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
    private ExcContent iWH;
    private SpannableString iWI;

    public a(ExcContent excContent) {
        this.iWH = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence csg() {
        return b(this.iWH);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int vb;
        a.C0391a vu;
        if (this.iWI == null && (vb = TbFaceManager.aPP().vb((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.aPP().vd(str) + ")";
            this.iWI = new SpannableString(str2 + HanziToPinyin.Token.SEPARATOR);
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst().getContext(), vb);
            if (TbFaceManager.aPP().vu(str) != null) {
                int width = (int) (vu.getWidth() * 0.6d);
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.iWI.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.iWI;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean csh() {
        return false;
    }
}
