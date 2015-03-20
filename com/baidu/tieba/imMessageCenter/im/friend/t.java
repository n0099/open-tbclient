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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.g<InviteFriendListActivity> implements s {
    private final InviteFriendListActivity bsI;
    private q bsJ;
    private View bsK;
    private InviteFriendCandidateList bsL;
    private LinearLayout bsM;
    private Button bsN;
    private View bsO;
    private int bsP;
    private boolean bsQ;
    private TextView bsR;
    private View bsS;
    private View bsT;
    private TextView bsU;
    private EditText mEditText;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.s mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public t(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.bsP = 0;
        this.bsI = inviteFriendListActivity;
        this.bsQ = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.bsI.setContentView(com.baidu.tieba.w.invite_friend_list);
        this.mRoot = this.bsI.findViewById(com.baidu.tieba.v.root_view);
        Lv();
        this.mListView = (BdListView) this.mRoot.findViewById(com.baidu.tieba.v.friend_list);
        this.mListView.setOnItemClickListener(this.bsI);
        if (this.bsQ) {
            this.mNoDataView = NoDataViewFactory.a(this.bsI.getPageContext().getPageActivity(), this.mRoot, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.r(com.baidu.tieba.y.no_friends, com.baidu.tieba.y.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.bsI.getPageContext().getPageActivity(), this.mRoot, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.r(com.baidu.tieba.y.no_chat_friends, com.baidu.tieba.y.no_chat_friends_tip), com.baidu.tbadk.core.view.u.a(new com.baidu.tbadk.core.view.t(TbadkCoreApplication.m411getInst().getResources().getString(com.baidu.tieba.y.find_new_friend), new u(this))));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.v.progress);
        this.bsL = (InviteFriendCandidateList) this.mRoot.findViewById(com.baidu.tieba.v.candidate_list);
        this.bsL.a(new v(this));
        this.bsM = (LinearLayout) this.mRoot.findViewById(com.baidu.tieba.v.invite_candidate);
        this.bsK = this.mRoot.findViewById(com.baidu.tieba.v.invite_candidate_border);
        if (this.bsQ) {
            this.bsM.setVisibility(8);
            this.bsK.setVisibility(8);
        }
        VD();
        this.bsN = (Button) this.mRoot.findViewById(com.baidu.tieba.v.button_send);
        this.bsN.setOnClickListener(this.bsI);
        tP();
        Vx();
        gB(0);
    }

    private void Lv() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new w(this));
        if (this.bsQ) {
            this.bsR = this.mNavigationBar.setTitleText(com.baidu.tieba.y.invite_contact_title);
        } else {
            this.bsR = this.mNavigationBar.setTitleText(com.baidu.tieba.y.invite_friend);
        }
        this.bsT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.add_new_friend_text, new x(this));
        this.bsS = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.w.navigationbar_search_edit, (View.OnClickListener) null);
        this.bsS.setVisibility(8);
        this.mEditText = (EditText) this.bsS.findViewById(com.baidu.tieba.v.search_bar_edit);
        if (this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.mEditText.addTextChangedListener(new y(this));
        this.bsU = (TextView) this.bsS.findViewById(com.baidu.tieba.v.search_bar_delete_button);
        this.bsU.setOnClickListener(new z(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vw() {
        if (this.bsI != null) {
            this.bsI.Vu();
        }
    }

    public void tP() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bsI.getLayoutMode().X(skinType == 1);
        this.bsI.getLayoutMode().h(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.bsI.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bsI.getPageContext(), skinType);
        ba.i(this.bsO, com.baidu.tieba.u.invite_friend_list_item_bg_color);
        this.bsO.setEnabled(false);
    }

    public void Vx() {
        this.mListView.setOnTouchListener(new aa(this));
    }

    public void Vy() {
        com.baidu.adp.lib.util.n.c(this.bsI.getPageContext().getPageActivity(), this.mEditText);
        this.bsS.setVisibility(8);
        this.bsR.setVisibility(0);
        this.bsT.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean Vz() {
        return this.bsS != null && this.bsS.getVisibility() == 0;
    }

    public int VA() {
        return this.bsN.getId();
    }

    public String VB() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String VC() {
        return this.bsL.Vr();
    }

    public void a(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.bsJ == null) {
            this.bsJ = new q(this.bsI, this.bsQ);
            this.bsJ.a(this);
            this.bsJ.a(new ab(this));
            this.mListView.setAdapter((ListAdapter) this.bsJ);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.mListView.setVisibility(8);
            if (!this.bsQ) {
                this.bsM.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.mListView.setVisibility(0);
        this.bsJ.setData(list);
        this.bsJ.notifyDataSetChanged();
        if (!this.bsQ) {
            this.bsM.setVisibility(0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [370=4] */
    private void VD() {
        int dimensionPixelSize = this.bsI.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_height) + this.bsI.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_padding_bottom) + this.bsI.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_padding_top);
        this.bsO = new View(this.bsI.getPageContext().getPageActivity());
        this.bsO.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bsO.setEnabled(false);
        this.mListView.addFooterView(this.bsO);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bsL.d(aVar);
            gB(this.bsL.getItemLength());
            VE();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bsL.f(aVar);
            gB(this.bsL.getItemLength());
            VE();
        }
    }

    private void VE() {
        if (this.bsL.getItemLength() > 0) {
            this.bsN.setEnabled(true);
        } else {
            this.bsN.setEnabled(false);
        }
    }

    public void VF() {
        com.baidu.adp.lib.util.n.c(this.bsI.getPageContext().getPageActivity(), this.mEditText);
    }

    private void gB(int i) {
        this.bsN.setText(String.format(this.bsI.getPageContext().getString(com.baidu.tieba.y.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int VG() {
        return this.bsP;
    }

    public void gC(int i) {
        this.bsP = i;
        this.bsL.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.s
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bsL.e(aVar);
        }
    }
}
