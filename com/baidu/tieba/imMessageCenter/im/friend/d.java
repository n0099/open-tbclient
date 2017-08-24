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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView JE;
    private View Sg;
    private EditText dAX;
    private InviteFriendCandidateList dEA;
    private LinearLayout dEB;
    private Button dEC;
    private int dED;
    private boolean dEE;
    private TextView dEF;
    private View dEG;
    private View dEH;
    private TextView dEI;
    private ImageView dEJ;
    private final InviteFriendListActivity dEx;
    private c dEy;
    private View dEz;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dED = 0;
        this.dEx = inviteFriendListActivity;
        this.dEE = z;
        bg();
    }

    public View getRootView() {
        return this.Sg;
    }

    private void bg() {
        this.dEx.setContentView(d.j.invite_friend_list);
        this.Sg = this.dEx.findViewById(d.h.root_view);
        Wp();
        this.JE = (BdListView) this.Sg.findViewById(d.h.friend_list);
        this.JE.setOnItemClickListener(this.dEx);
        if (this.dEE) {
            this.mNoDataView = NoDataViewFactory.a(this.dEx.getPageContext().getPageActivity(), this.Sg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aMy), NoDataViewFactory.d.C(d.l.no_friends, d.l.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dEx.getPageContext().getPageActivity(), this.Sg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aMy), NoDataViewFactory.d.C(d.l.no_chat_friends, d.l.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.l.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.dEx.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.Sg.findViewById(d.h.progress);
        this.dEA = (InviteFriendCandidateList) this.Sg.findViewById(d.h.candidate_list);
        this.dEA.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.JE.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.dEB = (LinearLayout) this.Sg.findViewById(d.h.invite_candidate);
        this.dEz = this.Sg.findViewById(d.h.invite_candidate_border);
        if (this.dEE) {
            this.dEB.setVisibility(8);
            this.dEz.setVisibility(8);
        }
        azF();
        this.dEC = (Button) this.Sg.findViewById(d.h.button_send);
        this.dEC.setOnClickListener(this.dEx);
        xd();
        azx();
        mU(0);
    }

    private void Wp() {
        this.mNavigationBar = (NavigationBar) this.Sg.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dEG != null && d.this.dEG.getVisibility() == 0) {
                    d.this.azy();
                    return;
                }
                k.b(d.this.dEx.getPageContext().getPageActivity(), d.this.dAX);
                d.this.dEx.finish();
            }
        });
        if (this.dEE) {
            this.dEF = this.mNavigationBar.setTitleText(d.l.invite_contact_title);
        } else {
            this.dEF = this.mNavigationBar.setTitleText(d.l.invite_friend);
        }
        this.dEH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dEF.setVisibility(8);
                d.this.dEH.setVisibility(8);
                d.this.dEG.setVisibility(0);
                d.this.dAX.requestFocus();
                k.c(d.this.dEx.getPageContext().getPageActivity(), d.this.dAX);
            }
        });
        this.dEJ = (ImageView) this.dEH.findViewById(d.h.new_friend_search);
        this.dEG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dEG.setVisibility(8);
        this.dAX = (EditText) this.dEG.findViewById(d.h.search_bar_edit);
        if (this.dAX.getParent() != null) {
            ((View) this.dAX.getParent()).setFocusable(true);
            ((View) this.dAX.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a = com.baidu.adp.lib.util.j.a(editable, null);
                if (a != null) {
                    if (a.length() > 0) {
                        d.this.dEI.setVisibility(0);
                    } else {
                        d.this.dEI.setVisibility(8);
                    }
                    d.this.azw();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.dAX.addTextChangedListener(this.mTextWatcher);
        this.dEI = (TextView) this.dEG.findViewById(d.h.search_bar_delete_button);
        this.dEI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dAX.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azw() {
        if (this.dEx != null) {
            this.dEx.azu();
        }
    }

    public void xd() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dEx.getLayoutMode().ah(skinType == 1);
        this.dEx.getLayoutMode().t(this.Sg);
        ai.b(this.dEJ, d.g.icon_search_bg_s, d.g.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dEx.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dEx.getPageContext(), skinType);
        ai.j(this.mListFooter, d.g.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void azx() {
        this.JE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.azH();
                return false;
            }
        });
    }

    public void azy() {
        k.b(this.dEx.getPageContext().getPageActivity(), this.dAX);
        this.dEG.setVisibility(8);
        this.dEF.setVisibility(0);
        this.dEH.setVisibility(0);
        this.dAX.getText().clear();
    }

    public boolean azz() {
        return this.dEG != null && this.dEG.getVisibility() == 0;
    }

    public int azA() {
        return this.dEC.getId();
    }

    public String azB() {
        Editable text = this.dAX.getText();
        return text != null ? text.toString() : "";
    }

    public String azC() {
        return this.dEA.azr();
    }

    public void m(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dEy == null) {
            this.dEy = new c(this.dEx, this.dEE);
            this.dEy.a(this);
            this.dEy.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.azH();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.azI() <= d.this.dEA.getItemLength()) {
                                d.this.dEx.showToast(String.format(d.this.dEx.getPageContext().getString(d.l.invite_friend_exceed_max_count), Integer.valueOf(d.this.dED)));
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
            this.JE.setAdapter((ListAdapter) this.dEy);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.JE.setVisibility(8);
            if (!this.dEE) {
                this.dEB.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.JE.setVisibility(0);
        this.dEy.setData(list);
        this.dEy.notifyDataSetChanged();
        if (!this.dEE) {
            this.dEB.setVisibility(0);
        }
    }

    public void azD() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dEx.getPageContext());
        }
    }

    public void azE() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void azF() {
        int dimensionPixelSize = this.dEx.getResources().getDimensionPixelSize(d.f.ds80) + this.dEx.getResources().getDimensionPixelSize(d.f.ds16) + this.dEx.getResources().getDimensionPixelSize(d.f.ds16);
        this.mListFooter = new View(this.dEx.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.JE.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dEA.d(aVar);
            mU(this.dEA.getItemLength());
            azG();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dEA.f(aVar);
            mU(this.dEA.getItemLength());
            azG();
        }
    }

    private void azG() {
        if (this.dEA.getItemLength() > 0) {
            this.dEC.setEnabled(true);
        } else {
            this.dEC.setEnabled(false);
        }
    }

    public void azH() {
        k.b(this.dEx.getPageContext().getPageActivity(), this.dAX);
    }

    private void mU(int i) {
        this.dEC.setText(String.format(this.dEx.getPageContext().getString(d.l.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int azI() {
        return this.dED;
    }

    public void mV(int i) {
        this.dED = i;
        this.dEA.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dEA.e(aVar);
        }
    }

    public void onDestroy() {
        this.dAX.removeTextChangedListener(this.mTextWatcher);
    }
}
