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
    public TBLottieAnimationView akZ;
    public TextView eLt;
    public TextView fWu;
    public TextView jtZ;
    public ImageView jua;
    public TextView jub;
    private final int juh;
    public LinearLayout lMh;
    public View mRoot;
    private int mSkinType;
    public VoteView mai;
    private final int miN;
    public ImageView miO;
    public HeadPendantClickableView miP;
    public UserIconBox miQ;
    public UserIconBox miR;
    public TextView miS;
    public PbFirstFloorUserLikeButton miT;
    public RelativeLayout miU;
    public TbRichTextView miV;
    private final TextView miW;
    public ImageView miX;
    public RelativeLayout miY;
    public View miZ;
    public final View mja;
    public TextView mjb;
    public TextView mjc;
    public View mjd;
    public TbRichTextView mje;
    public TextView mjf;
    public TextView mjg;
    public TextView mjh;
    public TextView mji;
    public TextView mjj;
    private int mjk;
    private int mjl;
    private boolean mjm;
    private VideoPbFragment mjn;

    public VideoPbVideoInfoViewHolder(Context context, View view, VideoPbFragment videoPbFragment) {
        super(view);
        this.miN = 2;
        this.juh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mSkinType = 3;
        this.mRoot = view;
        this.mjn = videoPbFragment;
        this.miO = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.miP = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.miP.setHasPendantStyle();
        this.miP.getHeadView().setIsRound(true);
        this.miP.getHeadView().setDrawBorder(true);
        this.miP.getHeadView().setBorderWidth(l.getDimens(context, R.dimen.L_X01));
        this.miP.getHeadView().setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.miP.getHeadView().setPlaceHolder(1);
        this.miP.setBigVDimenSize(R.dimen.tbds27);
        this.akZ = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        this.miQ = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.eLt = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.jtZ = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.jua = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.miR = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.jub = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.miS = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.miT = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.miU = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.miV = (TbRichTextView) view.findViewById(R.id.title_video_info_item);
        this.miW = (TextView) view.findViewById(R.id.title_measure_text);
        this.mjd = view.findViewById(R.id.video_info_item_layout);
        this.miZ = view.findViewById(R.id.video_title_area_video_info_item);
        this.mja = view.findViewById(R.id.video_info_item_collapsible_layout);
        this.miV.setLayoutStrategy(new d(this.miV.getLayoutStrategy()));
        this.miV.setTextSize(TbConfig.getContentSize());
        this.miV.setTextBold();
        this.miW.setTextSize(0, TbConfig.getContentSize());
        this.miW.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.miX = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.miY = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.mjk = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.miU.getPaddingLeft()) - this.miU.getPaddingRight();
        HN(0);
        this.fWu = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.mjb = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.mjc = (TextView) view.findViewById(R.id.publish_location_video_info_item);
        this.mjf = (TextView) view.findViewById(R.id.publish_distance_video_info_item);
        this.mjg = (TextView) view.findViewById(R.id.play_count_video_info_item_collapsible);
        this.mjh = (TextView) view.findViewById(R.id.publish_time_video_info_item_collapsible);
        this.mji = (TextView) view.findViewById(R.id.publish_location_video_info_item_collapsible);
        this.mjj = (TextView) view.findViewById(R.id.publish_distance_video_info_item_collapsible);
        this.mai = (VoteView) view.findViewById(R.id.pb_video_vote_view);
        this.mje = (TbRichTextView) view.findViewById(R.id.video_abstract_item);
        this.lMh = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        d dVar = new d(this.mje.getLayoutStrategy());
        dVar.setTextSize(l.getDimens(context, R.dimen.T_X06));
        dVar.ar(0.9f);
        this.mje.setLayoutStrategy(dVar);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ao.setBackgroundColor(this.mRoot, R.color.CAM_X0205);
        this.jub.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.miS.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.miT.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.miV.setTextColor(ao.getColor(R.color.CAM_X0105));
        HN(this.mjl);
        this.fWu.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.mjb.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.mjc.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.mjf.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.mjg.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.mjh.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.mji.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.mjj.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.mai.onChangeSkinType(skinType);
        this.mje.setTextColor(ao.getColor(R.color.CAM_X0107));
        if (this.mSkinType != skinType) {
            EW(skinType);
        }
        this.mSkinType = skinType;
    }

    public void wl(boolean z) {
        if (z) {
            ao.setViewTextColor(this.eLt, R.color.CAM_X0301, 1);
        } else {
            ao.setViewTextColor(this.eLt, R.color.CAM_X0105, 1);
        }
    }

    public void AQ(int i) {
        if (i > 0) {
            ao.setImageResource(this.jua, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void l(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.miO.setImageResource(R.drawable.pic_frs_headlines_n);
            this.miO.setVisibility(0);
        } else if (z2 && z3) {
            this.miO.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.miO.setVisibility(0);
        } else if (z2) {
            this.miO.setImageResource(R.drawable.pic_pb_refined_n);
            this.miO.setVisibility(0);
        } else if (z3) {
            this.miO.setImageResource(R.drawable.pic_pb_stick_n);
            this.miO.setVisibility(0);
        } else {
            this.miO.setVisibility(8);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.miP.setOnClickListener(onClickListener);
        this.miY.setOnClickListener(onClickListener);
        this.miZ.setOnClickListener(onClickListener);
        this.miQ.setOnClickListener(onClickListener);
        this.eLt.setOnClickListener(onClickListener);
        this.miR.setOnClickListener(onClickListener);
    }

    public void a(Context context, List<PbContent> list, String str, bz bzVar, boolean z) {
        int i;
        TbRichText tbRichText;
        if (!x.isEmpty(list) || !StringUtils.isNull(str)) {
            String spannableStringBuilder = !x.isEmpty(list) ? e.bP(list).toString() : str;
            if (this.miW.getPaint().measureText(spannableStringBuilder, 0, spannableStringBuilder.length()) + (this.miW.getTextSize() * 2.0f) > this.mjk * 2 || z) {
                i = (this.mjl == 1 || this.mjl == 2) ? this.mjl : 1;
            } else {
                i = 0;
            }
            HN(i);
            if (!x.isEmpty(list)) {
                tbRichText = TbRichTextView.a(context, list, true);
            } else {
                tbRichText = new TbRichText(context, a.f(context, str, 1));
            }
            a(tbRichText, bzVar.bty());
            this.miV.setText(tbRichText, false, this.mjn, false, true);
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

    public int dwZ() {
        return this.mjl;
    }

    public void HN(int i) {
        this.mjl = i;
        if (i == 0) {
            dxa();
        } else if (i == 1) {
            dxb();
        } else if (i == 2) {
            dxc();
        }
    }

    private void dxa() {
        this.miY.setVisibility(8);
        this.miV.setTextEllipsize(null);
        this.miV.setMaxLines(2);
    }

    private void dxb() {
        this.miY.setVisibility(0);
        SvgManager.bwq().a(this.miX, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.miV.setTextEllipsize(TextUtils.TruncateAt.END);
        this.miV.setMaxLines(2);
        this.mja.setVisibility(8);
        this.mje.setVisibility(8);
        this.fWu.setVisibility(0);
        this.mjb.setVisibility(0);
        this.mjc.setVisibility(0);
        this.mjf.setVisibility(0);
        this.mjd.setVisibility(0);
    }

    private void dxc() {
        this.miY.setVisibility(0);
        SvgManager.bwq().a(this.miX, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.miV.setTextEllipsize(null);
        this.miV.setMaxLines(3);
        if (this.mjm) {
            this.mje.setVisibility(0);
        }
        this.mja.setVisibility(0);
        this.fWu.setVisibility(8);
        this.mjb.setVisibility(8);
        this.mjc.setVisibility(8);
        this.mjf.setVisibility(8);
        this.mjd.setVisibility(8);
    }

    public void tq(boolean z) {
        if (z) {
            this.akZ.setVisibility(0);
            if (!this.akZ.isAnimating()) {
                this.akZ.setSpeed(0.8f);
                this.akZ.setRepeatCount(-1);
                this.akZ.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.viewholder.VideoPbVideoInfoViewHolder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPbVideoInfoViewHolder.this.akZ.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.akZ.setVisibility(8);
        if (this.akZ.isAnimating()) {
            this.akZ.cancelAnimation();
        }
    }

    private void EW(int i) {
        if (i == 1) {
            this.akZ.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.akZ.setAnimation("live/card_live_bg_black.json");
        } else {
            this.akZ.setAnimation("live/card_live_bg.json");
        }
    }

    public void a(Context context, PostData postData) {
        if (postData == null || x.getCount(postData.nst) < 2) {
            this.mjm = false;
            return;
        }
        List<PbContent> list = postData.nst;
        TbRichText a2 = TbRichTextView.a(context, (List<PbContent>) x.subList(list, 1, list.size()), true);
        a(a2, postData.bty());
        this.mje.setText(a2);
        this.mjm = true;
    }

    public void a(TbRichText tbRichText, List<HeadItem> list) {
        TbRichTextData tbRichTextData;
        int i;
        int count = x.getCount(list);
        if (count != 0 && list != null) {
            ArrayList<TbRichTextData> bKW = tbRichText.bKW();
            if (count == 1) {
                TbRichTextData tbRichTextData2 = (TbRichTextData) x.getItem(bKW, 0);
                if (tbRichTextData2 == null || tbRichTextData2.getType() != 1) {
                    TbRichTextData tbRichTextData3 = new TbRichTextData(1);
                    x.add(bKW, 0, tbRichTextData3);
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
                    a(bKW, headItem2);
                }
            }
        }
    }
}
