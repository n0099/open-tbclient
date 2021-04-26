package com.baidu.webkit.sdk;
/* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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

    public final void populateManifestInfo(String str, String str2, String str3, int i2, int i3, int i4, int i5, String[] strArr, String[] strArr2, int[] iArr, int[] iArr2, String str4) {
        this.mStartUrl = str;
        this.mName = str2;
        this.mShortName = str3;
        this.mDisplay = i2;
        this.mOrientation = i3;
        this.mThemeColor = i4;
        this.mBgColor = i5;
        this.mManifestExtra = str4;
        if (strArr == null) {
            return;
        }
        int length = strArr.length;
        this.mIcons = new IconInfo[length];
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            IconInfo[] iconInfoArr = this.mIcons;
            if (iconInfoArr[i7] == null) {
                iconInfoArr[i7] = new IconInfo();
            }
            IconInfo[] iconInfoArr2 = this.mIcons;
            iconInfoArr2[i7].mIconUrl = strArr[i7];
            iconInfoArr2[i7].mIconType = strArr2[i7];
            int min = Math.min(iArr2[i7], 3);
            for (int i8 = 0; i8 < min; i8++) {
                int i9 = (i6 + i8) * 2;
                if (i8 == 0) {
                    IconInfo[] iconInfoArr3 = this.mIcons;
                    iconInfoArr3[i7].mWidth1 = iArr[i9];
                    iconInfoArr3[i7].mHeight1 = iArr[i9 + 1];
                } else if (i8 == 1) {
                    IconInfo[] iconInfoArr4 = this.mIcons;
                    iconInfoArr4[i7].mWidth2 = iArr[i9];
                    iconInfoArr4[i7].mHeight2 = iArr[i9 + 1];
                } else if (i8 == 2) {
                    IconInfo[] iconInfoArr5 = this.mIcons;
                    iconInfoArr5[i7].mWidth3 = iArr[i9];
                    iconInfoArr5[i7].mHeight3 = iArr[i9 + 1];
                }
            }
            i6 += iArr2[i7];
        }
    }
}
