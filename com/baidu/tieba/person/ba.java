package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.personInfo.PersonInfoActivity;
/* loaded from: classes.dex */
public class ba extends com.baidu.adp.base.g {
    TextView bQF;
    TextView bQG;
    View mView;

    public ba(PersonInfoActivity personInfoActivity) {
        super(personInfoActivity.getPageContext());
        a(personInfoActivity);
    }

    private void a(PersonInfoActivity personInfoActivity) {
        this.mView = com.baidu.adp.lib.g.b.hH().inflate(personInfoActivity.getPageContext().getPageActivity(), com.baidu.tieba.w.person_info_more_view, null);
        this.bQF = (TextView) this.mView.findViewById(com.baidu.tieba.v.person_info_more_view_item_friend);
        this.bQF.setOnClickListener(personInfoActivity);
        this.bQG = (TextView) this.mView.findViewById(com.baidu.tieba.v.person_info_more_view_item_black);
        this.bQG.setOnClickListener(personInfoActivity);
    }

    public void e(boolean z, boolean z2) {
        if (z) {
            this.bQF.setVisibility(0);
        } else {
            this.bQF.setVisibility(8);
        }
        if (z2) {
            this.bQG.setText(com.baidu.tieba.y.remove_block_chat);
        } else {
            this.bQG.setText(com.baidu.tieba.y.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View adt() {
        return this.bQF;
    }

    public View adu() {
        return this.bQG;
    }
}
