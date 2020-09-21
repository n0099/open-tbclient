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
/* loaded from: classes21.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    private HeadImageView lhj;
    private PbVideoFullscreenLikeBtn lhk;
    private ax lhl;
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
        this.lhj = (HeadImageView) findViewById(R.id.attention_img);
        this.lhk = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.lhj.setIsRound(true);
        this.lhj.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.lhj.setBorderColor(context.getResources().getColor(R.color.cp_border_b));
        this.lhj.setAutoChangeStyle(false);
        this.lhk.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.lhk.setOnclickEvent(onClickListener);
    }

    public void setData(bw bwVar) {
        if (bwVar != null && bwVar.bfy() != null) {
            String As = q.As(bwVar.bfy().getAvater());
            if (As.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.lhj.startLoad(As, 10, false);
            } else {
                this.lhj.startLoad(As, 25, false);
            }
            if (bwVar.bfy().getBaijiahaoInfo() != null && bwVar.bfy().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.lhj.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(bwVar.bfy().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.lhj.setShowV(true);
                this.lhj.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.lhj.setBjhAuthIconRes(0);
                this.lhj.setIsBigV(bwVar.bfy().isBigV());
                this.lhj.setShowV(bwVar.bfy().isBigV());
            }
            aU(bwVar);
        }
    }

    public void aU(bw bwVar) {
        if (bwVar != null && bwVar.bfy() != null) {
            String str = bwVar.tid;
            int aV = aV(bwVar);
            if (this.lhl == null) {
                if (getContext() instanceof PbActivity) {
                    this.lhl = new ax(((PbActivity) getContext()).getPageContext(), this.lhk, -1);
                    this.lhl.zH("11");
                    this.lhl.l(this.uniqueId);
                } else {
                    return;
                }
            }
            this.lhl.a(bwVar.bfy());
            this.lhl.setTid(str);
            this.lhl.setThreadData(bwVar);
            this.lhl.kTe = true;
            this.lhl.EU(aV);
        }
    }

    public int aV(bw bwVar) {
        if (bwVar == null) {
            return 0;
        }
        if (bwVar.bgV()) {
            return !at.isEmpty(bwVar.bfC()) ? 2 : 0;
        }
        return 1;
    }

    public boolean diW() {
        return (this.lhl == null || this.lhl.bmF() == null || !this.lhl.bmF().getIsLike()) ? false : true;
    }
}
