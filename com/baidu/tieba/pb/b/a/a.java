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
    private ExcContent fvr;
    private SpannableString fvs;

    public a(ExcContent excContent) {
        this.fvr = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bcg() {
        return b(this.fvr);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int gb;
        a.C0098a gB;
        if (this.fvs == null && (gb = TbFaceManager.EZ().gb((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.EZ().gd(str) + ")";
            this.fvs = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getContext(), gb);
            if (TbFaceManager.EZ().gB(str) != null) {
                int width = (int) (gB.getWidth() * 0.6d);
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.fvs.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return this.fvs;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bch() {
        return false;
    }
}
