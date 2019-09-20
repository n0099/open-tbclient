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
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView Nj;
    private final InviteFriendListActivity gWf;
    private c gWg;
    private View gWh;
    private InviteFriendCandidateList gWi;
    private LinearLayout gWj;
    private Button gWk;
    private int gWl;
    private boolean gWm;
    private TextView gWn;
    private View gWo;
    private View gWp;
    private TextView gWq;
    private ImageView gWr;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.gWl = 0;
        this.gWf = inviteFriendListActivity;
        this.gWm = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.gWf.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.gWf.findViewById(R.id.root_view);
        aJX();
        this.Nj = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.Nj.setOnItemClickListener(this.gWf);
        if (this.gWm) {
            this.mNoDataView = NoDataViewFactory.a(this.gWf.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.cDC), NoDataViewFactory.d.ag(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.gWf.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.cDC), NoDataViewFactory.d.ag(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.gWf.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.gWi = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.gWi.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.Nj.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.gWj = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.gWh = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.gWm) {
            this.gWj.setVisibility(8);
            this.gWh.setVisibility(8);
        }
        bIz();
        this.gWk = (Button) this.mRoot.findViewById(R.id.button_send);
        this.gWk.setOnClickListener(this.gWf);
        akZ();
        bIr();
        wf(0);
    }

    private void aJX() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.gWo != null && d.this.gWo.getVisibility() == 0) {
                    d.this.bIs();
                    return;
                }
                l.b(d.this.gWf.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.gWf.finish();
            }
        });
        if (this.gWm) {
            this.gWn = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.gWn = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.gWp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.gWn.setVisibility(8);
                d.this.gWp.setVisibility(8);
                d.this.gWo.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.c(d.this.gWf.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.gWr = (ImageView) this.gWp.findViewById(R.id.new_friend_search);
        this.gWo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.gWo.setVisibility(8);
        this.mEditText = (EditText) this.gWo.findViewById(R.id.search_bar_edit);
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
                        d.this.gWq.setVisibility(0);
                    } else {
                        d.this.gWq.setVisibility(8);
                    }
                    d.this.bIq();
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
        this.gWq = (TextView) this.gWo.findViewById(R.id.search_bar_delete_button);
        this.gWq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIq() {
        if (this.gWf != null) {
            this.gWf.bIo();
        }
    }

    public void akZ() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gWf.getLayoutMode().setNightMode(skinType == 1);
        this.gWf.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.ajv().a(this.gWr, R.drawable.icon_pure_topbar_search_n_svg, R.color.cp_cont_b, null);
        this.mNavigationBar.onChangeSkinType(this.gWf.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.gWf.getPageContext(), skinType);
        am.k(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void bIr() {
        this.Nj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void bIs() {
        l.b(this.gWf.getPageContext().getPageActivity(), this.mEditText);
        this.gWo.setVisibility(8);
        this.gWn.setVisibility(0);
        this.gWp.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean bIt() {
        return this.gWo != null && this.gWo.getVisibility() == 0;
    }

    public int bIu() {
        return this.gWk.getId();
    }

    public String bIv() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String bIw() {
        return this.gWi.bIl();
    }

    public void p(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.gWg == null) {
            this.gWg = new c(this.gWf, this.gWm);
            this.gWg.a(this);
            this.gWg.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.bIB() <= d.this.gWi.getItemLength()) {
                                d.this.gWf.showToast(String.format(d.this.gWf.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.gWl)));
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
            this.Nj.setAdapter((ListAdapter) this.gWg);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Nj.setVisibility(8);
            if (!this.gWm) {
                this.gWj.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Nj.setVisibility(0);
        this.gWg.setData(list);
        this.gWg.notifyDataSetChanged();
        if (!this.gWm) {
            this.gWj.setVisibility(0);
        }
    }

    public void bIx() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.gWf.getPageContext());
        }
    }

    public void bIy() {
        if (this.mNoDataView != null) {
            this.mNoDataView.akI();
        }
    }

    private void bIz() {
        int dimensionPixelSize = this.gWf.getResources().getDimensionPixelSize(R.dimen.ds80) + this.gWf.getResources().getDimensionPixelSize(R.dimen.ds16) + this.gWf.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.gWf.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Nj.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gWi.d(aVar);
            wf(this.gWi.getItemLength());
            bIA();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gWi.f(aVar);
            wf(this.gWi.getItemLength());
            bIA();
        }
    }

    private void bIA() {
        if (this.gWi.getItemLength() > 0) {
            this.gWk.setEnabled(true);
        } else {
            this.gWk.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.b(this.gWf.getPageContext().getPageActivity(), this.mEditText);
    }

    private void wf(int i) {
        this.gWk.setText(String.format(this.gWf.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int bIB() {
        return this.gWl;
    }

    public void wg(int i) {
        this.gWl = i;
        this.gWi.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gWi.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
