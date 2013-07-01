package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z f1079a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.f1079a = zVar;
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
        context = this.f1079a.f118a;
        SpannableString spannableString = new SpannableString(context.getString(R.string.image_quality_high_menu));
        context2 = this.f1079a.f118a;
        spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.util.ab.a(context2, 16.0f)), 1, spannableString.length(), 18);
        context3 = this.f1079a.f118a;
        SpannableString spannableString2 = new SpannableString(context3.getString(R.string.image_quality_low_menu));
        context4 = this.f1079a.f118a;
        spannableString2.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.util.ab.a(context4, 16.0f)), 1, spannableString2.length(), 18);
        context5 = this.f1079a.f118a;
        CharSequence[] charSequenceArr = {spannableString, context5.getString(R.string.image_quality_mid_menu), spannableString2};
        z zVar = this.f1079a;
        context6 = this.f1079a.f118a;
        zVar.K = new AlertDialog.Builder(context6).setTitle(R.string.upload_image_quality).setItems(charSequenceArr, new ab(this)).create();
        alertDialog = this.f1079a.K;
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog2 = this.f1079a.K;
        alertDialog2.show();
    }
}
