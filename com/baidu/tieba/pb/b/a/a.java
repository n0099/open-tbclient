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
    private ExcContent iYu;
    private SpannableString iYv;

    public a(ExcContent excContent) {
        this.iYu = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence csC() {
        return b(this.iYu);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int vb;
        a.C0391a vu;
        if (this.iYv == null && (vb = TbFaceManager.aPU().vb((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.aPU().vd(str) + ")";
            this.iYv = new SpannableString(str2 + HanziToPinyin.Token.SEPARATOR);
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst().getContext(), vb);
            if (TbFaceManager.aPU().vu(str) != null) {
                int width = (int) (vu.getWidth() * 0.6d);
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.iYv.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.iYv;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean csD() {
        return false;
    }
}
