package com.baidu.tieba.pb.b.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class a implements c {
    private ExcContent gnA;
    private SpannableString gnB;

    public a(ExcContent excContent) {
        this.gnA = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence box() {
        return b(this.gnA);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int hS;
        a.C0171a ir;
        if (this.gnB == null && (hS = TbFaceManager.NL().hS((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.NL().hU(str) + ")";
            this.gnB = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getContext(), hS);
            if (TbFaceManager.NL().ir(str) != null) {
                int width = (int) (ir.getWidth() * 0.6d);
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.gnB.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return this.gnB;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean boy() {
        return false;
    }
}
