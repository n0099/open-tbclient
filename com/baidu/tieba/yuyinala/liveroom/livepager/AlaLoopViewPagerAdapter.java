package com.baidu.tieba.yuyinala.liveroom.livepager;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SimpleArrayMap;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout;
/* loaded from: classes10.dex */
public class AlaLoopViewPagerAdapter extends PagerAdapter {
    private SimpleArrayMap<Integer, AlaLiveRoomBlurPageLayout> hBy = new SimpleArrayMap<>();
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
        if (this.hBy.get(Integer.valueOf(i)).getParent() != null) {
            ((ViewGroup) this.hBy.get(Integer.valueOf(i)).getParent()).removeView(this.hBy.get(Integer.valueOf(i)));
        }
        viewGroup.addView(this.hBy.get(Integer.valueOf(i)));
        return this.hBy.get(Integer.valueOf(i));
    }

    public void cfK() {
        if (this.hBy == null) {
            this.hBy = new SimpleArrayMap<>();
        }
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout.c(this.mTbPageContext);
        this.hBy.put(0, alaLiveRoomBlurPageLayout);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout2 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout2.c(this.mTbPageContext);
        this.hBy.put(1, alaLiveRoomBlurPageLayout2);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout3 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout3.c(this.mTbPageContext);
        this.hBy.put(2, alaLiveRoomBlurPageLayout3);
    }

    public AlaLiveRoomBlurPageLayout LD(int i) {
        return this.hBy.get(Integer.valueOf(i));
    }

    public AlaLiveRoomBlurPageLayout LE(int i) {
        return this.hBy.get(Integer.valueOf(i));
    }

    private int vw(int i) {
        return ((getCount() + i) - 1) % getCount();
    }

    private int vx(int i) {
        return ((getCount() + i) + 1) % getCount();
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, x xVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.hBy.get(Integer.valueOf(vw(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.ckg();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.bg_cover, null);
        }
    }

    public void b(int i, AlaLiveInfoData alaLiveInfoData, x xVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.hBy.get(Integer.valueOf(vx(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.ckg();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.bg_cover, null);
        }
    }

    public void a(int i, x xVar) {
        if (xVar != null) {
            AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.hBy.get(Integer.valueOf(i));
            if (xVar.aGy != null && !TextUtils.isEmpty(xVar.aGy.bg_cover)) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(xVar.aGy.bg_cover, null);
            } else if (xVar.aFH != null) {
                alaLiveRoomBlurPageLayout.setDefaultBg();
            }
        }
    }

    public void onDestroy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hBy.size()) {
                this.hBy.get(Integer.valueOf(i2)).release();
                i = i2 + 1;
            } else {
                this.hBy.clear();
                return;
            }
        }
    }
}
