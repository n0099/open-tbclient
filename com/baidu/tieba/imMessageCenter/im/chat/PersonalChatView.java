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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.h;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes21.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private PersonalChatActivity jJM;
    private LinearLayout jJN;
    private LinearLayout jJO;
    private TextView jJP;
    private TextView jJQ;
    private TextView jJR;
    private Button jJS;
    private View.OnClickListener jJT;
    private TextView jnC;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.jJT = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.jJM.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.jJM.cMr() && this.mTool != null) {
            b(this.mTool.qo(6));
            b(this.mTool.qo(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.jJM = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.jnC = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.jnC.setText(string);
        }
        if (!this.jJM.cMr()) {
            this.jJN = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.jJO = (LinearLayout) this.jJN.findViewById(R.id.add_friend_tip_full);
            this.jJP = (TextView) this.jJN.findViewById(R.id.add_friend_tip_title);
            this.jJQ = (TextView) this.jJN.findViewById(R.id.add_friend_tip_content);
            this.jJR = (TextView) this.jJN.findViewById(R.id.add_friend_tip_center);
            this.jJS = (Button) this.jJN.findViewById(R.id.add_friend_tip_button);
            this.jJS.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.jJN.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jnC != null) {
            ap.setViewTextColor(this.jnC, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(h hVar) {
        if (hVar != null && hVar != null && (hVar instanceof View)) {
            ((View) hVar).setOnClickListener(this.jJT);
        }
    }

    private void cMu() {
        if (this.mTool != null) {
            this.mTool.bsH();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.jJN.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                cMv();
                return;
            case WAIT:
                rk(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                s(z, str);
                return;
            case PASS:
                rl(z);
                return;
            default:
                return;
        }
    }

    private void cMv() {
        this.jJN.setVisibility(8);
        this.jJO.setVisibility(0);
        this.jJR.setVisibility(8);
        this.jJP.setText(R.string.add_friend_title);
        this.jJQ.setText(R.string.add_friend_content);
        this.jJS.setText(R.string.add_friend_button);
    }

    private void rk(boolean z) {
        if (this.jJM.cMp().cNb() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.jJR.startAnimation(translateAnimation);
                }
            });
            this.jJR.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.jJR.setVisibility(0);
                    PersonalChatView.this.jJR.setAnimation(translateAnimation3);
                }
            });
            this.jJO.setVisibility(8);
            this.jJO.startAnimation(translateAnimation4);
        } else {
            this.jJO.setVisibility(8);
            this.jJR.setVisibility(0);
        }
        this.jJR.setText(R.string.add_friend_wait);
        this.jJS.setText(R.string.add_friend_button);
    }

    private void s(boolean z, final String str) {
        final String name_show = this.jJM.cMp().getUser().getName_show();
        this.jJR.setVisibility(8);
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
                    PersonalChatView.this.jJO.clearAnimation();
                    PersonalChatView.this.jJP.setText(PersonalChatView.this.jJM.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.jJQ.setText(str);
                    PersonalChatView.this.jJO.setAnimation(translateAnimation);
                }
            });
            this.jJO.setVisibility(0);
            this.jJO.startAnimation(translateAnimation2);
        } else {
            this.jJO.setVisibility(0);
            this.jJP.setText(this.jJM.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.jJQ.setText(str);
        }
        this.jJS.setText(R.string.add_friend_agree_button);
    }

    private void rl(boolean z) {
        cMu();
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
                    PersonalChatView.this.jJN.setVisibility(8);
                }
            });
            this.jJN.startAnimation(translateAnimation);
            return;
        }
        this.jJN.setVisibility(8);
    }

    public Button cMw() {
        return this.jJS;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
