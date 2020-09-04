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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class f {
    private View fpR;
    private ImageView iev;
    private PostWriteCallBackData kFL;
    private Context mContext;
    private View mtZ;
    private TextView mua;
    private boolean mub;
    private TextView muc;
    private SendVideoSuccessShareModel mud = new SendVideoSuccessShareModel();

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.fpR = viewGroup;
        if (this.mContext != null && this.fpR != null) {
            this.mtZ = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.mua = (TextView) this.mtZ.findViewById(R.id.success_tip);
            this.iev = (ImageView) this.mtZ.findViewById(R.id.video_activity_btn);
            this.muc = (TextView) this.mtZ.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.getDimens(context, R.dimen.ds128));
            if (this.mtZ.getParent() == null) {
                viewGroup.addView(this.mtZ, layoutParams);
            }
            this.mtZ.setVisibility(8);
            this.mtZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.mub) {
                        f.this.hideTip();
                        if (f.this.kFL != null && !StringUtils.isNull(f.this.kFL.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.startWebActivity(f.this.mContext, (String) null, f.this.kFL.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.muc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.kFL != null && !StringUtils.isNull(f.this.kFL.getVideoid())) {
                        f.this.mud.Rz(f.this.kFL.getVideoid());
                        f.this.mud.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void callback(Object obj) {
                                ShareItem shareItem = new ShareItem();
                                shareItem.eEH = false;
                                shareItem.eEE = OriginalThreadInfo.ShareInfo.generateShareInfo((OriginalThreadInfo) obj);
                                com.baidu.tieba.c.f.cdc().b(new ShareDialogConfig(f.this.mContext, shareItem, true, true));
                                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dD("uid", TbadkCoreApplication.getCurrentAccount()).ai(TiebaInitialize.Params.OBJ_PARAM2, 1).ai(TiebaInitialize.Params.OBJ_PARAM3, 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void i(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.kFL = postWriteCallBackData;
            this.mub = postWriteCallBackData.mVideoTitleData != null;
            if (this.mtZ != null && this.mua != null && this.iev != null && this.muc != null) {
                ap.setBackgroundColor(this.mtZ, R.color.cp_link_tip_a);
                ap.setViewTextColor(this.mua, R.color.cp_cont_a);
                ap.setImageResource(this.iev, R.drawable.icon_arrow_more_white);
                ap.setBackgroundResource(this.muc, R.drawable.immediately_share_background);
                this.mtZ.setVisibility(0);
                this.mtZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.mub) {
                    this.mua.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.mua.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.mtZ.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.mtZ != null) {
            this.mtZ.setVisibility(8);
        }
    }

    public void coV() {
        if (this.mud != null) {
            this.mud.cancelLoadData();
        }
    }
}
