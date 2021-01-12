package com.baidu.tieba.pb.b.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes7.dex */
public class a implements c {
    private ExcContent lZi;
    private SpannableString lZj;

    public a(ExcContent excContent) {
        this.lZi = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence drh() {
        return b(this.lZi);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int Cv;
        a.C0579a CQ;
        if (this.lZj == null && (Cv = TbFaceManager.bCw().Cv((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.bCw().Cx(str) + ")";
            this.lZj = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst().getContext(), Cv);
            if (TbFaceManager.bCw().CQ(str) != null) {
                int width = (int) (CQ.getWidth() * 0.6d);
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.lZj.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.lZj;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean dri() {
        return false;
    }
}
