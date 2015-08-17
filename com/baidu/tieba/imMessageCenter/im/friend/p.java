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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.i;
import com.baidu.tieba.imMessageCenter.im.friend.o;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.f<InviteFriendListActivity> implements o.b {
    private TextWatcher aEl;
    private EditText bEb;
    private o bJA;
    private View bJB;
    private InviteFriendCandidateList bJC;
    private LinearLayout bJD;
    private Button bJE;
    private View bJF;
    private int bJG;
    private boolean bJH;
    private TextView bJI;
    private View bJJ;
    private View bJK;
    private TextView bJL;
    private final InviteFriendListActivity bJz;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.u mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.bJG = 0;
        this.bJz = inviteFriendListActivity;
        this.bJH = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.bJz.setContentView(i.g.invite_friend_list);
        this.mRoot = this.bJz.findViewById(i.f.root_view);
        Oi();
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.friend_list);
        this.mListView.setOnItemClickListener(this.bJz);
        if (this.bJH) {
            this.mNoDataView = NoDataViewFactory.a(this.bJz.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(i.C0057i.no_friends, i.C0057i.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.bJz.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(i.C0057i.no_chat_friends, i.C0057i.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m411getInst().getResources().getString(i.C0057i.find_new_friend), new q(this))));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(i.f.progress);
        this.bJC = (InviteFriendCandidateList) this.mRoot.findViewById(i.f.candidate_list);
        this.bJC.a(new r(this));
        this.bJD = (LinearLayout) this.mRoot.findViewById(i.f.invite_candidate);
        this.bJB = this.mRoot.findViewById(i.f.invite_candidate_border);
        if (this.bJH) {
            this.bJD.setVisibility(8);
            this.bJB.setVisibility(8);
        }
        YP();
        this.bJE = (Button) this.mRoot.findViewById(i.f.button_send);
        this.bJE.setOnClickListener(this.bJz);
        vD();
        YH();
        hy(0);
    }

    private void Oi() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.bJH) {
            this.bJI = this.mNavigationBar.setTitleText(i.C0057i.invite_contact_title);
        } else {
            this.bJI = this.mNavigationBar.setTitleText(i.C0057i.invite_friend);
        }
        this.bJK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.add_new_friend_text, new t(this));
        this.bJJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, i.g.navigationbar_search_edit, (View.OnClickListener) null);
        this.bJJ.setVisibility(8);
        this.bEb = (EditText) this.bJJ.findViewById(i.f.search_bar_edit);
        if (this.bEb.getParent() != null) {
            ((View) this.bEb.getParent()).setFocusable(true);
            ((View) this.bEb.getParent()).setFocusableInTouchMode(true);
        }
        this.aEl = new u(this);
        this.bEb.addTextChangedListener(this.aEl);
        this.bJL = (TextView) this.bJJ.findViewById(i.f.search_bar_delete_button);
        this.bJL.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YG() {
        if (this.bJz != null) {
            this.bJz.YE();
        }
    }

    public void vD() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bJz.getLayoutMode().ad(skinType == 1);
        this.bJz.getLayoutMode().k(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.bJz.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bJz.getPageContext(), skinType);
        al.i(this.bJF, i.e.invite_friend_list_item_bg_color);
        this.bJF.setEnabled(false);
    }

    public void YH() {
        this.mListView.setOnTouchListener(new w(this));
    }

    public void YI() {
        com.baidu.adp.lib.util.k.c(this.bJz.getPageContext().getPageActivity(), this.bEb);
        this.bJJ.setVisibility(8);
        this.bJI.setVisibility(0);
        this.bJK.setVisibility(0);
        this.bEb.getText().clear();
    }

    public boolean YJ() {
        return this.bJJ != null && this.bJJ.getVisibility() == 0;
    }

    public int YK() {
        return this.bJE.getId();
    }

    public String YL() {
        Editable text = this.bEb.getText();
        return text != null ? text.toString() : "";
    }

    public String YM() {
        return this.bJC.YB();
    }

    public void c(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.bJA == null) {
            this.bJA = new o(this.bJz, this.bJH);
            this.bJA.a(this);
            this.bJA.setCheckBoxStateChangedListener(new x(this));
            this.mListView.setAdapter((ListAdapter) this.bJA);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.mListView.setVisibility(8);
            if (!this.bJH) {
                this.bJD.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.mListView.setVisibility(0);
        this.bJA.setData(list);
        this.bJA.notifyDataSetChanged();
        if (!this.bJH) {
            this.bJD.setVisibility(0);
        }
    }

    public void YN() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.bJz.getPageContext());
        }
    }

    public void YO() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [383=4] */
    private void YP() {
        int dimensionPixelSize = this.bJz.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_height) + this.bJz.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_padding_bottom) + this.bJz.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_padding_top);
        this.bJF = new View(this.bJz.getPageContext().getPageActivity());
        this.bJF.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bJF.setEnabled(false);
        this.mListView.addFooterView(this.bJF);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bJC.d(aVar);
            hy(this.bJC.getItemLength());
            YQ();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bJC.f(aVar);
            hy(this.bJC.getItemLength());
            YQ();
        }
    }

    private void YQ() {
        if (this.bJC.getItemLength() > 0) {
            this.bJE.setEnabled(true);
        } else {
            this.bJE.setEnabled(false);
        }
    }

    public void YR() {
        com.baidu.adp.lib.util.k.c(this.bJz.getPageContext().getPageActivity(), this.bEb);
    }

    private void hy(int i) {
        this.bJE.setText(String.format(this.bJz.getPageContext().getString(i.C0057i.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int YS() {
        return this.bJG;
    }

    public void hz(int i) {
        this.bJG = i;
        this.bJC.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bJC.e(aVar);
        }
    }

    public void onDestroy() {
        this.bEb.removeTextChangedListener(this.aEl);
    }
}
