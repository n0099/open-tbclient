package com.baidu.tieba.personInfo;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ba;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class z {
    private View aVn;
    private int aiq = -1;
    private PersonInfoActivity bSi;
    private LinearLayout bTP;
    private LinearLayout bTQ;
    private TextView bTR;
    private TextView bTS;
    private boolean mIsHost;
    private View mRootView;

    public z(PersonInfoActivity personInfoActivity, boolean z) {
        this.bSi = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.hH().inflate(this.bSi.getPageContext().getPageActivity(), com.baidu.tieba.w.sign_reply_view, null);
        initView();
    }

    private void initView() {
        this.aVn = this.mRootView.findViewById(com.baidu.tieba.v.root);
        this.bTP = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.v.reply_ll);
        this.bTQ = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.v.sign_ll);
        this.bTR = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.sign_tip);
        this.bTS = (TextView) this.mRootView.findViewById(com.baidu.tieba.v.sign_text);
        oq();
    }

    public void oq() {
        if (this.aiq != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.aiq = TbadkCoreApplication.m411getInst().getSkinType();
            ba.j(this.aVn, com.baidu.tieba.s.cp_bg_line_c);
            ba.j(this.bTP, com.baidu.tieba.s.cp_bg_line_d);
            ba.j(this.bTQ, com.baidu.tieba.s.cp_bg_line_d);
            ba.b(this.bTR, com.baidu.tieba.s.cp_cont_d, 1);
        }
    }

    public void adR() {
        v ady = this.bSi.ady();
        UserData userData = ady.getUserData();
        e(ady.aed(), userData);
        l(userData);
        oq();
    }

    public void l(UserData userData) {
        if (userData != null) {
            String intro = userData.getIntro();
            if (!TextUtils.isEmpty(intro)) {
                this.bTS.setText(intro);
                ba.b(this.bTS, com.baidu.tieba.s.cp_cont_b, 1);
                return;
            }
            this.bTS.setText(com.baidu.tieba.y.no_person_sign);
            ba.b(this.bTS, com.baidu.tieba.s.cp_cont_e, 1);
        }
    }

    public void e(PersonTainInfo personTainInfo, UserData userData) {
        List<ReplyInfo> replyInfo;
        this.bTP.removeAllViews();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTP.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.bTP.setLayoutParams(layoutParams);
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
                    View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.bSi.getPageContext().getPageActivity(), com.baidu.tieba.w.apply_message, null);
                    View findViewById = inflate.findViewById(com.baidu.tieba.v.line);
                    TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.apply_name);
                    TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.v.apply_info);
                    ba.b(textView, com.baidu.tieba.s.cp_cont_d, 1);
                    ba.b(textView2, com.baidu.tieba.s.cp_cont_b, 1);
                    ba.j(findViewById, com.baidu.tieba.s.cp_bg_line_b);
                    if (((ReplyInfo) arrayList.get(i3)).getUserId() == userData.getUserIdLong()) {
                        textView.setText(String.valueOf(userData.getName_show()) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    } else {
                        textView.setText(String.valueOf(this.bSi.getResources().getString(com.baidu.tieba.y.me)) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    }
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.leftMargin = this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30);
                    layoutParams2.rightMargin = this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30);
                    this.bTP.addView(inflate, layoutParams2);
                }
            }
            View inflate2 = com.baidu.adp.lib.g.b.hH().inflate(this.bSi.getPageContext().getPageActivity(), com.baidu.tieba.w.personinfo_reply_btn, null);
            TextView textView3 = (TextView) inflate2.findViewById(com.baidu.tieba.v.reply_btn);
            ba.i((View) textView3, com.baidu.tieba.u.btn_pop_news);
            ba.b(textView3, com.baidu.tieba.s.cp_cont_b, 1);
            textView3.setOnClickListener(new aa(this, userData));
            this.bTP.addView(inflate2);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bTP.getLayoutParams();
            layoutParams3.bottomMargin = this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds20);
            this.bTP.setLayoutParams(layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(UserData userData) {
        View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.bSi.getPageContext().getPageActivity(), com.baidu.tieba.w.reply_dialog, null);
        EditText editText = (EditText) inflate.findViewById(com.baidu.tieba.v.reply_message);
        ba.i((View) editText, com.baidu.tieba.u.bg_live_compile);
        ba.b(editText, com.baidu.tieba.s.cp_cont_b, 2);
        editText.setPadding(this.bSi.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds16), 0, 0, 0);
        editText.setFocusable(true);
        editText.requestFocus();
        new Handler().postDelayed(new ab(this, editText), 100L);
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bSi.getPageContext().getPageActivity());
        aVar.bZ(this.bSi.getResources().getString(com.baidu.tieba.y.add_reply));
        aVar.b(this.bSi.getResources().getString(com.baidu.tieba.y.delete_account_cancle), new ac(this));
        aVar.a(this.bSi.getResources().getString(com.baidu.tieba.y.reply_message), new ad(this, editText, userData));
        aVar.j(inflate);
        aVar.b(this.bSi.getPageContext()).re();
    }

    public View getRootView() {
        return this.mRootView;
    }
}
