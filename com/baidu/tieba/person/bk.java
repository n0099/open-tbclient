package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.i;
import com.baidu.tieba.personInfo.PersonInfoActivity;
/* loaded from: classes.dex */
public class bk extends com.baidu.adp.base.f {
    TextView cjQ;
    TextView cjR;
    TextView cjS;
    View cjT;
    PersonInfoActivity cjU;
    View mView;

    public bk(PersonInfoActivity personInfoActivity) {
        super(personInfoActivity.getPageContext());
        this.cjU = personInfoActivity;
        a(this.cjU);
    }

    private void a(PersonInfoActivity personInfoActivity) {
        this.mView = LayoutInflater.from(personInfoActivity.getPageContext().getPageActivity()).inflate(i.g.person_info_more_view, (ViewGroup) null);
        this.cjQ = (TextView) this.mView.findViewById(i.f.person_info_more_view_item_friend);
        this.cjQ.setOnClickListener(personInfoActivity);
        this.cjR = (TextView) this.mView.findViewById(i.f.person_info_more_view_item_black);
        this.cjR.setOnClickListener(personInfoActivity);
        this.cjS = (TextView) this.mView.findViewById(i.f.person_info_more_view_item_mute);
        this.cjT = this.mView.findViewById(i.f.person_info_more_view_item_line_mute);
        this.cjS.setOnClickListener(personInfoActivity);
    }

    public void j(boolean z, boolean z2) {
        if (z) {
            this.cjQ.setVisibility(0);
        } else {
            this.cjQ.setVisibility(8);
        }
        if (z2) {
            this.cjR.setText(i.C0057i.remove_block_chat);
        } else {
            this.cjR.setText(i.C0057i.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View agt() {
        return this.cjQ;
    }

    public View agu() {
        return this.cjR;
    }

    public View agv() {
        return this.cjS;
    }

    public void iL(int i) {
        this.cjS.setVisibility(0);
        this.cjT.setVisibility(0);
        if (i == 0) {
            this.cjS.setText(this.cjU.getPageContext().getResources().getString(i.C0057i.mute));
        } else if (i == 1) {
            this.cjS.setText(this.cjU.getPageContext().getResources().getString(i.C0057i.un_mute));
        }
    }
}
