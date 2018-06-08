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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class e {
    private View bmp;
    private ImageView doH;
    private PostWriteCallBackData fwa;
    private View gWs;
    private TextView gWt;
    private boolean gWu;
    private TextView gWv;
    private SendVideoSuccessShareModel gWw = new SendVideoSuccessShareModel();
    private Context mContext;

    public e(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.bmp = viewGroup;
        if (this.mContext != null && this.bmp != null) {
            this.gWs = LayoutInflater.from(context).inflate(d.i.send_video_success_tip, (ViewGroup) null);
            this.gWt = (TextView) this.gWs.findViewById(d.g.success_tip);
            this.doH = (ImageView) this.gWs.findViewById(d.g.video_activity_btn);
            this.gWv = (TextView) this.gWs.findViewById(d.g.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.e(context, d.e.ds128));
            if (this.gWs.getParent() == null) {
                viewGroup.addView(this.gWs, layoutParams);
            }
            this.gWs.setVisibility(8);
            this.gWs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.gWu) {
                        e.this.hideTip();
                        if (e.this.fwa != null && !StringUtils.isNull(e.this.fwa.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.g(e.this.mContext, null, e.this.fwa.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.gWv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.hideTip();
                    if (e.this.fwa != null && !StringUtils.isNull(e.this.fwa.getVideoid())) {
                        e.this.gWw.uF(e.this.fwa.getVideoid());
                        e.this.gWw.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.e.2.1
                            @Override // com.baidu.adp.base.d
                            public void i(Object obj) {
                                com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
                                dVar.aFu = false;
                                dVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.c.e.akV().a(new ShareDialogConfig(e.this.mContext, dVar, true, true));
                                TiebaStatic.log(new am("c10125").ah("uid", TbadkCoreApplication.getCurrentAccount()).r("obj_param2", 1).r("obj_param3", 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.fwa = postWriteCallBackData;
            this.gWu = postWriteCallBackData.mVideoTitleData != null;
            if (this.gWs != null && this.gWt != null && this.doH != null && this.gWv != null) {
                al.j(this.gWs, d.C0141d.cp_link_tip_a);
                al.h(this.gWt, d.C0141d.cp_cont_i);
                al.c(this.doH, d.f.icon_arrow_more_white);
                al.i(this.gWv, d.f.immediately_share_background);
                this.gWs.setVisibility(0);
                this.gWs.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.hideTip();
                    }
                }, TbConfig.NOTIFY_SOUND_INTERVAL);
                if (this.gWu) {
                    this.gWt.setText(d.k.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.gWt.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.gWs.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.gWs != null) {
            this.gWs.setVisibility(8);
        }
    }

    public void avk() {
        if (this.gWw != null) {
            this.gWw.cancelLoadData();
        }
    }
}
