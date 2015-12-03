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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.launcherGuide.topRec.TRForumListData;
import com.baidu.tieba.launcherGuide.topRec.h;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.x;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class TopRecActivity extends BaseActivity<TopRecActivity> {
    private x Ml;
    private List<a> cjA;
    private List<x> cjB;
    private e cju;
    private d cjv;
    private h cjw;
    private a cjx;
    private TRForumListData cjy;
    private int cjz = 0;
    private int cjC = 0;
    private h.b cjD = new com.baidu.tieba.launcherGuide.topRec.a(this);
    private q.a aZS = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData();
    }

    private void initUI() {
        this.cju = new e(this);
        this.cju.dz(true);
    }

    private void initData() {
        this.cjv = new d(this);
        this.cju.a(this.cjv);
        this.cjw = new h(this);
        this.cjw.a(this.cjD);
        this.cjw.LoadData();
        this.cjA = new LinkedList();
        this.cjB = new LinkedList();
        this.cju.b(this.aZS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void au(int i, int i2) {
        if (this.cjy != null && i < this.cjy.forum_list.length) {
            this.cjy.forum_list[i].is_like = 1;
            this.cjv.notifyDataSetChanged();
            this.cjz++;
            this.cju.jf(this.cjz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void av(int i, int i2) {
        if (this.cjy != null && i < this.cjy.forum_list.length) {
            this.cjy.forum_list[i].is_like = 0;
            this.cjv.notifyDataSetChanged();
            if (this.cjz != 0) {
                this.cjz--;
            }
            this.cju.jf(this.cjz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aeM() {
        this.cjC++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aeN() {
        if (this.cjC != 0) {
            this.cjC--;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int size = this.cjA.size();
        for (int i = 0; i < size; i++) {
            if (this.cjA.get(i) != null) {
                this.cjA.get(i).cancel();
            }
        }
        int size2 = this.cjB.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.cjB.get(i2) != null) {
                this.cjB.get(i2).Op();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cjv != null) {
            int aeQ = this.cjv.aeQ();
            if (aeQ != 0) {
                this.cjz += aeQ;
                this.cjC = aeQ + this.cjC;
                this.cju.jf(this.cjz);
            }
            this.cjv.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cju.onChangeSkinType(i);
        this.cjv.aw(n.e.btn_add, n.e.btn_add_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int je(int i) {
        if (this.cjy == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.cjy.forum_list.length; i2++) {
            if (this.cjy.forum_list[i2].forum_id == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.cju.aeR()) {
            this.cjv.aeO();
            if (this.cjv.aeP()) {
                this.cju.aeU();
            }
        } else if (view == this.cju.aeS()) {
            if (this.cjC != 0) {
                showToast(String.valueOf(getPageContext().getString(n.i.top_rec_like_finish_a)) + this.cjC + getPageContext().getString(n.i.top_rec_like_finish_b));
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
            } else {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
            }
            finish();
            com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 1);
        } else if (this.cjy != null && this.cjy.forum_list.length != 0) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.cjy.forum_list.length != 0) {
                int je = je(intValue);
                if (this.cjy.forum_list[je].is_like == 1) {
                    av(je, intValue);
                    this.cjx = new a(this, null);
                    this.cjA.add(this.cjx);
                    this.cjx.setPriority(2);
                    this.cjx.execute(Integer.valueOf(intValue));
                    return;
                }
                this.Ml = new x(getPageContext());
                if (!this.Ml.aCq()) {
                    this.cjB.add(this.Ml);
                    au(je, intValue);
                    this.Ml.setLoadDataCallBack(new c(this, je, intValue));
                    this.Ml.setFrom("from_topRec");
                    this.Ml.bg(this.cjy.forum_list[je].forum_name, String.valueOf(this.cjy.forum_list[je].forum_id));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Integer, Integer, String> {
        private ab agS;
        TRForumListData.TRForum cjF;
        int id;
        int position;

        private a() {
            this.agS = null;
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
            this.position = TopRecActivity.this.je(this.id);
            if (this.position >= 0) {
                this.cjF = TopRecActivity.this.cjy.forum_list[this.position];
            }
            try {
                if (this.cjF != null && this.cjF.forum_id != 0 && this.cjF.forum_name != null) {
                    this.agS = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.agS.o(ImageViewerConfig.FORUM_ID, String.valueOf(this.cjF.forum_id));
                    this.agS.o("kw", this.cjF.forum_name);
                    this.agS.o("favo_type", "1");
                    this.agS.o("st_type", "from_topRec");
                    this.agS.uM().vF().mIsNeedTbs = true;
                    this.agS.ul();
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
            TopRecActivity.this.cjx = null;
            if (this.agS == null) {
                TopRecActivity.this.au(this.position, this.cjF.forum_id);
            } else if (!this.agS.uM().vG().rf()) {
                TopRecActivity.this.au(this.position, this.cjF.forum_id);
            } else if (str == null) {
                TopRecActivity.this.au(this.position, this.cjF.forum_id);
            } else {
                TbadkApplication.getInst().delLikeForum(this.cjF.forum_name);
                TopRecActivity.this.aeN();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.agS != null) {
                this.agS.gL();
                this.agS = null;
            }
            TopRecActivity.this.cju.dz(false);
            TopRecActivity.this.cjx = null;
            super.cancel(true);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.cjC != 0) {
            showToast(String.valueOf(getPageContext().getString(n.i.top_rec_like_finish_a)) + this.cjC + getPageContext().getString(n.i.top_rec_like_finish_b));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
        } else {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
        }
        finish();
        com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 1);
    }
}
