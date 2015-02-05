package com.baidu.tieba.personInfo;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bc;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class z {
    private View aOl;
    private PersonInfoActivity bJY;
    private LinearLayout bLF;
    private LinearLayout bLG;
    private TextView bLH;
    private TextView bLI;
    private boolean mIsHost;
    private View mRootView;

    public z(PersonInfoActivity personInfoActivity, boolean z) {
        this.bJY = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.ei().inflate(this.bJY.getPageContext().getPageActivity(), com.baidu.tieba.x.sign_reply_view, null);
        initView();
    }

    private void initView() {
        this.aOl = this.mRootView.findViewById(com.baidu.tieba.w.root);
        this.bLF = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.reply_ll);
        this.bLG = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.sign_ll);
        this.bLH = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.sign_tip);
        this.bLI = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.sign_text);
        kx();
    }

    public void kx() {
        bc.j(this.aOl, com.baidu.tieba.t.cp_bg_line_c);
        bc.j(this.bLF, com.baidu.tieba.t.cp_bg_line_d);
        bc.j(this.bLG, com.baidu.tieba.t.cp_bg_line_d);
        bc.b(this.bLH, com.baidu.tieba.t.cp_cont_d, 1);
    }

    public void abD() {
        v abl = this.bJY.abl();
        UserData userData = abl.getUserData();
        e(abl.abQ(), userData);
        m(userData);
    }

    public void m(UserData userData) {
        if (userData != null) {
            String intro = userData.getIntro();
            if (!TextUtils.isEmpty(intro)) {
                this.bLI.setText(intro);
                bc.b(this.bLI, com.baidu.tieba.t.cp_cont_b, 1);
                return;
            }
            this.bLI.setText(com.baidu.tieba.z.no_person_sign);
            bc.b(this.bLI, com.baidu.tieba.t.cp_cont_e, 1);
        }
    }

    public void e(PersonTainInfo personTainInfo, UserData userData) {
        List<ReplyInfo> replyInfo;
        this.bLF.removeAllViews();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bLF.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.bLF.setLayoutParams(layoutParams);
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
                    View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.bJY.getPageContext().getPageActivity(), com.baidu.tieba.x.apply_message, null);
                    View findViewById = inflate.findViewById(com.baidu.tieba.w.line);
                    TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.apply_name);
                    TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.w.apply_info);
                    bc.b(textView, com.baidu.tieba.t.cp_cont_d, 1);
                    bc.b(textView2, com.baidu.tieba.t.cp_cont_b, 1);
                    bc.j(findViewById, com.baidu.tieba.t.cp_bg_line_b);
                    if (((ReplyInfo) arrayList.get(i3)).getUserId() == userData.getUserIdLong()) {
                        textView.setText(String.valueOf(userData.getName_show()) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    } else {
                        textView.setText(String.valueOf(this.bJY.getResources().getString(com.baidu.tieba.z.me)) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    }
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.leftMargin = this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds30);
                    layoutParams2.rightMargin = this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds30);
                    this.bLF.addView(inflate, layoutParams2);
                }
            }
            View inflate2 = com.baidu.adp.lib.g.b.ei().inflate(this.bJY.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_reply_btn, null);
            TextView textView3 = (TextView) inflate2.findViewById(com.baidu.tieba.w.reply_btn);
            bc.i((View) textView3, com.baidu.tieba.v.btn_pop_news);
            bc.b(textView3, com.baidu.tieba.t.cp_cont_b, 1);
            textView3.setOnClickListener(new aa(this, userData));
            this.bLF.addView(inflate2);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bLF.getLayoutParams();
            layoutParams3.bottomMargin = this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds20);
            this.bLF.setLayoutParams(layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(UserData userData) {
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.bJY.getPageContext().getPageActivity(), com.baidu.tieba.x.reply_dialog, null);
        EditText editText = (EditText) inflate.findViewById(com.baidu.tieba.w.reply_message);
        bc.i((View) editText, com.baidu.tieba.v.bg_live_compile);
        bc.b(editText, com.baidu.tieba.t.cp_cont_b, 2);
        editText.setPadding(this.bJY.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds16), 0, 0, 0);
        editText.setFocusable(true);
        editText.requestFocus();
        new Handler().postDelayed(new ab(this, editText), 100L);
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bJY.getPageContext().getPageActivity());
        aVar.bS(this.bJY.getResources().getString(com.baidu.tieba.z.add_reply));
        aVar.b(this.bJY.getResources().getString(com.baidu.tieba.z.delete_account_cancle), new ac(this));
        aVar.a(this.bJY.getResources().getString(com.baidu.tieba.z.reply_message), new ad(this, editText, userData));
        aVar.j(inflate);
        aVar.b(this.bJY.getPageContext()).nQ();
    }

    public View getRootView() {
        return this.mRootView;
    }
}
