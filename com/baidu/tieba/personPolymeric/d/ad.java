package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ad extends LinearLayout {
    private LinearLayout aEC;
    private TextView eSq;
    private TextView eSr;
    private boolean mIsLiked;
    private int mSkinType;

    public ad(Context context, boolean z, View.OnClickListener onClickListener) {
        super(context);
        this.mSkinType = 3;
        this.mIsLiked = z;
        LayoutInflater.from(getContext()).inflate(r.h.person_info_relation_view, (ViewGroup) this, true);
        aO(context);
        P(onClickListener);
    }

    private void aO(Context context) {
        if (context != null) {
            this.aEC = (LinearLayout) getRootView();
            this.eSq = (TextView) this.aEC.findViewById(r.g.attention_btn);
            this.eSq.setClickable(true);
            aWn();
            this.eSr = (TextView) this.aEC.findViewById(r.g.chat_btn);
            this.eSr.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(r.j.private_chat), r.f.icon_mine_bar_chat, true));
            this.eSr.setClickable(true);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void P(View.OnClickListener onClickListener) {
        if (this.eSq != null) {
            this.eSq.setOnClickListener(onClickListener);
        }
        if (this.eSr != null) {
            this.eSr.setOnClickListener(onClickListener);
        }
    }

    private void aWn() {
        if (this.eSq != null) {
            if (this.mIsLiked) {
                this.eSq.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(r.j.relate_forum_is_followed), r.f.icon_mine_bar_add_ok, true));
                at.j((View) this.eSq, r.d.cp_cont_e);
                return;
            }
            this.eSq.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(r.j.attention), r.f.icon_mine_bar_add, true));
            at.j((View) this.eSq, r.d.cp_link_tip_a);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            at.l(this.aEC, r.d.cp_bg_line_c);
            at.k(this.eSq, r.f.item_person_header_attention_bg_selector);
            at.j((View) this.eSr, r.d.cp_link_tip_a);
            at.k(this.eSr, r.f.item_person_header_attention_bg_selector);
        }
        this.mSkinType = i;
    }

    public void setData(boolean z) {
        this.mIsLiked = z;
        aWn();
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }
}
