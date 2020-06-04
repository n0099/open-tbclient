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
    private View.OnClickListener eRh = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.kbV || view == f.this.kbW || view == f.this.kbZ) {
                f.this.cO(view);
            }
        }
    };
    private View jaz;
    private HeadImageView kbV;
    private TextView kbW;
    private RelativeLayout kbX;
    private TextView kbY;
    private ImageView kbZ;
    private PbVideoFullUserInfoLikeButton kca;
    private e kcb;
    private View.OnClickListener kcc;
    private LinearLayout kcd;

    public f(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.dIF = tbPageContext;
        this.jaz = w(tbPageContext);
        initView();
        frameLayout.addView(this.jaz);
    }

    private View w(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.kbX = (RelativeLayout) this.jaz.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.kbV = (HeadImageView) this.jaz.findViewById(R.id.pbVideoFullPhoto);
        this.kbV.setOnClickListener(this.eRh);
        this.kcd = (LinearLayout) this.jaz.findViewById(R.id.pbVideoFullNameLayout);
        am.setBackgroundResource(this.kcd, R.drawable.video_author_bg);
        this.kbW = (TextView) this.jaz.findViewById(R.id.pbVideoFullUserName);
        this.kbW.setOnClickListener(this.eRh);
        this.kbY = (TextView) this.jaz.findViewById(R.id.pbVideoFullAttention);
        this.kbY.setOnClickListener(this.eRh);
        this.kbZ = (ImageView) this.jaz.findViewById(R.id.pbVideoFullChannelIcon);
        this.kca = (PbVideoFullUserInfoLikeButton) this.jaz.findViewById(R.id.pbVideoFullLikeButton);
        this.kca.setTextSize(0, l.getDimens(this.dIF.getPageActivity(), R.dimen.tbds30));
        this.kcb = new e(this.dIF, this.kca);
        this.kbV.setRadius(l.getDimens(this.dIF.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cO(View view) {
        if (this.kcc != null) {
            this.kcc.onClick(view);
        }
    }

    public void a(PostData postData, bk bkVar, m mVar) {
        this.kca.setVisibility(0);
        this.kbY.setVisibility(8);
        v(postData);
        if (aK(bkVar)) {
            this.kbY.setVisibility(8);
            this.kca.setVisibility(8);
        }
    }

    private boolean aK(bk bkVar) {
        if (bkVar == null || bkVar.aQx() == null || bkVar.aQx().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bkVar.aQx().getUserId());
    }

    private void v(PostData postData) {
        this.kbZ.setVisibility(8);
        this.kbV.setUserId(postData.aQx().getUserId());
        this.kbV.setUserName(postData.aQx().getUserName());
        this.kbV.setIsBigV(postData.aQx().isBigV());
        this.kbW.setText(postData.aQx().getName_show());
        this.kbW.setTag(postData.aQx().getUserId());
        this.kbV.startLoad(postData.aQx().getAvater(), 28, false);
        this.kcb.a(postData.aQx());
    }

    public void an(float f) {
        this.kbX.setAlpha(f);
    }

    public View cKy() {
        return this.kbX;
    }

    public void onChangeSkin(int i) {
        if (this.kca != null) {
            this.kca.onChangeSkinType(i);
        }
        am.setViewTextColor(this.kbY, (int) R.color.cp_cont_a);
        if (this.kbW != null) {
            am.setViewTextColor(this.kbW, (int) R.color.cp_cont_a);
        }
        if (this.kbZ != null) {
            am.setBackgroundResource(this.kbZ, R.drawable.icon_weiba);
        }
    }

    public void S(View.OnClickListener onClickListener) {
        this.kcc = onClickListener;
    }

    public void onDestroy() {
    }
}
