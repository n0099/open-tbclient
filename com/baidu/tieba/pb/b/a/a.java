package com.baidu.tieba.pb.b.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes22.dex */
public class a implements c {
    private ExcContent lcx;
    private SpannableString lcy;

    public a(ExcContent excContent) {
        this.lcx = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence dgW() {
        return b(this.lcx);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int Ck;
        a.C0550a CF;
        if (this.lcy == null && (Ck = TbFaceManager.bua().Ck((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.bua().Cm(str) + ")";
            this.lcy = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst().getContext(), Ck);
            if (TbFaceManager.bua().CF(str) != null) {
                int width = (int) (CF.getWidth() * 0.6d);
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.lcy.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.lcy;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean dgX() {
        return false;
    }
}
