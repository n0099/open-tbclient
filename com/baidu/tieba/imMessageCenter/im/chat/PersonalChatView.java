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
    private TextView ePA;
    private Button ePB;
    private View.OnClickListener ePC;
    private PersonalChatActivity ePv;
    private LinearLayout ePw;
    private LinearLayout ePx;
    private TextView ePy;
    private TextView ePz;
    private TextView evk;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.ePC = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.ePv.showToast(d.j.add_friend_cannot_send);
            }
        };
        if (!this.ePv.aMx() && this.mTool != null) {
            b(this.mTool.hG(6));
            b(this.mTool.hG(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.ePv = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.j.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.personal_info_btn, talkableActivity);
            this.evk = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.evk.setText(string);
        }
        if (!this.ePv.aMx()) {
            this.ePw = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.stranger_person_add_friend_stub)).inflate();
            this.ePx = (LinearLayout) this.ePw.findViewById(d.g.add_friend_tip_full);
            this.ePy = (TextView) this.ePw.findViewById(d.g.add_friend_tip_title);
            this.ePz = (TextView) this.ePw.findViewById(d.g.add_friend_tip_content);
            this.ePA = (TextView) this.ePw.findViewById(d.g.add_friend_tip_center);
            this.ePB = (Button) this.ePw.findViewById(d.g.add_friend_tip_button);
            this.ePB.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.ePw.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.evk != null) {
            aj.e(this.evk, d.C0141d.cp_cont_b, 1);
        }
    }

    private void b(l lVar) {
        if (lVar != null && lVar != null && (lVar instanceof View)) {
            ((View) lVar).setOnClickListener(this.ePC);
        }
    }

    private void aMz() {
        if (this.mTool != null) {
            this.mTool.Ll();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.ePw.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                aMA();
                return;
            case WAIT:
                ib(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                h(z, str);
                return;
            case PASS:
                ic(z);
                return;
            default:
                return;
        }
    }

    private void aMA() {
        this.ePw.setVisibility(8);
        this.ePx.setVisibility(0);
        this.ePA.setVisibility(8);
        this.ePy.setText(d.j.add_friend_title);
        this.ePz.setText(d.j.add_friend_content);
        this.ePB.setText(d.j.add_friend_button);
    }

    private void ib(boolean z) {
        if (this.ePv.aMv().aNm() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.ePA.startAnimation(translateAnimation);
                }
            });
            this.ePA.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.ePA.setVisibility(0);
                    PersonalChatView.this.ePA.setAnimation(translateAnimation3);
                }
            });
            this.ePx.setVisibility(8);
            this.ePx.startAnimation(translateAnimation4);
        } else {
            this.ePx.setVisibility(8);
            this.ePA.setVisibility(0);
        }
        this.ePA.setText(d.j.add_friend_wait);
        this.ePB.setText(d.j.add_friend_button);
    }

    private void h(boolean z, final String str) {
        final String userName = this.ePv.aMv().getUser().getUserName();
        this.ePA.setVisibility(8);
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
                    PersonalChatView.this.ePx.clearAnimation();
                    PersonalChatView.this.ePy.setText(PersonalChatView.this.ePv.getResources().getString(d.j.add_friend_agree_title, userName));
                    PersonalChatView.this.ePz.setText(str);
                    PersonalChatView.this.ePx.setAnimation(translateAnimation);
                }
            });
            this.ePx.setVisibility(0);
            this.ePx.startAnimation(translateAnimation2);
        } else {
            this.ePx.setVisibility(0);
            this.ePy.setText(this.ePv.getResources().getString(d.j.add_friend_agree_title, userName));
            this.ePz.setText(str);
        }
        this.ePB.setText(d.j.add_friend_agree_button);
    }

    private void ic(boolean z) {
        aMz();
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
                    PersonalChatView.this.ePw.setVisibility(8);
                }
            });
            this.ePw.startAnimation(translateAnimation);
            return;
        }
        this.ePw.setVisibility(8);
    }

    public Button aMB() {
        return this.ePB;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
