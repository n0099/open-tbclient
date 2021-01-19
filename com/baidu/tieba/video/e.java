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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class e {
    private View ggb;
    private ImageView jmo;
    private PostWriteCallBackData lKL;
    private Context mContext;
    private View nAH;
    private TextView nAI;
    private boolean nAJ;
    private TextView nAK;
    private SendVideoSuccessShareModel nAL = new SendVideoSuccessShareModel();

    public e(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.ggb = viewGroup;
        if (this.mContext != null && this.ggb != null) {
            this.nAH = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.nAI = (TextView) this.nAH.findViewById(R.id.success_tip);
            this.jmo = (ImageView) this.nAH.findViewById(R.id.video_activity_btn);
            this.nAK = (TextView) this.nAH.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.nAH.getParent() == null) {
                viewGroup.addView(this.nAH, layoutParams);
            }
            this.nAH.setVisibility(8);
            this.nAH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.nAJ) {
                        e.this.hideTip();
                        if (e.this.lKL != null && !StringUtils.isNull(e.this.lKL.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(e.this.mContext, (String) null, e.this.lKL.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.nAK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.hideTip();
                    if (e.this.lKL != null && !StringUtils.isNull(e.this.lKL.getVideoid())) {
                        e.this.nAL.Tc(e.this.lKL.getVideoid());
                        e.this.nAL.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.video.e.2.1
                            @Override // com.baidu.adp.base.e
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.fsQ = false;
                                shareItem.fsN = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.f.csn().b(new ShareDialogConfig(e.this.mContext, shareItem, true, true));
                                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dW("uid", TbadkCoreApplication.getCurrentAccount()).an(TiebaInitialize.Params.OBJ_PARAM2, 1).an(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lKL = postWriteCallBackData;
            this.nAJ = postWriteCallBackData.mVideoTitleData != null;
            if (this.nAH != null && this.nAI != null && this.jmo != null && this.nAK != null) {
                ao.setBackgroundColor(this.nAH, R.color.CAM_X0302);
                ao.setViewTextColor(this.nAI, R.color.CAM_X0101);
                ao.setImageResource(this.jmo, R.drawable.icon_arrow_more_white);
                ao.setBackgroundResource(this.nAK, R.drawable.immediately_share_background);
                this.nAH.setVisibility(0);
                this.nAH.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.hideTip();
                    }
                }, 5000L);
                if (this.nAJ) {
                    this.nAI.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.nAI.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.nAH.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.nAH != null) {
            this.nAH.setVisibility(8);
        }
    }

    public void cEk() {
        if (this.nAL != null) {
            this.nAL.cancelLoadData();
        }
    }
}
