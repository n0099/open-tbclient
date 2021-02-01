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
    private HeadImageView mmZ;
    private PbVideoFullscreenLikeBtn mna;
    private an mnb;
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
        this.mmZ = (HeadImageView) findViewById(R.id.attention_img);
        this.mna = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.mmZ.setIsRound(true);
        this.mmZ.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.mmZ.setBorderColor(context.getResources().getColor(R.color.CAM_X0402));
        this.mmZ.setAutoChangeStyle(false);
        this.mna.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.mna.setOnclickEvent(onClickListener);
    }

    public void setData(cb cbVar) {
        if (cbVar != null && cbVar.bnQ() != null) {
            String AV = r.AV(cbVar.bnQ().getAvater());
            if (AV.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.mmZ.startLoad(AV, 10, false);
            } else {
                this.mmZ.startLoad(AV, 25, false);
            }
            if (cbVar.bnQ().getBaijiahaoInfo() != null && cbVar.bnQ().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.mmZ.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(cbVar.bnQ().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.mmZ.setShowV(true);
                this.mmZ.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.mmZ.setBjhAuthIconRes(0);
                this.mmZ.setIsBigV(cbVar.bnQ().isBigV());
                this.mmZ.setShowV(cbVar.bnQ().isBigV());
            }
            aY(cbVar);
        }
    }

    public void aY(cb cbVar) {
        if (cbVar != null && cbVar.bnQ() != null) {
            String str = cbVar.tid;
            int aZ = aZ(cbVar);
            if (this.mnb == null) {
                if (getContext() instanceof PbActivity) {
                    this.mnb = new an(((PbActivity) getContext()).getPageContext(), this.mna, -1);
                    this.mnb.Ag(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                    this.mnb.l(this.uniqueId);
                } else {
                    return;
                }
            }
            this.mnb.a(cbVar.bnQ());
            this.mnb.setTid(str);
            this.mnb.setThreadData(cbVar);
            this.mnb.lYB = true;
            this.mnb.Ga(aZ);
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

    public boolean dvt() {
        return (this.mnb == null || this.mnb.bvs() == null || !this.mnb.bvs().getIsLike()) ? false : true;
    }
}
