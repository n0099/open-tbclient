package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.RoundLinearLayout;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class f extends com.baidu.adp.base.d {
    TextView epA;
    TextView hXC;
    TbPageContext mPageContext;
    RoundLinearLayout miW;
    TextView miX;
    TextView miY;
    TextView miZ;
    TextView mja;
    TextView mjb;

    public f(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        a(this.mPageContext, onClickListener);
    }

    private void a(TbPageContext tbPageContext, View.OnClickListener onClickListener) {
        this.miW = (RoundLinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.person_info_more_view, (ViewGroup) null);
        this.miW.setRadius(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds31));
        this.miX = (TextView) this.miW.findViewById(R.id.person_info_more_view_item_friend);
        this.miX.setOnClickListener(onClickListener);
        this.miY = (TextView) this.miW.findViewById(R.id.person_info_more_view_item_report);
        this.miY.setOnClickListener(onClickListener);
        this.miZ = (TextView) this.miW.findViewById(R.id.person_info_more_view_item_black);
        this.miZ.setOnClickListener(onClickListener);
        this.mja = (TextView) this.miW.findViewById(R.id.person_info_more_view_item_mute);
        this.mja.setOnClickListener(onClickListener);
        this.epA = (TextView) this.miW.findViewById(R.id.person_info_more_view_item_cancel);
        this.epA.setOnClickListener(onClickListener);
        this.hXC = (TextView) this.miW.findViewById(R.id.person_info_more_view_item_username);
        this.mjb = (TextView) this.miW.findViewById(R.id.person_info_item_remove_fans_view);
        this.mjb.setOnClickListener(onClickListener);
    }

    public void m(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.miX.setText(R.string.remove_friend);
        } else {
            this.miX.setText(R.string.frs_recommend_friend_item_add);
        }
        if (z2) {
            this.miZ.setText(R.string.remove_block_chat);
        } else {
            this.miZ.setText(R.string.block_chat_message);
        }
        if (z3) {
            this.mjb.setVisibility(0);
        } else {
            this.mjb.setVisibility(8);
        }
    }

    public View getView() {
        return this.miW;
    }

    public View dub() {
        return this.miX;
    }

    public View duc() {
        return this.miZ;
    }

    public View dud() {
        return this.mja;
    }

    public View due() {
        return this.miY;
    }

    public View duf() {
        return this.mjb;
    }

    public void Gt(int i) {
        this.mja.setVisibility(0);
        if (i == 0) {
            this.mja.setText(this.mPageContext.getResources().getString(R.string.mute));
        } else if (i == 1) {
            this.mja.setText(this.mPageContext.getResources().getString(R.string.un_mute));
        }
    }

    public void setUserName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.hXC.setVisibility(8);
            return;
        }
        this.hXC.setVisibility(0);
        this.hXC.setText(String.format(this.mPageContext.getResources().getString(R.string.more_info_username), str));
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this.miW, R.color.CAM_X0211);
        ao.n(this.miZ, R.color.CAM_X0105);
        ao.n(this.miX, R.color.CAM_X0105);
        ao.n(this.miY, R.color.CAM_X0105);
        ao.n(this.mja, R.color.CAM_X0105);
        ao.setViewTextColor(this.hXC, R.color.CAM_X0109, 1);
        ao.n(this.mjb, R.color.CAM_X0105);
        ao.n(this.epA, R.color.CAM_X0107);
    }
}
