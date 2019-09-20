package com.baidu.tieba.pb.b.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class a implements c {
    private ExcContent ieI;
    private SpannableString ieJ;

    public a(ExcContent excContent) {
        this.ieI = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence caI() {
        return b(this.ieI);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int qq;
        a.C0264a qN;
        if (this.ieJ == null && (qq = TbFaceManager.atJ().qq((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.atJ().qs(str) + ")";
            this.ieJ = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getContext(), qq);
            if (TbFaceManager.atJ().qN(str) != null) {
                int width = (int) (qN.getWidth() * 0.6d);
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.ieJ.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return this.ieJ;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean caJ() {
        return false;
    }
}
