package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.personInfo.PersonInfoActivity;
/* loaded from: classes.dex */
public class bc extends com.baidu.adp.base.g {
    TextView bIi;
    TextView bIj;
    View mView;

    public bc(PersonInfoActivity personInfoActivity) {
        super(personInfoActivity.getPageContext());
        a(personInfoActivity);
    }

    private void a(PersonInfoActivity personInfoActivity) {
        this.mView = com.baidu.adp.lib.g.b.ei().inflate(personInfoActivity.getPageContext().getPageActivity(), com.baidu.tieba.x.person_info_more_view, null);
        this.bIi = (TextView) this.mView.findViewById(com.baidu.tieba.w.person_info_more_view_item_friend);
        this.bIi.setOnClickListener(personInfoActivity);
        this.bIj = (TextView) this.mView.findViewById(com.baidu.tieba.w.person_info_more_view_item_black);
        this.bIj.setOnClickListener(personInfoActivity);
    }

    public void i(boolean z, boolean z2) {
        if (z) {
            this.bIi.setVisibility(0);
        } else {
            this.bIi.setVisibility(8);
        }
        if (z2) {
            this.bIj.setText(com.baidu.tieba.z.remove_block_chat);
        } else {
            this.bIj.setText(com.baidu.tieba.z.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aba() {
        return this.bIi;
    }

    public View abb() {
        return this.bIj;
    }
}
