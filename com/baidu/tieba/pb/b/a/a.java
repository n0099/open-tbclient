package com.baidu.tieba.pb.b.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes7.dex */
public class a implements c {
    private ExcContent iRI;
    private SpannableString iRJ;

    public a(ExcContent excContent) {
        this.iRI = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence cpF() {
        return b(this.iRI);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int uF;
        a.C0379a uY;
        if (this.iRJ == null && (uF = TbFaceManager.aMY().uF((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.aMY().uH(str) + ")";
            this.iRJ = new SpannableString(str2 + HanziToPinyin.Token.SEPARATOR);
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst().getContext(), uF);
            if (TbFaceManager.aMY().uY(str) != null) {
                int width = (int) (uY.getWidth() * 0.6d);
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.iRJ.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.iRJ;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean cpG() {
        return false;
    }
}
