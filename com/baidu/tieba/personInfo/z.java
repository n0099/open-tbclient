package com.baidu.tieba.personInfo;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ay;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class z {
    private View aYi;
    private int ajy = -1;
    private PersonInfoActivity bVf;
    private LinearLayout bWM;
    private LinearLayout bWN;
    private TextView bWO;
    private TextView bWP;
    private boolean mIsHost;
    private View mRootView;

    public z(PersonInfoActivity personInfoActivity, boolean z) {
        this.bVf = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.hr().inflate(this.bVf.getPageContext().getPageActivity(), com.baidu.tieba.r.sign_reply_view, null);
        initView();
    }

    private void initView() {
        this.aYi = this.mRootView.findViewById(com.baidu.tieba.q.root);
        this.bWM = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.q.reply_ll);
        this.bWN = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.q.sign_ll);
        this.bWO = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.sign_tip);
        this.bWP = (TextView) this.mRootView.findViewById(com.baidu.tieba.q.sign_text);
        oG();
    }

    public void oG() {
        if (this.ajy != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.ajy = TbadkCoreApplication.m411getInst().getSkinType();
            ay.j(this.aYi, com.baidu.tieba.n.cp_bg_line_c);
            ay.j(this.bWM, com.baidu.tieba.n.cp_bg_line_d);
            ay.j(this.bWN, com.baidu.tieba.n.cp_bg_line_d);
            ay.b(this.bWO, com.baidu.tieba.n.cp_cont_d, 1);
        }
    }

    public void afl() {
        v aeT = this.bVf.aeT();
        UserData userData = aeT.getUserData();
        e(aeT.afx(), userData);
        l(userData);
        oG();
    }

    public void l(UserData userData) {
        if (userData != null) {
            String intro = userData.getIntro();
            if (!TextUtils.isEmpty(intro)) {
                this.bWP.setText(intro);
                ay.b(this.bWP, com.baidu.tieba.n.cp_cont_b, 1);
                return;
            }
            this.bWP.setText(com.baidu.tieba.t.no_person_sign);
            ay.b(this.bWP, com.baidu.tieba.n.cp_cont_e, 1);
        }
    }

    public void e(PersonTainInfo personTainInfo, UserData userData) {
        List<ReplyInfo> replyInfo;
        this.bWM.removeAllViews();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bWM.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.bWM.setLayoutParams(layoutParams);
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
                    View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.bVf.getPageContext().getPageActivity(), com.baidu.tieba.r.apply_message, null);
                    View findViewById = inflate.findViewById(com.baidu.tieba.q.line);
                    TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.q.apply_name);
                    TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.q.apply_info);
                    ay.b(textView, com.baidu.tieba.n.cp_cont_d, 1);
                    ay.b(textView2, com.baidu.tieba.n.cp_cont_b, 1);
                    ay.j(findViewById, com.baidu.tieba.n.cp_bg_line_b);
                    if (((ReplyInfo) arrayList.get(i3)).getUserId() == userData.getUserIdLong()) {
                        textView.setText(String.valueOf(userData.getName_show()) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    } else {
                        textView.setText(String.valueOf(this.bVf.getResources().getString(com.baidu.tieba.t.me)) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    }
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.leftMargin = this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds30);
                    layoutParams2.rightMargin = this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds30);
                    this.bWM.addView(inflate, layoutParams2);
                }
            }
            View inflate2 = com.baidu.adp.lib.g.b.hr().inflate(this.bVf.getPageContext().getPageActivity(), com.baidu.tieba.r.personinfo_reply_btn, null);
            TextView textView3 = (TextView) inflate2.findViewById(com.baidu.tieba.q.reply_btn);
            ay.i((View) textView3, com.baidu.tieba.p.btn_pop_news);
            ay.b(textView3, com.baidu.tieba.n.cp_cont_b, 1);
            textView3.setOnClickListener(new aa(this, userData));
            this.bWM.addView(inflate2);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bWM.getLayoutParams();
            layoutParams3.bottomMargin = this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds20);
            this.bWM.setLayoutParams(layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(UserData userData) {
        View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.bVf.getPageContext().getPageActivity(), com.baidu.tieba.r.reply_dialog, null);
        ay.b((TextView) inflate.findViewById(com.baidu.tieba.q.text_replay), com.baidu.tieba.n.cp_cont_b, 1);
        EditText editText = (EditText) inflate.findViewById(com.baidu.tieba.q.reply_message);
        ay.i((View) editText, com.baidu.tieba.p.blue_rectangle_input_bg);
        ay.b(editText, com.baidu.tieba.n.cp_cont_b, 2);
        editText.setPadding(this.bVf.getResources().getDimensionPixelSize(com.baidu.tieba.o.ds16), 0, 0, 0);
        editText.requestFocus();
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bVf.getPageContext().getPageActivity());
        aVar.b(this.bVf.getResources().getString(com.baidu.tieba.t.delete_account_cancle), new ab(this));
        aVar.a(this.bVf.getResources().getString(com.baidu.tieba.t.reply_message), new ac(this, editText, userData));
        aVar.l(inflate);
        aVar.b(this.bVf.getPageContext()).rL();
        this.bVf.ShowSoftKeyPadDelay(editText, 200);
    }

    public View getRootView() {
        return this.mRootView;
    }
}
