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
    private View cYf;
    private ImageView fDd;
    private PostWriteCallBackData hPi;
    private View jtG;
    private TextView jtH;
    private boolean jtI;
    private TextView jtJ;
    private SendVideoSuccessShareModel jtK = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.cYf = viewGroup;
        if (this.mContext != null && this.cYf != null) {
            this.jtG = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.jtH = (TextView) this.jtG.findViewById(R.id.success_tip);
            this.fDd = (ImageView) this.jtG.findViewById(R.id.video_activity_btn);
            this.jtJ = (TextView) this.jtG.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.g(context, R.dimen.ds128));
            if (this.jtG.getParent() == null) {
                viewGroup.addView(this.jtG, layoutParams);
            }
            this.jtG.setVisibility(8);
            this.jtG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.jtI) {
                        f.this.hideTip();
                        if (f.this.hPi != null && !StringUtils.isNull(f.this.hPi.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.k(f.this.mContext, null, f.this.hPi.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.jtJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.hPi != null && !StringUtils.isNull(f.this.hPi.getVideoid())) {
                        f.this.jtK.FB(f.this.hPi.getVideoid());
                        f.this.jtK.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
                                eVar.ckV = false;
                                eVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.c.e.bbB().a(new ShareDialogConfig(f.this.mContext, eVar, true, true));
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
            this.hPi = postWriteCallBackData;
            this.jtI = postWriteCallBackData.mVideoTitleData != null;
            if (this.jtG != null && this.jtH != null && this.fDd != null && this.jtJ != null) {
                am.l(this.jtG, R.color.cp_link_tip_a);
                am.j(this.jtH, R.color.cp_btn_a);
                am.c(this.fDd, (int) R.drawable.icon_arrow_more_white);
                am.k(this.jtJ, R.drawable.immediately_share_background);
                this.jtG.setVisibility(0);
                this.jtG.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.jtI) {
                    this.jtH.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.jtH.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.jtG.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.jtG != null) {
            this.jtG.setVisibility(8);
        }
    }

    public void bos() {
        if (this.jtK != null) {
            this.jtK.cancelLoadData();
        }
    }
}
