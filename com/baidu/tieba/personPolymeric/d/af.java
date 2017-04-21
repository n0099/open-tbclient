package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class af extends LinearLayout {
    private LinearLayout aIA;
    private TextView eJA;
    private TextView eJB;
    private boolean mIsLiked;
    private int mSkinType;

    public af(Context context, boolean z, View.OnClickListener onClickListener) {
        super(context);
        this.mSkinType = 3;
        this.mIsLiked = z;
        LayoutInflater.from(getContext()).inflate(w.j.person_info_relation_view, (ViewGroup) this, true);
        bm(context);
        O(onClickListener);
    }

    private void bm(Context context) {
        if (context != null) {
            this.aIA = (LinearLayout) getRootView();
            this.eJA = (TextView) this.aIA.findViewById(w.h.attention_btn);
            this.eJA.setClickable(true);
            aSJ();
            this.eJB = (TextView) this.aIA.findViewById(w.h.chat_btn);
            this.eJB.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(w.l.private_chat), w.g.icon_mine_bar_chat, true));
            this.eJB.setClickable(true);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void O(View.OnClickListener onClickListener) {
        if (this.eJA != null) {
            this.eJA.setOnClickListener(onClickListener);
        }
        if (this.eJB != null) {
            this.eJB.setOnClickListener(onClickListener);
        }
    }

    private void aSJ() {
        if (this.eJA != null) {
            if (this.mIsLiked) {
                this.eJA.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(w.l.relate_forum_is_followed), w.g.icon_mine_bar_add_ok, true));
                aq.i(this.eJA, w.e.cp_cont_e);
                return;
            }
            this.eJA.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(w.l.attention), w.g.icon_mine_bar_add, true));
            aq.i(this.eJA, w.e.cp_link_tip_a);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aq.k(this.aIA, w.e.cp_bg_line_c);
            aq.j(this.eJA, w.g.item_person_header_attention_bg_selector);
            aq.i(this.eJB, w.e.cp_link_tip_a);
            aq.j(this.eJB, w.g.item_person_header_attention_bg_selector);
        }
        this.mSkinType = i;
    }

    public void setData(boolean z) {
        this.mIsLiked = z;
        aSJ();
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }
}
