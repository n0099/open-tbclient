package com.baidu.tieba.pb.c.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class a implements c {
    private Content cnu;
    private SpannableString cnv;

    public a(Content content) {
        this.cnu = content;
    }

    @Override // com.baidu.tieba.pb.c.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public CharSequence ahQ() {
        return b(this.cnu);
    }

    private SpannableString b(Content content) {
        String str;
        int eM;
        a.C0049a fk;
        if (this.cnv == null && (eM = TbFaceManager.Ce().eM((str = content.text))) != 0) {
            String str2 = "#(" + TbFaceManager.Ce().eO(str) + ")";
            this.cnv = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.e eVar = new com.baidu.tbadk.widget.richText.e(TbadkCoreApplication.m411getInst().getContext(), eM);
            if (TbFaceManager.Ce().fk(str) != null) {
                int width = (int) (fk.getWidth() * 0.6d);
                eVar.setBounds(new Rect(0, 0, width, width));
            } else {
                eVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.cnv.setSpan(new ImageSpan(eVar, 0), 0, str2.length(), 33);
        }
        return this.cnv;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public boolean ahR() {
        return false;
    }
}
