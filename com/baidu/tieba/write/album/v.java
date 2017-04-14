package com.baidu.tieba.write.album;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ t fNS;
    private final /* synthetic */ ImageFileInfo fNT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, ImageFileInfo imageFileInfo) {
        this.fNS = tVar;
        this.fNT = imageFileInfo;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        TbImageView a;
        if (aVar != null) {
            linearLayout = this.fNS.fNJ;
            int childCount = linearLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                linearLayout2 = this.fNS.fNJ;
                if (linearLayout2.getChildAt(i) != null) {
                    linearLayout3 = this.fNS.fNJ;
                    if (linearLayout3.getChildAt(i) instanceof FrameLayout) {
                        linearLayout4 = this.fNS.fNJ;
                        a = this.fNS.a((FrameLayout) linearLayout4.getChildAt(i));
                        if (a != null && a.getTag() != null && a.getTag().equals(this.fNT.toCachedKey(false))) {
                            aVar.e(a);
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
