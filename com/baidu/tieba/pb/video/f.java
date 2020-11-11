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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.o;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes22.dex */
public class f {
    private TbPageContext eIc;
    private View.OnClickListener fUZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.lKH || view == f.this.lKI || view == f.this.lKL) {
                f.this.du(view);
            }
        }
    };
    private View kFY;
    private HeadImageView lKH;
    private TextView lKI;
    private RelativeLayout lKJ;
    private TextView lKK;
    private ImageView lKL;
    private PbVideoFullUserInfoLikeButton lKM;
    private e lKN;
    private View.OnClickListener lKO;
    private LinearLayout lKP;

    public f(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.eIc = tbPageContext;
        this.kFY = y(tbPageContext);
        initView();
        frameLayout.addView(this.kFY);
    }

    private View y(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.lKJ = (RelativeLayout) this.kFY.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.lKH = (HeadImageView) this.kFY.findViewById(R.id.pbVideoFullPhoto);
        this.lKH.setOnClickListener(this.fUZ);
        this.lKP = (LinearLayout) this.kFY.findViewById(R.id.pbVideoFullNameLayout);
        ap.setBackgroundResource(this.lKP, R.drawable.video_author_bg);
        this.lKI = (TextView) this.kFY.findViewById(R.id.pbVideoFullUserName);
        this.lKI.setOnClickListener(this.fUZ);
        this.lKK = (TextView) this.kFY.findViewById(R.id.pbVideoFullAttention);
        this.lKK.setOnClickListener(this.fUZ);
        this.lKL = (ImageView) this.kFY.findViewById(R.id.pbVideoFullChannelIcon);
        this.lKM = (PbVideoFullUserInfoLikeButton) this.kFY.findViewById(R.id.pbVideoFullLikeButton);
        this.lKM.setTextSize(0, l.getDimens(this.eIc.getPageActivity(), R.dimen.tbds30));
        this.lKN = new e(this.eIc, this.lKM);
        this.lKH.setRadius(l.getDimens(this.eIc.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void du(View view) {
        if (this.lKO != null) {
            this.lKO.onClick(view);
        }
    }

    public void a(PostData postData, bw bwVar, o oVar) {
        this.lKM.setVisibility(0);
        this.lKK.setVisibility(8);
        v(postData);
        if (aK(bwVar)) {
            this.lKK.setVisibility(8);
            this.lKM.setVisibility(8);
        }
    }

    private boolean aK(bw bwVar) {
        if (bwVar == null || bwVar.bmA() == null || bwVar.bmA().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bwVar.bmA().getUserId());
    }

    private void v(PostData postData) {
        this.lKL.setVisibility(8);
        this.lKH.setUserId(postData.bmA().getUserId());
        this.lKH.setUserName(postData.bmA().getUserName());
        this.lKH.setIsBigV(postData.bmA().isBigV());
        this.lKI.setText(postData.bmA().getName_show());
        this.lKI.setTag(postData.bmA().getUserId());
        this.lKH.startLoad(postData.bmA().getAvater(), 28, false);
        this.lKN.a(postData.bmA());
    }

    public void aH(float f) {
        this.lKJ.setAlpha(f);
    }

    public View dqt() {
        return this.lKJ;
    }

    public void onChangeSkin(int i) {
        if (this.lKM != null) {
            this.lKM.onChangeSkinType(i);
        }
        ap.setViewTextColor(this.lKK, R.color.cp_cont_a);
        if (this.lKI != null) {
            ap.setViewTextColor(this.lKI, R.color.cp_cont_a);
        }
        if (this.lKL != null) {
            ap.setBackgroundResource(this.lKL, R.drawable.icon_weiba);
        }
    }

    public void W(View.OnClickListener onClickListener) {
        this.lKO = onClickListener;
    }

    public void onDestroy() {
    }
}
