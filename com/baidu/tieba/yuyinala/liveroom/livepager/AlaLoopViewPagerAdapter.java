package com.baidu.tieba.yuyinala.liveroom.livepager;

import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLiveRoomBlurPageLayout;
/* loaded from: classes4.dex */
public class AlaLoopViewPagerAdapter extends PagerAdapter {
    private SimpleArrayMap<Integer, AlaLiveRoomBlurPageLayout> hlc = new SimpleArrayMap<>();
    private TbPageContext mTbPageContext;

    public AlaLoopViewPagerAdapter(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return 3;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.hlc.get(Integer.valueOf(i)).getParent() != null) {
            ((ViewGroup) this.hlc.get(Integer.valueOf(i)).getParent()).removeView(this.hlc.get(Integer.valueOf(i)));
        }
        viewGroup.addView(this.hlc.get(Integer.valueOf(i)));
        return this.hlc.get(Integer.valueOf(i));
    }

    public void cdB() {
        if (this.hlc == null) {
            this.hlc = new SimpleArrayMap<>();
        }
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout.c(this.mTbPageContext);
        this.hlc.put(0, alaLiveRoomBlurPageLayout);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout2 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout2.c(this.mTbPageContext);
        this.hlc.put(1, alaLiveRoomBlurPageLayout2);
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout3 = new AlaLiveRoomBlurPageLayout(this.mTbPageContext.getPageActivity());
        alaLiveRoomBlurPageLayout3.c(this.mTbPageContext);
        this.hlc.put(2, alaLiveRoomBlurPageLayout3);
    }

    public AlaLiveRoomBlurPageLayout Mc(int i) {
        return this.hlc.get(Integer.valueOf(i));
    }

    public AlaLiveRoomBlurPageLayout Md(int i) {
        return this.hlc.get(Integer.valueOf(i));
    }

    private int vO(int i) {
        return ((getCount() + i) - 1) % getCount();
    }

    private int vP(int i) {
        return ((getCount() + i) + 1) % getCount();
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, w wVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.hlc.get(Integer.valueOf(vO(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.chS();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.bg_cover, null);
        }
    }

    public void b(int i, AlaLiveInfoData alaLiveInfoData, w wVar) {
        AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.hlc.get(Integer.valueOf(vP(i)));
        if (alaLiveInfoData != null) {
            alaLiveRoomBlurPageLayout.chS();
            alaLiveRoomBlurPageLayout.setBgImageUrl(alaLiveInfoData.bg_cover, null);
        }
    }

    public void a(int i, w wVar) {
        if (wVar != null) {
            AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout = this.hlc.get(Integer.valueOf(i));
            if (wVar.aJK != null && !TextUtils.isEmpty(wVar.aJK.bg_cover)) {
                alaLiveRoomBlurPageLayout.setBgImageUrl(wVar.aJK.bg_cover, null);
            } else if (wVar.aIV != null) {
                alaLiveRoomBlurPageLayout.setDefaultBg();
            }
        }
    }

    public void onDestroy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.hlc.size()) {
                this.hlc.get(Integer.valueOf(i2)).release();
                i = i2 + 1;
            } else {
                this.hlc.clear();
                return;
            }
        }
    }
}
