package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.ax;
import org.apache.http.HttpHost;
/* loaded from: classes21.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    private HeadImageView lPk;
    private PbVideoFullscreenLikeBtn lPl;
    private ax lPm;
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
        this.lPk = (HeadImageView) findViewById(R.id.attention_img);
        this.lPl = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.lPk.setIsRound(true);
        this.lPk.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.lPk.setBorderColor(context.getResources().getColor(R.color.CAM_X0402));
        this.lPk.setAutoChangeStyle(false);
        this.lPl.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.lPl.setOnclickEvent(onClickListener);
    }

    public void setData(bx bxVar) {
        if (bxVar != null && bxVar.blC() != null) {
            String Bk = q.Bk(bxVar.blC().getAvater());
            if (Bk.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.lPk.startLoad(Bk, 10, false);
            } else {
                this.lPk.startLoad(Bk, 25, false);
            }
            if (bxVar.blC().getBaijiahaoInfo() != null && bxVar.blC().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.lPk.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(bxVar.blC().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.lPk.setShowV(true);
                this.lPk.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.lPk.setBjhAuthIconRes(0);
                this.lPk.setIsBigV(bxVar.blC().isBigV());
                this.lPk.setShowV(bxVar.blC().isBigV());
            }
            aW(bxVar);
        }
    }

    public void aW(bx bxVar) {
        if (bxVar != null && bxVar.blC() != null) {
            String str = bxVar.tid;
            int aX = aX(bxVar);
            if (this.lPm == null) {
                if (getContext() instanceof PbActivity) {
                    this.lPm = new ax(((PbActivity) getContext()).getPageContext(), this.lPl, -1);
                    this.lPm.Av("11");
                    this.lPm.l(this.uniqueId);
                } else {
                    return;
                }
            }
            this.lPm.a(bxVar.blC());
            this.lPm.setTid(str);
            this.lPm.setThreadData(bxVar);
            this.lPm.lBj = true;
            this.lPm.GE(aX);
        }
    }

    public int aX(bx bxVar) {
        if (bxVar == null) {
            return 0;
        }
        if (bxVar.bnb()) {
            return !au.isEmpty(bxVar.blG()) ? 2 : 0;
        }
        return 1;
    }

    public boolean drP() {
        return (this.lPm == null || this.lPm.bsY() == null || !this.lPm.bsY().getIsLike()) ? false : true;
    }
}
