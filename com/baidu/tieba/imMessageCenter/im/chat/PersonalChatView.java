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
/* loaded from: classes22.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private TextView jCz;
    private PersonalChatActivity jYJ;
    private LinearLayout jYK;
    private LinearLayout jYL;
    private TextView jYM;
    private TextView jYN;
    private TextView jYO;
    private Button jYP;
    private View.OnClickListener jYQ;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.jYQ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.jYJ.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.jYJ.cPZ() && this.mTool != null) {
            b(this.mTool.qM(6));
            b(this.mTool.qM(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.jYJ = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.jCz = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.jCz.setText(string);
        }
        if (!this.jYJ.cPZ()) {
            this.jYK = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.jYL = (LinearLayout) this.jYK.findViewById(R.id.add_friend_tip_full);
            this.jYM = (TextView) this.jYK.findViewById(R.id.add_friend_tip_title);
            this.jYN = (TextView) this.jYK.findViewById(R.id.add_friend_tip_content);
            this.jYO = (TextView) this.jYK.findViewById(R.id.add_friend_tip_center);
            this.jYP = (Button) this.jYK.findViewById(R.id.add_friend_tip_button);
            this.jYP.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.jYK.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jCz != null) {
            ap.setViewTextColor(this.jCz, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(h hVar) {
        if (hVar != null && hVar != null && (hVar instanceof View)) {
            ((View) hVar).setOnClickListener(this.jYQ);
        }
    }

    private void cQc() {
        if (this.mTool != null) {
            this.mTool.bvr();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.jYK.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                cQd();
                return;
            case WAIT:
                rQ(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                s(z, str);
                return;
            case PASS:
                rR(z);
                return;
            default:
                return;
        }
    }

    private void cQd() {
        this.jYK.setVisibility(8);
        this.jYL.setVisibility(0);
        this.jYO.setVisibility(8);
        this.jYM.setText(R.string.add_friend_title);
        this.jYN.setText(R.string.add_friend_content);
        this.jYP.setText(R.string.add_friend_button);
    }

    private void rQ(boolean z) {
        if (this.jYJ.cPX().cQJ() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.jYO.startAnimation(translateAnimation);
                }
            });
            this.jYO.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.jYO.setVisibility(0);
                    PersonalChatView.this.jYO.setAnimation(translateAnimation3);
                }
            });
            this.jYL.setVisibility(8);
            this.jYL.startAnimation(translateAnimation4);
        } else {
            this.jYL.setVisibility(8);
            this.jYO.setVisibility(0);
        }
        this.jYO.setText(R.string.add_friend_wait);
        this.jYP.setText(R.string.add_friend_button);
    }

    private void s(boolean z, final String str) {
        final String name_show = this.jYJ.cPX().getUser().getName_show();
        this.jYO.setVisibility(8);
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
                    PersonalChatView.this.jYL.clearAnimation();
                    PersonalChatView.this.jYM.setText(PersonalChatView.this.jYJ.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.jYN.setText(str);
                    PersonalChatView.this.jYL.setAnimation(translateAnimation);
                }
            });
            this.jYL.setVisibility(0);
            this.jYL.startAnimation(translateAnimation2);
        } else {
            this.jYL.setVisibility(0);
            this.jYM.setText(this.jYJ.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.jYN.setText(str);
        }
        this.jYP.setText(R.string.add_friend_agree_button);
    }

    private void rR(boolean z) {
        cQc();
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
                    PersonalChatView.this.jYK.setVisibility(8);
                }
            });
            this.jYK.startAnimation(translateAnimation);
            return;
        }
        this.jYK.setVisibility(8);
    }

    public Button cQe() {
        return this.jYP;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
