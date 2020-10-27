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
    private HeadImageView lIY;
    private PbVideoFullscreenLikeBtn lIZ;
    private ax lJa;
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
        this.lIY = (HeadImageView) findViewById(R.id.attention_img);
        this.lIZ = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.lIY.setIsRound(true);
        this.lIY.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.lIY.setBorderColor(context.getResources().getColor(R.color.cp_border_b));
        this.lIY.setAutoChangeStyle(false);
        this.lIZ.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.lIZ.setOnclickEvent(onClickListener);
    }

    public void setData(bw bwVar) {
        if (bwVar != null && bwVar.bka() != null) {
            String Bx = q.Bx(bwVar.bka().getAvater());
            if (Bx.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.lIY.startLoad(Bx, 10, false);
            } else {
                this.lIY.startLoad(Bx, 25, false);
            }
            if (bwVar.bka().getBaijiahaoInfo() != null && bwVar.bka().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.lIY.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(bwVar.bka().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.lIY.setShowV(true);
                this.lIY.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.lIY.setBjhAuthIconRes(0);
                this.lIY.setIsBigV(bwVar.bka().isBigV());
                this.lIY.setShowV(bwVar.bka().isBigV());
            }
            aU(bwVar);
        }
    }

    public void aU(bw bwVar) {
        if (bwVar != null && bwVar.bka() != null) {
            String str = bwVar.tid;
            int aV = aV(bwVar);
            if (this.lJa == null) {
                if (getContext() instanceof PbActivity) {
                    this.lJa = new ax(((PbActivity) getContext()).getPageContext(), this.lIZ, -1);
                    this.lJa.AM("11");
                    this.lJa.l(this.uniqueId);
                } else {
                    return;
                }
            }
            this.lJa.a(bwVar.bka());
            this.lJa.setTid(str);
            this.lJa.setThreadData(bwVar);
            this.lJa.luU = true;
            this.lJa.FT(aV);
        }
    }

    public int aV(bw bwVar) {
        if (bwVar == null) {
            return 0;
        }
        if (bwVar.blx()) {
            return !at.isEmpty(bwVar.bke()) ? 2 : 0;
        }
        return 1;
    }

    public boolean dpN() {
        return (this.lJa == null || this.lJa.bri() == null || !this.lJa.bri().getIsLike()) ? false : true;
    }
}
