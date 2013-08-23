package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aa f1432a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.f1432a = aaVar;
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
        if (TiebaApplication.g().aR()) {
            context7 = this.f1432a.f347a;
            UtilHelper.a(context7, (int) R.string.image_quality_cant_set);
            return;
        }
        context = this.f1432a.f347a;
        SpannableString spannableString = new SpannableString(context.getString(R.string.image_quality_high_menu));
        context2 = this.f1432a.f347a;
        spannableString.setSpan(new AbsoluteSizeSpan(UtilHelper.a(context2, 16.0f)), 1, spannableString.length(), 18);
        context3 = this.f1432a.f347a;
        SpannableString spannableString2 = new SpannableString(context3.getString(R.string.image_quality_low_menu));
        context4 = this.f1432a.f347a;
        spannableString2.setSpan(new AbsoluteSizeSpan(UtilHelper.a(context4, 16.0f)), 1, spannableString2.length(), 18);
        context5 = this.f1432a.f347a;
        CharSequence[] charSequenceArr = {spannableString, context5.getString(R.string.image_quality_mid_menu), spannableString2};
        aa aaVar = this.f1432a;
        context6 = this.f1432a.f347a;
        aaVar.M = new AlertDialog.Builder(context6).setTitle(R.string.upload_image_quality).setItems(charSequenceArr, new ac(this)).create();
        alertDialog = this.f1432a.M;
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog2 = this.f1432a.M;
        alertDialog2.show();
    }
}
