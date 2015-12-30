package com.baidu.tieba.recapp.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.n;
import com.baidu.tieba.recapp.PbRecBaseViewHolder;
import com.baidu.tieba.recapp.a.a;
import com.baidu.tieba.recapp.a.d;
import com.baidu.tieba.recapp.a.g;
import com.baidu.tieba.recapp.a.h;
import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
public abstract class BaseAppViewHolder extends PbRecBaseViewHolder {
    protected int ahf;
    private DownloadData bfh;
    protected TextView dnK;
    protected TextView dnL;
    protected TextView dnM;
    protected TextView dnN;
    protected HeadImageView dnO;
    protected AppDownloadView dnP;
    protected View dnQ;

    protected abstract void axS();

    protected abstract int axT();

    public BaseAppViewHolder(View view) {
        super(view);
        this.bfh = new DownloadData();
        this.rootView = view;
        this.ahf = TbadkCoreApplication.m411getInst().getSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(q qVar, int i) {
        if (this.dnn != null && this.dnn.rk() && qVar != null) {
            if (this.dnn.isApp()) {
                this.bfh.setId(qVar.getPkgName());
                this.bfh.setUrl(qVar.getDownloadUrl());
                this.bfh.setName(qVar.getAppName());
                this.bfh.setPosition(i);
                this.bfh.setNotifyId(0);
                int b = AppDownloadView.b(this.bfh);
                this.bfh.setStatus(b);
                this.dnP.a(BdUniqueId.gen(), this.bfh);
                axS();
                switch (b) {
                    case 1:
                        this.dnK.setText(n.j.downloading2);
                        break;
                    case 3:
                        this.dnK.setText(n.j.downloaded_install);
                        break;
                    case 6:
                        this.dnK.setText(axT());
                        break;
                    case 7:
                        this.dnK.setText(n.j.continue_download);
                        break;
                }
                this.dnK.setOnClickListener(d.axJ());
                this.rootView.setOnClickListener(a.axI());
            } else if (this.dnn.aFh()) {
                axS();
                this.dnK.setText(n.j.view);
                this.dnK.setOnClickListener(g.axK());
                this.rootView.setOnClickListener(h.axL());
            }
        }
    }

    public q getAppData() {
        return this.dnn;
    }

    public DownloadData getDownloadData() {
        return this.bfh;
    }

    public AppDownloadView getAppDownloadView() {
        return this.dnP;
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
        com.baidu.tieba.recapp.a.axH().registerHolder(i, cls);
    }
}
