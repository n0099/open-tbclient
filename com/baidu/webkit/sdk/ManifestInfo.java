package com.baidu.webkit.sdk;
/* loaded from: classes4.dex */
public final class ManifestInfo {
    public int mBgColor;
    public int mDisplay;
    public IconInfo[] mIcons;
    public String mManifestExtra;
    public String mName;
    public int mOrientation;
    public String mShortName;
    public String mStartUrl;
    public int mThemeColor;

    /* loaded from: classes4.dex */
    public static final class IconInfo {
        public int mHeight1;
        public int mHeight2;
        public int mHeight3;
        public String mIconType;
        public String mIconUrl;
        public int mWidth1;
        public int mWidth2;
        public int mWidth3;
    }

    public final void populateManifestInfo(String str, String str2, String str3, int i, int i2, int i3, int i4, String[] strArr, String[] strArr2, int[] iArr, int[] iArr2, String str4) {
        this.mStartUrl = str;
        this.mName = str2;
        this.mShortName = str3;
        this.mDisplay = i;
        this.mOrientation = i2;
        this.mThemeColor = i3;
        this.mBgColor = i4;
        this.mManifestExtra = str4;
        if (strArr == null) {
            return;
        }
        int length = strArr.length;
        this.mIcons = new IconInfo[length];
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            if (this.mIcons[i5] == null) {
                this.mIcons[i5] = new IconInfo();
            }
            this.mIcons[i5].mIconUrl = strArr[i5];
            this.mIcons[i5].mIconType = strArr2[i5];
            int min = Math.min(iArr2[i5], 3);
            for (int i7 = 0; i7 < min; i7++) {
                int i8 = (i6 + i7) * 2;
                switch (i7) {
                    case 0:
                        this.mIcons[i5].mWidth1 = iArr[i8];
                        this.mIcons[i5].mHeight1 = iArr[i8 + 1];
                        break;
                    case 1:
                        this.mIcons[i5].mWidth2 = iArr[i8];
                        this.mIcons[i5].mHeight2 = iArr[i8 + 1];
                        break;
                    case 2:
                        this.mIcons[i5].mWidth3 = iArr[i8];
                        this.mIcons[i5].mHeight3 = iArr[i8 + 1];
                        break;
                }
            }
            i5++;
            i6 = iArr2[i5] + i6;
        }
    }
}
