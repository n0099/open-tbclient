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
    private HeadImageView keL;
    private PbVideoFullscreenLikeBtn keM;
    private at keN;
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
        this.keL = (HeadImageView) findViewById(R.id.attention_img);
        this.keM = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.keL.setIsRound(true);
        this.keL.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.keL.setBorderColor(context.getResources().getColor(R.color.cp_border_b));
        this.keL.setAutoChangeStyle(false);
        this.keM.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.keM.setOnclickEvent(onClickListener);
    }

    public void setData(bk bkVar) {
        if (bkVar != null && bkVar.aQx() != null) {
            String wj = o.wj(bkVar.aQx().getAvater());
            if (wj.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.keL.startLoad(wj, 10, false);
            } else {
                this.keL.startLoad(wj, 25, false);
            }
            if (bkVar.aQx().getBaijiahaoInfo() != null && bkVar.aQx().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.keL.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(bkVar.aQx().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.keL.setShowV(true);
                this.keL.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.keL.setBjhAuthIconRes(0);
                this.keL.setIsBigV(bkVar.aQx().isBigV());
                this.keL.setShowV(bkVar.aQx().isBigV());
            }
            aU(bkVar);
        }
    }

    public void aU(bk bkVar) {
        if (bkVar != null && bkVar.aQx() != null) {
            String str = bkVar.tid;
            int aV = aV(bkVar);
            if (this.keN == null) {
                if (getContext() instanceof PbActivity) {
                    this.keN = new at(((PbActivity) getContext()).getPageContext(), this.keM, -1);
                    this.keN.vA("11");
                    this.keN.l(this.uniqueId);
                } else {
                    return;
                }
            }
            this.keN.a(bkVar.aQx());
            this.keN.setTid(str);
            this.keN.setThreadData(bkVar);
            this.keN.jQX = true;
            this.keN.Aw(aV);
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

    public boolean cLW() {
        return (this.keN == null || this.keN.aXb() == null || !this.keN.aXb().getIsLike()) ? false : true;
    }
}
