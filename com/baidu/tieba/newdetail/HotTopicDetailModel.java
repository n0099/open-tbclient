package com.baidu.tieba.newdetail;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.hottopic.data.d;
import com.baidu.tieba.hottopic.data.e;
import com.baidu.tieba.hottopic.data.i;
import com.baidu.tieba.hottopic.message.RequestGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.RequestHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotTopicMessage;
import com.baidu.tieba.message.RequestBlessMessage;
import com.baidu.tieba.newdetail.a;
/* loaded from: classes21.dex */
public class HotTopicDetailModel extends BdBaseModel {
    private String eIa;
    private String from;
    private int height;
    private a.InterfaceC0814a lpi;
    private boolean lpj;
    private double lpk;
    private boolean mIsLoading;
    private long topicId;
    private int width;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HotTopicDetailModel(TbPageContext<?> tbPageContext, a.InterfaceC0814a interfaceC0814a) {
        super(tbPageContext);
        this.lpk = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.width = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        this.height = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        cPu();
        this.lpi = interfaceC0814a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(long j, String str) {
        this.topicId = j;
        this.eIa = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFrom(String str) {
        this.from = str;
    }

    private void cPu() {
        registerListener(new com.baidu.adp.framework.listener.a(1003041, CmdConfigSocket.CMD_HOT_TOPIC) { // from class: com.baidu.tieba.newdetail.HotTopicDetailModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z = HotTopicDetailModel.this.mIsLoading;
                HotTopicDetailModel.this.mIsLoading = false;
                if (responsedMessage != null) {
                    if (((responsedMessage instanceof ResponseHttpHotTopicMessage) || (responsedMessage instanceof ResponseSocketHotTopicMessage)) && responsedMessage.getOrginalMessage().getTag() == HotTopicDetailModel.this.getUniqueId()) {
                        e hotTopicData = (!(responsedMessage instanceof ResponseHttpHotTopicMessage) || ((ResponseHttpHotTopicMessage) responsedMessage).getHotTopicData() == null) ? null : ((ResponseHttpHotTopicMessage) responsedMessage).getHotTopicData();
                        if ((responsedMessage instanceof ResponseSocketHotTopicMessage) && ((ResponseSocketHotTopicMessage) responsedMessage).getHotTopicData() != null) {
                            hotTopicData = ((ResponseSocketHotTopicMessage) responsedMessage).getHotTopicData();
                        }
                        if (hotTopicData != null && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
                            hotTopicData.sortType = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
                            if (hotTopicData.kdC != null) {
                                hotTopicData.kdC.sortType = hotTopicData.sortType;
                            }
                            if (hotTopicData.sortType == -1) {
                                HotTopicDetailModel.this.mIsLoading = z;
                            }
                        }
                        if (hotTopicData != null) {
                            HotTopicDetailModel.this.lpi.a(responsedMessage.getError(), hotTopicData);
                        } else {
                            HotTopicDetailModel.this.lpi.a(-1, (e) null);
                        }
                    }
                }
            }
        });
        registerListener(new com.baidu.adp.framework.listener.a(1003042, CmdConfigSocket.CMD_TOPIC_RELATE_THREAD) { // from class: com.baidu.tieba.newdetail.HotTopicDetailModel.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                HotTopicDetailModel.this.mIsLoading = false;
                if (responsedMessage != null) {
                    if (((responsedMessage instanceof ResponseHttpGetTopicRelateThreadMessage) || (responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage)) && responsedMessage.getOrginalMessage().getTag() == HotTopicDetailModel.this.getUniqueId()) {
                        d hotThreadItemListData = (!(responsedMessage instanceof ResponseHttpGetTopicRelateThreadMessage) || ((ResponseHttpGetTopicRelateThreadMessage) responsedMessage).getHotThreadItemListData() == null) ? null : ((ResponseHttpGetTopicRelateThreadMessage) responsedMessage).getHotThreadItemListData();
                        if ((responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage) && ((ResponseSocketGetTopicRelateThreadMessage) responsedMessage).getHotThreadItemListData() != null) {
                            hotThreadItemListData = ((ResponseSocketGetTopicRelateThreadMessage) responsedMessage).getHotThreadItemListData();
                        }
                        if (hotThreadItemListData != null && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
                            hotThreadItemListData.sortType = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
                        }
                        if (hotThreadItemListData != null) {
                            HotTopicDetailModel.this.lpi.a(responsedMessage.getError(), hotThreadItemListData);
                        } else {
                            HotTopicDetailModel.this.lpi.a(-1, (d) null);
                        }
                    }
                }
            }
        });
        registerListener(new com.baidu.adp.framework.listener.a(1003065, CmdConfigSocket.CMD_TOPIC_BLESS) { // from class: com.baidu.tieba.newdetail.HotTopicDetailModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                long j2;
                int i;
                if (responsedMessage != null) {
                    if (((responsedMessage instanceof BlessHttpResponseMessage) || (responsedMessage instanceof BlessSocketResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == HotTopicDetailModel.this.getUniqueId()) {
                        if (responsedMessage instanceof BlessHttpResponseMessage) {
                            j2 = ((BlessHttpResponseMessage) responsedMessage).userPkId;
                            j = ((BlessHttpResponseMessage) responsedMessage).pkID;
                        } else {
                            j = 0;
                            j2 = 0;
                        }
                        if (responsedMessage instanceof BlessSocketResponseMessage) {
                            j2 = ((BlessSocketResponseMessage) responsedMessage).userPkId;
                            j = ((BlessSocketResponseMessage) responsedMessage).pkID;
                        }
                        if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
                            i = -1;
                        } else {
                            i = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
                            if (i == 1 || i == 2) {
                                HotTopicDetailModel.this.lpj = false;
                            }
                        }
                        if (j != 0) {
                            HotTopicDetailModel.this.lpi.a(responsedMessage.getError(), j, j2, i);
                        } else {
                            HotTopicDetailModel.this.lpi.a(-1, j, j2, i);
                        }
                    }
                }
            }
        });
    }

    public boolean a(com.baidu.tieba.hottopic.data.a aVar) {
        if (aVar == null || !j.isNetworkAvailableForImmediately()) {
            return false;
        }
        RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
        requestBlessMessage.setPkId(Long.valueOf(aVar.pkId));
        requestBlessMessage.setTopicId(Long.valueOf(this.topicId));
        requestBlessMessage.setPkIndex(1);
        requestBlessMessage.setClickType(aVar.userPkId == 0 ? 0 : 1);
        requestBlessMessage.setPkType(1);
        requestBlessMessage.setUserPkId(aVar.userPkId);
        requestBlessMessage.setTag(this.unique_id);
        if (requestBlessMessage.getHttpMessage() != null) {
            requestBlessMessage.getHttpMessage().setExtra(0);
            requestBlessMessage.getHttpMessage().setTag(getUniqueId());
        }
        if (requestBlessMessage.getSocketMessage() != null) {
            requestBlessMessage.getSocketMessage().setExtra(0);
            requestBlessMessage.getSocketMessage().setTag(getUniqueId());
        }
        return MessageManager.getInstance().sendMessage(requestBlessMessage);
    }

    public boolean a(i iVar, int i) {
        if (iVar == null || !j.isNetworkAvailableForImmediately() || this.lpj) {
            return false;
        }
        RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
        requestBlessMessage.setPkId(Long.valueOf(iVar.pkId));
        requestBlessMessage.setTopicId(Long.valueOf(this.topicId));
        requestBlessMessage.setPkIndex(i);
        requestBlessMessage.setClickType(iVar.userPkId == 0 ? 0 : 1);
        requestBlessMessage.setPkType(0);
        requestBlessMessage.setUserPkId(iVar.userPkId);
        requestBlessMessage.setTag(this.unique_id);
        if (requestBlessMessage.getHttpMessage() != null) {
            requestBlessMessage.getHttpMessage().setExtra(Integer.valueOf(i));
            requestBlessMessage.getHttpMessage().setTag(getUniqueId());
        }
        if (requestBlessMessage.getSocketMessage() != null) {
            requestBlessMessage.getSocketMessage().setExtra(Integer.valueOf(i));
            requestBlessMessage.getSocketMessage().setTag(getUniqueId());
        }
        this.lpj = MessageManager.getInstance().sendMessage(requestBlessMessage);
        return this.lpj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Gu(int i) {
        if (!j.isNetworkAvailableForImmediately() || this.mIsLoading) {
            return false;
        }
        cancelLoadData();
        RequestHotTopicMessage requestHotTopicMessage = new RequestHotTopicMessage();
        requestHotTopicMessage.setTopicId(Long.valueOf(this.topicId));
        requestHotTopicMessage.setTopicName(this.eIa);
        requestHotTopicMessage.setCall_from(MD(this.from));
        requestHotTopicMessage.setSort_type(Integer.valueOf(i));
        requestHotTopicMessage.setScrH(Integer.valueOf(this.height));
        requestHotTopicMessage.setScrW(Integer.valueOf(this.width));
        requestHotTopicMessage.setSrcDip(Double.valueOf(this.lpk));
        if (requestHotTopicMessage.getHttpMessage() != null) {
            requestHotTopicMessage.getHttpMessage().setExtra(Integer.valueOf(i));
            requestHotTopicMessage.getHttpMessage().setTag(getUniqueId());
        }
        if (requestHotTopicMessage.getSocketMessage() != null) {
            requestHotTopicMessage.getSocketMessage().setExtra(Integer.valueOf(i));
            requestHotTopicMessage.getSocketMessage().setTag(getUniqueId());
        }
        requestHotTopicMessage.setTag(this.unique_id);
        this.mIsLoading = MessageManager.getInstance().sendMessage(requestHotTopicMessage);
        return this.mIsLoading;
    }

    public void dkf() {
        if (j.isNetworkAvailableForImmediately()) {
            RequestHotTopicMessage requestHotTopicMessage = new RequestHotTopicMessage();
            requestHotTopicMessage.setTopicId(Long.valueOf(this.topicId));
            requestHotTopicMessage.setTopicName(this.eIa);
            requestHotTopicMessage.setCall_from(MD(this.from));
            requestHotTopicMessage.setSort_type(1);
            requestHotTopicMessage.setScrH(Integer.valueOf(this.height));
            requestHotTopicMessage.setScrW(Integer.valueOf(this.width));
            requestHotTopicMessage.setSrcDip(Double.valueOf(this.lpk));
            if (requestHotTopicMessage.getHttpMessage() != null) {
                requestHotTopicMessage.getHttpMessage().setExtra(-1);
                requestHotTopicMessage.getHttpMessage().setTag(getUniqueId());
            }
            if (requestHotTopicMessage.getSocketMessage() != null) {
                requestHotTopicMessage.getSocketMessage().setExtra(-1);
                requestHotTopicMessage.getSocketMessage().setTag(getUniqueId());
            }
            requestHotTopicMessage.setTag(this.unique_id);
            MessageManager.getInstance().sendMessage(requestHotTopicMessage);
        }
    }

    public boolean Gv(int i) {
        if (!j.isNetworkAvailableForImmediately() || this.mIsLoading) {
            return false;
        }
        cancelLoadData();
        RequestGetTopicRelateThreadMessage requestGetTopicRelateThreadMessage = new RequestGetTopicRelateThreadMessage();
        requestGetTopicRelateThreadMessage.setTopicId(Long.valueOf(this.topicId));
        requestGetTopicRelateThreadMessage.setTopicName(this.eIa);
        requestGetTopicRelateThreadMessage.setRn(10);
        requestGetTopicRelateThreadMessage.setPageNo(1);
        requestGetTopicRelateThreadMessage.setLastId(0L);
        requestGetTopicRelateThreadMessage.setSort_type(Integer.valueOf(i));
        requestGetTopicRelateThreadMessage.setScrH(Integer.valueOf(this.height));
        requestGetTopicRelateThreadMessage.setScrW(Integer.valueOf(this.width));
        requestGetTopicRelateThreadMessage.setScrDip(Double.valueOf(this.lpk));
        if (requestGetTopicRelateThreadMessage.getHttpMessage() != null) {
            requestGetTopicRelateThreadMessage.getHttpMessage().setExtra(Integer.valueOf(i));
            requestGetTopicRelateThreadMessage.getHttpMessage().setTag(getUniqueId());
        }
        if (requestGetTopicRelateThreadMessage.getSocketMessage() != null) {
            requestGetTopicRelateThreadMessage.getSocketMessage().setExtra(Integer.valueOf(i));
            requestGetTopicRelateThreadMessage.getSocketMessage().setTag(getUniqueId());
        }
        requestGetTopicRelateThreadMessage.setTag(this.unique_id);
        this.mIsLoading = MessageManager.getInstance().sendMessage(requestGetTopicRelateThreadMessage);
        return this.mIsLoading;
    }

    public boolean a(int i, ax axVar, long j) {
        if (!j.isNetworkAvailableForImmediately() || this.mIsLoading) {
            return false;
        }
        cancelLoadData();
        RequestGetTopicRelateThreadMessage requestGetTopicRelateThreadMessage = new RequestGetTopicRelateThreadMessage();
        requestGetTopicRelateThreadMessage.setTopicId(Long.valueOf(this.topicId));
        requestGetTopicRelateThreadMessage.setTopicName(this.eIa);
        requestGetTopicRelateThreadMessage.setRn(10);
        requestGetTopicRelateThreadMessage.setPageNo(Integer.valueOf(axVar.bnD() + 1));
        requestGetTopicRelateThreadMessage.setLastId(Long.valueOf(j));
        requestGetTopicRelateThreadMessage.setSort_type(Integer.valueOf(i));
        requestGetTopicRelateThreadMessage.setScrH(Integer.valueOf(this.height));
        requestGetTopicRelateThreadMessage.setScrW(Integer.valueOf(this.width));
        requestGetTopicRelateThreadMessage.setScrDip(Double.valueOf(this.lpk));
        if (requestGetTopicRelateThreadMessage.getHttpMessage() != null) {
            requestGetTopicRelateThreadMessage.getHttpMessage().setExtra(Integer.valueOf(i));
            requestGetTopicRelateThreadMessage.getHttpMessage().setTag(getUniqueId());
        }
        if (requestGetTopicRelateThreadMessage.getSocketMessage() != null) {
            requestGetTopicRelateThreadMessage.getSocketMessage().setExtra(Integer.valueOf(i));
            requestGetTopicRelateThreadMessage.getSocketMessage().setTag(getUniqueId());
        }
        requestGetTopicRelateThreadMessage.setTag(this.unique_id);
        this.mIsLoading = MessageManager.getInstance().sendMessage(requestGetTopicRelateThreadMessage);
        return this.mIsLoading;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return Gu(1);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    private int MD(String str) {
        if ("1".equals(str)) {
            return 1;
        }
        if ("2".equals(str)) {
            return 2;
        }
        if ("3".equals(str)) {
            return 3;
        }
        if ("4".equals(str)) {
            return 4;
        }
        return "5".equals(str) ? 5 : 1;
    }
}
