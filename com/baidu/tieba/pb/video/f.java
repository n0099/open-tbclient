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
    private TbPageContext eCn;
    private View.OnClickListener fPj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.lEL || view == f.this.lEM || view == f.this.lEP) {
                f.this.dp(view);
            }
        }
    };
    private View kAe;
    private HeadImageView lEL;
    private TextView lEM;
    private RelativeLayout lEN;
    private TextView lEO;
    private ImageView lEP;
    private PbVideoFullUserInfoLikeButton lEQ;
    private e lER;
    private View.OnClickListener lES;
    private LinearLayout lET;

    public f(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.eCn = tbPageContext;
        this.kAe = y(tbPageContext);
        initView();
        frameLayout.addView(this.kAe);
    }

    private View y(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.lEN = (RelativeLayout) this.kAe.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.lEL = (HeadImageView) this.kAe.findViewById(R.id.pbVideoFullPhoto);
        this.lEL.setOnClickListener(this.fPj);
        this.lET = (LinearLayout) this.kAe.findViewById(R.id.pbVideoFullNameLayout);
        ap.setBackgroundResource(this.lET, R.drawable.video_author_bg);
        this.lEM = (TextView) this.kAe.findViewById(R.id.pbVideoFullUserName);
        this.lEM.setOnClickListener(this.fPj);
        this.lEO = (TextView) this.kAe.findViewById(R.id.pbVideoFullAttention);
        this.lEO.setOnClickListener(this.fPj);
        this.lEP = (ImageView) this.kAe.findViewById(R.id.pbVideoFullChannelIcon);
        this.lEQ = (PbVideoFullUserInfoLikeButton) this.kAe.findViewById(R.id.pbVideoFullLikeButton);
        this.lEQ.setTextSize(0, l.getDimens(this.eCn.getPageActivity(), R.dimen.tbds30));
        this.lER = new e(this.eCn, this.lEQ);
        this.lEL.setRadius(l.getDimens(this.eCn.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dp(View view) {
        if (this.lES != null) {
            this.lES.onClick(view);
        }
    }

    public void a(PostData postData, bw bwVar, o oVar) {
        this.lEQ.setVisibility(0);
        this.lEO.setVisibility(8);
        v(postData);
        if (aK(bwVar)) {
            this.lEO.setVisibility(8);
            this.lEQ.setVisibility(8);
        }
    }

    private boolean aK(bw bwVar) {
        if (bwVar == null || bwVar.bka() == null || bwVar.bka().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bwVar.bka().getUserId());
    }

    private void v(PostData postData) {
        this.lEP.setVisibility(8);
        this.lEL.setUserId(postData.bka().getUserId());
        this.lEL.setUserName(postData.bka().getUserName());
        this.lEL.setIsBigV(postData.bka().isBigV());
        this.lEM.setText(postData.bka().getName_show());
        this.lEM.setTag(postData.bka().getUserId());
        this.lEL.startLoad(postData.bka().getAvater(), 28, false);
        this.lER.a(postData.bka());
    }

    public void aF(float f) {
        this.lEN.setAlpha(f);
    }

    public View dnR() {
        return this.lEN;
    }

    public void onChangeSkin(int i) {
        if (this.lEQ != null) {
            this.lEQ.onChangeSkinType(i);
        }
        ap.setViewTextColor(this.lEO, R.color.cp_cont_a);
        if (this.lEM != null) {
            ap.setViewTextColor(this.lEM, R.color.cp_cont_a);
        }
        if (this.lEP != null) {
            ap.setBackgroundResource(this.lEP, R.drawable.icon_weiba);
        }
    }

    public void V(View.OnClickListener onClickListener) {
        this.lES = onClickListener;
    }

    public void onDestroy() {
    }
}
