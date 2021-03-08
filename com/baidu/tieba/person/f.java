package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.base.d {
    TextView etj;
    TextView idX;
    TbPageContext mPageContext;
    RoundLinearLayout mup;
    TextView muq;
    TextView mur;
    TextView mus;
    TextView mut;
    TextView muu;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mup = (RoundLinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.mup.setRadius(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds31));
        this.muq = (TextView) this.mup.findViewById(R.id.person_info_more_view_item_friend);
        this.muq.setOnClickListener(onClickListener);
        this.mur = (TextView) this.mup.findViewById(R.id.person_info_more_view_item_report);
        this.mur.setOnClickListener(onClickListener);
        this.mus = (TextView) this.mup.findViewById(R.id.person_info_more_view_item_black);
        this.mus.setOnClickListener(onClickListener);
        this.mut = (TextView) this.mup.findViewById(R.id.person_info_more_view_item_mute);
        this.mut.setOnClickListener(onClickListener);
        this.etj = (TextView) this.mup.findViewById(R.id.person_info_more_view_item_cancel);
        this.etj.setOnClickListener(onClickListener);
        this.idX = (TextView) this.mup.findViewById(R.id.person_info_more_view_item_username);
        this.muu = (TextView) this.mup.findViewById(R.id.person_info_item_remove_fans_view);
        this.muu.setOnClickListener(onClickListener);
    }

    public void m(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.muq.setText(R.string.remove_friend);
        } else {
            this.muq.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.mus.setText(R.string.remove_block_chat);
        } else {
            this.mus.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.muu.setVisibility(0);
        } else {
            this.muu.setVisibility(8);
        }
    }

    public View getView() {
        return this.mup;
    }

    public View dwA() {
        return this.muq;
    }

    public View dwB() {
        return this.mus;
    }

    public View dwC() {
        return this.mut;
    }

    public View dwD() {
        return this.mur;
    }

    public View dwE() {
        return this.muu;
    }

    public void GO(int i) {
        this.mut.setVisibility(0);
        if (i == 0) {
            this.mut.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.mut.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.idX.setVisibility(8);
            return;
        }
        this.idX.setVisibility(0);
        this.idX.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mup, R.color.CAM_X0211);
        ap.n(this.mus, R.color.CAM_X0105);
        ap.n(this.muq, R.color.CAM_X0105);
        ap.n(this.mur, R.color.CAM_X0105);
        ap.n(this.mut, R.color.CAM_X0105);
        ap.setViewTextColor(this.idX, R.color.CAM_X0109, 1);
        ap.n(this.muu, R.color.CAM_X0105);
        ap.n(this.etj, R.color.CAM_X0107);
    }
}
