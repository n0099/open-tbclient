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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.o;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class e {
    private View bVM;
    private TbPageContext eXu;
    private View.OnClickListener gmj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == e.this.mep || view == e.this.meq || view == e.this.met) {
                e.this.dS(view);
            }
        }
    };
    private HeadImageView mep;
    private TextView meq;
    private RelativeLayout mer;
    private TextView mes;
    private ImageView met;
    private PbVideoFullUserInfoLikeButton meu;
    private d mev;
    private View.OnClickListener mew;
    private LinearLayout mex;

    public e(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.eXu = tbPageContext;
        this.bVM = x(tbPageContext);
        initView();
        frameLayout.addView(this.bVM);
    }

    private View x(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.mer = (RelativeLayout) this.bVM.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.mep = (HeadImageView) this.bVM.findViewById(R.id.pbVideoFullPhoto);
        this.mep.setOnClickListener(this.gmj);
        this.mex = (LinearLayout) this.bVM.findViewById(R.id.pbVideoFullNameLayout);
        ao.setBackgroundResource(this.mex, R.drawable.video_author_bg);
        this.meq = (TextView) this.bVM.findViewById(R.id.pbVideoFullUserName);
        this.meq.setOnClickListener(this.gmj);
        this.mes = (TextView) this.bVM.findViewById(R.id.pbVideoFullAttention);
        this.mes.setOnClickListener(this.gmj);
        this.met = (ImageView) this.bVM.findViewById(R.id.pbVideoFullChannelIcon);
        this.meu = (PbVideoFullUserInfoLikeButton) this.bVM.findViewById(R.id.pbVideoFullLikeButton);
        this.meu.setTextSize(0, l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds30));
        this.mev = new d(this.eXu, this.meu);
        this.mep.setRadius(l.getDimens(this.eXu.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dS(View view) {
        if (this.mew != null) {
            this.mew.onClick(view);
        }
    }

    public void a(PostData postData, bz bzVar, o oVar) {
        this.meu.setVisibility(0);
        this.mes.setVisibility(8);
        w(postData);
        if (aN(bzVar)) {
            this.mes.setVisibility(8);
            this.meu.setVisibility(8);
        }
    }

    private boolean aN(bz bzVar) {
        if (bzVar == null || bzVar.brq() == null || bzVar.brq().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bzVar.brq().getUserId());
    }

    private void w(PostData postData) {
        this.met.setVisibility(8);
        this.mep.setUserId(postData.brq().getUserId());
        this.mep.setUserName(postData.brq().getUserName());
        this.mep.setIsBigV(postData.brq().isBigV());
        this.meq.setText(postData.brq().getName_show());
        this.meq.setTag(postData.brq().getUserId());
        this.mep.startLoad(postData.brq().getAvater(), 28, false);
        this.mev.a(postData.brq());
    }

    public void aR(float f) {
        this.mer.setAlpha(f);
    }

    public View dvc() {
        return this.mer;
    }

    public void onChangeSkin(int i) {
        if (this.meu != null) {
            this.meu.onChangeSkinType(i);
        }
        ao.setViewTextColor(this.mes, R.color.CAM_X0101);
        if (this.meq != null) {
            ao.setViewTextColor(this.meq, R.color.CAM_X0101);
        }
        if (this.met != null) {
            ao.setBackgroundResource(this.met, R.drawable.icon_weiba);
        }
    }

    public void X(View.OnClickListener onClickListener) {
        this.mew = onClickListener;
    }

    public void onDestroy() {
    }
}
