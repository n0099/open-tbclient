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
    private ExcContent iVl;
    private SpannableString iVm;

    public a(ExcContent excContent) {
        this.iVl = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence cqM() {
        return b(this.iVl);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int uK;
        a.C0381a vd;
        if (this.iVm == null && (uK = TbFaceManager.aNr().uK((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.aNr().uM(str) + ")";
            this.iVm = new SpannableString(str2 + HanziToPinyin.Token.SEPARATOR);
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst().getContext(), uK);
            if (TbFaceManager.aNr().vd(str) != null) {
                int width = (int) (vd.getWidth() * 0.6d);
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.iVm.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.iVm;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean cqN() {
        return false;
    }
}
