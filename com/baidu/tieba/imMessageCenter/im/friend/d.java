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
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private final InviteFriendListActivity gUf;
    private c gUg;
    private View gUh;
    private InviteFriendCandidateList gUi;
    private LinearLayout gUj;
    private Button gUk;
    private int gUl;
    private boolean gUm;
    private TextView gUn;
    private View gUo;
    private View gUp;
    private TextView gUq;
    private ImageView gUr;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;
    private BdListView yl;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.gUl = 0;
        this.gUf = inviteFriendListActivity;
        this.gUm = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.gUf.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.gUf.findViewById(R.id.root_view);
        aJx();
        this.yl = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.yl.setOnItemClickListener(this.gUf);
        if (this.gUm) {
            this.mNoDataView = NoDataViewFactory.a(this.gUf.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.NET_RERESHNEW_TOP_MARGIN), NoDataViewFactory.d.ak(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.gUf.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.NET_RERESHNEW_TOP_MARGIN), NoDataViewFactory.d.ak(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.gUf.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.gUi = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.gUi.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.yl.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.gUj = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.gUh = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.gUm) {
            this.gUj.setVisibility(8);
            this.gUh.setVisibility(8);
        }
        bFj();
        this.gUk = (Button) this.mRoot.findViewById(R.id.button_send);
        this.gUk.setOnClickListener(this.gUf);
        anO();
        bFb();
        uL(0);
    }

    private void aJx() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.gUo != null && d.this.gUo.getVisibility() == 0) {
                    d.this.bFc();
                    return;
                }
                l.hideSoftKeyPad(d.this.gUf.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.gUf.finish();
            }
        });
        if (this.gUm) {
            this.gUn = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.gUn = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.gUp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.gUn.setVisibility(8);
                d.this.gUp.setVisibility(8);
                d.this.gUo.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.gUf.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.gUr = (ImageView) this.gUp.findViewById(R.id.new_friend_search);
        this.gUo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.gUo.setVisibility(8);
        this.mEditText = (EditText) this.gUo.findViewById(R.id.search_bar_edit);
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
                        d.this.gUq.setVisibility(0);
                    } else {
                        d.this.gUq.setVisibility(8);
                    }
                    d.this.bFa();
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
        this.gUq = (TextView) this.gUo.findViewById(R.id.search_bar_delete_button);
        this.gUq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFa() {
        if (this.gUf != null) {
            this.gUf.bEY();
        }
    }

    public void anO() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gUf.getLayoutMode().setNightMode(skinType == 1);
        this.gUf.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.amN().a(this.gUr, R.drawable.icon_pure_topbar_search_n_svg, R.color.cp_cont_b, null);
        this.mNavigationBar.onChangeSkinType(this.gUf.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.gUf.getPageContext(), skinType);
        am.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void bFb() {
        this.yl.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void bFc() {
        l.hideSoftKeyPad(this.gUf.getPageContext().getPageActivity(), this.mEditText);
        this.gUo.setVisibility(8);
        this.gUn.setVisibility(0);
        this.gUp.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean bFd() {
        return this.gUo != null && this.gUo.getVisibility() == 0;
    }

    public int bFe() {
        return this.gUk.getId();
    }

    public String bFf() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String bFg() {
        return this.gUi.getDataList();
    }

    public void p(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.gUg == null) {
            this.gUg = new c(this.gUf, this.gUm);
            this.gUg.a(this);
            this.gUg.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.bFl() <= d.this.gUi.getItemLength()) {
                                d.this.gUf.showToast(String.format(d.this.gUf.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.gUl)));
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
            this.yl.setAdapter((ListAdapter) this.gUg);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.yl.setVisibility(8);
            if (!this.gUm) {
                this.gUj.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.yl.setVisibility(0);
        this.gUg.setData(list);
        this.gUg.notifyDataSetChanged();
        if (!this.gUm) {
            this.gUj.setVisibility(0);
        }
    }

    public void bFh() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.gUf.getPageContext());
        }
    }

    public void bFi() {
        if (this.mNoDataView != null) {
            this.mNoDataView.anG();
        }
    }

    private void bFj() {
        int dimensionPixelSize = this.gUf.getResources().getDimensionPixelSize(R.dimen.ds80) + this.gUf.getResources().getDimensionPixelSize(R.dimen.ds16) + this.gUf.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.gUf.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.yl.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gUi.d(aVar);
            uL(this.gUi.getItemLength());
            bFk();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gUi.f(aVar);
            uL(this.gUi.getItemLength());
            bFk();
        }
    }

    private void bFk() {
        if (this.gUi.getItemLength() > 0) {
            this.gUk.setEnabled(true);
        } else {
            this.gUk.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.gUf.getPageContext().getPageActivity(), this.mEditText);
    }

    private void uL(int i) {
        this.gUk.setText(String.format(this.gUf.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int bFl() {
        return this.gUl;
    }

    public void uM(int i) {
        this.gUl = i;
        this.gUi.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gUi.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
