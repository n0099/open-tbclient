package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class af extends LinearLayout {
    private LinearLayout aCL;
    private TextView eFN;
    private TextView eFO;
    private boolean mIsLiked;
    private int mSkinType;

    public af(Context context, boolean z, View.OnClickListener onClickListener) {
        super(context);
        this.mSkinType = 3;
        this.mIsLiked = z;
        LayoutInflater.from(getContext()).inflate(r.j.person_info_relation_view, (ViewGroup) this, true);
        aT(context);
        P(onClickListener);
    }

    private void aT(Context context) {
        if (context != null) {
            this.aCL = (LinearLayout) getRootView();
            this.eFN = (TextView) this.aCL.findViewById(r.h.attention_btn);
            this.eFN.setClickable(true);
            aRW();
            this.eFO = (TextView) this.aCL.findViewById(r.h.chat_btn);
            this.eFO.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(r.l.private_chat), r.g.icon_mine_bar_chat, true));
            this.eFO.setClickable(true);
            onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void P(View.OnClickListener onClickListener) {
        if (this.eFN != null) {
            this.eFN.setOnClickListener(onClickListener);
        }
        if (this.eFO != null) {
            this.eFO.setOnClickListener(onClickListener);
        }
    }

    private void aRW() {
        if (this.eFN != null) {
            if (this.mIsLiked) {
                this.eFN.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(r.l.relate_forum_is_followed), r.g.icon_mine_bar_add_ok, true));
                ap.i((View) this.eFN, r.e.cp_cont_e);
                return;
            }
            this.eFN.setText(UtilHelper.getSpannableIcon(getContext(), getContext().getString(r.l.attention), r.g.icon_mine_bar_add, true));
            ap.i((View) this.eFN, r.e.cp_link_tip_a);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.k(this.aCL, r.e.cp_bg_line_c);
            ap.j((View) this.eFN, r.g.item_person_header_attention_bg_selector);
            ap.i((View) this.eFO, r.e.cp_link_tip_a);
            ap.j((View) this.eFO, r.g.item_person_header_attention_bg_selector);
        }
        this.mSkinType = i;
    }

    public void setData(boolean z) {
        this.mIsLiked = z;
        aRW();
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }
}
