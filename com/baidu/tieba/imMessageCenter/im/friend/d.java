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
/* loaded from: classes16.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView UL;
    private InviteFriendCandidateList jnA;
    private LinearLayout jnB;
    private Button jnC;
    private int jnD;
    private boolean jnE;
    private TextView jnF;
    private View jnG;
    private View jnH;
    private TextView jnI;
    private ImageView jnJ;
    private final InviteFriendListActivity jnx;
    private c jny;
    private View jnz;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.jnD = 0;
        this.jnx = inviteFriendListActivity;
        this.jnE = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.jnx.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.jnx.findViewById(R.id.root_view);
        bmb();
        this.UL = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.UL.setOnItemClickListener(this.jnx);
        if (this.jnE) {
            this.mNoDataView = NoDataViewFactory.a(this.jnx.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.eKp), NoDataViewFactory.d.aQ(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.jnx.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.eKp), NoDataViewFactory.d.aQ(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.jnx.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.jnA = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.jnA.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.UL.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.jnB = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.jnz = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.jnE) {
            this.jnB.setVisibility(8);
            this.jnz.setVisibility(8);
        }
        cyx();
        this.jnC = (Button) this.mRoot.findViewById(R.id.button_send);
        this.jnC.setOnClickListener(this.jnx);
        bci();
        cyp();
        zu(0);
    }

    private void bmb() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.jnG != null && d.this.jnG.getVisibility() == 0) {
                    d.this.cyq();
                    return;
                }
                l.hideSoftKeyPad(d.this.jnx.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.jnx.finish();
            }
        });
        if (this.jnE) {
            this.jnF = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.jnF = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.jnH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.jnF.setVisibility(8);
                d.this.jnH.setVisibility(8);
                d.this.jnG.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.jnx.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.jnJ = (ImageView) this.jnH.findViewById(R.id.new_friend_search);
        this.jnG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.jnG.setVisibility(8);
        this.mEditText = (EditText) this.jnG.findViewById(R.id.search_bar_edit);
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
                        d.this.jnI.setVisibility(0);
                    } else {
                        d.this.jnI.setVisibility(8);
                    }
                    d.this.cyo();
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
        this.jnI = (TextView) this.jnG.findViewById(R.id.search_bar_delete_button);
        this.jnI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyo() {
        if (this.jnx != null) {
            this.jnx.cym();
        }
    }

    public void bci() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jnx.getLayoutMode().setNightMode(skinType == 1);
        this.jnx.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.baR().a(this.jnJ, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.jnx.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.jnx.getPageContext(), skinType);
        ao.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void cyp() {
        this.UL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void cyq() {
        l.hideSoftKeyPad(this.jnx.getPageContext().getPageActivity(), this.mEditText);
        this.jnG.setVisibility(8);
        this.jnF.setVisibility(0);
        this.jnH.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean cyr() {
        return this.jnG != null && this.jnG.getVisibility() == 0;
    }

    public int cys() {
        return this.jnC.getId();
    }

    public String cyt() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String cyu() {
        return this.jnA.getDataList();
    }

    public void p(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.jny == null) {
            this.jny = new c(this.jnx, this.jnE);
            this.jny.a(this);
            this.jny.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.cyz() <= d.this.jnA.getItemLength()) {
                                d.this.jnx.showToast(String.format(d.this.jnx.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.jnD)));
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
            this.UL.setAdapter((ListAdapter) this.jny);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.UL.setVisibility(8);
            if (!this.jnE) {
                this.jnB.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.UL.setVisibility(0);
        this.jny.setData(list);
        this.jny.notifyDataSetChanged();
        if (!this.jnE) {
            this.jnB.setVisibility(0);
        }
    }

    public void cyv() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.jnx.getPageContext());
        }
    }

    public void cyw() {
        if (this.mNoDataView != null) {
            this.mNoDataView.bbU();
        }
    }

    private void cyx() {
        int dimensionPixelSize = this.jnx.getResources().getDimensionPixelSize(R.dimen.ds80) + this.jnx.getResources().getDimensionPixelSize(R.dimen.ds16) + this.jnx.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.jnx.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.UL.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.jnA.d(aVar);
            zu(this.jnA.getItemLength());
            cyy();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.jnA.f(aVar);
            zu(this.jnA.getItemLength());
            cyy();
        }
    }

    private void cyy() {
        if (this.jnA.getItemLength() > 0) {
            this.jnC.setEnabled(true);
        } else {
            this.jnC.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.jnx.getPageContext().getPageActivity(), this.mEditText);
    }

    private void zu(int i) {
        this.jnC.setText(String.format(this.jnx.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int cyz() {
        return this.jnD;
    }

    public void zv(int i) {
        this.jnD = i;
        this.jnA.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.jnA.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
