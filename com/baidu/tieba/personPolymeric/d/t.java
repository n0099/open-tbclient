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
    private LinearLayout aLH;
    private TextView fnE;
    private TextView fnF;
    private TextView fnG;
    private boolean mIsLiked;
    private int mSkinType;
    private UserData mUserData;

    public t(Context context, UserData userData, boolean z, View.OnClickListener onClickListener) {
        super(context);
        this.mSkinType = 3;
        this.mUserData = userData;
        this.mIsLiked = z;
        LayoutInflater.from(getContext()).inflate(d.j.person_info_relation_view, (ViewGroup) this, true);
        bt(context);
        K(onClickListener);
    }

    private void bt(Context context) {
        if (context != null) {
            this.aLH = (LinearLayout) getRootView();
            this.fnE = (TextView) this.aLH.findViewById(d.h.attention_btn);
            this.fnE.setClickable(true);
            this.fnF = (TextView) this.aLH.findViewById(d.h.chat_btn);
            this.fnF.setClickable(true);
            this.fnG = (TextView) this.aLH.findViewById(d.h.gift_btn);
            this.fnG.setClickable(true);
            aYN();
            aYL();
            aYO();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void aYL() {
        if (this.fnG != null) {
            aYM();
            this.fnG.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.gift_btn), d.g.icon_gift_bar_blue, true));
            aj.i(this.fnG, d.e.cp_link_tip_a);
        }
    }

    public void l(boolean z, boolean z2, boolean z3) {
        if (this.fnE != null) {
            this.fnE.setVisibility(z ? 0 : 8);
        }
        if (this.fnF != null) {
            this.fnF.setVisibility(z2 ? 0 : 8);
        }
        if (this.fnG != null) {
            this.fnG.setVisibility(z3 ? 0 : 8);
        }
    }

    private void aYM() {
        if (!TbadkCoreApplication.getInst().isGiftSwitchOn() || TbadkCoreApplication.getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.fnG.setVisibility(8);
        } else {
            this.fnG.setVisibility(0);
        }
        if (this.mUserData != null && this.mUserData.getIsOfficialAccount() == 1) {
            this.fnG.setVisibility(8);
        } else {
            this.fnG.setVisibility(0);
        }
    }

    private void K(View.OnClickListener onClickListener) {
        if (this.fnE != null) {
            this.fnE.setOnClickListener(onClickListener);
        }
        if (this.fnF != null) {
            this.fnF.setOnClickListener(onClickListener);
        }
        if (this.fnG != null) {
            this.fnG.setOnClickListener(onClickListener);
        }
    }

    private void aYN() {
        if (this.fnE != null) {
            this.fnE.setVisibility(0);
            if (this.mIsLiked) {
                this.fnE.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.relate_forum_is_followed), d.g.icon_yiguanzhu_bar_blue, true));
                aj.i(this.fnE, d.e.cp_cont_e);
                return;
            }
            this.fnE.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.attention), d.g.icon_guanzhu_bar_blue, true));
            aj.i(this.fnE, d.e.cp_link_tip_a);
        }
    }

    private void aYO() {
        if (this.fnF != null) {
            this.fnF.setVisibility(0);
            this.fnF.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.private_chat), d.g.icon_message_bar_blue, true));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.k(this.aLH, d.e.cp_bg_line_c);
            aj.j(this.fnE, d.g.item_person_header_attention_bg_selector);
            aj.i(this.fnF, d.e.cp_link_tip_a);
            aj.j(this.fnF, d.g.item_person_header_attention_bg_selector);
            aj.j(this.fnG, d.g.item_person_header_attention_bg_selector);
            aj.i(this.fnG, d.e.cp_link_tip_a);
            if (this.mIsLiked) {
                this.fnE.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.relate_forum_is_followed), d.g.icon_yiguanzhu_bar_blue, true));
            } else {
                this.fnE.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.attention), d.g.icon_guanzhu_bar_blue, true));
            }
            this.fnF.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.private_chat), d.g.icon_message_bar_blue, true));
            this.fnG.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.gift_btn), d.g.icon_gift_bar_blue, true));
        }
        this.mSkinType = i;
    }

    public void a(UserData userData, boolean z) {
        this.mUserData = userData;
        setAttentionData(z);
        aYL();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setAttentionData(boolean z) {
        this.mIsLiked = z;
        aYN();
    }
}
