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
    private HeadImageView kIH;
    private PbVideoFullscreenLikeBtn kII;
    private ax kIJ;
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
        this.kIH = (HeadImageView) findViewById(R.id.attention_img);
        this.kII = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.kIH.setIsRound(true);
        this.kIH.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.kIH.setBorderColor(context.getResources().getColor(R.color.cp_border_b));
        this.kIH.setAutoChangeStyle(false);
        this.kII.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.kII.setOnclickEvent(onClickListener);
    }

    public void setData(bv bvVar) {
        if (bvVar != null && bvVar.aWl() != null) {
            String xH = q.xH(bvVar.aWl().getAvater());
            if (xH.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.kIH.startLoad(xH, 10, false);
            } else {
                this.kIH.startLoad(xH, 25, false);
            }
            if (bvVar.aWl().getBaijiahaoInfo() != null && bvVar.aWl().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.kIH.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(bvVar.aWl().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.kIH.setShowV(true);
                this.kIH.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.kIH.setBjhAuthIconRes(0);
                this.kIH.setIsBigV(bvVar.aWl().isBigV());
                this.kIH.setShowV(bvVar.aWl().isBigV());
            }
            aS(bvVar);
        }
    }

    public void aS(bv bvVar) {
        if (bvVar != null && bvVar.aWl() != null) {
            String str = bvVar.tid;
            int aT = aT(bvVar);
            if (this.kIJ == null) {
                if (getContext() instanceof PbActivity) {
                    this.kIJ = new ax(((PbActivity) getContext()).getPageContext(), this.kII, -1);
                    this.kIJ.wX("11");
                    this.kIJ.m(this.uniqueId);
                } else {
                    return;
                }
            }
            this.kIJ.a(bvVar.aWl());
            this.kIJ.setTid(str);
            this.kIJ.setThreadData(bvVar);
            this.kIJ.kuQ = true;
            this.kIJ.BZ(aT);
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
        return (this.kIJ == null || this.kIJ.bdf() == null || !this.kIJ.bdf().getIsLike()) ? false : true;
    }
}
