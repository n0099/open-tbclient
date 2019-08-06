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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class f {
    private View cYm;
    private ImageView fDR;
    private PostWriteCallBackData hQd;
    private View juN;
    private TextView juO;
    private boolean juP;
    private TextView juQ;
    private SendVideoSuccessShareModel juR = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.cYm = viewGroup;
        if (this.mContext != null && this.cYm != null) {
            this.juN = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.juO = (TextView) this.juN.findViewById(R.id.success_tip);
            this.fDR = (ImageView) this.juN.findViewById(R.id.video_activity_btn);
            this.juQ = (TextView) this.juN.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.g(context, R.dimen.ds128));
            if (this.juN.getParent() == null) {
                viewGroup.addView(this.juN, layoutParams);
            }
            this.juN.setVisibility(8);
            this.juN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.juP) {
                        f.this.hideTip();
                        if (f.this.hQd != null && !StringUtils.isNull(f.this.hQd.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.k(f.this.mContext, null, f.this.hQd.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.juQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.hQd != null && !StringUtils.isNull(f.this.hQd.getVideoid())) {
                        f.this.juR.FC(f.this.hQd.getVideoid());
                        f.this.juR.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
                                eVar.clc = false;
                                eVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.c.e.bbD().a(new ShareDialogConfig(f.this.mContext, eVar, true, true));
                                TiebaStatic.log(new an("c10125").bT("uid", TbadkCoreApplication.getCurrentAccount()).P("obj_param2", 1).P("obj_param3", 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hQd = postWriteCallBackData;
            this.juP = postWriteCallBackData.mVideoTitleData != null;
            if (this.juN != null && this.juO != null && this.fDR != null && this.juQ != null) {
                am.l(this.juN, R.color.cp_link_tip_a);
                am.j(this.juO, R.color.cp_btn_a);
                am.c(this.fDR, (int) R.drawable.icon_arrow_more_white);
                am.k(this.juQ, R.drawable.immediately_share_background);
                this.juN.setVisibility(0);
                this.juN.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.juP) {
                    this.juO.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.juO.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.juN.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.juN != null) {
            this.juN.setVisibility(8);
        }
    }

    public void boF() {
        if (this.juR != null) {
            this.juR.cancelLoadData();
        }
    }
}
