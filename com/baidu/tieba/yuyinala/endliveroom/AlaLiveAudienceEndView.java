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
    private static final LinearInterpolator gJx = new LinearInterpolator();
    private w aFN;
    private AlaLiveUserInfoData aKr;
    private String aWR;
    private Activity beD;
    private TextView gJA;
    private LinearLayout gJF;
    private LinearLayout gJG;
    private RelativeLayout gJH;
    private RelativeLayout gJI;
    private TbImageView gJJ;
    private TextView gJK;
    private TextView gJL;
    private ProgressBar gJM;
    private TbImageView gJN;
    private TextView gJO;
    private TextView gJP;
    private ProgressBar gJQ;
    private TextView gJR;
    private LinearLayout gJS;
    private TextView gJT;
    private TextView gJU;
    private View gJV;
    private boolean gJW;
    private boolean gJX;
    private int gJY;
    private ArrayList<AlaLiveInfoData> gJZ;
    private ValueAnimator gKa;
    private Set<Long> gKb;
    private String liveId;
    private ImageView mCloseBtn;
    private AlaLiveInfoData mLiveInfo;
    private String mOtherParams;
    private String mPortrait;
    private TbPageContext mTbPageContext;
    private View mView;
    private a okd;
    private BarImageView oke;
    private TextView okf;
    private TextView okg;
    private TextView okh;
    private TextView oki;
    private TextView okj;
    private TextView okk;
    private LinearLayout okl;
    private LinearLayout okm;
    private TextView okn;
    private TextView oko;
    private String roomId;

    /* loaded from: classes4.dex */
    public interface a {
        void Pv();

        void f(AlaLiveInfoData alaLiveInfoData);

        void mA(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.gJW = false;
        this.mPortrait = "";
        this.gJX = false;
        this.gJY = 0;
        this.gKb = new HashSet();
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_live_audience_end_view_layout, (ViewGroup) this, true);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.f.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.okd != null) {
                    AlaLiveAudienceEndView.this.okd.Pv();
                }
            }
        });
        this.oke = (BarImageView) this.mView.findViewById(a.f.avatar_img);
        this.gJA = (TextView) this.mView.findViewById(a.f.user_name);
        this.okf = (TextView) this.mView.findViewById(a.f.tv_user_id);
        this.gJU = (TextView) this.mView.findViewById(a.f.endText_textView);
        this.okg = (TextView) this.mView.findViewById(a.f.tv_live_end_newcharmnum);
        this.okh = (TextView) this.mView.findViewById(a.f.tv_live_end_givernum);
        this.oki = (TextView) this.mView.findViewById(a.f.tv_live_end_watchnum);
        this.okj = (TextView) this.mView.findViewById(a.f.tv_live_end_newfansnum);
        this.okk = (TextView) this.mView.findViewById(a.f.endText_textView_master);
        this.okl = (LinearLayout) this.mView.findViewById(a.f.ll_master_bottomview);
        this.okm = (LinearLayout) this.mView.findViewById(a.f.ll_audience_bottomview);
        this.gJS = (LinearLayout) this.mView.findViewById(a.f.llFollowLabel);
        this.gJR = (TextView) this.mView.findViewById(a.f.follow_label);
        this.gJT = (TextView) this.mView.findViewById(a.f.live_over_name);
        bVm();
    }

    private void setUserTypeForView(boolean z) {
        if (z) {
            this.okl.setVisibility(0);
            this.okm.setVisibility(8);
            return;
        }
        this.okl.setVisibility(8);
        this.okm.setVisibility(0);
    }

    private void ecW() {
        this.oki.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.familyFansCount));
        if (this.mLiveInfo.newFansCount <= 0) {
            this.okj.setText(String.valueOf(this.mLiveInfo.newFansCount));
        } else {
            this.okj.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.newFansCount));
        }
        this.okh.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.rewardUserCount));
        this.okg.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.charm_count));
    }

    public void setCallback(a aVar) {
        this.okd = aVar;
    }

    public void setData(TbPageContext tbPageContext, w wVar, boolean z, boolean z2, String str, String str2) {
        this.aFN = wVar;
        this.gJX = z;
        this.mTbPageContext = tbPageContext;
        this.beD = tbPageContext.getPageActivity();
        this.aFN = wVar;
        this.mLiveInfo = wVar.mLiveInfo;
        this.aKr = wVar.aKr;
        this.gJW = z2;
        this.mPortrait = str;
        this.gJX = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aWR = this.mLiveInfo.feed_id;
        this.mOtherParams = str2;
        if (this.aWR == null || TextUtils.equals(this.aWR, "null")) {
            this.aWR = "";
        }
        if (this.mOtherParams == null || TextUtils.equals(this.mOtherParams, "null")) {
            this.mOtherParams = "";
        }
        this.oke.setShowOval(true);
        this.oke.setBorderColor(this.beD.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.oke.setAutoChangeStyle(false);
        this.oke.setAccuracyWith(30.0f);
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.oke.setDefaultResource(a.e.pic_avatar_moren);
        } else {
            this.oke.startLoad(this.mPortrait, 12, false, false);
        }
        this.gJA.setText(this.aFN.aKL.room_name);
        this.okf.setText(this.beD.getResources().getString(a.h.room_id_name) + wVar.aKL.croom_id);
        this.gJS.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aFN != null && this.aFN.mLiveInfo != null && this.aFN.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aFN.mLiveInfo.mLiveCloseData.title)) {
            this.gJT.setText(this.aFN.mLiveInfo.mLiveCloseData.title);
        } else if (this.gJX) {
            this.gJT.setText(a.h.yuyin_live_closed);
        } else {
            this.gJT.setText(a.h.yuyin_live_over_name);
        }
        mB(this.gJW);
        if (this.aFN != null && this.aFN.mLiveInfo != null && this.aFN.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aFN.mLiveInfo.mLiveCloseData.title)) {
                this.gJT.setText(a.h.yuyin_live_over_name);
            } else {
                this.gJT.setText(this.aFN.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.gJX) {
            this.gJT.setText(a.h.yuyin_live_closed);
        } else {
            this.gJT.setText(a.h.yuyin_live_over_name);
        }
        if (this.aKr.userType == 1 || this.aKr.userType == 2) {
            setUserTypeForView(true);
            ecW();
            if (TextUtils.isEmpty(this.mLiveInfo.close_reason)) {
                this.okk.setVisibility(8);
                return;
            }
            this.okk.setVisibility(0);
            this.okk.setText(this.mLiveInfo.close_reason);
            return;
        }
        setUserTypeForView(false);
        this.gJS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aFN == null || AlaLiveAudienceEndView.this.aFN.mLiveInfo == null || AlaLiveAudienceEndView.this.aFN.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.okd != null) {
                        if (AlaLiveAudienceEndView.this.gJW) {
                            AlaLiveAudienceEndView.this.bVp();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWR, AlaLiveAudienceEndView.this.mOtherParams);
                        AlaLiveAudienceEndView.this.okd.mA(AlaLiveAudienceEndView.this.gJW);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aFN.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.beD, AlaLiveAudienceEndView.this.aFN.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
    }

    public void mB(boolean z) {
        this.gJW = z;
        if (this.aFN != null && this.aFN.mLiveInfo != null && this.aFN.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aFN.mLiveInfo.mLiveCloseData.tips)) {
                this.gJU.setText("");
            } else {
                this.gJU.setText(this.aFN.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aFN.mLiveInfo.mLiveCloseData.actionText)) {
                this.gJS.setVisibility(8);
                this.gJR.setText("");
            } else {
                this.gJS.setVisibility(0);
                this.gJR.setText(this.aFN.mLiveInfo.mLiveCloseData.actionText);
                this.gJS.setBackgroundResource(a.e.round_btn_collection_highlight);
            }
            setRecommendViewVisible(8);
            return;
        }
        this.gJS.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.gJW) {
            this.gJU.setText(a.h.yuyin_endtext_followed);
            this.gJR.setText(a.h.yuyinala_live_end_view_followed);
            this.gJS.setBackgroundResource(a.e.round_btn_collection_lowlight);
            return;
        }
        this.gJU.setText(a.h.yuyin_endtext_follow);
        this.gJR.setText(a.h.yuyinala_live_end_view_follow);
        this.gJS.setBackgroundResource(a.e.round_btn_collection_highlight);
    }

    private void bVm() {
        this.gJF = (LinearLayout) this.mView.findViewById(a.f.llFeedVideoLabel);
        this.gJG = (LinearLayout) this.mView.findViewById(a.f.video_audience_ll);
        this.gJV = this.mView.findViewById(a.f.change_layout);
        this.gJJ = (TbImageView) this.mView.findViewById(a.f.feed_video_item1_cover);
        this.gJK = (TextView) this.mView.findViewById(a.f.feed_video_item1_name);
        this.gJL = (TextView) this.mView.findViewById(a.f.feed_video_item1_watch_num);
        this.okn = (TextView) this.mView.findViewById(a.f.live_label_1);
        this.gJN = (TbImageView) this.mView.findViewById(a.f.feed_video_item2_cover);
        this.gJO = (TextView) this.mView.findViewById(a.f.feed_video_item2_name);
        this.gJP = (TextView) this.mView.findViewById(a.f.feed_video_item2_watch_num);
        this.oko = (TextView) this.mView.findViewById(a.f.live_label_2);
        this.gJH = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_1);
        this.gJI = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_2);
        this.gJM = (ProgressBar) this.mView.findViewById(a.f.feed_video_item1_progressBar);
        this.gJQ = (ProgressBar) this.mView.findViewById(a.f.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.gJF.setVisibility(i);
        this.gJG.setVisibility(i);
    }

    public void ad(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aFN != null) {
            if (this.aFN.mLiveInfo == null || this.aFN.mLiveInfo.mLiveCloseData == null) {
                setRecommendViewVisible(0);
                boolean z = arrayList.size() > 2;
                this.gJZ = arrayList;
                this.gJY = 0;
                a(this.gJY, arrayList.get(this.gJY), this.gJY + 1, arrayList.get(this.gJY + 1), z);
                this.gJY++;
                if (this.gKa == null) {
                    this.gKa = ValueAnimator.ofInt(100, 0);
                    this.gKa.setDuration(5000L);
                    this.gKa.setInterpolator(gJx);
                    this.gKa.setRepeatCount(-1);
                    this.gKa.setRepeatMode(1);
                    this.gKa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            AlaLiveAudienceEndView.this.gJM.setProgress(intValue);
                            AlaLiveAudienceEndView.this.gJQ.setProgress(intValue);
                        }
                    });
                    this.gKa.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.4
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                            AlaLiveAudienceEndView.this.bVo();
                        }
                    });
                }
                if (z) {
                    this.gKa.start();
                    this.gJV.setVisibility(0);
                    this.gJV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWR, AlaLiveAudienceEndView.this.mOtherParams);
                            AlaLiveAudienceEndView.this.gKa.cancel();
                            AlaLiveAudienceEndView.this.bVo();
                            AlaLiveAudienceEndView.this.gKa.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVo() {
        int i = this.gJY + 1;
        this.gJY = i;
        if (i >= this.gJZ.size()) {
            this.gJY = 0;
            i = 0;
        }
        int i2 = this.gJY + 1;
        this.gJY = i2;
        if (i2 >= this.gJZ.size()) {
            this.gJY = 0;
            i2 = 0;
        }
        this.gJY = i2;
        a(i, this.gJZ.get(i), i2, this.gJZ.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        a(this.gJH, this.gJJ, this.gJK, this.gJL, this.gJM, this.okn, alaLiveInfoData, z, i);
        a(this.gJI, this.gJN, this.gJO, this.gJP, this.gJQ, this.oko, alaLiveInfoData2, z, i2);
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
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.beD, a.h.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.okd != null) {
                        AlaLiveAudienceEndView.this.okd.f(alaLiveInfoData);
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
        return this.gJF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVp() {
        if (this.beD != null) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.beD);
            bdAlertDialog.setMessage(this.beD.getResources().getString(a.h.yuyinala_live_end_dialog_nomore_attention_msg));
            bdAlertDialog.setNegativeButton(a.h.yuyinala_live_end_dialog_cancel_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.7
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setPositiveButton(a.h.yuyinala_live_end_dialog_confirm_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.8
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWR, AlaLiveAudienceEndView.this.mOtherParams);
                    AlaLiveAudienceEndView.this.okd.mA(AlaLiveAudienceEndView.this.gJW);
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(this.beD.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(this.beD.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
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
        if (this.gKa != null) {
            this.gKa.cancel();
        }
    }
}
