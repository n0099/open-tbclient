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
    private PersonalChatActivity gLT;
    private LinearLayout gLU;
    private LinearLayout gLV;
    private TextView gLW;
    private TextView gLX;
    private TextView gLY;
    private Button gLZ;
    private View.OnClickListener gMa;
    private TextView grR;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.gMa = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.gLT.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.gLT.bEm() && this.mTool != null) {
            b(this.mTool.kg(6));
            b(this.mTool.kg(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.gLT = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.grR = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.grR.setText(string);
        }
        if (!this.gLT.bEm()) {
            this.gLU = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.gLV = (LinearLayout) this.gLU.findViewById(R.id.add_friend_tip_full);
            this.gLW = (TextView) this.gLU.findViewById(R.id.add_friend_tip_title);
            this.gLX = (TextView) this.gLU.findViewById(R.id.add_friend_tip_content);
            this.gLY = (TextView) this.gLU.findViewById(R.id.add_friend_tip_center);
            this.gLZ = (Button) this.gLU.findViewById(R.id.add_friend_tip_button);
            this.gLZ.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.gLU.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.grR != null) {
            al.f(this.grR, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.gMa);
        }
    }

    private void bEo() {
        if (this.mTool != null) {
            this.mTool.arc();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.gLU.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                bEp();
                return;
            case WAIT:
                mq(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                m(z, str);
                return;
            case PASS:
                mr(z);
                return;
            default:
                return;
        }
    }

    private void bEp() {
        this.gLU.setVisibility(8);
        this.gLV.setVisibility(0);
        this.gLY.setVisibility(8);
        this.gLW.setText(R.string.add_friend_title);
        this.gLX.setText(R.string.add_friend_content);
        this.gLZ.setText(R.string.add_friend_button);
    }

    private void mq(boolean z) {
        if (this.gLT.bEk().bEV() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.gLY.startAnimation(translateAnimation);
                }
            });
            this.gLY.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.gLY.setVisibility(0);
                    PersonalChatView.this.gLY.setAnimation(translateAnimation3);
                }
            });
            this.gLV.setVisibility(8);
            this.gLV.startAnimation(translateAnimation4);
        } else {
            this.gLV.setVisibility(8);
            this.gLY.setVisibility(0);
        }
        this.gLY.setText(R.string.add_friend_wait);
        this.gLZ.setText(R.string.add_friend_button);
    }

    private void m(boolean z, final String str) {
        final String name_show = this.gLT.bEk().getUser().getName_show();
        this.gLY.setVisibility(8);
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
                    PersonalChatView.this.gLV.clearAnimation();
                    PersonalChatView.this.gLW.setText(PersonalChatView.this.gLT.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.gLX.setText(str);
                    PersonalChatView.this.gLV.setAnimation(translateAnimation);
                }
            });
            this.gLV.setVisibility(0);
            this.gLV.startAnimation(translateAnimation2);
        } else {
            this.gLV.setVisibility(0);
            this.gLW.setText(this.gLT.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.gLX.setText(str);
        }
        this.gLZ.setText(R.string.add_friend_agree_button);
    }

    private void mr(boolean z) {
        bEo();
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
                    PersonalChatView.this.gLU.setVisibility(8);
                }
            });
            this.gLU.startAnimation(translateAnimation);
            return;
        }
        this.gLU.setVisibility(8);
    }

    public Button bEq() {
        return this.gLZ;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
