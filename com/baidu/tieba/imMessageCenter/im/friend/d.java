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
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.d<InviteFriendListActivity> implements c.b {
    private BdListView WV;
    private EditText cDt;
    private final InviteFriendListActivity kLL;
    private c kLM;
    private View kLN;
    private InviteFriendCandidateList kLO;
    private LinearLayout kLP;
    private Button kLQ;
    private int kLR;
    private boolean kLS;
    private TextView kLT;
    private View kLU;
    private View kLV;
    private TextView kLW;
    private ImageView kLX;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.kLR = 0;
        this.kLL = inviteFriendListActivity;
        this.kLS = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.kLL.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.kLL.findViewById(R.id.root_view);
        bIk();
        this.WV = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.WV.setOnItemClickListener(this.kLL);
        if (this.kLS) {
            this.mNoDataView = NoDataViewFactory.a(this.kLL.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fOZ), NoDataViewFactory.d.aY(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.kLL.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, BdListViewHelper.fOZ), NoDataViewFactory.d.aY(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.kLL.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.kLO = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.kLO.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.WV.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.kLP = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.kLN = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.kLS) {
            this.kLP.setVisibility(8);
            this.kLN.setVisibility(8);
        }
        daH();
        this.kLQ = (Button) this.mRoot.findViewById(R.id.button_send);
        this.kLQ.setOnClickListener(this.kLL);
        bxO();
        daz();
        EF(0);
    }

    private void bIk() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.kLU != null && d.this.kLU.getVisibility() == 0) {
                    d.this.daA();
                    return;
                }
                l.hideSoftKeyPad(d.this.kLL.getPageContext().getPageActivity(), d.this.cDt);
                d.this.kLL.finish();
            }
        });
        if (this.kLS) {
            this.kLT = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.kLT = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.kLV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.kLT.setVisibility(8);
                d.this.kLV.setVisibility(8);
                d.this.kLU.setVisibility(0);
                d.this.cDt.requestFocus();
                l.showSoftKeyPad(d.this.kLL.getPageContext().getPageActivity(), d.this.cDt);
            }
        });
        this.kLX = (ImageView) this.kLV.findViewById(R.id.new_friend_search);
        this.kLU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.kLU.setVisibility(8);
        this.cDt = (EditText) this.kLU.findViewById(R.id.search_bar_edit);
        if (this.cDt.getParent() != null) {
            ((View) this.cDt.getParent()).setFocusable(true);
            ((View) this.cDt.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String charSequence2String = k.charSequence2String(editable, null);
                if (charSequence2String != null) {
                    if (charSequence2String.length() > 0) {
                        d.this.kLW.setVisibility(0);
                    } else {
                        d.this.kLW.setVisibility(8);
                    }
                    d.this.day();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.cDt.addTextChangedListener(this.mTextWatcher);
        this.kLW = (TextView) this.kLU.findViewById(R.id.search_bar_delete_button);
        this.kLW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.cDt.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void day() {
        if (this.kLL != null) {
            this.kLL.daw();
        }
    }

    public void bxO() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kLL.getLayoutMode().setNightMode(skinType == 1);
        this.kLL.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.bwq().a(this.kLX, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.kLL.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.kLL.getPageContext(), skinType);
        ao.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void daz() {
        this.WV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void daA() {
        l.hideSoftKeyPad(this.kLL.getPageContext().getPageActivity(), this.cDt);
        this.kLU.setVisibility(8);
        this.kLT.setVisibility(0);
        this.kLV.setVisibility(0);
        this.cDt.getText().clear();
    }

    public boolean daB() {
        return this.kLU != null && this.kLU.getVisibility() == 0;
    }

    public int daC() {
        return this.kLQ.getId();
    }

    public String daD() {
        Editable text = this.cDt.getText();
        return text != null ? text.toString() : "";
    }

    public String daE() {
        return this.kLO.getDataList();
    }

    public void t(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.kLM == null) {
            this.kLM = new c(this.kLL, this.kLS);
            this.kLM.a(this);
            this.kLM.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.daJ() <= d.this.kLO.getItemLength()) {
                                d.this.kLL.showToast(String.format(d.this.kLL.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.kLR)));
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
            this.WV.setAdapter((ListAdapter) this.kLM);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.WV.setVisibility(8);
            if (!this.kLS) {
                this.kLP.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.WV.setVisibility(0);
        this.kLM.setData(list);
        this.kLM.notifyDataSetChanged();
        if (!this.kLS) {
            this.kLP.setVisibility(0);
        }
    }

    public void daF() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.kLL.getPageContext());
        }
    }

    public void daG() {
        if (this.mNoDataView != null) {
            this.mNoDataView.bxw();
        }
    }

    private void daH() {
        int dimensionPixelSize = this.kLL.getResources().getDimensionPixelSize(R.dimen.ds80) + this.kLL.getResources().getDimensionPixelSize(R.dimen.ds16) + this.kLL.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.kLL.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.WV.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kLO.d(aVar);
            EF(this.kLO.getItemLength());
            daI();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kLO.f(aVar);
            EF(this.kLO.getItemLength());
            daI();
        }
    }

    private void daI() {
        if (this.kLO.getItemLength() > 0) {
            this.kLQ.setEnabled(true);
        } else {
            this.kLQ.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.kLL.getPageContext().getPageActivity(), this.cDt);
    }

    private void EF(int i) {
        this.kLQ.setText(String.format(this.kLL.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int daJ() {
        return this.kLR;
    }

    public void EG(int i) {
        this.kLR = i;
        this.kLO.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kLO.e(aVar);
        }
    }

    public void onDestroy() {
        this.cDt.removeTextChangedListener(this.mTextWatcher);
    }
}
