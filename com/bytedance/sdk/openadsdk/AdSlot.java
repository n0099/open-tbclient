package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.utils.u;
import com.yy.videoplayer.decoder.VideoConstant;
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
    private String f4061a;
    private int b;
    private int c;
    private float d;
    private float e;
    private int f;
    private boolean g;
    private boolean h;
    private String i;
    private int j;
    private String k;
    private String l;
    private int m;
    private int n;
    private boolean o;
    private int[] p;
    private String q;
    private int r;
    private String s;
    private String t;
    private String u;

    private AdSlot() {
        this.m = 2;
        this.o = true;
    }

    public String getAdId() {
        return this.t;
    }

    public String getCreativeId() {
        return this.u;
    }

    public String getCodeId() {
        return this.f4061a;
    }

    public static int getPosition(int i) {
        switch (i) {
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
            case 4:
            case 7:
            case 8:
                return 5;
            case 5:
            case 6:
            case 9:
            default:
                return 3;
        }
    }

    public boolean isAutoPlay() {
        return this.o;
    }

    public int getImgAcceptedWidth() {
        return this.b;
    }

    public int getImgAcceptedHeight() {
        return this.c;
    }

    public float getExpressViewAcceptedWidth() {
        return this.d;
    }

    public float getExpressViewAcceptedHeight() {
        return this.e;
    }

    public boolean isSupportDeepLink() {
        return this.g;
    }

    public boolean isSupportRenderConrol() {
        return this.h;
    }

    public int getAdCount() {
        return this.f;
    }

    public void setAdCount(int i) {
        this.f = i;
    }

    public String getRewardName() {
        return this.i;
    }

    public int getRewardAmount() {
        return this.j;
    }

    public String getMediaExtra() {
        return this.k;
    }

    public String getUserID() {
        return this.l;
    }

    public int getOrientation() {
        return this.m;
    }

    public int getNativeAdType() {
        return this.n;
    }

    public void setNativeAdType(int i) {
        this.n = i;
    }

    public int[] getExternalABVid() {
        return this.p;
    }

    public void setExternalABVid(int... iArr) {
        this.p = iArr;
    }

    public int getAdloadSeq() {
        return this.r;
    }

    public String getPrimeRit() {
        return this.s == null ? "" : this.s;
    }

    public String getExtraSmartLookParam() {
        return this.q;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.f4061a + "', mImgAcceptedWidth=" + this.b + ", mImgAcceptedHeight=" + this.c + ", mExpressViewAcceptedWidth=" + this.d + ", mExpressViewAcceptedHeight=" + this.e + ", mAdCount=" + this.f + ", mSupportDeepLink=" + this.g + ", mSupportRenderControl=" + this.h + ", mRewardName='" + this.i + "', mRewardAmount=" + this.j + ", mMediaExtra='" + this.k + "', mUserID='" + this.l + "', mOrientation=" + this.m + ", mNativeAdType=" + this.n + ", mIsAutoPlay=" + this.o + ", mPrimeRit" + this.s + ", mAdloadSeq" + this.r + ", mAdId" + this.t + ", mCreativeId" + this.u + '}';
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.f4061a);
            jSONObject.put("mIsAutoPlay", this.o);
            jSONObject.put("mImgAcceptedWidth", this.b);
            jSONObject.put("mImgAcceptedHeight", this.c);
            jSONObject.put("mExpressViewAcceptedWidth", this.d);
            jSONObject.put("mExpressViewAcceptedHeight", this.e);
            jSONObject.put("mAdCount", this.f);
            jSONObject.put("mSupportDeepLink", this.g);
            jSONObject.put("mSupportRenderControl", this.h);
            jSONObject.put("mRewardName", this.i);
            jSONObject.put("mRewardAmount", this.j);
            jSONObject.put("mMediaExtra", this.k);
            jSONObject.put("mUserID", this.l);
            jSONObject.put("mOrientation", this.m);
            jSONObject.put("mNativeAdType", this.n);
            jSONObject.put("mAdloadSeq", this.r);
            jSONObject.put("mPrimeRit", this.s);
            jSONObject.put("mExtraSmartLookParam", this.q);
            jSONObject.put("mAdId", this.t);
            jSONObject.put("mCreativeId", this.u);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f4062a;
        private String i;
        private int l;
        private String m;
        private float n;
        private float o;
        private int[] q;
        private int r;
        private String s;
        private String t;
        private String u;
        private int b = 640;
        private int c = VideoConstant.THUMBNAIL_WIDTH;
        private boolean d = true;
        private boolean e = false;
        private int f = 1;
        private String g = "";
        private int h = 0;
        private String j = "defaultUser";
        private int k = 2;
        private boolean p = true;

        public Builder setExtraParam(String str) {
            this.m = str;
            return this;
        }

        public Builder setAdId(String str) {
            this.t = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.u = str;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.p = z;
            return this;
        }

        public Builder setCodeId(String str) {
            this.f4062a = str;
            return this;
        }

        public Builder setImageAcceptedSize(int i, int i2) {
            this.b = i;
            this.c = i2;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f, float f2) {
            this.n = f;
            this.o = f2;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            return this;
        }

        public Builder supportRenderControl() {
            this.e = true;
            return this;
        }

        public Builder setAdCount(int i) {
            int i2;
            int i3 = 20;
            if (i <= 0) {
                i2 = 1;
                u.c(TTAdConstant.TAG, "setAdCount: adCount must greater than 0 ");
            } else {
                i2 = i;
            }
            if (i2 > 20) {
                u.c(TTAdConstant.TAG, "setAdCount: adCount must less than or equal to 20 ");
            } else {
                i3 = i2;
            }
            this.f = i3;
            return this;
        }

        public Builder setRewardName(String str) {
            return this;
        }

        public Builder setRewardAmount(int i) {
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.i = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.j = str;
            return this;
        }

        public Builder setOrientation(int i) {
            this.k = i;
            return this;
        }

        public Builder setNativeAdType(int i) {
            this.l = i;
            return this;
        }

        public Builder setAdloadSeq(int i) {
            this.r = i;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.s = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.q = iArr;
            return this;
        }

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.f4061a = this.f4062a;
            adSlot.f = this.f;
            adSlot.g = this.d;
            adSlot.h = this.e;
            adSlot.b = this.b;
            adSlot.c = this.c;
            if (this.n <= 0.0f) {
                adSlot.d = this.b;
                adSlot.e = this.c;
            } else {
                adSlot.d = this.n;
                adSlot.e = this.o;
            }
            adSlot.i = this.g;
            adSlot.j = this.h;
            adSlot.k = this.i;
            adSlot.l = this.j;
            adSlot.m = this.k;
            adSlot.n = this.l;
            adSlot.o = this.p;
            adSlot.p = this.q;
            adSlot.r = this.r;
            adSlot.s = this.s;
            adSlot.q = this.m;
            adSlot.t = this.t;
            adSlot.u = this.u;
            return adSlot;
        }
    }
}
