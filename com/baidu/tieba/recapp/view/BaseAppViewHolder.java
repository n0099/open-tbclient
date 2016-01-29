package com.baidu.tieba.recapp.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
import com.baidu.tieba.recapp.a.a;
import com.baidu.tieba.recapp.a.d;
import com.baidu.tieba.recapp.a.g;
import com.baidu.tieba.recapp.a.h;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
public abstract class BaseAppViewHolder extends PbRecBaseViewHolder {
    protected int ahU;
    private DownloadData bhI;
    protected TextView dCO;
    protected TextView dCP;
    protected TextView dCQ;
    protected TextView dCR;
    protected HeadImageView dCS;
    protected AppDownloadView dCT;
    protected View dCU;

    protected abstract void aEP();

    protected abstract int aEQ();

    public BaseAppViewHolder(View view) {
        super(view);
        this.bhI = new DownloadData();
        this.azA = view;
        this.ahU = TbadkCoreApplication.m411getInst().getSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(q qVar, int i) {
        if (this.dCq != null && this.dCq.rM() && qVar != null) {
            if (this.dCq.isApp()) {
                this.bhI.setId(qVar.getPkgName());
                this.bhI.setUrl(qVar.getDownloadUrl());
                this.bhI.setName(qVar.getAppName());
                this.bhI.setPosition(i);
                this.bhI.setNotifyId(0);
                int b = AppDownloadView.b(this.bhI);
                this.bhI.setStatus(b);
                this.dCT.a(BdUniqueId.gen(), this.bhI);
                aEP();
                switch (b) {
                    case 1:
                        this.dCO.setText(t.j.downloading2);
                        break;
                    case 3:
                        this.dCO.setText(t.j.downloaded_install);
                        break;
                    case 6:
                        this.dCO.setText(aEQ());
                        break;
                    case 7:
                        this.dCO.setText(t.j.continue_download);
                        break;
                }
                this.dCO.setOnClickListener(d.aEG());
                this.azA.setOnClickListener(a.aEF());
            } else if (this.dCq.aMn()) {
                aEP();
                this.dCO.setText(t.j.view);
                this.dCO.setOnClickListener(g.aEH());
                this.azA.setOnClickListener(h.aEI());
            }
        }
    }

    public q getAppData() {
        return this.dCq;
    }

    public DownloadData getDownloadData() {
        return this.bhI;
    }

    public AppDownloadView getAppDownloadView() {
        return this.dCT;
    }

    public String getFixedChineseString(String str) {
        if (!StringUtils.isNull(str)) {
            String replaceAll = str.replaceAll("，", "， ").replaceAll("。", "。 ").replaceAll("？", "？ ").replaceAll("！", "！ ").replaceAll("、", "、 ").replaceAll("‘", "’ ").replaceAll("“", "” ").replaceAll("【", "【 ").replaceAll("】", "】 ").replaceAll("；", "； ").replaceAll("：", "： ").replaceAll("（", "（ ").replaceAll("）", "） ").replaceAll("·", "· ").replaceAll(" ", "  ");
            if (replaceAll.charAt(replaceAll.length() - 1) == ' ') {
                replaceAll = replaceAll.substring(0, replaceAll.length() - 1);
            }
            return replaceAll;
        }
        return str;
    }

    public static void registerHolder(int i, Class<? extends BaseAppViewHolder> cls) {
        com.baidu.tieba.recapp.a.aEE().registerHolder(i, cls);
    }
}
