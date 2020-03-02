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
    private final InviteFriendListActivity hMU;
    private c hMV;
    private View hMW;
    private InviteFriendCandidateList hMX;
    private LinearLayout hMY;
    private Button hMZ;
    private int hNa;
    private boolean hNb;
    private TextView hNc;
    private View hNd;
    private View hNe;
    private TextView hNf;
    private ImageView hNg;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.hNa = 0;
        this.hMU = inviteFriendListActivity;
        this.hNb = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.hMU.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.hMU.findViewById(R.id.root_view);
        bcJ();
        this.AG = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.AG.setOnItemClickListener(this.hMU);
        if (this.hNb) {
            this.mNoDataView = NoDataViewFactory.a(this.hMU.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.NET_RERESHNEW_TOP_MARGIN), NoDataViewFactory.d.aF(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.hMU.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.NET_RERESHNEW_TOP_MARGIN), NoDataViewFactory.d.aF(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.hMU.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.hMX = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.hMX.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
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
        this.hMY = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.hMW = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.hNb) {
            this.hMY.setVisibility(8);
            this.hMW.setVisibility(8);
        }
        bZf();
        this.hMZ = (Button) this.mRoot.findViewById(R.id.button_send);
        this.hMZ.setOnClickListener(this.hMU);
        aHN();
        bYX();
        wX(0);
    }

    private void bcJ() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.hNd != null && d.this.hNd.getVisibility() == 0) {
                    d.this.bYY();
                    return;
                }
                l.hideSoftKeyPad(d.this.hMU.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.hMU.finish();
            }
        });
        if (this.hNb) {
            this.hNc = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.hNc = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.hNe = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.hNc.setVisibility(8);
                d.this.hNe.setVisibility(8);
                d.this.hNd.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.hMU.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.hNg = (ImageView) this.hNe.findViewById(R.id.new_friend_search);
        this.hNd = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.hNd.setVisibility(8);
        this.mEditText = (EditText) this.hNd.findViewById(R.id.search_bar_edit);
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
                        d.this.hNf.setVisibility(0);
                    } else {
                        d.this.hNf.setVisibility(8);
                    }
                    d.this.bYW();
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
        this.hNf = (TextView) this.hNd.findViewById(R.id.search_bar_delete_button);
        this.hNf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYW() {
        if (this.hMU != null) {
            this.hMU.bYU();
        }
    }

    public void aHN() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hMU.getLayoutMode().setNightMode(skinType == 1);
        this.hMU.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.aGC().a(this.hNg, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.hMU.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.hMU.getPageContext(), skinType);
        am.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void bYX() {
        this.AG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void bYY() {
        l.hideSoftKeyPad(this.hMU.getPageContext().getPageActivity(), this.mEditText);
        this.hNd.setVisibility(8);
        this.hNc.setVisibility(0);
        this.hNe.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean bYZ() {
        return this.hNd != null && this.hNd.getVisibility() == 0;
    }

    public int bZa() {
        return this.hMZ.getId();
    }

    public String bZb() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String bZc() {
        return this.hMX.getDataList();
    }

    public void s(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.hMV == null) {
            this.hMV = new c(this.hMU, this.hNb);
            this.hMV.a(this);
            this.hMV.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.bZh() <= d.this.hMX.getItemLength()) {
                                d.this.hMU.showToast(String.format(d.this.hMU.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.hNa)));
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
            this.AG.setAdapter((ListAdapter) this.hMV);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.AG.setVisibility(8);
            if (!this.hNb) {
                this.hMY.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.AG.setVisibility(0);
        this.hMV.setData(list);
        this.hMV.notifyDataSetChanged();
        if (!this.hNb) {
            this.hMY.setVisibility(0);
        }
    }

    public void bZd() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.hMU.getPageContext());
        }
    }

    public void bZe() {
        if (this.mNoDataView != null) {
            this.mNoDataView.aHB();
        }
    }

    private void bZf() {
        int dimensionPixelSize = this.hMU.getResources().getDimensionPixelSize(R.dimen.ds80) + this.hMU.getResources().getDimensionPixelSize(R.dimen.ds16) + this.hMU.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.hMU.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.AG.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.hMX.d(aVar);
            wX(this.hMX.getItemLength());
            bZg();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.hMX.f(aVar);
            wX(this.hMX.getItemLength());
            bZg();
        }
    }

    private void bZg() {
        if (this.hMX.getItemLength() > 0) {
            this.hMZ.setEnabled(true);
        } else {
            this.hMZ.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.hMU.getPageContext().getPageActivity(), this.mEditText);
    }

    private void wX(int i) {
        this.hMZ.setText(String.format(this.hMU.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int bZh() {
        return this.hNa;
    }

    public void wY(int i) {
        this.hNa = i;
        this.hMX.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.hMX.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
