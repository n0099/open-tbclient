package com.bigkoo.svprogresshud;
/* loaded from: classes6.dex */
public class SVProgressHUDAnimateUtil {
    public static final int INVALID = -1;

    public static int getAnimationResource(int i2, boolean z) {
        if (i2 == 17) {
            return z ? R.anim.svfade_in_center : R.anim.svfade_out_center;
        } else if (i2 == 48) {
            return z ? R.anim.svslide_in_top : R.anim.svslide_out_top;
        } else if (i2 != 80) {
            return -1;
        } else {
            return z ? R.anim.svslide_in_bottom : R.anim.svslide_out_bottom;
        }
    }
}
