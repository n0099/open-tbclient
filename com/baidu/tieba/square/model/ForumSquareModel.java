package com.baidu.tieba.square.model;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.square.d;
import com.baidu.tieba.square.data.b;
import com.baidu.tieba.square.data.c;
import com.baidu.tieba.square.message.ForumSquareHttpResponsedMessage;
import com.baidu.tieba.square.message.ForumSquareRequestMessage;
import com.baidu.tieba.square.message.ForumSquareSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.writeModel.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class ForumSquareModel extends BdBaseModel {
    private a eBn;
    private CustomMessageListener fli;
    private boolean isLoading;
    private CustomMessageListener mLikeForumListener;
    private d nhX;
    private final HashMap<String, c> nhY;
    private final List<String> nhZ;

    /* JADX INFO: Access modifiers changed from: private */
    public void s(long j, boolean z) {
        for (Map.Entry<String, c> entry : this.nhY.entrySet()) {
            c value = entry.getValue();
            if (value != null && !x.isEmpty(value.getDataList())) {
                for (n nVar : value.getDataList()) {
                    if (nVar instanceof b) {
                        b bVar = (b) nVar;
                        if (bVar.forumId == j) {
                            bVar.eNy = z;
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
            str = (String) x.getItem(this.nhZ, 0);
            dVar.className = str;
        }
        String str2 = str;
        c cVar = this.nhY.get(str2);
        if (cVar == null) {
            cVar = new c();
            this.nhY.put(str2, cVar);
        }
        cVar.a(dVar);
        if (this.nhX != null) {
            this.nhX.d(str2, this.nhZ, cVar.getDataList());
        }
    }

    public int w(List<n> list, int i) {
        int count = x.getCount(list);
        if (count <= i) {
            return 0;
        }
        int max = Math.max(count - 300, 30);
        int i2 = (count - max) / 2;
        int i3 = i2 + max;
        if (i2 <= 20 || i3 >= count - 20) {
            return 0;
        }
        x.removeSubList(list, i2, i3);
        return max;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.square.data.d dVar) {
        if (x.isEmpty(this.nhZ) && dVar != null && !x.isEmpty(dVar.nfZ)) {
            for (String str : dVar.nfZ) {
                if (!TextUtils.isEmpty(str) && !this.nhZ.contains(str)) {
                    this.nhZ.add(str);
                }
            }
        }
    }

    public ForumSquareModel(Context context, d dVar) {
        super(UtilHelper.getTbPageContext(context));
        this.isLoading = false;
        this.nhY = new HashMap<>();
        this.nhZ = new ArrayList();
        this.mLikeForumListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_LIKE_FORUM) { // from class: com.baidu.tieba.square.model.ForumSquareModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    if (eVar.isSuccess) {
                        ForumSquareModel.this.s(eVar.forumId, true);
                    }
                }
            }
        };
        this.fli = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_UNLIKE_FORUM) { // from class: com.baidu.tieba.square.model.ForumSquareModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    e eVar = (e) customResponsedMessage.getData();
                    if (eVar.isSuccess) {
                        ForumSquareModel.this.s(eVar.forumId, false);
                    }
                }
            }
        };
        this.eBn = new a(CmdConfigHttp.CMD_FORUM_SQUARE, 309653) { // from class: com.baidu.tieba.square.model.ForumSquareModel.3
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
                    if (x.isEmpty(ForumSquareModel.this.nhZ)) {
                        if (ForumSquareModel.this.nhX != null) {
                            ForumSquareModel.this.nhX.e(errorData);
                        }
                    } else if (ForumSquareModel.this.mErrorCode != 0 || data == null) {
                        if (ForumSquareModel.this.nhX != null) {
                            ForumSquareModel.this.nhX.a(str2, errorData);
                        }
                    } else {
                        ForumSquareModel.this.b(data);
                    }
                }
            }
        };
        this.nhX = dVar;
        this.eBn.getHttpMessageListener().setSelfListener(true);
        this.eBn.getSocketMessageListener().setSelfListener(true);
        registerListener(this.eBn);
        registerListener(this.mLikeForumListener);
        registerListener(this.fli);
    }

    public c RM(String str) {
        if (str == null) {
            return null;
        }
        return this.nhY.get(str);
    }

    public void RN(String str) {
        c cVar;
        ForumSquareRequestMessage forumSquareRequestMessage = new ForumSquareRequestMessage();
        forumSquareRequestMessage.className = str;
        if (TextUtils.isEmpty(str)) {
            cVar = new c();
        } else {
            cVar = this.nhY.get(str);
            if (cVar == null) {
                cVar = new c();
                this.nhY.put(str, cVar);
            }
        }
        forumSquareRequestMessage.pn = cVar.pn + 1;
        this.isLoading = true;
        sendMessage(forumSquareRequestMessage);
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public boolean RO(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        c cVar = this.nhY.get(str);
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
