package com.baidu.tieba.imMessageCenter.im.friend;

import android.text.Editable;
import android.text.TextWatcher;
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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.imMessageCenter.im.friend.o;
import com.baidu.tieba.n;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.f<InviteFriendListActivity> implements o.b {
    private TextWatcher aGT;
    private EditText bXx;
    private final InviteFriendListActivity ccV;
    private o ccW;
    private View ccX;
    private InviteFriendCandidateList ccY;
    private LinearLayout ccZ;
    private Button cda;
    private int cdb;
    private boolean cdc;
    private TextView cdd;
    private View cde;
    private View cdf;
    private TextView cdg;
    private View mListFooter;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.n mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.cdb = 0;
        this.ccV = inviteFriendListActivity;
        this.cdc = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.ccV.setContentView(n.g.invite_friend_list);
        this.mRoot = this.ccV.findViewById(n.f.root_view);
        Qh();
        this.mListView = (BdListView) this.mRoot.findViewById(n.f.friend_list);
        this.mListView.setOnItemClickListener(this.ccV);
        if (this.cdc) {
            this.mNoDataView = NoDataViewFactory.a(this.ccV.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.D(n.i.no_friends, n.i.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.ccV.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.D(n.i.no_chat_friends, n.i.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m411getInst().getResources().getString(n.i.find_new_friend), new q(this))));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(n.f.progress);
        this.ccY = (InviteFriendCandidateList) this.mRoot.findViewById(n.f.candidate_list);
        this.ccY.a(new r(this));
        this.ccZ = (LinearLayout) this.mRoot.findViewById(n.f.invite_candidate);
        this.ccX = this.mRoot.findViewById(n.f.invite_candidate_border);
        if (this.cdc) {
            this.ccZ.setVisibility(8);
            this.ccX.setVisibility(8);
        }
        acW();
        this.cda = (Button) this.mRoot.findViewById(n.f.button_send);
        this.cda.setOnClickListener(this.ccV);
        wh();
        acO();
        iP(0);
    }

    private void Qh() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.cdc) {
            this.cdd = this.mNavigationBar.setTitleText(n.i.invite_contact_title);
        } else {
            this.cdd = this.mNavigationBar.setTitleText(n.i.invite_friend);
        }
        this.cdf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.add_new_friend_text, new t(this));
        this.cde = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, n.g.navigationbar_search_edit, (View.OnClickListener) null);
        this.cde.setVisibility(8);
        this.bXx = (EditText) this.cde.findViewById(n.f.search_bar_edit);
        if (this.bXx.getParent() != null) {
            ((View) this.bXx.getParent()).setFocusable(true);
            ((View) this.bXx.getParent()).setFocusableInTouchMode(true);
        }
        this.aGT = new u(this);
        this.bXx.addTextChangedListener(this.aGT);
        this.cdg = (TextView) this.cde.findViewById(n.f.search_bar_delete_button);
        this.cdg.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acN() {
        if (this.ccV != null) {
            this.ccV.acL();
        }
    }

    public void wh() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.ccV.getLayoutMode().af(skinType == 1);
        this.ccV.getLayoutMode().k(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.ccV.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.ccV.getPageContext(), skinType);
        as.i(this.mListFooter, n.e.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void acO() {
        this.mListView.setOnTouchListener(new w(this));
    }

    public void acP() {
        com.baidu.adp.lib.util.k.c(this.ccV.getPageContext().getPageActivity(), this.bXx);
        this.cde.setVisibility(8);
        this.cdd.setVisibility(0);
        this.cdf.setVisibility(0);
        this.bXx.getText().clear();
    }

    public boolean acQ() {
        return this.cde != null && this.cde.getVisibility() == 0;
    }

    public int acR() {
        return this.cda.getId();
    }

    public String acS() {
        Editable text = this.bXx.getText();
        return text != null ? text.toString() : "";
    }

    public String acT() {
        return this.ccY.acI();
    }

    public void d(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.ccW == null) {
            this.ccW = new o(this.ccV, this.cdc);
            this.ccW.a(this);
            this.ccW.setCheckBoxStateChangedListener(new x(this));
            this.mListView.setAdapter((ListAdapter) this.ccW);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.mListView.setVisibility(8);
            if (!this.cdc) {
                this.ccZ.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.mListView.setVisibility(0);
        this.ccW.setData(list);
        this.ccW.notifyDataSetChanged();
        if (!this.cdc) {
            this.ccZ.setVisibility(0);
        }
    }

    public void acU() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.ccV.getPageContext());
        }
    }

    public void acV() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [383=4] */
    private void acW() {
        int dimensionPixelSize = this.ccV.getResources().getDimensionPixelSize(n.d.invite_friend_candidate_item_height) + this.ccV.getResources().getDimensionPixelSize(n.d.invite_friend_candidate_padding_bottom) + this.ccV.getResources().getDimensionPixelSize(n.d.invite_friend_candidate_padding_top);
        this.mListFooter = new View(this.ccV.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.mListView.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.ccY.d(aVar);
            iP(this.ccY.getItemLength());
            acX();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.ccY.f(aVar);
            iP(this.ccY.getItemLength());
            acX();
        }
    }

    private void acX() {
        if (this.ccY.getItemLength() > 0) {
            this.cda.setEnabled(true);
        } else {
            this.cda.setEnabled(false);
        }
    }

    public void acY() {
        com.baidu.adp.lib.util.k.c(this.ccV.getPageContext().getPageActivity(), this.bXx);
    }

    private void iP(int i) {
        this.cda.setText(String.format(this.ccV.getPageContext().getString(n.i.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int acZ() {
        return this.cdb;
    }

    public void iQ(int i) {
        this.cdb = i;
        this.ccY.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.ccY.e(aVar);
        }
    }

    public void onDestroy() {
        this.bXx.removeTextChangedListener(this.aGT);
    }
}
