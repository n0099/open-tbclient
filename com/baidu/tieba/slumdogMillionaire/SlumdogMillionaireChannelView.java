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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes3.dex */
public class SlumdogMillionaireChannelView extends LinearLayout implements View.OnClickListener {
    private TextView gTl;
    private TextView gTm;
    private TextView gTn;
    private TextView gTo;
    private TextView gTp;
    private com.baidu.tieba.o.a gTq;
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
        LayoutInflater.from(context).inflate(d.h.slumdog_millionaire_channel, (ViewGroup) this, true);
        this.gTl = (TextView) findViewById(d.g.slumdog_millionaire_weixin);
        this.gTl.setTag(4);
        this.gTl.setOnClickListener(this);
        this.gTm = (TextView) findViewById(d.g.slumdog_millionaire_weixin_coterie);
        this.gTm.setTag(3);
        this.gTm.setOnClickListener(this);
        this.gTn = (TextView) findViewById(d.g.slumdog_millionaire_qq);
        this.gTn.setTag(9);
        this.gTn.setOnClickListener(this);
        this.gTo = (TextView) findViewById(d.g.slumdog_millionaire_qzone);
        this.gTo.setTag(5);
        this.gTo.setOnClickListener(this);
        this.gTp = (TextView) findViewById(d.g.slumdog_millionaire_weibo);
        this.gTp.setTag(7);
        this.gTp.setOnClickListener(this);
        onChangeSkinType();
    }

    public void setShareItemClickListener(com.baidu.tieba.o.a aVar) {
        this.gTq = aVar;
    }

    public void setShareData(com.baidu.tbadk.coreExtra.c.d dVar) {
        this.mShareItem = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gTq != null) {
            this.gTq.cN(view);
        }
        if (!j.oJ()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
            return;
        }
        e eVar = new e(this.mContext, null);
        com.baidu.tbadk.coreExtra.c.d dVar = this.mShareItem;
        if (dVar != null) {
            if (!StringUtils.isNull(dVar.price)) {
                if (StringUtils.isNull(dVar.title)) {
                    dVar.title = String.format(this.mContext.getString(d.j.slumdog_millionaire_share_title_price_default), dVar.price);
                }
                if (StringUtils.isNull(dVar.content)) {
                    dVar.content = this.mContext.getString(d.j.slumdog_millionaire_share_content_price_default);
                }
            } else {
                if (StringUtils.isNull(dVar.title)) {
                    dVar.title = this.mContext.getString(d.j.slumdog_millionaire_share_title_normal_default);
                }
                if (StringUtils.isNull(dVar.content)) {
                    dVar.content = this.mContext.getString(d.j.slumdog_millionaire_share_content_normal_default);
                }
            }
            if (dVar.blo == null) {
                dVar.blo = Uri.parse("http://c.tieba.baidu.com/tb/cms/tieba-fe/baiwanfuweng.jpg");
            }
            if (view == this.gTl) {
                eVar.b(dVar);
            } else if (view == this.gTm) {
                dVar.content = "【" + dVar.title + "】 " + dVar.content;
                eVar.c(dVar);
            } else if (view == this.gTo) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    eVar.e(dVar);
                } else {
                    BdToast.a(this.mContext, this.mContext.getText(d.j.share_qq_not_install)).Bc();
                }
            } else if (view == this.gTn) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    eVar.d(dVar);
                } else {
                    BdToast.a(this.mContext, this.mContext.getText(d.j.share_qq_not_install)).Bc();
                }
            } else if (view == this.gTp) {
                eVar.g(dVar);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            aj.r(this.gTl, d.C0141d.cp_cont_j);
            this.gTl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_weixin_n), (Drawable) null, (Drawable) null);
            aj.r(this.gTm, d.C0141d.cp_cont_j);
            this.gTm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_weixin_q_n), (Drawable) null, (Drawable) null);
            aj.r(this.gTn, d.C0141d.cp_cont_j);
            this.gTn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_qq_share_n), (Drawable) null, (Drawable) null);
            aj.r(this.gTo, d.C0141d.cp_cont_j);
            this.gTo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_qq_zone_n), (Drawable) null, (Drawable) null);
            aj.r(this.gTp, d.C0141d.cp_cont_j);
            this.gTp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_sina_n), (Drawable) null, (Drawable) null);
        }
    }
}
