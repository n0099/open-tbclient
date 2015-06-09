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
    private final InviteFriendListActivity bvJ;
    private q bvK;
    private View bvL;
    private InviteFriendCandidateList bvM;
    private LinearLayout bvN;
    private Button bvO;
    private View bvP;
    private int bvQ;
    private boolean bvR;
    private TextView bvS;
    private View bvT;
    private View bvU;
    private TextView bvV;
    private EditText mEditText;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public t(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.bvQ = 0;
        this.bvJ = inviteFriendListActivity;
        this.bvR = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.bvJ.setContentView(com.baidu.tieba.r.invite_friend_list);
        this.mRoot = this.bvJ.findViewById(com.baidu.tieba.q.root_view);
        MN();
        this.mListView = (BdListView) this.mRoot.findViewById(com.baidu.tieba.q.friend_list);
        this.mListView.setOnItemClickListener(this.bvJ);
        if (this.bvR) {
            this.mNoDataView = NoDataViewFactory.a(this.bvJ.getPageContext().getPageActivity(), this.mRoot, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.s(com.baidu.tieba.t.no_friends, com.baidu.tieba.t.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.bvJ.getPageContext().getPageActivity(), this.mRoot, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.ab.s(com.baidu.tieba.t.no_chat_friends, com.baidu.tieba.t.no_chat_friends_tip), com.baidu.tbadk.core.view.z.a(new com.baidu.tbadk.core.view.y(TbadkCoreApplication.m411getInst().getResources().getString(com.baidu.tieba.t.find_new_friend), new u(this))));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.q.progress);
        this.bvM = (InviteFriendCandidateList) this.mRoot.findViewById(com.baidu.tieba.q.candidate_list);
        this.bvM.a(new v(this));
        this.bvN = (LinearLayout) this.mRoot.findViewById(com.baidu.tieba.q.invite_candidate);
        this.bvL = this.mRoot.findViewById(com.baidu.tieba.q.invite_candidate_border);
        if (this.bvR) {
            this.bvN.setVisibility(8);
            this.bvL.setVisibility(8);
        }
        Xj();
        this.bvO = (Button) this.mRoot.findViewById(com.baidu.tieba.q.button_send);
        this.bvO.setOnClickListener(this.bvJ);
        uy();
        Xd();
        gU(0);
    }

    private void MN() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new w(this));
        if (this.bvR) {
            this.bvS = this.mNavigationBar.setTitleText(com.baidu.tieba.t.invite_contact_title);
        } else {
            this.bvS = this.mNavigationBar.setTitleText(com.baidu.tieba.t.invite_friend);
        }
        this.bvU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.add_new_friend_text, new x(this));
        this.bvT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.r.navigationbar_search_edit, (View.OnClickListener) null);
        this.bvT.setVisibility(8);
        this.mEditText = (EditText) this.bvT.findViewById(com.baidu.tieba.q.search_bar_edit);
        if (this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.mEditText.addTextChangedListener(new y(this));
        this.bvV = (TextView) this.bvT.findViewById(com.baidu.tieba.q.search_bar_delete_button);
        this.bvV.setOnClickListener(new z(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xc() {
        if (this.bvJ != null) {
            this.bvJ.Xa();
        }
    }

    public void uy() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bvJ.getLayoutMode().ab(skinType == 1);
        this.bvJ.getLayoutMode().j(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.bvJ.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bvJ.getPageContext(), skinType);
        ay.i(this.bvP, com.baidu.tieba.p.invite_friend_list_item_bg_color);
        this.bvP.setEnabled(false);
    }

    public void Xd() {
        this.mListView.setOnTouchListener(new aa(this));
    }

    public void Xe() {
        com.baidu.adp.lib.util.n.c(this.bvJ.getPageContext().getPageActivity(), this.mEditText);
        this.bvT.setVisibility(8);
        this.bvS.setVisibility(0);
        this.bvU.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean Xf() {
        return this.bvT != null && this.bvT.getVisibility() == 0;
    }

    public int Xg() {
        return this.bvO.getId();
    }

    public String Xh() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String Xi() {
        return this.bvM.WX();
    }

    public void a(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.bvK == null) {
            this.bvK = new q(this.bvJ, this.bvR);
            this.bvK.a(this);
            this.bvK.setCheckBoxStateChangedListener(new ab(this));
            this.mListView.setAdapter((ListAdapter) this.bvK);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.mListView.setVisibility(8);
            if (!this.bvR) {
                this.bvN.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.mListView.setVisibility(0);
        this.bvK.setData(list);
        this.bvK.notifyDataSetChanged();
        if (!this.bvR) {
            this.bvN.setVisibility(0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [370=4] */
    private void Xj() {
        int dimensionPixelSize = this.bvJ.getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_item_height) + this.bvJ.getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_padding_bottom) + this.bvJ.getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_padding_top);
        this.bvP = new View(this.bvJ.getPageContext().getPageActivity());
        this.bvP.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bvP.setEnabled(false);
        this.mListView.addFooterView(this.bvP);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bvM.d(aVar);
            gU(this.bvM.getItemLength());
            Xk();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bvM.f(aVar);
            gU(this.bvM.getItemLength());
            Xk();
        }
    }

    private void Xk() {
        if (this.bvM.getItemLength() > 0) {
            this.bvO.setEnabled(true);
        } else {
            this.bvO.setEnabled(false);
        }
    }

    public void Xl() {
        com.baidu.adp.lib.util.n.c(this.bvJ.getPageContext().getPageActivity(), this.mEditText);
    }

    private void gU(int i) {
        this.bvO.setText(String.format(this.bvJ.getPageContext().getString(com.baidu.tieba.t.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int Xm() {
        return this.bvQ;
    }

    public void gV(int i) {
        this.bvQ = i;
        this.bvM.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.s
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bvM.e(aVar);
        }
    }
}
