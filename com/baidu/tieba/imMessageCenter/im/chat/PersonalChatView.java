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
    private TextView iPT;
    private PersonalChatActivity jmf;
    private LinearLayout jmg;
    private LinearLayout jmh;
    private TextView jmi;
    private TextView jmj;
    private TextView jmk;
    private Button jml;
    private View.OnClickListener jmm;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.jmm = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.jmf.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.jmf.cxT() && this.mTool != null) {
            b(this.mTool.nQ(6));
            b(this.mTool.nQ(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.jmf = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.iPT = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.iPT.setText(string);
        }
        if (!this.jmf.cxT()) {
            this.jmg = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.jmh = (LinearLayout) this.jmg.findViewById(R.id.add_friend_tip_full);
            this.jmi = (TextView) this.jmg.findViewById(R.id.add_friend_tip_title);
            this.jmj = (TextView) this.jmg.findViewById(R.id.add_friend_tip_content);
            this.jmk = (TextView) this.jmg.findViewById(R.id.add_friend_tip_center);
            this.jml = (Button) this.jmg.findViewById(R.id.add_friend_tip_button);
            this.jml.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.jmg.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iPT != null) {
            ao.setViewTextColor(this.iPT, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.jmm);
        }
    }

    private void cxW() {
        if (this.mTool != null) {
            this.mTool.biT();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.jmg.setVisibility(0);
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
        this.jmg.setVisibility(8);
        this.jmh.setVisibility(0);
        this.jmk.setVisibility(8);
        this.jmi.setText(R.string.add_friend_title);
        this.jmj.setText(R.string.add_friend_content);
        this.jml.setText(R.string.add_friend_button);
    }

    private void qu(boolean z) {
        if (this.jmf.cxR().cyD() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.jmk.startAnimation(translateAnimation);
                }
            });
            this.jmk.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.jmk.setVisibility(0);
                    PersonalChatView.this.jmk.setAnimation(translateAnimation3);
                }
            });
            this.jmh.setVisibility(8);
            this.jmh.startAnimation(translateAnimation4);
        } else {
            this.jmh.setVisibility(8);
            this.jmk.setVisibility(0);
        }
        this.jmk.setText(R.string.add_friend_wait);
        this.jml.setText(R.string.add_friend_button);
    }

    private void r(boolean z, final String str) {
        final String name_show = this.jmf.cxR().getUser().getName_show();
        this.jmk.setVisibility(8);
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
                    PersonalChatView.this.jmh.clearAnimation();
                    PersonalChatView.this.jmi.setText(PersonalChatView.this.jmf.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.jmj.setText(str);
                    PersonalChatView.this.jmh.setAnimation(translateAnimation);
                }
            });
            this.jmh.setVisibility(0);
            this.jmh.startAnimation(translateAnimation2);
        } else {
            this.jmh.setVisibility(0);
            this.jmi.setText(this.jmf.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.jmj.setText(str);
        }
        this.jml.setText(R.string.add_friend_agree_button);
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
                    PersonalChatView.this.jmg.setVisibility(8);
                }
            });
            this.jmg.startAnimation(translateAnimation);
            return;
        }
        this.jmg.setVisibility(8);
    }

    public Button cxY() {
        return this.jml;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
