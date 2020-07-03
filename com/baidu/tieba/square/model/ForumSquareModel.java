package com.baidu.tieba.square.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.square.ForumSquareActivity;
import com.baidu.tieba.square.c;
import com.baidu.tieba.square.data.b;
import com.baidu.tieba.square.data.d;
import com.baidu.tieba.square.message.ForumSquareHttpResponsedMessage;
import com.baidu.tieba.square.message.ForumSquareRequestMessage;
import com.baidu.tieba.square.message.ForumSquareSocketResponsedMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class ForumSquareModel extends BdBaseModel {
    private a dzN;
    private CustomMessageListener egO;
    private boolean isLoading;
    private c lAZ;
    private final HashMap<String, com.baidu.tieba.square.data.c> lBa;
    private final List<String> lBb;
    private CustomMessageListener mLikeForumListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void n(long j, boolean z) {
        for (Map.Entry<String, com.baidu.tieba.square.data.c> entry : this.lBa.entrySet()) {
            com.baidu.tieba.square.data.c value = entry.getValue();
            if (value != null && !w.isEmpty(value.getDataList())) {
                for (q qVar : value.getDataList()) {
                    if (qVar instanceof b) {
                        b bVar = (b) qVar;
                        if (bVar.forumId == j) {
                            bVar.dKM = z;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        String str = dVar.className;
        if (TextUtils.isEmpty(str)) {
            str = (String) w.getItem(this.lBb, 0);
            dVar.className = str;
        }
        String str2 = str;
        com.baidu.tieba.square.data.c cVar = this.lBa.get(str2);
        if (cVar == null) {
            cVar = new com.baidu.tieba.square.data.c();
            this.lBa.put(str2, cVar);
        }
        cVar.a(dVar);
        if (this.lAZ != null) {
            this.lAZ.c(str2, this.lBb, cVar.getDataList());
        }
    }

    public int s(List<q> list, int i) {
        int count = w.getCount(list);
        if (count <= i) {
            return 0;
        }
        int max = Math.max(count - 300, 30);
        int i2 = (count - max) / 2;
        int i3 = i2 + max;
        if (i2 <= 20 || i3 >= count - 20) {
            return 0;
        }
        w.removeSubList(list, i2, i3);
        return max;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d dVar) {
        if (w.isEmpty(this.lBb) && dVar != null && !w.isEmpty(dVar.lza)) {
            for (String str : dVar.lza) {
                if (!TextUtils.isEmpty(str) && !this.lBb.contains(str)) {
                    this.lBb.add(str);
                }
            }
        }
    }

    public ForumSquareModel(ForumSquareActivity forumSquareActivity, c cVar) {
        super(forumSquareActivity.getPageContext());
        this.isLoading = false;
        this.lBa = new HashMap<>();
        this.lBb = new ArrayList();
        this.mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.square.model.ForumSquareModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                    com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                    if (aVar.isSuccess) {
                        ForumSquareModel.this.n(aVar.forumId, true);
                    }
                }
            }
        };
        this.egO = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.square.model.ForumSquareModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                    com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                    if (aVar.isSuccess) {
                        ForumSquareModel.this.n(aVar.forumId, false);
                    }
                }
            }
        };
        this.dzN = new a(CmdConfigHttp.CMD_FORUM_SQUARE, 309653) { // from class: com.baidu.tieba.square.model.ForumSquareModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str;
                d data;
                ForumSquareModel.this.isLoading = false;
                if (responsedMessage != null) {
                    ForumSquareModel.this.mErrorCode = responsedMessage.getError();
                    ForumSquareModel.this.mErrorString = responsedMessage.getErrorString();
                    if (!StringUtils.isNull(ForumSquareModel.this.mErrorString)) {
                        str = ForumSquareModel.this.mErrorString;
                    } else {
                        str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
                    }
                    ErrorData errorData = new ErrorData();
                    errorData.setError_code(ForumSquareModel.this.mErrorCode);
                    errorData.setError_msg(str);
                    if (responsedMessage instanceof ForumSquareHttpResponsedMessage) {
                        data = ((ForumSquareHttpResponsedMessage) responsedMessage).getData();
                    } else {
                        data = responsedMessage instanceof ForumSquareSocketResponsedMessage ? ((ForumSquareSocketResponsedMessage) responsedMessage).getData() : null;
                    }
                    Object extra = responsedMessage.getOrginalMessage().getExtra();
                    String str2 = extra instanceof ForumSquareRequestMessage ? ((ForumSquareRequestMessage) extra).className : null;
                    ForumSquareModel.this.c(data);
                    if (w.isEmpty(ForumSquareModel.this.lBb)) {
                        if (ForumSquareModel.this.lAZ != null) {
                            ForumSquareModel.this.lAZ.e(errorData);
                        }
                    } else if (ForumSquareModel.this.mErrorCode != 0 || data == null) {
                        if (ForumSquareModel.this.lAZ != null) {
                            ForumSquareModel.this.lAZ.a(str2, errorData);
                        }
                    } else {
                        ForumSquareModel.this.b(data);
                    }
                }
            }
        };
        this.lAZ = cVar;
        this.dzN.getHttpMessageListener().setSelfListener(true);
        this.dzN.getSocketMessageListener().setSelfListener(true);
        registerListener(this.dzN);
        registerListener(this.mLikeForumListener);
        registerListener(this.egO);
    }

    public com.baidu.tieba.square.data.c MK(String str) {
        if (str == null) {
            return null;
        }
        return this.lBa.get(str);
    }

    public void ML(String str) {
        com.baidu.tieba.square.data.c cVar;
        ForumSquareRequestMessage forumSquareRequestMessage = new ForumSquareRequestMessage();
        forumSquareRequestMessage.className = str;
        if (TextUtils.isEmpty(str)) {
            cVar = new com.baidu.tieba.square.data.c();
        } else {
            cVar = this.lBa.get(str);
            if (cVar == null) {
                cVar = new com.baidu.tieba.square.data.c();
                this.lBa.put(str, cVar);
            }
        }
        forumSquareRequestMessage.pn = cVar.pn + 1;
        this.isLoading = true;
        sendMessage(forumSquareRequestMessage);
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public boolean MM(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.tieba.square.data.c cVar = this.lBa.get(str);
        return cVar != null ? cVar.hasMore : false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        super.cancelMessage();
        this.isLoading = false;
    }
}
