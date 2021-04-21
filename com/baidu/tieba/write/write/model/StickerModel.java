package com.baidu.tieba.write.write.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.write.write.message.RequestGetStickerMessage;
import com.baidu.tieba.write.write.message.ResponseHttpGetStickerMessage;
import com.baidu.tieba.write.write.message.ResponseSocketGetStickerMessage;
import d.b.c.e.p.j;
import java.util.List;
/* loaded from: classes5.dex */
public class StickerModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.v3.v.l.a f22260e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.c.c.g.a f22261f;

    /* loaded from: classes5.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof ResponseHttpGetStickerMessage;
            if (z || (responsedMessage instanceof ResponseSocketGetStickerMessage)) {
                List<String> list = null;
                if (z) {
                    list = ((ResponseHttpGetStickerMessage) responsedMessage).getUrlList();
                } else if (responsedMessage instanceof ResponseSocketGetStickerMessage) {
                    list = ((ResponseSocketGetStickerMessage) responsedMessage).getUrlList();
                }
                if (StickerModel.this.f22260e != null) {
                    StickerModel.this.f22260e.d(list);
                }
            }
        }
    }

    public StickerModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        a aVar = new a(CmdConfigHttp.CMD_GET_STICKET_LIST, 309475);
        this.f22261f = aVar;
        registerListener(aVar);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (j.A()) {
            d.b.j0.d3.d0.a.h(309475, ResponseSocketGetStickerMessage.class, false, false);
            d.b.j0.d3.d0.a.c(309475, CmdConfigHttp.CMD_GET_STICKET_LIST, TbConfig.URL_GET_STICKER_LIST, ResponseHttpGetStickerMessage.class, false, false, true, false);
            RequestGetStickerMessage requestGetStickerMessage = new RequestGetStickerMessage();
            requestGetStickerMessage.setTag(this.unique_id);
            sendMessage(requestGetStickerMessage);
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void destroy() {
        cancelLoadData();
    }

    public void t(d.b.j0.v3.v.l.a aVar) {
        this.f22260e = aVar;
    }
}
