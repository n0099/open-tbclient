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
    public ImageView jhA;
    public TextView jhB;
    private final int jhH;
    public TextView jhz;
    public LinearLayout lGS;
    public VoteView lUV;
    public View mRoot;
    private int mSkinType;
    public ImageView mdA;
    public HeadPendantClickableView mdB;
    public UserIconBox mdC;
    public UserIconBox mdD;
    public TextView mdE;
    public PbFirstFloorUserLikeButton mdF;
    public RelativeLayout mdG;
    public TbRichTextView mdH;
    private final TextView mdI;
    public ImageView mdJ;
    public RelativeLayout mdK;
    public View mdL;
    public final View mdM;
    public TextView mdN;
    public TextView mdO;
    public View mdP;
    public TbRichTextView mdQ;
    public TextView mdR;
    public TextView mdS;
    public TextView mdT;
    public TextView mdU;
    public TextView mdV;
    private int mdW;
    private int mdX;
    private boolean mdY;
    private VideoPbFragment mdZ;
    private final int mdz;

    public b(Context context, View view, VideoPbFragment videoPbFragment) {
        super(view);
        this.mdz = 2;
        this.jhH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        this.mSkinType = 3;
        this.mRoot = view;
        this.mdZ = videoPbFragment;
        this.mdA = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        this.mdB = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.mdB.setHasPendantStyle();
        this.mdB.getHeadView().setIsRound(true);
        this.mdB.getHeadView().setDrawBorder(true);
        this.mdB.getHeadView().setBorderWidth(l.getDimens(context, R.dimen.L_X01));
        this.mdB.getHeadView().setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.mdB.getHeadView().setPlaceHolder(1);
        this.mdB.setBigVDimenSize(R.dimen.tbds27);
        this.akx = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        this.mdC = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.eBQ = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.jhz = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.jhA = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.mdD = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.jhB = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.mdE = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.mdF = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.mdG = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.mdH = (TbRichTextView) view.findViewById(R.id.title_video_info_item);
        this.mdI = (TextView) view.findViewById(R.id.title_measure_text);
        this.mdP = view.findViewById(R.id.video_info_item_layout);
        this.mdL = view.findViewById(R.id.video_title_area_video_info_item);
        this.mdM = view.findViewById(R.id.video_info_item_collapsible_layout);
        this.mdH.setLayoutStrategy(new d(this.mdH.getLayoutStrategy()));
        this.mdH.setTextSize(TbConfig.getContentSize());
        this.mdH.setTextBold();
        this.mdI.setTextSize(0, TbConfig.getContentSize());
        this.mdI.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.mdJ = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.mdK = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.mdW = (l.getEquipmentWidth(TbadkCoreApplication.getInst()) - this.mdG.getPaddingLeft()) - this.mdG.getPaddingRight();
        HU(0);
        this.fMQ = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.mdN = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.mdO = (TextView) view.findViewById(R.id.publish_location_video_info_item);
        this.mdR = (TextView) view.findViewById(R.id.publish_distance_video_info_item);
        this.mdS = (TextView) view.findViewById(R.id.play_count_video_info_item_collapsible);
        this.mdT = (TextView) view.findViewById(R.id.publish_time_video_info_item_collapsible);
        this.mdU = (TextView) view.findViewById(R.id.publish_location_video_info_item_collapsible);
        this.mdV = (TextView) view.findViewById(R.id.publish_distance_video_info_item_collapsible);
        this.lUV = (VoteView) view.findViewById(R.id.pb_video_vote_view);
        this.mdQ = (TbRichTextView) view.findViewById(R.id.video_abstract_item);
        this.lGS = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        d dVar = new d(this.mdQ.getLayoutStrategy());
        dVar.setTextSize(l.getDimens(context, R.dimen.T_X06));
        dVar.ap(0.9f);
        this.mdQ.setLayoutStrategy(dVar);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setBackgroundColor(this.mRoot, R.color.CAM_X0205);
        this.jhB.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mdE.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mdF.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.mdH.setTextColor(ap.getColor(R.color.CAM_X0105));
        HU(this.mdX);
        this.fMQ.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mdN.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mdO.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mdR.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mdS.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mdT.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mdU.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.mdV.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.lUV.onChangeSkinType(skinType);
        this.mdQ.setTextColor(ap.getColor(R.color.CAM_X0107));
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
            ap.setImageResource(this.jhA, BitmapHelper.getGradeResourceIdInEnterForum(i));
        }
    }

    public void k(boolean z, boolean z2, boolean z3) {
        if (z) {
            this.mdA.setImageResource(R.drawable.pic_frs_headlines_n);
            this.mdA.setVisibility(0);
        } else if (z2 && z3) {
            this.mdA.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.mdA.setVisibility(0);
        } else if (z2) {
            this.mdA.setImageResource(R.drawable.pic_pb_refined_n);
            this.mdA.setVisibility(0);
        } else if (z3) {
            this.mdA.setImageResource(R.drawable.pic_pb_stick_n);
            this.mdA.setVisibility(0);
        } else {
            this.mdA.setVisibility(8);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mdB.setOnClickListener(onClickListener);
        this.mdK.setOnClickListener(onClickListener);
        this.mdL.setOnClickListener(onClickListener);
        this.mdC.setOnClickListener(onClickListener);
        this.eBQ.setOnClickListener(onClickListener);
        this.mdD.setOnClickListener(onClickListener);
    }

    public void a(Context context, List<PbContent> list, String str, by byVar, boolean z) {
        int i;
        TbRichText tbRichText;
        if (!y.isEmpty(list) || !StringUtils.isNull(str)) {
            String spannableStringBuilder = !y.isEmpty(list) ? e.bI(list).toString() : str;
            if (this.mdI.getPaint().measureText(spannableStringBuilder, 0, spannableStringBuilder.length()) + (this.mdI.getTextSize() * 2.0f) > this.mdW * 2 || z) {
                i = (this.mdX == 1 || this.mdX == 2) ? this.mdX : 1;
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
            this.mdH.setText(tbRichText, false, this.mdZ, false, true);
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

    public int dxk() {
        return this.mdX;
    }

    public void HU(int i) {
        this.mdX = i;
        if (i == 0) {
            dxl();
        } else if (i == 1) {
            dxm();
        } else if (i == 2) {
            dxn();
        }
    }

    private void dxl() {
        this.mdK.setVisibility(8);
        this.mdH.setTextEllipsize(null);
        this.mdH.setMaxLines(2);
    }

    private void dxm() {
        this.mdK.setVisibility(0);
        SvgManager.btW().a(this.mdJ, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.mdH.setTextEllipsize(TextUtils.TruncateAt.END);
        this.mdH.setMaxLines(2);
        this.mdM.setVisibility(8);
        this.mdQ.setVisibility(8);
        this.fMQ.setVisibility(0);
        this.mdN.setVisibility(0);
        this.mdO.setVisibility(0);
        this.mdR.setVisibility(0);
        this.mdP.setVisibility(0);
    }

    private void dxn() {
        this.mdK.setVisibility(0);
        SvgManager.btW().a(this.mdJ, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.mdH.setTextEllipsize(null);
        this.mdH.setMaxLines(3);
        if (this.mdY) {
            this.mdQ.setVisibility(0);
        }
        this.mdM.setVisibility(0);
        this.fMQ.setVisibility(8);
        this.mdN.setVisibility(8);
        this.mdO.setVisibility(8);
        this.mdR.setVisibility(8);
        this.mdP.setVisibility(8);
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
        if (postData == null || y.getCount(postData.nmH) < 2) {
            this.mdY = false;
            return;
        }
        List<PbContent> list = postData.nmH;
        TbRichText a2 = TbRichTextView.a(context, (List<PbContent>) y.subList(list, 1, list.size()), true);
        a(a2, postData.bqW());
        this.mdQ.setText(a2);
        this.mdY = true;
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
