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
    private HeadImageView jaX;
    private PbVideoFullscreenLikeBtn jaY;
    private al jaZ;
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
        this.jaX = (HeadImageView) findViewById(R.id.attention_img);
        this.jaY = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.jaX.setIsRound(true);
        this.jaX.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.jaX.setBorderColor(context.getResources().getColor(R.color.cp_border_b));
        this.jaX.setAutoChangeStyle(false);
        this.jaY.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.jaY.setOnclickEvent(onClickListener);
    }

    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.aCo() != null) {
            String tn = o.tn(bjVar.aCo().getAvater());
            if (tn.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.jaX.startLoad(tn, 10, false);
            } else {
                this.jaX.startLoad(tn, 25, false);
            }
            if (bjVar.aCo().getBaijiahaoInfo() != null && bjVar.aCo().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.jaX.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(bjVar.aCo().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.jaX.setShowV(true);
                this.jaX.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.jaX.setBjhAuthIconRes(0);
                this.jaX.setIsBigV(bjVar.aCo().isBigV());
                this.jaX.setShowV(bjVar.aCo().isBigV());
            }
            aS(bjVar);
        }
    }

    public void aS(bj bjVar) {
        if (bjVar != null && bjVar.aCo() != null) {
            String str = bjVar.tid;
            int aT = aT(bjVar);
            if (this.jaZ == null) {
                if (getContext() instanceof PbActivity) {
                    this.jaZ = new al(((PbActivity) getContext()).getPageContext(), this.jaY, -1);
                    this.jaZ.sE("11");
                    this.jaZ.j(this.uniqueId);
                } else {
                    return;
                }
            }
            this.jaZ.a(bjVar.aCo());
            this.jaZ.setTid(str);
            this.jaZ.iNE = true;
            this.jaZ.zc(aT);
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

    public boolean cua() {
        return (this.jaZ == null || this.jaZ.aIv() == null || !this.jaZ.aIv().getIsLike()) ? false : true;
    }
}
