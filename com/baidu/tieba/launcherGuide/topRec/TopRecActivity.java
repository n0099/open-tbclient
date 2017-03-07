package com.baidu.tieba.launcherGuide.topRec;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tieba.launcherGuide.topRec.TRForumListData;
import com.baidu.tieba.launcherGuide.topRec.TopRecModel;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.w;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class TopRecActivity extends BaseActivity<TopRecActivity> {
    private LikeModel brY;
    private e dsc;
    private d dsd;
    private TopRecModel dse;
    private a dsf;
    private TRForumListData dsg;
    private List<a> dsi;
    private List<LikeModel> dsj;
    private int dsh = 0;
    private int dsk = 0;
    private TopRecModel.b dsl = new com.baidu.tieba.launcherGuide.topRec.a(this);
    private ab.b bVC = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData();
    }

    private void initUI() {
        this.dsc = new e(this);
        this.dsc.fN(true);
    }

    private void initData() {
        this.dsd = new d(this);
        this.dsc.a(this.dsd);
        this.dse = new TopRecModel(this);
        this.dse.a(this.dsl);
        this.dse.LoadData();
        this.dsi = new LinkedList();
        this.dsj = new LinkedList();
        this.dsc.b(this.bVC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(int i, int i2) {
        if (this.dsg != null && i < this.dsg.forum_list.length) {
            this.dsg.forum_list[i].is_like = 1;
            this.dsd.notifyDataSetChanged();
            this.dsh++;
            this.dsc.mn(this.dsh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(int i, int i2) {
        if (this.dsg != null && i < this.dsg.forum_list.length) {
            this.dsg.forum_list[i].is_like = 0;
            this.dsd.notifyDataSetChanged();
            if (this.dsh != 0) {
                this.dsh--;
            }
            this.dsc.mn(this.dsh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void axk() {
        this.dsk++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void axl() {
        if (this.dsk != 0) {
            this.dsk--;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int size = this.dsi.size();
        for (int i = 0; i < size; i++) {
            if (this.dsi.get(i) != null) {
                this.dsi.get(i).cancel();
            }
        }
        int size2 = this.dsj.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.dsj.get(i2) != null) {
                this.dsj.get(i2).bgM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dsd != null) {
            int axo = this.dsd.axo();
            if (axo != 0) {
                this.dsh += axo;
                this.dsk = axo + this.dsk;
                this.dsc.mn(this.dsh);
            }
            this.dsd.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dsc.onChangeSkinType(i);
        this.dsd.aZ(w.g.btn_add, w.g.btn_add_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mm(int i) {
        if (this.dsg == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.dsg.forum_list.length; i2++) {
            if (this.dsg.forum_list[i2].forum_id == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dsc.axp()) {
            this.dsd.axm();
            if (this.dsd.axn()) {
                this.dsc.axs();
            }
        } else if (view == this.dsc.axq()) {
            if (this.dsk != 0) {
                showToast(String.valueOf(getPageContext().getString(w.l.top_rec_like_finish_a)) + this.dsk + getPageContext().getString(w.l.total_num_bar));
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
            } else {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
            }
            finish();
            com.baidu.tbadk.core.e.b.i(getPageContext().getPageActivity(), 1);
        } else if (this.dsg != null && this.dsg.forum_list.length != 0) {
            int intValue = ((Integer) view.getTag()).intValue();
            int mm = mm(intValue);
            if (this.dsg.forum_list[mm].is_like == 1) {
                aY(mm, intValue);
                this.dsf = new a(this, null);
                this.dsi.add(this.dsf);
                this.dsf.setPriority(2);
                this.dsf.execute(Integer.valueOf(intValue));
                return;
            }
            this.brY = new LikeModel(getPageContext());
            if (!this.brY.bgN()) {
                this.dsj.add(this.brY);
                aX(mm, intValue);
                this.brY.setLoadDataCallBack(new c(this, mm, intValue));
                this.brY.setFrom("from_topRec");
                this.brY.bY(this.dsg.forum_list[mm].forum_name, String.valueOf(this.dsg.forum_list[mm].forum_id));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Integer, Integer, String> {
        TRForumListData.TRForum dsn;
        int id;
        private z mNetwork;
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
            this.position = TopRecActivity.this.mm(this.id);
            if (this.position >= 0) {
                this.dsn = TopRecActivity.this.dsg.forum_list[this.position];
            }
            try {
                if (this.dsn != null && this.dsn.forum_id != 0 && this.dsn.forum_name != null) {
                    this.mNetwork = new z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.mNetwork.n("fid", String.valueOf(this.dsn.forum_id));
                    this.mNetwork.n("kw", this.dsn.forum_name);
                    this.mNetwork.n("favo_type", "1");
                    this.mNetwork.n("st_type", "from_topRec");
                    this.mNetwork.uZ().vS().mIsNeedTbs = true;
                    this.mNetwork.uB();
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
            TopRecActivity.this.dsf = null;
            if (this.mNetwork == null) {
                TopRecActivity.this.aX(this.position, this.dsn.forum_id);
            } else if (!this.mNetwork.uZ().vT().isRequestSuccess()) {
                TopRecActivity.this.aX(this.position, this.dsn.forum_id);
            } else if (str == null) {
                TopRecActivity.this.aX(this.position, this.dsn.forum_id);
            } else {
                TbadkApplication.getInst().delLikeForum(this.dsn.forum_name);
                TopRecActivity.this.axl();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.fm();
                this.mNetwork = null;
            }
            TopRecActivity.this.dsc.fN(false);
            TopRecActivity.this.dsf = null;
            super.cancel(true);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.dsk != 0) {
            showToast(String.valueOf(getPageContext().getString(w.l.top_rec_like_finish_a)) + this.dsk + getPageContext().getString(w.l.total_num_bar));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
        } else {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
        }
        finish();
        com.baidu.tbadk.core.e.b.i(getPageContext().getPageActivity(), 1);
    }
}
