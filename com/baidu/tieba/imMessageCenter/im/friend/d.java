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
    private EditText dMp;
    private final InviteFriendListActivity dPQ;
    private c dPR;
    private View dPS;
    private InviteFriendCandidateList dPT;
    private LinearLayout dPU;
    private Button dPV;
    private int dPW;
    private boolean dPX;
    private TextView dPY;
    private View dPZ;
    private View dQa;
    private TextView dQb;
    private ImageView dQc;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private f mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dPW = 0;
        this.dPQ = inviteFriendListActivity;
        this.dPX = z;
        wA();
    }

    public View getRootView() {
        return this.Ry;
    }

    private void wA() {
        this.dPQ.setContentView(d.h.invite_friend_list);
        this.Ry = this.dPQ.findViewById(d.g.root_view);
        akW();
        this.Hj = (BdListView) this.Ry.findViewById(d.g.friend_list);
        this.Hj.setOnItemClickListener(this.dPQ);
        if (this.dPX) {
            this.mNoDataView = NoDataViewFactory.a(this.dPQ.getPageContext().getPageActivity(), this.Ry, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aMh), NoDataViewFactory.d.D(d.j.no_friends, d.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dPQ.getPageContext().getPageActivity(), this.Ry, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aMh), NoDataViewFactory.d.D(d.j.no_chat_friends, d.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.dPQ.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.Ry.findViewById(d.g.progress);
        this.dPT = (InviteFriendCandidateList) this.Ry.findViewById(d.g.candidate_list);
        this.dPT.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
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
        this.dPU = (LinearLayout) this.Ry.findViewById(d.g.invite_candidate);
        this.dPS = this.Ry.findViewById(d.g.invite_candidate_border);
        if (this.dPX) {
            this.dPU.setVisibility(8);
            this.dPS.setVisibility(8);
        }
        aCK();
        this.dPV = (Button) this.Ry.findViewById(d.g.button_send);
        this.dPV.setOnClickListener(this.dPQ);
        wB();
        aCC();
        nC(0);
    }

    private void akW() {
        this.mNavigationBar = (NavigationBar) this.Ry.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dPZ != null && d.this.dPZ.getVisibility() == 0) {
                    d.this.aCD();
                    return;
                }
                l.a(d.this.dPQ.getPageContext().getPageActivity(), d.this.dMp);
                d.this.dPQ.finish();
            }
        });
        if (this.dPX) {
            this.dPY = this.mNavigationBar.setTitleText(d.j.invite_contact_title);
        } else {
            this.dPY = this.mNavigationBar.setTitleText(d.j.invite_friend);
        }
        this.dQa = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dPY.setVisibility(8);
                d.this.dQa.setVisibility(8);
                d.this.dPZ.setVisibility(0);
                d.this.dMp.requestFocus();
                l.b(d.this.dPQ.getPageContext().getPageActivity(), d.this.dMp);
            }
        });
        this.dQc = (ImageView) this.dQa.findViewById(d.g.new_friend_search);
        this.dPZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.dPZ.setVisibility(8);
        this.dMp = (EditText) this.dPZ.findViewById(d.g.search_bar_edit);
        if (this.dMp.getParent() != null) {
            ((View) this.dMp.getParent()).setFocusable(true);
            ((View) this.dMp.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a = k.a(editable, null);
                if (a != null) {
                    if (a.length() > 0) {
                        d.this.dQb.setVisibility(0);
                    } else {
                        d.this.dQb.setVisibility(8);
                    }
                    d.this.aCB();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.dMp.addTextChangedListener(this.mTextWatcher);
        this.dQb = (TextView) this.dPZ.findViewById(d.g.search_bar_delete_button);
        this.dQb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dMp.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCB() {
        if (this.dPQ != null) {
            this.dPQ.aCz();
        }
    }

    public void wB() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dPQ.getLayoutMode().ag(skinType == 1);
        this.dPQ.getLayoutMode().t(this.Ry);
        aj.a(this.dQc, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dPQ.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dPQ.getPageContext(), skinType);
        aj.j(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aCC() {
        this.Hj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aCM();
                return false;
            }
        });
    }

    public void aCD() {
        l.a(this.dPQ.getPageContext().getPageActivity(), this.dMp);
        this.dPZ.setVisibility(8);
        this.dPY.setVisibility(0);
        this.dQa.setVisibility(0);
        this.dMp.getText().clear();
    }

    public boolean aCE() {
        return this.dPZ != null && this.dPZ.getVisibility() == 0;
    }

    public int aCF() {
        return this.dPV.getId();
    }

    public String aCG() {
        Editable text = this.dMp.getText();
        return text != null ? text.toString() : "";
    }

    public String aCH() {
        return this.dPT.aCw();
    }

    public void k(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dPR == null) {
            this.dPR = new c(this.dPQ, this.dPX);
            this.dPR.a(this);
            this.dPR.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aCM();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aCN() <= d.this.dPT.getItemLength()) {
                                d.this.dPQ.showToast(String.format(d.this.dPQ.getPageContext().getString(d.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.dPW)));
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
            this.Hj.setAdapter((ListAdapter) this.dPR);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Hj.setVisibility(8);
            if (!this.dPX) {
                this.dPU.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Hj.setVisibility(0);
        this.dPR.setData(list);
        this.dPR.notifyDataSetChanged();
        if (!this.dPX) {
            this.dPU.setVisibility(0);
        }
    }

    public void aCI() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dPQ.getPageContext());
        }
    }

    public void aCJ() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aCK() {
        int dimensionPixelSize = this.dPQ.getResources().getDimensionPixelSize(d.e.ds80) + this.dPQ.getResources().getDimensionPixelSize(d.e.ds16) + this.dPQ.getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(this.dPQ.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Hj.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dPT.d(aVar);
            nC(this.dPT.getItemLength());
            aCL();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dPT.f(aVar);
            nC(this.dPT.getItemLength());
            aCL();
        }
    }

    private void aCL() {
        if (this.dPT.getItemLength() > 0) {
            this.dPV.setEnabled(true);
        } else {
            this.dPV.setEnabled(false);
        }
    }

    public void aCM() {
        l.a(this.dPQ.getPageContext().getPageActivity(), this.dMp);
    }

    private void nC(int i) {
        this.dPV.setText(String.format(this.dPQ.getPageContext().getString(d.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aCN() {
        return this.dPW;
    }

    public void nD(int i) {
        this.dPW = i;
        this.dPT.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dPT.e(aVar);
        }
    }

    public void onDestroy() {
        this.dMp.removeTextChangedListener(this.mTextWatcher);
    }
}
