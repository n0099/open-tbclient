package com.baidu.tieba.yuyinala.liveroom.activeview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.live.data.p;
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
/* loaded from: classes10.dex */
public class AlaActiveBannerView extends LinearLayout implements c {
    private String hkV;
    private Set<Integer> hkW;
    private boolean isHost;
    private int mCurrentPosition;
    private SlideRatioViewPager.OnPageChangeListener mOnPageChangeListener;
    private AlaActiveBannerViewPager ohI;
    private AlaActiveBannerViewPagerAdapter ohJ;
    private AlaActiveBannerDot ohK;
    private b.a ohL;
    private String otherParams;

    public AlaActiveBannerView(Context context) {
        super(context);
        this.mCurrentPosition = 0;
        this.hkV = "";
        this.isHost = false;
        this.hkW = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.uQ(i);
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
        this.hkV = "";
        this.isHost = false;
        this.hkW = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.uQ(i);
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
        this.hkV = "";
        this.isHost = false;
        this.hkW = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                AlaActiveBannerView.this.uQ(i2);
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
        this.ohI = (AlaActiveBannerViewPager) findViewById(a.f.active_view_pager);
        this.ohI.setSlideRatioToLeft(0.8f);
        this.ohI.setSlideRatioToRight(0.2f);
        this.ohK = (AlaActiveBannerDot) findViewById(a.f.dot_container);
        this.ohJ = new AlaActiveBannerViewPagerAdapter();
        this.ohI.setAdapter(this.ohJ);
        this.ohI.addOnPageChangeListener(this.mOnPageChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uQ(int i) {
        int count = this.ohI.getAdapter().getCount();
        if (count > 3) {
            if (i == count - 1) {
                this.mCurrentPosition = 1;
                this.ohI.setCurrentItem(this.mCurrentPosition, false);
            } else if (i == 0) {
                this.mCurrentPosition = count - 2;
                this.ohI.setCurrentItem(this.mCurrentPosition, false);
            } else {
                this.mCurrentPosition = i;
                uR(this.mCurrentPosition);
            }
            this.ohK.tV(this.mCurrentPosition - 1);
        }
        uS(i);
    }

    private void uR(int i) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "show");
        alaStaticItem.addParams("page", "liveroom");
        alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        alaStaticItem.addParams("ext", i);
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    private void uS(int i) {
        p uV;
        if (!this.isHost && (uV = this.ohJ.uV(i)) != null) {
            int i2 = uV.activityId;
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && !this.hkW.contains(Integer.valueOf(i2)) && !TextUtils.isEmpty(this.hkV)) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                alaStaticItem.addParams("feed_id", this.hkV);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, i2 + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                this.hkW.add(Integer.valueOf(i2));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setData(ArrayList<p> arrayList, String str) {
        boolean z = false;
        if (!TextUtils.equals(this.hkV, str)) {
            this.hkW = new HashSet();
            this.hkV = str;
        }
        List<p> originDatas = this.ohJ.getOriginDatas();
        if (originDatas != null && originDatas.size() == arrayList.size()) {
            int i = 0;
            while (true) {
                if (i >= originDatas.size()) {
                    z = true;
                    break;
                }
                p pVar = arrayList.get(i);
                p pVar2 = originDatas.get(i);
                if (pVar.activityId != pVar2.activityId || pVar.picType != pVar2.picType || !pVar.pic_url.equals(pVar2.pic_url) || !pVar.jump_url.equals(pVar2.jump_url)) {
                    break;
                }
                i++;
            }
        }
        this.ohK.tW(ListUtils.getCount(arrayList));
        this.ohJ.setData(arrayList);
        this.ohJ.notifyDataSetChanged();
        this.ohI.bYK();
    }

    public void uT(int i) {
        this.ohJ.Ls(i);
    }

    public void a(b.a aVar) {
        this.ohL = aVar;
        this.ohJ.a(this.ohL);
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
        if (this.ohI != null) {
            this.ohI.release();
        }
        this.hkV = "";
        this.hkW.clear();
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
