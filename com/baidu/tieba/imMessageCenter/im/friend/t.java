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
    private final InviteFriendListActivity bsY;
    private q bsZ;
    private View bta;
    private InviteFriendCandidateList btb;
    private LinearLayout btc;
    private Button btd;
    private View bte;
    private int btf;
    private boolean btg;
    private TextView bth;
    private View bti;
    private View btj;
    private TextView btk;
    private EditText mEditText;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.s mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public t(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.btf = 0;
        this.bsY = inviteFriendListActivity;
        this.btg = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.bsY.setContentView(com.baidu.tieba.w.invite_friend_list);
        this.mRoot = this.bsY.findViewById(com.baidu.tieba.v.root_view);
        LH();
        this.mListView = (BdListView) this.mRoot.findViewById(com.baidu.tieba.v.friend_list);
        this.mListView.setOnItemClickListener(this.bsY);
        if (this.btg) {
            this.mNoDataView = NoDataViewFactory.a(this.bsY.getPageContext().getPageActivity(), this.mRoot, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.r(com.baidu.tieba.y.no_friends, com.baidu.tieba.y.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.bsY.getPageContext().getPageActivity(), this.mRoot, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA), com.baidu.tbadk.core.view.w.r(com.baidu.tieba.y.no_chat_friends, com.baidu.tieba.y.no_chat_friends_tip), com.baidu.tbadk.core.view.u.a(new com.baidu.tbadk.core.view.t(TbadkCoreApplication.m411getInst().getResources().getString(com.baidu.tieba.y.find_new_friend), new u(this))));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(com.baidu.tieba.v.progress);
        this.btb = (InviteFriendCandidateList) this.mRoot.findViewById(com.baidu.tieba.v.candidate_list);
        this.btb.a(new v(this));
        this.btc = (LinearLayout) this.mRoot.findViewById(com.baidu.tieba.v.invite_candidate);
        this.bta = this.mRoot.findViewById(com.baidu.tieba.v.invite_candidate_border);
        if (this.btg) {
            this.btc.setVisibility(8);
            this.bta.setVisibility(8);
        }
        VQ();
        this.btd = (Button) this.mRoot.findViewById(com.baidu.tieba.v.button_send);
        this.btd.setOnClickListener(this.bsY);
        tP();
        VK();
        gD(0);
    }

    private void LH() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new w(this));
        if (this.btg) {
            this.bth = this.mNavigationBar.setTitleText(com.baidu.tieba.y.invite_contact_title);
        } else {
            this.bth = this.mNavigationBar.setTitleText(com.baidu.tieba.y.invite_friend);
        }
        this.btj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.add_new_friend_text, new x(this));
        this.bti = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, com.baidu.tieba.w.navigationbar_search_edit, (View.OnClickListener) null);
        this.bti.setVisibility(8);
        this.mEditText = (EditText) this.bti.findViewById(com.baidu.tieba.v.search_bar_edit);
        if (this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.mEditText.addTextChangedListener(new y(this));
        this.btk = (TextView) this.bti.findViewById(com.baidu.tieba.v.search_bar_delete_button);
        this.btk.setOnClickListener(new z(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VJ() {
        if (this.bsY != null) {
            this.bsY.VH();
        }
    }

    public void tP() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bsY.getLayoutMode().X(skinType == 1);
        this.bsY.getLayoutMode().h(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.bsY.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bsY.getPageContext(), skinType);
        ba.i(this.bte, com.baidu.tieba.u.invite_friend_list_item_bg_color);
        this.bte.setEnabled(false);
    }

    public void VK() {
        this.mListView.setOnTouchListener(new aa(this));
    }

    public void VL() {
        com.baidu.adp.lib.util.n.c(this.bsY.getPageContext().getPageActivity(), this.mEditText);
        this.bti.setVisibility(8);
        this.bth.setVisibility(0);
        this.btj.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean VM() {
        return this.bti != null && this.bti.getVisibility() == 0;
    }

    public int VN() {
        return this.btd.getId();
    }

    public String VO() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String VP() {
        return this.btb.VE();
    }

    public void a(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.bsZ == null) {
            this.bsZ = new q(this.bsY, this.btg);
            this.bsZ.a(this);
            this.bsZ.a(new ab(this));
            this.mListView.setAdapter((ListAdapter) this.bsZ);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.mListView.setVisibility(8);
            if (!this.btg) {
                this.btc.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.mListView.setVisibility(0);
        this.bsZ.setData(list);
        this.bsZ.notifyDataSetChanged();
        if (!this.btg) {
            this.btc.setVisibility(0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [370=4] */
    private void VQ() {
        int dimensionPixelSize = this.bsY.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_height) + this.bsY.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_padding_bottom) + this.bsY.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_padding_top);
        this.bte = new View(this.bsY.getPageContext().getPageActivity());
        this.bte.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bte.setEnabled(false);
        this.mListView.addFooterView(this.bte);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.btb.d(aVar);
            gD(this.btb.getItemLength());
            VR();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.btb.f(aVar);
            gD(this.btb.getItemLength());
            VR();
        }
    }

    private void VR() {
        if (this.btb.getItemLength() > 0) {
            this.btd.setEnabled(true);
        } else {
            this.btd.setEnabled(false);
        }
    }

    public void VS() {
        com.baidu.adp.lib.util.n.c(this.bsY.getPageContext().getPageActivity(), this.mEditText);
    }

    private void gD(int i) {
        this.btd.setText(String.format(this.bsY.getPageContext().getString(com.baidu.tieba.y.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int VT() {
        return this.btf;
    }

    public void gE(int i) {
        this.btf = i;
        this.btb.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.s
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.btb.e(aVar);
        }
    }
}
