package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private static /* synthetic */ int[] diW;
    private TextView cOm;
    private PersonalChatActivity diO;
    private LinearLayout diP;
    private LinearLayout diQ;
    private TextView diR;
    private TextView diS;
    private TextView diT;
    private Button diU;
    private View.OnClickListener diV;

    static /* synthetic */ int[] auo() {
        int[] iArr = diW;
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
            diW = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.diV = new q(this);
        if (!this.diO.auj() && this.mTool != null) {
            b(this.mTool.ew(6));
            b(this.mTool.ew(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.diO = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(w.l.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.personal_info_btn, talkableActivity);
            this.cOm = (TextView) this.mBtnGroupInfo.findViewById(w.h.group_info_btn_txt);
            this.cOm.setText(string);
        }
        if (!this.diO.auj()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.diP = (LinearLayout) ((ViewStub) talkableActivity.findViewById(w.h.stranger_person_add_friend_stub)).inflate();
            this.diQ = (LinearLayout) this.diP.findViewById(w.h.add_friend_tip_full);
            this.diR = (TextView) this.diP.findViewById(w.h.add_friend_tip_title);
            this.diS = (TextView) this.diP.findViewById(w.h.add_friend_tip_content);
            this.diT = (TextView) this.diP.findViewById(w.h.add_friend_tip_center);
            this.diU = (Button) this.diP.findViewById(w.h.add_friend_tip_button);
            this.diU.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.diP.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cOm != null) {
            aq.c(this.cOm, w.e.cp_cont_b, 1);
        }
    }

    private void b(com.baidu.tbadk.editortools.p pVar) {
        if (pVar != null && pVar != null && (pVar instanceof View)) {
            ((View) pVar).setOnClickListener(this.diV);
        }
    }

    private void aul() {
        if (this.mTool != null) {
            this.mTool.CW();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (auo()[cardStatus.ordinal()]) {
            case 1:
                aum();
                return;
            case 2:
                gi(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                i(z, str);
                return;
            case 4:
                gj(z);
                return;
            default:
                return;
        }
    }

    private void aum() {
        this.diQ.setVisibility(0);
        this.diT.setVisibility(8);
        this.diR.setText(w.l.add_friend_title);
        this.diS.setText(w.l.add_friend_content);
        this.diU.setText(w.l.add_friend_button);
    }

    private void gi(boolean z) {
        if (this.diO.aug().avd() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new r(this, translateAnimation));
            this.diT.startAnimation(translateAnimation2);
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
            this.diQ.setVisibility(8);
            this.diQ.startAnimation(translateAnimation4);
        } else {
            this.diQ.setVisibility(8);
            this.diT.setVisibility(0);
        }
        this.diT.setText(w.l.add_friend_wait);
        this.diU.setText(w.l.add_friend_button);
    }

    private void i(boolean z, String str) {
        String userName = this.diO.aug().getUser().getUserName();
        this.diT.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new t(this, userName, str, translateAnimation));
            this.diQ.setVisibility(0);
            this.diQ.startAnimation(translateAnimation2);
        } else {
            this.diQ.setVisibility(0);
            this.diR.setText(this.diO.getResources().getString(w.l.add_friend_agree_title, userName));
            this.diS.setText(str);
        }
        this.diU.setText(w.l.add_friend_agree_button);
    }

    private void gj(boolean z) {
        aul();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new u(this));
            this.diP.startAnimation(translateAnimation);
            return;
        }
        this.diP.setVisibility(8);
    }

    public Button aun() {
        return this.diU;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
