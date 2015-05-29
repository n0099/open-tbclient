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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.data.i;
/* loaded from: classes.dex */
public abstract class BaseAppViewHolder extends PbRecBaseViewHolder {
    protected int ajy;
    protected TextView cbl;
    protected TextView cbm;
    protected TextView cbn;
    protected HeadImageView cbo;
    protected View cbp;

    protected abstract void ahn();

    protected abstract void aho();

    protected abstract int ahp();

    public BaseAppViewHolder(View view) {
        super(view);
        this.rootView = view;
        this.ajy = TbadkCoreApplication.m411getInst().getSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ahm() {
        if (this.cbc != null && this.cbc.qu()) {
            boolean er = b.ze().er(this.cbc.getPkgName());
            boolean es = b.ze().es(this.cbc.getPkgName());
            if (er) {
                this.cbc.iJ(1);
            } else if (es) {
                this.cbc.iJ(2);
            } else {
                this.cbc.iJ(0);
            }
            if (this.cbc.aou()) {
                switch (this.cbc.aot()) {
                    case 0:
                        ahn();
                        this.cbl.setText(ahp());
                        this.cbl.setOnClickListener(d.ahj());
                        this.rootView.setOnClickListener(a.ahi());
                        this.cbl.setEnabled(true);
                        return;
                    case 1:
                        aho();
                        this.cbl.setText(t.downloading2);
                        this.cbl.setOnClickListener(null);
                        this.rootView.setOnClickListener(null);
                        this.cbl.setEnabled(false);
                        return;
                    case 2:
                        ahn();
                        this.cbl.setText(t.downloaded_install);
                        this.cbl.setOnClickListener(d.ahj());
                        this.rootView.setOnClickListener(a.ahi());
                        this.cbl.setEnabled(true);
                        return;
                    default:
                        return;
                }
            } else if (this.cbc.aov()) {
                ahn();
                this.cbl.setText(t.view);
                this.cbl.setOnClickListener(g.ahk());
                this.rootView.setOnClickListener(h.ahl());
            }
        }
    }

    public i getAppData() {
        return this.cbc;
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
        com.baidu.tieba.recapp.a.ahh().registerHolder(i, cls);
    }
}
