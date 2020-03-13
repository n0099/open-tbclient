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
    private PersonalChatActivity hLQ;
    private LinearLayout hLR;
    private LinearLayout hLS;
    private TextView hLT;
    private TextView hLU;
    private TextView hLV;
    private Button hLW;
    private View.OnClickListener hLX;
    private TextView hrR;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.hLX = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.hLQ.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.hLQ.bYD() && this.mTool != null) {
            b(this.mTool.mm(6));
            b(this.mTool.mm(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.hLQ = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.hrR = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.hrR.setText(string);
        }
        if (!this.hLQ.bYD()) {
            this.hLR = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.hLS = (LinearLayout) this.hLR.findViewById(R.id.add_friend_tip_full);
            this.hLT = (TextView) this.hLR.findViewById(R.id.add_friend_tip_title);
            this.hLU = (TextView) this.hLR.findViewById(R.id.add_friend_tip_content);
            this.hLV = (TextView) this.hLR.findViewById(R.id.add_friend_tip_center);
            this.hLW = (Button) this.hLR.findViewById(R.id.add_friend_tip_button);
            this.hLW.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.hLR.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hrR != null) {
            am.setViewTextColor(this.hrR, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.hLX);
        }
    }

    private void bYF() {
        if (this.mTool != null) {
            this.mTool.aOD();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.hLR.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                bYG();
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

    private void bYG() {
        this.hLR.setVisibility(8);
        this.hLS.setVisibility(0);
        this.hLV.setVisibility(8);
        this.hLT.setText(R.string.add_friend_title);
        this.hLU.setText(R.string.add_friend_content);
        this.hLW.setText(R.string.add_friend_button);
    }

    private void nW(boolean z) {
        if (this.hLQ.bYB().bZl() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.hLV.startAnimation(translateAnimation);
                }
            });
            this.hLV.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.hLV.setVisibility(0);
                    PersonalChatView.this.hLV.setAnimation(translateAnimation3);
                }
            });
            this.hLS.setVisibility(8);
            this.hLS.startAnimation(translateAnimation4);
        } else {
            this.hLS.setVisibility(8);
            this.hLV.setVisibility(0);
        }
        this.hLV.setText(R.string.add_friend_wait);
        this.hLW.setText(R.string.add_friend_button);
    }

    private void o(boolean z, final String str) {
        final String name_show = this.hLQ.bYB().getUser().getName_show();
        this.hLV.setVisibility(8);
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
                    PersonalChatView.this.hLS.clearAnimation();
                    PersonalChatView.this.hLT.setText(PersonalChatView.this.hLQ.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.hLU.setText(str);
                    PersonalChatView.this.hLS.setAnimation(translateAnimation);
                }
            });
            this.hLS.setVisibility(0);
            this.hLS.startAnimation(translateAnimation2);
        } else {
            this.hLS.setVisibility(0);
            this.hLT.setText(this.hLQ.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.hLU.setText(str);
        }
        this.hLW.setText(R.string.add_friend_agree_button);
    }

    private void nX(boolean z) {
        bYF();
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
                    PersonalChatView.this.hLR.setVisibility(8);
                }
            });
            this.hLR.startAnimation(translateAnimation);
            return;
        }
        this.hLR.setVisibility(8);
    }

    public Button bYH() {
        return this.hLW;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
