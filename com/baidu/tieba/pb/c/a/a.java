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
    private Content chX;
    private SpannableString chY;

    public a(Content content) {
        this.chX = content;
    }

    @Override // com.baidu.tieba.pb.c.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public CharSequence afR() {
        return b(this.chX);
    }

    private SpannableString b(Content content) {
        String str;
        int eH;
        a.C0049a ff;
        if (this.chY == null && (eH = TbFaceManager.Cr().eH((str = content.text))) != 0) {
            String str2 = "#(" + TbFaceManager.Cr().eJ(str) + ")";
            this.chY = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.e eVar = new com.baidu.tbadk.widget.richText.e(TbadkCoreApplication.m411getInst().getContext(), eH);
            if (TbFaceManager.Cr().ff(str) != null) {
                int width = (int) (ff.getWidth() * 0.6d);
                eVar.setBounds(new Rect(0, 0, width, width));
            } else {
                eVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.chY.setSpan(new ImageSpan(eVar, 0), 0, str2.length(), 33);
        }
        return this.chY;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public boolean afS() {
        return false;
    }
}
