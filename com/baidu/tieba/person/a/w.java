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
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class w extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.person.data.o, com.baidu.tieba.person.b.x> {
    UserData OE;
    private int aeK;
    private View bUM;
    private BaseFragmentActivity bfw;
    private boolean cgJ;
    private LinearLayout egv;
    PersonTainInfo egw;
    private View mRootView;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public w(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.aeK = -1;
        this.bfw = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public com.baidu.tieba.person.b.x a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.x(LayoutInflater.from(this.mContext).inflate(u.h.sign_reply_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.o oVar, com.baidu.tieba.person.b.x xVar) {
        this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
        a(xVar, oVar);
        com.baidu.tbadk.j.a.a(this.bfw.getPageContext(), view);
        return view;
    }

    private void a(com.baidu.tieba.person.b.x xVar, com.baidu.tieba.person.data.o oVar) {
        if (oVar != null) {
            this.cgJ = oVar.getIsSelf();
            this.mRootView = xVar.emN;
            this.bUM = this.mRootView.findViewById(u.g.root);
            this.egv = (LinearLayout) this.mRootView.findViewById(u.g.reply_ll);
            this.OE = oVar.getUserData();
            this.egw = oVar.aLj();
            initView();
        }
    }

    private void initView() {
        View inflate = LayoutInflater.from(this.bfw.getPageContext().getPageActivity()).inflate(u.h.personinfo_reply_btn, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(u.g.reply_btn);
        com.baidu.tbadk.core.util.av.k(textView, u.f.btn_pop_news);
        com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_b, 1);
        com.baidu.tbadk.core.util.av.l(this.bUM, u.d.cp_bg_line_d);
        textView.setOnClickListener(new x(this));
        this.egv.addView(inflate);
        kX();
        Ri();
    }

    public void kX() {
        if (this.aeK != TbadkCoreApplication.m9getInst().getSkinType()) {
            this.aeK = TbadkCoreApplication.m9getInst().getSkinType();
            com.baidu.tbadk.core.util.av.l(this.bUM, u.d.cp_bg_line_d);
        }
    }

    public void Ri() {
        if (this.OE != null && this.egw != null) {
            a(this.egw, this.OE);
            kX();
        }
    }

    public void a(PersonTainInfo personTainInfo, UserData userData) {
        List<ReplyInfo> replyInfo;
        this.egv.removeAllViews();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.egv.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.egv.setLayoutParams(layoutParams);
        if (!this.cgJ && personTainInfo != null && personTainInfo.getIsFriend() != 1 && userData != null && (replyInfo = personTainInfo.getReplyInfo()) != null && replyInfo.size() > 0) {
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
                    View inflate = LayoutInflater.from(this.bfw.getPageContext().getPageActivity()).inflate(u.h.apply_message, (ViewGroup) null);
                    View findViewById = inflate.findViewById(u.g.line);
                    TextView textView = (TextView) inflate.findViewById(u.g.apply_name);
                    TextView textView2 = (TextView) inflate.findViewById(u.g.apply_info);
                    com.baidu.tbadk.core.util.av.c(textView, u.d.cp_cont_d, 1);
                    com.baidu.tbadk.core.util.av.c(textView2, u.d.cp_cont_b, 1);
                    com.baidu.tbadk.core.util.av.l(findViewById, u.d.cp_bg_line_b);
                    if (((ReplyInfo) arrayList.get(i3)).getUserId() == userData.getUserIdLong()) {
                        textView.setText(String.valueOf(userData.getName_show()) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    } else {
                        textView.setText(String.valueOf(this.bfw.getResources().getString(u.j.me)) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    }
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.leftMargin = this.bfw.getResources().getDimensionPixelSize(u.e.ds20);
                    layoutParams2.rightMargin = this.bfw.getResources().getDimensionPixelSize(u.e.ds20);
                    this.egv.addView(inflate, layoutParams2);
                }
            }
            View inflate2 = LayoutInflater.from(this.bfw.getPageContext().getPageActivity()).inflate(u.h.personinfo_reply_btn, (ViewGroup) null);
            TextView textView3 = (TextView) inflate2.findViewById(u.g.reply_btn);
            com.baidu.tbadk.core.util.av.k(textView3, u.f.btn_pop_news);
            com.baidu.tbadk.core.util.av.c(textView3, u.d.cp_cont_b, 1);
            textView3.setOnClickListener(new y(this, userData));
            this.egv.addView(inflate2);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.egv.getLayoutParams();
            layoutParams3.bottomMargin = this.bfw.getResources().getDimensionPixelSize(u.e.ds20);
            this.egv.setLayoutParams(layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(UserData userData) {
        View inflate = LayoutInflater.from(this.bfw.getPageContext().getPageActivity()).inflate(u.h.reply_dialog, (ViewGroup) null);
        com.baidu.tbadk.core.util.av.c((TextView) inflate.findViewById(u.g.text_replay), u.d.cp_cont_b, 1);
        EditText editText = (EditText) inflate.findViewById(u.g.reply_message);
        com.baidu.tbadk.core.util.av.k(editText, u.f.blue_rectangle_input_bg);
        com.baidu.tbadk.core.util.av.c(editText, u.d.cp_cont_b, 2);
        editText.setPadding(this.bfw.getResources().getDimensionPixelSize(u.e.ds16), 0, 0, 0);
        editText.requestFocus();
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bfw.getPageContext().getPageActivity());
        aVar.b(this.bfw.getResources().getString(u.j.delete_account_cancle), new z(this));
        aVar.a(this.bfw.getResources().getString(u.j.reply_message), new aa(this, editText, userData));
        aVar.y(inflate);
        aVar.b(this.bfw.getPageContext()).rT();
        this.bfw.ShowSoftKeyPadDelay(editText, 200);
    }
}
