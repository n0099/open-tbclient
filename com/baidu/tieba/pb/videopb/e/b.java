package com.baidu.tieba.pb.videopb.e;

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
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
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
import com.baidu.tieba.pb.pb.main.d;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
/* loaded from: classes22.dex */
public class b extends af.a {
    public TBLottieAnimationView akx;
    public TextView eBQ;
    public TextView fMQ;
    private final int jhF;
    public TextView jhx;
    public ImageView jhy;
    public TextView jhz;
    public LinearLayout lGQ;
    public VoteView lUT;
    public View mRoot;
    private int mSkinType;
    public UserIconBox mdA;
    public UserIconBox mdB;
    public TextView mdC;
    public PbFirstFloorUserLikeButton mdD;
    public RelativeLayout mdE;
    public TbRichTextView mdF;
    private final TextView mdG;
    public ImageView mdH;
    public RelativeLayout mdI;
    public View mdJ;
    public final View mdK;
    public TextView mdL;
    public TextView mdM;
    public View mdN;
    public TbRichTextView mdO;
    public TextView mdP;
    public TextView mdQ;
    public TextView mdR;
    public TextView mdS;
    public TextView mdT;
    private int mdU;
    private int mdV;
    private boolean mdW;
    private VideoPbFragment mdX;
    private final int mdx;
    public ImageView mdy;
    public HeadPendantClickableView mdz;

    public b(Context context, View view, VideoPbFragment videoPbFragment) {
        super(view);
        this.mdx = 2;
        this.jhF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mSkinType = 3;
        this.mRoot = view;
        this.mdX = videoPbFragment;
        this.mdy = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.mdz = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.mdz.setHasPendantStyle();
        this.mdz.getHeadView().setIsRound(true);
        this.mdz.getHeadView().setDrawBorder(true);
        this.mdz.getHeadView().setBorderWidth(l.getDimens(context, R.dimen.L_X01));
        this.mdz.getHeadView().setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.mdz.getHeadView().setPlaceHolder(1);
        this.mdz.setBigVDimenSize(R.dimen.tbds27);
        this.akx = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        this.mdA = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.eBQ = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.jhx = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.jhy = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.mdB = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.jhz = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.mdC = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.mdD = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.mdE = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.mdF = (TbRichTextView) view.findViewById(R.id.title_video_info_item);
        this.mdG = (TextView) view.findViewById(R.id.title_measure_text);
        this.mdN = view.findViewById(R.id.video_info_item_layout);
        this.mdJ = view.findViewById(R.id.video_title_area_video_info_item);
        this.mdK = view.findViewById(R.id.video_info_item_collapsible_layout);
        this.mdF.setLayoutStrategy(new d(this.mdF.getLayoutStrategy()));
        this.mdF.setTextSize(TbConfig.getContentSize());
        this.mdF.setTextBold();
        this.mdG.setTextSize(0, TbConfig.getContentSize());
        this.mdG.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.mdH = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.mdI = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.mdU = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.mdE.getPaddingLeft()) - this.mdE.getPaddingRight();
        HU(0);
        this.fMQ = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.mdL = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.mdM = (TextView) view.findViewById(R.id.publish_location_video_info_item);
        this.mdP = (TextView) view.findViewById(R.id.publish_distance_video_info_item);
        this.mdQ = (TextView) view.findViewById(R.id.play_count_video_info_item_collapsible);
        this.mdR = (TextView) view.findViewById(R.id.publish_time_video_info_item_collapsible);
        this.mdS = (TextView) view.findViewById(R.id.publish_location_video_info_item_collapsible);
        this.mdT = (TextView) view.findViewById(R.id.publish_distance_video_info_item_collapsible);
        this.lUT = (VoteView) view.findViewById(R.id.pb_video_vote_view);
        this.mdO = (TbRichTextView) view.findViewById(R.id.video_abstract_item);
        this.lGQ = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        d dVar = new d(this.mdO.getLayoutStrategy());
        dVar.setTextSize(l.getDimens(context, R.dimen.T_X06));
        dVar.ap(0.9f);
        this.mdO.setLayoutStrategy(dVar);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0205);
        this.jhz.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mdC.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mdD.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mdF.setTextColor(ap.getColor(R.color.CAM_X0105));
        HU(this.mdV);
        this.fMQ.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mdL.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mdM.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mdP.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mdQ.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mdR.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mdS.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mdT.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.lUT.onChangeSkinType(skinType);
        this.mdO.setTextColor(ap.getColor(R.color.CAM_X0107));
        if (this.mSkinType != skinType) {
            Fc(skinType);
        }
        this.mSkinType = skinType;
    }

    public void wk(boolean z) {
        if (z) {
            ap.setViewTextColor(this.eBQ, R.color.CAM_X0301, 1);
        } else {
            ap.setViewTextColor(this.eBQ, R.color.CAM_X0105, 1);
        }
    }

    public void AE(int i) {
        if (i > 0) {
            ap.setImageResource(this.jhy, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void k(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.mdy.setImageResource(R.drawable.pic_frs_headlines_n);
            this.mdy.setVisibility(0);
        } else if (z2 && z3) {
            this.mdy.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.mdy.setVisibility(0);
        } else if (z2) {
            this.mdy.setImageResource(R.drawable.pic_pb_refined_n);
            this.mdy.setVisibility(0);
        } else if (z3) {
            this.mdy.setImageResource(R.drawable.pic_pb_stick_n);
            this.mdy.setVisibility(0);
        } else {
            this.mdy.setVisibility(8);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mdz.setOnClickListener(onClickListener);
        this.mdI.setOnClickListener(onClickListener);
        this.mdJ.setOnClickListener(onClickListener);
        this.mdA.setOnClickListener(onClickListener);
        this.eBQ.setOnClickListener(onClickListener);
        this.mdB.setOnClickListener(onClickListener);
    }

    public void a(Context context, List<PbContent> list, String str, by byVar, boolean z) {
        int i;
        TbRichText tbRichText;
        if (!y.isEmpty(list) || !StringUtils.isNull(str)) {
            String spannableStringBuilder = !y.isEmpty(list) ? e.bI(list).toString() : str;
            if (this.mdG.getPaint().measureText(spannableStringBuilder, 0, spannableStringBuilder.length()) + (this.mdG.getTextSize() * 2.0f) > this.mdU * 2 || z) {
                i = (this.mdV == 1 || this.mdV == 2) ? this.mdV : 1;
            } else {
                i = 0;
            }
            HU(i);
            if (!y.isEmpty(list)) {
                tbRichText = TbRichTextView.a(context, list, true);
            } else {
                tbRichText = new TbRichText(context, com.baidu.tieba.im.chat.a.e(context, str, 1));
            }
            a(tbRichText, byVar.bqW());
            this.mdF.setText(tbRichText, false, this.mdX, false, true);
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
        y.add(list, 0, tbRichTextData);
    }

    public int dxj() {
        return this.mdV;
    }

    public void HU(int i) {
        this.mdV = i;
        if (i == 0) {
            dxk();
        } else if (i == 1) {
            dxl();
        } else if (i == 2) {
            dxm();
        }
    }

    private void dxk() {
        this.mdI.setVisibility(8);
        this.mdF.setTextEllipsize(null);
        this.mdF.setMaxLines(2);
    }

    private void dxl() {
        this.mdI.setVisibility(0);
        SvgManager.btW().a(this.mdH, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.mdF.setTextEllipsize(TextUtils.TruncateAt.END);
        this.mdF.setMaxLines(2);
        this.mdK.setVisibility(8);
        this.mdO.setVisibility(8);
        this.fMQ.setVisibility(0);
        this.mdL.setVisibility(0);
        this.mdM.setVisibility(0);
        this.mdP.setVisibility(0);
        this.mdN.setVisibility(0);
    }

    private void dxm() {
        this.mdI.setVisibility(0);
        SvgManager.btW().a(this.mdH, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.mdF.setTextEllipsize(null);
        this.mdF.setMaxLines(3);
        if (this.mdW) {
            this.mdO.setVisibility(0);
        }
        this.mdK.setVisibility(0);
        this.fMQ.setVisibility(8);
        this.mdL.setVisibility(8);
        this.mdM.setVisibility(8);
        this.mdP.setVisibility(8);
        this.mdN.setVisibility(8);
    }

    public void tp(boolean z) {
        if (z) {
            this.akx.setVisibility(0);
            if (!this.akx.isAnimating()) {
                this.akx.setSpeed(0.8f);
                this.akx.setRepeatCount(-1);
                this.akx.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.e.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.akx.playAnimation();
                    }
                });
                return;
            }
            return;
        }
        this.akx.setVisibility(8);
        if (this.akx.isAnimating()) {
            this.akx.cancelAnimation();
        }
    }

    private void Fc(int i) {
        if (i == 1) {
            this.akx.setAnimation("live/card_live_bg_night.json");
        } else if (i == 4) {
            this.akx.setAnimation("live/card_live_bg_black.json");
        } else {
            this.akx.setAnimation("live/card_live_bg.json");
        }
    }

    public void a(Context context, PostData postData) {
        if (postData == null || y.getCount(postData.nmF) < 2) {
            this.mdW = false;
            return;
        }
        List<PbContent> list = postData.nmF;
        TbRichText a2 = TbRichTextView.a(context, (List<PbContent>) y.subList(list, 1, list.size()), true);
        a(a2, postData.bqW());
        this.mdO.setText(a2);
        this.mdW = true;
    }

    public void a(TbRichText tbRichText, List<HeadItem> list) {
        TbRichTextData tbRichTextData;
        int i;
        int count = y.getCount(list);
        if (count != 0 && list != null) {
            ArrayList<TbRichTextData> bIC = tbRichText.bIC();
            if (count == 1) {
                TbRichTextData tbRichTextData2 = (TbRichTextData) y.getItem(bIC, 0);
                if (tbRichTextData2 == null || tbRichTextData2.getType() != 1) {
                    TbRichTextData tbRichTextData3 = new TbRichTextData(1);
                    y.add(bIC, 0, tbRichTextData3);
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
                    tbRichTextData.r(e.I(i, false));
                    return;
                }
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                HeadItem headItem2 = list.get(size);
                if (headItem2 != null) {
                    a(bIC, headItem2);
                }
            }
        }
    }
}
