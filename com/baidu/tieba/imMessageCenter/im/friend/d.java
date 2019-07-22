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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
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
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView Ni;
    private int gTA;
    private boolean gTB;
    private TextView gTC;
    private View gTD;
    private View gTE;
    private TextView gTF;
    private ImageView gTG;
    private final InviteFriendListActivity gTu;
    private c gTv;
    private View gTw;
    private InviteFriendCandidateList gTx;
    private LinearLayout gTy;
    private Button gTz;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.gTA = 0;
        this.gTu = inviteFriendListActivity;
        this.gTB = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.gTu.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.gTu.findViewById(R.id.root_view);
        aJr();
        this.Ni = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.Ni.setOnItemClickListener(this.gTu);
        if (this.gTB) {
            this.mNoDataView = NoDataViewFactory.a(this.gTu.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.cCz), NoDataViewFactory.d.ag(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.gTu.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.cCz), NoDataViewFactory.d.ag(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.gTu.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.gTx = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.gTx.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.Ni.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.gTy = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.gTw = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.gTB) {
            this.gTy.setVisibility(8);
            this.gTw.setVisibility(8);
        }
        bHx();
        this.gTz = (Button) this.mRoot.findViewById(R.id.button_send);
        this.gTz.setOnClickListener(this.gTu);
        akL();
        bHp();
        vZ(0);
    }

    private void aJr() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.gTD != null && d.this.gTD.getVisibility() == 0) {
                    d.this.bHq();
                    return;
                }
                l.b(d.this.gTu.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.gTu.finish();
            }
        });
        if (this.gTB) {
            this.gTC = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.gTC = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.gTE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.gTC.setVisibility(8);
                d.this.gTE.setVisibility(8);
                d.this.gTD.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.c(d.this.gTu.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.gTG = (ImageView) this.gTE.findViewById(R.id.new_friend_search);
        this.gTD = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.gTD.setVisibility(8);
        this.mEditText = (EditText) this.gTD.findViewById(R.id.search_bar_edit);
        if (this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a = k.a(editable, null);
                if (a != null) {
                    if (a.length() > 0) {
                        d.this.gTF.setVisibility(0);
                    } else {
                        d.this.gTF.setVisibility(8);
                    }
                    d.this.bHo();
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
        this.gTF = (TextView) this.gTD.findViewById(R.id.search_bar_delete_button);
        this.gTF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHo() {
        if (this.gTu != null) {
            this.gTu.bHm();
        }
    }

    public void akL() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gTu.getLayoutMode().setNightMode(skinType == 1);
        this.gTu.getLayoutMode().onModeChanged(this.mRoot);
        am.a(this.gTG, (int) R.drawable.icon_search_bg_s, (int) R.drawable.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.gTu.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.gTu.getPageContext(), skinType);
        am.k(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void bHp() {
        this.Ni.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void bHq() {
        l.b(this.gTu.getPageContext().getPageActivity(), this.mEditText);
        this.gTD.setVisibility(8);
        this.gTC.setVisibility(0);
        this.gTE.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean bHr() {
        return this.gTD != null && this.gTD.getVisibility() == 0;
    }

    public int bHs() {
        return this.gTz.getId();
    }

    public String bHt() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String bHu() {
        return this.gTx.bHj();
    }

    public void p(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.gTv == null) {
            this.gTv = new c(this.gTu, this.gTB);
            this.gTv.a(this);
            this.gTv.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.bHz() <= d.this.gTx.getItemLength()) {
                                d.this.gTu.showToast(String.format(d.this.gTu.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.gTA)));
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
            this.Ni.setAdapter((ListAdapter) this.gTv);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Ni.setVisibility(8);
            if (!this.gTB) {
                this.gTy.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Ni.setVisibility(0);
        this.gTv.setData(list);
        this.gTv.notifyDataSetChanged();
        if (!this.gTB) {
            this.gTy.setVisibility(0);
        }
    }

    public void bHv() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.gTu.getPageContext());
        }
    }

    public void bHw() {
        if (this.mNoDataView != null) {
            this.mNoDataView.aku();
        }
    }

    private void bHx() {
        int dimensionPixelSize = this.gTu.getResources().getDimensionPixelSize(R.dimen.ds80) + this.gTu.getResources().getDimensionPixelSize(R.dimen.ds16) + this.gTu.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.gTu.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Ni.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gTx.d(aVar);
            vZ(this.gTx.getItemLength());
            bHy();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gTx.f(aVar);
            vZ(this.gTx.getItemLength());
            bHy();
        }
    }

    private void bHy() {
        if (this.gTx.getItemLength() > 0) {
            this.gTz.setEnabled(true);
        } else {
            this.gTz.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.b(this.gTu.getPageContext().getPageActivity(), this.mEditText);
    }

    private void vZ(int i) {
        this.gTz.setText(String.format(this.gTu.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int bHz() {
        return this.gTA;
    }

    public void wa(int i) {
        this.gTA = i;
        this.gTx.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gTx.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
