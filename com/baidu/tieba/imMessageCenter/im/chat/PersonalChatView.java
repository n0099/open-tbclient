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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.g;
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes4.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private TextView eJW;
    private PersonalChatActivity fdV;
    private LinearLayout fdW;
    private LinearLayout fdX;
    private TextView fdY;
    private TextView fdZ;
    private TextView fea;
    private Button feb;
    private View.OnClickListener fec;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.fec = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.fdV.showToast(e.j.add_friend_cannot_send);
            }
        };
        if (!this.fdV.aVy() && this.mTool != null) {
            b(this.mTool.fI(6));
            b(this.mTool.fI(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.fdV = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(e.j.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.personal_info_btn, talkableActivity);
            this.eJW = (TextView) this.mBtnGroupInfo.findViewById(e.g.group_info_btn_txt);
            this.eJW.setText(string);
        }
        if (!this.fdV.aVy()) {
            this.fdW = (LinearLayout) ((ViewStub) talkableActivity.findViewById(e.g.stranger_person_add_friend_stub)).inflate();
            this.fdX = (LinearLayout) this.fdW.findViewById(e.g.add_friend_tip_full);
            this.fdY = (TextView) this.fdW.findViewById(e.g.add_friend_tip_title);
            this.fdZ = (TextView) this.fdW.findViewById(e.g.add_friend_tip_content);
            this.fea = (TextView) this.fdW.findViewById(e.g.add_friend_tip_center);
            this.feb = (Button) this.fdW.findViewById(e.g.add_friend_tip_button);
            this.feb.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.fdW.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eJW != null) {
            al.c(this.eJW, e.d.cp_cont_b, 1);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.fec);
        }
    }

    private void aVA() {
        if (this.mTool != null) {
            this.mTool.Mh();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.fdW.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                aVB();
                return;
            case WAIT:
                ja(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                j(z, str);
                return;
            case PASS:
                jb(z);
                return;
            default:
                return;
        }
    }

    private void aVB() {
        this.fdW.setVisibility(8);
        this.fdX.setVisibility(0);
        this.fea.setVisibility(8);
        this.fdY.setText(e.j.add_friend_title);
        this.fdZ.setText(e.j.add_friend_content);
        this.feb.setText(e.j.add_friend_button);
    }

    private void ja(boolean z) {
        if (this.fdV.aVw().aWi() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.fea.startAnimation(translateAnimation);
                }
            });
            this.fea.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.fea.setVisibility(0);
                    PersonalChatView.this.fea.setAnimation(translateAnimation3);
                }
            });
            this.fdX.setVisibility(8);
            this.fdX.startAnimation(translateAnimation4);
        } else {
            this.fdX.setVisibility(8);
            this.fea.setVisibility(0);
        }
        this.fea.setText(e.j.add_friend_wait);
        this.feb.setText(e.j.add_friend_button);
    }

    private void j(boolean z, final String str) {
        final String name_show = this.fdV.aVw().getUser().getName_show();
        this.fea.setVisibility(8);
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
                    PersonalChatView.this.fdX.clearAnimation();
                    PersonalChatView.this.fdY.setText(PersonalChatView.this.fdV.getResources().getString(e.j.add_friend_agree_title, name_show));
                    PersonalChatView.this.fdZ.setText(str);
                    PersonalChatView.this.fdX.setAnimation(translateAnimation);
                }
            });
            this.fdX.setVisibility(0);
            this.fdX.startAnimation(translateAnimation2);
        } else {
            this.fdX.setVisibility(0);
            this.fdY.setText(this.fdV.getResources().getString(e.j.add_friend_agree_title, name_show));
            this.fdZ.setText(str);
        }
        this.feb.setText(e.j.add_friend_agree_button);
    }

    private void jb(boolean z) {
        aVA();
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
                    PersonalChatView.this.fdW.setVisibility(8);
                }
            });
            this.fdW.startAnimation(translateAnimation);
            return;
        }
        this.fdW.setVisibility(8);
    }

    public Button aVC() {
        return this.feb;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
