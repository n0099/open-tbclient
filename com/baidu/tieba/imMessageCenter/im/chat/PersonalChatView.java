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
/* loaded from: classes9.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private PersonalChatActivity hLC;
    private LinearLayout hLD;
    private LinearLayout hLE;
    private TextView hLF;
    private TextView hLG;
    private TextView hLH;
    private Button hLI;
    private View.OnClickListener hLJ;
    private TextView hrD;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.hLJ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.hLC.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.hLC.bYA() && this.mTool != null) {
            b(this.mTool.mm(6));
            b(this.mTool.mm(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.hLC = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.hrD = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.hrD.setText(string);
        }
        if (!this.hLC.bYA()) {
            this.hLD = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.hLE = (LinearLayout) this.hLD.findViewById(R.id.add_friend_tip_full);
            this.hLF = (TextView) this.hLD.findViewById(R.id.add_friend_tip_title);
            this.hLG = (TextView) this.hLD.findViewById(R.id.add_friend_tip_content);
            this.hLH = (TextView) this.hLD.findViewById(R.id.add_friend_tip_center);
            this.hLI = (Button) this.hLD.findViewById(R.id.add_friend_tip_button);
            this.hLI.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.hLD.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hrD != null) {
            am.setViewTextColor(this.hrD, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.hLJ);
        }
    }

    private void bYC() {
        if (this.mTool != null) {
            this.mTool.aOA();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.hLD.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                bYD();
                return;
            case WAIT:
                nW(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                o(z, str);
                return;
            case PASS:
                nX(z);
                return;
            default:
                return;
        }
    }

    private void bYD() {
        this.hLD.setVisibility(8);
        this.hLE.setVisibility(0);
        this.hLH.setVisibility(8);
        this.hLF.setText(R.string.add_friend_title);
        this.hLG.setText(R.string.add_friend_content);
        this.hLI.setText(R.string.add_friend_button);
    }

    private void nW(boolean z) {
        if (this.hLC.bYy().bZi() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.hLH.startAnimation(translateAnimation);
                }
            });
            this.hLH.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.hLH.setVisibility(0);
                    PersonalChatView.this.hLH.setAnimation(translateAnimation3);
                }
            });
            this.hLE.setVisibility(8);
            this.hLE.startAnimation(translateAnimation4);
        } else {
            this.hLE.setVisibility(8);
            this.hLH.setVisibility(0);
        }
        this.hLH.setText(R.string.add_friend_wait);
        this.hLI.setText(R.string.add_friend_button);
    }

    private void o(boolean z, final String str) {
        final String name_show = this.hLC.bYy().getUser().getName_show();
        this.hLH.setVisibility(8);
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
                    PersonalChatView.this.hLE.clearAnimation();
                    PersonalChatView.this.hLF.setText(PersonalChatView.this.hLC.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.hLG.setText(str);
                    PersonalChatView.this.hLE.setAnimation(translateAnimation);
                }
            });
            this.hLE.setVisibility(0);
            this.hLE.startAnimation(translateAnimation2);
        } else {
            this.hLE.setVisibility(0);
            this.hLF.setText(this.hLC.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.hLG.setText(str);
        }
        this.hLI.setText(R.string.add_friend_agree_button);
    }

    private void nX(boolean z) {
        bYC();
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
                    PersonalChatView.this.hLD.setVisibility(8);
                }
            });
            this.hLD.startAnimation(translateAnimation);
            return;
        }
        this.hLD.setVisibility(8);
    }

    public Button bYE() {
        return this.hLI;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
