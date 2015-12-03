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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
import com.baidu.tieba.n;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a extends e<BaseFragmentActivity> {
    private static final String cja = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/gettaglist";
    private boolean cjb;
    private InterestFrsData cjc;
    private C0071a cjd;

    /* loaded from: classes.dex */
    public interface b {
        void a(InterestFrsData interestFrsData);

        void b(InterestFrsData interestFrsData);
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
    }

    public boolean aeC() {
        return this.cjb;
    }

    public void ej(boolean z) {
        this.cjb = z;
    }

    public InterestFrsData aeD() {
        return this.cjc;
    }

    public void e(InterestFrsData interestFrsData) {
        this.cjc = interestFrsData;
    }

    public void a(int i, int i2, int i3, b bVar) {
        this.cjd = new C0071a(i, i2, i3, bVar);
        this.cjd.execute(new Void[0]);
    }

    public void aeE() {
        if (this.cjd != null) {
            this.cjd.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.launcherGuide.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0071a extends BdAsyncTask<Void, Void, InterestFrsData> {
        private WeakReference<b> aHt;
        private int limit;
        private int offset;
        private int userType;

        public C0071a(int i, int i2, int i3, b bVar) {
            this.userType = i;
            this.offset = i2;
            this.limit = i3;
            this.aHt = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public InterestFrsData doInBackground(Void... voidArr) {
            ab abVar = new ab(a.cja);
            abVar.o(OfficalBarChatActivityConfig.USER_TYPE, String.valueOf(this.userType));
            abVar.o("offset", String.valueOf(this.offset));
            abVar.o("limit", String.valueOf(this.limit));
            String ul = abVar.ul();
            if (abVar.uM().vG().rf()) {
                try {
                    return (InterestFrsData) i.objectWithJsonStr(ul, InterestFrsData.class);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    InterestFrsData interestFrsData = new InterestFrsData();
                    interestFrsData.setErrno(-1000);
                    interestFrsData.setErrmsg(TbadkApplication.getInst().getContext().getString(n.i.neterror));
                    return interestFrsData;
                }
            }
            InterestFrsData interestFrsData2 = new InterestFrsData();
            interestFrsData2.setErrno(abVar.uQ() == 0 ? TbErrInfo.ERR_IMG_GET_REMOTE : abVar.uQ());
            interestFrsData2.setErrmsg(abVar.getErrorString());
            return interestFrsData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public void onPostExecute(InterestFrsData interestFrsData) {
            super.onPostExecute(interestFrsData);
            b bVar = this.aHt.get();
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
