package com.baidu.tieba.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
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
    private View djw;
    private ImageView fEV;
    private PostWriteCallBackData hQF;
    private View jxb;
    private TextView jxc;
    private boolean jxd;
    private TextView jxe;
    private SendVideoSuccessShareModel jxf = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.djw = viewGroup;
        if (this.mContext != null && this.djw != null) {
            this.jxb = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.jxc = (TextView) this.jxb.findViewById(R.id.success_tip);
            this.fEV = (ImageView) this.jxb.findViewById(R.id.video_activity_btn);
            this.jxe = (TextView) this.jxb.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.jxb.getParent() == null) {
                viewGroup.addView(this.jxb, layoutParams);
            }
            this.jxb.setVisibility(8);
            this.jxb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.jxd) {
                        f.this.hideTip();
                        if (f.this.hQF != null && !StringUtils.isNull(f.this.hQF.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.mContext, (String) null, f.this.hQF.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.jxe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.hQF != null && !StringUtils.isNull(f.this.hQF.getVideoid())) {
                        f.this.jxf.EE(f.this.hQF.getVideoid());
                        f.this.jxf.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
                                eVar.cyX = false;
                                eVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.c.e.bcj().a(new ShareDialogConfig(f.this.mContext, eVar, true, true));
                                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).bS("uid", TbadkCoreApplication.getCurrentAccount()).O(TiebaInitialize.Params.OBJ_PARAM2, 1).O(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hQF = postWriteCallBackData;
            this.jxd = postWriteCallBackData.mVideoTitleData != null;
            if (this.jxb != null && this.jxc != null && this.fEV != null && this.jxe != null) {
                am.setBackgroundColor(this.jxb, R.color.cp_link_tip_a);
                am.setViewTextColor(this.jxc, (int) R.color.cp_cont_a);
                am.setImageResource(this.fEV, R.drawable.icon_arrow_more_white);
                am.setBackgroundResource(this.jxe, R.drawable.immediately_share_background);
                this.jxb.setVisibility(0);
                this.jxb.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.jxd) {
                    this.jxc.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.jxc.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.jxb.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.jxb != null) {
            this.jxb.setVisibility(8);
        }
    }

    public void bmv() {
        if (this.jxf != null) {
            this.jxf.cancelLoadData();
        }
    }
}
