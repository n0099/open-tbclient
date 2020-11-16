package com.baidu.tieba.yuyinala.endliveroom;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
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
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.w;
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
/* loaded from: classes4.dex */
public class AlaLiveAudienceEndView extends RelativeLayout {
    private static final LinearInterpolator gAy = new LinearInterpolator();
    private w aDh;
    private AlaLiveUserInfoData aHG;
    private String aTN;
    private Activity bMo;
    private TextView gAB;
    private LinearLayout gAG;
    private LinearLayout gAH;
    private RelativeLayout gAI;
    private RelativeLayout gAJ;
    private TbImageView gAK;
    private TextView gAL;
    private TextView gAM;
    private ProgressBar gAN;
    private TbImageView gAO;
    private TextView gAP;
    private TextView gAQ;
    private ProgressBar gAR;
    private TextView gAS;
    private LinearLayout gAT;
    private TextView gAU;
    private TextView gAV;
    private View gAW;
    private boolean gAX;
    private boolean gAY;
    private int gAZ;
    private ArrayList<AlaLiveInfoData> gBa;
    private ValueAnimator gBb;
    private Set<Long> gBc;
    private String liveId;
    private ImageView mCloseBtn;
    private AlaLiveInfoData mLiveInfo;
    private String mOtherParams;
    private String mPortrait;
    private TbPageContext mTbPageContext;
    private View mView;
    private a nVd;
    private BarImageView nVe;
    private TextView nVf;
    private TextView nVg;
    private TextView nVh;
    private TextView nVi;
    private TextView nVj;
    private TextView nVk;
    private LinearLayout nVl;
    private LinearLayout nVm;
    private TextView nVn;
    private TextView nVo;
    private String roomId;

    /* loaded from: classes4.dex */
    public interface a {
        void Nd();

        void f(AlaLiveInfoData alaLiveInfoData);

        void mf(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.gAX = false;
        this.mPortrait = "";
        this.gAY = false;
        this.gAZ = 0;
        this.gBc = new HashSet();
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_live_audience_end_view_layout, (ViewGroup) this, true);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.f.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.nVd != null) {
                    AlaLiveAudienceEndView.this.nVd.Nd();
                }
            }
        });
        this.nVe = (BarImageView) this.mView.findViewById(a.f.avatar_img);
        this.gAB = (TextView) this.mView.findViewById(a.f.user_name);
        this.nVf = (TextView) this.mView.findViewById(a.f.tv_user_id);
        this.gAV = (TextView) this.mView.findViewById(a.f.endText_textView);
        this.nVg = (TextView) this.mView.findViewById(a.f.tv_live_end_newcharmnum);
        this.nVh = (TextView) this.mView.findViewById(a.f.tv_live_end_givernum);
        this.nVi = (TextView) this.mView.findViewById(a.f.tv_live_end_watchnum);
        this.nVj = (TextView) this.mView.findViewById(a.f.tv_live_end_newfansnum);
        this.nVk = (TextView) this.mView.findViewById(a.f.endText_textView_master);
        this.nVl = (LinearLayout) this.mView.findViewById(a.f.ll_master_bottomview);
        this.nVm = (LinearLayout) this.mView.findViewById(a.f.ll_audience_bottomview);
        this.gAT = (LinearLayout) this.mView.findViewById(a.f.llFollowLabel);
        this.gAS = (TextView) this.mView.findViewById(a.f.follow_label);
        this.gAU = (TextView) this.mView.findViewById(a.f.live_over_name);
        bRB();
    }

    private void setUserTypeForView(boolean z) {
        if (z) {
            this.nVl.setVisibility(0);
            this.nVm.setVisibility(8);
            return;
        }
        this.nVl.setVisibility(8);
        this.nVm.setVisibility(0);
    }

    private void dXr() {
        this.nVi.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.familyFansCount));
        if (this.mLiveInfo.newFansCount < 0) {
            this.nVj.setText(String.valueOf(this.mLiveInfo.newFansCount));
        } else {
            this.nVj.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.newFansCount));
        }
        this.nVh.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.rewardUserCount));
        this.nVg.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.charm_count));
    }

    public void setCallback(a aVar) {
        this.nVd = aVar;
    }

    public void setData(TbPageContext tbPageContext, w wVar, boolean z, boolean z2, String str, String str2) {
        this.aDh = wVar;
        this.gAY = z;
        this.mTbPageContext = tbPageContext;
        this.bMo = tbPageContext.getPageActivity();
        this.aDh = wVar;
        this.mLiveInfo = wVar.mLiveInfo;
        this.aHG = wVar.aHG;
        this.gAX = z2;
        this.mPortrait = str;
        this.gAY = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aTN = this.mLiveInfo.feed_id;
        this.mOtherParams = str2;
        if (this.aTN == null || TextUtils.equals(this.aTN, "null")) {
            this.aTN = "";
        }
        if (this.mOtherParams == null || TextUtils.equals(this.mOtherParams, "null")) {
            this.mOtherParams = "";
        }
        this.nVe.setShowOval(true);
        this.nVe.setBorderColor(this.bMo.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.nVe.setAutoChangeStyle(false);
        this.nVe.setAccuracyWith(30.0f);
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.nVe.setDefaultResource(a.e.pic_avatar_moren);
        } else {
            this.nVe.startLoad(this.mPortrait, 12, false, false);
        }
        this.gAB.setText(this.aDh.aHZ.room_name);
        this.nVf.setText(this.bMo.getResources().getString(a.h.room_id_name) + wVar.aHZ.croom_id);
        this.gAT.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aDh != null && this.aDh.mLiveInfo != null && this.aDh.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aDh.mLiveInfo.mLiveCloseData.title)) {
            this.gAU.setText(this.aDh.mLiveInfo.mLiveCloseData.title);
        } else if (this.gAY) {
            this.gAU.setText(a.h.yuyin_live_closed);
        } else {
            this.gAU.setText(a.h.yuyin_live_over_name);
        }
        mg(this.gAX);
        if (this.aDh != null && this.aDh.mLiveInfo != null && this.aDh.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aDh.mLiveInfo.mLiveCloseData.title)) {
                this.gAU.setText(a.h.yuyin_live_over_name);
            } else {
                this.gAU.setText(this.aDh.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.gAY) {
            this.gAU.setText(a.h.yuyin_live_closed);
        } else {
            this.gAU.setText(a.h.yuyin_live_over_name);
        }
        if (this.aHG.userType == 1 || this.aHG.userType == 2) {
            setUserTypeForView(true);
            dXr();
            if (TextUtils.isEmpty(this.mLiveInfo.close_reason)) {
                this.nVk.setVisibility(8);
                return;
            }
            this.nVk.setVisibility(0);
            this.nVk.setText(this.mLiveInfo.close_reason);
            return;
        }
        setUserTypeForView(false);
        this.gAT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aDh == null || AlaLiveAudienceEndView.this.aDh.mLiveInfo == null || AlaLiveAudienceEndView.this.aDh.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.nVd != null) {
                        if (AlaLiveAudienceEndView.this.gAX) {
                            AlaLiveAudienceEndView.this.bRE();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aTN, AlaLiveAudienceEndView.this.mOtherParams);
                        AlaLiveAudienceEndView.this.nVd.mf(AlaLiveAudienceEndView.this.gAX);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aDh.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.bMo, AlaLiveAudienceEndView.this.aDh.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
    }

    public void mg(boolean z) {
        this.gAX = z;
        if (this.aDh != null && this.aDh.mLiveInfo != null && this.aDh.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aDh.mLiveInfo.mLiveCloseData.tips)) {
                this.gAV.setText("");
            } else {
                this.gAV.setText(this.aDh.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aDh.mLiveInfo.mLiveCloseData.actionText)) {
                this.gAT.setVisibility(8);
                this.gAS.setText("");
            } else {
                this.gAT.setVisibility(0);
                this.gAS.setText(this.aDh.mLiveInfo.mLiveCloseData.actionText);
                this.gAT.setBackgroundResource(a.e.round_btn_collection_highlight);
            }
            setRecommendViewVisible(8);
            return;
        }
        this.gAT.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.gAX) {
            this.gAV.setText(a.h.yuyin_endtext_followed);
            this.gAS.setText(a.h.yuyinala_live_end_view_followed);
            this.gAT.setBackgroundResource(a.e.round_btn_collection_lowlight);
            return;
        }
        this.gAV.setText(a.h.yuyin_endtext_follow);
        this.gAS.setText(a.h.yuyinala_live_end_view_follow);
        this.gAT.setBackgroundResource(a.e.round_btn_collection_highlight);
    }

    private void bRB() {
        this.gAG = (LinearLayout) this.mView.findViewById(a.f.llFeedVideoLabel);
        this.gAH = (LinearLayout) this.mView.findViewById(a.f.video_audience_ll);
        this.gAW = this.mView.findViewById(a.f.change_layout);
        this.gAK = (TbImageView) this.mView.findViewById(a.f.feed_video_item1_cover);
        this.gAL = (TextView) this.mView.findViewById(a.f.feed_video_item1_name);
        this.gAM = (TextView) this.mView.findViewById(a.f.feed_video_item1_watch_num);
        this.nVn = (TextView) this.mView.findViewById(a.f.live_label_1);
        this.gAO = (TbImageView) this.mView.findViewById(a.f.feed_video_item2_cover);
        this.gAP = (TextView) this.mView.findViewById(a.f.feed_video_item2_name);
        this.gAQ = (TextView) this.mView.findViewById(a.f.feed_video_item2_watch_num);
        this.nVo = (TextView) this.mView.findViewById(a.f.live_label_2);
        this.gAI = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_1);
        this.gAJ = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_2);
        this.gAN = (ProgressBar) this.mView.findViewById(a.f.feed_video_item1_progressBar);
        this.gAR = (ProgressBar) this.mView.findViewById(a.f.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.gAG.setVisibility(i);
        this.gAH.setVisibility(i);
    }

    public void ac(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aDh != null) {
            if (this.aDh.mLiveInfo == null || this.aDh.mLiveInfo.mLiveCloseData == null) {
                setRecommendViewVisible(0);
                boolean z = arrayList.size() > 2;
                this.gBa = arrayList;
                this.gAZ = 0;
                a(this.gAZ, arrayList.get(this.gAZ), this.gAZ + 1, arrayList.get(this.gAZ + 1), z);
                this.gAZ++;
                if (this.gBb == null) {
                    this.gBb = ValueAnimator.ofInt(100, 0);
                    this.gBb.setDuration(5000L);
                    this.gBb.setInterpolator(gAy);
                    this.gBb.setRepeatCount(-1);
                    this.gBb.setRepeatMode(1);
                    this.gBb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            AlaLiveAudienceEndView.this.gAN.setProgress(intValue);
                            AlaLiveAudienceEndView.this.gAR.setProgress(intValue);
                        }
                    });
                    this.gBb.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.4
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                            AlaLiveAudienceEndView.this.bRD();
                        }
                    });
                }
                if (z) {
                    this.gBb.start();
                    this.gAW.setVisibility(0);
                    this.gAW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aTN, AlaLiveAudienceEndView.this.mOtherParams);
                            AlaLiveAudienceEndView.this.gBb.cancel();
                            AlaLiveAudienceEndView.this.bRD();
                            AlaLiveAudienceEndView.this.gBb.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRD() {
        int i = this.gAZ + 1;
        this.gAZ = i;
        if (i >= this.gBa.size()) {
            this.gAZ = 0;
            i = 0;
        }
        int i2 = this.gAZ + 1;
        this.gAZ = i2;
        if (i2 >= this.gBa.size()) {
            this.gAZ = 0;
            i2 = 0;
        }
        this.gAZ = i2;
        a(i, this.gBa.get(i), i2, this.gBa.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        a(this.gAI, this.gAK, this.gAL, this.gAM, this.gAN, this.nVn, alaLiveInfoData, z, i);
        a(this.gAJ, this.gAO, this.gAP, this.gAQ, this.gAR, this.nVo, alaLiveInfoData2, z, i2);
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
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.bMo, a.h.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.nVd != null) {
                        AlaLiveAudienceEndView.this.nVd.f(alaLiveInfoData);
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
        return this.gAG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRE() {
        if (this.bMo != null) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.bMo);
            bdAlertDialog.setMessage(this.bMo.getResources().getString(a.h.yuyinala_live_end_dialog_nomore_attention_msg));
            bdAlertDialog.setNegativeButton(a.h.yuyinala_live_end_dialog_cancel_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.7
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setPositiveButton(a.h.yuyinala_live_end_dialog_confirm_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.8
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aTN, AlaLiveAudienceEndView.this.mOtherParams);
                    AlaLiveAudienceEndView.this.nVd.mf(AlaLiveAudienceEndView.this.gAX);
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(this.bMo.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(this.bMo.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
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
        if (this.gBb != null) {
            this.gBb.cancel();
        }
    }
}
