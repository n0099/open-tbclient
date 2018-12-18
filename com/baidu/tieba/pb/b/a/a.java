package com.baidu.tieba.pb.b.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class a implements c {
    private ExcContent gjF;
    private SpannableString gjG;

    public a(ExcContent excContent) {
        this.gjF = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bnd() {
        return b(this.gjF);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int hD;
        a.C0171a ib;
        if (this.gjG == null && (hD = TbFaceManager.Nt().hD((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.Nt().hF(str) + ")";
            this.gjG = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getContext(), hD);
            if (TbFaceManager.Nt().ib(str) != null) {
                int width = (int) (ib.getWidth() * 0.6d);
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.gjG.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return this.gjG;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bne() {
        return false;
    }
}
