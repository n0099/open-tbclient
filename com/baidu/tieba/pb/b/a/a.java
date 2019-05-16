package com.baidu.tieba.pb.b.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class a implements c {
    private ExcContent hVs;
    private SpannableString hVt;

    public a(ExcContent excContent) {
        this.hVs = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bWK() {
        return b(this.hVs);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int pP;
        a.C0253a qm;
        if (this.hVt == null && (pP = TbFaceManager.aso().pP((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.aso().pR(str) + ")";
            this.hVt = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getContext(), pP);
            if (TbFaceManager.aso().qm(str) != null) {
                int width = (int) (qm.getWidth() * 0.6d);
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.hVt.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return this.hVt;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bWL() {
        return false;
    }
}
