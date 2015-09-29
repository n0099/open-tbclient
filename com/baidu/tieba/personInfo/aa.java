package com.baidu.tieba.personInfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class aa {
    private PersonInfoActivity cqt;
    private View csE;
    private RelativeLayout ctI;
    private TextView ctJ;
    private ImageView ctK;
    private ImageView ctL;
    private View mRootView;

    public aa(PersonInfoActivity personInfoActivity) {
        this.cqt = personInfoActivity;
        this.mRootView = LayoutInflater.from(this.cqt.getPageContext().getPageActivity()).inflate(i.g.personinfo_my_mark_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.csE = this.mRootView.findViewById(i.f.root_next);
        this.ctI = (RelativeLayout) this.mRootView.findViewById(i.f.bookmark);
        this.ctJ = (TextView) this.mRootView.findViewById(i.f.bookmark_num);
        this.ctK = (ImageView) this.mRootView.findViewById(i.f.bookmark_icon);
        this.ctL = (ImageView) this.mRootView.findViewById(i.f.bookmark_arrow);
        this.ctI.setOnClickListener(this.cqt);
    }

    public RelativeLayout ajs() {
        return this.ctI;
    }

    public void ajC() {
        UserData userData = this.cqt.ajf().getUserData();
        if (userData != null) {
            this.ctJ.setText(String.valueOf(userData.getMarkCount()));
            if (userData.getMarkCount() <= 0) {
                am.b(this.ctJ, i.c.cp_cont_e, 1);
                this.ctL.setVisibility(8);
            } else {
                am.b(this.ctJ, i.c.cp_cont_b, 1);
                this.ctL.setVisibility(0);
            }
            if (userData.getNewMarkCount() > 0) {
                this.ctK.setVisibility(0);
            } else {
                this.ctK.setVisibility(8);
            }
        }
    }

    public View getRootView() {
        return this.mRootView;
    }
}
