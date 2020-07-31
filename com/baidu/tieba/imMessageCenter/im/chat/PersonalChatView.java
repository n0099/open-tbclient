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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.g;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes16.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private TextView iPR;
    private PersonalChatActivity jmd;
    private LinearLayout jme;
    private LinearLayout jmf;
    private TextView jmg;
    private TextView jmh;
    private TextView jmi;
    private Button jmj;
    private View.OnClickListener jmk;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.jmk = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.jmd.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.jmd.cxT() && this.mTool != null) {
            b(this.mTool.nQ(6));
            b(this.mTool.nQ(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.jmd = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.iPR = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.iPR.setText(string);
        }
        if (!this.jmd.cxT()) {
            this.jme = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.jmf = (LinearLayout) this.jme.findViewById(R.id.add_friend_tip_full);
            this.jmg = (TextView) this.jme.findViewById(R.id.add_friend_tip_title);
            this.jmh = (TextView) this.jme.findViewById(R.id.add_friend_tip_content);
            this.jmi = (TextView) this.jme.findViewById(R.id.add_friend_tip_center);
            this.jmj = (Button) this.jme.findViewById(R.id.add_friend_tip_button);
            this.jmj.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.jme.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iPR != null) {
            ao.setViewTextColor(this.iPR, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.jmk);
        }
    }

    private void cxW() {
        if (this.mTool != null) {
            this.mTool.biT();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.jme.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                cxX();
                return;
            case WAIT:
                qu(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                r(z, str);
                return;
            case PASS:
                qv(z);
                return;
            default:
                return;
        }
    }

    private void cxX() {
        this.jme.setVisibility(8);
        this.jmf.setVisibility(0);
        this.jmi.setVisibility(8);
        this.jmg.setText(R.string.add_friend_title);
        this.jmh.setText(R.string.add_friend_content);
        this.jmj.setText(R.string.add_friend_button);
    }

    private void qu(boolean z) {
        if (this.jmd.cxR().cyD() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.jmi.startAnimation(translateAnimation);
                }
            });
            this.jmi.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.jmi.setVisibility(0);
                    PersonalChatView.this.jmi.setAnimation(translateAnimation3);
                }
            });
            this.jmf.setVisibility(8);
            this.jmf.startAnimation(translateAnimation4);
        } else {
            this.jmf.setVisibility(8);
            this.jmi.setVisibility(0);
        }
        this.jmi.setText(R.string.add_friend_wait);
        this.jmj.setText(R.string.add_friend_button);
    }

    private void r(boolean z, final String str) {
        final String name_show = this.jmd.cxR().getUser().getName_show();
        this.jmi.setVisibility(8);
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
                    PersonalChatView.this.jmf.clearAnimation();
                    PersonalChatView.this.jmg.setText(PersonalChatView.this.jmd.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.jmh.setText(str);
                    PersonalChatView.this.jmf.setAnimation(translateAnimation);
                }
            });
            this.jmf.setVisibility(0);
            this.jmf.startAnimation(translateAnimation2);
        } else {
            this.jmf.setVisibility(0);
            this.jmg.setText(this.jmd.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.jmh.setText(str);
        }
        this.jmj.setText(R.string.add_friend_agree_button);
    }

    private void qv(boolean z) {
        cxW();
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
                    PersonalChatView.this.jme.setVisibility(8);
                }
            });
            this.jme.startAnimation(translateAnimation);
            return;
        }
        this.jme.setVisibility(8);
    }

    public Button cxY() {
        return this.jmj;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
