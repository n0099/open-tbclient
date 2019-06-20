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
    private View cWJ;
    private ImageView fyh;
    private PostWriteCallBackData hIV;
    private TextView jnA;
    private boolean jnB;
    private TextView jnC;
    private SendVideoSuccessShareModel jnD = new SendVideoSuccessShareModel();
    private View jnz;
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.cWJ = viewGroup;
        if (this.mContext != null && this.cWJ != null) {
            this.jnz = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.jnA = (TextView) this.jnz.findViewById(R.id.success_tip);
            this.fyh = (ImageView) this.jnz.findViewById(R.id.video_activity_btn);
            this.jnC = (TextView) this.jnz.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.g(context, R.dimen.ds128));
            if (this.jnz.getParent() == null) {
                viewGroup.addView(this.jnz, layoutParams);
            }
            this.jnz.setVisibility(8);
            this.jnz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.jnB) {
                        f.this.hideTip();
                        if (f.this.hIV != null && !StringUtils.isNull(f.this.hIV.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.k(f.this.mContext, null, f.this.hIV.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.jnC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.hIV != null && !StringUtils.isNull(f.this.hIV.getVideoid())) {
                        f.this.jnD.EN(f.this.hIV.getVideoid());
                        f.this.jnD.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
                                eVar.cjQ = false;
                                eVar.originalThreadInfo = (OriginalThreadInfo) obj;
                                com.baidu.tieba.c.e.aZC().a(new ShareDialogConfig(f.this.mContext, eVar, true, true));
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
            this.hIV = postWriteCallBackData;
            this.jnB = postWriteCallBackData.mVideoTitleData != null;
            if (this.jnz != null && this.jnA != null && this.fyh != null && this.jnC != null) {
                al.l(this.jnz, R.color.cp_link_tip_a);
                al.j(this.jnA, R.color.cp_btn_a);
                al.c(this.fyh, (int) R.drawable.icon_arrow_more_white);
                al.k(this.jnC, R.drawable.immediately_share_background);
                this.jnz.setVisibility(0);
                this.jnz.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.jnB) {
                    this.jnA.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.jnA.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.jnz.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.jnz != null) {
            this.jnz.setVisibility(8);
        }
    }

    public void bmr() {
        if (this.jnD != null) {
            this.jnD.cancelLoadData();
        }
    }
}
