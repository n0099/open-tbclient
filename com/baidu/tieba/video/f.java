package com.baidu.tieba.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes.dex */
public class f {
    private View cWH;
    private ImageView fyg;
    private PostWriteCallBackData hIR;
    private View jnu;
    private TextView jnv;
    private boolean jnw;
    private TextView jnx;
    private SendVideoSuccessShareModel jny = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.cWH = viewGroup;
        if (this.mContext != null && this.cWH != null) {
            this.jnu = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.jnv = (TextView) this.jnu.findViewById(R.id.success_tip);
            this.fyg = (ImageView) this.jnu.findViewById(R.id.video_activity_btn);
            this.jnx = (TextView) this.jnu.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.g(context, R.dimen.ds128));
            if (this.jnu.getParent() == null) {
                viewGroup.addView(this.jnu, layoutParams);
            }
            this.jnu.setVisibility(8);
            this.jnu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.jnw) {
                        f.this.hideTip();
                        if (f.this.hIR != null && !StringUtils.isNull(f.this.hIR.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.k(f.this.mContext, null, f.this.hIR.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.jnx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.hIR != null && !StringUtils.isNull(f.this.hIR.getVideoid())) {
                        f.this.jny.EL(f.this.hIR.getVideoid());
                        f.this.jny.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
                                eVar.cjP = false;
                                eVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.c.e.aZz().a(new ShareDialogConfig(f.this.mContext, eVar, true, true));
                                TiebaStatic.log(new am("c10125").bT("uid", TbadkCoreApplication.getCurrentAccount()).P("obj_param2", 1).P("obj_param3", 1));
                            }
                        });
                    }
                }
            });
        }
    }

    public void h(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            this.hIR = postWriteCallBackData;
            this.jnw = postWriteCallBackData.mVideoTitleData != null;
            if (this.jnu != null && this.jnv != null && this.fyg != null && this.jnx != null) {
                al.l(this.jnu, R.color.cp_link_tip_a);
                al.j(this.jnv, R.color.cp_btn_a);
                al.c(this.fyg, (int) R.drawable.icon_arrow_more_white);
                al.k(this.jnx, R.drawable.immediately_share_background);
                this.jnu.setVisibility(0);
                this.jnu.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.jnw) {
                    this.jnv.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.jnv.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.jnu.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.jnu != null) {
            this.jnu.setVisibility(8);
        }
    }

    public void bmo() {
        if (this.jny != null) {
            this.jny.cancelLoadData();
        }
    }
}
