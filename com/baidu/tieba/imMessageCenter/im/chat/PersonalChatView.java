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
    private static /* synthetic */ int[] dhv;
    private TextView cMJ;
    private PersonalChatActivity dhn;
    private LinearLayout dho;
    private LinearLayout dhp;
    private TextView dhq;
    private TextView dhr;
    private TextView dhs;
    private Button dht;
    private View.OnClickListener dhu;

    static /* synthetic */ int[] auh() {
        int[] iArr = dhv;
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
            dhv = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.dhu = new q(this);
        if (!this.dhn.auc() && this.mTool != null) {
            b(this.mTool.ez(6));
            b(this.mTool.ez(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.dhn = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(w.l.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.personal_info_btn, talkableActivity);
            this.cMJ = (TextView) this.mBtnGroupInfo.findViewById(w.h.group_info_btn_txt);
            this.cMJ.setText(string);
        }
        if (!this.dhn.auc()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.dho = (LinearLayout) ((ViewStub) talkableActivity.findViewById(w.h.stranger_person_add_friend_stub)).inflate();
            this.dhp = (LinearLayout) this.dho.findViewById(w.h.add_friend_tip_full);
            this.dhq = (TextView) this.dho.findViewById(w.h.add_friend_tip_title);
            this.dhr = (TextView) this.dho.findViewById(w.h.add_friend_tip_content);
            this.dhs = (TextView) this.dho.findViewById(w.h.add_friend_tip_center);
            this.dht = (Button) this.dho.findViewById(w.h.add_friend_tip_button);
            this.dht.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.dho.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cMJ != null) {
            aq.c(this.cMJ, w.e.cp_cont_b, 1);
        }
    }

    private void b(com.baidu.tbadk.editortools.p pVar) {
        if (pVar != null && pVar != null && (pVar instanceof View)) {
            ((View) pVar).setOnClickListener(this.dhu);
        }
    }

    private void aue() {
        if (this.mTool != null) {
            this.mTool.Du();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (auh()[cardStatus.ordinal()]) {
            case 1:
                auf();
                return;
            case 2:
                gi(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                h(z, str);
                return;
            case 4:
                gj(z);
                return;
            default:
                return;
        }
    }

    private void auf() {
        this.dhp.setVisibility(0);
        this.dhs.setVisibility(8);
        this.dhq.setText(w.l.add_friend_title);
        this.dhr.setText(w.l.add_friend_content);
        this.dht.setText(w.l.add_friend_button);
    }

    private void gi(boolean z) {
        if (this.dhn.atZ().auW() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new r(this, translateAnimation));
            this.dhs.startAnimation(translateAnimation2);
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
            this.dhp.setVisibility(8);
            this.dhp.startAnimation(translateAnimation4);
        } else {
            this.dhp.setVisibility(8);
            this.dhs.setVisibility(0);
        }
        this.dhs.setText(w.l.add_friend_wait);
        this.dht.setText(w.l.add_friend_button);
    }

    private void h(boolean z, String str) {
        String userName = this.dhn.atZ().getUser().getUserName();
        this.dhs.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new t(this, userName, str, translateAnimation));
            this.dhp.setVisibility(0);
            this.dhp.startAnimation(translateAnimation2);
        } else {
            this.dhp.setVisibility(0);
            this.dhq.setText(this.dhn.getResources().getString(w.l.add_friend_agree_title, userName));
            this.dhr.setText(str);
        }
        this.dht.setText(w.l.add_friend_agree_button);
    }

    private void gj(boolean z) {
        aue();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new u(this));
            this.dho.startAnimation(translateAnimation);
            return;
        }
        this.dho.setVisibility(8);
    }

    public Button aug() {
        return this.dht;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
