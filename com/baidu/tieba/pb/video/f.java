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
    private TbPageContext duK;
    private View.OnClickListener eCx = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.jJe || view == f.this.jJf || view == f.this.jJi) {
                f.this.cN(view);
            }
        }
    };
    private View iKM;
    private HeadImageView jJe;
    private TextView jJf;
    private RelativeLayout jJg;
    private TextView jJh;
    private ImageView jJi;
    private PbVideoFullUserInfoLikeButton jJj;
    private e jJk;
    private View.OnClickListener jJl;
    private LinearLayout jJm;

    public f(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.duK = tbPageContext;
        this.iKM = w(tbPageContext);
        initView();
        frameLayout.addView(this.iKM);
    }

    private View w(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.jJg = (RelativeLayout) this.iKM.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.jJe = (HeadImageView) this.iKM.findViewById(R.id.pbVideoFullPhoto);
        this.jJe.setOnClickListener(this.eCx);
        this.jJm = (LinearLayout) this.iKM.findViewById(R.id.pbVideoFullNameLayout);
        am.setBackgroundResource(this.jJm, R.drawable.video_author_bg);
        this.jJf = (TextView) this.iKM.findViewById(R.id.pbVideoFullUserName);
        this.jJf.setOnClickListener(this.eCx);
        this.jJh = (TextView) this.iKM.findViewById(R.id.pbVideoFullAttention);
        this.jJh.setOnClickListener(this.eCx);
        this.jJi = (ImageView) this.iKM.findViewById(R.id.pbVideoFullChannelIcon);
        this.jJj = (PbVideoFullUserInfoLikeButton) this.iKM.findViewById(R.id.pbVideoFullLikeButton);
        this.jJj.setTextSize(0, l.getDimens(this.duK.getPageActivity(), R.dimen.tbds30));
        this.jJk = new e(this.duK, this.jJj);
        this.jJe.setRadius(l.getDimens(this.duK.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(View view) {
        if (this.jJl != null) {
            this.jJl.onClick(view);
        }
    }

    public void a(PostData postData, bj bjVar, k kVar) {
        this.jJj.setVisibility(0);
        this.jJh.setVisibility(8);
        s(postData);
        if (aK(bjVar)) {
            this.jJh.setVisibility(8);
            this.jJj.setVisibility(8);
        }
    }

    private boolean aK(bj bjVar) {
        if (bjVar == null || bjVar.aKC() == null || bjVar.aKC().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bjVar.aKC().getUserId());
    }

    private void s(PostData postData) {
        this.jJi.setVisibility(8);
        this.jJe.setUserId(postData.aKC().getUserId());
        this.jJe.setUserName(postData.aKC().getUserName());
        this.jJe.setIsBigV(postData.aKC().isBigV());
        this.jJf.setText(postData.aKC().getName_show());
        this.jJf.setTag(postData.aKC().getUserId());
        this.jJe.startLoad(postData.aKC().getAvater(), 28, false);
        this.jJk.a(postData.aKC());
    }

    public void ao(float f) {
        this.jJg.setAlpha(f);
    }

    public View cDk() {
        return this.jJg;
    }

    public void onChangeSkin(int i) {
        if (this.jJj != null) {
            this.jJj.onChangeSkinType(i);
        }
        am.setViewTextColor(this.jJh, (int) R.color.cp_cont_a);
        if (this.jJf != null) {
            am.setViewTextColor(this.jJf, (int) R.color.cp_cont_a);
        }
        if (this.jJi != null) {
            am.setBackgroundResource(this.jJi, R.drawable.icon_weiba);
        }
    }

    public void S(View.OnClickListener onClickListener) {
        this.jJl = onClickListener;
    }

    public void onDestroy() {
    }
}
