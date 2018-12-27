package com.baidu.tieba.s;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {
    private static final int hBT = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds20);
    private static final int hBU = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds60);
    private static final int hBV = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds140);
    private static final int hBW = l.h(TbadkCoreApplication.getInst(), e.C0210e.fontsize24);
    private LinearLayout ceK;
    private a hBP;
    private SparseArray<String> hcU;
    private Context mContext;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;

    public c(Context context) {
        this.mContext = context;
    }

    public void a(a aVar) {
        this.hBP = aVar;
    }

    public LinearLayout bIe() {
        if (this.ceK == null) {
            initView();
        }
        return this.ceK;
    }

    private void initView() {
        this.ceK = new LinearLayout(this.mContext);
        this.ceK.setOrientation(0);
        int h = l.h(this.mContext, e.C0210e.ds18);
        this.ceK.setPadding(h, l.h(this.mContext, e.C0210e.ds30), h, l.h(this.mContext, e.C0210e.ds26));
        ad(e.f.icon_weixin_n, e.j.share_weixin, 4);
        ad(e.f.icon_weixin_q_n, e.j.share_weixin_timeline, 3);
        ad(e.f.icon_qq_zone_n, e.j.share_qzone, 5);
        ad(e.f.icon_qq_share_n, e.j.share_qq_friends, 9);
        ad(e.f.icon_sina_n, e.j.share_sina_weibo, 7);
        ad(e.f.icon_copy_link_n, e.j.share_copy, 10);
    }

    private void ad(int i, int i2, int i3) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setId(e.g.photo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(hBU, hBU);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = hBT;
        relativeLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, hBW);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, e.g.photo);
        layoutParams2.addRule(14);
        relativeLayout.addView(textView, layoutParams2);
        al.c(imageView, i);
        textView.setText(i2);
        al.h(textView, e.d.cp_cont_f);
        relativeLayout.setTag(Integer.valueOf(i3));
        relativeLayout.setOnClickListener(this);
        this.ceK.addView(relativeLayout, new LinearLayout.LayoutParams(hBV, -2));
    }

    public void o(com.baidu.tbadk.coreExtra.c.d dVar) {
        this.mShareItem = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hBP != null) {
            this.hBP.bW(view);
        }
        if (view.getTag() instanceof Integer) {
            Integer num = (Integer) view.getTag();
            if (!j.kV() && num.intValue() != 10) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                return;
            }
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e(this.mContext, null);
            com.baidu.tbadk.coreExtra.c.d dVar = this.mShareItem;
            if (num.intValue() == 4) {
                l("share_to_weixin", new Object[0]);
                uT(3);
                a(dVar, 4);
                if (dVar != null) {
                    eVar.b(dVar);
                }
            } else if (num.intValue() == 3) {
                l("share_to_pyq", new Object[0]);
                uT(2);
                a(dVar, 3);
                if (dVar != null) {
                    if (dVar.aRZ) {
                        dVar.content = "【" + dVar.title + "】 " + dVar.content;
                    }
                    eVar.c(dVar);
                }
            } else if (num.intValue() == 5) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    l("share_to_qzone", new Object[0]);
                    uT(4);
                    a(dVar, 5);
                    if (dVar != null) {
                        eVar.e(dVar);
                        return;
                    }
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).BN();
            } else if (num.intValue() == 9) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    l("share_to_qq_friend", new Object[0]);
                    uT(8);
                    a(dVar, 9);
                    if (dVar != null) {
                        eVar.d(dVar);
                        return;
                    }
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).BN();
            } else if (num.intValue() == 7) {
                l("share_to_sweibo", new Object[0]);
                uT(6);
                a(dVar, 7);
                if (dVar != null) {
                    if (!dVar.aRY) {
                        dVar.content = m(dVar);
                    }
                    eVar.g(dVar);
                }
            } else if (num.intValue() == 10) {
                a(dVar, 10);
                dVar.linkUrl = com.baidu.tbadk.coreExtra.c.e.aG(dVar.linkUrl, dVar.tid);
                com.baidu.adp.lib.util.a.bg(dVar.linkUrl);
                l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(e.j.copy_pb_url_success));
                n(dVar);
                if (dVar != null && dVar.aRY) {
                    ag(8, dVar.aSk);
                }
            }
        }
    }

    private void a(com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.aRZ) {
                TiebaStatic.log(new am("c10125").aA(ImageViewerConfig.FORUM_ID, dVar.extData).x("obj_type", i));
            } else if (dVar.aSa || dVar.aSd) {
                TiebaStatic.log(new am("c10125").aA("tid", dVar.extData).x("obj_type", i).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aSn).x("obj_param1", dVar.aSo).aA(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.aSb) {
                TiebaStatic.log(new am("c10427").aA("tid", dVar.extData).x("obj_type", i));
            } else if (dVar.aRY) {
                ag(i, dVar.aSk);
            } else if (dVar.aSc) {
                TiebaStatic.log(new am("c10125").x("obj_param1", 7).x("obj_type", i).aA(ImageViewerConfig.FORUM_ID, dVar.extData));
            }
        }
    }

    private void ag(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void uT(int i) {
        if (i <= 8 && i > 0 && this.hcU != null) {
            String str = this.hcU.get(i);
            if (!ao.isEmpty(str)) {
                l(str, new Object[0]);
            }
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, AiAppsUBCStatistic.TYPE_CLICK, 1, objArr);
    }

    private void n(com.baidu.tbadk.coreExtra.c.d dVar) {
        am x = new am("share_success").x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.aSo != 0) {
            x.x("obj_param1", dVar.aSo);
            if (dVar.aSo == 2) {
                x.aA(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.aSo == 3) {
                if (dVar.aSp != 0) {
                    x.x("obj_type", dVar.aSp);
                }
                x.aA("tid", dVar.tid).aA(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(x);
    }

    private String m(com.baidu.tbadk.coreExtra.c.d dVar) {
        String str = "【" + dVar.title + "】 " + dVar.content;
        dVar.content = str;
        return str;
    }
}
