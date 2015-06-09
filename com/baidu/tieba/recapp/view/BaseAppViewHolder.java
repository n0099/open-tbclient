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
    protected TextView cbm;
    protected TextView cbn;
    protected TextView cbo;
    protected HeadImageView cbp;
    protected View cbq;

    protected abstract void aho();

    protected abstract void ahp();

    protected abstract int ahq();

    public BaseAppViewHolder(View view) {
        super(view);
        this.rootView = view;
        this.ajy = TbadkCoreApplication.m411getInst().getSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ahn() {
        if (this.cbd != null && this.cbd.qu()) {
            boolean er = b.zf().er(this.cbd.getPkgName());
            boolean es = b.zf().es(this.cbd.getPkgName());
            if (er) {
                this.cbd.iJ(1);
            } else if (es) {
                this.cbd.iJ(2);
            } else {
                this.cbd.iJ(0);
            }
            if (this.cbd.aov()) {
                switch (this.cbd.aou()) {
                    case 0:
                        aho();
                        this.cbm.setText(ahq());
                        this.cbm.setOnClickListener(d.ahk());
                        this.rootView.setOnClickListener(a.ahj());
                        this.cbm.setEnabled(true);
                        return;
                    case 1:
                        ahp();
                        this.cbm.setText(t.downloading2);
                        this.cbm.setOnClickListener(null);
                        this.rootView.setOnClickListener(null);
                        this.cbm.setEnabled(false);
                        return;
                    case 2:
                        aho();
                        this.cbm.setText(t.downloaded_install);
                        this.cbm.setOnClickListener(d.ahk());
                        this.rootView.setOnClickListener(a.ahj());
                        this.cbm.setEnabled(true);
                        return;
                    default:
                        return;
                }
            } else if (this.cbd.aow()) {
                aho();
                this.cbm.setText(t.view);
                this.cbm.setOnClickListener(g.ahl());
                this.rootView.setOnClickListener(h.ahm());
            }
        }
    }

    public i getAppData() {
        return this.cbd;
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
        com.baidu.tieba.recapp.a.ahi().registerHolder(i, cls);
    }
}
