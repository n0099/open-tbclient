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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private View aId;
    private BdListView avh;
    private final InviteFriendListActivity eQV;
    private c eQW;
    private View eQX;
    private InviteFriendCandidateList eQY;
    private LinearLayout eQZ;
    private Button eRa;
    private int eRb;
    private boolean eRc;
    private TextView eRd;
    private View eRe;
    private View eRf;
    private TextView eRg;
    private ImageView eRh;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;
    private EditText rE;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.eRb = 0;
        this.eQV = inviteFriendListActivity;
        this.eRc = z;
        Em();
    }

    public View getRootView() {
        return this.aId;
    }

    private void Em() {
        this.eQV.setContentView(d.h.invite_friend_list);
        this.aId = this.eQV.findViewById(d.g.root_view);
        awN();
        this.avh = (BdListView) this.aId.findViewById(d.g.friend_list);
        this.avh.setOnItemClickListener(this.eQV);
        if (this.eRc) {
            this.mNoDataView = NoDataViewFactory.a(this.eQV.getPageContext().getPageActivity(), this.aId, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bCW), NoDataViewFactory.d.aC(d.j.no_friends, d.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.eQV.getPageContext().getPageActivity(), this.aId, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bCW), NoDataViewFactory.d.aC(d.j.no_chat_friends, d.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.eQV.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.aId.findViewById(d.g.progress);
        this.eQY = (InviteFriendCandidateList) this.aId.findViewById(d.g.candidate_list);
        this.eQY.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.avh.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.eQZ = (LinearLayout) this.aId.findViewById(d.g.invite_candidate);
        this.eQX = this.aId.findViewById(d.g.invite_candidate_border);
        if (this.eRc) {
            this.eQZ.setVisibility(8);
            this.eQX.setVisibility(8);
        }
        aNg();
        this.eRa = (Button) this.aId.findViewById(d.g.button_send);
        this.eRa.setOnClickListener(this.eQV);
        En();
        aMY();
        qH(0);
    }

    private void awN() {
        this.mNavigationBar = (NavigationBar) this.aId.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eRe != null && d.this.eRe.getVisibility() == 0) {
                    d.this.aMZ();
                    return;
                }
                l.a(d.this.eQV.getPageContext().getPageActivity(), d.this.rE);
                d.this.eQV.finish();
            }
        });
        if (this.eRc) {
            this.eRd = this.mNavigationBar.setTitleText(d.j.invite_contact_title);
        } else {
            this.eRd = this.mNavigationBar.setTitleText(d.j.invite_friend);
        }
        this.eRf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eRd.setVisibility(8);
                d.this.eRf.setVisibility(8);
                d.this.eRe.setVisibility(0);
                d.this.rE.requestFocus();
                l.b(d.this.eQV.getPageContext().getPageActivity(), d.this.rE);
            }
        });
        this.eRh = (ImageView) this.eRf.findViewById(d.g.new_friend_search);
        this.eRe = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.eRe.setVisibility(8);
        this.rE = (EditText) this.eRe.findViewById(d.g.search_bar_edit);
        if (this.rE.getParent() != null) {
            ((View) this.rE.getParent()).setFocusable(true);
            ((View) this.rE.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a = k.a(editable, null);
                if (a != null) {
                    if (a.length() > 0) {
                        d.this.eRg.setVisibility(0);
                    } else {
                        d.this.eRg.setVisibility(8);
                    }
                    d.this.aMX();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.rE.addTextChangedListener(this.mTextWatcher);
        this.eRg = (TextView) this.eRe.findViewById(d.g.search_bar_delete_button);
        this.eRg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.rE.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMX() {
        if (this.eQV != null) {
            this.eQV.aMV();
        }
    }

    public void En() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eQV.getLayoutMode().aQ(skinType == 1);
        this.eQV.getLayoutMode().aM(this.aId);
        aj.a(this.eRh, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.eQV.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eQV.getPageContext(), skinType);
        aj.s(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aMY() {
        this.avh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aNi();
                return false;
            }
        });
    }

    public void aMZ() {
        l.a(this.eQV.getPageContext().getPageActivity(), this.rE);
        this.eRe.setVisibility(8);
        this.eRd.setVisibility(0);
        this.eRf.setVisibility(0);
        this.rE.getText().clear();
    }

    public boolean aNa() {
        return this.eRe != null && this.eRe.getVisibility() == 0;
    }

    public int aNb() {
        return this.eRa.getId();
    }

    public String aNc() {
        Editable text = this.rE.getText();
        return text != null ? text.toString() : "";
    }

    public String aNd() {
        return this.eQY.aMS();
    }

    public void m(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.eQW == null) {
            this.eQW = new c(this.eQV, this.eRc);
            this.eQW.a(this);
            this.eQW.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aNi();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aNj() <= d.this.eQY.getItemLength()) {
                                d.this.eQV.showToast(String.format(d.this.eQV.getPageContext().getString(d.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.eRb)));
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
            this.avh.setAdapter((ListAdapter) this.eQW);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.avh.setVisibility(8);
            if (!this.eRc) {
                this.eQZ.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.avh.setVisibility(0);
        this.eQW.setData(list);
        this.eQW.notifyDataSetChanged();
        if (!this.eRc) {
            this.eQZ.setVisibility(0);
        }
    }

    public void aNe() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eQV.getPageContext());
        }
    }

    public void aNf() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aNg() {
        int dimensionPixelSize = this.eQV.getResources().getDimensionPixelSize(d.e.ds80) + this.eQV.getResources().getDimensionPixelSize(d.e.ds16) + this.eQV.getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(this.eQV.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.avh.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eQY.d(aVar);
            qH(this.eQY.getItemLength());
            aNh();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eQY.f(aVar);
            qH(this.eQY.getItemLength());
            aNh();
        }
    }

    private void aNh() {
        if (this.eQY.getItemLength() > 0) {
            this.eRa.setEnabled(true);
        } else {
            this.eRa.setEnabled(false);
        }
    }

    public void aNi() {
        l.a(this.eQV.getPageContext().getPageActivity(), this.rE);
    }

    private void qH(int i) {
        this.eRa.setText(String.format(this.eQV.getPageContext().getString(d.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aNj() {
        return this.eRb;
    }

    public void qI(int i) {
        this.eRb = i;
        this.eQY.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eQY.e(aVar);
        }
    }

    public void onDestroy() {
        this.rE.removeTextChangedListener(this.mTextWatcher);
    }
}
