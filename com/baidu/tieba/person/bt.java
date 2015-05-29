package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.personInfo.PersonInfoActivity;
/* loaded from: classes.dex */
public class bt extends com.baidu.adp.base.g {
    TextView bTk;
    TextView bTl;
    View mView;

    public bt(PersonInfoActivity personInfoActivity) {
        super(personInfoActivity.getPageContext());
        a(personInfoActivity);
    }

    private void a(PersonInfoActivity personInfoActivity) {
        this.mView = com.baidu.adp.lib.g.b.hr().inflate(personInfoActivity.getPageContext().getPageActivity(), com.baidu.tieba.r.person_info_more_view, null);
        this.bTk = (TextView) this.mView.findViewById(com.baidu.tieba.q.person_info_more_view_item_friend);
        this.bTk.setOnClickListener(personInfoActivity);
        this.bTl = (TextView) this.mView.findViewById(com.baidu.tieba.q.person_info_more_view_item_black);
        this.bTl.setOnClickListener(personInfoActivity);
    }

    public void f(boolean z, boolean z2) {
        if (z) {
            this.bTk.setVisibility(0);
        } else {
            this.bTk.setVisibility(8);
        }
        if (z2) {
            this.bTl.setText(com.baidu.tieba.t.remove_block_chat);
        } else {
            this.bTl.setText(com.baidu.tieba.t.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aeB() {
        return this.bTk;
    }

    public View aeC() {
        return this.bTl;
    }
}
