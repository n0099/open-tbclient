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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.o;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes16.dex */
public class f {
    private TbPageContext dVN;
    private View.OnClickListener ffU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.kED || view == f.this.kEE || view == f.this.kEH) {
                f.this.cV(view);
            }
        }
    };
    private View jAo;
    private HeadImageView kED;
    private TextView kEE;
    private RelativeLayout kEF;
    private TextView kEG;
    private ImageView kEH;
    private PbVideoFullUserInfoLikeButton kEI;
    private e kEJ;
    private View.OnClickListener kEK;
    private LinearLayout kEL;

    public f(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.dVN = tbPageContext;
        this.jAo = y(tbPageContext);
        initView();
        frameLayout.addView(this.jAo);
    }

    private View y(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.kEF = (RelativeLayout) this.jAo.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.kED = (HeadImageView) this.jAo.findViewById(R.id.pbVideoFullPhoto);
        this.kED.setOnClickListener(this.ffU);
        this.kEL = (LinearLayout) this.jAo.findViewById(R.id.pbVideoFullNameLayout);
        ao.setBackgroundResource(this.kEL, R.drawable.video_author_bg);
        this.kEE = (TextView) this.jAo.findViewById(R.id.pbVideoFullUserName);
        this.kEE.setOnClickListener(this.ffU);
        this.kEG = (TextView) this.jAo.findViewById(R.id.pbVideoFullAttention);
        this.kEG.setOnClickListener(this.ffU);
        this.kEH = (ImageView) this.jAo.findViewById(R.id.pbVideoFullChannelIcon);
        this.kEI = (PbVideoFullUserInfoLikeButton) this.jAo.findViewById(R.id.pbVideoFullLikeButton);
        this.kEI.setTextSize(0, l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds30));
        this.kEJ = new e(this.dVN, this.kEI);
        this.kED.setRadius(l.getDimens(this.dVN.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cV(View view) {
        if (this.kEK != null) {
            this.kEK.onClick(view);
        }
    }

    public void a(PostData postData, bv bvVar, o oVar) {
        this.kEI.setVisibility(0);
        this.kEG.setVisibility(8);
        v(postData);
        if (aI(bvVar)) {
            this.kEG.setVisibility(8);
            this.kEI.setVisibility(8);
        }
    }

    private boolean aI(bv bvVar) {
        if (bvVar == null || bvVar.aWl() == null || bvVar.aWl().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bvVar.aWl().getUserId());
    }

    private void v(PostData postData) {
        this.kEH.setVisibility(8);
        this.kED.setUserId(postData.aWl().getUserId());
        this.kED.setUserName(postData.aWl().getUserName());
        this.kED.setIsBigV(postData.aWl().isBigV());
        this.kEE.setText(postData.aWl().getName_show());
        this.kEE.setTag(postData.aWl().getUserId());
        this.kED.startLoad(postData.aWl().getAvater(), 28, false);
        this.kEJ.a(postData.aWl());
    }

    public void ar(float f) {
        this.kEF.setAlpha(f);
    }

    public View cSD() {
        return this.kEF;
    }

    public void onChangeSkin(int i) {
        if (this.kEI != null) {
            this.kEI.onChangeSkinType(i);
        }
        ao.setViewTextColor(this.kEG, R.color.cp_cont_a);
        if (this.kEE != null) {
            ao.setViewTextColor(this.kEE, R.color.cp_cont_a);
        }
        if (this.kEH != null) {
            ao.setBackgroundResource(this.kEH, R.drawable.icon_weiba);
        }
    }

    public void U(View.OnClickListener onClickListener) {
        this.kEK = onClickListener;
    }

    public void onDestroy() {
    }
}
