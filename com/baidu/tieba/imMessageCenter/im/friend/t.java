package com.baidu.tieba.imMessageCenter.im.friend;

import android.text.Editable;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.g<InviteFriendListActivity> implements s {
    private final InviteFriendListActivity bvI;
    private q bvJ;
    private View bvK;
    private InviteFriendCandidateList bvL;
    private LinearLayout bvM;
    private Button bvN;
    private View bvO;
    private int bvP;
    private boolean bvQ;
    private TextView bvR;
    private View bvS;
    private View bvT;
    private TextView bvU;
    private EditText mEditText;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public t(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.bvP = 0;
        this.bvI = inviteFriendListActivity;
        this.bvQ = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.bvI.setContentView(com.baidu.tieba.r.invite_friend_list);
        this.mRoot = this.bvI.findViewById(com.baidu.tieba.q.root_view);
        MM();
        this.mListView = (BdListView) this.mRoot.findViewById(com.baidu.tieba.q.friend_list);
        this.mListView.setOnItemClickListener(this.bvI);
        if (this.bvQ) {
            this.mNoDataView = NoDataViewFactory.a(this.bvI.getPageContext().getPageActivity(), this.mRoot, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.s(com.baidu.tieba.t.no_friends, com.baidu.tieba.t.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.bvI.getPageContext().getPageActivity(), this.mRoot, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.s(com.baidu.tieba.t.no_chat_friends, com.baidu.tieba.t.no_chat_friends_tip), com.baidu.tbadk.core.view.z.a(new com.baidu.tbadk.core.view.y(TbadkCoreApplication.m411getInst().getResources().getString(com.baidu.tieba.t.find_new_friend), new u(this))));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.q.progress);
        this.bvL = (InviteFriendCandidateList) this.mRoot.findViewById(com.baidu.tieba.q.candidate_list);
        this.bvL.a(new v(this));
        this.bvM = (LinearLayout) this.mRoot.findViewById(com.baidu.tieba.q.invite_candidate);
        this.bvK = this.mRoot.findViewById(com.baidu.tieba.q.invite_candidate_border);
        if (this.bvQ) {
            this.bvM.setVisibility(8);
            this.bvK.setVisibility(8);
        }
        Xi();
        this.bvN = (Button) this.mRoot.findViewById(com.baidu.tieba.q.button_send);
        this.bvN.setOnClickListener(this.bvI);
        uy();
        Xc();
        gU(0);
    }

    private void MM() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new w(this));
        if (this.bvQ) {
            this.bvR = this.mNavigationBar.setTitleText(com.baidu.tieba.t.invite_contact_title);
        } else {
            this.bvR = this.mNavigationBar.setTitleText(com.baidu.tieba.t.invite_friend);
        }
        this.bvT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.add_new_friend_text, new x(this));
        this.bvS = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.r.navigationbar_search_edit, (View.OnClickListener) null);
        this.bvS.setVisibility(8);
        this.mEditText = (EditText) this.bvS.findViewById(com.baidu.tieba.q.search_bar_edit);
        if (this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.mEditText.addTextChangedListener(new y(this));
        this.bvU = (TextView) this.bvS.findViewById(com.baidu.tieba.q.search_bar_delete_button);
        this.bvU.setOnClickListener(new z(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xb() {
        if (this.bvI != null) {
            this.bvI.WZ();
        }
    }

    public void uy() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bvI.getLayoutMode().ab(skinType == 1);
        this.bvI.getLayoutMode().j(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.bvI.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bvI.getPageContext(), skinType);
        ay.i(this.bvO, com.baidu.tieba.p.invite_friend_list_item_bg_color);
        this.bvO.setEnabled(false);
    }

    public void Xc() {
        this.mListView.setOnTouchListener(new aa(this));
    }

    public void Xd() {
        com.baidu.adp.lib.util.n.c(this.bvI.getPageContext().getPageActivity(), this.mEditText);
        this.bvS.setVisibility(8);
        this.bvR.setVisibility(0);
        this.bvT.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean Xe() {
        return this.bvS != null && this.bvS.getVisibility() == 0;
    }

    public int Xf() {
        return this.bvN.getId();
    }

    public String Xg() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String Xh() {
        return this.bvL.WW();
    }

    public void a(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.bvJ == null) {
            this.bvJ = new q(this.bvI, this.bvQ);
            this.bvJ.a(this);
            this.bvJ.setCheckBoxStateChangedListener(new ab(this));
            this.mListView.setAdapter((ListAdapter) this.bvJ);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.mListView.setVisibility(8);
            if (!this.bvQ) {
                this.bvM.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.mListView.setVisibility(0);
        this.bvJ.setData(list);
        this.bvJ.notifyDataSetChanged();
        if (!this.bvQ) {
            this.bvM.setVisibility(0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [370=4] */
    private void Xi() {
        int dimensionPixelSize = this.bvI.getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_item_height) + this.bvI.getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_padding_bottom) + this.bvI.getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_padding_top);
        this.bvO = new View(this.bvI.getPageContext().getPageActivity());
        this.bvO.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bvO.setEnabled(false);
        this.mListView.addFooterView(this.bvO);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bvL.d(aVar);
            gU(this.bvL.getItemLength());
            Xj();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bvL.f(aVar);
            gU(this.bvL.getItemLength());
            Xj();
        }
    }

    private void Xj() {
        if (this.bvL.getItemLength() > 0) {
            this.bvN.setEnabled(true);
        } else {
            this.bvN.setEnabled(false);
        }
    }

    public void Xk() {
        com.baidu.adp.lib.util.n.c(this.bvI.getPageContext().getPageActivity(), this.mEditText);
    }

    private void gU(int i) {
        this.bvN.setText(String.format(this.bvI.getPageContext().getString(com.baidu.tieba.t.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int Xl() {
        return this.bvP;
    }

    public void gV(int i) {
        this.bvP = i;
        this.bvL.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.s
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bvL.e(aVar);
        }
    }
}
