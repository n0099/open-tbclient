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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.g;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes2.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private TextView dPN;
    private PersonalChatActivity ejV;
    private LinearLayout ejW;
    private LinearLayout ejX;
    private TextView ejY;
    private TextView ejZ;
    private TextView eka;
    private Button ekb;
    private View.OnClickListener ekc;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.ekc = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PersonalChatView.this.ejV.showToast(d.k.add_friend_cannot_send);
            }
        };
        if (!this.ejV.aHx() && this.mTool != null) {
            b(this.mTool.eE(6));
            b(this.mTool.eE(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.ejV = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.k.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.personal_info_btn, talkableActivity);
            this.dPN = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.dPN.setText(string);
        }
        if (!this.ejV.aHx()) {
            this.ejW = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.stranger_person_add_friend_stub)).inflate();
            this.ejX = (LinearLayout) this.ejW.findViewById(d.g.add_friend_tip_full);
            this.ejY = (TextView) this.ejW.findViewById(d.g.add_friend_tip_title);
            this.ejZ = (TextView) this.ejW.findViewById(d.g.add_friend_tip_content);
            this.eka = (TextView) this.ejW.findViewById(d.g.add_friend_tip_center);
            this.ekb = (Button) this.ejW.findViewById(d.g.add_friend_tip_button);
            this.ekb.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.ejW.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dPN != null) {
            ak.c(this.dPN, d.C0126d.cp_cont_b, 1);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.ekc);
        }
    }

    private void aHz() {
        if (this.mTool != null) {
            this.mTool.DO();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.ejW.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                aHA();
                return;
            case WAIT:
                hB(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                j(z, str);
                return;
            case PASS:
                hC(z);
                return;
            default:
                return;
        }
    }

    private void aHA() {
        this.ejW.setVisibility(8);
        this.ejX.setVisibility(0);
        this.eka.setVisibility(8);
        this.ejY.setText(d.k.add_friend_title);
        this.ejZ.setText(d.k.add_friend_content);
        this.ekb.setText(d.k.add_friend_button);
    }

    private void hB(boolean z) {
        if (this.ejV.aHv().aIh() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.eka.startAnimation(translateAnimation);
                }
            });
            this.eka.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.eka.setVisibility(0);
                    PersonalChatView.this.eka.setAnimation(translateAnimation3);
                }
            });
            this.ejX.setVisibility(8);
            this.ejX.startAnimation(translateAnimation4);
        } else {
            this.ejX.setVisibility(8);
            this.eka.setVisibility(0);
        }
        this.eka.setText(d.k.add_friend_wait);
        this.ekb.setText(d.k.add_friend_button);
    }

    private void j(boolean z, final String str) {
        final String userName = this.ejV.aHv().getUser().getUserName();
        this.eka.setVisibility(8);
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
                    PersonalChatView.this.ejX.clearAnimation();
                    PersonalChatView.this.ejY.setText(PersonalChatView.this.ejV.getResources().getString(d.k.add_friend_agree_title, userName));
                    PersonalChatView.this.ejZ.setText(str);
                    PersonalChatView.this.ejX.setAnimation(translateAnimation);
                }
            });
            this.ejX.setVisibility(0);
            this.ejX.startAnimation(translateAnimation2);
        } else {
            this.ejX.setVisibility(0);
            this.ejY.setText(this.ejV.getResources().getString(d.k.add_friend_agree_title, userName));
            this.ejZ.setText(str);
        }
        this.ekb.setText(d.k.add_friend_agree_button);
    }

    private void hC(boolean z) {
        aHz();
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
                    PersonalChatView.this.ejW.setVisibility(8);
                }
            });
            this.ejW.startAnimation(translateAnimation);
            return;
        }
        this.ejW.setVisibility(8);
    }

    public Button aHB() {
        return this.ekb;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
