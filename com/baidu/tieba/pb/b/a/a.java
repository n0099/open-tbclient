package com.baidu.tieba.pb.b.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes8.dex */
public class a implements c {
    private ExcContent iVq;
    private SpannableString iVr;

    public a(ExcContent excContent) {
        this.iVq = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence cqO() {
        return b(this.iVq);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int uK;
        a.C0381a vd;
        if (this.iVr == null && (uK = TbFaceManager.aNr().uK((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.aNr().uM(str) + ")";
            this.iVr = new SpannableString(str2 + HanziToPinyin.Token.SEPARATOR);
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst().getContext(), uK);
            if (TbFaceManager.aNr().vd(str) != null) {
                int width = (int) (vd.getWidth() * 0.6d);
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.iVr.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.iVr;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean cqP() {
        return false;
    }
}
