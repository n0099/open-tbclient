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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.i;
import com.baidu.tieba.imMessageCenter.im.friend.o;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.f<InviteFriendListActivity> implements o.b {
    private TextWatcher aFa;
    private EditText bHW;
    private LinearLayout bNA;
    private Button bNB;
    private View bNC;
    private int bND;
    private boolean bNE;
    private TextView bNF;
    private View bNG;
    private View bNH;
    private TextView bNI;
    private final InviteFriendListActivity bNw;
    private o bNx;
    private View bNy;
    private InviteFriendCandidateList bNz;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.bND = 0;
        this.bNw = inviteFriendListActivity;
        this.bNE = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.bNw.setContentView(i.g.invite_friend_list);
        this.mRoot = this.bNw.findViewById(i.f.root_view);
        Ok();
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.friend_list);
        this.mListView.setOnItemClickListener(this.bNw);
        if (this.bNE) {
            this.mNoDataView = NoDataViewFactory.a(this.bNw.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(i.h.no_friends, i.h.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.bNw.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(i.h.no_chat_friends, i.h.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m411getInst().getResources().getString(i.h.find_new_friend), new q(this))));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(i.f.progress);
        this.bNz = (InviteFriendCandidateList) this.mRoot.findViewById(i.f.candidate_list);
        this.bNz.a(new r(this));
        this.bNA = (LinearLayout) this.mRoot.findViewById(i.f.invite_candidate);
        this.bNy = this.mRoot.findViewById(i.f.invite_candidate_border);
        if (this.bNE) {
            this.bNA.setVisibility(8);
            this.bNy.setVisibility(8);
        }
        Zz();
        this.bNB = (Button) this.mRoot.findViewById(i.f.button_send);
        this.bNB.setOnClickListener(this.bNw);
        vA();
        Zr();
        hO(0);
    }

    private void Ok() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.bNE) {
            this.bNF = this.mNavigationBar.setTitleText(i.h.invite_contact_title);
        } else {
            this.bNF = this.mNavigationBar.setTitleText(i.h.invite_friend);
        }
        this.bNH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.add_new_friend_text, new t(this));
        this.bNG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, i.g.navigationbar_search_edit, (View.OnClickListener) null);
        this.bNG.setVisibility(8);
        this.bHW = (EditText) this.bNG.findViewById(i.f.search_bar_edit);
        if (this.bHW.getParent() != null) {
            ((View) this.bHW.getParent()).setFocusable(true);
            ((View) this.bHW.getParent()).setFocusableInTouchMode(true);
        }
        this.aFa = new u(this);
        this.bHW.addTextChangedListener(this.aFa);
        this.bNI = (TextView) this.bNG.findViewById(i.f.search_bar_delete_button);
        this.bNI.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zq() {
        if (this.bNw != null) {
            this.bNw.Zo();
        }
    }

    public void vA() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bNw.getLayoutMode().ad(skinType == 1);
        this.bNw.getLayoutMode().k(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.bNw.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bNw.getPageContext(), skinType);
        an.i(this.bNC, i.e.invite_friend_list_item_bg_color);
        this.bNC.setEnabled(false);
    }

    public void Zr() {
        this.mListView.setOnTouchListener(new w(this));
    }

    public void Zs() {
        com.baidu.adp.lib.util.k.c(this.bNw.getPageContext().getPageActivity(), this.bHW);
        this.bNG.setVisibility(8);
        this.bNF.setVisibility(0);
        this.bNH.setVisibility(0);
        this.bHW.getText().clear();
    }

    public boolean Zt() {
        return this.bNG != null && this.bNG.getVisibility() == 0;
    }

    public int Zu() {
        return this.bNB.getId();
    }

    public String Zv() {
        Editable text = this.bHW.getText();
        return text != null ? text.toString() : "";
    }

    public String Zw() {
        return this.bNz.Zl();
    }

    public void d(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.bNx == null) {
            this.bNx = new o(this.bNw, this.bNE);
            this.bNx.a(this);
            this.bNx.setCheckBoxStateChangedListener(new x(this));
            this.mListView.setAdapter((ListAdapter) this.bNx);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.mListView.setVisibility(8);
            if (!this.bNE) {
                this.bNA.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.mListView.setVisibility(0);
        this.bNx.setData(list);
        this.bNx.notifyDataSetChanged();
        if (!this.bNE) {
            this.bNA.setVisibility(0);
        }
    }

    public void Zx() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.bNw.getPageContext());
        }
    }

    public void Zy() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [383=4] */
    private void Zz() {
        int dimensionPixelSize = this.bNw.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_height) + this.bNw.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_padding_bottom) + this.bNw.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_padding_top);
        this.bNC = new View(this.bNw.getPageContext().getPageActivity());
        this.bNC.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bNC.setEnabled(false);
        this.mListView.addFooterView(this.bNC);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bNz.d(aVar);
            hO(this.bNz.getItemLength());
            ZA();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bNz.f(aVar);
            hO(this.bNz.getItemLength());
            ZA();
        }
    }

    private void ZA() {
        if (this.bNz.getItemLength() > 0) {
            this.bNB.setEnabled(true);
        } else {
            this.bNB.setEnabled(false);
        }
    }

    public void ZB() {
        com.baidu.adp.lib.util.k.c(this.bNw.getPageContext().getPageActivity(), this.bHW);
    }

    private void hO(int i) {
        this.bNB.setText(String.format(this.bNw.getPageContext().getString(i.h.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int ZC() {
        return this.bND;
    }

    public void hP(int i) {
        this.bND = i;
        this.bNz.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bNz.e(aVar);
        }
    }

    public void onDestroy() {
        this.bHW.removeTextChangedListener(this.aFa);
    }
}
