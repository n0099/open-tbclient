package com.baidu.tieba.write.write.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.write.write.message.RequestGetStickerMessage;
import com.baidu.tieba.write.write.message.ResponseHttpGetStickerMessage;
import com.baidu.tieba.write.write.message.ResponseSocketGetStickerMessage;
import java.util.List;
/* loaded from: classes13.dex */
public class StickerModel extends BdBaseModel {
    private a kVd;
    private com.baidu.adp.framework.listener.a kVe;

    public StickerModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.kVe = new com.baidu.adp.framework.listener.a(1003341, CmdConfigSocket.CMD_GET_STICKET_LIST) { // from class: com.baidu.tieba.write.write.model.StickerModel.1
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
                        if (StickerModel.this.kVd != null) {
                            StickerModel.this.kVd.eB(list);
                        }
                    }
                }
            }
        };
        registerListener(this.kVe);
    }

    public void a(a aVar) {
        this.kVd = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (j.isNetworkAvailableForImmediately()) {
            com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_STICKET_LIST, ResponseSocketGetStickerMessage.class, false, false);
            com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_STICKET_LIST, 1003341, TbConfig.URL_GET_STICKER_LIST, ResponseHttpGetStickerMessage.class, false, false, true, false);
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
