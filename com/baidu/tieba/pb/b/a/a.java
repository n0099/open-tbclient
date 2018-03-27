package com.baidu.tieba.pb.b.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes3.dex */
public class a implements c {
    private ExcContent gbl;
    private SpannableString gbm;

    public a(ExcContent excContent) {
        this.gbl = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bhg() {
        return b(this.gbl);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int gk;
        a.C0109a gK;
        if (this.gbm == null && (gk = TbFaceManager.Mw().gk((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.Mw().gm(str) + ")";
            this.gbm = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getContext(), gk);
            if (TbFaceManager.Mw().gK(str) != null) {
                int width = (int) (gK.getWidth() * 0.6d);
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.gbm.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return this.gbm;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bhh() {
        return false;
    }
}
