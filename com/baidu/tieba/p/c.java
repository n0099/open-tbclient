package com.baidu.tieba.p;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {
    private static final int gIU = l.e(TbadkCoreApplication.getInst(), d.e.ds20);
    private static final int gIV = l.e(TbadkCoreApplication.getInst(), d.e.ds60);
    private static final int gIW = l.e(TbadkCoreApplication.getInst(), d.e.ds140);
    private static final int gIX = l.e(TbadkCoreApplication.getInst(), d.e.fontsize24);
    private LinearLayout gIQ;
    private SparseArray<String> gkZ;
    private a goN;
    private Context mContext;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;

    public c(Context context) {
        this.mContext = context;
    }

    public void setShareItemClickListener(a aVar) {
        this.goN = aVar;
    }

    public LinearLayout bvA() {
        if (this.gIQ == null) {
            initView();
        }
        return this.gIQ;
    }

    private void initView() {
        this.gIQ = new LinearLayout(this.mContext);
        this.gIQ.setOrientation(0);
        int e = l.e(this.mContext, d.e.ds18);
        this.gIQ.setPadding(e, l.e(this.mContext, d.e.ds30), e, l.e(this.mContext, d.e.ds26));
        Z(d.f.icon_weixin_n, d.k.share_weixin, 4);
        Z(d.f.icon_weixin_q_n, d.k.share_weixin_timeline, 3);
        Z(d.f.icon_qq_zone_n, d.k.share_qzone, 5);
        Z(d.f.icon_qq_share_n, d.k.share_qq_friends, 9);
        Z(d.f.icon_sina_n, d.k.share_sina_weibo, 7);
        Z(d.f.icon_copy_link_n, d.k.share_copy, 10);
    }

    private void Z(int i, int i2, int i3) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setId(d.g.photo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(gIV, gIV);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = gIU;
        relativeLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, gIX);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, d.g.photo);
        layoutParams2.addRule(14);
        relativeLayout.addView(textView, layoutParams2);
        ak.c(imageView, i);
        textView.setText(i2);
        ak.h(textView, d.C0126d.cp_cont_f);
        relativeLayout.setTag(Integer.valueOf(i3));
        relativeLayout.setOnClickListener(this);
        this.gIQ.addView(relativeLayout, new LinearLayout.LayoutParams(gIW, -2));
    }

    public void setShareData(com.baidu.tbadk.coreExtra.c.d dVar) {
        this.mShareItem = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.goN != null) {
            this.goN.bt(view2);
        }
        if (view2.getTag() instanceof Integer) {
            Integer num = (Integer) view2.getTag();
            if (!j.gP() && num.intValue() != 10) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                return;
            }
            e eVar = new e(this.mContext, null);
            com.baidu.tbadk.coreExtra.c.d dVar = this.mShareItem;
            if (num.intValue() == 4) {
                l("share_to_weixin", new Object[0]);
                sC(3);
                b(dVar, 4);
                if (dVar != null) {
                    eVar.b(dVar);
                }
            } else if (num.intValue() == 3) {
                l("share_to_pyq", new Object[0]);
                sC(2);
                b(dVar, 3);
                if (dVar != null) {
                    if (dVar.awM) {
                        dVar.content = "【" + dVar.title + "】 " + dVar.content;
                    }
                    eVar.c(dVar);
                }
            } else if (num.intValue() == 5) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    l("share_to_qzone", new Object[0]);
                    sC(4);
                    b(dVar, 5);
                    if (dVar != null) {
                        eVar.e(dVar);
                        return;
                    }
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getText(d.k.share_qq_not_install)).tL();
            } else if (num.intValue() == 9) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    l("share_to_qq_friend", new Object[0]);
                    sC(8);
                    b(dVar, 9);
                    if (dVar != null) {
                        eVar.d(dVar);
                        return;
                    }
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getText(d.k.share_qq_not_install)).tL();
            } else if (num.intValue() == 7) {
                l("share_to_sweibo", new Object[0]);
                sC(6);
                b(dVar, 7);
                if (dVar != null) {
                    if (!dVar.awL) {
                        dVar.content = k(dVar);
                    }
                    eVar.g(dVar);
                }
            } else if (num.intValue() == 10) {
                b(dVar, 10);
                dVar.linkUrl = e.aj(dVar.linkUrl, dVar.tid);
                com.baidu.adp.lib.util.a.aB(dVar.linkUrl);
                l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(d.k.copy_pb_url_success));
                j(dVar);
                if (dVar != null && dVar.awL) {
                    al(8, dVar.awX);
                }
            }
        }
    }

    private void b(com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.awM) {
                TiebaStatic.log(new al("c10125").ac(ImageViewerConfig.FORUM_ID, dVar.extData).r("obj_type", i));
            } else if (dVar.awN || dVar.awQ) {
                TiebaStatic.log(new al("c10125").ac("tid", dVar.extData).r("obj_type", i).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.axa).r("obj_param1", dVar.axb).ac(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.awO) {
                TiebaStatic.log(new al("c10427").ac("tid", dVar.extData).r("obj_type", i));
            } else if (dVar.awL) {
                al(i, dVar.awX);
            } else if (dVar.awP) {
                TiebaStatic.log(new al("c10125").r("obj_param1", 7).r("obj_type", i).ac(ImageViewerConfig.FORUM_ID, dVar.extData));
            }
        }
    }

    private void al(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void sC(int i) {
        if (i <= 8 && i > 0 && this.gkZ != null) {
            String str = this.gkZ.get(i);
            if (!an.isEmpty(str)) {
                l(str, new Object[0]);
            }
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void j(com.baidu.tbadk.coreExtra.c.d dVar) {
        al r = new al("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.axb != 0) {
            r.r("obj_param1", dVar.axb);
            if (dVar.axb == 2) {
                r.ac(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.axb == 3) {
                if (dVar.axc != 0) {
                    r.r("obj_type", dVar.axc);
                }
                r.ac("tid", dVar.tid).ac(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(r);
    }

    private String k(com.baidu.tbadk.coreExtra.c.d dVar) {
        String str = "【" + dVar.title + "】 " + dVar.content;
        dVar.content = str;
        return str;
    }
}
