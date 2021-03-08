package com.baidu.tieba.yuyinala.liveroom.livepager;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SimpleArrayMap;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout;
/* loaded from: classes10.dex */
public class AlaLoopViewPagerAdapter extends PagerAdapter {
    private SimpleArrayMap<Integer, AlaLiveRoomBlurPageLayout> hHF = new SimpleArrayMap<>();
    private TbPageContext mTbPageContext;

    public AlaLoopViewPagerAdapter(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 3;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hHF.get(Integer.valueOf(i)).getParent() != null) {
            ((ViewGroup) this.hHF.get(Integer.valueOf(i)).getParent()).removeView(this.hHF.get(Integer.valueOf(i)));
        }
        viewGroup.addView(this.hHF.get(Integer.valueOf(i)));
        return this.hHF.get(Integer.valueOf(i));
    }

    public void cgQ() {
        if (this.hHF == null) {
            this.hHF = new SimpleArrayMap<>();
        }
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout.c(this.mTbPageContext);
        this.hHF.put(0, alaLiveRoomBlurPageLayout);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout2 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout2.c(this.mTbPageContext);
        this.hHF.put(1, alaLiveRoomBlurPageLayout2);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout3 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout3.c(this.mTbPageContext);
        this.hHF.put(2, alaLiveRoomBlurPageLayout3);
    }

    public AlaLiveRoomBlurPageLayout Md(int i) {
        return this.hHF.get(Integer.valueOf(i));
    }

    public AlaLiveRoomBlurPageLayout Me(int i) {
        return this.hHF.get(Integer.valueOf(i));
    }

    private int vJ(int i) {
        return ((getCount() + i) - 1) % getCount();
    }

    private int vK(int i) {
        return ((getCount() + i) + 1) % getCount();
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, ab abVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.hHF.get(Integer.valueOf(vJ(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.clr();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.bg_cover, null);
        }
    }

    public void b(int i, AlaLiveInfoData alaLiveInfoData, ab abVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.hHF.get(Integer.valueOf(vK(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.clr();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.bg_cover, null);
        }
    }

    public void a(int i, ab abVar) {
        if (abVar != null) {
            AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.hHF.get(Integer.valueOf(i));
            if (abVar.aKu != null && !TextUtils.isEmpty(abVar.aKu.bg_cover)) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(abVar.aKu.bg_cover, null);
            } else if (abVar.aJD != null) {
                alaLiveRoomBlurPageLayout.setDefaultBg();
            }
        }
    }

    public void onDestroy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hHF.size()) {
                this.hHF.get(Integer.valueOf(i2)).release();
                i = i2 + 1;
            } else {
                this.hHF.clear();
                return;
            }
        }
    }
}
