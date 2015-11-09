package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.i;
import com.baidu.tieba.personInfo.PersonInfoActivity;
/* loaded from: classes.dex */
public class bl extends com.baidu.adp.base.f {
    TextView crW;
    TextView crX;
    TextView crY;
    View crZ;
    PersonInfoActivity csa;
    View mView;

    public bl(PersonInfoActivity personInfoActivity) {
        super(personInfoActivity.getPageContext());
        this.csa = personInfoActivity;
        a(this.csa);
    }

    private void a(PersonInfoActivity personInfoActivity) {
        this.mView = LayoutInflater.from(personInfoActivity.getPageContext().getPageActivity()).inflate(i.g.person_info_more_view, (ViewGroup) null);
        this.crW = (TextView) this.mView.findViewById(i.f.person_info_more_view_item_friend);
        this.crW.setOnClickListener(personInfoActivity);
        this.crX = (TextView) this.mView.findViewById(i.f.person_info_more_view_item_black);
        this.crX.setOnClickListener(personInfoActivity);
        this.crY = (TextView) this.mView.findViewById(i.f.person_info_more_view_item_mute);
        this.crZ = this.mView.findViewById(i.f.person_info_more_view_item_line_mute);
        this.crY.setOnClickListener(personInfoActivity);
    }

    public void l(boolean z, boolean z2) {
        if (z) {
            this.crW.setVisibility(0);
        } else {
            this.crW.setVisibility(8);
        }
        if (z2) {
            this.crX.setText(i.h.remove_block_chat);
        } else {
            this.crX.setText(i.h.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View ajl() {
        return this.crW;
    }

    public View ajm() {
        return this.crX;
    }

    public View ajn() {
        return this.crY;
    }

    public void jv(int i) {
        this.crY.setVisibility(0);
        this.crZ.setVisibility(0);
        if (i == 0) {
            this.crY.setText(this.csa.getPageContext().getResources().getString(i.h.mute));
        } else if (i == 1) {
            this.crY.setText(this.csa.getPageContext().getResources().getString(i.h.un_mute));
        }
    }
}
