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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ae {
    private int apS = -1;
    private View bnn;
    private PersonInfoActivity cqE;
    private LinearLayout cuA;
    private TextView cuB;
    private TextView cuC;
    private View cuD;
    private ViewGroup cuE;
    private TextView cuF;
    private TextView cuG;
    private ImageView cuH;
    private LinearLayout cuz;
    private boolean mIsHost;
    private View mRootView;

    public ae(PersonInfoActivity personInfoActivity, boolean z) {
        this.cqE = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.cqE.getPageContext().getPageActivity()).inflate(i.g.sign_reply_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.bnn = this.mRootView.findViewById(i.f.root);
        this.cuz = (LinearLayout) this.mRootView.findViewById(i.f.reply_ll);
        this.cuA = (LinearLayout) this.mRootView.findViewById(i.f.sign_ll);
        this.cuB = (TextView) this.mRootView.findViewById(i.f.sign_tip);
        this.cuC = (TextView) this.mRootView.findViewById(i.f.sign_text);
        this.cuD = this.mRootView.findViewById(i.f.my_tdou_line);
        this.cuE = (ViewGroup) this.mRootView.findViewById(i.f.my_tdou);
        this.cuF = (TextView) this.mRootView.findViewById(i.f.my_tdou_tip);
        this.cuG = (TextView) this.mRootView.findViewById(i.f.my_tdou_value);
        this.cuH = (ImageView) this.mRootView.findViewById(i.f.my_tdou_arrow);
        oO();
    }

    public void oO() {
        if (this.apS != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.apS = TbadkCoreApplication.m411getInst().getSkinType();
            an.j(this.bnn, i.c.cp_bg_line_d);
            an.j(this.cuD, i.c.cp_bg_line_b);
            an.i(this.cuE, i.e.personinfo_select_bg);
            an.b(this.cuG, i.c.cp_link_tip_d, 1);
            an.b(this.cuF, i.c.cp_cont_d, 1);
            this.cuG.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
            an.i(this.cuH, i.e.icon_dredge_arrow_r_n);
            an.b(this.cuB, i.c.cp_cont_d, 1);
        }
    }

    public void ajC() {
        y ajf = this.cqE.ajf();
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
                this.cuC.setText(intro);
                an.b(this.cuC, i.c.cp_cont_b, 1);
                return;
            }
            this.cuC.setText(i.h.no_person_sign);
            an.b(this.cuC, i.c.cp_cont_e, 1);
        }
    }

    public void o(UserData userData) {
        if (this.mIsHost) {
            this.cuD.setVisibility(0);
            this.cuE.setVisibility(0);
        } else {
            this.cuD.setVisibility(8);
            this.cuE.setVisibility(8);
        }
        if (userData != null) {
            this.cuG.setText(as.w(userData.getTDouNum()));
            this.cuE.setOnClickListener(new af(this));
        }
    }

    public void e(PersonTainInfo personTainInfo, UserData userData) {
        List<ReplyInfo> replyInfo;
        this.cuz.removeAllViews();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cuz.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.cuz.setLayoutParams(layoutParams);
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
                    View inflate = LayoutInflater.from(this.cqE.getPageContext().getPageActivity()).inflate(i.g.apply_message, (ViewGroup) null);
                    View findViewById = inflate.findViewById(i.f.line);
                    TextView textView = (TextView) inflate.findViewById(i.f.apply_name);
                    TextView textView2 = (TextView) inflate.findViewById(i.f.apply_info);
                    an.b(textView, i.c.cp_cont_d, 1);
                    an.b(textView2, i.c.cp_cont_b, 1);
                    an.j(findViewById, i.c.cp_bg_line_b);
                    if (((ReplyInfo) arrayList.get(i3)).getUserId() == userData.getUserIdLong()) {
                        textView.setText(String.valueOf(userData.getName_show()) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    } else {
                        textView.setText(String.valueOf(this.cqE.getResources().getString(i.h.me)) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    }
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.leftMargin = this.cqE.getResources().getDimensionPixelSize(i.d.ds30);
                    layoutParams2.rightMargin = this.cqE.getResources().getDimensionPixelSize(i.d.ds30);
                    this.cuz.addView(inflate, layoutParams2);
                }
            }
            View inflate2 = LayoutInflater.from(this.cqE.getPageContext().getPageActivity()).inflate(i.g.personinfo_reply_btn, (ViewGroup) null);
            TextView textView3 = (TextView) inflate2.findViewById(i.f.reply_btn);
            an.i((View) textView3, i.e.btn_pop_news);
            an.b(textView3, i.c.cp_cont_b, 1);
            textView3.setOnClickListener(new ag(this, userData));
            this.cuz.addView(inflate2);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.cuz.getLayoutParams();
            layoutParams3.bottomMargin = this.cqE.getResources().getDimensionPixelSize(i.d.ds20);
            this.cuz.setLayoutParams(layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(UserData userData) {
        View inflate = LayoutInflater.from(this.cqE.getPageContext().getPageActivity()).inflate(i.g.reply_dialog, (ViewGroup) null);
        an.b((TextView) inflate.findViewById(i.f.text_replay), i.c.cp_cont_b, 1);
        EditText editText = (EditText) inflate.findViewById(i.f.reply_message);
        an.i((View) editText, i.e.blue_rectangle_input_bg);
        an.b(editText, i.c.cp_cont_b, 2);
        editText.setPadding(this.cqE.getResources().getDimensionPixelSize(i.d.ds16), 0, 0, 0);
        editText.requestFocus();
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cqE.getPageContext().getPageActivity());
        aVar.b(this.cqE.getResources().getString(i.h.delete_account_cancle), new ah(this));
        aVar.a(this.cqE.getResources().getString(i.h.reply_message), new ai(this, editText, userData));
        aVar.m(inflate);
        aVar.b(this.cqE.getPageContext()).sR();
        this.cqE.ShowSoftKeyPadDelay(editText, 200);
    }

    public View getRootView() {
        return this.mRootView;
    }
}
