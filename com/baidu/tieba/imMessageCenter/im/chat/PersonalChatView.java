package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private static /* synthetic */ int[] dgE;
    private TextView cLX;
    private TextView dgA;
    private TextView dgB;
    private Button dgC;
    private View.OnClickListener dgD;
    private PersonalChatActivity dgw;
    private LinearLayout dgx;
    private LinearLayout dgy;
    private TextView dgz;

    static /* synthetic */ int[] auT() {
        int[] iArr = dgE;
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
            dgE = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.dgD = new q(this);
        if (!this.dgw.auO() && this.mTool != null) {
            b(this.mTool.eB(6));
            b(this.mTool.eB(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.dgw = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(r.l.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.j.personal_info_btn, talkableActivity);
            this.cLX = (TextView) this.mBtnGroupInfo.findViewById(r.h.group_info_btn_txt);
            this.cLX.setText(string);
        }
        if (!this.dgw.auO()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.dgx = (LinearLayout) ((ViewStub) talkableActivity.findViewById(r.h.stranger_person_add_friend_stub)).inflate();
            this.dgy = (LinearLayout) this.dgx.findViewById(r.h.add_friend_tip_full);
            this.dgz = (TextView) this.dgx.findViewById(r.h.add_friend_tip_title);
            this.dgA = (TextView) this.dgx.findViewById(r.h.add_friend_tip_content);
            this.dgB = (TextView) this.dgx.findViewById(r.h.add_friend_tip_center);
            this.dgC = (Button) this.dgx.findViewById(r.h.add_friend_tip_button);
            this.dgC.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.dgx.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cLX != null) {
            ap.c(this.cLX, r.e.cp_cont_b, 1);
        }
    }

    private void b(com.baidu.tbadk.editortools.p pVar) {
        if (pVar != null && pVar != null && (pVar instanceof View)) {
            ((View) pVar).setOnClickListener(this.dgD);
        }
    }

    private void auQ() {
        if (this.mTool != null) {
            this.mTool.CD();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (auT()[cardStatus.ordinal()]) {
            case 1:
                auR();
                return;
            case 2:
                gr(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                i(z, str);
                return;
            case 4:
                gs(z);
                return;
            default:
                return;
        }
    }

    private void auR() {
        this.dgy.setVisibility(0);
        this.dgB.setVisibility(8);
        this.dgz.setText(r.l.add_friend_title);
        this.dgA.setText(r.l.add_friend_content);
        this.dgC.setText(r.l.add_friend_button);
    }

    private void gr(boolean z) {
        if (this.dgw.auL().avH() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new r(this, translateAnimation));
            this.dgB.startAnimation(translateAnimation2);
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
            this.dgy.setVisibility(8);
            this.dgy.startAnimation(translateAnimation4);
        } else {
            this.dgy.setVisibility(8);
            this.dgB.setVisibility(0);
        }
        this.dgB.setText(r.l.add_friend_wait);
        this.dgC.setText(r.l.add_friend_button);
    }

    private void i(boolean z, String str) {
        String userName = this.dgw.auL().getUser().getUserName();
        this.dgB.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new t(this, userName, str, translateAnimation));
            this.dgy.setVisibility(0);
            this.dgy.startAnimation(translateAnimation2);
        } else {
            this.dgy.setVisibility(0);
            this.dgz.setText(this.dgw.getResources().getString(r.l.add_friend_agree_title, userName));
            this.dgA.setText(str);
        }
        this.dgC.setText(r.l.add_friend_agree_button);
    }

    private void gs(boolean z) {
        auQ();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new u(this));
            this.dgx.startAnimation(translateAnimation);
            return;
        }
        this.dgx.setVisibility(8);
    }

    public Button auS() {
        return this.dgC;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
