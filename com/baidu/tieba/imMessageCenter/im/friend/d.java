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
    private final InviteFriendListActivity hOG;
    private c hOH;
    private View hOI;
    private InviteFriendCandidateList hOJ;
    private LinearLayout hOK;
    private Button hOL;
    private int hOM;
    private boolean hON;
    private TextView hOO;
    private View hOP;
    private View hOQ;
    private TextView hOR;
    private ImageView hOS;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.hOM = 0;
        this.hOG = inviteFriendListActivity;
        this.hON = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.hOG.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.hOG.findViewById(R.id.root_view);
        bcO();
        this.AG = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.AG.setOnItemClickListener(this.hOG);
        if (this.hON) {
            this.mNoDataView = NoDataViewFactory.a(this.hOG.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.NET_RERESHNEW_TOP_MARGIN), NoDataViewFactory.d.aF(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.hOG.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.NET_RERESHNEW_TOP_MARGIN), NoDataViewFactory.d.aF(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.hOG.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.hOJ = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.hOJ.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
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
        this.hOK = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.hOI = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.hON) {
            this.hOK.setVisibility(8);
            this.hOI.setVisibility(8);
        }
        bZy();
        this.hOL = (Button) this.mRoot.findViewById(R.id.button_send);
        this.hOL.setOnClickListener(this.hOG);
        aHS();
        bZq();
        xf(0);
    }

    private void bcO() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.hOP != null && d.this.hOP.getVisibility() == 0) {
                    d.this.bZr();
                    return;
                }
                l.hideSoftKeyPad(d.this.hOG.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.hOG.finish();
            }
        });
        if (this.hON) {
            this.hOO = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.hOO = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.hOQ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.hOO.setVisibility(8);
                d.this.hOQ.setVisibility(8);
                d.this.hOP.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.hOG.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.hOS = (ImageView) this.hOQ.findViewById(R.id.new_friend_search);
        this.hOP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.hOP.setVisibility(8);
        this.mEditText = (EditText) this.hOP.findViewById(R.id.search_bar_edit);
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
                        d.this.hOR.setVisibility(0);
                    } else {
                        d.this.hOR.setVisibility(8);
                    }
                    d.this.bZp();
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
        this.hOR = (TextView) this.hOP.findViewById(R.id.search_bar_delete_button);
        this.hOR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZp() {
        if (this.hOG != null) {
            this.hOG.bZn();
        }
    }

    public void aHS() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.hOG.getLayoutMode().setNightMode(skinType == 1);
        this.hOG.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.aGG().a(this.hOS, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.hOG.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.hOG.getPageContext(), skinType);
        am.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void bZq() {
        this.AG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void bZr() {
        l.hideSoftKeyPad(this.hOG.getPageContext().getPageActivity(), this.mEditText);
        this.hOP.setVisibility(8);
        this.hOO.setVisibility(0);
        this.hOQ.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean bZs() {
        return this.hOP != null && this.hOP.getVisibility() == 0;
    }

    public int bZt() {
        return this.hOL.getId();
    }

    public String bZu() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String bZv() {
        return this.hOJ.getDataList();
    }

    public void s(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.hOH == null) {
            this.hOH = new c(this.hOG, this.hON);
            this.hOH.a(this);
            this.hOH.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.bZA() <= d.this.hOJ.getItemLength()) {
                                d.this.hOG.showToast(String.format(d.this.hOG.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.hOM)));
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
            this.AG.setAdapter((ListAdapter) this.hOH);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.AG.setVisibility(8);
            if (!this.hON) {
                this.hOK.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.AG.setVisibility(0);
        this.hOH.setData(list);
        this.hOH.notifyDataSetChanged();
        if (!this.hON) {
            this.hOK.setVisibility(0);
        }
    }

    public void bZw() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.hOG.getPageContext());
        }
    }

    public void bZx() {
        if (this.mNoDataView != null) {
            this.mNoDataView.aHG();
        }
    }

    private void bZy() {
        int dimensionPixelSize = this.hOG.getResources().getDimensionPixelSize(R.dimen.ds80) + this.hOG.getResources().getDimensionPixelSize(R.dimen.ds16) + this.hOG.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.hOG.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.AG.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.hOJ.d(aVar);
            xf(this.hOJ.getItemLength());
            bZz();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.hOJ.f(aVar);
            xf(this.hOJ.getItemLength());
            bZz();
        }
    }

    private void bZz() {
        if (this.hOJ.getItemLength() > 0) {
            this.hOL.setEnabled(true);
        } else {
            this.hOL.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.hOG.getPageContext().getPageActivity(), this.mEditText);
    }

    private void xf(int i) {
        this.hOL.setText(String.format(this.hOG.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int bZA() {
        return this.hOM;
    }

    public void xg(int i) {
        this.hOM = i;
        this.hOJ.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.hOJ.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
