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
    private TbPageContext etO;
    private View.OnClickListener fGO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.lsm || view == f.this.lsn || view == f.this.lsq) {
                f.this.dl(view);
            }
        }
    };
    private View knH;
    private HeadImageView lsm;
    private TextView lsn;
    private RelativeLayout lso;
    private TextView lsp;
    private ImageView lsq;
    private PbVideoFullUserInfoLikeButton lsr;
    private e lss;
    private View.OnClickListener lst;
    private LinearLayout lsu;

    public f(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.etO = tbPageContext;
        this.knH = y(tbPageContext);
        initView();
        frameLayout.addView(this.knH);
    }

    private View y(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.lso = (RelativeLayout) this.knH.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.lsm = (HeadImageView) this.knH.findViewById(R.id.pbVideoFullPhoto);
        this.lsm.setOnClickListener(this.fGO);
        this.lsu = (LinearLayout) this.knH.findViewById(R.id.pbVideoFullNameLayout);
        ap.setBackgroundResource(this.lsu, R.drawable.video_author_bg);
        this.lsn = (TextView) this.knH.findViewById(R.id.pbVideoFullUserName);
        this.lsn.setOnClickListener(this.fGO);
        this.lsp = (TextView) this.knH.findViewById(R.id.pbVideoFullAttention);
        this.lsp.setOnClickListener(this.fGO);
        this.lsq = (ImageView) this.knH.findViewById(R.id.pbVideoFullChannelIcon);
        this.lsr = (PbVideoFullUserInfoLikeButton) this.knH.findViewById(R.id.pbVideoFullLikeButton);
        this.lsr.setTextSize(0, l.getDimens(this.etO.getPageActivity(), R.dimen.tbds30));
        this.lss = new e(this.etO, this.lsr);
        this.lsm.setRadius(l.getDimens(this.etO.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(View view) {
        if (this.lst != null) {
            this.lst.onClick(view);
        }
    }

    public void a(PostData postData, bw bwVar, o oVar) {
        this.lsr.setVisibility(0);
        this.lsp.setVisibility(8);
        v(postData);
        if (aK(bwVar)) {
            this.lsp.setVisibility(8);
            this.lsr.setVisibility(8);
        }
    }

    private boolean aK(bw bwVar) {
        if (bwVar == null || bwVar.bih() == null || bwVar.bih().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bwVar.bih().getUserId());
    }

    private void v(PostData postData) {
        this.lsq.setVisibility(8);
        this.lsm.setUserId(postData.bih().getUserId());
        this.lsm.setUserName(postData.bih().getUserName());
        this.lsm.setIsBigV(postData.bih().isBigV());
        this.lsn.setText(postData.bih().getName_show());
        this.lsn.setTag(postData.bih().getUserId());
        this.lsm.startLoad(postData.bih().getAvater(), 28, false);
        this.lss.a(postData.bih());
    }

    public void aD(float f) {
        this.lso.setAlpha(f);
    }

    public View dkJ() {
        return this.lso;
    }

    public void onChangeSkin(int i) {
        if (this.lsr != null) {
            this.lsr.onChangeSkinType(i);
        }
        ap.setViewTextColor(this.lsp, R.color.cp_cont_a);
        if (this.lsn != null) {
            ap.setViewTextColor(this.lsn, R.color.cp_cont_a);
        }
        if (this.lsq != null) {
            ap.setBackgroundResource(this.lsq, R.drawable.icon_weiba);
        }
    }

    public void V(View.OnClickListener onClickListener) {
        this.lst = onClickListener;
    }

    public void onDestroy() {
    }
}
