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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class f {
    private View feu;
    private ImageView hQe;
    private PostWriteCallBackData kqk;
    private Context mContext;
    private View mbU;
    private TextView mbV;
    private boolean mbW;
    private TextView mbX;
    private SendVideoSuccessShareModel mbY = new SendVideoSuccessShareModel();

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.feu = viewGroup;
        if (this.mContext != null && this.feu != null) {
            this.mbU = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.mbV = (TextView) this.mbU.findViewById(R.id.success_tip);
            this.hQe = (ImageView) this.mbU.findViewById(R.id.video_activity_btn);
            this.mbX = (TextView) this.mbU.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.mbU.getParent() == null) {
                viewGroup.addView(this.mbU, layoutParams);
            }
            this.mbU.setVisibility(8);
            this.mbU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.mbW) {
                        f.this.hideTip();
                        if (f.this.kqk != null && !StringUtils.isNull(f.this.kqk.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.mContext, (String) null, f.this.kqk.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.mbX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.kqk != null && !StringUtils.isNull(f.this.kqk.getVideoid())) {
                        f.this.mbY.OB(f.this.kqk.getVideoid());
                        f.this.mbY.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.eud = false;
                                shareItem.eua = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.f.bSP().b(new ShareDialogConfig(f.this.mContext, shareItem, true, true));
                                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dn("uid", TbadkCoreApplication.getCurrentAccount()).ah(TiebaInitialize.Params.OBJ_PARAM2, 1).ah(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.kqk = postWriteCallBackData;
            this.mbW = postWriteCallBackData.mVideoTitleData != null;
            if (this.mbU != null && this.mbV != null && this.hQe != null && this.mbX != null) {
                ao.setBackgroundColor(this.mbU, R.color.cp_link_tip_a);
                ao.setViewTextColor(this.mbV, R.color.cp_cont_a);
                ao.setImageResource(this.hQe, R.drawable.icon_arrow_more_white);
                ao.setBackgroundResource(this.mbX, R.drawable.immediately_share_background);
                this.mbU.setVisibility(0);
                this.mbU.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.mbW) {
                    this.mbV.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.mbV.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.mbU.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.mbU != null) {
            this.mbU.setVisibility(8);
        }
    }

    public void ceq() {
        if (this.mbY != null) {
            this.mbY.cancelLoadData();
        }
    }
}
