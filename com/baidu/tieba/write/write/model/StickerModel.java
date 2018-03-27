package com.baidu.tieba.write.write.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.write.write.message.RequestGetStickerMessage;
import com.baidu.tieba.write.write.message.ResponseHttpGetStickerMessage;
import com.baidu.tieba.write.write.message.ResponseSocketGetStickerMessage;
import java.util.List;
/* loaded from: classes2.dex */
public class StickerModel extends BdBaseModel {
    private a hNA;
    private com.baidu.adp.framework.listener.a hNB;

    public StickerModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hNB = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_STICKET_LIST, 309475) { // from class: com.baidu.tieba.write.write.model.StickerModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if ((responsedMessage instanceof ResponseHttpGetStickerMessage) || (responsedMessage instanceof ResponseSocketGetStickerMessage)) {
                        List<String> list = null;
                        if (responsedMessage instanceof ResponseHttpGetStickerMessage) {
                            list = ((ResponseHttpGetStickerMessage) responsedMessage).getUrlList();
                        } else if (responsedMessage instanceof ResponseSocketGetStickerMessage) {
                            list = ((ResponseSocketGetStickerMessage) responsedMessage).getUrlList();
                        }
                        if (StickerModel.this.hNA != null) {
                            StickerModel.this.hNA.dY(list);
                        }
                    }
                }
            }
        };
        registerListener(this.hNB);
    }

    public void a(a aVar) {
        this.hNA = aVar;
    }

    public void bJE() {
        if (j.ox()) {
            com.baidu.tieba.tbadkCore.a.a.a(309475, ResponseSocketGetStickerMessage.class, false, false);
            com.baidu.tieba.tbadkCore.a.a.a(309475, CmdConfigHttp.CMD_GET_STICKET_LIST, TbConfig.URL_GET_STICKER_LIST, ResponseHttpGetStickerMessage.class, false, false, true, false);
            RequestGetStickerMessage requestGetStickerMessage = new RequestGetStickerMessage();
            requestGetStickerMessage.setTag(this.unique_id);
            sendMessage(requestGetStickerMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }
}
