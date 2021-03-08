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
    private View gki;
    private ImageView jtS;
    private PostWriteCallBackData lVY;
    private Context mContext;
    private View nMW;
    private TextView nMX;
    private boolean nMY;
    private TextView nMZ;
    private SendVideoSuccessShareModel nNa = new SendVideoSuccessShareModel();

    public e(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.gki = viewGroup;
        if (this.mContext != null && this.gki != null) {
            this.nMW = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.nMX = (TextView) this.nMW.findViewById(R.id.success_tip);
            this.jtS = (ImageView) this.nMW.findViewById(R.id.video_activity_btn);
            this.nMZ = (TextView) this.nMW.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.nMW.getParent() == null) {
                viewGroup.addView(this.nMW, layoutParams);
            }
            this.nMW.setVisibility(8);
            this.nMW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.nMY) {
                        e.this.hideTip();
                        if (e.this.lVY != null && !StringUtils.isNull(e.this.lVY.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(e.this.mContext, (String) null, e.this.lVY.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.nMZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.hideTip();
                    if (e.this.lVY != null && !StringUtils.isNull(e.this.lVY.getVideoid())) {
                        e.this.nNa.Us(e.this.lVY.getVideoid());
                        e.this.nNa.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.video.e.2.1
                            @Override // com.baidu.adp.base.e
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.fwH = false;
                                shareItem.fwE = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.f.ctM().b(new ShareDialogConfig(e.this.mContext, shareItem, true, true));
                                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("uid", TbadkCoreApplication.getCurrentAccount()).aq(TiebaInitialize.Params.OBJ_PARAM2, 1).aq(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lVY = postWriteCallBackData;
            this.nMY = postWriteCallBackData.mVideoTitleData != null;
            if (this.nMW != null && this.nMX != null && this.jtS != null && this.nMZ != null) {
                ap.setBackgroundColor(this.nMW, R.color.CAM_X0302);
                ap.setViewTextColor(this.nMX, R.color.CAM_X0101);
                ap.setImageResource(this.jtS, R.drawable.icon_arrow_more_white);
                ap.setBackgroundResource(this.nMZ, R.drawable.immediately_share_background);
                this.nMW.setVisibility(0);
                this.nMW.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.hideTip();
                    }
                }, 5000L);
                if (this.nMY) {
                    this.nMX.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.nMX.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.nMW.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.nMW != null) {
            this.nMW.setVisibility(8);
        }
    }

    public void cFK() {
        if (this.nNa != null) {
            this.nNa.cancelLoadData();
        }
    }
}
