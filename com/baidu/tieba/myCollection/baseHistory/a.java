package com.baidu.tieba.myCollection.baseHistory;

import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.model.a<b, BaseActivity> {
    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public Class<b> AH() {
        return b.class;
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public int AI() {
        return 2001190;
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public int AJ() {
        return 2001191;
    }

    @Override // com.baidu.tbadk.mvc.a.b
    public String AK() {
        return "tb.pb_history";
    }
}
