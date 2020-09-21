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
/* loaded from: classes21.dex */
public class f {
    private TbPageContext ehG;
    private View.OnClickListener fuF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.lcV || view == f.this.lcW || view == f.this.lcZ) {
                f.this.dh(view);
            }
        }
    };
    private View jYr;
    private HeadImageView lcV;
    private TextView lcW;
    private RelativeLayout lcX;
    private TextView lcY;
    private ImageView lcZ;
    private PbVideoFullUserInfoLikeButton lda;
    private e ldb;
    private View.OnClickListener ldc;
    private LinearLayout ldd;

    public f(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.ehG = tbPageContext;
        this.jYr = y(tbPageContext);
        initView();
        frameLayout.addView(this.jYr);
    }

    private View y(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.lcX = (RelativeLayout) this.jYr.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.lcV = (HeadImageView) this.jYr.findViewById(R.id.pbVideoFullPhoto);
        this.lcV.setOnClickListener(this.fuF);
        this.ldd = (LinearLayout) this.jYr.findViewById(R.id.pbVideoFullNameLayout);
        ap.setBackgroundResource(this.ldd, R.drawable.video_author_bg);
        this.lcW = (TextView) this.jYr.findViewById(R.id.pbVideoFullUserName);
        this.lcW.setOnClickListener(this.fuF);
        this.lcY = (TextView) this.jYr.findViewById(R.id.pbVideoFullAttention);
        this.lcY.setOnClickListener(this.fuF);
        this.lcZ = (ImageView) this.jYr.findViewById(R.id.pbVideoFullChannelIcon);
        this.lda = (PbVideoFullUserInfoLikeButton) this.jYr.findViewById(R.id.pbVideoFullLikeButton);
        this.lda.setTextSize(0, l.getDimens(this.ehG.getPageActivity(), R.dimen.tbds30));
        this.ldb = new e(this.ehG, this.lda);
        this.lcV.setRadius(l.getDimens(this.ehG.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh(View view) {
        if (this.ldc != null) {
            this.ldc.onClick(view);
        }
    }

    public void a(PostData postData, bw bwVar, o oVar) {
        this.lda.setVisibility(0);
        this.lcY.setVisibility(8);
        v(postData);
        if (aK(bwVar)) {
            this.lcY.setVisibility(8);
            this.lda.setVisibility(8);
        }
    }

    private boolean aK(bw bwVar) {
        if (bwVar == null || bwVar.bfy() == null || bwVar.bfy().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bwVar.bfy().getUserId());
    }

    private void v(PostData postData) {
        this.lcZ.setVisibility(8);
        this.lcV.setUserId(postData.bfy().getUserId());
        this.lcV.setUserName(postData.bfy().getUserName());
        this.lcV.setIsBigV(postData.bfy().isBigV());
        this.lcW.setText(postData.bfy().getName_show());
        this.lcW.setTag(postData.bfy().getUserId());
        this.lcV.startLoad(postData.bfy().getAvater(), 28, false);
        this.ldb.a(postData.bfy());
    }

    public void ax(float f) {
        this.lcX.setAlpha(f);
    }

    public View dha() {
        return this.lcX;
    }

    public void onChangeSkin(int i) {
        if (this.lda != null) {
            this.lda.onChangeSkinType(i);
        }
        ap.setViewTextColor(this.lcY, R.color.cp_cont_a);
        if (this.lcW != null) {
            ap.setViewTextColor(this.lcW, R.color.cp_cont_a);
        }
        if (this.lcZ != null) {
            ap.setBackgroundResource(this.lcZ, R.drawable.icon_weiba);
        }
    }

    public void V(View.OnClickListener onClickListener) {
        this.ldc = onClickListener;
    }

    public void onDestroy() {
    }
}
