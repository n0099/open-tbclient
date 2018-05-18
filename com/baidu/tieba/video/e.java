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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class e {
    private View bef;
    private ImageView dfs;
    private PostWriteCallBackData fkF;
    private View gKQ;
    private TextView gKR;
    private boolean gKS;
    private TextView gKT;
    private SendVideoSuccessShareModel gKU = new SendVideoSuccessShareModel();
    private Context mContext;

    public e(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.bef = viewGroup;
        if (this.mContext != null && this.bef != null) {
            this.gKQ = LayoutInflater.from(context).inflate(d.i.send_video_success_tip, (ViewGroup) null);
            this.gKR = (TextView) this.gKQ.findViewById(d.g.success_tip);
            this.dfs = (ImageView) this.gKQ.findViewById(d.g.video_activity_btn);
            this.gKT = (TextView) this.gKQ.findViewById(d.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.e(context, d.e.ds128));
            if (this.gKQ.getParent() == null) {
                viewGroup.addView(this.gKQ, layoutParams);
            }
            this.gKQ.setVisibility(8);
            this.gKQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (e.this.gKS) {
                        e.this.hideTip();
                        if (e.this.fkF != null && !StringUtils.isNull(e.this.fkF.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.f(e.this.mContext, null, e.this.fkF.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.gKT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.hideTip();
                    if (e.this.fkF != null && !StringUtils.isNull(e.this.fkF.getVideoid())) {
                        e.this.gKU.tL(e.this.fkF.getVideoid());
                        e.this.gKU.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.e.2.1
                            @Override // com.baidu.adp.base.d
                            public void f(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.axh = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.d.d.ahh().a(new ShareDialogConfig(e.this.mContext, dVar, true, true));
                                TiebaStatic.log(new al("c10125").ac("uid", TbadkCoreApplication.getCurrentAccount()).r("obj_param2", 1).r("obj_param3", 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fkF = postWriteCallBackData;
            this.gKS = postWriteCallBackData.mVideoTitleData != null;
            if (this.gKQ != null && this.gKR != null && this.dfs != null && this.gKT != null) {
                ak.j(this.gKQ, d.C0126d.cp_link_tip_a);
                ak.h(this.gKR, d.C0126d.cp_cont_i);
                ak.c(this.dfs, d.f.icon_arrow_more_white);
                ak.i(this.gKT, d.f.immediately_share_background);
                this.gKQ.setVisibility(0);
                this.gKQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
                if (this.gKS) {
                    this.gKR.setText(d.k.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.gKR.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.gKQ.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.gKQ != null) {
            this.gKQ.setVisibility(8);
        }
    }

    public void arf() {
        if (this.gKU != null) {
            this.gKU.cancelLoadData();
        }
    }
}
