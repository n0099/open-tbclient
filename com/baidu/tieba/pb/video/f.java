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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class f {
    private TbPageContext dIF;
    private View.OnClickListener eQW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.kaP || view == f.this.kaQ || view == f.this.kaT) {
                f.this.cO(view);
            }
        }
    };
    private View iZM;
    private HeadImageView kaP;
    private TextView kaQ;
    private RelativeLayout kaR;
    private TextView kaS;
    private ImageView kaT;
    private PbVideoFullUserInfoLikeButton kaU;
    private e kaV;
    private View.OnClickListener kaW;
    private LinearLayout kaX;

    public f(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.dIF = tbPageContext;
        this.iZM = w(tbPageContext);
        initView();
        frameLayout.addView(this.iZM);
    }

    private View w(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.kaR = (RelativeLayout) this.iZM.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.kaP = (HeadImageView) this.iZM.findViewById(R.id.pbVideoFullPhoto);
        this.kaP.setOnClickListener(this.eQW);
        this.kaX = (LinearLayout) this.iZM.findViewById(R.id.pbVideoFullNameLayout);
        am.setBackgroundResource(this.kaX, R.drawable.video_author_bg);
        this.kaQ = (TextView) this.iZM.findViewById(R.id.pbVideoFullUserName);
        this.kaQ.setOnClickListener(this.eQW);
        this.kaS = (TextView) this.iZM.findViewById(R.id.pbVideoFullAttention);
        this.kaS.setOnClickListener(this.eQW);
        this.kaT = (ImageView) this.iZM.findViewById(R.id.pbVideoFullChannelIcon);
        this.kaU = (PbVideoFullUserInfoLikeButton) this.iZM.findViewById(R.id.pbVideoFullLikeButton);
        this.kaU.setTextSize(0, l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds30));
        this.kaV = new e(this.dIF, this.kaU);
        this.kaP.setRadius(l.getDimens(this.dIF.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cO(View view) {
        if (this.kaW != null) {
            this.kaW.onClick(view);
        }
    }

    public void a(PostData postData, bk bkVar, m mVar) {
        this.kaU.setVisibility(0);
        this.kaS.setVisibility(8);
        v(postData);
        if (aK(bkVar)) {
            this.kaS.setVisibility(8);
            this.kaU.setVisibility(8);
        }
    }

    private boolean aK(bk bkVar) {
        if (bkVar == null || bkVar.aQx() == null || bkVar.aQx().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bkVar.aQx().getUserId());
    }

    private void v(PostData postData) {
        this.kaT.setVisibility(8);
        this.kaP.setUserId(postData.aQx().getUserId());
        this.kaP.setUserName(postData.aQx().getUserName());
        this.kaP.setIsBigV(postData.aQx().isBigV());
        this.kaQ.setText(postData.aQx().getName_show());
        this.kaQ.setTag(postData.aQx().getUserId());
        this.kaP.startLoad(postData.aQx().getAvater(), 28, false);
        this.kaV.a(postData.aQx());
    }

    public void an(float f) {
        this.kaR.setAlpha(f);
    }

    public View cKi() {
        return this.kaR;
    }

    public void onChangeSkin(int i) {
        if (this.kaU != null) {
            this.kaU.onChangeSkinType(i);
        }
        am.setViewTextColor(this.kaS, (int) R.color.cp_cont_a);
        if (this.kaQ != null) {
            am.setViewTextColor(this.kaQ, (int) R.color.cp_cont_a);
        }
        if (this.kaT != null) {
            am.setBackgroundResource(this.kaT, R.drawable.icon_weiba);
        }
    }

    public void S(View.OnClickListener onClickListener) {
        this.kaW = onClickListener;
    }

    public void onDestroy() {
    }
}
