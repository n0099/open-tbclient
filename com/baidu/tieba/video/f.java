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
    private View dWo;
    private ImageView gsx;
    private PostWriteCallBackData iEv;
    private View kqn;
    private TextView kqo;
    private boolean kqp;
    private TextView kqq;
    private SendVideoSuccessShareModel kqr = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.dWo = viewGroup;
        if (this.mContext != null && this.dWo != null) {
            this.kqn = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.kqo = (TextView) this.kqn.findViewById(R.id.success_tip);
            this.gsx = (ImageView) this.kqn.findViewById(R.id.video_activity_btn);
            this.kqq = (TextView) this.kqn.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.kqn.getParent() == null) {
                viewGroup.addView(this.kqn, layoutParams);
            }
            this.kqn.setVisibility(8);
            this.kqn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.kqp) {
                        f.this.hideTip();
                        if (f.this.iEv != null && !StringUtils.isNull(f.this.iEv.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.mContext, (String) null, f.this.iEv.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.kqq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.iEv != null && !StringUtils.isNull(f.this.iEv.getVideoid())) {
                        f.this.kqr.Jt(f.this.iEv.getVideoid());
                        f.this.kqr.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.dlP = false;
                                shareItem.dlM = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.e.btE().a(new ShareDialogConfig(f.this.mContext, shareItem, true, true));
                                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cp("uid", TbadkCoreApplication.getCurrentAccount()).Z(TiebaInitialize.Params.OBJ_PARAM2, 1).Z(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.iEv = postWriteCallBackData;
            this.kqp = postWriteCallBackData.mVideoTitleData != null;
            if (this.kqn != null && this.kqo != null && this.gsx != null && this.kqq != null) {
                am.setBackgroundColor(this.kqn, R.color.cp_link_tip_a);
                am.setViewTextColor(this.kqo, (int) R.color.cp_cont_a);
                am.setImageResource(this.gsx, R.drawable.icon_arrow_more_white);
                am.setBackgroundResource(this.kqq, R.drawable.immediately_share_background);
                this.kqn.setVisibility(0);
                this.kqn.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.kqp) {
                    this.kqo.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.kqo.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.kqn.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.kqn != null) {
            this.kqn.setVisibility(8);
        }
    }

    public void bDP() {
        if (this.kqr != null) {
            this.kqr.cancelLoadData();
        }
    }
}
