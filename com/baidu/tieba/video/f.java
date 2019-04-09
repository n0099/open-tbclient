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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class f {
    private View cOw;
    private ImageView fhK;
    private PostWriteCallBackData hrn;
    private TextView iUA;
    private SendVideoSuccessShareModel iUB = new SendVideoSuccessShareModel();
    private View iUx;
    private TextView iUy;
    private boolean iUz;
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.cOw = viewGroup;
        if (this.mContext != null && this.cOw != null) {
            this.iUx = LayoutInflater.from(context).inflate(d.h.send_video_success_tip, (ViewGroup) null);
            this.iUy = (TextView) this.iUx.findViewById(d.g.success_tip);
            this.fhK = (ImageView) this.iUx.findViewById(d.g.video_activity_btn);
            this.iUA = (TextView) this.iUx.findViewById(d.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.h(context, d.e.ds128));
            if (this.iUx.getParent() == null) {
                viewGroup.addView(this.iUx, layoutParams);
            }
            this.iUx.setVisibility(8);
            this.iUx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.iUz) {
                        f.this.hideTip();
                        if (f.this.hrn != null && !StringUtils.isNull(f.this.hrn.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.h(f.this.mContext, null, f.this.hrn.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.iUA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.hrn != null && !StringUtils.isNull(f.this.hrn.getVideoid())) {
                        f.this.iUB.Dp(f.this.hrn.getVideoid());
                        f.this.iUB.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.cbO = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.c.e.aSr().a(new ShareDialogConfig(f.this.mContext, dVar, true, true));
                                TiebaStatic.log(new am("c10125").bJ("uid", TbadkCoreApplication.getCurrentAccount()).T("obj_param2", 1).T("obj_param3", 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hrn = postWriteCallBackData;
            this.iUz = postWriteCallBackData.mVideoTitleData != null;
            if (this.iUx != null && this.iUy != null && this.fhK != null && this.iUA != null) {
                al.l(this.iUx, d.C0277d.cp_link_tip_a);
                al.j(this.iUy, d.C0277d.cp_btn_a);
                al.c(this.fhK, d.f.icon_arrow_more_white);
                al.k(this.iUA, d.f.immediately_share_background);
                this.iUx.setVisibility(0);
                this.iUx.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.iUz) {
                    this.iUy.setText(d.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.iUy.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.iUx.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.iUx != null) {
            this.iUx.setVisibility(8);
        }
    }

    public void beW() {
        if (this.iUB != null) {
            this.iUB.cancelLoadData();
        }
    }
}
