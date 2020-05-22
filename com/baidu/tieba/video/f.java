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
    private View ePw;
    private ImageView hwV;
    private PostWriteCallBackData jMA;
    private View lzM;
    private TextView lzN;
    private boolean lzO;
    private TextView lzP;
    private SendVideoSuccessShareModel lzQ = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.ePw = viewGroup;
        if (this.mContext != null && this.ePw != null) {
            this.lzM = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.lzN = (TextView) this.lzM.findViewById(R.id.success_tip);
            this.hwV = (ImageView) this.lzM.findViewById(R.id.video_activity_btn);
            this.lzP = (TextView) this.lzM.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.lzM.getParent() == null) {
                viewGroup.addView(this.lzM, layoutParams);
            }
            this.lzM.setVisibility(8);
            this.lzM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.lzO) {
                        f.this.hideTip();
                        if (f.this.jMA != null && !StringUtils.isNull(f.this.jMA.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.mContext, (String) null, f.this.jMA.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.lzP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.jMA != null && !StringUtils.isNull(f.this.jMA.getVideoid())) {
                        f.this.lzQ.Nq(f.this.jMA.getVideoid());
                        f.this.lzQ.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.efg = false;
                                shareItem.efd = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.e.bMw().b(new ShareDialogConfig(f.this.mContext, shareItem, true, true));
                                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dh("uid", TbadkCoreApplication.getCurrentAccount()).ag(TiebaInitialize.Params.OBJ_PARAM2, 1).ag(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.jMA = postWriteCallBackData;
            this.lzO = postWriteCallBackData.mVideoTitleData != null;
            if (this.lzM != null && this.lzN != null && this.hwV != null && this.lzP != null) {
                am.setBackgroundColor(this.lzM, R.color.cp_link_tip_a);
                am.setViewTextColor(this.lzN, (int) R.color.cp_cont_a);
                am.setImageResource(this.hwV, R.drawable.icon_arrow_more_white);
                am.setBackgroundResource(this.lzP, R.drawable.immediately_share_background);
                this.lzM.setVisibility(0);
                this.lzM.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.lzO) {
                    this.lzN.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.lzN.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.lzM.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.lzM != null) {
            this.lzM.setVisibility(8);
        }
    }

    public void bXE() {
        if (this.lzQ != null) {
            this.lzQ.cancelLoadData();
        }
    }
}
