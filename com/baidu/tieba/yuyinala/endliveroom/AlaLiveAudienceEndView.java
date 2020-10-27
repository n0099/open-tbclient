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
    private static final LinearInterpolator gvd = new LinearInterpolator();
    private w aEc;
    private AlaLiveUserInfoData aIA;
    private String aUg;
    private Activity bIs;
    private TextView gvA;
    private View gvB;
    private boolean gvC;
    private boolean gvD;
    private int gvE;
    private ArrayList<AlaLiveInfoData> gvF;
    private ValueAnimator gvG;
    private Set<Long> gvH;
    private TextView gvg;
    private LinearLayout gvl;
    private LinearLayout gvm;
    private RelativeLayout gvn;
    private RelativeLayout gvo;
    private TbImageView gvp;
    private TextView gvq;
    private TextView gvr;
    private ProgressBar gvs;
    private TbImageView gvt;
    private TextView gvu;
    private TextView gvv;
    private ProgressBar gvw;
    private TextView gvx;
    private LinearLayout gvy;
    private TextView gvz;
    private String liveId;
    private ImageView mCloseBtn;
    private AlaLiveInfoData mLiveInfo;
    private String mOtherParams;
    private String mPortrait;
    private TbPageContext mTbPageContext;
    private View mView;
    private a nNG;
    private BarImageView nNH;
    private TextView nNI;
    private TextView nNJ;
    private TextView nNK;
    private TextView nNL;
    private TextView nNM;
    private TextView nNN;
    private LinearLayout nNO;
    private LinearLayout nNP;
    private String roomId;

    /* loaded from: classes4.dex */
    public interface a {
        void Nm();

        void f(AlaLiveInfoData alaLiveInfoData);

        void lV(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.gvC = false;
        this.mPortrait = "";
        this.gvD = false;
        this.gvE = 0;
        this.gvH = new HashSet();
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.yuyinala_live_audience_end_view_layout, (ViewGroup) this, true);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.g.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.nNG != null) {
                    AlaLiveAudienceEndView.this.nNG.Nm();
                }
            }
        });
        this.nNH = (BarImageView) this.mView.findViewById(a.g.avatar_img);
        this.gvg = (TextView) this.mView.findViewById(a.g.user_name);
        this.nNI = (TextView) this.mView.findViewById(a.g.tv_user_id);
        this.gvA = (TextView) this.mView.findViewById(a.g.endText_textView);
        this.nNJ = (TextView) this.mView.findViewById(a.g.tv_live_end_newcharmnum);
        this.nNK = (TextView) this.mView.findViewById(a.g.tv_live_end_givernum);
        this.nNL = (TextView) this.mView.findViewById(a.g.tv_live_end_watchnum);
        this.nNM = (TextView) this.mView.findViewById(a.g.tv_live_end_newfansnum);
        this.nNN = (TextView) this.mView.findViewById(a.g.endText_textView_master);
        this.nNO = (LinearLayout) this.mView.findViewById(a.g.ll_master_bottomview);
        this.nNP = (LinearLayout) this.mView.findViewById(a.g.ll_audience_bottomview);
        this.gvy = (LinearLayout) this.mView.findViewById(a.g.llFollowLabel);
        this.gvx = (TextView) this.mView.findViewById(a.g.follow_label);
        this.gvz = (TextView) this.mView.findViewById(a.g.live_over_name);
        bPI();
    }

    private void setUserTypeForView(boolean z) {
        if (z) {
            this.nNO.setVisibility(0);
            this.nNP.setVisibility(8);
            return;
        }
        this.nNO.setVisibility(8);
        this.nNP.setVisibility(0);
    }

    private void dUS() {
        this.nNL.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.familyFansCount));
        if (this.mLiveInfo.newFansCount < 0) {
            this.nNM.setText(String.valueOf(this.mLiveInfo.newFansCount));
        } else {
            this.nNM.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.newFansCount));
        }
        this.nNK.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.rewardUserCount));
        this.nNJ.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.charm_count));
    }

    public void setCallback(a aVar) {
        this.nNG = aVar;
    }

    public void setData(TbPageContext tbPageContext, w wVar, boolean z, boolean z2, String str, String str2) {
        this.aEc = wVar;
        this.gvD = z;
        this.mTbPageContext = tbPageContext;
        this.bIs = tbPageContext.getPageActivity();
        this.aEc = wVar;
        this.mLiveInfo = wVar.mLiveInfo;
        this.aIA = wVar.aIA;
        this.gvC = z2;
        this.mPortrait = str;
        this.gvD = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aUg = this.mLiveInfo.feed_id;
        this.mOtherParams = str2;
        if (this.aUg == null || TextUtils.equals(this.aUg, "null")) {
            this.aUg = "";
        }
        if (this.mOtherParams == null || TextUtils.equals(this.mOtherParams, "null")) {
            this.mOtherParams = "";
        }
        this.nNH.setShowOval(true);
        this.nNH.setBorderColor(this.bIs.getResources().getColor(a.d.sdk_cp_bg_line_k_alpha10_1));
        this.nNH.setAutoChangeStyle(false);
        this.nNH.setAccuracyWith(30.0f);
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.nNH.setDefaultResource(a.f.pic_avatar_moren);
        } else {
            this.nNH.startLoad(this.mPortrait, 12, false, false);
        }
        this.gvg.setText(this.aEc.aIS.room_name);
        this.nNI.setText(this.bIs.getResources().getString(a.i.room_id_name) + wVar.aIS.croom_id);
        this.gvy.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aEc != null && this.aEc.mLiveInfo != null && this.aEc.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aEc.mLiveInfo.mLiveCloseData.title)) {
            this.gvz.setText(this.aEc.mLiveInfo.mLiveCloseData.title);
        } else if (this.gvD) {
            this.gvz.setText(a.i.yuyin_live_closed);
        } else {
            this.gvz.setText(a.i.yuyin_live_over_name);
        }
        lW(this.gvC);
        if (this.aEc != null && this.aEc.mLiveInfo != null && this.aEc.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aEc.mLiveInfo.mLiveCloseData.title)) {
                this.gvz.setText(a.i.yuyin_live_over_name);
            } else {
                this.gvz.setText(this.aEc.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.gvD) {
            this.gvz.setText(a.i.yuyin_live_closed);
        } else {
            this.gvz.setText(a.i.yuyin_live_over_name);
        }
        if (this.aIA.userType == 1 || this.aIA.userType == 2) {
            setUserTypeForView(true);
            dUS();
            if (TextUtils.isEmpty(this.mLiveInfo.close_reason)) {
                this.nNN.setVisibility(8);
                return;
            }
            this.nNN.setVisibility(0);
            this.nNN.setText(this.mLiveInfo.close_reason);
            return;
        }
        setUserTypeForView(false);
        this.gvy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aEc == null || AlaLiveAudienceEndView.this.aEc.mLiveInfo == null || AlaLiveAudienceEndView.this.aEc.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.nNG != null) {
                        if (AlaLiveAudienceEndView.this.gvC) {
                            AlaLiveAudienceEndView.this.bPL();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aUg, AlaLiveAudienceEndView.this.mOtherParams);
                        AlaLiveAudienceEndView.this.nNG.lV(AlaLiveAudienceEndView.this.gvC);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aEc.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.bIs, AlaLiveAudienceEndView.this.aEc.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
    }

    public void lW(boolean z) {
        this.gvC = z;
        if (this.aEc != null && this.aEc.mLiveInfo != null && this.aEc.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aEc.mLiveInfo.mLiveCloseData.tips)) {
                this.gvA.setText("");
            } else {
                this.gvA.setText(this.aEc.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aEc.mLiveInfo.mLiveCloseData.actionText)) {
                this.gvy.setVisibility(8);
                this.gvx.setText("");
            } else {
                this.gvy.setVisibility(0);
                this.gvx.setText(this.aEc.mLiveInfo.mLiveCloseData.actionText);
                this.gvy.setBackgroundResource(a.f.round_btn_collection_highlight);
            }
            setRecommendViewVisible(8);
            return;
        }
        this.gvy.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.gvC) {
            this.gvA.setText(a.i.yuyin_endtext_followed);
            this.gvx.setText(a.i.yuyinala_live_end_view_followed);
            this.gvy.setBackgroundResource(a.f.round_btn_collection_lowlight);
            return;
        }
        this.gvA.setText(a.i.yuyin_endtext_follow);
        this.gvx.setText(a.i.yuyinala_live_end_view_follow);
        this.gvy.setBackgroundResource(a.f.round_btn_collection_highlight);
    }

    private void bPI() {
        this.gvl = (LinearLayout) this.mView.findViewById(a.g.llFeedVideoLabel);
        this.gvm = (LinearLayout) this.mView.findViewById(a.g.video_audience_ll);
        this.gvB = this.mView.findViewById(a.g.change_layout);
        this.gvp = (TbImageView) this.mView.findViewById(a.g.feed_video_item1_cover);
        this.gvq = (TextView) this.mView.findViewById(a.g.feed_video_item1_name);
        this.gvr = (TextView) this.mView.findViewById(a.g.feed_video_item1_watch_num);
        this.gvt = (TbImageView) this.mView.findViewById(a.g.feed_video_item2_cover);
        this.gvu = (TextView) this.mView.findViewById(a.g.feed_video_item2_name);
        this.gvv = (TextView) this.mView.findViewById(a.g.feed_video_item2_watch_num);
        this.gvn = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_1);
        this.gvo = (RelativeLayout) this.mView.findViewById(a.g.rl_recom_video_cover_2);
        this.gvs = (ProgressBar) this.mView.findViewById(a.g.feed_video_item1_progressBar);
        this.gvw = (ProgressBar) this.mView.findViewById(a.g.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.gvl.setVisibility(i);
        this.gvm.setVisibility(i);
    }

    public void ac(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aEc != null) {
            if (this.aEc.mLiveInfo == null || this.aEc.mLiveInfo.mLiveCloseData == null) {
                setRecommendViewVisible(0);
                boolean z = arrayList.size() > 2;
                this.gvF = arrayList;
                this.gvE = 0;
                a(this.gvE, arrayList.get(this.gvE), this.gvE + 1, arrayList.get(this.gvE + 1), z);
                this.gvE++;
                if (this.gvG == null) {
                    this.gvG = ValueAnimator.ofInt(100, 0);
                    this.gvG.setDuration(5000L);
                    this.gvG.setInterpolator(gvd);
                    this.gvG.setRepeatCount(-1);
                    this.gvG.setRepeatMode(1);
                    this.gvG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            AlaLiveAudienceEndView.this.gvs.setProgress(intValue);
                            AlaLiveAudienceEndView.this.gvw.setProgress(intValue);
                        }
                    });
                    this.gvG.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.4
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                            AlaLiveAudienceEndView.this.bPK();
                        }
                    });
                }
                if (z) {
                    this.gvG.start();
                    this.gvB.setVisibility(0);
                    this.gvB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aUg, AlaLiveAudienceEndView.this.mOtherParams);
                            AlaLiveAudienceEndView.this.gvG.cancel();
                            AlaLiveAudienceEndView.this.bPK();
                            AlaLiveAudienceEndView.this.gvG.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPK() {
        int i = this.gvE + 1;
        this.gvE = i;
        if (i >= this.gvF.size()) {
            this.gvE = 0;
            i = 0;
        }
        int i2 = this.gvE + 1;
        this.gvE = i2;
        if (i2 >= this.gvF.size()) {
            this.gvE = 0;
            i2 = 0;
        }
        this.gvE = i2;
        a(i, this.gvF.get(i), i2, this.gvF.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        a(this.gvn, this.gvp, this.gvq, this.gvr, this.gvs, alaLiveInfoData, z, i);
        a(this.gvo, this.gvt, this.gvu, this.gvv, this.gvw, alaLiveInfoData2, z, i2);
    }

    public void a(View view, TbImageView tbImageView, TextView textView, TextView textView2, ProgressBar progressBar, final AlaLiveInfoData alaLiveInfoData, boolean z, int i) {
        if (alaLiveInfoData != null) {
            String str = alaLiveInfoData.cover;
            tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
            if (!TextUtils.isEmpty(str)) {
                tbImageView.startLoad(str, 10, false);
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        BdUtilHelper.showToast(AlaLiveAudienceEndView.this.bIs, a.i.sdk_no_network_guide);
                    } else if (AlaLiveAudienceEndView.this.nNG != null) {
                        AlaLiveAudienceEndView.this.nNG.f(alaLiveInfoData);
                    }
                }
            });
            textView.setText(alaLiveInfoData.room_name);
            textView2.setVisibility(8);
            if (z) {
                progressBar.setVisibility(0);
                progressBar.setProgress(0);
                return;
            }
            progressBar.setVisibility(8);
        }
    }

    public ViewGroup getRecParentView() {
        return this.gvl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPL() {
        if (this.bIs != null) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.bIs);
            bdAlertDialog.setMessage(this.bIs.getResources().getString(a.i.yuyinala_live_end_dialog_nomore_attention_msg));
            bdAlertDialog.setNegativeButton(a.i.yuyinala_live_end_dialog_cancel_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.7
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setPositiveButton(a.i.yuyinala_live_end_dialog_confirm_msg, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.8
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aUg, AlaLiveAudienceEndView.this.mOtherParams);
                    AlaLiveAudienceEndView.this.nNG.lV(AlaLiveAudienceEndView.this.gvC);
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(this.bIs.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(this.bIs.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
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
        if (this.gvG != null) {
            this.gvG.cancel();
        }
    }
}
