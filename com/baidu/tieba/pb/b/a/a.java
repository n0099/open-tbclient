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
    private ExcContent icw;
    private SpannableString icx;

    public a(ExcContent excContent) {
        this.icw = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bXJ() {
        return b(this.icw);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int pz;
        a.C0291a pV;
        if (this.icx == null && (pz = TbFaceManager.avr().pz((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.avr().pB(str) + ")";
            this.icx = new SpannableString(str2 + HanziToPinyin.Token.SEPARATOR);
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getContext(), pz);
            if (TbFaceManager.avr().pV(str) != null) {
                int width = (int) (pV.getWidth() * 0.6d);
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.icx.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return this.icx;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bXK() {
        return false;
    }
}
