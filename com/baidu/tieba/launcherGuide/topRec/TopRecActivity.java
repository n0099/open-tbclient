package com.baidu.tieba.launcherGuide.topRec;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.launcherGuide.topRec.TRForumListData;
import com.baidu.tieba.launcherGuide.topRec.h;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.w;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class TopRecActivity extends BaseActivity<TopRecActivity> {
    private w Gg;
    private d diA;
    private h diB;
    private a diC;
    private TRForumListData diD;
    private List<a> diF;
    private List<w> diG;
    private e diz;
    private int diE = 0;
    private int diH = 0;
    private h.b diI = new com.baidu.tieba.launcherGuide.topRec.a(this);
    private z.b bIh = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData();
    }

    private void initUI() {
        this.diz = new e(this);
        this.diz.fU(true);
    }

    private void initData() {
        this.diA = new d(this);
        this.diz.a(this.diA);
        this.diB = new h(this);
        this.diB.a(this.diI);
        this.diB.LoadData();
        this.diF = new LinkedList();
        this.diG = new LinkedList();
        this.diz.b(this.bIh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(int i, int i2) {
        if (this.diD != null && i < this.diD.forum_list.length) {
            this.diD.forum_list[i].is_like = 1;
            this.diA.notifyDataSetChanged();
            this.diE++;
            this.diz.lK(this.diE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(int i, int i2) {
        if (this.diD != null && i < this.diD.forum_list.length) {
            this.diD.forum_list[i].is_like = 0;
            this.diA.notifyDataSetChanged();
            if (this.diE != 0) {
                this.diE--;
            }
            this.diz.lK(this.diE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void awH() {
        this.diH++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void awI() {
        if (this.diH != 0) {
            this.diH--;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int size = this.diF.size();
        for (int i = 0; i < size; i++) {
            if (this.diF.get(i) != null) {
                this.diF.get(i).cancel();
            }
        }
        int size2 = this.diG.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.diG.get(i2) != null) {
                this.diG.get(i2).bfj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.diA != null) {
            int awL = this.diA.awL();
            if (awL != 0) {
                this.diE += awL;
                this.diH = awL + this.diH;
                this.diz.lK(this.diE);
            }
            this.diA.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.diz.onChangeSkinType(i);
        this.diA.aV(r.f.btn_add, r.f.btn_add_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lJ(int i) {
        if (this.diD == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.diD.forum_list.length; i2++) {
            if (this.diD.forum_list[i2].forum_id == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.diz.awM()) {
            this.diA.awJ();
            if (this.diA.awK()) {
                this.diz.awP();
            }
        } else if (view == this.diz.awN()) {
            if (this.diH != 0) {
                showToast(String.valueOf(getPageContext().getString(r.j.top_rec_like_finish_a)) + this.diH + getPageContext().getString(r.j.total_num_bar));
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
            } else {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
            }
            finish();
            com.baidu.tbadk.core.d.b.f(getPageContext().getPageActivity(), 1);
        } else if (this.diD != null && this.diD.forum_list.length != 0) {
            int intValue = ((Integer) view.getTag()).intValue();
            int lJ = lJ(intValue);
            if (this.diD.forum_list[lJ].is_like == 1) {
                aU(lJ, intValue);
                this.diC = new a(this, null);
                this.diF.add(this.diC);
                this.diC.setPriority(2);
                this.diC.execute(Integer.valueOf(intValue));
                return;
            }
            this.Gg = new w(getPageContext());
            if (!this.Gg.bfk()) {
                this.diG.add(this.Gg);
                aT(lJ, intValue);
                this.Gg.setLoadDataCallBack(new c(this, lJ, intValue));
                this.Gg.setFrom("from_topRec");
                this.Gg.bV(this.diD.forum_list[lJ].forum_name, String.valueOf(this.diD.forum_list[lJ].forum_id));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Integer, Integer, String> {
        private com.baidu.tbadk.core.util.z aiN;
        TRForumListData.TRForum diK;
        int id;
        int position;

        private a() {
            this.aiN = null;
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
            this.position = TopRecActivity.this.lJ(this.id);
            if (this.position >= 0) {
                this.diK = TopRecActivity.this.diD.forum_list[this.position];
            }
            try {
                if (this.diK != null && this.diK.forum_id != 0 && this.diK.forum_name != null) {
                    this.aiN = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.aiN.n("fid", String.valueOf(this.diK.forum_id));
                    this.aiN.n("kw", this.diK.forum_name);
                    this.aiN.n("favo_type", "1");
                    this.aiN.n("st_type", "from_topRec");
                    this.aiN.uI().vB().mIsNeedTbs = true;
                    this.aiN.uk();
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
        /* renamed from: ew */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            TopRecActivity.this.diC = null;
            if (this.aiN == null) {
                TopRecActivity.this.aT(this.position, this.diK.forum_id);
            } else if (!this.aiN.uI().vC().oH()) {
                TopRecActivity.this.aT(this.position, this.diK.forum_id);
            } else if (str == null) {
                TopRecActivity.this.aT(this.position, this.diK.forum_id);
            } else {
                TbadkApplication.getInst().delLikeForum(this.diK.forum_name);
                TopRecActivity.this.awI();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiN != null) {
                this.aiN.eg();
                this.aiN = null;
            }
            TopRecActivity.this.diz.fU(false);
            TopRecActivity.this.diC = null;
            super.cancel(true);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.diH != 0) {
            showToast(String.valueOf(getPageContext().getString(r.j.top_rec_like_finish_a)) + this.diH + getPageContext().getString(r.j.total_num_bar));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
        } else {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
        }
        finish();
        com.baidu.tbadk.core.d.b.f(getPageContext().getPageActivity(), 1);
    }
}
