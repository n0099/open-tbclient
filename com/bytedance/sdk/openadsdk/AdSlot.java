package com.bytedance.sdk.openadsdk;

import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.k.g.b;
import com.bytedance.sdk.openadsdk.utils.u;
import org.json.JSONObject;
/* loaded from: classes6.dex */
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
    public String f27109a;

    /* renamed from: b  reason: collision with root package name */
    public int f27110b;

    /* renamed from: c  reason: collision with root package name */
    public int f27111c;

    /* renamed from: d  reason: collision with root package name */
    public float f27112d;

    /* renamed from: e  reason: collision with root package name */
    public float f27113e;

    /* renamed from: f  reason: collision with root package name */
    public int f27114f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27115g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27116h;

    /* renamed from: i  reason: collision with root package name */
    public String f27117i;
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

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f27118a;

        /* renamed from: i  reason: collision with root package name */
        public String f27126i;
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
        public int f27119b = 640;

        /* renamed from: c  reason: collision with root package name */
        public int f27120c = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;

        /* renamed from: d  reason: collision with root package name */
        public boolean f27121d = true;

        /* renamed from: e  reason: collision with root package name */
        public boolean f27122e = false;

        /* renamed from: f  reason: collision with root package name */
        public int f27123f = 1;

        /* renamed from: g  reason: collision with root package name */
        public String f27124g = "";

        /* renamed from: h  reason: collision with root package name */
        public int f27125h = 0;
        public String j = "defaultUser";
        public int k = 2;
        public boolean q = true;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.f27109a = this.f27118a;
            adSlot.f27114f = this.f27123f;
            adSlot.f27115g = this.f27121d;
            adSlot.f27116h = this.f27122e;
            adSlot.f27110b = this.f27119b;
            adSlot.f27111c = this.f27120c;
            float f2 = this.o;
            if (f2 <= 0.0f) {
                adSlot.f27112d = this.f27119b;
                adSlot.f27113e = this.f27120c;
            } else {
                adSlot.f27112d = f2;
                adSlot.f27113e = this.p;
            }
            adSlot.f27117i = this.f27124g;
            adSlot.j = this.f27125h;
            adSlot.k = this.f27126i;
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

        public Builder setAdCount(int i2) {
            if (i2 <= 0) {
                i2 = 1;
                u.c(TTAdConstant.TAG, "setAdCount: adCount must greater than 0 ");
            }
            if (i2 > 20) {
                u.c(TTAdConstant.TAG, "setAdCount: adCount must less than or equal to 20 ");
                i2 = 20;
            }
            this.f27123f = i2;
            return this;
        }

        public Builder setAdId(String str) {
            this.v = str;
            return this;
        }

        public Builder setAdType(int i2) {
            this.n = i2;
            return this;
        }

        public Builder setAdloadSeq(int i2) {
            this.s = i2;
            return this;
        }

        public Builder setCodeId(String str) {
            this.f27118a = str;
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

        public Builder setImageAcceptedSize(int i2, int i3) {
            this.f27119b = i2;
            this.f27120c = i3;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.q = z;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.f27126i = str;
            return this;
        }

        public Builder setNativeAdType(int i2) {
            this.l = i2;
            return this;
        }

        public Builder setOrientation(int i2) {
            this.k = i2;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.t = str;
            return this;
        }

        public Builder setRewardAmount(int i2) {
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
            this.f27122e = true;
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

    public static int getPosition(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                return (i2 == 3 || i2 == 4 || i2 == 7 || i2 == 8) ? 5 : 3;
            }
            return 4;
        }
        return 2;
    }

    public int getAdCount() {
        return this.f27114f;
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
        return this.f27109a;
    }

    public String getCreativeId() {
        return this.x;
    }

    public int getDurationSlotType() {
        return this.p;
    }

    public float getExpressViewAcceptedHeight() {
        return this.f27113e;
    }

    public float getExpressViewAcceptedWidth() {
        return this.f27112d;
    }

    public int[] getExternalABVid() {
        return this.r;
    }

    public String getExtraSmartLookParam() {
        return this.s;
    }

    public int getImgAcceptedHeight() {
        return this.f27111c;
    }

    public int getImgAcceptedWidth() {
        return this.f27110b;
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
        return this.f27117i;
    }

    public String getUserID() {
        return this.l;
    }

    public boolean isAutoPlay() {
        return this.q;
    }

    public boolean isSupportDeepLink() {
        return this.f27115g;
    }

    public boolean isSupportRenderConrol() {
        return this.f27116h;
    }

    public void setAdCount(int i2) {
        this.f27114f = i2;
    }

    public void setDurationSlotType(int i2) {
        this.p = i2;
    }

    public void setExternalABVid(int... iArr) {
        this.r = iArr;
    }

    public void setNativeAdType(int i2) {
        this.o = i2;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.f27109a);
            jSONObject.put("mIsAutoPlay", this.q);
            jSONObject.put("mImgAcceptedWidth", this.f27110b);
            jSONObject.put("mImgAcceptedHeight", this.f27111c);
            jSONObject.put("mExpressViewAcceptedWidth", this.f27112d);
            jSONObject.put("mExpressViewAcceptedHeight", this.f27113e);
            jSONObject.put("mAdCount", this.f27114f);
            jSONObject.put("mSupportDeepLink", this.f27115g);
            jSONObject.put("mSupportRenderControl", this.f27116h);
            jSONObject.put("mRewardName", this.f27117i);
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
        return "AdSlot{mCodeId='" + this.f27109a + "', mImgAcceptedWidth=" + this.f27110b + ", mImgAcceptedHeight=" + this.f27111c + ", mExpressViewAcceptedWidth=" + this.f27112d + ", mExpressViewAcceptedHeight=" + this.f27113e + ", mAdCount=" + this.f27114f + ", mSupportDeepLink=" + this.f27115g + ", mSupportRenderControl=" + this.f27116h + ", mRewardName='" + this.f27117i + "', mRewardAmount=" + this.j + ", mMediaExtra='" + this.k + "', mUserID='" + this.l + "', mOrientation=" + this.m + ", mNativeAdType=" + this.o + ", mIsAutoPlay=" + this.q + ", mPrimeRit" + this.u + ", mAdloadSeq" + this.t + ", mAdId" + this.w + ", mCreativeId" + this.x + '}';
    }

    public AdSlot() {
        this.m = 2;
        this.q = true;
    }
}
