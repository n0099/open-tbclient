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
    private PersonalChatActivity dGn;
    private LinearLayout dGo;
    private LinearLayout dGp;
    private TextView dGq;
    private TextView dGr;
    private TextView dGs;
    private Button dGt;
    private View.OnClickListener dGu;
    private TextView dlV;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.dGu = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.dGn.showToast(d.l.add_friend_cannot_send);
            }
        };
        if (!this.dGn.azC() && this.mTool != null) {
            b(this.mTool.eM(6));
            b(this.mTool.eM(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.dGn = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.l.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.personal_info_btn, talkableActivity);
            this.dlV = (TextView) this.mBtnGroupInfo.findViewById(d.h.group_info_btn_txt);
            this.dlV.setText(string);
        }
        if (!this.dGn.azC()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.dGo = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.h.stranger_person_add_friend_stub)).inflate();
            this.dGp = (LinearLayout) this.dGo.findViewById(d.h.add_friend_tip_full);
            this.dGq = (TextView) this.dGo.findViewById(d.h.add_friend_tip_title);
            this.dGr = (TextView) this.dGo.findViewById(d.h.add_friend_tip_content);
            this.dGs = (TextView) this.dGo.findViewById(d.h.add_friend_tip_center);
            this.dGt = (Button) this.dGo.findViewById(d.h.add_friend_tip_button);
            this.dGt.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.dGo.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dlV != null) {
            aj.c(this.dlV, d.e.cp_cont_b, 1);
        }
    }

    private void b(l lVar) {
        if (lVar != null && lVar != null && (lVar instanceof View)) {
            ((View) lVar).setOnClickListener(this.dGu);
        }
    }

    private void azE() {
        if (this.mTool != null) {
            this.mTool.CB();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (cardStatus) {
            case APPLY:
                azF();
                return;
            case WAIT:
                gK(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                h(z, str);
                return;
            case PASS:
                gL(z);
                return;
            default:
                return;
        }
    }

    private void azF() {
        this.dGp.setVisibility(0);
        this.dGs.setVisibility(8);
        this.dGq.setText(d.l.add_friend_title);
        this.dGr.setText(d.l.add_friend_content);
        this.dGt.setText(d.l.add_friend_button);
    }

    private void gK(boolean z) {
        if (this.dGn.azA().aAr() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.dGs.startAnimation(translateAnimation);
                }
            });
            this.dGs.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.dGs.setVisibility(0);
                    PersonalChatView.this.dGs.setAnimation(translateAnimation3);
                }
            });
            this.dGp.setVisibility(8);
            this.dGp.startAnimation(translateAnimation4);
        } else {
            this.dGp.setVisibility(8);
            this.dGs.setVisibility(0);
        }
        this.dGs.setText(d.l.add_friend_wait);
        this.dGt.setText(d.l.add_friend_button);
    }

    private void h(boolean z, final String str) {
        final String userName = this.dGn.azA().getUser().getUserName();
        this.dGs.setVisibility(8);
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
                    PersonalChatView.this.dGp.clearAnimation();
                    PersonalChatView.this.dGq.setText(PersonalChatView.this.dGn.getResources().getString(d.l.add_friend_agree_title, userName));
                    PersonalChatView.this.dGr.setText(str);
                    PersonalChatView.this.dGp.setAnimation(translateAnimation);
                }
            });
            this.dGp.setVisibility(0);
            this.dGp.startAnimation(translateAnimation2);
        } else {
            this.dGp.setVisibility(0);
            this.dGq.setText(this.dGn.getResources().getString(d.l.add_friend_agree_title, userName));
            this.dGr.setText(str);
        }
        this.dGt.setText(d.l.add_friend_agree_button);
    }

    private void gL(boolean z) {
        azE();
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
                    PersonalChatView.this.dGo.setVisibility(8);
                }
            });
            this.dGo.startAnimation(translateAnimation);
            return;
        }
        this.dGo.setVisibility(8);
    }

    public Button azG() {
        return this.dGt;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
