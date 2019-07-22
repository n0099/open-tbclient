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
/* loaded from: classes3.dex */
public class StickerModel extends BdBaseModel {
    private a jVt;
    private com.baidu.adp.framework.listener.a jVu;

    public StickerModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.jVu = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_STICKET_LIST, 309475) { // from class: com.baidu.tieba.write.write.model.StickerModel.1
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
                        if (StickerModel.this.jVt != null) {
                            StickerModel.this.jVt.eC(list);
                        }
                    }
                }
            }
        };
        registerListener(this.jVu);
    }

    public void a(a aVar) {
        this.jVt = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (j.jQ()) {
            com.baidu.tieba.tbadkCore.a.a.a(309475, ResponseSocketGetStickerMessage.class, false, false);
            com.baidu.tieba.tbadkCore.a.a.a(309475, CmdConfigHttp.CMD_GET_STICKET_LIST, TbConfig.URL_GET_STICKER_LIST, ResponseHttpGetStickerMessage.class, false, false, true, false);
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
}
