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
    private ExcContent hVw;
    private SpannableString hVx;

    public a(ExcContent excContent) {
        this.hVw = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence bWO() {
        return b(this.hVw);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int pO;
        a.C0253a ql;
        if (this.hVx == null && (pO = TbFaceManager.aso().pO((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.aso().pQ(str) + ")";
            this.hVx = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.b bVar = new com.baidu.tbadk.widget.richText.b(TbadkCoreApplication.getInst().getContext(), pO);
            if (TbFaceManager.aso().ql(str) != null) {
                int width = (int) (ql.getWidth() * 0.6d);
                bVar.setBounds(new Rect(0, 0, width, width));
            } else {
                bVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.hVx.setSpan(new ImageSpan(bVar, 0), 0, str2.length(), 33);
        }
        return this.hVx;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean bWP() {
        return false;
    }
}
