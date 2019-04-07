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
    private ExcContent hDr;
    private SpannableString hDs;

    public a(ExcContent excContent) {
        this.hDr = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bOR() {
        return b(this.hDr);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int oH;
        a.C0238a pe;
        if (this.hDs == null && (oH = TbFaceManager.anl().oH((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.anl().oJ(str) + ")";
            this.hDs = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getContext(), oH);
            if (TbFaceManager.anl().pe(str) != null) {
                int width = (int) (pe.getWidth() * 0.6d);
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.hDs.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return this.hDs;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bOS() {
        return false;
    }
}
