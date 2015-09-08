package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.i;
import com.baidu.tieba.personInfo.PersonInfoActivity;
/* loaded from: classes.dex */
public class bk extends com.baidu.adp.base.f {
    TextView ckL;
    TextView ckM;
    TextView ckN;
    View ckO;
    PersonInfoActivity ckP;
    View mView;

    public bk(PersonInfoActivity personInfoActivity) {
        super(personInfoActivity.getPageContext());
        this.ckP = personInfoActivity;
        a(this.ckP);
    }

    private void a(PersonInfoActivity personInfoActivity) {
        this.mView = LayoutInflater.from(personInfoActivity.getPageContext().getPageActivity()).inflate(i.g.person_info_more_view, (ViewGroup) null);
        this.ckL = (TextView) this.mView.findViewById(i.f.person_info_more_view_item_friend);
        this.ckL.setOnClickListener(personInfoActivity);
        this.ckM = (TextView) this.mView.findViewById(i.f.person_info_more_view_item_black);
        this.ckM.setOnClickListener(personInfoActivity);
        this.ckN = (TextView) this.mView.findViewById(i.f.person_info_more_view_item_mute);
        this.ckO = this.mView.findViewById(i.f.person_info_more_view_item_line_mute);
        this.ckN.setOnClickListener(personInfoActivity);
    }

    public void j(boolean z, boolean z2) {
        if (z) {
            this.ckL.setVisibility(0);
        } else {
            this.ckL.setVisibility(8);
        }
        if (z2) {
            this.ckM.setText(i.h.remove_block_chat);
        } else {
            this.ckM.setText(i.h.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View agJ() {
        return this.ckL;
    }

    public View agK() {
        return this.ckM;
    }

    public View agL() {
        return this.ckN;
    }

    public void iX(int i) {
        this.ckN.setVisibility(0);
        this.ckO.setVisibility(0);
        if (i == 0) {
            this.ckN.setText(this.ckP.getPageContext().getResources().getString(i.h.mute));
        } else if (i == 1) {
            this.ckN.setText(this.ckP.getPageContext().getResources().getString(i.h.un_mute));
        }
    }
}
