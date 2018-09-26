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
    private ExcContent fTQ;
    private SpannableString fTR;

    public a(ExcContent excContent) {
        this.fTQ = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence biD() {
        return b(this.fTQ);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int gW;
        a.C0113a hv;
        if (this.fTR == null && (gW = TbFaceManager.Kf().gW((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.Kf().gY(str) + ")";
            this.fTR = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getContext(), gW);
            if (TbFaceManager.Kf().hv(str) != null) {
                int width = (int) (hv.getWidth() * 0.6d);
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.fTR.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return this.fTR;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean biE() {
        return false;
    }
}
