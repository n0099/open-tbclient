package com.baidu.tieba.newinterest.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.data.InterestCommitHttpResMsg;
import com.baidu.tieba.newinterest.data.InterestedForumHttpResMsg;
import com.baidu.tieba.newinterest.data.InterestedForumReqMsg;
import com.baidu.tieba.newinterest.data.InterestedForumSocketResMsg;
import com.baidu.tieba.newinterest.data.c;
import com.baidu.tieba.newinterest.data.d;
import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    private InterfaceC0820b lFw;
    private a lFx;
    private List<com.baidu.tieba.newinterest.data.b> lFy;
    private final BdUniqueId mBdUniqueId;
    private int mPageNum;
    private Gson gson = new Gson();
    private com.baidu.adp.framework.listener.a lFz = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GUIDE_INTERESTED_FORUM, 309654) { // from class: com.baidu.tieba.newinterest.b.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == b.this.mBdUniqueId) {
                    c cVar = null;
                    if (responsedMessage instanceof InterestedForumHttpResMsg) {
                        cVar = ((InterestedForumHttpResMsg) responsedMessage).getPageData();
                    } else if (responsedMessage instanceof InterestedForumSocketResMsg) {
                        cVar = ((InterestedForumSocketResMsg) responsedMessage).getPageData();
                    }
                    if (responsedMessage.getError() != 0) {
                        if (b.this.lFw != null) {
                            b.this.lFw.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                        }
                    } else if (cVar == null || y.isEmpty(cVar.lFg)) {
                        if (b.this.lFw != null) {
                            b.this.lFw.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    } else if (cVar != null && b.this.lFw != null) {
                        b.c(b.this);
                        b.this.lFw.a(cVar);
                    }
                }
            }
        }
    };
    private HttpMessageListener lFA = new HttpMessageListener(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT) { // from class: com.baidu.tieba.newinterest.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null) {
                if ((httpResponsedMessage.getOrginalMessage() == null || httpResponsedMessage.getOrginalMessage().getTag() == b.this.mBdUniqueId) && (httpResponsedMessage instanceof InterestCommitHttpResMsg)) {
                    InterestCommitHttpResMsg interestCommitHttpResMsg = (InterestCommitHttpResMsg) httpResponsedMessage;
                    if (interestCommitHttpResMsg.hasError() || interestCommitHttpResMsg.getErrno() != 0) {
                        if (b.this.lFw != null) {
                            b.this.lFw.onError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    } else if (b.this.lFx != null) {
                        b.this.lFx.bTl();
                    }
                }
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void bTl();
    }

    /* renamed from: com.baidu.tieba.newinterest.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0820b {
        void a(c cVar);

        void onError(int i, String str);
    }

    static /* synthetic */ int c(b bVar) {
        int i = bVar.mPageNum;
        bVar.mPageNum = i + 1;
        return i;
    }

    public b(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        this.lFz.setTag(this.mBdUniqueId);
        this.lFA.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.lFz);
        MessageManager.getInstance().registerListener(this.lFA);
        djD();
        djC();
        djB();
    }

    private List<Integer> fg(List<com.baidu.tieba.newinterest.data.b> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (com.baidu.tieba.newinterest.data.b bVar : list) {
                arrayList.add(Integer.valueOf(bVar.getId()));
            }
        }
        return arrayList;
    }

    private void djB() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT, TbConfig.SERVER_ADDRESS + TbConfig.GUIDE_INTEREST_COMMIT_URL);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(InterestCommitHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void djC() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GUIDE_INTERESTED_FORUM, com.baidu.tieba.tbadkCore.a.a.bV(TbConfig.GUIDE_INTERESTED_FORUM_URL, 309654));
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(InterestedForumHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void djD() {
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(309654);
        bVar.setResponsedClass(InterestedForumSocketResMsg.class);
        bVar.setNeedAck(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    public void fh(List<com.baidu.tieba.newinterest.data.a> list) throws UnsupportedEncodingException {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
        httpMessage.addParam("interestList", URLEncoder.encode(fi(list), "utf-8"));
        httpMessage.setTag(this.mBdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private String fi(List<com.baidu.tieba.newinterest.data.a> list) {
        HashMap hashMap = new HashMap();
        for (com.baidu.tieba.newinterest.data.a aVar : list) {
            HashMap hashMap2 = new HashMap();
            for (d dVar : aVar.forum_info) {
                if (dVar.selected) {
                    hashMap2.put(dVar.lFh.forum_id, dVar.lFh.forum_name);
                }
            }
            hashMap.put(aVar.class_name, hashMap2);
        }
        return this.gson.toJson(hashMap);
    }

    public void a(InterfaceC0820b interfaceC0820b) {
        this.lFw = interfaceC0820b;
    }

    public void a(a aVar) {
        this.lFx = aVar;
    }

    public void fj(List<com.baidu.tieba.newinterest.data.b> list) {
        this.lFy = list;
        this.mPageNum = 1;
    }

    public void djE() {
        InterestedForumReqMsg interestedForumReqMsg = new InterestedForumReqMsg();
        if (this.lFy == null) {
            interestedForumReqMsg.classidList = fg(null);
        } else {
            interestedForumReqMsg.classidList = fg(this.lFy.subList((this.mPageNum - 1) * 3, Math.min(this.lFy.size(), this.mPageNum * 3)));
        }
        interestedForumReqMsg.setTag(this.mBdUniqueId);
        MessageManager.getInstance().sendMessage(interestedForumReqMsg);
    }

    public boolean hasMore() {
        return (this.mPageNum + (-1)) * 3 < this.lFy.size();
    }
}
