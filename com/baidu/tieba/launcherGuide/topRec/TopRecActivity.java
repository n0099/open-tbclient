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
import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.launcherGuide.topRec.TRForumListData;
import com.baidu.tieba.launcherGuide.topRec.h;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.x;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class TopRecActivity extends BaseActivity<TopRecActivity> {
    private x Dp;
    private d cEA;
    private h cEB;
    private a cEC;
    private TRForumListData cED;
    private List<a> cEF;
    private List<x> cEG;
    private e cEz;
    private int cEE = 0;
    private int cEH = 0;
    private h.b cEI = new com.baidu.tieba.launcherGuide.topRec.a(this);
    private t.b bqy = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        nq();
        initData();
    }

    private void nq() {
        this.cEz = new e(this);
        this.cEz.eB(true);
    }

    private void initData() {
        this.cEA = new d(this);
        this.cEz.a(this.cEA);
        this.cEB = new h(this);
        this.cEB.a(this.cEI);
        this.cEB.LoadData();
        this.cEF = new LinkedList();
        this.cEG = new LinkedList();
        this.cEz.b(this.bqy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(int i, int i2) {
        if (this.cED != null && i < this.cED.forum_list.length) {
            this.cED.forum_list[i].is_like = 1;
            this.cEA.notifyDataSetChanged();
            this.cEE++;
            this.cEz.km(this.cEE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(int i, int i2) {
        if (this.cED != null && i < this.cED.forum_list.length) {
            this.cED.forum_list[i].is_like = 0;
            this.cEA.notifyDataSetChanged();
            if (this.cEE != 0) {
                this.cEE--;
            }
            this.cEz.km(this.cEE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void anp() {
        this.cEH++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void anq() {
        if (this.cEH != 0) {
            this.cEH--;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int size = this.cEF.size();
        for (int i = 0; i < size; i++) {
            if (this.cEF.get(i) != null) {
                this.cEF.get(i).cancel();
            }
        }
        int size2 = this.cEG.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.cEG.get(i2) != null) {
                this.cEG.get(i2).aTc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cEA != null) {
            int ant = this.cEA.ant();
            if (ant != 0) {
                this.cEE += ant;
                this.cEH = ant + this.cEH;
                this.cEz.km(this.cEE);
            }
            this.cEA.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cEz.onChangeSkinType(i);
        this.cEA.aF(t.f.btn_add, t.f.btn_add_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int kl(int i) {
        if (this.cED == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.cED.forum_list.length; i2++) {
            if (this.cED.forum_list[i2].forum_id == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.cEz.anu()) {
            this.cEA.anr();
            if (this.cEA.ans()) {
                this.cEz.anx();
            }
        } else if (view == this.cEz.anv()) {
            if (this.cEH != 0) {
                showToast(String.valueOf(getPageContext().getString(t.j.top_rec_like_finish_a)) + this.cEH + getPageContext().getString(t.j.top_rec_like_finish_b));
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
            } else {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
            }
            finish();
            com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 1);
        } else if (this.cED != null && this.cED.forum_list.length != 0) {
            int intValue = ((Integer) view.getTag()).intValue();
            int kl = kl(intValue);
            if (this.cED.forum_list[kl].is_like == 1) {
                aE(kl, intValue);
                this.cEC = new a(this, null);
                this.cEF.add(this.cEC);
                this.cEC.setPriority(2);
                this.cEC.execute(Integer.valueOf(intValue));
                return;
            }
            this.Dp = new x(getPageContext());
            if (!this.Dp.aTd()) {
                this.cEG.add(this.Dp);
                aD(kl, intValue);
                this.Dp.setLoadDataCallBack(new c(this, kl, intValue));
                this.Dp.setFrom("from_topRec");
                this.Dp.bH(this.cED.forum_list[kl].forum_name, String.valueOf(this.cED.forum_list[kl].forum_id));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Integer, Integer, String> {
        private ab aeI;
        TRForumListData.TRForum cEK;
        int id;
        int position;

        private a() {
            this.aeI = null;
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
            this.position = TopRecActivity.this.kl(this.id);
            if (this.position >= 0) {
                this.cEK = TopRecActivity.this.cED.forum_list[this.position];
            }
            try {
                if (this.cEK != null && this.cEK.forum_id != 0 && this.cEK.forum_name != null) {
                    this.aeI = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.aeI.n("fid", String.valueOf(this.cEK.forum_id));
                    this.aeI.n("kw", this.cEK.forum_name);
                    this.aeI.n("favo_type", "1");
                    this.aeI.n("st_type", "from_topRec");
                    this.aeI.tB().uv().mIsNeedTbs = true;
                    this.aeI.td();
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
        /* renamed from: eo */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            TopRecActivity.this.cEC = null;
            if (this.aeI == null) {
                TopRecActivity.this.aD(this.position, this.cEK.forum_id);
            } else if (!this.aeI.tB().uw().nZ()) {
                TopRecActivity.this.aD(this.position, this.cEK.forum_id);
            } else if (str == null) {
                TopRecActivity.this.aD(this.position, this.cEK.forum_id);
            } else {
                TbadkApplication.getInst().delLikeForum(this.cEK.forum_name);
                TopRecActivity.this.anq();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aeI != null) {
                this.aeI.dl();
                this.aeI = null;
            }
            TopRecActivity.this.cEz.eB(false);
            TopRecActivity.this.cEC = null;
            super.cancel(true);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.cEH != 0) {
            showToast(String.valueOf(getPageContext().getString(t.j.top_rec_like_finish_a)) + this.cEH + getPageContext().getString(t.j.top_rec_like_finish_b));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
        } else {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
        }
        finish();
        com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 1);
    }
}
