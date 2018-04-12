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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes3.dex */
public class SlumdogMillionaireChannelView extends LinearLayout implements View.OnClickListener {
    private TextView goI;
    private TextView goJ;
    private TextView goK;
    private TextView goL;
    private TextView goM;
    private com.baidu.tieba.p.a goN;
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
        this.goI = (TextView) findViewById(d.g.slumdog_millionaire_weixin);
        this.goI.setTag(4);
        this.goI.setOnClickListener(this);
        this.goJ = (TextView) findViewById(d.g.slumdog_millionaire_weixin_coterie);
        this.goJ.setTag(3);
        this.goJ.setOnClickListener(this);
        this.goK = (TextView) findViewById(d.g.slumdog_millionaire_qq);
        this.goK.setTag(9);
        this.goK.setOnClickListener(this);
        this.goL = (TextView) findViewById(d.g.slumdog_millionaire_qzone);
        this.goL.setTag(5);
        this.goL.setOnClickListener(this);
        this.goM = (TextView) findViewById(d.g.slumdog_millionaire_weibo);
        this.goM.setTag(7);
        this.goM.setOnClickListener(this);
        onChangeSkinType();
    }

    public void setShareItemClickListener(com.baidu.tieba.p.a aVar) {
        this.goN = aVar;
    }

    public void setShareData(com.baidu.tbadk.coreExtra.c.d dVar) {
        this.mShareItem = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.goN != null) {
            this.goN.bt(view2);
        }
        if (!j.gP()) {
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
            if (dVar.awV == null) {
                dVar.awV = Uri.parse("http://c.tieba.baidu.com/tb/cms/tieba-fe/baiwanfuweng.jpg");
            }
            if (view2 == this.goI) {
                eVar.b(dVar);
            } else if (view2 == this.goJ) {
                dVar.content = "【" + dVar.title + "】 " + dVar.content;
                eVar.c(dVar);
            } else if (view2 == this.goL) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    eVar.e(dVar);
                } else {
                    BdToast.a(this.mContext, this.mContext.getText(d.k.share_qq_not_install)).tL();
                }
            } else if (view2 == this.goK) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    eVar.d(dVar);
                } else {
                    BdToast.a(this.mContext, this.mContext.getText(d.k.share_qq_not_install)).tL();
                }
            } else if (view2 == this.goM) {
                eVar.g(dVar);
            }
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ak.h(this.goI, d.C0126d.cp_cont_j);
            this.goI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_weixin_n), (Drawable) null, (Drawable) null);
            ak.h(this.goJ, d.C0126d.cp_cont_j);
            this.goJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_weixin_q_n), (Drawable) null, (Drawable) null);
            ak.h(this.goK, d.C0126d.cp_cont_j);
            this.goK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_qq_share_n), (Drawable) null, (Drawable) null);
            ak.h(this.goL, d.C0126d.cp_cont_j);
            this.goL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_qq_zone_n), (Drawable) null, (Drawable) null);
            ak.h(this.goM, d.C0126d.cp_cont_j);
            this.goM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ak.getDrawable(d.f.icon_sina_n), (Drawable) null, (Drawable) null);
        }
    }
}
