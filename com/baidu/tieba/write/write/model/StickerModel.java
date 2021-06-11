package com.baidu.tieba.write.write.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.write.write.message.RequestGetStickerMessage;
import com.baidu.tieba.write.write.message.ResponseHttpGetStickerMessage;
import com.baidu.tieba.write.write.message.ResponseSocketGetStickerMessage;
import d.a.c.e.p.j;
import java.util.List;
/* loaded from: classes5.dex */
public class StickerModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.w3.u.l.a f22225e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f22226f;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
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
                if (StickerModel.this.f22225e != null) {
                    StickerModel.this.f22225e.e(list);
                }
            }
        }
    }

    public StickerModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        a aVar = new a(CmdConfigHttp.CMD_GET_STICKET_LIST, 309475);
        this.f22226f = aVar;
        registerListener(aVar);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (j.A()) {
            d.a.n0.e3.d0.a.h(309475, ResponseSocketGetStickerMessage.class, false, false);
            d.a.n0.e3.d0.a.c(309475, CmdConfigHttp.CMD_GET_STICKET_LIST, TbConfig.URL_GET_STICKER_LIST, ResponseHttpGetStickerMessage.class, false, false, true, false);
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

    public void x(d.a.n0.w3.u.l.a aVar) {
        this.f22225e = aVar;
    }
}
