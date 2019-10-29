package com.baidu.tieba.pb.b.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class a implements c {
    private ExcContent ido;
    private SpannableString idp;

    public a(ExcContent excContent) {
        this.ido = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bXL() {
        return b(this.ido);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int pz;
        a.C0296a pV;
        if (this.idp == null && (pz = TbFaceManager.avt().pz((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.avt().pB(str) + ")";
            this.idp = new SpannableString(str2 + HanziToPinyin.Token.SEPARATOR);
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getContext(), pz);
            if (TbFaceManager.avt().pV(str) != null) {
                int width = (int) (pV.getWidth() * 0.6d);
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.idp.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return this.idp;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bXM() {
        return false;
    }
}
