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
    private ExcContent lrO;
    private SpannableString lrP;

    public a(ExcContent excContent) {
        this.lrO = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence dkF() {
        return b(this.lrO);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int CW;
        a.C0567a Dr;
        if (this.lrP == null && (CW = TbFaceManager.bwK().CW((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.bwK().CY(str) + ")";
            this.lrP = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst().getContext(), CW);
            if (TbFaceManager.bwK().Dr(str) != null) {
                int width = (int) (Dr.getWidth() * 0.6d);
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.lrP.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.lrP;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean dkG() {
        return false;
    }
}
