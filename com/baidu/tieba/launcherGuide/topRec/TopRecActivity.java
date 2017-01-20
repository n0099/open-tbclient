package com.baidu.tieba.launcherGuide.topRec;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tieba.launcherGuide.topRec.TRForumListData;
import com.baidu.tieba.launcherGuide.topRec.TopRecModel;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.LikeModel;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class TopRecActivity extends BaseActivity<TopRecActivity> {
    private LikeModel Fq;
    private e dpJ;
    private d dpK;
    private TopRecModel dpL;
    private a dpM;
    private TRForumListData dpN;
    private List<a> dpP;
    private List<LikeModel> dpQ;
    private int dpO = 0;
    private int dpR = 0;
    private TopRecModel.b dpS = new com.baidu.tieba.launcherGuide.topRec.a(this);
    private aa.b bOu = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData();
    }

    private void initUI() {
        this.dpJ = new e(this);
        this.dpJ.fX(true);
    }

    private void initData() {
        this.dpK = new d(this);
        this.dpJ.a(this.dpK);
        this.dpL = new TopRecModel(this);
        this.dpL.a(this.dpS);
        this.dpL.LoadData();
        this.dpP = new LinkedList();
        this.dpQ = new LinkedList();
        this.dpJ.b(this.bOu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(int i, int i2) {
        if (this.dpN != null && i < this.dpN.forum_list.length) {
            this.dpN.forum_list[i].is_like = 1;
            this.dpK.notifyDataSetChanged();
            this.dpO++;
            this.dpJ.mx(this.dpO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(int i, int i2) {
        if (this.dpN != null && i < this.dpN.forum_list.length) {
            this.dpN.forum_list[i].is_like = 0;
            this.dpK.notifyDataSetChanged();
            if (this.dpO != 0) {
                this.dpO--;
            }
            this.dpJ.mx(this.dpO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void axO() {
        this.dpR++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void axP() {
        if (this.dpR != 0) {
            this.dpR--;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int size = this.dpP.size();
        for (int i = 0; i < size; i++) {
            if (this.dpP.get(i) != null) {
                this.dpP.get(i).cancel();
            }
        }
        int size2 = this.dpQ.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.dpQ.get(i2) != null) {
                this.dpQ.get(i2).bgZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dpK != null) {
            int axS = this.dpK.axS();
            if (axS != 0) {
                this.dpO += axS;
                this.dpR = axS + this.dpR;
                this.dpJ.mx(this.dpO);
            }
            this.dpK.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dpJ.onChangeSkinType(i);
        this.dpK.aV(r.g.btn_add, r.g.btn_add_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mw(int i) {
        if (this.dpN == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.dpN.forum_list.length; i2++) {
            if (this.dpN.forum_list[i2].forum_id == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dpJ.axT()) {
            this.dpK.axQ();
            if (this.dpK.axR()) {
                this.dpJ.axW();
            }
        } else if (view == this.dpJ.axU()) {
            if (this.dpR != 0) {
                showToast(String.valueOf(getPageContext().getString(r.l.top_rec_like_finish_a)) + this.dpR + getPageContext().getString(r.l.total_num_bar));
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
            } else {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
            }
            finish();
            com.baidu.tbadk.core.e.b.g(getPageContext().getPageActivity(), 1);
        } else if (this.dpN != null && this.dpN.forum_list.length != 0) {
            int intValue = ((Integer) view.getTag()).intValue();
            int mw = mw(intValue);
            if (this.dpN.forum_list[mw].is_like == 1) {
                aU(mw, intValue);
                this.dpM = new a(this, null);
                this.dpP.add(this.dpM);
                this.dpM.setPriority(2);
                this.dpM.execute(Integer.valueOf(intValue));
                return;
            }
            this.Fq = new LikeModel(getPageContext());
            if (!this.Fq.bha()) {
                this.dpQ.add(this.Fq);
                aT(mw, intValue);
                this.Fq.setLoadDataCallBack(new c(this, mw, intValue));
                this.Fq.setFrom("from_topRec");
                this.Fq.ce(this.dpN.forum_list[mw].forum_name, String.valueOf(this.dpN.forum_list[mw].forum_id));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Integer, Integer, String> {
        TRForumListData.TRForum dpU;
        int id;
        private y mNetwork;
        int position;

        private a() {
            this.mNetwork = null;
            this.position = -1;
            this.id = 0;
        }

        /* synthetic */ a(TopRecActivity topRecActivity, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            this.id = numArr[0].intValue();
            this.position = TopRecActivity.this.mw(this.id);
            if (this.position >= 0) {
                this.dpU = TopRecActivity.this.dpN.forum_list[this.position];
            }
            try {
                if (this.dpU != null && this.dpU.forum_id != 0 && this.dpU.forum_name != null) {
                    this.mNetwork = new y(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.mNetwork.n("fid", String.valueOf(this.dpU.forum_id));
                    this.mNetwork.n("kw", this.dpU.forum_name);
                    this.mNetwork.n("favo_type", "1");
                    this.mNetwork.n("st_type", "from_topRec");
                    this.mNetwork.uC().vv().mIsNeedTbs = true;
                    this.mNetwork.ud();
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
            TopRecActivity.this.dpM = null;
            if (this.mNetwork == null) {
                TopRecActivity.this.aT(this.position, this.dpU.forum_id);
            } else if (!this.mNetwork.uC().vw().isRequestSuccess()) {
                TopRecActivity.this.aT(this.position, this.dpU.forum_id);
            } else if (str == null) {
                TopRecActivity.this.aT(this.position, this.dpU.forum_id);
            } else {
                TbadkApplication.getInst().delLikeForum(this.dpU.forum_name);
                TopRecActivity.this.axP();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.ee();
                this.mNetwork = null;
            }
            TopRecActivity.this.dpJ.fX(false);
            TopRecActivity.this.dpM = null;
            super.cancel(true);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.dpR != 0) {
            showToast(String.valueOf(getPageContext().getString(r.l.top_rec_like_finish_a)) + this.dpR + getPageContext().getString(r.l.total_num_bar));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
        } else {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
        }
        finish();
        com.baidu.tbadk.core.e.b.g(getPageContext().getPageActivity(), 1);
    }
}
