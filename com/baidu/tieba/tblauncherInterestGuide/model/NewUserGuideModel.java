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
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class NewUserGuideModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LIMIT = 100;
    public static final int OFFSET = 0;
    private static final String gPk = TbConfig.SERVER_ADDRESS + "c/s/gettaglist";
    private boolean gPl;
    private InterestFrsData gPm;
    private a gPn;

    /* loaded from: classes3.dex */
    public interface b {
        void a(InterestFrsData interestFrsData);

        void b(InterestFrsData interestFrsData);
    }

    public NewUserGuideModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
    }

    public boolean bzp() {
        return this.gPl;
    }

    public void mN(boolean z) {
        this.gPl = z;
    }

    public InterestFrsData bzq() {
        return this.gPm;
    }

    public void e(InterestFrsData interestFrsData) {
        this.gPm = interestFrsData;
    }

    public void a(int i, int i2, int i3, b bVar) {
        this.gPn = new a(i, i2, i3, bVar);
        this.gPn.execute(new Void[0]);
    }

    public void bzr() {
        if (this.gPn != null) {
            this.gPn.cancel();
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
        private WeakReference<b> fmQ;
        private int limit;
        private int offset;
        private int userType;

        public a(int i, int i2, int i3, b bVar) {
            this.userType = i;
            this.offset = i2;
            this.limit = i3;
            this.fmQ = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public InterestFrsData doInBackground(Void... voidArr) {
            y yVar = new y(NewUserGuideModel.gPk);
            yVar.o("user_type", String.valueOf(this.userType));
            yVar.o(WBPageConstants.ParamKey.OFFSET, String.valueOf(this.offset));
            yVar.o("limit", String.valueOf(this.limit));
            String yl = yVar.yl();
            if (yVar.yJ().zJ().isRequestSuccess()) {
                try {
                    return (InterestFrsData) OrmObject.objectWithJsonStr(yl, InterestFrsData.class);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    InterestFrsData interestFrsData = new InterestFrsData();
                    interestFrsData.setErrno(NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
                    interestFrsData.setErrmsg(TbadkApplication.getInst().getContext().getString(d.k.neterror));
                    return interestFrsData;
                }
            }
            InterestFrsData interestFrsData2 = new InterestFrsData();
            interestFrsData2.setErrno(yVar.yN() == 0 ? -1001 : yVar.yN());
            interestFrsData2.setErrmsg(yVar.getErrorString());
            return interestFrsData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public void onPostExecute(InterestFrsData interestFrsData) {
            super.onPostExecute(interestFrsData);
            b bVar = this.fmQ.get();
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
