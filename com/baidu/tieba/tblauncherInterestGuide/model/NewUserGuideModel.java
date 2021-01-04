package com.baidu.tieba.tblauncherInterestGuide.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class NewUserGuideModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LIMIT = 100;
    public static final int OFFSET = 0;
    private static final String nzX = TbConfig.SERVER_ADDRESS + Config.INTERESTS_FRS_URL;
    private a nAa;
    private boolean nzY;
    private InterestFrsData nzZ;

    /* loaded from: classes2.dex */
    public interface b {
        void a(InterestFrsData interestFrsData);

        void b(InterestFrsData interestFrsData);
    }

    public NewUserGuideModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
    }

    public boolean dSk() {
        return this.nzY;
    }

    public void yB(boolean z) {
        this.nzY = z;
    }

    public InterestFrsData dSl() {
        return this.nzZ;
    }

    public void e(InterestFrsData interestFrsData) {
        this.nzZ = interestFrsData;
    }

    public void a(int i, int i2, int i3, b bVar) {
        this.nAa = new a(i, i2, i3, bVar);
        this.nAa.execute(new Void[0]);
    }

    public void dSm() {
        if (this.nAa != null) {
            this.nAa.cancel();
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
    /* loaded from: classes2.dex */
    public static class a extends BdAsyncTask<Void, Void, InterestFrsData> {
        private WeakReference<b> lEl;
        private int limit;
        private int offset;
        private int userType;

        public a(int i, int i2, int i3, b bVar) {
            this.userType = i;
            this.offset = i2;
            this.limit = i3;
            this.lEl = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public InterestFrsData doInBackground(Void... voidArr) {
            z zVar = new z(NewUserGuideModel.nzX);
            zVar.addPostData("user_type", String.valueOf(this.userType));
            zVar.addPostData("offset", String.valueOf(this.offset));
            zVar.addPostData(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(this.limit));
            String postNetData = zVar.postNetData();
            if (zVar.bvQ().bwA().isRequestSuccess()) {
                try {
                    return (InterestFrsData) OrmObject.objectWithJsonStr(postNetData, InterestFrsData.class);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    InterestFrsData interestFrsData = new InterestFrsData();
                    interestFrsData.setErrno(-1000);
                    interestFrsData.setErrmsg(TbadkApplication.getInst().getContext().getString(R.string.neterror));
                    return interestFrsData;
                }
            }
            InterestFrsData interestFrsData2 = new InterestFrsData();
            interestFrsData2.setErrno(zVar.getServerErrorCode() == 0 ? -1001 : zVar.getServerErrorCode());
            interestFrsData2.setErrmsg(zVar.getErrorString());
            return interestFrsData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public void onPostExecute(InterestFrsData interestFrsData) {
            super.onPostExecute(interestFrsData);
            b bVar = this.lEl.get();
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
