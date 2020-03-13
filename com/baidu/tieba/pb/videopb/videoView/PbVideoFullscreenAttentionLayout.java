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
    private HeadImageView jbj;
    private PbVideoFullscreenLikeBtn jbk;
    private al jbl;
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
        this.jbj = (HeadImageView) findViewById(R.id.attention_img);
        this.jbk = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.jbj.setIsRound(true);
        this.jbj.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.jbj.setBorderColor(context.getResources().getColor(R.color.cp_border_b));
        this.jbj.setAutoChangeStyle(false);
        this.jbk.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.jbk.setOnclickEvent(onClickListener);
    }

    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.aCo() != null) {
            String tn = o.tn(bjVar.aCo().getAvater());
            if (tn.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.jbj.startLoad(tn, 10, false);
            } else {
                this.jbj.startLoad(tn, 25, false);
            }
            if (bjVar.aCo().getBaijiahaoInfo() != null && bjVar.aCo().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.jbj.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(bjVar.aCo().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.jbj.setShowV(true);
                this.jbj.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.jbj.setBjhAuthIconRes(0);
                this.jbj.setIsBigV(bjVar.aCo().isBigV());
                this.jbj.setShowV(bjVar.aCo().isBigV());
            }
            aS(bjVar);
        }
    }

    public void aS(bj bjVar) {
        if (bjVar != null && bjVar.aCo() != null) {
            String str = bjVar.tid;
            int aT = aT(bjVar);
            if (this.jbl == null) {
                if (getContext() instanceof PbActivity) {
                    this.jbl = new al(((PbActivity) getContext()).getPageContext(), this.jbk, -1);
                    this.jbl.sE("11");
                    this.jbl.j(this.uniqueId);
                } else {
                    return;
                }
            }
            this.jbl.a(bjVar.aCo());
            this.jbl.setTid(str);
            this.jbl.iNQ = true;
            this.jbl.zc(aT);
        }
    }

    public int aT(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aDG()) {
            return !aq.isEmpty(bjVar.aCt()) ? 2 : 0;
        }
        return 1;
    }

    public boolean cub() {
        return (this.jbl == null || this.jbl.aIw() == null || !this.jbl.aIw().getIsLike()) ? false : true;
    }
}
