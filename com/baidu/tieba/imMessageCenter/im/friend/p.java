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
    private BdListView Im;
    private View QK;
    private EditText dbN;
    private View dfA;
    private View dfB;
    private TextView dfC;
    private ImageView dfD;
    private final InviteFriendListActivity dfr;
    private o dfs;
    private View dft;
    private InviteFriendCandidateList dfu;
    private LinearLayout dfv;
    private Button dfw;
    private int dfx;
    private boolean dfy;
    private TextView dfz;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dfx = 0;
        this.dfr = inviteFriendListActivity;
        this.dfy = z;
        wv();
    }

    public View getRootView() {
        return this.QK;
    }

    private void wv() {
        this.dfr.setContentView(w.j.invite_friend_list);
        this.QK = this.dfr.findViewById(w.h.root_view);
        asC();
        this.Im = (BdListView) this.QK.findViewById(w.h.friend_list);
        this.Im.setOnItemClickListener(this.dfr);
        if (this.dfy) {
            this.mNoDataView = NoDataViewFactory.a(this.dfr.getPageContext().getPageActivity(), this.QK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aIX), NoDataViewFactory.d.C(w.l.no_friends, w.l.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dfr.getPageContext().getPageActivity(), this.QK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aIX), NoDataViewFactory.d.C(w.l.no_chat_friends, w.l.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m9getInst().getResources().getString(w.l.find_new_friend), new q(this))));
        }
        this.mProgress = (ProgressBar) this.QK.findViewById(w.h.progress);
        this.dfu = (InviteFriendCandidateList) this.QK.findViewById(w.h.candidate_list);
        this.dfu.a(new r(this));
        this.dfv = (LinearLayout) this.QK.findViewById(w.h.invite_candidate);
        this.dft = this.QK.findViewById(w.h.invite_candidate_border);
        if (this.dfy) {
            this.dfv.setVisibility(8);
            this.dft.setVisibility(8);
        }
        asM();
        this.dfw = (Button) this.QK.findViewById(w.h.button_send);
        this.dfw.setOnClickListener(this.dfr);
        ww();
        asE();
        lX(0);
    }

    private void asC() {
        this.mNavigationBar = (NavigationBar) this.QK.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.dfy) {
            this.dfz = this.mNavigationBar.setTitleText(w.l.invite_contact_title);
        } else {
            this.dfz = this.mNavigationBar.setTitleText(w.l.invite_friend);
        }
        this.dfB = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.add_new_friend_text, new t(this));
        this.dfD = (ImageView) this.dfB.findViewById(w.h.new_friend_search);
        this.dfA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dfA.setVisibility(8);
        this.dbN = (EditText) this.dfA.findViewById(w.h.search_bar_edit);
        if (this.dbN.getParent() != null) {
            ((View) this.dbN.getParent()).setFocusable(true);
            ((View) this.dbN.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new u(this);
        this.dbN.addTextChangedListener(this.mTextWatcher);
        this.dfC = (TextView) this.dfA.findViewById(w.h.search_bar_delete_button);
        this.dfC.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asD() {
        if (this.dfr != null) {
            this.dfr.asA();
        }
    }

    public void ww() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.dfr.getLayoutMode().ai(skinType == 1);
        this.dfr.getLayoutMode().t(this.QK);
        aq.b(this.dfD, w.g.icon_search_bg_s, w.g.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dfr.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dfr.getPageContext(), skinType);
        aq.j(this.mListFooter, w.g.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void asE() {
        this.Im.setOnTouchListener(new w(this));
    }

    public void asF() {
        com.baidu.adp.lib.util.k.b(this.dfr.getPageContext().getPageActivity(), this.dbN);
        this.dfA.setVisibility(8);
        this.dfz.setVisibility(0);
        this.dfB.setVisibility(0);
        this.dbN.getText().clear();
    }

    public boolean asG() {
        return this.dfA != null && this.dfA.getVisibility() == 0;
    }

    public int asH() {
        return this.dfw.getId();
    }

    public String asI() {
        Editable text = this.dbN.getText();
        return text != null ? text.toString() : "";
    }

    public String asJ() {
        return this.dfu.asx();
    }

    public void k(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dfs == null) {
            this.dfs = new o(this.dfr, this.dfy);
            this.dfs.a(this);
            this.dfs.a(new x(this));
            this.Im.setAdapter((ListAdapter) this.dfs);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Im.setVisibility(8);
            if (!this.dfy) {
                this.dfv.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Im.setVisibility(0);
        this.dfs.setData(list);
        this.dfs.notifyDataSetChanged();
        if (!this.dfy) {
            this.dfv.setVisibility(0);
        }
    }

    public void asK() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dfr.getPageContext());
        }
    }

    public void asL() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [387=4] */
    private void asM() {
        int dimensionPixelSize = this.dfr.getResources().getDimensionPixelSize(w.f.ds80) + this.dfr.getResources().getDimensionPixelSize(w.f.ds16) + this.dfr.getResources().getDimensionPixelSize(w.f.ds16);
        this.mListFooter = new View(this.dfr.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Im.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dfu.d(aVar);
            lX(this.dfu.getItemLength());
            asN();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dfu.f(aVar);
            lX(this.dfu.getItemLength());
            asN();
        }
    }

    private void asN() {
        if (this.dfu.getItemLength() > 0) {
            this.dfw.setEnabled(true);
        } else {
            this.dfw.setEnabled(false);
        }
    }

    public void asO() {
        com.baidu.adp.lib.util.k.b(this.dfr.getPageContext().getPageActivity(), this.dbN);
    }

    private void lX(int i) {
        this.dfw.setText(String.format(this.dfr.getPageContext().getString(w.l.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int asP() {
        return this.dfx;
    }

    public void lY(int i) {
        this.dfx = i;
        this.dfu.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dfu.e(aVar);
        }
    }

    public void onDestroy() {
        this.dbN.removeTextChangedListener(this.mTextWatcher);
    }
}
