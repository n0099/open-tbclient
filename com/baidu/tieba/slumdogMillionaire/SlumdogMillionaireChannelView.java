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
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes3.dex */
public class SlumdogMillionaireChannelView extends LinearLayout implements View.OnClickListener {
    private TextView gTB;
    private TextView gTC;
    private TextView gTD;
    private TextView gTE;
    private TextView gTF;
    private com.baidu.tieba.o.a gTG;
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
        this.gTB = (TextView) findViewById(d.g.slumdog_millionaire_weixin);
        this.gTB.setTag(4);
        this.gTB.setOnClickListener(this);
        this.gTC = (TextView) findViewById(d.g.slumdog_millionaire_weixin_coterie);
        this.gTC.setTag(3);
        this.gTC.setOnClickListener(this);
        this.gTD = (TextView) findViewById(d.g.slumdog_millionaire_qq);
        this.gTD.setTag(9);
        this.gTD.setOnClickListener(this);
        this.gTE = (TextView) findViewById(d.g.slumdog_millionaire_qzone);
        this.gTE.setTag(5);
        this.gTE.setOnClickListener(this);
        this.gTF = (TextView) findViewById(d.g.slumdog_millionaire_weibo);
        this.gTF.setTag(7);
        this.gTF.setOnClickListener(this);
        onChangeSkinType();
    }

    public void setShareItemClickListener(com.baidu.tieba.o.a aVar) {
        this.gTG = aVar;
    }

    public void setShareData(com.baidu.tbadk.coreExtra.c.d dVar) {
        this.mShareItem = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gTG != null) {
            this.gTG.cN(view);
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
            if (dVar.blr == null) {
                dVar.blr = Uri.parse("http://c.tieba.baidu.com/tb/cms/tieba-fe/baiwanfuweng.jpg");
            }
            if (view == this.gTB) {
                eVar.b(dVar);
            } else if (view == this.gTC) {
                dVar.content = "【" + dVar.title + "】 " + dVar.content;
                eVar.c(dVar);
            } else if (view == this.gTE) {
                if (v.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    eVar.e(dVar);
                } else {
                    BdToast.a(this.mContext, this.mContext.getText(d.j.share_qq_not_install)).Bd();
                }
            } else if (view == this.gTD) {
                if (v.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    eVar.d(dVar);
                } else {
                    BdToast.a(this.mContext, this.mContext.getText(d.j.share_qq_not_install)).Bd();
                }
            } else if (view == this.gTF) {
                eVar.g(dVar);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            aj.r(this.gTB, d.C0141d.cp_cont_j);
            this.gTB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_weixin_n), (Drawable) null, (Drawable) null);
            aj.r(this.gTC, d.C0141d.cp_cont_j);
            this.gTC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_weixin_q_n), (Drawable) null, (Drawable) null);
            aj.r(this.gTD, d.C0141d.cp_cont_j);
            this.gTD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_qq_share_n), (Drawable) null, (Drawable) null);
            aj.r(this.gTE, d.C0141d.cp_cont_j);
            this.gTE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_qq_zone_n), (Drawable) null, (Drawable) null);
            aj.r(this.gTF, d.C0141d.cp_cont_j);
            this.gTF.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.getDrawable(d.f.icon_sina_n), (Drawable) null, (Drawable) null);
        }
    }
}
