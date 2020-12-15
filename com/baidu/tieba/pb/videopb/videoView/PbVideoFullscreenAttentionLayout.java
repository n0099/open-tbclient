package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.ax;
import org.apache.http.HttpHost;
/* loaded from: classes22.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    private HeadImageView mdq;
    private PbVideoFullscreenLikeBtn mdr;
    private ax mds;
    private BdUniqueId uniqueId;

    public PbVideoFullscreenAttentionLayout(Context context) {
        super(context);
        init(context);
    }

    public PbVideoFullscreenAttentionLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public PbVideoFullscreenAttentionLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.pb_video_attention, this);
        this.mdq = (HeadImageView) findViewById(R.id.attention_img);
        this.mdr = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.mdq.setIsRound(true);
        this.mdq.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.mdq.setBorderColor(context.getResources().getColor(R.color.CAM_X0402));
        this.mdq.setAutoChangeStyle(false);
        this.mdr.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.mdr.setOnclickEvent(onClickListener);
    }

    public void setData(by byVar) {
        if (byVar != null && byVar.boP() != null) {
            String BR = q.BR(byVar.boP().getAvater());
            if (BR.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.mdq.startLoad(BR, 10, false);
            } else {
                this.mdq.startLoad(BR, 25, false);
            }
            if (byVar.boP().getBaijiahaoInfo() != null && byVar.boP().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.mdq.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(byVar.boP().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.mdq.setShowV(true);
                this.mdq.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.mdq.setBjhAuthIconRes(0);
                this.mdq.setIsBigV(byVar.boP().isBigV());
                this.mdq.setShowV(byVar.boP().isBigV());
            }
            aW(byVar);
        }
    }

    public void aW(by byVar) {
        if (byVar != null && byVar.boP() != null) {
            String str = byVar.tid;
            int aX = aX(byVar);
            if (this.mds == null) {
                if (getContext() instanceof PbActivity) {
                    this.mds = new ax(((PbActivity) getContext()).getPageContext(), this.mdr, -1);
                    this.mds.Bc("11");
                    this.mds.l(this.uniqueId);
                } else {
                    return;
                }
            }
            this.mds.a(byVar.boP());
            this.mds.setTid(str);
            this.mds.setThreadData(byVar);
            this.mds.lOY = true;
            this.mds.Hu(aX);
        }
    }

    public int aX(by byVar) {
        if (byVar == null) {
            return 0;
        }
        if (byVar.bqo()) {
            return !au.isEmpty(byVar.boT()) ? 2 : 0;
        }
        return 1;
    }

    public boolean dxi() {
        return (this.mds == null || this.mds.bwy() == null || !this.mds.bwy().getIsLike()) ? false : true;
    }
}
