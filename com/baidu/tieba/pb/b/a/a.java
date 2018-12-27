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
    private ExcContent gmw;
    private SpannableString gmx;

    public a(ExcContent excContent) {
        this.gmw = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bnP() {
        return b(this.gmw);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int hE;
        a.C0171a ic;
        if (this.gmx == null && (hE = TbFaceManager.Nu().hE((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.Nu().hG(str) + ")";
            this.gmx = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getContext(), hE);
            if (TbFaceManager.Nu().ic(str) != null) {
                int width = (int) (ic.getWidth() * 0.6d);
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.gmx.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return this.gmx;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bnQ() {
        return false;
    }
}
