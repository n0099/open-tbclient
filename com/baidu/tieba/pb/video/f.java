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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.o;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes22.dex */
public class f {
    private TbPageContext eNx;
    private View.OnClickListener gcQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.lYX || view == f.this.lYY || view == f.this.lZb) {
                f.this.dI(view);
            }
        }
    };
    private View kTF;
    private HeadImageView lYX;
    private TextView lYY;
    private RelativeLayout lYZ;
    private TextView lZa;
    private ImageView lZb;
    private PbVideoFullUserInfoLikeButton lZc;
    private e lZd;
    private View.OnClickListener lZe;
    private LinearLayout lZf;

    public f(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.eNx = tbPageContext;
        this.kTF = y(tbPageContext);
        initView();
        frameLayout.addView(this.kTF);
    }

    private View y(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.lYZ = (RelativeLayout) this.kTF.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.lYX = (HeadImageView) this.kTF.findViewById(R.id.pbVideoFullPhoto);
        this.lYX.setOnClickListener(this.gcQ);
        this.lZf = (LinearLayout) this.kTF.findViewById(R.id.pbVideoFullNameLayout);
        ap.setBackgroundResource(this.lZf, R.drawable.video_author_bg);
        this.lYY = (TextView) this.kTF.findViewById(R.id.pbVideoFullUserName);
        this.lYY.setOnClickListener(this.gcQ);
        this.lZa = (TextView) this.kTF.findViewById(R.id.pbVideoFullAttention);
        this.lZa.setOnClickListener(this.gcQ);
        this.lZb = (ImageView) this.kTF.findViewById(R.id.pbVideoFullChannelIcon);
        this.lZc = (PbVideoFullUserInfoLikeButton) this.kTF.findViewById(R.id.pbVideoFullLikeButton);
        this.lZc.setTextSize(0, l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds30));
        this.lZd = new e(this.eNx, this.lZc);
        this.lYX.setRadius(l.getDimens(this.eNx.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dI(View view) {
        if (this.lZe != null) {
            this.lZe.onClick(view);
        }
    }

    public void a(PostData postData, by byVar, o oVar) {
        this.lZc.setVisibility(0);
        this.lZa.setVisibility(8);
        w(postData);
        if (aM(byVar)) {
            this.lZa.setVisibility(8);
            this.lZc.setVisibility(8);
        }
    }

    private boolean aM(by byVar) {
        if (byVar == null || byVar.boP() == null || byVar.boP().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), byVar.boP().getUserId());
    }

    private void w(PostData postData) {
        this.lZb.setVisibility(8);
        this.lYX.setUserId(postData.boP().getUserId());
        this.lYX.setUserName(postData.boP().getUserName());
        this.lYX.setIsBigV(postData.boP().isBigV());
        this.lYY.setText(postData.boP().getName_show());
        this.lYY.setTag(postData.boP().getUserId());
        this.lYX.startLoad(postData.boP().getAvater(), 28, false);
        this.lZd.a(postData.boP());
    }

    public void aP(float f) {
        this.lYZ.setAlpha(f);
    }

    public View dvm() {
        return this.lYZ;
    }

    public void onChangeSkin(int i) {
        if (this.lZc != null) {
            this.lZc.onChangeSkinType(i);
        }
        ap.setViewTextColor(this.lZa, R.color.CAM_X0101);
        if (this.lYY != null) {
            ap.setViewTextColor(this.lYY, R.color.CAM_X0101);
        }
        if (this.lZb != null) {
            ap.setBackgroundResource(this.lZb, R.drawable.icon_weiba);
        }
    }

    public void V(View.OnClickListener onClickListener) {
        this.lZe = onClickListener;
    }

    public void onDestroy() {
    }
}
