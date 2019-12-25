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
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes6.dex */
public class f {
    private TbPageContext cQU;
    private View.OnClickListener dXO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.iSg || view == f.this.iSh || view == f.this.iSk) {
                f.this.cB(view);
            }
        }
    };
    private View hTy;
    private HeadImageView iSg;
    private TextView iSh;
    private RelativeLayout iSi;
    private TextView iSj;
    private ImageView iSk;
    private PbVideoFullUserInfoLikeButton iSl;
    private e iSm;
    private View.OnClickListener iSn;
    private LinearLayout iSo;

    public f(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.cQU = tbPageContext;
        this.hTy = t(tbPageContext);
        initView();
        frameLayout.addView(this.hTy);
    }

    private View t(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.iSi = (RelativeLayout) this.hTy.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.iSg = (HeadImageView) this.hTy.findViewById(R.id.pbVideoFullPhoto);
        this.iSg.setOnClickListener(this.dXO);
        this.iSo = (LinearLayout) this.hTy.findViewById(R.id.pbVideoFullNameLayout);
        am.setBackgroundResource(this.iSo, R.drawable.video_author_bg);
        this.iSh = (TextView) this.hTy.findViewById(R.id.pbVideoFullUserName);
        this.iSh.setOnClickListener(this.dXO);
        this.iSj = (TextView) this.hTy.findViewById(R.id.pbVideoFullAttention);
        this.iSj.setOnClickListener(this.dXO);
        this.iSk = (ImageView) this.hTy.findViewById(R.id.pbVideoFullChannelIcon);
        this.iSl = (PbVideoFullUserInfoLikeButton) this.hTy.findViewById(R.id.pbVideoFullLikeButton);
        this.iSl.setTextSize(0, l.getDimens(this.cQU.getPageActivity(), R.dimen.tbds30));
        this.iSm = new e(this.cQU, this.iSl);
        this.iSg.setRadius(l.getDimens(this.cQU.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(View view) {
        if (this.iSn != null) {
            this.iSn.onClick(view);
        }
    }

    public void a(PostData postData, bj bjVar, com.baidu.tieba.pb.data.l lVar) {
        this.iSl.setVisibility(0);
        this.iSj.setVisibility(8);
        t(postData);
        if (aE(bjVar)) {
            this.iSj.setVisibility(8);
            this.iSl.setVisibility(8);
        }
    }

    private boolean aE(bj bjVar) {
        if (bjVar == null || bjVar.azE() == null || bjVar.azE().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bjVar.azE().getUserId());
    }

    private void t(PostData postData) {
        this.iSk.setVisibility(8);
        this.iSg.setUserId(postData.azE().getUserId());
        this.iSg.setUserName(postData.azE().getUserName());
        this.iSg.setIsBigV(postData.azE().isBigV());
        this.iSh.setText(postData.azE().getName_show());
        this.iSh.setTag(postData.azE().getUserId());
        this.iSg.startLoad(postData.azE().getAvater(), 28, false);
        this.iSm.a(postData.azE());
    }

    public void aG(float f) {
        this.iSi.setAlpha(f);
    }

    public View cpJ() {
        return this.iSi;
    }

    public void onChangeSkin(int i) {
        if (this.iSl != null) {
            this.iSl.onChangeSkinType(i);
        }
        am.setViewTextColor(this.iSj, (int) R.color.cp_cont_a);
        if (this.iSh != null) {
            am.setViewTextColor(this.iSh, (int) R.color.cp_cont_a);
        }
        if (this.iSk != null) {
            am.setBackgroundResource(this.iSk, R.drawable.icon_weiba);
        }
    }

    public void S(View.OnClickListener onClickListener) {
        this.iSn = onClickListener;
    }

    public void onDestroy() {
    }
}
