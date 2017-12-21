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
    private View beI;
    private ImageView cOu;
    private PostWriteCallBackData eXF;
    private View gPN;
    private TextView gPO;
    private boolean gPP;
    private TextView gPQ;
    private SendVideoSuccessShareModel gPR = new SendVideoSuccessShareModel();
    private Context mContext;

    public e(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.beI = viewGroup;
        if (this.mContext != null && this.beI != null) {
            this.gPN = LayoutInflater.from(context).inflate(d.h.send_video_success_tip, (ViewGroup) null);
            this.gPO = (TextView) this.gPN.findViewById(d.g.success_tip);
            this.cOu = (ImageView) this.gPN.findViewById(d.g.video_activity_btn);
            this.gPQ = (TextView) this.gPN.findViewById(d.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.f(context, d.e.ds128));
            if (this.gPN.getParent() == null) {
                viewGroup.addView(this.gPN, layoutParams);
            }
            this.gPN.setVisibility(8);
            this.gPN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.gPP) {
                        e.this.hideTip();
                        if (e.this.eXF != null && !StringUtils.isNull(e.this.eXF.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.e(e.this.mContext, null, e.this.eXF.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.gPQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.hideTip();
                    if (e.this.eXF != null && !StringUtils.isNull(e.this.eXF.getVideoid())) {
                        e.this.gPR.tT(e.this.eXF.getVideoid());
                        e.this.gPR.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.e.2.1
                            @Override // com.baidu.adp.base.d
                            public void f(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.auS = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                new com.baidu.tieba.d.c(e.this.mContext).a(new ShareDialogConfig(e.this.mContext, dVar, true, true));
                                TiebaStatic.log(new ak("c10125").ac("uid", TbadkCoreApplication.getCurrentAccount()).r("obj_param2", 1).r("obj_param3", 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void g(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.eXF = postWriteCallBackData;
            this.gPP = postWriteCallBackData.mVideoTitleData != null;
            if (this.gPN != null && this.gPO != null && this.cOu != null && this.gPQ != null) {
                aj.k(this.gPN, d.C0095d.cp_link_tip_a);
                aj.i(this.gPO, d.C0095d.cp_cont_i);
                aj.c(this.cOu, d.f.icon_arrow_more_white);
                aj.j(this.gPQ, d.f.immediately_share_background);
                this.gPN.setVisibility(0);
                this.gPN.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
                if (this.gPP) {
                    this.gPO.setText(d.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.gPO.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.gPN.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.gPN != null) {
            this.gPN.setVisibility(8);
        }
    }

    public void and() {
        if (this.gPR != null) {
            this.gPR.cancelLoadData();
        }
    }
}
