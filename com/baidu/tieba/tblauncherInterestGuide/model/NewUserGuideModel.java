package com.baidu.tieba.tblauncherInterestGuide.model;

import android.support.v4.app.NotificationManagerCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.d;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class NewUserGuideModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LIMIT = 100;
    public static final int OFFSET = 0;
    private static final String gUJ = TbConfig.SERVER_ADDRESS + "c/s/gettaglist";
    private boolean gUK;
    private InterestFrsData gUL;
    private a gUM;

    /* loaded from: classes3.dex */
    public interface b {
        void a(InterestFrsData interestFrsData);

        void b(InterestFrsData interestFrsData);
    }

    public NewUserGuideModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
    }

    public boolean byA() {
        return this.gUK;
    }

    public void mJ(boolean z) {
        this.gUK = z;
    }

    public InterestFrsData byB() {
        return this.gUL;
    }

    public void e(InterestFrsData interestFrsData) {
        this.gUL = interestFrsData;
    }

    public void a(int i, int i2, int i3, b bVar) {
        this.gUM = new a(i, i2, i3, bVar);
        this.gUM.execute(new Void[0]);
    }

    public void byC() {
        if (this.gUM != null) {
            this.gUM.cancel();
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
        private WeakReference<b> fqV;
        private int limit;
        private int offset;
        private int userType;

        public a(int i, int i2, int i3, b bVar) {
            this.userType = i;
            this.offset = i2;
            this.limit = i3;
            this.fqV = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public InterestFrsData doInBackground(Void... voidArr) {
            y yVar = new y(NewUserGuideModel.gUJ);
            yVar.o("user_type", String.valueOf(this.userType));
            yVar.o("offset", String.valueOf(this.offset));
            yVar.o("limit", String.valueOf(this.limit));
            String yq = yVar.yq();
            if (yVar.yO().zN().isRequestSuccess()) {
                try {
                    return (InterestFrsData) OrmObject.objectWithJsonStr(yq, InterestFrsData.class);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    InterestFrsData interestFrsData = new InterestFrsData();
                    interestFrsData.setErrno(NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
                    interestFrsData.setErrmsg(TbadkApplication.getInst().getContext().getString(d.j.neterror));
                    return interestFrsData;
                }
            }
            InterestFrsData interestFrsData2 = new InterestFrsData();
            interestFrsData2.setErrno(yVar.yS() == 0 ? -1001 : yVar.yS());
            interestFrsData2.setErrmsg(yVar.getErrorString());
            return interestFrsData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public void onPostExecute(InterestFrsData interestFrsData) {
            super.onPostExecute(interestFrsData);
            b bVar = this.fqV.get();
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
