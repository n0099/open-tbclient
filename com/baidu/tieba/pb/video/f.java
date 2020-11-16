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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.o;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes21.dex */
public class f {
    private TbPageContext eGu;
    private View.OnClickListener fUG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.lKZ || view == f.this.lLa || view == f.this.lLd) {
                f.this.dy(view);
            }
        }
    };
    private View kGn;
    private HeadImageView lKZ;
    private TextView lLa;
    private RelativeLayout lLb;
    private TextView lLc;
    private ImageView lLd;
    private PbVideoFullUserInfoLikeButton lLe;
    private e lLf;
    private View.OnClickListener lLg;
    private LinearLayout lLh;

    public f(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.eGu = tbPageContext;
        this.kGn = y(tbPageContext);
        initView();
        frameLayout.addView(this.kGn);
    }

    private View y(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.lLb = (RelativeLayout) this.kGn.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.lKZ = (HeadImageView) this.kGn.findViewById(R.id.pbVideoFullPhoto);
        this.lKZ.setOnClickListener(this.fUG);
        this.lLh = (LinearLayout) this.kGn.findViewById(R.id.pbVideoFullNameLayout);
        ap.setBackgroundResource(this.lLh, R.drawable.video_author_bg);
        this.lLa = (TextView) this.kGn.findViewById(R.id.pbVideoFullUserName);
        this.lLa.setOnClickListener(this.fUG);
        this.lLc = (TextView) this.kGn.findViewById(R.id.pbVideoFullAttention);
        this.lLc.setOnClickListener(this.fUG);
        this.lLd = (ImageView) this.kGn.findViewById(R.id.pbVideoFullChannelIcon);
        this.lLe = (PbVideoFullUserInfoLikeButton) this.kGn.findViewById(R.id.pbVideoFullLikeButton);
        this.lLe.setTextSize(0, l.getDimens(this.eGu.getPageActivity(), R.dimen.tbds30));
        this.lLf = new e(this.eGu, this.lLe);
        this.lKZ.setRadius(l.getDimens(this.eGu.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dy(View view) {
        if (this.lLg != null) {
            this.lLg.onClick(view);
        }
    }

    public void a(PostData postData, bx bxVar, o oVar) {
        this.lLe.setVisibility(0);
        this.lLc.setVisibility(8);
        v(postData);
        if (aM(bxVar)) {
            this.lLc.setVisibility(8);
            this.lLe.setVisibility(8);
        }
    }

    private boolean aM(bx bxVar) {
        if (bxVar == null || bxVar.blC() == null || bxVar.blC().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bxVar.blC().getUserId());
    }

    private void v(PostData postData) {
        this.lLd.setVisibility(8);
        this.lKZ.setUserId(postData.blC().getUserId());
        this.lKZ.setUserName(postData.blC().getUserName());
        this.lKZ.setIsBigV(postData.blC().isBigV());
        this.lLa.setText(postData.blC().getName_show());
        this.lLa.setTag(postData.blC().getUserId());
        this.lKZ.startLoad(postData.blC().getAvater(), 28, false);
        this.lLf.a(postData.blC());
    }

    public void aO(float f) {
        this.lLb.setAlpha(f);
    }

    public View dpT() {
        return this.lLb;
    }

    public void onChangeSkin(int i) {
        if (this.lLe != null) {
            this.lLe.onChangeSkinType(i);
        }
        ap.setViewTextColor(this.lLc, R.color.CAM_X0101);
        if (this.lLa != null) {
            ap.setViewTextColor(this.lLa, R.color.CAM_X0101);
        }
        if (this.lLd != null) {
            ap.setBackgroundResource(this.lLd, R.drawable.icon_weiba);
        }
    }

    public void V(View.OnClickListener onClickListener) {
        this.lLg = onClickListener;
    }

    public void onDestroy() {
    }
}
