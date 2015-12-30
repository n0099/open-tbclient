package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private static /* synthetic */ int[] cds;
    private PersonalChatActivity cdk;
    private LinearLayout cdl;
    private LinearLayout cdm;
    private TextView cdn;
    private TextView cdo;
    private TextView cdp;
    private Button cdq;
    private View.OnClickListener cdr;
    private TextView mGroupInfoBtnTxt;

    static /* synthetic */ int[] act() {
        int[] iArr = cds;
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
            cds = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.cdr = new p(this);
        if (!this.cdk.aco() && this.mTool != null) {
            b(this.mTool.ea(6));
            b(this.mTool.ea(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.cdk = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(n.j.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.personal_info_btn, talkableActivity);
            this.mGroupInfoBtnTxt = (TextView) this.mBtnGroupInfo.findViewById(n.g.group_info_btn_txt);
            this.mGroupInfoBtnTxt.setText(string);
        }
        if (!this.cdk.aco()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.cdl = (LinearLayout) ((ViewStub) talkableActivity.findViewById(n.g.stranger_person_add_friend_stub)).inflate();
            this.cdm = (LinearLayout) this.cdl.findViewById(n.g.add_friend_tip_full);
            this.cdn = (TextView) this.cdl.findViewById(n.g.add_friend_tip_title);
            this.cdo = (TextView) this.cdl.findViewById(n.g.add_friend_tip_content);
            this.cdp = (TextView) this.cdl.findViewById(n.g.add_friend_tip_center);
            this.cdq = (Button) this.cdl.findViewById(n.g.add_friend_tip_button);
            this.cdq.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.cdl.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    private void b(com.baidu.tbadk.editortools.r rVar) {
        if (rVar != null && rVar != null && (rVar instanceof View)) {
            ((View) rVar).setOnClickListener(this.cdr);
        }
    }

    private void acq() {
        if (this.mTool != null) {
            this.mTool.Bs();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (act()[cardStatus.ordinal()]) {
            case 1:
                acr();
                return;
            case 2:
                dP(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                i(z, str);
                return;
            case 4:
                dQ(z);
                return;
            default:
                return;
        }
    }

    private void acr() {
        this.cdm.setVisibility(0);
        this.cdp.setVisibility(8);
        this.cdn.setText(n.j.add_friend_title);
        this.cdo.setText(n.j.add_friend_content);
        this.cdq.setText(n.j.add_friend_button);
    }

    private void dP(boolean z) {
        if (this.cdk.acl().ael() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new q(this, translateAnimation));
            this.cdp.startAnimation(translateAnimation2);
            return;
        }
        if (z) {
            TranslateAnimation translateAnimation3 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation3.setDuration(400L);
            translateAnimation3.setFillAfter(true);
            TranslateAnimation translateAnimation4 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation4.setDuration(400L);
            translateAnimation4.setFillAfter(true);
            translateAnimation4.setAnimationListener(new r(this, translateAnimation3));
            this.cdm.setVisibility(8);
            this.cdm.startAnimation(translateAnimation4);
        } else {
            this.cdm.setVisibility(8);
            this.cdp.setVisibility(0);
        }
        this.cdp.setText(n.j.add_friend_wait);
        this.cdq.setText(n.j.add_friend_button);
    }

    private void i(boolean z, String str) {
        String userName = this.cdk.acl().getUser().getUserName();
        this.cdp.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new s(this, userName, str, translateAnimation));
            this.cdm.setVisibility(0);
            this.cdm.startAnimation(translateAnimation2);
        } else {
            this.cdm.setVisibility(0);
            this.cdn.setText(this.cdk.getResources().getString(n.j.add_friend_agree_title, userName));
            this.cdo.setText(str);
        }
        this.cdq.setText(n.j.add_friend_agree_button);
    }

    private void dQ(boolean z) {
        acq();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new t(this));
            this.cdl.startAnimation(translateAnimation);
            return;
        }
        this.cdl.setVisibility(8);
    }

    public Button acs() {
        return this.cdq;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
