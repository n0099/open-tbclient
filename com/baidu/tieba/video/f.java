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
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class f {
    private View diF;
    private ImageView fEe;
    private PostWriteCallBackData hPO;
    private View jwk;
    private TextView jwl;
    private boolean jwm;
    private TextView jwn;
    private SendVideoSuccessShareModel jwo = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.diF = viewGroup;
        if (this.mContext != null && this.diF != null) {
            this.jwk = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.jwl = (TextView) this.jwk.findViewById(R.id.success_tip);
            this.fEe = (ImageView) this.jwk.findViewById(R.id.video_activity_btn);
            this.jwn = (TextView) this.jwk.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.jwk.getParent() == null) {
                viewGroup.addView(this.jwk, layoutParams);
            }
            this.jwk.setVisibility(8);
            this.jwk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.jwm) {
                        f.this.hideTip();
                        if (f.this.hPO != null && !StringUtils.isNull(f.this.hPO.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.mContext, (String) null, f.this.hPO.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.jwn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.hPO != null && !StringUtils.isNull(f.this.hPO.getVideoid())) {
                        f.this.jwo.EE(f.this.hPO.getVideoid());
                        f.this.jwo.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
                                eVar.cyg = false;
                                eVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.c.e.bch().a(new ShareDialogConfig(f.this.mContext, eVar, true, true));
                                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).bS("uid", TbadkCoreApplication.getCurrentAccount()).O(TiebaInitialize.Params.OBJ_PARAM2, 1).O(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hPO = postWriteCallBackData;
            this.jwm = postWriteCallBackData.mVideoTitleData != null;
            if (this.jwk != null && this.jwl != null && this.fEe != null && this.jwn != null) {
                am.setBackgroundColor(this.jwk, R.color.cp_link_tip_a);
                am.setViewTextColor(this.jwl, (int) R.color.cp_cont_a);
                am.setImageResource(this.fEe, R.drawable.icon_arrow_more_white);
                am.setBackgroundResource(this.jwn, R.drawable.immediately_share_background);
                this.jwk.setVisibility(0);
                this.jwk.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.jwm) {
                    this.jwl.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.jwl.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.jwk.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.jwk != null) {
            this.jwk.setVisibility(8);
        }
    }

    public void bmt() {
        if (this.jwo != null) {
            this.jwo.cancelLoadData();
        }
    }
}
