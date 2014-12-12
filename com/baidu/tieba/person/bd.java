package com.baidu.tieba.person;

import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.personInfo.PersonInfoActivity;
/* loaded from: classes.dex */
public class bd extends com.baidu.adp.base.g {
    TextView bGw;
    TextView bGx;
    View mView;

    public bd(PersonInfoActivity personInfoActivity) {
        super(personInfoActivity.getPageContext());
        a(personInfoActivity);
    }

    private void a(PersonInfoActivity personInfoActivity) {
        this.mView = com.baidu.adp.lib.g.b.ek().inflate(personInfoActivity.getPageContext().getPageActivity(), com.baidu.tieba.x.person_info_more_view, null);
        this.bGw = (TextView) this.mView.findViewById(com.baidu.tieba.w.person_info_more_view_item_friend);
        this.bGw.setOnClickListener(personInfoActivity);
        this.bGx = (TextView) this.mView.findViewById(com.baidu.tieba.w.person_info_more_view_item_black);
        this.bGx.setOnClickListener(personInfoActivity);
    }

    public void h(boolean z, boolean z2) {
        if (z) {
            this.bGw.setVisibility(0);
        } else {
            this.bGw.setVisibility(8);
        }
        if (z2) {
            this.bGx.setText(com.baidu.tieba.z.remove_block_chat);
        } else {
            this.bGx.setText(com.baidu.tieba.z.block_chat_message);
        }
    }

    public View getView() {
        return this.mView;
    }

    public View aav() {
        return this.bGw;
    }

    public View aaw() {
        return this.bGx;
    }
}
