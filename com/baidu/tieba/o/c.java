package com.baidu.tieba.o;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes3.dex */
public class c implements View.OnClickListener {
    private SparseArray<String> gPT;
    private a gTG;
    private LinearLayout hnq;
    private Context mContext;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;

    public c(Context context) {
        this.mContext = context;
    }

    public void setShareItemClickListener(a aVar) {
        this.gTG = aVar;
    }

    public LinearLayout bAy() {
        if (this.hnq == null) {
            initView();
        }
        return this.hnq;
    }

    private void initView() {
        this.hnq = new LinearLayout(this.mContext);
        this.hnq.setOrientation(0);
        int t = l.t(this.mContext, d.e.ds18);
        this.hnq.setPadding(t, l.t(this.mContext, d.e.ds30), t, l.t(this.mContext, d.e.ds26));
        al(d.f.icon_weixin_n, d.j.share_weixin, 4);
        al(d.f.icon_weixin_q_n, d.j.share_weixin_timeline, 3);
        al(d.f.icon_qq_zone_n, d.j.share_qzone, 5);
        al(d.f.icon_qq_share_n, d.j.share_qq_friends, 9);
        al(d.f.icon_sina_n, d.j.share_sina_weibo, 7);
        al(d.f.icon_copy_link_n, d.j.share_copy, 10);
    }

    private void al(int i, int i2, int i3) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.h.share_dialog_outer_item, (ViewGroup) this.hnq, false);
        TextView textView = (TextView) viewGroup.findViewById(d.g.name);
        aj.c((ImageView) viewGroup.findViewById(d.g.photo), i);
        textView.setText(i2);
        aj.r(textView, d.C0141d.cp_cont_f);
        viewGroup.setTag(Integer.valueOf(i3));
        viewGroup.setOnClickListener(this);
        this.hnq.addView(viewGroup);
    }

    public void setShareData(com.baidu.tbadk.coreExtra.c.d dVar) {
        this.mShareItem = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gTG != null) {
            this.gTG.cN(view);
        }
        if (view.getTag() instanceof Integer) {
            Integer num = (Integer) view.getTag();
            if (!j.oJ() && num.intValue() != 10) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                return;
            }
            e eVar = new e(this.mContext, null);
            com.baidu.tbadk.coreExtra.c.d dVar = this.mShareItem;
            if (num.intValue() == 4) {
                l("share_to_weixin", new Object[0]);
                va(3);
                b(dVar, 4);
                if (dVar != null) {
                    eVar.b(dVar);
                }
            } else if (num.intValue() == 3) {
                l("share_to_pyq", new Object[0]);
                va(2);
                b(dVar, 3);
                if (dVar != null) {
                    if (dVar.bli) {
                        dVar.content = "【" + dVar.title + "】 " + dVar.content;
                    }
                    eVar.c(dVar);
                }
            } else if (num.intValue() == 5) {
                if (v.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    l("share_to_qzone", new Object[0]);
                    va(4);
                    b(dVar, 5);
                    if (dVar != null) {
                        eVar.e(dVar);
                        return;
                    }
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getText(d.j.share_qq_not_install)).Bd();
            } else if (num.intValue() == 9) {
                if (v.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    l("share_to_qq_friend", new Object[0]);
                    va(8);
                    b(dVar, 9);
                    if (dVar != null) {
                        eVar.d(dVar);
                        return;
                    }
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getText(d.j.share_qq_not_install)).Bd();
            } else if (num.intValue() == 7) {
                l("share_to_sweibo", new Object[0]);
                va(6);
                b(dVar, 7);
                if (dVar != null) {
                    if (!dVar.blh) {
                        dVar.content = j(dVar);
                    }
                    eVar.g(dVar);
                }
            } else if (num.intValue() == 10) {
                b(dVar, 10);
                dVar.linkUrl = e.ai(dVar.linkUrl, dVar.tid);
                com.baidu.adp.lib.util.a.aE(dVar.linkUrl);
                l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(d.j.copy_pb_url_success));
                i(dVar);
                if (dVar != null && dVar.blh) {
                    af(8, dVar.blt);
                }
            }
        }
    }

    private void b(com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.bli) {
                TiebaStatic.log(new ak("c10125").ab(ImageViewerConfig.FORUM_ID, dVar.extData).s("obj_type", i));
            } else if (dVar.blj || dVar.blm) {
                TiebaStatic.log(new ak("c10125").ab("tid", dVar.extData).s("obj_type", i).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.blw).s("obj_param1", dVar.blx).ab(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.blk) {
                TiebaStatic.log(new ak("c10427").ab("tid", dVar.extData).s("obj_type", i));
            } else if (dVar.blh) {
                af(i, dVar.blt);
            } else if (dVar.bll) {
                TiebaStatic.log(new ak("c10125").s("obj_param1", 7).s("obj_type", i).ab(ImageViewerConfig.FORUM_ID, dVar.extData));
            }
        }
    }

    private void af(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private void va(int i) {
        if (i <= 8 && i > 0 && this.gPT != null) {
            String str = this.gPT.get(i);
            if (!am.isEmpty(str)) {
                l(str, new Object[0]);
            }
        }
    }

    private void l(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void i(com.baidu.tbadk.coreExtra.c.d dVar) {
        ak s = new ak("share_success").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.blx != 0) {
            s.s("obj_param1", dVar.blx);
            if (dVar.blx == 2) {
                s.ab(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.blx == 3) {
                if (dVar.bly != 0) {
                    s.s("obj_type", dVar.bly);
                }
                s.ab("tid", dVar.tid).ab(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(s);
    }

    private String j(com.baidu.tbadk.coreExtra.c.d dVar) {
        String str = "【" + dVar.title + "】 " + dVar.content;
        dVar.content = str;
        return str;
    }
}
