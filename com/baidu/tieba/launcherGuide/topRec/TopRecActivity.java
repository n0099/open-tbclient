package com.baidu.tieba.launcherGuide.topRec;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.launcherGuide.topRec.TRForumListData;
import com.baidu.tieba.launcherGuide.topRec.h;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.w;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class TopRecActivity extends BaseActivity<TopRecActivity> {
    private w MY;
    private e cEH;
    private d cEI;
    private h cEJ;
    private a cEK;
    private TRForumListData cEL;
    private List<a> cEN;
    private List<w> cEO;
    private int cEM = 0;
    private int cEP = 0;
    private h.b cEQ = new com.baidu.tieba.launcherGuide.topRec.a(this);
    private s.a bkU = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        pU();
        initData();
    }

    private void pU() {
        this.cEH = new e(this);
        this.cEH.ea(true);
    }

    private void initData() {
        this.cEI = new d(this);
        this.cEH.a(this.cEI);
        this.cEJ = new h(this);
        this.cEJ.a(this.cEQ);
        this.cEJ.LoadData();
        this.cEN = new LinkedList();
        this.cEO = new LinkedList();
        this.cEH.b(this.bkU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(int i, int i2) {
        if (this.cEL != null && i < this.cEL.forum_list.length) {
            this.cEL.forum_list[i].is_like = 1;
            this.cEI.notifyDataSetChanged();
            this.cEM++;
            this.cEH.kI(this.cEM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(int i, int i2) {
        if (this.cEL != null && i < this.cEL.forum_list.length) {
            this.cEL.forum_list[i].is_like = 0;
            this.cEI.notifyDataSetChanged();
            if (this.cEM != 0) {
                this.cEM--;
            }
            this.cEH.kI(this.cEM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void anq() {
        this.cEP++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void anr() {
        if (this.cEP != 0) {
            this.cEP--;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int size = this.cEN.size();
        for (int i = 0; i < size; i++) {
            if (this.cEN.get(i) != null) {
                this.cEN.get(i).cancel();
            }
        }
        int size2 = this.cEO.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.cEO.get(i2) != null) {
                this.cEO.get(i2).aSx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cEI != null) {
            int anu = this.cEI.anu();
            if (anu != 0) {
                this.cEM += anu;
                this.cEP = anu + this.cEP;
                this.cEH.kI(this.cEM);
            }
            this.cEI.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cEH.onChangeSkinType(i);
        this.cEI.aG(t.f.btn_add, t.f.btn_add_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int kH(int i) {
        if (this.cEL == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.cEL.forum_list.length; i2++) {
            if (this.cEL.forum_list[i2].forum_id == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.cEH.anv()) {
            this.cEI.ans();
            if (this.cEI.ant()) {
                this.cEH.any();
            }
        } else if (view == this.cEH.anw()) {
            if (this.cEP != 0) {
                showToast(String.valueOf(getPageContext().getString(t.j.top_rec_like_finish_a)) + this.cEP + getPageContext().getString(t.j.top_rec_like_finish_b));
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
            } else {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
            }
            finish();
            com.baidu.tbadk.core.d.b.d(getPageContext().getPageActivity(), 1);
        } else if (this.cEL != null && this.cEL.forum_list.length != 0) {
            int intValue = ((Integer) view.getTag()).intValue();
            int kH = kH(intValue);
            if (this.cEL.forum_list[kH].is_like == 1) {
                aF(kH, intValue);
                this.cEK = new a(this, null);
                this.cEN.add(this.cEK);
                this.cEK.setPriority(2);
                this.cEK.execute(Integer.valueOf(intValue));
                return;
            }
            this.MY = new w(getPageContext());
            if (!this.MY.aSy()) {
                this.cEO.add(this.MY);
                aE(kH, intValue);
                this.MY.setLoadDataCallBack(new c(this, kH, intValue));
                this.MY.setFrom("from_topRec");
                this.MY.bC(this.cEL.forum_list[kH].forum_name, String.valueOf(this.cEL.forum_list[kH].forum_id));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Integer, Integer, String> {
        private ab aiW;
        TRForumListData.TRForum cES;
        int id;
        int position;

        private a() {
            this.aiW = null;
            this.position = -1;
            this.id = 0;
        }

        /* synthetic */ a(TopRecActivity topRecActivity, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(Integer... numArr) {
            this.id = numArr[0].intValue();
            this.position = TopRecActivity.this.kH(this.id);
            if (this.position >= 0) {
                this.cES = TopRecActivity.this.cEL.forum_list[this.position];
            }
            try {
                if (this.cES != null && this.cES.forum_id != 0 && this.cES.forum_name != null) {
                    this.aiW = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.aiW.p("fid", String.valueOf(this.cES.forum_id));
                    this.aiW.p("kw", this.cES.forum_name);
                    this.aiW.p("favo_type", "1");
                    this.aiW.p("st_type", "from_topRec");
                    this.aiW.vU().wO().mIsNeedTbs = true;
                    this.aiW.vw();
                    return null;
                }
                return null;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: er */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            TopRecActivity.this.cEK = null;
            if (this.aiW == null) {
                TopRecActivity.this.aE(this.position, this.cES.forum_id);
            } else if (!this.aiW.vU().wP().qC()) {
                TopRecActivity.this.aE(this.position, this.cES.forum_id);
            } else if (str == null) {
                TopRecActivity.this.aE(this.position, this.cES.forum_id);
            } else {
                TbadkApplication.getInst().delLikeForum(this.cES.forum_name);
                TopRecActivity.this.anr();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiW != null) {
                this.aiW.gX();
                this.aiW = null;
            }
            TopRecActivity.this.cEH.ea(false);
            TopRecActivity.this.cEK = null;
            super.cancel(true);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.cEP != 0) {
            showToast(String.valueOf(getPageContext().getString(t.j.top_rec_like_finish_a)) + this.cEP + getPageContext().getString(t.j.top_rec_like_finish_b));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
        } else {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
        }
        finish();
        com.baidu.tbadk.core.d.b.d(getPageContext().getPageActivity(), 1);
    }
}
