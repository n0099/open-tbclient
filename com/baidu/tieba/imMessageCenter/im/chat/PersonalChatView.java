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
    private TextView jVF;
    private PersonalChatActivity krP;
    private LinearLayout krQ;
    private LinearLayout krR;
    private TextView krS;
    private TextView krT;
    private TextView krU;
    private Button krV;
    private View.OnClickListener krW;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.krW = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.krP.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.krP.cVn() && this.mTool != null) {
            b(this.mTool.rF(6));
            b(this.mTool.rF(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.krP = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.jVF = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.jVF.setText(string);
        }
        if (!this.krP.cVn()) {
            this.krQ = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.krR = (LinearLayout) this.krQ.findViewById(R.id.add_friend_tip_full);
            this.krS = (TextView) this.krQ.findViewById(R.id.add_friend_tip_title);
            this.krT = (TextView) this.krQ.findViewById(R.id.add_friend_tip_content);
            this.krU = (TextView) this.krQ.findViewById(R.id.add_friend_tip_center);
            this.krV = (Button) this.krQ.findViewById(R.id.add_friend_tip_button);
            this.krV.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.krQ.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jVF != null) {
            ap.setViewTextColor(this.jVF, R.color.CAM_X0105, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(h hVar) {
        if (hVar != null && hVar != null && (hVar instanceof View)) {
            ((View) hVar).setOnClickListener(this.krW);
        }
    }

    private void cVq() {
        if (this.mTool != null) {
            this.mTool.byZ();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.krQ.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                cVr();
                return;
            case WAIT:
                su(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                v(z, str);
                return;
            case PASS:
                sv(z);
                return;
            default:
                return;
        }
    }

    private void cVr() {
        this.krQ.setVisibility(8);
        this.krR.setVisibility(0);
        this.krU.setVisibility(8);
        this.krS.setText(R.string.add_friend_title);
        this.krT.setText(R.string.add_friend_content);
        this.krV.setText(R.string.add_friend_button);
    }

    private void su(boolean z) {
        if (this.krP.cVl().cVX() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.krU.startAnimation(translateAnimation);
                }
            });
            this.krU.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.krU.setVisibility(0);
                    PersonalChatView.this.krU.setAnimation(translateAnimation3);
                }
            });
            this.krR.setVisibility(8);
            this.krR.startAnimation(translateAnimation4);
        } else {
            this.krR.setVisibility(8);
            this.krU.setVisibility(0);
        }
        this.krU.setText(R.string.add_friend_wait);
        this.krV.setText(R.string.add_friend_button);
    }

    private void v(boolean z, final String str) {
        final String name_show = this.krP.cVl().getUser().getName_show();
        this.krU.setVisibility(8);
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
                    PersonalChatView.this.krR.clearAnimation();
                    PersonalChatView.this.krS.setText(PersonalChatView.this.krP.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.krT.setText(str);
                    PersonalChatView.this.krR.setAnimation(translateAnimation);
                }
            });
            this.krR.setVisibility(0);
            this.krR.startAnimation(translateAnimation2);
        } else {
            this.krR.setVisibility(0);
            this.krS.setText(this.krP.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.krT.setText(str);
        }
        this.krV.setText(R.string.add_friend_agree_button);
    }

    private void sv(boolean z) {
        cVq();
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
                    PersonalChatView.this.krQ.setVisibility(8);
                }
            });
            this.krQ.startAnimation(translateAnimation);
            return;
        }
        this.krQ.setVisibility(8);
    }

    public Button cVs() {
        return this.krV;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
