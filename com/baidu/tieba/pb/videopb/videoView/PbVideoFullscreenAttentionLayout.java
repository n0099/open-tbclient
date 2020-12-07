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
    private HeadImageView mdo;
    private PbVideoFullscreenLikeBtn mdp;
    private ax mdq;
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
        this.mdo = (HeadImageView) findViewById(R.id.attention_img);
        this.mdp = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.mdo.setIsRound(true);
        this.mdo.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.mdo.setBorderColor(context.getResources().getColor(R.color.CAM_X0402));
        this.mdo.setAutoChangeStyle(false);
        this.mdp.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.mdp.setOnclickEvent(onClickListener);
    }

    public void setData(by byVar) {
        if (byVar != null && byVar.boP() != null) {
            String BR = q.BR(byVar.boP().getAvater());
            if (BR.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.mdo.startLoad(BR, 10, false);
            } else {
                this.mdo.startLoad(BR, 25, false);
            }
            if (byVar.boP().getBaijiahaoInfo() != null && byVar.boP().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.mdo.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(byVar.boP().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.mdo.setShowV(true);
                this.mdo.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.mdo.setBjhAuthIconRes(0);
                this.mdo.setIsBigV(byVar.boP().isBigV());
                this.mdo.setShowV(byVar.boP().isBigV());
            }
            aW(byVar);
        }
    }

    public void aW(by byVar) {
        if (byVar != null && byVar.boP() != null) {
            String str = byVar.tid;
            int aX = aX(byVar);
            if (this.mdq == null) {
                if (getContext() instanceof PbActivity) {
                    this.mdq = new ax(((PbActivity) getContext()).getPageContext(), this.mdp, -1);
                    this.mdq.Bc("11");
                    this.mdq.l(this.uniqueId);
                } else {
                    return;
                }
            }
            this.mdq.a(byVar.boP());
            this.mdq.setTid(str);
            this.mdq.setThreadData(byVar);
            this.mdq.lOW = true;
            this.mdq.Hu(aX);
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

    public boolean dxh() {
        return (this.mdq == null || this.mdq.bwy() == null || !this.mdq.bwy().getIsLike()) ? false : true;
    }
}
