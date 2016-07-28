package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private static /* synthetic */ int[] dbG;
    private TextView cGU;
    private LinearLayout dbA;
    private TextView dbB;
    private TextView dbC;
    private TextView dbD;
    private Button dbE;
    private View.OnClickListener dbF;
    private PersonalChatActivity dby;
    private LinearLayout dbz;

    static /* synthetic */ int[] ase() {
        int[] iArr = dbG;
        if (iArr == null) {
            iArr = new int[PersonalMsglistModel.CardStatus.valuesCustom().length];
            try {
                iArr[PersonalMsglistModel.CardStatus.AGREE.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PersonalMsglistModel.CardStatus.APPLY.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PersonalMsglistModel.CardStatus.PASS.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[PersonalMsglistModel.CardStatus.WAIT.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            dbG = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.dbF = new q(this);
        if (!this.dby.arZ() && this.mTool != null) {
            b(this.mTool.ej(6));
            b(this.mTool.ej(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.dby = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(u.j.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.personal_info_btn, talkableActivity);
            this.cGU = (TextView) this.mBtnGroupInfo.findViewById(u.g.group_info_btn_txt);
            this.cGU.setText(string);
        }
        if (!this.dby.arZ()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.dbz = (LinearLayout) ((ViewStub) talkableActivity.findViewById(u.g.stranger_person_add_friend_stub)).inflate();
            this.dbA = (LinearLayout) this.dbz.findViewById(u.g.add_friend_tip_full);
            this.dbB = (TextView) this.dbz.findViewById(u.g.add_friend_tip_title);
            this.dbC = (TextView) this.dbz.findViewById(u.g.add_friend_tip_content);
            this.dbD = (TextView) this.dbz.findViewById(u.g.add_friend_tip_center);
            this.dbE = (Button) this.dbz.findViewById(u.g.add_friend_tip_button);
            this.dbE.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.m10getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.dbz.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cGU != null) {
            av.c(this.cGU, u.d.cp_cont_b, 1);
        }
    }

    private void b(com.baidu.tbadk.editortools.s sVar) {
        if (sVar != null && sVar != null && (sVar instanceof View)) {
            ((View) sVar).setOnClickListener(this.dbF);
        }
    }

    private void asb() {
        if (this.mTool != null) {
            this.mTool.Bu();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (ase()[cardStatus.ordinal()]) {
            case 1:
                asc();
                return;
            case 2:
                fL(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                i(z, str);
                return;
            case 4:
                fM(z);
                return;
            default:
                return;
        }
    }

    private void asc() {
        this.dbA.setVisibility(0);
        this.dbD.setVisibility(8);
        this.dbB.setText(u.j.add_friend_title);
        this.dbC.setText(u.j.add_friend_content);
        this.dbE.setText(u.j.add_friend_button);
    }

    private void fL(boolean z) {
        if (this.dby.arW().atW() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new r(this, translateAnimation));
            this.dbD.startAnimation(translateAnimation2);
            return;
        }
        if (z) {
            TranslateAnimation translateAnimation3 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation3.setDuration(400L);
            translateAnimation3.setFillAfter(true);
            TranslateAnimation translateAnimation4 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation4.setDuration(400L);
            translateAnimation4.setFillAfter(true);
            translateAnimation4.setAnimationListener(new s(this, translateAnimation3));
            this.dbA.setVisibility(8);
            this.dbA.startAnimation(translateAnimation4);
        } else {
            this.dbA.setVisibility(8);
            this.dbD.setVisibility(0);
        }
        this.dbD.setText(u.j.add_friend_wait);
        this.dbE.setText(u.j.add_friend_button);
    }

    private void i(boolean z, String str) {
        String userName = this.dby.arW().getUser().getUserName();
        this.dbD.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new t(this, userName, str, translateAnimation));
            this.dbA.setVisibility(0);
            this.dbA.startAnimation(translateAnimation2);
        } else {
            this.dbA.setVisibility(0);
            this.dbB.setText(this.dby.getResources().getString(u.j.add_friend_agree_title, userName));
            this.dbC.setText(str);
        }
        this.dbE.setText(u.j.add_friend_agree_button);
    }

    private void fM(boolean z) {
        asb();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new u(this));
            this.dbz.startAnimation(translateAnimation);
            return;
        }
        this.dbz.setVisibility(8);
    }

    public Button asd() {
        return this.dbE;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
