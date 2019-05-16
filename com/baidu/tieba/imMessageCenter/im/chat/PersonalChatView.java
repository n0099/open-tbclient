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
    private PersonalChatActivity gLQ;
    private LinearLayout gLR;
    private LinearLayout gLS;
    private TextView gLT;
    private TextView gLU;
    private TextView gLV;
    private Button gLW;
    private View.OnClickListener gLX;
    private TextView grO;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.gLX = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.gLQ.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.gLQ.bEi() && this.mTool != null) {
            b(this.mTool.kg(6));
            b(this.mTool.kg(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.gLQ = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.grO = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.grO.setText(string);
        }
        if (!this.gLQ.bEi()) {
            this.gLR = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.gLS = (LinearLayout) this.gLR.findViewById(R.id.add_friend_tip_full);
            this.gLT = (TextView) this.gLR.findViewById(R.id.add_friend_tip_title);
            this.gLU = (TextView) this.gLR.findViewById(R.id.add_friend_tip_content);
            this.gLV = (TextView) this.gLR.findViewById(R.id.add_friend_tip_center);
            this.gLW = (Button) this.gLR.findViewById(R.id.add_friend_tip_button);
            this.gLW.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.gLR.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.grO != null) {
            al.f(this.grO, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.gLX);
        }
    }

    private void bEk() {
        if (this.mTool != null) {
            this.mTool.arc();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.gLR.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                bEl();
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

    private void bEl() {
        this.gLR.setVisibility(8);
        this.gLS.setVisibility(0);
        this.gLV.setVisibility(8);
        this.gLT.setText(R.string.add_friend_title);
        this.gLU.setText(R.string.add_friend_content);
        this.gLW.setText(R.string.add_friend_button);
    }

    private void mp(boolean z) {
        if (this.gLQ.bEg().bER() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.gLV.startAnimation(translateAnimation);
                }
            });
            this.gLV.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.gLV.setVisibility(0);
                    PersonalChatView.this.gLV.setAnimation(translateAnimation3);
                }
            });
            this.gLS.setVisibility(8);
            this.gLS.startAnimation(translateAnimation4);
        } else {
            this.gLS.setVisibility(8);
            this.gLV.setVisibility(0);
        }
        this.gLV.setText(R.string.add_friend_wait);
        this.gLW.setText(R.string.add_friend_button);
    }

    private void m(boolean z, final String str) {
        final String name_show = this.gLQ.bEg().getUser().getName_show();
        this.gLV.setVisibility(8);
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
                    PersonalChatView.this.gLS.clearAnimation();
                    PersonalChatView.this.gLT.setText(PersonalChatView.this.gLQ.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.gLU.setText(str);
                    PersonalChatView.this.gLS.setAnimation(translateAnimation);
                }
            });
            this.gLS.setVisibility(0);
            this.gLS.startAnimation(translateAnimation2);
        } else {
            this.gLS.setVisibility(0);
            this.gLT.setText(this.gLQ.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.gLU.setText(str);
        }
        this.gLW.setText(R.string.add_friend_agree_button);
    }

    private void mq(boolean z) {
        bEk();
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
                    PersonalChatView.this.gLR.setVisibility(8);
                }
            });
            this.gLR.startAnimation(translateAnimation);
            return;
        }
        this.gLR.setVisibility(8);
    }

    public Button bEm() {
        return this.gLW;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
