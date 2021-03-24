package com.baidu.tieba.tblauncherInterestGuide.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class NewUserGuideModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LIMIT = 100;
    public static final int OFFSET = 0;

    /* renamed from: h  reason: collision with root package name */
    public static final String f21554h = TbConfig.SERVER_ADDRESS + "c/s/gettaglist";

    /* renamed from: e  reason: collision with root package name */
    public boolean f21555e;

    /* renamed from: f  reason: collision with root package name */
    public InterestFrsData f21556f;

    /* renamed from: g  reason: collision with root package name */
    public a f21557g;

    /* loaded from: classes5.dex */
    public static class a extends BdAsyncTask<Void, Void, InterestFrsData> {

        /* renamed from: a  reason: collision with root package name */
        public int f21558a;

        /* renamed from: b  reason: collision with root package name */
        public int f21559b;

        /* renamed from: c  reason: collision with root package name */
        public int f21560c;

        /* renamed from: d  reason: collision with root package name */
        public WeakReference<b> f21561d;

        public a(int i, int i2, int i3, b bVar) {
            this.f21558a = i;
            this.f21559b = i2;
            this.f21560c = i3;
            this.f21561d = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public InterestFrsData doInBackground(Void... voidArr) {
            NetWork netWork = new NetWork(NewUserGuideModel.f21554h);
            netWork.addPostData("user_type", String.valueOf(this.f21558a));
            netWork.addPostData("offset", String.valueOf(this.f21559b));
            netWork.addPostData(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(this.f21560c));
            String postNetData = netWork.postNetData();
            if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                try {
                    return (InterestFrsData) OrmObject.objectWithJsonStr(postNetData, InterestFrsData.class);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    InterestFrsData interestFrsData = new InterestFrsData();
                    interestFrsData.setErrno(-1000);
                    interestFrsData.setErrmsg(TbadkApplication.getInst().getContext().getString(R.string.neterror));
                    return interestFrsData;
                }
            }
            InterestFrsData interestFrsData2 = new InterestFrsData();
            interestFrsData2.setErrno(netWork.getServerErrorCode() == 0 ? -1001 : netWork.getServerErrorCode());
            interestFrsData2.setErrmsg(netWork.getErrorString());
            return interestFrsData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(InterestFrsData interestFrsData) {
            super.onPostExecute(interestFrsData);
            b bVar = this.f21561d.get();
            if (bVar != null) {
                if (interestFrsData.getErrno() == 0) {
                    bVar.b(interestFrsData);
                } else {
                    bVar.a(interestFrsData);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(InterestFrsData interestFrsData);

        void b(InterestFrsData interestFrsData);
    }

    public NewUserGuideModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void t() {
        a aVar = this.f21557g;
        if (aVar != null) {
            aVar.cancel();
        }
    }

    public InterestFrsData u() {
        return this.f21556f;
    }

    public boolean v() {
        return this.f21555e;
    }

    public void w(int i, int i2, int i3, b bVar) {
        a aVar = new a(i, i2, i3, bVar);
        this.f21557g = aVar;
        aVar.execute(new Void[0]);
    }

    public void x(InterestFrsData interestFrsData) {
        this.f21556f = interestFrsData;
    }

    public void y(boolean z) {
        this.f21555e = z;
    }
}
