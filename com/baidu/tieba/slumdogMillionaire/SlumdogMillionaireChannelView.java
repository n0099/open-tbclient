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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes3.dex */
public class SlumdogMillionaireChannelView extends LinearLayout implements View.OnClickListener {
    private TextView gFb;
    private TextView gFc;
    private TextView gFd;
    private TextView gFe;
    private TextView gFf;
    private com.baidu.tieba.r.a gFg;
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
        this.gFb = (TextView) findViewById(d.g.slumdog_millionaire_weixin);
        this.gFb.setTag(4);
        this.gFb.setOnClickListener(this);
        this.gFc = (TextView) findViewById(d.g.slumdog_millionaire_weixin_coterie);
        this.gFc.setTag(3);
        this.gFc.setOnClickListener(this);
        this.gFd = (TextView) findViewById(d.g.slumdog_millionaire_qq);
        this.gFd.setTag(9);
        this.gFd.setOnClickListener(this);
        this.gFe = (TextView) findViewById(d.g.slumdog_millionaire_qzone);
        this.gFe.setTag(5);
        this.gFe.setOnClickListener(this);
        this.gFf = (TextView) findViewById(d.g.slumdog_millionaire_weibo);
        this.gFf.setTag(7);
        this.gFf.setOnClickListener(this);
        onChangeSkinType();
    }

    public void setShareItemClickListener(com.baidu.tieba.r.a aVar) {
        this.gFg = aVar;
    }

    public void setShareData(com.baidu.tbadk.coreExtra.c.d dVar) {
        this.mShareItem = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gFg != null) {
            this.gFg.bx(view);
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
            if (dVar.imageUri == null) {
                dVar.imageUri = Uri.parse("http://c.tieba.baidu.com/tb/cms/tieba-fe/baiwanfuweng.jpg");
            }
            if (view == this.gFb) {
                eVar.b(dVar);
            } else if (view == this.gFc) {
                dVar.content = "【" + dVar.title + "】 " + dVar.content;
                eVar.c(dVar);
            } else if (view == this.gFe) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    eVar.e(dVar);
                } else {
                    BdToast.a(this.mContext, this.mContext.getText(d.k.share_qq_not_install)).xv();
                }
            } else if (view == this.gFd) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    eVar.d(dVar);
                } else {
                    BdToast.a(this.mContext, this.mContext.getText(d.k.share_qq_not_install)).xv();
                }
            } else if (view == this.gFf) {
                eVar.g(dVar);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.h(this.gFb, d.C0142d.cp_cont_j);
            this.gFb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.icon_weixin_n), (Drawable) null, (Drawable) null);
            am.h(this.gFc, d.C0142d.cp_cont_j);
            this.gFc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.icon_weixin_q_n), (Drawable) null, (Drawable) null);
            am.h(this.gFd, d.C0142d.cp_cont_j);
            this.gFd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.icon_qq_share_n), (Drawable) null, (Drawable) null);
            am.h(this.gFe, d.C0142d.cp_cont_j);
            this.gFe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.icon_qq_zone_n), (Drawable) null, (Drawable) null);
            am.h(this.gFf, d.C0142d.cp_cont_j);
            this.gFf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.getDrawable(d.f.icon_sina_n), (Drawable) null, (Drawable) null);
        }
    }
}
