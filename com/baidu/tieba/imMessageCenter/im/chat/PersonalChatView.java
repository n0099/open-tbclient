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
    private TextView dPQ;
    private PersonalChatActivity ejY;
    private LinearLayout ejZ;
    private LinearLayout eka;
    private TextView ekb;
    private TextView ekc;
    private TextView ekd;
    private Button eke;
    private View.OnClickListener ekf;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.ekf = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PersonalChatView.this.ejY.showToast(d.k.add_friend_cannot_send);
            }
        };
        if (!this.ejY.aHx() && this.mTool != null) {
            b(this.mTool.eF(6));
            b(this.mTool.eF(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.ejY = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.k.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.personal_info_btn, talkableActivity);
            this.dPQ = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.dPQ.setText(string);
        }
        if (!this.ejY.aHx()) {
            this.ejZ = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.stranger_person_add_friend_stub)).inflate();
            this.eka = (LinearLayout) this.ejZ.findViewById(d.g.add_friend_tip_full);
            this.ekb = (TextView) this.ejZ.findViewById(d.g.add_friend_tip_title);
            this.ekc = (TextView) this.ejZ.findViewById(d.g.add_friend_tip_content);
            this.ekd = (TextView) this.ejZ.findViewById(d.g.add_friend_tip_center);
            this.eke = (Button) this.ejZ.findViewById(d.g.add_friend_tip_button);
            this.eke.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.ejZ.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dPQ != null) {
            ak.c(this.dPQ, d.C0126d.cp_cont_b, 1);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.ekf);
        }
    }

    private void aHz() {
        if (this.mTool != null) {
            this.mTool.DO();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.ejZ.setVisibility(0);
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
        this.ejZ.setVisibility(8);
        this.eka.setVisibility(0);
        this.ekd.setVisibility(8);
        this.ekb.setText(d.k.add_friend_title);
        this.ekc.setText(d.k.add_friend_content);
        this.eke.setText(d.k.add_friend_button);
    }

    private void hB(boolean z) {
        if (this.ejY.aHv().aIh() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.ekd.startAnimation(translateAnimation);
                }
            });
            this.ekd.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.ekd.setVisibility(0);
                    PersonalChatView.this.ekd.setAnimation(translateAnimation3);
                }
            });
            this.eka.setVisibility(8);
            this.eka.startAnimation(translateAnimation4);
        } else {
            this.eka.setVisibility(8);
            this.ekd.setVisibility(0);
        }
        this.ekd.setText(d.k.add_friend_wait);
        this.eke.setText(d.k.add_friend_button);
    }

    private void j(boolean z, final String str) {
        final String userName = this.ejY.aHv().getUser().getUserName();
        this.ekd.setVisibility(8);
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
                    PersonalChatView.this.eka.clearAnimation();
                    PersonalChatView.this.ekb.setText(PersonalChatView.this.ejY.getResources().getString(d.k.add_friend_agree_title, userName));
                    PersonalChatView.this.ekc.setText(str);
                    PersonalChatView.this.eka.setAnimation(translateAnimation);
                }
            });
            this.eka.setVisibility(0);
            this.eka.startAnimation(translateAnimation2);
        } else {
            this.eka.setVisibility(0);
            this.ekb.setText(this.ejY.getResources().getString(d.k.add_friend_agree_title, userName));
            this.ekc.setText(str);
        }
        this.eke.setText(d.k.add_friend_agree_button);
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
                    PersonalChatView.this.ejZ.setVisibility(8);
                }
            });
            this.ejZ.startAnimation(translateAnimation);
            return;
        }
        this.ejZ.setVisibility(8);
    }

    public Button aHB() {
        return this.eke;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
