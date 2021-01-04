package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.an;
import com.tencent.connect.common.Constants;
import org.apache.http.HttpHost;
/* loaded from: classes2.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    private HeadImageView miE;
    private PbVideoFullscreenLikeBtn miF;
    private an miG;
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
        this.miE = (HeadImageView) findViewById(R.id.attention_img);
        this.miF = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.miE.setIsRound(true);
        this.miE.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.miE.setBorderColor(context.getResources().getColor(R.color.CAM_X0402));
        this.miE.setAutoChangeStyle(false);
        this.miF.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.miF.setOnclickEvent(onClickListener);
    }

    public void setData(bz bzVar) {
        if (bzVar != null && bzVar.brq() != null) {
            String BQ = q.BQ(bzVar.brq().getAvater());
            if (BQ.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.miE.startLoad(BQ, 10, false);
            } else {
                this.miE.startLoad(BQ, 25, false);
            }
            if (bzVar.brq().getBaijiahaoInfo() != null && bzVar.brq().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.miE.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(bzVar.brq().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.miE.setShowV(true);
                this.miE.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.miE.setBjhAuthIconRes(0);
                this.miE.setIsBigV(bzVar.brq().isBigV());
                this.miE.setShowV(bzVar.brq().isBigV());
            }
            aX(bzVar);
        }
    }

    public void aX(bz bzVar) {
        if (bzVar != null && bzVar.brq() != null) {
            String str = bzVar.tid;
            int aY = aY(bzVar);
            if (this.miG == null) {
                if (getContext() instanceof PbActivity) {
                    this.miG = new an(((PbActivity) getContext()).getPageContext(), this.miF, -1);
                    this.miG.Bb(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                    this.miG.l(this.uniqueId);
                } else {
                    return;
                }
            }
            this.miG.a(bzVar.brq());
            this.miG.setTid(str);
            this.miG.setThreadData(bzVar);
            this.miG.lUk = true;
            this.miG.Hn(aY);
        }
    }

    public int aY(bz bzVar) {
        if (bzVar == null) {
            return 0;
        }
        if (bzVar.bsQ()) {
            return !at.isEmpty(bzVar.bru()) ? 2 : 0;
        }
        return 1;
    }

    public boolean dwX() {
        return (this.miG == null || this.miG.byR() == null || !this.miG.byR().getIsLike()) ? false : true;
    }
}
