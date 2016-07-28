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
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.personInfo.PersonTainInfo;
import com.baidu.tieba.personInfo.ReplyInfo;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.person.data.n, com.baidu.tieba.person.holder.x> {
    UserData OS;
    private int afy;
    private View bWM;
    private BaseFragmentActivity bgI;
    private boolean ciS;
    private LinearLayout equ;
    PersonTainInfo eqv;
    private View mRootView;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public u(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.afy = -1;
        this.bgI = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bL */
    public com.baidu.tieba.person.holder.x a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.holder.x(LayoutInflater.from(this.mContext).inflate(u.h.sign_reply_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.n nVar, com.baidu.tieba.person.holder.x xVar) {
        this.mSkinType = TbadkCoreApplication.m10getInst().getSkinType();
        a(xVar, nVar);
        com.baidu.tbadk.j.a.a(this.bgI.getPageContext(), view);
        return view;
    }

    private void a(com.baidu.tieba.person.holder.x xVar, com.baidu.tieba.person.data.n nVar) {
        if (nVar != null) {
            this.ciS = nVar.getIsSelf();
            this.mRootView = xVar.exm;
            this.bWM = this.mRootView.findViewById(u.g.root);
            this.equ = (LinearLayout) this.mRootView.findViewById(u.g.reply_ll);
            this.OS = nVar.getUserData();
            this.eqv = nVar.aNM();
            initView();
        }
    }

    private void initView() {
        View inflate = LayoutInflater.from(this.bgI.getPageContext().getPageActivity()).inflate(u.h.personinfo_reply_btn, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(u.g.reply_btn);
        av.k(textView, u.f.btn_pop_news);
        av.c(textView, u.d.cp_cont_b, 1);
        av.l(this.bWM, u.d.cp_bg_line_d);
        textView.setOnClickListener(new v(this));
        this.equ.addView(inflate);
        kT();
        RP();
    }

    public void kT() {
        if (this.afy != TbadkCoreApplication.m10getInst().getSkinType()) {
            this.afy = TbadkCoreApplication.m10getInst().getSkinType();
            av.l(this.bWM, u.d.cp_bg_line_d);
        }
    }

    public void RP() {
        if (this.OS != null && this.eqv != null) {
            a(this.eqv, this.OS);
            kT();
        }
    }

    public void a(PersonTainInfo personTainInfo, UserData userData) {
        List<ReplyInfo> replyInfo;
        this.equ.removeAllViews();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.equ.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.equ.setLayoutParams(layoutParams);
        if (!this.ciS && personTainInfo != null && personTainInfo.getIsFriend() != 1 && userData != null && (replyInfo = personTainInfo.getReplyInfo()) != null && replyInfo.size() > 0) {
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
                    View inflate = LayoutInflater.from(this.bgI.getPageContext().getPageActivity()).inflate(u.h.apply_message, (ViewGroup) null);
                    View findViewById = inflate.findViewById(u.g.line);
                    TextView textView = (TextView) inflate.findViewById(u.g.apply_name);
                    TextView textView2 = (TextView) inflate.findViewById(u.g.apply_info);
                    av.c(textView, u.d.cp_cont_d, 1);
                    av.c(textView2, u.d.cp_cont_b, 1);
                    av.l(findViewById, u.d.cp_bg_line_b);
                    if (((ReplyInfo) arrayList.get(i3)).getUserId() == userData.getUserIdLong()) {
                        textView.setText(String.valueOf(userData.getName_show()) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    } else {
                        textView.setText(String.valueOf(this.bgI.getResources().getString(u.j.me)) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    }
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.leftMargin = this.bgI.getResources().getDimensionPixelSize(u.e.ds20);
                    layoutParams2.rightMargin = this.bgI.getResources().getDimensionPixelSize(u.e.ds20);
                    this.equ.addView(inflate, layoutParams2);
                }
            }
            View inflate2 = LayoutInflater.from(this.bgI.getPageContext().getPageActivity()).inflate(u.h.personinfo_reply_btn, (ViewGroup) null);
            TextView textView3 = (TextView) inflate2.findViewById(u.g.reply_btn);
            av.k(textView3, u.f.btn_pop_news);
            av.c(textView3, u.d.cp_cont_b, 1);
            textView3.setOnClickListener(new w(this, userData));
            this.equ.addView(inflate2);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.equ.getLayoutParams();
            layoutParams3.bottomMargin = this.bgI.getResources().getDimensionPixelSize(u.e.ds20);
            this.equ.setLayoutParams(layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(UserData userData) {
        View inflate = LayoutInflater.from(this.bgI.getPageContext().getPageActivity()).inflate(u.h.reply_dialog, (ViewGroup) null);
        av.c((TextView) inflate.findViewById(u.g.text_replay), u.d.cp_cont_b, 1);
        EditText editText = (EditText) inflate.findViewById(u.g.reply_message);
        av.k(editText, u.f.blue_rectangle_input_bg);
        av.c(editText, u.d.cp_cont_b, 2);
        editText.setPadding(this.bgI.getResources().getDimensionPixelSize(u.e.ds16), 0, 0, 0);
        editText.requestFocus();
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bgI.getPageContext().getPageActivity());
        aVar.b(this.bgI.getResources().getString(u.j.delete_account_cancle), new x(this));
        aVar.a(this.bgI.getResources().getString(u.j.reply_message), new y(this, editText, userData));
        aVar.y(inflate);
        aVar.b(this.bgI.getPageContext()).rS();
        this.bgI.ShowSoftKeyPadDelay(editText, 200);
    }
}
