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
    private String gUT;
    private Set<Integer> gUU;
    private boolean isHost;
    private int mCurrentPosition;
    private SlideRatioViewPager.OnPageChangeListener mOnPageChangeListener;
    private AlaActiveBannerViewPager nTX;
    private AlaActiveBannerViewPagerAdapter nTY;
    private AlaActiveBannerDot nTZ;
    private b.a nUa;
    private String otherParams;

    public AlaActiveBannerView(Context context) {
        super(context);
        this.mCurrentPosition = 0;
        this.gUT = "";
        this.isHost = false;
        this.gUU = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.vi(i);
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
        this.gUT = "";
        this.isHost = false;
        this.gUU = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                AlaActiveBannerView.this.vi(i);
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
        this.gUT = "";
        this.isHost = false;
        this.gUU = new HashSet();
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveBannerView.1
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                AlaActiveBannerView.this.vi(i2);
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
        this.nTX = (AlaActiveBannerViewPager) findViewById(a.f.active_view_pager);
        this.nTX.setSlideRatioToLeft(0.8f);
        this.nTX.setSlideRatioToRight(0.2f);
        this.nTZ = (AlaActiveBannerDot) findViewById(a.f.dot_container);
        this.nTY = new AlaActiveBannerViewPagerAdapter();
        this.nTX.setAdapter(this.nTY);
        this.nTX.addOnPageChangeListener(this.mOnPageChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vi(int i) {
        int count = this.nTX.getAdapter().getCount();
        if (count > 3) {
            if (i == count - 1) {
                this.mCurrentPosition = 1;
                this.nTX.setCurrentItem(this.mCurrentPosition, false);
            } else if (i == 0) {
                this.mCurrentPosition = count - 2;
                this.nTX.setCurrentItem(this.mCurrentPosition, false);
            } else {
                this.mCurrentPosition = i;
                vj(this.mCurrentPosition);
            }
            this.nTZ.vg(this.mCurrentPosition - 1);
        }
        vk(i);
    }

    private void vj(int i) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
        alaStaticItem.addParams("from", "liveshow");
        alaStaticItem.addParams("type", "show");
        alaStaticItem.addParams("page", "liveroom");
        alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        alaStaticItem.addParams("ext", i);
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    private void vk(int i) {
        o vn;
        if (!this.isHost && (vn = this.nTY.vn(i)) != null) {
            int i2 = vn.activityId;
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && !this.gUU.contains(Integer.valueOf(i2)) && !TextUtils.isEmpty(this.gUT)) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                alaStaticItem.addParams("feed_id", this.gUT);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, i2 + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                this.gUU.add(Integer.valueOf(i2));
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
        if (!TextUtils.equals(this.gUT, str)) {
            this.gUU = new HashSet();
            this.gUT = str;
        }
        List<o> originDatas = this.nTY.getOriginDatas();
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
        this.nTZ.vh(ListUtils.getCount(arrayList));
        this.nTY.setData(arrayList);
        this.nTY.notifyDataSetChanged();
        this.nTX.bWQ();
    }

    public void vl(int i) {
        this.nTY.LT(i);
    }

    public void a(b.a aVar) {
        this.nUa = aVar;
        this.nTY.a(this.nUa);
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
        if (this.nTX != null) {
            this.nTX.release();
        }
        this.gUT = "";
        this.gUU.clear();
    }

    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
