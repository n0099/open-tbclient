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
    private HeadImageView kYw;
    private PbVideoFullscreenLikeBtn kYx;
    private ax kYy;
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
        this.kYw = (HeadImageView) findViewById(R.id.attention_img);
        this.kYx = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.kYw.setIsRound(true);
        this.kYw.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.kYw.setBorderColor(context.getResources().getColor(R.color.cp_border_b));
        this.kYw.setAutoChangeStyle(false);
        this.kYx.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.kYx.setOnclickEvent(onClickListener);
    }

    public void setData(bw bwVar) {
        if (bwVar != null && bwVar.beE() != null) {
            String zV = q.zV(bwVar.beE().getAvater());
            if (zV.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.kYw.startLoad(zV, 10, false);
            } else {
                this.kYw.startLoad(zV, 25, false);
            }
            if (bwVar.beE().getBaijiahaoInfo() != null && bwVar.beE().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.kYw.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(bwVar.beE().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.kYw.setShowV(true);
                this.kYw.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.kYw.setBjhAuthIconRes(0);
                this.kYw.setIsBigV(bwVar.beE().isBigV());
                this.kYw.setShowV(bwVar.beE().isBigV());
            }
            aT(bwVar);
        }
    }

    public void aT(bw bwVar) {
        if (bwVar != null && bwVar.beE() != null) {
            String str = bwVar.tid;
            int aU = aU(bwVar);
            if (this.kYy == null) {
                if (getContext() instanceof PbActivity) {
                    this.kYy = new ax(((PbActivity) getContext()).getPageContext(), this.kYx, -1);
                    this.kYy.zl("11");
                    this.kYy.m(this.uniqueId);
                } else {
                    return;
                }
            }
            this.kYy.a(bwVar.beE());
            this.kYy.setTid(str);
            this.kYy.setThreadData(bwVar);
            this.kYy.kKx = true;
            this.kYy.Et(aU);
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

    public boolean dfr() {
        return (this.kYy == null || this.kYy.blL() == null || !this.kYy.blL().getIsLike()) ? false : true;
    }
}
