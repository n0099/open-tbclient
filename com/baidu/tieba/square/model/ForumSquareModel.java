package com.baidu.tieba.square.model;

import android.content.Context;
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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.square.d;
import com.baidu.tieba.square.data.b;
import com.baidu.tieba.square.data.c;
import com.baidu.tieba.square.message.ForumSquareHttpResponsedMessage;
import com.baidu.tieba.square.message.ForumSquareRequestMessage;
import com.baidu.tieba.square.message.ForumSquareSocketResponsedMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes22.dex */
public class ForumSquareModel extends BdBaseModel {
    private a ewJ;
    private CustomMessageListener fgj;
    private boolean isLoading;
    private CustomMessageListener mLikeForumListener;
    private d ngX;
    private final HashMap<String, c> ngY;
    private final List<String> ngZ;

    /* JADX INFO: Access modifiers changed from: private */
    public void q(long j, boolean z) {
        for (Map.Entry<String, c> entry : this.ngY.entrySet()) {
            c value = entry.getValue();
            if (value != null && !y.isEmpty(value.getDataList())) {
                for (q qVar : value.getDataList()) {
                    if (qVar instanceof b) {
                        b bVar = (b) qVar;
                        if (bVar.forumId == j) {
                            bVar.eIr = z;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.square.data.d dVar) {
        String str = dVar.className;
        if (TextUtils.isEmpty(str)) {
            str = (String) y.getItem(this.ngZ, 0);
            dVar.className = str;
        }
        String str2 = str;
        c cVar = this.ngY.get(str2);
        if (cVar == null) {
            cVar = new c();
            this.ngY.put(str2, cVar);
        }
        cVar.a(dVar);
        if (this.ngX != null) {
            this.ngX.d(str2, this.ngZ, cVar.getDataList());
        }
    }

    public int w(List<q> list, int i) {
        int count = y.getCount(list);
        if (count <= i) {
            return 0;
        }
        int max = Math.max(count - 300, 30);
        int i2 = (count - max) / 2;
        int i3 = i2 + max;
        if (i2 <= 20 || i3 >= count - 20) {
            return 0;
        }
        y.removeSubList(list, i2, i3);
        return max;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.square.data.d dVar) {
        if (y.isEmpty(this.ngZ) && dVar != null && !y.isEmpty(dVar.neZ)) {
            for (String str : dVar.neZ) {
                if (!TextUtils.isEmpty(str) && !this.ngZ.contains(str)) {
                    this.ngZ.add(str);
                }
            }
        }
    }

    public ForumSquareModel(Context context, d dVar) {
        super(UtilHelper.getTbPageContext(context));
        this.isLoading = false;
        this.ngY = new HashMap<>();
        this.ngZ = new ArrayList();
        this.mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.square.model.ForumSquareModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                    com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                    if (aVar.isSuccess) {
                        ForumSquareModel.this.q(aVar.forumId, true);
                    }
                }
            }
        };
        this.fgj = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.square.model.ForumSquareModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.writeModel.a)) {
                    com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) customResponsedMessage.getData();
                    if (aVar.isSuccess) {
                        ForumSquareModel.this.q(aVar.forumId, false);
                    }
                }
            }
        };
        this.ewJ = new a(CmdConfigHttp.CMD_FORUM_SQUARE, 309653) { // from class: com.baidu.tieba.square.model.ForumSquareModel.3
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                String str;
                com.baidu.tieba.square.data.d data;
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
                    if (y.isEmpty(ForumSquareModel.this.ngZ)) {
                        if (ForumSquareModel.this.ngX != null) {
                            ForumSquareModel.this.ngX.e(errorData);
                        }
                    } else if (ForumSquareModel.this.mErrorCode != 0 || data == null) {
                        if (ForumSquareModel.this.ngX != null) {
                            ForumSquareModel.this.ngX.a(str2, errorData);
                        }
                    } else {
                        ForumSquareModel.this.b(data);
                    }
                }
            }
        };
        this.ngX = dVar;
        this.ewJ.getHttpMessageListener().setSelfListener(true);
        this.ewJ.getSocketMessageListener().setSelfListener(true);
        registerListener(this.ewJ);
        registerListener(this.mLikeForumListener);
        registerListener(this.fgj);
    }

    public c Tm(String str) {
        if (str == null) {
            return null;
        }
        return this.ngY.get(str);
    }

    public void Tn(String str) {
        c cVar;
        ForumSquareRequestMessage forumSquareRequestMessage = new ForumSquareRequestMessage();
        forumSquareRequestMessage.className = str;
        if (TextUtils.isEmpty(str)) {
            cVar = new c();
        } else {
            cVar = this.ngY.get(str);
            if (cVar == null) {
                cVar = new c();
                this.ngY.put(str, cVar);
            }
        }
        forumSquareRequestMessage.pn = cVar.pn + 1;
        this.isLoading = true;
        sendMessage(forumSquareRequestMessage);
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public boolean To(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        c cVar = this.ngY.get(str);
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
