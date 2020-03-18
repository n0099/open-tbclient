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
    private HeadImageView jcI;
    private PbVideoFullscreenLikeBtn jcJ;
    private al jcK;
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
        this.jcI = (HeadImageView) findViewById(R.id.attention_img);
        this.jcJ = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.jcI.setIsRound(true);
        this.jcI.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.jcI.setBorderColor(context.getResources().getColor(R.color.cp_border_b));
        this.jcI.setAutoChangeStyle(false);
        this.jcJ.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.jcJ.setOnclickEvent(onClickListener);
    }

    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.aCr() != null) {
            String tm = o.tm(bjVar.aCr().getAvater());
            if (tm.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.jcI.startLoad(tm, 10, false);
            } else {
                this.jcI.startLoad(tm, 25, false);
            }
            if (bjVar.aCr().getBaijiahaoInfo() != null && bjVar.aCr().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.jcI.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(bjVar.aCr().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.jcI.setShowV(true);
                this.jcI.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.jcI.setBjhAuthIconRes(0);
                this.jcI.setIsBigV(bjVar.aCr().isBigV());
                this.jcI.setShowV(bjVar.aCr().isBigV());
            }
            aT(bjVar);
        }
    }

    public void aT(bj bjVar) {
        if (bjVar != null && bjVar.aCr() != null) {
            String str = bjVar.tid;
            int aU = aU(bjVar);
            if (this.jcK == null) {
                if (getContext() instanceof PbActivity) {
                    this.jcK = new al(((PbActivity) getContext()).getPageContext(), this.jcJ, -1);
                    this.jcK.sD("11");
                    this.jcK.j(this.uniqueId);
                } else {
                    return;
                }
            }
            this.jcK.a(bjVar.aCr());
            this.jcK.setTid(str);
            this.jcK.iPr = true;
            this.jcK.zk(aU);
        }
    }

    public int aU(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aDK()) {
            return !aq.isEmpty(bjVar.aCw()) ? 2 : 0;
        }
        return 1;
    }

    public boolean cuu() {
        return (this.jcK == null || this.jcK.aIA() == null || !this.jcK.aIA().getIsLike()) ? false : true;
    }
}
