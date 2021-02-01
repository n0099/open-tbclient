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
    private View gir;
    private ImageView jrV;
    private PostWriteCallBackData lTH;
    private Context mContext;
    private View nKr;
    private TextView nKs;
    private boolean nKt;
    private TextView nKu;
    private SendVideoSuccessShareModel nKv = new SendVideoSuccessShareModel();

    public e(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.gir = viewGroup;
        if (this.mContext != null && this.gir != null) {
            this.nKr = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.nKs = (TextView) this.nKr.findViewById(R.id.success_tip);
            this.jrV = (ImageView) this.nKr.findViewById(R.id.video_activity_btn);
            this.nKu = (TextView) this.nKr.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.nKr.getParent() == null) {
                viewGroup.addView(this.nKr, layoutParams);
            }
            this.nKr.setVisibility(8);
            this.nKr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.nKt) {
                        e.this.hideTip();
                        if (e.this.lTH != null && !StringUtils.isNull(e.this.lTH.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(e.this.mContext, (String) null, e.this.lTH.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.nKu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.hideTip();
                    if (e.this.lTH != null && !StringUtils.isNull(e.this.lTH.getVideoid())) {
                        e.this.nKv.TZ(e.this.lTH.getVideoid());
                        e.this.nKv.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.video.e.2.1
                            @Override // com.baidu.adp.base.e
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.fvi = false;
                                shareItem.fvf = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.f.ctz().b(new ShareDialogConfig(e.this.mContext, shareItem, true, true));
                                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("uid", TbadkCoreApplication.getCurrentAccount()).ap(TiebaInitialize.Params.OBJ_PARAM2, 1).ap(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.lTH = postWriteCallBackData;
            this.nKt = postWriteCallBackData.mVideoTitleData != null;
            if (this.nKr != null && this.nKs != null && this.jrV != null && this.nKu != null) {
                ap.setBackgroundColor(this.nKr, R.color.CAM_X0302);
                ap.setViewTextColor(this.nKs, R.color.CAM_X0101);
                ap.setImageResource(this.jrV, R.drawable.icon_arrow_more_white);
                ap.setBackgroundResource(this.nKu, R.drawable.immediately_share_background);
                this.nKr.setVisibility(0);
                this.nKr.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.hideTip();
                    }
                }, 5000L);
                if (this.nKt) {
                    this.nKs.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.nKs.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.nKr.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.nKr != null) {
            this.nKr.setVisibility(8);
        }
    }

    public void cFx() {
        if (this.nKv != null) {
            this.nKv.cancelLoadData();
        }
    }
}
