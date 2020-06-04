package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.at;
import org.apache.http.HttpHost;
/* loaded from: classes9.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    private HeadImageView kfR;
    private PbVideoFullscreenLikeBtn kfS;
    private at kfT;
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
        this.kfR = (HeadImageView) findViewById(R.id.attention_img);
        this.kfS = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.kfR.setIsRound(true);
        this.kfR.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.kfR.setBorderColor(context.getResources().getColor(R.color.cp_border_b));
        this.kfR.setAutoChangeStyle(false);
        this.kfS.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.kfS.setOnclickEvent(onClickListener);
    }

    public void setData(bk bkVar) {
        if (bkVar != null && bkVar.aQx() != null) {
            String wj = o.wj(bkVar.aQx().getAvater());
            if (wj.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.kfR.startLoad(wj, 10, false);
            } else {
                this.kfR.startLoad(wj, 25, false);
            }
            if (bkVar.aQx().getBaijiahaoInfo() != null && bkVar.aQx().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.kfR.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(bkVar.aQx().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.kfR.setShowV(true);
                this.kfR.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.kfR.setBjhAuthIconRes(0);
                this.kfR.setIsBigV(bkVar.aQx().isBigV());
                this.kfR.setShowV(bkVar.aQx().isBigV());
            }
            aU(bkVar);
        }
    }

    public void aU(bk bkVar) {
        if (bkVar != null && bkVar.aQx() != null) {
            String str = bkVar.tid;
            int aV = aV(bkVar);
            if (this.kfT == null) {
                if (getContext() instanceof PbActivity) {
                    this.kfT = new at(((PbActivity) getContext()).getPageContext(), this.kfS, -1);
                    this.kfT.vA("11");
                    this.kfT.l(this.uniqueId);
                } else {
                    return;
                }
            }
            this.kfT.a(bkVar.aQx());
            this.kfT.setTid(str);
            this.kfT.setThreadData(bkVar);
            this.kfT.jSd = true;
            this.kfT.Ay(aV);
        }
    }

    public int aV(bk bkVar) {
        if (bkVar == null) {
            return 0;
        }
        if (bkVar.aRV()) {
            return !aq.isEmpty(bkVar.aQC()) ? 2 : 0;
        }
        return 1;
    }

    public boolean cMm() {
        return (this.kfT == null || this.kfT.aXc() == null || !this.kfT.aXc().getIsLike()) ? false : true;
    }
}
