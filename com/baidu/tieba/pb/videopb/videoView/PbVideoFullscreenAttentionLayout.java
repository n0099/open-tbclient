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
import com.baidu.tieba.pb.pb.main.al;
import org.apache.http.HttpHost;
/* loaded from: classes9.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    private HeadImageView jMU;
    private PbVideoFullscreenLikeBtn jMV;
    private al jMW;
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
        this.jMU = (HeadImageView) findViewById(R.id.attention_img);
        this.jMV = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.jMU.setIsRound(true);
        this.jMU.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.jMU.setBorderColor(context.getResources().getColor(R.color.cp_border_b));
        this.jMU.setAutoChangeStyle(false);
        this.jMV.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.jMV.setOnclickEvent(onClickListener);
    }

    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.aKC() != null) {
            String uD = o.uD(bjVar.aKC().getAvater());
            if (uD.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.jMU.startLoad(uD, 10, false);
            } else {
                this.jMU.startLoad(uD, 25, false);
            }
            if (bjVar.aKC().getBaijiahaoInfo() != null && bjVar.aKC().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.jMU.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(bjVar.aKC().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.jMU.setShowV(true);
                this.jMU.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.jMU.setBjhAuthIconRes(0);
                this.jMU.setIsBigV(bjVar.aKC().isBigV());
                this.jMU.setShowV(bjVar.aKC().isBigV());
            }
            aU(bjVar);
        }
    }

    public void aU(bj bjVar) {
        if (bjVar != null && bjVar.aKC() != null) {
            String str = bjVar.tid;
            int aV = aV(bjVar);
            if (this.jMW == null) {
                if (getContext() instanceof PbActivity) {
                    this.jMW = new al(((PbActivity) getContext()).getPageContext(), this.jMV, -1);
                    this.jMW.tU("11");
                    this.jMW.j(this.uniqueId);
                } else {
                    return;
                }
            }
            this.jMW.a(bjVar.aKC());
            this.jMW.setTid(str);
            this.jMW.jzE = true;
            this.jMW.zL(aV);
        }
    }

    public int aV(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aLW()) {
            return !aq.isEmpty(bjVar.aKH()) ? 2 : 0;
        }
        return 1;
    }

    public boolean cEX() {
        return (this.jMW == null || this.jMW.aQT() == null || !this.jMW.aQT().getIsLike()) ? false : true;
    }
}
