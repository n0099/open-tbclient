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
    private View bCB;
    private ImageView dTF;
    private PostWriteCallBackData gay;
    private View hDa;
    private TextView hDb;
    private boolean hDc;
    private TextView hDd;
    private SendVideoSuccessShareModel hDe = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.bCB = viewGroup;
        if (this.mContext != null && this.bCB != null) {
            this.hDa = LayoutInflater.from(context).inflate(e.h.send_video_success_tip, (ViewGroup) null);
            this.hDb = (TextView) this.hDa.findViewById(e.g.success_tip);
            this.dTF = (ImageView) this.hDa.findViewById(e.g.video_activity_btn);
            this.hDd = (TextView) this.hDa.findViewById(e.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.h(context, e.C0210e.ds128));
            if (this.hDa.getParent() == null) {
                viewGroup.addView(this.hDa, layoutParams);
            }
            this.hDa.setVisibility(8);
            this.hDa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.hDc) {
                        f.this.hideTip();
                        if (f.this.gay != null && !StringUtils.isNull(f.this.gay.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.h(f.this.mContext, null, f.this.gay.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.hDd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.gay != null && !StringUtils.isNull(f.this.gay.getVideoid())) {
                        f.this.hDe.wz(f.this.gay.getVideoid());
                        f.this.hDe.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.aSt = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.c.e.asd().a(new ShareDialogConfig(f.this.mContext, dVar, true, true));
                                TiebaStatic.log(new am("c10125").aA("uid", TbadkCoreApplication.getCurrentAccount()).x("obj_param2", 1).x("obj_param3", 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.gay = postWriteCallBackData;
            this.hDc = postWriteCallBackData.mVideoTitleData != null;
            if (this.hDa != null && this.hDb != null && this.dTF != null && this.hDd != null) {
                al.j(this.hDa, e.d.cp_link_tip_a);
                al.h(this.hDb, e.d.cp_cont_i);
                al.c(this.dTF, e.f.icon_arrow_more_white);
                al.i(this.hDd, e.f.immediately_share_background);
                this.hDa.setVisibility(0);
                this.hDa.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.hDc) {
                    this.hDb.setText(e.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.hDb.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.hDa.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.hDa != null) {
            this.hDa.setVisibility(8);
        }
    }

    public void aDS() {
        if (this.hDe != null) {
            this.hDe.cancelLoadData();
        }
    }
}
