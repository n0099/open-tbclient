package com.baidu.tieba.launcherGuide.a;

import com.baidu.adp.base.e;
import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.i;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a extends e<BaseFragmentActivity> {
    private static final String bSM = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/gettaglist";
    private boolean bSN;
    private InterestFrsData bSO;
    private C0063a bSP;

    /* loaded from: classes.dex */
    public interface b {
        void a(InterestFrsData interestFrsData);

        void b(InterestFrsData interestFrsData);
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
    }

    public boolean aaW() {
        return this.bSN;
    }

    public void dK(boolean z) {
        this.bSN = z;
    }

    public InterestFrsData aaX() {
        return this.bSO;
    }

    public void e(InterestFrsData interestFrsData) {
        this.bSO = interestFrsData;
    }

    public void a(int i, int i2, int i3, b bVar) {
        this.bSP = new C0063a(i, i2, i3, bVar);
        this.bSP.execute(new Void[0]);
    }

    public void aaY() {
        if (this.bSP != null) {
            this.bSP.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.launcherGuide.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0063a extends BdAsyncTask<Void, Void, InterestFrsData> {
        private WeakReference<b> aEu;
        private int limit;
        private int offset;
        private int userType;

        public C0063a(int i, int i2, int i3, b bVar) {
            this.userType = i;
            this.offset = i2;
            this.limit = i3;
            this.aEu = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public InterestFrsData doInBackground(Void... voidArr) {
            w wVar = new w(a.bSM);
            wVar.o(OfficalBarChatActivityConfig.USER_TYPE, String.valueOf(this.userType));
            wVar.o("offset", String.valueOf(this.offset));
            wVar.o("limit", String.valueOf(this.limit));
            String tG = wVar.tG();
            if (wVar.uh().va().qT()) {
                try {
                    return (InterestFrsData) i.objectWithJsonStr(tG, InterestFrsData.class);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    InterestFrsData interestFrsData = new InterestFrsData();
                    interestFrsData.setErrno(-1000);
                    interestFrsData.setErrmsg(TbadkApplication.getInst().getContext().getString(i.h.neterror));
                    return interestFrsData;
                }
            }
            InterestFrsData interestFrsData2 = new InterestFrsData();
            interestFrsData2.setErrno(wVar.ul() == 0 ? TbErrInfo.ERR_IMG_GET_REMOTE : wVar.ul());
            interestFrsData2.setErrmsg(wVar.getErrorString());
            return interestFrsData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public void onPostExecute(InterestFrsData interestFrsData) {
            super.onPostExecute(interestFrsData);
            b bVar = this.aEu.get();
            if (bVar != null) {
                if (interestFrsData.getErrno() == 0) {
                    bVar.a(interestFrsData);
                } else {
                    bVar.b(interestFrsData);
                }
            }
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
