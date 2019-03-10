package com.baidu.tieba.lego;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.activity.LegoListActivity;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class j {
    public final TbImageView Uy;
    public final View csE;
    public final TextView dfo;
    public final RelativeLayout gFd;
    public final LinearLayout gFe;
    public final TbImageView gFf;
    public final TbImageView gFg;
    public final TbImageView gFh;
    public final List<TbImageView> gFi;
    private LegoListActivity gFj;
    public final NavigationBar mNavigationBar;

    public j(LegoListActivity legoListActivity) {
        this.gFj = legoListActivity;
        this.mNavigationBar = (NavigationBar) this.gFj.findViewById(d.g.view_navigation_bar);
        this.csE = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, legoListActivity.faZ);
        this.gFd = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, d.h.title_textview, (View.OnClickListener) null);
        ((LinearLayout) this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER)).setGravity(17);
        this.dfo = (TextView) this.gFd.findViewById(d.g.lego_title);
        this.Uy = (TbImageView) this.gFd.findViewById(d.g.lego_title_img);
        this.gFe = (LinearLayout) this.gFd.findViewById(d.g.ll_right);
        this.gFf = (TbImageView) this.gFe.findViewById(d.g.iv1);
        this.gFg = (TbImageView) this.gFe.findViewById(d.g.iv2);
        this.gFh = (TbImageView) this.gFe.findViewById(d.g.iv3);
        this.gFi = new ArrayList();
        this.gFi.add(this.gFf);
        this.gFi.add(this.gFg);
        this.gFi.add(this.gFh);
    }

    public void xS(String str) {
        al.j(this.dfo, d.C0236d.cp_cont_b);
        this.dfo.setVisibility(0);
        this.Uy.setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            this.dfo.setText(str);
        } else {
            this.dfo.setText("");
        }
    }

    public void dj(final String str, final String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            dk(str, str2);
            this.Uy.postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.dk(str, str2);
                }
            }, 1000L);
        }
    }

    public void df(final List<com.baidu.tieba.lego.c.d> list) {
        if (v.T(list)) {
            this.gFe.setVisibility(8);
            return;
        }
        dg(list);
        this.gFe.postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.j.2
            @Override // java.lang.Runnable
            public void run() {
                j.this.dg(list);
            }
        }, 1000L);
    }

    public void hide() {
        this.mNavigationBar.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(String str, String str2) {
        if (this.Uy != null && this.dfo != null) {
            this.Uy.setVisibility(0);
            this.dfo.setVisibility(8);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.Uy.startLoad(str2, 10, false);
            } else {
                this.Uy.startLoad(str, 10, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dg(List<com.baidu.tieba.lego.c.d> list) {
        if (!v.T(list)) {
            this.gFe.setVisibility(0);
            for (int i = 0; i < list.size() && i < this.gFi.size(); i++) {
                this.gFi.get(i).setVisibility(0);
                if (list.get(i).type == 2) {
                    al.c(this.gFi.get(i), d.f.icon_nav_share_n);
                } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.gFi.get(i).startLoad(list.get(i).gKV, 10, false);
                } else {
                    this.gFi.get(i).startLoad(list.get(i).pic, 10, false);
                }
                if (!TextUtils.isEmpty(list.get(i).scheme)) {
                    final String str = list.get(i).scheme;
                    if (list.get(i).type == 1) {
                        this.gFi.get(i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.j.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                q.f(j.this.gFj.getPageContext(), str);
                            }
                        });
                    } else if (list.get(i).type == 2) {
                        final com.baidu.tieba.lego.c.d dVar = list.get(i);
                        this.gFi.get(i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.j.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                j.this.a(dVar);
                            }
                        });
                    }
                }
            }
            int size = list.size();
            while (true) {
                int i2 = size;
                if (i2 < this.gFi.size()) {
                    this.gFi.get(i2).setVisibility(8);
                    size = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(com.baidu.tieba.lego.c.d dVar) {
        if (dVar != null && dVar.type == 2) {
            Uri parse = dVar.shareImageUrl == null ? null : Uri.parse(dVar.shareImageUrl);
            final com.baidu.tbadk.coreExtra.c.d dVar2 = new com.baidu.tbadk.coreExtra.c.d();
            dVar2.title = dVar.shareTitle;
            dVar2.content = dVar.shareContent;
            dVar2.linkUrl = dVar.scheme;
            if (parse != null) {
                dVar2.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.gFj.getActivity(), dVar2, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.j.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.bh(dVar2.linkUrl);
                    com.baidu.adp.lib.util.l.showToast(j.this.gFj.getActivity(), view.getResources().getString(d.j.copy_pb_url_success));
                }
            });
            this.gFj.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }
}
