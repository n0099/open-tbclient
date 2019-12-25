package com.bigkoo.svprogresshud;
/* loaded from: classes4.dex */
public class SVProgressHUDAnimateUtil {
    private static final int INVALID = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getAnimationResource(int i, boolean z) {
        switch (i) {
            case 17:
                return z ? R.anim.svfade_in_center : R.anim.svfade_out_center;
            case 48:
                return z ? R.anim.svslide_in_top : R.anim.svslide_out_top;
            case 80:
                return z ? R.anim.svslide_in_bottom : R.anim.svslide_out_bottom;
            default:
                return -1;
        }
    }
}
