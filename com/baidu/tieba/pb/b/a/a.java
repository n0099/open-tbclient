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
    private ExcContent ibJ;
    private SpannableString ibK;

    public a(ExcContent excContent) {
        this.ibJ = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bZD() {
        return b(this.ibJ);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int qf;
        a.C0255a qC;
        if (this.ibK == null && (qf = TbFaceManager.atv().qf((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.atv().qh(str) + ")";
            this.ibK = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getContext(), qf);
            if (TbFaceManager.atv().qC(str) != null) {
                int width = (int) (qC.getWidth() * 0.6d);
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.ibK.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return this.ibK;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bZE() {
        return false;
    }
}
