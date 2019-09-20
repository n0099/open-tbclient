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
    private TextView gAL;
    private PersonalChatActivity gUO;
    private LinearLayout gUP;
    private LinearLayout gUQ;
    private TextView gUR;
    private TextView gUS;
    private TextView gUT;
    private Button gUU;
    private View.OnClickListener gUV;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.gUV = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.gUO.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.gUO.bHV() && this.mTool != null) {
            b(this.mTool.kq(6));
            b(this.mTool.kq(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.gUO = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.gAL = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.gAL.setText(string);
        }
        if (!this.gUO.bHV()) {
            this.gUP = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.gUQ = (LinearLayout) this.gUP.findViewById(R.id.add_friend_tip_full);
            this.gUR = (TextView) this.gUP.findViewById(R.id.add_friend_tip_title);
            this.gUS = (TextView) this.gUP.findViewById(R.id.add_friend_tip_content);
            this.gUT = (TextView) this.gUP.findViewById(R.id.add_friend_tip_center);
            this.gUU = (Button) this.gUP.findViewById(R.id.add_friend_tip_button);
            this.gUU.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.gUP.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gAL != null) {
            am.f(this.gAL, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.gUV);
        }
    }

    private void bHX() {
        if (this.mTool != null) {
            this.mTool.asw();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.gUP.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                bHY();
                return;
            case WAIT:
                mH(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                n(z, str);
                return;
            case PASS:
                mI(z);
                return;
            default:
                return;
        }
    }

    private void bHY() {
        this.gUP.setVisibility(8);
        this.gUQ.setVisibility(0);
        this.gUT.setVisibility(8);
        this.gUR.setText(R.string.add_friend_title);
        this.gUS.setText(R.string.add_friend_content);
        this.gUU.setText(R.string.add_friend_button);
    }

    private void mH(boolean z) {
        if (this.gUO.bHT().bIE() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.gUT.startAnimation(translateAnimation);
                }
            });
            this.gUT.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.gUT.setVisibility(0);
                    PersonalChatView.this.gUT.setAnimation(translateAnimation3);
                }
            });
            this.gUQ.setVisibility(8);
            this.gUQ.startAnimation(translateAnimation4);
        } else {
            this.gUQ.setVisibility(8);
            this.gUT.setVisibility(0);
        }
        this.gUT.setText(R.string.add_friend_wait);
        this.gUU.setText(R.string.add_friend_button);
    }

    private void n(boolean z, final String str) {
        final String name_show = this.gUO.bHT().getUser().getName_show();
        this.gUT.setVisibility(8);
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
                    PersonalChatView.this.gUQ.clearAnimation();
                    PersonalChatView.this.gUR.setText(PersonalChatView.this.gUO.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.gUS.setText(str);
                    PersonalChatView.this.gUQ.setAnimation(translateAnimation);
                }
            });
            this.gUQ.setVisibility(0);
            this.gUQ.startAnimation(translateAnimation2);
        } else {
            this.gUQ.setVisibility(0);
            this.gUR.setText(this.gUO.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.gUS.setText(str);
        }
        this.gUU.setText(R.string.add_friend_agree_button);
    }

    private void mI(boolean z) {
        bHX();
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
                    PersonalChatView.this.gUP.setVisibility(8);
                }
            });
            this.gUP.startAnimation(translateAnimation);
            return;
        }
        this.gUP.setVisibility(8);
    }

    public Button bHZ() {
        return this.gUU;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
