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
    private BdListView AG;
    private final InviteFriendListActivity hNg;
    private c hNh;
    private View hNi;
    private InviteFriendCandidateList hNj;
    private LinearLayout hNk;
    private Button hNl;
    private int hNm;
    private boolean hNn;
    private TextView hNo;
    private View hNp;
    private View hNq;
    private TextView hNr;
    private ImageView hNs;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.hNm = 0;
        this.hNg = inviteFriendListActivity;
        this.hNn = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.hNg.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.hNg.findViewById(R.id.root_view);
        bcK();
        this.AG = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.AG.setOnItemClickListener(this.hNg);
        if (this.hNn) {
            this.mNoDataView = NoDataViewFactory.a(this.hNg.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.NET_RERESHNEW_TOP_MARGIN), NoDataViewFactory.d.aF(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.hNg.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.NET_RERESHNEW_TOP_MARGIN), NoDataViewFactory.d.aF(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.hNg.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.hNj = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.hNj.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.AG.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.hNk = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.hNi = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.hNn) {
            this.hNk.setVisibility(8);
            this.hNi.setVisibility(8);
        }
        bZg();
        this.hNl = (Button) this.mRoot.findViewById(R.id.button_send);
        this.hNl.setOnClickListener(this.hNg);
        aHO();
        bYY();
        wX(0);
    }

    private void bcK() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.hNp != null && d.this.hNp.getVisibility() == 0) {
                    d.this.bYZ();
                    return;
                }
                l.hideSoftKeyPad(d.this.hNg.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.hNg.finish();
            }
        });
        if (this.hNn) {
            this.hNo = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.hNo = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.hNq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.hNo.setVisibility(8);
                d.this.hNq.setVisibility(8);
                d.this.hNp.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.hNg.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.hNs = (ImageView) this.hNq.findViewById(R.id.new_friend_search);
        this.hNp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.hNp.setVisibility(8);
        this.mEditText = (EditText) this.hNp.findViewById(R.id.search_bar_edit);
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
                        d.this.hNr.setVisibility(0);
                    } else {
                        d.this.hNr.setVisibility(8);
                    }
                    d.this.bYX();
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
        this.hNr = (TextView) this.hNp.findViewById(R.id.search_bar_delete_button);
        this.hNr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYX() {
        if (this.hNg != null) {
            this.hNg.bYV();
        }
    }

    public void aHO() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hNg.getLayoutMode().setNightMode(skinType == 1);
        this.hNg.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.aGC().a(this.hNs, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.hNg.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.hNg.getPageContext(), skinType);
        am.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void bYY() {
        this.AG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void bYZ() {
        l.hideSoftKeyPad(this.hNg.getPageContext().getPageActivity(), this.mEditText);
        this.hNp.setVisibility(8);
        this.hNo.setVisibility(0);
        this.hNq.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean bZa() {
        return this.hNp != null && this.hNp.getVisibility() == 0;
    }

    public int bZb() {
        return this.hNl.getId();
    }

    public String bZc() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String bZd() {
        return this.hNj.getDataList();
    }

    public void s(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.hNh == null) {
            this.hNh = new c(this.hNg, this.hNn);
            this.hNh.a(this);
            this.hNh.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.bZi() <= d.this.hNj.getItemLength()) {
                                d.this.hNg.showToast(String.format(d.this.hNg.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.hNm)));
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
            this.AG.setAdapter((ListAdapter) this.hNh);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.AG.setVisibility(8);
            if (!this.hNn) {
                this.hNk.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.AG.setVisibility(0);
        this.hNh.setData(list);
        this.hNh.notifyDataSetChanged();
        if (!this.hNn) {
            this.hNk.setVisibility(0);
        }
    }

    public void bZe() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.hNg.getPageContext());
        }
    }

    public void bZf() {
        if (this.mNoDataView != null) {
            this.mNoDataView.aHC();
        }
    }

    private void bZg() {
        int dimensionPixelSize = this.hNg.getResources().getDimensionPixelSize(R.dimen.ds80) + this.hNg.getResources().getDimensionPixelSize(R.dimen.ds16) + this.hNg.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.hNg.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.AG.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.hNj.d(aVar);
            wX(this.hNj.getItemLength());
            bZh();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.hNj.f(aVar);
            wX(this.hNj.getItemLength());
            bZh();
        }
    }

    private void bZh() {
        if (this.hNj.getItemLength() > 0) {
            this.hNl.setEnabled(true);
        } else {
            this.hNl.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.hNg.getPageContext().getPageActivity(), this.mEditText);
    }

    private void wX(int i) {
        this.hNl.setText(String.format(this.hNg.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int bZi() {
        return this.hNm;
    }

    public void wY(int i) {
        this.hNm = i;
        this.hNj.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.hNj.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
