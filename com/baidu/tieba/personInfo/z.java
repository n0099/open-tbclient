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
    private View HS;
    private View aFZ;
    private PersonInfoActivity bEE;
    private LinearLayout bGn;
    private LinearLayout bGo;
    private TextView bGp;
    private TextView bGq;
    private boolean mIsHost;

    public z(PersonInfoActivity personInfoActivity, boolean z) {
        this.bEE = personInfoActivity;
        this.mIsHost = z;
        this.HS = com.baidu.adp.lib.g.b.ek().inflate(this.bEE, com.baidu.tieba.w.sign_reply_view, null);
        nu();
    }

    private void nu() {
        this.aFZ = this.HS.findViewById(com.baidu.tieba.v.root);
        this.bGn = (LinearLayout) this.HS.findViewById(com.baidu.tieba.v.reply_ll);
        this.bGo = (LinearLayout) this.HS.findViewById(com.baidu.tieba.v.sign_ll);
        this.bGp = (TextView) this.HS.findViewById(com.baidu.tieba.v.sign_tip);
        this.bGq = (TextView) this.HS.findViewById(com.baidu.tieba.v.sign_text);
        pS();
    }

    public void pS() {
        aw.i(this.aFZ, com.baidu.tieba.s.cp_bg_line_c);
        aw.i(this.bGn, com.baidu.tieba.s.cp_bg_line_d);
        aw.i(this.bGo, com.baidu.tieba.s.cp_bg_line_d);
        aw.b(this.bGp, com.baidu.tieba.s.cp_cont_d, 1);
    }

    public void Hu() {
        v aap = this.bEE.aap();
        UserData userData = aap.getUserData();
        e(aap.aaS(), userData);
        i(userData);
    }

    public void i(UserData userData) {
        if (userData != null) {
            String intro = userData.getIntro();
            if (!TextUtils.isEmpty(intro)) {
                this.bGq.setText(intro);
                aw.b(this.bGq, com.baidu.tieba.s.cp_cont_b, 1);
                return;
            }
            this.bGq.setText(com.baidu.tieba.y.no_person_sign);
            aw.b(this.bGq, com.baidu.tieba.s.cp_cont_e, 1);
        }
    }

    public void e(PersonTainInfo personTainInfo, UserData userData) {
        List<ReplyInfo> replyInfo;
        this.bGn.removeAllViews();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bGn.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.bGn.setLayoutParams(layoutParams);
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
                    View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.bEE, com.baidu.tieba.w.apply_message, null);
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
                        textView.setText(String.valueOf(this.bEE.getResources().getString(com.baidu.tieba.y.me)) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    }
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.leftMargin = this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30);
                    layoutParams2.rightMargin = this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30);
                    this.bGn.addView(inflate, layoutParams2);
                }
            }
            View inflate2 = com.baidu.adp.lib.g.b.ek().inflate(this.bEE, com.baidu.tieba.w.personinfo_reply_btn, null);
            TextView textView3 = (TextView) inflate2.findViewById(com.baidu.tieba.v.reply_btn);
            aw.h((View) textView3, com.baidu.tieba.u.btn_pop_news);
            aw.b(textView3, com.baidu.tieba.s.cp_cont_b, 1);
            textView3.setOnClickListener(new aa(this, userData));
            this.bGn.addView(inflate2);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bGn.getLayoutParams();
            layoutParams3.bottomMargin = this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds20);
            this.bGn.setLayoutParams(layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(UserData userData) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.bEE, com.baidu.tieba.w.reply_dialog, null);
        EditText editText = (EditText) inflate.findViewById(com.baidu.tieba.v.reply_message);
        aw.h((View) editText, com.baidu.tieba.u.bg_live_compile);
        aw.b(editText, com.baidu.tieba.s.cp_cont_b, 2);
        editText.setPadding(this.bEE.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds16), 0, 0, 0);
        editText.setFocusable(true);
        editText.requestFocus();
        new Handler().postDelayed(new ab(this, editText), 100L);
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bEE);
        aVar.bf(this.bEE.getResources().getString(com.baidu.tieba.y.add_reply));
        aVar.b(this.bEE.getResources().getString(com.baidu.tieba.y.delete_account_cancle), new ac(this));
        aVar.a(this.bEE.getResources().getString(com.baidu.tieba.y.reply_message), new ad(this, editText, userData));
        aVar.j(inflate);
        aVar.kT().kW();
    }

    public View getRootView() {
        return this.HS;
    }
}
