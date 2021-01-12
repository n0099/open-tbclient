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
/* loaded from: classes8.dex */
public class j {
    public final TbImageView abG;
    public final TextView eli;
    public final View fJL;
    public final RelativeLayout kRR;
    public final LinearLayout kRS;
    public final TbImageView kRT;
    public final TbImageView kRU;
    public final TbImageView kRV;
    public final List<TbImageView> kRW;
    private LegoListActivity kRX;
    public final NavigationBar mNavigationBar;

    public j(LegoListActivity legoListActivity) {
        this.kRX = legoListActivity;
        this.mNavigationBar = (NavigationBar) this.kRX.findViewById(R.id.view_navigation_bar);
        this.fJL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, legoListActivity.jdo);
        this.kRR = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.title_textview, (View.OnClickListener) null);
        ((LinearLayout) this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER)).setGravity(17);
        this.eli = (TextView) this.kRR.findViewById(R.id.lego_title);
        this.abG = (TbImageView) this.kRR.findViewById(R.id.lego_title_img);
        this.kRS = (LinearLayout) this.kRR.findViewById(R.id.ll_right);
        this.kRT = (TbImageView) this.kRS.findViewById(R.id.iv1);
        this.kRU = (TbImageView) this.kRS.findViewById(R.id.iv2);
        this.kRV = (TbImageView) this.kRS.findViewById(R.id.iv3);
        this.kRW = new ArrayList();
        this.kRW.add(this.kRT);
        this.kRW.add(this.kRU);
        this.kRW.add(this.kRV);
    }

    public void JU(String str) {
        ao.setViewTextColor(this.eli, R.color.CAM_X0105);
        this.eli.setVisibility(0);
        this.abG.setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            this.eli.setText(str);
        } else {
            this.eli.setText("");
        }
    }

    public void fG(final String str, final String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            fH(str, str2);
            this.abG.postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.fH(str, str2);
                }
            }, 1000L);
        }
    }

    public void eI(final List<com.baidu.tieba.lego.c.d> list) {
        if (x.isEmpty(list)) {
            this.kRS.setVisibility(8);
            return;
        }
        eJ(list);
        this.kRS.postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.j.2
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
    public void fH(String str, String str2) {
        if (this.abG != null && this.eli != null) {
            this.abG.setVisibility(0);
            this.eli.setVisibility(8);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.abG.startLoad(str2, 10, false);
            } else {
                this.abG.startLoad(str, 10, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(List<com.baidu.tieba.lego.c.d> list) {
        if (!x.isEmpty(list)) {
            this.kRS.setVisibility(0);
            for (int i = 0; i < list.size() && i < this.kRW.size(); i++) {
                this.kRW.get(i).setVisibility(0);
                if (list.get(i).type == 2) {
                    ao.setImageResource(this.kRW.get(i), R.drawable.icon_nav_share_n);
                } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.kRW.get(i).startLoad(list.get(i).kXz, 10, false);
                } else {
                    this.kRW.get(i).startLoad(list.get(i).pic, 10, false);
                }
                if (!TextUtils.isEmpty(list.get(i).scheme)) {
                    final String str = list.get(i).scheme;
                    if (list.get(i).type == 1) {
                        this.kRW.get(i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.j.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                v.h(j.this.kRX.getPageContext(), str);
                            }
                        });
                    } else if (list.get(i).type == 2) {
                        final com.baidu.tieba.lego.c.d dVar = list.get(i);
                        this.kRW.get(i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.j.4
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
                if (i2 < this.kRW.size()) {
                    this.kRW.get(i2).setVisibility(8);
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
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.kRX.getActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.j.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                    com.baidu.adp.lib.util.l.showToast(j.this.kRX.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
                }
            });
            this.kRX.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }
}
