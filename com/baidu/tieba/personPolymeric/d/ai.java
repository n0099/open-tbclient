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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ai extends LinearLayout {
    private LinearLayout aJF;
    private TextView eYA;
    private TextView eYy;
    private TextView eYz;
    private boolean mIsLiked;
    private int mSkinType;
    private UserData mUserData;

    public ai(Context context, UserData userData, boolean z, View.OnClickListener onClickListener) {
        super(context);
        this.mSkinType = 3;
        this.mUserData = userData;
        this.mIsLiked = z;
        LayoutInflater.from(getContext()).inflate(w.j.person_info_relation_view, (ViewGroup) this, true);
        bj(context);
        S(onClickListener);
    }

    private void bj(Context context) {
        if (context != null) {
            this.aJF = (LinearLayout) getRootView();
            this.eYy = (TextView) this.aJF.findViewById(w.h.attention_btn);
            this.eYy.setClickable(true);
            this.eYz = (TextView) this.aJF.findViewById(w.h.chat_btn);
            this.eYz.setClickable(true);
            this.eYA = (TextView) this.aJF.findViewById(w.h.gift_btn);
            this.eYA.setClickable(true);
            aVI();
            aVG();
            aVJ();
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void aVG() {
        if (this.eYA != null) {
            aVH();
            this.eYA.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(w.l.gift_btn), w.g.icon_gift_bar_blue, true));
            as.i(this.eYA, w.e.cp_link_tip_a);
        }
    }

    public void i(boolean z, boolean z2, boolean z3) {
        if (this.eYy != null) {
            this.eYy.setVisibility(z ? 0 : 8);
        }
        if (this.eYz != null) {
            this.eYz.setVisibility(z2 ? 0 : 8);
        }
        if (this.eYA != null) {
            this.eYA.setVisibility(z3 ? 0 : 8);
        }
    }

    private void aVH() {
        if (!TbadkCoreApplication.m9getInst().isGiftSwitchOn() || TbadkCoreApplication.m9getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.eYA.setVisibility(8);
        } else {
            this.eYA.setVisibility(0);
        }
        if (this.mUserData != null && this.mUserData.getIsOfficialAccount() == 1) {
            this.eYA.setVisibility(8);
        } else {
            this.eYA.setVisibility(0);
        }
    }

    private void S(View.OnClickListener onClickListener) {
        if (this.eYy != null) {
            this.eYy.setOnClickListener(onClickListener);
        }
        if (this.eYz != null) {
            this.eYz.setOnClickListener(onClickListener);
        }
        if (this.eYA != null) {
            this.eYA.setOnClickListener(onClickListener);
        }
    }

    private void aVI() {
        if (this.eYy != null) {
            this.eYy.setVisibility(0);
            if (this.mIsLiked) {
                this.eYy.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(w.l.relate_forum_is_followed), w.g.icon_yiguanzhu_bar_blue, true));
                as.i(this.eYy, w.e.cp_cont_e);
                return;
            }
            this.eYy.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(w.l.attention), w.g.icon_guanzhu_bar_blue, true));
            as.i(this.eYy, w.e.cp_link_tip_a);
        }
    }

    private void aVJ() {
        if (this.eYz != null) {
            this.eYz.setVisibility(0);
            this.eYz.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(w.l.private_chat), w.g.icon_message_bar_blue, true));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            as.k(this.aJF, w.e.cp_bg_line_c);
            as.j(this.eYy, w.g.item_person_header_attention_bg_selector);
            as.i(this.eYz, w.e.cp_link_tip_a);
            as.j(this.eYz, w.g.item_person_header_attention_bg_selector);
            as.j(this.eYA, w.g.item_person_header_attention_bg_selector);
            as.i(this.eYA, w.e.cp_link_tip_a);
            if (this.mIsLiked) {
                this.eYy.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(w.l.relate_forum_is_followed), w.g.icon_yiguanzhu_bar_blue, true));
            } else {
                this.eYy.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(w.l.attention), w.g.icon_guanzhu_bar_blue, true));
            }
            this.eYz.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(w.l.private_chat), w.g.icon_message_bar_blue, true));
            this.eYA.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(w.l.gift_btn), w.g.icon_gift_bar_blue, true));
        }
        this.mSkinType = i;
    }

    public void a(UserData userData, boolean z) {
        this.mUserData = userData;
        setAttentionData(z);
        aVG();
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void setAttentionData(boolean z) {
        this.mIsLiked = z;
        aVI();
    }
}
