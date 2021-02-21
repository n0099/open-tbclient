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
    private final int izw;
    public TextView jvn;
    public ImageView jvo;
    public TextView jvp;
    private final int jvv;
    private final int jxi;
    public LinearLayout lQL;
    private FrameLayout lQf;
    private d lQh;
    public View mRoot;
    private int mSkinType;
    public VoteView meW;
    public UserIconBox mnA;
    public UserIconBox mnB;
    public TextView mnC;
    public PbFirstFloorUserLikeButton mnD;
    public RelativeLayout mnE;
    public TbRichTextView mnF;
    private final TextView mnG;
    public ImageView mnH;
    public RelativeLayout mnI;
    public View mnJ;
    public final View mnK;
    public TextView mnL;
    public TextView mnM;
    public View mnN;
    public TbRichTextView mnO;
    public TextView mnP;
    public TextView mnQ;
    public TextView mnR;
    public TextView mnS;
    public TextView mnT;
    private int mnU;
    private int mnV;
    private boolean mnW;
    private VideoPbFragment mnX;
    private final int mnx;
    public ImageView mny;
    public HeadPendantClickableView mnz;

    public VideoPbVideoInfoViewHolder(Context context, View view, VideoPbFragment videoPbFragment) {
        super(view);
        this.mnx = 2;
        this.izw = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.jvv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.jxi = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
        this.mSkinType = 3;
        this.mRoot = view;
        this.mnX = videoPbFragment;
        this.mny = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.mnz = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.mnz.setHasPendantStyle();
        this.mnz.getHeadView().setIsRound(true);
        this.mnz.getHeadView().setDrawBorder(true);
        this.mnz.getHeadView().setBorderWidth(l.getDimens(context, R.dimen.L_X01));
        this.mnz.getHeadView().setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.mnz.getHeadView().setPlaceHolder(1);
        this.mnz.setBigVDimenSize(R.dimen.tbds27);
        this.ajX = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        this.mnA = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.eIO = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.jvn = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.jvo = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.mnB = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.jvp = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.mnC = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.mnD = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.mnE = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.mnF = (TbRichTextView) view.findViewById(R.id.title_video_info_item);
        this.mnG = (TextView) view.findViewById(R.id.title_measure_text);
        this.mnN = view.findViewById(R.id.video_info_item_layout);
        this.mnJ = view.findViewById(R.id.video_title_area_video_info_item);
        this.mnK = view.findViewById(R.id.video_info_item_collapsible_layout);
        this.mnF.setLayoutStrategy(new com.baidu.tieba.pb.pb.main.d(this.mnF.getLayoutStrategy()));
        this.mnF.setTextSize(TbConfig.getContentSize());
        this.mnF.setTextBold();
        this.mnG.setTextSize(0, TbConfig.getContentSize());
        this.mnG.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.mnH = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.mnI = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.mnU = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.mnE.getPaddingLeft()) - this.mnE.getPaddingRight();
        AX(0);
        this.fUc = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.mnL = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.mnM = (TextView) view.findViewById(R.id.publish_location_video_info_item);
        this.mnP = (TextView) view.findViewById(R.id.publish_distance_video_info_item);
        this.mnQ = (TextView) view.findViewById(R.id.play_count_video_info_item_collapsible);
        this.mnR = (TextView) view.findViewById(R.id.publish_time_video_info_item_collapsible);
        this.mnS = (TextView) view.findViewById(R.id.publish_location_video_info_item_collapsible);
        this.mnT = (TextView) view.findViewById(R.id.publish_distance_video_info_item_collapsible);
        this.meW = (VoteView) view.findViewById(R.id.pb_video_vote_view);
        this.mnO = (TbRichTextView) view.findViewById(R.id.video_abstract_item);
        this.lQL = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        com.baidu.tieba.pb.pb.main.d dVar = new com.baidu.tieba.pb.pb.main.d(this.mnO.getLayoutStrategy());
        dVar.setTextSize(l.getDimens(context, R.dimen.T_X06));
        dVar.as(0.9f);
        this.mnO.setLayoutStrategy(dVar);
        this.lQf = (FrameLayout) view.findViewById(R.id.ueg_root);
        this.lQh = new d(videoPbFragment, this.lQf);
        this.lQh.fvb = 2;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0205);
        this.jvp.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mnC.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mnD.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mnF.setTextColor(ap.getColor(R.color.CAM_X0105));
        AX(this.mnV);
        this.fUc.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mnL.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mnM.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mnP.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mnQ.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mnR.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mnS.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mnT.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.meW.onChangeSkinType(skinType);
        this.mnO.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.lQh.onChangeSkinType();
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
            ap.setImageResource(this.jvo, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void l(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.mny.setImageResource(R.drawable.pic_frs_headlines_n);
            this.mny.setVisibility(0);
        } else if (z2 && z3) {
            this.mny.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.mny.setVisibility(0);
        } else if (z2) {
            this.mny.setImageResource(R.drawable.pic_pb_refined_n);
            this.mny.setVisibility(0);
        } else if (z3) {
            this.mny.setImageResource(R.drawable.pic_pb_stick_n);
            this.mny.setVisibility(0);
        } else {
            this.mny.setVisibility(8);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mnz.setOnClickListener(onClickListener);
        this.mnI.setOnClickListener(onClickListener);
        this.mnJ.setOnClickListener(onClickListener);
        this.mnA.setOnClickListener(onClickListener);
        this.eIO.setOnClickListener(onClickListener);
        this.mnB.setOnClickListener(onClickListener);
    }

    public void a(Context context, List<PbContent> list, String str, cb cbVar, boolean z) {
        int i;
        TbRichText tbRichText;
        if (!y.isEmpty(list) || !StringUtils.isNull(str)) {
            String spannableStringBuilder = !y.isEmpty(list) ? e.bK(list).toString() : str;
            if (this.mnG.getPaint().measureText(spannableStringBuilder, 0, spannableStringBuilder.length()) + (this.mnG.getTextSize() * 2.0f) > this.mnU * 2 || z) {
                i = (this.mnV == 1 || this.mnV == 2) ? this.mnV : 1;
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
            this.mnF.setText(tbRichText, false, this.mnX, false, true);
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

    public int cMJ() {
        return this.mnV;
    }

    public void AX(int i) {
        this.mnV = i;
        if (i == 0) {
            cML();
        } else if (i == 1) {
            cMM();
        } else if (i == 2) {
            cMN();
        }
    }

    private void cML() {
        this.mnI.setVisibility(8);
        this.mnF.setTextEllipsize(null);
        this.mnF.setMaxLines(2);
    }

    private void cMM() {
        this.mnI.setVisibility(0);
        SvgManager.bsR().a(this.mnH, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.mnF.setTextEllipsize(TextUtils.TruncateAt.END);
        this.mnF.setMaxLines(2);
        this.mnK.setVisibility(8);
        this.mnO.setVisibility(8);
        this.fUc.setVisibility(0);
        this.mnL.setVisibility(0);
        this.mnM.setVisibility(0);
        this.mnP.setVisibility(0);
        this.mnN.setVisibility(0);
    }

    private void cMN() {
        this.mnI.setVisibility(0);
        SvgManager.bsR().a(this.mnH, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.mnF.setTextEllipsize(null);
        this.mnF.setMaxLines(3);
        if (this.mnW) {
            this.mnO.setVisibility(0);
        }
        this.mnK.setVisibility(0);
        this.fUc.setVisibility(8);
        this.mnL.setVisibility(8);
        this.mnM.setVisibility(8);
        this.mnP.setVisibility(8);
        this.mnN.setVisibility(8);
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
        if (postData == null || y.getCount(postData.nxW) < 2) {
            this.mnW = false;
            return;
        }
        List<PbContent> list = postData.nxW;
        TbRichText a2 = TbRichTextView.a(context, (List<PbContent>) y.subList(list, 1, list.size()), true);
        a(a2, postData.bpX());
        this.mnO.setText(a2);
        this.mnW = true;
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
        this.lQh.setVisibility(i);
        this.lQh.setPostId(str);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mnE.getLayoutParams();
        if (i == 8) {
            layoutParams.addRule(3, R.id.user_info_area_video_info_item);
            layoutParams.setMargins(0, this.jxi, 0, 0);
        } else {
            layoutParams.addRule(3, R.id.ueg_root);
            layoutParams.setMargins(0, this.izw, 0, 0);
        }
        this.mnE.setLayoutParams(layoutParams);
    }
}
