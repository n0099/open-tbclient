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
    private TbPageContext cVg;
    private View.OnClickListener ecb = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.iXd || view == f.this.iXe || view == f.this.iXh) {
                f.this.cF(view);
            }
        }
    };
    private View hZa;
    private HeadImageView iXd;
    private TextView iXe;
    private RelativeLayout iXf;
    private TextView iXg;
    private ImageView iXh;
    private PbVideoFullUserInfoLikeButton iXi;
    private e iXj;
    private View.OnClickListener iXk;
    private LinearLayout iXl;

    public f(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.cVg = tbPageContext;
        this.hZa = t(tbPageContext);
        initView();
        frameLayout.addView(this.hZa);
    }

    private View t(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.iXf = (RelativeLayout) this.hZa.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.iXd = (HeadImageView) this.hZa.findViewById(R.id.pbVideoFullPhoto);
        this.iXd.setOnClickListener(this.ecb);
        this.iXl = (LinearLayout) this.hZa.findViewById(R.id.pbVideoFullNameLayout);
        am.setBackgroundResource(this.iXl, R.drawable.video_author_bg);
        this.iXe = (TextView) this.hZa.findViewById(R.id.pbVideoFullUserName);
        this.iXe.setOnClickListener(this.ecb);
        this.iXg = (TextView) this.hZa.findViewById(R.id.pbVideoFullAttention);
        this.iXg.setOnClickListener(this.ecb);
        this.iXh = (ImageView) this.hZa.findViewById(R.id.pbVideoFullChannelIcon);
        this.iXi = (PbVideoFullUserInfoLikeButton) this.hZa.findViewById(R.id.pbVideoFullLikeButton);
        this.iXi.setTextSize(0, l.getDimens(this.cVg.getPageActivity(), R.dimen.tbds30));
        this.iXj = new e(this.cVg, this.iXi);
        this.iXd.setRadius(l.getDimens(this.cVg.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF(View view) {
        if (this.iXk != null) {
            this.iXk.onClick(view);
        }
    }

    public void a(PostData postData, bj bjVar, k kVar) {
        this.iXi.setVisibility(0);
        this.iXg.setVisibility(8);
        s(postData);
        if (aI(bjVar)) {
            this.iXg.setVisibility(8);
            this.iXi.setVisibility(8);
        }
    }

    private boolean aI(bj bjVar) {
        if (bjVar == null || bjVar.aCm() == null || bjVar.aCm().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bjVar.aCm().getUserId());
    }

    private void s(PostData postData) {
        this.iXh.setVisibility(8);
        this.iXd.setUserId(postData.aCm().getUserId());
        this.iXd.setUserName(postData.aCm().getUserName());
        this.iXd.setIsBigV(postData.aCm().isBigV());
        this.iXe.setText(postData.aCm().getName_show());
        this.iXe.setTag(postData.aCm().getUserId());
        this.iXd.startLoad(postData.aCm().getAvater(), 28, false);
        this.iXj.a(postData.aCm());
    }

    public void aE(float f) {
        this.iXf.setAlpha(f);
    }

    public View csi() {
        return this.iXf;
    }

    public void onChangeSkin(int i) {
        if (this.iXi != null) {
            this.iXi.onChangeSkinType(i);
        }
        am.setViewTextColor(this.iXg, (int) R.color.cp_cont_a);
        if (this.iXe != null) {
            am.setViewTextColor(this.iXe, (int) R.color.cp_cont_a);
        }
        if (this.iXh != null) {
            am.setBackgroundResource(this.iXh, R.drawable.icon_weiba);
        }
    }

    public void R(View.OnClickListener onClickListener) {
        this.iXk = onClickListener;
    }

    public void onDestroy() {
    }
}
