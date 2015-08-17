package com.baidu.tieba.pb.c.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.FinePbPage.Content;
/* loaded from: classes.dex */
public class a implements c {
    private Content cha;
    private SpannableString chb;

    public a(Content content) {
        this.cha = content;
    }

    @Override // com.baidu.tieba.pb.c.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public CharSequence afA() {
        return b(this.cha);
    }

    private SpannableString b(Content content) {
        String str;
        int ez;
        a.C0049a eX;
        if (this.chb == null && (ez = TbFaceManager.Cd().ez((str = content.text))) != 0) {
            String str2 = "#(" + TbFaceManager.Cd().eB(str) + ")";
            this.chb = new SpannableString(String.valueOf(str2) + " ");
            com.baidu.tbadk.widget.richText.e eVar = new com.baidu.tbadk.widget.richText.e(TbadkCoreApplication.m411getInst().getContext(), ez);
            if (TbFaceManager.Cd().eX(str) != null) {
                int width = (int) (eX.getWidth() * 0.6d);
                eVar.setBounds(new Rect(0, 0, width, width));
            } else {
                eVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.chb.setSpan(new ImageSpan(eVar, 0), 0, str2.length(), 33);
        }
        return this.chb;
    }

    @Override // com.baidu.tieba.pb.c.a.c
    public boolean afB() {
        return false;
    }
}
