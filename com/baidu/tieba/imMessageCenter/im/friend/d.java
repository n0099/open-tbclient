package com.baidu.tieba.imMessageCenter.im.friend;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private View aGH;
    private BdListView avj;
    private View eMA;
    private View eMB;
    private TextView eMC;
    private ImageView eMD;
    private final InviteFriendListActivity eMr;
    private c eMs;
    private View eMt;
    private InviteFriendCandidateList eMu;
    private LinearLayout eMv;
    private Button eMw;
    private int eMx;
    private boolean eMy;
    private TextView eMz;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;
    private EditText rE;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.eMx = 0;
        this.eMr = inviteFriendListActivity;
        this.eMy = z;
        DQ();
    }

    public View getRootView() {
        return this.aGH;
    }

    private void DQ() {
        this.eMr.setContentView(d.h.invite_friend_list);
        this.aGH = this.eMr.findViewById(d.g.root_view);
        avL();
        this.avj = (BdListView) this.aGH.findViewById(d.g.friend_list);
        this.avj.setOnItemClickListener(this.eMr);
        if (this.eMy) {
            this.mNoDataView = NoDataViewFactory.a(this.eMr.getPageContext().getPageActivity(), this.aGH, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bAK), NoDataViewFactory.d.aC(d.j.no_friends, d.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.eMr.getPageContext().getPageActivity(), this.aGH, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bAK), NoDataViewFactory.d.aC(d.j.no_chat_friends, d.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.eMr.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.aGH.findViewById(d.g.progress);
        this.eMu = (InviteFriendCandidateList) this.aGH.findViewById(d.g.candidate_list);
        this.eMu.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.avj.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.eMv = (LinearLayout) this.aGH.findViewById(d.g.invite_candidate);
        this.eMt = this.aGH.findViewById(d.g.invite_candidate_border);
        if (this.eMy) {
            this.eMv.setVisibility(8);
            this.eMt.setVisibility(8);
        }
        aLz();
        this.eMw = (Button) this.aGH.findViewById(d.g.button_send);
        this.eMw.setOnClickListener(this.eMr);
        DR();
        aLr();
        qI(0);
    }

    private void avL() {
        this.mNavigationBar = (NavigationBar) this.aGH.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eMA != null && d.this.eMA.getVisibility() == 0) {
                    d.this.aLs();
                    return;
                }
                l.a(d.this.eMr.getPageContext().getPageActivity(), d.this.rE);
                d.this.eMr.finish();
            }
        });
        if (this.eMy) {
            this.eMz = this.mNavigationBar.setTitleText(d.j.invite_contact_title);
        } else {
            this.eMz = this.mNavigationBar.setTitleText(d.j.invite_friend);
        }
        this.eMB = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eMz.setVisibility(8);
                d.this.eMB.setVisibility(8);
                d.this.eMA.setVisibility(0);
                d.this.rE.requestFocus();
                l.b(d.this.eMr.getPageContext().getPageActivity(), d.this.rE);
            }
        });
        this.eMD = (ImageView) this.eMB.findViewById(d.g.new_friend_search);
        this.eMA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.eMA.setVisibility(8);
        this.rE = (EditText) this.eMA.findViewById(d.g.search_bar_edit);
        if (this.rE.getParent() != null) {
            ((View) this.rE.getParent()).setFocusable(true);
            ((View) this.rE.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a = k.a(editable, null);
                if (a != null) {
                    if (a.length() > 0) {
                        d.this.eMC.setVisibility(0);
                    } else {
                        d.this.eMC.setVisibility(8);
                    }
                    d.this.aLq();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.rE.addTextChangedListener(this.mTextWatcher);
        this.eMC = (TextView) this.eMA.findViewById(d.g.search_bar_delete_button);
        this.eMC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.rE.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLq() {
        if (this.eMr != null) {
            this.eMr.aLo();
        }
    }

    public void DR() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eMr.getLayoutMode().aM(skinType == 1);
        this.eMr.getLayoutMode().aM(this.aGH);
        aj.a(this.eMD, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.eMr.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eMr.getPageContext(), skinType);
        aj.s(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aLr() {
        this.avj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aLB();
                return false;
            }
        });
    }

    public void aLs() {
        l.a(this.eMr.getPageContext().getPageActivity(), this.rE);
        this.eMA.setVisibility(8);
        this.eMz.setVisibility(0);
        this.eMB.setVisibility(0);
        this.rE.getText().clear();
    }

    public boolean aLt() {
        return this.eMA != null && this.eMA.getVisibility() == 0;
    }

    public int aLu() {
        return this.eMw.getId();
    }

    public String aLv() {
        Editable text = this.rE.getText();
        return text != null ? text.toString() : "";
    }

    public String aLw() {
        return this.eMu.aLl();
    }

    public void k(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.eMs == null) {
            this.eMs = new c(this.eMr, this.eMy);
            this.eMs.a(this);
            this.eMs.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aLB();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aLC() <= d.this.eMu.getItemLength()) {
                                d.this.eMr.showToast(String.format(d.this.eMr.getPageContext().getString(d.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.eMx)));
                                tbCheckBox.setChecked(false);
                                ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                                return;
                            }
                            d.this.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                            return;
                        }
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            });
            this.avj.setAdapter((ListAdapter) this.eMs);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.avj.setVisibility(8);
            if (!this.eMy) {
                this.eMv.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.avj.setVisibility(0);
        this.eMs.setData(list);
        this.eMs.notifyDataSetChanged();
        if (!this.eMy) {
            this.eMv.setVisibility(0);
        }
    }

    public void aLx() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eMr.getPageContext());
        }
    }

    public void aLy() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aLz() {
        int dimensionPixelSize = this.eMr.getResources().getDimensionPixelSize(d.e.ds80) + this.eMr.getResources().getDimensionPixelSize(d.e.ds16) + this.eMr.getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(this.eMr.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.avj.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eMu.d(aVar);
            qI(this.eMu.getItemLength());
            aLA();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eMu.f(aVar);
            qI(this.eMu.getItemLength());
            aLA();
        }
    }

    private void aLA() {
        if (this.eMu.getItemLength() > 0) {
            this.eMw.setEnabled(true);
        } else {
            this.eMw.setEnabled(false);
        }
    }

    public void aLB() {
        l.a(this.eMr.getPageContext().getPageActivity(), this.rE);
    }

    private void qI(int i) {
        this.eMw.setText(String.format(this.eMr.getPageContext().getString(d.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aLC() {
        return this.eMx;
    }

    public void qJ(int i) {
        this.eMx = i;
        this.eMu.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eMu.e(aVar);
        }
    }

    public void onDestroy() {
        this.rE.removeTextChangedListener(this.mTextWatcher);
    }
}
