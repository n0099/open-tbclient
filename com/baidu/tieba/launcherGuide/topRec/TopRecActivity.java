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
    private w LS;
    private e bSA;
    private d bSB;
    private h bSC;
    private a bSD;
    private TRForumListData bSE;
    private List<a> bSG;
    private List<w> bSH;
    private int bSF = 0;
    private int bSI = 0;
    private h.b bSJ = new com.baidu.tieba.launcherGuide.topRec.a(this);
    private p.a aUl = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData();
    }

    private void initUI() {
        this.bSA = new e(this);
        this.bSA.db(true);
    }

    private void initData() {
        this.bSB = new d(this);
        this.bSA.a(this.bSB);
        this.bSC = new h(this);
        this.bSC.a(this.bSJ);
        this.bSC.LoadData();
        this.bSG = new LinkedList();
        this.bSH = new LinkedList();
        this.bSA.b(this.aUl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aq(int i, int i2) {
        if (this.bSE != null && i < this.bSE.forum_list.length) {
            this.bSE.forum_list[i].is_like = 1;
            this.bSB.notifyDataSetChanged();
            this.bSF++;
            this.bSA.hX(this.bSF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ar(int i, int i2) {
        if (this.bSE != null && i < this.bSE.forum_list.length) {
            this.bSE.forum_list[i].is_like = 0;
            this.bSB.notifyDataSetChanged();
            if (this.bSF != 0) {
                this.bSF--;
            }
            this.bSA.hX(this.bSF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aaP() {
        this.bSI++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aaQ() {
        if (this.bSI != 0) {
            this.bSI--;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int size = this.bSG.size();
        for (int i = 0; i < size; i++) {
            if (this.bSG.get(i) != null) {
                this.bSG.get(i).cancel();
            }
        }
        int size2 = this.bSH.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.bSH.get(i2) != null) {
                this.bSH.get(i2).ME();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bSB != null) {
            int aaT = this.bSB.aaT();
            if (aaT != 0) {
                this.bSF += aaT;
                this.bSI = aaT + this.bSI;
                this.bSA.hX(this.bSF);
            }
            this.bSB.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bSA.onChangeSkinType(i);
        this.bSB.as(i.e.btn_add, i.e.btn_add_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int hW(int i) {
        if (this.bSE == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.bSE.forum_list.length; i2++) {
            if (this.bSE.forum_list[i2].forum_id == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bSA.aaU()) {
            this.bSB.aaR();
            if (this.bSB.aaS()) {
                this.bSA.aaX();
            }
        } else if (view == this.bSA.aaV()) {
            if (this.bSI != 0) {
                showToast(String.valueOf(getPageContext().getString(i.h.top_rec_like_finish_a)) + this.bSI + getPageContext().getString(i.h.top_rec_like_finish_b));
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
            } else {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
            }
            finish();
            com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 1);
        } else if (this.bSE != null && this.bSE.forum_list.length != 0) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.bSE.forum_list.length != 0) {
                int hW = hW(intValue);
                if (this.bSE.forum_list[hW].is_like == 1) {
                    ar(hW, intValue);
                    this.bSD = new a(this, null);
                    this.bSG.add(this.bSD);
                    this.bSD.setPriority(2);
                    this.bSD.execute(Integer.valueOf(intValue));
                    return;
                }
                this.LS = new w(getPageContext());
                if (!this.LS.avT()) {
                    this.bSH.add(this.LS);
                    aq(hW, intValue);
                    this.LS.setLoadDataCallBack(new c(this, hW, intValue));
                    this.LS.setFrom("from_topRec");
                    this.LS.be(this.bSE.forum_list[hW].forum_name, String.valueOf(this.bSE.forum_list[hW].forum_id));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Integer, Integer, String> {
        private com.baidu.tbadk.core.util.w afg;
        TRForumListData.TRForum bSL;
        int id;
        int position;

        private a() {
            this.afg = null;
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
                this.bSL = TopRecActivity.this.bSE.forum_list[this.position];
            }
            try {
                if (this.bSL != null && this.bSL.forum_id != 0 && this.bSL.forum_name != null) {
                    this.afg = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.UNFAVOLIKE_ADDRESS);
                    this.afg.o(ImageViewerConfig.FORUM_ID, String.valueOf(this.bSL.forum_id));
                    this.afg.o("kw", this.bSL.forum_name);
                    this.afg.o("favo_type", "1");
                    this.afg.o("st_type", "from_topRec");
                    this.afg.uh().uX().mIsNeedTbs = true;
                    this.afg.tG();
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
            TopRecActivity.this.bSD = null;
            if (this.afg == null) {
                TopRecActivity.this.aq(this.position, this.bSL.forum_id);
            } else if (!this.afg.uh().uY().qV()) {
                TopRecActivity.this.aq(this.position, this.bSL.forum_id);
            } else if (str == null) {
                TopRecActivity.this.aq(this.position, this.bSL.forum_id);
            } else {
                TbadkApplication.getInst().delLikeForum(this.bSL.forum_name);
                TopRecActivity.this.aaQ();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.afg != null) {
                this.afg.gJ();
                this.afg = null;
            }
            TopRecActivity.this.bSA.db(false);
            TopRecActivity.this.bSD = null;
            super.cancel(true);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.bSI != 0) {
            showToast(String.valueOf(getPageContext().getString(i.h.top_rec_like_finish_a)) + this.bSI + getPageContext().getString(i.h.top_rec_like_finish_b));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
        } else {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
        }
        finish();
        com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 1);
    }
}
