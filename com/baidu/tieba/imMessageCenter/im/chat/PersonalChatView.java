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
    private PersonalChatActivity hLE;
    private LinearLayout hLF;
    private LinearLayout hLG;
    private TextView hLH;
    private TextView hLI;
    private TextView hLJ;
    private Button hLK;
    private View.OnClickListener hLL;
    private TextView hrF;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.hLL = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.hLE.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.hLE.bYC() && this.mTool != null) {
            b(this.mTool.mm(6));
            b(this.mTool.mm(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.hLE = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.hrF = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.hrF.setText(string);
        }
        if (!this.hLE.bYC()) {
            this.hLF = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.hLG = (LinearLayout) this.hLF.findViewById(R.id.add_friend_tip_full);
            this.hLH = (TextView) this.hLF.findViewById(R.id.add_friend_tip_title);
            this.hLI = (TextView) this.hLF.findViewById(R.id.add_friend_tip_content);
            this.hLJ = (TextView) this.hLF.findViewById(R.id.add_friend_tip_center);
            this.hLK = (Button) this.hLF.findViewById(R.id.add_friend_tip_button);
            this.hLK.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.hLF.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hrF != null) {
            am.setViewTextColor(this.hrF, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.hLL);
        }
    }

    private void bYE() {
        if (this.mTool != null) {
            this.mTool.aOC();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.hLF.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                bYF();
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

    private void bYF() {
        this.hLF.setVisibility(8);
        this.hLG.setVisibility(0);
        this.hLJ.setVisibility(8);
        this.hLH.setText(R.string.add_friend_title);
        this.hLI.setText(R.string.add_friend_content);
        this.hLK.setText(R.string.add_friend_button);
    }

    private void nW(boolean z) {
        if (this.hLE.bYA().bZk() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.hLJ.startAnimation(translateAnimation);
                }
            });
            this.hLJ.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.hLJ.setVisibility(0);
                    PersonalChatView.this.hLJ.setAnimation(translateAnimation3);
                }
            });
            this.hLG.setVisibility(8);
            this.hLG.startAnimation(translateAnimation4);
        } else {
            this.hLG.setVisibility(8);
            this.hLJ.setVisibility(0);
        }
        this.hLJ.setText(R.string.add_friend_wait);
        this.hLK.setText(R.string.add_friend_button);
    }

    private void o(boolean z, final String str) {
        final String name_show = this.hLE.bYA().getUser().getName_show();
        this.hLJ.setVisibility(8);
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
                    PersonalChatView.this.hLG.clearAnimation();
                    PersonalChatView.this.hLH.setText(PersonalChatView.this.hLE.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.hLI.setText(str);
                    PersonalChatView.this.hLG.setAnimation(translateAnimation);
                }
            });
            this.hLG.setVisibility(0);
            this.hLG.startAnimation(translateAnimation2);
        } else {
            this.hLG.setVisibility(0);
            this.hLH.setText(this.hLE.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.hLI.setText(str);
        }
        this.hLK.setText(R.string.add_friend_agree_button);
    }

    private void nX(boolean z) {
        bYE();
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
                    PersonalChatView.this.hLF.setVisibility(8);
                }
            });
            this.hLF.startAnimation(translateAnimation);
            return;
        }
        this.hLF.setVisibility(8);
    }

    public Button bYG() {
        return this.hLK;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
