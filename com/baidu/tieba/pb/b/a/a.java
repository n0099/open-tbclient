package com.baidu.tieba.pb.b.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes7.dex */
public class a implements c {
    private ExcContent mkH;
    private SpannableString mkI;

    public a(ExcContent excContent) {
        this.mkH = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence dtM() {
        return b(this.mkH);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int CR;
        a.C0582a Dm;
        if (this.mkI == null && (CR = TbFaceManager.bCR().CR((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.bCR().CT(str) + ")";
            this.mkI = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst().getContext(), CR);
            if (TbFaceManager.bCR().Dm(str) != null) {
                int width = (int) (Dm.getWidth() * 0.6d);
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.mkI.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.mkI;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean dtN() {
        return false;
    }
}
