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
public class e {
    private View giF;
    private ImageView jsj;
    private PostWriteCallBackData lTW;
    private Context mContext;
    private View nKR;
    private TextView nKS;
    private boolean nKT;
    private TextView nKU;
    private SendVideoSuccessShareModel nKV = new SendVideoSuccessShareModel();

    public e(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.giF = viewGroup;
        if (this.mContext != null && this.giF != null) {
            this.nKR = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.nKS = (TextView) this.nKR.findViewById(R.id.success_tip);
            this.jsj = (ImageView) this.nKR.findViewById(R.id.video_activity_btn);
            this.nKU = (TextView) this.nKR.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.nKR.getParent() == null) {
                viewGroup.addView(this.nKR, layoutParams);
            }
            this.nKR.setVisibility(8);
            this.nKR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.nKT) {
                        e.this.hideTip();
                        if (e.this.lTW != null && !StringUtils.isNull(e.this.lTW.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(e.this.mContext, (String) null, e.this.lTW.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.nKU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.hideTip();
                    if (e.this.lTW != null && !StringUtils.isNull(e.this.lTW.getVideoid())) {
                        e.this.nKV.Ul(e.this.lTW.getVideoid());
                        e.this.nKV.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.video.e.2.1
                            @Override // com.baidu.adp.base.e
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.fvi = false;
                                shareItem.fvf = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.f.ctG().b(new ShareDialogConfig(e.this.mContext, shareItem, true, true));
                                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("uid", TbadkCoreApplication.getCurrentAccount()).ap(TiebaInitialize.Params.OBJ_PARAM2, 1).ap(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lTW = postWriteCallBackData;
            this.nKT = postWriteCallBackData.mVideoTitleData != null;
            if (this.nKR != null && this.nKS != null && this.jsj != null && this.nKU != null) {
                ap.setBackgroundColor(this.nKR, R.color.CAM_X0302);
                ap.setViewTextColor(this.nKS, R.color.CAM_X0101);
                ap.setImageResource(this.jsj, R.drawable.icon_arrow_more_white);
                ap.setBackgroundResource(this.nKU, R.drawable.immediately_share_background);
                this.nKR.setVisibility(0);
                this.nKR.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.hideTip();
                    }
                }, 5000L);
                if (this.nKT) {
                    this.nKS.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.nKS.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.nKR.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.nKR != null) {
            this.nKR.setVisibility(8);
        }
    }

    public void cFE() {
        if (this.nKV != null) {
            this.nKV.cancelLoadData();
        }
    }
}
