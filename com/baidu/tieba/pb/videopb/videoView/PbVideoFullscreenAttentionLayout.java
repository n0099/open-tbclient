package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.an;
import com.tencent.connect.common.Constants;
import org.apache.http.HttpHost;
/* loaded from: classes2.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    private HeadImageView mno;
    private PbVideoFullscreenLikeBtn mnp;
    private an mnq;
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
        this.mno = (HeadImageView) findViewById(R.id.attention_img);
        this.mnp = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.mno.setIsRound(true);
        this.mno.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.mno.setBorderColor(context.getResources().getColor(R.color.CAM_X0402));
        this.mno.setAutoChangeStyle(false);
        this.mnp.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.mnp.setOnclickEvent(onClickListener);
    }

    public void setData(cb cbVar) {
        if (cbVar != null && cbVar.bnQ() != null) {
            String AV = r.AV(cbVar.bnQ().getAvater());
            if (AV.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.mno.startLoad(AV, 10, false);
            } else {
                this.mno.startLoad(AV, 25, false);
            }
            if (cbVar.bnQ().getBaijiahaoInfo() != null && cbVar.bnQ().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.mno.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(cbVar.bnQ().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.mno.setShowV(true);
                this.mno.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.mno.setBjhAuthIconRes(0);
                this.mno.setIsBigV(cbVar.bnQ().isBigV());
                this.mno.setShowV(cbVar.bnQ().isBigV());
            }
            aY(cbVar);
        }
    }

    public void aY(cb cbVar) {
        if (cbVar != null && cbVar.bnQ() != null) {
            String str = cbVar.tid;
            int aZ = aZ(cbVar);
            if (this.mnq == null) {
                if (getContext() instanceof PbActivity) {
                    this.mnq = new an(((PbActivity) getContext()).getPageContext(), this.mnp, -1);
                    this.mnq.Ag(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                    this.mnq.l(this.uniqueId);
                } else {
                    return;
                }
            }
            this.mnq.a(cbVar.bnQ());
            this.mnq.setTid(str);
            this.mnq.setThreadData(cbVar);
            this.mnq.lYQ = true;
            this.mnq.Ga(aZ);
        }
    }

    public int aZ(cb cbVar) {
        if (cbVar == null) {
            return 0;
        }
        if (cbVar.bpp()) {
            return !au.isEmpty(cbVar.bnU()) ? 2 : 0;
        }
        return 1;
    }

    public boolean dvA() {
        return (this.mnq == null || this.mnq.bvs() == null || !this.mnq.bvs().getIsLike()) ? false : true;
    }
}
