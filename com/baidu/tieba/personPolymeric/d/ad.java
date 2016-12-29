package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ad extends LinearLayout {
    private LinearLayout aDV;
    private TextView evP;
    private TextView evQ;
    private boolean mIsLiked;
    private int mSkinType;

    public ad(Context context, boolean z, View.OnClickListener onClickListener) {
        super(context);
        this.mSkinType = 3;
        this.mIsLiked = z;
        LayoutInflater.from(getContext()).inflate(r.h.person_info_relation_view, (ViewGroup) this, true);
        aN(context);
        M(onClickListener);
    }

    private void aN(Context context) {
        if (context != null) {
            this.aDV = (LinearLayout) getRootView();
            this.evP = (TextView) this.aDV.findViewById(r.g.attention_btn);
            this.evP.setClickable(true);
            aPX();
            this.evQ = (TextView) this.aDV.findViewById(r.g.chat_btn);
            this.evQ.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(r.j.private_chat), r.f.icon_mine_bar_chat, true));
            this.evQ.setClickable(true);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void M(View.OnClickListener onClickListener) {
        if (this.evP != null) {
            this.evP.setOnClickListener(onClickListener);
        }
        if (this.evQ != null) {
            this.evQ.setOnClickListener(onClickListener);
        }
    }

    private void aPX() {
        if (this.evP != null) {
            if (this.mIsLiked) {
                this.evP.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(r.j.relate_forum_is_followed), r.f.icon_mine_bar_add_ok, true));
                ar.j((View) this.evP, r.d.cp_cont_e);
                return;
            }
            this.evP.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(r.j.attention), r.f.icon_mine_bar_add, true));
            ar.j((View) this.evP, r.d.cp_link_tip_a);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ar.l(this.aDV, r.d.cp_bg_line_c);
            ar.k(this.evP, r.f.item_person_header_attention_bg_selector);
            ar.j((View) this.evQ, r.d.cp_link_tip_a);
            ar.k(this.evQ, r.f.item_person_header_attention_bg_selector);
        }
        this.mSkinType = i;
    }

    public void setData(boolean z) {
        this.mIsLiked = z;
        aPX();
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }
}
