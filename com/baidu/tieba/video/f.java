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
    private View cOt;
    private ImageView fhY;
    private PostWriteCallBackData hrz;
    private View iUI;
    private TextView iUJ;
    private boolean iUK;
    private TextView iUL;
    private SendVideoSuccessShareModel iUM = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.cOt = viewGroup;
        if (this.mContext != null && this.cOt != null) {
            this.iUI = LayoutInflater.from(context).inflate(d.h.send_video_success_tip, (ViewGroup) null);
            this.iUJ = (TextView) this.iUI.findViewById(d.g.success_tip);
            this.fhY = (ImageView) this.iUI.findViewById(d.g.video_activity_btn);
            this.iUL = (TextView) this.iUI.findViewById(d.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.h(context, d.e.ds128));
            if (this.iUI.getParent() == null) {
                viewGroup.addView(this.iUI, layoutParams);
            }
            this.iUI.setVisibility(8);
            this.iUI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.iUK) {
                        f.this.hideTip();
                        if (f.this.hrz != null && !StringUtils.isNull(f.this.hrz.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.h(f.this.mContext, null, f.this.hrz.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.iUL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.hrz != null && !StringUtils.isNull(f.this.hrz.getVideoid())) {
                        f.this.iUM.Dq(f.this.hrz.getVideoid());
                        f.this.iUM.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.cbL = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.c.e.aSt().a(new ShareDialogConfig(f.this.mContext, dVar, true, true));
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
            this.hrz = postWriteCallBackData;
            this.iUK = postWriteCallBackData.mVideoTitleData != null;
            if (this.iUI != null && this.iUJ != null && this.fhY != null && this.iUL != null) {
                al.l(this.iUI, d.C0277d.cp_link_tip_a);
                al.j(this.iUJ, d.C0277d.cp_btn_a);
                al.c(this.fhY, d.f.icon_arrow_more_white);
                al.k(this.iUL, d.f.immediately_share_background);
                this.iUI.setVisibility(0);
                this.iUI.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.iUK) {
                    this.iUJ.setText(d.j.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.iUJ.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.iUI.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.iUI != null) {
            this.iUI.setVisibility(8);
        }
    }

    public void beY() {
        if (this.iUM != null) {
            this.iUM.cancelLoadData();
        }
    }
}
