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
    private TbPageContext cVh;
    private View.OnClickListener ecc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.iXf || view == f.this.iXg || view == f.this.iXj) {
                f.this.cF(view);
            }
        }
    };
    private View hZc;
    private HeadImageView iXf;
    private TextView iXg;
    private RelativeLayout iXh;
    private TextView iXi;
    private ImageView iXj;
    private PbVideoFullUserInfoLikeButton iXk;
    private e iXl;
    private View.OnClickListener iXm;
    private LinearLayout iXn;

    public f(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.cVh = tbPageContext;
        this.hZc = t(tbPageContext);
        initView();
        frameLayout.addView(this.hZc);
    }

    private View t(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.iXh = (RelativeLayout) this.hZc.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.iXf = (HeadImageView) this.hZc.findViewById(R.id.pbVideoFullPhoto);
        this.iXf.setOnClickListener(this.ecc);
        this.iXn = (LinearLayout) this.hZc.findViewById(R.id.pbVideoFullNameLayout);
        am.setBackgroundResource(this.iXn, R.drawable.video_author_bg);
        this.iXg = (TextView) this.hZc.findViewById(R.id.pbVideoFullUserName);
        this.iXg.setOnClickListener(this.ecc);
        this.iXi = (TextView) this.hZc.findViewById(R.id.pbVideoFullAttention);
        this.iXi.setOnClickListener(this.ecc);
        this.iXj = (ImageView) this.hZc.findViewById(R.id.pbVideoFullChannelIcon);
        this.iXk = (PbVideoFullUserInfoLikeButton) this.hZc.findViewById(R.id.pbVideoFullLikeButton);
        this.iXk.setTextSize(0, l.getDimens(this.cVh.getPageActivity(), R.dimen.tbds30));
        this.iXl = new e(this.cVh, this.iXk);
        this.iXf.setRadius(l.getDimens(this.cVh.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF(View view) {
        if (this.iXm != null) {
            this.iXm.onClick(view);
        }
    }

    public void a(PostData postData, bj bjVar, k kVar) {
        this.iXk.setVisibility(0);
        this.iXi.setVisibility(8);
        s(postData);
        if (aI(bjVar)) {
            this.iXi.setVisibility(8);
            this.iXk.setVisibility(8);
        }
    }

    private boolean aI(bj bjVar) {
        if (bjVar == null || bjVar.aCo() == null || bjVar.aCo().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bjVar.aCo().getUserId());
    }

    private void s(PostData postData) {
        this.iXj.setVisibility(8);
        this.iXf.setUserId(postData.aCo().getUserId());
        this.iXf.setUserName(postData.aCo().getUserName());
        this.iXf.setIsBigV(postData.aCo().isBigV());
        this.iXg.setText(postData.aCo().getName_show());
        this.iXg.setTag(postData.aCo().getUserId());
        this.iXf.startLoad(postData.aCo().getAvater(), 28, false);
        this.iXl.a(postData.aCo());
    }

    public void aE(float f) {
        this.iXh.setAlpha(f);
    }

    public View csk() {
        return this.iXh;
    }

    public void onChangeSkin(int i) {
        if (this.iXk != null) {
            this.iXk.onChangeSkinType(i);
        }
        am.setViewTextColor(this.iXi, (int) R.color.cp_cont_a);
        if (this.iXg != null) {
            am.setViewTextColor(this.iXg, (int) R.color.cp_cont_a);
        }
        if (this.iXj != null) {
            am.setBackgroundResource(this.iXj, R.drawable.icon_weiba);
        }
    }

    public void R(View.OnClickListener onClickListener) {
        this.iXm = onClickListener;
    }

    public void onDestroy() {
    }
}
