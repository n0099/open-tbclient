package com.baidu.tieba.recapp.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.b;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
import com.baidu.tieba.recapp.a.a;
import com.baidu.tieba.recapp.a.d;
import com.baidu.tieba.recapp.a.g;
import com.baidu.tieba.recapp.a.h;
import com.baidu.tieba.tbadkCore.b.j;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public abstract class BaseAppViewHolder extends PbRecBaseViewHolder {
    protected int Yk;
    protected TextView bML;
    protected TextView bMM;
    protected TextView bMN;
    protected HeadImageView bMO;
    protected View bMP;

    protected abstract void acs();

    protected abstract void act();

    protected abstract int acu();

    public BaseAppViewHolder(View view) {
        this.rootView = view;
        this.Yk = TbadkCoreApplication.m255getInst().getSkinType();
        view.setTag(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acr() {
        if (this.bMC != null && this.bMC.mu()) {
            boolean dR = b.vb().dR(this.bMC.getPkgName());
            boolean dS = b.vb().dS(this.bMC.getPkgName());
            if (dR) {
                this.bMC.hJ(1);
            } else if (dS) {
                this.bMC.hJ(2);
            } else {
                this.bMC.hJ(0);
            }
            if (this.bMC.ahr()) {
                switch (this.bMC.ahq()) {
                    case 0:
                        acs();
                        this.bML.setText(acu());
                        this.bML.setOnClickListener(d.aco());
                        this.rootView.setOnClickListener(a.acn());
                        this.bML.setEnabled(true);
                        return;
                    case 1:
                        act();
                        this.bML.setText(z.downloading2);
                        this.bML.setOnClickListener(null);
                        this.rootView.setOnClickListener(null);
                        this.bML.setEnabled(false);
                        return;
                    case 2:
                        acs();
                        this.bML.setText(z.downloaded_install);
                        this.bML.setOnClickListener(d.aco());
                        this.rootView.setOnClickListener(a.acn());
                        this.bML.setEnabled(true);
                        return;
                    default:
                        return;
                }
            } else if (this.bMC.ahs()) {
                acs();
                this.bML.setText(z.view);
                this.bML.setOnClickListener(g.acp());
                this.rootView.setOnClickListener(h.acq());
            }
        }
    }

    public j getAppData() {
        return this.bMC;
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
        com.baidu.tieba.recapp.a.acm().registerHolder(i, cls);
    }
}
