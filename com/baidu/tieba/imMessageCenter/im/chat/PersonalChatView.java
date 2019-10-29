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
    private PersonalChatActivity gSO;
    private LinearLayout gSP;
    private LinearLayout gSQ;
    private TextView gSR;
    private TextView gSS;
    private TextView gST;
    private Button gSU;
    private View.OnClickListener gSV;
    private TextView gyJ;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.gSV = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.gSO.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.gSO.bEG() && this.mTool != null) {
            b(this.mTool.jI(6));
            b(this.mTool.jI(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.gSO = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.gyJ = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.gyJ.setText(string);
        }
        if (!this.gSO.bEG()) {
            this.gSP = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.gSQ = (LinearLayout) this.gSP.findViewById(R.id.add_friend_tip_full);
            this.gSR = (TextView) this.gSP.findViewById(R.id.add_friend_tip_title);
            this.gSS = (TextView) this.gSP.findViewById(R.id.add_friend_tip_content);
            this.gST = (TextView) this.gSP.findViewById(R.id.add_friend_tip_center);
            this.gSU = (Button) this.gSP.findViewById(R.id.add_friend_tip_button);
            this.gSU.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.gSP.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gyJ != null) {
            am.setViewTextColor(this.gyJ, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.gSV);
        }
    }

    private void bEI() {
        if (this.mTool != null) {
            this.mTool.aui();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.gSP.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                bEJ();
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

    private void bEJ() {
        this.gSP.setVisibility(8);
        this.gSQ.setVisibility(0);
        this.gST.setVisibility(8);
        this.gSR.setText(R.string.add_friend_title);
        this.gSS.setText(R.string.add_friend_content);
        this.gSU.setText(R.string.add_friend_button);
    }

    private void mv(boolean z) {
        if (this.gSO.bEE().bFo() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.gST.startAnimation(translateAnimation);
                }
            });
            this.gST.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.gST.setVisibility(0);
                    PersonalChatView.this.gST.setAnimation(translateAnimation3);
                }
            });
            this.gSQ.setVisibility(8);
            this.gSQ.startAnimation(translateAnimation4);
        } else {
            this.gSQ.setVisibility(8);
            this.gST.setVisibility(0);
        }
        this.gST.setText(R.string.add_friend_wait);
        this.gSU.setText(R.string.add_friend_button);
    }

    private void n(boolean z, final String str) {
        final String name_show = this.gSO.bEE().getUser().getName_show();
        this.gST.setVisibility(8);
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
                    PersonalChatView.this.gSQ.clearAnimation();
                    PersonalChatView.this.gSR.setText(PersonalChatView.this.gSO.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.gSS.setText(str);
                    PersonalChatView.this.gSQ.setAnimation(translateAnimation);
                }
            });
            this.gSQ.setVisibility(0);
            this.gSQ.startAnimation(translateAnimation2);
        } else {
            this.gSQ.setVisibility(0);
            this.gSR.setText(this.gSO.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.gSS.setText(str);
        }
        this.gSU.setText(R.string.add_friend_agree_button);
    }

    private void mw(boolean z) {
        bEI();
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
                    PersonalChatView.this.gSP.setVisibility(8);
                }
            });
            this.gSP.startAnimation(translateAnimation);
            return;
        }
        this.gSP.setVisibility(8);
    }

    public Button bEK() {
        return this.gSU;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
