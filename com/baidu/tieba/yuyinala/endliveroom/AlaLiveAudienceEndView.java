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
/* loaded from: classes11.dex */
public class AlaLiveAudienceEndView extends RelativeLayout {
    private static final LinearInterpolator gTo = new LinearInterpolator();
    private ab aDd;
    private AlaLiveUserInfoData aIz;
    private String aWP;
    private ValueAnimator animator;
    private TbImageView gTA;
    private TextView gTB;
    private TextView gTC;
    private ProgressBar gTD;
    private TbImageView gTE;
    private TextView gTF;
    private TextView gTG;
    private ProgressBar gTH;
    private TextView gTI;
    private LinearLayout gTJ;
    private TextView gTK;
    private TextView gTL;
    private View gTM;
    private boolean gTN;
    private boolean gTO;
    private int gTP;
    private ArrayList<AlaLiveInfoData> gTQ;
    private Set<Long> gTR;
    private TextView gTr;
    private LinearLayout gTw;
    private LinearLayout gTx;
    private RelativeLayout gTy;
    private RelativeLayout gTz;
    private String liveId;
    private ImageView mCloseBtn;
    private Activity mContext;
    private AlaLiveInfoData mLiveInfo;
    private String mOtherParams;
    private String mPortrait;
    private TbPageContext mTbPageContext;
    private View mView;
    private a orf;
    private BarImageView orh;
    private TextView ori;
    private TextView orj;
    private TextView ork;
    private TextView orl;
    private TextView orm;
    private TextView orn;
    private LinearLayout oro;
    private LinearLayout orp;
    private TextView orq;
    private TextView orr;
    private String roomId;

    /* loaded from: classes11.dex */
    public interface a {
        void MM();

        void f(AlaLiveInfoData alaLiveInfoData);

        void nb(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.gTN = false;
        this.mPortrait = "";
        this.gTO = false;
        this.gTP = 0;
        this.gTR = new HashSet();
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_live_audience_end_view_layout, (ViewGroup) this, true);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.f.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.orf != null) {
                    AlaLiveAudienceEndView.this.orf.MM();
                }
            }
        });
        this.orh = (BarImageView) this.mView.findViewById(a.f.avatar_img);
        this.gTr = (TextView) this.mView.findViewById(a.f.user_name);
        this.ori = (TextView) this.mView.findViewById(a.f.tv_user_id);
        this.gTL = (TextView) this.mView.findViewById(a.f.endText_textView);
        this.orj = (TextView) this.mView.findViewById(a.f.tv_live_end_newcharmnum);
        this.ork = (TextView) this.mView.findViewById(a.f.tv_live_end_givernum);
        this.orl = (TextView) this.mView.findViewById(a.f.tv_live_end_watchnum);
        this.orm = (TextView) this.mView.findViewById(a.f.tv_live_end_newfansnum);
        this.orn = (TextView) this.mView.findViewById(a.f.endText_textView_master);
        this.oro = (LinearLayout) this.mView.findViewById(a.f.ll_master_bottomview);
        this.orp = (LinearLayout) this.mView.findViewById(a.f.ll_audience_bottomview);
        this.gTJ = (LinearLayout) this.mView.findViewById(a.f.llFollowLabel);
        this.gTI = (TextView) this.mView.findViewById(a.f.follow_label);
        this.gTK = (TextView) this.mView.findViewById(a.f.live_over_name);
        bUF();
    }

    private void setUserTypeForView(boolean z) {
        if (z) {
            this.oro.setVisibility(0);
            this.orp.setVisibility(8);
            return;
        }
        this.oro.setVisibility(8);
        this.orp.setVisibility(0);
    }

    private void eam() {
        this.orl.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.familyFansCount));
        if (this.mLiveInfo.newFansCount <= 0) {
            this.orm.setText(String.valueOf(this.mLiveInfo.newFansCount));
        } else {
            this.orm.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.newFansCount));
        }
        this.ork.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.rewardUserCount));
        this.orj.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.charm_count));
    }

    public void setCallback(a aVar) {
        this.orf = aVar;
    }

    public void setData(TbPageContext tbPageContext, ab abVar, boolean z, boolean z2, String str, String str2) {
        this.aDd = abVar;
        this.gTO = z;
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.aDd = abVar;
        this.mLiveInfo = abVar.mLiveInfo;
        this.aIz = abVar.aIz;
        this.gTN = z2;
        this.mPortrait = str;
        this.gTO = z;
        this.liveId = this.mLiveInfo.live_id + "";
        this.roomId = this.mLiveInfo.room_id + "";
        this.aWP = this.mLiveInfo.feed_id;
        this.mOtherParams = str2;
        if (this.aWP == null || TextUtils.equals(this.aWP, "null")) {
            this.aWP = "";
        }
        if (this.mOtherParams == null || TextUtils.equals(this.mOtherParams, "null")) {
            this.mOtherParams = "";
        }
        this.orh.setShowOval(true);
        this.orh.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.orh.setAutoChangeStyle(false);
        this.orh.setAccuracyWith(30.0f);
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.orh.setDefaultResource(a.e.pic_avatar_moren);
        } else {
            this.orh.startLoad(this.mPortrait, 12, false, false);
        }
        this.gTr.setText(this.aDd.aIU.room_name);
        this.ori.setText(this.mContext.getResources().getString(a.h.room_id_name) + abVar.aIU.croom_id);
        this.gTJ.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aDd != null && this.aDd.mLiveInfo != null && this.aDd.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aDd.mLiveInfo.mLiveCloseData.title)) {
            this.gTK.setText(this.aDd.mLiveInfo.mLiveCloseData.title);
        } else if (this.gTO) {
            this.gTK.setText(a.h.yuyin_live_closed);
        } else {
            this.gTK.setText(a.h.yuyin_live_over_name);
        }
        nc(this.gTN);
        if (this.aDd != null && this.aDd.mLiveInfo != null && this.aDd.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aDd.mLiveInfo.mLiveCloseData.title)) {
                this.gTK.setText(a.h.yuyin_live_over_name);
            } else {
                this.gTK.setText(this.aDd.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.gTO) {
            this.gTK.setText(a.h.yuyin_live_closed);
        } else {
            this.gTK.setText(a.h.yuyin_live_over_name);
        }
        if (this.aIz.userType == 1 || this.aIz.userType == 2) {
            setUserTypeForView(true);
            eam();
            if (TextUtils.isEmpty(this.mLiveInfo.close_reason)) {
                this.orn.setVisibility(8);
                return;
            }
            this.orn.setVisibility(0);
            this.orn.setText(this.mLiveInfo.close_reason);
            return;
        }
        setUserTypeForView(false);
        this.gTJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aDd == null || AlaLiveAudienceEndView.this.aDd.mLiveInfo == null || AlaLiveAudienceEndView.this.aDd.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.orf != null) {
                        if (AlaLiveAudienceEndView.this.gTN) {
                            AlaLiveAudienceEndView.this.bUI();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWP, AlaLiveAudienceEndView.this.mOtherParams);
                        AlaLiveAudienceEndView.this.orf.nb(AlaLiveAudienceEndView.this.gTN);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aDd.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.mContext, AlaLiveAudienceEndView.this.aDd.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
    }

    public void nc(boolean z) {
        this.gTN = z;
        if (this.aDd != null && this.aDd.mLiveInfo != null && this.aDd.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aDd.mLiveInfo.mLiveCloseData.tips)) {
                this.gTL.setText("");
            } else {
                this.gTL.setText(this.aDd.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aDd.mLiveInfo.mLiveCloseData.actionText)) {
                this.gTJ.setVisibility(8);
                this.gTI.setText("");
            } else {
                this.gTJ.setVisibility(0);
                this.gTI.setText(this.aDd.mLiveInfo.mLiveCloseData.actionText);
                this.gTJ.setBackgroundResource(a.e.round_btn_collection_highlight);
            }
            setRecommendViewVisible(8);
            return;
        }
        this.gTJ.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.gTN) {
            this.gTL.setText(a.h.yuyin_endtext_followed);
            this.gTI.setText(a.h.yuyinala_live_end_view_followed);
            this.gTJ.setBackgroundResource(a.e.round_btn_collection_lowlight);
            return;
        }
        this.gTL.setText(a.h.yuyin_endtext_follow);
        this.gTI.setText(a.h.yuyinala_live_end_view_follow);
        this.gTJ.setBackgroundResource(a.e.round_btn_collection_highlight);
    }

    private void bUF() {
        this.gTw = (LinearLayout) this.mView.findViewById(a.f.llFeedVideoLabel);
        this.gTx = (LinearLayout) this.mView.findViewById(a.f.video_audience_ll);
        this.gTM = this.mView.findViewById(a.f.change_layout);
        this.gTA = (TbImageView) this.mView.findViewById(a.f.feed_video_item1_cover);
        this.gTB = (TextView) this.mView.findViewById(a.f.feed_video_item1_name);
        this.gTC = (TextView) this.mView.findViewById(a.f.feed_video_item1_watch_num);
        this.orq = (TextView) this.mView.findViewById(a.f.live_label_1);
        this.gTE = (TbImageView) this.mView.findViewById(a.f.feed_video_item2_cover);
        this.gTF = (TextView) this.mView.findViewById(a.f.feed_video_item2_name);
        this.gTG = (TextView) this.mView.findViewById(a.f.feed_video_item2_watch_num);
        this.orr = (TextView) this.mView.findViewById(a.f.live_label_2);
        this.gTy = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_1);
        this.gTz = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_2);
        this.gTD = (ProgressBar) this.mView.findViewById(a.f.feed_video_item1_progressBar);
        this.gTH = (ProgressBar) this.mView.findViewById(a.f.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.gTw.setVisibility(i);
        this.gTx.setVisibility(i);
    }

    public void X(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aDd != null) {
            if (this.aDd.mLiveInfo == null || this.aDd.mLiveInfo.mLiveCloseData == null) {
                setRecommendViewVisible(0);
                boolean z = arrayList.size() > 2;
                this.gTQ = arrayList;
                this.gTP = 0;
                a(this.gTP, arrayList.get(this.gTP), this.gTP + 1, arrayList.get(this.gTP + 1), z);
                this.gTP++;
                if (this.animator == null) {
                    this.animator = ValueAnimator.ofInt(100, 0);
                    this.animator.setDuration(5000L);
                    this.animator.setInterpolator(gTo);
                    this.animator.setRepeatCount(-1);
                    this.animator.setRepeatMode(1);
                    this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            AlaLiveAudienceEndView.this.gTD.setProgress(intValue);
                            AlaLiveAudienceEndView.this.gTH.setProgress(intValue);
                        }
                    });
                    this.animator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.4
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                            AlaLiveAudienceEndView.this.bUH();
                        }
                    });
                }
                if (z) {
                    this.animator.start();
                    this.gTM.setVisibility(0);
                    this.gTM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWP, AlaLiveAudienceEndView.this.mOtherParams);
                            AlaLiveAudienceEndView.this.animator.cancel();
                            AlaLiveAudienceEndView.this.bUH();
                            AlaLiveAudienceEndView.this.animator.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUH() {
        int i = this.gTP + 1;
        this.gTP = i;
        if (i >= this.gTQ.size()) {
            this.gTP = 0;
            i = 0;
        }
        int i2 = this.gTP + 1;
        this.gTP = i2;
        if (i2 >= this.gTQ.size()) {
            this.gTP = 0;
            i2 = 0;
        }
        this.gTP = i2;
        a(i, this.gTQ.get(i), i2, this.gTQ.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        a(this.gTy, this.gTA, this.gTB, this.gTC, this.gTD, this.orq, alaLiveInfoData, z, i);
        a(this.gTz, this.gTE, this.gTF, this.gTG, this.gTH, this.orr, alaLiveInfoData2, z, i2);
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
                    } else if (AlaLiveAudienceEndView.this.orf != null) {
                        AlaLiveAudienceEndView.this.orf.f(alaLiveInfoData);
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
        return this.gTw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUI() {
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
                    LogManager.getLiveCloseLogger().doClickNoFollowLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWP, AlaLiveAudienceEndView.this.mOtherParams);
                    AlaLiveAudienceEndView.this.orf.nb(AlaLiveAudienceEndView.this.gTN);
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
