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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.g;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes9.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private TextView iJM;
    private PersonalChatActivity jdI;
    private LinearLayout jdJ;
    private LinearLayout jdK;
    private TextView jdL;
    private TextView jdM;
    private TextView jdN;
    private Button jdO;
    private View.OnClickListener jdP;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.jdP = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.jdI.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.jdI.ctR() && this.mTool != null) {
            b(this.mTool.ny(6));
            b(this.mTool.ny(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.jdI = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.iJM = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.iJM.setText(string);
        }
        if (!this.jdI.ctR()) {
            this.jdJ = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.jdK = (LinearLayout) this.jdJ.findViewById(R.id.add_friend_tip_full);
            this.jdL = (TextView) this.jdJ.findViewById(R.id.add_friend_tip_title);
            this.jdM = (TextView) this.jdJ.findViewById(R.id.add_friend_tip_content);
            this.jdN = (TextView) this.jdJ.findViewById(R.id.add_friend_tip_center);
            this.jdO = (Button) this.jdJ.findViewById(R.id.add_friend_tip_button);
            this.jdO.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.jdJ.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iJM != null) {
            an.setViewTextColor(this.iJM, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.jdP);
        }
    }

    private void ctU() {
        if (this.mTool != null) {
            this.mTool.bfj();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.jdJ.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                ctV();
                return;
            case WAIT:
                pM(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                r(z, str);
                return;
            case PASS:
                pN(z);
                return;
            default:
                return;
        }
    }

    private void ctV() {
        this.jdJ.setVisibility(8);
        this.jdK.setVisibility(0);
        this.jdN.setVisibility(8);
        this.jdL.setText(R.string.add_friend_title);
        this.jdM.setText(R.string.add_friend_content);
        this.jdO.setText(R.string.add_friend_button);
    }

    private void pM(boolean z) {
        if (this.jdI.ctP().cuA() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.jdN.startAnimation(translateAnimation);
                }
            });
            this.jdN.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.jdN.setVisibility(0);
                    PersonalChatView.this.jdN.setAnimation(translateAnimation3);
                }
            });
            this.jdK.setVisibility(8);
            this.jdK.startAnimation(translateAnimation4);
        } else {
            this.jdK.setVisibility(8);
            this.jdN.setVisibility(0);
        }
        this.jdN.setText(R.string.add_friend_wait);
        this.jdO.setText(R.string.add_friend_button);
    }

    private void r(boolean z, final String str) {
        final String name_show = this.jdI.ctP().getUser().getName_show();
        this.jdN.setVisibility(8);
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
                    PersonalChatView.this.jdK.clearAnimation();
                    PersonalChatView.this.jdL.setText(PersonalChatView.this.jdI.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.jdM.setText(str);
                    PersonalChatView.this.jdK.setAnimation(translateAnimation);
                }
            });
            this.jdK.setVisibility(0);
            this.jdK.startAnimation(translateAnimation2);
        } else {
            this.jdK.setVisibility(0);
            this.jdL.setText(this.jdI.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.jdM.setText(str);
        }
        this.jdO.setText(R.string.add_friend_agree_button);
    }

    private void pN(boolean z) {
        ctU();
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
                    PersonalChatView.this.jdJ.setVisibility(8);
                }
            });
            this.jdJ.startAnimation(translateAnimation);
            return;
        }
        this.jdJ.setVisibility(8);
    }

    public Button ctW() {
        return this.jdO;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
