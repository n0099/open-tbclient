package com.baidu.tieba.tblauncherInterestGuide.model;

import android.support.v4.app.NotificationManagerCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.e;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class NewUserGuideModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LIMIT = 100;
    public static final int OFFSET = 0;
    private static final String hjP = TbConfig.SERVER_ADDRESS + "c/s/gettaglist";
    private boolean hjQ;
    private InterestFrsData hjR;
    private a hjS;

    /* loaded from: classes3.dex */
    public interface b {
        void a(InterestFrsData interestFrsData);

        void b(InterestFrsData interestFrsData);
    }

    public NewUserGuideModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
    }

    public boolean bEy() {
        return this.hjQ;
    }

    public void nx(boolean z) {
        this.hjQ = z;
    }

    public InterestFrsData bEz() {
        return this.hjR;
    }

    public void e(InterestFrsData interestFrsData) {
        this.hjR = interestFrsData;
    }

    public void a(int i, int i2, int i3, b bVar) {
        this.hjS = new a(i, i2, i3, bVar);
        this.hjS.execute(new Void[0]);
    }

    public void bEA() {
        if (this.hjS != null) {
            this.hjS.cancel();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends BdAsyncTask<Void, Void, InterestFrsData> {
        private WeakReference<b> fGb;
        private int limit;
        private int offset;
        private int userType;

        public a(int i, int i2, int i3, b bVar) {
            this.userType = i;
            this.offset = i2;
            this.limit = i3;
            this.fGb = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public InterestFrsData doInBackground(Void... voidArr) {
            x xVar = new x(NewUserGuideModel.hjP);
            xVar.x("user_type", String.valueOf(this.userType));
            xVar.x("offset", String.valueOf(this.offset));
            xVar.x("limit", String.valueOf(this.limit));
            String BA = xVar.BA();
            if (xVar.BY().CX().isRequestSuccess()) {
                try {
                    return (InterestFrsData) OrmObject.objectWithJsonStr(BA, InterestFrsData.class);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    InterestFrsData interestFrsData = new InterestFrsData();
                    interestFrsData.setErrno(NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
                    interestFrsData.setErrmsg(TbadkApplication.getInst().getContext().getString(e.j.neterror));
                    return interestFrsData;
                }
            }
            InterestFrsData interestFrsData2 = new InterestFrsData();
            interestFrsData2.setErrno(xVar.Cc() == 0 ? -1001 : xVar.Cc());
            interestFrsData2.setErrmsg(xVar.getErrorString());
            return interestFrsData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public void onPostExecute(InterestFrsData interestFrsData) {
            super.onPostExecute(interestFrsData);
            b bVar = this.fGb.get();
            if (bVar != null) {
                if (interestFrsData.getErrno() == 0) {
                    bVar.a(interestFrsData);
                } else {
                    bVar.b(interestFrsData);
                }
            }
        }
    }
}
