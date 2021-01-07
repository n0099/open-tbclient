package com.baidu.tieba.lego;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.activity.LegoListActivity;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class j {
    public final TbImageView abI;
    public final TextView epX;
    public final View fOs;
    public final TbImageView kWA;
    public final List<TbImageView> kWB;
    private LegoListActivity kWC;
    public final RelativeLayout kWw;
    public final LinearLayout kWx;
    public final TbImageView kWy;
    public final TbImageView kWz;
    public final NavigationBar mNavigationBar;

    public j(LegoListActivity legoListActivity) {
        this.kWC = legoListActivity;
        this.mNavigationBar = (NavigationBar) this.kWC.findViewById(R.id.view_navigation_bar);
        this.fOs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, legoListActivity.jhV);
        this.kWw = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.title_textview, (View.OnClickListener) null);
        ((LinearLayout) this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER)).setGravity(17);
        this.epX = (TextView) this.kWw.findViewById(R.id.lego_title);
        this.abI = (TbImageView) this.kWw.findViewById(R.id.lego_title_img);
        this.kWx = (LinearLayout) this.kWw.findViewById(R.id.ll_right);
        this.kWy = (TbImageView) this.kWx.findViewById(R.id.iv1);
        this.kWz = (TbImageView) this.kWx.findViewById(R.id.iv2);
        this.kWA = (TbImageView) this.kWx.findViewById(R.id.iv3);
        this.kWB = new ArrayList();
        this.kWB.add(this.kWy);
        this.kWB.add(this.kWz);
        this.kWB.add(this.kWA);
    }

    public void Le(String str) {
        ao.setViewTextColor(this.epX, R.color.CAM_X0105);
        this.epX.setVisibility(0);
        this.abI.setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            this.epX.setText(str);
        } else {
            this.epX.setText("");
        }
    }

    public void fH(final String str, final String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            fI(str, str2);
            this.abI.postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.fI(str, str2);
                }
            }, 1000L);
        }
    }

    public void eI(final List<com.baidu.tieba.lego.c.d> list) {
        if (x.isEmpty(list)) {
            this.kWx.setVisibility(8);
            return;
        }
        eJ(list);
        this.kWx.postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.j.2
            @Override // java.lang.Runnable
            public void run() {
                j.this.eJ(list);
            }
        }, 1000L);
    }

    public void hide() {
        this.mNavigationBar.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fI(String str, String str2) {
        if (this.abI != null && this.epX != null) {
            this.abI.setVisibility(0);
            this.epX.setVisibility(8);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.abI.startLoad(str2, 10, false);
            } else {
                this.abI.startLoad(str, 10, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(List<com.baidu.tieba.lego.c.d> list) {
        if (!x.isEmpty(list)) {
            this.kWx.setVisibility(0);
            for (int i = 0; i < list.size() && i < this.kWB.size(); i++) {
                this.kWB.get(i).setVisibility(0);
                if (list.get(i).type == 2) {
                    ao.setImageResource(this.kWB.get(i), R.drawable.icon_nav_share_n);
                } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.kWB.get(i).startLoad(list.get(i).lcf, 10, false);
                } else {
                    this.kWB.get(i).startLoad(list.get(i).pic, 10, false);
                }
                if (!TextUtils.isEmpty(list.get(i).scheme)) {
                    final String str = list.get(i).scheme;
                    if (list.get(i).type == 1) {
                        this.kWB.get(i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.j.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                v.h(j.this.kWC.getPageContext(), str);
                            }
                        });
                    } else if (list.get(i).type == 2) {
                        final com.baidu.tieba.lego.c.d dVar = list.get(i);
                        this.kWB.get(i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.j.4
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
                if (i2 < this.kWB.size()) {
                    this.kWB.get(i2).setVisibility(8);
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
            final ShareItem shareItem = new ShareItem();
            shareItem.title = dVar.shareTitle;
            shareItem.content = dVar.shareContent;
            shareItem.linkUrl = dVar.scheme;
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.kWC.getActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.j.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                    com.baidu.adp.lib.util.l.showToast(j.this.kWC.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
                }
            });
            this.kWC.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }
}
