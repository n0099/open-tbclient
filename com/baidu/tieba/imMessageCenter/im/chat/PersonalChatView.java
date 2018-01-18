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
    private PersonalChatActivity eKI;
    private LinearLayout eKJ;
    private LinearLayout eKK;
    private TextView eKL;
    private TextView eKM;
    private TextView eKN;
    private Button eKO;
    private View.OnClickListener eKP;
    private TextView eqA;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.eKP = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.eKI.showToast(d.j.add_friend_cannot_send);
            }
        };
        if (!this.eKI.aKQ() && this.mTool != null) {
            b(this.mTool.hH(6));
            b(this.mTool.hH(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.eKI = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.j.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.personal_info_btn, talkableActivity);
            this.eqA = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.eqA.setText(string);
        }
        if (!this.eKI.aKQ()) {
            this.eKJ = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.stranger_person_add_friend_stub)).inflate();
            this.eKK = (LinearLayout) this.eKJ.findViewById(d.g.add_friend_tip_full);
            this.eKL = (TextView) this.eKJ.findViewById(d.g.add_friend_tip_title);
            this.eKM = (TextView) this.eKJ.findViewById(d.g.add_friend_tip_content);
            this.eKN = (TextView) this.eKJ.findViewById(d.g.add_friend_tip_center);
            this.eKO = (Button) this.eKJ.findViewById(d.g.add_friend_tip_button);
            this.eKO.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.eKJ.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eqA != null) {
            aj.e(this.eqA, d.C0107d.cp_cont_b, 1);
        }
    }

    private void b(l lVar) {
        if (lVar != null && lVar != null && (lVar instanceof View)) {
            ((View) lVar).setOnClickListener(this.eKP);
        }
    }

    private void aKS() {
        if (this.mTool != null) {
            this.mTool.KD();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.eKJ.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                aKT();
                return;
            case WAIT:
                hJ(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                h(z, str);
                return;
            case PASS:
                hK(z);
                return;
            default:
                return;
        }
    }

    private void aKT() {
        this.eKJ.setVisibility(8);
        this.eKK.setVisibility(0);
        this.eKN.setVisibility(8);
        this.eKL.setText(d.j.add_friend_title);
        this.eKM.setText(d.j.add_friend_content);
        this.eKO.setText(d.j.add_friend_button);
    }

    private void hJ(boolean z) {
        if (this.eKI.aKO().aLF() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.eKN.startAnimation(translateAnimation);
                }
            });
            this.eKN.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.eKN.setVisibility(0);
                    PersonalChatView.this.eKN.setAnimation(translateAnimation3);
                }
            });
            this.eKK.setVisibility(8);
            this.eKK.startAnimation(translateAnimation4);
        } else {
            this.eKK.setVisibility(8);
            this.eKN.setVisibility(0);
        }
        this.eKN.setText(d.j.add_friend_wait);
        this.eKO.setText(d.j.add_friend_button);
    }

    private void h(boolean z, final String str) {
        final String userName = this.eKI.aKO().getUser().getUserName();
        this.eKN.setVisibility(8);
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
                    PersonalChatView.this.eKK.clearAnimation();
                    PersonalChatView.this.eKL.setText(PersonalChatView.this.eKI.getResources().getString(d.j.add_friend_agree_title, userName));
                    PersonalChatView.this.eKM.setText(str);
                    PersonalChatView.this.eKK.setAnimation(translateAnimation);
                }
            });
            this.eKK.setVisibility(0);
            this.eKK.startAnimation(translateAnimation2);
        } else {
            this.eKK.setVisibility(0);
            this.eKL.setText(this.eKI.getResources().getString(d.j.add_friend_agree_title, userName));
            this.eKM.setText(str);
        }
        this.eKO.setText(d.j.add_friend_agree_button);
    }

    private void hK(boolean z) {
        aKS();
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
                    PersonalChatView.this.eKJ.setVisibility(8);
                }
            });
            this.eKJ.startAnimation(translateAnimation);
            return;
        }
        this.eKJ.setVisibility(8);
    }

    public Button aKU() {
        return this.eKO;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
