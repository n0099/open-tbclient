package com.baidu.tieba.imMessageCenter.mention.agree;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.imMessageCenter.mention.agree.message.AgreeMeHTTPResponseMessage;
import com.baidu.tieba.imMessageCenter.mention.agree.message.AgreeMeRequestMessage;
import com.baidu.tieba.imMessageCenter.mention.agree.message.AgreeMeSocketResponseMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.AgreeList;
import tbclient.AgreeMe.AgreeMeResIdl;
/* loaded from: classes7.dex */
public class b {
    private a hOf;
    private ArrayList<m> hOg;
    public boolean hasMore;
    private BdUniqueId uniqueId;
    private boolean hOe = false;
    private long lastId = 0;
    private com.baidu.adp.framework.listener.a hOh = new com.baidu.adp.framework.listener.a(1002211, CmdConfigSocket.CMD_AGREE_ME) { // from class: com.baidu.tieba.imMessageCenter.mention.agree.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = false;
            if (responsedMessage != null) {
                if (responsedMessage.hasError()) {
                    if (b.this.hOf != null) {
                        b.this.hOf.onFailed(responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof AgreeMeRequestMessage)) {
                    z = ((AgreeMeRequestMessage) responsedMessage.getOrginalMessage().getExtra()).id == 0;
                }
                if (responsedMessage instanceof AgreeMeHTTPResponseMessage) {
                    AgreeMeHTTPResponseMessage agreeMeHTTPResponseMessage = (AgreeMeHTTPResponseMessage) responsedMessage;
                    b.this.e(agreeMeHTTPResponseMessage.datas, z);
                    b.this.hasMore = agreeMeHTTPResponseMessage.hasMore;
                } else if (responsedMessage instanceof AgreeMeSocketResponseMessage) {
                    AgreeMeSocketResponseMessage agreeMeSocketResponseMessage = (AgreeMeSocketResponseMessage) responsedMessage;
                    b.this.e(agreeMeSocketResponseMessage.datas, z);
                    b.this.hasMore = agreeMeSocketResponseMessage.hasMore;
                }
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void al(ArrayList<m> arrayList);

        void onFailed(String str);
    }

    static {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_AGREE_ME, AgreeMeSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_AGREE_ME, 1002211, Config.AGREE_ME_ADDRESS, AgreeMeHTTPResponseMessage.class, false, false, false, false);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        if (tbPageContext != null) {
            this.uniqueId = tbPageContext.getUniqueId();
            tbPageContext.registerListener(this.hOh);
            this.hOf = aVar;
        }
    }

    public void bLu() {
        axI();
        axH();
    }

    public void bEV() {
        this.lastId = 0L;
        axH();
    }

    public void aZN() {
        axH();
    }

    private void axI() {
        new BdAsyncTask<Void, Void, ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a>>() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: e */
            public ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> doInBackground(Void... voidArr) {
                byte[] bArr;
                ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList = new ArrayList<>();
                l<byte[]> ch = com.baidu.tbadk.core.c.a.aCo().ch("tb_user_agreeme", TbadkCoreApplication.getCurrentAccountName());
                if (ch != null && (bArr = ch.get("agree_me_cache_key")) != null) {
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
            public void onPostExecute(ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList) {
                super.onPostExecute((AnonymousClass2) arrayList);
                if (arrayList != null) {
                    b.this.q(arrayList);
                }
            }
        }.execute(new Void[0]);
    }

    private void axH() {
        AgreeMeRequestMessage agreeMeRequestMessage = new AgreeMeRequestMessage();
        agreeMeRequestMessage.id = this.lastId;
        agreeMeRequestMessage.setTag(this.uniqueId);
        MessageManager.getInstance().sendMessage(agreeMeRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList) {
        if (!this.hOe) {
            if (v.isEmpty(this.hOg)) {
                this.hOg = new ArrayList<>();
            } else {
                this.hOg.clear();
            }
            this.hOg.addAll(arrayList);
            m mVar = (m) v.getItem(this.hOg, this.hOg.size() - 1);
            if (mVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                this.lastId = ((com.baidu.tieba.imMessageCenter.mention.base.a) mVar).getMsgId();
            }
            if (this.hOf != null && !v.isEmpty(this.hOg)) {
                this.hOf.al(this.hOg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList, boolean z) {
        this.hOe = true;
        if (v.isEmpty(this.hOg)) {
            this.hOg = new ArrayList<>();
        }
        if (!z) {
            this.hOg.addAll(arrayList);
        } else {
            this.hOg.clear();
            this.hOg.addAll(0, arrayList);
        }
        m mVar = (m) v.getItem(this.hOg, this.hOg.size() - 1);
        if (mVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
            this.lastId = ((com.baidu.tieba.imMessageCenter.mention.base.a) mVar).getMsgId();
        }
        if (this.hOf != null) {
            this.hOf.al(this.hOg);
        }
    }
}
