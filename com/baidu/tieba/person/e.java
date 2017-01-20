package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.e {
    TbPageContext FY;
    TextView exI;
    TextView exJ;
    TextView exK;
    View exL;
    View mView;

    public e(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.FY = tbPageContext;
        a(this.FY, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(r.j.person_info_more_view, (ViewGroup) null);
        this.exI = (TextView) this.mView.findViewById(r.h.person_info_more_view_item_friend);
        this.exI.setOnClickListener(onClickListener);
        this.exJ = (TextView) this.mView.findViewById(r.h.person_info_more_view_item_black);
        this.exJ.setOnClickListener(onClickListener);
        this.exK = (TextView) this.mView.findViewById(r.h.person_info_more_view_item_mute);
        this.exL = this.mView.findViewById(r.h.person_info_more_view_item_line_mute);
        this.exK.setOnClickListener(onClickListener);
    }

    public void z(boolean z, boolean z2) {
        if (z) {
            this.exI.setText(r.l.remove_friend);
        } else {
            this.exI.setText(r.l.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.exJ.setText(r.l.remove_block_chat);
        } else {
            this.exJ.setText(r.l.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aQw() {
        return this.exI;
    }

    public View aQx() {
        return this.exJ;
    }

    public View aQy() {
        return this.exK;
    }

    public void oX(int i) {
        this.exK.setVisibility(0);
        this.exL.setVisibility(0);
        if (i == 0) {
            this.exK.setText(this.FY.getResources().getString(r.l.mute));
        } else if (i == 1) {
            this.exK.setText(this.FY.getResources().getString(r.l.un_mute));
        }
    }
}
