package com.baidu.tieba.personInfo;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.aw;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class z {
    private View HT;
    private View aGj;
    private PersonInfoActivity bES;
    private LinearLayout bGB;
    private LinearLayout bGC;
    private TextView bGD;
    private TextView bGE;
    private boolean mIsHost;

    public z(PersonInfoActivity personInfoActivity, boolean z) {
        this.bES = personInfoActivity;
        this.mIsHost = z;
        this.HT = com.baidu.adp.lib.g.b.ek().inflate(this.bES, com.baidu.tieba.w.sign_reply_view, null);
        nu();
    }

    private void nu() {
        this.aGj = this.HT.findViewById(com.baidu.tieba.v.root);
        this.bGB = (LinearLayout) this.HT.findViewById(com.baidu.tieba.v.reply_ll);
        this.bGC = (LinearLayout) this.HT.findViewById(com.baidu.tieba.v.sign_ll);
        this.bGD = (TextView) this.HT.findViewById(com.baidu.tieba.v.sign_tip);
        this.bGE = (TextView) this.HT.findViewById(com.baidu.tieba.v.sign_text);
        pU();
    }

    public void pU() {
        aw.i(this.aGj, com.baidu.tieba.s.cp_bg_line_c);
        aw.i(this.bGB, com.baidu.tieba.s.cp_bg_line_d);
        aw.i(this.bGC, com.baidu.tieba.s.cp_bg_line_d);
        aw.b(this.bGD, com.baidu.tieba.s.cp_cont_d, 1);
    }

    public void aaJ() {
        v aar = this.bES.aar();
        UserData userData = aar.getUserData();
        e(aar.aaV(), userData);
        i(userData);
    }

    public void i(UserData userData) {
        if (userData != null) {
            String intro = userData.getIntro();
            if (!TextUtils.isEmpty(intro)) {
                this.bGE.setText(intro);
                aw.b(this.bGE, com.baidu.tieba.s.cp_cont_b, 1);
                return;
            }
            this.bGE.setText(com.baidu.tieba.y.no_person_sign);
            aw.b(this.bGE, com.baidu.tieba.s.cp_cont_e, 1);
        }
    }

    public void e(PersonTainInfo personTainInfo, UserData userData) {
        List<ReplyInfo> replyInfo;
        this.bGB.removeAllViews();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGB.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.bGB.setLayoutParams(layoutParams);
        if (!this.mIsHost && personTainInfo != null && personTainInfo.getIsFriend() != 1 && userData != null && (replyInfo = personTainInfo.getReplyInfo()) != null && replyInfo.size() > 0) {
            int size = replyInfo.size();
            ArrayList arrayList = new ArrayList();
            if (size > 6) {
                int i = size - 1;
                while (true) {
                    int i2 = i;
                    if (i2 <= size - 7) {
                        break;
                    }
                    arrayList.add(0, replyInfo.get(i2));
                    i = i2 - 1;
                }
            } else {
                arrayList.addAll(replyInfo);
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (((ReplyInfo) arrayList.get(i3)) != null) {
                    View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.bES, com.baidu.tieba.w.apply_message, null);
                    View findViewById = inflate.findViewById(com.baidu.tieba.v.line);
                    TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.apply_name);
                    TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.v.apply_info);
                    aw.b(textView, com.baidu.tieba.s.cp_cont_d, 1);
                    aw.b(textView2, com.baidu.tieba.s.cp_cont_b, 1);
                    aw.i(findViewById, com.baidu.tieba.s.cp_bg_line_b);
                    if (((ReplyInfo) arrayList.get(i3)).getUserId() == userData.getUserIdLong()) {
                        textView.setText(String.valueOf(userData.getName_show()) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    } else {
                        textView.setText(String.valueOf(this.bES.getResources().getString(com.baidu.tieba.y.me)) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    }
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.leftMargin = this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30);
                    layoutParams2.rightMargin = this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30);
                    this.bGB.addView(inflate, layoutParams2);
                }
            }
            View inflate2 = com.baidu.adp.lib.g.b.ek().inflate(this.bES, com.baidu.tieba.w.personinfo_reply_btn, null);
            TextView textView3 = (TextView) inflate2.findViewById(com.baidu.tieba.v.reply_btn);
            aw.h((View) textView3, com.baidu.tieba.u.btn_pop_news);
            aw.b(textView3, com.baidu.tieba.s.cp_cont_b, 1);
            textView3.setOnClickListener(new aa(this, userData));
            this.bGB.addView(inflate2);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bGB.getLayoutParams();
            layoutParams3.bottomMargin = this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds20);
            this.bGB.setLayoutParams(layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(UserData userData) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.bES, com.baidu.tieba.w.reply_dialog, null);
        EditText editText = (EditText) inflate.findViewById(com.baidu.tieba.v.reply_message);
        aw.h((View) editText, com.baidu.tieba.u.bg_live_compile);
        aw.b(editText, com.baidu.tieba.s.cp_cont_b, 2);
        editText.setPadding(this.bES.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds16), 0, 0, 0);
        editText.setFocusable(true);
        editText.requestFocus();
        new Handler().postDelayed(new ab(this, editText), 100L);
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bES);
        aVar.bf(this.bES.getResources().getString(com.baidu.tieba.y.add_reply));
        aVar.b(this.bES.getResources().getString(com.baidu.tieba.y.delete_account_cancle), new ac(this));
        aVar.a(this.bES.getResources().getString(com.baidu.tieba.y.reply_message), new ad(this, editText, userData));
        aVar.j(inflate);
        aVar.kT().kW();
    }

    public View getRootView() {
        return this.HT;
    }
}
