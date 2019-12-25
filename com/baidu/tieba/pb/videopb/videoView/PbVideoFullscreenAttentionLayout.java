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
/* loaded from: classes6.dex */
public class PbVideoFullscreenAttentionLayout extends FrameLayout {
    private HeadImageView iVM;
    private PbVideoFullscreenLikeBtn iVN;
    private ao iVO;
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
        this.iVM = (HeadImageView) findViewById(R.id.attention_img);
        this.iVN = (PbVideoFullscreenLikeBtn) findViewById(R.id.concern_video_info_item);
        this.iVM.setIsRound(true);
        this.iVM.setBorderWidth(l.getDimens(context, R.dimen.tbds3));
        this.iVM.setBorderColor(context.getResources().getColor(R.color.cp_border_b));
        this.iVM.setAutoChangeStyle(false);
        this.iVN.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public void setOnClickEvent(View.OnClickListener onClickListener) {
        this.iVN.setOnclickEvent(onClickListener);
    }

    public void setData(bj bjVar) {
        if (bjVar != null && bjVar.azE() != null) {
            String sU = o.sU(bjVar.azE().getAvater());
            if (sU.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.iVM.startLoad(sU, 10, false);
            } else {
                this.iVM.startLoad(sU, 25, false);
            }
            if (bjVar.azE().getBaijiahaoInfo() != null && bjVar.azE().getBaijiahaoInfo().auth_id.intValue() > 0) {
                this.iVM.setBjhAuthIconRes(UtilHelper.getBjhBigVIconId(bjVar.azE().getBaijiahaoInfo().auth_id.intValue(), 1));
                this.iVM.setShowV(true);
                this.iVM.setGodIconWidth(R.dimen.tbds31);
            } else {
                this.iVM.setBjhAuthIconRes(0);
                this.iVM.setIsBigV(bjVar.azE().isBigV());
                this.iVM.setShowV(bjVar.azE().isBigV());
            }
            aO(bjVar);
        }
    }

    public void aO(bj bjVar) {
        if (bjVar != null && bjVar.azE() != null) {
            String str = bjVar.tid;
            int aP = aP(bjVar);
            if (this.iVO == null) {
                if (getContext() instanceof PbActivity) {
                    this.iVO = new ao(((PbActivity) getContext()).getPageContext(), this.iVN, -1);
                    this.iVO.sk("11");
                    this.iVO.j(this.uniqueId);
                } else {
                    return;
                }
            }
            this.iVO.a(bjVar.azE());
            this.iVO.setTid(str);
            this.iVO.iIE = true;
            this.iVO.yR(aP);
        }
    }

    public int aP(bj bjVar) {
        if (bjVar == null) {
            return 0;
        }
        if (bjVar.aAY()) {
            return !aq.isEmpty(bjVar.azJ()) ? 2 : 0;
        }
        return 1;
    }

    public boolean cru() {
        return (this.iVO == null || this.iVO.aFL() == null || !this.iVO.aFL().getIsLike()) ? false : true;
    }
}
