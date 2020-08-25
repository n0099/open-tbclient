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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import java.lang.ref.WeakReference;
/* loaded from: classes16.dex */
public class NewUserGuideModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int LIMIT = 100;
    public static final int OFFSET = 0;
    private static final String mmN = TbConfig.SERVER_ADDRESS + Config.INTERESTS_FRS_URL;
    private boolean mmO;
    private InterestFrsData mmP;
    private a mmQ;

    /* loaded from: classes16.dex */
    public interface b {
        void a(InterestFrsData interestFrsData);

        void b(InterestFrsData interestFrsData);
    }

    public NewUserGuideModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
    }

    public boolean dzi() {
        return this.mmO;
    }

    public void ws(boolean z) {
        this.mmO = z;
    }

    public InterestFrsData dzj() {
        return this.mmP;
    }

    public void e(InterestFrsData interestFrsData) {
        this.mmP = interestFrsData;
    }

    public void a(int i, int i2, int i3, b bVar) {
        this.mmQ = new a(i, i2, i3, bVar);
        this.mmQ.execute(new Void[0]);
    }

    public void dzk() {
        if (this.mmQ != null) {
            this.mmQ.cancel();
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
    /* loaded from: classes16.dex */
    public static class a extends BdAsyncTask<Void, Void, InterestFrsData> {
        private WeakReference<b> kvb;
        private int limit;
        private int offset;
        private int userType;

        public a(int i, int i2, int i3, b bVar) {
            this.userType = i;
            this.offset = i2;
            this.limit = i3;
            this.kvb = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public InterestFrsData doInBackground(Void... voidArr) {
            aa aaVar = new aa(NewUserGuideModel.mmN);
            aaVar.addPostData("user_type", String.valueOf(this.userType));
            aaVar.addPostData("offset", String.valueOf(this.offset));
            aaVar.addPostData(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(this.limit));
            String postNetData = aaVar.postNetData();
            if (aaVar.biQ().bjw().isRequestSuccess()) {
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
            interestFrsData2.setErrno(aaVar.getServerErrorCode() == 0 ? -1001 : aaVar.getServerErrorCode());
            interestFrsData2.setErrmsg(aaVar.getErrorString());
            return interestFrsData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public void onPostExecute(InterestFrsData interestFrsData) {
            super.onPostExecute(interestFrsData);
            b bVar = this.kvb.get();
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
