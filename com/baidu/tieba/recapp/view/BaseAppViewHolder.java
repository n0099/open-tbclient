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
    protected int aiq;
    protected TextView bXs;
    protected TextView bXt;
    protected TextView bXu;
    protected HeadImageView bXv;
    protected View bXw;

    protected abstract void afu();

    protected abstract void afv();

    protected abstract int afw();

    public BaseAppViewHolder(View view) {
        super(view);
        this.rootView = view;
        this.aiq = TbadkCoreApplication.m411getInst().getSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aft() {
        if (this.bXj != null && this.bXj.pO()) {
            boolean dX = b.yl().dX(this.bXj.getPkgName());
            boolean dY = b.yl().dY(this.bXj.getPkgName());
            if (dX) {
                this.bXj.ik(1);
            } else if (dY) {
                this.bXj.ik(2);
            } else {
                this.bXj.ik(0);
            }
            if (this.bXj.amt()) {
                switch (this.bXj.ams()) {
                    case 0:
                        afu();
                        this.bXs.setText(afw());
                        this.bXs.setOnClickListener(d.afq());
                        this.rootView.setOnClickListener(a.afp());
                        this.bXs.setEnabled(true);
                        return;
                    case 1:
                        afv();
                        this.bXs.setText(y.downloading2);
                        this.bXs.setOnClickListener(null);
                        this.rootView.setOnClickListener(null);
                        this.bXs.setEnabled(false);
                        return;
                    case 2:
                        afu();
                        this.bXs.setText(y.downloaded_install);
                        this.bXs.setOnClickListener(d.afq());
                        this.rootView.setOnClickListener(a.afp());
                        this.bXs.setEnabled(true);
                        return;
                    default:
                        return;
                }
            } else if (this.bXj.amu()) {
                afu();
                this.bXs.setText(y.view);
                this.bXs.setOnClickListener(g.afr());
                this.rootView.setOnClickListener(h.afs());
            }
        }
    }

    public i getAppData() {
        return this.bXj;
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
        com.baidu.tieba.recapp.a.afo().registerHolder(i, cls);
    }
}
