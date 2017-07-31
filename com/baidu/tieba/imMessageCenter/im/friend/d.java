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
    private BdListView JC;
    private View Sd;
    private final InviteFriendListActivity dCA;
    private c dCB;
    private View dCC;
    private InviteFriendCandidateList dCD;
    private LinearLayout dCE;
    private Button dCF;
    private int dCG;
    private boolean dCH;
    private TextView dCI;
    private View dCJ;
    private View dCK;
    private TextView dCL;
    private ImageView dCM;
    private EditText dza;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dCG = 0;
        this.dCA = inviteFriendListActivity;
        this.dCH = z;
        bg();
    }

    public View getRootView() {
        return this.Sd;
    }

    private void bg() {
        this.dCA.setContentView(d.j.invite_friend_list);
        this.Sd = this.dCA.findViewById(d.h.root_view);
        VW();
        this.JC = (BdListView) this.Sd.findViewById(d.h.friend_list);
        this.JC.setOnItemClickListener(this.dCA);
        if (this.dCH) {
            this.mNoDataView = NoDataViewFactory.a(this.dCA.getPageContext().getPageActivity(), this.Sd, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aMw), NoDataViewFactory.d.C(d.l.no_friends, d.l.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dCA.getPageContext().getPageActivity(), this.Sd, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aMw), NoDataViewFactory.d.C(d.l.no_chat_friends, d.l.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.l.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.dCA.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.Sd.findViewById(d.h.progress);
        this.dCD = (InviteFriendCandidateList) this.Sd.findViewById(d.h.candidate_list);
        this.dCD.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.JC.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.dCE = (LinearLayout) this.Sd.findViewById(d.h.invite_candidate);
        this.dCC = this.Sd.findViewById(d.h.invite_candidate_border);
        if (this.dCH) {
            this.dCE.setVisibility(8);
            this.dCC.setVisibility(8);
        }
        azd();
        this.dCF = (Button) this.Sd.findViewById(d.h.button_send);
        this.dCF.setOnClickListener(this.dCA);
        xd();
        ayV();
        mK(0);
    }

    private void VW() {
        this.mNavigationBar = (NavigationBar) this.Sd.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dCJ != null && d.this.dCJ.getVisibility() == 0) {
                    d.this.ayW();
                    return;
                }
                k.b(d.this.dCA.getPageContext().getPageActivity(), d.this.dza);
                d.this.dCA.finish();
            }
        });
        if (this.dCH) {
            this.dCI = this.mNavigationBar.setTitleText(d.l.invite_contact_title);
        } else {
            this.dCI = this.mNavigationBar.setTitleText(d.l.invite_friend);
        }
        this.dCK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dCI.setVisibility(8);
                d.this.dCK.setVisibility(8);
                d.this.dCJ.setVisibility(0);
                d.this.dza.requestFocus();
                k.c(d.this.dCA.getPageContext().getPageActivity(), d.this.dza);
            }
        });
        this.dCM = (ImageView) this.dCK.findViewById(d.h.new_friend_search);
        this.dCJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dCJ.setVisibility(8);
        this.dza = (EditText) this.dCJ.findViewById(d.h.search_bar_edit);
        if (this.dza.getParent() != null) {
            ((View) this.dza.getParent()).setFocusable(true);
            ((View) this.dza.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a = com.baidu.adp.lib.util.j.a(editable, null);
                if (a != null) {
                    if (a.length() > 0) {
                        d.this.dCL.setVisibility(0);
                    } else {
                        d.this.dCL.setVisibility(8);
                    }
                    d.this.ayU();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.dza.addTextChangedListener(this.mTextWatcher);
        this.dCL = (TextView) this.dCJ.findViewById(d.h.search_bar_delete_button);
        this.dCL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dza.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayU() {
        if (this.dCA != null) {
            this.dCA.ayS();
        }
    }

    public void xd() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dCA.getLayoutMode().ah(skinType == 1);
        this.dCA.getLayoutMode().t(this.Sd);
        ai.b(this.dCM, d.g.icon_search_bg_s, d.g.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dCA.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dCA.getPageContext(), skinType);
        ai.j(this.mListFooter, d.g.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void ayV() {
        this.JC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.azf();
                return false;
            }
        });
    }

    public void ayW() {
        k.b(this.dCA.getPageContext().getPageActivity(), this.dza);
        this.dCJ.setVisibility(8);
        this.dCI.setVisibility(0);
        this.dCK.setVisibility(0);
        this.dza.getText().clear();
    }

    public boolean ayX() {
        return this.dCJ != null && this.dCJ.getVisibility() == 0;
    }

    public int ayY() {
        return this.dCF.getId();
    }

    public String ayZ() {
        Editable text = this.dza.getText();
        return text != null ? text.toString() : "";
    }

    public String aza() {
        return this.dCD.ayP();
    }

    public void l(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dCB == null) {
            this.dCB = new c(this.dCA, this.dCH);
            this.dCB.a(this);
            this.dCB.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.azf();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.azg() <= d.this.dCD.getItemLength()) {
                                d.this.dCA.showToast(String.format(d.this.dCA.getPageContext().getString(d.l.invite_friend_exceed_max_count), Integer.valueOf(d.this.dCG)));
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
            this.JC.setAdapter((ListAdapter) this.dCB);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.JC.setVisibility(8);
            if (!this.dCH) {
                this.dCE.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.JC.setVisibility(0);
        this.dCB.setData(list);
        this.dCB.notifyDataSetChanged();
        if (!this.dCH) {
            this.dCE.setVisibility(0);
        }
    }

    public void azb() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dCA.getPageContext());
        }
    }

    public void azc() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void azd() {
        int dimensionPixelSize = this.dCA.getResources().getDimensionPixelSize(d.f.ds80) + this.dCA.getResources().getDimensionPixelSize(d.f.ds16) + this.dCA.getResources().getDimensionPixelSize(d.f.ds16);
        this.mListFooter = new View(this.dCA.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.JC.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dCD.d(aVar);
            mK(this.dCD.getItemLength());
            aze();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dCD.f(aVar);
            mK(this.dCD.getItemLength());
            aze();
        }
    }

    private void aze() {
        if (this.dCD.getItemLength() > 0) {
            this.dCF.setEnabled(true);
        } else {
            this.dCF.setEnabled(false);
        }
    }

    public void azf() {
        k.b(this.dCA.getPageContext().getPageActivity(), this.dza);
    }

    private void mK(int i) {
        this.dCF.setText(String.format(this.dCA.getPageContext().getString(d.l.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int azg() {
        return this.dCG;
    }

    public void mL(int i) {
        this.dCG = i;
        this.dCD.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dCD.e(aVar);
        }
    }

    public void onDestroy() {
        this.dza.removeTextChangedListener(this.mTextWatcher);
    }
}
