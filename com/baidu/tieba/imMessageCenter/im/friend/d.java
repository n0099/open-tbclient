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
    private final InviteFriendListActivity eln;
    private c elo;
    private View elp;
    private InviteFriendCandidateList elq;
    private LinearLayout elr;
    private Button els;
    private int elt;
    private boolean elu;
    private TextView elv;
    private View elw;
    private View elx;
    private TextView ely;
    private ImageView elz;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.elt = 0;
        this.eln = inviteFriendListActivity;
        this.elu = z;
        initialize();
    }

    public View getRootView() {
        return this.Tl;
    }

    private void initialize() {
        this.eln.setContentView(d.i.invite_friend_list);
        this.Tl = this.eln.findViewById(d.g.root_view);
        are();
        this.FL = (BdListView) this.Tl.findViewById(d.g.friend_list);
        this.FL.setOnItemClickListener(this.eln);
        if (this.elu) {
            this.mNoDataView = NoDataViewFactory.a(this.eln.getPageContext().getPageActivity(), this.Tl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aNm), NoDataViewFactory.d.C(d.k.no_friends, d.k.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.eln.getPageContext().getPageActivity(), this.Tl, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aNm), NoDataViewFactory.d.C(d.k.no_chat_friends, d.k.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.k.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.eln.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.Tl.findViewById(d.g.progress);
        this.elq = (InviteFriendCandidateList) this.Tl.findViewById(d.g.candidate_list);
        this.elq.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
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
        this.elr = (LinearLayout) this.Tl.findViewById(d.g.invite_candidate);
        this.elp = this.Tl.findViewById(d.g.invite_candidate_border);
        if (this.elu) {
            this.elr.setVisibility(8);
            this.elp.setVisibility(8);
        }
        aIb();
        this.els = (Button) this.Tl.findViewById(d.g.button_send);
        this.els.setOnClickListener(this.eln);
        wY();
        aHT();
        od(0);
    }

    private void are() {
        this.mNavigationBar = (NavigationBar) this.Tl.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (d.this.elw != null && d.this.elw.getVisibility() == 0) {
                    d.this.aHU();
                    return;
                }
                l.b(d.this.eln.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.eln.finish();
            }
        });
        if (this.elu) {
            this.elv = this.mNavigationBar.setTitleText(d.k.invite_contact_title);
        } else {
            this.elv = this.mNavigationBar.setTitleText(d.k.invite_friend);
        }
        this.elx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.elv.setVisibility(8);
                d.this.elx.setVisibility(8);
                d.this.elw.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.c(d.this.eln.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.elz = (ImageView) this.elx.findViewById(d.g.new_friend_search);
        this.elw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.navigationbar_search_edit, (View.OnClickListener) null);
        this.elw.setVisibility(8);
        this.mEditText = (EditText) this.elw.findViewById(d.g.search_bar_edit);
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
                        d.this.ely.setVisibility(0);
                    } else {
                        d.this.ely.setVisibility(8);
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
        this.ely = (TextView) this.elw.findViewById(d.g.search_bar_delete_button);
        this.ely.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHS() {
        if (this.eln != null) {
            this.eln.aHQ();
        }
    }

    public void wY() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eln.getLayoutMode().setNightMode(skinType == 1);
        this.eln.getLayoutMode().u(this.Tl);
        ak.a(this.elz, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.eln.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eln.getPageContext(), skinType);
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
        l.b(this.eln.getPageContext().getPageActivity(), this.mEditText);
        this.elw.setVisibility(8);
        this.elv.setVisibility(0);
        this.elx.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean aHV() {
        return this.elw != null && this.elw.getVisibility() == 0;
    }

    public int aHW() {
        return this.els.getId();
    }

    public String aHX() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String aHY() {
        return this.elq.aHN();
    }

    public void k(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.elo == null) {
            this.elo = new c(this.eln, this.elu);
            this.elo.a(this);
            this.elo.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aId();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aIe() <= d.this.elq.getItemLength()) {
                                d.this.eln.showToast(String.format(d.this.eln.getPageContext().getString(d.k.invite_friend_exceed_max_count), Integer.valueOf(d.this.elt)));
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
            this.FL.setAdapter((ListAdapter) this.elo);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.FL.setVisibility(8);
            if (!this.elu) {
                this.elr.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.FL.setVisibility(0);
        this.elo.setData(list);
        this.elo.notifyDataSetChanged();
        if (!this.elu) {
            this.elr.setVisibility(0);
        }
    }

    public void aHZ() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eln.getPageContext());
        }
    }

    public void aIa() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aIb() {
        int dimensionPixelSize = this.eln.getResources().getDimensionPixelSize(d.e.ds80) + this.eln.getResources().getDimensionPixelSize(d.e.ds16) + this.eln.getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(this.eln.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.FL.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.elq.d(aVar);
            od(this.elq.getItemLength());
            aIc();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.elq.f(aVar);
            od(this.elq.getItemLength());
            aIc();
        }
    }

    private void aIc() {
        if (this.elq.getItemLength() > 0) {
            this.els.setEnabled(true);
        } else {
            this.els.setEnabled(false);
        }
    }

    public void aId() {
        l.b(this.eln.getPageContext().getPageActivity(), this.mEditText);
    }

    private void od(int i) {
        this.els.setText(String.format(this.eln.getPageContext().getString(d.k.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aIe() {
        return this.elt;
    }

    public void oe(int i) {
        this.elt = i;
        this.elq.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view2, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.elq.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
