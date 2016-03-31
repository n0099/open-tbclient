package com.baidu.tieba.person.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.personInfo.PersonTainInfo;
import com.baidu.tieba.personInfo.ReplyInfo;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.person.data.n, com.baidu.tieba.person.b.q> {
    UserData TP;
    private int aik;
    private boolean bIP;
    private boolean bJj;
    private View bJp;
    private BaseFragmentActivity duj;
    private LinearLayout dvd;
    PersonTainInfo dve;
    private View mRootView;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public v(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bJj = false;
        this.aik = -1;
        this.duj = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.person.b.q b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.q(LayoutInflater.from(this.mContext).inflate(t.h.sign_reply_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.n nVar, com.baidu.tieba.person.b.q qVar) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(qVar, nVar);
        com.baidu.tbadk.i.a.a(this.duj.getPageContext(), view);
        return view;
    }

    private void a(com.baidu.tieba.person.b.q qVar, com.baidu.tieba.person.data.n nVar) {
        if (nVar != null) {
            this.bIP = nVar.getIsSelf();
            this.mRootView = qVar.dAN;
            this.bJp = this.mRootView.findViewById(t.g.root);
            this.dvd = (LinearLayout) this.mRootView.findViewById(t.g.reply_ll);
            this.TP = nVar.getUserData();
            this.dve = nVar.aBV();
            initView();
        }
    }

    private void initView() {
        View inflate = LayoutInflater.from(this.duj.getPageContext().getPageActivity()).inflate(t.h.personinfo_reply_btn, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(t.g.reply_btn);
        at.k(textView, t.f.btn_pop_news);
        at.b(textView, t.d.cp_cont_b, 1);
        textView.setOnClickListener(new w(this));
        this.dvd.addView(inflate);
        oH();
        arP();
    }

    public void oH() {
        if (this.aik != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.aik = TbadkCoreApplication.m411getInst().getSkinType();
            at.l(this.bJp, t.d.cp_bg_line_d);
        }
    }

    public void arP() {
        if (this.TP != null && this.dve != null) {
            a(this.dve, this.TP);
            oH();
        }
    }

    public void a(PersonTainInfo personTainInfo, UserData userData) {
        List<ReplyInfo> replyInfo;
        this.dvd.removeAllViews();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dvd.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.dvd.setLayoutParams(layoutParams);
        if (!this.bIP && personTainInfo != null && personTainInfo.getIsFriend() != 1 && userData != null && (replyInfo = personTainInfo.getReplyInfo()) != null && replyInfo.size() > 0) {
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
                    View inflate = LayoutInflater.from(this.duj.getPageContext().getPageActivity()).inflate(t.h.apply_message, (ViewGroup) null);
                    View findViewById = inflate.findViewById(t.g.line);
                    TextView textView = (TextView) inflate.findViewById(t.g.apply_name);
                    TextView textView2 = (TextView) inflate.findViewById(t.g.apply_info);
                    at.b(textView, t.d.cp_cont_d, 1);
                    at.b(textView2, t.d.cp_cont_b, 1);
                    at.l(findViewById, t.d.cp_bg_line_b);
                    if (((ReplyInfo) arrayList.get(i3)).getUserId() == userData.getUserIdLong()) {
                        textView.setText(String.valueOf(userData.getName_show()) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    } else {
                        textView.setText(String.valueOf(this.duj.getResources().getString(t.j.me)) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    }
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.leftMargin = this.duj.getResources().getDimensionPixelSize(t.e.ds20);
                    layoutParams2.rightMargin = this.duj.getResources().getDimensionPixelSize(t.e.ds20);
                    this.dvd.addView(inflate, layoutParams2);
                }
            }
            View inflate2 = LayoutInflater.from(this.duj.getPageContext().getPageActivity()).inflate(t.h.personinfo_reply_btn, (ViewGroup) null);
            TextView textView3 = (TextView) inflate2.findViewById(t.g.reply_btn);
            at.k(textView3, t.f.btn_pop_news);
            at.b(textView3, t.d.cp_cont_b, 1);
            textView3.setOnClickListener(new x(this, userData));
            this.dvd.addView(inflate2);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.dvd.getLayoutParams();
            layoutParams3.bottomMargin = this.duj.getResources().getDimensionPixelSize(t.e.ds20);
            this.dvd.setLayoutParams(layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(UserData userData) {
        View inflate = LayoutInflater.from(this.duj.getPageContext().getPageActivity()).inflate(t.h.reply_dialog, (ViewGroup) null);
        at.b((TextView) inflate.findViewById(t.g.text_replay), t.d.cp_cont_b, 1);
        EditText editText = (EditText) inflate.findViewById(t.g.reply_message);
        at.k(editText, t.f.blue_rectangle_input_bg);
        at.b(editText, t.d.cp_cont_b, 2);
        editText.setPadding(this.duj.getResources().getDimensionPixelSize(t.e.ds16), 0, 0, 0);
        editText.requestFocus();
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.duj.getPageContext().getPageActivity());
        aVar.b(this.duj.getResources().getString(t.j.delete_account_cancle), new y(this));
        aVar.a(this.duj.getResources().getString(t.j.reply_message), new z(this, editText, userData));
        aVar.z(inflate);
        aVar.b(this.duj.getPageContext()).up();
        this.duj.ShowSoftKeyPadDelay(editText, 200);
    }
}
