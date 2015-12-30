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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import com.baidu.tieba.personInfo.PersonTainInfo;
import com.baidu.tieba.personInfo.ReplyInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.person.data.m, com.baidu.tieba.person.b.o> {
    UserData VW;
    private int ahf;
    private boolean bAA;
    private View bAG;
    private LinearLayout cQU;
    PersonTainInfo cQV;
    private BaseFragmentActivity mActivity;
    private boolean mIsHost;
    private View mRootView;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public v(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bAA = false;
        this.ahf = -1;
        this.mActivity = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: an */
    public com.baidu.tieba.person.b.o a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.o(LayoutInflater.from(this.mContext).inflate(n.h.sign_reply_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.m mVar, com.baidu.tieba.person.b.o oVar) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(oVar, mVar);
        com.baidu.tbadk.i.a.a(this.mActivity.getPageContext(), view);
        return view;
    }

    private void a(com.baidu.tieba.person.b.o oVar, com.baidu.tieba.person.data.m mVar) {
        if (mVar != null) {
            this.mIsHost = mVar.getIsSelf();
            this.mRootView = oVar.cUO;
            this.bAG = this.mRootView.findViewById(n.g.root);
            this.cQU = (LinearLayout) this.mRootView.findViewById(n.g.reply_ll);
            this.VW = mVar.getUserData();
            this.cQV = mVar.apv();
            initView();
        }
    }

    private void initView() {
        View inflate = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(n.h.personinfo_reply_btn, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(n.g.reply_btn);
        as.i((View) textView, n.f.btn_pop_news);
        as.b(textView, n.d.cp_cont_b, 1);
        textView.setOnClickListener(new w(this));
        this.cQU.addView(inflate);
        ot();
        agW();
    }

    public void ot() {
        if (this.ahf != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.ahf = TbadkCoreApplication.m411getInst().getSkinType();
            as.j(this.bAG, n.d.cp_bg_line_d);
        }
    }

    public void agW() {
        if (this.VW != null && this.cQV != null) {
            a(this.cQV, this.VW);
            ot();
        }
    }

    public void a(PersonTainInfo personTainInfo, UserData userData) {
        List<ReplyInfo> replyInfo;
        this.cQU.removeAllViews();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cQU.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.cQU.setLayoutParams(layoutParams);
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
                    View inflate = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(n.h.apply_message, (ViewGroup) null);
                    View findViewById = inflate.findViewById(n.g.line);
                    TextView textView = (TextView) inflate.findViewById(n.g.apply_name);
                    TextView textView2 = (TextView) inflate.findViewById(n.g.apply_info);
                    as.b(textView, n.d.cp_cont_d, 1);
                    as.b(textView2, n.d.cp_cont_b, 1);
                    as.j(findViewById, n.d.cp_bg_line_b);
                    if (((ReplyInfo) arrayList.get(i3)).getUserId() == userData.getUserIdLong()) {
                        textView.setText(String.valueOf(userData.getName_show()) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    } else {
                        textView.setText(String.valueOf(this.mActivity.getResources().getString(n.j.me)) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    }
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.leftMargin = this.mActivity.getResources().getDimensionPixelSize(n.e.ds20);
                    layoutParams2.rightMargin = this.mActivity.getResources().getDimensionPixelSize(n.e.ds20);
                    this.cQU.addView(inflate, layoutParams2);
                }
            }
            View inflate2 = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(n.h.personinfo_reply_btn, (ViewGroup) null);
            TextView textView3 = (TextView) inflate2.findViewById(n.g.reply_btn);
            as.i((View) textView3, n.f.btn_pop_news);
            as.b(textView3, n.d.cp_cont_b, 1);
            textView3.setOnClickListener(new x(this, userData));
            this.cQU.addView(inflate2);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.cQU.getLayoutParams();
            layoutParams3.bottomMargin = this.mActivity.getResources().getDimensionPixelSize(n.e.ds20);
            this.cQU.setLayoutParams(layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(UserData userData) {
        View inflate = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(n.h.reply_dialog, (ViewGroup) null);
        as.b((TextView) inflate.findViewById(n.g.text_replay), n.d.cp_cont_b, 1);
        EditText editText = (EditText) inflate.findViewById(n.g.reply_message);
        as.i((View) editText, n.f.blue_rectangle_input_bg);
        as.b(editText, n.d.cp_cont_b, 2);
        editText.setPadding(this.mActivity.getResources().getDimensionPixelSize(n.e.ds16), 0, 0, 0);
        editText.requestFocus();
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity.getPageContext().getPageActivity());
        aVar.b(this.mActivity.getResources().getString(n.j.delete_account_cancle), new y(this));
        aVar.a(this.mActivity.getResources().getString(n.j.reply_message), new z(this, editText, userData));
        aVar.m(inflate);
        aVar.b(this.mActivity.getPageContext()).tf();
        this.mActivity.ShowSoftKeyPadDelay(editText, 200);
    }
}
