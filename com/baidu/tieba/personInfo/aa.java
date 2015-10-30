package com.baidu.tieba.personInfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class aa {
    private PersonInfoActivity cqE;
    private View csP;
    private RelativeLayout ctT;
    private TextView ctU;
    private ImageView ctV;
    private ImageView ctW;
    private View mRootView;

    public aa(PersonInfoActivity personInfoActivity) {
        this.cqE = personInfoActivity;
        this.mRootView = LayoutInflater.from(this.cqE.getPageContext().getPageActivity()).inflate(i.g.personinfo_my_mark_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.csP = this.mRootView.findViewById(i.f.root_next);
        this.ctT = (RelativeLayout) this.mRootView.findViewById(i.f.bookmark);
        this.ctU = (TextView) this.mRootView.findViewById(i.f.bookmark_num);
        this.ctV = (ImageView) this.mRootView.findViewById(i.f.bookmark_icon);
        this.ctW = (ImageView) this.mRootView.findViewById(i.f.bookmark_arrow);
        this.ctT.setOnClickListener(this.cqE);
    }

    public RelativeLayout ajo() {
        return this.ctT;
    }

    public void ajy() {
        UserData userData = this.cqE.ajb().getUserData();
        if (userData != null) {
            this.ctU.setText(String.valueOf(userData.getMarkCount()));
            if (userData.getMarkCount() <= 0) {
                an.b(this.ctU, i.c.cp_cont_e, 1);
                this.ctW.setVisibility(8);
            } else {
                an.b(this.ctU, i.c.cp_cont_b, 1);
                this.ctW.setVisibility(0);
            }
            if (userData.getNewMarkCount() > 0) {
                this.ctV.setVisibility(0);
            } else {
                this.ctV.setVisibility(8);
            }
        }
    }

    public View getRootView() {
        return this.mRootView;
    }
}
