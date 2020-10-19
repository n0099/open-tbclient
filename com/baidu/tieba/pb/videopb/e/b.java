package com.baidu.tieba.pb.videopb.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.data.Config;
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
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.d;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.List;
import tbclient.PbContent;
/* loaded from: classes22.dex */
public class b extends af.a {
    public TBLottieAnimationView ajs;
    public TextView eig;
    public TextView fro;
    private final int iWE;
    public LinearLayout lao;
    private final int lwJ;
    public ImageView lwK;
    public HeadPendantClickableView lwL;
    public UserIconBox lwM;
    public TextView lwN;
    public ImageView lwO;
    public UserIconBox lwP;
    public TextView lwQ;
    public TextView lwR;
    public PbFirstFloorUserLikeButton lwS;
    public RelativeLayout lwT;
    public TbRichTextView lwU;
    private final TextView lwV;
    public ImageView lwW;
    public RelativeLayout lwX;
    public View lwY;
    public final View lwZ;
    public TextView lxa;
    public TextView lxb;
    public View lxc;
    public VoteView lxd;
    public TbRichTextView lxe;
    public TextView lxf;
    public TextView lxg;
    public TextView lxh;
    public TextView lxi;
    public TextView lxj;
    private int lxk;
    private int lxl;
    private boolean lxm;
    public View mRoot;
    private int mSkinType;

    public b(Context context, View view) {
        super(view);
        this.lwJ = 2;
        this.iWE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mSkinType = 3;
        this.mRoot = view;
        this.lwK = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.lwL = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.lwL.setHasPendantStyle();
        this.lwL.getHeadView().setIsRound(true);
        this.lwL.getHeadView().setDrawBorder(false);
        this.lwL.getHeadView().setPlaceHolder(1);
        this.ajs = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        this.lwM = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.eig = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.lwN = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.lwO = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.lwP = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.lwQ = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.lwR = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.lwS = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.lwT = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.lwU = (TbRichTextView) view.findViewById(R.id.title_video_info_item);
        this.lwV = (TextView) view.findViewById(R.id.title_measure_text);
        this.lxc = view.findViewById(R.id.video_info_item_layout);
        this.lwY = view.findViewById(R.id.video_title_area_video_info_item);
        this.lwZ = view.findViewById(R.id.video_info_item_collapsible_layout);
        this.lwU.setLayoutStrategy(new d(this.lwU.getLayoutStrategy()));
        this.lwU.setTextSize(TbConfig.getContentSize());
        this.lwV.setTextSize(0, TbConfig.getContentSize());
        this.lwV.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.lwW = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.lwX = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.lxk = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.lwT.getPaddingLeft()) - this.lwT.getPaddingRight();
        Ga(0);
        this.fro = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.lxa = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.lxb = (TextView) view.findViewById(R.id.publish_location_video_info_item);
        this.lxf = (TextView) view.findViewById(R.id.publish_distance_video_info_item);
        this.lxg = (TextView) view.findViewById(R.id.play_count_video_info_item_collapsible);
        this.lxh = (TextView) view.findViewById(R.id.publish_time_video_info_item_collapsible);
        this.lxi = (TextView) view.findViewById(R.id.publish_location_video_info_item_collapsible);
        this.lxj = (TextView) view.findViewById(R.id.publish_distance_video_info_item_collapsible);
        this.lxd = (VoteView) view.findViewById(R.id.pb_video_vote_view);
        this.lxe = (TbRichTextView) view.findViewById(R.id.video_abstract_item);
        this.lao = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        d dVar = new d(this.lxe.getLayoutStrategy());
        dVar.setTextSize(l.getDimens(context, R.dimen.tbds40));
        this.lxe.setLayoutStrategy(dVar);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setBackgroundColor(this.mRoot, R.color.cp_bg_line_e);
        this.lwQ.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lwR.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lwS.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.lwU.setTextColor(ap.getColor(R.color.cp_cont_b));
        Ga(this.lxl);
        this.fro.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lxa.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lxb.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lxf.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lxg.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lxh.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lxi.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lxj.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.lxd.onChangeSkinType(skinType);
        this.lxe.setTextColor(ap.getColor(R.color.cp_cont_j));
        if (this.mSkinType != skinType) {
            Dj(skinType);
        }
        this.mSkinType = skinType;
    }

    public void vd(boolean z) {
        if (z) {
            ap.setViewTextColor(this.eig, R.color.cp_cont_h, 1);
        } else {
            ap.setViewTextColor(this.eig, R.color.cp_cont_b, 1);
        }
    }

    public void FZ(int i) {
        if (i > 0) {
            ap.setImageResource(this.lwO, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void k(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.lwK.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lwK.setVisibility(0);
        } else if (z2 && z3) {
            this.lwK.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lwK.setVisibility(0);
        } else if (z2) {
            this.lwK.setImageResource(R.drawable.pic_pb_refined_n);
            this.lwK.setVisibility(0);
        } else if (z3) {
            this.lwK.setImageResource(R.drawable.pic_pb_stick_n);
            this.lwK.setVisibility(0);
        } else {
            this.lwK.setVisibility(8);
        }
    }

    public void Pv(String str) {
        StateListDrawable stateListDrawable;
        StateListDrawable stateListDrawable2 = null;
        if (Config.BAWU_TYPE_MANAGER.equals(str) || Config.BAWU_TYPE_ASSIST.equals(str)) {
            if (Config.BAWU_TYPE_MANAGER.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.e.a.b.bnw().oO(0).X(this.iWE).b("TL_BR", R.color.ba_zhu_start, R.color.ba_zhu_end).bny();
                stateListDrawable2 = com.baidu.tbadk.core.util.e.a.b.bnw().oO(0).X(this.iWE).BF("#4D000000").bny();
            } else if (Config.BAWU_TYPE_ASSIST.equals(str)) {
                stateListDrawable = com.baidu.tbadk.core.util.e.a.b.bnw().oO(0).X(this.iWE).b("TL_BR", R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).bny();
                stateListDrawable2 = com.baidu.tbadk.core.util.e.a.b.bnw().oO(0).X(this.iWE).BF("#4D000000").bny();
            } else {
                stateListDrawable = null;
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{stateListDrawable, stateListDrawable2});
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                if (layerDrawable.getDrawable(1) != null) {
                    layerDrawable.getDrawable(1).setAlpha(255);
                }
            } else if (layerDrawable.getDrawable(1) != null) {
                layerDrawable.getDrawable(1).setAlpha(0);
            }
            this.lwN.setBackgroundDrawable(layerDrawable);
            ap.setViewTextColor(this.lwN, R.color.cp_cont_a);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.lwL.setOnClickListener(onClickListener);
        this.lwX.setOnClickListener(onClickListener);
        this.lwY.setOnClickListener(onClickListener);
        this.lwM.setOnClickListener(onClickListener);
        this.eig.setOnClickListener(onClickListener);
        this.lwP.setOnClickListener(onClickListener);
    }

    public void a(Context context, List<PbContent> list, String str, boolean z) {
        int i;
        if (!y.isEmpty(list) || !StringUtils.isNull(str)) {
            String spannableStringBuilder = !y.isEmpty(list) ? e.bo(list).toString() : str;
            if (this.lwV.getPaint().measureText(spannableStringBuilder, 0, spannableStringBuilder.length()) + (this.lwV.getTextSize() * 2.0f) > this.lxk * 2 || z) {
                i = (this.lxl == 1 || this.lxl == 2) ? this.lxl : 1;
            } else {
                i = 0;
            }
            Ga(i);
            if (!y.isEmpty(list)) {
                this.lwU.setText(TbRichTextView.a(context, list, true));
            } else {
                this.lwU.setText(new TbRichText(context, com.baidu.tieba.im.chat.a.d(context, str, 1)));
            }
        }
    }

    public int dmH() {
        return this.lxl;
    }

    public void Ga(int i) {
        this.lxl = i;
        if (i == 0) {
            dmI();
        } else if (i == 1) {
            dmJ();
        } else if (i == 2) {
            dmK();
        }
    }

    private void dmI() {
        this.lwX.setVisibility(8);
        this.lwU.setTextEllipsize(null);
        this.lwU.setMaxLines(2);
    }

    private void dmJ() {
        this.lwX.setVisibility(0);
        SvgManager.bmU().a(this.lwW, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.lwU.setTextEllipsize(TextUtils.TruncateAt.END);
        this.lwU.setMaxLines(2);
        this.lwZ.setVisibility(8);
        this.lxe.setVisibility(8);
        this.fro.setVisibility(0);
        this.lxa.setVisibility(0);
        this.lxb.setVisibility(0);
        this.lxf.setVisibility(0);
    }

    private void dmK() {
        this.lwX.setVisibility(0);
        SvgManager.bmU().a(this.lwW, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.lwU.setTextEllipsize(null);
        this.lwU.setMaxLines(3);
        if (this.lxm) {
            this.lxe.setVisibility(0);
        }
        this.lwZ.setVisibility(0);
        this.fro.setVisibility(8);
        this.lxa.setVisibility(8);
        this.lxb.setVisibility(8);
        this.lxf.setVisibility(8);
    }

    public void sj(boolean z) {
        if (z) {
            this.ajs.setVisibility(0);
            if (!this.ajs.isAnimating()) {
                this.ajs.setSpeed(0.8f);
                this.ajs.setRepeatCount(-1);
                this.ajs.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.e.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.ajs.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.ajs.setVisibility(8);
        if (this.ajs.isAnimating()) {
            this.ajs.cancelAnimation();
        }
    }

    private void Dj(int i) {
        if (i == 1) {
            this.ajs.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.ajs.setAnimation("live/card_live_bg_black.json");
        } else {
            this.ajs.setAnimation("live/card_live_bg.json");
        }
    }

    public void a(Context context, f fVar) {
        if (fVar == null || !fVar.isValid()) {
            this.lxm = false;
            return;
        }
        PostData postData = fVar.dcC().get(0);
        if (postData == null || y.getCount(postData.mFg) < 2) {
            this.lxm = false;
            return;
        }
        List<PbContent> list = postData.mFg;
        this.lxe.setText(TbRichTextView.a(context, (List<PbContent>) y.subList(list, 1, list.size()), true));
        this.lxm = true;
    }
}
