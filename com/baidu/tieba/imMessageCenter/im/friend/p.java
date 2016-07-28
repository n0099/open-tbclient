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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.imMessageCenter.im.friend.o;
import com.baidu.tieba.u;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.f<InviteFriendListActivity> implements o.b {
    private View KA;
    private TextWatcher aMV;
    private EditText cZK;
    private ProgressBar cdm;
    private final InviteFriendListActivity dfk;
    private o dfl;
    private View dfm;
    private InviteFriendCandidateList dfn;
    private LinearLayout dfo;
    private Button dfp;
    private int dfq;
    private boolean dfr;
    private TextView dfs;
    private View dft;
    private View dfu;
    private TextView dfv;
    private ImageView dfw;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.q mNoDataView;
    private BdListView zU;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dfq = 0;
        this.dfk = inviteFriendListActivity;
        this.dfr = z;
        initialize();
    }

    public View getRootView() {
        return this.KA;
    }

    private void initialize() {
        this.dfk.setContentView(u.h.invite_friend_list);
        this.KA = this.dfk.findViewById(u.g.root_view);
        Qu();
        this.zU = (BdListView) this.KA.findViewById(u.g.friend_list);
        this.zU.setOnItemClickListener(this.dfk);
        if (this.dfr) {
            this.mNoDataView = NoDataViewFactory.a(this.dfk.getPageContext().getPageActivity(), this.KA, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aBB), NoDataViewFactory.d.v(u.j.no_friends, u.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dfk.getPageContext().getPageActivity(), this.KA, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aBB), NoDataViewFactory.d.v(u.j.no_chat_friends, u.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m10getInst().getResources().getString(u.j.find_new_friend), new q(this))));
        }
        this.cdm = (ProgressBar) this.KA.findViewById(u.g.progress);
        this.dfn = (InviteFriendCandidateList) this.KA.findViewById(u.g.candidate_list);
        this.dfn.a(new r(this));
        this.dfo = (LinearLayout) this.KA.findViewById(u.g.invite_candidate);
        this.dfm = this.KA.findViewById(u.g.invite_candidate_border);
        if (this.dfr) {
            this.dfo.setVisibility(8);
            this.dfm.setVisibility(8);
        }
        atP();
        this.dfp = (Button) this.KA.findViewById(u.g.button_send);
        this.dfp.setOnClickListener(this.dfk);
        vm();
        atI();
        lE(0);
    }

    private void Qu() {
        this.mNavigationBar = (NavigationBar) this.KA.findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.dfr) {
            this.dfs = this.mNavigationBar.setTitleText(u.j.invite_contact_title);
        } else {
            this.dfs = this.mNavigationBar.setTitleText(u.j.invite_friend);
        }
        this.dfu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.add_new_friend_text, new t(this));
        this.dfw = (ImageView) this.dfu.findViewById(u.g.new_friend_search);
        this.dft = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, u.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.dft.setVisibility(8);
        this.cZK = (EditText) this.dft.findViewById(u.g.search_bar_edit);
        if (this.cZK.getParent() != null) {
            ((View) this.cZK.getParent()).setFocusable(true);
            ((View) this.cZK.getParent()).setFocusableInTouchMode(true);
        }
        this.aMV = new u(this);
        this.cZK.addTextChangedListener(this.aMV);
        this.dfv = (TextView) this.dft.findViewById(u.g.search_bar_delete_button);
        this.dfv.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atH() {
        if (this.dfk != null) {
            this.dfk.atF();
        }
    }

    public void vm() {
        int skinType = TbadkCoreApplication.m10getInst().getSkinType();
        this.dfk.getLayoutMode().af(skinType == 1);
        this.dfk.getLayoutMode().w(this.KA);
        av.b(this.dfw, u.f.icon_search_bg_s, u.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dfk.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dfk.getPageContext(), skinType);
        av.k(this.mListFooter, u.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void atI() {
        this.zU.setOnTouchListener(new w(this));
    }

    public void atJ() {
        com.baidu.adp.lib.util.k.b(this.dfk.getPageContext().getPageActivity(), this.cZK);
        this.dft.setVisibility(8);
        this.dfs.setVisibility(0);
        this.dfu.setVisibility(0);
        this.cZK.getText().clear();
    }

    public boolean atK() {
        return this.dft != null && this.dft.getVisibility() == 0;
    }

    public int atL() {
        return this.dfp.getId();
    }

    public String getSearchText() {
        Editable text = this.cZK.getText();
        return text != null ? text.toString() : "";
    }

    public String atM() {
        return this.dfn.atC();
    }

    public void g(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dfl == null) {
            this.dfl = new o(this.dfk, this.dfr);
            this.dfl.a(this);
            this.dfl.a(new x(this));
            this.zU.setAdapter((ListAdapter) this.dfl);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.zU.setVisibility(8);
            if (!this.dfr) {
                this.dfo.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.zU.setVisibility(0);
        this.dfl.setData(list);
        this.dfl.notifyDataSetChanged();
        if (!this.dfr) {
            this.dfo.setVisibility(0);
        }
    }

    public void atN() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dfk.getPageContext());
        }
    }

    public void atO() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [387=4] */
    private void atP() {
        int dimensionPixelSize = this.dfk.getResources().getDimensionPixelSize(u.e.ds80) + this.dfk.getResources().getDimensionPixelSize(u.e.ds16) + this.dfk.getResources().getDimensionPixelSize(u.e.ds16);
        this.mListFooter = new View(this.dfk.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.zU.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dfn.d(aVar);
            lE(this.dfn.getItemLength());
            atQ();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dfn.f(aVar);
            lE(this.dfn.getItemLength());
            atQ();
        }
    }

    private void atQ() {
        if (this.dfn.getItemLength() > 0) {
            this.dfp.setEnabled(true);
        } else {
            this.dfp.setEnabled(false);
        }
    }

    public void atR() {
        com.baidu.adp.lib.util.k.b(this.dfk.getPageContext().getPageActivity(), this.cZK);
    }

    private void lE(int i) {
        this.dfp.setText(String.format(this.dfk.getPageContext().getString(u.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int atS() {
        return this.dfq;
    }

    public void lF(int i) {
        this.dfq = i;
        this.dfn.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dfn.e(aVar);
        }
    }

    public void onDestroy() {
        this.cZK.removeTextChangedListener(this.aMV);
    }
}
