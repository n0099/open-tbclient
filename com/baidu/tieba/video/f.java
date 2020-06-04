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
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class f {
    private View ePH;
    private ImageView hxg;
    private PostWriteCallBackData jNG;
    private View lAV;
    private TextView lAW;
    private boolean lAX;
    private TextView lAY;
    private SendVideoSuccessShareModel lAZ = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.ePH = viewGroup;
        if (this.mContext != null && this.ePH != null) {
            this.lAV = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.lAW = (TextView) this.lAV.findViewById(R.id.success_tip);
            this.hxg = (ImageView) this.lAV.findViewById(R.id.video_activity_btn);
            this.lAY = (TextView) this.lAV.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.lAV.getParent() == null) {
                viewGroup.addView(this.lAV, layoutParams);
            }
            this.lAV.setVisibility(8);
            this.lAV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.lAX) {
                        f.this.hideTip();
                        if (f.this.jNG != null && !StringUtils.isNull(f.this.jNG.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.mContext, (String) null, f.this.jNG.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.lAY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.jNG != null && !StringUtils.isNull(f.this.jNG.getVideoid())) {
                        f.this.lAZ.Nr(f.this.jNG.getVideoid());
                        f.this.lAZ.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.efg = false;
                                shareItem.efd = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.e.bMy().b(new ShareDialogConfig(f.this.mContext, shareItem, true, true));
                                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dh("uid", TbadkCoreApplication.getCurrentAccount()).ag(TiebaInitialize.Params.OBJ_PARAM2, 1).ag(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jNG = postWriteCallBackData;
            this.lAX = postWriteCallBackData.mVideoTitleData != null;
            if (this.lAV != null && this.lAW != null && this.hxg != null && this.lAY != null) {
                am.setBackgroundColor(this.lAV, R.color.cp_link_tip_a);
                am.setViewTextColor(this.lAW, (int) R.color.cp_cont_a);
                am.setImageResource(this.hxg, R.drawable.icon_arrow_more_white);
                am.setBackgroundResource(this.lAY, R.drawable.immediately_share_background);
                this.lAV.setVisibility(0);
                this.lAV.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.lAX) {
                    this.lAW.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.lAW.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.lAV.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.lAV != null) {
            this.lAV.setVisibility(8);
        }
    }

    public void bXG() {
        if (this.lAZ != null) {
            this.lAZ.cancelLoadData();
        }
    }
}
