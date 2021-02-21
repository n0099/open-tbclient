package com.baidu.tieba.imMessageCenter.mention.agree;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.widget.ListView.n;
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
/* loaded from: classes2.dex */
public class b {
    public boolean hasMore;
    private a kTf;
    private ArrayList<n> kTg;
    private BdUniqueId uniqueId;
    private boolean kTe = false;
    private long lastId = 0;
    private com.baidu.adp.framework.listener.a kTh = new com.baidu.adp.framework.listener.a(1002211, CmdConfigSocket.CMD_AGREE_ME) { // from class: com.baidu.tieba.imMessageCenter.mention.agree.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = false;
            if (responsedMessage != null) {
                if (responsedMessage.hasError()) {
                    if (b.this.kTf != null) {
                        b.this.kTf.onFailed(responsedMessage.getErrorString());
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

    /* loaded from: classes2.dex */
    public interface a {
        void at(ArrayList<n> arrayList);

        void onFailed(String str);
    }

    static {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_AGREE_ME, AgreeMeSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_AGREE_ME, 1002211, Config.AGREE_ME_ADDRESS, AgreeMeHTTPResponseMessage.class, false, false, false, false);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        if (tbPageContext != null) {
            this.uniqueId = tbPageContext.getUniqueId();
            tbPageContext.registerListener(this.kTh);
            this.kTf = aVar;
        }
    }

    public void cOO() {
        bld();
        blc();
    }

    public void cFL() {
        this.lastId = 0L;
        blc();
    }

    public void bRj() {
        blc();
    }

    private void bld() {
        new BdAsyncTask<Void, Void, ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a>>() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: f */
            public ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> doInBackground(Void... voidArr) {
                byte[] bArr;
                ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList = new ArrayList<>();
                l<byte[]> dE = com.baidu.tbadk.core.c.a.bqr().dE("tb_user_agreeme", TbadkCoreApplication.getCurrentAccountName());
                if (dE != null && (bArr = dE.get("agree_me_cache_key")) != null) {
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
            /* renamed from: w */
            public void onPostExecute(ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList) {
                super.onPostExecute(arrayList);
                if (arrayList != null) {
                    b.this.t(arrayList);
                }
            }
        }.execute(new Void[0]);
    }

    private void blc() {
        AgreeMeRequestMessage agreeMeRequestMessage = new AgreeMeRequestMessage();
        agreeMeRequestMessage.id = this.lastId;
        agreeMeRequestMessage.setTag(this.uniqueId);
        MessageManager.getInstance().sendMessage(agreeMeRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList) {
        if (!this.kTe) {
            if (y.isEmpty(this.kTg)) {
                this.kTg = new ArrayList<>();
            } else {
                this.kTg.clear();
            }
            this.kTg.addAll(arrayList);
            n nVar = (n) y.getItem(this.kTg, this.kTg.size() - 1);
            if (nVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                this.lastId = ((com.baidu.tieba.imMessageCenter.mention.base.a) nVar).getMsgId();
            }
            if (this.kTf != null && !y.isEmpty(this.kTg)) {
                this.kTf.at(this.kTg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList, boolean z) {
        this.kTe = true;
        if (y.isEmpty(this.kTg)) {
            this.kTg = new ArrayList<>();
        }
        if (!z) {
            this.kTg.addAll(arrayList);
        } else {
            this.kTg.clear();
            this.kTg.addAll(0, arrayList);
        }
        n nVar = (n) y.getItem(this.kTg, this.kTg.size() - 1);
        if (nVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
            this.lastId = ((com.baidu.tieba.imMessageCenter.mention.base.a) nVar).getMsgId();
        }
        if (this.kTf != null) {
            this.kTf.at(this.kTg);
        }
    }
}
