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
    private TbPageContext efn;
    private View.OnClickListener fro = new View.OnClickListener() { // from class: com.baidu.tieba.pb.video.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == f.this.kUk || view == f.this.kUl || view == f.this.kUo) {
                f.this.cZ(view);
            }
        }
    };
    private View jPI;
    private HeadImageView kUk;
    private TextView kUl;
    private RelativeLayout kUm;
    private TextView kUn;
    private ImageView kUo;
    private PbVideoFullUserInfoLikeButton kUp;
    private e kUq;
    private View.OnClickListener kUr;
    private LinearLayout kUs;

    public f(TbPageContext tbPageContext, FrameLayout frameLayout) {
        this.efn = tbPageContext;
        this.jPI = y(tbPageContext);
        initView();
        frameLayout.addView(this.jPI);
    }

    private View y(TbPageContext<?> tbPageContext) {
        if (tbPageContext == null) {
            return null;
        }
        return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.video_pb_full_user_info_layout, (ViewGroup) null);
    }

    private void initView() {
        this.kUm = (RelativeLayout) this.jPI.findViewById(R.id.pbVideoFullUserInfoPanel);
        this.kUk = (HeadImageView) this.jPI.findViewById(R.id.pbVideoFullPhoto);
        this.kUk.setOnClickListener(this.fro);
        this.kUs = (LinearLayout) this.jPI.findViewById(R.id.pbVideoFullNameLayout);
        ap.setBackgroundResource(this.kUs, R.drawable.video_author_bg);
        this.kUl = (TextView) this.jPI.findViewById(R.id.pbVideoFullUserName);
        this.kUl.setOnClickListener(this.fro);
        this.kUn = (TextView) this.jPI.findViewById(R.id.pbVideoFullAttention);
        this.kUn.setOnClickListener(this.fro);
        this.kUo = (ImageView) this.jPI.findViewById(R.id.pbVideoFullChannelIcon);
        this.kUp = (PbVideoFullUserInfoLikeButton) this.jPI.findViewById(R.id.pbVideoFullLikeButton);
        this.kUp.setTextSize(0, l.getDimens(this.efn.getPageActivity(), R.dimen.tbds30));
        this.kUq = new e(this.efn, this.kUp);
        this.kUk.setRadius(l.getDimens(this.efn.getPageActivity(), R.dimen.ds40));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZ(View view) {
        if (this.kUr != null) {
            this.kUr.onClick(view);
        }
    }

    public void a(PostData postData, bw bwVar, o oVar) {
        this.kUp.setVisibility(0);
        this.kUn.setVisibility(8);
        v(postData);
        if (aJ(bwVar)) {
            this.kUn.setVisibility(8);
            this.kUp.setVisibility(8);
        }
    }

    private boolean aJ(bw bwVar) {
        if (bwVar == null || bwVar.beE() == null || bwVar.beE().getUserId() == null) {
            return false;
        }
        return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), bwVar.beE().getUserId());
    }

    private void v(PostData postData) {
        this.kUo.setVisibility(8);
        this.kUk.setUserId(postData.beE().getUserId());
        this.kUk.setUserName(postData.beE().getUserName());
        this.kUk.setIsBigV(postData.beE().isBigV());
        this.kUl.setText(postData.beE().getName_show());
        this.kUl.setTag(postData.beE().getUserId());
        this.kUk.startLoad(postData.beE().getAvater(), 28, false);
        this.kUq.a(postData.beE());
    }

    public void ax(float f) {
        this.kUm.setAlpha(f);
    }

    public View ddv() {
        return this.kUm;
    }

    public void onChangeSkin(int i) {
        if (this.kUp != null) {
            this.kUp.onChangeSkinType(i);
        }
        ap.setViewTextColor(this.kUn, R.color.cp_cont_a);
        if (this.kUl != null) {
            ap.setViewTextColor(this.kUl, R.color.cp_cont_a);
        }
        if (this.kUo != null) {
            ap.setBackgroundResource(this.kUo, R.drawable.icon_weiba);
        }
    }

    public void V(View.OnClickListener onClickListener) {
        this.kUr = onClickListener;
    }

    public void onDestroy() {
    }
}
