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
    private BdListView Pi;
    private View btW;
    private final InviteFriendListActivity gwh;
    private c gwi;
    private View gwj;
    private InviteFriendCandidateList gwk;
    private LinearLayout gwl;
    private Button gwm;
    private int gwn;
    private boolean gwo;
    private TextView gwp;
    private View gwq;
    private View gwr;
    private TextView gws;
    private ImageView gwt;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.gwn = 0;
        this.gwh = inviteFriendListActivity;
        this.gwo = z;
        initialize();
    }

    public View getRootView() {
        return this.btW;
    }

    private void initialize() {
        this.gwh.setContentView(d.h.invite_friend_list);
        this.btW = this.gwh.findViewById(d.g.root_view);
        aBC();
        this.Pi = (BdListView) this.btW.findViewById(d.g.friend_list);
        this.Pi.setOnItemClickListener(this.gwh);
        if (this.gwo) {
            this.mNoDataView = NoDataViewFactory.a(this.gwh.getPageContext().getPageActivity(), this.btW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.csY), NoDataViewFactory.d.ad(d.j.no_friends, d.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.gwh.getPageContext().getPageActivity(), this.btW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.csY), NoDataViewFactory.d.ad(d.j.no_chat_friends, d.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.gwh.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.btW.findViewById(d.g.progress);
        this.gwk = (InviteFriendCandidateList) this.btW.findViewById(d.g.candidate_list);
        this.gwk.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.Pi.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.gwl = (LinearLayout) this.btW.findViewById(d.g.invite_candidate);
        this.gwj = this.btW.findViewById(d.g.invite_candidate_border);
        if (this.gwo) {
            this.gwl.setVisibility(8);
            this.gwj.setVisibility(8);
        }
        bxi();
        this.gwm = (Button) this.btW.findViewById(d.g.button_send);
        this.gwm.setOnClickListener(this.gwh);
        aeK();
        bxa();
        uv(0);
    }

    private void aBC() {
        this.mNavigationBar = (NavigationBar) this.btW.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.gwq != null && d.this.gwq.getVisibility() == 0) {
                    d.this.bxb();
                    return;
                }
                l.b(d.this.gwh.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.gwh.finish();
            }
        });
        if (this.gwo) {
            this.gwp = this.mNavigationBar.setTitleText(d.j.invite_contact_title);
        } else {
            this.gwp = this.mNavigationBar.setTitleText(d.j.invite_friend);
        }
        this.gwr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.gwp.setVisibility(8);
                d.this.gwr.setVisibility(8);
                d.this.gwq.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.c(d.this.gwh.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.gwt = (ImageView) this.gwr.findViewById(d.g.new_friend_search);
        this.gwq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.gwq.setVisibility(8);
        this.mEditText = (EditText) this.gwq.findViewById(d.g.search_bar_edit);
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
                        d.this.gws.setVisibility(0);
                    } else {
                        d.this.gws.setVisibility(8);
                    }
                    d.this.bwZ();
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
        this.gws = (TextView) this.gwq.findViewById(d.g.search_bar_delete_button);
        this.gws.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwZ() {
        if (this.gwh != null) {
            this.gwh.bwX();
        }
    }

    public void aeK() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gwh.getLayoutMode().setNightMode(skinType == 1);
        this.gwh.getLayoutMode().onModeChanged(this.btW);
        al.a(this.gwt, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.gwh.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.gwh.getPageContext(), skinType);
        al.k(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void bxa() {
        this.Pi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void bxb() {
        l.b(this.gwh.getPageContext().getPageActivity(), this.mEditText);
        this.gwq.setVisibility(8);
        this.gwp.setVisibility(0);
        this.gwr.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean bxc() {
        return this.gwq != null && this.gwq.getVisibility() == 0;
    }

    public int bxd() {
        return this.gwm.getId();
    }

    public String bxe() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String bxf() {
        return this.gwk.bwU();
    }

    public void o(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.gwi == null) {
            this.gwi = new c(this.gwh, this.gwo);
            this.gwi.a(this);
            this.gwi.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.bxk() <= d.this.gwk.getItemLength()) {
                                d.this.gwh.showToast(String.format(d.this.gwh.getPageContext().getString(d.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.gwn)));
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
            this.Pi.setAdapter((ListAdapter) this.gwi);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Pi.setVisibility(8);
            if (!this.gwo) {
                this.gwl.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Pi.setVisibility(0);
        this.gwi.setData(list);
        this.gwi.notifyDataSetChanged();
        if (!this.gwo) {
            this.gwl.setVisibility(0);
        }
    }

    public void bxg() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.gwh.getPageContext());
        }
    }

    public void bxh() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void bxi() {
        int dimensionPixelSize = this.gwh.getResources().getDimensionPixelSize(d.e.ds80) + this.gwh.getResources().getDimensionPixelSize(d.e.ds16) + this.gwh.getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(this.gwh.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Pi.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gwk.d(aVar);
            uv(this.gwk.getItemLength());
            bxj();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gwk.f(aVar);
            uv(this.gwk.getItemLength());
            bxj();
        }
    }

    private void bxj() {
        if (this.gwk.getItemLength() > 0) {
            this.gwm.setEnabled(true);
        } else {
            this.gwm.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.b(this.gwh.getPageContext().getPageActivity(), this.mEditText);
    }

    private void uv(int i) {
        this.gwm.setText(String.format(this.gwh.getPageContext().getString(d.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int bxk() {
        return this.gwn;
    }

    public void uw(int i) {
        this.gwn = i;
        this.gwk.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gwk.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
