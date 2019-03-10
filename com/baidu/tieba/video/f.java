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
    private PostWriteCallBackData hrG;
    private View iUQ;
    private TextView iUR;
    private boolean iUS;
    private TextView iUT;
    private SendVideoSuccessShareModel iUU = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.cOw = viewGroup;
        if (this.mContext != null && this.cOw != null) {
            this.iUQ = LayoutInflater.from(context).inflate(d.h.send_video_success_tip, (ViewGroup) null);
            this.iUR = (TextView) this.iUQ.findViewById(d.g.success_tip);
            this.fhZ = (ImageView) this.iUQ.findViewById(d.g.video_activity_btn);
            this.iUT = (TextView) this.iUQ.findViewById(d.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.h(context, d.e.ds128));
            if (this.iUQ.getParent() == null) {
                viewGroup.addView(this.iUQ, layoutParams);
            }
            this.iUQ.setVisibility(8);
            this.iUQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.iUS) {
                        f.this.hideTip();
                        if (f.this.hrG != null && !StringUtils.isNull(f.this.hrG.buildVideoFakeOnWallUrl())) {
                            a.h(f.this.mContext, null, f.this.hrG.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.iUT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.hrG != null && !StringUtils.isNull(f.this.hrG.getVideoid())) {
                        f.this.iUU.Ds(f.this.hrG.getVideoid());
                        f.this.iUU.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.cbL = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                e.aSu().a(new ShareDialogConfig(f.this.mContext, dVar, true, true));
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
            this.hrG = postWriteCallBackData;
            this.iUS = postWriteCallBackData.mVideoTitleData != null;
            if (this.iUQ != null && this.iUR != null && this.fhZ != null && this.iUT != null) {
                al.l(this.iUQ, d.C0236d.cp_link_tip_a);
                al.j(this.iUR, d.C0236d.cp_btn_a);
                al.c(this.fhZ, d.f.icon_arrow_more_white);
                al.k(this.iUT, d.f.immediately_share_background);
                this.iUQ.setVisibility(0);
                this.iUQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
                if (this.iUS) {
                    this.iUR.setText(d.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.iUR.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.iUQ.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.iUQ != null) {
            this.iUQ.setVisibility(8);
        }
    }

    public void beZ() {
        if (this.iUU != null) {
            this.iUU.cancelLoadData();
        }
    }
}
