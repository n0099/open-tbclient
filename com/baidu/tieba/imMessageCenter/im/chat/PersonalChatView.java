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
    private PersonalChatActivity dAQ;
    private LinearLayout dAR;
    private LinearLayout dAS;
    private TextView dAT;
    private TextView dAU;
    private TextView dAV;
    private Button dAW;
    private View.OnClickListener dAX;
    private TextView dgx;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.dAX = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.dAQ.showToast(d.l.add_friend_cannot_send);
            }
        };
        if (!this.dAQ.ayu() && this.mTool != null) {
            b(this.mTool.eC(6));
            b(this.mTool.eC(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.dAQ = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.l.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.personal_info_btn, talkableActivity);
            this.dgx = (TextView) this.mBtnGroupInfo.findViewById(d.h.group_info_btn_txt);
            this.dgx.setText(string);
        }
        if (!this.dAQ.ayu()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.dAR = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.h.stranger_person_add_friend_stub)).inflate();
            this.dAS = (LinearLayout) this.dAR.findViewById(d.h.add_friend_tip_full);
            this.dAT = (TextView) this.dAR.findViewById(d.h.add_friend_tip_title);
            this.dAU = (TextView) this.dAR.findViewById(d.h.add_friend_tip_content);
            this.dAV = (TextView) this.dAR.findViewById(d.h.add_friend_tip_center);
            this.dAW = (Button) this.dAR.findViewById(d.h.add_friend_tip_button);
            this.dAW.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.dAR.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dgx != null) {
            ai.c(this.dgx, d.e.cp_cont_b, 1);
        }
    }

    private void b(l lVar) {
        if (lVar != null && lVar != null && (lVar instanceof View)) {
            ((View) lVar).setOnClickListener(this.dAX);
        }
    }

    private void ayw() {
        if (this.mTool != null) {
            this.mTool.Di();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (cardStatus) {
            case APPLY:
                ayx();
                return;
            case WAIT:
                gM(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                g(z, str);
                return;
            case PASS:
                gN(z);
                return;
            default:
                return;
        }
    }

    private void ayx() {
        this.dAS.setVisibility(0);
        this.dAV.setVisibility(8);
        this.dAT.setText(d.l.add_friend_title);
        this.dAU.setText(d.l.add_friend_content);
        this.dAW.setText(d.l.add_friend_button);
    }

    private void gM(boolean z) {
        if (this.dAQ.ays().azj() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.dAV.startAnimation(translateAnimation);
                }
            });
            this.dAV.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.dAV.setVisibility(0);
                    PersonalChatView.this.dAV.setAnimation(translateAnimation3);
                }
            });
            this.dAS.setVisibility(8);
            this.dAS.startAnimation(translateAnimation4);
        } else {
            this.dAS.setVisibility(8);
            this.dAV.setVisibility(0);
        }
        this.dAV.setText(d.l.add_friend_wait);
        this.dAW.setText(d.l.add_friend_button);
    }

    private void g(boolean z, final String str) {
        final String userName = this.dAQ.ays().getUser().getUserName();
        this.dAV.setVisibility(8);
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
                    PersonalChatView.this.dAS.clearAnimation();
                    PersonalChatView.this.dAT.setText(PersonalChatView.this.dAQ.getResources().getString(d.l.add_friend_agree_title, userName));
                    PersonalChatView.this.dAU.setText(str);
                    PersonalChatView.this.dAS.setAnimation(translateAnimation);
                }
            });
            this.dAS.setVisibility(0);
            this.dAS.startAnimation(translateAnimation2);
        } else {
            this.dAS.setVisibility(0);
            this.dAT.setText(this.dAQ.getResources().getString(d.l.add_friend_agree_title, userName));
            this.dAU.setText(str);
        }
        this.dAW.setText(d.l.add_friend_agree_button);
    }

    private void gN(boolean z) {
        ayw();
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
                    PersonalChatView.this.dAR.setVisibility(8);
                }
            });
            this.dAR.startAnimation(translateAnimation);
            return;
        }
        this.dAR.setVisibility(8);
    }

    public Button ayy() {
        return this.dAW;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
