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
            if (view == f.this.kEB || view == f.this.kEC || view == f.this.kEF) {
                f.this.cV(view);
            }
        }
    };
    private View jAm;
    private HeadImageView kEB;
    private TextView kEC;
    private RelativeLayout kED;
    private TextView kEE;
    private ImageView kEF;
    private PbVideoFullUserInfoLikeButton kEG;
    private e kEH;
    private View.OnClickListener kEI;
    private LinearLayout kEJ;

    public f(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.dVN = tbPageContext;
        this.jAm = y(tbPageContext);
        initView();
        frameLayout.addView(this.jAm);
    }

    private View y(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.kED = (RelativeLayout) this.jAm.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.kEB = (HeadImageView) this.jAm.findViewById(R.id.pbVideoFullPhoto);
        this.kEB.setOnClickListener(this.ffU);
        this.kEJ = (LinearLayout) this.jAm.findViewById(R.id.pbVideoFullNameLayout);
        ao.setBackgroundResource(this.kEJ, R.drawable.video_author_bg);
        this.kEC = (TextView) this.jAm.findViewById(R.id.pbVideoFullUserName);
        this.kEC.setOnClickListener(this.ffU);
        this.kEE = (TextView) this.jAm.findViewById(R.id.pbVideoFullAttention);
        this.kEE.setOnClickListener(this.ffU);
        this.kEF = (ImageView) this.jAm.findViewById(R.id.pbVideoFullChannelIcon);
        this.kEG = (PbVideoFullUserInfoLikeButton) this.jAm.findViewById(R.id.pbVideoFullLikeButton);
        this.kEG.setTextSize(0, l.getDimens(this.dVN.getPageActivity(), R.dimen.tbds30));
        this.kEH = new e(this.dVN, this.kEG);
        this.kEB.setRadius(l.getDimens(this.dVN.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cV(View view) {
        if (this.kEI != null) {
            this.kEI.onClick(view);
        }
    }

    public void a(PostData postData, bv bvVar, o oVar) {
        this.kEG.setVisibility(0);
        this.kEE.setVisibility(8);
        v(postData);
        if (aI(bvVar)) {
            this.kEE.setVisibility(8);
            this.kEG.setVisibility(8);
        }
    }

    private boolean aI(bv bvVar) {
        if (bvVar == null || bvVar.aWl() == null || bvVar.aWl().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bvVar.aWl().getUserId());
    }

    private void v(PostData postData) {
        this.kEF.setVisibility(8);
        this.kEB.setUserId(postData.aWl().getUserId());
        this.kEB.setUserName(postData.aWl().getUserName());
        this.kEB.setIsBigV(postData.aWl().isBigV());
        this.kEC.setText(postData.aWl().getName_show());
        this.kEC.setTag(postData.aWl().getUserId());
        this.kEB.startLoad(postData.aWl().getAvater(), 28, false);
        this.kEH.a(postData.aWl());
    }

    public void ar(float f) {
        this.kED.setAlpha(f);
    }

    public View cSD() {
        return this.kED;
    }

    public void onChangeSkin(int i) {
        if (this.kEG != null) {
            this.kEG.onChangeSkinType(i);
        }
        ao.setViewTextColor(this.kEE, R.color.cp_cont_a);
        if (this.kEC != null) {
            ao.setViewTextColor(this.kEC, R.color.cp_cont_a);
        }
        if (this.kEF != null) {
            ao.setBackgroundResource(this.kEF, R.drawable.icon_weiba);
        }
    }

    public void U(View.OnClickListener onClickListener) {
        this.kEI = onClickListener;
    }

    public void onDestroy() {
    }
}
