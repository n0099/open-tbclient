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
public class r extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.person.data.k, com.baidu.tieba.person.b.m> {
    UserData Vw;
    private int afY;
    private boolean bwJ;
    private View bwP;
    private LinearLayout cMA;
    PersonTainInfo cMB;
    private BaseFragmentActivity mActivity;
    private boolean mIsHost;
    private View mRootView;
    protected int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public r(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bwJ = false;
        this.afY = -1;
        this.mActivity = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.person.b.m a(ViewGroup viewGroup) {
        return new com.baidu.tieba.person.b.m(LayoutInflater.from(this.mContext).inflate(n.g.sign_reply_view, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.person.data.k kVar, com.baidu.tieba.person.b.m mVar) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        a(mVar, kVar);
        com.baidu.tbadk.i.a.a(this.mActivity.getPageContext(), view);
        return view;
    }

    private void a(com.baidu.tieba.person.b.m mVar, com.baidu.tieba.person.data.k kVar) {
        if (kVar != null) {
            this.mIsHost = kVar.getIsSelf();
            this.mRootView = mVar.cQm;
            this.bwP = this.mRootView.findViewById(n.f.root);
            this.cMA = (LinearLayout) this.mRootView.findViewById(n.f.reply_ll);
            this.Vw = kVar.getUserData();
            this.cMB = kVar.aol();
            initView();
        }
    }

    private void initView() {
        View inflate = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(n.g.personinfo_reply_btn, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(n.f.reply_btn);
        as.i((View) textView, n.e.btn_pop_news);
        as.b(textView, n.c.cp_cont_b, 1);
        textView.setOnClickListener(new s(this));
        this.cMA.addView(inflate);
        oV();
        afN();
    }

    public void oV() {
        if (this.afY != TbadkCoreApplication.m411getInst().getSkinType()) {
            this.afY = TbadkCoreApplication.m411getInst().getSkinType();
            as.j(this.bwP, n.c.cp_bg_line_d);
        }
    }

    public void afN() {
        if (this.Vw != null && this.cMB != null) {
            a(this.cMB, this.Vw);
            oV();
        }
    }

    public void a(PersonTainInfo personTainInfo, UserData userData) {
        List<ReplyInfo> replyInfo;
        this.cMA.removeAllViews();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cMA.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.cMA.setLayoutParams(layoutParams);
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
                    View inflate = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(n.g.apply_message, (ViewGroup) null);
                    View findViewById = inflate.findViewById(n.f.line);
                    TextView textView = (TextView) inflate.findViewById(n.f.apply_name);
                    TextView textView2 = (TextView) inflate.findViewById(n.f.apply_info);
                    as.b(textView, n.c.cp_cont_d, 1);
                    as.b(textView2, n.c.cp_cont_b, 1);
                    as.j(findViewById, n.c.cp_bg_line_b);
                    if (((ReplyInfo) arrayList.get(i3)).getUserId() == userData.getUserIdLong()) {
                        textView.setText(String.valueOf(userData.getName_show()) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    } else {
                        textView.setText(String.valueOf(this.mActivity.getResources().getString(n.i.me)) + ":");
                        textView2.setText(((ReplyInfo) arrayList.get(i3)).getMessage());
                    }
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.leftMargin = this.mActivity.getResources().getDimensionPixelSize(n.d.ds20);
                    layoutParams2.rightMargin = this.mActivity.getResources().getDimensionPixelSize(n.d.ds20);
                    this.cMA.addView(inflate, layoutParams2);
                }
            }
            View inflate2 = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(n.g.personinfo_reply_btn, (ViewGroup) null);
            TextView textView3 = (TextView) inflate2.findViewById(n.f.reply_btn);
            as.i((View) textView3, n.e.btn_pop_news);
            as.b(textView3, n.c.cp_cont_b, 1);
            textView3.setOnClickListener(new t(this, userData));
            this.cMA.addView(inflate2);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.cMA.getLayoutParams();
            layoutParams3.bottomMargin = this.mActivity.getResources().getDimensionPixelSize(n.d.ds20);
            this.cMA.setLayoutParams(layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(UserData userData) {
        View inflate = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(n.g.reply_dialog, (ViewGroup) null);
        as.b((TextView) inflate.findViewById(n.f.text_replay), n.c.cp_cont_b, 1);
        EditText editText = (EditText) inflate.findViewById(n.f.reply_message);
        as.i((View) editText, n.e.blue_rectangle_input_bg);
        as.b(editText, n.c.cp_cont_b, 2);
        editText.setPadding(this.mActivity.getResources().getDimensionPixelSize(n.d.ds16), 0, 0, 0);
        editText.requestFocus();
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mActivity.getPageContext().getPageActivity());
        aVar.b(this.mActivity.getResources().getString(n.i.delete_account_cancle), new u(this));
        aVar.a(this.mActivity.getResources().getString(n.i.reply_message), new v(this, editText, userData));
        aVar.m(inflate);
        aVar.b(this.mActivity.getPageContext()).tv();
        this.mActivity.ShowSoftKeyPadDelay(editText, 200);
    }
}
