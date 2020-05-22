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
    private ExcContent kaq;
    private SpannableString kar;

    public a(ExcContent excContent) {
        this.kaq = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence cKe() {
        return b(this.kaq);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int xY;
        a.C0490a ys;
        if (this.kar == null && (xY = TbFaceManager.bes().xY((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.bes().ya(str) + ")";
            this.kar = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst().getContext(), xY);
            if (TbFaceManager.bes().ys(str) != null) {
                int width = (int) (ys.getWidth() * 0.6d);
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.kar.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.kar;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean cKf() {
        return false;
    }
}
