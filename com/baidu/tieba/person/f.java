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
    TextView hPN;
    TbPageContext mPageContext;
    RoundLinearLayout mit;
    TextView miu;
    TextView miv;
    TextView miw;
    TextView mix;
    TextView miy;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.mit = (RoundLinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.mit.setRadius(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds31));
        this.miu = (TextView) this.mit.findViewById(R.id.person_info_more_view_item_friend);
        this.miu.setOnClickListener(onClickListener);
        this.miv = (TextView) this.mit.findViewById(R.id.person_info_more_view_item_report);
        this.miv.setOnClickListener(onClickListener);
        this.miw = (TextView) this.mit.findViewById(R.id.person_info_more_view_item_black);
        this.miw.setOnClickListener(onClickListener);
        this.mix = (TextView) this.mit.findViewById(R.id.person_info_more_view_item_mute);
        this.mix.setOnClickListener(onClickListener);
        this.elj = (TextView) this.mit.findViewById(R.id.person_info_more_view_item_cancel);
        this.elj.setOnClickListener(onClickListener);
        this.hPN = (TextView) this.mit.findViewById(R.id.person_info_more_view_item_username);
        this.miy = (TextView) this.mit.findViewById(R.id.person_info_item_remove_fans_view);
        this.miy.setOnClickListener(onClickListener);
    }

    public void l(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.miu.setText(R.string.remove_friend);
        } else {
            this.miu.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.miw.setText(R.string.remove_block_chat);
        } else {
            this.miw.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.miy.setVisibility(0);
        } else {
            this.miy.setVisibility(8);
        }
    }

    public View getView() {
        return this.mit;
    }

    public View dyd() {
        return this.miu;
    }

    public View dye() {
        return this.miw;
    }

    public View dyf() {
        return this.mix;
    }

    public View dyg() {
        return this.miv;
    }

    public View dyh() {
        return this.miy;
    }

    public void Ig(int i) {
        this.mix.setVisibility(0);
        if (i == 0) {
            this.mix.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.mix.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.hPN.setVisibility(8);
            return;
        }
        this.hPN.setVisibility(0);
        this.hPN.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.mit, R.color.CAM_X0211);
        ap.k(this.miw, R.color.CAM_X0105);
        ap.k(this.miu, R.color.CAM_X0105);
        ap.k(this.miv, R.color.CAM_X0105);
        ap.k(this.mix, R.color.CAM_X0105);
        ap.setViewTextColor(this.hPN, R.color.CAM_X0109, 1);
        ap.k(this.miy, R.color.CAM_X0105);
        ap.k(this.elj, R.color.CAM_X0107);
    }
}
