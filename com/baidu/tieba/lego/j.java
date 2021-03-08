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
/* loaded from: classes8.dex */
public class j {
    public final TbImageView acX;
    public final TextView eoT;
    public final View fNw;
    public final RelativeLayout lck;
    public final LinearLayout lcl;
    public final TbImageView lcm;
    public final TbImageView lcn;
    public final TbImageView lco;
    public final List<TbImageView> lcp;
    private LegoListActivity lcq;
    public final NavigationBar mNavigationBar;

    public j(LegoListActivity legoListActivity) {
        this.lcq = legoListActivity;
        this.mNavigationBar = (NavigationBar) this.lcq.findViewById(R.id.view_navigation_bar);
        this.fNw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, legoListActivity.jkS);
        this.lck = (RelativeLayout) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.title_textview, (View.OnClickListener) null);
        ((LinearLayout) this.mNavigationBar.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER)).setGravity(17);
        this.eoT = (TextView) this.lck.findViewById(R.id.lego_title);
        this.acX = (TbImageView) this.lck.findViewById(R.id.lego_title_img);
        this.lcl = (LinearLayout) this.lck.findViewById(R.id.ll_right);
        this.lcm = (TbImageView) this.lcl.findViewById(R.id.iv1);
        this.lcn = (TbImageView) this.lcl.findViewById(R.id.iv2);
        this.lco = (TbImageView) this.lcl.findViewById(R.id.iv3);
        this.lcp = new ArrayList();
        this.lcp.add(this.lcm);
        this.lcp.add(this.lcn);
        this.lcp.add(this.lco);
    }

    public void KP(String str) {
        ap.setViewTextColor(this.eoT, R.color.CAM_X0105);
        this.eoT.setVisibility(0);
        this.acX.setVisibility(8);
        if (!TextUtils.isEmpty(str)) {
            this.eoT.setText(str);
        } else {
            this.eoT.setText("");
        }
    }

    public void fG(final String str, final String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            fH(str, str2);
            this.acX.postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.j.1
                @Override // java.lang.Runnable
                public void run() {
                    j.this.fH(str, str2);
                }
            }, 1000L);
        }
    }

    public void eG(final List<com.baidu.tieba.lego.c.d> list) {
        if (y.isEmpty(list)) {
            this.lcl.setVisibility(8);
            return;
        }
        eH(list);
        this.lcl.postDelayed(new Runnable() { // from class: com.baidu.tieba.lego.j.2
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
        if (this.acX != null && this.eoT != null) {
            this.acX.setVisibility(0);
            this.eoT.setVisibility(8);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.acX.startLoad(str2, 10, false);
            } else {
                this.acX.startLoad(str, 10, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(List<com.baidu.tieba.lego.c.d> list) {
        if (!y.isEmpty(list)) {
            this.lcl.setVisibility(0);
            for (int i = 0; i < list.size() && i < this.lcp.size(); i++) {
                this.lcp.get(i).setVisibility(0);
                if (list.get(i).type == 2) {
                    ap.setImageResource(this.lcp.get(i), R.drawable.icon_nav_share_n);
                } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.lcp.get(i).startLoad(list.get(i).lhT, 10, false);
                } else {
                    this.lcp.get(i).startLoad(list.get(i).pic, 10, false);
                }
                if (!TextUtils.isEmpty(list.get(i).scheme)) {
                    final String str = list.get(i).scheme;
                    if (list.get(i).type == 1) {
                        this.lcp.get(i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.j.3
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                v.j(j.this.lcq.getPageContext(), str);
                            }
                        });
                    } else if (list.get(i).type == 2) {
                        final com.baidu.tieba.lego.c.d dVar = list.get(i);
                        this.lcp.get(i).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.j.4
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
                if (i2 < this.lcp.size()) {
                    this.lcp.get(i2).setVisibility(8);
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
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.lcq.getActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.j.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                    com.baidu.adp.lib.util.l.showToast(j.this.lcq.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
                }
            });
            this.lcq.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }
}
