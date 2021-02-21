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
    private View bUP;
    private TbPageContext eUY;
    private View.OnClickListener gkd = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == e.this.mjc || view == e.this.mjd || view == e.this.mjg) {
                e.this.dQ(view);
            }
        }
    };
    private HeadImageView mjc;
    private TextView mjd;
    private RelativeLayout mje;
    private TextView mjf;
    private ImageView mjg;
    private PbVideoFullUserInfoLikeButton mjh;
    private d mji;
    private View.OnClickListener mjj;
    private LinearLayout mjk;

    public e(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.eUY = tbPageContext;
        this.bUP = z(tbPageContext);
        initView();
        frameLayout.addView(this.bUP);
    }

    private View z(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.mje = (RelativeLayout) this.bUP.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.mjc = (HeadImageView) this.bUP.findViewById(R.id.pbVideoFullPhoto);
        this.mjc.setOnClickListener(this.gkd);
        this.mjk = (LinearLayout) this.bUP.findViewById(R.id.pbVideoFullNameLayout);
        ap.setBackgroundResource(this.mjk, R.drawable.video_author_bg);
        this.mjd = (TextView) this.bUP.findViewById(R.id.pbVideoFullUserName);
        this.mjd.setOnClickListener(this.gkd);
        this.mjf = (TextView) this.bUP.findViewById(R.id.pbVideoFullAttention);
        this.mjf.setOnClickListener(this.gkd);
        this.mjg = (ImageView) this.bUP.findViewById(R.id.pbVideoFullChannelIcon);
        this.mjh = (PbVideoFullUserInfoLikeButton) this.bUP.findViewById(R.id.pbVideoFullLikeButton);
        this.mjh.setTextSize(0, l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds30));
        this.mji = new d(this.eUY, this.mjh);
        this.mjc.setRadius(l.getDimens(this.eUY.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQ(View view) {
        if (this.mjj != null) {
            this.mjj.onClick(view);
        }
    }

    public void a(PostData postData, cb cbVar, p pVar) {
        this.mjh.setVisibility(0);
        this.mjf.setVisibility(8);
        w(postData);
        if (aO(cbVar)) {
            this.mjf.setVisibility(8);
            this.mjh.setVisibility(8);
        }
    }

    private boolean aO(cb cbVar) {
        if (cbVar == null || cbVar.bnQ() == null || cbVar.bnQ().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cbVar.bnQ().getUserId());
    }

    private void w(PostData postData) {
        this.mjg.setVisibility(8);
        this.mjc.setUserId(postData.bnQ().getUserId());
        this.mjc.setUserName(postData.bnQ().getUserName());
        this.mjc.setIsBigV(postData.bnQ().isBigV());
        this.mjd.setText(postData.bnQ().getName_show());
        this.mjd.setTag(postData.bnQ().getUserId());
        this.mjc.startLoad(postData.bnQ().getAvater(), 28, false);
        this.mji.a(postData.bnQ());
    }

    public void aU(float f) {
        this.mje.setAlpha(f);
    }

    public View dtG() {
        return this.mje;
    }

    public void onChangeSkin(int i) {
        if (this.mjh != null) {
            this.mjh.onChangeSkinType(i);
        }
        ap.setViewTextColor(this.mjf, R.color.CAM_X0101);
        if (this.mjd != null) {
            ap.setViewTextColor(this.mjd, R.color.CAM_X0101);
        }
        if (this.mjg != null) {
            ap.setBackgroundResource(this.mjg, R.drawable.icon_weiba);
        }
    }

    public void X(View.OnClickListener onClickListener) {
        this.mjj = onClickListener;
    }

    public void onDestroy() {
    }
}
