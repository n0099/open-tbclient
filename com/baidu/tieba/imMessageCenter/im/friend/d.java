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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView Ib;
    private View QE;
    private final InviteFriendListActivity dBj;
    private c dBk;
    private View dBl;
    private InviteFriendCandidateList dBm;
    private LinearLayout dBn;
    private Button dBo;
    private int dBp;
    private boolean dBq;
    private TextView dBr;
    private View dBs;
    private View dBt;
    private TextView dBu;
    private ImageView dBv;
    private EditText dxI;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dBp = 0;
        this.dBj = inviteFriendListActivity;
        this.dBq = z;
        wU();
    }

    public View getRootView() {
        return this.QE;
    }

    private void wU() {
        this.dBj.setContentView(d.j.invite_friend_list);
        this.QE = this.dBj.findViewById(d.h.root_view);
        VR();
        this.Ib = (BdListView) this.QE.findViewById(d.h.friend_list);
        this.Ib.setOnItemClickListener(this.dBj);
        if (this.dBq) {
            this.mNoDataView = NoDataViewFactory.a(this.dBj.getPageContext().getPageActivity(), this.QE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aLh), NoDataViewFactory.d.B(d.l.no_friends, d.l.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dBj.getPageContext().getPageActivity(), this.QE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aLh), NoDataViewFactory.d.B(d.l.no_chat_friends, d.l.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.l.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.dBj.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.QE.findViewById(d.h.progress);
        this.dBm = (InviteFriendCandidateList) this.QE.findViewById(d.h.candidate_list);
        this.dBm.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.Ib.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.dBn = (LinearLayout) this.QE.findViewById(d.h.invite_candidate);
        this.dBl = this.QE.findViewById(d.h.invite_candidate_border);
        if (this.dBq) {
            this.dBn.setVisibility(8);
            this.dBl.setVisibility(8);
        }
        ayS();
        this.dBo = (Button) this.QE.findViewById(d.h.button_send);
        this.dBo.setOnClickListener(this.dBj);
        wV();
        ayK();
        mL(0);
    }

    private void VR() {
        this.mNavigationBar = (NavigationBar) this.QE.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dBs != null && d.this.dBs.getVisibility() == 0) {
                    d.this.ayL();
                    return;
                }
                k.b(d.this.dBj.getPageContext().getPageActivity(), d.this.dxI);
                d.this.dBj.finish();
            }
        });
        if (this.dBq) {
            this.dBr = this.mNavigationBar.setTitleText(d.l.invite_contact_title);
        } else {
            this.dBr = this.mNavigationBar.setTitleText(d.l.invite_friend);
        }
        this.dBt = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dBr.setVisibility(8);
                d.this.dBt.setVisibility(8);
                d.this.dBs.setVisibility(0);
                d.this.dxI.requestFocus();
                k.c(d.this.dBj.getPageContext().getPageActivity(), d.this.dxI);
            }
        });
        this.dBv = (ImageView) this.dBt.findViewById(d.h.new_friend_search);
        this.dBs = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dBs.setVisibility(8);
        this.dxI = (EditText) this.dBs.findViewById(d.h.search_bar_edit);
        if (this.dxI.getParent() != null) {
            ((View) this.dxI.getParent()).setFocusable(true);
            ((View) this.dxI.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a = com.baidu.adp.lib.util.j.a(editable, null);
                if (a != null) {
                    if (a.length() > 0) {
                        d.this.dBu.setVisibility(0);
                    } else {
                        d.this.dBu.setVisibility(8);
                    }
                    d.this.ayJ();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.dxI.addTextChangedListener(this.mTextWatcher);
        this.dBu = (TextView) this.dBs.findViewById(d.h.search_bar_delete_button);
        this.dBu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dxI.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayJ() {
        if (this.dBj != null) {
            this.dBj.ayH();
        }
    }

    public void wV() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dBj.getLayoutMode().ah(skinType == 1);
        this.dBj.getLayoutMode().t(this.QE);
        ai.b(this.dBv, d.g.icon_search_bg_s, d.g.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dBj.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dBj.getPageContext(), skinType);
        ai.j(this.mListFooter, d.g.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void ayK() {
        this.Ib.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.ayU();
                return false;
            }
        });
    }

    public void ayL() {
        k.b(this.dBj.getPageContext().getPageActivity(), this.dxI);
        this.dBs.setVisibility(8);
        this.dBr.setVisibility(0);
        this.dBt.setVisibility(0);
        this.dxI.getText().clear();
    }

    public boolean ayM() {
        return this.dBs != null && this.dBs.getVisibility() == 0;
    }

    public int ayN() {
        return this.dBo.getId();
    }

    public String ayO() {
        Editable text = this.dxI.getText();
        return text != null ? text.toString() : "";
    }

    public String ayP() {
        return this.dBm.ayE();
    }

    public void l(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dBk == null) {
            this.dBk = new c(this.dBj, this.dBq);
            this.dBk.a(this);
            this.dBk.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.ayU();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.ayV() <= d.this.dBm.getItemLength()) {
                                d.this.dBj.showToast(String.format(d.this.dBj.getPageContext().getString(d.l.invite_friend_exceed_max_count), Integer.valueOf(d.this.dBp)));
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
            this.Ib.setAdapter((ListAdapter) this.dBk);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Ib.setVisibility(8);
            if (!this.dBq) {
                this.dBn.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Ib.setVisibility(0);
        this.dBk.setData(list);
        this.dBk.notifyDataSetChanged();
        if (!this.dBq) {
            this.dBn.setVisibility(0);
        }
    }

    public void ayQ() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dBj.getPageContext());
        }
    }

    public void ayR() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void ayS() {
        int dimensionPixelSize = this.dBj.getResources().getDimensionPixelSize(d.f.ds80) + this.dBj.getResources().getDimensionPixelSize(d.f.ds16) + this.dBj.getResources().getDimensionPixelSize(d.f.ds16);
        this.mListFooter = new View(this.dBj.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Ib.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dBm.d(aVar);
            mL(this.dBm.getItemLength());
            ayT();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dBm.f(aVar);
            mL(this.dBm.getItemLength());
            ayT();
        }
    }

    private void ayT() {
        if (this.dBm.getItemLength() > 0) {
            this.dBo.setEnabled(true);
        } else {
            this.dBo.setEnabled(false);
        }
    }

    public void ayU() {
        k.b(this.dBj.getPageContext().getPageActivity(), this.dxI);
    }

    private void mL(int i) {
        this.dBo.setText(String.format(this.dBj.getPageContext().getString(d.l.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int ayV() {
        return this.dBp;
    }

    public void mM(int i) {
        this.dBp = i;
        this.dBm.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dBm.e(aVar);
        }
    }

    public void onDestroy() {
        this.dxI.removeTextChangedListener(this.mTextWatcher);
    }
}
