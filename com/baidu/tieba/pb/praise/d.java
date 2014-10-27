package com.baidu.tieba.pb.praise;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.model.NetModel;
/* loaded from: classes.dex */
public class d extends NetModel<f, g> {
    public d(Context context, f fVar) {
        super(context, fVar, NetModel.NetModelType.TYPE_HTTP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<g> getResponseDataClass() {
        return g.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int tI() {
        return CmdConfigHttp.PRAISE_LIST_HTTP_CMD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int tJ() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public String tK() {
        return "c/u/zan/getuserlist";
    }
}
