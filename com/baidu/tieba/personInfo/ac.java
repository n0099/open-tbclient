package com.baidu.tieba.personInfo;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac {
    private int arr = -1;
    private View bmB;
    private PersonInfoActivity ckP;
    private LinearLayout coH;
    private LinearLayout coI;
    private TextView coJ;
    private TextView coK;
    private boolean mIsHost;
    private View mRootView;

    public ac(PersonInfoActivity personInfoActivity, boolean z) {
        this.ckP = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.ckP.getPageContext().getPageActivity()).inflate(i.g.sign_reply_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.bmB = this.mRootView.findViewById(i.f.root);
        this.coH = (LinearLayout) this.mRootView.findViewById(i.f.reply_ll);
        this.coI = (LinearLayout) this.mRootView.findViewById(i.f.sign_ll);
        this.coJ = (TextView) this.mRootView.findViewById(i.f.sign_tip);
        this.coK = (TextView) this.mRootView.findViewById(i.f.sign_text);
        oN();
    }

    public void oN() {
        if (this.arr != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.arr = TbadkCoreApplication.m411getInst().getSkinType();
            al.i(this.bmB, i.c.cp_bg_line_c);
            al.i(this.coH, i.c.cp_bg_line_d);
            al.i(this.coI, i.c.cp_bg_line_d);
            al.b(this.coJ, i.c.cp_cont_d, 1);
        }
    }

    public void ahA() {
        w ahd = this.ckP.ahd();
        UserData userData = ahd.getUserData();
        e(ahd.ahM(), userData);
        m(userData);
        oN();
    }

    public void m(UserData userData) {
        if (userData != null) {
            String intro = userData.getIntro();
            if (!TextUtils.isEmpty(intro)) {
                this.coK.setText(intro);
                al.b(this.coK, i.c.cp_cont_b, 1);
                return;
            }
            this.coK.setText(i.h.no_person_sign);
            al.b(this.coK, i.c.cp_cont_e, 1);
        }
    }

    public void e(PersonTainInfo personTainInfo, UserData userData) {
        List<ReplyInfo> replyInfo;
        this.coH.removeAllViews();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.coH.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.coH.setLayoutParams(layoutParams);
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
                    View inflate = LayoutInflater.from(this.ckP.getPageContext().getPageActivity()).inflate(i.g.apply_message, (ViewGroup) null);
                    View findViewById = inflate.findViewById(i.f.line);
                    TextView textView = (TextView) inflate.findViewById(i.f.apply_name);
                    TextView textView2 = (TextView) inflate.findViewById(i.f.apply_info);
                    al.b(textView, i.c.cp_cont_d, 1);
                    al.b(textView2, i.c.cp_cont_b, 1);
                    al.i(findViewById, i.c.cp_bg_line_b);
                    if (((ReplyInfo) arrayList.get(i3)).getUserId() == userData.getUserIdLong()) {
                        textView.setText(String.valueOf(userData.getName_show()) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    } else {
                        textView.setText(String.valueOf(this.ckP.getResources().getString(i.h.me)) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    }
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.leftMargin = this.ckP.getResources().getDimensionPixelSize(i.d.ds30);
                    layoutParams2.rightMargin = this.ckP.getResources().getDimensionPixelSize(i.d.ds30);
                    this.coH.addView(inflate, layoutParams2);
                }
            }
            View inflate2 = LayoutInflater.from(this.ckP.getPageContext().getPageActivity()).inflate(i.g.personinfo_reply_btn, (ViewGroup) null);
            TextView textView3 = (TextView) inflate2.findViewById(i.f.reply_btn);
            al.h((View) textView3, i.e.btn_pop_news);
            al.b(textView3, i.c.cp_cont_b, 1);
            textView3.setOnClickListener(new ad(this, userData));
            this.coH.addView(inflate2);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.coH.getLayoutParams();
            layoutParams3.bottomMargin = this.ckP.getResources().getDimensionPixelSize(i.d.ds20);
            this.coH.setLayoutParams(layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(UserData userData) {
        View inflate = LayoutInflater.from(this.ckP.getPageContext().getPageActivity()).inflate(i.g.reply_dialog, (ViewGroup) null);
        al.b((TextView) inflate.findViewById(i.f.text_replay), i.c.cp_cont_b, 1);
        EditText editText = (EditText) inflate.findViewById(i.f.reply_message);
        al.h((View) editText, i.e.blue_rectangle_input_bg);
        al.b(editText, i.c.cp_cont_b, 2);
        editText.setPadding(this.ckP.getResources().getDimensionPixelSize(i.d.ds16), 0, 0, 0);
        editText.requestFocus();
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ckP.getPageContext().getPageActivity());
        aVar.b(this.ckP.getResources().getString(i.h.delete_account_cancle), new ae(this));
        aVar.a(this.ckP.getResources().getString(i.h.reply_message), new af(this, editText, userData));
        aVar.m(inflate);
        aVar.b(this.ckP.getPageContext()).sU();
        this.ckP.ShowSoftKeyPadDelay(editText, 200);
    }

    public View getRootView() {
        return this.mRootView;
    }
}
