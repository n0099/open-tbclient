package com.baidu.tieba.pb.b.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes10.dex */
public class a implements c {
    private ExcContent iWF;
    private SpannableString iWG;

    public a(ExcContent excContent) {
        this.iWF = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence cse() {
        return b(this.iWF);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int vb;
        a.C0391a vu;
        if (this.iWG == null && (vb = TbFaceManager.aPN().vb((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.aPN().vd(str) + ")";
            this.iWG = new SpannableString(str2 + HanziToPinyin.Token.SEPARATOR);
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst().getContext(), vb);
            if (TbFaceManager.aPN().vu(str) != null) {
                int width = (int) (vu.getWidth() * 0.6d);
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.iWG.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.iWG;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean csf() {
        return false;
    }
}
