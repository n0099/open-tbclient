package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.ao;
import org.apache.http.HttpHost;
/* loaded from: classes7.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    private HeadImageView iZp;
    private PbVideoFullscreenLikeBtn iZq;
    private ao iZr;
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
        this.iZp = (HeadImageView) findViewById(R.id.attention_img);
        this.iZq = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.iZp.setIsRound(true);
        this.iZp.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.iZp.setBorderColor(context.getResources().getColor(R.color.cp_border_b));
        this.iZp.setAutoChangeStyle(false);
        this.iZq.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.iZq.setOnclickEvent(onClickListener);
    }

    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.azX() != null) {
            String sX = o.sX(bjVar.azX().getAvater());
            if (sX.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.iZp.startLoad(sX, 10, false);
            } else {
                this.iZp.startLoad(sX, 25, false);
            }
            if (bjVar.azX().getBaijiahaoInfo() != null && bjVar.azX().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.iZp.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(bjVar.azX().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.iZp.setShowV(true);
                this.iZp.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.iZp.setBjhAuthIconRes(0);
                this.iZp.setIsBigV(bjVar.azX().isBigV());
                this.iZp.setShowV(bjVar.azX().isBigV());
            }
            aP(bjVar);
        }
    }

    public void aP(bj bjVar) {
        if (bjVar != null && bjVar.azX() != null) {
            String str = bjVar.tid;
            int aQ = aQ(bjVar);
            if (this.iZr == null) {
                if (getContext() instanceof PbActivity) {
                    this.iZr = new ao(((PbActivity) getContext()).getPageContext(), this.iZq, -1);
                    this.iZr.sn("11");
                    this.iZr.j(this.uniqueId);
                } else {
                    return;
                }
            }
            this.iZr.a(bjVar.azX());
            this.iZr.setTid(str);
            this.iZr.iMi = true;
            this.iZr.yW(aQ);
        }
    }

    public int aQ(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aBr()) {
            return !aq.isEmpty(bjVar.aAc()) ? 2 : 0;
        }
        return 1;
    }

    public boolean csB() {
        return (this.iZr == null || this.iZr.aGe() == null || !this.iZr.aGe().getIsLike()) ? false : true;
    }
}
