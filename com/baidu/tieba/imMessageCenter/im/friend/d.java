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
import com.baidu.tieba.e;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView OF;
    private View ajk;
    private final InviteFriendListActivity eVG;
    private c eVH;
    private View eVI;
    private InviteFriendCandidateList eVJ;
    private LinearLayout eVK;
    private Button eVL;
    private int eVM;
    private boolean eVN;
    private TextView eVO;
    private View eVP;
    private View eVQ;
    private TextView eVR;
    private ImageView eVS;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.eVM = 0;
        this.eVG = inviteFriendListActivity;
        this.eVN = z;
        initialize();
    }

    public View getRootView() {
        return this.ajk;
    }

    private void initialize() {
        this.eVG.setContentView(e.h.invite_friend_list);
        this.ajk = this.eVG.findViewById(e.g.root_view);
        awU();
        this.OF = (BdListView) this.ajk.findViewById(e.g.friend_list);
        this.OF.setOnItemClickListener(this.eVG);
        if (this.eVN) {
            this.mNoDataView = NoDataViewFactory.a(this.eVG.getPageContext().getPageActivity(), this.ajk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.beN), NoDataViewFactory.d.G(e.j.no_friends, e.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.eVG.getPageContext().getPageActivity(), this.ajk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.beN), NoDataViewFactory.d.G(e.j.no_chat_friends, e.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(e.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.eVG.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.ajk.findViewById(e.g.progress);
        this.eVJ = (InviteFriendCandidateList) this.ajk.findViewById(e.g.candidate_list);
        this.eVJ.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.OF.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.eVK = (LinearLayout) this.ajk.findViewById(e.g.invite_candidate);
        this.eVI = this.ajk.findViewById(e.g.invite_candidate_border);
        if (this.eVN) {
            this.eVK.setVisibility(8);
            this.eVI.setVisibility(8);
        }
        aTx();
        this.eVL = (Button) this.ajk.findViewById(e.g.button_send);
        this.eVL.setOnClickListener(this.eVG);
        Ef();
        aTp();
        qd(0);
    }

    private void awU() {
        this.mNavigationBar = (NavigationBar) this.ajk.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eVP != null && d.this.eVP.getVisibility() == 0) {
                    d.this.aTq();
                    return;
                }
                l.b(d.this.eVG.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.eVG.finish();
            }
        });
        if (this.eVN) {
            this.eVO = this.mNavigationBar.setTitleText(e.j.invite_contact_title);
        } else {
            this.eVO = this.mNavigationBar.setTitleText(e.j.invite_friend);
        }
        this.eVQ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eVO.setVisibility(8);
                d.this.eVQ.setVisibility(8);
                d.this.eVP.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.c(d.this.eVG.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.eVS = (ImageView) this.eVQ.findViewById(e.g.new_friend_search);
        this.eVP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.eVP.setVisibility(8);
        this.mEditText = (EditText) this.eVP.findViewById(e.g.search_bar_edit);
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
                        d.this.eVR.setVisibility(0);
                    } else {
                        d.this.eVR.setVisibility(8);
                    }
                    d.this.aTo();
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
        this.eVR = (TextView) this.eVP.findViewById(e.g.search_bar_delete_button);
        this.eVR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTo() {
        if (this.eVG != null) {
            this.eVG.aTm();
        }
    }

    public void Ef() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eVG.getLayoutMode().setNightMode(skinType == 1);
        this.eVG.getLayoutMode().onModeChanged(this.ajk);
        al.a(this.eVS, e.f.icon_search_bg_s, e.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.eVG.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eVG.getPageContext(), skinType);
        al.i(this.mListFooter, e.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aTp() {
        this.OF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aTz();
                return false;
            }
        });
    }

    public void aTq() {
        l.b(this.eVG.getPageContext().getPageActivity(), this.mEditText);
        this.eVP.setVisibility(8);
        this.eVO.setVisibility(0);
        this.eVQ.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean aTr() {
        return this.eVP != null && this.eVP.getVisibility() == 0;
    }

    public int aTs() {
        return this.eVL.getId();
    }

    public String aTt() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String aTu() {
        return this.eVJ.aTj();
    }

    public void m(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.eVH == null) {
            this.eVH = new c(this.eVG, this.eVN);
            this.eVH.a(this);
            this.eVH.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aTz();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aTA() <= d.this.eVJ.getItemLength()) {
                                d.this.eVG.showToast(String.format(d.this.eVG.getPageContext().getString(e.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.eVM)));
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
            this.OF.setAdapter((ListAdapter) this.eVH);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.OF.setVisibility(8);
            if (!this.eVN) {
                this.eVK.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.OF.setVisibility(0);
        this.eVH.setData(list);
        this.eVH.notifyDataSetChanged();
        if (!this.eVN) {
            this.eVK.setVisibility(0);
        }
    }

    public void aTv() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eVG.getPageContext());
        }
    }

    public void aTw() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aTx() {
        int dimensionPixelSize = this.eVG.getResources().getDimensionPixelSize(e.C0200e.ds80) + this.eVG.getResources().getDimensionPixelSize(e.C0200e.ds16) + this.eVG.getResources().getDimensionPixelSize(e.C0200e.ds16);
        this.mListFooter = new View(this.eVG.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.OF.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eVJ.d(aVar);
            qd(this.eVJ.getItemLength());
            aTy();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eVJ.f(aVar);
            qd(this.eVJ.getItemLength());
            aTy();
        }
    }

    private void aTy() {
        if (this.eVJ.getItemLength() > 0) {
            this.eVL.setEnabled(true);
        } else {
            this.eVL.setEnabled(false);
        }
    }

    public void aTz() {
        l.b(this.eVG.getPageContext().getPageActivity(), this.mEditText);
    }

    private void qd(int i) {
        this.eVL.setText(String.format(this.eVG.getPageContext().getString(e.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aTA() {
        return this.eVM;
    }

    public void qe(int i) {
        this.eVM = i;
        this.eVJ.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eVJ.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
