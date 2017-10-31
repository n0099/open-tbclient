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
    private View Ry;
    private EditText dMk;
    private final InviteFriendListActivity dPL;
    private c dPM;
    private View dPN;
    private InviteFriendCandidateList dPO;
    private LinearLayout dPP;
    private Button dPQ;
    private int dPR;
    private boolean dPS;
    private TextView dPT;
    private View dPU;
    private View dPV;
    private TextView dPW;
    private ImageView dPX;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private f mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dPR = 0;
        this.dPL = inviteFriendListActivity;
        this.dPS = z;
        wA();
    }

    public View getRootView() {
        return this.Ry;
    }

    private void wA() {
        this.dPL.setContentView(d.h.invite_friend_list);
        this.Ry = this.dPL.findViewById(d.g.root_view);
        akI();
        this.Hj = (BdListView) this.Ry.findViewById(d.g.friend_list);
        this.Hj.setOnItemClickListener(this.dPL);
        if (this.dPS) {
            this.mNoDataView = NoDataViewFactory.a(this.dPL.getPageContext().getPageActivity(), this.Ry, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aLZ), NoDataViewFactory.d.D(d.j.no_friends, d.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dPL.getPageContext().getPageActivity(), this.Ry, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aLZ), NoDataViewFactory.d.D(d.j.no_chat_friends, d.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.dPL.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.Ry.findViewById(d.g.progress);
        this.dPO = (InviteFriendCandidateList) this.Ry.findViewById(d.g.candidate_list);
        this.dPO.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
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
        this.dPP = (LinearLayout) this.Ry.findViewById(d.g.invite_candidate);
        this.dPN = this.Ry.findViewById(d.g.invite_candidate_border);
        if (this.dPS) {
            this.dPP.setVisibility(8);
            this.dPN.setVisibility(8);
        }
        aCG();
        this.dPQ = (Button) this.Ry.findViewById(d.g.button_send);
        this.dPQ.setOnClickListener(this.dPL);
        wB();
        aCy();
        nB(0);
    }

    private void akI() {
        this.mNavigationBar = (NavigationBar) this.Ry.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dPU != null && d.this.dPU.getVisibility() == 0) {
                    d.this.aCz();
                    return;
                }
                l.a(d.this.dPL.getPageContext().getPageActivity(), d.this.dMk);
                d.this.dPL.finish();
            }
        });
        if (this.dPS) {
            this.dPT = this.mNavigationBar.setTitleText(d.j.invite_contact_title);
        } else {
            this.dPT = this.mNavigationBar.setTitleText(d.j.invite_friend);
        }
        this.dPV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dPT.setVisibility(8);
                d.this.dPV.setVisibility(8);
                d.this.dPU.setVisibility(0);
                d.this.dMk.requestFocus();
                l.b(d.this.dPL.getPageContext().getPageActivity(), d.this.dMk);
            }
        });
        this.dPX = (ImageView) this.dPV.findViewById(d.g.new_friend_search);
        this.dPU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.dPU.setVisibility(8);
        this.dMk = (EditText) this.dPU.findViewById(d.g.search_bar_edit);
        if (this.dMk.getParent() != null) {
            ((View) this.dMk.getParent()).setFocusable(true);
            ((View) this.dMk.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a = k.a(editable, null);
                if (a != null) {
                    if (a.length() > 0) {
                        d.this.dPW.setVisibility(0);
                    } else {
                        d.this.dPW.setVisibility(8);
                    }
                    d.this.aCx();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.dMk.addTextChangedListener(this.mTextWatcher);
        this.dPW = (TextView) this.dPU.findViewById(d.g.search_bar_delete_button);
        this.dPW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dMk.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCx() {
        if (this.dPL != null) {
            this.dPL.aCv();
        }
    }

    public void wB() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dPL.getLayoutMode().ag(skinType == 1);
        this.dPL.getLayoutMode().t(this.Ry);
        aj.a(this.dPX, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dPL.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dPL.getPageContext(), skinType);
        aj.j(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aCy() {
        this.Hj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aCI();
                return false;
            }
        });
    }

    public void aCz() {
        l.a(this.dPL.getPageContext().getPageActivity(), this.dMk);
        this.dPU.setVisibility(8);
        this.dPT.setVisibility(0);
        this.dPV.setVisibility(0);
        this.dMk.getText().clear();
    }

    public boolean aCA() {
        return this.dPU != null && this.dPU.getVisibility() == 0;
    }

    public int aCB() {
        return this.dPQ.getId();
    }

    public String aCC() {
        Editable text = this.dMk.getText();
        return text != null ? text.toString() : "";
    }

    public String aCD() {
        return this.dPO.aCs();
    }

    public void k(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dPM == null) {
            this.dPM = new c(this.dPL, this.dPS);
            this.dPM.a(this);
            this.dPM.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aCI();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aCJ() <= d.this.dPO.getItemLength()) {
                                d.this.dPL.showToast(String.format(d.this.dPL.getPageContext().getString(d.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.dPR)));
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
            this.Hj.setAdapter((ListAdapter) this.dPM);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Hj.setVisibility(8);
            if (!this.dPS) {
                this.dPP.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Hj.setVisibility(0);
        this.dPM.setData(list);
        this.dPM.notifyDataSetChanged();
        if (!this.dPS) {
            this.dPP.setVisibility(0);
        }
    }

    public void aCE() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dPL.getPageContext());
        }
    }

    public void aCF() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aCG() {
        int dimensionPixelSize = this.dPL.getResources().getDimensionPixelSize(d.e.ds80) + this.dPL.getResources().getDimensionPixelSize(d.e.ds16) + this.dPL.getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(this.dPL.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Hj.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dPO.d(aVar);
            nB(this.dPO.getItemLength());
            aCH();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dPO.f(aVar);
            nB(this.dPO.getItemLength());
            aCH();
        }
    }

    private void aCH() {
        if (this.dPO.getItemLength() > 0) {
            this.dPQ.setEnabled(true);
        } else {
            this.dPQ.setEnabled(false);
        }
    }

    public void aCI() {
        l.a(this.dPL.getPageContext().getPageActivity(), this.dMk);
    }

    private void nB(int i) {
        this.dPQ.setText(String.format(this.dPL.getPageContext().getString(d.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aCJ() {
        return this.dPR;
    }

    public void nC(int i) {
        this.dPR = i;
        this.dPO.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dPO.e(aVar);
        }
    }

    public void onDestroy() {
        this.dMk.removeTextChangedListener(this.mTextWatcher);
    }
}
