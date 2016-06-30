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
    private y Dq;
    private e djZ;
    private d dka;
    private h dkb;
    private a dkc;
    private TRForumListData dkd;
    private List<a> dkf;
    private List<y> dkg;
    private int dke = 0;
    private int dkh = 0;
    private h.b dki = new com.baidu.tieba.launcherGuide.topRec.a(this);
    private t.b bMd = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        nl();
        initData();
    }

    private void nl() {
        this.djZ = new e(this);
        this.djZ.fp(true);
    }

    private void initData() {
        this.dka = new d(this);
        this.djZ.a(this.dka);
        this.dkb = new h(this);
        this.dkb.a(this.dki);
        this.dkb.LoadData();
        this.dkf = new LinkedList();
        this.dkg = new LinkedList();
        this.djZ.b(this.bMd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(int i, int i2) {
        if (this.dkd != null && i < this.dkd.forum_list.length) {
            this.dkd.forum_list[i].is_like = 1;
            this.dka.notifyDataSetChanged();
            this.dke++;
            this.djZ.lO(this.dke);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(int i, int i2) {
        if (this.dkd != null && i < this.dkd.forum_list.length) {
            this.dkd.forum_list[i].is_like = 0;
            this.dka.notifyDataSetChanged();
            if (this.dke != 0) {
                this.dke--;
            }
            this.djZ.lO(this.dke);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void avB() {
        this.dkh++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void avC() {
        if (this.dkh != 0) {
            this.dkh--;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int size = this.dkf.size();
        for (int i = 0; i < size; i++) {
            if (this.dkf.get(i) != null) {
                this.dkf.get(i).cancel();
            }
        }
        int size2 = this.dkg.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.dkg.get(i2) != null) {
                this.dkg.get(i2).bbp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dka != null) {
            int avF = this.dka.avF();
            if (avF != 0) {
                this.dke += avF;
                this.dkh = avF + this.dkh;
                this.djZ.lO(this.dke);
            }
            this.dka.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.djZ.onChangeSkinType(i);
        this.dka.aW(u.f.btn_add, u.f.btn_add_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lN(int i) {
        if (this.dkd == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.dkd.forum_list.length; i2++) {
            if (this.dkd.forum_list[i2].forum_id == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.djZ.avG()) {
            this.dka.avD();
            if (this.dka.avE()) {
                this.djZ.avJ();
            }
        } else if (view == this.djZ.avH()) {
            if (this.dkh != 0) {
                showToast(String.valueOf(getPageContext().getString(u.j.top_rec_like_finish_a)) + this.dkh + getPageContext().getString(u.j.top_rec_like_finish_b));
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
            } else {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
            }
            finish();
            com.baidu.tbadk.core.d.b.d(getPageContext().getPageActivity(), 1);
        } else if (this.dkd != null && this.dkd.forum_list.length != 0) {
            int intValue = ((Integer) view.getTag()).intValue();
            int lN = lN(intValue);
            if (this.dkd.forum_list[lN].is_like == 1) {
                aV(lN, intValue);
                this.dkc = new a(this, null);
                this.dkf.add(this.dkc);
                this.dkc.setPriority(2);
                this.dkc.execute(Integer.valueOf(intValue));
                return;
            }
            this.Dq = new y(getPageContext());
            if (!this.Dq.bbq()) {
                this.dkg.add(this.Dq);
                aU(lN, intValue);
                this.Dq.setLoadDataCallBack(new c(this, lN, intValue));
                this.Dq.setFrom("from_topRec");
                this.Dq.bJ(this.dkd.forum_list[lN].forum_name, String.valueOf(this.dkd.forum_list[lN].forum_id));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Integer, Integer, String> {
        private ab afj;
        TRForumListData.TRForum dkk;
        int id;
        int position;

        private a() {
            this.afj = null;
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
            this.position = TopRecActivity.this.lN(this.id);
            if (this.position >= 0) {
                this.dkk = TopRecActivity.this.dkd.forum_list[this.position];
            }
            try {
                if (this.dkk != null && this.dkk.forum_id != 0 && this.dkk.forum_name != null) {
                    this.afj = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.afj.n("fid", String.valueOf(this.dkk.forum_id));
                    this.afj.n("kw", this.dkk.forum_name);
                    this.afj.n("favo_type", "1");
                    this.afj.n("st_type", "from_topRec");
                    this.afj.ty().uu().mIsNeedTbs = true;
                    this.afj.ta();
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
        /* renamed from: es */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            TopRecActivity.this.dkc = null;
            if (this.afj == null) {
                TopRecActivity.this.aU(this.position, this.dkk.forum_id);
            } else if (!this.afj.ty().uv().nU()) {
                TopRecActivity.this.aU(this.position, this.dkk.forum_id);
            } else if (str == null) {
                TopRecActivity.this.aU(this.position, this.dkk.forum_id);
            } else {
                TbadkApplication.getInst().delLikeForum(this.dkk.forum_name);
                TopRecActivity.this.avC();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afj != null) {
                this.afj.dm();
                this.afj = null;
            }
            TopRecActivity.this.djZ.fp(false);
            TopRecActivity.this.dkc = null;
            super.cancel(true);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.dkh != 0) {
            showToast(String.valueOf(getPageContext().getString(u.j.top_rec_like_finish_a)) + this.dkh + getPageContext().getString(u.j.top_rec_like_finish_b));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
        } else {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
        }
        finish();
        com.baidu.tbadk.core.d.b.d(getPageContext().getPageActivity(), 1);
    }
}
