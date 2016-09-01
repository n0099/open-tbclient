package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ad extends LinearLayout {
    private LinearLayout aEo;
    private boolean eHS;
    private TextView eJP;
    private TextView eJQ;
    private int mSkinType;

    public ad(Context context, boolean z, View.OnClickListener onClickListener) {
        super(context);
        this.mSkinType = 3;
        this.eHS = z;
        LayoutInflater.from(getContext()).inflate(t.h.person_info_relation_view, (ViewGroup) this, true);
        aE(context);
        O(onClickListener);
    }

    private void aE(Context context) {
        if (context != null) {
            this.aEo = (LinearLayout) getRootView();
            this.eJP = (TextView) this.aEo.findViewById(t.g.attention_btn);
            this.eJP.setClickable(true);
            aTJ();
            this.eJQ = (TextView) this.aEo.findViewById(t.g.chat_btn);
            this.eJQ.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(t.j.private_chat), t.f.icon_mine_bar_chat, true));
            this.eJQ.setClickable(true);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void O(View.OnClickListener onClickListener) {
        if (this.eJP != null) {
            this.eJP.setOnClickListener(onClickListener);
        }
        if (this.eJQ != null) {
            this.eJQ.setOnClickListener(onClickListener);
        }
    }

    private void aTJ() {
        if (this.eJP != null) {
            if (this.eHS) {
                this.eJP.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(t.j.relate_forum_is_followed), t.f.icon_mine_bar_add_ok, true));
                av.j((View) this.eJP, t.d.cp_cont_e);
                return;
            }
            this.eJP.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(t.j.attention), t.f.icon_mine_bar_add, true));
            av.j((View) this.eJP, t.d.cp_link_tip_a);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            av.l(this.aEo, t.d.cp_bg_line_c);
            av.k(this.eJP, t.f.item_person_header_attention_bg_selector);
            av.j((View) this.eJQ, t.d.cp_link_tip_a);
            av.k(this.eJQ, t.f.item_person_header_attention_bg_selector);
        }
        this.mSkinType = i;
    }

    public void setData(boolean z) {
        this.eHS = z;
        aTJ();
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }
}
