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
    private w LT;
    private e bSL;
    private d bSM;
    private h bSN;
    private a bSO;
    private TRForumListData bSP;
    private List<a> bSR;
    private List<w> bSS;
    private int bSQ = 0;
    private int bST = 0;
    private h.b bSU = new com.baidu.tieba.launcherGuide.topRec.a(this);
    private p.a aUw = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData();
    }

    private void initUI() {
        this.bSL = new e(this);
        this.bSL.db(true);
    }

    private void initData() {
        this.bSM = new d(this);
        this.bSL.a(this.bSM);
        this.bSN = new h(this);
        this.bSN.a(this.bSU);
        this.bSN.LoadData();
        this.bSR = new LinkedList();
        this.bSS = new LinkedList();
        this.bSL.b(this.aUw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aq(int i, int i2) {
        if (this.bSP != null && i < this.bSP.forum_list.length) {
            this.bSP.forum_list[i].is_like = 1;
            this.bSM.notifyDataSetChanged();
            this.bSQ++;
            this.bSL.hX(this.bSQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ar(int i, int i2) {
        if (this.bSP != null && i < this.bSP.forum_list.length) {
            this.bSP.forum_list[i].is_like = 0;
            this.bSM.notifyDataSetChanged();
            if (this.bSQ != 0) {
                this.bSQ--;
            }
            this.bSL.hX(this.bSQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aaL() {
        this.bST++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aaM() {
        if (this.bST != 0) {
            this.bST--;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int size = this.bSR.size();
        for (int i = 0; i < size; i++) {
            if (this.bSR.get(i) != null) {
                this.bSR.get(i).cancel();
            }
        }
        int size2 = this.bSS.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.bSS.get(i2) != null) {
                this.bSS.get(i2).MA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bSM != null) {
            int aaP = this.bSM.aaP();
            if (aaP != 0) {
                this.bSQ += aaP;
                this.bST = aaP + this.bST;
                this.bSL.hX(this.bSQ);
            }
            this.bSM.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bSL.onChangeSkinType(i);
        this.bSM.as(i.e.btn_add, i.e.btn_add_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int hW(int i) {
        if (this.bSP == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.bSP.forum_list.length; i2++) {
            if (this.bSP.forum_list[i2].forum_id == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bSL.aaQ()) {
            this.bSM.aaN();
            if (this.bSM.aaO()) {
                this.bSL.aaT();
            }
        } else if (view == this.bSL.aaR()) {
            if (this.bST != 0) {
                showToast(String.valueOf(getPageContext().getString(i.h.top_rec_like_finish_a)) + this.bST + getPageContext().getString(i.h.top_rec_like_finish_b));
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
            } else {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
            }
            finish();
            com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 1);
        } else if (this.bSP != null && this.bSP.forum_list.length != 0) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.bSP.forum_list.length != 0) {
                int hW = hW(intValue);
                if (this.bSP.forum_list[hW].is_like == 1) {
                    ar(hW, intValue);
                    this.bSO = new a(this, null);
                    this.bSR.add(this.bSO);
                    this.bSO.setPriority(2);
                    this.bSO.execute(Integer.valueOf(intValue));
                    return;
                }
                this.LT = new w(getPageContext());
                if (!this.LT.avX()) {
                    this.bSS.add(this.LT);
                    aq(hW, intValue);
                    this.LT.setLoadDataCallBack(new c(this, hW, intValue));
                    this.LT.setFrom("from_topRec");
                    this.LT.be(this.bSP.forum_list[hW].forum_name, String.valueOf(this.bSP.forum_list[hW].forum_id));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Integer, Integer, String> {
        private com.baidu.tbadk.core.util.w afh;
        TRForumListData.TRForum bSW;
        int id;
        int position;

        private a() {
            this.afh = null;
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
            this.position = TopRecActivity.this.hW(this.id);
            if (this.position >= 0) {
                this.bSW = TopRecActivity.this.bSP.forum_list[this.position];
            }
            try {
                if (this.bSW != null && this.bSW.forum_id != 0 && this.bSW.forum_name != null) {
                    this.afh = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.afh.o(ImageViewerConfig.FORUM_ID, String.valueOf(this.bSW.forum_id));
                    this.afh.o("kw", this.bSW.forum_name);
                    this.afh.o("favo_type", "1");
                    this.afh.o("st_type", "from_topRec");
                    this.afh.ue().uV().mIsNeedTbs = true;
                    this.afh.tD();
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
            TopRecActivity.this.bSO = null;
            if (this.afh == null) {
                TopRecActivity.this.aq(this.position, this.bSW.forum_id);
            } else if (!this.afh.ue().uW().qS()) {
                TopRecActivity.this.aq(this.position, this.bSW.forum_id);
            } else if (str == null) {
                TopRecActivity.this.aq(this.position, this.bSW.forum_id);
            } else {
                TbadkApplication.getInst().delLikeForum(this.bSW.forum_name);
                TopRecActivity.this.aaM();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afh != null) {
                this.afh.gJ();
                this.afh = null;
            }
            TopRecActivity.this.bSL.db(false);
            TopRecActivity.this.bSO = null;
            super.cancel(true);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.bST != 0) {
            showToast(String.valueOf(getPageContext().getString(i.h.top_rec_like_finish_a)) + this.bST + getPageContext().getString(i.h.top_rec_like_finish_b));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
        } else {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
        }
        finish();
        com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 1);
    }
}
