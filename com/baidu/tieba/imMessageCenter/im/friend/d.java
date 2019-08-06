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
    private final InviteFriendListActivity gUm;
    private c gUn;
    private View gUo;
    private InviteFriendCandidateList gUp;
    private LinearLayout gUq;
    private Button gUr;
    private int gUs;
    private boolean gUt;
    private TextView gUu;
    private View gUv;
    private View gUw;
    private TextView gUx;
    private ImageView gUy;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.gUs = 0;
        this.gUm = inviteFriendListActivity;
        this.gUt = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.gUm.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.gUm.findViewById(R.id.root_view);
        aJt();
        this.Ni = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.Ni.setOnItemClickListener(this.gUm);
        if (this.gUt) {
            this.mNoDataView = NoDataViewFactory.a(this.gUm.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.cCG), NoDataViewFactory.d.ag(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.gUm.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.cCG), NoDataViewFactory.d.ag(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.gUm.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.gUp = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.gUp.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
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
        this.gUq = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.gUo = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.gUt) {
            this.gUq.setVisibility(8);
            this.gUo.setVisibility(8);
        }
        bHL();
        this.gUr = (Button) this.mRoot.findViewById(R.id.button_send);
        this.gUr.setOnClickListener(this.gUm);
        akN();
        bHD();
        wb(0);
    }

    private void aJt() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.gUv != null && d.this.gUv.getVisibility() == 0) {
                    d.this.bHE();
                    return;
                }
                l.b(d.this.gUm.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.gUm.finish();
            }
        });
        if (this.gUt) {
            this.gUu = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.gUu = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.gUw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.gUu.setVisibility(8);
                d.this.gUw.setVisibility(8);
                d.this.gUv.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.c(d.this.gUm.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.gUy = (ImageView) this.gUw.findViewById(R.id.new_friend_search);
        this.gUv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.gUv.setVisibility(8);
        this.mEditText = (EditText) this.gUv.findViewById(R.id.search_bar_edit);
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
                        d.this.gUx.setVisibility(0);
                    } else {
                        d.this.gUx.setVisibility(8);
                    }
                    d.this.bHC();
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
        this.gUx = (TextView) this.gUv.findViewById(R.id.search_bar_delete_button);
        this.gUx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHC() {
        if (this.gUm != null) {
            this.gUm.bHA();
        }
    }

    public void akN() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gUm.getLayoutMode().setNightMode(skinType == 1);
        this.gUm.getLayoutMode().onModeChanged(this.mRoot);
        am.a(this.gUy, (int) R.drawable.icon_search_bg_s, (int) R.drawable.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.gUm.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.gUm.getPageContext(), skinType);
        am.k(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void bHD() {
        this.Ni.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void bHE() {
        l.b(this.gUm.getPageContext().getPageActivity(), this.mEditText);
        this.gUv.setVisibility(8);
        this.gUu.setVisibility(0);
        this.gUw.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean bHF() {
        return this.gUv != null && this.gUv.getVisibility() == 0;
    }

    public int bHG() {
        return this.gUr.getId();
    }

    public String bHH() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String bHI() {
        return this.gUp.bHx();
    }

    public void p(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.gUn == null) {
            this.gUn = new c(this.gUm, this.gUt);
            this.gUn.a(this);
            this.gUn.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.bHN() <= d.this.gUp.getItemLength()) {
                                d.this.gUm.showToast(String.format(d.this.gUm.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.gUs)));
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
            this.Ni.setAdapter((ListAdapter) this.gUn);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Ni.setVisibility(8);
            if (!this.gUt) {
                this.gUq.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Ni.setVisibility(0);
        this.gUn.setData(list);
        this.gUn.notifyDataSetChanged();
        if (!this.gUt) {
            this.gUq.setVisibility(0);
        }
    }

    public void bHJ() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.gUm.getPageContext());
        }
    }

    public void bHK() {
        if (this.mNoDataView != null) {
            this.mNoDataView.akw();
        }
    }

    private void bHL() {
        int dimensionPixelSize = this.gUm.getResources().getDimensionPixelSize(R.dimen.ds80) + this.gUm.getResources().getDimensionPixelSize(R.dimen.ds16) + this.gUm.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.gUm.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Ni.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gUp.d(aVar);
            wb(this.gUp.getItemLength());
            bHM();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gUp.f(aVar);
            wb(this.gUp.getItemLength());
            bHM();
        }
    }

    private void bHM() {
        if (this.gUp.getItemLength() > 0) {
            this.gUr.setEnabled(true);
        } else {
            this.gUr.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.b(this.gUm.getPageContext().getPageActivity(), this.mEditText);
    }

    private void wb(int i) {
        this.gUr.setText(String.format(this.gUm.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int bHN() {
        return this.gUs;
    }

    public void wc(int i) {
        this.gUs = i;
        this.gUp.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gUp.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
