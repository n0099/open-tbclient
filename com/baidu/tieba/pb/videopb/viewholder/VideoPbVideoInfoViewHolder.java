package com.baidu.tieba.pb.videopb.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.s.q.d2;
import c.a.r0.j2.k.e.a1.c;
import c.a.r0.j2.k.e.a1.g;
import c.a.r0.j2.k.e.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextHelper;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
/* loaded from: classes7.dex */
public class VideoPbVideoInfoViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int VIDEO_TITLE_STATUS_EXPAND_BTN_ARROW_DOWN = 1;
    public static final int VIDEO_TITLE_STATUS_EXPAND_BTN_ARROW_UP = 2;
    public static final int VIDEO_TITLE_STATUS_NO_EXPAND_BTN = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f55746a;
    public TbRichTextView abstractView;

    /* renamed from: b  reason: collision with root package name */
    public int f55747b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f55748c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f55749d;

    /* renamed from: e  reason: collision with root package name */
    public g f55750e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f55751f;

    /* renamed from: g  reason: collision with root package name */
    public c f55752g;

    /* renamed from: h  reason: collision with root package name */
    public int f55753h;

    /* renamed from: i  reason: collision with root package name */
    public int f55754i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f55755j;
    public AbsVideoPbFragment k;
    public TextView mBjhAuthorAuth;
    public TextView mCollapsiblePlayCount;
    public TextView mCollapsiblePublishDistance;
    public TextView mCollapsiblePublishLocation;
    public TextView mCollapsiblePublishTime;
    public PbFirstFloorUserLikeButton mConcernBtn;
    public TextView mFansCount;
    public HeadPendantClickableView mHeadView;
    public LinearLayout mLinkContainer;
    public ViewGroup mNoticeContainer;
    public TextView mPlayCount;
    public TextView mPublishDistance;
    public TextView mPublishLocation;
    public TextView mPublishTime;
    public VoteView mPublishVoteView;
    public View mRoot;
    public ImageView mThreadStamp;
    public ImageView mTitleExpandBtn;
    public RelativeLayout mTitleExpandBtnWrapper;
    public ImageView mUserForumLevel;
    public TextView mUserIdentity;
    public TBLottieAnimationView mUserLivingLottie;
    public TextView mUserName;
    public UserIconBox mUserYinJi;
    public RelativeLayout mVideoInfoAreaLayout;
    public final View mVideoInfoItemCollapsibleLayout;
    public View mVideoInfoItemLayout;
    public TbRichTextView mVideoTitle;
    public View mVideoTitleAreaVideoInfoItem;
    public UserIconBox mVipIcon;
    public TextView mYoungsterTip;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbVideoInfoViewHolder f55756e;

        public a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPbVideoInfoViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55756e = videoPbVideoInfoViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55756e.mUserLivingLottie.playAnimation();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPbVideoInfoViewHolder(Context context, View view, AbsVideoPbFragment absVideoPbFragment) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view, absVideoPbFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.f55746a = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds6);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
        this.f55747b = 3;
        this.mRoot = view;
        this.k = absVideoPbFragment;
        this.mThreadStamp = (ImageView) view.findViewById(R.id.thread_stamp_video_info_item);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view.findViewById(R.id.head_view_video_info_item);
        this.mHeadView = headPendantClickableView;
        headPendantClickableView.setHasPendantStyle();
        this.mHeadView.getHeadView().setIsRound(true);
        this.mHeadView.getHeadView().setDrawBorder(true);
        this.mHeadView.getHeadView().setBorderWidth(l.g(context, R.dimen.L_X01));
        this.mHeadView.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.mHeadView.getHeadView().setPlaceHolder(1);
        this.mHeadView.setBigVDimenSize(R.dimen.tbds36);
        this.mUserLivingLottie = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        this.mVipIcon = (UserIconBox) view.findViewById(R.id.vip_icon_video_info_item);
        this.mUserName = (TextView) view.findViewById(R.id.user_name_video_info_item);
        this.mUserIdentity = (TextView) view.findViewById(R.id.user_identity_video_info_item);
        this.mUserForumLevel = (ImageView) view.findViewById(R.id.user_forum_level_video_info_item);
        this.mUserYinJi = (UserIconBox) view.findViewById(R.id.user_yinji_video_info_item);
        this.mBjhAuthorAuth = (TextView) view.findViewById(R.id.bjh_author_auth_video_info_item);
        this.mFansCount = (TextView) view.findViewById(R.id.fans_count_video_info_item);
        this.mConcernBtn = (PbFirstFloorUserLikeButton) view.findViewById(R.id.concern_video_info_item);
        this.mNoticeContainer = (ViewGroup) view.findViewById(R.id.notice_container);
        this.mVideoInfoAreaLayout = (RelativeLayout) view.findViewById(R.id.video_info_area_video_info_item);
        this.mVideoTitle = (TbRichTextView) view.findViewById(R.id.title_video_info_item);
        this.f55748c = (TextView) view.findViewById(R.id.title_measure_text);
        this.mVideoInfoItemLayout = view.findViewById(R.id.video_info_item_layout);
        this.mVideoTitleAreaVideoInfoItem = view.findViewById(R.id.video_title_area_video_info_item);
        this.mVideoInfoItemCollapsibleLayout = view.findViewById(R.id.video_info_item_collapsible_layout);
        this.mVideoTitle.setLayoutStrategy(new e(this.mVideoTitle.getLayoutStrategy()));
        this.mVideoTitle.setTextSize(TbConfig.getContentSize());
        this.mVideoTitle.setTextBold();
        this.f55748c.setTextSize(0, TbConfig.getContentSize());
        this.f55748c.setLineSpacing(TbConfig.getContentLineSpace(), 1.0f);
        this.mTitleExpandBtn = (ImageView) view.findViewById(R.id.btn_title_expand_video_info_item);
        this.mTitleExpandBtnWrapper = (RelativeLayout) view.findViewById(R.id.btn_wrapper_title_expand_video_info_item);
        this.f55753h = (l.k(TbadkCoreApplication.getInst()) - this.mVideoInfoAreaLayout.getPaddingLeft()) - this.mVideoInfoAreaLayout.getPaddingRight();
        changeVideoTitleStatus(0);
        this.mPlayCount = (TextView) view.findViewById(R.id.play_count_video_info_item);
        this.mPublishTime = (TextView) view.findViewById(R.id.publish_time_video_info_item);
        this.mPublishLocation = (TextView) view.findViewById(R.id.publish_location_video_info_item);
        this.mPublishDistance = (TextView) view.findViewById(R.id.publish_distance_video_info_item);
        this.mCollapsiblePlayCount = (TextView) view.findViewById(R.id.play_count_video_info_item_collapsible);
        this.mCollapsiblePublishTime = (TextView) view.findViewById(R.id.publish_time_video_info_item_collapsible);
        this.mCollapsiblePublishLocation = (TextView) view.findViewById(R.id.publish_location_video_info_item_collapsible);
        this.mCollapsiblePublishDistance = (TextView) view.findViewById(R.id.publish_distance_video_info_item_collapsible);
        this.mPublishVoteView = (VoteView) view.findViewById(R.id.pb_video_vote_view);
        TbRichTextView tbRichTextView = (TbRichTextView) view.findViewById(R.id.video_abstract_item);
        this.abstractView = tbRichTextView;
        tbRichTextView.setIsShowOrderOrDownloadBtn(true);
        this.abstractView.setIsNeedResizeEmotion(true);
        this.mLinkContainer = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        e eVar = new e(this.abstractView.getLayoutStrategy());
        eVar.v(TbConfig.getContentSize());
        eVar.n(0.9f);
        this.abstractView.setLayoutStrategy(eVar);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.ueg_root);
        this.f55749d = frameLayout;
        g gVar = new g(absVideoPbFragment, frameLayout);
        this.f55750e = gVar;
        gVar.f19836f = 2;
        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.inc_pb_notice_bar);
        this.f55751f = frameLayout2;
        this.f55752g = new c(frameLayout2);
        this.mYoungsterTip = (TextView) view.findViewById(R.id.tv_youngster_tip);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mTitleExpandBtnWrapper.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mTitleExpandBtn, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
            this.mVideoTitle.setTextEllipsize(TextUtils.TruncateAt.END);
            this.mVideoTitle.setMaxLines(2);
            this.mVideoInfoItemCollapsibleLayout.setVisibility(8);
            this.abstractView.setVisibility(8);
            this.mPlayCount.setVisibility(0);
            this.mPublishTime.setVisibility(0);
            this.mPublishLocation.setVisibility(0);
            this.mPublishDistance.setVisibility(0);
            this.mVideoInfoItemLayout.setVisibility(0);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mTitleExpandBtnWrapper.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mTitleExpandBtn, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null);
            this.mVideoTitle.setTextEllipsize(null);
            this.mVideoTitle.setMaxLines(3);
            if (this.f55755j) {
                this.abstractView.setVisibility(0);
            }
            this.mVideoInfoItemCollapsibleLayout.setVisibility(0);
            this.mPlayCount.setVisibility(8);
            this.mPublishTime.setVisibility(8);
            this.mPublishLocation.setVisibility(8);
            this.mPublishDistance.setVisibility(8);
            this.mVideoInfoItemLayout.setVisibility(8);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mTitleExpandBtnWrapper.setVisibility(8);
            this.mVideoTitle.setTextEllipsize(null);
            this.mVideoTitle.setMaxLines(2);
        }
    }

    public void changeVideoTitleStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f55754i = i2;
            if (i2 == 0) {
                c();
            } else if (i2 == 1) {
                a();
            } else if (i2 == 2) {
                b();
            }
        }
    }

    public final void d(List<TbRichTextData> list, HeadItem headItem) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, headItem) == null) {
            TbRichTextData tbRichTextData = new TbRichTextData(1);
            StringBuilder sb = new StringBuilder();
            sb.append(headItem.name);
            sb.append(": ");
            sb.append(headItem.type.intValue() == 1 ? headItem.content : " ");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(sb.toString()));
            if (headItem.type.intValue() == 2) {
                try {
                    i2 = Integer.parseInt(headItem.content);
                } catch (NumberFormatException unused) {
                    i2 = 0;
                }
                spannableStringBuilder.append((CharSequence) TbRichTextHelper.r(i2, true));
            }
            tbRichTextData.x(spannableStringBuilder);
            ListUtils.add(list, 0, tbRichTextData);
        }
    }

    public int getCurVideoTitleStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f55754i : invokeV.intValue;
    }

    public final void handleUserAlaLiveSkinType(int i2) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (tBLottieAnimationView = this.mUserLivingLottie) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public void handleUserAlaLiveState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (z) {
                this.mUserLivingLottie.setVisibility(0);
                if (this.mUserLivingLottie.isAnimating()) {
                    return;
                }
                this.mUserLivingLottie.setSpeed(0.8f);
                this.mUserLivingLottie.setRepeatCount(-1);
                this.mUserLivingLottie.post(new a(this));
                return;
            }
            this.mUserLivingLottie.setVisibility(8);
            if (this.mUserLivingLottie.isAnimating()) {
                this.mUserLivingLottie.cancelAnimation();
            }
        }
    }

    public void insertHighQualityPrefix(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbRichText) == null) || tbRichText == null) {
            return;
        }
        ArrayList<TbRichTextData> y = tbRichText.y();
        TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(y, 0);
        if (tbRichTextData == null || tbRichTextData.getType() != 1) {
            tbRichTextData = new TbRichTextData(1);
            ListUtils.add(y, 0, tbRichTextData);
        }
        tbRichTextData.Z(TbRichTextHelper.t());
    }

    public void insertItemToTitleOrAbstractText(TbRichText tbRichText, List<HeadItem> list) {
        int count;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, tbRichText, list) == null) || (count = ListUtils.getCount(list)) == 0 || list == null) {
            return;
        }
        ArrayList<TbRichTextData> y = tbRichText.y();
        if (count == 1) {
            TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(y, 0);
            if (tbRichTextData == null || tbRichTextData.getType() != 1) {
                tbRichTextData = new TbRichTextData(1);
                ListUtils.add(y, 0, tbRichTextData);
            }
            HeadItem headItem = (HeadItem) ListUtils.getItem(list, 0);
            if (headItem != null) {
                try {
                    i2 = Integer.parseInt(headItem.content);
                } catch (NumberFormatException unused) {
                    i2 = 0;
                }
                tbRichTextData.Z(TbRichTextHelper.r(i2, false));
                return;
            }
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            HeadItem headItem2 = list.get(size);
            if (headItem2 != null) {
                d(y, headItem2);
            }
        }
    }

    public void onChangeForumLevelSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || i2 <= 0) {
            return;
        }
        SkinManager.setImageResource(this.mUserForumLevel, BitmapHelper.getGradeResourceIdInEnterForum(i2));
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.mRoot, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.mYoungsterTip, R.color.CAM_X0202);
            this.mBjhAuthorAuth.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.mFansCount.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.mConcernBtn.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mVideoTitle.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            changeVideoTitleStatus(this.f55754i);
            this.mPlayCount.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.mPublishTime.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.mPublishLocation.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.mPublishDistance.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.mCollapsiblePlayCount.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.mCollapsiblePublishTime.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.mCollapsiblePublishLocation.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.mCollapsiblePublishDistance.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.mPublishVoteView.onChangeSkinType(skinType);
            this.abstractView.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            this.f55750e.d();
            this.f55752g.c();
            if (this.f55747b != skinType) {
                handleUserAlaLiveSkinType(skinType);
            }
            this.f55747b = skinType;
        }
    }

    public void onChangeThreadStamp(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (z) {
                this.mThreadStamp.setImageResource(R.drawable.pic_frs_headlines_n);
                this.mThreadStamp.setVisibility(0);
            } else if (z2 && z3) {
                this.mThreadStamp.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.mThreadStamp.setVisibility(0);
            } else if (z2) {
                this.mThreadStamp.setImageResource(R.drawable.pic_pb_refined_n);
                this.mThreadStamp.setVisibility(0);
            } else if (z3) {
                this.mThreadStamp.setImageResource(R.drawable.pic_pb_stick_n);
                this.mThreadStamp.setVisibility(0);
            } else {
                this.mThreadStamp.setVisibility(8);
            }
        }
    }

    public void onChangeUserIdentitySkinType(String str) {
        StateListDrawable stateListDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            if ("manager".equals(str) || PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(str)) {
                StateListDrawable stateListDrawable2 = null;
                if ("manager".equals(str)) {
                    stateListDrawable2 = DrawableSelector.make().setShape(0).radius(this.f55746a).gradientLinear(DrawableSelector.TL_BR, R.color.ba_zhu_start, R.color.ba_zhu_end).build();
                    stateListDrawable = DrawableSelector.make().setShape(0).radius(this.f55746a).defaultColor("#4D000000").build();
                } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(str)) {
                    stateListDrawable2 = DrawableSelector.make().setShape(0).radius(this.f55746a).gradientLinear(DrawableSelector.TL_BR, R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).build();
                    stateListDrawable = DrawableSelector.make().setShape(0).radius(this.f55746a).defaultColor("#4D000000").build();
                } else {
                    stateListDrawable = null;
                }
                LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{stateListDrawable2, stateListDrawable});
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    if (layerDrawable.getDrawable(1) != null) {
                        layerDrawable.getDrawable(1).setAlpha(255);
                    }
                } else if (layerDrawable.getDrawable(1) != null) {
                    layerDrawable.getDrawable(1).setAlpha(0);
                }
                this.mUserIdentity.setBackgroundDrawable(layerDrawable);
                SkinManager.setViewTextColor(this.mUserIdentity, R.color.CAM_X0101);
            }
        }
    }

    public void onChangeUserNameSkinType(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (z) {
                SkinManager.setViewTextColor(this.mUserName, R.color.CAM_X0301, 1);
            } else {
                SkinManager.setViewTextColor(this.mUserName, R.color.CAM_X0105, 1);
            }
        }
    }

    public void setNoticeBarData(@Nullable c.a.r0.j2.h.e eVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, eVar, i2) == null) {
            this.f55752g.e(eVar, i2, null);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            this.mHeadView.setOnClickListener(onClickListener);
            this.mTitleExpandBtnWrapper.setOnClickListener(onClickListener);
            this.mVideoTitleAreaVideoInfoItem.setOnClickListener(onClickListener);
            this.mVipIcon.setOnClickListener(onClickListener);
            this.mUserName.setOnClickListener(onClickListener);
            this.mUserYinJi.setOnClickListener(onClickListener);
        }
    }

    public void setUegInfo(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048593, this, i2, str) == null) {
            this.f55750e.g(i2);
            this.f55750e.f(str);
        }
    }

    public void setVideoAbstract(Context context, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, context, postData) == null) {
            if (postData != null && ListUtils.getCount(postData.n0) >= 2) {
                List<PbContent> list = postData.n0;
                TbRichText parser = TbRichTextView.parser(context, ListUtils.subList(list, 1, list.size()), true);
                insertItemToTitleOrAbstractText(parser, postData.G());
                this.abstractView.setText(parser);
                this.f55755j = true;
                return;
            }
            this.f55755j = false;
        }
    }

    public void setVideoTitle(Context context, List<PbContent> list, String str, d2 d2Var, boolean z, boolean z2) {
        TbRichText tbRichText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{context, list, str, d2Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (ListUtils.isEmpty(list) && StringUtils.isNull(str)) {
                return;
            }
            String spannableStringBuilder = !ListUtils.isEmpty(list) ? TbRichTextHelper.D(list).toString() : str;
            int i2 = 0;
            if (this.f55748c.getPaint().measureText(spannableStringBuilder, 0, spannableStringBuilder.length()) + (this.f55748c.getTextSize() * 2.0f) > this.f55753h * 2 || z) {
                int i3 = this.f55754i;
                i2 = (i3 == 1 || i3 == 2) ? this.f55754i : 1;
            }
            changeVideoTitleStatus(i2);
            if (!ListUtils.isEmpty(list)) {
                tbRichText = TbRichTextView.parser(context, list, true);
            } else {
                tbRichText = new TbRichText(context, c.a.r0.k1.f.a.d(context, str, 1));
            }
            insertItemToTitleOrAbstractText(tbRichText, d2Var.t0());
            if (z2) {
                insertHighQualityPrefix(tbRichText);
            }
            this.mVideoTitle.setText(tbRichText, false, this.k, false, true);
        }
    }
}
