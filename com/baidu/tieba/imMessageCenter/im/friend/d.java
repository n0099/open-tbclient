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
    private final InviteFriendListActivity hMS;
    private c hMT;
    private View hMU;
    private InviteFriendCandidateList hMV;
    private LinearLayout hMW;
    private Button hMX;
    private int hMY;
    private boolean hMZ;
    private TextView hNa;
    private View hNb;
    private View hNc;
    private TextView hNd;
    private ImageView hNe;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.hMY = 0;
        this.hMS = inviteFriendListActivity;
        this.hMZ = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.hMS.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.hMS.findViewById(R.id.root_view);
        bcH();
        this.AG = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.AG.setOnItemClickListener(this.hMS);
        if (this.hMZ) {
            this.mNoDataView = NoDataViewFactory.a(this.hMS.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.NET_RERESHNEW_TOP_MARGIN), NoDataViewFactory.d.aF(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.hMS.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.NET_RERESHNEW_TOP_MARGIN), NoDataViewFactory.d.aF(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.hMS.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.hMV = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.hMV.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
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
        this.hMW = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.hMU = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.hMZ) {
            this.hMW.setVisibility(8);
            this.hMU.setVisibility(8);
        }
        bZd();
        this.hMX = (Button) this.mRoot.findViewById(R.id.button_send);
        this.hMX.setOnClickListener(this.hMS);
        aHL();
        bYV();
        wX(0);
    }

    private void bcH() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.hNb != null && d.this.hNb.getVisibility() == 0) {
                    d.this.bYW();
                    return;
                }
                l.hideSoftKeyPad(d.this.hMS.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.hMS.finish();
            }
        });
        if (this.hMZ) {
            this.hNa = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.hNa = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.hNc = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.hNa.setVisibility(8);
                d.this.hNc.setVisibility(8);
                d.this.hNb.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.hMS.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.hNe = (ImageView) this.hNc.findViewById(R.id.new_friend_search);
        this.hNb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.hNb.setVisibility(8);
        this.mEditText = (EditText) this.hNb.findViewById(R.id.search_bar_edit);
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
                        d.this.hNd.setVisibility(0);
                    } else {
                        d.this.hNd.setVisibility(8);
                    }
                    d.this.bYU();
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
        this.hNd = (TextView) this.hNb.findViewById(R.id.search_bar_delete_button);
        this.hNd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYU() {
        if (this.hMS != null) {
            this.hMS.bYS();
        }
    }

    public void aHL() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hMS.getLayoutMode().setNightMode(skinType == 1);
        this.hMS.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.aGA().a(this.hNe, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.hMS.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.hMS.getPageContext(), skinType);
        am.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void bYV() {
        this.AG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void bYW() {
        l.hideSoftKeyPad(this.hMS.getPageContext().getPageActivity(), this.mEditText);
        this.hNb.setVisibility(8);
        this.hNa.setVisibility(0);
        this.hNc.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean bYX() {
        return this.hNb != null && this.hNb.getVisibility() == 0;
    }

    public int bYY() {
        return this.hMX.getId();
    }

    public String bYZ() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String bZa() {
        return this.hMV.getDataList();
    }

    public void s(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.hMT == null) {
            this.hMT = new c(this.hMS, this.hMZ);
            this.hMT.a(this);
            this.hMT.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.bZf() <= d.this.hMV.getItemLength()) {
                                d.this.hMS.showToast(String.format(d.this.hMS.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.hMY)));
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
            this.AG.setAdapter((ListAdapter) this.hMT);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.AG.setVisibility(8);
            if (!this.hMZ) {
                this.hMW.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.AG.setVisibility(0);
        this.hMT.setData(list);
        this.hMT.notifyDataSetChanged();
        if (!this.hMZ) {
            this.hMW.setVisibility(0);
        }
    }

    public void bZb() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.hMS.getPageContext());
        }
    }

    public void bZc() {
        if (this.mNoDataView != null) {
            this.mNoDataView.aHz();
        }
    }

    private void bZd() {
        int dimensionPixelSize = this.hMS.getResources().getDimensionPixelSize(R.dimen.ds80) + this.hMS.getResources().getDimensionPixelSize(R.dimen.ds16) + this.hMS.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.hMS.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.AG.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.hMV.d(aVar);
            wX(this.hMV.getItemLength());
            bZe();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.hMV.f(aVar);
            wX(this.hMV.getItemLength());
            bZe();
        }
    }

    private void bZe() {
        if (this.hMV.getItemLength() > 0) {
            this.hMX.setEnabled(true);
        } else {
            this.hMX.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.hMS.getPageContext().getPageActivity(), this.mEditText);
    }

    private void wX(int i) {
        this.hMX.setText(String.format(this.hMS.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int bZf() {
        return this.hMY;
    }

    public void wY(int i) {
        this.hMY = i;
        this.hMV.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.hMV.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
