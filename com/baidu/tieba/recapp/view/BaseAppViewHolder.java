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
    protected int Yh;
    protected TextView bMK;
    protected TextView bML;
    protected TextView bMM;
    protected HeadImageView bMN;
    protected View bMO;

    protected abstract void acn();

    protected abstract void aco();

    protected abstract int acp();

    public BaseAppViewHolder(View view) {
        this.rootView = view;
        this.Yh = TbadkCoreApplication.m255getInst().getSkinType();
        view.setTag(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void acm() {
        if (this.bMB != null && this.bMB.mn()) {
            boolean dO = b.uV().dO(this.bMB.getPkgName());
            boolean dP = b.uV().dP(this.bMB.getPkgName());
            if (dO) {
                this.bMB.hJ(1);
            } else if (dP) {
                this.bMB.hJ(2);
            } else {
                this.bMB.hJ(0);
            }
            if (this.bMB.ahm()) {
                switch (this.bMB.ahl()) {
                    case 0:
                        acn();
                        this.bMK.setText(acp());
                        this.bMK.setOnClickListener(d.acj());
                        this.rootView.setOnClickListener(a.aci());
                        this.bMK.setEnabled(true);
                        return;
                    case 1:
                        aco();
                        this.bMK.setText(z.downloading2);
                        this.bMK.setOnClickListener(null);
                        this.rootView.setOnClickListener(null);
                        this.bMK.setEnabled(false);
                        return;
                    case 2:
                        acn();
                        this.bMK.setText(z.downloaded_install);
                        this.bMK.setOnClickListener(d.acj());
                        this.rootView.setOnClickListener(a.aci());
                        this.bMK.setEnabled(true);
                        return;
                    default:
                        return;
                }
            } else if (this.bMB.ahn()) {
                acn();
                this.bMK.setText(z.view);
                this.bMK.setOnClickListener(g.ack());
                this.rootView.setOnClickListener(h.acl());
            }
        }
    }

    public j getAppData() {
        return this.bMB;
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
        com.baidu.tieba.recapp.a.ach().registerHolder(i, cls);
    }
}
