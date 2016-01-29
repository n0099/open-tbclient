package com.baidu.tieba.pb.d.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes.dex */
public class a implements c {
    private ExcContent cUY;
    private SpannableString cUZ;

    public a(ExcContent excContent) {
        this.cUY = excContent;
    }

    @Override // com.baidu.tieba.pb.d.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.d.a.c
    public CharSequence asP() {
        return b(this.cUY);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int fd;
        a.C0052a fD;
        if (this.cUZ == null && (fd = TbFaceManager.Ec().fd((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.Ec().ff(str) + ")";
            this.cUZ = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.e eVar = new com.baidu.tbadk.widget.richText.e(TbadkCoreApplication.m411getInst().getContext(), fd);
            if (TbFaceManager.Ec().fD(str) != null) {
                int width = (int) (fD.getWidth() * 0.6d);
                eVar.setBounds(new Rect(0, 0, width, width));
            } else {
                eVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.cUZ.setSpan(new ImageSpan(eVar, 0), 0, str2.length(), 33);
        }
        return this.cUZ;
    }

    @Override // com.baidu.tieba.pb.d.a.c
    public boolean asQ() {
        return false;
    }
}
