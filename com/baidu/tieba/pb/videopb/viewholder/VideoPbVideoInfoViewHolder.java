package com.baidu.tieba.pb.videopb.viewholder;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
import com.baidu.tieba.pb.pb.main.d;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
/* loaded from: classes2.dex */
public class VideoPbVideoInfoViewHolder extends TypeAdapter.ViewHolder {
    public TBLottieAnimationView aki;
    public TextView eGI;
    public TextView fRN;
    private final int jpB;
    public TextView jpt;
    public ImageView jpu;
    public TextView jpv;
    public LinearLayout lHC;
    public VoteView lVC;
    public View mRoot;
    private int mSkinType;
    public TextView meA;
    public TextView meB;
    public TextView meC;
    private int meD;
    private int meE;
    private boolean meF;
    private VideoPbFragment meG;
    private final int mef;
    public ImageView meg;
    public HeadPendantClickableView meh;
    public UserIconBox mei;
    public UserIconBox mej;
    public TextView mek;
    public PbFirstFloorUserLikeButton mel;
    public RelativeLayout men;
    public TbRichTextView meo;
    private final TextView mep;
    public ImageView meq;
    public RelativeLayout mer;
    public View mes;
    public final View met;
    public TextView meu;
    public TextView mev;
    public View mew;
    public TbRichTextView mex;
    public TextView mey;
    public TextView mez;

    public VideoPbVideoInfoViewHolder(Context context, View view, VideoPbFragment videoPbFragment) {
        super(view);
        this.mef = 2;
        this.jpB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mSkinType = 3;
        this.mRoot = view;
        this.meG = videoPbFragment;
        this.meg = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.meh = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.meh.setHasPendantStyle();
        this.meh.getHeadView().setIsRound(true);
        this.meh.getHeadView().setDrawBorder(true);
        this.meh.getHeadView().setBorderWidth(l.getDimens(context, R.dimen.L_X01));
        this.meh.getHeadView().setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.meh.getHeadView().setPlaceHolder(1);
        this.meh.setBigVDimenSize(R.dimen.tbds27);
        this.aki = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        this.mei = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.eGI = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.jpt = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.jpu = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.mej = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.jpv = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.mek = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.mel = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.men = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.meo = (TbRichTextView) view.findViewById(R.id.title_video_info_item);
        this.mep = (TextView) view.findViewById(R.id.title_measure_text);
        this.mew = view.findViewById(R.id.video_info_item_layout);
        this.mes = view.findViewById(R.id.video_title_area_video_info_item);
        this.met = view.findViewById(R.id.video_info_item_collapsible_layout);
        this.meo.setLayoutStrategy(new d(this.meo.getLayoutStrategy()));
        this.meo.setTextSize(TbConfig.getContentSize());
        this.meo.setTextBold();
        this.mep.setTextSize(0, TbConfig.getContentSize());
        this.mep.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.meq = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.mer = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.meD = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.men.getPaddingLeft()) - this.men.getPaddingRight();
        Gh(0);
        this.fRN = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.meu = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.mev = (TextView) view.findViewById(R.id.publish_location_video_info_item);
        this.mey = (TextView) view.findViewById(R.id.publish_distance_video_info_item);
        this.mez = (TextView) view.findViewById(R.id.play_count_video_info_item_collapsible);
        this.meA = (TextView) view.findViewById(R.id.publish_time_video_info_item_collapsible);
        this.meB = (TextView) view.findViewById(R.id.publish_location_video_info_item_collapsible);
        this.meC = (TextView) view.findViewById(R.id.publish_distance_video_info_item_collapsible);
        this.lVC = (VoteView) view.findViewById(R.id.pb_video_vote_view);
        this.mex = (TbRichTextView) view.findViewById(R.id.video_abstract_item);
        this.lHC = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        d dVar = new d(this.mex.getLayoutStrategy());
        dVar.setTextSize(l.getDimens(context, R.dimen.T_X06));
        dVar.ar(0.9f);
        this.mex.setLayoutStrategy(dVar);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0205);
        this.jpv.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.mek.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.mel.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.meo.setTextColor(ao.getColor(R.color.CAM_X0105));
        Gh(this.meE);
        this.fRN.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.meu.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.mev.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.mey.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.mez.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.meA.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.meB.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.meC.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.lVC.onChangeSkinType(skinType);
        this.mex.setTextColor(ao.getColor(R.color.CAM_X0107));
        if (this.mSkinType != skinType) {
            Dq(skinType);
        }
        this.mSkinType = skinType;
    }

    public void wh(boolean z) {
        if (z) {
            ao.setViewTextColor(this.eGI, R.color.CAM_X0301, 1);
        } else {
            ao.setViewTextColor(this.eGI, R.color.CAM_X0105, 1);
        }
    }

    public void zk(int i) {
        if (i > 0) {
            ao.setImageResource(this.jpu, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void l(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.meg.setImageResource(R.drawable.pic_frs_headlines_n);
            this.meg.setVisibility(0);
        } else if (z2 && z3) {
            this.meg.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.meg.setVisibility(0);
        } else if (z2) {
            this.meg.setImageResource(R.drawable.pic_pb_refined_n);
            this.meg.setVisibility(0);
        } else if (z3) {
            this.meg.setImageResource(R.drawable.pic_pb_stick_n);
            this.meg.setVisibility(0);
        } else {
            this.meg.setVisibility(8);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.meh.setOnClickListener(onClickListener);
        this.mer.setOnClickListener(onClickListener);
        this.mes.setOnClickListener(onClickListener);
        this.mei.setOnClickListener(onClickListener);
        this.eGI.setOnClickListener(onClickListener);
        this.mej.setOnClickListener(onClickListener);
    }

    public void a(Context context, List<PbContent> list, String str, bz bzVar, boolean z) {
        int i;
        TbRichText tbRichText;
        if (!x.isEmpty(list) || !StringUtils.isNull(str)) {
            String spannableStringBuilder = !x.isEmpty(list) ? e.bP(list).toString() : str;
            if (this.mep.getPaint().measureText(spannableStringBuilder, 0, spannableStringBuilder.length()) + (this.mep.getTextSize() * 2.0f) > this.meD * 2 || z) {
                i = (this.meE == 1 || this.meE == 2) ? this.meE : 1;
            } else {
                i = 0;
            }
            Gh(i);
            if (!x.isEmpty(list)) {
                tbRichText = TbRichTextView.a(context, list, true);
            } else {
                tbRichText = new TbRichText(context, a.f(context, str, 1));
            }
            a(tbRichText, bzVar.bpF());
            this.meo.setText(tbRichText, false, this.meG, false, true);
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
        tbRichTextData.q(spannableStringBuilder);
        x.add(list, 0, tbRichTextData);
    }

    public int dti() {
        return this.meE;
    }

    public void Gh(int i) {
        this.meE = i;
        if (i == 0) {
            dtj();
        } else if (i == 1) {
            dtk();
        } else if (i == 2) {
            dtl();
        }
    }

    private void dtj() {
        this.mer.setVisibility(8);
        this.meo.setTextEllipsize(null);
        this.meo.setMaxLines(2);
    }

    private void dtk() {
        this.mer.setVisibility(0);
        SvgManager.bsx().a(this.meq, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.meo.setTextEllipsize(TextUtils.TruncateAt.END);
        this.meo.setMaxLines(2);
        this.met.setVisibility(8);
        this.mex.setVisibility(8);
        this.fRN.setVisibility(0);
        this.meu.setVisibility(0);
        this.mev.setVisibility(0);
        this.mey.setVisibility(0);
        this.mew.setVisibility(0);
    }

    private void dtl() {
        this.mer.setVisibility(0);
        SvgManager.bsx().a(this.meq, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.meo.setTextEllipsize(null);
        this.meo.setMaxLines(3);
        if (this.meF) {
            this.mex.setVisibility(0);
        }
        this.met.setVisibility(0);
        this.fRN.setVisibility(8);
        this.meu.setVisibility(8);
        this.mev.setVisibility(8);
        this.mey.setVisibility(8);
        this.mew.setVisibility(8);
    }

    public void tm(boolean z) {
        if (z) {
            this.aki.setVisibility(0);
            if (!this.aki.isAnimating()) {
                this.aki.setSpeed(0.8f);
                this.aki.setRepeatCount(-1);
                this.aki.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.viewholder.VideoPbVideoInfoViewHolder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPbVideoInfoViewHolder.this.aki.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.aki.setVisibility(8);
        if (this.aki.isAnimating()) {
            this.aki.cancelAnimation();
        }
    }

    private void Dq(int i) {
        if (this.aki != null) {
            ao.a(this.aki, R.raw.card_live_header_bg);
        }
    }

    public void a(Context context, PostData postData) {
        if (postData == null || x.getCount(postData.nnL) < 2) {
            this.meF = false;
            return;
        }
        List<PbContent> list = postData.nnL;
        TbRichText a2 = TbRichTextView.a(context, (List<PbContent>) x.subList(list, 1, list.size()), true);
        a(a2, postData.bpF());
        this.mex.setText(a2);
        this.meF = true;
    }

    public void a(TbRichText tbRichText, List<HeadItem> list) {
        TbRichTextData tbRichTextData;
        int i;
        int count = x.getCount(list);
        if (count != 0 && list != null) {
            ArrayList<TbRichTextData> bHf = tbRichText.bHf();
            if (count == 1) {
                TbRichTextData tbRichTextData2 = (TbRichTextData) x.getItem(bHf, 0);
                if (tbRichTextData2 == null || tbRichTextData2.getType() != 1) {
                    TbRichTextData tbRichTextData3 = new TbRichTextData(1);
                    x.add(bHf, 0, tbRichTextData3);
                    tbRichTextData = tbRichTextData3;
                } else {
                    tbRichTextData = tbRichTextData2;
                }
                HeadItem headItem = (HeadItem) x.getItem(list, 0);
                if (headItem != null) {
                    try {
                        i = Integer.parseInt(headItem.content);
                    } catch (NumberFormatException e) {
                        i = 0;
                    }
                    tbRichTextData.r(e.I(i, false));
                    return;
                }
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                HeadItem headItem2 = list.get(size);
                if (headItem2 != null) {
                    a(bHf, headItem2);
                }
            }
        }
    }
}
