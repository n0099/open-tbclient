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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class t extends LinearLayout {
    private LinearLayout aMe;
    private TextView foq;

    /* renamed from: for  reason: not valid java name */
    private TextView f0for;
    private TextView fot;
    private boolean mIsLiked;
    private int mSkinType;
    private UserData mUserData;

    public t(Context context, UserData userData, boolean z, View.OnClickListener onClickListener) {
        super(context);
        this.mSkinType = 3;
        this.mUserData = userData;
        this.mIsLiked = z;
        LayoutInflater.from(getContext()).inflate(d.j.person_info_relation_view, (ViewGroup) this, true);
        bk(context);
        M(onClickListener);
    }

    private void bk(Context context) {
        if (context != null) {
            this.aMe = (LinearLayout) getRootView();
            this.foq = (TextView) this.aMe.findViewById(d.h.attention_btn);
            this.foq.setClickable(true);
            this.f0for = (TextView) this.aMe.findViewById(d.h.chat_btn);
            this.f0for.setClickable(true);
            this.fot = (TextView) this.aMe.findViewById(d.h.gift_btn);
            this.fot.setClickable(true);
            aZq();
            aZo();
            aZr();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void aZo() {
        if (this.fot != null) {
            aZp();
            this.fot.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.gift_btn), d.g.icon_gift_bar_blue, true));
            ai.i(this.fot, d.e.cp_link_tip_a);
        }
    }

    public void l(boolean z, boolean z2, boolean z3) {
        if (this.foq != null) {
            this.foq.setVisibility(z ? 0 : 8);
        }
        if (this.f0for != null) {
            this.f0for.setVisibility(z2 ? 0 : 8);
        }
        if (this.fot != null) {
            this.fot.setVisibility(z3 ? 0 : 8);
        }
    }

    private void aZp() {
        if (!TbadkCoreApplication.getInst().isGiftSwitchOn() || TbadkCoreApplication.getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.fot.setVisibility(8);
        } else {
            this.fot.setVisibility(0);
        }
        if (this.mUserData != null && this.mUserData.getIsOfficialAccount() == 1) {
            this.fot.setVisibility(8);
        } else {
            this.fot.setVisibility(0);
        }
    }

    private void M(View.OnClickListener onClickListener) {
        if (this.foq != null) {
            this.foq.setOnClickListener(onClickListener);
        }
        if (this.f0for != null) {
            this.f0for.setOnClickListener(onClickListener);
        }
        if (this.fot != null) {
            this.fot.setOnClickListener(onClickListener);
        }
    }

    private void aZq() {
        if (this.foq != null) {
            this.foq.setVisibility(0);
            if (this.mIsLiked) {
                this.foq.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.relate_forum_is_followed), d.g.icon_yiguanzhu_bar_blue, true));
                ai.i(this.foq, d.e.cp_cont_e);
                return;
            }
            this.foq.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.attention), d.g.icon_guanzhu_bar_blue, true));
            ai.i(this.foq, d.e.cp_link_tip_a);
        }
    }

    private void aZr() {
        if (this.f0for != null) {
            this.f0for.setVisibility(0);
            this.f0for.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.private_chat), d.g.icon_message_bar_blue, true));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ai.k(this.aMe, d.e.cp_bg_line_c);
            ai.j(this.foq, d.g.item_person_header_attention_bg_selector);
            ai.i(this.f0for, d.e.cp_link_tip_a);
            ai.j(this.f0for, d.g.item_person_header_attention_bg_selector);
            ai.j(this.fot, d.g.item_person_header_attention_bg_selector);
            ai.i(this.fot, d.e.cp_link_tip_a);
            if (this.mIsLiked) {
                this.foq.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.relate_forum_is_followed), d.g.icon_yiguanzhu_bar_blue, true));
            } else {
                this.foq.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.attention), d.g.icon_guanzhu_bar_blue, true));
            }
            this.f0for.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.private_chat), d.g.icon_message_bar_blue, true));
            this.fot.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.gift_btn), d.g.icon_gift_bar_blue, true));
        }
        this.mSkinType = i;
    }

    public void a(UserData userData, boolean z) {
        this.mUserData = userData;
        setAttentionData(z);
        aZo();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setAttentionData(boolean z) {
        this.mIsLiked = z;
        aZq();
    }
}
