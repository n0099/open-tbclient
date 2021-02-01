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
    private View.OnClickListener gjP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == e.this.miN || view == e.this.miO || view == e.this.miR) {
                e.this.dQ(view);
            }
        }
    };
    private HeadImageView miN;
    private TextView miO;
    private RelativeLayout miP;
    private TextView miQ;
    private ImageView miR;
    private PbVideoFullUserInfoLikeButton miS;
    private d miT;
    private View.OnClickListener miU;
    private LinearLayout miV;

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
        this.miP = (RelativeLayout) this.bUP.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.miN = (HeadImageView) this.bUP.findViewById(R.id.pbVideoFullPhoto);
        this.miN.setOnClickListener(this.gjP);
        this.miV = (LinearLayout) this.bUP.findViewById(R.id.pbVideoFullNameLayout);
        ap.setBackgroundResource(this.miV, R.drawable.video_author_bg);
        this.miO = (TextView) this.bUP.findViewById(R.id.pbVideoFullUserName);
        this.miO.setOnClickListener(this.gjP);
        this.miQ = (TextView) this.bUP.findViewById(R.id.pbVideoFullAttention);
        this.miQ.setOnClickListener(this.gjP);
        this.miR = (ImageView) this.bUP.findViewById(R.id.pbVideoFullChannelIcon);
        this.miS = (PbVideoFullUserInfoLikeButton) this.bUP.findViewById(R.id.pbVideoFullLikeButton);
        this.miS.setTextSize(0, l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds30));
        this.miT = new d(this.eUY, this.miS);
        this.miN.setRadius(l.getDimens(this.eUY.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQ(View view) {
        if (this.miU != null) {
            this.miU.onClick(view);
        }
    }

    public void a(PostData postData, cb cbVar, p pVar) {
        this.miS.setVisibility(0);
        this.miQ.setVisibility(8);
        w(postData);
        if (aO(cbVar)) {
            this.miQ.setVisibility(8);
            this.miS.setVisibility(8);
        }
    }

    private boolean aO(cb cbVar) {
        if (cbVar == null || cbVar.bnQ() == null || cbVar.bnQ().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cbVar.bnQ().getUserId());
    }

    private void w(PostData postData) {
        this.miR.setVisibility(8);
        this.miN.setUserId(postData.bnQ().getUserId());
        this.miN.setUserName(postData.bnQ().getUserName());
        this.miN.setIsBigV(postData.bnQ().isBigV());
        this.miO.setText(postData.bnQ().getName_show());
        this.miO.setTag(postData.bnQ().getUserId());
        this.miN.startLoad(postData.bnQ().getAvater(), 28, false);
        this.miT.a(postData.bnQ());
    }

    public void aU(float f) {
        this.miP.setAlpha(f);
    }

    public View dtz() {
        return this.miP;
    }

    public void onChangeSkin(int i) {
        if (this.miS != null) {
            this.miS.onChangeSkinType(i);
        }
        ap.setViewTextColor(this.miQ, R.color.CAM_X0101);
        if (this.miO != null) {
            ap.setViewTextColor(this.miO, R.color.CAM_X0101);
        }
        if (this.miR != null) {
            ap.setBackgroundResource(this.miR, R.drawable.icon_weiba);
        }
    }

    public void X(View.OnClickListener onClickListener) {
        this.miU = onClickListener;
    }

    public void onDestroy() {
    }
}
