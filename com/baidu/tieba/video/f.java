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
public class f {
    private View gbs;
    private ImageView jew;
    private PostWriteCallBackData lKb;
    private Context mContext;
    private View nBg;
    private TextView nBh;
    private boolean nBi;
    private TextView nBj;
    private SendVideoSuccessShareModel nBk = new SendVideoSuccessShareModel();

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.gbs = viewGroup;
        if (this.mContext != null && this.gbs != null) {
            this.nBg = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.nBh = (TextView) this.nBg.findViewById(R.id.success_tip);
            this.jew = (ImageView) this.nBg.findViewById(R.id.video_activity_btn);
            this.nBj = (TextView) this.nBg.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.nBg.getParent() == null) {
                viewGroup.addView(this.nBg, layoutParams);
            }
            this.nBg.setVisibility(8);
            this.nBg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.nBi) {
                        f.this.hideTip();
                        if (f.this.lKb != null && !StringUtils.isNull(f.this.lKb.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.mContext, (String) null, f.this.lKb.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.nBj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.lKb != null && !StringUtils.isNull(f.this.lKb.getVideoid())) {
                        f.this.nBk.UD(f.this.lKb.getVideoid());
                        f.this.nBk.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.fnP = false;
                                shareItem.fnM = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.d.f.ctl().b(new ShareDialogConfig(f.this.mContext, shareItem, true, true));
                                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dY("uid", TbadkCoreApplication.getCurrentAccount()).al(TiebaInitialize.Params.OBJ_PARAM2, 1).al(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lKb = postWriteCallBackData;
            this.nBi = postWriteCallBackData.mVideoTitleData != null;
            if (this.nBg != null && this.nBh != null && this.jew != null && this.nBj != null) {
                ap.setBackgroundColor(this.nBg, R.color.CAM_X0302);
                ap.setViewTextColor(this.nBh, R.color.CAM_X0101);
                ap.setImageResource(this.jew, R.drawable.icon_arrow_more_white);
                ap.setBackgroundResource(this.nBj, R.drawable.immediately_share_background);
                this.nBg.setVisibility(0);
                this.nBg.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.nBi) {
                    this.nBh.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.nBh.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.nBg.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.nBg != null) {
            this.nBg.setVisibility(8);
        }
    }

    public void cFh() {
        if (this.nBk != null) {
            this.nBk.cancelLoadData();
        }
    }
}
