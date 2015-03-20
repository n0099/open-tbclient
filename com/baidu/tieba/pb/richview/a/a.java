package com.baidu.tieba.pb.richview.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class a implements b {
    private Content bOk;
    private SpannableString bOl;

    public a(Content content) {
        this.bOk = content;
    }

    @Override // com.baidu.tieba.pb.richview.a.c
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.richview.a.b
    public CharSequence acw() {
        return b(this.bOk);
    }

    private SpannableString b(Content content) {
        String str;
        int ea;
        com.baidu.tbadk.imageManager.c en;
        if (this.bOl == null && (ea = TbFaceManager.zr().ea((str = content.text))) != 0) {
            String str2 = "#(" + TbFaceManager.zr().ec(str) + ")";
            this.bOl = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.f fVar = new com.baidu.tbadk.widget.richText.f(TbadkCoreApplication.m411getInst().getContext(), ea);
            if (TbFaceManager.zr().en(str) != null) {
                int width = (int) (en.getWidth() * 0.6d);
                fVar.setBounds(new Rect(0, 0, width, width));
            } else {
                fVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.bOl.setSpan(new ImageSpan(fVar, 0), 0, str2.length(), 33);
        }
        return this.bOl;
    }
}
