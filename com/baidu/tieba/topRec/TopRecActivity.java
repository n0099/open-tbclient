package com.baidu.tieba.topRec;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.TopRecActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.v;
import com.baidu.tieba.z;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class TopRecActivity extends BaseActivity<TopRecActivity> {
    private g ccB;
    private e ccC;
    private j ccD;
    private d ccE;
    private TRForumListData ccF;
    private List<d> ccH;
    private List<ac> ccI;
    private ac zm;
    private int ccG = 0;
    private int ccJ = 0;
    private l ccK = new a(this);
    private com.baidu.adp.widget.ListView.g aza = new b(this);

    static {
        TbadkApplication.getInst().RegisterIntent(TopRecActivityConfig.class, TopRecActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData();
    }

    private void initUI() {
        this.ccB = new g(this);
        this.ccB.cR(true);
    }

    private void initData() {
        this.ccC = new e(this);
        this.ccB.a(this.ccC);
        this.ccD = new j(this);
        this.ccD.a(this.ccK);
        this.ccD.LoadData();
        this.ccH = new LinkedList();
        this.ccI = new LinkedList();
        this.ccB.b(this.aza);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ah(int i, int i2) {
        if (this.ccF != null && i < this.ccF.forum_list.length) {
            this.ccF.forum_list[i].is_like = 1;
            this.ccC.notifyDataSetChanged();
            this.ccG++;
            this.ccB.il(this.ccG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ai(int i, int i2) {
        if (this.ccF != null && i < this.ccF.forum_list.length) {
            this.ccF.forum_list[i].is_like = 0;
            this.ccC.notifyDataSetChanged();
            if (this.ccG != 0) {
                this.ccG--;
            }
            this.ccB.il(this.ccG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ajv() {
        this.ccJ++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ajw() {
        if (this.ccJ != 0) {
            this.ccJ--;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int size = this.ccH.size();
        for (int i = 0; i < size; i++) {
            if (this.ccH.get(i) != null) {
                this.ccH.get(i).cancel();
            }
        }
        int size2 = this.ccI.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.ccI.get(i2) != null) {
                this.ccI.get(i2).GZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.ccC != null) {
            int ajz = this.ccC.ajz();
            if (ajz != 0) {
                this.ccG += ajz;
                this.ccJ = ajz + this.ccJ;
                this.ccB.il(this.ccG);
            }
            this.ccC.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ccB.onChangeSkinType(i);
        this.ccC.I(v.btn_add, v.btn_add_end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ik(int i) {
        if (this.ccF == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.ccF.forum_list.length; i2++) {
            if (this.ccF.forum_list[i2].forum_id == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ccB.ajA()) {
            this.ccC.ajx();
            if (this.ccC.ajy()) {
                this.ccB.ajD();
            }
        } else if (view == this.ccB.ajB()) {
            if (this.ccJ != 0) {
                showToast(String.valueOf(getPageContext().getString(z.top_rec_like_finish_a)) + this.ccJ + getPageContext().getString(z.top_rec_like_finish_b));
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
            } else {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
            }
            finish();
            com.baidu.tbadk.core.b.b.e(getPageContext().getPageActivity(), 1);
        } else if (this.ccF != null && this.ccF.forum_list.length != 0) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.ccF.forum_list.length != 0) {
                int ik = ik(intValue);
                if (this.ccF.forum_list[ik].is_like == 1) {
                    ai(ik, intValue);
                    this.ccE = new d(this, null);
                    this.ccH.add(this.ccE);
                    this.ccE.setPriority(2);
                    this.ccE.execute(Integer.valueOf(intValue));
                    return;
                }
                this.zm = new ac(getPageContext());
                if (!this.zm.aeB()) {
                    this.ccI.add(this.zm);
                    ah(ik, intValue);
                    this.zm.setLoadDataCallBack(new c(this, ik, intValue));
                    this.zm.setFrom("from_topRec");
                    this.zm.aN(this.ccF.forum_list[ik].forum_name, String.valueOf(this.ccF.forum_list[ik].forum_id));
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.ccJ != 0) {
            showToast(String.valueOf(getPageContext().getString(z.top_rec_like_finish_a)) + this.ccJ + getPageContext().getString(z.top_rec_like_finish_b));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_have_like", "people_number", 1, new Object[0]);
        } else {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "top_rec_no_like", "people_number", 1, new Object[0]);
        }
        finish();
        com.baidu.tbadk.core.b.b.e(getPageContext().getPageActivity(), 1);
    }
}
