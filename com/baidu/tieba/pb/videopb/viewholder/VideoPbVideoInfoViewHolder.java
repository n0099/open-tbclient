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
    public TBLottieAnimationView alq;
    public TextView eKp;
    public TextView fVC;
    private final int iBf;
    public TextView jwW;
    public ImageView jwX;
    public TextView jwY;
    private final int jxe;
    private final int jyR;
    public LinearLayout lSN;
    private FrameLayout lSh;
    private d lSj;
    public View mRoot;
    private int mSkinType;
    public VoteView mgY;
    private final int mpA;
    public ImageView mpB;
    public HeadPendantClickableView mpC;
    public UserIconBox mpD;
    public UserIconBox mpE;
    public TextView mpF;
    public PbFirstFloorUserLikeButton mpG;
    public RelativeLayout mpH;
    public TbRichTextView mpI;
    private final TextView mpJ;
    public ImageView mpK;
    public RelativeLayout mpL;
    public View mpM;
    public final View mpN;
    public TextView mpO;
    public TextView mpP;
    public View mpQ;
    public TbRichTextView mpR;
    public TextView mpS;
    public TextView mpT;
    public TextView mpU;
    public TextView mpV;
    public TextView mpW;
    private int mpX;
    private int mpY;
    private boolean mpZ;
    private VideoPbFragment mqa;

    public VideoPbVideoInfoViewHolder(Context context, View view, VideoPbFragment videoPbFragment) {
        super(view);
        this.mpA = 2;
        this.iBf = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.jxe = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.jyR = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
        this.mSkinType = 3;
        this.mRoot = view;
        this.mqa = videoPbFragment;
        this.mpB = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.mpC = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.mpC.setHasPendantStyle();
        this.mpC.getHeadView().setIsRound(true);
        this.mpC.getHeadView().setDrawBorder(true);
        this.mpC.getHeadView().setBorderWidth(l.getDimens(context, R.dimen.L_X01));
        this.mpC.getHeadView().setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.mpC.getHeadView().setPlaceHolder(1);
        this.mpC.setBigVDimenSize(R.dimen.tbds27);
        this.alq = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        this.mpD = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.eKp = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.jwW = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.jwX = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.mpE = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.jwY = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.mpF = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.mpG = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.mpH = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.mpI = (TbRichTextView) view.findViewById(R.id.title_video_info_item);
        this.mpJ = (TextView) view.findViewById(R.id.title_measure_text);
        this.mpQ = view.findViewById(R.id.video_info_item_layout);
        this.mpM = view.findViewById(R.id.video_title_area_video_info_item);
        this.mpN = view.findViewById(R.id.video_info_item_collapsible_layout);
        this.mpI.setLayoutStrategy(new com.baidu.tieba.pb.pb.main.d(this.mpI.getLayoutStrategy()));
        this.mpI.setTextSize(TbConfig.getContentSize());
        this.mpI.setTextBold();
        this.mpJ.setTextSize(0, TbConfig.getContentSize());
        this.mpJ.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.mpK = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.mpL = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.mpX = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.mpH.getPaddingLeft()) - this.mpH.getPaddingRight();
        AY(0);
        this.fVC = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.mpO = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.mpP = (TextView) view.findViewById(R.id.publish_location_video_info_item);
        this.mpS = (TextView) view.findViewById(R.id.publish_distance_video_info_item);
        this.mpT = (TextView) view.findViewById(R.id.play_count_video_info_item_collapsible);
        this.mpU = (TextView) view.findViewById(R.id.publish_time_video_info_item_collapsible);
        this.mpV = (TextView) view.findViewById(R.id.publish_location_video_info_item_collapsible);
        this.mpW = (TextView) view.findViewById(R.id.publish_distance_video_info_item_collapsible);
        this.mgY = (VoteView) view.findViewById(R.id.pb_video_vote_view);
        this.mpR = (TbRichTextView) view.findViewById(R.id.video_abstract_item);
        this.lSN = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        com.baidu.tieba.pb.pb.main.d dVar = new com.baidu.tieba.pb.pb.main.d(this.mpR.getLayoutStrategy());
        dVar.setTextSize(l.getDimens(context, R.dimen.T_X06));
        dVar.aw(0.9f);
        this.mpR.setLayoutStrategy(dVar);
        this.lSh = (FrameLayout) view.findViewById(R.id.ueg_root);
        this.lSj = new d(videoPbFragment, this.lSh);
        this.lSj.fwA = 2;
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0205);
        this.jwY.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mpF.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mpG.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mpI.setTextColor(ap.getColor(R.color.CAM_X0105));
        AY(this.mpY);
        this.fVC.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mpO.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mpP.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mpS.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mpT.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mpU.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mpV.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mpW.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mgY.onChangeSkinType(skinType);
        this.mpR.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.lSj.onChangeSkinType();
        if (this.mSkinType != skinType) {
            DL(skinType);
        }
        this.mSkinType = skinType;
    }

    public void wy(boolean z) {
        if (z) {
            ap.setViewTextColor(this.eKp, R.color.CAM_X0301, 1);
        } else {
            ap.setViewTextColor(this.eKp, R.color.CAM_X0105, 1);
        }
    }

    public void zv(int i) {
        if (i > 0) {
            ap.setImageResource(this.jwX, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void l(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.mpB.setImageResource(R.drawable.pic_frs_headlines_n);
            this.mpB.setVisibility(0);
        } else if (z2 && z3) {
            this.mpB.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.mpB.setVisibility(0);
        } else if (z2) {
            this.mpB.setImageResource(R.drawable.pic_pb_refined_n);
            this.mpB.setVisibility(0);
        } else if (z3) {
            this.mpB.setImageResource(R.drawable.pic_pb_stick_n);
            this.mpB.setVisibility(0);
        } else {
            this.mpB.setVisibility(8);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mpC.setOnClickListener(onClickListener);
        this.mpL.setOnClickListener(onClickListener);
        this.mpM.setOnClickListener(onClickListener);
        this.mpD.setOnClickListener(onClickListener);
        this.eKp.setOnClickListener(onClickListener);
        this.mpE.setOnClickListener(onClickListener);
    }

    public void a(Context context, List<PbContent> list, String str, cb cbVar, boolean z) {
        int i;
        TbRichText tbRichText;
        if (!y.isEmpty(list) || !StringUtils.isNull(str)) {
            String spannableStringBuilder = !y.isEmpty(list) ? e.bK(list).toString() : str;
            if (this.mpJ.getPaint().measureText(spannableStringBuilder, 0, spannableStringBuilder.length()) + (this.mpJ.getTextSize() * 2.0f) > this.mpX * 2 || z) {
                i = (this.mpY == 1 || this.mpY == 2) ? this.mpY : 1;
            } else {
                i = 0;
            }
            AY(i);
            if (!y.isEmpty(list)) {
                tbRichText = TbRichTextView.a(context, list, true);
            } else {
                tbRichText = new TbRichText(context, a.e(context, str, 1));
            }
            a(tbRichText, cbVar.bpZ());
            this.mpI.setText(tbRichText, false, this.mqa, false, true);
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

    public int cMP() {
        return this.mpY;
    }

    public void AY(int i) {
        this.mpY = i;
        if (i == 0) {
            cMR();
        } else if (i == 1) {
            cMS();
        } else if (i == 2) {
            cMT();
        }
    }

    private void cMR() {
        this.mpL.setVisibility(8);
        this.mpI.setTextEllipsize(null);
        this.mpI.setMaxLines(2);
    }

    private void cMS() {
        this.mpL.setVisibility(0);
        SvgManager.bsU().a(this.mpK, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.mpI.setTextEllipsize(TextUtils.TruncateAt.END);
        this.mpI.setMaxLines(2);
        this.mpN.setVisibility(8);
        this.mpR.setVisibility(8);
        this.fVC.setVisibility(0);
        this.mpO.setVisibility(0);
        this.mpP.setVisibility(0);
        this.mpS.setVisibility(0);
        this.mpQ.setVisibility(0);
    }

    private void cMT() {
        this.mpL.setVisibility(0);
        SvgManager.bsU().a(this.mpK, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.mpI.setTextEllipsize(null);
        this.mpI.setMaxLines(3);
        if (this.mpZ) {
            this.mpR.setVisibility(0);
        }
        this.mpN.setVisibility(0);
        this.fVC.setVisibility(8);
        this.mpO.setVisibility(8);
        this.mpP.setVisibility(8);
        this.mpS.setVisibility(8);
        this.mpQ.setVisibility(8);
    }

    public void tz(boolean z) {
        if (z) {
            this.alq.setVisibility(0);
            if (!this.alq.isAnimating()) {
                this.alq.setSpeed(0.8f);
                this.alq.setRepeatCount(-1);
                this.alq.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.viewholder.VideoPbVideoInfoViewHolder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPbVideoInfoViewHolder.this.alq.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.alq.setVisibility(8);
        if (this.alq.isAnimating()) {
            this.alq.cancelAnimation();
        }
    }

    private void DL(int i) {
        if (this.alq != null) {
            ap.a(this.alq, R.raw.card_live_header_bg);
        }
    }

    public void a(Context context, PostData postData) {
        if (postData == null || y.getCount(postData.nAb) < 2) {
            this.mpZ = false;
            return;
        }
        List<PbContent> list = postData.nAb;
        TbRichText a2 = TbRichTextView.a(context, (List<PbContent>) y.subList(list, 1, list.size()), true);
        a(a2, postData.bpZ());
        this.mpR.setText(a2);
        this.mpZ = true;
    }

    public void a(TbRichText tbRichText, List<HeadItem> list) {
        TbRichTextData tbRichTextData;
        int i;
        int count = y.getCount(list);
        if (count != 0 && list != null) {
            ArrayList<TbRichTextData> bHD = tbRichText.bHD();
            if (count == 1) {
                TbRichTextData tbRichTextData2 = (TbRichTextData) y.getItem(bHD, 0);
                if (tbRichTextData2 == null || tbRichTextData2.getType() != 1) {
                    TbRichTextData tbRichTextData3 = new TbRichTextData(1);
                    y.add(bHD, 0, tbRichTextData3);
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
                    a(bHD, headItem2);
                }
            }
        }
    }

    public void bS(int i, String str) {
        this.lSj.setVisibility(i);
        this.lSj.setPostId(str);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mpH.getLayoutParams();
        if (i == 8) {
            layoutParams.addRule(3, R.id.user_info_area_video_info_item);
            layoutParams.setMargins(0, this.jyR, 0, 0);
        } else {
            layoutParams.addRule(3, R.id.ueg_root);
            layoutParams.setMargins(0, this.iBf, 0, 0);
        }
        this.mpH.setLayoutParams(layoutParams);
    }
}
