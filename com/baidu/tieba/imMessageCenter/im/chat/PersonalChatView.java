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
    private PersonalChatActivity dJr;
    private LinearLayout dJs;
    private LinearLayout dJt;
    private TextView dJu;
    private TextView dJv;
    private TextView dJw;
    private Button dJx;
    private View.OnClickListener dJy;
    private TextView doY;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.dJy = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.dJr.showToast(d.l.add_friend_cannot_send);
            }
        };
        if (!this.dJr.aAL() && this.mTool != null) {
            b(this.mTool.eC(6));
            b(this.mTool.eC(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.dJr = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.l.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.personal_info_btn, talkableActivity);
            this.doY = (TextView) this.mBtnGroupInfo.findViewById(d.h.group_info_btn_txt);
            this.doY.setText(string);
        }
        if (!this.dJr.aAL()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.dJs = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.h.stranger_person_add_friend_stub)).inflate();
            this.dJt = (LinearLayout) this.dJs.findViewById(d.h.add_friend_tip_full);
            this.dJu = (TextView) this.dJs.findViewById(d.h.add_friend_tip_title);
            this.dJv = (TextView) this.dJs.findViewById(d.h.add_friend_tip_content);
            this.dJw = (TextView) this.dJs.findViewById(d.h.add_friend_tip_center);
            this.dJx = (Button) this.dJs.findViewById(d.h.add_friend_tip_button);
            this.dJx.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.dJs.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.doY != null) {
            aj.c(this.doY, d.e.cp_cont_b, 1);
        }
    }

    private void b(l lVar) {
        if (lVar != null && lVar != null && (lVar instanceof View)) {
            ((View) lVar).setOnClickListener(this.dJy);
        }
    }

    private void aAN() {
        if (this.mTool != null) {
            this.mTool.Dd();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (cardStatus) {
            case APPLY:
                aAO();
                return;
            case WAIT:
                gX(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                h(z, str);
                return;
            case PASS:
                gY(z);
                return;
            default:
                return;
        }
    }

    private void aAO() {
        this.dJt.setVisibility(0);
        this.dJw.setVisibility(8);
        this.dJu.setText(d.l.add_friend_title);
        this.dJv.setText(d.l.add_friend_content);
        this.dJx.setText(d.l.add_friend_button);
    }

    private void gX(boolean z) {
        if (this.dJr.aAJ().aBA() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.dJw.startAnimation(translateAnimation);
                }
            });
            this.dJw.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.dJw.setVisibility(0);
                    PersonalChatView.this.dJw.setAnimation(translateAnimation3);
                }
            });
            this.dJt.setVisibility(8);
            this.dJt.startAnimation(translateAnimation4);
        } else {
            this.dJt.setVisibility(8);
            this.dJw.setVisibility(0);
        }
        this.dJw.setText(d.l.add_friend_wait);
        this.dJx.setText(d.l.add_friend_button);
    }

    private void h(boolean z, final String str) {
        final String userName = this.dJr.aAJ().getUser().getUserName();
        this.dJw.setVisibility(8);
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
                    PersonalChatView.this.dJt.clearAnimation();
                    PersonalChatView.this.dJu.setText(PersonalChatView.this.dJr.getResources().getString(d.l.add_friend_agree_title, userName));
                    PersonalChatView.this.dJv.setText(str);
                    PersonalChatView.this.dJt.setAnimation(translateAnimation);
                }
            });
            this.dJt.setVisibility(0);
            this.dJt.startAnimation(translateAnimation2);
        } else {
            this.dJt.setVisibility(0);
            this.dJu.setText(this.dJr.getResources().getString(d.l.add_friend_agree_title, userName));
            this.dJv.setText(str);
        }
        this.dJx.setText(d.l.add_friend_agree_button);
    }

    private void gY(boolean z) {
        aAN();
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
                    PersonalChatView.this.dJs.setVisibility(8);
                }
            });
            this.dJs.startAnimation(translateAnimation);
            return;
        }
        this.dJs.setVisibility(8);
    }

    public Button aAP() {
        return this.dJx;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
