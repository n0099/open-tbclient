package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ MoreActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(MoreActivity moreActivity) {
        this.a = moreActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        AlertDialog alertDialog4;
        AlertDialog alertDialog5;
        AlertDialog alertDialog6;
        AlertDialog alertDialog7;
        AlertDialog alertDialog8;
        AlertDialog alertDialog9;
        AlertDialog alertDialog10;
        ag agVar;
        ag agVar2;
        switch (view.getId()) {
            case R.id.account_manager /* 2131231067 */:
                String u = TiebaApplication.u();
                if ((u == null || u.length() <= 0) && com.baidu.tieba.c.k.k() <= 0) {
                    LoginActivity.a(this.a, "goto_more", this.a.getString(R.string.login_manage_account), 1100003);
                    return;
                } else {
                    AccountActivity.a(this.a);
                    return;
                }
            case R.id.account_name /* 2131231068 */:
            case R.id.arrow /* 2131231069 */:
            case R.id.frequency_time /* 2131231071 */:
            case R.id.browse_setting_text /* 2131231073 */:
            case R.id.abstract_state_on /* 2131231075 */:
            case R.id.eyeshield_mode_text /* 2131231077 */:
            case R.id.eyeshield_mode_on /* 2131231078 */:
            case R.id.text_upload_image_quality /* 2131231080 */:
            case R.id.promoted_message_textview /* 2131231083 */:
            case R.id.share_location_on /* 2131231085 */:
            default:
                return;
            case R.id.msg_remind /* 2131231070 */:
                String u2 = TiebaApplication.u();
                if (u2 == null || u2.length() <= 0) {
                    LoginActivity.a(this.a, "goto_more", this.a.getString(R.string.login_to_use), 1100003);
                    return;
                } else {
                    MsgRemindActivity.a(this.a);
                    return;
                }
            case R.id.browse_setting /* 2131231072 */:
                BrowseSettingActivity.a(this.a);
                return;
            case R.id.abstract_selection /* 2131231074 */:
                alertDialog4 = this.a.A;
                if (alertDialog4 == null) {
                    this.a.A = new AlertDialog.Builder(this.a).setTitle(R.string.abstract_state).setItems(R.array.menu_view_images, new ab(this)).create();
                }
                alertDialog5 = this.a.A;
                alertDialog5.setCanceledOnTouchOutside(true);
                alertDialog6 = this.a.A;
                alertDialog6.show();
                return;
            case R.id.eyeshield_mode /* 2131231076 */:
                this.a.j();
                new com.baidu.tieba.account.ak("eyeshield").start();
                return;
            case R.id.upload_image_quality /* 2131231079 */:
                SpannableString spannableString = new SpannableString(this.a.getString(R.string.image_quality_high_menu));
                spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.c.ag.a((Context) this.a, 16.0f)), 1, spannableString.length(), 18);
                SpannableString spannableString2 = new SpannableString(this.a.getString(R.string.image_quality_low_menu));
                spannableString2.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.c.ag.a((Context) this.a, 16.0f)), 1, spannableString2.length(), 18);
                this.a.x = new AlertDialog.Builder(this.a).setTitle(R.string.upload_image_quality).setItems(new CharSequence[]{spannableString, this.a.getString(R.string.image_quality_mid_menu), spannableString2}, new z(this)).create();
                alertDialog9 = this.a.x;
                alertDialog9.setCanceledOnTouchOutside(true);
                alertDialog10 = this.a.x;
                alertDialog10.show();
                return;
            case R.id.recommend_app /* 2131231081 */:
                AppsActivity.a(this.a, "http://c.tieba.baidu.com/c/s/apprecommend");
                return;
            case R.id.promoted_message /* 2131231082 */:
                this.a.B = new AlertDialog.Builder(this.a).setTitle(R.string.promoted_message_text).setItems(R.array.menu_remind_tone, new aa(this)).create();
                alertDialog7 = this.a.B;
                alertDialog7.setCanceledOnTouchOutside(true);
                alertDialog8 = this.a.B;
                alertDialog8.show();
                return;
            case R.id.share_location_layout /* 2131231084 */:
                alertDialog = this.a.h;
                if (alertDialog == null) {
                    this.a.h = new AlertDialog.Builder(this.a).setTitle(R.string.share_location).setItems(R.array.menu_on_off, new ac(this)).create();
                }
                alertDialog2 = this.a.h;
                alertDialog2.setCanceledOnTouchOutside(true);
                alertDialog3 = this.a.h;
                alertDialog3.show();
                return;
            case R.id.position_paper /* 2131231086 */:
                this.a.l();
                return;
            case R.id.clear_cash /* 2131231087 */:
                agVar = this.a.w;
                if (agVar == null) {
                    this.a.w = new ag(this.a, null);
                    agVar2 = this.a.w;
                    agVar2.execute(new String[0]);
                    return;
                }
                return;
            case R.id.about_bieta /* 2131231088 */:
                AboutActivity.a(this.a);
                return;
        }
    }
}
