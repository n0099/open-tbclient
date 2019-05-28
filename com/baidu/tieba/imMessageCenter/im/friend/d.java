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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView MS;
    private View bBg;
    private final InviteFriendListActivity gNi;
    private c gNj;
    private View gNk;
    private InviteFriendCandidateList gNl;
    private LinearLayout gNm;
    private Button gNn;
    private int gNo;
    private boolean gNp;
    private TextView gNq;
    private View gNr;
    private View gNs;
    private TextView gNt;
    private ImageView gNu;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.gNo = 0;
        this.gNi = inviteFriendListActivity;
        this.gNp = z;
        initialize();
    }

    public View getRootView() {
        return this.bBg;
    }

    private void initialize() {
        this.gNi.setContentView(R.layout.invite_friend_list);
        this.bBg = this.gNi.findViewById(R.id.root_view);
        aHR();
        this.MS = (BdListView) this.bBg.findViewById(R.id.friend_list);
        this.MS.setOnItemClickListener(this.gNi);
        if (this.gNp) {
            this.mNoDataView = NoDataViewFactory.a(this.gNi.getPageContext().getPageActivity(), this.bBg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.cBh), NoDataViewFactory.d.ad(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.gNi.getPageContext().getPageActivity(), this.bBg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.cBh), NoDataViewFactory.d.ad(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.gNi.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.bBg.findViewById(R.id.progress);
        this.gNl = (InviteFriendCandidateList) this.bBg.findViewById(R.id.candidate_list);
        this.gNl.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.MS.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.gNm = (LinearLayout) this.bBg.findViewById(R.id.invite_candidate);
        this.gNk = this.bBg.findViewById(R.id.invite_candidate_border);
        if (this.gNp) {
            this.gNm.setVisibility(8);
            this.gNk.setVisibility(8);
        }
        bEP();
        this.gNn = (Button) this.bBg.findViewById(R.id.button_send);
        this.gNn.setOnClickListener(this.gNi);
        ajG();
        bEH();
        vy(0);
    }

    private void aHR() {
        this.mNavigationBar = (NavigationBar) this.bBg.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.gNr != null && d.this.gNr.getVisibility() == 0) {
                    d.this.bEI();
                    return;
                }
                l.b(d.this.gNi.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.gNi.finish();
            }
        });
        if (this.gNp) {
            this.gNq = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.gNq = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.gNs = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.gNq.setVisibility(8);
                d.this.gNs.setVisibility(8);
                d.this.gNr.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.c(d.this.gNi.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.gNu = (ImageView) this.gNs.findViewById(R.id.new_friend_search);
        this.gNr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.gNr.setVisibility(8);
        this.mEditText = (EditText) this.gNr.findViewById(R.id.search_bar_edit);
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
                        d.this.gNt.setVisibility(0);
                    } else {
                        d.this.gNt.setVisibility(8);
                    }
                    d.this.bEG();
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
        this.gNt = (TextView) this.gNr.findViewById(R.id.search_bar_delete_button);
        this.gNt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEG() {
        if (this.gNi != null) {
            this.gNi.bEE();
        }
    }

    public void ajG() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gNi.getLayoutMode().setNightMode(skinType == 1);
        this.gNi.getLayoutMode().onModeChanged(this.bBg);
        al.a(this.gNu, (int) R.drawable.icon_search_bg_s, (int) R.drawable.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.gNi.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.gNi.getPageContext(), skinType);
        al.k(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void bEH() {
        this.MS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void bEI() {
        l.b(this.gNi.getPageContext().getPageActivity(), this.mEditText);
        this.gNr.setVisibility(8);
        this.gNq.setVisibility(0);
        this.gNs.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean bEJ() {
        return this.gNr != null && this.gNr.getVisibility() == 0;
    }

    public int bEK() {
        return this.gNn.getId();
    }

    public String bEL() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String bEM() {
        return this.gNl.bEB();
    }

    public void n(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.gNj == null) {
            this.gNj = new c(this.gNi, this.gNp);
            this.gNj.a(this);
            this.gNj.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.bER() <= d.this.gNl.getItemLength()) {
                                d.this.gNi.showToast(String.format(d.this.gNi.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.gNo)));
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
            this.MS.setAdapter((ListAdapter) this.gNj);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.MS.setVisibility(8);
            if (!this.gNp) {
                this.gNm.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.MS.setVisibility(0);
        this.gNj.setData(list);
        this.gNj.notifyDataSetChanged();
        if (!this.gNp) {
            this.gNm.setVisibility(0);
        }
    }

    public void bEN() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.gNi.getPageContext());
        }
    }

    public void bEO() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void bEP() {
        int dimensionPixelSize = this.gNi.getResources().getDimensionPixelSize(R.dimen.ds80) + this.gNi.getResources().getDimensionPixelSize(R.dimen.ds16) + this.gNi.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.gNi.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.MS.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gNl.d(aVar);
            vy(this.gNl.getItemLength());
            bEQ();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gNl.f(aVar);
            vy(this.gNl.getItemLength());
            bEQ();
        }
    }

    private void bEQ() {
        if (this.gNl.getItemLength() > 0) {
            this.gNn.setEnabled(true);
        } else {
            this.gNn.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.b(this.gNi.getPageContext().getPageActivity(), this.mEditText);
    }

    private void vy(int i) {
        this.gNn.setText(String.format(this.gNi.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int bER() {
        return this.gNo;
    }

    public void vz(int i) {
        this.gNo = i;
        this.gNl.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gNl.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
