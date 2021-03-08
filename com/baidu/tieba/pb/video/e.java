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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class e {
    private View bWp;
    private TbPageContext eWx;
    private View.OnClickListener glG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == e.this.mle || view == e.this.mlf || view == e.this.mli) {
                e.this.dQ(view);
            }
        }
    };
    private HeadImageView mle;
    private TextView mlf;
    private RelativeLayout mlg;
    private TextView mlh;
    private ImageView mli;
    private PbVideoFullUserInfoLikeButton mlj;
    private d mlk;
    private View.OnClickListener mll;
    private LinearLayout mlm;

    public e(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.eWx = tbPageContext;
        this.bWp = z(tbPageContext);
        initView();
        frameLayout.addView(this.bWp);
    }

    private View z(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.mlg = (RelativeLayout) this.bWp.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.mle = (HeadImageView) this.bWp.findViewById(R.id.pbVideoFullPhoto);
        this.mle.setOnClickListener(this.glG);
        this.mlm = (LinearLayout) this.bWp.findViewById(R.id.pbVideoFullNameLayout);
        ap.setBackgroundResource(this.mlm, R.drawable.video_author_bg);
        this.mlf = (TextView) this.bWp.findViewById(R.id.pbVideoFullUserName);
        this.mlf.setOnClickListener(this.glG);
        this.mlh = (TextView) this.bWp.findViewById(R.id.pbVideoFullAttention);
        this.mlh.setOnClickListener(this.glG);
        this.mli = (ImageView) this.bWp.findViewById(R.id.pbVideoFullChannelIcon);
        this.mlj = (PbVideoFullUserInfoLikeButton) this.bWp.findViewById(R.id.pbVideoFullLikeButton);
        this.mlj.setTextSize(0, l.getDimens(this.eWx.getPageActivity(), R.dimen.tbds30));
        this.mlk = new d(this.eWx, this.mlj);
        this.mle.setRadius(l.getDimens(this.eWx.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQ(View view) {
        if (this.mll != null) {
            this.mll.onClick(view);
        }
    }

    public void a(PostData postData, cb cbVar, p pVar) {
        this.mlj.setVisibility(0);
        this.mlh.setVisibility(8);
        w(postData);
        if (aO(cbVar)) {
            this.mlh.setVisibility(8);
            this.mlj.setVisibility(8);
        }
    }

    private boolean aO(cb cbVar) {
        if (cbVar == null || cbVar.bnS() == null || cbVar.bnS().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cbVar.bnS().getUserId());
    }

    private void w(PostData postData) {
        this.mli.setVisibility(8);
        this.mle.setUserId(postData.bnS().getUserId());
        this.mle.setUserName(postData.bnS().getUserName());
        this.mle.setIsBigV(postData.bnS().isBigV());
        this.mlf.setText(postData.bnS().getName_show());
        this.mlf.setTag(postData.bnS().getUserId());
        this.mle.startLoad(postData.bnS().getAvater(), 28, false);
        this.mlk.a(postData.bnS());
    }

    public void aY(float f) {
        this.mlg.setAlpha(f);
    }

    public View dtP() {
        return this.mlg;
    }

    public void onChangeSkin(int i) {
        if (this.mlj != null) {
            this.mlj.onChangeSkinType(i);
        }
        ap.setViewTextColor(this.mlh, R.color.CAM_X0101);
        if (this.mlf != null) {
            ap.setViewTextColor(this.mlf, R.color.CAM_X0101);
        }
        if (this.mli != null) {
            ap.setBackgroundResource(this.mli, R.drawable.icon_weiba);
        }
    }

    public void Y(View.OnClickListener onClickListener) {
        this.mll = onClickListener;
    }

    public void onDestroy() {
    }
}
