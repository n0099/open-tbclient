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
    private ExcContent gbq;
    private SpannableString gbr;

    public a(ExcContent excContent) {
        this.gbq = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence blP() {
        return b(this.gbq);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int hk;
        a.C0137a hJ;
        if (this.gbr == null && (hk = TbFaceManager.Md().hk((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.Md().hm(str) + ")";
            this.gbr = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getContext(), hk);
            if (TbFaceManager.Md().hJ(str) != null) {
                int width = (int) (hJ.getWidth() * 0.6d);
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.gbr.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return this.gbr;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean blQ() {
        return false;
    }
}
