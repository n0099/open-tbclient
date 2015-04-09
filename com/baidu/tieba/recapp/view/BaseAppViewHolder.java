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
import com.baidu.tieba.tbadkCore.c.i;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public abstract class BaseAppViewHolder extends PbRecBaseViewHolder {
    protected int aiy;
    protected TextView bXI;
    protected TextView bXJ;
    protected TextView bXK;
    protected HeadImageView bXL;
    protected View bXM;

    protected abstract void afJ();

    protected abstract void afK();

    protected abstract int afL();

    public BaseAppViewHolder(View view) {
        super(view);
        this.rootView = view;
        this.aiy = TbadkCoreApplication.m411getInst().getSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afI() {
        if (this.bXz != null && this.bXz.pO()) {
            boolean ea = b.yr().ea(this.bXz.getPkgName());
            boolean eb = b.yr().eb(this.bXz.getPkgName());
            if (ea) {
                this.bXz.in(1);
            } else if (eb) {
                this.bXz.in(2);
            } else {
                this.bXz.in(0);
            }
            if (this.bXz.amI()) {
                switch (this.bXz.amH()) {
                    case 0:
                        afJ();
                        this.bXI.setText(afL());
                        this.bXI.setOnClickListener(d.afF());
                        this.rootView.setOnClickListener(a.afE());
                        this.bXI.setEnabled(true);
                        return;
                    case 1:
                        afK();
                        this.bXI.setText(y.downloading2);
                        this.bXI.setOnClickListener(null);
                        this.rootView.setOnClickListener(null);
                        this.bXI.setEnabled(false);
                        return;
                    case 2:
                        afJ();
                        this.bXI.setText(y.downloaded_install);
                        this.bXI.setOnClickListener(d.afF());
                        this.rootView.setOnClickListener(a.afE());
                        this.bXI.setEnabled(true);
                        return;
                    default:
                        return;
                }
            } else if (this.bXz.amJ()) {
                afJ();
                this.bXI.setText(y.view);
                this.bXI.setOnClickListener(g.afG());
                this.rootView.setOnClickListener(h.afH());
            }
        }
    }

    public i getAppData() {
        return this.bXz;
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
        com.baidu.tieba.recapp.a.afD().registerHolder(i, cls);
    }
}
