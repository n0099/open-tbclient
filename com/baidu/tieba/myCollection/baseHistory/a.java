package com.baidu.tieba.myCollection.baseHistory;

import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.model.a<b, BaseActivity> {
    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public Class<b> zU() {
        return b.class;
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public int zV() {
        return 2001190;
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public int zW() {
        return 2001191;
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public String zX() {
        return "tb.pb_history";
    }
}
