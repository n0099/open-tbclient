package com.baidu.tieba.pb.b.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes8.dex */
public class a implements c {
    private ExcContent miq;
    private SpannableString mir;

    public a(ExcContent excContent) {
        this.miq = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence dtw() {
        return b(this.miq);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int CM;
        a.C0576a Dh;
        if (this.mir == null && (CM = TbFaceManager.bCO().CM((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.bCO().CO(str) + ")";
            this.mir = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst().getContext(), CM);
            if (TbFaceManager.bCO().Dh(str) != null) {
                int width = (int) (Dh.getWidth() * 0.6d);
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.mir.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.mir;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean dtx() {
        return false;
    }
}
