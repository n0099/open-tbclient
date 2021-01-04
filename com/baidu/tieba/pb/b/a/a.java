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
    private ExcContent mdQ;
    private SpannableString mdR;

    public a(ExcContent excContent) {
        this.mdQ = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence duY() {
        return b(this.mdQ);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int DH;
        a.C0596a Ec;
        if (this.mdR == null && (DH = TbFaceManager.bGo().DH((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.bGo().DJ(str) + ")";
            this.mdR = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst().getContext(), DH);
            if (TbFaceManager.bGo().Ec(str) != null) {
                int width = (int) (Ec.getWidth() * 0.6d);
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.mdR.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.mdR;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean duZ() {
        return false;
    }
}
