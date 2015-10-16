package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.i;
import com.baidu.tieba.personInfo.PersonInfoActivity;
/* loaded from: classes.dex */
public class bl extends com.baidu.adp.base.f {
    TextView cqA;
    TextView cqB;
    TextView cqC;
    View cqD;
    PersonInfoActivity cqE;
    View mView;

    public bl(PersonInfoActivity personInfoActivity) {
        super(personInfoActivity.getPageContext());
        this.cqE = personInfoActivity;
        a(this.cqE);
    }

    private void a(PersonInfoActivity personInfoActivity) {
        this.mView = LayoutInflater.from(personInfoActivity.getPageContext().getPageActivity()).inflate(i.g.person_info_more_view, (ViewGroup) null);
        this.cqA = (TextView) this.mView.findViewById(i.f.person_info_more_view_item_friend);
        this.cqA.setOnClickListener(personInfoActivity);
        this.cqB = (TextView) this.mView.findViewById(i.f.person_info_more_view_item_black);
        this.cqB.setOnClickListener(personInfoActivity);
        this.cqC = (TextView) this.mView.findViewById(i.f.person_info_more_view_item_mute);
        this.cqD = this.mView.findViewById(i.f.person_info_more_view_item_line_mute);
        this.cqC.setOnClickListener(personInfoActivity);
    }

    public void l(boolean z, boolean z2) {
        if (z) {
            this.cqA.setVisibility(0);
        } else {
            this.cqA.setVisibility(8);
        }
        if (z2) {
            this.cqB.setText(i.h.remove_block_chat);
        } else {
            this.cqB.setText(i.h.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aiJ() {
        return this.cqA;
    }

    public View aiK() {
        return this.cqB;
    }

    public View aiL() {
        return this.cqC;
    }

    public void jh(int i) {
        this.cqC.setVisibility(0);
        this.cqD.setVisibility(0);
        if (i == 0) {
            this.cqC.setText(this.cqE.getPageContext().getResources().getString(i.h.mute));
        } else if (i == 1) {
            this.cqC.setText(this.cqE.getPageContext().getResources().getString(i.h.un_mute));
        }
    }
}
