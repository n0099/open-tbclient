package com.baidu.tieba.personInfo;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ax;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class z {
    private View aNd;
    private PersonInfoActivity bIn;
    private LinearLayout bJV;
    private LinearLayout bJW;
    private TextView bJX;
    private TextView bJY;
    private boolean mIsHost;
    private View mRootView;

    public z(PersonInfoActivity personInfoActivity, boolean z) {
        this.bIn = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = com.baidu.adp.lib.g.b.ek().inflate(this.bIn.getPageContext().getPageActivity(), com.baidu.tieba.x.sign_reply_view, null);
        initView();
    }

    private void initView() {
        this.aNd = this.mRootView.findViewById(com.baidu.tieba.w.root);
        this.bJV = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.reply_ll);
        this.bJW = (LinearLayout) this.mRootView.findViewById(com.baidu.tieba.w.sign_ll);
        this.bJX = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.sign_tip);
        this.bJY = (TextView) this.mRootView.findViewById(com.baidu.tieba.w.sign_text);
        kE();
    }

    public void kE() {
        ax.j(this.aNd, com.baidu.tieba.t.cp_bg_line_c);
        ax.j(this.bJV, com.baidu.tieba.t.cp_bg_line_d);
        ax.j(this.bJW, com.baidu.tieba.t.cp_bg_line_d);
        ax.b(this.bJX, com.baidu.tieba.t.cp_cont_d, 1);
    }

    public void abe() {
        v aaL = this.bIn.aaL();
        UserData userData = aaL.getUserData();
        e(aaL.abr(), userData);
        m(userData);
    }

    public void m(UserData userData) {
        if (userData != null) {
            String intro = userData.getIntro();
            if (!TextUtils.isEmpty(intro)) {
                this.bJY.setText(intro);
                ax.b(this.bJY, com.baidu.tieba.t.cp_cont_b, 1);
                return;
            }
            this.bJY.setText(com.baidu.tieba.z.no_person_sign);
            ax.b(this.bJY, com.baidu.tieba.t.cp_cont_e, 1);
        }
    }

    public void e(PersonTainInfo personTainInfo, UserData userData) {
        List<ReplyInfo> replyInfo;
        this.bJV.removeAllViews();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bJV.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.bJV.setLayoutParams(layoutParams);
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
                    View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.bIn.getPageContext().getPageActivity(), com.baidu.tieba.x.apply_message, null);
                    View findViewById = inflate.findViewById(com.baidu.tieba.w.line);
                    TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.apply_name);
                    TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.w.apply_info);
                    ax.b(textView, com.baidu.tieba.t.cp_cont_d, 1);
                    ax.b(textView2, com.baidu.tieba.t.cp_cont_b, 1);
                    ax.j(findViewById, com.baidu.tieba.t.cp_bg_line_b);
                    if (((ReplyInfo) arrayList.get(i3)).getUserId() == userData.getUserIdLong()) {
                        textView.setText(String.valueOf(userData.getName_show()) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    } else {
                        textView.setText(String.valueOf(this.bIn.getResources().getString(com.baidu.tieba.z.me)) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    }
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.leftMargin = this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds30);
                    layoutParams2.rightMargin = this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds30);
                    this.bJV.addView(inflate, layoutParams2);
                }
            }
            View inflate2 = com.baidu.adp.lib.g.b.ek().inflate(this.bIn.getPageContext().getPageActivity(), com.baidu.tieba.x.personinfo_reply_btn, null);
            TextView textView3 = (TextView) inflate2.findViewById(com.baidu.tieba.w.reply_btn);
            ax.i((View) textView3, com.baidu.tieba.v.btn_pop_news);
            ax.b(textView3, com.baidu.tieba.t.cp_cont_b, 1);
            textView3.setOnClickListener(new aa(this, userData));
            this.bJV.addView(inflate2);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.bJV.getLayoutParams();
            layoutParams3.bottomMargin = this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds20);
            this.bJV.setLayoutParams(layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(UserData userData) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.bIn.getPageContext().getPageActivity(), com.baidu.tieba.x.reply_dialog, null);
        EditText editText = (EditText) inflate.findViewById(com.baidu.tieba.w.reply_message);
        ax.i((View) editText, com.baidu.tieba.v.bg_live_compile);
        ax.b(editText, com.baidu.tieba.t.cp_cont_b, 2);
        editText.setPadding(this.bIn.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds16), 0, 0, 0);
        editText.setFocusable(true);
        editText.requestFocus();
        new Handler().postDelayed(new ab(this, editText), 100L);
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bIn.getPageContext().getPageActivity());
        aVar.bX(this.bIn.getResources().getString(com.baidu.tieba.z.add_reply));
        aVar.b(this.bIn.getResources().getString(com.baidu.tieba.z.delete_account_cancle), new ac(this));
        aVar.a(this.bIn.getResources().getString(com.baidu.tieba.z.reply_message), new ad(this, editText, userData));
        aVar.j(inflate);
        aVar.b(this.bIn.getPageContext()).nU();
    }

    public View getRootView() {
        return this.mRootView;
    }
}
