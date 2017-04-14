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
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.e<InviteFriendListActivity> implements o.b {
    private BdListView Ik;
    private View Rr;
    private EditText dfv;
    private final InviteFriendListActivity diW;
    private o diX;
    private View diY;
    private InviteFriendCandidateList diZ;
    private LinearLayout dja;
    private Button djb;
    private int djc;
    private boolean djd;
    private TextView dje;
    private View djf;
    private View djg;
    private TextView djh;
    private ImageView dji;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.djc = 0;
        this.diW = inviteFriendListActivity;
        this.djd = z;
        xk();
    }

    public View getRootView() {
        return this.Rr;
    }

    private void xk() {
        this.diW.setContentView(w.j.invite_friend_list);
        this.Rr = this.diW.findViewById(w.h.root_view);
        auG();
        this.Ik = (BdListView) this.Rr.findViewById(w.h.friend_list);
        this.Ik.setOnItemClickListener(this.diW);
        if (this.djd) {
            this.mNoDataView = NoDataViewFactory.a(this.diW.getPageContext().getPageActivity(), this.Rr, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aIT), NoDataViewFactory.d.E(w.l.no_friends, w.l.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.diW.getPageContext().getPageActivity(), this.Rr, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aIT), NoDataViewFactory.d.E(w.l.no_chat_friends, w.l.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m9getInst().getResources().getString(w.l.find_new_friend), new q(this))));
        }
        this.mProgress = (ProgressBar) this.Rr.findViewById(w.h.progress);
        this.diZ = (InviteFriendCandidateList) this.Rr.findViewById(w.h.candidate_list);
        this.diZ.a(new r(this));
        this.dja = (LinearLayout) this.Rr.findViewById(w.h.invite_candidate);
        this.diY = this.Rr.findViewById(w.h.invite_candidate_border);
        if (this.djd) {
            this.dja.setVisibility(8);
            this.diY.setVisibility(8);
        }
        auQ();
        this.djb = (Button) this.Rr.findViewById(w.h.button_send);
        this.djb.setOnClickListener(this.diW);
        xl();
        auI();
        me(0);
    }

    private void auG() {
        this.mNavigationBar = (NavigationBar) this.Rr.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.djd) {
            this.dje = this.mNavigationBar.setTitleText(w.l.invite_contact_title);
        } else {
            this.dje = this.mNavigationBar.setTitleText(w.l.invite_friend);
        }
        this.djg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.add_new_friend_text, new t(this));
        this.dji = (ImageView) this.djg.findViewById(w.h.new_friend_search);
        this.djf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.djf.setVisibility(8);
        this.dfv = (EditText) this.djf.findViewById(w.h.search_bar_edit);
        if (this.dfv.getParent() != null) {
            ((View) this.dfv.getParent()).setFocusable(true);
            ((View) this.dfv.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new u(this);
        this.dfv.addTextChangedListener(this.mTextWatcher);
        this.djh = (TextView) this.djf.findViewById(w.h.search_bar_delete_button);
        this.djh.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auH() {
        if (this.diW != null) {
            this.diW.auE();
        }
    }

    public void xl() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.diW.getLayoutMode().aj(skinType == 1);
        this.diW.getLayoutMode().t(this.Rr);
        aq.b(this.dji, w.g.icon_search_bg_s, w.g.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.diW.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.diW.getPageContext(), skinType);
        aq.j(this.mListFooter, w.g.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void auI() {
        this.Ik.setOnTouchListener(new w(this));
    }

    public void auJ() {
        com.baidu.adp.lib.util.k.b(this.diW.getPageContext().getPageActivity(), this.dfv);
        this.djf.setVisibility(8);
        this.dje.setVisibility(0);
        this.djg.setVisibility(0);
        this.dfv.getText().clear();
    }

    public boolean auK() {
        return this.djf != null && this.djf.getVisibility() == 0;
    }

    public int auL() {
        return this.djb.getId();
    }

    public String auM() {
        Editable text = this.dfv.getText();
        return text != null ? text.toString() : "";
    }

    public String auN() {
        return this.diZ.auB();
    }

    public void i(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.diX == null) {
            this.diX = new o(this.diW, this.djd);
            this.diX.a(this);
            this.diX.a(new x(this));
            this.Ik.setAdapter((ListAdapter) this.diX);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Ik.setVisibility(8);
            if (!this.djd) {
                this.dja.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Ik.setVisibility(0);
        this.diX.setData(list);
        this.diX.notifyDataSetChanged();
        if (!this.djd) {
            this.dja.setVisibility(0);
        }
    }

    public void auO() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.diW.getPageContext());
        }
    }

    public void auP() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [387=4] */
    private void auQ() {
        int dimensionPixelSize = this.diW.getResources().getDimensionPixelSize(w.f.ds80) + this.diW.getResources().getDimensionPixelSize(w.f.ds16) + this.diW.getResources().getDimensionPixelSize(w.f.ds16);
        this.mListFooter = new View(this.diW.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Ik.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.diZ.d(aVar);
            me(this.diZ.getItemLength());
            auR();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.diZ.f(aVar);
            me(this.diZ.getItemLength());
            auR();
        }
    }

    private void auR() {
        if (this.diZ.getItemLength() > 0) {
            this.djb.setEnabled(true);
        } else {
            this.djb.setEnabled(false);
        }
    }

    public void auS() {
        com.baidu.adp.lib.util.k.b(this.diW.getPageContext().getPageActivity(), this.dfv);
    }

    private void me(int i) {
        this.djb.setText(String.format(this.diW.getPageContext().getString(w.l.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int auT() {
        return this.djc;
    }

    public void mf(int i) {
        this.djc = i;
        this.diZ.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.diZ.e(aVar);
        }
    }

    public void onDestroy() {
        this.dfv.removeTextChangedListener(this.mTextWatcher);
    }
}
