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
    private Content cnF;
    private SpannableString cnG;

    public a(Content content) {
        this.cnF = content;
    }

    @Override // com.baidu.tieba.pb.c.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public CharSequence ahM() {
        return b(this.cnF);
    }

    private SpannableString b(Content content) {
        String str;
        int eM;
        a.C0049a fk;
        if (this.cnG == null && (eM = TbFaceManager.Cb().eM((str = content.text))) != 0) {
            String str2 = "#(" + TbFaceManager.Cb().eO(str) + ")";
            this.cnG = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.e eVar = new com.baidu.tbadk.widget.richText.e(TbadkCoreApplication.m411getInst().getContext(), eM);
            if (TbFaceManager.Cb().fk(str) != null) {
                int width = (int) (fk.getWidth() * 0.6d);
                eVar.setBounds(new Rect(0, 0, width, width));
            } else {
                eVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.cnG.setSpan(new ImageSpan(eVar, 0), 0, str2.length(), 33);
        }
        return this.cnG;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public boolean ahN() {
        return false;
    }
}
