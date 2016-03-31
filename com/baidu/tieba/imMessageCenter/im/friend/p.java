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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.imMessageCenter.im.friend.o;
import com.baidu.tieba.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.f<InviteFriendListActivity> implements o.b {
    private BdListView Je;
    private View PL;
    private TextWatcher aMu;
    private ProgressBar aQj;
    private EditText cqC;
    private final InviteFriendListActivity cwa;
    private o cwb;
    private View cwc;
    private InviteFriendCandidateList cwd;
    private LinearLayout cwe;
    private Button cwf;
    private int cwg;
    private boolean cwh;
    private TextView cwi;
    private View cwj;
    private View cwk;
    private TextView cwl;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.p mNoDataView;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.cwg = 0;
        this.cwa = inviteFriendListActivity;
        this.cwh = z;
        initialize();
    }

    public View getRootView() {
        return this.PL;
    }

    private void initialize() {
        this.cwa.setContentView(t.h.invite_friend_list);
        this.PL = this.cwa.findViewById(t.g.root_view);
        Ux();
        this.Je = (BdListView) this.PL.findViewById(t.g.friend_list);
        this.Je.setOnItemClickListener(this.cwa);
        if (this.cwh) {
            this.mNoDataView = NoDataViewFactory.a(this.cwa.getPageContext().getPageActivity(), this.PL, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.v(t.j.no_friends, t.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.cwa.getPageContext().getPageActivity(), this.PL, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.v(t.j.no_chat_friends, t.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m411getInst().getResources().getString(t.j.find_new_friend), new q(this))));
        }
        this.aQj = (ProgressBar) this.PL.findViewById(t.g.progress);
        this.cwd = (InviteFriendCandidateList) this.PL.findViewById(t.g.candidate_list);
        this.cwd.a(new r(this));
        this.cwe = (LinearLayout) this.PL.findViewById(t.g.invite_candidate);
        this.cwc = this.PL.findViewById(t.g.invite_candidate_border);
        if (this.cwh) {
            this.cwe.setVisibility(8);
            this.cwc.setVisibility(8);
        }
        akJ();
        this.cwf = (Button) this.PL.findViewById(t.g.button_send);
        this.cwf.setOnClickListener(this.cwa);
        xy();
        akB();
        ks(0);
    }

    private void Ux() {
        this.mNavigationBar = (NavigationBar) this.PL.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.cwh) {
            this.cwi = this.mNavigationBar.setTitleText(t.j.invite_contact_title);
        } else {
            this.cwi = this.mNavigationBar.setTitleText(t.j.invite_friend);
        }
        this.cwk = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.add_new_friend_text, new t(this));
        this.cwj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.cwj.setVisibility(8);
        this.cqC = (EditText) this.cwj.findViewById(t.g.search_bar_edit);
        if (this.cqC.getParent() != null) {
            ((View) this.cqC.getParent()).setFocusable(true);
            ((View) this.cqC.getParent()).setFocusableInTouchMode(true);
        }
        this.aMu = new u(this);
        this.cqC.addTextChangedListener(this.aMu);
        this.cwl = (TextView) this.cwj.findViewById(t.g.search_bar_delete_button);
        this.cwl.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akA() {
        if (this.cwa != null) {
            this.cwa.aky();
        }
    }

    public void xy() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.cwa.getLayoutMode().ab(skinType == 1);
        this.cwa.getLayoutMode().x(this.PL);
        this.mNavigationBar.onChangeSkinType(this.cwa.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.cwa.getPageContext(), skinType);
        at.k(this.mListFooter, t.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void akB() {
        this.Je.setOnTouchListener(new w(this));
    }

    public void akC() {
        com.baidu.adp.lib.util.k.c(this.cwa.getPageContext().getPageActivity(), this.cqC);
        this.cwj.setVisibility(8);
        this.cwi.setVisibility(0);
        this.cwk.setVisibility(0);
        this.cqC.getText().clear();
    }

    public boolean akD() {
        return this.cwj != null && this.cwj.getVisibility() == 0;
    }

    public int akE() {
        return this.cwf.getId();
    }

    public String akF() {
        Editable text = this.cqC.getText();
        return text != null ? text.toString() : "";
    }

    public String akG() {
        return this.cwd.akv();
    }

    public void d(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.cwb == null) {
            this.cwb = new o(this.cwa, this.cwh);
            this.cwb.a(this);
            this.cwb.a(new x(this));
            this.Je.setAdapter((ListAdapter) this.cwb);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Je.setVisibility(8);
            if (!this.cwh) {
                this.cwe.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Je.setVisibility(0);
        this.cwb.setData(list);
        this.cwb.notifyDataSetChanged();
        if (!this.cwh) {
            this.cwe.setVisibility(0);
        }
    }

    public void akH() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.cwa.getPageContext());
        }
    }

    public void akI() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [383=4] */
    private void akJ() {
        int dimensionPixelSize = this.cwa.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_height) + this.cwa.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_padding_bottom) + this.cwa.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_padding_top);
        this.mListFooter = new View(this.cwa.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Je.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.cwd.d(aVar);
            ks(this.cwd.getItemLength());
            akK();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.cwd.f(aVar);
            ks(this.cwd.getItemLength());
            akK();
        }
    }

    private void akK() {
        if (this.cwd.getItemLength() > 0) {
            this.cwf.setEnabled(true);
        } else {
            this.cwf.setEnabled(false);
        }
    }

    public void akL() {
        com.baidu.adp.lib.util.k.c(this.cwa.getPageContext().getPageActivity(), this.cqC);
    }

    private void ks(int i) {
        this.cwf.setText(String.format(this.cwa.getPageContext().getString(t.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int akM() {
        return this.cwg;
    }

    public void kt(int i) {
        this.cwg = i;
        this.cwd.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.cwd.e(aVar);
        }
    }

    public void onDestroy() {
        this.cqC.removeTextChangedListener(this.aMu);
    }
}
