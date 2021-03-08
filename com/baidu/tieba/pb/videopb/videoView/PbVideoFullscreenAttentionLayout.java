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
    private HeadImageView mpr;
    private PbVideoFullscreenLikeBtn mps;
    private an mpt;
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
        this.mpr = (HeadImageView) findViewById(R.id.attention_img);
        this.mps = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.mpr.setIsRound(true);
        this.mpr.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.mpr.setBorderColor(context.getResources().getColor(R.color.CAM_X0402));
        this.mpr.setAutoChangeStyle(false);
        this.mps.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.mps.setOnclickEvent(onClickListener);
    }

    public void setData(cb cbVar) {
        if (cbVar != null && cbVar.bnS() != null) {
            String Bc = r.Bc(cbVar.bnS().getAvater());
            if (Bc.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.mpr.startLoad(Bc, 10, false);
            } else {
                this.mpr.startLoad(Bc, 25, false);
            }
            if (cbVar.bnS().getBaijiahaoInfo() != null && cbVar.bnS().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.mpr.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(cbVar.bnS().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.mpr.setShowV(true);
                this.mpr.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.mpr.setBjhAuthIconRes(0);
                this.mpr.setIsBigV(cbVar.bnS().isBigV());
                this.mpr.setShowV(cbVar.bnS().isBigV());
            }
            aY(cbVar);
        }
    }

    public void aY(cb cbVar) {
        if (cbVar != null && cbVar.bnS() != null) {
            String str = cbVar.tid;
            int aZ = aZ(cbVar);
            if (this.mpt == null) {
                if (getContext() instanceof PbActivity) {
                    this.mpt = new an(((PbActivity) getContext()).getPageContext(), this.mps, -1);
                    this.mpt.An(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                    this.mpt.l(this.uniqueId);
                } else {
                    return;
                }
            }
            this.mpt.a(cbVar.bnS());
            this.mpt.setTid(str);
            this.mpt.setThreadData(cbVar);
            this.mpt.maV = true;
            this.mpt.Gd(aZ);
        }
    }

    public int aZ(cb cbVar) {
        if (cbVar == null) {
            return 0;
        }
        if (cbVar.bpr()) {
            return !au.isEmpty(cbVar.bnW()) ? 2 : 0;
        }
        return 1;
    }

    public boolean dvJ() {
        return (this.mpt == null || this.mpt.bvv() == null || !this.mpt.bvv().getIsLike()) ? false : true;
    }
}
