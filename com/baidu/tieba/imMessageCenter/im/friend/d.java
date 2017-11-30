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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView Hj;
    private View Sh;
    private EditText dUd;
    private final InviteFriendListActivity dXF;
    private c dXG;
    private View dXH;
    private InviteFriendCandidateList dXI;
    private LinearLayout dXJ;
    private Button dXK;
    private int dXL;
    private boolean dXM;
    private TextView dXN;
    private View dXO;
    private View dXP;
    private TextView dXQ;
    private ImageView dXR;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private f mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dXL = 0;
        this.dXF = inviteFriendListActivity;
        this.dXM = z;
        wD();
    }

    public View getRootView() {
        return this.Sh;
    }

    private void wD() {
        this.dXF.setContentView(d.h.invite_friend_list);
        this.Sh = this.dXF.findViewById(d.g.root_view);
        amS();
        this.Hj = (BdListView) this.Sh.findViewById(d.g.friend_list);
        this.Hj.setOnItemClickListener(this.dXF);
        if (this.dXM) {
            this.mNoDataView = NoDataViewFactory.a(this.dXF.getPageContext().getPageActivity(), this.Sh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aMI), NoDataViewFactory.d.C(d.j.no_friends, d.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dXF.getPageContext().getPageActivity(), this.Sh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aMI), NoDataViewFactory.d.C(d.j.no_chat_friends, d.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.dXF.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.Sh.findViewById(d.g.progress);
        this.dXI = (InviteFriendCandidateList) this.Sh.findViewById(d.g.candidate_list);
        this.dXI.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.Hj.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.dXJ = (LinearLayout) this.Sh.findViewById(d.g.invite_candidate);
        this.dXH = this.Sh.findViewById(d.g.invite_candidate_border);
        if (this.dXM) {
            this.dXJ.setVisibility(8);
            this.dXH.setVisibility(8);
        }
        aEk();
        this.dXK = (Button) this.Sh.findViewById(d.g.button_send);
        this.dXK.setOnClickListener(this.dXF);
        wE();
        aEc();
        nQ(0);
    }

    private void amS() {
        this.mNavigationBar = (NavigationBar) this.Sh.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dXO != null && d.this.dXO.getVisibility() == 0) {
                    d.this.aEd();
                    return;
                }
                l.a(d.this.dXF.getPageContext().getPageActivity(), d.this.dUd);
                d.this.dXF.finish();
            }
        });
        if (this.dXM) {
            this.dXN = this.mNavigationBar.setTitleText(d.j.invite_contact_title);
        } else {
            this.dXN = this.mNavigationBar.setTitleText(d.j.invite_friend);
        }
        this.dXP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dXN.setVisibility(8);
                d.this.dXP.setVisibility(8);
                d.this.dXO.setVisibility(0);
                d.this.dUd.requestFocus();
                l.b(d.this.dXF.getPageContext().getPageActivity(), d.this.dUd);
            }
        });
        this.dXR = (ImageView) this.dXP.findViewById(d.g.new_friend_search);
        this.dXO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.dXO.setVisibility(8);
        this.dUd = (EditText) this.dXO.findViewById(d.g.search_bar_edit);
        if (this.dUd.getParent() != null) {
            ((View) this.dUd.getParent()).setFocusable(true);
            ((View) this.dUd.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a = k.a(editable, null);
                if (a != null) {
                    if (a.length() > 0) {
                        d.this.dXQ.setVisibility(0);
                    } else {
                        d.this.dXQ.setVisibility(8);
                    }
                    d.this.aEb();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.dUd.addTextChangedListener(this.mTextWatcher);
        this.dXQ = (TextView) this.dXO.findViewById(d.g.search_bar_delete_button);
        this.dXQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dUd.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEb() {
        if (this.dXF != null) {
            this.dXF.aDZ();
        }
    }

    public void wE() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dXF.getLayoutMode().ag(skinType == 1);
        this.dXF.getLayoutMode().t(this.Sh);
        aj.a(this.dXR, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dXF.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dXF.getPageContext(), skinType);
        aj.j(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aEc() {
        this.Hj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aEm();
                return false;
            }
        });
    }

    public void aEd() {
        l.a(this.dXF.getPageContext().getPageActivity(), this.dUd);
        this.dXO.setVisibility(8);
        this.dXN.setVisibility(0);
        this.dXP.setVisibility(0);
        this.dUd.getText().clear();
    }

    public boolean aEe() {
        return this.dXO != null && this.dXO.getVisibility() == 0;
    }

    public int aEf() {
        return this.dXK.getId();
    }

    public String aEg() {
        Editable text = this.dUd.getText();
        return text != null ? text.toString() : "";
    }

    public String aEh() {
        return this.dXI.aDW();
    }

    public void l(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dXG == null) {
            this.dXG = new c(this.dXF, this.dXM);
            this.dXG.a(this);
            this.dXG.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aEm();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aEn() <= d.this.dXI.getItemLength()) {
                                d.this.dXF.showToast(String.format(d.this.dXF.getPageContext().getString(d.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.dXL)));
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
            this.Hj.setAdapter((ListAdapter) this.dXG);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Hj.setVisibility(8);
            if (!this.dXM) {
                this.dXJ.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Hj.setVisibility(0);
        this.dXG.setData(list);
        this.dXG.notifyDataSetChanged();
        if (!this.dXM) {
            this.dXJ.setVisibility(0);
        }
    }

    public void aEi() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dXF.getPageContext());
        }
    }

    public void aEj() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aEk() {
        int dimensionPixelSize = this.dXF.getResources().getDimensionPixelSize(d.e.ds80) + this.dXF.getResources().getDimensionPixelSize(d.e.ds16) + this.dXF.getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(this.dXF.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Hj.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dXI.d(aVar);
            nQ(this.dXI.getItemLength());
            aEl();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dXI.f(aVar);
            nQ(this.dXI.getItemLength());
            aEl();
        }
    }

    private void aEl() {
        if (this.dXI.getItemLength() > 0) {
            this.dXK.setEnabled(true);
        } else {
            this.dXK.setEnabled(false);
        }
    }

    public void aEm() {
        l.a(this.dXF.getPageContext().getPageActivity(), this.dUd);
    }

    private void nQ(int i) {
        this.dXK.setText(String.format(this.dXF.getPageContext().getString(d.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aEn() {
        return this.dXL;
    }

    public void nR(int i) {
        this.dXL = i;
        this.dXI.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dXI.e(aVar);
        }
    }

    public void onDestroy() {
        this.dUd.removeTextChangedListener(this.mTextWatcher);
    }
}
