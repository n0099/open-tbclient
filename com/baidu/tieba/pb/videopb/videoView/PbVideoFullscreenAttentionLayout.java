package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.ax;
import org.apache.http.HttpHost;
/* loaded from: classes16.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    private HeadImageView kIJ;
    private PbVideoFullscreenLikeBtn kIK;
    private ax kIL;
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
        this.kIJ = (HeadImageView) findViewById(R.id.attention_img);
        this.kIK = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.kIJ.setIsRound(true);
        this.kIJ.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.kIJ.setBorderColor(context.getResources().getColor(R.color.cp_border_b));
        this.kIJ.setAutoChangeStyle(false);
        this.kIK.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.kIK.setOnclickEvent(onClickListener);
    }

    public void setData(bv bvVar) {
        if (bvVar != null && bvVar.aWl() != null) {
            String xH = q.xH(bvVar.aWl().getAvater());
            if (xH.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.kIJ.startLoad(xH, 10, false);
            } else {
                this.kIJ.startLoad(xH, 25, false);
            }
            if (bvVar.aWl().getBaijiahaoInfo() != null && bvVar.aWl().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.kIJ.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(bvVar.aWl().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.kIJ.setShowV(true);
                this.kIJ.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.kIJ.setBjhAuthIconRes(0);
                this.kIJ.setIsBigV(bvVar.aWl().isBigV());
                this.kIJ.setShowV(bvVar.aWl().isBigV());
            }
            aS(bvVar);
        }
    }

    public void aS(bv bvVar) {
        if (bvVar != null && bvVar.aWl() != null) {
            String str = bvVar.tid;
            int aT = aT(bvVar);
            if (this.kIL == null) {
                if (getContext() instanceof PbActivity) {
                    this.kIL = new ax(((PbActivity) getContext()).getPageContext(), this.kIK, -1);
                    this.kIL.wX("11");
                    this.kIL.m(this.uniqueId);
                } else {
                    return;
                }
            }
            this.kIL.a(bvVar.aWl());
            this.kIL.setTid(str);
            this.kIL.setThreadData(bvVar);
            this.kIL.kuS = true;
            this.kIL.BZ(aT);
        }
    }

    public int aT(bv bvVar) {
        if (bvVar == null) {
            return 0;
        }
        if (bvVar.aXI()) {
            return !as.isEmpty(bvVar.aWp()) ? 2 : 0;
        }
        return 1;
    }

    public boolean cUu() {
        return (this.kIL == null || this.kIL.bdf() == null || !this.kIL.bdf().getIsLike()) ? false : true;
    }
}
