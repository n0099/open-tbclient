package com.baidu.tieba.pb.videopb.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.e;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.d;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbContent;
/* loaded from: classes21.dex */
public class b extends af.a {
    public TBLottieAnimationView ajy;
    public TextView euO;
    public TextView fFe;
    private final int jpG;
    public VoteView lGY;
    public TextView lPA;
    public TextView lPB;
    public PbFirstFloorUserLikeButton lPC;
    public RelativeLayout lPD;
    public TbRichTextView lPE;
    private final TextView lPF;
    public ImageView lPG;
    public RelativeLayout lPH;
    public View lPI;
    public final View lPJ;
    public TextView lPK;
    public TextView lPL;
    public View lPM;
    public TbRichTextView lPN;
    public TextView lPO;
    public TextView lPP;
    public TextView lPQ;
    public TextView lPR;
    public TextView lPS;
    private int lPT;
    private int lPU;
    private boolean lPV;
    private final int lPt;
    public ImageView lPu;
    public HeadPendantClickableView lPv;
    public UserIconBox lPw;
    public TextView lPx;
    public ImageView lPy;
    public UserIconBox lPz;
    public LinearLayout lte;
    public View mRoot;
    private int mSkinType;

    public b(Context context, View view) {
        super(view);
        this.lPt = 2;
        this.jpG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mSkinType = 3;
        this.mRoot = view;
        this.lPu = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.lPv = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.lPv.setHasPendantStyle();
        this.lPv.getHeadView().setIsRound(true);
        this.lPv.getHeadView().setDrawBorder(true);
        this.lPv.getHeadView().setBorderWidth(l.getDimens(context, R.dimen.L_X01));
        this.lPv.getHeadView().setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.lPv.getHeadView().setPlaceHolder(1);
        this.lPv.setBigVDimenSize(R.dimen.tbds27);
        this.ajy = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        this.lPw = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.euO = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.lPx = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.lPy = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.lPz = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.lPA = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.lPB = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.lPC = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.lPD = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.lPE = (TbRichTextView) view.findViewById(R.id.title_video_info_item);
        this.lPF = (TextView) view.findViewById(R.id.title_measure_text);
        this.lPM = view.findViewById(R.id.video_info_item_layout);
        this.lPI = view.findViewById(R.id.video_title_area_video_info_item);
        this.lPJ = view.findViewById(R.id.video_info_item_collapsible_layout);
        this.lPE.setLayoutStrategy(new d(this.lPE.getLayoutStrategy()));
        this.lPE.setTextSize(TbConfig.getContentSize());
        this.lPE.setTextBold();
        this.lPF.setTextSize(0, TbConfig.getContentSize());
        this.lPF.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.lPG = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.lPH = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.lPT = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.lPD.getPaddingLeft()) - this.lPD.getPaddingRight();
        He(0);
        this.fFe = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.lPK = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.lPL = (TextView) view.findViewById(R.id.publish_location_video_info_item);
        this.lPO = (TextView) view.findViewById(R.id.publish_distance_video_info_item);
        this.lPP = (TextView) view.findViewById(R.id.play_count_video_info_item_collapsible);
        this.lPQ = (TextView) view.findViewById(R.id.publish_time_video_info_item_collapsible);
        this.lPR = (TextView) view.findViewById(R.id.publish_location_video_info_item_collapsible);
        this.lPS = (TextView) view.findViewById(R.id.publish_distance_video_info_item_collapsible);
        this.lGY = (VoteView) view.findViewById(R.id.pb_video_vote_view);
        this.lPN = (TbRichTextView) view.findViewById(R.id.video_abstract_item);
        this.lte = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        d dVar = new d(this.lPN.getLayoutStrategy());
        dVar.setTextSize(l.getDimens(context, R.dimen.T_X06));
        dVar.ao(0.9f);
        this.lPN.setLayoutStrategy(dVar);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0205);
        this.lPA.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.lPB.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.lPC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lPE.setTextColor(ap.getColor(R.color.CAM_X0105));
        He(this.lPU);
        this.fFe.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.lPK.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.lPL.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.lPO.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.lPP.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.lPQ.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.lPR.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.lPS.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.lGY.onChangeSkinType(skinType);
        this.lPN.setTextColor(ap.getColor(R.color.CAM_X0107));
        if (this.mSkinType != skinType) {
            En(skinType);
        }
        this.mSkinType = skinType;
    }

    public void vG(boolean z) {
        if (z) {
            ap.setViewTextColor(this.euO, R.color.CAM_X0301, 1);
        } else {
            ap.setViewTextColor(this.euO, R.color.CAM_X0105, 1);
        }
    }

    public void Hd(int i) {
        if (i > 0) {
            ap.setImageResource(this.lPy, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void k(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.lPu.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lPu.setVisibility(0);
        } else if (z2 && z3) {
            this.lPu.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lPu.setVisibility(0);
        } else if (z2) {
            this.lPu.setImageResource(R.drawable.pic_pb_refined_n);
            this.lPu.setVisibility(0);
        } else if (z3) {
            this.lPu.setImageResource(R.drawable.pic_pb_stick_n);
            this.lPu.setVisibility(0);
        } else {
            this.lPu.setVisibility(8);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.lPv.setOnClickListener(onClickListener);
        this.lPH.setOnClickListener(onClickListener);
        this.lPI.setOnClickListener(onClickListener);
        this.lPw.setOnClickListener(onClickListener);
        this.euO.setOnClickListener(onClickListener);
        this.lPz.setOnClickListener(onClickListener);
    }

    public void a(Context context, List<PbContent> list, String str, boolean z) {
        int i;
        if (!y.isEmpty(list) || !StringUtils.isNull(str)) {
            String spannableStringBuilder = !y.isEmpty(list) ? e.bE(list).toString() : str;
            if (this.lPF.getPaint().measureText(spannableStringBuilder, 0, spannableStringBuilder.length()) + (this.lPF.getTextSize() * 2.0f) > this.lPT * 2 || z) {
                i = (this.lPU == 1 || this.lPU == 2) ? this.lPU : 1;
            } else {
                i = 0;
            }
            He(i);
            if (!y.isEmpty(list)) {
                this.lPE.setText(TbRichTextView.a(context, list, true));
            } else {
                this.lPE.setText(new TbRichText(context, com.baidu.tieba.im.chat.a.d(context, str, 1)));
            }
        }
    }

    public int drR() {
        return this.lPU;
    }

    public void He(int i) {
        this.lPU = i;
        if (i == 0) {
            drS();
        } else if (i == 1) {
            drT();
        } else if (i == 2) {
            drU();
        }
    }

    private void drS() {
        this.lPH.setVisibility(8);
        this.lPE.setTextEllipsize(null);
        this.lPE.setMaxLines(2);
    }

    private void drT() {
        this.lPH.setVisibility(0);
        SvgManager.bqB().a(this.lPG, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.lPE.setTextEllipsize(TextUtils.TruncateAt.END);
        this.lPE.setMaxLines(2);
        this.lPJ.setVisibility(8);
        this.lPN.setVisibility(8);
        this.fFe.setVisibility(0);
        this.lPK.setVisibility(0);
        this.lPL.setVisibility(0);
        this.lPO.setVisibility(0);
        this.lPM.setVisibility(0);
    }

    private void drU() {
        this.lPH.setVisibility(0);
        SvgManager.bqB().a(this.lPG, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.lPE.setTextEllipsize(null);
        this.lPE.setMaxLines(3);
        if (this.lPV) {
            this.lPN.setVisibility(0);
        }
        this.lPJ.setVisibility(0);
        this.fFe.setVisibility(8);
        this.lPK.setVisibility(8);
        this.lPL.setVisibility(8);
        this.lPO.setVisibility(8);
        this.lPM.setVisibility(8);
    }

    public void sN(boolean z) {
        if (z) {
            this.ajy.setVisibility(0);
            if (!this.ajy.isAnimating()) {
                this.ajy.setSpeed(0.8f);
                this.ajy.setRepeatCount(-1);
                this.ajy.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.e.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.ajy.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.ajy.setVisibility(8);
        if (this.ajy.isAnimating()) {
            this.ajy.cancelAnimation();
        }
    }

    private void En(int i) {
        if (i == 1) {
            this.ajy.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.ajy.setAnimation("live/card_live_bg_black.json");
        } else {
            this.ajy.setAnimation("live/card_live_bg.json");
        }
    }

    public void a(Context context, PostData postData) {
        if (postData == null || y.getCount(postData.mYH) < 2) {
            this.lPV = false;
            return;
        }
        List<PbContent> list = postData.mYH;
        this.lPN.setText(TbRichTextView.a(context, (List<PbContent>) y.subList(list, 1, list.size()), true));
        this.lPV = true;
    }
}
