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
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class f {
    private View bow;
    private ImageView duA;
    private PostWriteCallBackData fAg;
    private View hbL;
    private TextView hbM;
    private boolean hbN;
    private TextView hbO;
    private SendVideoSuccessShareModel hbP = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.bow = viewGroup;
        if (this.mContext != null && this.bow != null) {
            this.hbL = LayoutInflater.from(context).inflate(f.h.send_video_success_tip, (ViewGroup) null);
            this.hbM = (TextView) this.hbL.findViewById(f.g.success_tip);
            this.duA = (ImageView) this.hbL.findViewById(f.g.video_activity_btn);
            this.hbO = (TextView) this.hbL.findViewById(f.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.f(context, f.e.ds128));
            if (this.hbL.getParent() == null) {
                viewGroup.addView(this.hbL, layoutParams);
            }
            this.hbL.setVisibility(8);
            this.hbL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.hbN) {
                        f.this.hideTip();
                        if (f.this.fAg != null && !StringUtils.isNull(f.this.fAg.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.g(f.this.mContext, null, f.this.fAg.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.hbO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.fAg != null && !StringUtils.isNull(f.this.fAg.getVideoid())) {
                        f.this.hbP.uD(f.this.fAg.getVideoid());
                        f.this.hbP.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void i(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.aGm = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.c.e.akQ().a(new ShareDialogConfig(f.this.mContext, dVar, true, true));
                                TiebaStatic.log(new an("c10125").ae("uid", TbadkCoreApplication.getCurrentAccount()).r("obj_param2", 1).r("obj_param3", 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fAg = postWriteCallBackData;
            this.hbN = postWriteCallBackData.mVideoTitleData != null;
            if (this.hbL != null && this.hbM != null && this.duA != null && this.hbO != null) {
                am.j(this.hbL, f.d.cp_link_tip_a);
                am.h(this.hbM, f.d.cp_cont_i);
                am.c(this.duA, f.C0146f.icon_arrow_more_white);
                am.i(this.hbO, f.C0146f.immediately_share_background);
                this.hbL.setVisibility(0);
                this.hbL.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
                if (this.hbN) {
                    this.hbM.setText(f.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.hbM.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.hbL.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.hbL != null) {
            this.hbL.setVisibility(8);
        }
    }

    public void awr() {
        if (this.hbP != null) {
            this.hbP.cancelLoadData();
        }
    }
}
