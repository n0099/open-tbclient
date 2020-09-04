package com.baidu.tieba.pb.b.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes17.dex */
public class a implements c {
    private ExcContent kTT;
    private SpannableString kTU;

    public a(ExcContent excContent) {
        this.kTT = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence dds() {
        return b(this.kTT);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int BO;
        a.C0554a Cj;
        if (this.kTU == null && (BO = TbFaceManager.bsW().BO((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.bsW().BQ(str) + ")";
            this.kTU = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst().getContext(), BO);
            if (TbFaceManager.bsW().Cj(str) != null) {
                int width = (int) (Cj.getWidth() * 0.6d);
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.kTU.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.kTU;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean ddt() {
        return false;
    }
}
