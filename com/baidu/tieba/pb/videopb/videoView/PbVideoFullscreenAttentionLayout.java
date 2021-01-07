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
    private HeadImageView miD;
    private PbVideoFullscreenLikeBtn miE;
    private an miF;
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
        this.miD = (HeadImageView) findViewById(R.id.attention_img);
        this.miE = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.miD.setIsRound(true);
        this.miD.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.miD.setBorderColor(context.getResources().getColor(R.color.CAM_X0402));
        this.miD.setAutoChangeStyle(false);
        this.miE.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.miE.setOnclickEvent(onClickListener);
    }

    public void setData(bz bzVar) {
        if (bzVar != null && bzVar.brr() != null) {
            String BP = q.BP(bzVar.brr().getAvater());
            if (BP.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.miD.startLoad(BP, 10, false);
            } else {
                this.miD.startLoad(BP, 25, false);
            }
            if (bzVar.brr().getBaijiahaoInfo() != null && bzVar.brr().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.miD.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(bzVar.brr().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.miD.setShowV(true);
                this.miD.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.miD.setBjhAuthIconRes(0);
                this.miD.setIsBigV(bzVar.brr().isBigV());
                this.miD.setShowV(bzVar.brr().isBigV());
            }
            aX(bzVar);
        }
    }

    public void aX(bz bzVar) {
        if (bzVar != null && bzVar.brr() != null) {
            String str = bzVar.tid;
            int aY = aY(bzVar);
            if (this.miF == null) {
                if (getContext() instanceof PbActivity) {
                    this.miF = new an(((PbActivity) getContext()).getPageContext(), this.miE, -1);
                    this.miF.Ba(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                    this.miF.l(this.uniqueId);
                } else {
                    return;
                }
            }
            this.miF.a(bzVar.brr());
            this.miF.setTid(str);
            this.miF.setThreadData(bzVar);
            this.miF.lUj = true;
            this.miF.Hn(aY);
        }
    }

    public int aY(bz bzVar) {
        if (bzVar == null) {
            return 0;
        }
        if (bzVar.bsR()) {
            return !at.isEmpty(bzVar.brv()) ? 2 : 0;
        }
        return 1;
    }

    public boolean dwY() {
        return (this.miF == null || this.miF.byS() == null || !this.miF.byS().getIsLike()) ? false : true;
    }
}
