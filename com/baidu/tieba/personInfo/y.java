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
    private PersonInfoActivity ckP;
    private View cmY;
    private RelativeLayout cob;
    private TextView coc;
    private ImageView cod;
    private ImageView coe;
    private View mRootView;

    public y(PersonInfoActivity personInfoActivity) {
        this.ckP = personInfoActivity;
        this.mRootView = LayoutInflater.from(this.ckP.getPageContext().getPageActivity()).inflate(i.g.personinfo_my_mark_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.cmY = this.mRootView.findViewById(i.f.root_next);
        this.cob = (RelativeLayout) this.mRootView.findViewById(i.f.bookmark);
        this.coc = (TextView) this.mRootView.findViewById(i.f.bookmark_num);
        this.cod = (ImageView) this.mRootView.findViewById(i.f.bookmark_icon);
        this.coe = (ImageView) this.mRootView.findViewById(i.f.bookmark_arrow);
        this.cob.setOnClickListener(this.ckP);
    }

    public RelativeLayout ahq() {
        return this.cob;
    }

    public void ahA() {
        UserData userData = this.ckP.ahd().getUserData();
        if (userData != null) {
            this.coc.setText(String.valueOf(userData.getMarkCount()));
            if (userData.getMarkCount() <= 0) {
                al.b(this.coc, i.c.cp_cont_e, 1);
                this.coe.setVisibility(8);
            } else {
                al.b(this.coc, i.c.cp_cont_b, 1);
                this.coe.setVisibility(0);
            }
            if (userData.getNewMarkCount() > 0) {
                this.cod.setVisibility(0);
            } else {
                this.cod.setVisibility(8);
            }
        }
    }

    public View getRootView() {
        return this.mRootView;
    }
}
