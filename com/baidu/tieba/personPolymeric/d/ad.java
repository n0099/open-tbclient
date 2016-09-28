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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ad extends LinearLayout {
    private LinearLayout aDM;
    private boolean eJW;
    private TextView eLS;
    private TextView eLT;
    private int mSkinType;

    public ad(Context context, boolean z, View.OnClickListener onClickListener) {
        super(context);
        this.mSkinType = 3;
        this.eJW = z;
        LayoutInflater.from(getContext()).inflate(r.h.person_info_relation_view, (ViewGroup) this, true);
        aC(context);
        N(onClickListener);
    }

    private void aC(Context context) {
        if (context != null) {
            this.aDM = (LinearLayout) getRootView();
            this.eLS = (TextView) this.aDM.findViewById(r.g.attention_btn);
            this.eLS.setClickable(true);
            aUg();
            this.eLT = (TextView) this.aDM.findViewById(r.g.chat_btn);
            this.eLT.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(r.j.private_chat), r.f.icon_mine_bar_chat, true));
            this.eLT.setClickable(true);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void N(View.OnClickListener onClickListener) {
        if (this.eLS != null) {
            this.eLS.setOnClickListener(onClickListener);
        }
        if (this.eLT != null) {
            this.eLT.setOnClickListener(onClickListener);
        }
    }

    private void aUg() {
        if (this.eLS != null) {
            if (this.eJW) {
                this.eLS.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(r.j.relate_forum_is_followed), r.f.icon_mine_bar_add_ok, true));
                av.j((View) this.eLS, r.d.cp_cont_e);
                return;
            }
            this.eLS.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(r.j.attention), r.f.icon_mine_bar_add, true));
            av.j((View) this.eLS, r.d.cp_link_tip_a);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            av.l(this.aDM, r.d.cp_bg_line_c);
            av.k(this.eLS, r.f.item_person_header_attention_bg_selector);
            av.j((View) this.eLT, r.d.cp_link_tip_a);
            av.k(this.eLT, r.f.item_person_header_attention_bg_selector);
        }
        this.mSkinType = i;
    }

    public void setData(boolean z) {
        this.eJW = z;
        aUg();
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }
}
