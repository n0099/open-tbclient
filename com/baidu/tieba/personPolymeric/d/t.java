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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class t extends LinearLayout {
    private LinearLayout aLK;
    private TextView fmL;
    private TextView fmM;
    private TextView fmN;
    private boolean mIsLiked;
    private int mSkinType;
    private UserData mUserData;

    public t(Context context, UserData userData, boolean z, View.OnClickListener onClickListener) {
        super(context);
        this.mSkinType = 3;
        this.mUserData = userData;
        this.mIsLiked = z;
        LayoutInflater.from(getContext()).inflate(d.j.person_info_relation_view, (ViewGroup) this, true);
        bs(context);
        K(onClickListener);
    }

    private void bs(Context context) {
        if (context != null) {
            this.aLK = (LinearLayout) getRootView();
            this.fmL = (TextView) this.aLK.findViewById(d.h.attention_btn);
            this.fmL.setClickable(true);
            this.fmM = (TextView) this.aLK.findViewById(d.h.chat_btn);
            this.fmM.setClickable(true);
            this.fmN = (TextView) this.aLK.findViewById(d.h.gift_btn);
            this.fmN.setClickable(true);
            aYC();
            aYA();
            aYD();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void aYA() {
        if (this.fmN != null) {
            aYB();
            this.fmN.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.gift_btn), d.g.icon_gift_bar_blue, true));
            aj.i(this.fmN, d.e.cp_link_tip_a);
        }
    }

    public void l(boolean z, boolean z2, boolean z3) {
        if (this.fmL != null) {
            this.fmL.setVisibility(z ? 0 : 8);
        }
        if (this.fmM != null) {
            this.fmM.setVisibility(z2 ? 0 : 8);
        }
        if (this.fmN != null) {
            this.fmN.setVisibility(z3 ? 0 : 8);
        }
    }

    private void aYB() {
        if (!TbadkCoreApplication.getInst().isGiftSwitchOn() || TbadkCoreApplication.getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.fmN.setVisibility(8);
        } else {
            this.fmN.setVisibility(0);
        }
        if (this.mUserData != null && this.mUserData.getIsOfficialAccount() == 1) {
            this.fmN.setVisibility(8);
        } else {
            this.fmN.setVisibility(0);
        }
    }

    private void K(View.OnClickListener onClickListener) {
        if (this.fmL != null) {
            this.fmL.setOnClickListener(onClickListener);
        }
        if (this.fmM != null) {
            this.fmM.setOnClickListener(onClickListener);
        }
        if (this.fmN != null) {
            this.fmN.setOnClickListener(onClickListener);
        }
    }

    private void aYC() {
        if (this.fmL != null) {
            this.fmL.setVisibility(0);
            if (this.mIsLiked) {
                this.fmL.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.relate_forum_is_followed), d.g.icon_yiguanzhu_bar_blue, true));
                aj.i(this.fmL, d.e.cp_cont_e);
                return;
            }
            this.fmL.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.attention), d.g.icon_guanzhu_bar_blue, true));
            aj.i(this.fmL, d.e.cp_link_tip_a);
        }
    }

    private void aYD() {
        if (this.fmM != null) {
            this.fmM.setVisibility(0);
            this.fmM.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.private_chat), d.g.icon_message_bar_blue, true));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.k(this.aLK, d.e.cp_bg_line_c);
            aj.j(this.fmL, d.g.item_person_header_attention_bg_selector);
            aj.i(this.fmM, d.e.cp_link_tip_a);
            aj.j(this.fmM, d.g.item_person_header_attention_bg_selector);
            aj.j(this.fmN, d.g.item_person_header_attention_bg_selector);
            aj.i(this.fmN, d.e.cp_link_tip_a);
            if (this.mIsLiked) {
                this.fmL.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.relate_forum_is_followed), d.g.icon_yiguanzhu_bar_blue, true));
            } else {
                this.fmL.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.attention), d.g.icon_guanzhu_bar_blue, true));
            }
            this.fmM.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.private_chat), d.g.icon_message_bar_blue, true));
            this.fmN.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.gift_btn), d.g.icon_gift_bar_blue, true));
        }
        this.mSkinType = i;
    }

    public void a(UserData userData, boolean z) {
        this.mUserData = userData;
        setAttentionData(z);
        aYA();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setAttentionData(boolean z) {
        this.mIsLiked = z;
        aYC();
    }
}
