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
/* loaded from: classes9.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView Um;
    private final InviteFriendListActivity iNk;
    private c iNl;
    private View iNm;
    private InviteFriendCandidateList iNn;
    private LinearLayout iNo;
    private Button iNp;
    private int iNq;
    private boolean iNr;
    private TextView iNs;
    private View iNt;
    private View iNu;
    private TextView iNv;
    private ImageView iNw;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.iNq = 0;
        this.iNk = inviteFriendListActivity;
        this.iNr = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.iNk.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.iNk.findViewById(R.id.root_view);
        brb();
        this.Um = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.Um.setOnItemClickListener(this.iNk);
        if (this.iNr) {
            this.mNoDataView = NoDataViewFactory.a(this.iNk.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.euP), NoDataViewFactory.d.aM(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.iNk.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.euP), NoDataViewFactory.d.aM(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.iNk.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.iNn = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.iNn.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.Um.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.iNo = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.iNm = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.iNr) {
            this.iNo.setVisibility(8);
            this.iNm.setVisibility(8);
        }
        cqw();
        this.iNp = (Button) this.mRoot.findViewById(R.id.button_send);
        this.iNp.setOnClickListener(this.iNk);
        aWq();
        cqo();
        yj(0);
    }

    private void brb() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.iNt != null && d.this.iNt.getVisibility() == 0) {
                    d.this.cqp();
                    return;
                }
                l.hideSoftKeyPad(d.this.iNk.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.iNk.finish();
            }
        });
        if (this.iNr) {
            this.iNs = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.iNs = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.iNu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.iNs.setVisibility(8);
                d.this.iNu.setVisibility(8);
                d.this.iNt.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.iNk.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.iNw = (ImageView) this.iNu.findViewById(R.id.new_friend_search);
        this.iNt = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.iNt.setVisibility(8);
        this.mEditText = (EditText) this.iNt.findViewById(R.id.search_bar_edit);
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
                        d.this.iNv.setVisibility(0);
                    } else {
                        d.this.iNv.setVisibility(8);
                    }
                    d.this.cqn();
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
        this.iNv = (TextView) this.iNt.findViewById(R.id.search_bar_delete_button);
        this.iNv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqn() {
        if (this.iNk != null) {
            this.iNk.cql();
        }
    }

    public void aWq() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.iNk.getLayoutMode().setNightMode(skinType == 1);
        this.iNk.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.aUV().a(this.iNw, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.iNk.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.iNk.getPageContext(), skinType);
        am.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void cqo() {
        this.Um.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void cqp() {
        l.hideSoftKeyPad(this.iNk.getPageContext().getPageActivity(), this.mEditText);
        this.iNt.setVisibility(8);
        this.iNs.setVisibility(0);
        this.iNu.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean cqq() {
        return this.iNt != null && this.iNt.getVisibility() == 0;
    }

    public int cqr() {
        return this.iNp.getId();
    }

    public String cqs() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String cqt() {
        return this.iNn.getDataList();
    }

    public void r(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.iNl == null) {
            this.iNl = new c(this.iNk, this.iNr);
            this.iNl.a(this);
            this.iNl.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.cqy() <= d.this.iNn.getItemLength()) {
                                d.this.iNk.showToast(String.format(d.this.iNk.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.iNq)));
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
            this.Um.setAdapter((ListAdapter) this.iNl);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Um.setVisibility(8);
            if (!this.iNr) {
                this.iNo.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Um.setVisibility(0);
        this.iNl.setData(list);
        this.iNl.notifyDataSetChanged();
        if (!this.iNr) {
            this.iNo.setVisibility(0);
        }
    }

    public void cqu() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.iNk.getPageContext());
        }
    }

    public void cqv() {
        if (this.mNoDataView != null) {
            this.mNoDataView.aVZ();
        }
    }

    private void cqw() {
        int dimensionPixelSize = this.iNk.getResources().getDimensionPixelSize(R.dimen.ds80) + this.iNk.getResources().getDimensionPixelSize(R.dimen.ds16) + this.iNk.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.iNk.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Um.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.iNn.d(aVar);
            yj(this.iNn.getItemLength());
            cqx();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.iNn.f(aVar);
            yj(this.iNn.getItemLength());
            cqx();
        }
    }

    private void cqx() {
        if (this.iNn.getItemLength() > 0) {
            this.iNp.setEnabled(true);
        } else {
            this.iNp.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.iNk.getPageContext().getPageActivity(), this.mEditText);
    }

    private void yj(int i) {
        this.iNp.setText(String.format(this.iNk.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int cqy() {
        return this.iNq;
    }

    public void yk(int i) {
        this.iNq = i;
        this.iNn.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.iNn.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
