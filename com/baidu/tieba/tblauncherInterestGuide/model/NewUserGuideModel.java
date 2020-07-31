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
/* loaded from: classes16.dex */
public class NewUserGuideModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LIMIT = 100;
    public static final int OFFSET = 0;
    private static final String lUY = TbConfig.SERVER_ADDRESS + Config.INTERESTS_FRS_URL;
    private boolean lUZ;
    private InterestFrsData lVa;
    private a lVb;

    /* loaded from: classes16.dex */
    public interface b {
        void a(InterestFrsData interestFrsData);

        void b(InterestFrsData interestFrsData);
    }

    public NewUserGuideModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
    }

    public boolean dnM() {
        return this.lUZ;
    }

    public void vD(boolean z) {
        this.lUZ = z;
    }

    public InterestFrsData dnN() {
        return this.lVa;
    }

    public void e(InterestFrsData interestFrsData) {
        this.lVa = interestFrsData;
    }

    public void a(int i, int i2, int i3, b bVar) {
        this.lVb = new a(i, i2, i3, bVar);
        this.lVb.execute(new Void[0]);
    }

    public void dnO() {
        if (this.lVb != null) {
            this.lVb.cancel();
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

    /* loaded from: classes16.dex */
    private static class a extends BdAsyncTask<Void, Void, InterestFrsData> {
        private WeakReference<b> kfG;
        private int limit;
        private int offset;
        private int userType;

        public a(int i, int i2, int i3, b bVar) {
            this.userType = i;
            this.offset = i2;
            this.limit = i3;
            this.kfG = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public InterestFrsData doInBackground(Void... voidArr) {
            z zVar = new z(NewUserGuideModel.lUY);
            zVar.addPostData("user_type", String.valueOf(this.userType));
            zVar.addPostData("offset", String.valueOf(this.offset));
            zVar.addPostData(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(this.limit));
            String postNetData = zVar.postNetData();
            if (zVar.bav().baX().isRequestSuccess()) {
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
            b bVar = this.kfG.get();
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
