package com.bytedance.sdk.openadsdk;

import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.k.g.b;
import com.bytedance.sdk.openadsdk.utils.u;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AdSlot {
    public static final int TYPE_BANNER = 1;
    public static final int TYPE_CACHED_SPLASH = 4;
    public static final int TYPE_DRAW_FEED = 9;
    public static final int TYPE_FEED = 5;
    public static final int TYPE_FULL_SCREEN_VIDEO = 8;
    public static final int TYPE_INTERACTION_AD = 2;
    public static final int TYPE_REWARD_VIDEO = 7;
    public static final int TYPE_SPLASH = 3;
    public static final int TYPE_STREAM = 6;

    /* renamed from: a  reason: collision with root package name */
    public String f26926a;

    /* renamed from: b  reason: collision with root package name */
    public int f26927b;

    /* renamed from: c  reason: collision with root package name */
    public int f26928c;

    /* renamed from: d  reason: collision with root package name */
    public float f26929d;

    /* renamed from: e  reason: collision with root package name */
    public float f26930e;

    /* renamed from: f  reason: collision with root package name */
    public int f26931f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26932g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f26933h;
    public String i;
    public int j;
    public String k;
    public String l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public int[] r;
    public String s;
    public int t;
    public String u;
    public String v;
    public String w;
    public String x;

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f26934a;
        public String i;
        public int l;
        public String m;
        public int n;
        public float o;
        public float p;
        public int[] r;
        public int s;
        public String t;
        public String u;
        public String v;
        public String w;

        /* renamed from: b  reason: collision with root package name */
        public int f26935b = 640;

        /* renamed from: c  reason: collision with root package name */
        public int f26936c = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;

        /* renamed from: d  reason: collision with root package name */
        public boolean f26937d = true;

        /* renamed from: e  reason: collision with root package name */
        public boolean f26938e = false;

        /* renamed from: f  reason: collision with root package name */
        public int f26939f = 1;

        /* renamed from: g  reason: collision with root package name */
        public String f26940g = "";

        /* renamed from: h  reason: collision with root package name */
        public int f26941h = 0;
        public String j = "defaultUser";
        public int k = 2;
        public boolean q = true;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.f26926a = this.f26934a;
            adSlot.f26931f = this.f26939f;
            adSlot.f26932g = this.f26937d;
            adSlot.f26933h = this.f26938e;
            adSlot.f26927b = this.f26935b;
            adSlot.f26928c = this.f26936c;
            float f2 = this.o;
            if (f2 <= 0.0f) {
                adSlot.f26929d = this.f26935b;
                adSlot.f26930e = this.f26936c;
            } else {
                adSlot.f26929d = f2;
                adSlot.f26930e = this.p;
            }
            adSlot.i = this.f26940g;
            adSlot.j = this.f26941h;
            adSlot.k = this.i;
            adSlot.l = this.j;
            adSlot.m = this.k;
            adSlot.o = this.l;
            adSlot.q = this.q;
            adSlot.r = this.r;
            adSlot.t = this.s;
            adSlot.u = this.t;
            adSlot.s = this.m;
            adSlot.w = this.v;
            adSlot.x = this.w;
            adSlot.n = this.n;
            adSlot.v = this.u;
            return adSlot;
        }

        public Builder setAdCount(int i) {
            if (i <= 0) {
                i = 1;
                u.c(TTAdConstant.TAG, "setAdCount: adCount must greater than 0 ");
            }
            if (i > 20) {
                u.c(TTAdConstant.TAG, "setAdCount: adCount must less than or equal to 20 ");
                i = 20;
            }
            this.f26939f = i;
            return this;
        }

        public Builder setAdId(String str) {
            this.v = str;
            return this;
        }

        public Builder setAdType(int i) {
            this.n = i;
            return this;
        }

        public Builder setAdloadSeq(int i) {
            this.s = i;
            return this;
        }

        public Builder setCodeId(String str) {
            this.f26934a = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.w = str;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f2, float f3) {
            this.o = f2;
            this.p = f3;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.r = iArr;
            return this;
        }

        public Builder setExtraParam(String str) {
            this.m = str;
            return this;
        }

        public Builder setImageAcceptedSize(int i, int i2) {
            this.f26935b = i;
            this.f26936c = i2;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.q = z;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.i = str;
            return this;
        }

        public Builder setNativeAdType(int i) {
            this.l = i;
            return this;
        }

        public Builder setOrientation(int i) {
            this.k = i;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.t = str;
            return this;
        }

        public Builder setRewardAmount(int i) {
            return this;
        }

        public Builder setRewardName(String str) {
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            return this;
        }

        public Builder setUserID(String str) {
            this.j = str;
            return this;
        }

        public Builder supportRenderControl() {
            this.f26938e = true;
            return this;
        }

        public Builder withBid(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            u.c("bidding", "AdSlot -> bidAdm=" + b.a(str));
            this.u = str;
            return this;
        }
    }

    public static int getPosition(int i) {
        if (i != 1) {
            if (i != 2) {
                return (i == 3 || i == 4 || i == 7 || i == 8) ? 5 : 3;
            }
            return 4;
        }
        return 2;
    }

    public int getAdCount() {
        return this.f26931f;
    }

    public String getAdId() {
        return this.w;
    }

    public int getAdType() {
        return this.n;
    }

    public int getAdloadSeq() {
        return this.t;
    }

    public String getBidAdm() {
        return this.v;
    }

    public String getCodeId() {
        return this.f26926a;
    }

    public String getCreativeId() {
        return this.x;
    }

    public int getDurationSlotType() {
        return this.p;
    }

    public float getExpressViewAcceptedHeight() {
        return this.f26930e;
    }

    public float getExpressViewAcceptedWidth() {
        return this.f26929d;
    }

    public int[] getExternalABVid() {
        return this.r;
    }

    public String getExtraSmartLookParam() {
        return this.s;
    }

    public int getImgAcceptedHeight() {
        return this.f26928c;
    }

    public int getImgAcceptedWidth() {
        return this.f26927b;
    }

    public String getMediaExtra() {
        return this.k;
    }

    public int getNativeAdType() {
        return this.o;
    }

    public int getOrientation() {
        return this.m;
    }

    public String getPrimeRit() {
        String str = this.u;
        return str == null ? "" : str;
    }

    public int getRewardAmount() {
        return this.j;
    }

    public String getRewardName() {
        return this.i;
    }

    public String getUserID() {
        return this.l;
    }

    public boolean isAutoPlay() {
        return this.q;
    }

    public boolean isSupportDeepLink() {
        return this.f26932g;
    }

    public boolean isSupportRenderConrol() {
        return this.f26933h;
    }

    public void setAdCount(int i) {
        this.f26931f = i;
    }

    public void setDurationSlotType(int i) {
        this.p = i;
    }

    public void setExternalABVid(int... iArr) {
        this.r = iArr;
    }

    public void setNativeAdType(int i) {
        this.o = i;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.f26926a);
            jSONObject.put("mIsAutoPlay", this.q);
            jSONObject.put("mImgAcceptedWidth", this.f26927b);
            jSONObject.put("mImgAcceptedHeight", this.f26928c);
            jSONObject.put("mExpressViewAcceptedWidth", this.f26929d);
            jSONObject.put("mExpressViewAcceptedHeight", this.f26930e);
            jSONObject.put("mAdCount", this.f26931f);
            jSONObject.put("mSupportDeepLink", this.f26932g);
            jSONObject.put("mSupportRenderControl", this.f26933h);
            jSONObject.put("mRewardName", this.i);
            jSONObject.put("mRewardAmount", this.j);
            jSONObject.put("mMediaExtra", this.k);
            jSONObject.put("mUserID", this.l);
            jSONObject.put("mOrientation", this.m);
            jSONObject.put("mNativeAdType", this.o);
            jSONObject.put("mAdloadSeq", this.t);
            jSONObject.put("mPrimeRit", this.u);
            jSONObject.put("mExtraSmartLookParam", this.s);
            jSONObject.put("mAdId", this.w);
            jSONObject.put("mCreativeId", this.x);
            jSONObject.put("mBidAdm", this.v);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.f26926a + "', mImgAcceptedWidth=" + this.f26927b + ", mImgAcceptedHeight=" + this.f26928c + ", mExpressViewAcceptedWidth=" + this.f26929d + ", mExpressViewAcceptedHeight=" + this.f26930e + ", mAdCount=" + this.f26931f + ", mSupportDeepLink=" + this.f26932g + ", mSupportRenderControl=" + this.f26933h + ", mRewardName='" + this.i + "', mRewardAmount=" + this.j + ", mMediaExtra='" + this.k + "', mUserID='" + this.l + "', mOrientation=" + this.m + ", mNativeAdType=" + this.o + ", mIsAutoPlay=" + this.q + ", mPrimeRit" + this.u + ", mAdloadSeq" + this.t + ", mAdId" + this.w + ", mCreativeId" + this.x + '}';
    }

    public AdSlot() {
        this.m = 2;
        this.q = true;
    }
}
