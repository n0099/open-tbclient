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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
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
/* loaded from: classes6.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView Ak;
    private View hHA;
    private View hHB;
    private TextView hHC;
    private ImageView hHD;
    private final InviteFriendListActivity hHr;
    private c hHs;
    private View hHt;
    private InviteFriendCandidateList hHu;
    private LinearLayout hHv;
    private Button hHw;
    private int hHx;
    private boolean hHy;
    private TextView hHz;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.hHx = 0;
        this.hHr = inviteFriendListActivity;
        this.hHy = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.hHr.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.hHr.findViewById(R.id.root_view);
        aZT();
        this.Ak = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.Ak.setOnItemClickListener(this.hHr);
        if (this.hHy) {
            this.mNoDataView = NoDataViewFactory.a(this.hHr.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.NET_RERESHNEW_TOP_MARGIN), NoDataViewFactory.d.aB(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.hHr.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.NET_RERESHNEW_TOP_MARGIN), NoDataViewFactory.d.aB(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.hHr.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.hHu = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.hHu.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.Ak.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.hHv = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.hHt = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.hHy) {
            this.hHv.setVisibility(8);
            this.hHt.setVisibility(8);
        }
        bWt();
        this.hHw = (Button) this.mRoot.findViewById(R.id.button_send);
        this.hHw.setOnClickListener(this.hHr);
        aFd();
        bWl();
        wM(0);
    }

    private void aZT() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.hHA != null && d.this.hHA.getVisibility() == 0) {
                    d.this.bWm();
                    return;
                }
                l.hideSoftKeyPad(d.this.hHr.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.hHr.finish();
            }
        });
        if (this.hHy) {
            this.hHz = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.hHz = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.hHB = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.hHz.setVisibility(8);
                d.this.hHB.setVisibility(8);
                d.this.hHA.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.hHr.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.hHD = (ImageView) this.hHB.findViewById(R.id.new_friend_search);
        this.hHA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.hHA.setVisibility(8);
        this.mEditText = (EditText) this.hHA.findViewById(R.id.search_bar_edit);
        if (this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String charSequence2String = k.charSequence2String(editable, null);
                if (charSequence2String != null) {
                    if (charSequence2String.length() > 0) {
                        d.this.hHC.setVisibility(0);
                    } else {
                        d.this.hHC.setVisibility(8);
                    }
                    d.this.bWk();
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
        this.hHC = (TextView) this.hHA.findViewById(R.id.search_bar_delete_button);
        this.hHC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWk() {
        if (this.hHr != null) {
            this.hHr.bWi();
        }
    }

    public void aFd() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hHr.getLayoutMode().setNightMode(skinType == 1);
        this.hHr.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.aDW().a(this.hHD, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.hHr.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.hHr.getPageContext(), skinType);
        am.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void bWl() {
        this.Ak.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void bWm() {
        l.hideSoftKeyPad(this.hHr.getPageContext().getPageActivity(), this.mEditText);
        this.hHA.setVisibility(8);
        this.hHz.setVisibility(0);
        this.hHB.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean bWn() {
        return this.hHA != null && this.hHA.getVisibility() == 0;
    }

    public int bWo() {
        return this.hHw.getId();
    }

    public String bWp() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String bWq() {
        return this.hHu.getDataList();
    }

    public void p(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.hHs == null) {
            this.hHs = new c(this.hHr, this.hHy);
            this.hHs.a(this);
            this.hHs.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.bWv() <= d.this.hHu.getItemLength()) {
                                d.this.hHr.showToast(String.format(d.this.hHr.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.hHx)));
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
            this.Ak.setAdapter((ListAdapter) this.hHs);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Ak.setVisibility(8);
            if (!this.hHy) {
                this.hHv.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Ak.setVisibility(0);
        this.hHs.setData(list);
        this.hHs.notifyDataSetChanged();
        if (!this.hHy) {
            this.hHv.setVisibility(0);
        }
    }

    public void bWr() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.hHr.getPageContext());
        }
    }

    public void bWs() {
        if (this.mNoDataView != null) {
            this.mNoDataView.aEU();
        }
    }

    private void bWt() {
        int dimensionPixelSize = this.hHr.getResources().getDimensionPixelSize(R.dimen.ds80) + this.hHr.getResources().getDimensionPixelSize(R.dimen.ds16) + this.hHr.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.hHr.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Ak.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.hHu.d(aVar);
            wM(this.hHu.getItemLength());
            bWu();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.hHu.f(aVar);
            wM(this.hHu.getItemLength());
            bWu();
        }
    }

    private void bWu() {
        if (this.hHu.getItemLength() > 0) {
            this.hHw.setEnabled(true);
        } else {
            this.hHw.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.hHr.getPageContext().getPageActivity(), this.mEditText);
    }

    private void wM(int i) {
        this.hHw.setText(String.format(this.hHr.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int bWv() {
        return this.hHx;
    }

    public void wN(int i) {
        this.hHx = i;
        this.hHu.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.hHu.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
