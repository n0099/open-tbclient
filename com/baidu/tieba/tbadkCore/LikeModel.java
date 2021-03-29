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
import d.b.h0.z0.f;
import d.b.i0.c3.q0.e;
import d.b.i0.c3.w;
/* loaded from: classes5.dex */
public class LikeModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public String f21320e;

    /* renamed from: f  reason: collision with root package name */
    public String f21321f;

    /* renamed from: g  reason: collision with root package name */
    public String f21322g;

    /* renamed from: h  reason: collision with root package name */
    public String f21323h;
    public String i;
    public String j;
    public TbPageContext k;
    public b l;
    public BlockPopInfoData m;

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, Integer, w> {

        /* renamed from: a  reason: collision with root package name */
        public volatile NetWork f21324a;

        public b() {
            this.f21324a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public w doInBackground(Object... objArr) {
            try {
                this.f21324a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.LIKE_ADDRESS);
                this.f21324a.addPostData(TiebaStatic.Params.H5_FORUM_NAME, LikeModel.this.f21320e);
                this.f21324a.addPostData("fid", LikeModel.this.f21321f);
                this.f21324a.addPostData("st_type", LikeModel.this.f21323h);
                this.f21324a.addPostData("authsid", LikeModel.this.i);
                if (!StringUtils.isNull(LikeModel.this.j)) {
                    this.f21324a.addPostData("dev_id", LikeModel.this.j);
                }
                if (!TextUtils.isEmpty(LikeModel.this.f21322g)) {
                    this.f21324a.addPostData("pagefrom", LikeModel.this.f21322g);
                }
                this.f21324a.addPostData("user_name", TbadkCoreApplication.getCurrentAccountName());
                this.f21324a.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                this.f21324a.addPostData("forum_name", LikeModel.this.f21320e);
                this.f21324a.getNetContext().getRequest().mIsNeedTbs = true;
                this.f21324a.setNeedSig(true);
                String postNetData = this.f21324a.postNetData();
                int serverErrorCode = this.f21324a.getServerErrorCode();
                String errorString = this.f21324a.getErrorString();
                LikeModel.this.setErrorCode(serverErrorCode);
                LikeModel.this.setErrorString(errorString);
                AuthTokenData.parse(postNetData);
                if (postNetData != null) {
                    w wVar = new w();
                    wVar.o(postNetData);
                    if (this.f21324a.getNetContext().getResponse().isRequestSuccess()) {
                        wVar.q(null);
                    }
                    LikeModel.this.m = wVar.a();
                    wVar.s(LikeModel.this.f21321f);
                    return wVar;
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            w wVar2 = new w();
            wVar2.v(0);
            wVar2.s(LikeModel.this.f21321f);
            return wVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(w wVar) {
            LikeModel.this.l = null;
            if (this.f21324a == null || wVar == null || AntiHelper.a(LikeModel.this.getContext(), LikeModel.this.getErrorCode(), wVar.b())) {
                return;
            }
            e eVar = new e();
            eVar.f53594a = d.b.b.e.m.b.f(wVar.g(), 0L);
            wVar.j();
            if (wVar != null && this.f21324a.getNetContext().getResponse().isRequestSuccess()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001335, Long.valueOf(d.b.b.e.m.b.f(wVar.g(), 0L))));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001610, new f.a(LikeModel.this.f21320e, wVar.k())));
                TbadkCoreApplication.getInst().addLikeForum(LikeModel.this.f21320e);
                eVar.f53595b = true;
                eVar.f53596c = LikeModel.this.getErrorString();
            } else {
                eVar.f53595b = false;
                eVar.f53596c = LikeModel.this.getErrorString();
            }
            if (LikeModel.this.mLoadDataCallBack != null) {
                LikeModel.this.mLoadDataCallBack.c(wVar);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001437, eVar));
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.f21324a != null) {
                this.f21324a.cancelNetConnect();
                this.f21324a = null;
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
        this.f21320e = null;
        this.f21321f = null;
        this.f21322g = null;
        this.l = null;
        this.k = tbPageContext;
    }

    public void E() {
        b bVar = this.l;
        if (bVar != null) {
            bVar.cancel();
            this.l = null;
        }
    }

    public BlockPopInfoData F() {
        return this.m;
    }

    public boolean G() {
        return this.l != null;
    }

    public void H(String str, String str2) {
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0 || this.l != null) {
            return;
        }
        this.f21320e = str;
        this.f21321f = str2;
        b bVar = new b();
        this.l = bVar;
        bVar.setPriority(2);
        this.l.execute(new Object[0]);
    }

    public void I(String str, String str2, String str3) {
        H(str, str2);
        this.f21322g = str3;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
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
        this.f21323h = str;
    }
}
