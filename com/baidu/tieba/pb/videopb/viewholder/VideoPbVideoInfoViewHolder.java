package com.baidu.tieba.pb.videopb.viewholder;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.e;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.a;
import com.baidu.tieba.pb.pb.main.a.d;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
/* loaded from: classes2.dex */
public class VideoPbVideoInfoViewHolder extends TypeAdapter.ViewHolder {
    public TBLottieAnimationView ajX;
    public TextView eIO;
    public TextView fUc;
    private final int izi;
    public TextView juZ;
    public ImageView jva;
    public TextView jvb;
    private final int jvh;
    private final int jwU;
    private FrameLayout lPQ;
    private d lPS;
    public LinearLayout lQw;
    public View mRoot;
    private int mSkinType;
    public VoteView meH;
    public TextView mnA;
    public TextView mnB;
    public TextView mnC;
    public TextView mnD;
    public TextView mnE;
    private int mnF;
    private int mnG;
    private boolean mnH;
    private VideoPbFragment mnI;
    private final int mni;
    public ImageView mnj;
    public HeadPendantClickableView mnk;
    public UserIconBox mnl;
    public UserIconBox mnm;
    public TextView mnn;
    public PbFirstFloorUserLikeButton mno;
    public RelativeLayout mnp;
    public TbRichTextView mnq;
    private final TextView mnr;
    public ImageView mns;
    public RelativeLayout mnt;
    public View mnu;
    public final View mnv;
    public TextView mnw;
    public TextView mnx;
    public View mny;
    public TbRichTextView mnz;

    public VideoPbVideoInfoViewHolder(Context context, View view, VideoPbFragment videoPbFragment) {
        super(view);
        this.mni = 2;
        this.izi = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.jvh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.jwU = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
        this.mSkinType = 3;
        this.mRoot = view;
        this.mnI = videoPbFragment;
        this.mnj = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.mnk = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.mnk.setHasPendantStyle();
        this.mnk.getHeadView().setIsRound(true);
        this.mnk.getHeadView().setDrawBorder(true);
        this.mnk.getHeadView().setBorderWidth(l.getDimens(context, R.dimen.L_X01));
        this.mnk.getHeadView().setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.mnk.getHeadView().setPlaceHolder(1);
        this.mnk.setBigVDimenSize(R.dimen.tbds27);
        this.ajX = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        this.mnl = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.eIO = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.juZ = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.jva = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.mnm = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.jvb = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.mnn = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.mno = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.mnp = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.mnq = (TbRichTextView) view.findViewById(R.id.title_video_info_item);
        this.mnr = (TextView) view.findViewById(R.id.title_measure_text);
        this.mny = view.findViewById(R.id.video_info_item_layout);
        this.mnu = view.findViewById(R.id.video_title_area_video_info_item);
        this.mnv = view.findViewById(R.id.video_info_item_collapsible_layout);
        this.mnq.setLayoutStrategy(new com.baidu.tieba.pb.pb.main.d(this.mnq.getLayoutStrategy()));
        this.mnq.setTextSize(TbConfig.getContentSize());
        this.mnq.setTextBold();
        this.mnr.setTextSize(0, TbConfig.getContentSize());
        this.mnr.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.mns = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.mnt = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.mnF = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.mnp.getPaddingLeft()) - this.mnp.getPaddingRight();
        AX(0);
        this.fUc = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.mnw = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.mnx = (TextView) view.findViewById(R.id.publish_location_video_info_item);
        this.mnA = (TextView) view.findViewById(R.id.publish_distance_video_info_item);
        this.mnB = (TextView) view.findViewById(R.id.play_count_video_info_item_collapsible);
        this.mnC = (TextView) view.findViewById(R.id.publish_time_video_info_item_collapsible);
        this.mnD = (TextView) view.findViewById(R.id.publish_location_video_info_item_collapsible);
        this.mnE = (TextView) view.findViewById(R.id.publish_distance_video_info_item_collapsible);
        this.meH = (VoteView) view.findViewById(R.id.pb_video_vote_view);
        this.mnz = (TbRichTextView) view.findViewById(R.id.video_abstract_item);
        this.lQw = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        com.baidu.tieba.pb.pb.main.d dVar = new com.baidu.tieba.pb.pb.main.d(this.mnz.getLayoutStrategy());
        dVar.setTextSize(l.getDimens(context, R.dimen.T_X06));
        dVar.as(0.9f);
        this.mnz.setLayoutStrategy(dVar);
        this.lPQ = (FrameLayout) view.findViewById(R.id.ueg_root);
        this.lPS = new d(videoPbFragment, this.lPQ);
        this.lPS.fvb = 2;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0205);
        this.jvb.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mnn.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mno.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mnq.setTextColor(ap.getColor(R.color.CAM_X0105));
        AX(this.mnG);
        this.fUc.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mnw.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mnx.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mnA.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mnB.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mnC.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mnD.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mnE.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.meH.onChangeSkinType(skinType);
        this.mnz.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.lPS.onChangeSkinType();
        if (this.mSkinType != skinType) {
            DI(skinType);
        }
        this.mSkinType = skinType;
    }

    public void wy(boolean z) {
        if (z) {
            ap.setViewTextColor(this.eIO, R.color.CAM_X0301, 1);
        } else {
            ap.setViewTextColor(this.eIO, R.color.CAM_X0105, 1);
        }
    }

    public void zu(int i) {
        if (i > 0) {
            ap.setImageResource(this.jva, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void l(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.mnj.setImageResource(R.drawable.pic_frs_headlines_n);
            this.mnj.setVisibility(0);
        } else if (z2 && z3) {
            this.mnj.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.mnj.setVisibility(0);
        } else if (z2) {
            this.mnj.setImageResource(R.drawable.pic_pb_refined_n);
            this.mnj.setVisibility(0);
        } else if (z3) {
            this.mnj.setImageResource(R.drawable.pic_pb_stick_n);
            this.mnj.setVisibility(0);
        } else {
            this.mnj.setVisibility(8);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mnk.setOnClickListener(onClickListener);
        this.mnt.setOnClickListener(onClickListener);
        this.mnu.setOnClickListener(onClickListener);
        this.mnl.setOnClickListener(onClickListener);
        this.eIO.setOnClickListener(onClickListener);
        this.mnm.setOnClickListener(onClickListener);
    }

    public void a(Context context, List<PbContent> list, String str, cb cbVar, boolean z) {
        int i;
        TbRichText tbRichText;
        if (!y.isEmpty(list) || !StringUtils.isNull(str)) {
            String spannableStringBuilder = !y.isEmpty(list) ? e.bK(list).toString() : str;
            if (this.mnr.getPaint().measureText(spannableStringBuilder, 0, spannableStringBuilder.length()) + (this.mnr.getTextSize() * 2.0f) > this.mnF * 2 || z) {
                i = (this.mnG == 1 || this.mnG == 2) ? this.mnG : 1;
            } else {
                i = 0;
            }
            AX(i);
            if (!y.isEmpty(list)) {
                tbRichText = TbRichTextView.a(context, list, true);
            } else {
                tbRichText = new TbRichText(context, a.f(context, str, 1));
            }
            a(tbRichText, cbVar.bpX());
            this.mnq.setText(tbRichText, false, this.mnI, false, true);
        }
    }

    private void a(List<TbRichTextData> list, HeadItem headItem) {
        int i;
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(headItem.name + ": " + (headItem.type.intValue() == 1 ? headItem.content : " ")));
        if (headItem.type.intValue() == 2) {
            try {
                i = Integer.parseInt(headItem.content);
            } catch (NumberFormatException e) {
                i = 0;
            }
            spannableStringBuilder.append((CharSequence) e.I(i, true));
        }
        tbRichTextData.p(spannableStringBuilder);
        y.add(list, 0, tbRichTextData);
    }

    public int cMC() {
        return this.mnG;
    }

    public void AX(int i) {
        this.mnG = i;
        if (i == 0) {
            cME();
        } else if (i == 1) {
            cMF();
        } else if (i == 2) {
            cMG();
        }
    }

    private void cME() {
        this.mnt.setVisibility(8);
        this.mnq.setTextEllipsize(null);
        this.mnq.setMaxLines(2);
    }

    private void cMF() {
        this.mnt.setVisibility(0);
        SvgManager.bsR().a(this.mns, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.mnq.setTextEllipsize(TextUtils.TruncateAt.END);
        this.mnq.setMaxLines(2);
        this.mnv.setVisibility(8);
        this.mnz.setVisibility(8);
        this.fUc.setVisibility(0);
        this.mnw.setVisibility(0);
        this.mnx.setVisibility(0);
        this.mnA.setVisibility(0);
        this.mny.setVisibility(0);
    }

    private void cMG() {
        this.mnt.setVisibility(0);
        SvgManager.bsR().a(this.mns, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.mnq.setTextEllipsize(null);
        this.mnq.setMaxLines(3);
        if (this.mnH) {
            this.mnz.setVisibility(0);
        }
        this.mnv.setVisibility(0);
        this.fUc.setVisibility(8);
        this.mnw.setVisibility(8);
        this.mnx.setVisibility(8);
        this.mnA.setVisibility(8);
        this.mny.setVisibility(8);
    }

    public void tz(boolean z) {
        if (z) {
            this.ajX.setVisibility(0);
            if (!this.ajX.isAnimating()) {
                this.ajX.setSpeed(0.8f);
                this.ajX.setRepeatCount(-1);
                this.ajX.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.viewholder.VideoPbVideoInfoViewHolder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPbVideoInfoViewHolder.this.ajX.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.ajX.setVisibility(8);
        if (this.ajX.isAnimating()) {
            this.ajX.cancelAnimation();
        }
    }

    private void DI(int i) {
        if (this.ajX != null) {
            ap.a(this.ajX, R.raw.card_live_header_bg);
        }
    }

    public void a(Context context, PostData postData) {
        if (postData == null || y.getCount(postData.nxw) < 2) {
            this.mnH = false;
            return;
        }
        List<PbContent> list = postData.nxw;
        TbRichText a2 = TbRichTextView.a(context, (List<PbContent>) y.subList(list, 1, list.size()), true);
        a(a2, postData.bpX());
        this.mnz.setText(a2);
        this.mnH = true;
    }

    public void a(TbRichText tbRichText, List<HeadItem> list) {
        TbRichTextData tbRichTextData;
        int i;
        int count = y.getCount(list);
        if (count != 0 && list != null) {
            ArrayList<TbRichTextData> bHz = tbRichText.bHz();
            if (count == 1) {
                TbRichTextData tbRichTextData2 = (TbRichTextData) y.getItem(bHz, 0);
                if (tbRichTextData2 == null || tbRichTextData2.getType() != 1) {
                    TbRichTextData tbRichTextData3 = new TbRichTextData(1);
                    y.add(bHz, 0, tbRichTextData3);
                    tbRichTextData = tbRichTextData3;
                } else {
                    tbRichTextData = tbRichTextData2;
                }
                HeadItem headItem = (HeadItem) y.getItem(list, 0);
                if (headItem != null) {
                    try {
                        i = Integer.parseInt(headItem.content);
                    } catch (NumberFormatException e) {
                        i = 0;
                    }
                    tbRichTextData.q(e.I(i, false));
                    return;
                }
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                HeadItem headItem2 = list.get(size);
                if (headItem2 != null) {
                    a(bHz, headItem2);
                }
            }
        }
    }

    public void bS(int i, String str) {
        this.lPS.setVisibility(i);
        this.lPS.setPostId(str);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mnp.getLayoutParams();
        if (i == 8) {
            layoutParams.addRule(3, R.id.user_info_area_video_info_item);
            layoutParams.setMargins(0, this.jwU, 0, 0);
        } else {
            layoutParams.addRule(3, R.id.ueg_root);
            layoutParams.setMargins(0, this.izi, 0, 0);
        }
        this.mnp.setLayoutParams(layoutParams);
    }
}
