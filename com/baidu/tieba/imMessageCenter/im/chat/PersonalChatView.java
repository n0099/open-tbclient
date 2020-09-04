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
/* loaded from: classes16.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private PersonalChatActivity jBk;
    private LinearLayout jBl;
    private LinearLayout jBm;
    private TextView jBn;
    private TextView jBo;
    private TextView jBp;
    private Button jBq;
    private View.OnClickListener jBr;
    private TextView jeW;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.jBr = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.jBk.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.jBk.cIL() && this.mTool != null) {
            b(this.mTool.qb(6));
            b(this.mTool.qb(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.jBk = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.jeW = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.jeW.setText(string);
        }
        if (!this.jBk.cIL()) {
            this.jBl = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.jBm = (LinearLayout) this.jBl.findViewById(R.id.add_friend_tip_full);
            this.jBn = (TextView) this.jBl.findViewById(R.id.add_friend_tip_title);
            this.jBo = (TextView) this.jBl.findViewById(R.id.add_friend_tip_content);
            this.jBp = (TextView) this.jBl.findViewById(R.id.add_friend_tip_center);
            this.jBq = (Button) this.jBl.findViewById(R.id.add_friend_tip_button);
            this.jBq.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.jBl.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jeW != null) {
            ap.setViewTextColor(this.jeW, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(h hVar) {
        if (hVar != null && hVar != null && (hVar instanceof View)) {
            ((View) hVar).setOnClickListener(this.jBr);
        }
    }

    private void cIO() {
        if (this.mTool != null) {
            this.mTool.brG();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.jBl.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                cIP();
                return;
            case WAIT:
                rc(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                s(z, str);
                return;
            case PASS:
                rd(z);
                return;
            default:
                return;
        }
    }

    private void cIP() {
        this.jBl.setVisibility(8);
        this.jBm.setVisibility(0);
        this.jBp.setVisibility(8);
        this.jBn.setText(R.string.add_friend_title);
        this.jBo.setText(R.string.add_friend_content);
        this.jBq.setText(R.string.add_friend_button);
    }

    private void rc(boolean z) {
        if (this.jBk.cIJ().cJv() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.jBp.startAnimation(translateAnimation);
                }
            });
            this.jBp.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.jBp.setVisibility(0);
                    PersonalChatView.this.jBp.setAnimation(translateAnimation3);
                }
            });
            this.jBm.setVisibility(8);
            this.jBm.startAnimation(translateAnimation4);
        } else {
            this.jBm.setVisibility(8);
            this.jBp.setVisibility(0);
        }
        this.jBp.setText(R.string.add_friend_wait);
        this.jBq.setText(R.string.add_friend_button);
    }

    private void s(boolean z, final String str) {
        final String name_show = this.jBk.cIJ().getUser().getName_show();
        this.jBp.setVisibility(8);
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
                    PersonalChatView.this.jBm.clearAnimation();
                    PersonalChatView.this.jBn.setText(PersonalChatView.this.jBk.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.jBo.setText(str);
                    PersonalChatView.this.jBm.setAnimation(translateAnimation);
                }
            });
            this.jBm.setVisibility(0);
            this.jBm.startAnimation(translateAnimation2);
        } else {
            this.jBm.setVisibility(0);
            this.jBn.setText(this.jBk.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.jBo.setText(str);
        }
        this.jBq.setText(R.string.add_friend_agree_button);
    }

    private void rd(boolean z) {
        cIO();
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
                    PersonalChatView.this.jBl.setVisibility(8);
                }
            });
            this.jBl.startAnimation(translateAnimation);
            return;
        }
        this.jBl.setVisibility(8);
    }

    public Button cIQ() {
        return this.jBq;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
