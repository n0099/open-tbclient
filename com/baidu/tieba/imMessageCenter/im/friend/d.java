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
    private final InviteFriendListActivity iNX;
    private c iNY;
    private View iNZ;
    private InviteFriendCandidateList iOa;
    private LinearLayout iOb;
    private Button iOc;
    private int iOd;
    private boolean iOe;
    private TextView iOf;
    private View iOg;
    private View iOh;
    private TextView iOi;
    private ImageView iOj;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.iOd = 0;
        this.iNX = inviteFriendListActivity;
        this.iOe = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.iNX.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.iNX.findViewById(R.id.root_view);
        brd();
        this.Um = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.Um.setOnItemClickListener(this.iNX);
        if (this.iOe) {
            this.mNoDataView = NoDataViewFactory.a(this.iNX.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.euP), NoDataViewFactory.d.aM(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.iNX.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.euP), NoDataViewFactory.d.aM(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.iNX.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.iOa = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.iOa.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
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
        this.iOb = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.iNZ = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.iOe) {
            this.iOb.setVisibility(8);
            this.iNZ.setVisibility(8);
        }
        cqF();
        this.iOc = (Button) this.mRoot.findViewById(R.id.button_send);
        this.iOc.setOnClickListener(this.iNX);
        aWr();
        cqx();
        yl(0);
    }

    private void brd() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.iOg != null && d.this.iOg.getVisibility() == 0) {
                    d.this.cqy();
                    return;
                }
                l.hideSoftKeyPad(d.this.iNX.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.iNX.finish();
            }
        });
        if (this.iOe) {
            this.iOf = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.iOf = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.iOh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.iOf.setVisibility(8);
                d.this.iOh.setVisibility(8);
                d.this.iOg.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.iNX.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.iOj = (ImageView) this.iOh.findViewById(R.id.new_friend_search);
        this.iOg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.iOg.setVisibility(8);
        this.mEditText = (EditText) this.iOg.findViewById(R.id.search_bar_edit);
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
                        d.this.iOi.setVisibility(0);
                    } else {
                        d.this.iOi.setVisibility(8);
                    }
                    d.this.cqw();
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
        this.iOi = (TextView) this.iOg.findViewById(R.id.search_bar_delete_button);
        this.iOi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqw() {
        if (this.iNX != null) {
            this.iNX.cqu();
        }
    }

    public void aWr() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.iNX.getLayoutMode().setNightMode(skinType == 1);
        this.iNX.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.aUW().a(this.iOj, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.iNX.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.iNX.getPageContext(), skinType);
        am.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void cqx() {
        this.Um.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void cqy() {
        l.hideSoftKeyPad(this.iNX.getPageContext().getPageActivity(), this.mEditText);
        this.iOg.setVisibility(8);
        this.iOf.setVisibility(0);
        this.iOh.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean cqz() {
        return this.iOg != null && this.iOg.getVisibility() == 0;
    }

    public int cqA() {
        return this.iOc.getId();
    }

    public String cqB() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String cqC() {
        return this.iOa.getDataList();
    }

    public void r(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.iNY == null) {
            this.iNY = new c(this.iNX, this.iOe);
            this.iNY.a(this);
            this.iNY.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.cqH() <= d.this.iOa.getItemLength()) {
                                d.this.iNX.showToast(String.format(d.this.iNX.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.iOd)));
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
            this.Um.setAdapter((ListAdapter) this.iNY);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Um.setVisibility(8);
            if (!this.iOe) {
                this.iOb.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Um.setVisibility(0);
        this.iNY.setData(list);
        this.iNY.notifyDataSetChanged();
        if (!this.iOe) {
            this.iOb.setVisibility(0);
        }
    }

    public void cqD() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.iNX.getPageContext());
        }
    }

    public void cqE() {
        if (this.mNoDataView != null) {
            this.mNoDataView.aWa();
        }
    }

    private void cqF() {
        int dimensionPixelSize = this.iNX.getResources().getDimensionPixelSize(R.dimen.ds80) + this.iNX.getResources().getDimensionPixelSize(R.dimen.ds16) + this.iNX.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.iNX.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Um.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.iOa.d(aVar);
            yl(this.iOa.getItemLength());
            cqG();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.iOa.f(aVar);
            yl(this.iOa.getItemLength());
            cqG();
        }
    }

    private void cqG() {
        if (this.iOa.getItemLength() > 0) {
            this.iOc.setEnabled(true);
        } else {
            this.iOc.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.iNX.getPageContext().getPageActivity(), this.mEditText);
    }

    private void yl(int i) {
        this.iOc.setText(String.format(this.iNX.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int cqH() {
        return this.iOd;
    }

    public void ym(int i) {
        this.iOd = i;
        this.iOa.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.iOa.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
