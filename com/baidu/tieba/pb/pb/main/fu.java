package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.text.Html;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fu implements Html.ImageGetter {
    final /* synthetic */ ft est;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fu(ft ftVar) {
        this.est = ftVar;
    }

    @Override // android.text.Html.ImageGetter
    public Drawable getDrawable(String str) {
        int parseInt = Integer.parseInt(str);
        Drawable drawable = TbadkCoreApplication.m9getInst().getResources().getDrawable(w.g.praise_01);
        try {
            drawable = TbadkCoreApplication.m9getInst().getResources().getDrawable(parseInt);
        } catch (Exception e) {
        }
        drawable.setBounds(0, 0, com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds36), com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds36));
        return drawable;
    }
}
