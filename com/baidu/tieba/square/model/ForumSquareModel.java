package com.baidu.tieba.square.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
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
    private CustomMessageListener dKw;
    private a dho;
    private boolean isLoading;
    private c kNC;
    private final HashMap<String, com.baidu.tieba.square.data.c> kND;
    private final List<String> kNE;
    private CustomMessageListener mLikeForumListener;

    /* JADX INFO: Access modifiers changed from: private */
    public void m(long j, boolean z) {
        for (Map.Entry<String, com.baidu.tieba.square.data.c> entry : this.kND.entrySet()) {
            com.baidu.tieba.square.data.c value = entry.getValue();
            if (value != null && !v.isEmpty(value.getDataList())) {
                for (m mVar : value.getDataList()) {
                    if (mVar instanceof b) {
                        b bVar = (b) mVar;
                        if (bVar.forumId == j) {
                            bVar.dql = z;
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
            str = (String) v.getItem(this.kNE, 0);
            dVar.className = str;
        }
        String str2 = str;
        com.baidu.tieba.square.data.c cVar = this.kND.get(str2);
        if (cVar == null) {
            cVar = new com.baidu.tieba.square.data.c();
            this.kND.put(str2, cVar);
        }
        cVar.a(dVar);
        if (this.kNC != null) {
            this.kNC.c(str2, this.kNE, cVar.getDataList());
        }
    }

    public int p(List<m> list, int i) {
        int count = v.getCount(list);
        if (count <= i) {
            return 0;
        }
        int max = Math.max(count - 300, 30);
        int i2 = (count - max) / 2;
        int i3 = i2 + max;
        if (i2 <= 20 || i3 >= count - 20) {
            return 0;
        }
        v.removeSubList(list, i2, i3);
        return max;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d dVar) {
        if (v.isEmpty(this.kNE) && dVar != null && !v.isEmpty(dVar.kLD)) {
            for (String str : dVar.kLD) {
                if (!TextUtils.isEmpty(str) && !this.kNE.contains(str)) {
                    this.kNE.add(str);
                }
            }
        }
    }

    public ForumSquareModel(ForumSquareActivity forumSquareActivity, c cVar) {
        super(forumSquareActivity.getPageContext());
        this.isLoading = false;
        this.kND = new HashMap<>();
        this.kNE = new ArrayList();
        this.mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.square.model.ForumSquareModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                    com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                    if (aVar.isSuccess) {
                        ForumSquareModel.this.m(aVar.forumId, true);
                    }
                }
            }
        };
        this.dKw = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.square.model.ForumSquareModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                    com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                    if (aVar.isSuccess) {
                        ForumSquareModel.this.m(aVar.forumId, false);
                    }
                }
            }
        };
        this.dho = new a(CmdConfigHttp.CMD_FORUM_SQUARE, 309653) { // from class: com.baidu.tieba.square.model.ForumSquareModel.3
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
                    if (v.isEmpty(ForumSquareModel.this.kNE)) {
                        if (ForumSquareModel.this.kNC != null) {
                            ForumSquareModel.this.kNC.b(errorData);
                        }
                    } else if (ForumSquareModel.this.mErrorCode != 0 || data == null) {
                        if (ForumSquareModel.this.kNC != null) {
                            ForumSquareModel.this.kNC.a(str2, errorData);
                        }
                    } else {
                        ForumSquareModel.this.b(data);
                    }
                }
            }
        };
        this.kNC = cVar;
        this.dho.getHttpMessageListener().setSelfListener(true);
        this.dho.getSocketMessageListener().setSelfListener(true);
        registerListener(this.dho);
        registerListener(this.mLikeForumListener);
        registerListener(this.dKw);
    }

    public com.baidu.tieba.square.data.c Kv(String str) {
        if (str == null) {
            return null;
        }
        return this.kND.get(str);
    }

    public void Kw(String str) {
        com.baidu.tieba.square.data.c cVar;
        ForumSquareRequestMessage forumSquareRequestMessage = new ForumSquareRequestMessage();
        forumSquareRequestMessage.className = str;
        if (TextUtils.isEmpty(str)) {
            cVar = new com.baidu.tieba.square.data.c();
        } else {
            cVar = this.kND.get(str);
            if (cVar == null) {
                cVar = new com.baidu.tieba.square.data.c();
                this.kND.put(str, cVar);
            }
        }
        forumSquareRequestMessage.pn = cVar.pn + 1;
        this.isLoading = true;
        sendMessage(forumSquareRequestMessage);
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public boolean Kx(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.tieba.square.data.c cVar = this.kND.get(str);
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
