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
    private View gkJ;
    private ImageView jqV;
    private PostWriteCallBackData lPq;
    private Context mContext;
    private View nFm;
    private TextView nFn;
    private boolean nFo;
    private TextView nFp;
    private SendVideoSuccessShareModel nFq = new SendVideoSuccessShareModel();

    public e(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.gkJ = viewGroup;
        if (this.mContext != null && this.gkJ != null) {
            this.nFm = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.nFn = (TextView) this.nFm.findViewById(R.id.success_tip);
            this.jqV = (ImageView) this.nFm.findViewById(R.id.video_activity_btn);
            this.nFp = (TextView) this.nFm.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.nFm.getParent() == null) {
                viewGroup.addView(this.nFm, layoutParams);
            }
            this.nFm.setVisibility(8);
            this.nFm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.nFo) {
                        e.this.hideTip();
                        if (e.this.lPq != null && !StringUtils.isNull(e.this.lPq.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(e.this.mContext, (String) null, e.this.lPq.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.nFp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.hideTip();
                    if (e.this.lPq != null && !StringUtils.isNull(e.this.lPq.getVideoid())) {
                        e.this.nFq.Uk(e.this.lPq.getVideoid());
                        e.this.nFq.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.video.e.2.1
                            @Override // com.baidu.adp.base.e
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.fxz = false;
                                shareItem.fxw = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.f.cwe().b(new ShareDialogConfig(e.this.mContext, shareItem, true, true));
                                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dX("uid", TbadkCoreApplication.getCurrentAccount()).an(TiebaInitialize.Params.OBJ_PARAM2, 1).an(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lPq = postWriteCallBackData;
            this.nFo = postWriteCallBackData.mVideoTitleData != null;
            if (this.nFm != null && this.nFn != null && this.jqV != null && this.nFp != null) {
                ao.setBackgroundColor(this.nFm, R.color.CAM_X0302);
                ao.setViewTextColor(this.nFn, R.color.CAM_X0101);
                ao.setImageResource(this.jqV, R.drawable.icon_arrow_more_white);
                ao.setBackgroundResource(this.nFp, R.drawable.immediately_share_background);
                this.nFm.setVisibility(0);
                this.nFm.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.hideTip();
                    }
                }, 5000L);
                if (this.nFo) {
                    this.nFn.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.nFn.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.nFm.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.nFm != null) {
            this.nFm.setVisibility(8);
        }
    }

    public void cIb() {
        if (this.nFq != null) {
            this.nFq.cancelLoadData();
        }
    }
}
