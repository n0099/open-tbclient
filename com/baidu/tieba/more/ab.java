package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.am;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f1395a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.f1395a = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        Context context7;
        if (TiebaApplication.f().bb()) {
            context7 = this.f1395a.f343a;
            am.a(context7, (int) R.string.image_quality_cant_set);
            return;
        }
        context = this.f1395a.f343a;
        SpannableString spannableString = new SpannableString(context.getString(R.string.image_quality_high_menu));
        context2 = this.f1395a.f343a;
        spannableString.setSpan(new AbsoluteSizeSpan(am.a(context2, 16.0f)), 1, spannableString.length(), 18);
        context3 = this.f1395a.f343a;
        SpannableString spannableString2 = new SpannableString(context3.getString(R.string.image_quality_low_menu));
        context4 = this.f1395a.f343a;
        spannableString2.setSpan(new AbsoluteSizeSpan(am.a(context4, 16.0f)), 1, spannableString2.length(), 18);
        context5 = this.f1395a.f343a;
        CharSequence[] charSequenceArr = {spannableString, context5.getString(R.string.image_quality_mid_menu), spannableString2};
        aa aaVar = this.f1395a;
        context6 = this.f1395a.f343a;
        aaVar.M = new AlertDialog.Builder(context6).setTitle(R.string.upload_image_quality).setItems(charSequenceArr, new ac(this)).create();
        alertDialog = this.f1395a.M;
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog2 = this.f1395a.M;
        alertDialog2.show();
    }
}
