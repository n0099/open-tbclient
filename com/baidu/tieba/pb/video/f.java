package com.baidu.tieba.pb.video;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes7.dex */
public class f {
    private TbPageContext cRe;
    private View.OnClickListener dXX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.iVO || view == f.this.iVP || view == f.this.iVS) {
                f.this.cG(view);
            }
        }
    };
    private View hXc;
    private HeadImageView iVO;
    private TextView iVP;
    private RelativeLayout iVQ;
    private TextView iVR;
    private ImageView iVS;
    private PbVideoFullUserInfoLikeButton iVT;
    private e iVU;
    private View.OnClickListener iVV;
    private LinearLayout iVW;

    public f(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.cRe = tbPageContext;
        this.hXc = t(tbPageContext);
        initView();
        frameLayout.addView(this.hXc);
    }

    private View t(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.iVQ = (RelativeLayout) this.hXc.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.iVO = (HeadImageView) this.hXc.findViewById(R.id.pbVideoFullPhoto);
        this.iVO.setOnClickListener(this.dXX);
        this.iVW = (LinearLayout) this.hXc.findViewById(R.id.pbVideoFullNameLayout);
        am.setBackgroundResource(this.iVW, R.drawable.video_author_bg);
        this.iVP = (TextView) this.hXc.findViewById(R.id.pbVideoFullUserName);
        this.iVP.setOnClickListener(this.dXX);
        this.iVR = (TextView) this.hXc.findViewById(R.id.pbVideoFullAttention);
        this.iVR.setOnClickListener(this.dXX);
        this.iVS = (ImageView) this.hXc.findViewById(R.id.pbVideoFullChannelIcon);
        this.iVT = (PbVideoFullUserInfoLikeButton) this.hXc.findViewById(R.id.pbVideoFullLikeButton);
        this.iVT.setTextSize(0, l.getDimens(this.cRe.getPageActivity(), R.dimen.tbds30));
        this.iVU = new e(this.cRe, this.iVT);
        this.iVO.setRadius(l.getDimens(this.cRe.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cG(View view) {
        if (this.iVV != null) {
            this.iVV.onClick(view);
        }
    }

    public void a(PostData postData, bj bjVar, com.baidu.tieba.pb.data.l lVar) {
        this.iVT.setVisibility(0);
        this.iVR.setVisibility(8);
        t(postData);
        if (aF(bjVar)) {
            this.iVR.setVisibility(8);
            this.iVT.setVisibility(8);
        }
    }

    private boolean aF(bj bjVar) {
        if (bjVar == null || bjVar.azX() == null || bjVar.azX().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bjVar.azX().getUserId());
    }

    private void t(PostData postData) {
        this.iVS.setVisibility(8);
        this.iVO.setUserId(postData.azX().getUserId());
        this.iVO.setUserName(postData.azX().getUserName());
        this.iVO.setIsBigV(postData.azX().isBigV());
        this.iVP.setText(postData.azX().getName_show());
        this.iVP.setTag(postData.azX().getUserId());
        this.iVO.startLoad(postData.azX().getAvater(), 28, false);
        this.iVU.a(postData.azX());
    }

    public void aF(float f) {
        this.iVQ.setAlpha(f);
    }

    public View cqS() {
        return this.iVQ;
    }

    public void onChangeSkin(int i) {
        if (this.iVT != null) {
            this.iVT.onChangeSkinType(i);
        }
        am.setViewTextColor(this.iVR, (int) R.color.cp_cont_a);
        if (this.iVP != null) {
            am.setViewTextColor(this.iVP, (int) R.color.cp_cont_a);
        }
        if (this.iVS != null) {
            am.setBackgroundResource(this.iVS, R.drawable.icon_weiba);
        }
    }

    public void R(View.OnClickListener onClickListener) {
        this.iVV = onClickListener;
    }

    public void onDestroy() {
    }
}
