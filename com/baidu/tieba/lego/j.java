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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
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
    public final TbImageView abB;
    public final TextView enq;
    public final View fLW;
    public final RelativeLayout kZT;
    public final LinearLayout kZU;
    public final TbImageView kZV;
    public final TbImageView kZW;
    public final TbImageView kZX;
    public final List<TbImageView> kZY;
    private LegoListActivity kZZ;
    public final NavigationBar mNavigationBar;

    public j(LegoListActivity legoListActivity) {
        this.kZZ = legoListActivity;
        this.mNavigationBar = (NavigationBar) this.kZZ.findViewById(R.id.view_navigation_bar);
        this.fLW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, legoListActivity.jiV);
        this.kZT = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.title_textview, (View.OnClickListener) null);
        ((LinearLayout) this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER)).setGravity(17);
        this.enq = (TextView) this.kZT.findViewById(R.id.lego_title);
        this.abB = (TbImageView) this.kZT.findViewById(R.id.lego_title_img);
        this.kZU = (LinearLayout) this.kZT.findViewById(R.id.ll_right);
        this.kZV = (TbImageView) this.kZU.findViewById(R.id.iv1);
        this.kZW = (TbImageView) this.kZU.findViewById(R.id.iv2);
        this.kZX = (TbImageView) this.kZU.findViewById(R.id.iv3);
        this.kZY = new ArrayList();
        this.kZY.add(this.kZV);
        this.kZY.add(this.kZW);
        this.kZY.add(this.kZX);
    }

    public void KF(String str) {
        ap.setViewTextColor(this.enq, R.color.CAM_X0105);
        this.enq.setVisibility(0);
        this.abB.setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            this.enq.setText(str);
        } else {
            this.enq.setText("");
        }
    }

    public void fG(final String str, final String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            fH(str, str2);
            this.abB.postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.fH(str, str2);
                }
            }, 1000L);
        }
    }

    public void eG(final List<com.baidu.tieba.lego.c.d> list) {
        if (y.isEmpty(list)) {
            this.kZU.setVisibility(8);
            return;
        }
        eH(list);
        this.kZU.postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.j.2
            @Override // java.lang.Runnable
            public void run() {
                j.this.eH(list);
            }
        }, 1000L);
    }

    public void hide() {
        this.mNavigationBar.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fH(String str, String str2) {
        if (this.abB != null && this.enq != null) {
            this.abB.setVisibility(0);
            this.enq.setVisibility(8);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.abB.startLoad(str2, 10, false);
            } else {
                this.abB.startLoad(str, 10, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(List<com.baidu.tieba.lego.c.d> list) {
        if (!y.isEmpty(list)) {
            this.kZU.setVisibility(0);
            for (int i = 0; i < list.size() && i < this.kZY.size(); i++) {
                this.kZY.get(i).setVisibility(0);
                if (list.get(i).type == 2) {
                    ap.setImageResource(this.kZY.get(i), R.drawable.icon_nav_share_n);
                } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.kZY.get(i).startLoad(list.get(i).lfD, 10, false);
                } else {
                    this.kZY.get(i).startLoad(list.get(i).pic, 10, false);
                }
                if (!TextUtils.isEmpty(list.get(i).scheme)) {
                    final String str = list.get(i).scheme;
                    if (list.get(i).type == 1) {
                        this.kZY.get(i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.j.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                v.j(j.this.kZZ.getPageContext(), str);
                            }
                        });
                    } else if (list.get(i).type == 2) {
                        final com.baidu.tieba.lego.c.d dVar = list.get(i);
                        this.kZY.get(i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.j.4
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
                if (i2 < this.kZY.size()) {
                    this.kZY.get(i2).setVisibility(8);
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
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.kZZ.getActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.j.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                    com.baidu.adp.lib.util.l.showToast(j.this.kZZ.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
                }
            });
            this.kZZ.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }
}
