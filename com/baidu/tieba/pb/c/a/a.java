package com.baidu.tieba.pb.c.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes.dex */
public class a implements c {
    private ExcContent cIi;
    private SpannableString cIj;

    public a(ExcContent excContent) {
        this.cIi = excContent;
    }

    @Override // com.baidu.tieba.pb.c.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public CharSequence amV() {
        return b(this.cIi);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int fa;
        a.C0051a fB;
        if (this.cIj == null && (fa = TbFaceManager.CW().fa((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.CW().fc(str) + ")";
            this.cIj = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.e eVar = new com.baidu.tbadk.widget.richText.e(TbadkCoreApplication.m411getInst().getContext(), fa);
            if (TbFaceManager.CW().fB(str) != null) {
                int width = (int) (fB.getWidth() * 0.6d);
                eVar.setBounds(new Rect(0, 0, width, width));
            } else {
                eVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.cIj.setSpan(new ImageSpan(eVar, 0), 0, str2.length(), 33);
        }
        return this.cIj;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public boolean amW() {
        return false;
    }
}
