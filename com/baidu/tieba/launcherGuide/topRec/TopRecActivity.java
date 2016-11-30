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
import com.baidu.tieba.tbadkCore.x;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class TopRecActivity extends BaseActivity<TopRecActivity> {
    private x Gg;
    private e dFB;
    private d dFC;
    private h dFD;
    private a dFE;
    private TRForumListData dFF;
    private List<a> dFH;
    private List<x> dFI;
    private int dFG = 0;
    private int dFJ = 0;
    private h.b dFK = new com.baidu.tieba.launcherGuide.topRec.a(this);
    private z.b ccA = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData();
    }

    private void initUI() {
        this.dFB = new e(this);
        this.dFB.gk(true);
    }

    private void initData() {
        this.dFC = new d(this);
        this.dFB.a(this.dFC);
        this.dFD = new h(this);
        this.dFD.a(this.dFK);
        this.dFD.LoadData();
        this.dFH = new LinkedList();
        this.dFI = new LinkedList();
        this.dFB.b(this.ccA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(int i, int i2) {
        if (this.dFF != null && i < this.dFF.forum_list.length) {
            this.dFF.forum_list[i].is_like = 1;
            this.dFC.notifyDataSetChanged();
            this.dFG++;
            this.dFB.mN(this.dFG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(int i, int i2) {
        if (this.dFF != null && i < this.dFF.forum_list.length) {
            this.dFF.forum_list[i].is_like = 0;
            this.dFC.notifyDataSetChanged();
            if (this.dFG != 0) {
                this.dFG--;
            }
            this.dFB.mN(this.dFG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aDu() {
        this.dFJ++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aDv() {
        if (this.dFJ != 0) {
            this.dFJ--;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int size = this.dFH.size();
        for (int i = 0; i < size; i++) {
            if (this.dFH.get(i) != null) {
                this.dFH.get(i).cancel();
            }
        }
        int size2 = this.dFI.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.dFI.get(i2) != null) {
                this.dFI.get(i2).blu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dFC != null) {
            int aDy = this.dFC.aDy();
            if (aDy != 0) {
                this.dFG += aDy;
                this.dFJ = aDy + this.dFJ;
                this.dFB.mN(this.dFG);
            }
            this.dFC.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dFB.onChangeSkinType(i);
        this.dFC.bg(r.f.btn_add, r.f.btn_add_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mM(int i) {
        if (this.dFF == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.dFF.forum_list.length; i2++) {
            if (this.dFF.forum_list[i2].forum_id == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dFB.aDz()) {
            this.dFC.aDw();
            if (this.dFC.aDx()) {
                this.dFB.aDC();
            }
        } else if (view == this.dFB.aDA()) {
            if (this.dFJ != 0) {
                showToast(String.valueOf(getPageContext().getString(r.j.top_rec_like_finish_a)) + this.dFJ + getPageContext().getString(r.j.top_rec_like_finish_b));
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
            } else {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
            }
            finish();
            com.baidu.tbadk.core.d.b.f(getPageContext().getPageActivity(), 1);
        } else if (this.dFF != null && this.dFF.forum_list.length != 0) {
            int intValue = ((Integer) view.getTag()).intValue();
            int mM = mM(intValue);
            if (this.dFF.forum_list[mM].is_like == 1) {
                bf(mM, intValue);
                this.dFE = new a(this, null);
                this.dFH.add(this.dFE);
                this.dFE.setPriority(2);
                this.dFE.execute(Integer.valueOf(intValue));
                return;
            }
            this.Gg = new x(getPageContext());
            if (!this.Gg.blv()) {
                this.dFI.add(this.Gg);
                be(mM, intValue);
                this.Gg.setLoadDataCallBack(new c(this, mM, intValue));
                this.Gg.setFrom("from_topRec");
                this.Gg.bS(this.dFF.forum_list[mM].forum_name, String.valueOf(this.dFF.forum_list[mM].forum_id));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Integer, Integer, String> {
        private com.baidu.tbadk.core.util.z ajm;
        TRForumListData.TRForum dFM;
        int id;
        int position;

        private a() {
            this.ajm = null;
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
            this.position = TopRecActivity.this.mM(this.id);
            if (this.position >= 0) {
                this.dFM = TopRecActivity.this.dFF.forum_list[this.position];
            }
            try {
                if (this.dFM != null && this.dFM.forum_id != 0 && this.dFM.forum_name != null) {
                    this.ajm = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.ajm.n("fid", String.valueOf(this.dFM.forum_id));
                    this.ajm.n("kw", this.dFM.forum_name);
                    this.ajm.n("favo_type", "1");
                    this.ajm.n("st_type", "from_topRec");
                    this.ajm.uW().vR().mIsNeedTbs = true;
                    this.ajm.uy();
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
        /* renamed from: ez */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            TopRecActivity.this.dFE = null;
            if (this.ajm == null) {
                TopRecActivity.this.be(this.position, this.dFM.forum_id);
            } else if (!this.ajm.uW().vS().oH()) {
                TopRecActivity.this.be(this.position, this.dFM.forum_id);
            } else if (str == null) {
                TopRecActivity.this.be(this.position, this.dFM.forum_id);
            } else {
                TbadkApplication.getInst().delLikeForum(this.dFM.forum_name);
                TopRecActivity.this.aDv();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.ajm != null) {
                this.ajm.eg();
                this.ajm = null;
            }
            TopRecActivity.this.dFB.gk(false);
            TopRecActivity.this.dFE = null;
            super.cancel(true);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.dFJ != 0) {
            showToast(String.valueOf(getPageContext().getString(r.j.top_rec_like_finish_a)) + this.dFJ + getPageContext().getString(r.j.top_rec_like_finish_b));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
        } else {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
        }
        finish();
        com.baidu.tbadk.core.d.b.f(getPageContext().getPageActivity(), 1);
    }
}
