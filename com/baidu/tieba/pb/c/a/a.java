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
    private ExcContent cMk;
    private SpannableString cMl;

    public a(ExcContent excContent) {
        this.cMk = excContent;
    }

    @Override // com.baidu.tieba.pb.c.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public CharSequence aog() {
        return b(this.cMk);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int fe;
        a.C0051a fF;
        if (this.cMl == null && (fe = TbFaceManager.CL().fe((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.CL().fg(str) + ")";
            this.cMl = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.e eVar = new com.baidu.tbadk.widget.richText.e(TbadkCoreApplication.m411getInst().getContext(), fe);
            if (TbFaceManager.CL().fF(str) != null) {
                int width = (int) (fF.getWidth() * 0.6d);
                eVar.setBounds(new Rect(0, 0, width, width));
            } else {
                eVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.cMl.setSpan(new ImageSpan(eVar, 0), 0, str2.length(), 33);
        }
        return this.cMl;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public boolean aoh() {
        return false;
    }
}
