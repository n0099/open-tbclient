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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class f {
    private View fTg;
    private ImageView iTy;
    private PostWriteCallBackData lwm;
    private Context mContext;
    private View nnb;
    private TextView nnc;
    private boolean nnd;
    private TextView nne;
    private SendVideoSuccessShareModel nnf = new SendVideoSuccessShareModel();

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.fTg = viewGroup;
        if (this.mContext != null && this.fTg != null) {
            this.nnb = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.nnc = (TextView) this.nnb.findViewById(R.id.success_tip);
            this.iTy = (ImageView) this.nnb.findViewById(R.id.video_activity_btn);
            this.nne = (TextView) this.nnb.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.nnb.getParent() == null) {
                viewGroup.addView(this.nnb, layoutParams);
            }
            this.nnb.setVisibility(8);
            this.nnb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.nnd) {
                        f.this.hideTip();
                        if (f.this.lwm != null && !StringUtils.isNull(f.this.lwm.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.mContext, (String) null, f.this.lwm.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.nne.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.lwm != null && !StringUtils.isNull(f.this.lwm.getVideoid())) {
                        f.this.nnf.To(f.this.lwm.getVideoid());
                        f.this.nnf.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.fgp = false;
                                shareItem.fgm = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.d.f.coW().b(new ShareDialogConfig(f.this.mContext, shareItem, true, true));
                                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("uid", TbadkCoreApplication.getCurrentAccount()).ak(TiebaInitialize.Params.OBJ_PARAM2, 1).ak(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lwm = postWriteCallBackData;
            this.nnd = postWriteCallBackData.mVideoTitleData != null;
            if (this.nnb != null && this.nnc != null && this.iTy != null && this.nne != null) {
                ap.setBackgroundColor(this.nnb, R.color.CAM_X0302);
                ap.setViewTextColor(this.nnc, R.color.CAM_X0101);
                ap.setImageResource(this.iTy, R.drawable.icon_arrow_more_white);
                ap.setBackgroundResource(this.nne, R.drawable.immediately_share_background);
                this.nnb.setVisibility(0);
                this.nnb.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.nnd) {
                    this.nnc.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.nnc.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.nnb.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.nnb != null) {
            this.nnb.setVisibility(8);
        }
    }

    public void cAQ() {
        if (this.nnf != null) {
            this.nnf.cancelLoadData();
        }
    }
}
