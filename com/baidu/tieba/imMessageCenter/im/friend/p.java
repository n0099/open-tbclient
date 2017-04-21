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
    private BdListView Im;
    private View Rt;
    private EditText dhM;
    private final InviteFriendListActivity dln;
    private o dlo;
    private View dlp;
    private InviteFriendCandidateList dlq;
    private LinearLayout dlr;
    private Button dls;
    private int dlt;
    private boolean dlu;
    private TextView dlv;
    private View dlw;
    private View dlx;
    private TextView dly;
    private ImageView dlz;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dlt = 0;
        this.dln = inviteFriendListActivity;
        this.dlu = z;
        xk();
    }

    public View getRootView() {
        return this.Rt;
    }

    private void xk() {
        this.dln.setContentView(w.j.invite_friend_list);
        this.Rt = this.dln.findViewById(w.h.root_view);
        avH();
        this.Im = (BdListView) this.Rt.findViewById(w.h.friend_list);
        this.Im.setOnItemClickListener(this.dln);
        if (this.dlu) {
            this.mNoDataView = NoDataViewFactory.a(this.dln.getPageContext().getPageActivity(), this.Rt, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aIV), NoDataViewFactory.d.E(w.l.no_friends, w.l.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dln.getPageContext().getPageActivity(), this.Rt, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aIV), NoDataViewFactory.d.E(w.l.no_chat_friends, w.l.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m9getInst().getResources().getString(w.l.find_new_friend), new q(this))));
        }
        this.mProgress = (ProgressBar) this.Rt.findViewById(w.h.progress);
        this.dlq = (InviteFriendCandidateList) this.Rt.findViewById(w.h.candidate_list);
        this.dlq.a(new r(this));
        this.dlr = (LinearLayout) this.Rt.findViewById(w.h.invite_candidate);
        this.dlp = this.Rt.findViewById(w.h.invite_candidate_border);
        if (this.dlu) {
            this.dlr.setVisibility(8);
            this.dlp.setVisibility(8);
        }
        avR();
        this.dls = (Button) this.Rt.findViewById(w.h.button_send);
        this.dls.setOnClickListener(this.dln);
        xl();
        avJ();
        mk(0);
    }

    private void avH() {
        this.mNavigationBar = (NavigationBar) this.Rt.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.dlu) {
            this.dlv = this.mNavigationBar.setTitleText(w.l.invite_contact_title);
        } else {
            this.dlv = this.mNavigationBar.setTitleText(w.l.invite_friend);
        }
        this.dlx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.add_new_friend_text, new t(this));
        this.dlz = (ImageView) this.dlx.findViewById(w.h.new_friend_search);
        this.dlw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dlw.setVisibility(8);
        this.dhM = (EditText) this.dlw.findViewById(w.h.search_bar_edit);
        if (this.dhM.getParent() != null) {
            ((View) this.dhM.getParent()).setFocusable(true);
            ((View) this.dhM.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new u(this);
        this.dhM.addTextChangedListener(this.mTextWatcher);
        this.dly = (TextView) this.dlw.findViewById(w.h.search_bar_delete_button);
        this.dly.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avI() {
        if (this.dln != null) {
            this.dln.avF();
        }
    }

    public void xl() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.dln.getLayoutMode().aj(skinType == 1);
        this.dln.getLayoutMode().t(this.Rt);
        aq.b(this.dlz, w.g.icon_search_bg_s, w.g.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dln.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dln.getPageContext(), skinType);
        aq.j(this.mListFooter, w.g.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void avJ() {
        this.Im.setOnTouchListener(new w(this));
    }

    public void avK() {
        com.baidu.adp.lib.util.k.b(this.dln.getPageContext().getPageActivity(), this.dhM);
        this.dlw.setVisibility(8);
        this.dlv.setVisibility(0);
        this.dlx.setVisibility(0);
        this.dhM.getText().clear();
    }

    public boolean avL() {
        return this.dlw != null && this.dlw.getVisibility() == 0;
    }

    public int avM() {
        return this.dls.getId();
    }

    public String avN() {
        Editable text = this.dhM.getText();
        return text != null ? text.toString() : "";
    }

    public String avO() {
        return this.dlq.avC();
    }

    public void i(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dlo == null) {
            this.dlo = new o(this.dln, this.dlu);
            this.dlo.a(this);
            this.dlo.a(new x(this));
            this.Im.setAdapter((ListAdapter) this.dlo);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Im.setVisibility(8);
            if (!this.dlu) {
                this.dlr.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Im.setVisibility(0);
        this.dlo.setData(list);
        this.dlo.notifyDataSetChanged();
        if (!this.dlu) {
            this.dlr.setVisibility(0);
        }
    }

    public void avP() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dln.getPageContext());
        }
    }

    public void avQ() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [387=4] */
    private void avR() {
        int dimensionPixelSize = this.dln.getResources().getDimensionPixelSize(w.f.ds80) + this.dln.getResources().getDimensionPixelSize(w.f.ds16) + this.dln.getResources().getDimensionPixelSize(w.f.ds16);
        this.mListFooter = new View(this.dln.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Im.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dlq.d(aVar);
            mk(this.dlq.getItemLength());
            avS();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dlq.f(aVar);
            mk(this.dlq.getItemLength());
            avS();
        }
    }

    private void avS() {
        if (this.dlq.getItemLength() > 0) {
            this.dls.setEnabled(true);
        } else {
            this.dls.setEnabled(false);
        }
    }

    public void avT() {
        com.baidu.adp.lib.util.k.b(this.dln.getPageContext().getPageActivity(), this.dhM);
    }

    private void mk(int i) {
        this.dls.setText(String.format(this.dln.getPageContext().getString(w.l.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int avU() {
        return this.dlt;
    }

    public void ml(int i) {
        this.dlt = i;
        this.dlq.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dlq.e(aVar);
        }
    }

    public void onDestroy() {
        this.dhM.removeTextChangedListener(this.mTextWatcher);
    }
}
