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
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes4.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private PersonalChatActivity gLR;
    private LinearLayout gLS;
    private LinearLayout gLT;
    private TextView gLU;
    private TextView gLV;
    private TextView gLW;
    private Button gLX;
    private View.OnClickListener gLY;
    private TextView grP;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.gLY = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.gLR.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.gLR.bEl() && this.mTool != null) {
            b(this.mTool.kg(6));
            b(this.mTool.kg(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.gLR = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.grP = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.grP.setText(string);
        }
        if (!this.gLR.bEl()) {
            this.gLS = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.gLT = (LinearLayout) this.gLS.findViewById(R.id.add_friend_tip_full);
            this.gLU = (TextView) this.gLS.findViewById(R.id.add_friend_tip_title);
            this.gLV = (TextView) this.gLS.findViewById(R.id.add_friend_tip_content);
            this.gLW = (TextView) this.gLS.findViewById(R.id.add_friend_tip_center);
            this.gLX = (Button) this.gLS.findViewById(R.id.add_friend_tip_button);
            this.gLX.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.gLS.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.grP != null) {
            al.f(this.grP, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.gLY);
        }
    }

    private void bEn() {
        if (this.mTool != null) {
            this.mTool.arc();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.gLS.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                bEo();
                return;
            case WAIT:
                mp(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                m(z, str);
                return;
            case PASS:
                mq(z);
                return;
            default:
                return;
        }
    }

    private void bEo() {
        this.gLS.setVisibility(8);
        this.gLT.setVisibility(0);
        this.gLW.setVisibility(8);
        this.gLU.setText(R.string.add_friend_title);
        this.gLV.setText(R.string.add_friend_content);
        this.gLX.setText(R.string.add_friend_button);
    }

    private void mp(boolean z) {
        if (this.gLR.bEj().bEU() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.gLW.startAnimation(translateAnimation);
                }
            });
            this.gLW.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.gLW.setVisibility(0);
                    PersonalChatView.this.gLW.setAnimation(translateAnimation3);
                }
            });
            this.gLT.setVisibility(8);
            this.gLT.startAnimation(translateAnimation4);
        } else {
            this.gLT.setVisibility(8);
            this.gLW.setVisibility(0);
        }
        this.gLW.setText(R.string.add_friend_wait);
        this.gLX.setText(R.string.add_friend_button);
    }

    private void m(boolean z, final String str) {
        final String name_show = this.gLR.bEj().getUser().getName_show();
        this.gLW.setVisibility(8);
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
                    PersonalChatView.this.gLT.clearAnimation();
                    PersonalChatView.this.gLU.setText(PersonalChatView.this.gLR.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.gLV.setText(str);
                    PersonalChatView.this.gLT.setAnimation(translateAnimation);
                }
            });
            this.gLT.setVisibility(0);
            this.gLT.startAnimation(translateAnimation2);
        } else {
            this.gLT.setVisibility(0);
            this.gLU.setText(this.gLR.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.gLV.setText(str);
        }
        this.gLX.setText(R.string.add_friend_agree_button);
    }

    private void mq(boolean z) {
        bEn();
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
                    PersonalChatView.this.gLS.setVisibility(8);
                }
            });
            this.gLS.startAnimation(translateAnimation);
            return;
        }
        this.gLS.setVisibility(8);
    }

    public Button bEp() {
        return this.gLX;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
