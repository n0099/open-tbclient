package com.baidu.tieba.imMessageCenter.mention.agree;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.imMessageCenter.mention.agree.message.AgreeMeHTTPResponseMessage;
import com.baidu.tieba.imMessageCenter.mention.agree.message.AgreeMeRequestMessage;
import com.baidu.tieba.imMessageCenter.mention.agree.message.AgreeMeSocketResponseMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.AgreeList;
import tbclient.AgreeMe.AgreeMeResIdl;
/* loaded from: classes2.dex */
public class b {
    private a eAY;
    private ArrayList<h> eAZ;
    public boolean hasMore;
    private BdUniqueId uniqueId;
    private boolean eAW = false;
    private long eAX = 0;
    private com.baidu.adp.framework.listener.a eBa = new com.baidu.adp.framework.listener.a(CmdConfigHttp.AGREE_ME_HTTP_CMD, 309593) { // from class: com.baidu.tieba.imMessageCenter.mention.agree.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = false;
            if (responsedMessage != null) {
                if (responsedMessage.hasError()) {
                    if (b.this.eAY != null) {
                        b.this.eAY.mg(responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof AgreeMeRequestMessage)) {
                    z = ((AgreeMeRequestMessage) responsedMessage.getOrginalMessage().getExtra()).id == 0;
                }
                if (responsedMessage instanceof AgreeMeHTTPResponseMessage) {
                    AgreeMeHTTPResponseMessage agreeMeHTTPResponseMessage = (AgreeMeHTTPResponseMessage) responsedMessage;
                    b.this.d(agreeMeHTTPResponseMessage.datas, z);
                    b.this.hasMore = agreeMeHTTPResponseMessage.hasMore;
                } else if (responsedMessage instanceof AgreeMeSocketResponseMessage) {
                    AgreeMeSocketResponseMessage agreeMeSocketResponseMessage = (AgreeMeSocketResponseMessage) responsedMessage;
                    b.this.d(agreeMeSocketResponseMessage.datas, z);
                    b.this.hasMore = agreeMeSocketResponseMessage.hasMore;
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void I(ArrayList<h> arrayList);

        void mg(String str);
    }

    static {
        com.baidu.tieba.tbadkCore.a.a.a(309593, AgreeMeSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309593, CmdConfigHttp.AGREE_ME_HTTP_CMD, "c/u/feed/agreeme", AgreeMeHTTPResponseMessage.class, false, false, false, false);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        if (tbPageContext != null) {
            this.uniqueId = tbPageContext.getUniqueId();
            tbPageContext.registerListener(this.eBa);
            this.eAY = aVar;
        }
    }

    public void aBT() {
        aCd();
        aCb();
    }

    public void aNG() {
        this.eAX = 0L;
        aCb();
    }

    public void SJ() {
        aCb();
    }

    private void aCd() {
        new BdAsyncTask<Void, Void, ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a>>() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: g */
            public ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> doInBackground(Void... voidArr) {
                byte[] bArr;
                ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList = new ArrayList<>();
                l<byte[]> Q = com.baidu.tbadk.core.c.a.wW().Q("tb_user_agreeme", TbadkCoreApplication.getCurrentAccountName());
                if (Q != null && (bArr = Q.get("agree_me_cache_key")) != null) {
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
            /* renamed from: V */
            public void onPostExecute(ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList) {
                super.onPostExecute(arrayList);
                if (arrayList != null) {
                    b.this.U(arrayList);
                }
            }
        }.execute(new Void[0]);
    }

    private void aCb() {
        AgreeMeRequestMessage agreeMeRequestMessage = new AgreeMeRequestMessage();
        agreeMeRequestMessage.id = this.eAX;
        agreeMeRequestMessage.setTag(this.uniqueId);
        MessageManager.getInstance().sendMessage(agreeMeRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList) {
        if (!this.eAW) {
            if (w.z(this.eAZ)) {
                this.eAZ = new ArrayList<>();
            } else {
                this.eAZ.clear();
            }
            this.eAZ.addAll(arrayList);
            h hVar = (h) w.c(this.eAZ, this.eAZ.size() - 1);
            if (hVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                this.eAX = ((com.baidu.tieba.imMessageCenter.mention.base.a) hVar).getMsgId();
            }
            if (this.eAY != null && !w.z(this.eAZ)) {
                this.eAY.I(this.eAZ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList, boolean z) {
        this.eAW = true;
        if (w.z(this.eAZ)) {
            this.eAZ = new ArrayList<>();
        }
        if (!z) {
            this.eAZ.addAll(arrayList);
        } else {
            this.eAZ.clear();
            this.eAZ.addAll(0, arrayList);
        }
        h hVar = (h) w.c(this.eAZ, this.eAZ.size() - 1);
        if (hVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
            this.eAX = ((com.baidu.tieba.imMessageCenter.mention.base.a) hVar).getMsgId();
        }
        if (this.eAY != null) {
            this.eAY.I(this.eAZ);
        }
    }
}
