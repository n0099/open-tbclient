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
    private TextView idg;
    private PersonalChatActivity ixn;
    private LinearLayout ixo;
    private LinearLayout ixp;
    private TextView ixq;
    private TextView ixr;
    private TextView ixs;
    private Button ixt;
    private View.OnClickListener ixu;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.ixu = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.ixn.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.ixn.cjv() && this.mTool != null) {
            b(this.mTool.mA(6));
            b(this.mTool.mA(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.ixn = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.idg = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.idg.setText(string);
        }
        if (!this.ixn.cjv()) {
            this.ixo = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.ixp = (LinearLayout) this.ixo.findViewById(R.id.add_friend_tip_full);
            this.ixq = (TextView) this.ixo.findViewById(R.id.add_friend_tip_title);
            this.ixr = (TextView) this.ixo.findViewById(R.id.add_friend_tip_content);
            this.ixs = (TextView) this.ixo.findViewById(R.id.add_friend_tip_center);
            this.ixt = (Button) this.ixo.findViewById(R.id.add_friend_tip_button);
            this.ixt.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.ixo.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.idg != null) {
            am.setViewTextColor(this.idg, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.ixu);
        }
    }

    private void cjx() {
        if (this.mTool != null) {
            this.mTool.aWW();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.ixo.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                cjy();
                return;
            case WAIT:
                pg(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                p(z, str);
                return;
            case PASS:
                ph(z);
                return;
            default:
                return;
        }
    }

    private void cjy() {
        this.ixo.setVisibility(8);
        this.ixp.setVisibility(0);
        this.ixs.setVisibility(8);
        this.ixq.setText(R.string.add_friend_title);
        this.ixr.setText(R.string.add_friend_content);
        this.ixt.setText(R.string.add_friend_button);
    }

    private void pg(boolean z) {
        if (this.ixn.cjt().ckd() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.ixs.startAnimation(translateAnimation);
                }
            });
            this.ixs.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.ixs.setVisibility(0);
                    PersonalChatView.this.ixs.setAnimation(translateAnimation3);
                }
            });
            this.ixp.setVisibility(8);
            this.ixp.startAnimation(translateAnimation4);
        } else {
            this.ixp.setVisibility(8);
            this.ixs.setVisibility(0);
        }
        this.ixs.setText(R.string.add_friend_wait);
        this.ixt.setText(R.string.add_friend_button);
    }

    private void p(boolean z, final String str) {
        final String name_show = this.ixn.cjt().getUser().getName_show();
        this.ixs.setVisibility(8);
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
                    PersonalChatView.this.ixp.clearAnimation();
                    PersonalChatView.this.ixq.setText(PersonalChatView.this.ixn.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.ixr.setText(str);
                    PersonalChatView.this.ixp.setAnimation(translateAnimation);
                }
            });
            this.ixp.setVisibility(0);
            this.ixp.startAnimation(translateAnimation2);
        } else {
            this.ixp.setVisibility(0);
            this.ixq.setText(this.ixn.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.ixr.setText(str);
        }
        this.ixt.setText(R.string.add_friend_agree_button);
    }

    private void ph(boolean z) {
        cjx();
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
                    PersonalChatView.this.ixo.setVisibility(8);
                }
            });
            this.ixo.startAnimation(translateAnimation);
            return;
        }
        this.ixo.setVisibility(8);
    }

    public Button cjz() {
        return this.ixt;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
