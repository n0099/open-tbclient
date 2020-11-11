package com.baidu.tieba.imMessageCenter.mention.agree;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.imMessageCenter.mention.agree.message.AgreeMeHTTPResponseMessage;
import com.baidu.tieba.imMessageCenter.mention.agree.message.AgreeMeRequestMessage;
import com.baidu.tieba.imMessageCenter.mention.agree.message.AgreeMeSocketResponseMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.AgreeList;
import tbclient.AgreeMe.AgreeMeResIdl;
/* loaded from: classes22.dex */
public class b {
    public boolean hasMore;
    private a kwe;
    private ArrayList<q> kwf;
    private BdUniqueId uniqueId;
    private boolean kwd = false;
    private long lastId = 0;
    private com.baidu.adp.framework.listener.a kwg = new com.baidu.adp.framework.listener.a(1002211, CmdConfigSocket.CMD_AGREE_ME) { // from class: com.baidu.tieba.imMessageCenter.mention.agree.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = false;
            if (responsedMessage != null) {
                if (responsedMessage.hasError()) {
                    if (b.this.kwe != null) {
                        b.this.kwe.onFailed(responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof AgreeMeRequestMessage)) {
                    z = ((AgreeMeRequestMessage) responsedMessage.getOrginalMessage().getExtra()).id == 0;
                }
                if (responsedMessage instanceof AgreeMeHTTPResponseMessage) {
                    AgreeMeHTTPResponseMessage agreeMeHTTPResponseMessage = (AgreeMeHTTPResponseMessage) responsedMessage;
                    b.this.f(agreeMeHTTPResponseMessage.datas, z);
                    b.this.hasMore = agreeMeHTTPResponseMessage.hasMore;
                } else if (responsedMessage instanceof AgreeMeSocketResponseMessage) {
                    AgreeMeSocketResponseMessage agreeMeSocketResponseMessage = (AgreeMeSocketResponseMessage) responsedMessage;
                    b.this.f(agreeMeSocketResponseMessage.datas, z);
                    b.this.hasMore = agreeMeSocketResponseMessage.hasMore;
                }
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void ax(ArrayList<q> arrayList);

        void onFailed(String str);
    }

    static {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_AGREE_ME, AgreeMeSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_AGREE_ME, 1002211, Config.AGREE_ME_ADDRESS, AgreeMeHTTPResponseMessage.class, false, false, false, false);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        if (tbPageContext != null) {
            this.uniqueId = tbPageContext.getUniqueId();
            tbPageContext.registerListener(this.kwg);
            this.kwe = aVar;
        }
    }

    public void cIA() {
        bjR();
        bjQ();
    }

    public void cBt() {
        this.lastId = 0L;
        bjQ();
    }

    public void bOI() {
        bjQ();
    }

    private void bjR() {
        new BdAsyncTask<Void, Void, ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a>>() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: f */
            public ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> doInBackground(Void... voidArr) {
                byte[] bArr;
                ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList = new ArrayList<>();
                l<byte[]> dH = com.baidu.tbadk.core.c.a.boX().dH("tb_user_agreeme", TbadkCoreApplication.getCurrentAccountName());
                if (dH != null && (bArr = dH.get("agree_me_cache_key")) != null) {
                    try {
                        AgreeMeResIdl agreeMeResIdl = (AgreeMeResIdl) new Wire(new Class[0]).parseFrom(bArr, AgreeMeResIdl.class);
                        if (agreeMeResIdl.data != null) {
                            b.this.hasMore = agreeMeResIdl.data.has_more.intValue() == 1;
                            for (AgreeList agreeList : agreeMeResIdl.data.agree_list) {
                                if (agreeList != null) {
                                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = new com.baidu.tieba.imMessageCenter.mention.base.a();
                                    aVar.a(agreeList);
                                    arrayList.add(aVar);
                                }
                            }
                        }
                    } catch (Exception e) {
                        return null;
                    }
                }
                return arrayList;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: B */
            public void onPostExecute(ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList) {
                super.onPostExecute(arrayList);
                if (arrayList != null) {
                    b.this.y(arrayList);
                }
            }
        }.execute(new Void[0]);
    }

    private void bjQ() {
        AgreeMeRequestMessage agreeMeRequestMessage = new AgreeMeRequestMessage();
        agreeMeRequestMessage.id = this.lastId;
        agreeMeRequestMessage.setTag(this.uniqueId);
        MessageManager.getInstance().sendMessage(agreeMeRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList) {
        if (!this.kwd) {
            if (y.isEmpty(this.kwf)) {
                this.kwf = new ArrayList<>();
            } else {
                this.kwf.clear();
            }
            this.kwf.addAll(arrayList);
            q qVar = (q) y.getItem(this.kwf, this.kwf.size() - 1);
            if (qVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                this.lastId = ((com.baidu.tieba.imMessageCenter.mention.base.a) qVar).getMsgId();
            }
            if (this.kwe != null && !y.isEmpty(this.kwf)) {
                this.kwe.ax(this.kwf);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList, boolean z) {
        this.kwd = true;
        if (y.isEmpty(this.kwf)) {
            this.kwf = new ArrayList<>();
        }
        if (!z) {
            this.kwf.addAll(arrayList);
        } else {
            this.kwf.clear();
            this.kwf.addAll(0, arrayList);
        }
        q qVar = (q) y.getItem(this.kwf, this.kwf.size() - 1);
        if (qVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
            this.lastId = ((com.baidu.tieba.imMessageCenter.mention.base.a) qVar).getMsgId();
        }
        if (this.kwe != null) {
            this.kwe.ax(this.kwf);
        }
    }
}
