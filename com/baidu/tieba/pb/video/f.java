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
    private View.OnClickListener gcS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.lYZ || view == f.this.lZa || view == f.this.lZd) {
                f.this.dI(view);
            }
        }
    };
    private View kTH;
    private HeadImageView lYZ;
    private TextView lZa;
    private RelativeLayout lZb;
    private TextView lZc;
    private ImageView lZd;
    private PbVideoFullUserInfoLikeButton lZe;
    private e lZf;
    private View.OnClickListener lZg;
    private LinearLayout lZh;

    public f(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.eNx = tbPageContext;
        this.kTH = y(tbPageContext);
        initView();
        frameLayout.addView(this.kTH);
    }

    private View y(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.lZb = (RelativeLayout) this.kTH.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.lYZ = (HeadImageView) this.kTH.findViewById(R.id.pbVideoFullPhoto);
        this.lYZ.setOnClickListener(this.gcS);
        this.lZh = (LinearLayout) this.kTH.findViewById(R.id.pbVideoFullNameLayout);
        ap.setBackgroundResource(this.lZh, R.drawable.video_author_bg);
        this.lZa = (TextView) this.kTH.findViewById(R.id.pbVideoFullUserName);
        this.lZa.setOnClickListener(this.gcS);
        this.lZc = (TextView) this.kTH.findViewById(R.id.pbVideoFullAttention);
        this.lZc.setOnClickListener(this.gcS);
        this.lZd = (ImageView) this.kTH.findViewById(R.id.pbVideoFullChannelIcon);
        this.lZe = (PbVideoFullUserInfoLikeButton) this.kTH.findViewById(R.id.pbVideoFullLikeButton);
        this.lZe.setTextSize(0, l.getDimens(this.eNx.getPageActivity(), R.dimen.tbds30));
        this.lZf = new e(this.eNx, this.lZe);
        this.lYZ.setRadius(l.getDimens(this.eNx.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dI(View view) {
        if (this.lZg != null) {
            this.lZg.onClick(view);
        }
    }

    public void a(PostData postData, by byVar, o oVar) {
        this.lZe.setVisibility(0);
        this.lZc.setVisibility(8);
        w(postData);
        if (aM(byVar)) {
            this.lZc.setVisibility(8);
            this.lZe.setVisibility(8);
        }
    }

    private boolean aM(by byVar) {
        if (byVar == null || byVar.boP() == null || byVar.boP().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), byVar.boP().getUserId());
    }

    private void w(PostData postData) {
        this.lZd.setVisibility(8);
        this.lYZ.setUserId(postData.boP().getUserId());
        this.lYZ.setUserName(postData.boP().getUserName());
        this.lYZ.setIsBigV(postData.boP().isBigV());
        this.lZa.setText(postData.boP().getName_show());
        this.lZa.setTag(postData.boP().getUserId());
        this.lYZ.startLoad(postData.boP().getAvater(), 28, false);
        this.lZf.a(postData.boP());
    }

    public void aP(float f) {
        this.lZb.setAlpha(f);
    }

    public View dvn() {
        return this.lZb;
    }

    public void onChangeSkin(int i) {
        if (this.lZe != null) {
            this.lZe.onChangeSkinType(i);
        }
        ap.setViewTextColor(this.lZc, R.color.CAM_X0101);
        if (this.lZa != null) {
            ap.setViewTextColor(this.lZa, R.color.CAM_X0101);
        }
        if (this.lZd != null) {
            ap.setBackgroundResource(this.lZd, R.drawable.icon_weiba);
        }
    }

    public void V(View.OnClickListener onClickListener) {
        this.lZg = onClickListener;
    }

    public void onDestroy() {
    }
}
