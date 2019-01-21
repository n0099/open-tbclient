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
    private View bDp;
    private ImageView dUm;
    private PostWriteCallBackData gbw;
    private View hEi;
    private TextView hEj;
    private boolean hEk;
    private TextView hEl;
    private SendVideoSuccessShareModel hEm = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.bDp = viewGroup;
        if (this.mContext != null && this.bDp != null) {
            this.hEi = LayoutInflater.from(context).inflate(e.h.send_video_success_tip, (ViewGroup) null);
            this.hEj = (TextView) this.hEi.findViewById(e.g.success_tip);
            this.dUm = (ImageView) this.hEi.findViewById(e.g.video_activity_btn);
            this.hEl = (TextView) this.hEi.findViewById(e.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.h(context, e.C0210e.ds128));
            if (this.hEi.getParent() == null) {
                viewGroup.addView(this.hEi, layoutParams);
            }
            this.hEi.setVisibility(8);
            this.hEi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.hEk) {
                        f.this.hideTip();
                        if (f.this.gbw != null && !StringUtils.isNull(f.this.gbw.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.h(f.this.mContext, null, f.this.gbw.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.hEl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.gbw != null && !StringUtils.isNull(f.this.gbw.getVideoid())) {
                        f.this.hEm.wP(f.this.gbw.getVideoid());
                        f.this.hEm.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.aTb = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.c.e.asB().a(new ShareDialogConfig(f.this.mContext, dVar, true, true));
                                TiebaStatic.log(new am("c10125").aB("uid", TbadkCoreApplication.getCurrentAccount()).y("obj_param2", 1).y("obj_param3", 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.gbw = postWriteCallBackData;
            this.hEk = postWriteCallBackData.mVideoTitleData != null;
            if (this.hEi != null && this.hEj != null && this.dUm != null && this.hEl != null) {
                al.j(this.hEi, e.d.cp_link_tip_a);
                al.h(this.hEj, e.d.cp_cont_i);
                al.c(this.dUm, e.f.icon_arrow_more_white);
                al.i(this.hEl, e.f.immediately_share_background);
                this.hEi.setVisibility(0);
                this.hEi.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.hEk) {
                    this.hEj.setText(e.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.hEj.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.hEi.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.hEi != null) {
            this.hEi.setVisibility(8);
        }
    }

    public void aEp() {
        if (this.hEm != null) {
            this.hEm.cancelLoadData();
        }
    }
}
