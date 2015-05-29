package com.baidu.tieba.pb.d.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class a implements d {
    private Content bQB;
    private SpannableString bQC;

    public a(Content content) {
        this.bQB = content;
    }

    @Override // com.baidu.tieba.pb.d.a.e
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.d.a.d
    public CharSequence adM() {
        return b(this.bQB);
    }

    private SpannableString b(Content content) {
        String str;
        int eu;
        com.baidu.tbadk.imageManager.c eH;
        if (this.bQC == null && (eu = TbFaceManager.Ak().eu((str = content.text))) != 0) {
            String str2 = "#(" + TbFaceManager.Ak().ew(str) + ")";
            this.bQC = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.f fVar = new com.baidu.tbadk.widget.richText.f(TbadkCoreApplication.m411getInst().getContext(), eu);
            if (TbFaceManager.Ak().eH(str) != null) {
                int width = (int) (eH.getWidth() * 0.6d);
                fVar.setBounds(new Rect(0, 0, width, width));
            } else {
                fVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.bQC.setSpan(new ImageSpan(fVar, 0), 0, str2.length(), 33);
        }
        return this.bQC;
    }
}
