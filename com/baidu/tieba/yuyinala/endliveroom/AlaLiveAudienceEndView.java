package com.baidu.tieba.yuyinala.endliveroom;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.view.BarImageView;
import com.baidu.live.utils.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes11.dex */
public class AlaLiveAudienceEndView extends RelativeLayout {
    private static final LinearInterpolator gVk = new LinearInterpolator();
    private x aGe;
    private AlaLiveUserInfoData aKQ;
    private String aYx;
    private ValueAnimator animator;
    private TbImageView gVA;
    private TextView gVB;
    private TextView gVC;
    private ProgressBar gVD;
    private TextView gVE;
    private LinearLayout gVF;
    private TextView gVG;
    private TextView gVH;
    private View gVI;
    private boolean gVJ;
    private boolean gVK;
    private int gVL;
    private ArrayList<AlaLiveInfoData> gVM;
    private Set<Long> gVN;
    private TextView gVn;
    private LinearLayout gVs;
    private LinearLayout gVt;
    private RelativeLayout gVu;
    private RelativeLayout gVv;
    private TbImageView gVw;
    private TextView gVx;
    private TextView gVy;
    private ProgressBar gVz;
    private String liveId;
    private ImageView mCloseBtn;
    private Activity mContext;
    private AlaLiveInfoData mLiveInfo;
    private String mOtherParams;
    private String mPortrait;
    private TbPageContext mTbPageContext;
    private View mView;
    private a olQ;
    private BarImageView olR;
    private TextView olS;
    private TextView olT;
    private TextView olU;
    private TextView olV;
    private TextView olW;
    private TextView olX;
    private LinearLayout olY;
    private LinearLayout olZ;
    private TextView oma;
    private TextView omb;
    private String roomId;

    /* loaded from: classes11.dex */
    public interface a {
        void Pj();

        void f(AlaLiveInfoData alaLiveInfoData);

        void na(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.gVJ = false;
        this.mPortrait = "";
        this.gVK = false;
        this.gVL = 0;
        this.gVN = new HashSet();
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_live_audience_end_view_layout, (ViewGroup) this, true);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.f.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.olQ != null) {
                    AlaLiveAudienceEndView.this.olQ.Pj();
                }
            }
        });
        this.olR = (BarImageView) this.mView.findViewById(a.f.avatar_img);
        this.gVn = (TextView) this.mView.findViewById(a.f.user_name);
        this.olS = (TextView) this.mView.findViewById(a.f.tv_user_id);
        this.gVH = (TextView) this.mView.findViewById(a.f.endText_textView);
        this.olT = (TextView) this.mView.findViewById(a.f.tv_live_end_newcharmnum);
        this.olU = (TextView) this.mView.findViewById(a.f.tv_live_end_givernum);
        this.olV = (TextView) this.mView.findViewById(a.f.tv_live_end_watchnum);
        this.olW = (TextView) this.mView.findViewById(a.f.tv_live_end_newfansnum);
        this.olX = (TextView) this.mView.findViewById(a.f.endText_textView_master);
        this.olY = (LinearLayout) this.mView.findViewById(a.f.ll_master_bottomview);
        this.olZ = (LinearLayout) this.mView.findViewById(a.f.ll_audience_bottomview);
        this.gVF = (LinearLayout) this.mView.findViewById(a.f.llFollowLabel);
        this.gVE = (TextView) this.mView.findViewById(a.f.follow_label);
        this.gVG = (TextView) this.mView.findViewById(a.f.live_over_name);
        bXS();
    }

    private void setUserTypeForView(boolean z) {
        if (z) {
            this.olY.setVisibility(0);
            this.olZ.setVisibility(8);
            return;
        }
        this.olY.setVisibility(8);
        this.olZ.setVisibility(0);
    }

    private void ebT() {
        this.olV.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.familyFansCount));
        if (this.mLiveInfo.newFansCount <= 0) {
            this.olW.setText(String.valueOf(this.mLiveInfo.newFansCount));
        } else {
            this.olW.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.newFansCount));
        }
        this.olU.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.rewardUserCount));
        this.olT.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.charm_count));
    }

    public void setCallback(a aVar) {
        this.olQ = aVar;
    }

    public void setData(TbPageContext tbPageContext, x xVar, boolean z, boolean z2, String str, String str2) {
        this.aGe = xVar;
        this.gVK = z;
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.aGe = xVar;
        this.mLiveInfo = xVar.mLiveInfo;
        this.aKQ = xVar.aKQ;
        this.gVJ = z2;
        this.mPortrait = str;
        this.gVK = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aYx = this.mLiveInfo.feed_id;
        this.mOtherParams = str2;
        if (this.aYx == null || TextUtils.equals(this.aYx, "null")) {
            this.aYx = "";
        }
        if (this.mOtherParams == null || TextUtils.equals(this.mOtherParams, "null")) {
            this.mOtherParams = "";
        }
        this.olR.setShowOval(true);
        this.olR.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.olR.setAutoChangeStyle(false);
        this.olR.setAccuracyWith(30.0f);
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.olR.setDefaultResource(a.e.pic_avatar_moren);
        } else {
            this.olR.startLoad(this.mPortrait, 12, false, false);
        }
        this.gVn.setText(this.aGe.aLl.room_name);
        this.olS.setText(this.mContext.getResources().getString(a.h.room_id_name) + xVar.aLl.croom_id);
        this.gVF.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aGe != null && this.aGe.mLiveInfo != null && this.aGe.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aGe.mLiveInfo.mLiveCloseData.title)) {
            this.gVG.setText(this.aGe.mLiveInfo.mLiveCloseData.title);
        } else if (this.gVK) {
            this.gVG.setText(a.h.yuyin_live_closed);
        } else {
            this.gVG.setText(a.h.yuyin_live_over_name);
        }
        nb(this.gVJ);
        if (this.aGe != null && this.aGe.mLiveInfo != null && this.aGe.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aGe.mLiveInfo.mLiveCloseData.title)) {
                this.gVG.setText(a.h.yuyin_live_over_name);
            } else {
                this.gVG.setText(this.aGe.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.gVK) {
            this.gVG.setText(a.h.yuyin_live_closed);
        } else {
            this.gVG.setText(a.h.yuyin_live_over_name);
        }
        if (this.aKQ.userType == 1 || this.aKQ.userType == 2) {
            setUserTypeForView(true);
            ebT();
            if (TextUtils.isEmpty(this.mLiveInfo.close_reason)) {
                this.olX.setVisibility(8);
                return;
            }
            this.olX.setVisibility(0);
            this.olX.setText(this.mLiveInfo.close_reason);
            return;
        }
        setUserTypeForView(false);
        this.gVF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aGe == null || AlaLiveAudienceEndView.this.aGe.mLiveInfo == null || AlaLiveAudienceEndView.this.aGe.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.olQ != null) {
                        if (AlaLiveAudienceEndView.this.gVJ) {
                            AlaLiveAudienceEndView.this.bXV();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aYx, AlaLiveAudienceEndView.this.mOtherParams);
                        AlaLiveAudienceEndView.this.olQ.na(AlaLiveAudienceEndView.this.gVJ);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aGe.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.mContext, AlaLiveAudienceEndView.this.aGe.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
    }

    public void nb(boolean z) {
        this.gVJ = z;
        if (this.aGe != null && this.aGe.mLiveInfo != null && this.aGe.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aGe.mLiveInfo.mLiveCloseData.tips)) {
                this.gVH.setText("");
            } else {
                this.gVH.setText(this.aGe.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aGe.mLiveInfo.mLiveCloseData.actionText)) {
                this.gVF.setVisibility(8);
                this.gVE.setText("");
            } else {
                this.gVF.setVisibility(0);
                this.gVE.setText(this.aGe.mLiveInfo.mLiveCloseData.actionText);
                this.gVF.setBackgroundResource(a.e.round_btn_collection_highlight);
            }
            setRecommendViewVisible(8);
            return;
        }
        this.gVF.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.gVJ) {
            this.gVH.setText(a.h.yuyin_endtext_followed);
            this.gVE.setText(a.h.yuyinala_live_end_view_followed);
            this.gVF.setBackgroundResource(a.e.round_btn_collection_lowlight);
            return;
        }
        this.gVH.setText(a.h.yuyin_endtext_follow);
        this.gVE.setText(a.h.yuyinala_live_end_view_follow);
        this.gVF.setBackgroundResource(a.e.round_btn_collection_highlight);
    }

    private void bXS() {
        this.gVs = (LinearLayout) this.mView.findViewById(a.f.llFeedVideoLabel);
        this.gVt = (LinearLayout) this.mView.findViewById(a.f.video_audience_ll);
        this.gVI = this.mView.findViewById(a.f.change_layout);
        this.gVw = (TbImageView) this.mView.findViewById(a.f.feed_video_item1_cover);
        this.gVx = (TextView) this.mView.findViewById(a.f.feed_video_item1_name);
        this.gVy = (TextView) this.mView.findViewById(a.f.feed_video_item1_watch_num);
        this.oma = (TextView) this.mView.findViewById(a.f.live_label_1);
        this.gVA = (TbImageView) this.mView.findViewById(a.f.feed_video_item2_cover);
        this.gVB = (TextView) this.mView.findViewById(a.f.feed_video_item2_name);
        this.gVC = (TextView) this.mView.findViewById(a.f.feed_video_item2_watch_num);
        this.omb = (TextView) this.mView.findViewById(a.f.live_label_2);
        this.gVu = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_1);
        this.gVv = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_2);
        this.gVz = (ProgressBar) this.mView.findViewById(a.f.feed_video_item1_progressBar);
        this.gVD = (ProgressBar) this.mView.findViewById(a.f.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.gVs.setVisibility(i);
        this.gVt.setVisibility(i);
    }

    public void ad(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aGe != null) {
            if (this.aGe.mLiveInfo == null || this.aGe.mLiveInfo.mLiveCloseData == null) {
                setRecommendViewVisible(0);
                boolean z = arrayList.size() > 2;
                this.gVM = arrayList;
                this.gVL = 0;
                a(this.gVL, arrayList.get(this.gVL), this.gVL + 1, arrayList.get(this.gVL + 1), z);
                this.gVL++;
                if (this.animator == null) {
                    this.animator = ValueAnimator.ofInt(100, 0);
                    this.animator.setDuration(5000L);
                    this.animator.setInterpolator(gVk);
                    this.animator.setRepeatCount(-1);
                    this.animator.setRepeatMode(1);
                    this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            AlaLiveAudienceEndView.this.gVz.setProgress(intValue);
                            AlaLiveAudienceEndView.this.gVD.setProgress(intValue);
                        }
                    });
                    this.animator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.4
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                            AlaLiveAudienceEndView.this.bXU();
                        }
                    });
                }
                if (z) {
                    this.animator.start();
                    this.gVI.setVisibility(0);
                    this.gVI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aYx, AlaLiveAudienceEndView.this.mOtherParams);
                            AlaLiveAudienceEndView.this.animator.cancel();
                            AlaLiveAudienceEndView.this.bXU();
                            AlaLiveAudienceEndView.this.animator.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXU() {
        int i = this.gVL + 1;
        this.gVL = i;
        if (i >= this.gVM.size()) {
            this.gVL = 0;
            i = 0;
        }
        int i2 = this.gVL + 1;
        this.gVL = i2;
        if (i2 >= this.gVM.size()) {
            this.gVL = 0;
            i2 = 0;
        }
        this.gVL = i2;
        a(i, this.gVM.get(i), i2, this.gVM.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        a(this.gVu, this.gVw, this.gVx, this.gVy, this.gVz, this.oma, alaLiveInfoData, z, i);
        a(this.gVv, this.gVA, this.gVB, this.gVC, this.gVD, this.omb, alaLiveInfoData2, z, i2);
    }

    public void a(View view, TbImageView tbImageView, TextView textView, TextView textView2, ProgressBar progressBar, TextView textView3, final AlaLiveInfoData alaLiveInfoData, boolean z, int i) {
        if (alaLiveInfoData != null) {
            String str = alaLiveInfoData.cover;
            tbImageView.setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TextUtils.isEmpty(str)) {
                tbImageView.startLoad(str, 10, false);
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.mContext, a.h.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.olQ != null) {
                        AlaLiveAudienceEndView.this.olQ.f(alaLiveInfoData);
                    }
                }
            });
            textView.setText(alaLiveInfoData.room_name);
            textView2.setVisibility(8);
            if (z) {
                progressBar.setVisibility(0);
                progressBar.setProgress(0);
            } else {
                progressBar.setVisibility(8);
            }
            if (textView3 != null && alaLiveInfoData.corner_tag == 1) {
                textView3.setVisibility(0);
                textView3.setText(textView3.getContext().getResources().getString(a.h.yuyin_living));
                textView3.setBackgroundResource(a.e.shape_yuyin_living_bg);
            } else if (textView3 != null && alaLiveInfoData.corner_tag == 2) {
                textView3.setVisibility(0);
                textView3.setText(textView3.getContext().getResources().getString(a.h.yuyin_dating));
                textView3.setBackgroundResource(a.e.shape_yuyin_dating_bg);
            } else if (textView3 != null) {
                textView3.setVisibility(8);
            }
        }
    }

    public ViewGroup getRecParentView() {
        return this.gVs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXV() {
        if (this.mContext != null) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mContext);
            bdAlertDialog.setMessage(this.mContext.getResources().getString(a.h.yuyinala_live_end_dialog_nomore_attention_msg));
            bdAlertDialog.setNegativeButton(a.h.yuyinala_live_end_dialog_cancel_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.7
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setPositiveButton(a.h.yuyinala_live_end_dialog_confirm_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.8
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aYx, AlaLiveAudienceEndView.this.mOtherParams);
                    AlaLiveAudienceEndView.this.olQ.na(AlaLiveAudienceEndView.this.gVJ);
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                bdAlertDialog.setPositiveButtonTextColor(1714631475);
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
            } else {
                bdAlertDialog.setPositiveButtonTextColor(-13421773);
                bdAlertDialog.setNagetiveButtonTextColor(-13421773);
            }
            bdAlertDialog.create(this.mTbPageContext).show();
        }
    }

    public void onDestory() {
        if (this.animator != null) {
            this.animator.cancel();
        }
    }
}
