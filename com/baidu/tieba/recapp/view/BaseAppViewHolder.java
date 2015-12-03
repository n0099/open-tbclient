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
import com.baidu.tieba.tbadkCore.data.n;
/* loaded from: classes.dex */
public abstract class BaseAppViewHolder extends PbRecBaseViewHolder {
    protected int afY;
    private DownloadData bbi;
    protected TextView did;
    protected TextView die;
    protected TextView dif;
    protected TextView dig;
    protected HeadImageView dih;
    protected AppDownloadView dii;
    protected View dij;

    protected abstract void avZ();

    protected abstract int awa();

    public BaseAppViewHolder(View view) {
        super(view);
        this.bbi = new DownloadData();
        this.rootView = view;
        this.afY = TbadkCoreApplication.m411getInst().getSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(n nVar, int i) {
        if (this.dhH != null && this.dhH.rB() && nVar != null) {
            if (this.dhH.isApp()) {
                this.bbi.setId(nVar.getPkgName());
                this.bbi.setUrl(nVar.getDownloadUrl());
                this.bbi.setName(nVar.getAppName());
                this.bbi.setPosition(i);
                this.bbi.setNotifyId(0);
                int b = AppDownloadView.b(this.bbi);
                this.bbi.setStatus(b);
                this.dii.a(BdUniqueId.gen(), this.bbi);
                avZ();
                switch (b) {
                    case 1:
                        this.did.setText(n.i.downloading2);
                        break;
                    case 3:
                        this.did.setText(n.i.downloaded_install);
                        break;
                    case 6:
                        this.did.setText(awa());
                        break;
                    case 7:
                        this.did.setText(n.i.continue_download);
                        break;
                }
                this.did.setOnClickListener(d.avQ());
                this.rootView.setOnClickListener(a.avP());
            } else if (this.dhH.aCU()) {
                avZ();
                this.did.setText(n.i.view);
                this.did.setOnClickListener(g.avR());
                this.rootView.setOnClickListener(h.avS());
            }
        }
    }

    public com.baidu.tieba.tbadkCore.data.n getAppData() {
        return this.dhH;
    }

    public DownloadData getDownloadData() {
        return this.bbi;
    }

    public AppDownloadView getAppDownloadView() {
        return this.dii;
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
        com.baidu.tieba.recapp.a.avO().registerHolder(i, cls);
    }
}
