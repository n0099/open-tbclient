package com.baidu.tieba.r;

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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {
    private static final int gZB = l.e(TbadkCoreApplication.getInst(), d.e.ds20);
    private static final int gZC = l.e(TbadkCoreApplication.getInst(), d.e.ds60);
    private static final int gZD = l.e(TbadkCoreApplication.getInst(), d.e.ds140);
    private static final int gZE = l.e(TbadkCoreApplication.getInst(), d.e.fontsize24);
    private SparseArray<String> gBt;
    private a gFg;
    private LinearLayout gZx;
    private Context mContext;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;

    public c(Context context) {
        this.mContext = context;
    }

    public void setShareItemClickListener(a aVar) {
        this.gFg = aVar;
    }

    public LinearLayout bBf() {
        if (this.gZx == null) {
            initView();
        }
        return this.gZx;
    }

    private void initView() {
        this.gZx = new LinearLayout(this.mContext);
        this.gZx.setOrientation(0);
        int e = l.e(this.mContext, d.e.ds18);
        this.gZx.setPadding(e, l.e(this.mContext, d.e.ds30), e, l.e(this.mContext, d.e.ds26));
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
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(gZC, gZC);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = gZB;
        relativeLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, gZE);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, d.g.photo);
        layoutParams2.addRule(14);
        relativeLayout.addView(textView, layoutParams2);
        am.c(imageView, i);
        textView.setText(i2);
        am.h(textView, d.C0142d.cp_cont_f);
        relativeLayout.setTag(Integer.valueOf(i3));
        relativeLayout.setOnClickListener(this);
        this.gZx.addView(relativeLayout, new LinearLayout.LayoutParams(gZD, -2));
    }

    public void setShareData(com.baidu.tbadk.coreExtra.c.d dVar) {
        this.mShareItem = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gFg != null) {
            this.gFg.bx(view);
        }
        if (view.getTag() instanceof Integer) {
            Integer num = (Integer) view.getTag();
            if (!j.jD() && num.intValue() != 10) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
                return;
            }
            e eVar = new e(this.mContext, null);
            com.baidu.tbadk.coreExtra.c.d dVar = this.mShareItem;
            if (num.intValue() == 4) {
                l("share_to_weixin", new Object[0]);
                sX(3);
                a(dVar, 4);
                if (dVar != null) {
                    eVar.b(dVar);
                }
            } else if (num.intValue() == 3) {
                l("share_to_pyq", new Object[0]);
                sX(2);
                a(dVar, 3);
                if (dVar != null) {
                    if (dVar.aFT) {
                        dVar.content = "【" + dVar.title + "】 " + dVar.content;
                    }
                    eVar.c(dVar);
                }
            } else if (num.intValue() == 5) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    l("share_to_qzone", new Object[0]);
                    sX(4);
                    a(dVar, 5);
                    if (dVar != null) {
                        eVar.e(dVar);
                        return;
                    }
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getText(d.k.share_qq_not_install)).xv();
            } else if (num.intValue() == 9) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    l("share_to_qq_friend", new Object[0]);
                    sX(8);
                    a(dVar, 9);
                    if (dVar != null) {
                        eVar.d(dVar);
                        return;
                    }
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getText(d.k.share_qq_not_install)).xv();
            } else if (num.intValue() == 7) {
                l("share_to_sweibo", new Object[0]);
                sX(6);
                a(dVar, 7);
                if (dVar != null) {
                    if (!dVar.aFS) {
                        dVar.content = j(dVar);
                    }
                    eVar.g(dVar);
                }
            } else if (num.intValue() == 10) {
                a(dVar, 10);
                dVar.linkUrl = e.an(dVar.linkUrl, dVar.tid);
                com.baidu.adp.lib.util.a.aP(dVar.linkUrl);
                l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(d.k.copy_pb_url_success));
                k(dVar);
                if (dVar != null && dVar.aFS) {
                    ag(8, dVar.aGe);
                }
            }
        }
    }

    private void a(com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.aFT) {
                TiebaStatic.log(new an("c10125").ah(ImageViewerConfig.FORUM_ID, dVar.extData).r("obj_type", i));
            } else if (dVar.aFU || dVar.aFX) {
                TiebaStatic.log(new an("c10125").ah("tid", dVar.extData).r("obj_type", i).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aGh).r("obj_param1", dVar.aGi).ah(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.aFV) {
                TiebaStatic.log(new an("c10427").ah("tid", dVar.extData).r("obj_type", i));
            } else if (dVar.aFS) {
                ag(i, dVar.aGe);
            } else if (dVar.aFW) {
                TiebaStatic.log(new an("c10125").r("obj_param1", 7).r("obj_type", i).ah(ImageViewerConfig.FORUM_ID, dVar.extData));
            }
        }
    }

    private void ag(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void sX(int i) {
        if (i <= 8 && i > 0 && this.gBt != null) {
            String str = this.gBt.get(i);
            if (!ap.isEmpty(str)) {
                l(str, new Object[0]);
            }
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void k(com.baidu.tbadk.coreExtra.c.d dVar) {
        an r = new an("share_success").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.aGi != 0) {
            r.r("obj_param1", dVar.aGi);
            if (dVar.aGi == 2) {
                r.ah(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.aGi == 3) {
                if (dVar.aGj != 0) {
                    r.r("obj_type", dVar.aGj);
                }
                r.ah("tid", dVar.tid).ah(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(r);
    }

    private String j(com.baidu.tbadk.coreExtra.c.d dVar) {
        String str = "【" + dVar.title + "】 " + dVar.content;
        dVar.content = str;
        return str;
    }
}
