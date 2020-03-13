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
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class f {
    private TbPageContext cVi;
    private View.OnClickListener ecp = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.iXr || view == f.this.iXs || view == f.this.iXv) {
                f.this.cF(view);
            }
        }
    };
    private View hZo;
    private HeadImageView iXr;
    private TextView iXs;
    private RelativeLayout iXt;
    private TextView iXu;
    private ImageView iXv;
    private PbVideoFullUserInfoLikeButton iXw;
    private e iXx;
    private View.OnClickListener iXy;
    private LinearLayout iXz;

    public f(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.cVi = tbPageContext;
        this.hZo = t(tbPageContext);
        initView();
        frameLayout.addView(this.hZo);
    }

    private View t(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.iXt = (RelativeLayout) this.hZo.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.iXr = (HeadImageView) this.hZo.findViewById(R.id.pbVideoFullPhoto);
        this.iXr.setOnClickListener(this.ecp);
        this.iXz = (LinearLayout) this.hZo.findViewById(R.id.pbVideoFullNameLayout);
        am.setBackgroundResource(this.iXz, R.drawable.video_author_bg);
        this.iXs = (TextView) this.hZo.findViewById(R.id.pbVideoFullUserName);
        this.iXs.setOnClickListener(this.ecp);
        this.iXu = (TextView) this.hZo.findViewById(R.id.pbVideoFullAttention);
        this.iXu.setOnClickListener(this.ecp);
        this.iXv = (ImageView) this.hZo.findViewById(R.id.pbVideoFullChannelIcon);
        this.iXw = (PbVideoFullUserInfoLikeButton) this.hZo.findViewById(R.id.pbVideoFullLikeButton);
        this.iXw.setTextSize(0, l.getDimens(this.cVi.getPageActivity(), R.dimen.tbds30));
        this.iXx = new e(this.cVi, this.iXw);
        this.iXr.setRadius(l.getDimens(this.cVi.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF(View view) {
        if (this.iXy != null) {
            this.iXy.onClick(view);
        }
    }

    public void a(PostData postData, bj bjVar, k kVar) {
        this.iXw.setVisibility(0);
        this.iXu.setVisibility(8);
        s(postData);
        if (aI(bjVar)) {
            this.iXu.setVisibility(8);
            this.iXw.setVisibility(8);
        }
    }

    private boolean aI(bj bjVar) {
        if (bjVar == null || bjVar.aCo() == null || bjVar.aCo().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bjVar.aCo().getUserId());
    }

    private void s(PostData postData) {
        this.iXv.setVisibility(8);
        this.iXr.setUserId(postData.aCo().getUserId());
        this.iXr.setUserName(postData.aCo().getUserName());
        this.iXr.setIsBigV(postData.aCo().isBigV());
        this.iXs.setText(postData.aCo().getName_show());
        this.iXs.setTag(postData.aCo().getUserId());
        this.iXr.startLoad(postData.aCo().getAvater(), 28, false);
        this.iXx.a(postData.aCo());
    }

    public void aE(float f) {
        this.iXt.setAlpha(f);
    }

    public View csl() {
        return this.iXt;
    }

    public void onChangeSkin(int i) {
        if (this.iXw != null) {
            this.iXw.onChangeSkinType(i);
        }
        am.setViewTextColor(this.iXu, (int) R.color.cp_cont_a);
        if (this.iXs != null) {
            am.setViewTextColor(this.iXs, (int) R.color.cp_cont_a);
        }
        if (this.iXv != null) {
            am.setBackgroundResource(this.iXv, R.drawable.icon_weiba);
        }
    }

    public void R(View.OnClickListener onClickListener) {
        this.iXy = onClickListener;
    }

    public void onDestroy() {
    }
}
