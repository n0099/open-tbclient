package com.baidu.tieba.pb.videopb.videoView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.at;
import org.apache.http.HttpHost;
/* loaded from: classes9.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    private HeadImageView kzF;
    private PbVideoFullscreenLikeBtn kzG;
    private at kzH;
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
        this.kzF = (HeadImageView) findViewById(R.id.attention_img);
        this.kzG = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.kzF.setIsRound(true);
        this.kzF.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.kzF.setBorderColor(context.getResources().getColor(R.color.cp_border_b));
        this.kzF.setAutoChangeStyle(false);
        this.kzG.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.kzG.setOnclickEvent(onClickListener);
    }

    public void setData(bu buVar) {
        if (buVar != null && buVar.aSp() != null) {
            String wz = p.wz(buVar.aSp().getAvater());
            if (wz.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.kzF.startLoad(wz, 10, false);
            } else {
                this.kzF.startLoad(wz, 25, false);
            }
            if (buVar.aSp().getBaijiahaoInfo() != null && buVar.aSp().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.kzF.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(buVar.aSp().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.kzF.setShowV(true);
                this.kzF.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.kzF.setBjhAuthIconRes(0);
                this.kzF.setIsBigV(buVar.aSp().isBigV());
                this.kzF.setShowV(buVar.aSp().isBigV());
            }
            aV(buVar);
        }
    }

    public void aV(bu buVar) {
        if (buVar != null && buVar.aSp() != null) {
            String str = buVar.tid;
            int aW = aW(buVar);
            if (this.kzH == null) {
                if (getContext() instanceof PbActivity) {
                    this.kzH = new at(((PbActivity) getContext()).getPageContext(), this.kzG, -1);
                    this.kzH.vQ("11");
                    this.kzH.l(this.uniqueId);
                } else {
                    return;
                }
            }
            this.kzH.a(buVar.aSp());
            this.kzH.setTid(str);
            this.kzH.setThreadData(buVar);
            this.kzH.klT = true;
            this.kzH.BA(aW);
        }
    }

    public int aW(bu buVar) {
        if (buVar == null) {
            return 0;
        }
        if (buVar.aTM()) {
            return !ar.isEmpty(buVar.aSt()) ? 2 : 0;
        }
        return 1;
    }

    public boolean cQE() {
        return (this.kzH == null || this.kzH.aZi() == null || !this.kzH.aZi().getIsLike()) ? false : true;
    }
}
