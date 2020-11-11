package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.ax;
import org.apache.http.HttpHost;
/* loaded from: classes22.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    private HeadImageView lOU;
    private PbVideoFullscreenLikeBtn lOV;
    private ax lOW;
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
        this.lOU = (HeadImageView) findViewById(R.id.attention_img);
        this.lOV = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.lOU.setIsRound(true);
        this.lOU.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.lOU.setBorderColor(context.getResources().getColor(R.color.cp_border_b));
        this.lOU.setAutoChangeStyle(false);
        this.lOV.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.lOV.setOnclickEvent(onClickListener);
    }

    public void setData(bw bwVar) {
        if (bwVar != null && bwVar.bmA() != null) {
            String BL = q.BL(bwVar.bmA().getAvater());
            if (BL.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.lOU.startLoad(BL, 10, false);
            } else {
                this.lOU.startLoad(BL, 25, false);
            }
            if (bwVar.bmA().getBaijiahaoInfo() != null && bwVar.bmA().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.lOU.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(bwVar.bmA().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.lOU.setShowV(true);
                this.lOU.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.lOU.setBjhAuthIconRes(0);
                this.lOU.setIsBigV(bwVar.bmA().isBigV());
                this.lOU.setShowV(bwVar.bmA().isBigV());
            }
            aU(bwVar);
        }
    }

    public void aU(bw bwVar) {
        if (bwVar != null && bwVar.bmA() != null) {
            String str = bwVar.tid;
            int aV = aV(bwVar);
            if (this.lOW == null) {
                if (getContext() instanceof PbActivity) {
                    this.lOW = new ax(((PbActivity) getContext()).getPageContext(), this.lOV, -1);
                    this.lOW.Ba("11");
                    this.lOW.l(this.uniqueId);
                } else {
                    return;
                }
            }
            this.lOW.a(bwVar.bmA());
            this.lOW.setTid(str);
            this.lOW.setThreadData(bwVar);
            this.lOW.lAR = true;
            this.lOW.Gg(aV);
        }
    }

    public int aV(bw bwVar) {
        if (bwVar == null) {
            return 0;
        }
        if (bwVar.bnX()) {
            return !at.isEmpty(bwVar.bmE()) ? 2 : 0;
        }
        return 1;
    }

    public boolean dsp() {
        return (this.lOW == null || this.lOW.btI() == null || !this.lOW.btI().getIsLike()) ? false : true;
    }
}
