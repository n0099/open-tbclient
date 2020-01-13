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
            if (view == f.this.iVJ || view == f.this.iVK || view == f.this.iVN) {
                f.this.cG(view);
            }
        }
    };
    private View hXc;
    private HeadImageView iVJ;
    private TextView iVK;
    private RelativeLayout iVL;
    private TextView iVM;
    private ImageView iVN;
    private PbVideoFullUserInfoLikeButton iVO;
    private e iVP;
    private View.OnClickListener iVQ;
    private LinearLayout iVR;

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
        this.iVL = (RelativeLayout) this.hXc.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.iVJ = (HeadImageView) this.hXc.findViewById(R.id.pbVideoFullPhoto);
        this.iVJ.setOnClickListener(this.dXX);
        this.iVR = (LinearLayout) this.hXc.findViewById(R.id.pbVideoFullNameLayout);
        am.setBackgroundResource(this.iVR, R.drawable.video_author_bg);
        this.iVK = (TextView) this.hXc.findViewById(R.id.pbVideoFullUserName);
        this.iVK.setOnClickListener(this.dXX);
        this.iVM = (TextView) this.hXc.findViewById(R.id.pbVideoFullAttention);
        this.iVM.setOnClickListener(this.dXX);
        this.iVN = (ImageView) this.hXc.findViewById(R.id.pbVideoFullChannelIcon);
        this.iVO = (PbVideoFullUserInfoLikeButton) this.hXc.findViewById(R.id.pbVideoFullLikeButton);
        this.iVO.setTextSize(0, l.getDimens(this.cRe.getPageActivity(), R.dimen.tbds30));
        this.iVP = new e(this.cRe, this.iVO);
        this.iVJ.setRadius(l.getDimens(this.cRe.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cG(View view) {
        if (this.iVQ != null) {
            this.iVQ.onClick(view);
        }
    }

    public void a(PostData postData, bj bjVar, com.baidu.tieba.pb.data.l lVar) {
        this.iVO.setVisibility(0);
        this.iVM.setVisibility(8);
        t(postData);
        if (aF(bjVar)) {
            this.iVM.setVisibility(8);
            this.iVO.setVisibility(8);
        }
    }

    private boolean aF(bj bjVar) {
        if (bjVar == null || bjVar.azX() == null || bjVar.azX().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bjVar.azX().getUserId());
    }

    private void t(PostData postData) {
        this.iVN.setVisibility(8);
        this.iVJ.setUserId(postData.azX().getUserId());
        this.iVJ.setUserName(postData.azX().getUserName());
        this.iVJ.setIsBigV(postData.azX().isBigV());
        this.iVK.setText(postData.azX().getName_show());
        this.iVK.setTag(postData.azX().getUserId());
        this.iVJ.startLoad(postData.azX().getAvater(), 28, false);
        this.iVP.a(postData.azX());
    }

    public void aF(float f) {
        this.iVL.setAlpha(f);
    }

    public View cqQ() {
        return this.iVL;
    }

    public void onChangeSkin(int i) {
        if (this.iVO != null) {
            this.iVO.onChangeSkinType(i);
        }
        am.setViewTextColor(this.iVM, (int) R.color.cp_cont_a);
        if (this.iVK != null) {
            am.setViewTextColor(this.iVK, (int) R.color.cp_cont_a);
        }
        if (this.iVN != null) {
            am.setBackgroundResource(this.iVN, R.drawable.icon_weiba);
        }
    }

    public void R(View.OnClickListener onClickListener) {
        this.iVQ = onClickListener;
    }

    public void onDestroy() {
    }
}
