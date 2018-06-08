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
    private ExcContent fHR;
    private SpannableString fHS;

    public a(ExcContent excContent) {
        this.fHR = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bhg() {
        return b(this.fHR);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int gA;
        a.C0115a gZ;
        if (this.fHS == null && (gA = TbFaceManager.IC().gA((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.IC().gC(str) + ")";
            this.fHS = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getContext(), gA);
            if (TbFaceManager.IC().gZ(str) != null) {
                int width = (int) (gZ.getWidth() * 0.6d);
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.fHS.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return this.fHS;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bhh() {
        return false;
    }
}
