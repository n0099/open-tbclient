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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView Hi;
    private View Sf;
    private EditText dVm;
    private final InviteFriendListActivity dYO;
    private c dYP;
    private View dYQ;
    private InviteFriendCandidateList dYR;
    private LinearLayout dYS;
    private Button dYT;
    private int dYU;
    private boolean dYV;
    private TextView dYW;
    private View dYX;
    private View dYY;
    private TextView dYZ;
    private ImageView dZa;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private g mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dYU = 0;
        this.dYO = inviteFriendListActivity;
        this.dYV = z;
        wB();
    }

    public View getRootView() {
        return this.Sf;
    }

    private void wB() {
        this.dYO.setContentView(d.h.invite_friend_list);
        this.Sf = this.dYO.findViewById(d.g.root_view);
        anb();
        this.Hi = (BdListView) this.Sf.findViewById(d.g.friend_list);
        this.Hi.setOnItemClickListener(this.dYO);
        if (this.dYV) {
            this.mNoDataView = NoDataViewFactory.a(this.dYO.getPageContext().getPageActivity(), this.Sf, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aMO), NoDataViewFactory.d.D(d.j.no_friends, d.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dYO.getPageContext().getPageActivity(), this.Sf, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aMO), NoDataViewFactory.d.D(d.j.no_chat_friends, d.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.dYO.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.Sf.findViewById(d.g.progress);
        this.dYR = (InviteFriendCandidateList) this.Sf.findViewById(d.g.candidate_list);
        this.dYR.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.Hi.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.dYS = (LinearLayout) this.Sf.findViewById(d.g.invite_candidate);
        this.dYQ = this.Sf.findViewById(d.g.invite_candidate_border);
        if (this.dYV) {
            this.dYS.setVisibility(8);
            this.dYQ.setVisibility(8);
        }
        aEt();
        this.dYT = (Button) this.Sf.findViewById(d.g.button_send);
        this.dYT.setOnClickListener(this.dYO);
        wC();
        aEl();
        nX(0);
    }

    private void anb() {
        this.mNavigationBar = (NavigationBar) this.Sf.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dYX != null && d.this.dYX.getVisibility() == 0) {
                    d.this.aEm();
                    return;
                }
                l.a(d.this.dYO.getPageContext().getPageActivity(), d.this.dVm);
                d.this.dYO.finish();
            }
        });
        if (this.dYV) {
            this.dYW = this.mNavigationBar.setTitleText(d.j.invite_contact_title);
        } else {
            this.dYW = this.mNavigationBar.setTitleText(d.j.invite_friend);
        }
        this.dYY = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dYW.setVisibility(8);
                d.this.dYY.setVisibility(8);
                d.this.dYX.setVisibility(0);
                d.this.dVm.requestFocus();
                l.b(d.this.dYO.getPageContext().getPageActivity(), d.this.dVm);
            }
        });
        this.dZa = (ImageView) this.dYY.findViewById(d.g.new_friend_search);
        this.dYX = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.dYX.setVisibility(8);
        this.dVm = (EditText) this.dYX.findViewById(d.g.search_bar_edit);
        if (this.dVm.getParent() != null) {
            ((View) this.dVm.getParent()).setFocusable(true);
            ((View) this.dVm.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a = k.a(editable, null);
                if (a != null) {
                    if (a.length() > 0) {
                        d.this.dYZ.setVisibility(0);
                    } else {
                        d.this.dYZ.setVisibility(8);
                    }
                    d.this.aEk();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.dVm.addTextChangedListener(this.mTextWatcher);
        this.dYZ = (TextView) this.dYX.findViewById(d.g.search_bar_delete_button);
        this.dYZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dVm.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEk() {
        if (this.dYO != null) {
            this.dYO.aEi();
        }
    }

    public void wC() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dYO.getLayoutMode().ag(skinType == 1);
        this.dYO.getLayoutMode().t(this.Sf);
        aj.a(this.dZa, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dYO.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dYO.getPageContext(), skinType);
        aj.j(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aEl() {
        this.Hi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aEv();
                return false;
            }
        });
    }

    public void aEm() {
        l.a(this.dYO.getPageContext().getPageActivity(), this.dVm);
        this.dYX.setVisibility(8);
        this.dYW.setVisibility(0);
        this.dYY.setVisibility(0);
        this.dVm.getText().clear();
    }

    public boolean aEn() {
        return this.dYX != null && this.dYX.getVisibility() == 0;
    }

    public int aEo() {
        return this.dYT.getId();
    }

    public String aEp() {
        Editable text = this.dVm.getText();
        return text != null ? text.toString() : "";
    }

    public String aEq() {
        return this.dYR.aEf();
    }

    public void m(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dYP == null) {
            this.dYP = new c(this.dYO, this.dYV);
            this.dYP.a(this);
            this.dYP.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aEv();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aEw() <= d.this.dYR.getItemLength()) {
                                d.this.dYO.showToast(String.format(d.this.dYO.getPageContext().getString(d.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.dYU)));
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
            this.Hi.setAdapter((ListAdapter) this.dYP);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Hi.setVisibility(8);
            if (!this.dYV) {
                this.dYS.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Hi.setVisibility(0);
        this.dYP.setData(list);
        this.dYP.notifyDataSetChanged();
        if (!this.dYV) {
            this.dYS.setVisibility(0);
        }
    }

    public void aEr() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dYO.getPageContext());
        }
    }

    public void aEs() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aEt() {
        int dimensionPixelSize = this.dYO.getResources().getDimensionPixelSize(d.e.ds80) + this.dYO.getResources().getDimensionPixelSize(d.e.ds16) + this.dYO.getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(this.dYO.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Hi.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dYR.d(aVar);
            nX(this.dYR.getItemLength());
            aEu();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dYR.f(aVar);
            nX(this.dYR.getItemLength());
            aEu();
        }
    }

    private void aEu() {
        if (this.dYR.getItemLength() > 0) {
            this.dYT.setEnabled(true);
        } else {
            this.dYT.setEnabled(false);
        }
    }

    public void aEv() {
        l.a(this.dYO.getPageContext().getPageActivity(), this.dVm);
    }

    private void nX(int i) {
        this.dYT.setText(String.format(this.dYO.getPageContext().getString(d.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aEw() {
        return this.dYU;
    }

    public void nY(int i) {
        this.dYU = i;
        this.dYR.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dYR.e(aVar);
        }
    }

    public void onDestroy() {
        this.dVm.removeTextChangedListener(this.mTextWatcher);
    }
}
