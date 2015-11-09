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
    private int arf = -1;
    private View bnR;
    private PersonInfoActivity csa;
    private LinearLayout cvV;
    private LinearLayout cvW;
    private TextView cvX;
    private TextView cvY;
    private View cvZ;
    private ViewGroup cwa;
    private TextView cwb;
    private TextView cwc;
    private ImageView cwd;
    private boolean mIsHost;
    private View mRootView;

    public ae(PersonInfoActivity personInfoActivity, boolean z) {
        this.csa = personInfoActivity;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.csa.getPageContext().getPageActivity()).inflate(i.g.sign_reply_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.bnR = this.mRootView.findViewById(i.f.root);
        this.cvV = (LinearLayout) this.mRootView.findViewById(i.f.reply_ll);
        this.cvW = (LinearLayout) this.mRootView.findViewById(i.f.sign_ll);
        this.cvX = (TextView) this.mRootView.findViewById(i.f.sign_tip);
        this.cvY = (TextView) this.mRootView.findViewById(i.f.sign_text);
        this.cvZ = this.mRootView.findViewById(i.f.my_tdou_line);
        this.cwa = (ViewGroup) this.mRootView.findViewById(i.f.my_tdou);
        this.cwb = (TextView) this.mRootView.findViewById(i.f.my_tdou_tip);
        this.cwc = (TextView) this.mRootView.findViewById(i.f.my_tdou_value);
        this.cwd = (ImageView) this.mRootView.findViewById(i.f.my_tdou_arrow);
        oP();
    }

    public void oP() {
        if (this.arf != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.arf = TbadkCoreApplication.m411getInst().getSkinType();
            an.j(this.bnR, i.c.cp_bg_line_d);
            an.j(this.cvZ, i.c.cp_bg_line_b);
            an.i(this.cwa, i.e.personinfo_select_bg);
            an.b(this.cwc, i.c.cp_link_tip_d, 1);
            an.b(this.cwb, i.c.cp_cont_d, 1);
            this.cwc.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(i.e.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
            an.i(this.cwd, i.e.icon_dredge_arrow_r_n);
            an.b(this.cvX, i.c.cp_cont_d, 1);
        }
    }

    public void ake() {
        y ajH = this.csa.ajH();
        UserData userData = ajH.getUserData();
        e(ajH.akp(), userData);
        n(userData);
        o(userData);
        oP();
    }

    public void n(UserData userData) {
        if (userData != null) {
            String intro = userData.getIntro();
            if (!TextUtils.isEmpty(intro)) {
                this.cvY.setText(intro);
                an.b(this.cvY, i.c.cp_cont_b, 1);
                return;
            }
            this.cvY.setText(i.h.no_person_sign);
            an.b(this.cvY, i.c.cp_cont_e, 1);
        }
    }

    public void o(UserData userData) {
        if (this.mIsHost) {
            this.cvZ.setVisibility(0);
            this.cwa.setVisibility(0);
        } else {
            this.cvZ.setVisibility(8);
            this.cwa.setVisibility(8);
        }
        if (userData != null) {
            this.cwc.setText(as.u(userData.getTDouNum()));
            this.cwa.setOnClickListener(new af(this));
        }
    }

    public void e(PersonTainInfo personTainInfo, UserData userData) {
        List<ReplyInfo> replyInfo;
        this.cvV.removeAllViews();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cvV.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.cvV.setLayoutParams(layoutParams);
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
                    View inflate = LayoutInflater.from(this.csa.getPageContext().getPageActivity()).inflate(i.g.apply_message, (ViewGroup) null);
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
                        textView.setText(String.valueOf(this.csa.getResources().getString(i.h.me)) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    }
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.leftMargin = this.csa.getResources().getDimensionPixelSize(i.d.ds30);
                    layoutParams2.rightMargin = this.csa.getResources().getDimensionPixelSize(i.d.ds30);
                    this.cvV.addView(inflate, layoutParams2);
                }
            }
            View inflate2 = LayoutInflater.from(this.csa.getPageContext().getPageActivity()).inflate(i.g.personinfo_reply_btn, (ViewGroup) null);
            TextView textView3 = (TextView) inflate2.findViewById(i.f.reply_btn);
            an.i((View) textView3, i.e.btn_pop_news);
            an.b(textView3, i.c.cp_cont_b, 1);
            textView3.setOnClickListener(new ag(this, userData));
            this.cvV.addView(inflate2);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.cvV.getLayoutParams();
            layoutParams3.bottomMargin = this.csa.getResources().getDimensionPixelSize(i.d.ds20);
            this.cvV.setLayoutParams(layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(UserData userData) {
        View inflate = LayoutInflater.from(this.csa.getPageContext().getPageActivity()).inflate(i.g.reply_dialog, (ViewGroup) null);
        an.b((TextView) inflate.findViewById(i.f.text_replay), i.c.cp_cont_b, 1);
        EditText editText = (EditText) inflate.findViewById(i.f.reply_message);
        an.i((View) editText, i.e.blue_rectangle_input_bg);
        an.b(editText, i.c.cp_cont_b, 2);
        editText.setPadding(this.csa.getResources().getDimensionPixelSize(i.d.ds16), 0, 0, 0);
        editText.requestFocus();
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.csa.getPageContext().getPageActivity());
        aVar.b(this.csa.getResources().getString(i.h.delete_account_cancle), new ah(this));
        aVar.a(this.csa.getResources().getString(i.h.reply_message), new ai(this, editText, userData));
        aVar.m(inflate);
        aVar.b(this.csa.getPageContext()).sR();
        this.csa.ShowSoftKeyPadDelay(editText, 200);
    }

    public View getRootView() {
        return this.mRootView;
    }
}
