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
    private BdListView MR;
    private View bBg;
    private final InviteFriendListActivity gNk;
    private c gNl;
    private View gNm;
    private InviteFriendCandidateList gNn;
    private LinearLayout gNo;
    private Button gNp;
    private int gNq;
    private boolean gNr;
    private TextView gNs;
    private View gNt;
    private View gNu;
    private TextView gNv;
    private ImageView gNw;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.gNq = 0;
        this.gNk = inviteFriendListActivity;
        this.gNr = z;
        initialize();
    }

    public View getRootView() {
        return this.bBg;
    }

    private void initialize() {
        this.gNk.setContentView(R.layout.invite_friend_list);
        this.bBg = this.gNk.findViewById(R.id.root_view);
        aHR();
        this.MR = (BdListView) this.bBg.findViewById(R.id.friend_list);
        this.MR.setOnItemClickListener(this.gNk);
        if (this.gNr) {
            this.mNoDataView = NoDataViewFactory.a(this.gNk.getPageContext().getPageActivity(), this.bBg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.cBi), NoDataViewFactory.d.ad(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.gNk.getPageContext().getPageActivity(), this.bBg, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.cBi), NoDataViewFactory.d.ad(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.gNk.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.bBg.findViewById(R.id.progress);
        this.gNn = (InviteFriendCandidateList) this.bBg.findViewById(R.id.candidate_list);
        this.gNn.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.MR.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.gNo = (LinearLayout) this.bBg.findViewById(R.id.invite_candidate);
        this.gNm = this.bBg.findViewById(R.id.invite_candidate_border);
        if (this.gNr) {
            this.gNo.setVisibility(8);
            this.gNm.setVisibility(8);
        }
        bEQ();
        this.gNp = (Button) this.bBg.findViewById(R.id.button_send);
        this.gNp.setOnClickListener(this.gNk);
        ajG();
        bEI();
        vy(0);
    }

    private void aHR() {
        this.mNavigationBar = (NavigationBar) this.bBg.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.gNt != null && d.this.gNt.getVisibility() == 0) {
                    d.this.bEJ();
                    return;
                }
                l.b(d.this.gNk.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.gNk.finish();
            }
        });
        if (this.gNr) {
            this.gNs = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.gNs = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.gNu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.gNs.setVisibility(8);
                d.this.gNu.setVisibility(8);
                d.this.gNt.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.c(d.this.gNk.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.gNw = (ImageView) this.gNu.findViewById(R.id.new_friend_search);
        this.gNt = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.gNt.setVisibility(8);
        this.mEditText = (EditText) this.gNt.findViewById(R.id.search_bar_edit);
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
                        d.this.gNv.setVisibility(0);
                    } else {
                        d.this.gNv.setVisibility(8);
                    }
                    d.this.bEH();
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
        this.gNv = (TextView) this.gNt.findViewById(R.id.search_bar_delete_button);
        this.gNv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEH() {
        if (this.gNk != null) {
            this.gNk.bEF();
        }
    }

    public void ajG() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gNk.getLayoutMode().setNightMode(skinType == 1);
        this.gNk.getLayoutMode().onModeChanged(this.bBg);
        al.a(this.gNw, (int) R.drawable.icon_search_bg_s, (int) R.drawable.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.gNk.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.gNk.getPageContext(), skinType);
        al.k(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void bEI() {
        this.MR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void bEJ() {
        l.b(this.gNk.getPageContext().getPageActivity(), this.mEditText);
        this.gNt.setVisibility(8);
        this.gNs.setVisibility(0);
        this.gNu.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean bEK() {
        return this.gNt != null && this.gNt.getVisibility() == 0;
    }

    public int bEL() {
        return this.gNp.getId();
    }

    public String bEM() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String bEN() {
        return this.gNn.bEC();
    }

    public void n(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.gNl == null) {
            this.gNl = new c(this.gNk, this.gNr);
            this.gNl.a(this);
            this.gNl.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.bES() <= d.this.gNn.getItemLength()) {
                                d.this.gNk.showToast(String.format(d.this.gNk.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.gNq)));
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
            this.MR.setAdapter((ListAdapter) this.gNl);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.MR.setVisibility(8);
            if (!this.gNr) {
                this.gNo.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.MR.setVisibility(0);
        this.gNl.setData(list);
        this.gNl.notifyDataSetChanged();
        if (!this.gNr) {
            this.gNo.setVisibility(0);
        }
    }

    public void bEO() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.gNk.getPageContext());
        }
    }

    public void bEP() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void bEQ() {
        int dimensionPixelSize = this.gNk.getResources().getDimensionPixelSize(R.dimen.ds80) + this.gNk.getResources().getDimensionPixelSize(R.dimen.ds16) + this.gNk.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.gNk.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.MR.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gNn.d(aVar);
            vy(this.gNn.getItemLength());
            bER();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gNn.f(aVar);
            vy(this.gNn.getItemLength());
            bER();
        }
    }

    private void bER() {
        if (this.gNn.getItemLength() > 0) {
            this.gNp.setEnabled(true);
        } else {
            this.gNp.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.b(this.gNk.getPageContext().getPageActivity(), this.mEditText);
    }

    private void vy(int i) {
        this.gNp.setText(String.format(this.gNk.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int bES() {
        return this.gNq;
    }

    public void vz(int i) {
        this.gNq = i;
        this.gNn.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gNn.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
