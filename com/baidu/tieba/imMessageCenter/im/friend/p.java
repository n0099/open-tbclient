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
import com.baidu.tieba.r;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.f<InviteFriendListActivity> implements o.b {
    private BdListView Cj;
    private View MM;
    private TextWatcher aTr;
    private ProgressBar coW;
    private EditText dmQ;
    private ImageView dsA;
    private final InviteFriendListActivity dso;
    private o dsp;
    private View dsq;
    private InviteFriendCandidateList dsr;
    private LinearLayout dss;
    private Button dst;
    private int dsu;
    private boolean dsv;
    private TextView dsw;
    private View dsx;
    private View dsy;
    private TextView dsz;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.v mNoDataView;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dsu = 0;
        this.dso = inviteFriendListActivity;
        this.dsv = z;
        initialize();
    }

    public View getRootView() {
        return this.MM;
    }

    private void initialize() {
        this.dso.setContentView(r.h.invite_friend_list);
        this.MM = this.dso.findViewById(r.g.root_view);
        Vz();
        this.Cj = (BdListView) this.MM.findViewById(r.g.friend_list);
        this.Cj.setOnItemClickListener(this.dso);
        if (this.dsv) {
            this.mNoDataView = NoDataViewFactory.a(this.dso.getPageContext().getPageActivity(), this.MM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aEg), NoDataViewFactory.d.x(r.j.no_friends, r.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dso.getPageContext().getPageActivity(), this.MM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aEg), NoDataViewFactory.d.x(r.j.no_chat_friends, r.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m9getInst().getResources().getString(r.j.find_new_friend), new q(this))));
        }
        this.coW = (ProgressBar) this.MM.findViewById(r.g.progress);
        this.dsr = (InviteFriendCandidateList) this.MM.findViewById(r.g.candidate_list);
        this.dsr.a(new r(this));
        this.dss = (LinearLayout) this.MM.findViewById(r.g.invite_candidate);
        this.dsq = this.MM.findViewById(r.g.invite_candidate_border);
        if (this.dsv) {
            this.dss.setVisibility(8);
            this.dsq.setVisibility(8);
        }
        azb();
        this.dst = (Button) this.MM.findViewById(r.g.button_send);
        this.dst.setOnClickListener(this.dso);
        wH();
        ayU();
        mp(0);
    }

    private void Vz() {
        this.mNavigationBar = (NavigationBar) this.MM.findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.dsv) {
            this.dsw = this.mNavigationBar.setTitleText(r.j.invite_contact_title);
        } else {
            this.dsw = this.mNavigationBar.setTitleText(r.j.invite_friend);
        }
        this.dsy = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.add_new_friend_text, new t(this));
        this.dsA = (ImageView) this.dsy.findViewById(r.g.new_friend_search);
        this.dsx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.dsx.setVisibility(8);
        this.dmQ = (EditText) this.dsx.findViewById(r.g.search_bar_edit);
        if (this.dmQ.getParent() != null) {
            ((View) this.dmQ.getParent()).setFocusable(true);
            ((View) this.dmQ.getParent()).setFocusableInTouchMode(true);
        }
        this.aTr = new u(this);
        this.dmQ.addTextChangedListener(this.aTr);
        this.dsz = (TextView) this.dsx.findViewById(r.g.search_bar_delete_button);
        this.dsz.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayT() {
        if (this.dso != null) {
            this.dso.ayR();
        }
    }

    public void wH() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.dso.getLayoutMode().ah(skinType == 1);
        this.dso.getLayoutMode().x(this.MM);
        av.b(this.dsA, r.f.icon_search_bg_s, r.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dso.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dso.getPageContext(), skinType);
        av.k(this.mListFooter, r.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void ayU() {
        this.Cj.setOnTouchListener(new w(this));
    }

    public void ayV() {
        com.baidu.adp.lib.util.k.b(this.dso.getPageContext().getPageActivity(), this.dmQ);
        this.dsx.setVisibility(8);
        this.dsw.setVisibility(0);
        this.dsy.setVisibility(0);
        this.dmQ.getText().clear();
    }

    public boolean ayW() {
        return this.dsx != null && this.dsx.getVisibility() == 0;
    }

    public int ayX() {
        return this.dst.getId();
    }

    public String getSearchText() {
        Editable text = this.dmQ.getText();
        return text != null ? text.toString() : "";
    }

    public String ayY() {
        return this.dsr.ayO();
    }

    public void g(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dsp == null) {
            this.dsp = new o(this.dso, this.dsv);
            this.dsp.a(this);
            this.dsp.a(new x(this));
            this.Cj.setAdapter((ListAdapter) this.dsp);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Cj.setVisibility(8);
            if (!this.dsv) {
                this.dss.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Cj.setVisibility(0);
        this.dsp.setData(list);
        this.dsp.notifyDataSetChanged();
        if (!this.dsv) {
            this.dss.setVisibility(0);
        }
    }

    public void ayZ() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dso.getPageContext());
        }
    }

    public void aza() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [387=4] */
    private void azb() {
        int dimensionPixelSize = this.dso.getResources().getDimensionPixelSize(r.e.ds80) + this.dso.getResources().getDimensionPixelSize(r.e.ds16) + this.dso.getResources().getDimensionPixelSize(r.e.ds16);
        this.mListFooter = new View(this.dso.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Cj.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dsr.d(aVar);
            mp(this.dsr.getItemLength());
            azc();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dsr.f(aVar);
            mp(this.dsr.getItemLength());
            azc();
        }
    }

    private void azc() {
        if (this.dsr.getItemLength() > 0) {
            this.dst.setEnabled(true);
        } else {
            this.dst.setEnabled(false);
        }
    }

    public void azd() {
        com.baidu.adp.lib.util.k.b(this.dso.getPageContext().getPageActivity(), this.dmQ);
    }

    private void mp(int i) {
        this.dst.setText(String.format(this.dso.getPageContext().getString(r.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aze() {
        return this.dsu;
    }

    public void mq(int i) {
        this.dsu = i;
        this.dsr.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dsr.e(aVar);
        }
    }

    public void onDestroy() {
        this.dmQ.removeTextChangedListener(this.aTr);
    }
}
