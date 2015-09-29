package com.baidu.tieba.personInfo;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ae {
    private int apR = -1;
    private View bnc;
    private PersonInfoActivity cqt;
    private LinearLayout cuo;
    private LinearLayout cup;
    private TextView cuq;
    private TextView cur;
    private View cus;
    private ViewGroup cut;
    private TextView cuu;
    private TextView cuv;
    private ImageView cuw;
    private boolean mIsHost;
    private View mRootView;

    public ae(PersonInfoActivity personInfoActivity, boolean z) {
        this.cqt = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.cqt.getPageContext().getPageActivity()).inflate(i.g.sign_reply_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.bnc = this.mRootView.findViewById(i.f.root);
        this.cuo = (LinearLayout) this.mRootView.findViewById(i.f.reply_ll);
        this.cup = (LinearLayout) this.mRootView.findViewById(i.f.sign_ll);
        this.cuq = (TextView) this.mRootView.findViewById(i.f.sign_tip);
        this.cur = (TextView) this.mRootView.findViewById(i.f.sign_text);
        this.cus = this.mRootView.findViewById(i.f.my_tdou_line);
        this.cut = (ViewGroup) this.mRootView.findViewById(i.f.my_tdou);
        this.cuu = (TextView) this.mRootView.findViewById(i.f.my_tdou_tip);
        this.cuv = (TextView) this.mRootView.findViewById(i.f.my_tdou_value);
        this.cuw = (ImageView) this.mRootView.findViewById(i.f.my_tdou_arrow);
        oO();
    }

    public void oO() {
        if (this.apR != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.apR = TbadkCoreApplication.m411getInst().getSkinType();
            am.j(this.bnc, i.c.cp_bg_line_d);
            am.j(this.cus, i.c.cp_bg_line_b);
            am.i(this.cut, i.e.personinfo_select_bg);
            am.b(this.cuv, i.c.cp_link_tip_d, 1);
            am.b(this.cuu, i.c.cp_cont_d, 1);
            this.cuv.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(i.e.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
            am.i(this.cuw, i.e.icon_dredge_arrow_r_n);
            am.b(this.cuq, i.c.cp_cont_d, 1);
        }
    }

    public void ajC() {
        y ajf = this.cqt.ajf();
        UserData userData = ajf.getUserData();
        e(ajf.ajN(), userData);
        n(userData);
        o(userData);
        oO();
    }

    public void n(UserData userData) {
        if (userData != null) {
            String intro = userData.getIntro();
            if (!TextUtils.isEmpty(intro)) {
                this.cur.setText(intro);
                am.b(this.cur, i.c.cp_cont_b, 1);
                return;
            }
            this.cur.setText(i.h.no_person_sign);
            am.b(this.cur, i.c.cp_cont_e, 1);
        }
    }

    public void o(UserData userData) {
        if (this.mIsHost) {
            this.cus.setVisibility(0);
            this.cut.setVisibility(0);
        } else {
            this.cus.setVisibility(8);
            this.cut.setVisibility(8);
        }
        if (userData != null) {
            this.cuv.setText(ar.w(userData.getTDouNum()));
            this.cut.setOnClickListener(new af(this));
        }
    }

    public void e(PersonTainInfo personTainInfo, UserData userData) {
        List<ReplyInfo> replyInfo;
        this.cuo.removeAllViews();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cuo.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.cuo.setLayoutParams(layoutParams);
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
                    View inflate = LayoutInflater.from(this.cqt.getPageContext().getPageActivity()).inflate(i.g.apply_message, (ViewGroup) null);
                    View findViewById = inflate.findViewById(i.f.line);
                    TextView textView = (TextView) inflate.findViewById(i.f.apply_name);
                    TextView textView2 = (TextView) inflate.findViewById(i.f.apply_info);
                    am.b(textView, i.c.cp_cont_d, 1);
                    am.b(textView2, i.c.cp_cont_b, 1);
                    am.j(findViewById, i.c.cp_bg_line_b);
                    if (((ReplyInfo) arrayList.get(i3)).getUserId() == userData.getUserIdLong()) {
                        textView.setText(String.valueOf(userData.getName_show()) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    } else {
                        textView.setText(String.valueOf(this.cqt.getResources().getString(i.h.me)) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    }
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.leftMargin = this.cqt.getResources().getDimensionPixelSize(i.d.ds30);
                    layoutParams2.rightMargin = this.cqt.getResources().getDimensionPixelSize(i.d.ds30);
                    this.cuo.addView(inflate, layoutParams2);
                }
            }
            View inflate2 = LayoutInflater.from(this.cqt.getPageContext().getPageActivity()).inflate(i.g.personinfo_reply_btn, (ViewGroup) null);
            TextView textView3 = (TextView) inflate2.findViewById(i.f.reply_btn);
            am.i((View) textView3, i.e.btn_pop_news);
            am.b(textView3, i.c.cp_cont_b, 1);
            textView3.setOnClickListener(new ag(this, userData));
            this.cuo.addView(inflate2);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.cuo.getLayoutParams();
            layoutParams3.bottomMargin = this.cqt.getResources().getDimensionPixelSize(i.d.ds20);
            this.cuo.setLayoutParams(layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(UserData userData) {
        View inflate = LayoutInflater.from(this.cqt.getPageContext().getPageActivity()).inflate(i.g.reply_dialog, (ViewGroup) null);
        am.b((TextView) inflate.findViewById(i.f.text_replay), i.c.cp_cont_b, 1);
        EditText editText = (EditText) inflate.findViewById(i.f.reply_message);
        am.i((View) editText, i.e.blue_rectangle_input_bg);
        am.b(editText, i.c.cp_cont_b, 2);
        editText.setPadding(this.cqt.getResources().getDimensionPixelSize(i.d.ds16), 0, 0, 0);
        editText.requestFocus();
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cqt.getPageContext().getPageActivity());
        aVar.b(this.cqt.getResources().getString(i.h.delete_account_cancle), new ah(this));
        aVar.a(this.cqt.getResources().getString(i.h.reply_message), new ai(this, editText, userData));
        aVar.m(inflate);
        aVar.b(this.cqt.getPageContext()).sR();
        this.cqt.ShowSoftKeyPadDelay(editText, 200);
    }

    public View getRootView() {
        return this.mRootView;
    }
}
