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
import com.baidu.tbadk.browser.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.c.e;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class f {
    private View cOw;
    private ImageView fhZ;
    private PostWriteCallBackData hrF;
    private SendVideoSuccessShareModel iUA = new SendVideoSuccessShareModel();
    private View iUw;
    private TextView iUx;
    private boolean iUy;
    private TextView iUz;
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.cOw = viewGroup;
        if (this.mContext != null && this.cOw != null) {
            this.iUw = LayoutInflater.from(context).inflate(d.h.send_video_success_tip, (ViewGroup) null);
            this.iUx = (TextView) this.iUw.findViewById(d.g.success_tip);
            this.fhZ = (ImageView) this.iUw.findViewById(d.g.video_activity_btn);
            this.iUz = (TextView) this.iUw.findViewById(d.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.h(context, d.e.ds128));
            if (this.iUw.getParent() == null) {
                viewGroup.addView(this.iUw, layoutParams);
            }
            this.iUw.setVisibility(8);
            this.iUw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.iUy) {
                        f.this.hideTip();
                        if (f.this.hrF != null && !StringUtils.isNull(f.this.hrF.buildVideoFakeOnWallUrl())) {
                            a.h(f.this.mContext, null, f.this.hrF.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.iUz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.hrF != null && !StringUtils.isNull(f.this.hrF.getVideoid())) {
                        f.this.iUA.Dp(f.this.hrF.getVideoid());
                        f.this.iUA.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.cbL = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                e.aSt().a(new ShareDialogConfig(f.this.mContext, dVar, true, true));
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
            this.hrF = postWriteCallBackData;
            this.iUy = postWriteCallBackData.mVideoTitleData != null;
            if (this.iUw != null && this.iUx != null && this.fhZ != null && this.iUz != null) {
                al.l(this.iUw, d.C0236d.cp_link_tip_a);
                al.j(this.iUx, d.C0236d.cp_btn_a);
                al.c(this.fhZ, d.f.icon_arrow_more_white);
                al.k(this.iUz, d.f.immediately_share_background);
                this.iUw.setVisibility(0);
                this.iUw.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
                if (this.iUy) {
                    this.iUx.setText(d.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.iUx.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.iUw.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.iUw != null) {
            this.iUw.setVisibility(8);
        }
    }

    public void beY() {
        if (this.iUA != null) {
            this.iUA.cancelLoadData();
        }
    }
}
