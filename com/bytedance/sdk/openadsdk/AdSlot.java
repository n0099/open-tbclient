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

    /* renamed from: a  reason: collision with root package name */
    private String f6067a;

    /* renamed from: b  reason: collision with root package name */
    private int f6068b;
    private int c;
    private float d;
    private float e;
    private int f;
    private boolean g;
    private String h;
    private int i;
    private String j;
    private String k;
    private int l;
    private int m;
    private boolean n;
    private int[] o;
    private int p;
    private String q;

    private AdSlot() {
        this.n = true;
    }

    public String getCodeId() {
        return this.f6067a;
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
        return this.n;
    }

    public int getImgAcceptedWidth() {
        return this.f6068b;
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

    public int getAdCount() {
        return this.f;
    }

    public void setAdCount(int i) {
        this.f = i;
    }

    public String getRewardName() {
        return this.h;
    }

    public int getRewardAmount() {
        return this.i;
    }

    public String getMediaExtra() {
        return this.j;
    }

    public String getUserID() {
        return this.k;
    }

    public int getOrientation() {
        return this.l;
    }

    public int getNativeAdType() {
        return this.m;
    }

    public void setNativeAdType(int i) {
        this.m = i;
    }

    public int[] getExternalABVid() {
        return this.o;
    }

    public void setExternalABVid(int... iArr) {
        this.o = iArr;
    }

    public int getAdloadSeq() {
        return this.p;
    }

    public String getPrimeRit() {
        return this.q == null ? "" : this.q;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.f6067a + "', mImgAcceptedWidth=" + this.f6068b + ", mImgAcceptedHeight=" + this.c + ", mExpressViewAcceptedWidth=" + this.d + ", mExpressViewAcceptedHeight=" + this.e + ", mAdCount=" + this.f + ", mSupportDeepLink=" + this.g + ", mRewardName='" + this.h + "', mRewardAmount=" + this.i + ", mMediaExtra='" + this.j + "', mUserID='" + this.k + "', mOrientation=" + this.l + ", mNativeAdType=" + this.m + ", mIsAutoPlay=" + this.n + ", mPrimeRit" + this.q + ", mAdloadSeq" + this.p + '}';
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.f6067a);
            jSONObject.put("mIsAutoPlay", this.n);
            jSONObject.put("mImgAcceptedWidth", this.f6068b);
            jSONObject.put("mImgAcceptedHeight", this.c);
            jSONObject.put("mExpressViewAcceptedWidth", this.d);
            jSONObject.put("mExpressViewAcceptedHeight", this.e);
            jSONObject.put("mAdCount", this.f);
            jSONObject.put("mSupportDeepLink", this.g);
            jSONObject.put("mRewardName", this.h);
            jSONObject.put("mRewardAmount", this.i);
            jSONObject.put("mMediaExtra", this.j);
            jSONObject.put("mUserID", this.k);
            jSONObject.put("mOrientation", this.l);
            jSONObject.put("mNativeAdType", this.m);
            jSONObject.put("mAdloadSeq", this.p);
            jSONObject.put("mPrimeRit", this.q);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f6069a;
        private boolean d;
        private String f;
        private int g;
        private String h;
        private String i;
        private int j;
        private int k;
        private float l;
        private float m;
        private int[] o;
        private int p;
        private String q;

        /* renamed from: b  reason: collision with root package name */
        private int f6070b = 640;
        private int c = VideoConstant.THUMBNAIL_WIDTH;
        private int e = 1;
        private boolean n = true;

        public Builder setIsAutoPlay(boolean z) {
            this.n = z;
            return this;
        }

        public Builder setCodeId(String str) {
            this.f6069a = str;
            return this;
        }

        public Builder setImageAcceptedSize(int i, int i2) {
            this.f6070b = i;
            this.c = i2;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f, float f2) {
            this.l = f;
            this.m = f2;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.d = z;
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
            this.e = i3;
            return this;
        }

        public Builder setRewardName(String str) {
            this.f = str;
            return this;
        }

        public Builder setRewardAmount(int i) {
            this.g = i;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.h = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.i = str;
            return this;
        }

        public Builder setOrientation(int i) {
            this.j = i;
            return this;
        }

        public Builder setNativeAdType(int i) {
            this.k = i;
            return this;
        }

        public Builder setAdloadSeq(int i) {
            this.p = i;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.q = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.o = iArr;
            return this;
        }

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.f6067a = this.f6069a;
            adSlot.f = this.e;
            adSlot.g = this.d;
            adSlot.f6068b = this.f6070b;
            adSlot.c = this.c;
            adSlot.d = this.l;
            adSlot.e = this.m;
            adSlot.h = this.f;
            adSlot.i = this.g;
            adSlot.j = this.h;
            adSlot.k = this.i;
            adSlot.l = this.j;
            adSlot.m = this.k;
            adSlot.n = this.n;
            adSlot.o = this.o;
            adSlot.p = this.p;
            adSlot.q = this.q;
            return adSlot;
        }
    }
}
