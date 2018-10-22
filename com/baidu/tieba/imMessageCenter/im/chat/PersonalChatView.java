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
    private PersonalChatActivity eSX;
    private LinearLayout eSY;
    private LinearLayout eSZ;
    private TextView eTa;
    private TextView eTb;
    private TextView eTc;
    private Button eTd;
    private View.OnClickListener eTe;
    private TextView eyX;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.eTe = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.eSX.showToast(e.j.add_friend_cannot_send);
            }
        };
        if (!this.eSX.aTw() && this.mTool != null) {
            b(this.mTool.ff(6));
            b(this.mTool.ff(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.eSX = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(e.j.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.personal_info_btn, talkableActivity);
            this.eyX = (TextView) this.mBtnGroupInfo.findViewById(e.g.group_info_btn_txt);
            this.eyX.setText(string);
        }
        if (!this.eSX.aTw()) {
            this.eSY = (LinearLayout) ((ViewStub) talkableActivity.findViewById(e.g.stranger_person_add_friend_stub)).inflate();
            this.eSZ = (LinearLayout) this.eSY.findViewById(e.g.add_friend_tip_full);
            this.eTa = (TextView) this.eSY.findViewById(e.g.add_friend_tip_title);
            this.eTb = (TextView) this.eSY.findViewById(e.g.add_friend_tip_content);
            this.eTc = (TextView) this.eSY.findViewById(e.g.add_friend_tip_center);
            this.eTd = (Button) this.eSY.findViewById(e.g.add_friend_tip_button);
            this.eTd.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.eSY.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eyX != null) {
            al.c(this.eyX, e.d.cp_cont_b, 1);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.eTe);
        }
    }

    private void aTy() {
        if (this.mTool != null) {
            this.mTool.KQ();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.eSY.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                aTz();
                return;
            case WAIT:
                iL(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                j(z, str);
                return;
            case PASS:
                iM(z);
                return;
            default:
                return;
        }
    }

    private void aTz() {
        this.eSY.setVisibility(8);
        this.eSZ.setVisibility(0);
        this.eTc.setVisibility(8);
        this.eTa.setText(e.j.add_friend_title);
        this.eTb.setText(e.j.add_friend_content);
        this.eTd.setText(e.j.add_friend_button);
    }

    private void iL(boolean z) {
        if (this.eSX.aTu().aUg() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.eTc.startAnimation(translateAnimation);
                }
            });
            this.eTc.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.eTc.setVisibility(0);
                    PersonalChatView.this.eTc.setAnimation(translateAnimation3);
                }
            });
            this.eSZ.setVisibility(8);
            this.eSZ.startAnimation(translateAnimation4);
        } else {
            this.eSZ.setVisibility(8);
            this.eTc.setVisibility(0);
        }
        this.eTc.setText(e.j.add_friend_wait);
        this.eTd.setText(e.j.add_friend_button);
    }

    private void j(boolean z, final String str) {
        final String name_show = this.eSX.aTu().getUser().getName_show();
        this.eTc.setVisibility(8);
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
                    PersonalChatView.this.eSZ.clearAnimation();
                    PersonalChatView.this.eTa.setText(PersonalChatView.this.eSX.getResources().getString(e.j.add_friend_agree_title, name_show));
                    PersonalChatView.this.eTb.setText(str);
                    PersonalChatView.this.eSZ.setAnimation(translateAnimation);
                }
            });
            this.eSZ.setVisibility(0);
            this.eSZ.startAnimation(translateAnimation2);
        } else {
            this.eSZ.setVisibility(0);
            this.eTa.setText(this.eSX.getResources().getString(e.j.add_friend_agree_title, name_show));
            this.eTb.setText(str);
        }
        this.eTd.setText(e.j.add_friend_agree_button);
    }

    private void iM(boolean z) {
        aTy();
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
                    PersonalChatView.this.eSY.setVisibility(8);
                }
            });
            this.eSY.startAnimation(translateAnimation);
            return;
        }
        this.eSY.setVisibility(8);
    }

    public Button aTA() {
        return this.eTd;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
