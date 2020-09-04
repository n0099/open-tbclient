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
/* loaded from: classes16.dex */
public class f {
    private TbPageContext efr;
    private View.OnClickListener frt = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.kUr || view == f.this.kUs || view == f.this.kUv) {
                f.this.cZ(view);
            }
        }
    };
    private View jPO;
    private HeadImageView kUr;
    private TextView kUs;
    private RelativeLayout kUt;
    private TextView kUu;
    private ImageView kUv;
    private PbVideoFullUserInfoLikeButton kUw;
    private e kUx;
    private View.OnClickListener kUy;
    private LinearLayout kUz;

    public f(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.efr = tbPageContext;
        this.jPO = y(tbPageContext);
        initView();
        frameLayout.addView(this.jPO);
    }

    private View y(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.kUt = (RelativeLayout) this.jPO.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.kUr = (HeadImageView) this.jPO.findViewById(R.id.pbVideoFullPhoto);
        this.kUr.setOnClickListener(this.frt);
        this.kUz = (LinearLayout) this.jPO.findViewById(R.id.pbVideoFullNameLayout);
        ap.setBackgroundResource(this.kUz, R.drawable.video_author_bg);
        this.kUs = (TextView) this.jPO.findViewById(R.id.pbVideoFullUserName);
        this.kUs.setOnClickListener(this.frt);
        this.kUu = (TextView) this.jPO.findViewById(R.id.pbVideoFullAttention);
        this.kUu.setOnClickListener(this.frt);
        this.kUv = (ImageView) this.jPO.findViewById(R.id.pbVideoFullChannelIcon);
        this.kUw = (PbVideoFullUserInfoLikeButton) this.jPO.findViewById(R.id.pbVideoFullLikeButton);
        this.kUw.setTextSize(0, l.getDimens(this.efr.getPageActivity(), R.dimen.tbds30));
        this.kUx = new e(this.efr, this.kUw);
        this.kUr.setRadius(l.getDimens(this.efr.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZ(View view) {
        if (this.kUy != null) {
            this.kUy.onClick(view);
        }
    }

    public void a(PostData postData, bw bwVar, o oVar) {
        this.kUw.setVisibility(0);
        this.kUu.setVisibility(8);
        v(postData);
        if (aJ(bwVar)) {
            this.kUu.setVisibility(8);
            this.kUw.setVisibility(8);
        }
    }

    private boolean aJ(bw bwVar) {
        if (bwVar == null || bwVar.beE() == null || bwVar.beE().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bwVar.beE().getUserId());
    }

    private void v(PostData postData) {
        this.kUv.setVisibility(8);
        this.kUr.setUserId(postData.beE().getUserId());
        this.kUr.setUserName(postData.beE().getUserName());
        this.kUr.setIsBigV(postData.beE().isBigV());
        this.kUs.setText(postData.beE().getName_show());
        this.kUs.setTag(postData.beE().getUserId());
        this.kUr.startLoad(postData.beE().getAvater(), 28, false);
        this.kUx.a(postData.beE());
    }

    public void ax(float f) {
        this.kUt.setAlpha(f);
    }

    public View ddw() {
        return this.kUt;
    }

    public void onChangeSkin(int i) {
        if (this.kUw != null) {
            this.kUw.onChangeSkinType(i);
        }
        ap.setViewTextColor(this.kUu, R.color.cp_cont_a);
        if (this.kUs != null) {
            ap.setViewTextColor(this.kUs, R.color.cp_cont_a);
        }
        if (this.kUv != null) {
            ap.setBackgroundResource(this.kUv, R.drawable.icon_weiba);
        }
    }

    public void V(View.OnClickListener onClickListener) {
        this.kUy = onClickListener;
    }

    public void onDestroy() {
    }
}
