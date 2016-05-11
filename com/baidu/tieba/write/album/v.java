package com.baidu.tieba.write.album;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ t eYB;
    private final /* synthetic */ ImageFileInfo eYC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, ImageFileInfo imageFileInfo) {
        this.eYB = tVar;
        this.eYC = imageFileInfo;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        TbImageView a;
        if (aVar != null) {
            linearLayout = this.eYB.eYs;
            int childCount = linearLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                linearLayout2 = this.eYB.eYs;
                if (linearLayout2.getChildAt(i) != null) {
                    linearLayout3 = this.eYB.eYs;
                    if (linearLayout3.getChildAt(i) instanceof FrameLayout) {
                        linearLayout4 = this.eYB.eYs;
                        a = this.eYB.a((FrameLayout) linearLayout4.getChildAt(i));
                        if (a != null && a.getTag() != null && a.getTag().equals(this.eYC.toCachedKey(false))) {
                            aVar.a(a);
                            return;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
    }
}
