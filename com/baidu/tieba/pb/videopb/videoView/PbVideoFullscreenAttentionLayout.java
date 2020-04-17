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
    private HeadImageView jMQ;
    private PbVideoFullscreenLikeBtn jMR;
    private al jMS;
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
        this.jMQ = (HeadImageView) findViewById(R.id.attention_img);
        this.jMR = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.jMQ.setIsRound(true);
        this.jMQ.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.jMQ.setBorderColor(context.getResources().getColor(R.color.cp_border_b));
        this.jMQ.setAutoChangeStyle(false);
        this.jMR.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.jMR.setOnclickEvent(onClickListener);
    }

    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.aKE() != null) {
            String uA = o.uA(bjVar.aKE().getAvater());
            if (uA.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.jMQ.startLoad(uA, 10, false);
            } else {
                this.jMQ.startLoad(uA, 25, false);
            }
            if (bjVar.aKE().getBaijiahaoInfo() != null && bjVar.aKE().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.jMQ.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(bjVar.aKE().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.jMQ.setShowV(true);
                this.jMQ.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.jMQ.setBjhAuthIconRes(0);
                this.jMQ.setIsBigV(bjVar.aKE().isBigV());
                this.jMQ.setShowV(bjVar.aKE().isBigV());
            }
            aU(bjVar);
        }
    }

    public void aU(bj bjVar) {
        if (bjVar != null && bjVar.aKE() != null) {
            String str = bjVar.tid;
            int aV = aV(bjVar);
            if (this.jMS == null) {
                if (getContext() instanceof PbActivity) {
                    this.jMS = new al(((PbActivity) getContext()).getPageContext(), this.jMR, -1);
                    this.jMS.tR("11");
                    this.jMS.j(this.uniqueId);
                } else {
                    return;
                }
            }
            this.jMS.a(bjVar.aKE());
            this.jMS.setTid(str);
            this.jMS.jzA = true;
            this.jMS.zL(aV);
        }
    }

    public int aV(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aLY()) {
            return !aq.isEmpty(bjVar.aKJ()) ? 2 : 0;
        }
        return 1;
    }

    public boolean cFa() {
        return (this.jMS == null || this.jMS.aQW() == null || !this.jMS.aQW().getIsLike()) ? false : true;
    }
}
