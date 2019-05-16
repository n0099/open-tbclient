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
    private final InviteFriendListActivity gNh;
    private c gNi;
    private View gNj;
    private InviteFriendCandidateList gNk;
    private LinearLayout gNl;
    private Button gNm;
    private int gNn;
    private boolean gNo;
    private TextView gNp;
    private View gNq;
    private View gNr;
    private TextView gNs;
    private ImageView gNt;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.gNn = 0;
        this.gNh = inviteFriendListActivity;
        this.gNo = z;
        initialize();
    }

    public View getRootView() {
        return this.bBg;
    }

    private void initialize() {
        this.gNh.setContentView(R.layout.invite_friend_list);
        this.bBg = this.gNh.findViewById(R.id.root_view);
        aHO();
        this.MS = (BdListView) this.bBg.findViewById(R.id.friend_list);
        this.MS.setOnItemClickListener(this.gNh);
        if (this.gNo) {
            this.mNoDataView = NoDataViewFactory.a(this.gNh.getPageContext().getPageActivity(), this.bBg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.cBh), NoDataViewFactory.d.ad(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.gNh.getPageContext().getPageActivity(), this.bBg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.cBh), NoDataViewFactory.d.ad(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.gNh.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.bBg.findViewById(R.id.progress);
        this.gNk = (InviteFriendCandidateList) this.bBg.findViewById(R.id.candidate_list);
        this.gNk.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
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
        this.gNl = (LinearLayout) this.bBg.findViewById(R.id.invite_candidate);
        this.gNj = this.bBg.findViewById(R.id.invite_candidate_border);
        if (this.gNo) {
            this.gNl.setVisibility(8);
            this.gNj.setVisibility(8);
        }
        bEM();
        this.gNm = (Button) this.bBg.findViewById(R.id.button_send);
        this.gNm.setOnClickListener(this.gNh);
        ajG();
        bEE();
        vy(0);
    }

    private void aHO() {
        this.mNavigationBar = (NavigationBar) this.bBg.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.gNq != null && d.this.gNq.getVisibility() == 0) {
                    d.this.bEF();
                    return;
                }
                l.b(d.this.gNh.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.gNh.finish();
            }
        });
        if (this.gNo) {
            this.gNp = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.gNp = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.gNr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.gNp.setVisibility(8);
                d.this.gNr.setVisibility(8);
                d.this.gNq.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.c(d.this.gNh.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.gNt = (ImageView) this.gNr.findViewById(R.id.new_friend_search);
        this.gNq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.gNq.setVisibility(8);
        this.mEditText = (EditText) this.gNq.findViewById(R.id.search_bar_edit);
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
                        d.this.gNs.setVisibility(0);
                    } else {
                        d.this.gNs.setVisibility(8);
                    }
                    d.this.bED();
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
        this.gNs = (TextView) this.gNq.findViewById(R.id.search_bar_delete_button);
        this.gNs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bED() {
        if (this.gNh != null) {
            this.gNh.bEB();
        }
    }

    public void ajG() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gNh.getLayoutMode().setNightMode(skinType == 1);
        this.gNh.getLayoutMode().onModeChanged(this.bBg);
        al.a(this.gNt, (int) R.drawable.icon_search_bg_s, (int) R.drawable.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.gNh.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.gNh.getPageContext(), skinType);
        al.k(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void bEE() {
        this.MS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void bEF() {
        l.b(this.gNh.getPageContext().getPageActivity(), this.mEditText);
        this.gNq.setVisibility(8);
        this.gNp.setVisibility(0);
        this.gNr.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean bEG() {
        return this.gNq != null && this.gNq.getVisibility() == 0;
    }

    public int bEH() {
        return this.gNm.getId();
    }

    public String bEI() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String bEJ() {
        return this.gNk.bEy();
    }

    public void n(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.gNi == null) {
            this.gNi = new c(this.gNh, this.gNo);
            this.gNi.a(this);
            this.gNi.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.bEO() <= d.this.gNk.getItemLength()) {
                                d.this.gNh.showToast(String.format(d.this.gNh.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.gNn)));
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
            this.MS.setAdapter((ListAdapter) this.gNi);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.MS.setVisibility(8);
            if (!this.gNo) {
                this.gNl.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.MS.setVisibility(0);
        this.gNi.setData(list);
        this.gNi.notifyDataSetChanged();
        if (!this.gNo) {
            this.gNl.setVisibility(0);
        }
    }

    public void bEK() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.gNh.getPageContext());
        }
    }

    public void bEL() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void bEM() {
        int dimensionPixelSize = this.gNh.getResources().getDimensionPixelSize(R.dimen.ds80) + this.gNh.getResources().getDimensionPixelSize(R.dimen.ds16) + this.gNh.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.gNh.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.MS.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gNk.d(aVar);
            vy(this.gNk.getItemLength());
            bEN();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gNk.f(aVar);
            vy(this.gNk.getItemLength());
            bEN();
        }
    }

    private void bEN() {
        if (this.gNk.getItemLength() > 0) {
            this.gNm.setEnabled(true);
        } else {
            this.gNm.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.b(this.gNh.getPageContext().getPageActivity(), this.mEditText);
    }

    private void vy(int i) {
        this.gNm.setText(String.format(this.gNh.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int bEO() {
        return this.gNn;
    }

    public void vz(int i) {
        this.gNn = i;
        this.gNk.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gNk.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
