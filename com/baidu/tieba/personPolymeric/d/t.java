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
    private LinearLayout aKN;
    private TextView flj;
    private TextView flk;
    private TextView fll;
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
        Q(onClickListener);
    }

    private void bk(Context context) {
        if (context != null) {
            this.aKN = (LinearLayout) getRootView();
            this.flj = (TextView) this.aKN.findViewById(d.h.attention_btn);
            this.flj.setClickable(true);
            this.flk = (TextView) this.aKN.findViewById(d.h.chat_btn);
            this.flk.setClickable(true);
            this.fll = (TextView) this.aKN.findViewById(d.h.gift_btn);
            this.fll.setClickable(true);
            aYD();
            aYB();
            aYE();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void aYB() {
        if (this.fll != null) {
            aYC();
            this.fll.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.gift_btn), d.g.icon_gift_bar_blue, true));
            ai.i(this.fll, d.e.cp_link_tip_a);
        }
    }

    public void k(boolean z, boolean z2, boolean z3) {
        if (this.flj != null) {
            this.flj.setVisibility(z ? 0 : 8);
        }
        if (this.flk != null) {
            this.flk.setVisibility(z2 ? 0 : 8);
        }
        if (this.fll != null) {
            this.fll.setVisibility(z3 ? 0 : 8);
        }
    }

    private void aYC() {
        if (!TbadkCoreApplication.getInst().isGiftSwitchOn() || TbadkCoreApplication.getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.fll.setVisibility(8);
        } else {
            this.fll.setVisibility(0);
        }
        if (this.mUserData != null && this.mUserData.getIsOfficialAccount() == 1) {
            this.fll.setVisibility(8);
        } else {
            this.fll.setVisibility(0);
        }
    }

    private void Q(View.OnClickListener onClickListener) {
        if (this.flj != null) {
            this.flj.setOnClickListener(onClickListener);
        }
        if (this.flk != null) {
            this.flk.setOnClickListener(onClickListener);
        }
        if (this.fll != null) {
            this.fll.setOnClickListener(onClickListener);
        }
    }

    private void aYD() {
        if (this.flj != null) {
            this.flj.setVisibility(0);
            if (this.mIsLiked) {
                this.flj.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.relate_forum_is_followed), d.g.icon_yiguanzhu_bar_blue, true));
                ai.i(this.flj, d.e.cp_cont_e);
                return;
            }
            this.flj.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.attention), d.g.icon_guanzhu_bar_blue, true));
            ai.i(this.flj, d.e.cp_link_tip_a);
        }
    }

    private void aYE() {
        if (this.flk != null) {
            this.flk.setVisibility(0);
            this.flk.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.private_chat), d.g.icon_message_bar_blue, true));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ai.k(this.aKN, d.e.cp_bg_line_c);
            ai.j(this.flj, d.g.item_person_header_attention_bg_selector);
            ai.i(this.flk, d.e.cp_link_tip_a);
            ai.j(this.flk, d.g.item_person_header_attention_bg_selector);
            ai.j(this.fll, d.g.item_person_header_attention_bg_selector);
            ai.i(this.fll, d.e.cp_link_tip_a);
            if (this.mIsLiked) {
                this.flj.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.relate_forum_is_followed), d.g.icon_yiguanzhu_bar_blue, true));
            } else {
                this.flj.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.attention), d.g.icon_guanzhu_bar_blue, true));
            }
            this.flk.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.private_chat), d.g.icon_message_bar_blue, true));
            this.fll.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.gift_btn), d.g.icon_gift_bar_blue, true));
        }
        this.mSkinType = i;
    }

    public void a(UserData userData, boolean z) {
        this.mUserData = userData;
        setAttentionData(z);
        aYB();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setAttentionData(boolean z) {
        this.mIsLiked = z;
        aYD();
    }
}
