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
public class ak extends LinearLayout {
    private LinearLayout amo;
    private TextView eFy;
    private TextView eFz;
    private boolean mIsLiked;
    private int mSkinType;

    public ak(Context context, boolean z, View.OnClickListener onClickListener) {
        super(context);
        this.mSkinType = 3;
        this.mIsLiked = z;
        LayoutInflater.from(getContext()).inflate(w.j.person_info_relation_view, (ViewGroup) this, true);
        bp(context);
        P(onClickListener);
    }

    private void bp(Context context) {
        if (context != null) {
            this.amo = (LinearLayout) getRootView();
            this.eFy = (TextView) this.amo.findViewById(w.h.attention_btn);
            this.eFy.setClickable(true);
            this.eFz = (TextView) this.amo.findViewById(w.h.chat_btn);
            this.eFz.setClickable(true);
            aQh();
            aQi();
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void P(View.OnClickListener onClickListener) {
        if (this.eFy != null) {
            this.eFy.setOnClickListener(onClickListener);
        }
        if (this.eFz != null) {
            this.eFz.setOnClickListener(onClickListener);
        }
    }

    private void aQh() {
        if (this.eFy != null) {
            this.eFz.setVisibility(8);
            this.eFy.setVisibility(0);
            if (this.mIsLiked) {
                this.eFy.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(w.l.relate_forum_is_followed), w.g.icon_mine_bar_add_ok, true));
                aq.i(this.eFy, w.e.cp_cont_e);
                return;
            }
            this.eFy.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(w.l.attention), w.g.icon_mine_bar_add, true));
            aq.i(this.eFy, w.e.cp_link_tip_a);
        }
    }

    private void aQi() {
        if (this.eFz != null) {
            if (this.mIsLiked) {
                this.eFy.setVisibility(8);
                this.eFz.setVisibility(0);
                this.eFz.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(w.l.private_chat), w.g.icon_mine_bar_chat, true));
                return;
            }
            this.eFz.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aq.k(this.amo, w.e.cp_bg_line_c);
            aq.j(this.eFy, w.g.item_person_header_attention_bg_selector);
            aq.i(this.eFz, w.e.cp_link_tip_a);
            aq.j(this.eFz, w.g.item_person_header_attention_bg_selector);
        }
        this.mSkinType = i;
    }

    public void setData(boolean z) {
        this.mIsLiked = z;
        aQh();
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }
}
