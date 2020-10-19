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
/* loaded from: classes22.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    private HeadImageView lwA;
    private PbVideoFullscreenLikeBtn lwB;
    private ax lwC;
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
        this.lwA = (HeadImageView) findViewById(R.id.attention_img);
        this.lwB = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.lwA.setIsRound(true);
        this.lwA.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.lwA.setBorderColor(context.getResources().getColor(R.color.cp_border_b));
        this.lwA.setAutoChangeStyle(false);
        this.lwB.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.lwB.setOnclickEvent(onClickListener);
    }

    public void setData(bw bwVar) {
        if (bwVar != null && bwVar.bih() != null) {
            String Be = q.Be(bwVar.bih().getAvater());
            if (Be.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.lwA.startLoad(Be, 10, false);
            } else {
                this.lwA.startLoad(Be, 25, false);
            }
            if (bwVar.bih().getBaijiahaoInfo() != null && bwVar.bih().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.lwA.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(bwVar.bih().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.lwA.setShowV(true);
                this.lwA.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.lwA.setBjhAuthIconRes(0);
                this.lwA.setIsBigV(bwVar.bih().isBigV());
                this.lwA.setShowV(bwVar.bih().isBigV());
            }
            aU(bwVar);
        }
    }

    public void aU(bw bwVar) {
        if (bwVar != null && bwVar.bih() != null) {
            String str = bwVar.tid;
            int aV = aV(bwVar);
            if (this.lwC == null) {
                if (getContext() instanceof PbActivity) {
                    this.lwC = new ax(((PbActivity) getContext()).getPageContext(), this.lwB, -1);
                    this.lwC.At("11");
                    this.lwC.l(this.uniqueId);
                } else {
                    return;
                }
            }
            this.lwC.a(bwVar.bih());
            this.lwC.setTid(str);
            this.lwC.setThreadData(bwVar);
            this.lwC.lir = true;
            this.lwC.FA(aV);
        }
    }

    public int aV(bw bwVar) {
        if (bwVar == null) {
            return 0;
        }
        if (bwVar.bjE()) {
            return !at.isEmpty(bwVar.bil()) ? 2 : 0;
        }
        return 1;
    }

    public boolean dmF() {
        return (this.lwC == null || this.lwC.bpp() == null || !this.lwC.bpp().getIsLike()) ? false : true;
    }
}
