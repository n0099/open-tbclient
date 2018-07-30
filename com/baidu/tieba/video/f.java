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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class f {
    private View bou;
    private ImageView duD;
    private PostWriteCallBackData fAn;
    private View hbK;
    private TextView hbL;
    private boolean hbM;
    private TextView hbN;
    private SendVideoSuccessShareModel hbO = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.bou = viewGroup;
        if (this.mContext != null && this.bou != null) {
            this.hbK = LayoutInflater.from(context).inflate(d.h.send_video_success_tip, (ViewGroup) null);
            this.hbL = (TextView) this.hbK.findViewById(d.g.success_tip);
            this.duD = (ImageView) this.hbK.findViewById(d.g.video_activity_btn);
            this.hbN = (TextView) this.hbK.findViewById(d.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.f(context, d.e.ds128));
            if (this.hbK.getParent() == null) {
                viewGroup.addView(this.hbK, layoutParams);
            }
            this.hbK.setVisibility(8);
            this.hbK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.hbM) {
                        f.this.hideTip();
                        if (f.this.fAn != null && !StringUtils.isNull(f.this.fAn.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.g(f.this.mContext, null, f.this.fAn.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.hbN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.fAn != null && !StringUtils.isNull(f.this.fAn.getVideoid())) {
                        f.this.hbO.uz(f.this.fAn.getVideoid());
                        f.this.hbO.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void i(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.aGn = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.c.e.akO().a(new ShareDialogConfig(f.this.mContext, dVar, true, true));
                                TiebaStatic.log(new an("c10125").af("uid", TbadkCoreApplication.getCurrentAccount()).r("obj_param2", 1).r("obj_param3", 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fAn = postWriteCallBackData;
            this.hbM = postWriteCallBackData.mVideoTitleData != null;
            if (this.hbK != null && this.hbL != null && this.duD != null && this.hbN != null) {
                am.j(this.hbK, d.C0140d.cp_link_tip_a);
                am.h(this.hbL, d.C0140d.cp_cont_i);
                am.c(this.duD, d.f.icon_arrow_more_white);
                am.i(this.hbN, d.f.immediately_share_background);
                this.hbK.setVisibility(0);
                this.hbK.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
                if (this.hbM) {
                    this.hbL.setText(d.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.hbL.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.hbK.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.hbK != null) {
            this.hbK.setVisibility(8);
        }
    }

    public void aws() {
        if (this.hbO != null) {
            this.hbO.cancelLoadData();
        }
    }
}
