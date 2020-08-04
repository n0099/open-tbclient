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
    private ImageView hQg;
    private PostWriteCallBackData kqm;
    private Context mContext;
    private View mbW;
    private TextView mbX;
    private boolean mbY;
    private TextView mbZ;
    private SendVideoSuccessShareModel mca = new SendVideoSuccessShareModel();

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.feu = viewGroup;
        if (this.mContext != null && this.feu != null) {
            this.mbW = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.mbX = (TextView) this.mbW.findViewById(R.id.success_tip);
            this.hQg = (ImageView) this.mbW.findViewById(R.id.video_activity_btn);
            this.mbZ = (TextView) this.mbW.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.mbW.getParent() == null) {
                viewGroup.addView(this.mbW, layoutParams);
            }
            this.mbW.setVisibility(8);
            this.mbW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.mbY) {
                        f.this.hideTip();
                        if (f.this.kqm != null && !StringUtils.isNull(f.this.kqm.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.mContext, (String) null, f.this.kqm.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.mbZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.kqm != null && !StringUtils.isNull(f.this.kqm.getVideoid())) {
                        f.this.mca.OB(f.this.kqm.getVideoid());
                        f.this.mca.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
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
            this.kqm = postWriteCallBackData;
            this.mbY = postWriteCallBackData.mVideoTitleData != null;
            if (this.mbW != null && this.mbX != null && this.hQg != null && this.mbZ != null) {
                ao.setBackgroundColor(this.mbW, R.color.cp_link_tip_a);
                ao.setViewTextColor(this.mbX, R.color.cp_cont_a);
                ao.setImageResource(this.hQg, R.drawable.icon_arrow_more_white);
                ao.setBackgroundResource(this.mbZ, R.drawable.immediately_share_background);
                this.mbW.setVisibility(0);
                this.mbW.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.mbY) {
                    this.mbX.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.mbX.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.mbW.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.mbW != null) {
            this.mbW.setVisibility(8);
        }
    }

    public void ceq() {
        if (this.mca != null) {
            this.mca.cancelLoadData();
        }
    }
}
