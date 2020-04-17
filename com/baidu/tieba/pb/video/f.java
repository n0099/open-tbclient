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
    private TbPageContext duG;
    private View.OnClickListener eCs = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.jJa || view == f.this.jJb || view == f.this.jJe) {
                f.this.cN(view);
            }
        }
    };
    private View iKI;
    private HeadImageView jJa;
    private TextView jJb;
    private RelativeLayout jJc;
    private TextView jJd;
    private ImageView jJe;
    private PbVideoFullUserInfoLikeButton jJf;
    private e jJg;
    private View.OnClickListener jJh;
    private LinearLayout jJi;

    public f(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.duG = tbPageContext;
        this.iKI = w(tbPageContext);
        initView();
        frameLayout.addView(this.iKI);
    }

    private View w(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.jJc = (RelativeLayout) this.iKI.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.jJa = (HeadImageView) this.iKI.findViewById(R.id.pbVideoFullPhoto);
        this.jJa.setOnClickListener(this.eCs);
        this.jJi = (LinearLayout) this.iKI.findViewById(R.id.pbVideoFullNameLayout);
        am.setBackgroundResource(this.jJi, R.drawable.video_author_bg);
        this.jJb = (TextView) this.iKI.findViewById(R.id.pbVideoFullUserName);
        this.jJb.setOnClickListener(this.eCs);
        this.jJd = (TextView) this.iKI.findViewById(R.id.pbVideoFullAttention);
        this.jJd.setOnClickListener(this.eCs);
        this.jJe = (ImageView) this.iKI.findViewById(R.id.pbVideoFullChannelIcon);
        this.jJf = (PbVideoFullUserInfoLikeButton) this.iKI.findViewById(R.id.pbVideoFullLikeButton);
        this.jJf.setTextSize(0, l.getDimens(this.duG.getPageActivity(), R.dimen.tbds30));
        this.jJg = new e(this.duG, this.jJf);
        this.jJa.setRadius(l.getDimens(this.duG.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(View view) {
        if (this.jJh != null) {
            this.jJh.onClick(view);
        }
    }

    public void a(PostData postData, bj bjVar, k kVar) {
        this.jJf.setVisibility(0);
        this.jJd.setVisibility(8);
        s(postData);
        if (aK(bjVar)) {
            this.jJd.setVisibility(8);
            this.jJf.setVisibility(8);
        }
    }

    private boolean aK(bj bjVar) {
        if (bjVar == null || bjVar.aKE() == null || bjVar.aKE().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bjVar.aKE().getUserId());
    }

    private void s(PostData postData) {
        this.jJe.setVisibility(8);
        this.jJa.setUserId(postData.aKE().getUserId());
        this.jJa.setUserName(postData.aKE().getUserName());
        this.jJa.setIsBigV(postData.aKE().isBigV());
        this.jJb.setText(postData.aKE().getName_show());
        this.jJb.setTag(postData.aKE().getUserId());
        this.jJa.startLoad(postData.aKE().getAvater(), 28, false);
        this.jJg.a(postData.aKE());
    }

    public void ao(float f) {
        this.jJc.setAlpha(f);
    }

    public View cDm() {
        return this.jJc;
    }

    public void onChangeSkin(int i) {
        if (this.jJf != null) {
            this.jJf.onChangeSkinType(i);
        }
        am.setViewTextColor(this.jJd, (int) R.color.cp_cont_a);
        if (this.jJb != null) {
            am.setViewTextColor(this.jJb, (int) R.color.cp_cont_a);
        }
        if (this.jJe != null) {
            am.setBackgroundResource(this.jJe, R.drawable.icon_weiba);
        }
    }

    public void S(View.OnClickListener onClickListener) {
        this.jJh = onClickListener;
    }

    public void onDestroy() {
    }
}
