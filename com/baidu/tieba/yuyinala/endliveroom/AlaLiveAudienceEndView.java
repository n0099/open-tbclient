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
    private static final LinearInterpolator gJv = new LinearInterpolator();
    private w aFN;
    private AlaLiveUserInfoData aKr;
    private String aWR;
    private Activity beD;
    private LinearLayout gJD;
    private LinearLayout gJE;
    private RelativeLayout gJF;
    private RelativeLayout gJG;
    private TbImageView gJH;
    private TextView gJI;
    private TextView gJJ;
    private ProgressBar gJK;
    private TbImageView gJL;
    private TextView gJM;
    private TextView gJN;
    private ProgressBar gJO;
    private TextView gJP;
    private LinearLayout gJQ;
    private TextView gJR;
    private TextView gJS;
    private View gJT;
    private boolean gJU;
    private boolean gJV;
    private int gJW;
    private ArrayList<AlaLiveInfoData> gJX;
    private ValueAnimator gJY;
    private Set<Long> gJZ;
    private TextView gJy;
    private String liveId;
    private ImageView mCloseBtn;
    private AlaLiveInfoData mLiveInfo;
    private String mOtherParams;
    private String mPortrait;
    private TbPageContext mTbPageContext;
    private View mView;
    private a okb;
    private BarImageView okc;
    private TextView okd;
    private TextView oke;
    private TextView okf;
    private TextView okg;
    private TextView okh;
    private TextView oki;
    private LinearLayout okj;
    private LinearLayout okk;
    private TextView okl;
    private TextView okm;
    private String roomId;

    /* loaded from: classes4.dex */
    public interface a {
        void Pv();

        void f(AlaLiveInfoData alaLiveInfoData);

        void mA(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.gJU = false;
        this.mPortrait = "";
        this.gJV = false;
        this.gJW = 0;
        this.gJZ = new HashSet();
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_live_audience_end_view_layout, (ViewGroup) this, true);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.f.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.okb != null) {
                    AlaLiveAudienceEndView.this.okb.Pv();
                }
            }
        });
        this.okc = (BarImageView) this.mView.findViewById(a.f.avatar_img);
        this.gJy = (TextView) this.mView.findViewById(a.f.user_name);
        this.okd = (TextView) this.mView.findViewById(a.f.tv_user_id);
        this.gJS = (TextView) this.mView.findViewById(a.f.endText_textView);
        this.oke = (TextView) this.mView.findViewById(a.f.tv_live_end_newcharmnum);
        this.okf = (TextView) this.mView.findViewById(a.f.tv_live_end_givernum);
        this.okg = (TextView) this.mView.findViewById(a.f.tv_live_end_watchnum);
        this.okh = (TextView) this.mView.findViewById(a.f.tv_live_end_newfansnum);
        this.oki = (TextView) this.mView.findViewById(a.f.endText_textView_master);
        this.okj = (LinearLayout) this.mView.findViewById(a.f.ll_master_bottomview);
        this.okk = (LinearLayout) this.mView.findViewById(a.f.ll_audience_bottomview);
        this.gJQ = (LinearLayout) this.mView.findViewById(a.f.llFollowLabel);
        this.gJP = (TextView) this.mView.findViewById(a.f.follow_label);
        this.gJR = (TextView) this.mView.findViewById(a.f.live_over_name);
        bVl();
    }

    private void setUserTypeForView(boolean z) {
        if (z) {
            this.okj.setVisibility(0);
            this.okk.setVisibility(8);
            return;
        }
        this.okj.setVisibility(8);
        this.okk.setVisibility(0);
    }

    private void ecV() {
        this.okg.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.familyFansCount));
        if (this.mLiveInfo.newFansCount <= 0) {
            this.okh.setText(String.valueOf(this.mLiveInfo.newFansCount));
        } else {
            this.okh.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.newFansCount));
        }
        this.okf.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.rewardUserCount));
        this.oke.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.charm_count));
    }

    public void setCallback(a aVar) {
        this.okb = aVar;
    }

    public void setData(TbPageContext tbPageContext, w wVar, boolean z, boolean z2, String str, String str2) {
        this.aFN = wVar;
        this.gJV = z;
        this.mTbPageContext = tbPageContext;
        this.beD = tbPageContext.getPageActivity();
        this.aFN = wVar;
        this.mLiveInfo = wVar.mLiveInfo;
        this.aKr = wVar.aKr;
        this.gJU = z2;
        this.mPortrait = str;
        this.gJV = z;
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
        this.okc.setShowOval(true);
        this.okc.setBorderColor(this.beD.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.okc.setAutoChangeStyle(false);
        this.okc.setAccuracyWith(30.0f);
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.okc.setDefaultResource(a.e.pic_avatar_moren);
        } else {
            this.okc.startLoad(this.mPortrait, 12, false, false);
        }
        this.gJy.setText(this.aFN.aKL.room_name);
        this.okd.setText(this.beD.getResources().getString(a.h.room_id_name) + wVar.aKL.croom_id);
        this.gJQ.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aFN != null && this.aFN.mLiveInfo != null && this.aFN.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aFN.mLiveInfo.mLiveCloseData.title)) {
            this.gJR.setText(this.aFN.mLiveInfo.mLiveCloseData.title);
        } else if (this.gJV) {
            this.gJR.setText(a.h.yuyin_live_closed);
        } else {
            this.gJR.setText(a.h.yuyin_live_over_name);
        }
        mB(this.gJU);
        if (this.aFN != null && this.aFN.mLiveInfo != null && this.aFN.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aFN.mLiveInfo.mLiveCloseData.title)) {
                this.gJR.setText(a.h.yuyin_live_over_name);
            } else {
                this.gJR.setText(this.aFN.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.gJV) {
            this.gJR.setText(a.h.yuyin_live_closed);
        } else {
            this.gJR.setText(a.h.yuyin_live_over_name);
        }
        if (this.aKr.userType == 1 || this.aKr.userType == 2) {
            setUserTypeForView(true);
            ecV();
            if (TextUtils.isEmpty(this.mLiveInfo.close_reason)) {
                this.oki.setVisibility(8);
                return;
            }
            this.oki.setVisibility(0);
            this.oki.setText(this.mLiveInfo.close_reason);
            return;
        }
        setUserTypeForView(false);
        this.gJQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aFN == null || AlaLiveAudienceEndView.this.aFN.mLiveInfo == null || AlaLiveAudienceEndView.this.aFN.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.okb != null) {
                        if (AlaLiveAudienceEndView.this.gJU) {
                            AlaLiveAudienceEndView.this.bVo();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWR, AlaLiveAudienceEndView.this.mOtherParams);
                        AlaLiveAudienceEndView.this.okb.mA(AlaLiveAudienceEndView.this.gJU);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aFN.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.beD, AlaLiveAudienceEndView.this.aFN.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
    }

    public void mB(boolean z) {
        this.gJU = z;
        if (this.aFN != null && this.aFN.mLiveInfo != null && this.aFN.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aFN.mLiveInfo.mLiveCloseData.tips)) {
                this.gJS.setText("");
            } else {
                this.gJS.setText(this.aFN.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aFN.mLiveInfo.mLiveCloseData.actionText)) {
                this.gJQ.setVisibility(8);
                this.gJP.setText("");
            } else {
                this.gJQ.setVisibility(0);
                this.gJP.setText(this.aFN.mLiveInfo.mLiveCloseData.actionText);
                this.gJQ.setBackgroundResource(a.e.round_btn_collection_highlight);
            }
            setRecommendViewVisible(8);
            return;
        }
        this.gJQ.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.gJU) {
            this.gJS.setText(a.h.yuyin_endtext_followed);
            this.gJP.setText(a.h.yuyinala_live_end_view_followed);
            this.gJQ.setBackgroundResource(a.e.round_btn_collection_lowlight);
            return;
        }
        this.gJS.setText(a.h.yuyin_endtext_follow);
        this.gJP.setText(a.h.yuyinala_live_end_view_follow);
        this.gJQ.setBackgroundResource(a.e.round_btn_collection_highlight);
    }

    private void bVl() {
        this.gJD = (LinearLayout) this.mView.findViewById(a.f.llFeedVideoLabel);
        this.gJE = (LinearLayout) this.mView.findViewById(a.f.video_audience_ll);
        this.gJT = this.mView.findViewById(a.f.change_layout);
        this.gJH = (TbImageView) this.mView.findViewById(a.f.feed_video_item1_cover);
        this.gJI = (TextView) this.mView.findViewById(a.f.feed_video_item1_name);
        this.gJJ = (TextView) this.mView.findViewById(a.f.feed_video_item1_watch_num);
        this.okl = (TextView) this.mView.findViewById(a.f.live_label_1);
        this.gJL = (TbImageView) this.mView.findViewById(a.f.feed_video_item2_cover);
        this.gJM = (TextView) this.mView.findViewById(a.f.feed_video_item2_name);
        this.gJN = (TextView) this.mView.findViewById(a.f.feed_video_item2_watch_num);
        this.okm = (TextView) this.mView.findViewById(a.f.live_label_2);
        this.gJF = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_1);
        this.gJG = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_2);
        this.gJK = (ProgressBar) this.mView.findViewById(a.f.feed_video_item1_progressBar);
        this.gJO = (ProgressBar) this.mView.findViewById(a.f.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.gJD.setVisibility(i);
        this.gJE.setVisibility(i);
    }

    public void ad(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aFN != null) {
            if (this.aFN.mLiveInfo == null || this.aFN.mLiveInfo.mLiveCloseData == null) {
                setRecommendViewVisible(0);
                boolean z = arrayList.size() > 2;
                this.gJX = arrayList;
                this.gJW = 0;
                a(this.gJW, arrayList.get(this.gJW), this.gJW + 1, arrayList.get(this.gJW + 1), z);
                this.gJW++;
                if (this.gJY == null) {
                    this.gJY = ValueAnimator.ofInt(100, 0);
                    this.gJY.setDuration(5000L);
                    this.gJY.setInterpolator(gJv);
                    this.gJY.setRepeatCount(-1);
                    this.gJY.setRepeatMode(1);
                    this.gJY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            AlaLiveAudienceEndView.this.gJK.setProgress(intValue);
                            AlaLiveAudienceEndView.this.gJO.setProgress(intValue);
                        }
                    });
                    this.gJY.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.4
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                            AlaLiveAudienceEndView.this.bVn();
                        }
                    });
                }
                if (z) {
                    this.gJY.start();
                    this.gJT.setVisibility(0);
                    this.gJT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWR, AlaLiveAudienceEndView.this.mOtherParams);
                            AlaLiveAudienceEndView.this.gJY.cancel();
                            AlaLiveAudienceEndView.this.bVn();
                            AlaLiveAudienceEndView.this.gJY.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVn() {
        int i = this.gJW + 1;
        this.gJW = i;
        if (i >= this.gJX.size()) {
            this.gJW = 0;
            i = 0;
        }
        int i2 = this.gJW + 1;
        this.gJW = i2;
        if (i2 >= this.gJX.size()) {
            this.gJW = 0;
            i2 = 0;
        }
        this.gJW = i2;
        a(i, this.gJX.get(i), i2, this.gJX.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        a(this.gJF, this.gJH, this.gJI, this.gJJ, this.gJK, this.okl, alaLiveInfoData, z, i);
        a(this.gJG, this.gJL, this.gJM, this.gJN, this.gJO, this.okm, alaLiveInfoData2, z, i2);
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
                    } else if (AlaLiveAudienceEndView.this.okb != null) {
                        AlaLiveAudienceEndView.this.okb.f(alaLiveInfoData);
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
        return this.gJD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVo() {
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
                    AlaLiveAudienceEndView.this.okb.mA(AlaLiveAudienceEndView.this.gJU);
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
        if (this.gJY != null) {
            this.gJY.cancel();
        }
    }
}
