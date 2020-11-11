package com.baidu.tieba.pb.b.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes23.dex */
public class a implements c {
    private ExcContent lKj;
    private SpannableString lKk;

    public a(ExcContent excContent) {
        this.lKj = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence dqp() {
        return b(this.lKj);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int DD;
        a.C0593a DY;
        if (this.lKk == null && (DD = TbFaceManager.bBc().DD((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.bBc().DF(str) + ")";
            this.lKk = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst().getContext(), DD);
            if (TbFaceManager.bBc().DY(str) != null) {
                int width = (int) (DY.getWidth() * 0.6d);
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.lKk.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.lKk;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean dqq() {
        return false;
    }
}
