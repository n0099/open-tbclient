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
    public String f27240a;

    /* renamed from: b  reason: collision with root package name */
    public int f27241b;

    /* renamed from: c  reason: collision with root package name */
    public int f27242c;

    /* renamed from: d  reason: collision with root package name */
    public float f27243d;

    /* renamed from: e  reason: collision with root package name */
    public float f27244e;

    /* renamed from: f  reason: collision with root package name */
    public int f27245f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27246g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27247h;
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
        public String f27248a;
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
        public int f27249b = 640;

        /* renamed from: c  reason: collision with root package name */
        public int f27250c = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;

        /* renamed from: d  reason: collision with root package name */
        public boolean f27251d = true;

        /* renamed from: e  reason: collision with root package name */
        public boolean f27252e = false;

        /* renamed from: f  reason: collision with root package name */
        public int f27253f = 1;

        /* renamed from: g  reason: collision with root package name */
        public String f27254g = "";

        /* renamed from: h  reason: collision with root package name */
        public int f27255h = 0;
        public String j = "defaultUser";
        public int k = 2;
        public boolean q = true;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.f27240a = this.f27248a;
            adSlot.f27245f = this.f27253f;
            adSlot.f27246g = this.f27251d;
            adSlot.f27247h = this.f27252e;
            adSlot.f27241b = this.f27249b;
            adSlot.f27242c = this.f27250c;
            float f2 = this.o;
            if (f2 <= 0.0f) {
                adSlot.f27243d = this.f27249b;
                adSlot.f27244e = this.f27250c;
            } else {
                adSlot.f27243d = f2;
                adSlot.f27244e = this.p;
            }
            adSlot.i = this.f27254g;
            adSlot.j = this.f27255h;
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
            this.f27253f = i;
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
            this.f27248a = str;
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
            this.f27249b = i;
            this.f27250c = i2;
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
            this.f27252e = true;
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
        return this.f27245f;
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
        return this.f27240a;
    }

    public String getCreativeId() {
        return this.x;
    }

    public int getDurationSlotType() {
        return this.p;
    }

    public float getExpressViewAcceptedHeight() {
        return this.f27244e;
    }

    public float getExpressViewAcceptedWidth() {
        return this.f27243d;
    }

    public int[] getExternalABVid() {
        return this.r;
    }

    public String getExtraSmartLookParam() {
        return this.s;
    }

    public int getImgAcceptedHeight() {
        return this.f27242c;
    }

    public int getImgAcceptedWidth() {
        return this.f27241b;
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
        return this.f27246g;
    }

    public boolean isSupportRenderConrol() {
        return this.f27247h;
    }

    public void setAdCount(int i) {
        this.f27245f = i;
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
            jSONObject.put("mCodeId", this.f27240a);
            jSONObject.put("mIsAutoPlay", this.q);
            jSONObject.put("mImgAcceptedWidth", this.f27241b);
            jSONObject.put("mImgAcceptedHeight", this.f27242c);
            jSONObject.put("mExpressViewAcceptedWidth", this.f27243d);
            jSONObject.put("mExpressViewAcceptedHeight", this.f27244e);
            jSONObject.put("mAdCount", this.f27245f);
            jSONObject.put("mSupportDeepLink", this.f27246g);
            jSONObject.put("mSupportRenderControl", this.f27247h);
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
        return "AdSlot{mCodeId='" + this.f27240a + "', mImgAcceptedWidth=" + this.f27241b + ", mImgAcceptedHeight=" + this.f27242c + ", mExpressViewAcceptedWidth=" + this.f27243d + ", mExpressViewAcceptedHeight=" + this.f27244e + ", mAdCount=" + this.f27245f + ", mSupportDeepLink=" + this.f27246g + ", mSupportRenderControl=" + this.f27247h + ", mRewardName='" + this.i + "', mRewardAmount=" + this.j + ", mMediaExtra='" + this.k + "', mUserID='" + this.l + "', mOrientation=" + this.m + ", mNativeAdType=" + this.o + ", mIsAutoPlay=" + this.q + ", mPrimeRit" + this.u + ", mAdloadSeq" + this.t + ", mAdId" + this.w + ", mCreativeId" + this.x + '}';
    }

    public AdSlot() {
        this.m = 2;
        this.q = true;
    }
}
