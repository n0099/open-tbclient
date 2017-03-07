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
    private LinearLayout aIi;
    private TextView eJp;
    private TextView eJq;
    private boolean mIsLiked;
    private int mSkinType;

    public af(Context context, boolean z, View.OnClickListener onClickListener) {
        super(context);
        this.mSkinType = 3;
        this.mIsLiked = z;
        LayoutInflater.from(getContext()).inflate(w.j.person_info_relation_view, (ViewGroup) this, true);
        bs(context);
        N(onClickListener);
    }

    private void bs(Context context) {
        if (context != null) {
            this.aIi = (LinearLayout) getRootView();
            this.eJp = (TextView) this.aIi.findViewById(w.h.attention_btn);
            this.eJp.setClickable(true);
            aRz();
            this.eJq = (TextView) this.aIi.findViewById(w.h.chat_btn);
            this.eJq.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(w.l.private_chat), w.g.icon_mine_bar_chat, true));
            this.eJq.setClickable(true);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void N(View.OnClickListener onClickListener) {
        if (this.eJp != null) {
            this.eJp.setOnClickListener(onClickListener);
        }
        if (this.eJq != null) {
            this.eJq.setOnClickListener(onClickListener);
        }
    }

    private void aRz() {
        if (this.eJp != null) {
            if (this.mIsLiked) {
                this.eJp.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(w.l.relate_forum_is_followed), w.g.icon_mine_bar_add_ok, true));
                aq.i((View) this.eJp, w.e.cp_cont_e);
                return;
            }
            this.eJp.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(w.l.attention), w.g.icon_mine_bar_add, true));
            aq.i((View) this.eJp, w.e.cp_link_tip_a);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aq.k(this.aIi, w.e.cp_bg_line_c);
            aq.j(this.eJp, w.g.item_person_header_attention_bg_selector);
            aq.i((View) this.eJq, w.e.cp_link_tip_a);
            aq.j(this.eJq, w.g.item_person_header_attention_bg_selector);
        }
        this.mSkinType = i;
    }

    public void setData(boolean z) {
        this.mIsLiked = z;
        aRz();
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }
}
