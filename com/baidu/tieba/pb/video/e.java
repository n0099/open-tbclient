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
            if (view == e.this.meo || view == e.this.mep || view == e.this.mes) {
                e.this.dS(view);
            }
        }
    };
    private HeadImageView meo;
    private TextView mep;
    private RelativeLayout meq;
    private TextView mer;
    private ImageView mes;
    private PbVideoFullUserInfoLikeButton met;
    private d meu;
    private View.OnClickListener mev;
    private LinearLayout mew;

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
        this.meq = (RelativeLayout) this.bVM.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.meo = (HeadImageView) this.bVM.findViewById(R.id.pbVideoFullPhoto);
        this.meo.setOnClickListener(this.gmj);
        this.mew = (LinearLayout) this.bVM.findViewById(R.id.pbVideoFullNameLayout);
        ao.setBackgroundResource(this.mew, R.drawable.video_author_bg);
        this.mep = (TextView) this.bVM.findViewById(R.id.pbVideoFullUserName);
        this.mep.setOnClickListener(this.gmj);
        this.mer = (TextView) this.bVM.findViewById(R.id.pbVideoFullAttention);
        this.mer.setOnClickListener(this.gmj);
        this.mes = (ImageView) this.bVM.findViewById(R.id.pbVideoFullChannelIcon);
        this.met = (PbVideoFullUserInfoLikeButton) this.bVM.findViewById(R.id.pbVideoFullLikeButton);
        this.met.setTextSize(0, l.getDimens(this.eXu.getPageActivity(), R.dimen.tbds30));
        this.meu = new d(this.eXu, this.met);
        this.meo.setRadius(l.getDimens(this.eXu.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dS(View view) {
        if (this.mev != null) {
            this.mev.onClick(view);
        }
    }

    public void a(PostData postData, bz bzVar, o oVar) {
        this.met.setVisibility(0);
        this.mer.setVisibility(8);
        w(postData);
        if (aN(bzVar)) {
            this.mer.setVisibility(8);
            this.met.setVisibility(8);
        }
    }

    private boolean aN(bz bzVar) {
        if (bzVar == null || bzVar.brr() == null || bzVar.brr().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bzVar.brr().getUserId());
    }

    private void w(PostData postData) {
        this.mes.setVisibility(8);
        this.meo.setUserId(postData.brr().getUserId());
        this.meo.setUserName(postData.brr().getUserName());
        this.meo.setIsBigV(postData.brr().isBigV());
        this.mep.setText(postData.brr().getName_show());
        this.mep.setTag(postData.brr().getUserId());
        this.meo.startLoad(postData.brr().getAvater(), 28, false);
        this.meu.a(postData.brr());
    }

    public void aR(float f) {
        this.meq.setAlpha(f);
    }

    public View dvd() {
        return this.meq;
    }

    public void onChangeSkin(int i) {
        if (this.met != null) {
            this.met.onChangeSkinType(i);
        }
        ao.setViewTextColor(this.mer, R.color.CAM_X0101);
        if (this.mep != null) {
            ao.setViewTextColor(this.mep, R.color.CAM_X0101);
        }
        if (this.mes != null) {
            ao.setBackgroundResource(this.mes, R.drawable.icon_weiba);
        }
    }

    public void X(View.OnClickListener onClickListener) {
        this.mev = onClickListener;
    }

    public void onDestroy() {
    }
}
