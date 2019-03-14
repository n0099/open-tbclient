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
import com.baidu.tbadk.core.util.al;
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
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView Pj;
    private View btY;
    private final InviteFriendListActivity gwg;
    private c gwh;
    private View gwi;
    private InviteFriendCandidateList gwj;
    private LinearLayout gwk;
    private Button gwl;
    private int gwm;
    private boolean gwn;
    private TextView gwo;
    private View gwp;
    private View gwq;
    private TextView gwr;
    private ImageView gws;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.gwm = 0;
        this.gwg = inviteFriendListActivity;
        this.gwn = z;
        initialize();
    }

    public View getRootView() {
        return this.btY;
    }

    private void initialize() {
        this.gwg.setContentView(d.h.invite_friend_list);
        this.btY = this.gwg.findViewById(d.g.root_view);
        aBB();
        this.Pj = (BdListView) this.btY.findViewById(d.g.friend_list);
        this.Pj.setOnItemClickListener(this.gwg);
        if (this.gwn) {
            this.mNoDataView = NoDataViewFactory.a(this.gwg.getPageContext().getPageActivity(), this.btY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.csV), NoDataViewFactory.d.ad(d.j.no_friends, d.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.gwg.getPageContext().getPageActivity(), this.btY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.csV), NoDataViewFactory.d.ad(d.j.no_chat_friends, d.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.gwg.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.btY.findViewById(d.g.progress);
        this.gwj = (InviteFriendCandidateList) this.btY.findViewById(d.g.candidate_list);
        this.gwj.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.Pj.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.gwk = (LinearLayout) this.btY.findViewById(d.g.invite_candidate);
        this.gwi = this.btY.findViewById(d.g.invite_candidate_border);
        if (this.gwn) {
            this.gwk.setVisibility(8);
            this.gwi.setVisibility(8);
        }
        bxh();
        this.gwl = (Button) this.btY.findViewById(d.g.button_send);
        this.gwl.setOnClickListener(this.gwg);
        aeK();
        bwZ();
        uv(0);
    }

    private void aBB() {
        this.mNavigationBar = (NavigationBar) this.btY.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.gwp != null && d.this.gwp.getVisibility() == 0) {
                    d.this.bxa();
                    return;
                }
                l.b(d.this.gwg.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.gwg.finish();
            }
        });
        if (this.gwn) {
            this.gwo = this.mNavigationBar.setTitleText(d.j.invite_contact_title);
        } else {
            this.gwo = this.mNavigationBar.setTitleText(d.j.invite_friend);
        }
        this.gwq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.gwo.setVisibility(8);
                d.this.gwq.setVisibility(8);
                d.this.gwp.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.c(d.this.gwg.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.gws = (ImageView) this.gwq.findViewById(d.g.new_friend_search);
        this.gwp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.gwp.setVisibility(8);
        this.mEditText = (EditText) this.gwp.findViewById(d.g.search_bar_edit);
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
                        d.this.gwr.setVisibility(0);
                    } else {
                        d.this.gwr.setVisibility(8);
                    }
                    d.this.bwY();
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
        this.gwr = (TextView) this.gwp.findViewById(d.g.search_bar_delete_button);
        this.gwr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwY() {
        if (this.gwg != null) {
            this.gwg.bwW();
        }
    }

    public void aeK() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gwg.getLayoutMode().setNightMode(skinType == 1);
        this.gwg.getLayoutMode().onModeChanged(this.btY);
        al.a(this.gws, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.gwg.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.gwg.getPageContext(), skinType);
        al.k(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void bwZ() {
        this.Pj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void bxa() {
        l.b(this.gwg.getPageContext().getPageActivity(), this.mEditText);
        this.gwp.setVisibility(8);
        this.gwo.setVisibility(0);
        this.gwq.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean bxb() {
        return this.gwp != null && this.gwp.getVisibility() == 0;
    }

    public int bxc() {
        return this.gwl.getId();
    }

    public String bxd() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String bxe() {
        return this.gwj.bwT();
    }

    public void o(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.gwh == null) {
            this.gwh = new c(this.gwg, this.gwn);
            this.gwh.a(this);
            this.gwh.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.bxj() <= d.this.gwj.getItemLength()) {
                                d.this.gwg.showToast(String.format(d.this.gwg.getPageContext().getString(d.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.gwm)));
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
            this.Pj.setAdapter((ListAdapter) this.gwh);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Pj.setVisibility(8);
            if (!this.gwn) {
                this.gwk.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Pj.setVisibility(0);
        this.gwh.setData(list);
        this.gwh.notifyDataSetChanged();
        if (!this.gwn) {
            this.gwk.setVisibility(0);
        }
    }

    public void bxf() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.gwg.getPageContext());
        }
    }

    public void bxg() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void bxh() {
        int dimensionPixelSize = this.gwg.getResources().getDimensionPixelSize(d.e.ds80) + this.gwg.getResources().getDimensionPixelSize(d.e.ds16) + this.gwg.getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(this.gwg.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Pj.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gwj.d(aVar);
            uv(this.gwj.getItemLength());
            bxi();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gwj.f(aVar);
            uv(this.gwj.getItemLength());
            bxi();
        }
    }

    private void bxi() {
        if (this.gwj.getItemLength() > 0) {
            this.gwl.setEnabled(true);
        } else {
            this.gwl.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.b(this.gwg.getPageContext().getPageActivity(), this.mEditText);
    }

    private void uv(int i) {
        this.gwl.setText(String.format(this.gwg.getPageContext().getString(d.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int bxj() {
        return this.gwm;
    }

    public void uw(int i) {
        this.gwm = i;
        this.gwj.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gwj.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
