package com.baidu.tieba.yuyinala.liveroom.activeview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.live.data.o;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.widget.SlideRatioViewPager;
import com.baidu.tieba.yuyinala.liveroom.activeview.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public class AlaActiveBannerView extends LinearLayout implements c {
    private String hdN;
    private Set<Integer> hdO;
    private boolean isHost;
    private int mCurrentPosition;
    private SlideRatioViewPager.OnPageChangeListener mOnPageChangeListener;
    private AlaActiveBannerDot okA;
    private b.a okB;
    private AlaActiveBannerViewPager oky;
    private AlaActiveBannerViewPagerAdapter okz;
    private String otherParams;

    public AlaActiveBannerView(Context context) {
        super(context);
        this.mCurrentPosition = 0;
        this.hdN = "";
        this.isHost = false;
        this.hdO = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.wl(i);
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        };
        init(context);
    }

    public AlaActiveBannerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentPosition = 0;
        this.hdN = "";
        this.isHost = false;
        this.hdO = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.wl(i);
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        };
        init(context);
    }

    public AlaActiveBannerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentPosition = 0;
        this.hdN = "";
        this.isHost = false;
        this.hdO = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                AlaActiveBannerView.this.wl(i2);
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }
        };
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(a.g.yuyinala_active_banner, (ViewGroup) this, true);
        this.oky = (AlaActiveBannerViewPager) findViewById(a.f.active_view_pager);
        this.oky.setSlideRatioToLeft(0.8f);
        this.oky.setSlideRatioToRight(0.2f);
        this.okA = (AlaActiveBannerDot) findViewById(a.f.dot_container);
        this.okz = new AlaActiveBannerViewPagerAdapter();
        this.oky.setAdapter(this.okz);
        this.oky.addOnPageChangeListener(this.mOnPageChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wl(int i) {
        int count = this.oky.getAdapter().getCount();
        if (count > 3) {
            if (i == count - 1) {
                this.mCurrentPosition = 1;
                this.oky.setCurrentItem(this.mCurrentPosition, false);
            } else if (i == 0) {
                this.mCurrentPosition = count - 2;
                this.oky.setCurrentItem(this.mCurrentPosition, false);
            } else {
                this.mCurrentPosition = i;
                wm(this.mCurrentPosition);
            }
            this.okA.vq(this.mCurrentPosition - 1);
        }
        wn(i);
    }

    private void wm(int i) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "show");
        alaStaticItem.addParams("page", "liveroom");
        alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        alaStaticItem.addParams("ext", i);
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    private void wn(int i) {
        o wq;
        if (!this.isHost && (wq = this.okz.wq(i)) != null) {
            int i2 = wq.activityId;
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && !this.hdO.contains(Integer.valueOf(i2)) && !TextUtils.isEmpty(this.hdN)) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                alaStaticItem.addParams("feed_id", this.hdN);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, i2 + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                this.hdO.add(Integer.valueOf(i2));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setData(ArrayList<o> arrayList, String str) {
        boolean z = false;
        if (!TextUtils.equals(this.hdN, str)) {
            this.hdO = new HashSet();
            this.hdN = str;
        }
        List<o> originDatas = this.okz.getOriginDatas();
        if (originDatas != null && originDatas.size() == arrayList.size()) {
            int i = 0;
            while (true) {
                if (i >= originDatas.size()) {
                    z = true;
                    break;
                }
                o oVar = arrayList.get(i);
                o oVar2 = originDatas.get(i);
                if (oVar.activityId != oVar2.activityId || oVar.picType != oVar2.picType || !oVar.pic_url.equals(oVar2.pic_url) || !oVar.jump_url.equals(oVar2.jump_url)) {
                    break;
                }
                i++;
            }
        }
        this.okA.vr(ListUtils.getCount(arrayList));
        this.okz.setData(arrayList);
        this.okz.notifyDataSetChanged();
        this.oky.bZT();
    }

    public void wo(int i) {
        this.okz.No(i);
    }

    public void a(b.a aVar) {
        this.okB = aVar;
        this.okz.a(this.okB);
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.activeview.c
    public void onStart() {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.activeview.c
    public void onStop() {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.activeview.c
    public void release() {
        if (this.oky != null) {
            this.oky.release();
        }
        this.hdN = "";
        this.hdO.clear();
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
