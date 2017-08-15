package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes2.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private PersonalChatActivity dCN;
    private LinearLayout dCO;
    private LinearLayout dCP;
    private TextView dCQ;
    private TextView dCR;
    private TextView dCS;
    private Button dCT;
    private View.OnClickListener dCU;
    private TextView diu;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.dCU = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.dCN.showToast(d.l.add_friend_cannot_send);
            }
        };
        if (!this.dCN.azb() && this.mTool != null) {
            b(this.mTool.eC(6));
            b(this.mTool.eC(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.dCN = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.l.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.personal_info_btn, talkableActivity);
            this.diu = (TextView) this.mBtnGroupInfo.findViewById(d.h.group_info_btn_txt);
            this.diu.setText(string);
        }
        if (!this.dCN.azb()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.dCO = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.h.stranger_person_add_friend_stub)).inflate();
            this.dCP = (LinearLayout) this.dCO.findViewById(d.h.add_friend_tip_full);
            this.dCQ = (TextView) this.dCO.findViewById(d.h.add_friend_tip_title);
            this.dCR = (TextView) this.dCO.findViewById(d.h.add_friend_tip_content);
            this.dCS = (TextView) this.dCO.findViewById(d.h.add_friend_tip_center);
            this.dCT = (Button) this.dCO.findViewById(d.h.add_friend_tip_button);
            this.dCT.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.dCO.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.diu != null) {
            ai.c(this.diu, d.e.cp_cont_b, 1);
        }
    }

    private void b(l lVar) {
        if (lVar != null && lVar != null && (lVar instanceof View)) {
            ((View) lVar).setOnClickListener(this.dCU);
        }
    }

    private void azd() {
        if (this.mTool != null) {
            this.mTool.Di();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (cardStatus) {
            case APPLY:
                aze();
                return;
            case WAIT:
                gP(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                g(z, str);
                return;
            case PASS:
                gQ(z);
                return;
            default:
                return;
        }
    }

    private void aze() {
        this.dCP.setVisibility(0);
        this.dCS.setVisibility(8);
        this.dCQ.setText(d.l.add_friend_title);
        this.dCR.setText(d.l.add_friend_content);
        this.dCT.setText(d.l.add_friend_button);
    }

    private void gP(boolean z) {
        if (this.dCN.ayZ().azQ() == PersonalMsglistModel.CardStatus.WAIT && z) {
            final TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    PersonalChatView.this.dCS.startAnimation(translateAnimation);
                }
            });
            this.dCS.startAnimation(translateAnimation2);
            return;
        }
        if (z) {
            final TranslateAnimation translateAnimation3 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation3.setDuration(400L);
            translateAnimation3.setFillAfter(true);
            TranslateAnimation translateAnimation4 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation4.setDuration(400L);
            translateAnimation4.setFillAfter(true);
            translateAnimation4.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    PersonalChatView.this.dCS.setVisibility(0);
                    PersonalChatView.this.dCS.setAnimation(translateAnimation3);
                }
            });
            this.dCP.setVisibility(8);
            this.dCP.startAnimation(translateAnimation4);
        } else {
            this.dCP.setVisibility(8);
            this.dCS.setVisibility(0);
        }
        this.dCS.setText(d.l.add_friend_wait);
        this.dCT.setText(d.l.add_friend_button);
    }

    private void g(boolean z, final String str) {
        final String userName = this.dCN.ayZ().getUser().getUserName();
        this.dCS.setVisibility(8);
        if (z) {
            final TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    PersonalChatView.this.dCP.clearAnimation();
                    PersonalChatView.this.dCQ.setText(PersonalChatView.this.dCN.getResources().getString(d.l.add_friend_agree_title, userName));
                    PersonalChatView.this.dCR.setText(str);
                    PersonalChatView.this.dCP.setAnimation(translateAnimation);
                }
            });
            this.dCP.setVisibility(0);
            this.dCP.startAnimation(translateAnimation2);
        } else {
            this.dCP.setVisibility(0);
            this.dCQ.setText(this.dCN.getResources().getString(d.l.add_friend_agree_title, userName));
            this.dCR.setText(str);
        }
        this.dCT.setText(d.l.add_friend_agree_button);
    }

    private void gQ(boolean z) {
        azd();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    PersonalChatView.this.dCO.setVisibility(8);
                }
            });
            this.dCO.startAnimation(translateAnimation);
            return;
        }
        this.dCO.setVisibility(8);
    }

    public Button azf() {
        return this.dCT;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
