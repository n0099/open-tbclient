package com.baidu.tieba.pb.pb.main.adapter;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.pageExtra.d;
import com.baidu.tieba.pb.data.PbFloorAgreeResponseMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.data.AgreeData;
/* loaded from: classes2.dex */
public class c {
    private final com.baidu.tieba.pb.videopb.b mbX;
    private final HttpMessageListener mbY = new HttpMessageListener(1001601, true) { // from class: com.baidu.tieba.pb.pb.main.adapter.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            c.this.a(httpResponsedMessage, 1001601);
        }
    };
    private final HttpMessageListener mbZ = new HttpMessageListener(1001604) { // from class: com.baidu.tieba.pb.pb.main.adapter.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            c.this.a(httpResponsedMessage, 1001604);
        }
    };

    public c(com.baidu.tieba.pb.videopb.b bVar) {
        if (bVar == null) {
            throw new NullPointerException("PbActivity is NullPointerException");
        }
        this.mbX = bVar;
        drV();
    }

    public void onDestroy() {
        drU();
    }

    private boolean drU() {
        MessageManager.getInstance().unRegisterListener(this.mbY);
        MessageManager.getInstance().unRegisterListener(this.mbZ);
        return true;
    }

    public boolean drV() {
        if (this.mbX != null) {
            this.mbX.registerListener(this.mbY);
            this.mbX.registerListener(this.mbZ);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpResponsedMessage httpResponsedMessage, int i) {
        PbFloorAgreeResponseMessage pbFloorAgreeResponseMessage;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == i && (httpResponsedMessage instanceof PbFloorAgreeResponseMessage) && (pbFloorAgreeResponseMessage = (PbFloorAgreeResponseMessage) httpResponsedMessage) != null && !pbFloorAgreeResponseMessage.hasError() && this.mbX != null && pbFloorAgreeResponseMessage.getActivityDialogData() != null) {
            CustomDialogData activityDialogData = pbFloorAgreeResponseMessage.getActivityDialogData();
            activityDialogData.type = 0;
            com.baidu.tieba.pb.interactionpopupwindow.c.a(this.mbX.getPageContext(), activityDialogData).show();
        }
    }

    public void e(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    agreeData.agreeType = 2;
                    agreeData.hasAgree = false;
                    agreeData.agreeNum--;
                } else {
                    agreeData.agreeType = 2;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum++;
                    com.baidu.tieba.o.a.dCY().J(this.mbX.getPageContext());
                    i = 0;
                }
            } else {
                agreeData.agreeType = 2;
                agreeData.hasAgree = true;
                agreeData.agreeNum++;
                com.baidu.tieba.o.a.dCY().J(this.mbX.getPageContext());
                i = 0;
            }
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("z_id", TbadkCoreApplication.getInst().getZid());
            httpMessage.addParam("thread_id", agreeData.threadId);
            httpMessage.addParam("op_type", i);
            if (agreeData.objType == 0) {
                agreeData.objType = 3;
            }
            httpMessage.addParam("obj_type", agreeData.objType);
            httpMessage.addParam("agree_type", agreeData.agreeType);
            httpMessage.addParam("forum_id", agreeData.forumId);
            com.baidu.tbadk.pageExtra.c fq = d.fq(this.mbX.doh());
            if (fq != null) {
                httpMessage.addParam("obj_source", fq.getCurrentPageKey());
            }
            if (!TextUtils.isEmpty(agreeData.postId)) {
                httpMessage.addParam("post_id", agreeData.postId);
            }
            if (agreeData.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", agreeData.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", agreeData.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", agreeData.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", agreeData.baijiahaoData.oriUgcType);
            }
            httpMessage.setTag(getPageId());
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public BdUniqueId getPageId() {
        TbPageContext pageContext = this.mbX.getPageContext();
        if (pageContext != null) {
            return pageContext.getUniqueId();
        }
        return null;
    }
}
