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
/* loaded from: classes7.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private PersonalChatActivity hJD;
    private LinearLayout hJE;
    private LinearLayout hJF;
    private TextView hJG;
    private TextView hJH;
    private TextView hJI;
    private Button hJJ;
    private View.OnClickListener hJK;
    private TextView hpE;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.hJK = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.hJD.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.hJD.bWZ() && this.mTool != null) {
            b(this.mTool.lU(6));
            b(this.mTool.lU(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.hJD = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.hpE = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.hpE.setText(string);
        }
        if (!this.hJD.bWZ()) {
            this.hJE = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.hJF = (LinearLayout) this.hJE.findViewById(R.id.add_friend_tip_full);
            this.hJG = (TextView) this.hJE.findViewById(R.id.add_friend_tip_title);
            this.hJH = (TextView) this.hJE.findViewById(R.id.add_friend_tip_content);
            this.hJI = (TextView) this.hJE.findViewById(R.id.add_friend_tip_center);
            this.hJJ = (Button) this.hJE.findViewById(R.id.add_friend_tip_button);
            this.hJJ.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.hJE.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hpE != null) {
            am.setViewTextColor(this.hpE, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.hJK);
        }
    }

    private void bXb() {
        if (this.mTool != null) {
            this.mTool.aMe();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.hJE.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                bXc();
                return;
            case WAIT:
                nU(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                n(z, str);
                return;
            case PASS:
                nV(z);
                return;
            default:
                return;
        }
    }

    private void bXc() {
        this.hJE.setVisibility(8);
        this.hJF.setVisibility(0);
        this.hJI.setVisibility(8);
        this.hJG.setText(R.string.add_friend_title);
        this.hJH.setText(R.string.add_friend_content);
        this.hJJ.setText(R.string.add_friend_button);
    }

    private void nU(boolean z) {
        if (this.hJD.bWX().bXH() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.hJI.startAnimation(translateAnimation);
                }
            });
            this.hJI.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.hJI.setVisibility(0);
                    PersonalChatView.this.hJI.setAnimation(translateAnimation3);
                }
            });
            this.hJF.setVisibility(8);
            this.hJF.startAnimation(translateAnimation4);
        } else {
            this.hJF.setVisibility(8);
            this.hJI.setVisibility(0);
        }
        this.hJI.setText(R.string.add_friend_wait);
        this.hJJ.setText(R.string.add_friend_button);
    }

    private void n(boolean z, final String str) {
        final String name_show = this.hJD.bWX().getUser().getName_show();
        this.hJI.setVisibility(8);
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
                    PersonalChatView.this.hJF.clearAnimation();
                    PersonalChatView.this.hJG.setText(PersonalChatView.this.hJD.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.hJH.setText(str);
                    PersonalChatView.this.hJF.setAnimation(translateAnimation);
                }
            });
            this.hJF.setVisibility(0);
            this.hJF.startAnimation(translateAnimation2);
        } else {
            this.hJF.setVisibility(0);
            this.hJG.setText(this.hJD.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.hJH.setText(str);
        }
        this.hJJ.setText(R.string.add_friend_agree_button);
    }

    private void nV(boolean z) {
        bXb();
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
                    PersonalChatView.this.hJE.setVisibility(8);
                }
            });
            this.hJE.startAnimation(translateAnimation);
            return;
        }
        this.hJE.setVisibility(8);
    }

    public Button bXd() {
        return this.hJJ;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
