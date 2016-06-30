package com.baidu.tieba.pb.data;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class PbEcommRecommendMessage extends HttpMessage {
    public static final String PRODUCT_ID = "product_id";
    public static final String RECOMMEND = "recommend";
    public long productId;
    public boolean recommend;

    public PbEcommRecommendMessage(long j, boolean z) {
        super(CmdConfigHttp.PB_ECOMM_RECOMMEND_HTTP_CMD);
        this.productId = j;
        this.recommend = z;
        addParam("product_id", j);
        addParam(RECOMMEND, z ? 1 : 0);
    }
}
