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
    public static final String f21181h = TbConfig.SERVER_ADDRESS + "c/s/gettaglist";

    /* renamed from: e  reason: collision with root package name */
    public boolean f21182e;

    /* renamed from: f  reason: collision with root package name */
    public InterestFrsData f21183f;

    /* renamed from: g  reason: collision with root package name */
    public a f21184g;

    /* loaded from: classes5.dex */
    public static class a extends BdAsyncTask<Void, Void, InterestFrsData> {

        /* renamed from: a  reason: collision with root package name */
        public int f21185a;

        /* renamed from: b  reason: collision with root package name */
        public int f21186b;

        /* renamed from: c  reason: collision with root package name */
        public int f21187c;

        /* renamed from: d  reason: collision with root package name */
        public WeakReference<b> f21188d;

        public a(int i2, int i3, int i4, b bVar) {
            this.f21185a = i2;
            this.f21186b = i3;
            this.f21187c = i4;
            this.f21188d = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public InterestFrsData doInBackground(Void... voidArr) {
            NetWork netWork = new NetWork(NewUserGuideModel.f21181h);
            netWork.addPostData("user_type", String.valueOf(this.f21185a));
            netWork.addPostData("offset", String.valueOf(this.f21186b));
            netWork.addPostData(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(this.f21187c));
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
            b bVar = this.f21188d.get();
            if (bVar != null) {
                if (interestFrsData.getErrno() == 0) {
                    bVar.a(interestFrsData);
                } else {
                    bVar.b(interestFrsData);
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

    public void A(int i2, int i3, int i4, b bVar) {
        a aVar = new a(i2, i3, i4, bVar);
        this.f21184g = aVar;
        aVar.execute(new Void[0]);
    }

    public void B(InterestFrsData interestFrsData) {
        this.f21183f = interestFrsData;
    }

    public void C(boolean z) {
        this.f21182e = z;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void x() {
        a aVar = this.f21184g;
        if (aVar != null) {
            aVar.cancel();
        }
    }

    public InterestFrsData y() {
        return this.f21183f;
    }

    public boolean z() {
        return this.f21182e;
    }
}
