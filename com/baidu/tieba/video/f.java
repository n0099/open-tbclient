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
    private View cWI;
    private ImageView fyh;
    private PostWriteCallBackData hIU;
    private View jnv;
    private TextView jnw;
    private boolean jnx;
    private TextView jny;
    private SendVideoSuccessShareModel jnz = new SendVideoSuccessShareModel();
    private Context mContext;

    public f(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.cWI = viewGroup;
        if (this.mContext != null && this.cWI != null) {
            this.jnv = LayoutInflater.from(context).inflate(R.layout.send_video_success_tip, (ViewGroup) null);
            this.jnw = (TextView) this.jnv.findViewById(R.id.success_tip);
            this.fyh = (ImageView) this.jnv.findViewById(R.id.video_activity_btn);
            this.jny = (TextView) this.jnv.findViewById(R.id.video_share_btn);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, l.g(context, R.dimen.ds128));
            if (this.jnv.getParent() == null) {
                viewGroup.addView(this.jnv, layoutParams);
            }
            this.jnv.setVisibility(8);
            this.jnv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.jnx) {
                        f.this.hideTip();
                        if (f.this.hIU != null && !StringUtils.isNull(f.this.hIU.buildVideoFakeOnWallUrl())) {
                            com.baidu.tbadk.browser.a.k(f.this.mContext, null, f.this.hIU.buildVideoFakeOnWallUrl());
                        }
                    }
                }
            });
            this.jny.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.f.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hideTip();
                    if (f.this.hIU != null && !StringUtils.isNull(f.this.hIU.getVideoid())) {
                        f.this.jnz.EL(f.this.hIU.getVideoid());
                        f.this.jnz.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.video.f.2.1
                            @Override // com.baidu.adp.base.d
                            public void m(Object obj) {
                                com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
                                eVar.cjP = false;
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
            this.hIU = postWriteCallBackData;
            this.jnx = postWriteCallBackData.mVideoTitleData != null;
            if (this.jnv != null && this.jnw != null && this.fyh != null && this.jny != null) {
                al.l(this.jnv, R.color.cp_link_tip_a);
                al.j(this.jnw, R.color.cp_btn_a);
                al.c(this.fyh, (int) R.drawable.icon_arrow_more_white);
                al.k(this.jny, R.drawable.immediately_share_background);
                this.jnv.setVisibility(0);
                this.jnv.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.f.3
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.hideTip();
                    }
                }, 5000L);
                if (this.jnx) {
                    this.jnw.setText(R.string.video_activity_tip);
                } else if (!StringUtils.isNull(postWriteCallBackData.getErrorString())) {
                    this.jnw.setText(postWriteCallBackData.getErrorString());
                } else {
                    this.jnv.setVisibility(8);
                }
            }
        }
    }

    public void hideTip() {
        if (this.jnv != null) {
            this.jnv.setVisibility(8);
        }
    }

    public void bmr() {
        if (this.jnz != null) {
            this.jnz.cancelLoadData();
        }
    }
}
