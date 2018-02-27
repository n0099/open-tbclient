package com.baidu.tieba.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class e {
    private View bTY;
    private ImageView dLf;
    private PostWriteCallBackData fPm;
    private View hnK;
    private TextView hnL;
    private boolean hnM;
    private TextView hnN;
    private SendVideoSuccessShareModel hnO = new SendVideoSuccessShareModel();
    private Context mContext;

    public e(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.bTY = viewGroup;
        if (this.mContext != null && this.bTY != null) {
            this.hnK = LayoutInflater.from(context).inflate(d.h.send_video_success_tip, (ViewGroup) null);
            this.hnL = (TextView) this.hnK.findViewById(d.g.success_tip);
            this.dLf = (ImageView) this.hnK.findViewById(d.g.video_activity_btn);
            this.hnN = (TextView) this.hnK.findViewById(d.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.t(context, d.e.ds128));
            if (this.hnK.getParent() == null) {
                viewGroup.addView(this.hnK, layoutParams);
            }
            this.hnK.setVisibility(8);
            this.hnK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.hnM) {
                        e.this.hideTip();
                        if (e.this.fPm != null && !StringUtils.isNull(e.this.fPm.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.b.g(e.this.mContext, null, e.this.fPm.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.hnN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.hideTip();
                    if (e.this.fPm != null && !StringUtils.isNull(e.this.fPm.getVideoid())) {
                        e.this.hnO.tB(e.this.fPm.getVideoid());
                        e.this.hnO.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.e.2.1
                            @Override // com.baidu.adp.base.d
                            public void ak(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.blz = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.d.d.ani().a(new ShareDialogConfig(e.this.mContext, dVar, true, true));
                                TiebaStatic.log(new ak("c10125").ab("uid", TbadkCoreApplication.getCurrentAccount()).s("obj_param2", 1).s("obj_param3", 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fPm = postWriteCallBackData;
            this.hnM = postWriteCallBackData.mVideoTitleData != null;
            if (this.hnK != null && this.hnL != null && this.dLf != null && this.hnN != null) {
                aj.t(this.hnK, d.C0141d.cp_link_tip_a);
                aj.r(this.hnL, d.C0141d.cp_cont_i);
                aj.c(this.dLf, d.f.icon_arrow_more_white);
                aj.s(this.hnN, d.f.immediately_share_background);
                this.hnK.setVisibility(0);
                this.hnK.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
                if (this.hnM) {
                    this.hnL.setText(d.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.hnL.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.hnK.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.hnK != null) {
            this.hnK.setVisibility(8);
        }
    }

    public void awO() {
        if (this.hnO != null) {
            this.hnO.cancelLoadData();
        }
    }
}
