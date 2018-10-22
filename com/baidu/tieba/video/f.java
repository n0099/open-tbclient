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
    private View byq;
    private ImageView dJh;
    private PostWriteCallBackData fPr;
    private View hqU;
    private TextView hqV;
    private boolean hqW;
    private TextView hqX;
    private SendVideoSuccessShareModel hqY = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.byq = viewGroup;
        if (this.mContext != null && this.byq != null) {
            this.hqU = LayoutInflater.from(context).inflate(e.h.send_video_success_tip, (ViewGroup) null);
            this.hqV = (TextView) this.hqU.findViewById(e.g.success_tip);
            this.dJh = (ImageView) this.hqU.findViewById(e.g.video_activity_btn);
            this.hqX = (TextView) this.hqU.findViewById(e.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.h(context, e.C0175e.ds128));
            if (this.hqU.getParent() == null) {
                viewGroup.addView(this.hqU, layoutParams);
            }
            this.hqU.setVisibility(8);
            this.hqU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.hqW) {
                        f.this.hideTip();
                        if (f.this.fPr != null && !StringUtils.isNull(f.this.fPr.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.h(f.this.mContext, null, f.this.fPr.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.hqX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.fPr != null && !StringUtils.isNull(f.this.fPr.getVideoid())) {
                        f.this.hqY.vO(f.this.fPr.getVideoid());
                        f.this.hqY.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.aOc = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.c.e.aqb().a(new ShareDialogConfig(f.this.mContext, dVar, true, true));
                                TiebaStatic.log(new am("c10125").ax("uid", TbadkCoreApplication.getCurrentAccount()).x("obj_param2", 1).x("obj_param3", 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fPr = postWriteCallBackData;
            this.hqW = postWriteCallBackData.mVideoTitleData != null;
            if (this.hqU != null && this.hqV != null && this.dJh != null && this.hqX != null) {
                al.j(this.hqU, e.d.cp_link_tip_a);
                al.h(this.hqV, e.d.cp_cont_i);
                al.c(this.dJh, e.f.icon_arrow_more_white);
                al.i(this.hqX, e.f.immediately_share_background);
                this.hqU.setVisibility(0);
                this.hqU.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.hqW) {
                    this.hqV.setText(e.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.hqV.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.hqU.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.hqU != null) {
            this.hqU.setVisibility(8);
        }
    }

    public void aBW() {
        if (this.hqY != null) {
            this.hqY.cancelLoadData();
        }
    }
}
