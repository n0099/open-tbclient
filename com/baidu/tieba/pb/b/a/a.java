package com.baidu.tieba.pb.b.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes10.dex */
public class a implements c {
    private ExcContent jIC;
    private SpannableString jID;

    public a(ExcContent excContent) {
        this.jIC = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence cDi() {
        return b(this.jIC);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int wp;
        a.C0422a wJ;
        if (this.jID == null && (wp = TbFaceManager.aYl().wp((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.aYl().wr(str) + ")";
            this.jID = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst().getContext(), wp);
            if (TbFaceManager.aYl().wJ(str) != null) {
                int width = (int) (wJ.getWidth() * 0.6d);
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.jID.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.jID;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean cDj() {
        return false;
    }
}
