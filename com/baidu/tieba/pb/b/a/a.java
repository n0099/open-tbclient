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
    private ExcContent gaV;
    private SpannableString gaW;

    public a(ExcContent excContent) {
        this.gaV = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bhf() {
        return b(this.gaV);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int gk;
        a.C0109a gK;
        if (this.gaW == null && (gk = TbFaceManager.Mv().gk((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.Mv().gm(str) + ")";
            this.gaW = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getContext(), gk);
            if (TbFaceManager.Mv().gK(str) != null) {
                int width = (int) (gK.getWidth() * 0.6d);
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.gaW.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return this.gaW;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bhg() {
        return false;
    }
}
