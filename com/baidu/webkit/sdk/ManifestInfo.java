package com.baidu.webkit.sdk;
/* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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
        for (int i6 = 0; i6 < length; i6++) {
            IconInfo[] iconInfoArr = this.mIcons;
            if (iconInfoArr[i6] == null) {
                iconInfoArr[i6] = new IconInfo();
            }
            IconInfo[] iconInfoArr2 = this.mIcons;
            iconInfoArr2[i6].mIconUrl = strArr[i6];
            iconInfoArr2[i6].mIconType = strArr2[i6];
            int min = Math.min(iArr2[i6], 3);
            for (int i7 = 0; i7 < min; i7++) {
                int i8 = (i5 + i7) * 2;
                if (i7 == 0) {
                    IconInfo[] iconInfoArr3 = this.mIcons;
                    iconInfoArr3[i6].mWidth1 = iArr[i8];
                    iconInfoArr3[i6].mHeight1 = iArr[i8 + 1];
                } else if (i7 == 1) {
                    IconInfo[] iconInfoArr4 = this.mIcons;
                    iconInfoArr4[i6].mWidth2 = iArr[i8];
                    iconInfoArr4[i6].mHeight2 = iArr[i8 + 1];
                } else if (i7 == 2) {
                    IconInfo[] iconInfoArr5 = this.mIcons;
                    iconInfoArr5[i6].mWidth3 = iArr[i8];
                    iconInfoArr5[i6].mHeight3 = iArr[i8 + 1];
                }
            }
            i5 += iArr2[i6];
        }
    }
}
