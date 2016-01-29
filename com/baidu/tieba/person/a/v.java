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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.personInfo.PersonTainInfo;
import com.baidu.tieba.personInfo.ReplyInfo;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.person.data.n, com.baidu.tieba.person.b.q> {
    UserData VL;
    private int ahU;
    private boolean bDM;
    private View bDS;
    private boolean bDs;
    private BaseFragmentActivity cZG;
    private LinearLayout daB;
    PersonTainInfo daC;
    private View mRootView;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public v(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bDM = false;
        this.ahU = -1;
        this.cZG = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public com.baidu.tieba.person.b.q b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.q(LayoutInflater.from(this.mContext).inflate(t.h.sign_reply_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.n nVar, com.baidu.tieba.person.b.q qVar) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(qVar, nVar);
        com.baidu.tbadk.i.a.a(this.cZG.getPageContext(), view);
        return view;
    }

    private void a(com.baidu.tieba.person.b.q qVar, com.baidu.tieba.person.data.n nVar) {
        if (nVar != null) {
            this.bDs = nVar.getIsSelf();
            this.mRootView = qVar.dgo;
            this.bDS = this.mRootView.findViewById(t.g.root);
            this.daB = (LinearLayout) this.mRootView.findViewById(t.g.reply_ll);
            this.VL = nVar.getUserData();
            this.daC = nVar.aup();
            initView();
        }
    }

    private void initView() {
        View inflate = LayoutInflater.from(this.cZG.getPageContext().getPageActivity()).inflate(t.h.personinfo_reply_btn, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(t.g.reply_btn);
        ar.k(textView, t.f.btn_pop_news);
        ar.b(textView, t.d.cp_cont_b, 1);
        textView.setOnClickListener(new w(this));
        this.daB.addView(inflate);
        oO();
        akY();
    }

    public void oO() {
        if (this.ahU != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.ahU = TbadkCoreApplication.m411getInst().getSkinType();
            ar.l(this.bDS, t.d.cp_bg_line_d);
        }
    }

    public void akY() {
        if (this.VL != null && this.daC != null) {
            a(this.daC, this.VL);
            oO();
        }
    }

    public void a(PersonTainInfo personTainInfo, UserData userData) {
        List<ReplyInfo> replyInfo;
        this.daB.removeAllViews();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.daB.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.daB.setLayoutParams(layoutParams);
        if (!this.bDs && personTainInfo != null && personTainInfo.getIsFriend() != 1 && userData != null && (replyInfo = personTainInfo.getReplyInfo()) != null && replyInfo.size() > 0) {
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
                    View inflate = LayoutInflater.from(this.cZG.getPageContext().getPageActivity()).inflate(t.h.apply_message, (ViewGroup) null);
                    View findViewById = inflate.findViewById(t.g.line);
                    TextView textView = (TextView) inflate.findViewById(t.g.apply_name);
                    TextView textView2 = (TextView) inflate.findViewById(t.g.apply_info);
                    ar.b(textView, t.d.cp_cont_d, 1);
                    ar.b(textView2, t.d.cp_cont_b, 1);
                    ar.l(findViewById, t.d.cp_bg_line_b);
                    if (((ReplyInfo) arrayList.get(i3)).getUserId() == userData.getUserIdLong()) {
                        textView.setText(String.valueOf(userData.getName_show()) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    } else {
                        textView.setText(String.valueOf(this.cZG.getResources().getString(t.j.me)) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    }
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.leftMargin = this.cZG.getResources().getDimensionPixelSize(t.e.ds20);
                    layoutParams2.rightMargin = this.cZG.getResources().getDimensionPixelSize(t.e.ds20);
                    this.daB.addView(inflate, layoutParams2);
                }
            }
            View inflate2 = LayoutInflater.from(this.cZG.getPageContext().getPageActivity()).inflate(t.h.personinfo_reply_btn, (ViewGroup) null);
            TextView textView3 = (TextView) inflate2.findViewById(t.g.reply_btn);
            ar.k(textView3, t.f.btn_pop_news);
            ar.b(textView3, t.d.cp_cont_b, 1);
            textView3.setOnClickListener(new x(this, userData));
            this.daB.addView(inflate2);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.daB.getLayoutParams();
            layoutParams3.bottomMargin = this.cZG.getResources().getDimensionPixelSize(t.e.ds20);
            this.daB.setLayoutParams(layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(UserData userData) {
        View inflate = LayoutInflater.from(this.cZG.getPageContext().getPageActivity()).inflate(t.h.reply_dialog, (ViewGroup) null);
        ar.b((TextView) inflate.findViewById(t.g.text_replay), t.d.cp_cont_b, 1);
        EditText editText = (EditText) inflate.findViewById(t.g.reply_message);
        ar.k(editText, t.f.blue_rectangle_input_bg);
        ar.b(editText, t.d.cp_cont_b, 2);
        editText.setPadding(this.cZG.getResources().getDimensionPixelSize(t.e.ds16), 0, 0, 0);
        editText.requestFocus();
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cZG.getPageContext().getPageActivity());
        aVar.b(this.cZG.getResources().getString(t.j.delete_account_cancle), new y(this));
        aVar.a(this.cZG.getResources().getString(t.j.reply_message), new z(this, editText, userData));
        aVar.z(inflate);
        aVar.b(this.cZG.getPageContext()).uj();
        this.cZG.ShowSoftKeyPadDelay(editText, 200);
    }
}
