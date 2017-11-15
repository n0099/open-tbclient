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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes2.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private PersonalChatActivity dOg;
    private LinearLayout dOh;
    private LinearLayout dOi;
    private TextView dOj;
    private TextView dOk;
    private TextView dOl;
    private Button dOm;
    private View.OnClickListener dOn;
    private TextView duf;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.dOn = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.dOg.showToast(d.j.add_friend_cannot_send);
            }
        };
        if (!this.dOg.aCb() && this.mTool != null) {
            b(this.mTool.eM(6));
            b(this.mTool.eM(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.dOg = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.j.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.personal_info_btn, talkableActivity);
            this.duf = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.duf.setText(string);
        }
        if (!this.dOg.aCb()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.dOh = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.stranger_person_add_friend_stub)).inflate();
            this.dOi = (LinearLayout) this.dOh.findViewById(d.g.add_friend_tip_full);
            this.dOj = (TextView) this.dOh.findViewById(d.g.add_friend_tip_title);
            this.dOk = (TextView) this.dOh.findViewById(d.g.add_friend_tip_content);
            this.dOl = (TextView) this.dOh.findViewById(d.g.add_friend_tip_center);
            this.dOm = (Button) this.dOh.findViewById(d.g.add_friend_tip_button);
            this.dOm.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.dOh.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.duf != null) {
            aj.c(this.duf, d.C0080d.cp_cont_b, 1);
        }
    }

    private void b(l lVar) {
        if (lVar != null && lVar != null && (lVar instanceof View)) {
            ((View) lVar).setOnClickListener(this.dOn);
        }
    }

    private void aCd() {
        if (this.mTool != null) {
            this.mTool.Dc();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (cardStatus) {
            case APPLY:
                aCe();
                return;
            case WAIT:
                gM(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                i(z, str);
                return;
            case PASS:
                gN(z);
                return;
            default:
                return;
        }
    }

    private void aCe() {
        this.dOi.setVisibility(0);
        this.dOl.setVisibility(8);
        this.dOj.setText(d.j.add_friend_title);
        this.dOk.setText(d.j.add_friend_content);
        this.dOm.setText(d.j.add_friend_button);
    }

    private void gM(boolean z) {
        if (this.dOg.aBZ().aCQ() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.dOl.startAnimation(translateAnimation);
                }
            });
            this.dOl.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.dOl.setVisibility(0);
                    PersonalChatView.this.dOl.setAnimation(translateAnimation3);
                }
            });
            this.dOi.setVisibility(8);
            this.dOi.startAnimation(translateAnimation4);
        } else {
            this.dOi.setVisibility(8);
            this.dOl.setVisibility(0);
        }
        this.dOl.setText(d.j.add_friend_wait);
        this.dOm.setText(d.j.add_friend_button);
    }

    private void i(boolean z, final String str) {
        final String userName = this.dOg.aBZ().getUser().getUserName();
        this.dOl.setVisibility(8);
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
                    PersonalChatView.this.dOi.clearAnimation();
                    PersonalChatView.this.dOj.setText(PersonalChatView.this.dOg.getResources().getString(d.j.add_friend_agree_title, userName));
                    PersonalChatView.this.dOk.setText(str);
                    PersonalChatView.this.dOi.setAnimation(translateAnimation);
                }
            });
            this.dOi.setVisibility(0);
            this.dOi.startAnimation(translateAnimation2);
        } else {
            this.dOi.setVisibility(0);
            this.dOj.setText(this.dOg.getResources().getString(d.j.add_friend_agree_title, userName));
            this.dOk.setText(str);
        }
        this.dOm.setText(d.j.add_friend_agree_button);
    }

    private void gN(boolean z) {
        aCd();
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
                    PersonalChatView.this.dOh.setVisibility(8);
                }
            });
            this.dOh.startAnimation(translateAnimation);
            return;
        }
        this.dOh.setVisibility(8);
    }

    public Button aCf() {
        return this.dOm;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
