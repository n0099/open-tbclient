package com.baidu.tieba.pb.b.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes17.dex */
public class a implements c {
    private ExcContent kEd;
    private SpannableString kEe;

    public a(ExcContent excContent) {
        this.kEd = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence cSz() {
        return b(this.kEd);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int zx;
        a.C0508a zS;
        if (this.kEe == null && (zx = TbFaceManager.bkj().zx((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.bkj().zz(str) + ")";
            this.kEe = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst().getContext(), zx);
            if (TbFaceManager.bkj().zS(str) != null) {
                int width = (int) (zS.getWidth() * 0.6d);
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.kEe.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.kEe;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean cSA() {
        return false;
    }
}
