package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.personInfo.PersonInfoActivity;
/* loaded from: classes.dex */
public class bl extends com.baidu.adp.base.f {
    TextView bCX;
    TextView bCY;
    View mView;

    public bl(PersonInfoActivity personInfoActivity) {
        super(personInfoActivity);
        a(personInfoActivity);
    }

    private void a(PersonInfoActivity personInfoActivity) {
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(personInfoActivity, com.baidu.tieba.w.person_info_more_view, null);
        this.bCX = (TextView) this.mView.findViewById(com.baidu.tieba.v.person_info_more_view_item_friend);
        this.bCX.setOnClickListener(personInfoActivity);
        this.bCY = (TextView) this.mView.findViewById(com.baidu.tieba.v.person_info_more_view_item_black);
        this.bCY.setOnClickListener(personInfoActivity);
    }

    public void g(boolean z, boolean z2) {
        if (z) {
            this.bCX.setVisibility(0);
        } else {
            this.bCX.setVisibility(8);
        }
        if (z2) {
            this.bCY.setText(com.baidu.tieba.y.remove_block_chat);
        } else {
            this.bCY.setText(com.baidu.tieba.y.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aae() {
        return this.bCX;
    }

    public View aaf() {
        return this.bCY;
    }
}
