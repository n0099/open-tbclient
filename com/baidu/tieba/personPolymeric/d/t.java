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
    private LinearLayout aMd;
    private TextView foo;
    private TextView fop;
    private TextView foq;
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
            this.aMd = (LinearLayout) getRootView();
            this.foo = (TextView) this.aMd.findViewById(d.h.attention_btn);
            this.foo.setClickable(true);
            this.fop = (TextView) this.aMd.findViewById(d.h.chat_btn);
            this.fop.setClickable(true);
            this.foq = (TextView) this.aMd.findViewById(d.h.gift_btn);
            this.foq.setClickable(true);
            aZv();
            aZt();
            aZw();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void aZt() {
        if (this.foq != null) {
            aZu();
            this.foq.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.gift_btn), d.g.icon_gift_bar_blue, true));
            ai.i(this.foq, d.e.cp_link_tip_a);
        }
    }

    public void l(boolean z, boolean z2, boolean z3) {
        if (this.foo != null) {
            this.foo.setVisibility(z ? 0 : 8);
        }
        if (this.fop != null) {
            this.fop.setVisibility(z2 ? 0 : 8);
        }
        if (this.foq != null) {
            this.foq.setVisibility(z3 ? 0 : 8);
        }
    }

    private void aZu() {
        if (!TbadkCoreApplication.getInst().isGiftSwitchOn() || TbadkCoreApplication.getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.foq.setVisibility(8);
        } else {
            this.foq.setVisibility(0);
        }
        if (this.mUserData != null && this.mUserData.getIsOfficialAccount() == 1) {
            this.foq.setVisibility(8);
        } else {
            this.foq.setVisibility(0);
        }
    }

    private void Q(View.OnClickListener onClickListener) {
        if (this.foo != null) {
            this.foo.setOnClickListener(onClickListener);
        }
        if (this.fop != null) {
            this.fop.setOnClickListener(onClickListener);
        }
        if (this.foq != null) {
            this.foq.setOnClickListener(onClickListener);
        }
    }

    private void aZv() {
        if (this.foo != null) {
            this.foo.setVisibility(0);
            if (this.mIsLiked) {
                this.foo.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.relate_forum_is_followed), d.g.icon_yiguanzhu_bar_blue, true));
                ai.i(this.foo, d.e.cp_cont_e);
                return;
            }
            this.foo.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.attention), d.g.icon_guanzhu_bar_blue, true));
            ai.i(this.foo, d.e.cp_link_tip_a);
        }
    }

    private void aZw() {
        if (this.fop != null) {
            this.fop.setVisibility(0);
            this.fop.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.private_chat), d.g.icon_message_bar_blue, true));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ai.k(this.aMd, d.e.cp_bg_line_c);
            ai.j(this.foo, d.g.item_person_header_attention_bg_selector);
            ai.i(this.fop, d.e.cp_link_tip_a);
            ai.j(this.fop, d.g.item_person_header_attention_bg_selector);
            ai.j(this.foq, d.g.item_person_header_attention_bg_selector);
            ai.i(this.foq, d.e.cp_link_tip_a);
            if (this.mIsLiked) {
                this.foo.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.relate_forum_is_followed), d.g.icon_yiguanzhu_bar_blue, true));
            } else {
                this.foo.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.attention), d.g.icon_guanzhu_bar_blue, true));
            }
            this.fop.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.private_chat), d.g.icon_message_bar_blue, true));
            this.foq.setText(UtilHelper.getSpannableIconByVertical(getContext(), getContext().getString(d.l.gift_btn), d.g.icon_gift_bar_blue, true));
        }
        this.mSkinType = i;
    }

    public void a(UserData userData, boolean z) {
        this.mUserData = userData;
        setAttentionData(z);
        aZt();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setAttentionData(boolean z) {
        this.mIsLiked = z;
        aZv();
    }
}
