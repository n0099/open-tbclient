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
    private View ebf;
    private ImageView gyG;
    private PostWriteCallBackData iLo;
    private View kwK;
    private TextView kwL;
    private boolean kwM;
    private TextView kwN;
    private SendVideoSuccessShareModel kwO = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.ebf = viewGroup;
        if (this.mContext != null && this.ebf != null) {
            this.kwK = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.kwL = (TextView) this.kwK.findViewById(R.id.success_tip);
            this.gyG = (ImageView) this.kwK.findViewById(R.id.video_activity_btn);
            this.kwN = (TextView) this.kwK.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.kwK.getParent() == null) {
                viewGroup.addView(this.kwK, layoutParams);
            }
            this.kwK.setVisibility(8);
            this.kwK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.kwM) {
                        f.this.hideTip();
                        if (f.this.iLo != null && !StringUtils.isNull(f.this.iLo.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.mContext, (String) null, f.this.iLo.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.kwN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.iLo != null && !StringUtils.isNull(f.this.iLo.getVideoid())) {
                        f.this.kwO.JR(f.this.iLo.getVideoid());
                        f.this.kwO.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.dqP = false;
                                shareItem.dqM = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.e.bws().b(new ShareDialogConfig(f.this.mContext, shareItem, true, true));
                                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cx("uid", TbadkCoreApplication.getCurrentAccount()).X(TiebaInitialize.Params.OBJ_PARAM2, 1).X(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.iLo = postWriteCallBackData;
            this.kwM = postWriteCallBackData.mVideoTitleData != null;
            if (this.kwK != null && this.kwL != null && this.gyG != null && this.kwN != null) {
                am.setBackgroundColor(this.kwK, R.color.cp_link_tip_a);
                am.setViewTextColor(this.kwL, (int) R.color.cp_cont_a);
                am.setImageResource(this.gyG, R.drawable.icon_arrow_more_white);
                am.setBackgroundResource(this.kwN, R.drawable.immediately_share_background);
                this.kwK.setVisibility(0);
                this.kwK.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.kwM) {
                    this.kwL.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.kwL.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.kwK.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.kwK != null) {
            this.kwK.setVisibility(8);
        }
    }

    public void bGI() {
        if (this.kwO != null) {
            this.kwO.cancelLoadData();
        }
    }
}
