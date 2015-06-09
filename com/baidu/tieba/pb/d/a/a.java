package com.baidu.tieba.pb.d.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class a implements d {
    private Content bQC;
    private SpannableString bQD;

    public a(Content content) {
        this.bQC = content;
    }

    @Override // com.baidu.tieba.pb.d.a.e
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.d.a.d
    public CharSequence adN() {
        return b(this.bQC);
    }

    private SpannableString b(Content content) {
        String str;
        int eu;
        com.baidu.tbadk.imageManager.c eH;
        if (this.bQD == null && (eu = TbFaceManager.Al().eu((str = content.text))) != 0) {
            String str2 = "#(" + TbFaceManager.Al().ew(str) + ")";
            this.bQD = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.f fVar = new com.baidu.tbadk.widget.richText.f(TbadkCoreApplication.m411getInst().getContext(), eu);
            if (TbFaceManager.Al().eH(str) != null) {
                int width = (int) (eH.getWidth() * 0.6d);
                fVar.setBounds(new Rect(0, 0, width, width));
            } else {
                fVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.bQD.setSpan(new ImageSpan(fVar, 0), 0, str2.length(), 33);
        }
        return this.bQD;
    }
}
