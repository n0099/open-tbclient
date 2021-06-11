package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.a.m0.z0.f;
import d.a.n0.e3.q0.e;
import d.a.n0.e3.w;
/* loaded from: classes5.dex */
public class LikeModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public String f20836e;

    /* renamed from: f  reason: collision with root package name */
    public String f20837f;

    /* renamed from: g  reason: collision with root package name */
    public String f20838g;

    /* renamed from: h  reason: collision with root package name */
    public String f20839h;

    /* renamed from: i  reason: collision with root package name */
    public String f20840i;
    public String j;
    public TbPageContext k;
    public b l;
    public BlockPopInfoData m;

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, Integer, w> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f20841a;

        public b() {
            this.f20841a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public w doInBackground(Object... objArr) {
            try {
                this.f20841a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.LIKE_ADDRESS);
                this.f20841a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, LikeModel.this.f20836e);
                this.f20841a.addPostData("fid", LikeModel.this.f20837f);
                this.f20841a.addPostData("st_type", LikeModel.this.f20839h);
                this.f20841a.addPostData("authsid", LikeModel.this.f20840i);
                if (!StringUtils.isNull(LikeModel.this.j)) {
                    this.f20841a.addPostData("dev_id", LikeModel.this.j);
                }
                if (!TextUtils.isEmpty(LikeModel.this.f20838g)) {
                    this.f20841a.addPostData("pagefrom", LikeModel.this.f20838g);
                }
                this.f20841a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.f20841a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                this.f20841a.addPostData("forum_name", LikeModel.this.f20836e);
                this.f20841a.getNetContext().getRequest().mIsNeedTbs = true;
                this.f20841a.setNeedSig(true);
                String postNetData = this.f20841a.postNetData();
                int serverErrorCode = this.f20841a.getServerErrorCode();
                String errorString = this.f20841a.getErrorString();
                LikeModel.this.setErrorCode(serverErrorCode);
                LikeModel.this.setErrorString(errorString);
                AuthTokenData.parse(postNetData);
                if (postNetData != null) {
                    w wVar = new w();
                    wVar.o(postNetData);
                    if (this.f20841a.getNetContext().getResponse().isRequestSuccess()) {
                        wVar.q(null);
                    }
                    LikeModel.this.m = wVar.a();
                    wVar.s(LikeModel.this.f20837f);
                    return wVar;
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            w wVar2 = new w();
            wVar2.v(0);
            wVar2.s(LikeModel.this.f20837f);
            return wVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(w wVar) {
            LikeModel.this.l = null;
            if (this.f20841a == null || wVar == null || AntiHelper.a(LikeModel.this.getContext(), LikeModel.this.getErrorCode(), wVar.b())) {
                return;
            }
            e eVar = new e();
            eVar.f57912a = d.a.c.e.m.b.f(wVar.g(), 0L);
            wVar.j();
            if (wVar != null && this.f20841a.getNetContext().getResponse().isRequestSuccess()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001335, Long.valueOf(d.a.c.e.m.b.f(wVar.g(), 0L))));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001610, new f.a(LikeModel.this.f20836e, wVar.k())));
                TbadkCoreApplication.getInst().addLikeForum(LikeModel.this.f20836e);
                eVar.f57913b = true;
                eVar.f57914c = LikeModel.this.getErrorString();
            } else {
                eVar.f57913b = false;
                eVar.f57914c = LikeModel.this.getErrorString();
            }
            if (LikeModel.this.mLoadDataCallBack != null) {
                LikeModel.this.mLoadDataCallBack.c(wVar);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001437, eVar));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f20841a != null) {
                this.f20841a.cancelNetConnect();
                this.f20841a = null;
            }
            LikeModel.this.l = null;
            super.cancel(true);
            if (LikeModel.this.mLoadDataCallBack != null) {
                LikeModel.this.mLoadDataCallBack.c(null);
            }
        }
    }

    public LikeModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f20836e = null;
        this.f20837f = null;
        this.f20838g = null;
        this.l = null;
        this.k = tbPageContext;
    }

    public void I() {
        b bVar = this.l;
        if (bVar != null) {
            bVar.cancel();
            this.l = null;
        }
    }

    public BlockPopInfoData J() {
        return this.m;
    }

    public boolean K() {
        return this.l != null;
    }

    public void L(String str, String str2) {
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0 || this.l != null) {
            return;
        }
        this.f20836e = str;
        this.f20837f = str2;
        b bVar = new b();
        this.l = bVar;
        bVar.setPriority(2);
        this.l.execute(new Object[0]);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public void M(String str, String str2, String str3) {
        L(str, str2);
        this.f20838g = str3;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public Context getContext() {
        TbPageContext tbPageContext = this.k;
        if (tbPageContext != null) {
            return tbPageContext.getPageActivity();
        }
        return null;
    }

    public void setFrom(String str) {
        this.f20839h = str;
    }
}
