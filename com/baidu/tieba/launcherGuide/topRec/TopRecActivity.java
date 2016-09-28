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
import com.baidu.tbadk.core.view.y;
import com.baidu.tieba.launcherGuide.topRec.TRForumListData;
import com.baidu.tieba.launcherGuide.topRec.h;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.x;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class TopRecActivity extends BaseActivity<TopRecActivity> {
    private x Ge;
    private a dAa;
    private TRForumListData dAb;
    private List<a> dAd;
    private List<x> dAe;
    private e dzX;
    private d dzY;
    private h dzZ;
    private int dAc = 0;
    private int dAf = 0;
    private h.b dAg = new com.baidu.tieba.launcherGuide.topRec.a(this);
    private y.b bZd = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData();
    }

    private void initUI() {
        this.dzX = new e(this);
        this.dzX.fQ(true);
    }

    private void initData() {
        this.dzY = new d(this);
        this.dzX.a(this.dzY);
        this.dzZ = new h(this);
        this.dzZ.a(this.dAg);
        this.dzZ.LoadData();
        this.dAd = new LinkedList();
        this.dAe = new LinkedList();
        this.dzX.b(this.bZd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(int i, int i2) {
        if (this.dAb != null && i < this.dAb.forum_list.length) {
            this.dAb.forum_list[i].is_like = 1;
            this.dzY.notifyDataSetChanged();
            this.dAc++;
            this.dzX.mF(this.dAc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(int i, int i2) {
        if (this.dAb != null && i < this.dAb.forum_list.length) {
            this.dAb.forum_list[i].is_like = 0;
            this.dzY.notifyDataSetChanged();
            if (this.dAc != 0) {
                this.dAc--;
            }
            this.dzX.mF(this.dAc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aBy() {
        this.dAf++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aBz() {
        if (this.dAf != 0) {
            this.dAf--;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int size = this.dAd.size();
        for (int i = 0; i < size; i++) {
            if (this.dAd.get(i) != null) {
                this.dAd.get(i).cancel();
            }
        }
        int size2 = this.dAe.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.dAe.get(i2) != null) {
                this.dAe.get(i2).biU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dzY != null) {
            int aBC = this.dzY.aBC();
            if (aBC != 0) {
                this.dAc += aBC;
                this.dAf = aBC + this.dAf;
                this.dzX.mF(this.dAc);
            }
            this.dzY.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dzX.onChangeSkinType(i);
        this.dzY.bf(r.f.btn_add, r.f.btn_add_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mE(int i) {
        if (this.dAb == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.dAb.forum_list.length; i2++) {
            if (this.dAb.forum_list[i2].forum_id == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dzX.aBD()) {
            this.dzY.aBA();
            if (this.dzY.aBB()) {
                this.dzX.aBG();
            }
        } else if (view == this.dzX.aBE()) {
            if (this.dAf != 0) {
                showToast(String.valueOf(getPageContext().getString(r.j.top_rec_like_finish_a)) + this.dAf + getPageContext().getString(r.j.top_rec_like_finish_b));
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
            } else {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
            }
            finish();
            com.baidu.tbadk.core.d.b.f(getPageContext().getPageActivity(), 1);
        } else if (this.dAb != null && this.dAb.forum_list.length != 0) {
            int intValue = ((Integer) view.getTag()).intValue();
            int mE = mE(intValue);
            if (this.dAb.forum_list[mE].is_like == 1) {
                be(mE, intValue);
                this.dAa = new a(this, null);
                this.dAd.add(this.dAa);
                this.dAa.setPriority(2);
                this.dAa.execute(Integer.valueOf(intValue));
                return;
            }
            this.Ge = new x(getPageContext());
            if (!this.Ge.biV()) {
                this.dAe.add(this.Ge);
                bd(mE, intValue);
                this.Ge.setLoadDataCallBack(new c(this, mE, intValue));
                this.Ge.setFrom("from_topRec");
                this.Ge.bQ(this.dAb.forum_list[mE].forum_name, String.valueOf(this.dAb.forum_list[mE].forum_id));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Integer, Integer, String> {
        private ab aiu;
        TRForumListData.TRForum dAi;
        int id;
        int position;

        private a() {
            this.aiu = null;
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
            this.position = TopRecActivity.this.mE(this.id);
            if (this.position >= 0) {
                this.dAi = TopRecActivity.this.dAb.forum_list[this.position];
            }
            try {
                if (this.dAi != null && this.dAi.forum_id != 0 && this.dAi.forum_name != null) {
                    this.aiu = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.aiu.n("fid", String.valueOf(this.dAi.forum_id));
                    this.aiu.n("kw", this.dAi.forum_name);
                    this.aiu.n("favo_type", "1");
                    this.aiu.n("st_type", "from_topRec");
                    this.aiu.uS().vN().mIsNeedTbs = true;
                    this.aiu.uu();
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
        /* renamed from: ex */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            TopRecActivity.this.dAa = null;
            if (this.aiu == null) {
                TopRecActivity.this.bd(this.position, this.dAi.forum_id);
            } else if (!this.aiu.uS().vO().oF()) {
                TopRecActivity.this.bd(this.position, this.dAi.forum_id);
            } else if (str == null) {
                TopRecActivity.this.bd(this.position, this.dAi.forum_id);
            } else {
                TbadkApplication.getInst().delLikeForum(this.dAi.forum_name);
                TopRecActivity.this.aBz();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiu != null) {
                this.aiu.eg();
                this.aiu = null;
            }
            TopRecActivity.this.dzX.fQ(false);
            TopRecActivity.this.dAa = null;
            super.cancel(true);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.dAf != 0) {
            showToast(String.valueOf(getPageContext().getString(r.j.top_rec_like_finish_a)) + this.dAf + getPageContext().getString(r.j.top_rec_like_finish_b));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
        } else {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
        }
        finish();
        com.baidu.tbadk.core.d.b.f(getPageContext().getPageActivity(), 1);
    }
}
