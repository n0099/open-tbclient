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
    private a eII;
    private ArrayList<h> eIJ;
    public boolean hasMore;
    private BdUniqueId uniqueId;
    private boolean eIG = false;
    private long eIH = 0;
    private com.baidu.adp.framework.listener.a eIK = new com.baidu.adp.framework.listener.a(CmdConfigHttp.AGREE_ME_HTTP_CMD, 309593) { // from class: com.baidu.tieba.imMessageCenter.mention.agree.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = false;
            if (responsedMessage != null) {
                if (responsedMessage.hasError()) {
                    if (b.this.eII != null) {
                        b.this.eII.mb(responsedMessage.getErrorString());
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
        void O(ArrayList<h> arrayList);

        void mb(String str);
    }

    static {
        com.baidu.tieba.tbadkCore.a.a.a(309593, AgreeMeSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309593, CmdConfigHttp.AGREE_ME_HTTP_CMD, "c/u/feed/agreeme", AgreeMeHTTPResponseMessage.class, false, false, false, false);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        if (tbPageContext != null) {
            this.uniqueId = tbPageContext.getUniqueId();
            tbPageContext.registerListener(this.eIK);
            this.eII = aVar;
        }
    }

    public void aDh() {
        tx();
        tw();
    }

    public void aPm() {
        this.eIH = 0L;
        tw();
    }

    public void Tn() {
        tw();
    }

    private void tx() {
        new BdAsyncTask<Void, Void, ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a>>() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: c */
            public ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> doInBackground(Void... voidArr) {
                byte[] bArr;
                ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList = new ArrayList<>();
                l<byte[]> P = com.baidu.tbadk.core.c.a.xb().P("tb_user_agreeme", TbadkCoreApplication.getCurrentAccountName());
                if (P != null && (bArr = P.get("agree_me_cache_key")) != null) {
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
            /* renamed from: i */
            public void onPostExecute(ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList) {
                super.onPostExecute(arrayList);
                if (arrayList != null) {
                    b.this.f(arrayList);
                }
            }
        }.execute(new Void[0]);
    }

    private void tw() {
        AgreeMeRequestMessage agreeMeRequestMessage = new AgreeMeRequestMessage();
        agreeMeRequestMessage.id = this.eIH;
        agreeMeRequestMessage.setTag(this.uniqueId);
        MessageManager.getInstance().sendMessage(agreeMeRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList) {
        if (!this.eIG) {
            if (w.z(this.eIJ)) {
                this.eIJ = new ArrayList<>();
            } else {
                this.eIJ.clear();
            }
            this.eIJ.addAll(arrayList);
            h hVar = (h) w.d(this.eIJ, this.eIJ.size() - 1);
            if (hVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                this.eIH = ((com.baidu.tieba.imMessageCenter.mention.base.a) hVar).getMsgId();
            }
            if (this.eII != null && !w.z(this.eIJ)) {
                this.eII.O(this.eIJ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList, boolean z) {
        this.eIG = true;
        if (w.z(this.eIJ)) {
            this.eIJ = new ArrayList<>();
        }
        if (!z) {
            this.eIJ.addAll(arrayList);
        } else {
            this.eIJ.clear();
            this.eIJ.addAll(0, arrayList);
        }
        h hVar = (h) w.d(this.eIJ, this.eIJ.size() - 1);
        if (hVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
            this.eIH = ((com.baidu.tieba.imMessageCenter.mention.base.a) hVar).getMsgId();
        }
        if (this.eII != null) {
            this.eII.O(this.eIJ);
        }
    }
}
