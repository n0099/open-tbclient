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
    private HeadImageView jaV;
    private PbVideoFullscreenLikeBtn jaW;
    private al jaX;
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
        this.jaV = (HeadImageView) findViewById(R.id.attention_img);
        this.jaW = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.jaV.setIsRound(true);
        this.jaV.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.jaV.setBorderColor(context.getResources().getColor(R.color.cp_border_b));
        this.jaV.setAutoChangeStyle(false);
        this.jaW.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.jaW.setOnclickEvent(onClickListener);
    }

    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.aCm() != null) {
            String tn = o.tn(bjVar.aCm().getAvater());
            if (tn.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.jaV.startLoad(tn, 10, false);
            } else {
                this.jaV.startLoad(tn, 25, false);
            }
            if (bjVar.aCm().getBaijiahaoInfo() != null && bjVar.aCm().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.jaV.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(bjVar.aCm().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.jaV.setShowV(true);
                this.jaV.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.jaV.setBjhAuthIconRes(0);
                this.jaV.setIsBigV(bjVar.aCm().isBigV());
                this.jaV.setShowV(bjVar.aCm().isBigV());
            }
            aS(bjVar);
        }
    }

    public void aS(bj bjVar) {
        if (bjVar != null && bjVar.aCm() != null) {
            String str = bjVar.tid;
            int aT = aT(bjVar);
            if (this.jaX == null) {
                if (getContext() instanceof PbActivity) {
                    this.jaX = new al(((PbActivity) getContext()).getPageContext(), this.jaW, -1);
                    this.jaX.sE("11");
                    this.jaX.j(this.uniqueId);
                } else {
                    return;
                }
            }
            this.jaX.a(bjVar.aCm());
            this.jaX.setTid(str);
            this.jaX.iNC = true;
            this.jaX.zc(aT);
        }
    }

    public int aT(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aDE()) {
            return !aq.isEmpty(bjVar.aCr()) ? 2 : 0;
        }
        return 1;
    }

    public boolean ctY() {
        return (this.jaX == null || this.jaX.aIt() == null || !this.jaX.aIt().getIsLike()) ? false : true;
    }
}
