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
import com.baidu.tieba.personInfo.PersonTainInfo;
import com.baidu.tieba.personInfo.ReplyInfo;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.person.data.o, com.baidu.tieba.person.b.t> {
    UserData OE;
    private int aej;
    private boolean bIW;
    private View bxh;
    private BaseFragmentActivity cSp;
    private LinearLayout dxZ;
    PersonTainInfo dya;
    private View mRootView;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public w(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.aej = -1;
        this.cSp = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aW */
    public com.baidu.tieba.person.b.t b(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.t(LayoutInflater.from(this.mContext).inflate(t.h.sign_reply_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.o oVar, com.baidu.tieba.person.b.t tVar) {
        this.mSkinType = TbadkCoreApplication.m11getInst().getSkinType();
        a(tVar, oVar);
        com.baidu.tbadk.i.a.a(this.cSp.getPageContext(), view);
        return view;
    }

    private void a(com.baidu.tieba.person.b.t tVar, com.baidu.tieba.person.data.o oVar) {
        if (oVar != null) {
            this.bIW = oVar.getIsSelf();
            this.mRootView = tVar.dDU;
            this.bxh = this.mRootView.findViewById(t.g.root);
            this.dxZ = (LinearLayout) this.mRootView.findViewById(t.g.reply_ll);
            this.OE = oVar.getUserData();
            this.dya = oVar.aCq();
            initView();
        }
    }

    private void initView() {
        View inflate = LayoutInflater.from(this.cSp.getPageContext().getPageActivity()).inflate(t.h.personinfo_reply_btn, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(t.g.reply_btn);
        com.baidu.tbadk.core.util.at.k(textView, t.f.btn_pop_news);
        com.baidu.tbadk.core.util.at.c(textView, t.d.cp_cont_b, 1);
        com.baidu.tbadk.core.util.at.l(this.bxh, t.d.cp_bg_line_d);
        textView.setOnClickListener(new x(this));
        this.dxZ.addView(inflate);
        kU();
        aCa();
    }

    public void kU() {
        if (this.aej != TbadkCoreApplication.m11getInst().getSkinType()) {
            this.aej = TbadkCoreApplication.m11getInst().getSkinType();
            com.baidu.tbadk.core.util.at.l(this.bxh, t.d.cp_bg_line_d);
        }
    }

    public void aCa() {
        if (this.OE != null && this.dya != null) {
            a(this.dya, this.OE);
            kU();
        }
    }

    public void a(PersonTainInfo personTainInfo, UserData userData) {
        List<ReplyInfo> replyInfo;
        this.dxZ.removeAllViews();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dxZ.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.dxZ.setLayoutParams(layoutParams);
        if (!this.bIW && personTainInfo != null && personTainInfo.getIsFriend() != 1 && userData != null && (replyInfo = personTainInfo.getReplyInfo()) != null && replyInfo.size() > 0) {
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
                    View inflate = LayoutInflater.from(this.cSp.getPageContext().getPageActivity()).inflate(t.h.apply_message, (ViewGroup) null);
                    View findViewById = inflate.findViewById(t.g.line);
                    TextView textView = (TextView) inflate.findViewById(t.g.apply_name);
                    TextView textView2 = (TextView) inflate.findViewById(t.g.apply_info);
                    com.baidu.tbadk.core.util.at.c(textView, t.d.cp_cont_d, 1);
                    com.baidu.tbadk.core.util.at.c(textView2, t.d.cp_cont_b, 1);
                    com.baidu.tbadk.core.util.at.l(findViewById, t.d.cp_bg_line_b);
                    if (((ReplyInfo) arrayList.get(i3)).getUserId() == userData.getUserIdLong()) {
                        textView.setText(String.valueOf(userData.getName_show()) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    } else {
                        textView.setText(String.valueOf(this.cSp.getResources().getString(t.j.me)) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    }
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.leftMargin = this.cSp.getResources().getDimensionPixelSize(t.e.ds20);
                    layoutParams2.rightMargin = this.cSp.getResources().getDimensionPixelSize(t.e.ds20);
                    this.dxZ.addView(inflate, layoutParams2);
                }
            }
            View inflate2 = LayoutInflater.from(this.cSp.getPageContext().getPageActivity()).inflate(t.h.personinfo_reply_btn, (ViewGroup) null);
            TextView textView3 = (TextView) inflate2.findViewById(t.g.reply_btn);
            com.baidu.tbadk.core.util.at.k(textView3, t.f.btn_pop_news);
            com.baidu.tbadk.core.util.at.c(textView3, t.d.cp_cont_b, 1);
            textView3.setOnClickListener(new y(this, userData));
            this.dxZ.addView(inflate2);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.dxZ.getLayoutParams();
            layoutParams3.bottomMargin = this.cSp.getResources().getDimensionPixelSize(t.e.ds20);
            this.dxZ.setLayoutParams(layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(UserData userData) {
        View inflate = LayoutInflater.from(this.cSp.getPageContext().getPageActivity()).inflate(t.h.reply_dialog, (ViewGroup) null);
        com.baidu.tbadk.core.util.at.c((TextView) inflate.findViewById(t.g.text_replay), t.d.cp_cont_b, 1);
        EditText editText = (EditText) inflate.findViewById(t.g.reply_message);
        com.baidu.tbadk.core.util.at.k(editText, t.f.blue_rectangle_input_bg);
        com.baidu.tbadk.core.util.at.c(editText, t.d.cp_cont_b, 2);
        editText.setPadding(this.cSp.getResources().getDimensionPixelSize(t.e.ds16), 0, 0, 0);
        editText.requestFocus();
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cSp.getPageContext().getPageActivity());
        aVar.b(this.cSp.getResources().getString(t.j.delete_account_cancle), new z(this));
        aVar.a(this.cSp.getResources().getString(t.j.reply_message), new aa(this, editText, userData));
        aVar.z(inflate);
        aVar.b(this.cSp.getPageContext()).rV();
        this.cSp.ShowSoftKeyPadDelay(editText, 200);
    }
}
