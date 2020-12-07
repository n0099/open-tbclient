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
    private SpannableString lYA;
    private ExcContent lYz;

    public a(ExcContent excContent) {
        this.lYz = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence dvi() {
        return b(this.lYz);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int DK;
        a.C0605a Ef;
        if (this.lYA == null && (DK = TbFaceManager.bDU().DK((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.bDU().DM(str) + ")";
            this.lYA = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst().getContext(), DK);
            if (TbFaceManager.bDU().Ef(str) != null) {
                int width = (int) (Ef.getWidth() * 0.6d);
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.lYA.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.lYA;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean dvj() {
        return false;
    }
}
