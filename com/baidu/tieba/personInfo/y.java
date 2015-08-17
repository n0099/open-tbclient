package com.baidu.tieba.personInfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class y {
    private PersonInfoActivity cjU;
    private View clV;
    private RelativeLayout cmZ;
    private TextView cna;
    private ImageView cnb;
    private ImageView cnc;
    private View mRootView;

    public y(PersonInfoActivity personInfoActivity) {
        this.cjU = personInfoActivity;
        this.mRootView = LayoutInflater.from(this.cjU.getPageContext().getPageActivity()).inflate(i.g.personinfo_my_mark_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.clV = this.mRootView.findViewById(i.f.root_next);
        this.cmZ = (RelativeLayout) this.mRootView.findViewById(i.f.bookmark);
        this.cna = (TextView) this.mRootView.findViewById(i.f.bookmark_num);
        this.cnb = (ImageView) this.mRootView.findViewById(i.f.bookmark_icon);
        this.cnc = (ImageView) this.mRootView.findViewById(i.f.bookmark_arrow);
        this.cmZ.setOnClickListener(this.cjU);
    }

    public RelativeLayout agY() {
        return this.cmZ;
    }

    public void ahi() {
        UserData userData = this.cjU.agL().getUserData();
        if (userData != null) {
            this.cna.setText(String.valueOf(userData.getMarkCount()));
            if (userData.getMarkCount() <= 0) {
                al.b(this.cna, i.c.cp_cont_e, 1);
                this.cnc.setVisibility(8);
            } else {
                al.b(this.cna, i.c.cp_cont_b, 1);
                this.cnc.setVisibility(0);
            }
            if (userData.getNewMarkCount() > 0) {
                this.cnb.setVisibility(0);
            } else {
                this.cnb.setVisibility(8);
            }
        }
    }

    public View getRootView() {
        return this.mRootView;
    }
}
