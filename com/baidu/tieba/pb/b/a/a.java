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
    private ExcContent fLT;
    private SpannableString fLU;

    public a(ExcContent excContent) {
        this.fLT = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bhM() {
        return b(this.fLT);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int gE;
        a.C0116a hd;
        if (this.fLU == null && (gE = TbFaceManager.IU().gE((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.IU().gG(str) + ")";
            this.fLU = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getContext(), gE);
            if (TbFaceManager.IU().hd(str) != null) {
                int width = (int) (hd.getWidth() * 0.6d);
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.fLU.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return this.fLU;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bhN() {
        return false;
    }
}
