package com.baidu.tieba.pb.b.a;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.imageManager.a;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes10.dex */
public class a implements c {
    private ExcContent kbx;
    private SpannableString kby;

    public a(ExcContent excContent) {
        this.kbx = excContent;
    }

    @Override // com.baidu.tieba.pb.b.a.d
    public int getType() {
        return 2;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public CharSequence cKu() {
        return b(this.kbx);
    }

    private SpannableString b(ExcContent excContent) {
        String str;
        int xY;
        a.C0490a ys;
        if (this.kby == null && (xY = TbFaceManager.bet().xY((str = excContent.text))) != 0) {
            String str2 = "#(" + TbFaceManager.bet().ya(str) + ")";
            this.kby = new SpannableString(str2 + " ");
            com.baidu.tbadk.widget.richText.d dVar = new com.baidu.tbadk.widget.richText.d(TbadkCoreApplication.getInst().getContext(), xY);
            if (TbFaceManager.bet().ys(str) != null) {
                int width = (int) (ys.getWidth() * 0.6d);
                dVar.setBounds(new Rect(0, 0, width, width));
            } else {
                dVar.setBounds(new Rect(0, 0, 0, 0));
            }
            this.kby.setSpan(new ImageSpan(dVar, 0), 0, str2.length(), 33);
        }
        return this.kby;
    }

    @Override // com.baidu.tieba.pb.b.a.c
    public boolean cKv() {
        return false;
    }
}
