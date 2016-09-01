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
    private x Ge;
    private e dyG;
    private d dyH;
    private h dyI;
    private a dyJ;
    private TRForumListData dyK;
    private List<a> dyM;
    private List<x> dyN;
    private int dyL = 0;
    private int dyO = 0;
    private h.b dyP = new com.baidu.tieba.launcherGuide.topRec.a(this);
    private t.b bZh = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData();
    }

    private void initUI() {
        this.dyG = new e(this);
        this.dyG.fN(true);
    }

    private void initData() {
        this.dyH = new d(this);
        this.dyG.a(this.dyH);
        this.dyI = new h(this);
        this.dyI.a(this.dyP);
        this.dyI.LoadData();
        this.dyM = new LinkedList();
        this.dyN = new LinkedList();
        this.dyG.b(this.bZh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(int i, int i2) {
        if (this.dyK != null && i < this.dyK.forum_list.length) {
            this.dyK.forum_list[i].is_like = 1;
            this.dyH.notifyDataSetChanged();
            this.dyL++;
            this.dyG.mx(this.dyL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(int i, int i2) {
        if (this.dyK != null && i < this.dyK.forum_list.length) {
            this.dyK.forum_list[i].is_like = 0;
            this.dyH.notifyDataSetChanged();
            if (this.dyL != 0) {
                this.dyL--;
            }
            this.dyG.mx(this.dyL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aBa() {
        this.dyO++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aBb() {
        if (this.dyO != 0) {
            this.dyO--;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int size = this.dyM.size();
        for (int i = 0; i < size; i++) {
            if (this.dyM.get(i) != null) {
                this.dyM.get(i).cancel();
            }
        }
        int size2 = this.dyN.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.dyN.get(i2) != null) {
                this.dyN.get(i2).bij();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dyH != null) {
            int aBe = this.dyH.aBe();
            if (aBe != 0) {
                this.dyL += aBe;
                this.dyO = aBe + this.dyO;
                this.dyG.mx(this.dyL);
            }
            this.dyH.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dyG.onChangeSkinType(i);
        this.dyH.bd(t.f.btn_add, t.f.btn_add_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mw(int i) {
        if (this.dyK == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.dyK.forum_list.length; i2++) {
            if (this.dyK.forum_list[i2].forum_id == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dyG.aBf()) {
            this.dyH.aBc();
            if (this.dyH.aBd()) {
                this.dyG.aBi();
            }
        } else if (view == this.dyG.aBg()) {
            if (this.dyO != 0) {
                showToast(String.valueOf(getPageContext().getString(t.j.top_rec_like_finish_a)) + this.dyO + getPageContext().getString(t.j.top_rec_like_finish_b));
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
            } else {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
            }
            finish();
            com.baidu.tbadk.core.d.b.f(getPageContext().getPageActivity(), 1);
        } else if (this.dyK != null && this.dyK.forum_list.length != 0) {
            int intValue = ((Integer) view.getTag()).intValue();
            int mw = mw(intValue);
            if (this.dyK.forum_list[mw].is_like == 1) {
                bc(mw, intValue);
                this.dyJ = new a(this, null);
                this.dyM.add(this.dyJ);
                this.dyJ.setPriority(2);
                this.dyJ.execute(Integer.valueOf(intValue));
                return;
            }
            this.Ge = new x(getPageContext());
            if (!this.Ge.bik()) {
                this.dyN.add(this.Ge);
                bb(mw, intValue);
                this.Ge.setLoadDataCallBack(new c(this, mw, intValue));
                this.Ge.setFrom("from_topRec");
                this.Ge.bP(this.dyK.forum_list[mw].forum_name, String.valueOf(this.dyK.forum_list[mw].forum_id));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Integer, Integer, String> {
        private ab aiS;
        TRForumListData.TRForum dyR;
        int id;
        int position;

        private a() {
            this.aiS = null;
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
            this.position = TopRecActivity.this.mw(this.id);
            if (this.position >= 0) {
                this.dyR = TopRecActivity.this.dyK.forum_list[this.position];
            }
            try {
                if (this.dyR != null && this.dyR.forum_id != 0 && this.dyR.forum_name != null) {
                    this.aiS = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.aiS.n("fid", String.valueOf(this.dyR.forum_id));
                    this.aiS.n("kw", this.dyR.forum_name);
                    this.aiS.n("favo_type", "1");
                    this.aiS.n("st_type", "from_topRec");
                    this.aiS.uD().vz().mIsNeedTbs = true;
                    this.aiS.ue();
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
        /* renamed from: eu */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            TopRecActivity.this.dyJ = null;
            if (this.aiS == null) {
                TopRecActivity.this.bb(this.position, this.dyR.forum_id);
            } else if (!this.aiS.uD().vA().oE()) {
                TopRecActivity.this.bb(this.position, this.dyR.forum_id);
            } else if (str == null) {
                TopRecActivity.this.bb(this.position, this.dyR.forum_id);
            } else {
                TbadkApplication.getInst().delLikeForum(this.dyR.forum_name);
                TopRecActivity.this.aBb();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.aiS != null) {
                this.aiS.eg();
                this.aiS = null;
            }
            TopRecActivity.this.dyG.fN(false);
            TopRecActivity.this.dyJ = null;
            super.cancel(true);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.dyO != 0) {
            showToast(String.valueOf(getPageContext().getString(t.j.top_rec_like_finish_a)) + this.dyO + getPageContext().getString(t.j.top_rec_like_finish_b));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
        } else {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
        }
        finish();
        com.baidu.tbadk.core.d.b.f(getPageContext().getPageActivity(), 1);
    }
}
