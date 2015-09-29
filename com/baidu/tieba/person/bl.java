package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.i;
import com.baidu.tieba.personInfo.PersonInfoActivity;
/* loaded from: classes.dex */
public class bl extends com.baidu.adp.base.f {
    TextView cqp;
    TextView cqq;
    TextView cqr;
    View cqs;
    PersonInfoActivity cqt;
    View mView;

    public bl(PersonInfoActivity personInfoActivity) {
        super(personInfoActivity.getPageContext());
        this.cqt = personInfoActivity;
        a(this.cqt);
    }

    private void a(PersonInfoActivity personInfoActivity) {
        this.mView = LayoutInflater.from(personInfoActivity.getPageContext().getPageActivity()).inflate(i.g.person_info_more_view, (ViewGroup) null);
        this.cqp = (TextView) this.mView.findViewById(i.f.person_info_more_view_item_friend);
        this.cqp.setOnClickListener(personInfoActivity);
        this.cqq = (TextView) this.mView.findViewById(i.f.person_info_more_view_item_black);
        this.cqq.setOnClickListener(personInfoActivity);
        this.cqr = (TextView) this.mView.findViewById(i.f.person_info_more_view_item_mute);
        this.cqs = this.mView.findViewById(i.f.person_info_more_view_item_line_mute);
        this.cqr.setOnClickListener(personInfoActivity);
    }

    public void l(boolean z, boolean z2) {
        if (z) {
            this.cqp.setVisibility(0);
        } else {
            this.cqp.setVisibility(8);
        }
        if (z2) {
            this.cqq.setText(i.h.remove_block_chat);
        } else {
            this.cqq.setText(i.h.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aiJ() {
        return this.cqp;
    }

    public View aiK() {
        return this.cqq;
    }

    public View aiL() {
        return this.cqr;
    }

    public void jh(int i) {
        this.cqr.setVisibility(0);
        this.cqs.setVisibility(0);
        if (i == 0) {
            this.cqr.setText(this.cqt.getPageContext().getResources().getString(i.h.mute));
        } else if (i == 1) {
            this.cqr.setText(this.cqt.getPageContext().getResources().getString(i.h.un_mute));
        }
    }
}
