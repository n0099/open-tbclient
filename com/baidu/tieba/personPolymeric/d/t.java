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
    private LinearLayout aMc;
    private TextView fmv;
    private TextView fmw;
    private TextView fmx;
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
            this.aMc = (LinearLayout) getRootView();
            this.fmv = (TextView) this.aMc.findViewById(d.h.attention_btn);
            this.fmv.setClickable(true);
            this.fmw = (TextView) this.aMc.findViewById(d.h.chat_btn);
            this.fmw.setClickable(true);
            this.fmx = (TextView) this.aMc.findViewById(d.h.gift_btn);
            this.fmx.setClickable(true);
            aYO();
            aYM();
            aYP();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void aYM() {
        if (this.fmx != null) {
            aYN();
            this.fmx.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.gift_btn), d.g.icon_gift_bar_blue, true));
            ai.i(this.fmx, d.e.cp_link_tip_a);
        }
    }

    public void k(boolean z, boolean z2, boolean z3) {
        if (this.fmv != null) {
            this.fmv.setVisibility(z ? 0 : 8);
        }
        if (this.fmw != null) {
            this.fmw.setVisibility(z2 ? 0 : 8);
        }
        if (this.fmx != null) {
            this.fmx.setVisibility(z3 ? 0 : 8);
        }
    }

    private void aYN() {
        if (!TbadkCoreApplication.getInst().isGiftSwitchOn() || TbadkCoreApplication.getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.fmx.setVisibility(8);
        } else {
            this.fmx.setVisibility(0);
        }
        if (this.mUserData != null && this.mUserData.getIsOfficialAccount() == 1) {
            this.fmx.setVisibility(8);
        } else {
            this.fmx.setVisibility(0);
        }
    }

    private void Q(View.OnClickListener onClickListener) {
        if (this.fmv != null) {
            this.fmv.setOnClickListener(onClickListener);
        }
        if (this.fmw != null) {
            this.fmw.setOnClickListener(onClickListener);
        }
        if (this.fmx != null) {
            this.fmx.setOnClickListener(onClickListener);
        }
    }

    private void aYO() {
        if (this.fmv != null) {
            this.fmv.setVisibility(0);
            if (this.mIsLiked) {
                this.fmv.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.relate_forum_is_followed), d.g.icon_yiguanzhu_bar_blue, true));
                ai.i(this.fmv, d.e.cp_cont_e);
                return;
            }
            this.fmv.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.attention), d.g.icon_guanzhu_bar_blue, true));
            ai.i(this.fmv, d.e.cp_link_tip_a);
        }
    }

    private void aYP() {
        if (this.fmw != null) {
            this.fmw.setVisibility(0);
            this.fmw.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.private_chat), d.g.icon_message_bar_blue, true));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ai.k(this.aMc, d.e.cp_bg_line_c);
            ai.j(this.fmv, d.g.item_person_header_attention_bg_selector);
            ai.i(this.fmw, d.e.cp_link_tip_a);
            ai.j(this.fmw, d.g.item_person_header_attention_bg_selector);
            ai.j(this.fmx, d.g.item_person_header_attention_bg_selector);
            ai.i(this.fmx, d.e.cp_link_tip_a);
            if (this.mIsLiked) {
                this.fmv.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.relate_forum_is_followed), d.g.icon_yiguanzhu_bar_blue, true));
            } else {
                this.fmv.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.attention), d.g.icon_guanzhu_bar_blue, true));
            }
            this.fmw.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.private_chat), d.g.icon_message_bar_blue, true));
            this.fmx.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.gift_btn), d.g.icon_gift_bar_blue, true));
        }
        this.mSkinType = i;
    }

    public void a(UserData userData, boolean z) {
        this.mUserData = userData;
        setAttentionData(z);
        aYM();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setAttentionData(boolean z) {
        this.mIsLiked = z;
        aYO();
    }
}
