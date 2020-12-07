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
/* loaded from: classes22.dex */
public class f extends com.baidu.adp.base.c {
    TextView elj;
    TextView hPL;
    TbPageContext mPageContext;
    RoundLinearLayout mir;
    TextView mis;
    TextView mit;
    TextView miu;
    TextView miv;
    TextView miw;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mir = (RoundLinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.mir.setRadius(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds31));
        this.mis = (TextView) this.mir.findViewById(R.id.person_info_more_view_item_friend);
        this.mis.setOnClickListener(onClickListener);
        this.mit = (TextView) this.mir.findViewById(R.id.person_info_more_view_item_report);
        this.mit.setOnClickListener(onClickListener);
        this.miu = (TextView) this.mir.findViewById(R.id.person_info_more_view_item_black);
        this.miu.setOnClickListener(onClickListener);
        this.miv = (TextView) this.mir.findViewById(R.id.person_info_more_view_item_mute);
        this.miv.setOnClickListener(onClickListener);
        this.elj = (TextView) this.mir.findViewById(R.id.person_info_more_view_item_cancel);
        this.elj.setOnClickListener(onClickListener);
        this.hPL = (TextView) this.mir.findViewById(R.id.person_info_more_view_item_username);
        this.miw = (TextView) this.mir.findViewById(R.id.person_info_item_remove_fans_view);
        this.miw.setOnClickListener(onClickListener);
    }

    public void l(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.mis.setText(R.string.remove_friend);
        } else {
            this.mis.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.miu.setText(R.string.remove_block_chat);
        } else {
            this.miu.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.miw.setVisibility(0);
        } else {
            this.miw.setVisibility(8);
        }
    }

    public View getView() {
        return this.mir;
    }

    public View dyc() {
        return this.mis;
    }

    public View dyd() {
        return this.miu;
    }

    public View dye() {
        return this.miv;
    }

    public View dyf() {
        return this.mit;
    }

    public View dyg() {
        return this.miw;
    }

    public void Ig(int i) {
        this.miv.setVisibility(0);
        if (i == 0) {
            this.miv.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.miv.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.hPL.setVisibility(8);
            return;
        }
        this.hPL.setVisibility(0);
        this.hPL.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mir, R.color.CAM_X0211);
        ap.k(this.miu, R.color.CAM_X0105);
        ap.k(this.mis, R.color.CAM_X0105);
        ap.k(this.mit, R.color.CAM_X0105);
        ap.k(this.miv, R.color.CAM_X0105);
        ap.setViewTextColor(this.hPL, R.color.CAM_X0109, 1);
        ap.k(this.miw, R.color.CAM_X0105);
        ap.k(this.elj, R.color.CAM_X0107);
    }
}
