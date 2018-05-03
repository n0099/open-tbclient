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
    private ImageView dek;
    private PostWriteCallBackData fjy;
    private View gJN;
    private TextView gJO;
    private boolean gJP;
    private TextView gJQ;
    private SendVideoSuccessShareModel gJR = new SendVideoSuccessShareModel();
    private Context mContext;

    public e(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.bee = viewGroup;
        if (this.mContext != null && this.bee != null) {
            this.gJN = LayoutInflater.from(context).inflate(d.i.send_video_success_tip, (ViewGroup) null);
            this.gJO = (TextView) this.gJN.findViewById(d.g.success_tip);
            this.dek = (ImageView) this.gJN.findViewById(d.g.video_activity_btn);
            this.gJQ = (TextView) this.gJN.findViewById(d.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.e(context, d.e.ds128));
            if (this.gJN.getParent() == null) {
                viewGroup.addView(this.gJN, layoutParams);
            }
            this.gJN.setVisibility(8);
            this.gJN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (e.this.gJP) {
                        e.this.hideTip();
                        if (e.this.fjy != null && !StringUtils.isNull(e.this.fjy.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.f(e.this.mContext, null, e.this.fjy.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.gJQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    e.this.hideTip();
                    if (e.this.fjy != null && !StringUtils.isNull(e.this.fjy.getVideoid())) {
                        e.this.gJR.tI(e.this.fjy.getVideoid());
                        e.this.gJR.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.e.2.1
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
            this.fjy = postWriteCallBackData;
            this.gJP = postWriteCallBackData.mVideoTitleData != null;
            if (this.gJN != null && this.gJO != null && this.dek != null && this.gJQ != null) {
                ak.j(this.gJN, d.C0126d.cp_link_tip_a);
                ak.h(this.gJO, d.C0126d.cp_cont_i);
                ak.c(this.dek, d.f.icon_arrow_more_white);
                ak.i(this.gJQ, d.f.immediately_share_background);
                this.gJN.setVisibility(0);
                this.gJN.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
                if (this.gJP) {
                    this.gJO.setText(d.k.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.gJO.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.gJN.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.gJN != null) {
            this.gJN.setVisibility(8);
        }
    }

    public void arg() {
        if (this.gJR != null) {
            this.gJR.cancelLoadData();
        }
    }
}
