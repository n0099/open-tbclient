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
    private ExcContent fMa;
    private SpannableString fMb;

    public a(ExcContent excContent) {
        this.fMa = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bga() {
        return b(this.fMa);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int gA;
        a.C0113a gZ;
        if (this.fMb == null && (gA = TbFaceManager.IP().gA((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.IP().gC(str) + ")";
            this.fMb = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getContext(), gA);
            if (TbFaceManager.IP().gZ(str) != null) {
                int width = (int) (gZ.getWidth() * 0.6d);
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.fMb.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return this.fMb;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bgb() {
        return false;
    }
}
