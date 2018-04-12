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
    private View bee;
    private ImageView den;
    private PostWriteCallBackData fjB;
    private View gJQ;
    private TextView gJR;
    private boolean gJS;
    private TextView gJT;
    private SendVideoSuccessShareModel gJU = new SendVideoSuccessShareModel();
    private Context mContext;

    public e(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.bee = viewGroup;
        if (this.mContext != null && this.bee != null) {
            this.gJQ = LayoutInflater.from(context).inflate(d.i.send_video_success_tip, (ViewGroup) null);
            this.gJR = (TextView) this.gJQ.findViewById(d.g.success_tip);
            this.den = (ImageView) this.gJQ.findViewById(d.g.video_activity_btn);
            this.gJT = (TextView) this.gJQ.findViewById(d.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.e(context, d.e.ds128));
            if (this.gJQ.getParent() == null) {
                viewGroup.addView(this.gJQ, layoutParams);
            }
            this.gJQ.setVisibility(8);
            this.gJQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (e.this.gJS) {
                        e.this.hideTip();
                        if (e.this.fjB != null && !StringUtils.isNull(e.this.fjB.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.f(e.this.mContext, null, e.this.fjB.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.gJT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.hideTip();
                    if (e.this.fjB != null && !StringUtils.isNull(e.this.fjB.getVideoid())) {
                        e.this.gJU.tI(e.this.fjB.getVideoid());
                        e.this.gJU.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.e.2.1
                            @Override // com.baidu.adp.base.d
                            public void f(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.axg = false;
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
            this.fjB = postWriteCallBackData;
            this.gJS = postWriteCallBackData.mVideoTitleData != null;
            if (this.gJQ != null && this.gJR != null && this.den != null && this.gJT != null) {
                ak.j(this.gJQ, d.C0126d.cp_link_tip_a);
                ak.h(this.gJR, d.C0126d.cp_cont_i);
                ak.c(this.den, d.f.icon_arrow_more_white);
                ak.i(this.gJT, d.f.immediately_share_background);
                this.gJQ.setVisibility(0);
                this.gJQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
                if (this.gJS) {
                    this.gJR.setText(d.k.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.gJR.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.gJQ.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.gJQ != null) {
            this.gJQ.setVisibility(8);
        }
    }

    public void arg() {
        if (this.gJU != null) {
            this.gJU.cancelLoadData();
        }
    }
}
