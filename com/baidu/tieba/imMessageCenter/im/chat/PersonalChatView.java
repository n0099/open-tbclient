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
    private TextView jUV;
    private PersonalChatActivity krf;
    private LinearLayout krg;
    private LinearLayout krh;
    private TextView kri;
    private TextView krj;
    private TextView krk;
    private Button krl;
    private View.OnClickListener krm;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.krm = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.krf.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.krf.cVH() && this.mTool != null) {
            b(this.mTool.rh(6));
            b(this.mTool.rh(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.krf = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.jUV = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.jUV.setText(string);
        }
        if (!this.krf.cVH()) {
            this.krg = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.krh = (LinearLayout) this.krg.findViewById(R.id.add_friend_tip_full);
            this.kri = (TextView) this.krg.findViewById(R.id.add_friend_tip_title);
            this.krj = (TextView) this.krg.findViewById(R.id.add_friend_tip_content);
            this.krk = (TextView) this.krg.findViewById(R.id.add_friend_tip_center);
            this.krl = (Button) this.krg.findViewById(R.id.add_friend_tip_button);
            this.krl.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.krg.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jUV != null) {
            ap.setViewTextColor(this.jUV, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(h hVar) {
        if (hVar != null && hVar != null && (hVar instanceof View)) {
            ((View) hVar).setOnClickListener(this.krm);
        }
    }

    private void cVK() {
        if (this.mTool != null) {
            this.mTool.bzJ();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.krg.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                cVL();
                return;
            case WAIT:
                sr(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                u(z, str);
                return;
            case PASS:
                ss(z);
                return;
            default:
                return;
        }
    }

    private void cVL() {
        this.krg.setVisibility(8);
        this.krh.setVisibility(0);
        this.krk.setVisibility(8);
        this.kri.setText(R.string.add_friend_title);
        this.krj.setText(R.string.add_friend_content);
        this.krl.setText(R.string.add_friend_button);
    }

    private void sr(boolean z) {
        if (this.krf.cVF().cWr() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.krk.startAnimation(translateAnimation);
                }
            });
            this.krk.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.krk.setVisibility(0);
                    PersonalChatView.this.krk.setAnimation(translateAnimation3);
                }
            });
            this.krh.setVisibility(8);
            this.krh.startAnimation(translateAnimation4);
        } else {
            this.krh.setVisibility(8);
            this.krk.setVisibility(0);
        }
        this.krk.setText(R.string.add_friend_wait);
        this.krl.setText(R.string.add_friend_button);
    }

    private void u(boolean z, final String str) {
        final String name_show = this.krf.cVF().getUser().getName_show();
        this.krk.setVisibility(8);
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
                    PersonalChatView.this.krh.clearAnimation();
                    PersonalChatView.this.kri.setText(PersonalChatView.this.krf.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.krj.setText(str);
                    PersonalChatView.this.krh.setAnimation(translateAnimation);
                }
            });
            this.krh.setVisibility(0);
            this.krh.startAnimation(translateAnimation2);
        } else {
            this.krh.setVisibility(0);
            this.kri.setText(this.krf.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.krj.setText(str);
        }
        this.krl.setText(R.string.add_friend_agree_button);
    }

    private void ss(boolean z) {
        cVK();
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
                    PersonalChatView.this.krg.setVisibility(8);
                }
            });
            this.krg.startAnimation(translateAnimation);
            return;
        }
        this.krg.setVisibility(8);
    }

    public Button cVM() {
        return this.krl;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
