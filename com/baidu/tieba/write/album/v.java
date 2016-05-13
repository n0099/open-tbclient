package com.baidu.tieba.write.album;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ t eYA;
    private final /* synthetic */ ImageFileInfo eYB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, ImageFileInfo imageFileInfo) {
        this.eYA = tVar;
        this.eYB = imageFileInfo;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        TbImageView a;
        if (aVar != null) {
            linearLayout = this.eYA.eYr;
            int childCount = linearLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                linearLayout2 = this.eYA.eYr;
                if (linearLayout2.getChildAt(i) != null) {
                    linearLayout3 = this.eYA.eYr;
                    if (linearLayout3.getChildAt(i) instanceof FrameLayout) {
                        linearLayout4 = this.eYA.eYr;
                        a = this.eYA.a((FrameLayout) linearLayout4.getChildAt(i));
                        if (a != null && a.getTag() != null && a.getTag().equals(this.eYB.toCachedKey(false))) {
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
