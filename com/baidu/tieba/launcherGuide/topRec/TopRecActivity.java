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
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.u;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class TopRecActivity extends BaseActivity<TopRecActivity> {
    private y DR;
    private e dmY;
    private d dmZ;
    private h dna;
    private a dnb;
    private TRForumListData dnc;
    private List<a> dne;
    private List<y> dnf;
    private int dnd = 0;
    private int dng = 0;
    private h.b dnh = new com.baidu.tieba.launcherGuide.topRec.a(this);
    private t.b bNN = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData();
    }

    private void initUI() {
        this.dmY = new e(this);
        this.dmY.fr(true);
    }

    private void initData() {
        this.dmZ = new d(this);
        this.dmY.a(this.dmZ);
        this.dna = new h(this);
        this.dna.a(this.dnh);
        this.dna.LoadData();
        this.dne = new LinkedList();
        this.dnf = new LinkedList();
        this.dmY.b(this.bNN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(int i, int i2) {
        if (this.dnc != null && i < this.dnc.forum_list.length) {
            this.dnc.forum_list[i].is_like = 1;
            this.dmZ.notifyDataSetChanged();
            this.dnd++;
            this.dmY.lU(this.dnd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(int i, int i2) {
        if (this.dnc != null && i < this.dnc.forum_list.length) {
            this.dnc.forum_list[i].is_like = 0;
            this.dmZ.notifyDataSetChanged();
            if (this.dnd != 0) {
                this.dnd--;
            }
            this.dmY.lU(this.dnd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void awn() {
        this.dng++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void awo() {
        if (this.dng != 0) {
            this.dng--;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int size = this.dne.size();
        for (int i = 0; i < size; i++) {
            if (this.dne.get(i) != null) {
                this.dne.get(i).cancel();
            }
        }
        int size2 = this.dnf.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.dnf.get(i2) != null) {
                this.dnf.get(i2).beD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dmZ != null) {
            int awr = this.dmZ.awr();
            if (awr != 0) {
                this.dnd += awr;
                this.dng = awr + this.dng;
                this.dmY.lU(this.dnd);
            }
            this.dmZ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dmY.onChangeSkinType(i);
        this.dmZ.aZ(u.f.btn_add, u.f.btn_add_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lT(int i) {
        if (this.dnc == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.dnc.forum_list.length; i2++) {
            if (this.dnc.forum_list[i2].forum_id == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dmY.aws()) {
            this.dmZ.awp();
            if (this.dmZ.awq()) {
                this.dmY.awv();
            }
        } else if (view == this.dmY.awt()) {
            if (this.dng != 0) {
                showToast(String.valueOf(getPageContext().getString(u.j.top_rec_like_finish_a)) + this.dng + getPageContext().getString(u.j.top_rec_like_finish_b));
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
            } else {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
            }
            finish();
            com.baidu.tbadk.core.d.b.d(getPageContext().getPageActivity(), 1);
        } else if (this.dnc != null && this.dnc.forum_list.length != 0) {
            int intValue = ((Integer) view.getTag()).intValue();
            int lT = lT(intValue);
            if (this.dnc.forum_list[lT].is_like == 1) {
                aY(lT, intValue);
                this.dnb = new a(this, null);
                this.dne.add(this.dnb);
                this.dnb.setPriority(2);
                this.dnb.execute(Integer.valueOf(intValue));
                return;
            }
            this.DR = new y(getPageContext());
            if (!this.DR.beE()) {
                this.dnf.add(this.DR);
                aX(lT, intValue);
                this.DR.setLoadDataCallBack(new c(this, lT, intValue));
                this.DR.setFrom("from_topRec");
                this.DR.bO(this.dnc.forum_list[lT].forum_name, String.valueOf(this.dnc.forum_list[lT].forum_id));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Integer, Integer, String> {
        private ab afX;
        TRForumListData.TRForum dnj;
        int id;
        int position;

        private a() {
            this.afX = null;
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
            this.position = TopRecActivity.this.lT(this.id);
            if (this.position >= 0) {
                this.dnj = TopRecActivity.this.dnc.forum_list[this.position];
            }
            try {
                if (this.dnj != null && this.dnj.forum_id != 0 && this.dnj.forum_name != null) {
                    this.afX = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.afX.n("fid", String.valueOf(this.dnj.forum_id));
                    this.afX.n("kw", this.dnj.forum_name);
                    this.afX.n("favo_type", "1");
                    this.afX.n("st_type", "from_topRec");
                    this.afX.tx().uu().mIsNeedTbs = true;
                    this.afX.sZ();
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
        /* renamed from: er */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            TopRecActivity.this.dnb = null;
            if (this.afX == null) {
                TopRecActivity.this.aX(this.position, this.dnj.forum_id);
            } else if (!this.afX.tx().uv().nJ()) {
                TopRecActivity.this.aX(this.position, this.dnj.forum_id);
            } else if (str == null) {
                TopRecActivity.this.aX(this.position, this.dnj.forum_id);
            } else {
                TbadkApplication.getInst().delLikeForum(this.dnj.forum_name);
                TopRecActivity.this.awo();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afX != null) {
                this.afX.dl();
                this.afX = null;
            }
            TopRecActivity.this.dmY.fr(false);
            TopRecActivity.this.dnb = null;
            super.cancel(true);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.dng != 0) {
            showToast(String.valueOf(getPageContext().getString(u.j.top_rec_like_finish_a)) + this.dng + getPageContext().getString(u.j.top_rec_like_finish_b));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
        } else {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
        }
        finish();
        com.baidu.tbadk.core.d.b.d(getPageContext().getPageActivity(), 1);
    }
}
