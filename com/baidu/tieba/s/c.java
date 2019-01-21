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
    private static final int hDb = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds20);
    private static final int hDc = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds60);
    private static final int hDd = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds140);
    private static final int hDe = l.h(TbadkCoreApplication.getInst(), e.C0210e.fontsize24);
    private LinearLayout cfw;
    private a hCX;
    private SparseArray<String> hea;
    private Context mContext;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;

    public c(Context context) {
        this.mContext = context;
    }

    public void a(a aVar) {
        this.hCX = aVar;
    }

    public LinearLayout bIN() {
        if (this.cfw == null) {
            initView();
        }
        return this.cfw;
    }

    private void initView() {
        this.cfw = new LinearLayout(this.mContext);
        this.cfw.setOrientation(0);
        int h = l.h(this.mContext, e.C0210e.ds18);
        this.cfw.setPadding(h, l.h(this.mContext, e.C0210e.ds30), h, l.h(this.mContext, e.C0210e.ds26));
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
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(hDc, hDc);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = hDb;
        relativeLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, hDe);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, e.g.photo);
        layoutParams2.addRule(14);
        relativeLayout.addView(textView, layoutParams2);
        al.c(imageView, i);
        textView.setText(i2);
        al.h(textView, e.d.cp_cont_f);
        relativeLayout.setTag(Integer.valueOf(i3));
        relativeLayout.setOnClickListener(this);
        this.cfw.addView(relativeLayout, new LinearLayout.LayoutParams(hDd, -2));
    }

    public void p(com.baidu.tbadk.coreExtra.c.d dVar) {
        this.mShareItem = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hCX != null) {
            this.hCX.bW(view);
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
                uW(3);
                a(dVar, 4);
                if (dVar != null) {
                    eVar.b(dVar);
                }
            } else if (num.intValue() == 3) {
                l("share_to_pyq", new Object[0]);
                uW(2);
                a(dVar, 3);
                if (dVar != null) {
                    if (dVar.aSE) {
                        dVar.content = "【" + dVar.title + "】 " + dVar.content;
                    }
                    eVar.c(dVar);
                }
            } else if (num.intValue() == 5) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    l("share_to_qzone", new Object[0]);
                    uW(4);
                    a(dVar, 5);
                    if (dVar != null) {
                        eVar.e(dVar);
                        return;
                    }
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).Ca();
            } else if (num.intValue() == 9) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    l("share_to_qq_friend", new Object[0]);
                    uW(8);
                    a(dVar, 9);
                    if (dVar != null) {
                        eVar.d(dVar);
                        return;
                    }
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).Ca();
            } else if (num.intValue() == 7) {
                l("share_to_sweibo", new Object[0]);
                uW(6);
                a(dVar, 7);
                if (dVar != null) {
                    if (!dVar.aSD) {
                        dVar.content = m(dVar);
                    }
                    eVar.g(dVar);
                }
            } else if (num.intValue() == 10) {
                a(dVar, 10);
                dVar.linkUrl = com.baidu.tbadk.coreExtra.c.e.aH(dVar.linkUrl, dVar.tid);
                com.baidu.adp.lib.util.a.bg(dVar.linkUrl);
                l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(e.j.copy_pb_url_success));
                n(dVar);
                if (dVar != null && dVar.aSD) {
                    ai(8, dVar.aSQ);
                }
            }
        }
    }

    private void a(com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.aSE) {
                TiebaStatic.log(new am("c10125").aB(ImageViewerConfig.FORUM_ID, dVar.extData).y("obj_type", i));
            } else if (dVar.aSF || dVar.aSI) {
                TiebaStatic.log(new am("c10125").aB("tid", dVar.extData).y("obj_type", i).y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aST).y("obj_param1", dVar.aSU).aB(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.aSG) {
                TiebaStatic.log(new am("c10427").aB("tid", dVar.extData).y("obj_type", i));
            } else if (dVar.aSD) {
                ai(i, dVar.aSQ);
            } else if (dVar.aSH) {
                TiebaStatic.log(new am("c10125").y("obj_param1", 7).y("obj_type", i).aB(ImageViewerConfig.FORUM_ID, dVar.extData));
            }
        }
    }

    private void ai(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void uW(int i) {
        if (i <= 8 && i > 0 && this.hea != null) {
            String str = this.hea.get(i);
            if (!ao.isEmpty(str)) {
                l(str, new Object[0]);
            }
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, AiAppsUBCStatistic.TYPE_CLICK, 1, objArr);
    }

    private void n(com.baidu.tbadk.coreExtra.c.d dVar) {
        am y = new am("share_success").y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.aSU != 0) {
            y.y("obj_param1", dVar.aSU);
            if (dVar.aSU == 2) {
                y.aB(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.aSU == 3) {
                if (dVar.aSV != 0) {
                    y.y("obj_type", dVar.aSV);
                }
                y.aB("tid", dVar.tid).aB(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(y);
    }

    private String m(com.baidu.tbadk.coreExtra.c.d dVar) {
        String str = "【" + dVar.title + "】 " + dVar.content;
        dVar.content = str;
        return str;
    }
}
