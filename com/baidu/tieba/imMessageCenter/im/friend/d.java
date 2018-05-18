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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView FH;
    private View Th;
    private View emA;
    private View emB;
    private TextView emC;
    private ImageView emD;
    private final InviteFriendListActivity emr;
    private c ems;
    private View emt;
    private InviteFriendCandidateList emu;
    private LinearLayout emv;
    private Button emw;
    private int emx;
    private boolean emy;
    private TextView emz;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.emx = 0;
        this.emr = inviteFriendListActivity;
        this.emy = z;
        initialize();
    }

    public View getRootView() {
        return this.Th;
    }

    private void initialize() {
        this.emr.setContentView(d.i.invite_friend_list);
        this.Th = this.emr.findViewById(d.g.root_view);
        ard();
        this.FH = (BdListView) this.Th.findViewById(d.g.friend_list);
        this.FH.setOnItemClickListener(this.emr);
        if (this.emy) {
            this.mNoDataView = NoDataViewFactory.a(this.emr.getPageContext().getPageActivity(), this.Th, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aNn), NoDataViewFactory.d.C(d.k.no_friends, d.k.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.emr.getPageContext().getPageActivity(), this.Th, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aNn), NoDataViewFactory.d.C(d.k.no_chat_friends, d.k.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.k.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.emr.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.Th.findViewById(d.g.progress);
        this.emu = (InviteFriendCandidateList) this.Th.findViewById(d.g.candidate_list);
        this.emu.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view2, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.FH.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.emv = (LinearLayout) this.Th.findViewById(d.g.invite_candidate);
        this.emt = this.Th.findViewById(d.g.invite_candidate_border);
        if (this.emy) {
            this.emv.setVisibility(8);
            this.emt.setVisibility(8);
        }
        aHZ();
        this.emw = (Button) this.Th.findViewById(d.g.button_send);
        this.emw.setOnClickListener(this.emr);
        wX();
        aHR();
        ob(0);
    }

    private void ard() {
        this.mNavigationBar = (NavigationBar) this.Th.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (d.this.emA != null && d.this.emA.getVisibility() == 0) {
                    d.this.aHS();
                    return;
                }
                l.b(d.this.emr.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.emr.finish();
            }
        });
        if (this.emy) {
            this.emz = this.mNavigationBar.setTitleText(d.k.invite_contact_title);
        } else {
            this.emz = this.mNavigationBar.setTitleText(d.k.invite_friend);
        }
        this.emB = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.emz.setVisibility(8);
                d.this.emB.setVisibility(8);
                d.this.emA.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.c(d.this.emr.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.emD = (ImageView) this.emB.findViewById(d.g.new_friend_search);
        this.emA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.navigationbar_search_edit, (View.OnClickListener) null);
        this.emA.setVisibility(8);
        this.mEditText = (EditText) this.emA.findViewById(d.g.search_bar_edit);
        if (this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a = k.a(editable, null);
                if (a != null) {
                    if (a.length() > 0) {
                        d.this.emC.setVisibility(0);
                    } else {
                        d.this.emC.setVisibility(8);
                    }
                    d.this.aHQ();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.emC = (TextView) this.emA.findViewById(d.g.search_bar_delete_button);
        this.emC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHQ() {
        if (this.emr != null) {
            this.emr.aHO();
        }
    }

    public void wX() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.emr.getLayoutMode().setNightMode(skinType == 1);
        this.emr.getLayoutMode().u(this.Th);
        ak.a(this.emD, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.emr.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.emr.getPageContext(), skinType);
        ak.i(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aHR() {
        this.FH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                d.this.aIb();
                return false;
            }
        });
    }

    public void aHS() {
        l.b(this.emr.getPageContext().getPageActivity(), this.mEditText);
        this.emA.setVisibility(8);
        this.emz.setVisibility(0);
        this.emB.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean aHT() {
        return this.emA != null && this.emA.getVisibility() == 0;
    }

    public int aHU() {
        return this.emw.getId();
    }

    public String aHV() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String aHW() {
        return this.emu.aHL();
    }

    public void k(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.ems == null) {
            this.ems = new c(this.emr, this.emy);
            this.ems.a(this);
            this.ems.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aIb();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aIc() <= d.this.emu.getItemLength()) {
                                d.this.emr.showToast(String.format(d.this.emr.getPageContext().getString(d.k.invite_friend_exceed_max_count), Integer.valueOf(d.this.emx)));
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
            this.FH.setAdapter((ListAdapter) this.ems);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.FH.setVisibility(8);
            if (!this.emy) {
                this.emv.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.FH.setVisibility(0);
        this.ems.setData(list);
        this.ems.notifyDataSetChanged();
        if (!this.emy) {
            this.emv.setVisibility(0);
        }
    }

    public void aHX() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.emr.getPageContext());
        }
    }

    public void aHY() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aHZ() {
        int dimensionPixelSize = this.emr.getResources().getDimensionPixelSize(d.e.ds80) + this.emr.getResources().getDimensionPixelSize(d.e.ds16) + this.emr.getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(this.emr.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.FH.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.emu.d(aVar);
            ob(this.emu.getItemLength());
            aIa();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.emu.f(aVar);
            ob(this.emu.getItemLength());
            aIa();
        }
    }

    private void aIa() {
        if (this.emu.getItemLength() > 0) {
            this.emw.setEnabled(true);
        } else {
            this.emw.setEnabled(false);
        }
    }

    public void aIb() {
        l.b(this.emr.getPageContext().getPageActivity(), this.mEditText);
    }

    private void ob(int i) {
        this.emw.setText(String.format(this.emr.getPageContext().getString(d.k.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aIc() {
        return this.emx;
    }

    public void oc(int i) {
        this.emx = i;
        this.emu.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view2, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.emu.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
