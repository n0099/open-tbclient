package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ MoreActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(MoreActivity moreActivity) {
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
        String str;
        af afVar;
        af afVar2;
        switch (view.getId()) {
            case R.id.account_manager /* 2131231155 */:
                String y = TiebaApplication.y();
                if ((y == null || y.length() <= 0) && com.baidu.tieba.c.k.l() <= 0) {
                    LoginActivity.a(this.a, "goto_more", this.a.getString(R.string.login_manage_account), 1100003);
                    return;
                } else {
                    AccountActivity.a(this.a);
                    return;
                }
            case R.id.account_name /* 2131231156 */:
            case R.id.arrow /* 2131231157 */:
            case R.id.msg_remind_text /* 2131231159 */:
            case R.id.frequency_time /* 2131231160 */:
            case R.id.browse_setting_text /* 2131231162 */:
            case R.id.abstract_state_on /* 2131231164 */:
            case R.id.eyeshield_mode_text /* 2131231166 */:
            case R.id.skin_type_on /* 2131231167 */:
            case R.id.image_quality_text /* 2131231169 */:
            case R.id.text_upload_image_quality /* 2131231170 */:
            case R.id.recommend_app_text /* 2131231172 */:
            case R.id.promoted_message_text /* 2131231174 */:
            case R.id.promoted_message_textview /* 2131231175 */:
            case R.id.share_location_text /* 2131231177 */:
            case R.id.share_location_on /* 2131231178 */:
            case R.id.position_paper_text /* 2131231180 */:
            case R.id.clear_cash_text /* 2131231182 */:
            default:
                return;
            case R.id.msg_remind /* 2131231158 */:
                String y2 = TiebaApplication.y();
                if (y2 == null || y2.length() <= 0) {
                    LoginActivity.a(this.a, "goto_more", this.a.getString(R.string.login_to_use), 1100003);
                    return;
                } else {
                    MsgRemindActivity.a(this.a);
                    return;
                }
            case R.id.browse_setting /* 2131231161 */:
                BrowseSettingActivity.a(this.a);
                return;
            case R.id.abstract_selection /* 2131231163 */:
                alertDialog4 = this.a.O;
                if (alertDialog4 == null) {
                    this.a.O = new AlertDialog.Builder(this.a).setTitle(R.string.abstract_state).setItems(R.array.menu_view_images, new ac(this)).create();
                }
                alertDialog5 = this.a.O;
                alertDialog5.setCanceledOnTouchOutside(true);
                alertDialog6 = this.a.O;
                alertDialog6.show();
                return;
            case R.id.eyeshield_mode /* 2131231165 */:
                this.a.l();
                return;
            case R.id.upload_image_quality /* 2131231168 */:
                SpannableString spannableString = new SpannableString(this.a.getString(R.string.image_quality_high_menu));
                spannableString.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.c.ai.a(this.a, 16.0f)), 1, spannableString.length(), 18);
                SpannableString spannableString2 = new SpannableString(this.a.getString(R.string.image_quality_low_menu));
                spannableString2.setSpan(new AbsoluteSizeSpan(com.baidu.tieba.c.ai.a(this.a, 16.0f)), 1, spannableString2.length(), 18);
                this.a.M = new AlertDialog.Builder(this.a).setTitle(R.string.upload_image_quality).setItems(new CharSequence[]{spannableString, this.a.getString(R.string.image_quality_mid_menu), spannableString2}, new aa(this)).create();
                alertDialog9 = this.a.M;
                alertDialog9.setCanceledOnTouchOutside(true);
                alertDialog10 = this.a.M;
                alertDialog10.show();
                return;
            case R.id.recommend_app /* 2131231171 */:
                String str2 = "http://c.tieba.baidu.com/c/s/apprecommend";
                if ("http://c.tieba.baidu.com/c/s/apprecommend".indexOf("?") >= 0) {
                    if (!"http://c.tieba.baidu.com/c/s/apprecommend".endsWith("?") && !"http://c.tieba.baidu.com/c/s/apprecommend".endsWith("&")) {
                        str2 = String.valueOf("http://c.tieba.baidu.com/c/s/apprecommend") + "&";
                    }
                } else {
                    str2 = String.valueOf("http://c.tieba.baidu.com/c/s/apprecommend") + "?";
                }
                if (TiebaApplication.b().ah() == 1) {
                    str = String.valueOf(str2) + "night_type=1";
                } else {
                    str = String.valueOf(str2) + "night_type=0";
                }
                AppsActivity.a(this.a, str);
                return;
            case R.id.promoted_message /* 2131231173 */:
                this.a.P = new AlertDialog.Builder(this.a).setTitle(R.string.promoted_message_text).setItems(R.array.menu_recommend_push, new ab(this)).create();
                alertDialog7 = this.a.P;
                alertDialog7.setCanceledOnTouchOutside(true);
                alertDialog8 = this.a.P;
                alertDialog8.show();
                return;
            case R.id.share_location_layout /* 2131231176 */:
                alertDialog = this.a.l;
                if (alertDialog == null) {
                    this.a.l = new AlertDialog.Builder(this.a).setTitle(R.string.share_location).setItems(R.array.menu_on_off, new ad(this)).create();
                }
                alertDialog2 = this.a.l;
                alertDialog2.setCanceledOnTouchOutside(true);
                alertDialog3 = this.a.l;
                alertDialog3.show();
                return;
            case R.id.position_paper /* 2131231179 */:
                this.a.n();
                return;
            case R.id.clear_cash /* 2131231181 */:
                afVar = this.a.L;
                if (afVar == null) {
                    this.a.L = new af(this.a, null);
                    afVar2 = this.a.L;
                    afVar2.execute(new String[0]);
                    return;
                }
                return;
            case R.id.about_tieba /* 2131231183 */:
                AboutActivity.a(this.a);
                return;
        }
    }
}
