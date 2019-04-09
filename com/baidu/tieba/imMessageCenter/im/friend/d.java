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
    private View buc;
    private final InviteFriendListActivity gvU;
    private c gvV;
    private View gvW;
    private InviteFriendCandidateList gvX;
    private LinearLayout gvY;
    private Button gvZ;
    private int gwa;
    private boolean gwb;
    private TextView gwc;
    private View gwd;
    private View gwe;
    private TextView gwf;
    private ImageView gwg;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.gwa = 0;
        this.gvU = inviteFriendListActivity;
        this.gwb = z;
        initialize();
    }

    public View getRootView() {
        return this.buc;
    }

    private void initialize() {
        this.gvU.setContentView(d.h.invite_friend_list);
        this.buc = this.gvU.findViewById(d.g.root_view);
        aBy();
        this.Pj = (BdListView) this.buc.findViewById(d.g.friend_list);
        this.Pj.setOnItemClickListener(this.gvU);
        if (this.gwb) {
            this.mNoDataView = NoDataViewFactory.a(this.gvU.getPageContext().getPageActivity(), this.buc, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.csY), NoDataViewFactory.d.ad(d.j.no_friends, d.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.gvU.getPageContext().getPageActivity(), this.buc, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.csY), NoDataViewFactory.d.ad(d.j.no_chat_friends, d.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.gvU.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.buc.findViewById(d.g.progress);
        this.gvX = (InviteFriendCandidateList) this.buc.findViewById(d.g.candidate_list);
        this.gvX.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
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
        this.gvY = (LinearLayout) this.buc.findViewById(d.g.invite_candidate);
        this.gvW = this.buc.findViewById(d.g.invite_candidate_border);
        if (this.gwb) {
            this.gvY.setVisibility(8);
            this.gvW.setVisibility(8);
        }
        bxe();
        this.gvZ = (Button) this.buc.findViewById(d.g.button_send);
        this.gvZ.setOnClickListener(this.gvU);
        aeH();
        bwW();
        ur(0);
    }

    private void aBy() {
        this.mNavigationBar = (NavigationBar) this.buc.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.gwd != null && d.this.gwd.getVisibility() == 0) {
                    d.this.bwX();
                    return;
                }
                l.b(d.this.gvU.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.gvU.finish();
            }
        });
        if (this.gwb) {
            this.gwc = this.mNavigationBar.setTitleText(d.j.invite_contact_title);
        } else {
            this.gwc = this.mNavigationBar.setTitleText(d.j.invite_friend);
        }
        this.gwe = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.gwc.setVisibility(8);
                d.this.gwe.setVisibility(8);
                d.this.gwd.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.c(d.this.gvU.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.gwg = (ImageView) this.gwe.findViewById(d.g.new_friend_search);
        this.gwd = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.gwd.setVisibility(8);
        this.mEditText = (EditText) this.gwd.findViewById(d.g.search_bar_edit);
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
                        d.this.gwf.setVisibility(0);
                    } else {
                        d.this.gwf.setVisibility(8);
                    }
                    d.this.bwV();
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
        this.gwf = (TextView) this.gwd.findViewById(d.g.search_bar_delete_button);
        this.gwf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwV() {
        if (this.gvU != null) {
            this.gvU.bwT();
        }
    }

    public void aeH() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gvU.getLayoutMode().setNightMode(skinType == 1);
        this.gvU.getLayoutMode().onModeChanged(this.buc);
        al.a(this.gwg, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.gvU.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.gvU.getPageContext(), skinType);
        al.k(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void bwW() {
        this.Pj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void bwX() {
        l.b(this.gvU.getPageContext().getPageActivity(), this.mEditText);
        this.gwd.setVisibility(8);
        this.gwc.setVisibility(0);
        this.gwe.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean bwY() {
        return this.gwd != null && this.gwd.getVisibility() == 0;
    }

    public int bwZ() {
        return this.gvZ.getId();
    }

    public String bxa() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String bxb() {
        return this.gvX.bwQ();
    }

    public void o(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.gvV == null) {
            this.gvV = new c(this.gvU, this.gwb);
            this.gvV.a(this);
            this.gvV.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.bxg() <= d.this.gvX.getItemLength()) {
                                d.this.gvU.showToast(String.format(d.this.gvU.getPageContext().getString(d.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.gwa)));
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
            this.Pj.setAdapter((ListAdapter) this.gvV);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Pj.setVisibility(8);
            if (!this.gwb) {
                this.gvY.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Pj.setVisibility(0);
        this.gvV.setData(list);
        this.gvV.notifyDataSetChanged();
        if (!this.gwb) {
            this.gvY.setVisibility(0);
        }
    }

    public void bxc() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.gvU.getPageContext());
        }
    }

    public void bxd() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void bxe() {
        int dimensionPixelSize = this.gvU.getResources().getDimensionPixelSize(d.e.ds80) + this.gvU.getResources().getDimensionPixelSize(d.e.ds16) + this.gvU.getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(this.gvU.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Pj.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gvX.d(aVar);
            ur(this.gvX.getItemLength());
            bxf();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gvX.f(aVar);
            ur(this.gvX.getItemLength());
            bxf();
        }
    }

    private void bxf() {
        if (this.gvX.getItemLength() > 0) {
            this.gvZ.setEnabled(true);
        } else {
            this.gvZ.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.b(this.gvU.getPageContext().getPageActivity(), this.mEditText);
    }

    private void ur(int i) {
        this.gvZ.setText(String.format(this.gvU.getPageContext().getString(d.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int bxg() {
        return this.gwa;
    }

    public void us(int i) {
        this.gwa = i;
        this.gvX.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gvX.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
