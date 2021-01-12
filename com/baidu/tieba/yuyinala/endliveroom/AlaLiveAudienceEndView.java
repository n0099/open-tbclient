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
/* loaded from: classes10.dex */
public class AlaLiveAudienceEndView extends RelativeLayout {
    private static final LinearInterpolator gQE = new LinearInterpolator();
    private x aBr;
    private AlaLiveUserInfoData aGd;
    private String aTK;
    private ValueAnimator animator;
    private TextView gQH;
    private LinearLayout gQM;
    private LinearLayout gQN;
    private RelativeLayout gQO;
    private RelativeLayout gQP;
    private TbImageView gQQ;
    private TextView gQR;
    private TextView gQS;
    private ProgressBar gQT;
    private TbImageView gQU;
    private TextView gQV;
    private TextView gQW;
    private ProgressBar gQX;
    private TextView gQY;
    private LinearLayout gQZ;
    private TextView gRa;
    private TextView gRb;
    private View gRc;
    private boolean gRd;
    private boolean gRe;
    private int gRf;
    private ArrayList<AlaLiveInfoData> gRg;
    private Set<Long> gRh;
    private String liveId;
    private ImageView mCloseBtn;
    private Activity mContext;
    private AlaLiveInfoData mLiveInfo;
    private String mOtherParams;
    private String mPortrait;
    private TbPageContext mTbPageContext;
    private View mView;
    private a ohl;
    private BarImageView ohm;
    private TextView ohn;
    private TextView oho;
    private TextView ohp;
    private TextView ohq;
    private TextView ohr;
    private TextView ohs;
    private LinearLayout oht;
    private LinearLayout ohu;
    private TextView ohv;
    private TextView ohw;
    private String roomId;

    /* loaded from: classes10.dex */
    public interface a {
        void Lo();

        void f(AlaLiveInfoData alaLiveInfoData);

        void mW(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.gRd = false;
        this.mPortrait = "";
        this.gRe = false;
        this.gRf = 0;
        this.gRh = new HashSet();
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_live_audience_end_view_layout, (ViewGroup) this, true);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.f.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.ohl != null) {
                    AlaLiveAudienceEndView.this.ohl.Lo();
                }
            }
        });
        this.ohm = (BarImageView) this.mView.findViewById(a.f.avatar_img);
        this.gQH = (TextView) this.mView.findViewById(a.f.user_name);
        this.ohn = (TextView) this.mView.findViewById(a.f.tv_user_id);
        this.gRb = (TextView) this.mView.findViewById(a.f.endText_textView);
        this.oho = (TextView) this.mView.findViewById(a.f.tv_live_end_newcharmnum);
        this.ohp = (TextView) this.mView.findViewById(a.f.tv_live_end_givernum);
        this.ohq = (TextView) this.mView.findViewById(a.f.tv_live_end_watchnum);
        this.ohr = (TextView) this.mView.findViewById(a.f.tv_live_end_newfansnum);
        this.ohs = (TextView) this.mView.findViewById(a.f.endText_textView_master);
        this.oht = (LinearLayout) this.mView.findViewById(a.f.ll_master_bottomview);
        this.ohu = (LinearLayout) this.mView.findViewById(a.f.ll_audience_bottomview);
        this.gQZ = (LinearLayout) this.mView.findViewById(a.f.llFollowLabel);
        this.gQY = (TextView) this.mView.findViewById(a.f.follow_label);
        this.gRa = (TextView) this.mView.findViewById(a.f.live_over_name);
        bUa();
    }

    private void setUserTypeForView(boolean z) {
        if (z) {
            this.oht.setVisibility(0);
            this.ohu.setVisibility(8);
            return;
        }
        this.oht.setVisibility(8);
        this.ohu.setVisibility(0);
    }

    private void dYb() {
        this.ohq.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.familyFansCount));
        if (this.mLiveInfo.newFansCount <= 0) {
            this.ohr.setText(String.valueOf(this.mLiveInfo.newFansCount));
        } else {
            this.ohr.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.newFansCount));
        }
        this.ohp.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.rewardUserCount));
        this.oho.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.charm_count));
    }

    public void setCallback(a aVar) {
        this.ohl = aVar;
    }

    public void setData(TbPageContext tbPageContext, x xVar, boolean z, boolean z2, String str, String str2) {
        this.aBr = xVar;
        this.gRe = z;
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.aBr = xVar;
        this.mLiveInfo = xVar.mLiveInfo;
        this.aGd = xVar.aGd;
        this.gRd = z2;
        this.mPortrait = str;
        this.gRe = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aTK = this.mLiveInfo.feed_id;
        this.mOtherParams = str2;
        if (this.aTK == null || TextUtils.equals(this.aTK, "null")) {
            this.aTK = "";
        }
        if (this.mOtherParams == null || TextUtils.equals(this.mOtherParams, "null")) {
            this.mOtherParams = "";
        }
        this.ohm.setShowOval(true);
        this.ohm.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.ohm.setAutoChangeStyle(false);
        this.ohm.setAccuracyWith(30.0f);
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.ohm.setDefaultResource(a.e.pic_avatar_moren);
        } else {
            this.ohm.startLoad(this.mPortrait, 12, false, false);
        }
        this.gQH.setText(this.aBr.aGy.room_name);
        this.ohn.setText(this.mContext.getResources().getString(a.h.room_id_name) + xVar.aGy.croom_id);
        this.gQZ.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aBr != null && this.aBr.mLiveInfo != null && this.aBr.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aBr.mLiveInfo.mLiveCloseData.title)) {
            this.gRa.setText(this.aBr.mLiveInfo.mLiveCloseData.title);
        } else if (this.gRe) {
            this.gRa.setText(a.h.yuyin_live_closed);
        } else {
            this.gRa.setText(a.h.yuyin_live_over_name);
        }
        mX(this.gRd);
        if (this.aBr != null && this.aBr.mLiveInfo != null && this.aBr.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aBr.mLiveInfo.mLiveCloseData.title)) {
                this.gRa.setText(a.h.yuyin_live_over_name);
            } else {
                this.gRa.setText(this.aBr.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.gRe) {
            this.gRa.setText(a.h.yuyin_live_closed);
        } else {
            this.gRa.setText(a.h.yuyin_live_over_name);
        }
        if (this.aGd.userType == 1 || this.aGd.userType == 2) {
            setUserTypeForView(true);
            dYb();
            if (TextUtils.isEmpty(this.mLiveInfo.close_reason)) {
                this.ohs.setVisibility(8);
                return;
            }
            this.ohs.setVisibility(0);
            this.ohs.setText(this.mLiveInfo.close_reason);
            return;
        }
        setUserTypeForView(false);
        this.gQZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aBr == null || AlaLiveAudienceEndView.this.aBr.mLiveInfo == null || AlaLiveAudienceEndView.this.aBr.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.ohl != null) {
                        if (AlaLiveAudienceEndView.this.gRd) {
                            AlaLiveAudienceEndView.this.bUd();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aTK, AlaLiveAudienceEndView.this.mOtherParams);
                        AlaLiveAudienceEndView.this.ohl.mW(AlaLiveAudienceEndView.this.gRd);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aBr.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.mContext, AlaLiveAudienceEndView.this.aBr.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
    }

    public void mX(boolean z) {
        this.gRd = z;
        if (this.aBr != null && this.aBr.mLiveInfo != null && this.aBr.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aBr.mLiveInfo.mLiveCloseData.tips)) {
                this.gRb.setText("");
            } else {
                this.gRb.setText(this.aBr.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aBr.mLiveInfo.mLiveCloseData.actionText)) {
                this.gQZ.setVisibility(8);
                this.gQY.setText("");
            } else {
                this.gQZ.setVisibility(0);
                this.gQY.setText(this.aBr.mLiveInfo.mLiveCloseData.actionText);
                this.gQZ.setBackgroundResource(a.e.round_btn_collection_highlight);
            }
            setRecommendViewVisible(8);
            return;
        }
        this.gQZ.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.gRd) {
            this.gRb.setText(a.h.yuyin_endtext_followed);
            this.gQY.setText(a.h.yuyinala_live_end_view_followed);
            this.gQZ.setBackgroundResource(a.e.round_btn_collection_lowlight);
            return;
        }
        this.gRb.setText(a.h.yuyin_endtext_follow);
        this.gQY.setText(a.h.yuyinala_live_end_view_follow);
        this.gQZ.setBackgroundResource(a.e.round_btn_collection_highlight);
    }

    private void bUa() {
        this.gQM = (LinearLayout) this.mView.findViewById(a.f.llFeedVideoLabel);
        this.gQN = (LinearLayout) this.mView.findViewById(a.f.video_audience_ll);
        this.gRc = this.mView.findViewById(a.f.change_layout);
        this.gQQ = (TbImageView) this.mView.findViewById(a.f.feed_video_item1_cover);
        this.gQR = (TextView) this.mView.findViewById(a.f.feed_video_item1_name);
        this.gQS = (TextView) this.mView.findViewById(a.f.feed_video_item1_watch_num);
        this.ohv = (TextView) this.mView.findViewById(a.f.live_label_1);
        this.gQU = (TbImageView) this.mView.findViewById(a.f.feed_video_item2_cover);
        this.gQV = (TextView) this.mView.findViewById(a.f.feed_video_item2_name);
        this.gQW = (TextView) this.mView.findViewById(a.f.feed_video_item2_watch_num);
        this.ohw = (TextView) this.mView.findViewById(a.f.live_label_2);
        this.gQO = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_1);
        this.gQP = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_2);
        this.gQT = (ProgressBar) this.mView.findViewById(a.f.feed_video_item1_progressBar);
        this.gQX = (ProgressBar) this.mView.findViewById(a.f.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.gQM.setVisibility(i);
        this.gQN.setVisibility(i);
    }

    public void Y(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aBr != null) {
            if (this.aBr.mLiveInfo == null || this.aBr.mLiveInfo.mLiveCloseData == null) {
                setRecommendViewVisible(0);
                boolean z = arrayList.size() > 2;
                this.gRg = arrayList;
                this.gRf = 0;
                a(this.gRf, arrayList.get(this.gRf), this.gRf + 1, arrayList.get(this.gRf + 1), z);
                this.gRf++;
                if (this.animator == null) {
                    this.animator = ValueAnimator.ofInt(100, 0);
                    this.animator.setDuration(5000L);
                    this.animator.setInterpolator(gQE);
                    this.animator.setRepeatCount(-1);
                    this.animator.setRepeatMode(1);
                    this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            AlaLiveAudienceEndView.this.gQT.setProgress(intValue);
                            AlaLiveAudienceEndView.this.gQX.setProgress(intValue);
                        }
                    });
                    this.animator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.4
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                            AlaLiveAudienceEndView.this.bUc();
                        }
                    });
                }
                if (z) {
                    this.animator.start();
                    this.gRc.setVisibility(0);
                    this.gRc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aTK, AlaLiveAudienceEndView.this.mOtherParams);
                            AlaLiveAudienceEndView.this.animator.cancel();
                            AlaLiveAudienceEndView.this.bUc();
                            AlaLiveAudienceEndView.this.animator.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUc() {
        int i = this.gRf + 1;
        this.gRf = i;
        if (i >= this.gRg.size()) {
            this.gRf = 0;
            i = 0;
        }
        int i2 = this.gRf + 1;
        this.gRf = i2;
        if (i2 >= this.gRg.size()) {
            this.gRf = 0;
            i2 = 0;
        }
        this.gRf = i2;
        a(i, this.gRg.get(i), i2, this.gRg.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        a(this.gQO, this.gQQ, this.gQR, this.gQS, this.gQT, this.ohv, alaLiveInfoData, z, i);
        a(this.gQP, this.gQU, this.gQV, this.gQW, this.gQX, this.ohw, alaLiveInfoData2, z, i2);
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
                    } else if (AlaLiveAudienceEndView.this.ohl != null) {
                        AlaLiveAudienceEndView.this.ohl.f(alaLiveInfoData);
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
        return this.gQM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUd() {
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
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aTK, AlaLiveAudienceEndView.this.mOtherParams);
                    AlaLiveAudienceEndView.this.ohl.mW(AlaLiveAudienceEndView.this.gRd);
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
