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
    private ExcContent hDF;
    private SpannableString hDG;

    public a(ExcContent excContent) {
        this.hDF = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bOU() {
        return b(this.hDF);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int oG;
        a.C0238a pd;
        if (this.hDG == null && (oG = TbFaceManager.ano().oG((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.ano().oI(str) + ")";
            this.hDG = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getContext(), oG);
            if (TbFaceManager.ano().pd(str) != null) {
                int width = (int) (pd.getWidth() * 0.6d);
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.hDG.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return this.hDG;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bOV() {
        return false;
    }
}
