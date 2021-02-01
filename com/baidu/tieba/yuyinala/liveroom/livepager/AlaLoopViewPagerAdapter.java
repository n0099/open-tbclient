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
/* loaded from: classes11.dex */
public class AlaLoopViewPagerAdapter extends PagerAdapter {
    private SimpleArrayMap<Integer, AlaLiveRoomBlurPageLayout> hFI = new SimpleArrayMap<>();
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
        if (this.hFI.get(Integer.valueOf(i)).getParent() != null) {
            ((ViewGroup) this.hFI.get(Integer.valueOf(i)).getParent()).removeView(this.hFI.get(Integer.valueOf(i)));
        }
        viewGroup.addView(this.hFI.get(Integer.valueOf(i)));
        return this.hFI.get(Integer.valueOf(i));
    }

    public void cgD() {
        if (this.hFI == null) {
            this.hFI = new SimpleArrayMap<>();
        }
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout.c(this.mTbPageContext);
        this.hFI.put(0, alaLiveRoomBlurPageLayout);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout2 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout2.c(this.mTbPageContext);
        this.hFI.put(1, alaLiveRoomBlurPageLayout2);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout3 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout3.c(this.mTbPageContext);
        this.hFI.put(2, alaLiveRoomBlurPageLayout3);
    }

    public AlaLiveRoomBlurPageLayout LY(int i) {
        return this.hFI.get(Integer.valueOf(i));
    }

    public AlaLiveRoomBlurPageLayout LZ(int i) {
        return this.hFI.get(Integer.valueOf(i));
    }

    private int vH(int i) {
        return ((getCount() + i) - 1) % getCount();
    }

    private int vI(int i) {
        return ((getCount() + i) + 1) % getCount();
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, ab abVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.hFI.get(Integer.valueOf(vH(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.cle();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.bg_cover, null);
        }
    }

    public void b(int i, AlaLiveInfoData alaLiveInfoData, ab abVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.hFI.get(Integer.valueOf(vI(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.cle();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.bg_cover, null);
        }
    }

    public void a(int i, ab abVar) {
        if (abVar != null) {
            AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.hFI.get(Integer.valueOf(i));
            if (abVar.aIU != null && !TextUtils.isEmpty(abVar.aIU.bg_cover)) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(abVar.aIU.bg_cover, null);
            } else if (abVar.aId != null) {
                alaLiveRoomBlurPageLayout.setDefaultBg();
            }
        }
    }

    public void onDestroy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hFI.size()) {
                this.hFI.get(Integer.valueOf(i2)).release();
                i = i2 + 1;
            } else {
                this.hFI.clear();
                return;
            }
        }
    }
}
