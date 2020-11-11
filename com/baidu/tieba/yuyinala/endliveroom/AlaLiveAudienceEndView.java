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
    private static final LinearInterpolator gAR = new LinearInterpolator();
    private w aES;
    private AlaLiveUserInfoData aJr;
    private String aVy;
    private Activity bNY;
    private TextView gAU;
    private LinearLayout gAZ;
    private LinearLayout gBa;
    private RelativeLayout gBb;
    private RelativeLayout gBc;
    private TbImageView gBd;
    private TextView gBe;
    private TextView gBf;
    private ProgressBar gBg;
    private TbImageView gBh;
    private TextView gBi;
    private TextView gBj;
    private ProgressBar gBk;
    private TextView gBl;
    private LinearLayout gBm;
    private TextView gBn;
    private TextView gBo;
    private View gBp;
    private boolean gBq;
    private boolean gBr;
    private int gBs;
    private ArrayList<AlaLiveInfoData> gBt;
    private ValueAnimator gBu;
    private Set<Long> gBv;
    private String liveId;
    private ImageView mCloseBtn;
    private AlaLiveInfoData mLiveInfo;
    private String mOtherParams;
    private String mPortrait;
    private TbPageContext mTbPageContext;
    private View mView;
    private a nTA;
    private BarImageView nTB;
    private TextView nTC;
    private TextView nTD;
    private TextView nTE;
    private TextView nTF;
    private TextView nTG;
    private TextView nTH;
    private LinearLayout nTI;
    private LinearLayout nTJ;
    private TextView nTK;
    private TextView nTL;
    private String roomId;

    /* loaded from: classes4.dex */
    public interface a {
        void NM();

        void f(AlaLiveInfoData alaLiveInfoData);

        void me(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.gBq = false;
        this.mPortrait = "";
        this.gBr = false;
        this.gBs = 0;
        this.gBv = new HashSet();
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_live_audience_end_view_layout, (ViewGroup) this, true);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.f.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.nTA != null) {
                    AlaLiveAudienceEndView.this.nTA.NM();
                }
            }
        });
        this.nTB = (BarImageView) this.mView.findViewById(a.f.avatar_img);
        this.gAU = (TextView) this.mView.findViewById(a.f.user_name);
        this.nTC = (TextView) this.mView.findViewById(a.f.tv_user_id);
        this.gBo = (TextView) this.mView.findViewById(a.f.endText_textView);
        this.nTD = (TextView) this.mView.findViewById(a.f.tv_live_end_newcharmnum);
        this.nTE = (TextView) this.mView.findViewById(a.f.tv_live_end_givernum);
        this.nTF = (TextView) this.mView.findViewById(a.f.tv_live_end_watchnum);
        this.nTG = (TextView) this.mView.findViewById(a.f.tv_live_end_newfansnum);
        this.nTH = (TextView) this.mView.findViewById(a.f.endText_textView_master);
        this.nTI = (LinearLayout) this.mView.findViewById(a.f.ll_master_bottomview);
        this.nTJ = (LinearLayout) this.mView.findViewById(a.f.ll_audience_bottomview);
        this.gBm = (LinearLayout) this.mView.findViewById(a.f.llFollowLabel);
        this.gBl = (TextView) this.mView.findViewById(a.f.follow_label);
        this.gBn = (TextView) this.mView.findViewById(a.f.live_over_name);
        bSi();
    }

    private void setUserTypeForView(boolean z) {
        if (z) {
            this.nTI.setVisibility(0);
            this.nTJ.setVisibility(8);
            return;
        }
        this.nTI.setVisibility(8);
        this.nTJ.setVisibility(0);
    }

    private void dXs() {
        this.nTF.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.familyFansCount));
        if (this.mLiveInfo.newFansCount < 0) {
            this.nTG.setText(String.valueOf(this.mLiveInfo.newFansCount));
        } else {
            this.nTG.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.newFansCount));
        }
        this.nTE.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.rewardUserCount));
        this.nTD.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.charm_count));
    }

    public void setCallback(a aVar) {
        this.nTA = aVar;
    }

    public void setData(TbPageContext tbPageContext, w wVar, boolean z, boolean z2, String str, String str2) {
        this.aES = wVar;
        this.gBr = z;
        this.mTbPageContext = tbPageContext;
        this.bNY = tbPageContext.getPageActivity();
        this.aES = wVar;
        this.mLiveInfo = wVar.mLiveInfo;
        this.aJr = wVar.aJr;
        this.gBq = z2;
        this.mPortrait = str;
        this.gBr = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aVy = this.mLiveInfo.feed_id;
        this.mOtherParams = str2;
        if (this.aVy == null || TextUtils.equals(this.aVy, "null")) {
            this.aVy = "";
        }
        if (this.mOtherParams == null || TextUtils.equals(this.mOtherParams, "null")) {
            this.mOtherParams = "";
        }
        this.nTB.setShowOval(true);
        this.nTB.setBorderColor(this.bNY.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.nTB.setAutoChangeStyle(false);
        this.nTB.setAccuracyWith(30.0f);
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.nTB.setDefaultResource(a.e.pic_avatar_moren);
        } else {
            this.nTB.startLoad(this.mPortrait, 12, false, false);
        }
        this.gAU.setText(this.aES.aJK.room_name);
        this.nTC.setText(this.bNY.getResources().getString(a.h.room_id_name) + wVar.aJK.croom_id);
        this.gBm.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aES != null && this.aES.mLiveInfo != null && this.aES.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aES.mLiveInfo.mLiveCloseData.title)) {
            this.gBn.setText(this.aES.mLiveInfo.mLiveCloseData.title);
        } else if (this.gBr) {
            this.gBn.setText(a.h.yuyin_live_closed);
        } else {
            this.gBn.setText(a.h.yuyin_live_over_name);
        }
        mf(this.gBq);
        if (this.aES != null && this.aES.mLiveInfo != null && this.aES.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aES.mLiveInfo.mLiveCloseData.title)) {
                this.gBn.setText(a.h.yuyin_live_over_name);
            } else {
                this.gBn.setText(this.aES.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.gBr) {
            this.gBn.setText(a.h.yuyin_live_closed);
        } else {
            this.gBn.setText(a.h.yuyin_live_over_name);
        }
        if (this.aJr.userType == 1 || this.aJr.userType == 2) {
            setUserTypeForView(true);
            dXs();
            if (TextUtils.isEmpty(this.mLiveInfo.close_reason)) {
                this.nTH.setVisibility(8);
                return;
            }
            this.nTH.setVisibility(0);
            this.nTH.setText(this.mLiveInfo.close_reason);
            return;
        }
        setUserTypeForView(false);
        this.gBm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aES == null || AlaLiveAudienceEndView.this.aES.mLiveInfo == null || AlaLiveAudienceEndView.this.aES.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.nTA != null) {
                        if (AlaLiveAudienceEndView.this.gBq) {
                            AlaLiveAudienceEndView.this.bSl();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aVy, AlaLiveAudienceEndView.this.mOtherParams);
                        AlaLiveAudienceEndView.this.nTA.me(AlaLiveAudienceEndView.this.gBq);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aES.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.bNY, AlaLiveAudienceEndView.this.aES.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
    }

    public void mf(boolean z) {
        this.gBq = z;
        if (this.aES != null && this.aES.mLiveInfo != null && this.aES.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aES.mLiveInfo.mLiveCloseData.tips)) {
                this.gBo.setText("");
            } else {
                this.gBo.setText(this.aES.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aES.mLiveInfo.mLiveCloseData.actionText)) {
                this.gBm.setVisibility(8);
                this.gBl.setText("");
            } else {
                this.gBm.setVisibility(0);
                this.gBl.setText(this.aES.mLiveInfo.mLiveCloseData.actionText);
                this.gBm.setBackgroundResource(a.e.round_btn_collection_highlight);
            }
            setRecommendViewVisible(8);
            return;
        }
        this.gBm.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.gBq) {
            this.gBo.setText(a.h.yuyin_endtext_followed);
            this.gBl.setText(a.h.yuyinala_live_end_view_followed);
            this.gBm.setBackgroundResource(a.e.round_btn_collection_lowlight);
            return;
        }
        this.gBo.setText(a.h.yuyin_endtext_follow);
        this.gBl.setText(a.h.yuyinala_live_end_view_follow);
        this.gBm.setBackgroundResource(a.e.round_btn_collection_highlight);
    }

    private void bSi() {
        this.gAZ = (LinearLayout) this.mView.findViewById(a.f.llFeedVideoLabel);
        this.gBa = (LinearLayout) this.mView.findViewById(a.f.video_audience_ll);
        this.gBp = this.mView.findViewById(a.f.change_layout);
        this.gBd = (TbImageView) this.mView.findViewById(a.f.feed_video_item1_cover);
        this.gBe = (TextView) this.mView.findViewById(a.f.feed_video_item1_name);
        this.gBf = (TextView) this.mView.findViewById(a.f.feed_video_item1_watch_num);
        this.nTK = (TextView) this.mView.findViewById(a.f.live_label_1);
        this.gBh = (TbImageView) this.mView.findViewById(a.f.feed_video_item2_cover);
        this.gBi = (TextView) this.mView.findViewById(a.f.feed_video_item2_name);
        this.gBj = (TextView) this.mView.findViewById(a.f.feed_video_item2_watch_num);
        this.nTL = (TextView) this.mView.findViewById(a.f.live_label_2);
        this.gBb = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_1);
        this.gBc = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_2);
        this.gBg = (ProgressBar) this.mView.findViewById(a.f.feed_video_item1_progressBar);
        this.gBk = (ProgressBar) this.mView.findViewById(a.f.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.gAZ.setVisibility(i);
        this.gBa.setVisibility(i);
    }

    public void ac(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aES != null) {
            if (this.aES.mLiveInfo == null || this.aES.mLiveInfo.mLiveCloseData == null) {
                setRecommendViewVisible(0);
                boolean z = arrayList.size() > 2;
                this.gBt = arrayList;
                this.gBs = 0;
                a(this.gBs, arrayList.get(this.gBs), this.gBs + 1, arrayList.get(this.gBs + 1), z);
                this.gBs++;
                if (this.gBu == null) {
                    this.gBu = ValueAnimator.ofInt(100, 0);
                    this.gBu.setDuration(5000L);
                    this.gBu.setInterpolator(gAR);
                    this.gBu.setRepeatCount(-1);
                    this.gBu.setRepeatMode(1);
                    this.gBu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            AlaLiveAudienceEndView.this.gBg.setProgress(intValue);
                            AlaLiveAudienceEndView.this.gBk.setProgress(intValue);
                        }
                    });
                    this.gBu.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.4
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                            AlaLiveAudienceEndView.this.bSk();
                        }
                    });
                }
                if (z) {
                    this.gBu.start();
                    this.gBp.setVisibility(0);
                    this.gBp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aVy, AlaLiveAudienceEndView.this.mOtherParams);
                            AlaLiveAudienceEndView.this.gBu.cancel();
                            AlaLiveAudienceEndView.this.bSk();
                            AlaLiveAudienceEndView.this.gBu.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSk() {
        int i = this.gBs + 1;
        this.gBs = i;
        if (i >= this.gBt.size()) {
            this.gBs = 0;
            i = 0;
        }
        int i2 = this.gBs + 1;
        this.gBs = i2;
        if (i2 >= this.gBt.size()) {
            this.gBs = 0;
            i2 = 0;
        }
        this.gBs = i2;
        a(i, this.gBt.get(i), i2, this.gBt.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        a(this.gBb, this.gBd, this.gBe, this.gBf, this.gBg, this.nTK, alaLiveInfoData, z, i);
        a(this.gBc, this.gBh, this.gBi, this.gBj, this.gBk, this.nTL, alaLiveInfoData2, z, i2);
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
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.bNY, a.h.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.nTA != null) {
                        AlaLiveAudienceEndView.this.nTA.f(alaLiveInfoData);
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
        return this.gAZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSl() {
        if (this.bNY != null) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.bNY);
            bdAlertDialog.setMessage(this.bNY.getResources().getString(a.h.yuyinala_live_end_dialog_nomore_attention_msg));
            bdAlertDialog.setNegativeButton(a.h.yuyinala_live_end_dialog_cancel_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.7
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setPositiveButton(a.h.yuyinala_live_end_dialog_confirm_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.8
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aVy, AlaLiveAudienceEndView.this.mOtherParams);
                    AlaLiveAudienceEndView.this.nTA.me(AlaLiveAudienceEndView.this.gBq);
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(this.bNY.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(this.bNY.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
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
        if (this.gBu != null) {
            this.gBu.cancel();
        }
    }
}
