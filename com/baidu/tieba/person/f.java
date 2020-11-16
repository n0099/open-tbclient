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
/* loaded from: classes21.dex */
public class f extends com.baidu.adp.base.c {
    TextView eei;
    TextView hGe;
    RoundLinearLayout lUk;
    TextView lUl;
    TextView lUm;
    TextView lUn;
    TextView lUo;
    TextView lUp;
    TbPageContext mPageContext;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.lUk = (RoundLinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.lUk.setRadius(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds31));
        this.lUl = (TextView) this.lUk.findViewById(R.id.person_info_more_view_item_friend);
        this.lUl.setOnClickListener(onClickListener);
        this.lUm = (TextView) this.lUk.findViewById(R.id.person_info_more_view_item_report);
        this.lUm.setOnClickListener(onClickListener);
        this.lUn = (TextView) this.lUk.findViewById(R.id.person_info_more_view_item_black);
        this.lUn.setOnClickListener(onClickListener);
        this.lUo = (TextView) this.lUk.findViewById(R.id.person_info_more_view_item_mute);
        this.lUo.setOnClickListener(onClickListener);
        this.eei = (TextView) this.lUk.findViewById(R.id.person_info_more_view_item_cancel);
        this.eei.setOnClickListener(onClickListener);
        this.hGe = (TextView) this.lUk.findViewById(R.id.person_info_more_view_item_username);
        this.lUp = (TextView) this.lUk.findViewById(R.id.person_info_item_remove_fans_view);
        this.lUp.setOnClickListener(onClickListener);
    }

    public void l(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.lUl.setText(R.string.remove_friend);
        } else {
            this.lUl.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.lUn.setText(R.string.remove_block_chat);
        } else {
            this.lUn.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.lUp.setVisibility(0);
        } else {
            this.lUp.setVisibility(8);
        }
    }

    public View getView() {
        return this.lUk;
    }

    public View dsK() {
        return this.lUl;
    }

    public View dsL() {
        return this.lUn;
    }

    public View dsM() {
        return this.lUo;
    }

    public View dsN() {
        return this.lUm;
    }

    public View dsO() {
        return this.lUp;
    }

    public void Hp(int i) {
        this.lUo.setVisibility(0);
        if (i == 0) {
            this.lUo.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.lUo.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.hGe.setVisibility(8);
            return;
        }
        this.hGe.setVisibility(0);
        this.hGe.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.lUk, R.color.CAM_X0211);
        ap.k(this.lUn, R.color.CAM_X0105);
        ap.k(this.lUl, R.color.CAM_X0105);
        ap.k(this.lUm, R.color.CAM_X0105);
        ap.k(this.lUo, R.color.CAM_X0105);
        ap.setViewTextColor(this.hGe, R.color.CAM_X0109, 1);
        ap.k(this.lUp, R.color.CAM_X0105);
        ap.k(this.eei, R.color.CAM_X0107);
    }
}
