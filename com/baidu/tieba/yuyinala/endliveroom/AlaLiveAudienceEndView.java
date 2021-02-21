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
    private static final LinearInterpolator gTC = new LinearInterpolator();
    private ab aDd;
    private AlaLiveUserInfoData aIz;
    private String aWP;
    private ValueAnimator animator;
    private TextView gTF;
    private LinearLayout gTK;
    private LinearLayout gTL;
    private RelativeLayout gTM;
    private RelativeLayout gTN;
    private TbImageView gTO;
    private TextView gTP;
    private TextView gTQ;
    private ProgressBar gTR;
    private TbImageView gTS;
    private TextView gTT;
    private TextView gTU;
    private ProgressBar gTV;
    private TextView gTW;
    private LinearLayout gTX;
    private TextView gTY;
    private TextView gTZ;
    private View gUa;
    private boolean gUb;
    private boolean gUc;
    private int gUd;
    private ArrayList<AlaLiveInfoData> gUe;
    private Set<Long> gUf;
    private String liveId;
    private ImageView mCloseBtn;
    private Activity mContext;
    private AlaLiveInfoData mLiveInfo;
    private String mOtherParams;
    private String mPortrait;
    private TbPageContext mTbPageContext;
    private View mView;
    private a orG;
    private BarImageView orH;
    private TextView orI;
    private TextView orJ;
    private TextView orK;
    private TextView orL;
    private TextView orM;
    private TextView orN;
    private LinearLayout orO;
    private LinearLayout orP;
    private TextView orQ;
    private TextView orR;
    private String roomId;

    /* loaded from: classes11.dex */
    public interface a {
        void MM();

        void f(AlaLiveInfoData alaLiveInfoData);

        void nb(boolean z);
    }

    public AlaLiveAudienceEndView(@NonNull Context context) {
        super(context);
        this.gUb = false;
        this.mPortrait = "";
        this.gUc = false;
        this.gUd = 0;
        this.gUf = new HashSet();
        initUI();
    }

    private void initUI() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_live_audience_end_view_layout, (ViewGroup) this, true);
        this.mCloseBtn = (ImageView) this.mView.findViewById(a.f.close_btn_view);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.orG != null) {
                    AlaLiveAudienceEndView.this.orG.MM();
                }
            }
        });
        this.orH = (BarImageView) this.mView.findViewById(a.f.avatar_img);
        this.gTF = (TextView) this.mView.findViewById(a.f.user_name);
        this.orI = (TextView) this.mView.findViewById(a.f.tv_user_id);
        this.gTZ = (TextView) this.mView.findViewById(a.f.endText_textView);
        this.orJ = (TextView) this.mView.findViewById(a.f.tv_live_end_newcharmnum);
        this.orK = (TextView) this.mView.findViewById(a.f.tv_live_end_givernum);
        this.orL = (TextView) this.mView.findViewById(a.f.tv_live_end_watchnum);
        this.orM = (TextView) this.mView.findViewById(a.f.tv_live_end_newfansnum);
        this.orN = (TextView) this.mView.findViewById(a.f.endText_textView_master);
        this.orO = (LinearLayout) this.mView.findViewById(a.f.ll_master_bottomview);
        this.orP = (LinearLayout) this.mView.findViewById(a.f.ll_audience_bottomview);
        this.gTX = (LinearLayout) this.mView.findViewById(a.f.llFollowLabel);
        this.gTW = (TextView) this.mView.findViewById(a.f.follow_label);
        this.gTY = (TextView) this.mView.findViewById(a.f.live_over_name);
        bUM();
    }

    private void setUserTypeForView(boolean z) {
        if (z) {
            this.orO.setVisibility(0);
            this.orP.setVisibility(8);
            return;
        }
        this.orO.setVisibility(8);
        this.orP.setVisibility(0);
    }

    private void eau() {
        this.orL.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.familyFansCount));
        if (this.mLiveInfo.newFansCount <= 0) {
            this.orM.setText(String.valueOf(this.mLiveInfo.newFansCount));
        } else {
            this.orM.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.newFansCount));
        }
        this.orK.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.rewardUserCount));
        this.orJ.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.charm_count));
    }

    public void setCallback(a aVar) {
        this.orG = aVar;
    }

    public void setData(TbPageContext tbPageContext, ab abVar, boolean z, boolean z2, String str, String str2) {
        this.aDd = abVar;
        this.gUc = z;
        this.mTbPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.aDd = abVar;
        this.mLiveInfo = abVar.mLiveInfo;
        this.aIz = abVar.aIz;
        this.gUb = z2;
        this.mPortrait = str;
        this.gUc = z;
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
        this.orH.setShowOval(true);
        this.orH.setBorderColor(this.mContext.getResources().getColor(a.c.sdk_cp_bg_line_k_alpha10_1));
        this.orH.setAutoChangeStyle(false);
        this.orH.setAccuracyWith(30.0f);
        if (TextUtils.isEmpty(this.mPortrait)) {
            this.orH.setDefaultResource(a.e.pic_avatar_moren);
        } else {
            this.orH.startLoad(this.mPortrait, 12, false, false);
        }
        this.gTF.setText(this.aDd.aIU.room_name);
        this.orI.setText(this.mContext.getResources().getString(a.h.room_id_name) + abVar.aIU.croom_id);
        this.gTX.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.aDd != null && this.aDd.mLiveInfo != null && this.aDd.mLiveInfo.mLiveCloseData != null && !TextUtils.isEmpty(this.aDd.mLiveInfo.mLiveCloseData.title)) {
            this.gTY.setText(this.aDd.mLiveInfo.mLiveCloseData.title);
        } else if (this.gUc) {
            this.gTY.setText(a.h.yuyin_live_closed);
        } else {
            this.gTY.setText(a.h.yuyin_live_over_name);
        }
        nc(this.gUb);
        if (this.aDd != null && this.aDd.mLiveInfo != null && this.aDd.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aDd.mLiveInfo.mLiveCloseData.title)) {
                this.gTY.setText(a.h.yuyin_live_over_name);
            } else {
                this.gTY.setText(this.aDd.mLiveInfo.mLiveCloseData.title);
            }
        } else if (this.gUc) {
            this.gTY.setText(a.h.yuyin_live_closed);
        } else {
            this.gTY.setText(a.h.yuyin_live_over_name);
        }
        if (this.aIz.userType == 1 || this.aIz.userType == 2) {
            setUserTypeForView(true);
            eau();
            if (TextUtils.isEmpty(this.mLiveInfo.close_reason)) {
                this.orN.setVisibility(8);
                return;
            }
            this.orN.setVisibility(0);
            this.orN.setText(this.mLiveInfo.close_reason);
            return;
        }
        setUserTypeForView(false);
        this.gTX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaLiveAudienceEndView.this.aDd == null || AlaLiveAudienceEndView.this.aDd.mLiveInfo == null || AlaLiveAudienceEndView.this.aDd.mLiveInfo.mLiveCloseData == null) {
                    if (AlaLiveAudienceEndView.this.orG != null) {
                        if (AlaLiveAudienceEndView.this.gUb) {
                            AlaLiveAudienceEndView.this.bUP();
                            return;
                        }
                        LogManager.getLiveCloseLogger().doFollowClickLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWP, AlaLiveAudienceEndView.this.mOtherParams);
                        AlaLiveAudienceEndView.this.orG.nb(AlaLiveAudienceEndView.this.gUb);
                    }
                } else if (!TextUtils.isEmpty(AlaLiveAudienceEndView.this.aDd.mLiveInfo.mLiveCloseData.actionScheme)) {
                    BrowserHelper.startInternalWebActivity(AlaLiveAudienceEndView.this.mContext, AlaLiveAudienceEndView.this.aDd.mLiveInfo.mLiveCloseData.actionScheme);
                }
            }
        });
    }

    public void nc(boolean z) {
        this.gUb = z;
        if (this.aDd != null && this.aDd.mLiveInfo != null && this.aDd.mLiveInfo.mLiveCloseData != null) {
            if (TextUtils.isEmpty(this.aDd.mLiveInfo.mLiveCloseData.tips)) {
                this.gTZ.setText("");
            } else {
                this.gTZ.setText(this.aDd.mLiveInfo.mLiveCloseData.tips);
            }
            if (TextUtils.isEmpty(this.aDd.mLiveInfo.mLiveCloseData.actionText)) {
                this.gTX.setVisibility(8);
                this.gTW.setText("");
            } else {
                this.gTX.setVisibility(0);
                this.gTW.setText(this.aDd.mLiveInfo.mLiveCloseData.actionText);
                this.gTX.setBackgroundResource(a.e.round_btn_collection_highlight);
            }
            setRecommendViewVisible(8);
            return;
        }
        this.gTX.setVisibility(TextUtils.isEmpty(this.mPortrait) ? 4 : 0);
        if (this.gUb) {
            this.gTZ.setText(a.h.yuyin_endtext_followed);
            this.gTW.setText(a.h.yuyinala_live_end_view_followed);
            this.gTX.setBackgroundResource(a.e.round_btn_collection_lowlight);
            return;
        }
        this.gTZ.setText(a.h.yuyin_endtext_follow);
        this.gTW.setText(a.h.yuyinala_live_end_view_follow);
        this.gTX.setBackgroundResource(a.e.round_btn_collection_highlight);
    }

    private void bUM() {
        this.gTK = (LinearLayout) this.mView.findViewById(a.f.llFeedVideoLabel);
        this.gTL = (LinearLayout) this.mView.findViewById(a.f.video_audience_ll);
        this.gUa = this.mView.findViewById(a.f.change_layout);
        this.gTO = (TbImageView) this.mView.findViewById(a.f.feed_video_item1_cover);
        this.gTP = (TextView) this.mView.findViewById(a.f.feed_video_item1_name);
        this.gTQ = (TextView) this.mView.findViewById(a.f.feed_video_item1_watch_num);
        this.orQ = (TextView) this.mView.findViewById(a.f.live_label_1);
        this.gTS = (TbImageView) this.mView.findViewById(a.f.feed_video_item2_cover);
        this.gTT = (TextView) this.mView.findViewById(a.f.feed_video_item2_name);
        this.gTU = (TextView) this.mView.findViewById(a.f.feed_video_item2_watch_num);
        this.orR = (TextView) this.mView.findViewById(a.f.live_label_2);
        this.gTM = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_1);
        this.gTN = (RelativeLayout) this.mView.findViewById(a.f.rl_recom_video_cover_2);
        this.gTR = (ProgressBar) this.mView.findViewById(a.f.feed_video_item1_progressBar);
        this.gTV = (ProgressBar) this.mView.findViewById(a.f.feed_video_item2_progressBar);
    }

    private void setRecommendViewVisible(int i) {
        this.gTK.setVisibility(i);
        this.gTL.setVisibility(i);
    }

    public void X(ArrayList<AlaLiveInfoData> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            setRecommendViewVisible(8);
        } else if (this.aDd != null) {
            if (this.aDd.mLiveInfo == null || this.aDd.mLiveInfo.mLiveCloseData == null) {
                setRecommendViewVisible(0);
                boolean z = arrayList.size() > 2;
                this.gUe = arrayList;
                this.gUd = 0;
                a(this.gUd, arrayList.get(this.gUd), this.gUd + 1, arrayList.get(this.gUd + 1), z);
                this.gUd++;
                if (this.animator == null) {
                    this.animator = ValueAnimator.ofInt(100, 0);
                    this.animator.setDuration(5000L);
                    this.animator.setInterpolator(gTC);
                    this.animator.setRepeatCount(-1);
                    this.animator.setRepeatMode(1);
                    this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            AlaLiveAudienceEndView.this.gTR.setProgress(intValue);
                            AlaLiveAudienceEndView.this.gTV.setProgress(intValue);
                        }
                    });
                    this.animator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.4
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                            AlaLiveAudienceEndView.this.bUO();
                        }
                    });
                }
                if (z) {
                    this.animator.start();
                    this.gUa.setVisibility(0);
                    this.gUa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.endliveroom.AlaLiveAudienceEndView.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            LogManager.getLiveCloseLogger().doClickChangeSomeLiveCloseGuestLog(AlaLiveAudienceEndView.this.liveId, AlaLiveAudienceEndView.this.roomId, AlaLiveAudienceEndView.this.aWP, AlaLiveAudienceEndView.this.mOtherParams);
                            AlaLiveAudienceEndView.this.animator.cancel();
                            AlaLiveAudienceEndView.this.bUO();
                            AlaLiveAudienceEndView.this.animator.start();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUO() {
        int i = this.gUd + 1;
        this.gUd = i;
        if (i >= this.gUe.size()) {
            this.gUd = 0;
            i = 0;
        }
        int i2 = this.gUd + 1;
        this.gUd = i2;
        if (i2 >= this.gUe.size()) {
            this.gUd = 0;
            i2 = 0;
        }
        this.gUd = i2;
        a(i, this.gUe.get(i), i2, this.gUe.get(i2), true);
    }

    public void a(int i, AlaLiveInfoData alaLiveInfoData, int i2, AlaLiveInfoData alaLiveInfoData2, boolean z) {
        a(this.gTM, this.gTO, this.gTP, this.gTQ, this.gTR, this.orQ, alaLiveInfoData, z, i);
        a(this.gTN, this.gTS, this.gTT, this.gTU, this.gTV, this.orR, alaLiveInfoData2, z, i2);
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
                    } else if (AlaLiveAudienceEndView.this.orG != null) {
                        AlaLiveAudienceEndView.this.orG.f(alaLiveInfoData);
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
        return this.gTK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUP() {
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
                    AlaLiveAudienceEndView.this.orG.nb(AlaLiveAudienceEndView.this.gUb);
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
