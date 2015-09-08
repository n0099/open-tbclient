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
    private TextWatcher aFT;
    private EditText bEI;
    private final InviteFriendListActivity bKg;
    private o bKh;
    private View bKi;
    private InviteFriendCandidateList bKj;
    private LinearLayout bKk;
    private Button bKl;
    private View bKm;
    private int bKn;
    private boolean bKo;
    private TextView bKp;
    private View bKq;
    private View bKr;
    private TextView bKs;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.u mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.bKn = 0;
        this.bKg = inviteFriendListActivity;
        this.bKo = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.bKg.setContentView(i.g.invite_friend_list);
        this.mRoot = this.bKg.findViewById(i.f.root_view);
        Oj();
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.friend_list);
        this.mListView.setOnItemClickListener(this.bKg);
        if (this.bKo) {
            this.mNoDataView = NoDataViewFactory.a(this.bKg.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(i.h.no_friends, i.h.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.bKg.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(i.h.no_chat_friends, i.h.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m411getInst().getResources().getString(i.h.find_new_friend), new q(this))));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(i.f.progress);
        this.bKj = (InviteFriendCandidateList) this.mRoot.findViewById(i.f.candidate_list);
        this.bKj.a(new r(this));
        this.bKk = (LinearLayout) this.mRoot.findViewById(i.f.invite_candidate);
        this.bKi = this.mRoot.findViewById(i.f.invite_candidate_border);
        if (this.bKo) {
            this.bKk.setVisibility(8);
            this.bKi.setVisibility(8);
        }
        YR();
        this.bKl = (Button) this.mRoot.findViewById(i.f.button_send);
        this.bKl.setOnClickListener(this.bKg);
        vI();
        YJ();
        hI(0);
    }

    private void Oj() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.bKo) {
            this.bKp = this.mNavigationBar.setTitleText(i.h.invite_contact_title);
        } else {
            this.bKp = this.mNavigationBar.setTitleText(i.h.invite_friend);
        }
        this.bKr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.add_new_friend_text, new t(this));
        this.bKq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, i.g.navigationbar_search_edit, (View.OnClickListener) null);
        this.bKq.setVisibility(8);
        this.bEI = (EditText) this.bKq.findViewById(i.f.search_bar_edit);
        if (this.bEI.getParent() != null) {
            ((View) this.bEI.getParent()).setFocusable(true);
            ((View) this.bEI.getParent()).setFocusableInTouchMode(true);
        }
        this.aFT = new u(this);
        this.bEI.addTextChangedListener(this.aFT);
        this.bKs = (TextView) this.bKq.findViewById(i.f.search_bar_delete_button);
        this.bKs.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YI() {
        if (this.bKg != null) {
            this.bKg.YG();
        }
    }

    public void vI() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bKg.getLayoutMode().ad(skinType == 1);
        this.bKg.getLayoutMode().k(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.bKg.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bKg.getPageContext(), skinType);
        al.h(this.bKm, i.e.invite_friend_list_item_bg_color);
        this.bKm.setEnabled(false);
    }

    public void YJ() {
        this.mListView.setOnTouchListener(new w(this));
    }

    public void YK() {
        com.baidu.adp.lib.util.k.c(this.bKg.getPageContext().getPageActivity(), this.bEI);
        this.bKq.setVisibility(8);
        this.bKp.setVisibility(0);
        this.bKr.setVisibility(0);
        this.bEI.getText().clear();
    }

    public boolean YL() {
        return this.bKq != null && this.bKq.getVisibility() == 0;
    }

    public int YM() {
        return this.bKl.getId();
    }

    public String YN() {
        Editable text = this.bEI.getText();
        return text != null ? text.toString() : "";
    }

    public String YO() {
        return this.bKj.YD();
    }

    public void c(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.bKh == null) {
            this.bKh = new o(this.bKg, this.bKo);
            this.bKh.a(this);
            this.bKh.setCheckBoxStateChangedListener(new x(this));
            this.mListView.setAdapter((ListAdapter) this.bKh);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.mListView.setVisibility(8);
            if (!this.bKo) {
                this.bKk.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.mListView.setVisibility(0);
        this.bKh.setData(list);
        this.bKh.notifyDataSetChanged();
        if (!this.bKo) {
            this.bKk.setVisibility(0);
        }
    }

    public void YP() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.bKg.getPageContext());
        }
    }

    public void YQ() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [383=4] */
    private void YR() {
        int dimensionPixelSize = this.bKg.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_height) + this.bKg.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_padding_bottom) + this.bKg.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_padding_top);
        this.bKm = new View(this.bKg.getPageContext().getPageActivity());
        this.bKm.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bKm.setEnabled(false);
        this.mListView.addFooterView(this.bKm);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bKj.d(aVar);
            hI(this.bKj.getItemLength());
            YS();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bKj.f(aVar);
            hI(this.bKj.getItemLength());
            YS();
        }
    }

    private void YS() {
        if (this.bKj.getItemLength() > 0) {
            this.bKl.setEnabled(true);
        } else {
            this.bKl.setEnabled(false);
        }
    }

    public void YT() {
        com.baidu.adp.lib.util.k.c(this.bKg.getPageContext().getPageActivity(), this.bEI);
    }

    private void hI(int i) {
        this.bKl.setText(String.format(this.bKg.getPageContext().getString(i.h.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int YU() {
        return this.bKn;
    }

    public void hJ(int i) {
        this.bKn = i;
        this.bKj.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bKj.e(aVar);
        }
    }

    public void onDestroy() {
        this.bEI.removeTextChangedListener(this.aFT);
    }
}
