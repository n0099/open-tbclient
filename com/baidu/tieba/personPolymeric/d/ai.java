package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ai extends LinearLayout {
    private LinearLayout ame;
    private TextView eOi;
    private TextView eOj;
    private TextView eOk;
    private boolean mIsLiked;
    private int mSkinType;
    private UserData mUserData;

    public ai(Context context, UserData userData, boolean z, View.OnClickListener onClickListener) {
        super(context);
        this.mSkinType = 3;
        this.mUserData = userData;
        this.mIsLiked = z;
        LayoutInflater.from(getContext()).inflate(w.j.person_info_relation_view, (ViewGroup) this, true);
        bp(context);
        R(onClickListener);
    }

    private void bp(Context context) {
        if (context != null) {
            this.ame = (LinearLayout) getRootView();
            this.eOi = (TextView) this.ame.findViewById(w.h.attention_btn);
            this.eOi.setClickable(true);
            this.eOj = (TextView) this.ame.findViewById(w.h.chat_btn);
            this.eOj.setClickable(true);
            this.eOk = (TextView) this.ame.findViewById(w.h.gift_btn);
            this.eOk.setClickable(true);
            aRy();
            aRx();
            aRz();
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void aRx() {
        if (this.eOk != null) {
            TC();
            this.eOk.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(w.l.gift_btn), w.g.icon_gift_bar_blue, true));
            aq.i(this.eOk, w.e.cp_link_tip_a);
        }
    }

    public void j(boolean z, boolean z2, boolean z3) {
        if (this.eOi != null) {
            this.eOi.setVisibility(z ? 0 : 8);
        }
        if (this.eOj != null) {
            this.eOj.setVisibility(z2 ? 0 : 8);
        }
        if (this.eOk != null) {
            this.eOk.setVisibility(z3 ? 0 : 8);
        }
    }

    private void TC() {
        if (!TbadkCoreApplication.m9getInst().isGiftSwitchOn() || TbadkCoreApplication.m9getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.eOk.setVisibility(8);
        } else {
            this.eOk.setVisibility(0);
        }
        if (this.mUserData != null && this.mUserData.getIsOfficialAccount() == 1) {
            this.eOk.setVisibility(8);
        } else {
            this.eOk.setVisibility(0);
        }
    }

    private void R(View.OnClickListener onClickListener) {
        if (this.eOi != null) {
            this.eOi.setOnClickListener(onClickListener);
        }
        if (this.eOj != null) {
            this.eOj.setOnClickListener(onClickListener);
        }
        if (this.eOk != null) {
            this.eOk.setOnClickListener(onClickListener);
        }
    }

    private void aRy() {
        if (this.eOi != null) {
            this.eOi.setVisibility(0);
            if (this.mIsLiked) {
                this.eOi.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(w.l.relate_forum_is_followed), w.g.icon_yiguanzhu_bar_blue, true));
                aq.i(this.eOi, w.e.cp_cont_e);
                return;
            }
            this.eOi.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(w.l.attention), w.g.icon_guanzhu_bar_blue, true));
            aq.i(this.eOi, w.e.cp_link_tip_a);
        }
    }

    private void aRz() {
        if (this.eOj != null) {
            this.eOj.setVisibility(0);
            this.eOj.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(w.l.private_chat), w.g.icon_message_bar_blue, true));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aq.k(this.ame, w.e.cp_bg_line_c);
            aq.j(this.eOi, w.g.item_person_header_attention_bg_selector);
            aq.i(this.eOj, w.e.cp_link_tip_a);
            aq.j(this.eOj, w.g.item_person_header_attention_bg_selector);
            aq.j(this.eOk, w.g.item_person_header_attention_bg_selector);
            aq.i(this.eOk, w.e.cp_link_tip_a);
            if (this.mIsLiked) {
                this.eOi.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(w.l.relate_forum_is_followed), w.g.icon_yiguanzhu_bar_blue, true));
            } else {
                this.eOi.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(w.l.attention), w.g.icon_guanzhu_bar_blue, true));
            }
            this.eOj.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(w.l.private_chat), w.g.icon_message_bar_blue, true));
            this.eOk.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(w.l.gift_btn), w.g.icon_gift_bar_blue, true));
        }
        this.mSkinType = i;
    }

    public void a(UserData userData, boolean z) {
        this.mUserData = userData;
        setAttentionData(z);
        aRx();
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setAttentionData(boolean z) {
        this.mIsLiked = z;
        aRy();
    }
}
