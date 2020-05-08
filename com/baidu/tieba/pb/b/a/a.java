package com.baidu.tieba.pb.b.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes10.dex */
public class a implements c {
    private ExcContent jIG;
    private SpannableString jIH;

    public a(ExcContent excContent) {
        this.jIG = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence cDf() {
        return b(this.jIG);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int ws;
        a.C0443a wM;
        if (this.jIH == null && (ws = TbFaceManager.aYj().ws((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.aYj().wu(str) + ")";
            this.jIH = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst().getContext(), ws);
            if (TbFaceManager.aYj().wM(str) != null) {
                int width = (int) (wM.getWidth() * 0.6d);
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.jIH.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.jIH;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean cDg() {
        return false;
    }
}
