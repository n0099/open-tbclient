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
    private PersonalChatActivity iMG;
    private LinearLayout iMH;
    private LinearLayout iMI;
    private TextView iMJ;
    private TextView iMK;
    private TextView iML;
    private Button iMM;
    private View.OnClickListener iMN;
    private TextView isG;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.iMN = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.iMG.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.iMG.cqb() && this.mTool != null) {
            b(this.mTool.ne(6));
            b(this.mTool.ne(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.iMG = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.isG = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.isG.setText(string);
        }
        if (!this.iMG.cqb()) {
            this.iMH = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.iMI = (LinearLayout) this.iMH.findViewById(R.id.add_friend_tip_full);
            this.iMJ = (TextView) this.iMH.findViewById(R.id.add_friend_tip_title);
            this.iMK = (TextView) this.iMH.findViewById(R.id.add_friend_tip_content);
            this.iML = (TextView) this.iMH.findViewById(R.id.add_friend_tip_center);
            this.iMM = (Button) this.iMH.findViewById(R.id.add_friend_tip_button);
            this.iMM.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.iMH.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.isG != null) {
            am.setViewTextColor(this.isG, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.iMN);
        }
    }

    private void cqe() {
        if (this.mTool != null) {
            this.mTool.bdg();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.iMH.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                cqf();
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

    private void cqf() {
        this.iMH.setVisibility(8);
        this.iMI.setVisibility(0);
        this.iML.setVisibility(8);
        this.iMJ.setText(R.string.add_friend_title);
        this.iMK.setText(R.string.add_friend_content);
        this.iMM.setText(R.string.add_friend_button);
    }

    private void pC(boolean z) {
        if (this.iMG.cpZ().cqK() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.iML.startAnimation(translateAnimation);
                }
            });
            this.iML.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.iML.setVisibility(0);
                    PersonalChatView.this.iML.setAnimation(translateAnimation3);
                }
            });
            this.iMI.setVisibility(8);
            this.iMI.startAnimation(translateAnimation4);
        } else {
            this.iMI.setVisibility(8);
            this.iML.setVisibility(0);
        }
        this.iML.setText(R.string.add_friend_wait);
        this.iMM.setText(R.string.add_friend_button);
    }

    private void p(boolean z, final String str) {
        final String name_show = this.iMG.cpZ().getUser().getName_show();
        this.iML.setVisibility(8);
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
                    PersonalChatView.this.iMI.clearAnimation();
                    PersonalChatView.this.iMJ.setText(PersonalChatView.this.iMG.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.iMK.setText(str);
                    PersonalChatView.this.iMI.setAnimation(translateAnimation);
                }
            });
            this.iMI.setVisibility(0);
            this.iMI.startAnimation(translateAnimation2);
        } else {
            this.iMI.setVisibility(0);
            this.iMJ.setText(this.iMG.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.iMK.setText(str);
        }
        this.iMM.setText(R.string.add_friend_agree_button);
    }

    private void pD(boolean z) {
        cqe();
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
                    PersonalChatView.this.iMH.setVisibility(8);
                }
            });
            this.iMH.startAnimation(translateAnimation);
            return;
        }
        this.iMH.setVisibility(8);
    }

    public Button cqg() {
        return this.iMM;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
