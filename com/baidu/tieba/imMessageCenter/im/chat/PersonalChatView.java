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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.g;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes4.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private PersonalChatActivity gSV;
    private LinearLayout gSW;
    private LinearLayout gSX;
    private TextView gSY;
    private TextView gSZ;
    private TextView gTa;
    private Button gTb;
    private View.OnClickListener gTc;
    private TextView gyU;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.gTc = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.gSV.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.gSV.bHh() && this.mTool != null) {
            b(this.mTool.kn(6));
            b(this.mTool.kn(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.gSV = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.gyU = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.gyU.setText(string);
        }
        if (!this.gSV.bHh()) {
            this.gSW = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.gSX = (LinearLayout) this.gSW.findViewById(R.id.add_friend_tip_full);
            this.gSY = (TextView) this.gSW.findViewById(R.id.add_friend_tip_title);
            this.gSZ = (TextView) this.gSW.findViewById(R.id.add_friend_tip_content);
            this.gTa = (TextView) this.gSW.findViewById(R.id.add_friend_tip_center);
            this.gTb = (Button) this.gSW.findViewById(R.id.add_friend_tip_button);
            this.gTb.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.gSW.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gyU != null) {
            am.f(this.gyU, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.gTc);
        }
    }

    private void bHj() {
        if (this.mTool != null) {
            this.mTool.ask();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.gSW.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                bHk();
                return;
            case WAIT:
                mE(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                n(z, str);
                return;
            case PASS:
                mF(z);
                return;
            default:
                return;
        }
    }

    private void bHk() {
        this.gSW.setVisibility(8);
        this.gSX.setVisibility(0);
        this.gTa.setVisibility(8);
        this.gSY.setText(R.string.add_friend_title);
        this.gSZ.setText(R.string.add_friend_content);
        this.gTb.setText(R.string.add_friend_button);
    }

    private void mE(boolean z) {
        if (this.gSV.bHf().bHQ() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.gTa.startAnimation(translateAnimation);
                }
            });
            this.gTa.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.gTa.setVisibility(0);
                    PersonalChatView.this.gTa.setAnimation(translateAnimation3);
                }
            });
            this.gSX.setVisibility(8);
            this.gSX.startAnimation(translateAnimation4);
        } else {
            this.gSX.setVisibility(8);
            this.gTa.setVisibility(0);
        }
        this.gTa.setText(R.string.add_friend_wait);
        this.gTb.setText(R.string.add_friend_button);
    }

    private void n(boolean z, final String str) {
        final String name_show = this.gSV.bHf().getUser().getName_show();
        this.gTa.setVisibility(8);
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
                    PersonalChatView.this.gSX.clearAnimation();
                    PersonalChatView.this.gSY.setText(PersonalChatView.this.gSV.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.gSZ.setText(str);
                    PersonalChatView.this.gSX.setAnimation(translateAnimation);
                }
            });
            this.gSX.setVisibility(0);
            this.gSX.startAnimation(translateAnimation2);
        } else {
            this.gSX.setVisibility(0);
            this.gSY.setText(this.gSV.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.gSZ.setText(str);
        }
        this.gTb.setText(R.string.add_friend_agree_button);
    }

    private void mF(boolean z) {
        bHj();
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
                    PersonalChatView.this.gSW.setVisibility(8);
                }
            });
            this.gSW.startAnimation(translateAnimation);
            return;
        }
        this.gSW.setVisibility(8);
    }

    public Button bHl() {
        return this.gTb;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
