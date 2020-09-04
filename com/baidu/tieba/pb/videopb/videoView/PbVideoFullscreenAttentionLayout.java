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
/* loaded from: classes16.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    private HeadImageView kYD;
    private PbVideoFullscreenLikeBtn kYE;
    private ax kYF;
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
        this.kYD = (HeadImageView) findViewById(R.id.attention_img);
        this.kYE = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.kYD.setIsRound(true);
        this.kYD.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.kYD.setBorderColor(context.getResources().getColor(R.color.cp_border_b));
        this.kYD.setAutoChangeStyle(false);
        this.kYE.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.kYE.setOnclickEvent(onClickListener);
    }

    public void setData(bw bwVar) {
        if (bwVar != null && bwVar.beE() != null) {
            String zW = q.zW(bwVar.beE().getAvater());
            if (zW.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.kYD.startLoad(zW, 10, false);
            } else {
                this.kYD.startLoad(zW, 25, false);
            }
            if (bwVar.beE().getBaijiahaoInfo() != null && bwVar.beE().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.kYD.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(bwVar.beE().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.kYD.setShowV(true);
                this.kYD.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.kYD.setBjhAuthIconRes(0);
                this.kYD.setIsBigV(bwVar.beE().isBigV());
                this.kYD.setShowV(bwVar.beE().isBigV());
            }
            aT(bwVar);
        }
    }

    public void aT(bw bwVar) {
        if (bwVar != null && bwVar.beE() != null) {
            String str = bwVar.tid;
            int aU = aU(bwVar);
            if (this.kYF == null) {
                if (getContext() instanceof PbActivity) {
                    this.kYF = new ax(((PbActivity) getContext()).getPageContext(), this.kYE, -1);
                    this.kYF.zm("11");
                    this.kYF.m(this.uniqueId);
                } else {
                    return;
                }
            }
            this.kYF.a(bwVar.beE());
            this.kYF.setTid(str);
            this.kYF.setThreadData(bwVar);
            this.kYF.kKE = true;
            this.kYF.Et(aU);
        }
    }

    public int aU(bw bwVar) {
        if (bwVar == null) {
            return 0;
        }
        if (bwVar.bgb()) {
            return !at.isEmpty(bwVar.beI()) ? 2 : 0;
        }
        return 1;
    }

    public boolean dfs() {
        return (this.kYF == null || this.kYF.blL() == null || !this.kYF.blL().getIsLike()) ? false : true;
    }
}
