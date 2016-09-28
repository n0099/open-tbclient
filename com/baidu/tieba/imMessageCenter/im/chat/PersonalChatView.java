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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private static /* synthetic */ int[] doM;
    private TextView cTU;
    private PersonalChatActivity doE;
    private LinearLayout doF;
    private LinearLayout doG;
    private TextView doH;
    private TextView doI;
    private TextView doJ;
    private Button doK;
    private View.OnClickListener doL;

    static /* synthetic */ int[] axr() {
        int[] iArr = doM;
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
            doM = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.doL = new q(this);
        if (!this.doE.axm() && this.mTool != null) {
            b(this.mTool.ew(6));
            b(this.mTool.ew(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.doE = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(r.j.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.personal_info_btn, talkableActivity);
            this.cTU = (TextView) this.mBtnGroupInfo.findViewById(r.g.group_info_btn_txt);
            this.cTU.setText(string);
        }
        if (!this.doE.axm()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.doF = (LinearLayout) ((ViewStub) talkableActivity.findViewById(r.g.stranger_person_add_friend_stub)).inflate();
            this.doG = (LinearLayout) this.doF.findViewById(r.g.add_friend_tip_full);
            this.doH = (TextView) this.doF.findViewById(r.g.add_friend_tip_title);
            this.doI = (TextView) this.doF.findViewById(r.g.add_friend_tip_content);
            this.doJ = (TextView) this.doF.findViewById(r.g.add_friend_tip_center);
            this.doK = (Button) this.doF.findViewById(r.g.add_friend_tip_button);
            this.doK.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.doF.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cTU != null) {
            av.c(this.cTU, r.d.cp_cont_b, 1);
        }
    }

    private void b(com.baidu.tbadk.editortools.s sVar) {
        if (sVar != null && sVar != null && (sVar instanceof View)) {
            ((View) sVar).setOnClickListener(this.doL);
        }
    }

    private void axo() {
        if (this.mTool != null) {
            this.mTool.CP();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (axr()[cardStatus.ordinal()]) {
            case 1:
                axp();
                return;
            case 2:
                gk(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                h(z, str);
                return;
            case 4:
                gl(z);
                return;
            default:
                return;
        }
    }

    private void axp() {
        this.doG.setVisibility(0);
        this.doJ.setVisibility(8);
        this.doH.setText(r.j.add_friend_title);
        this.doI.setText(r.j.add_friend_content);
        this.doK.setText(r.j.add_friend_button);
    }

    private void gk(boolean z) {
        if (this.doE.axj().azi() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new r(this, translateAnimation));
            this.doJ.startAnimation(translateAnimation2);
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
            this.doG.setVisibility(8);
            this.doG.startAnimation(translateAnimation4);
        } else {
            this.doG.setVisibility(8);
            this.doJ.setVisibility(0);
        }
        this.doJ.setText(r.j.add_friend_wait);
        this.doK.setText(r.j.add_friend_button);
    }

    private void h(boolean z, String str) {
        String userName = this.doE.axj().getUser().getUserName();
        this.doJ.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new t(this, userName, str, translateAnimation));
            this.doG.setVisibility(0);
            this.doG.startAnimation(translateAnimation2);
        } else {
            this.doG.setVisibility(0);
            this.doH.setText(this.doE.getResources().getString(r.j.add_friend_agree_title, userName));
            this.doI.setText(str);
        }
        this.doK.setText(r.j.add_friend_agree_button);
    }

    private void gl(boolean z) {
        axo();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new u(this));
            this.doF.startAnimation(translateAnimation);
            return;
        }
        this.doF.setVisibility(8);
    }

    public Button axq() {
        return this.doK;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
