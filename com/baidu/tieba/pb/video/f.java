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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes9.dex */
public class f {
    private TbPageContext dPv;
    private View.OnClickListener fbs = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.kvI || view == f.this.kvJ || view == f.this.kvM) {
                f.this.cP(view);
            }
        }
    };
    private View jrJ;
    private HeadImageView kvI;
    private TextView kvJ;
    private RelativeLayout kvK;
    private TextView kvL;
    private ImageView kvM;
    private PbVideoFullUserInfoLikeButton kvN;
    private e kvO;
    private View.OnClickListener kvP;
    private LinearLayout kvQ;

    public f(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.dPv = tbPageContext;
        this.jrJ = z(tbPageContext);
        initView();
        frameLayout.addView(this.jrJ);
    }

    private View z(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.kvK = (RelativeLayout) this.jrJ.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.kvI = (HeadImageView) this.jrJ.findViewById(R.id.pbVideoFullPhoto);
        this.kvI.setOnClickListener(this.fbs);
        this.kvQ = (LinearLayout) this.jrJ.findViewById(R.id.pbVideoFullNameLayout);
        an.setBackgroundResource(this.kvQ, R.drawable.video_author_bg);
        this.kvJ = (TextView) this.jrJ.findViewById(R.id.pbVideoFullUserName);
        this.kvJ.setOnClickListener(this.fbs);
        this.kvL = (TextView) this.jrJ.findViewById(R.id.pbVideoFullAttention);
        this.kvL.setOnClickListener(this.fbs);
        this.kvM = (ImageView) this.jrJ.findViewById(R.id.pbVideoFullChannelIcon);
        this.kvN = (PbVideoFullUserInfoLikeButton) this.jrJ.findViewById(R.id.pbVideoFullLikeButton);
        this.kvN.setTextSize(0, l.getDimens(this.dPv.getPageActivity(), R.dimen.tbds30));
        this.kvO = new e(this.dPv, this.kvN);
        this.kvI.setRadius(l.getDimens(this.dPv.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cP(View view) {
        if (this.kvP != null) {
            this.kvP.onClick(view);
        }
    }

    public void a(PostData postData, bu buVar, m mVar) {
        this.kvN.setVisibility(0);
        this.kvL.setVisibility(8);
        v(postData);
        if (aL(buVar)) {
            this.kvL.setVisibility(8);
            this.kvN.setVisibility(8);
        }
    }

    private boolean aL(bu buVar) {
        if (buVar == null || buVar.aSp() == null || buVar.aSp().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), buVar.aSp().getUserId());
    }

    private void v(PostData postData) {
        this.kvM.setVisibility(8);
        this.kvI.setUserId(postData.aSp().getUserId());
        this.kvI.setUserName(postData.aSp().getUserName());
        this.kvI.setIsBigV(postData.aSp().isBigV());
        this.kvJ.setText(postData.aSp().getName_show());
        this.kvJ.setTag(postData.aSp().getUserId());
        this.kvI.startLoad(postData.aSp().getAvater(), 28, false);
        this.kvO.a(postData.aSp());
    }

    public void as(float f) {
        this.kvK.setAlpha(f);
    }

    public View cOQ() {
        return this.kvK;
    }

    public void onChangeSkin(int i) {
        if (this.kvN != null) {
            this.kvN.onChangeSkinType(i);
        }
        an.setViewTextColor(this.kvL, (int) R.color.cp_cont_a);
        if (this.kvJ != null) {
            an.setViewTextColor(this.kvJ, (int) R.color.cp_cont_a);
        }
        if (this.kvM != null) {
            an.setBackgroundResource(this.kvM, R.drawable.icon_weiba);
        }
    }

    public void T(View.OnClickListener onClickListener) {
        this.kvP = onClickListener;
    }

    public void onDestroy() {
    }
}
