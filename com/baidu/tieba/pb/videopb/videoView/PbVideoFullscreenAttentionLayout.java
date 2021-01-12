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
    private HeadImageView mdW;
    private PbVideoFullscreenLikeBtn mdX;
    private an mdY;
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
        this.mdW = (HeadImageView) findViewById(R.id.attention_img);
        this.mdX = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.mdW.setIsRound(true);
        this.mdW.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.mdW.setBorderColor(context.getResources().getColor(R.color.CAM_X0402));
        this.mdW.setAutoChangeStyle(false);
        this.mdX.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.mdX.setOnclickEvent(onClickListener);
    }

    public void setData(bz bzVar) {
        if (bzVar != null && bzVar.bnx() != null) {
            String AE = q.AE(bzVar.bnx().getAvater());
            if (AE.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.mdW.startLoad(AE, 10, false);
            } else {
                this.mdW.startLoad(AE, 25, false);
            }
            if (bzVar.bnx().getBaijiahaoInfo() != null && bzVar.bnx().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.mdW.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(bzVar.bnx().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.mdW.setShowV(true);
                this.mdW.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.mdW.setBjhAuthIconRes(0);
                this.mdW.setIsBigV(bzVar.bnx().isBigV());
                this.mdW.setShowV(bzVar.bnx().isBigV());
            }
            aX(bzVar);
        }
    }

    public void aX(bz bzVar) {
        if (bzVar != null && bzVar.bnx() != null) {
            String str = bzVar.tid;
            int aY = aY(bzVar);
            if (this.mdY == null) {
                if (getContext() instanceof PbActivity) {
                    this.mdY = new an(((PbActivity) getContext()).getPageContext(), this.mdX, -1);
                    this.mdY.zP(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                    this.mdY.l(this.uniqueId);
                } else {
                    return;
                }
            }
            this.mdY.a(bzVar.bnx());
            this.mdY.setTid(str);
            this.mdY.setThreadData(bzVar);
            this.mdY.lPF = true;
            this.mdY.FH(aY);
        }
    }

    public int aY(bz bzVar) {
        if (bzVar == null) {
            return 0;
        }
        if (bzVar.boX()) {
            return !at.isEmpty(bzVar.bnB()) ? 2 : 0;
        }
        return 1;
    }

    public boolean dtg() {
        return (this.mdY == null || this.mdY.buY() == null || !this.mdY.buY().getIsLike()) ? false : true;
    }
}
