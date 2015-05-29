package com.baidu.tieba.write.album;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ v cyT;
    private final /* synthetic */ ImageFileInfo cyU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar, ImageFileInfo imageFileInfo) {
        this.cyT = vVar;
        this.cyU = imageFileInfo;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        TbImageView a;
        if (aVar != null) {
            linearLayout = this.cyT.cyL;
            int childCount = linearLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                linearLayout2 = this.cyT.cyL;
                if (linearLayout2.getChildAt(i) != null) {
                    linearLayout3 = this.cyT.cyL;
                    if (linearLayout3.getChildAt(i) instanceof FrameLayout) {
                        linearLayout4 = this.cyT.cyL;
                        a = this.cyT.a((FrameLayout) linearLayout4.getChildAt(i));
                        if (a != null && a.getTag() != null && a.getTag().equals(this.cyU.toCachedKey(false))) {
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
