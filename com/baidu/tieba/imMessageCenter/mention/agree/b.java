package com.baidu.tieba.imMessageCenter.mention.agree;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.imMessageCenter.mention.agree.message.AgreeMeHTTPResponseMessage;
import com.baidu.tieba.imMessageCenter.mention.agree.message.AgreeMeRequestMessage;
import com.baidu.tieba.imMessageCenter.mention.agree.message.AgreeMeSocketResponseMessage;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.AgreeList;
import tbclient.AgreeMe.AgreeMeResIdl;
/* loaded from: classes4.dex */
public class b {
    private a gzd;
    private ArrayList<m> gze;
    public boolean hasMore;
    private BdUniqueId uniqueId;
    private boolean gzb = false;
    private long gzc = 0;
    private com.baidu.adp.framework.listener.a gzf = new com.baidu.adp.framework.listener.a(CmdConfigHttp.AGREE_ME_HTTP_CMD, 309593) { // from class: com.baidu.tieba.imMessageCenter.mention.agree.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z = false;
            if (responsedMessage != null) {
                if (responsedMessage.hasError()) {
                    if (b.this.gzd != null) {
                        b.this.gzd.uE(responsedMessage.getErrorString());
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

    /* loaded from: classes4.dex */
    public interface a {
        void R(ArrayList<m> arrayList);

        void uE(String str);
    }

    static {
        com.baidu.tieba.tbadkCore.a.a.a(309593, AgreeMeSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309593, CmdConfigHttp.AGREE_ME_HTTP_CMD, "c/u/feed/agreeme", AgreeMeHTTPResponseMessage.class, false, false, false, false);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        if (tbPageContext != null) {
            this.uniqueId = tbPageContext.getUniqueId();
            tbPageContext.registerListener(this.gzf);
            this.gzd = aVar;
        }
    }

    public void blo() {
        WL();
        WK();
    }

    public void bfc() {
        this.gzc = 0L;
        WK();
    }

    public void aAZ() {
        WK();
    }

    private void WL() {
        new BdAsyncTask<Void, Void, ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a>>() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: d */
            public ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> doInBackground(Void... voidArr) {
                byte[] bArr;
                ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList = new ArrayList<>();
                l<byte[]> bu = com.baidu.tbadk.core.c.a.aaT().bu("tb_user_agreeme", TbadkCoreApplication.getCurrentAccountName());
                if (bu != null && (bArr = bu.get("agree_me_cache_key")) != null) {
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
                    b.this.i(arrayList);
                }
            }
        }.execute(new Void[0]);
    }

    private void WK() {
        AgreeMeRequestMessage agreeMeRequestMessage = new AgreeMeRequestMessage();
        agreeMeRequestMessage.id = this.gzc;
        agreeMeRequestMessage.setTag(this.uniqueId);
        MessageManager.getInstance().sendMessage(agreeMeRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList) {
        if (!this.gzb) {
            if (v.T(this.gze)) {
                this.gze = new ArrayList<>();
            } else {
                this.gze.clear();
            }
            this.gze.addAll(arrayList);
            m mVar = (m) v.c(this.gze, this.gze.size() - 1);
            if (mVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                this.gzc = ((com.baidu.tieba.imMessageCenter.mention.base.a) mVar).getMsgId();
            }
            if (this.gzd != null && !v.T(this.gze)) {
                this.gzd.R(this.gze);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ArrayList<com.baidu.tieba.imMessageCenter.mention.base.a> arrayList, boolean z) {
        this.gzb = true;
        if (v.T(this.gze)) {
            this.gze = new ArrayList<>();
        }
        if (!z) {
            this.gze.addAll(arrayList);
        } else {
            this.gze.clear();
            this.gze.addAll(0, arrayList);
        }
        m mVar = (m) v.c(this.gze, this.gze.size() - 1);
        if (mVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
            this.gzc = ((com.baidu.tieba.imMessageCenter.mention.base.a) mVar).getMsgId();
        }
        if (this.gzd != null) {
            this.gzd.R(this.gze);
        }
    }
}
