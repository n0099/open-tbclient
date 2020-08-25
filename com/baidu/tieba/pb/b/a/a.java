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
    private ExcContent kTM;
    private SpannableString kTN;

    public a(ExcContent excContent) {
        this.kTM = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence ddr() {
        return b(this.kTM);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int BN;
        a.C0554a Ci;
        if (this.kTN == null && (BN = TbFaceManager.bsV().BN((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.bsV().BP(str) + ")";
            this.kTN = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst().getContext(), BN);
            if (TbFaceManager.bsV().Ci(str) != null) {
                int width = (int) (Ci.getWidth() * 0.6d);
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.kTN.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.kTN;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean dds() {
        return false;
    }
}
