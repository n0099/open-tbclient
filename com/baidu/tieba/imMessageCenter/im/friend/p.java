package com.baidu.tieba.imMessageCenter.im.friend;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.imMessageCenter.im.friend.o;
import com.baidu.tieba.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class p extends com.baidu.adp.base.e<InviteFriendListActivity> implements o.b {
    private BdListView Ic;
    private View Qx;
    private EditText dhk;
    private final InviteFriendListActivity dkL;
    private o dkM;
    private View dkN;
    private InviteFriendCandidateList dkO;
    private LinearLayout dkP;
    private Button dkQ;
    private int dkR;
    private boolean dkS;
    private TextView dkT;
    private View dkU;
    private View dkV;
    private TextView dkW;
    private ImageView dkX;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dkR = 0;
        this.dkL = inviteFriendListActivity;
        this.dkS = z;
        wr();
    }

    public View getRootView() {
        return this.Qx;
    }

    private void wr() {
        this.dkL.setContentView(w.j.invite_friend_list);
        this.Qx = this.dkL.findViewById(w.h.root_view);
        TV();
        this.Ic = (BdListView) this.Qx.findViewById(w.h.friend_list);
        this.Ic.setOnItemClickListener(this.dkL);
        if (this.dkS) {
            this.mNoDataView = NoDataViewFactory.a(this.dkL.getPageContext().getPageActivity(), this.Qx, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aIK), NoDataViewFactory.d.B(w.l.no_friends, w.l.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dkL.getPageContext().getPageActivity(), this.Qx, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aIK), NoDataViewFactory.d.B(w.l.no_chat_friends, w.l.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m9getInst().getResources().getString(w.l.find_new_friend), new q(this))));
        }
        this.mProgress = (ProgressBar) this.Qx.findViewById(w.h.progress);
        this.dkO = (InviteFriendCandidateList) this.Qx.findViewById(w.h.candidate_list);
        this.dkO.a(new r(this));
        this.dkP = (LinearLayout) this.Qx.findViewById(w.h.invite_candidate);
        this.dkN = this.Qx.findViewById(w.h.invite_candidate_border);
        if (this.dkS) {
            this.dkP.setVisibility(8);
            this.dkN.setVisibility(8);
        }
        atH();
        this.dkQ = (Button) this.Qx.findViewById(w.h.button_send);
        this.dkQ.setOnClickListener(this.dkL);
        ws();
        atz();
        mr(0);
    }

    private void TV() {
        this.mNavigationBar = (NavigationBar) this.Qx.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.dkS) {
            this.dkT = this.mNavigationBar.setTitleText(w.l.invite_contact_title);
        } else {
            this.dkT = this.mNavigationBar.setTitleText(w.l.invite_friend);
        }
        this.dkV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.add_new_friend_text, new t(this));
        this.dkX = (ImageView) this.dkV.findViewById(w.h.new_friend_search);
        this.dkU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dkU.setVisibility(8);
        this.dhk = (EditText) this.dkU.findViewById(w.h.search_bar_edit);
        if (this.dhk.getParent() != null) {
            ((View) this.dhk.getParent()).setFocusable(true);
            ((View) this.dhk.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new u(this);
        this.dhk.addTextChangedListener(this.mTextWatcher);
        this.dkW = (TextView) this.dkU.findViewById(w.h.search_bar_delete_button);
        this.dkW.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aty() {
        if (this.dkL != null) {
            this.dkL.atw();
        }
    }

    public void ws() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.dkL.getLayoutMode().ah(skinType == 1);
        this.dkL.getLayoutMode().t(this.Qx);
        aq.b(this.dkX, w.g.icon_search_bg_s, w.g.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dkL.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dkL.getPageContext(), skinType);
        aq.j(this.mListFooter, w.g.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void atz() {
        this.Ic.setOnTouchListener(new w(this));
    }

    public void atA() {
        com.baidu.adp.lib.util.k.b(this.dkL.getPageContext().getPageActivity(), this.dhk);
        this.dkU.setVisibility(8);
        this.dkT.setVisibility(0);
        this.dkV.setVisibility(0);
        this.dhk.getText().clear();
    }

    public boolean atB() {
        return this.dkU != null && this.dkU.getVisibility() == 0;
    }

    public int atC() {
        return this.dkQ.getId();
    }

    public String atD() {
        Editable text = this.dhk.getText();
        return text != null ? text.toString() : "";
    }

    public String atE() {
        return this.dkO.att();
    }

    public void k(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dkM == null) {
            this.dkM = new o(this.dkL, this.dkS);
            this.dkM.a(this);
            this.dkM.a(new x(this));
            this.Ic.setAdapter((ListAdapter) this.dkM);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Ic.setVisibility(8);
            if (!this.dkS) {
                this.dkP.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Ic.setVisibility(0);
        this.dkM.setData(list);
        this.dkM.notifyDataSetChanged();
        if (!this.dkS) {
            this.dkP.setVisibility(0);
        }
    }

    public void atF() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dkL.getPageContext());
        }
    }

    public void atG() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [387=4] */
    private void atH() {
        int dimensionPixelSize = this.dkL.getResources().getDimensionPixelSize(w.f.ds80) + this.dkL.getResources().getDimensionPixelSize(w.f.ds16) + this.dkL.getResources().getDimensionPixelSize(w.f.ds16);
        this.mListFooter = new View(this.dkL.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Ic.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dkO.d(aVar);
            mr(this.dkO.getItemLength());
            atI();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dkO.f(aVar);
            mr(this.dkO.getItemLength());
            atI();
        }
    }

    private void atI() {
        if (this.dkO.getItemLength() > 0) {
            this.dkQ.setEnabled(true);
        } else {
            this.dkQ.setEnabled(false);
        }
    }

    public void atJ() {
        com.baidu.adp.lib.util.k.b(this.dkL.getPageContext().getPageActivity(), this.dhk);
    }

    private void mr(int i) {
        this.dkQ.setText(String.format(this.dkL.getPageContext().getString(w.l.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int atK() {
        return this.dkR;
    }

    public void ms(int i) {
        this.dkR = i;
        this.dkO.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dkO.e(aVar);
        }
    }

    public void onDestroy() {
        this.dhk.removeTextChangedListener(this.mTextWatcher);
    }
}
