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
/* loaded from: classes7.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView Ao;
    private final InviteFriendListActivity hKU;
    private c hKV;
    private View hKW;
    private InviteFriendCandidateList hKX;
    private LinearLayout hKY;
    private Button hKZ;
    private int hLa;
    private boolean hLb;
    private TextView hLc;
    private View hLd;
    private View hLe;
    private TextView hLf;
    private ImageView hLg;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.hLa = 0;
        this.hKU = inviteFriendListActivity;
        this.hLb = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.hKU.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.hKU.findViewById(R.id.root_view);
        bas();
        this.Ao = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.Ao.setOnItemClickListener(this.hKU);
        if (this.hLb) {
            this.mNoDataView = NoDataViewFactory.a(this.hKU.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.NET_RERESHNEW_TOP_MARGIN), NoDataViewFactory.d.aF(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.hKU.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.NET_RERESHNEW_TOP_MARGIN), NoDataViewFactory.d.aF(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.hKU.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.hKX = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.hKX.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.Ao.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.hKY = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.hKW = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.hLb) {
            this.hKY.setVisibility(8);
            this.hKW.setVisibility(8);
        }
        bXC();
        this.hKZ = (Button) this.mRoot.findViewById(R.id.button_send);
        this.hKZ.setOnClickListener(this.hKU);
        aFw();
        bXu();
        wR(0);
    }

    private void bas() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.hLd != null && d.this.hLd.getVisibility() == 0) {
                    d.this.bXv();
                    return;
                }
                l.hideSoftKeyPad(d.this.hKU.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.hKU.finish();
            }
        });
        if (this.hLb) {
            this.hLc = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.hLc = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.hLe = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.hLc.setVisibility(8);
                d.this.hLe.setVisibility(8);
                d.this.hLd.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.hKU.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.hLg = (ImageView) this.hLe.findViewById(R.id.new_friend_search);
        this.hLd = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.hLd.setVisibility(8);
        this.mEditText = (EditText) this.hLd.findViewById(R.id.search_bar_edit);
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
                        d.this.hLf.setVisibility(0);
                    } else {
                        d.this.hLf.setVisibility(8);
                    }
                    d.this.bXt();
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
        this.hLf = (TextView) this.hLd.findViewById(R.id.search_bar_delete_button);
        this.hLf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXt() {
        if (this.hKU != null) {
            this.hKU.bXr();
        }
    }

    public void aFw() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hKU.getLayoutMode().setNightMode(skinType == 1);
        this.hKU.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.aEp().a(this.hLg, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.hKU.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.hKU.getPageContext(), skinType);
        am.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void bXu() {
        this.Ao.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void bXv() {
        l.hideSoftKeyPad(this.hKU.getPageContext().getPageActivity(), this.mEditText);
        this.hLd.setVisibility(8);
        this.hLc.setVisibility(0);
        this.hLe.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean bXw() {
        return this.hLd != null && this.hLd.getVisibility() == 0;
    }

    public int bXx() {
        return this.hKZ.getId();
    }

    public String bXy() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String bXz() {
        return this.hKX.getDataList();
    }

    public void r(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.hKV == null) {
            this.hKV = new c(this.hKU, this.hLb);
            this.hKV.a(this);
            this.hKV.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.bXE() <= d.this.hKX.getItemLength()) {
                                d.this.hKU.showToast(String.format(d.this.hKU.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.hLa)));
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
            this.Ao.setAdapter((ListAdapter) this.hKV);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Ao.setVisibility(8);
            if (!this.hLb) {
                this.hKY.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Ao.setVisibility(0);
        this.hKV.setData(list);
        this.hKV.notifyDataSetChanged();
        if (!this.hLb) {
            this.hKY.setVisibility(0);
        }
    }

    public void bXA() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.hKU.getPageContext());
        }
    }

    public void bXB() {
        if (this.mNoDataView != null) {
            this.mNoDataView.aFn();
        }
    }

    private void bXC() {
        int dimensionPixelSize = this.hKU.getResources().getDimensionPixelSize(R.dimen.ds80) + this.hKU.getResources().getDimensionPixelSize(R.dimen.ds16) + this.hKU.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.hKU.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Ao.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.hKX.d(aVar);
            wR(this.hKX.getItemLength());
            bXD();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.hKX.f(aVar);
            wR(this.hKX.getItemLength());
            bXD();
        }
    }

    private void bXD() {
        if (this.hKX.getItemLength() > 0) {
            this.hKZ.setEnabled(true);
        } else {
            this.hKZ.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.hKU.getPageContext().getPageActivity(), this.mEditText);
    }

    private void wR(int i) {
        this.hKZ.setText(String.format(this.hKU.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int bXE() {
        return this.hLa;
    }

    public void wS(int i) {
        this.hLa = i;
        this.hKX.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.hKX.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
