package com.baidu.tieba.slumdogMillionaire;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes3.dex */
public class SlumdogMillionaireChannelView extends LinearLayout implements View.OnClickListener {
    private TextView gBi;
    private TextView gBj;
    private TextView gBk;
    private TextView gBl;
    private TextView gBm;
    private com.baidu.tieba.r.a gBn;
    private Context mContext;
    private d mShareItem;
    private int mSkinType;

    public SlumdogMillionaireChannelView(Context context) {
        super(context);
        this.mSkinType = 3;
        init(context);
    }

    public SlumdogMillionaireChannelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        init(context);
    }

    public SlumdogMillionaireChannelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        LayoutInflater.from(context).inflate(d.i.slumdog_millionaire_channel, (ViewGroup) this, true);
        this.gBi = (TextView) findViewById(d.g.slumdog_millionaire_weixin);
        this.gBi.setTag(4);
        this.gBi.setOnClickListener(this);
        this.gBj = (TextView) findViewById(d.g.slumdog_millionaire_weixin_coterie);
        this.gBj.setTag(3);
        this.gBj.setOnClickListener(this);
        this.gBk = (TextView) findViewById(d.g.slumdog_millionaire_qq);
        this.gBk.setTag(9);
        this.gBk.setOnClickListener(this);
        this.gBl = (TextView) findViewById(d.g.slumdog_millionaire_qzone);
        this.gBl.setTag(5);
        this.gBl.setOnClickListener(this);
        this.gBm = (TextView) findViewById(d.g.slumdog_millionaire_weibo);
        this.gBm.setTag(7);
        this.gBm.setOnClickListener(this);
        onChangeSkinType();
    }

    public void setShareItemClickListener(com.baidu.tieba.r.a aVar) {
        this.gBn = aVar;
    }

    public void setShareData(com.baidu.tbadk.coreExtra.c.d dVar) {
        this.mShareItem = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gBn != null) {
            this.gBn.bw(view);
        }
        if (!j.jD()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
            return;
        }
        e eVar = new e(this.mContext, null);
        com.baidu.tbadk.coreExtra.c.d dVar = this.mShareItem;
        if (dVar != null) {
            if (!StringUtils.isNull(dVar.price)) {
                if (StringUtils.isNull(dVar.title)) {
                    dVar.title = String.format(this.mContext.getString(d.k.slumdog_millionaire_share_title_price_default), dVar.price);
                }
                if (StringUtils.isNull(dVar.content)) {
                    dVar.content = this.mContext.getString(d.k.slumdog_millionaire_share_content_price_default);
                }
            } else {
                if (StringUtils.isNull(dVar.title)) {
                    dVar.title = this.mContext.getString(d.k.slumdog_millionaire_share_title_normal_default);
                }
                if (StringUtils.isNull(dVar.content)) {
                    dVar.content = this.mContext.getString(d.k.slumdog_millionaire_share_content_normal_default);
                }
            }
            if (dVar.aFj == null) {
                dVar.aFj = Uri.parse("http://c.tieba.baidu.com/tb/cms/tieba-fe/baiwanfuweng.jpg");
            }
            if (view == this.gBi) {
                eVar.b(dVar);
            } else if (view == this.gBj) {
                dVar.content = "【" + dVar.title + "】 " + dVar.content;
                eVar.c(dVar);
            } else if (view == this.gBl) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    eVar.e(dVar);
                } else {
                    BdToast.a(this.mContext, this.mContext.getText(d.k.share_qq_not_install)).xi();
                }
            } else if (view == this.gBk) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    eVar.d(dVar);
                } else {
                    BdToast.a(this.mContext, this.mContext.getText(d.k.share_qq_not_install)).xi();
                }
            } else if (view == this.gBm) {
                eVar.g(dVar);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.h(this.gBi, d.C0141d.cp_cont_j);
            this.gBi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_weixin_n), (Drawable) null, (Drawable) null);
            al.h(this.gBj, d.C0141d.cp_cont_j);
            this.gBj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_weixin_q_n), (Drawable) null, (Drawable) null);
            al.h(this.gBk, d.C0141d.cp_cont_j);
            this.gBk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_qq_share_n), (Drawable) null, (Drawable) null);
            al.h(this.gBl, d.C0141d.cp_cont_j);
            this.gBl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_qq_zone_n), (Drawable) null, (Drawable) null);
            al.h(this.gBm, d.C0141d.cp_cont_j);
            this.gBm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, al.getDrawable(d.f.icon_sina_n), (Drawable) null, (Drawable) null);
        }
    }
}
