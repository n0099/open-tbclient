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
    private PersonalChatActivity iLT;
    private LinearLayout iLU;
    private LinearLayout iLV;
    private TextView iLW;
    private TextView iLX;
    private TextView iLY;
    private Button iLZ;
    private View.OnClickListener iMa;
    private TextView irT;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.iMa = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.iLT.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.iLT.cpS() && this.mTool != null) {
            b(this.mTool.nc(6));
            b(this.mTool.nc(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.iLT = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.irT = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.irT.setText(string);
        }
        if (!this.iLT.cpS()) {
            this.iLU = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.iLV = (LinearLayout) this.iLU.findViewById(R.id.add_friend_tip_full);
            this.iLW = (TextView) this.iLU.findViewById(R.id.add_friend_tip_title);
            this.iLX = (TextView) this.iLU.findViewById(R.id.add_friend_tip_content);
            this.iLY = (TextView) this.iLU.findViewById(R.id.add_friend_tip_center);
            this.iLZ = (Button) this.iLU.findViewById(R.id.add_friend_tip_button);
            this.iLZ.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.iLU.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.irT != null) {
            am.setViewTextColor(this.irT, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.iMa);
        }
    }

    private void cpV() {
        if (this.mTool != null) {
            this.mTool.bdf();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.iLU.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                cpW();
                return;
            case WAIT:
                pC(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                p(z, str);
                return;
            case PASS:
                pD(z);
                return;
            default:
                return;
        }
    }

    private void cpW() {
        this.iLU.setVisibility(8);
        this.iLV.setVisibility(0);
        this.iLY.setVisibility(8);
        this.iLW.setText(R.string.add_friend_title);
        this.iLX.setText(R.string.add_friend_content);
        this.iLZ.setText(R.string.add_friend_button);
    }

    private void pC(boolean z) {
        if (this.iLT.cpQ().cqB() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.iLY.startAnimation(translateAnimation);
                }
            });
            this.iLY.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.iLY.setVisibility(0);
                    PersonalChatView.this.iLY.setAnimation(translateAnimation3);
                }
            });
            this.iLV.setVisibility(8);
            this.iLV.startAnimation(translateAnimation4);
        } else {
            this.iLV.setVisibility(8);
            this.iLY.setVisibility(0);
        }
        this.iLY.setText(R.string.add_friend_wait);
        this.iLZ.setText(R.string.add_friend_button);
    }

    private void p(boolean z, final String str) {
        final String name_show = this.iLT.cpQ().getUser().getName_show();
        this.iLY.setVisibility(8);
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
                    PersonalChatView.this.iLV.clearAnimation();
                    PersonalChatView.this.iLW.setText(PersonalChatView.this.iLT.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.iLX.setText(str);
                    PersonalChatView.this.iLV.setAnimation(translateAnimation);
                }
            });
            this.iLV.setVisibility(0);
            this.iLV.startAnimation(translateAnimation2);
        } else {
            this.iLV.setVisibility(0);
            this.iLW.setText(this.iLT.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.iLX.setText(str);
        }
        this.iLZ.setText(R.string.add_friend_agree_button);
    }

    private void pD(boolean z) {
        cpV();
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
                    PersonalChatView.this.iLU.setVisibility(8);
                }
            });
            this.iLU.startAnimation(translateAnimation);
            return;
        }
        this.iLU.setVisibility(8);
    }

    public Button cpX() {
        return this.iLZ;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
