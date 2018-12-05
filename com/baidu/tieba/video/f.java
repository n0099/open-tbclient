package com.baidu.tieba.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class f {
    private View bCy;
    private ImageView dQO;
    private PostWriteCallBackData fXG;
    private View hzP;
    private TextView hzQ;
    private boolean hzR;
    private TextView hzS;
    private SendVideoSuccessShareModel hzT = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.bCy = viewGroup;
        if (this.mContext != null && this.bCy != null) {
            this.hzP = LayoutInflater.from(context).inflate(e.h.send_video_success_tip, (ViewGroup) null);
            this.hzQ = (TextView) this.hzP.findViewById(e.g.success_tip);
            this.dQO = (ImageView) this.hzP.findViewById(e.g.video_activity_btn);
            this.hzS = (TextView) this.hzP.findViewById(e.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.h(context, e.C0210e.ds128));
            if (this.hzP.getParent() == null) {
                viewGroup.addView(this.hzP, layoutParams);
            }
            this.hzP.setVisibility(8);
            this.hzP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.hzR) {
                        f.this.hideTip();
                        if (f.this.fXG != null && !StringUtils.isNull(f.this.fXG.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.h(f.this.mContext, null, f.this.fXG.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.hzS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.fXG != null && !StringUtils.isNull(f.this.fXG.getVideoid())) {
                        f.this.hzT.ww(f.this.fXG.getVideoid());
                        f.this.hzT.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.aSr = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.c.e.aro().a(new ShareDialogConfig(f.this.mContext, dVar, true, true));
                                TiebaStatic.log(new am("c10125").aA("uid", TbadkCoreApplication.getCurrentAccount()).x("obj_param2", 1).x("obj_param3", 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fXG = postWriteCallBackData;
            this.hzR = postWriteCallBackData.mVideoTitleData != null;
            if (this.hzP != null && this.hzQ != null && this.dQO != null && this.hzS != null) {
                al.j(this.hzP, e.d.cp_link_tip_a);
                al.h(this.hzQ, e.d.cp_cont_i);
                al.c(this.dQO, e.f.icon_arrow_more_white);
                al.i(this.hzS, e.f.immediately_share_background);
                this.hzP.setVisibility(0);
                this.hzP.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.hzR) {
                    this.hzQ.setText(e.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.hzQ.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.hzP.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.hzP != null) {
            this.hzP.setVisibility(8);
        }
    }

    public void aDd() {
        if (this.hzT != null) {
            this.hzT.cancelLoadData();
        }
    }
}
