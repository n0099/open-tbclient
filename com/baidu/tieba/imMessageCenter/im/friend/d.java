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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView FL;
    private View Tl;
    private final InviteFriendListActivity elk;
    private c ell;
    private View elm;
    private InviteFriendCandidateList eln;
    private LinearLayout elo;
    private Button elp;
    private int elq;
    private boolean elr;
    private TextView els;
    private View elt;
    private View elu;
    private TextView elv;
    private ImageView elw;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.elq = 0;
        this.elk = inviteFriendListActivity;
        this.elr = z;
        initialize();
    }

    public View getRootView() {
        return this.Tl;
    }

    private void initialize() {
        this.elk.setContentView(d.i.invite_friend_list);
        this.Tl = this.elk.findViewById(d.g.root_view);
        are();
        this.FL = (BdListView) this.Tl.findViewById(d.g.friend_list);
        this.FL.setOnItemClickListener(this.elk);
        if (this.elr) {
            this.mNoDataView = NoDataViewFactory.a(this.elk.getPageContext().getPageActivity(), this.Tl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aNm), NoDataViewFactory.d.C(d.k.no_friends, d.k.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.elk.getPageContext().getPageActivity(), this.Tl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aNm), NoDataViewFactory.d.C(d.k.no_chat_friends, d.k.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.k.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.elk.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.Tl.findViewById(d.g.progress);
        this.eln = (InviteFriendCandidateList) this.Tl.findViewById(d.g.candidate_list);
        this.eln.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view2, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.FL.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.elo = (LinearLayout) this.Tl.findViewById(d.g.invite_candidate);
        this.elm = this.Tl.findViewById(d.g.invite_candidate_border);
        if (this.elr) {
            this.elo.setVisibility(8);
            this.elm.setVisibility(8);
        }
        aIb();
        this.elp = (Button) this.Tl.findViewById(d.g.button_send);
        this.elp.setOnClickListener(this.elk);
        wY();
        aHT();
        oc(0);
    }

    private void are() {
        this.mNavigationBar = (NavigationBar) this.Tl.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (d.this.elt != null && d.this.elt.getVisibility() == 0) {
                    d.this.aHU();
                    return;
                }
                l.b(d.this.elk.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.elk.finish();
            }
        });
        if (this.elr) {
            this.els = this.mNavigationBar.setTitleText(d.k.invite_contact_title);
        } else {
            this.els = this.mNavigationBar.setTitleText(d.k.invite_friend);
        }
        this.elu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.els.setVisibility(8);
                d.this.elu.setVisibility(8);
                d.this.elt.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.c(d.this.elk.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.elw = (ImageView) this.elu.findViewById(d.g.new_friend_search);
        this.elt = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.navigationbar_search_edit, (View.OnClickListener) null);
        this.elt.setVisibility(8);
        this.mEditText = (EditText) this.elt.findViewById(d.g.search_bar_edit);
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
                        d.this.elv.setVisibility(0);
                    } else {
                        d.this.elv.setVisibility(8);
                    }
                    d.this.aHS();
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
        this.elv = (TextView) this.elt.findViewById(d.g.search_bar_delete_button);
        this.elv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHS() {
        if (this.elk != null) {
            this.elk.aHQ();
        }
    }

    public void wY() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.elk.getLayoutMode().setNightMode(skinType == 1);
        this.elk.getLayoutMode().u(this.Tl);
        ak.a(this.elw, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.elk.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.elk.getPageContext(), skinType);
        ak.i(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aHT() {
        this.FL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                d.this.aId();
                return false;
            }
        });
    }

    public void aHU() {
        l.b(this.elk.getPageContext().getPageActivity(), this.mEditText);
        this.elt.setVisibility(8);
        this.els.setVisibility(0);
        this.elu.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean aHV() {
        return this.elt != null && this.elt.getVisibility() == 0;
    }

    public int aHW() {
        return this.elp.getId();
    }

    public String aHX() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String aHY() {
        return this.eln.aHN();
    }

    public void k(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.ell == null) {
            this.ell = new c(this.elk, this.elr);
            this.ell.a(this);
            this.ell.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aId();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aIe() <= d.this.eln.getItemLength()) {
                                d.this.elk.showToast(String.format(d.this.elk.getPageContext().getString(d.k.invite_friend_exceed_max_count), Integer.valueOf(d.this.elq)));
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
            this.FL.setAdapter((ListAdapter) this.ell);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.FL.setVisibility(8);
            if (!this.elr) {
                this.elo.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.FL.setVisibility(0);
        this.ell.setData(list);
        this.ell.notifyDataSetChanged();
        if (!this.elr) {
            this.elo.setVisibility(0);
        }
    }

    public void aHZ() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.elk.getPageContext());
        }
    }

    public void aIa() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aIb() {
        int dimensionPixelSize = this.elk.getResources().getDimensionPixelSize(d.e.ds80) + this.elk.getResources().getDimensionPixelSize(d.e.ds16) + this.elk.getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(this.elk.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.FL.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eln.d(aVar);
            oc(this.eln.getItemLength());
            aIc();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eln.f(aVar);
            oc(this.eln.getItemLength());
            aIc();
        }
    }

    private void aIc() {
        if (this.eln.getItemLength() > 0) {
            this.elp.setEnabled(true);
        } else {
            this.elp.setEnabled(false);
        }
    }

    public void aId() {
        l.b(this.elk.getPageContext().getPageActivity(), this.mEditText);
    }

    private void oc(int i) {
        this.elp.setText(String.format(this.elk.getPageContext().getString(d.k.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aIe() {
        return this.elq;
    }

    public void od(int i) {
        this.elq = i;
        this.eln.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view2, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eln.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
