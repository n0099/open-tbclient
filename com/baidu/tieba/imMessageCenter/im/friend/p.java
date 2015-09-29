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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.i;
import com.baidu.tieba.imMessageCenter.im.friend.o;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.f<InviteFriendListActivity> implements o.b {
    private TextWatcher aEP;
    private EditText bHL;
    private final InviteFriendListActivity bNl;
    private o bNm;
    private View bNn;
    private InviteFriendCandidateList bNo;
    private LinearLayout bNp;
    private Button bNq;
    private View bNr;
    private int bNs;
    private boolean bNt;
    private TextView bNu;
    private View bNv;
    private View bNw;
    private TextView bNx;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.bNs = 0;
        this.bNl = inviteFriendListActivity;
        this.bNt = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.bNl.setContentView(i.g.invite_friend_list);
        this.mRoot = this.bNl.findViewById(i.f.root_view);
        Ok();
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.friend_list);
        this.mListView.setOnItemClickListener(this.bNl);
        if (this.bNt) {
            this.mNoDataView = NoDataViewFactory.a(this.bNl.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(i.h.no_friends, i.h.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.bNl.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(i.h.no_chat_friends, i.h.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m411getInst().getResources().getString(i.h.find_new_friend), new q(this))));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(i.f.progress);
        this.bNo = (InviteFriendCandidateList) this.mRoot.findViewById(i.f.candidate_list);
        this.bNo.a(new r(this));
        this.bNp = (LinearLayout) this.mRoot.findViewById(i.f.invite_candidate);
        this.bNn = this.mRoot.findViewById(i.f.invite_candidate_border);
        if (this.bNt) {
            this.bNp.setVisibility(8);
            this.bNn.setVisibility(8);
        }
        Zz();
        this.bNq = (Button) this.mRoot.findViewById(i.f.button_send);
        this.bNq.setOnClickListener(this.bNl);
        vA();
        Zr();
        hO(0);
    }

    private void Ok() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.bNt) {
            this.bNu = this.mNavigationBar.setTitleText(i.h.invite_contact_title);
        } else {
            this.bNu = this.mNavigationBar.setTitleText(i.h.invite_friend);
        }
        this.bNw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.add_new_friend_text, new t(this));
        this.bNv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, i.g.navigationbar_search_edit, (View.OnClickListener) null);
        this.bNv.setVisibility(8);
        this.bHL = (EditText) this.bNv.findViewById(i.f.search_bar_edit);
        if (this.bHL.getParent() != null) {
            ((View) this.bHL.getParent()).setFocusable(true);
            ((View) this.bHL.getParent()).setFocusableInTouchMode(true);
        }
        this.aEP = new u(this);
        this.bHL.addTextChangedListener(this.aEP);
        this.bNx = (TextView) this.bNv.findViewById(i.f.search_bar_delete_button);
        this.bNx.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zq() {
        if (this.bNl != null) {
            this.bNl.Zo();
        }
    }

    public void vA() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bNl.getLayoutMode().ad(skinType == 1);
        this.bNl.getLayoutMode().k(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.bNl.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bNl.getPageContext(), skinType);
        am.i(this.bNr, i.e.invite_friend_list_item_bg_color);
        this.bNr.setEnabled(false);
    }

    public void Zr() {
        this.mListView.setOnTouchListener(new w(this));
    }

    public void Zs() {
        com.baidu.adp.lib.util.k.c(this.bNl.getPageContext().getPageActivity(), this.bHL);
        this.bNv.setVisibility(8);
        this.bNu.setVisibility(0);
        this.bNw.setVisibility(0);
        this.bHL.getText().clear();
    }

    public boolean Zt() {
        return this.bNv != null && this.bNv.getVisibility() == 0;
    }

    public int Zu() {
        return this.bNq.getId();
    }

    public String Zv() {
        Editable text = this.bHL.getText();
        return text != null ? text.toString() : "";
    }

    public String Zw() {
        return this.bNo.Zl();
    }

    public void d(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.bNm == null) {
            this.bNm = new o(this.bNl, this.bNt);
            this.bNm.a(this);
            this.bNm.setCheckBoxStateChangedListener(new x(this));
            this.mListView.setAdapter((ListAdapter) this.bNm);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.mListView.setVisibility(8);
            if (!this.bNt) {
                this.bNp.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.mListView.setVisibility(0);
        this.bNm.setData(list);
        this.bNm.notifyDataSetChanged();
        if (!this.bNt) {
            this.bNp.setVisibility(0);
        }
    }

    public void Zx() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.bNl.getPageContext());
        }
    }

    public void Zy() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [383=4] */
    private void Zz() {
        int dimensionPixelSize = this.bNl.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_height) + this.bNl.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_padding_bottom) + this.bNl.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_padding_top);
        this.bNr = new View(this.bNl.getPageContext().getPageActivity());
        this.bNr.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bNr.setEnabled(false);
        this.mListView.addFooterView(this.bNr);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bNo.d(aVar);
            hO(this.bNo.getItemLength());
            ZA();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bNo.f(aVar);
            hO(this.bNo.getItemLength());
            ZA();
        }
    }

    private void ZA() {
        if (this.bNo.getItemLength() > 0) {
            this.bNq.setEnabled(true);
        } else {
            this.bNq.setEnabled(false);
        }
    }

    public void ZB() {
        com.baidu.adp.lib.util.k.c(this.bNl.getPageContext().getPageActivity(), this.bHL);
    }

    private void hO(int i) {
        this.bNq.setText(String.format(this.bNl.getPageContext().getString(i.h.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int ZC() {
        return this.bNs;
    }

    public void hP(int i) {
        this.bNs = i;
        this.bNo.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bNo.e(aVar);
        }
    }

    public void onDestroy() {
        this.bHL.removeTextChangedListener(this.aEP);
    }
}
