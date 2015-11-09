package com.baidu.tieba.launcherGuide.topRec;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.p;
import com.baidu.tieba.i;
import com.baidu.tieba.launcherGuide.topRec.TRForumListData;
import com.baidu.tieba.launcherGuide.topRec.h;
import com.baidu.tieba.tbadkCore.w;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class TopRecActivity extends BaseActivity<TopRecActivity> {
    private w LU;
    private e bTg;
    private d bTh;
    private h bTi;
    private a bTj;
    private TRForumListData bTk;
    private List<a> bTm;
    private List<w> bTn;
    private int bTl = 0;
    private int bTo = 0;
    private h.b bTp = new com.baidu.tieba.launcherGuide.topRec.a(this);
    private p.a aUE = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData();
    }

    private void initUI() {
        this.bTg = new e(this);
        this.bTg.dd(true);
    }

    private void initData() {
        this.bTh = new d(this);
        this.bTg.a(this.bTh);
        this.bTi = new h(this);
        this.bTi.a(this.bTp);
        this.bTi.LoadData();
        this.bTm = new LinkedList();
        this.bTn = new LinkedList();
        this.bTg.b(this.aUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void as(int i, int i2) {
        if (this.bTk != null && i < this.bTk.forum_list.length) {
            this.bTk.forum_list[i].is_like = 1;
            this.bTh.notifyDataSetChanged();
            this.bTl++;
            this.bTg.il(this.bTl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void at(int i, int i2) {
        if (this.bTk != null && i < this.bTk.forum_list.length) {
            this.bTk.forum_list[i].is_like = 0;
            this.bTh.notifyDataSetChanged();
            if (this.bTl != 0) {
                this.bTl--;
            }
            this.bTg.il(this.bTl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void abg() {
        this.bTo++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void abh() {
        if (this.bTo != 0) {
            this.bTo--;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int size = this.bTm.size();
        for (int i = 0; i < size; i++) {
            if (this.bTm.get(i) != null) {
                this.bTm.get(i).cancel();
            }
        }
        int size2 = this.bTn.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.bTn.get(i2) != null) {
                this.bTn.get(i2).MQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bTh != null) {
            int abk = this.bTh.abk();
            if (abk != 0) {
                this.bTl += abk;
                this.bTo = abk + this.bTo;
                this.bTg.il(this.bTl);
            }
            this.bTh.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bTg.onChangeSkinType(i);
        this.bTh.au(i.e.btn_add, i.e.btn_add_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ik(int i) {
        if (this.bTk == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.bTk.forum_list.length; i2++) {
            if (this.bTk.forum_list[i2].forum_id == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bTg.abl()) {
            this.bTh.abi();
            if (this.bTh.abj()) {
                this.bTg.abo();
            }
        } else if (view == this.bTg.abm()) {
            if (this.bTo != 0) {
                showToast(String.valueOf(getPageContext().getString(i.h.top_rec_like_finish_a)) + this.bTo + getPageContext().getString(i.h.top_rec_like_finish_b));
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
            } else {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
            }
            finish();
            com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 1);
        } else if (this.bTk != null && this.bTk.forum_list.length != 0) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.bTk.forum_list.length != 0) {
                int ik = ik(intValue);
                if (this.bTk.forum_list[ik].is_like == 1) {
                    at(ik, intValue);
                    this.bTj = new a(this, null);
                    this.bTm.add(this.bTj);
                    this.bTj.setPriority(2);
                    this.bTj.execute(Integer.valueOf(intValue));
                    return;
                }
                this.LU = new w(getPageContext());
                if (!this.LU.awF()) {
                    this.bTn.add(this.LU);
                    as(ik, intValue);
                    this.LU.setLoadDataCallBack(new c(this, ik, intValue));
                    this.LU.setFrom("from_topRec");
                    this.LU.bd(this.bTk.forum_list[ik].forum_name, String.valueOf(this.bTk.forum_list[ik].forum_id));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Integer, Integer, String> {
        private com.baidu.tbadk.core.util.w afm;
        TRForumListData.TRForum bTr;
        int id;
        int position;

        private a() {
            this.afm = null;
            this.position = -1;
            this.id = 0;
        }

        /* synthetic */ a(TopRecActivity topRecActivity, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Integer... numArr) {
            this.id = numArr[0].intValue();
            this.position = TopRecActivity.this.ik(this.id);
            if (this.position >= 0) {
                this.bTr = TopRecActivity.this.bTk.forum_list[this.position];
            }
            try {
                if (this.bTr != null && this.bTr.forum_id != 0 && this.bTr.forum_name != null) {
                    this.afm = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.afm.o(ImageViewerConfig.FORUM_ID, String.valueOf(this.bTr.forum_id));
                    this.afm.o("kw", this.bTr.forum_name);
                    this.afm.o("favo_type", "1");
                    this.afm.o("st_type", "from_topRec");
                    this.afm.uh().uZ().mIsNeedTbs = true;
                    this.afm.tG();
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
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            TopRecActivity.this.bTj = null;
            if (this.afm == null) {
                TopRecActivity.this.as(this.position, this.bTr.forum_id);
            } else if (!this.afm.uh().va().qT()) {
                TopRecActivity.this.as(this.position, this.bTr.forum_id);
            } else if (str == null) {
                TopRecActivity.this.as(this.position, this.bTr.forum_id);
            } else {
                TbadkApplication.getInst().delLikeForum(this.bTr.forum_name);
                TopRecActivity.this.abh();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afm != null) {
                this.afm.gJ();
                this.afm = null;
            }
            TopRecActivity.this.bTg.dd(false);
            TopRecActivity.this.bTj = null;
            super.cancel(true);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.bTo != 0) {
            showToast(String.valueOf(getPageContext().getString(i.h.top_rec_like_finish_a)) + this.bTo + getPageContext().getString(i.h.top_rec_like_finish_b));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
        } else {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
        }
        finish();
        com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 1);
    }
}
