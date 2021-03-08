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
import com.baidu.live.data.ab;
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
    private static final LinearInterpolator gVl = new LinearInterpolator();
    private ab aED;
    private AlaLiveUserInfoData aJZ;
    private String aYp;
    private ValueAnimator animator;
    private ProgressBar gVA;
    private TbImageView gVB;
    private TextView gVC;
    private TextView gVD;
    private ProgressBar gVE;
    private TextView gVF;
    private LinearLayout gVG;
    private TextView gVH;
    private TextView gVI;
    private View gVJ;
    private boolean gVK;
    private boolean gVL;
    private int gVM;
    private ArrayList<AlaLiveInfoData> gVN;
    private Set<Long> gVO;
    private TextView gVo;
    private LinearLayout gVt;
    private LinearLayout gVu;
    private RelativeLayout gVv;
    private RelativeLayout gVw;
    private TbImageView gVx;
    private TextView gVy;
    private TextView gVz;
    private String liveId;
    private ImageView mCloseBtn;
    private Activity mContext;
    private AlaLiveInfoData mLiveInfo;
    private String mOtherParams;
    private String mPortrait;
    private TbPageContext mTbPageContext;
    private View mView;
    private a otL;
    private BarImageView otM;
    private TextView otN;
    private TextView otO;
    private TextView otP;
    private TextView otQ;
    private TextView otR;
    private TextView otS;
    private LinearLayout otT;
    private LinearLayout otU;
    private TextView otV;
    private TextView otW;
    private String roomId;

    /* loaded from: classes10.dex */
    public interface a {
        void MP();

        void f(AlaLiveInfoData alaLiveInfoData);

        void nb(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.gVK = false;
        this.mPortrait = "";
        this.gVL = false;
        this.gVM = 0;
        this.gVO = new HashSet();
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_live_audience_end_view_layout, (ViewGroup) this, true);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.f.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.otL != null) {
                    AlaLiveAudienceEndView.this.otL.MP();
                }
            }
        });
        this.otM = (BarImageView) this.mView.findViewById(a.f.avatar_img);
        this.gVo = (TextView) this.mView.findViewById(a.f.user_name);
        this.otN = (TextView) this.mView.findViewById(a.f.tv_user_id);
        this.gVI = (TextView) this.mView.findViewById(a.f.endText_textView);
        this.otO = (TextView) this.mView.findViewById(a.f.tv_live_end_newcharmnum);
        this.otP = (TextView) this.mView.findViewById(a.f.tv_live_end_givernum);
        this.otQ = (TextView) this.mView.findViewById(a.f.tv_live_end_watchnum);
        this.otR = (TextView) this.mView.findViewById(a.f.tv_live_end_newfansnum);
        this.otS = (TextView) this.mView.findViewById(a.f.endText_textView_master);
        this.otT = (LinearLayout) this.mView.findViewById(a.f.ll_master_bottomview);
        this.otU = (LinearLayout) this.mView.findViewById(a.f.ll_audience_bottomview);
        this.gVG = (LinearLayout) this.mView.findViewById(a.f.llFollowLabel);
        this.gVF = (TextView) this.mView.findViewById(a.f.follow_label);
        this.gVH = (TextView) this.mView.findViewById(a.f.live_over_name);
        bUS();
    }

    private void setUserTypeForView(boolean z) {
        if (z) {
            this.otT.setVisibility(0);
            this.otU.setVisibility(8);
            return;
        }
        this.otT.setVisibility(8);
        this.otU.setVisibility(0);
    }

    private void eaC() {
        this.otQ.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.familyFansCount));
        if (this.mLiveInfo.newFansCount <= 0) {
            this.otR.setText(String.valueOf(this.mLiveInfo.newFansCount));
        } else {
            this.otR.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.newFansCount));
        }
        this.otP.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.rewardUserCount));
        this.otO.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.charm_count));
    }

    public void setCallback(a aVar) {
        this.otL = aVar;
    }

    public void setData(TbPageContext tbPageContext, ab abVar, boolean z, boolean z2, String str, String str2) {
        this.aED = abVar;
        this.gVL = z;
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.aED = abVar;
        this.mLiveInfo = abVar.mLiveInfo;
        this.aJZ = abVar.aJZ;
        this.gVK = z2;
        this.mPortrait = str;
        this.gVL = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aYp = this.mLiveInfo.feed_id;
        this.mOtherParams = str2;
        if (this.aYp == null || TextUtils.equals(this.aYp, "null")) {
            this.aYp = "";
        }
        if (this.mOtherParams == null || TextUtils.equals(this.mOtherParams, "null")) {
            this.mOtherParams = "";
        }
        this.otM.setShowOval(true);
        this.otM.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.otM.setAutoChangeStyle(false);
        this.otM.setAccuracyWith(30.0f);
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.otM.setDefaultResource(a.e.pic_avatar_moren);
        } else {
            this.otM.startLoad(this.mPortrait, 12, false, false);
        }
        this.gVo.setText(this.aED.aKu.room_name);
        this.otN.setText(this.mContext.getResources().getString(a.h.room_id_name) + abVar.aKu.croom_id);
        this.gVG.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aED != null && this.aED.mLiveInfo != null && this.aED.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aED.mLiveInfo.mLiveCloseData.title)) {
            this.gVH.setText(this.aED.mLiveInfo.mLiveCloseData.title);
        } else if (this.gVL) {
            this.gVH.setText(a.h.yuyin_live_closed);
        } else {
            this.gVH.setText(a.h.yuyin_live_over_name);
        }
        nc(this.gVK);
        if (this.aED != null && this.aED.mLiveInfo != null && this.aED.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aED.mLiveInfo.mLiveCloseData.title)) {
                this.gVH.setText(a.h.yuyin_live_over_name);
            } else {
                this.gVH.setText(this.aED.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.gVL) {
            this.gVH.setText(a.h.yuyin_live_closed);
        } else {
            this.gVH.setText(a.h.yuyin_live_over_name);
        }
        if (this.aJZ.userType == 1 || this.aJZ.userType == 2) {
            setUserTypeForView(true);
            eaC();
            if (TextUtils.isEmpty(this.mLiveInfo.close_reason)) {
                this.otS.setVisibility(8);
                return;
            }
            this.otS.setVisibility(0);
            this.otS.setText(this.mLiveInfo.close_reason);
            return;
        }
        setUserTypeForView(false);
        this.gVG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aED == null || AlaLiveAudienceEndView.this.aED.mLiveInfo == null || AlaLiveAudienceEndView.this.aED.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.otL != null) {
                        if (AlaLiveAudienceEndView.this.gVK) {
                            AlaLiveAudienceEndView.this.bUV();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aYp, AlaLiveAudienceEndView.this.mOtherParams);
                        AlaLiveAudienceEndView.this.otL.nb(AlaLiveAudienceEndView.this.gVK);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aED.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.mContext, AlaLiveAudienceEndView.this.aED.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
    }

    public void nc(boolean z) {
        this.gVK = z;
        if (this.aED != null && this.aED.mLiveInfo != null && this.aED.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aED.mLiveInfo.mLiveCloseData.tips)) {
                this.gVI.setText("");
            } else {
                this.gVI.setText(this.aED.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aED.mLiveInfo.mLiveCloseData.actionText)) {
                this.gVG.setVisibility(8);
                this.gVF.setText("");
            } else {
                this.gVG.setVisibility(0);
                this.gVF.setText(this.aED.mLiveInfo.mLiveCloseData.actionText);
                this.gVG.setBackgroundResource(a.e.round_btn_collection_highlight);
            }
            setRecommendViewVisible(8);
            return;
        }
        this.gVG.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.gVK) {
            this.gVI.setText(a.h.yuyin_endtext_followed);
            this.gVF.setText(a.h.yuyinala_live_end_view_followed);
            this.gVG.setBackgroundResource(a.e.round_btn_collection_lowlight);
            return;
        }
        this.gVI.setText(a.h.yuyin_endtext_follow);
        this.gVF.setText(a.h.yuyinala_live_end_view_follow);
        this.gVG.setBackgroundResource(a.e.round_btn_collection_highlight);
    }

    private void bUS() {
        this.gVt = (LinearLayout) this.mView.findViewById(a.f.llFeedVideoLabel);
        this.gVu = (LinearLayout) this.mView.findViewById(a.f.video_audience_ll);
        this.gVJ = this.mView.findViewById(a.f.change_layout);
        this.gVx = (TbImageView) this.mView.findViewById(a.f.feed_video_item1_cover);
        this.gVy = (TextView) this.mView.findViewById(a.f.feed_video_item1_name);
        this.gVz = (TextView) this.mView.findViewById(a.f.feed_video_item1_watch_num);
        this.otV = (TextView) this.mView.findViewById(a.f.live_label_1);
        this.gVB = (TbImageView) this.mView.findViewById(a.f.feed_video_item2_cover);
        this.gVC = (TextView) this.mView.findViewById(a.f.feed_video_item2_name);
        this.gVD = (TextView) this.mView.findViewById(a.f.feed_video_item2_watch_num);
        this.otW = (TextView) this.mView.findViewById(a.f.live_label_2);
        this.gVv = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_1);
        this.gVw = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_2);
        this.gVA = (ProgressBar) this.mView.findViewById(a.f.feed_video_item1_progressBar);
        this.gVE = (ProgressBar) this.mView.findViewById(a.f.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.gVt.setVisibility(i);
        this.gVu.setVisibility(i);
    }

    public void X(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aED != null) {
            if (this.aED.mLiveInfo == null || this.aED.mLiveInfo.mLiveCloseData == null) {
                setRecommendViewVisible(0);
                boolean z = arrayList.size() > 2;
                this.gVN = arrayList;
                this.gVM = 0;
                a(this.gVM, arrayList.get(this.gVM), this.gVM + 1, arrayList.get(this.gVM + 1), z);
                this.gVM++;
                if (this.animator == null) {
                    this.animator = ValueAnimator.ofInt(100, 0);
                    this.animator.setDuration(5000L);
                    this.animator.setInterpolator(gVl);
                    this.animator.setRepeatCount(-1);
                    this.animator.setRepeatMode(1);
                    this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            AlaLiveAudienceEndView.this.gVA.setProgress(intValue);
                            AlaLiveAudienceEndView.this.gVE.setProgress(intValue);
                        }
                    });
                    this.animator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.4
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                            AlaLiveAudienceEndView.this.bUU();
                        }
                    });
                }
                if (z) {
                    this.animator.start();
                    this.gVJ.setVisibility(0);
                    this.gVJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aYp, AlaLiveAudienceEndView.this.mOtherParams);
                            AlaLiveAudienceEndView.this.animator.cancel();
                            AlaLiveAudienceEndView.this.bUU();
                            AlaLiveAudienceEndView.this.animator.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUU() {
        int i = this.gVM + 1;
        this.gVM = i;
        if (i >= this.gVN.size()) {
            this.gVM = 0;
            i = 0;
        }
        int i2 = this.gVM + 1;
        this.gVM = i2;
        if (i2 >= this.gVN.size()) {
            this.gVM = 0;
            i2 = 0;
        }
        this.gVM = i2;
        a(i, this.gVN.get(i), i2, this.gVN.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        a(this.gVv, this.gVx, this.gVy, this.gVz, this.gVA, this.otV, alaLiveInfoData, z, i);
        a(this.gVw, this.gVB, this.gVC, this.gVD, this.gVE, this.otW, alaLiveInfoData2, z, i2);
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
                    } else if (AlaLiveAudienceEndView.this.otL != null) {
                        AlaLiveAudienceEndView.this.otL.f(alaLiveInfoData);
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
        return this.gVt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUV() {
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
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aYp, AlaLiveAudienceEndView.this.mOtherParams);
                    AlaLiveAudienceEndView.this.otL.nb(AlaLiveAudienceEndView.this.gVK);
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
