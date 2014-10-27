package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.personInfo.PersonInfoActivity;
/* loaded from: classes.dex */
public class bk extends com.baidu.adp.base.f {
    TextView bCJ;
    TextView bCK;
    View mView;

    public bk(PersonInfoActivity personInfoActivity) {
        super(personInfoActivity);
        a(personInfoActivity);
    }

    private void a(PersonInfoActivity personInfoActivity) {
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(personInfoActivity, com.baidu.tieba.w.person_info_more_view, null);
        this.bCJ = (TextView) this.mView.findViewById(com.baidu.tieba.v.person_info_more_view_item_friend);
        this.bCJ.setOnClickListener(personInfoActivity);
        this.bCK = (TextView) this.mView.findViewById(com.baidu.tieba.v.person_info_more_view_item_black);
        this.bCK.setOnClickListener(personInfoActivity);
    }

    public void g(boolean z, boolean z2) {
        if (z) {
            this.bCJ.setVisibility(0);
        } else {
            this.bCJ.setVisibility(8);
        }
        if (z2) {
            this.bCK.setText(com.baidu.tieba.y.remove_block_chat);
        } else {
            this.bCK.setText(com.baidu.tieba.y.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aac() {
        return this.bCJ;
    }

    public View aad() {
        return this.bCK;
    }
}
