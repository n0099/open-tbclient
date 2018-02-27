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
    private PersonalChatActivity ePg;
    private LinearLayout ePh;
    private LinearLayout ePi;
    private TextView ePj;
    private TextView ePk;
    private TextView ePl;
    private Button ePm;
    private View.OnClickListener ePn;
    private TextView euU;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.ePn = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.ePg.showToast(d.j.add_friend_cannot_send);
            }
        };
        if (!this.ePg.aMw() && this.mTool != null) {
            b(this.mTool.hG(6));
            b(this.mTool.hG(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.ePg = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.j.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.personal_info_btn, talkableActivity);
            this.euU = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.euU.setText(string);
        }
        if (!this.ePg.aMw()) {
            this.ePh = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.stranger_person_add_friend_stub)).inflate();
            this.ePi = (LinearLayout) this.ePh.findViewById(d.g.add_friend_tip_full);
            this.ePj = (TextView) this.ePh.findViewById(d.g.add_friend_tip_title);
            this.ePk = (TextView) this.ePh.findViewById(d.g.add_friend_tip_content);
            this.ePl = (TextView) this.ePh.findViewById(d.g.add_friend_tip_center);
            this.ePm = (Button) this.ePh.findViewById(d.g.add_friend_tip_button);
            this.ePm.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.ePh.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.euU != null) {
            aj.e(this.euU, d.C0141d.cp_cont_b, 1);
        }
    }

    private void b(l lVar) {
        if (lVar != null && lVar != null && (lVar instanceof View)) {
            ((View) lVar).setOnClickListener(this.ePn);
        }
    }

    private void aMy() {
        if (this.mTool != null) {
            this.mTool.Lk();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.ePh.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                aMz();
                return;
            case WAIT:
                hW(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                h(z, str);
                return;
            case PASS:
                hX(z);
                return;
            default:
                return;
        }
    }

    private void aMz() {
        this.ePh.setVisibility(8);
        this.ePi.setVisibility(0);
        this.ePl.setVisibility(8);
        this.ePj.setText(d.j.add_friend_title);
        this.ePk.setText(d.j.add_friend_content);
        this.ePm.setText(d.j.add_friend_button);
    }

    private void hW(boolean z) {
        if (this.ePg.aMu().aNl() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.ePl.startAnimation(translateAnimation);
                }
            });
            this.ePl.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.ePl.setVisibility(0);
                    PersonalChatView.this.ePl.setAnimation(translateAnimation3);
                }
            });
            this.ePi.setVisibility(8);
            this.ePi.startAnimation(translateAnimation4);
        } else {
            this.ePi.setVisibility(8);
            this.ePl.setVisibility(0);
        }
        this.ePl.setText(d.j.add_friend_wait);
        this.ePm.setText(d.j.add_friend_button);
    }

    private void h(boolean z, final String str) {
        final String userName = this.ePg.aMu().getUser().getUserName();
        this.ePl.setVisibility(8);
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
                    PersonalChatView.this.ePi.clearAnimation();
                    PersonalChatView.this.ePj.setText(PersonalChatView.this.ePg.getResources().getString(d.j.add_friend_agree_title, userName));
                    PersonalChatView.this.ePk.setText(str);
                    PersonalChatView.this.ePi.setAnimation(translateAnimation);
                }
            });
            this.ePi.setVisibility(0);
            this.ePi.startAnimation(translateAnimation2);
        } else {
            this.ePi.setVisibility(0);
            this.ePj.setText(this.ePg.getResources().getString(d.j.add_friend_agree_title, userName));
            this.ePk.setText(str);
        }
        this.ePm.setText(d.j.add_friend_agree_button);
    }

    private void hX(boolean z) {
        aMy();
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
                    PersonalChatView.this.ePh.setVisibility(8);
                }
            });
            this.ePh.startAnimation(translateAnimation);
            return;
        }
        this.ePh.setVisibility(8);
    }

    public Button aMA() {
        return this.ePm;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
