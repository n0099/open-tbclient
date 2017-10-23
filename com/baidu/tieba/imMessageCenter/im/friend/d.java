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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView HO;
    private View Rh;
    private EditText dEw;
    private final InviteFriendListActivity dHX;
    private c dHY;
    private View dHZ;
    private InviteFriendCandidateList dIa;
    private LinearLayout dIb;
    private Button dIc;
    private int dId;
    private boolean dIe;
    private TextView dIf;
    private View dIg;
    private View dIh;
    private TextView dIi;
    private ImageView dIj;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private f mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dId = 0;
        this.dHX = inviteFriendListActivity;
        this.dIe = z;
        wt();
    }

    public View getRootView() {
        return this.Rh;
    }

    private void wt() {
        this.dHX.setContentView(d.j.invite_friend_list);
        this.Rh = this.dHX.findViewById(d.h.root_view);
        aiw();
        this.HO = (BdListView) this.Rh.findViewById(d.h.friend_list);
        this.HO.setOnItemClickListener(this.dHX);
        if (this.dIe) {
            this.mNoDataView = NoDataViewFactory.a(this.dHX.getPageContext().getPageActivity(), this.Rh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aLq), NoDataViewFactory.d.D(d.l.no_friends, d.l.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dHX.getPageContext().getPageActivity(), this.Rh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aLq), NoDataViewFactory.d.D(d.l.no_chat_friends, d.l.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.l.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.dHX.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.Rh.findViewById(d.h.progress);
        this.dIa = (InviteFriendCandidateList) this.Rh.findViewById(d.h.candidate_list);
        this.dIa.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.HO.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.dIb = (LinearLayout) this.Rh.findViewById(d.h.invite_candidate);
        this.dHZ = this.Rh.findViewById(d.h.invite_candidate_border);
        if (this.dIe) {
            this.dIb.setVisibility(8);
            this.dHZ.setVisibility(8);
        }
        aAl();
        this.dIc = (Button) this.Rh.findViewById(d.h.button_send);
        this.dIc.setOnClickListener(this.dHX);
        wu();
        aAd();
        nk(0);
    }

    private void aiw() {
        this.mNavigationBar = (NavigationBar) this.Rh.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dIg != null && d.this.dIg.getVisibility() == 0) {
                    d.this.aAe();
                    return;
                }
                l.a(d.this.dHX.getPageContext().getPageActivity(), d.this.dEw);
                d.this.dHX.finish();
            }
        });
        if (this.dIe) {
            this.dIf = this.mNavigationBar.setTitleText(d.l.invite_contact_title);
        } else {
            this.dIf = this.mNavigationBar.setTitleText(d.l.invite_friend);
        }
        this.dIh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dIf.setVisibility(8);
                d.this.dIh.setVisibility(8);
                d.this.dIg.setVisibility(0);
                d.this.dEw.requestFocus();
                l.b(d.this.dHX.getPageContext().getPageActivity(), d.this.dEw);
            }
        });
        this.dIj = (ImageView) this.dIh.findViewById(d.h.new_friend_search);
        this.dIg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dIg.setVisibility(8);
        this.dEw = (EditText) this.dIg.findViewById(d.h.search_bar_edit);
        if (this.dEw.getParent() != null) {
            ((View) this.dEw.getParent()).setFocusable(true);
            ((View) this.dEw.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a = k.a(editable, null);
                if (a != null) {
                    if (a.length() > 0) {
                        d.this.dIi.setVisibility(0);
                    } else {
                        d.this.dIi.setVisibility(8);
                    }
                    d.this.aAc();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.dEw.addTextChangedListener(this.mTextWatcher);
        this.dIi = (TextView) this.dIg.findViewById(d.h.search_bar_delete_button);
        this.dIi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dEw.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAc() {
        if (this.dHX != null) {
            this.dHX.aAa();
        }
    }

    public void wu() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dHX.getLayoutMode().ah(skinType == 1);
        this.dHX.getLayoutMode().t(this.Rh);
        aj.a(this.dIj, d.g.icon_search_bg_s, d.g.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dHX.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dHX.getPageContext(), skinType);
        aj.j(this.mListFooter, d.g.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aAd() {
        this.HO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aAn();
                return false;
            }
        });
    }

    public void aAe() {
        l.a(this.dHX.getPageContext().getPageActivity(), this.dEw);
        this.dIg.setVisibility(8);
        this.dIf.setVisibility(0);
        this.dIh.setVisibility(0);
        this.dEw.getText().clear();
    }

    public boolean aAf() {
        return this.dIg != null && this.dIg.getVisibility() == 0;
    }

    public int aAg() {
        return this.dIc.getId();
    }

    public String aAh() {
        Editable text = this.dEw.getText();
        return text != null ? text.toString() : "";
    }

    public String aAi() {
        return this.dIa.azX();
    }

    public void k(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dHY == null) {
            this.dHY = new c(this.dHX, this.dIe);
            this.dHY.a(this);
            this.dHY.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aAn();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aAo() <= d.this.dIa.getItemLength()) {
                                d.this.dHX.showToast(String.format(d.this.dHX.getPageContext().getString(d.l.invite_friend_exceed_max_count), Integer.valueOf(d.this.dId)));
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
            this.HO.setAdapter((ListAdapter) this.dHY);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.HO.setVisibility(8);
            if (!this.dIe) {
                this.dIb.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.HO.setVisibility(0);
        this.dHY.setData(list);
        this.dHY.notifyDataSetChanged();
        if (!this.dIe) {
            this.dIb.setVisibility(0);
        }
    }

    public void aAj() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dHX.getPageContext());
        }
    }

    public void aAk() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aAl() {
        int dimensionPixelSize = this.dHX.getResources().getDimensionPixelSize(d.f.ds80) + this.dHX.getResources().getDimensionPixelSize(d.f.ds16) + this.dHX.getResources().getDimensionPixelSize(d.f.ds16);
        this.mListFooter = new View(this.dHX.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.HO.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dIa.d(aVar);
            nk(this.dIa.getItemLength());
            aAm();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dIa.f(aVar);
            nk(this.dIa.getItemLength());
            aAm();
        }
    }

    private void aAm() {
        if (this.dIa.getItemLength() > 0) {
            this.dIc.setEnabled(true);
        } else {
            this.dIc.setEnabled(false);
        }
    }

    public void aAn() {
        l.a(this.dHX.getPageContext().getPageActivity(), this.dEw);
    }

    private void nk(int i) {
        this.dIc.setText(String.format(this.dHX.getPageContext().getString(d.l.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aAo() {
        return this.dId;
    }

    public void nl(int i) {
        this.dId = i;
        this.dIa.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dIa.e(aVar);
        }
    }

    public void onDestroy() {
        this.dEw.removeTextChangedListener(this.mTextWatcher);
    }
}
