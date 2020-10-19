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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class f {
    private View fFo;
    private ImageView iAs;
    private PostWriteCallBackData ldw;
    private Context mContext;
    private TextView mTA;
    private SendVideoSuccessShareModel mTB = new SendVideoSuccessShareModel();
    private View mTx;
    private TextView mTy;
    private boolean mTz;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.fFo = viewGroup;
        if (this.mContext != null && this.fFo != null) {
            this.mTx = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.mTy = (TextView) this.mTx.findViewById(R.id.success_tip);
            this.iAs = (ImageView) this.mTx.findViewById(R.id.video_activity_btn);
            this.mTA = (TextView) this.mTx.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.mTx.getParent() == null) {
                viewGroup.addView(this.mTx, layoutParams);
            }
            this.mTx.setVisibility(8);
            this.mTx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.mTz) {
                        f.this.hideTip();
                        if (f.this.ldw != null && !StringUtils.isNull(f.this.ldw.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.mContext, (String) null, f.this.ldw.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.mTA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.ldw != null && !StringUtils.isNull(f.this.ldw.getVideoid())) {
                        f.this.mTB.SN(f.this.ldw.getVideoid());
                        f.this.mTB.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.eSU = false;
                                shareItem.eSR = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.f.cjN().b(new ShareDialogConfig(f.this.mContext, shareItem, true, true));
                                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dK("uid", TbadkCoreApplication.getCurrentAccount()).aj(TiebaInitialize.Params.OBJ_PARAM2, 1).aj(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.ldw = postWriteCallBackData;
            this.mTz = postWriteCallBackData.mVideoTitleData != null;
            if (this.mTx != null && this.mTy != null && this.iAs != null && this.mTA != null) {
                ap.setBackgroundColor(this.mTx, R.color.cp_link_tip_a);
                ap.setViewTextColor(this.mTy, R.color.cp_cont_a);
                ap.setImageResource(this.iAs, R.drawable.icon_arrow_more_white);
                ap.setBackgroundResource(this.mTA, R.drawable.immediately_share_background);
                this.mTx.setVisibility(0);
                this.mTx.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.mTz) {
                    this.mTy.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.mTy.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.mTx.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.mTx != null) {
            this.mTx.setVisibility(8);
        }
    }

    public void cvF() {
        if (this.mTB != null) {
            this.mTB.cancelLoadData();
        }
    }
}
