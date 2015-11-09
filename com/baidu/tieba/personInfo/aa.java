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
    private PersonInfoActivity csa;
    private View cul;
    private RelativeLayout cvp;
    private TextView cvq;
    private ImageView cvr;
    private ImageView cvs;
    private View mRootView;

    public aa(PersonInfoActivity personInfoActivity) {
        this.csa = personInfoActivity;
        this.mRootView = LayoutInflater.from(this.csa.getPageContext().getPageActivity()).inflate(i.g.personinfo_my_mark_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.cul = this.mRootView.findViewById(i.f.root_next);
        this.cvp = (RelativeLayout) this.mRootView.findViewById(i.f.bookmark);
        this.cvq = (TextView) this.mRootView.findViewById(i.f.bookmark_num);
        this.cvr = (ImageView) this.mRootView.findViewById(i.f.bookmark_icon);
        this.cvs = (ImageView) this.mRootView.findViewById(i.f.bookmark_arrow);
        this.cvp.setOnClickListener(this.csa);
    }

    public RelativeLayout ajU() {
        return this.cvp;
    }

    public void ake() {
        UserData userData = this.csa.ajH().getUserData();
        if (userData != null) {
            this.cvq.setText(String.valueOf(userData.getMarkCount()));
            if (userData.getMarkCount() <= 0) {
                an.b(this.cvq, i.c.cp_cont_e, 1);
                this.cvs.setVisibility(8);
            } else {
                an.b(this.cvq, i.c.cp_cont_b, 1);
                this.cvs.setVisibility(0);
            }
            if (userData.getNewMarkCount() > 0) {
                this.cvr.setVisibility(0);
            } else {
                this.cvr.setVisibility(8);
            }
        }
    }

    public View getRootView() {
        return this.mRootView;
    }
}
