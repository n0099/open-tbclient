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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.o;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class e {
    private View bRa;
    private TbPageContext eSJ;
    private View.OnClickListener ghB = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == e.this.lZG || view == e.this.lZH || view == e.this.lZK) {
                e.this.dS(view);
            }
        }
    };
    private HeadImageView lZG;
    private TextView lZH;
    private RelativeLayout lZI;
    private TextView lZJ;
    private ImageView lZK;
    private PbVideoFullUserInfoLikeButton lZL;
    private d lZM;
    private View.OnClickListener lZN;
    private LinearLayout lZO;

    public e(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.eSJ = tbPageContext;
        this.bRa = x(tbPageContext);
        initView();
        frameLayout.addView(this.bRa);
    }

    private View x(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.lZI = (RelativeLayout) this.bRa.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.lZG = (HeadImageView) this.bRa.findViewById(R.id.pbVideoFullPhoto);
        this.lZG.setOnClickListener(this.ghB);
        this.lZO = (LinearLayout) this.bRa.findViewById(R.id.pbVideoFullNameLayout);
        ao.setBackgroundResource(this.lZO, R.drawable.video_author_bg);
        this.lZH = (TextView) this.bRa.findViewById(R.id.pbVideoFullUserName);
        this.lZH.setOnClickListener(this.ghB);
        this.lZJ = (TextView) this.bRa.findViewById(R.id.pbVideoFullAttention);
        this.lZJ.setOnClickListener(this.ghB);
        this.lZK = (ImageView) this.bRa.findViewById(R.id.pbVideoFullChannelIcon);
        this.lZL = (PbVideoFullUserInfoLikeButton) this.bRa.findViewById(R.id.pbVideoFullLikeButton);
        this.lZL.setTextSize(0, l.getDimens(this.eSJ.getPageActivity(), R.dimen.tbds30));
        this.lZM = new d(this.eSJ, this.lZL);
        this.lZG.setRadius(l.getDimens(this.eSJ.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dS(View view) {
        if (this.lZN != null) {
            this.lZN.onClick(view);
        }
    }

    public void a(PostData postData, bz bzVar, o oVar) {
        this.lZL.setVisibility(0);
        this.lZJ.setVisibility(8);
        w(postData);
        if (aN(bzVar)) {
            this.lZJ.setVisibility(8);
            this.lZL.setVisibility(8);
        }
    }

    private boolean aN(bz bzVar) {
        if (bzVar == null || bzVar.bnx() == null || bzVar.bnx().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bzVar.bnx().getUserId());
    }

    private void w(PostData postData) {
        this.lZK.setVisibility(8);
        this.lZG.setUserId(postData.bnx().getUserId());
        this.lZG.setUserName(postData.bnx().getUserName());
        this.lZG.setIsBigV(postData.bnx().isBigV());
        this.lZH.setText(postData.bnx().getName_show());
        this.lZH.setTag(postData.bnx().getUserId());
        this.lZG.startLoad(postData.bnx().getAvater(), 28, false);
        this.lZM.a(postData.bnx());
    }

    public void aR(float f) {
        this.lZI.setAlpha(f);
    }

    public View drl() {
        return this.lZI;
    }

    public void onChangeSkin(int i) {
        if (this.lZL != null) {
            this.lZL.onChangeSkinType(i);
        }
        ao.setViewTextColor(this.lZJ, R.color.CAM_X0101);
        if (this.lZH != null) {
            ao.setViewTextColor(this.lZH, R.color.CAM_X0101);
        }
        if (this.lZK != null) {
            ao.setBackgroundResource(this.lZK, R.drawable.icon_weiba);
        }
    }

    public void X(View.OnClickListener onClickListener) {
        this.lZN = onClickListener;
    }

    public void onDestroy() {
    }
}
