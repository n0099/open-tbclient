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
    private PersonalChatActivity gRX;
    private LinearLayout gRY;
    private LinearLayout gRZ;
    private TextView gSa;
    private TextView gSb;
    private TextView gSc;
    private Button gSd;
    private View.OnClickListener gSe;
    private TextView gxS;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.gSe = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.gRX.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.gRX.bEE() && this.mTool != null) {
            b(this.mTool.jH(6));
            b(this.mTool.jH(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.gRX = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.gxS = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.gxS.setText(string);
        }
        if (!this.gRX.bEE()) {
            this.gRY = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.gRZ = (LinearLayout) this.gRY.findViewById(R.id.add_friend_tip_full);
            this.gSa = (TextView) this.gRY.findViewById(R.id.add_friend_tip_title);
            this.gSb = (TextView) this.gRY.findViewById(R.id.add_friend_tip_content);
            this.gSc = (TextView) this.gRY.findViewById(R.id.add_friend_tip_center);
            this.gSd = (Button) this.gRY.findViewById(R.id.add_friend_tip_button);
            this.gSd.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.gRY.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gxS != null) {
            am.setViewTextColor(this.gxS, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.gSe);
        }
    }

    private void bEG() {
        if (this.mTool != null) {
            this.mTool.aug();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.gRY.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                bEH();
                return;
            case WAIT:
                mv(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                n(z, str);
                return;
            case PASS:
                mw(z);
                return;
            default:
                return;
        }
    }

    private void bEH() {
        this.gRY.setVisibility(8);
        this.gRZ.setVisibility(0);
        this.gSc.setVisibility(8);
        this.gSa.setText(R.string.add_friend_title);
        this.gSb.setText(R.string.add_friend_content);
        this.gSd.setText(R.string.add_friend_button);
    }

    private void mv(boolean z) {
        if (this.gRX.bEC().bFm() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.gSc.startAnimation(translateAnimation);
                }
            });
            this.gSc.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.gSc.setVisibility(0);
                    PersonalChatView.this.gSc.setAnimation(translateAnimation3);
                }
            });
            this.gRZ.setVisibility(8);
            this.gRZ.startAnimation(translateAnimation4);
        } else {
            this.gRZ.setVisibility(8);
            this.gSc.setVisibility(0);
        }
        this.gSc.setText(R.string.add_friend_wait);
        this.gSd.setText(R.string.add_friend_button);
    }

    private void n(boolean z, final String str) {
        final String name_show = this.gRX.bEC().getUser().getName_show();
        this.gSc.setVisibility(8);
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
                    PersonalChatView.this.gRZ.clearAnimation();
                    PersonalChatView.this.gSa.setText(PersonalChatView.this.gRX.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.gSb.setText(str);
                    PersonalChatView.this.gRZ.setAnimation(translateAnimation);
                }
            });
            this.gRZ.setVisibility(0);
            this.gRZ.startAnimation(translateAnimation2);
        } else {
            this.gRZ.setVisibility(0);
            this.gSa.setText(this.gRX.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.gSb.setText(str);
        }
        this.gSd.setText(R.string.add_friend_agree_button);
    }

    private void mw(boolean z) {
        bEG();
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
                    PersonalChatView.this.gRY.setVisibility(8);
                }
            });
            this.gRY.startAnimation(translateAnimation);
            return;
        }
        this.gRY.setVisibility(8);
    }

    public Button bEI() {
        return this.gSd;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
