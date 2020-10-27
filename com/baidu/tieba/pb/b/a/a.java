package com.baidu.tieba.pb.b.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes23.dex */
public class a implements c {
    private ExcContent lEn;
    private SpannableString lEo;

    public a(ExcContent excContent) {
        this.lEn = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence dnN() {
        return b(this.lEn);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int Dp;
        a.C0581a DK;
        if (this.lEo == null && (Dp = TbFaceManager.byD().Dp((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.byD().Dr(str) + ")";
            this.lEo = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst().getContext(), Dp);
            if (TbFaceManager.byD().DK(str) != null) {
                int width = (int) (DK.getWidth() * 0.6d);
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.lEo.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.lEo;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean dnO() {
        return false;
    }
}
