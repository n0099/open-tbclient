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
    private View cZX;
    private ImageView fFE;
    private PostWriteCallBackData hSa;
    private View jxj;
    private TextView jxk;
    private boolean jxl;
    private TextView jxm;
    private SendVideoSuccessShareModel jxn = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.cZX = viewGroup;
        if (this.mContext != null && this.cZX != null) {
            this.jxj = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.jxk = (TextView) this.jxj.findViewById(R.id.success_tip);
            this.fFE = (ImageView) this.jxj.findViewById(R.id.video_activity_btn);
            this.jxm = (TextView) this.jxj.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.g(context, R.dimen.ds128));
            if (this.jxj.getParent() == null) {
                viewGroup.addView(this.jxj, layoutParams);
            }
            this.jxj.setVisibility(8);
            this.jxj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.jxl) {
                        f.this.hideTip();
                        if (f.this.hSa != null && !StringUtils.isNull(f.this.hSa.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.k(f.this.mContext, null, f.this.hSa.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.jxm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.hSa != null && !StringUtils.isNull(f.this.hSa.getVideoid())) {
                        f.this.jxn.Gc(f.this.hSa.getVideoid());
                        f.this.jxn.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
                                eVar.clX = false;
                                eVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.c.e.bch().a(new ShareDialogConfig(f.this.mContext, eVar, true, true));
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
            this.hSa = postWriteCallBackData;
            this.jxl = postWriteCallBackData.mVideoTitleData != null;
            if (this.jxj != null && this.jxk != null && this.fFE != null && this.jxm != null) {
                am.l(this.jxj, R.color.cp_link_tip_a);
                am.j(this.jxk, R.color.cp_cont_a);
                am.c(this.fFE, (int) R.drawable.icon_arrow_more_white);
                am.k(this.jxm, R.drawable.immediately_share_background);
                this.jxj.setVisibility(0);
                this.jxj.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.jxl) {
                    this.jxk.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.jxk.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.jxj.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.jxj != null) {
            this.jxj.setVisibility(8);
        }
    }

    public void bpq() {
        if (this.jxn != null) {
            this.jxn.cancelLoadData();
        }
    }
}
