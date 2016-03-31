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
import com.baidu.tieba.t;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class a extends e<BaseFragmentActivity> {
    private static final String cEk = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/gettaglist";
    private boolean cEl;
    private InterestFrsData cEm;
    private C0069a cEn;

    /* loaded from: classes.dex */
    public interface b {
        void a(InterestFrsData interestFrsData);

        void b(InterestFrsData interestFrsData);
    }

    public a(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
    }

    public boolean ang() {
        return this.cEl;
    }

    public void eT(boolean z) {
        this.cEl = z;
    }

    public InterestFrsData anh() {
        return this.cEm;
    }

    public void e(InterestFrsData interestFrsData) {
        this.cEm = interestFrsData;
    }

    public void a(int i, int i2, int i3, b bVar) {
        this.cEn = new C0069a(i, i2, i3, bVar);
        this.cEn.execute(new Void[0]);
    }

    public void ani() {
        if (this.cEn != null) {
            this.cEn.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.launcherGuide.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0069a extends BdAsyncTask<Void, Void, InterestFrsData> {
        private WeakReference<b> aMW;
        private int limit;
        private int offset;
        private int userType;

        public C0069a(int i, int i2, int i3, b bVar) {
            this.userType = i;
            this.offset = i2;
            this.limit = i3;
            this.aMW = new WeakReference<>(bVar);
            setPriority(3);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public InterestFrsData doInBackground(Void... voidArr) {
            ab abVar = new ab(a.cEk);
            abVar.p(OfficalBarChatActivityConfig.USER_TYPE, String.valueOf(this.userType));
            abVar.p("offset", String.valueOf(this.offset));
            abVar.p("limit", String.valueOf(this.limit));
            String vw = abVar.vw();
            if (abVar.vU().wP().qC()) {
                try {
                    return (InterestFrsData) i.objectWithJsonStr(vw, InterestFrsData.class);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    InterestFrsData interestFrsData = new InterestFrsData();
                    interestFrsData.setErrno(-1000);
                    interestFrsData.setErrmsg(TbadkApplication.getInst().getContext().getString(t.j.neterror));
                    return interestFrsData;
                }
            }
            InterestFrsData interestFrsData2 = new InterestFrsData();
            interestFrsData2.setErrno(abVar.vY() == 0 ? TbErrInfo.ERR_IMG_GET_REMOTE : abVar.vY());
            interestFrsData2.setErrmsg(abVar.getErrorString());
            return interestFrsData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public void onPostExecute(InterestFrsData interestFrsData) {
            super.onPostExecute(interestFrsData);
            b bVar = this.aMW.get();
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
