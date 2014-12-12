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
    protected int XE;
    protected TextView bLa;
    protected TextView bLb;
    protected TextView bLc;
    protected HeadImageView bLd;
    protected View bLe;

    protected abstract void abO();

    protected abstract void abP();

    protected abstract int abQ();

    public BaseAppViewHolder(View view) {
        this.rootView = view;
        this.XE = TbadkCoreApplication.m255getInst().getSkinType();
        view.setTag(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abN() {
        if (this.bKR != null && this.bKR.mu()) {
            boolean dS = b.uK().dS(this.bKR.getPkgName());
            boolean dT = b.uK().dT(this.bKR.getPkgName());
            if (dS) {
                this.bKR.hA(1);
            } else if (dT) {
                this.bKR.hA(2);
            } else {
                this.bKR.hA(0);
            }
            if (this.bKR.agM()) {
                switch (this.bKR.agL()) {
                    case 0:
                        abO();
                        this.bLa.setText(abQ());
                        this.bLa.setOnClickListener(d.abK());
                        this.rootView.setOnClickListener(a.abJ());
                        this.bLa.setEnabled(true);
                        return;
                    case 1:
                        abP();
                        this.bLa.setText(z.downloading2);
                        this.bLa.setOnClickListener(null);
                        this.rootView.setOnClickListener(null);
                        this.bLa.setEnabled(false);
                        return;
                    case 2:
                        abO();
                        this.bLa.setText(z.downloaded_install);
                        this.bLa.setOnClickListener(d.abK());
                        this.rootView.setOnClickListener(a.abJ());
                        this.bLa.setEnabled(true);
                        return;
                    default:
                        return;
                }
            } else if (this.bKR.agN()) {
                abO();
                this.bLa.setText(z.view);
                this.bLa.setOnClickListener(g.abL());
                this.rootView.setOnClickListener(h.abM());
            }
        }
    }

    public j getAppData() {
        return this.bKR;
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
        com.baidu.tieba.recapp.a.abI().registerHolder(i, cls);
    }
}
