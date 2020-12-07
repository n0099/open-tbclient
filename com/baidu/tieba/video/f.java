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
    private View gbq;
    private ImageView jeu;
    private PostWriteCallBackData lJZ;
    private Context mContext;
    private View nBe;
    private TextView nBf;
    private boolean nBg;
    private TextView nBh;
    private SendVideoSuccessShareModel nBi = new SendVideoSuccessShareModel();

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.gbq = viewGroup;
        if (this.mContext != null && this.gbq != null) {
            this.nBe = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.nBf = (TextView) this.nBe.findViewById(R.id.success_tip);
            this.jeu = (ImageView) this.nBe.findViewById(R.id.video_activity_btn);
            this.nBh = (TextView) this.nBe.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.nBe.getParent() == null) {
                viewGroup.addView(this.nBe, layoutParams);
            }
            this.nBe.setVisibility(8);
            this.nBe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.nBg) {
                        f.this.hideTip();
                        if (f.this.lJZ != null && !StringUtils.isNull(f.this.lJZ.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.mContext, (String) null, f.this.lJZ.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.nBh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.lJZ != null && !StringUtils.isNull(f.this.lJZ.getVideoid())) {
                        f.this.nBi.UD(f.this.lJZ.getVideoid());
                        f.this.nBi.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.fnP = false;
                                shareItem.fnM = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.d.f.ctk().b(new ShareDialogConfig(f.this.mContext, shareItem, true, true));
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
            this.lJZ = postWriteCallBackData;
            this.nBg = postWriteCallBackData.mVideoTitleData != null;
            if (this.nBe != null && this.nBf != null && this.jeu != null && this.nBh != null) {
                ap.setBackgroundColor(this.nBe, R.color.CAM_X0302);
                ap.setViewTextColor(this.nBf, R.color.CAM_X0101);
                ap.setImageResource(this.jeu, R.drawable.icon_arrow_more_white);
                ap.setBackgroundResource(this.nBh, R.drawable.immediately_share_background);
                this.nBe.setVisibility(0);
                this.nBe.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.nBg) {
                    this.nBf.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.nBf.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.nBe.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.nBe != null) {
            this.nBe.setVisibility(8);
        }
    }

    public void cFg() {
        if (this.nBi != null) {
            this.nBi.cancelLoadData();
        }
    }
}
