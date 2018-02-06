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
    private View bUk;
    private ImageView dLr;
    private PostWriteCallBackData fPx;
    private View hnX;
    private TextView hnY;
    private boolean hnZ;
    private TextView hoa;
    private SendVideoSuccessShareModel hob = new SendVideoSuccessShareModel();
    private Context mContext;

    public e(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.bUk = viewGroup;
        if (this.mContext != null && this.bUk != null) {
            this.hnX = LayoutInflater.from(context).inflate(d.h.send_video_success_tip, (ViewGroup) null);
            this.hnY = (TextView) this.hnX.findViewById(d.g.success_tip);
            this.dLr = (ImageView) this.hnX.findViewById(d.g.video_activity_btn);
            this.hoa = (TextView) this.hnX.findViewById(d.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.t(context, d.e.ds128));
            if (this.hnX.getParent() == null) {
                viewGroup.addView(this.hnX, layoutParams);
            }
            this.hnX.setVisibility(8);
            this.hnX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.hnZ) {
                        e.this.hideTip();
                        if (e.this.fPx != null && !StringUtils.isNull(e.this.fPx.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.b.g(e.this.mContext, null, e.this.fPx.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.hoa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.hideTip();
                    if (e.this.fPx != null && !StringUtils.isNull(e.this.fPx.getVideoid())) {
                        e.this.hob.tB(e.this.fPx.getVideoid());
                        e.this.hob.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.e.2.1
                            @Override // com.baidu.adp.base.d
                            public void ak(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.blM = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.d.d.anj().a(new ShareDialogConfig(e.this.mContext, dVar, true, true));
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
            this.fPx = postWriteCallBackData;
            this.hnZ = postWriteCallBackData.mVideoTitleData != null;
            if (this.hnX != null && this.hnY != null && this.dLr != null && this.hoa != null) {
                aj.t(this.hnX, d.C0140d.cp_link_tip_a);
                aj.r(this.hnY, d.C0140d.cp_cont_i);
                aj.c(this.dLr, d.f.icon_arrow_more_white);
                aj.s(this.hoa, d.f.immediately_share_background);
                this.hnX.setVisibility(0);
                this.hnX.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
                if (this.hnZ) {
                    this.hnY.setText(d.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.hnY.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.hnX.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.hnX != null) {
            this.hnX.setVisibility(8);
        }
    }

    public void awP() {
        if (this.hob != null) {
            this.hob.cancelLoadData();
        }
    }
}
