package com.baidu.tieba.pb.richview.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class a implements b {
    private Content bOA;
    private SpannableString bOB;

    public a(Content content) {
        this.bOA = content;
    }

    @Override // com.baidu.tieba.pb.richview.a.c
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.richview.a.b
    public CharSequence acL() {
        return b(this.bOA);
    }

    private SpannableString b(Content content) {
        String str;
        int ed;
        com.baidu.tbadk.imageManager.c eq;
        if (this.bOB == null && (ed = TbFaceManager.zx().ed((str = content.text))) != 0) {
            String str2 = "#(" + TbFaceManager.zx().ef(str) + ")";
            this.bOB = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.f fVar = new com.baidu.tbadk.widget.richText.f(TbadkCoreApplication.m411getInst().getContext(), ed);
            if (TbFaceManager.zx().eq(str) != null) {
                int width = (int) (eq.getWidth() * 0.6d);
                fVar.setBounds(new Rect(0, 0, width, width));
            } else {
                fVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.bOB.setSpan(new ImageSpan(fVar, 0), 0, str2.length(), 33);
        }
        return this.bOB;
    }
}
