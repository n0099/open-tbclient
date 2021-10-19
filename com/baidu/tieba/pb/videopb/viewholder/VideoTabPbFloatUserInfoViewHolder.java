package com.baidu.tieba.pb.videopb.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.d;
import c.a.e.e.p.l;
import c.a.q0.s.q.d2;
import c.a.r0.k2.k.e.a1.g;
import c.a.r0.k2.k.e.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.HeadItem;
import tbclient.PbContent;
/* loaded from: classes7.dex */
public class VideoTabPbFloatUserInfoViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f55694a;
    public TbRichTextView abstractView;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f55695b;

    /* renamed from: c  reason: collision with root package name */
    public g f55696c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55697d;

    /* renamed from: e  reason: collision with root package name */
    public AbsVideoPbFragment f55698e;
    public TextView mBjhAuthorAuth;
    public PbFirstFloorUserLikeButton mConcernBtn;
    public TextView mFansCount;
    public HeadPendantClickableView mHeadView;
    public View mRoot;
    public ImageView mThreadStamp;
    public ImageView mUserForumLevel;
    public TextView mUserIdentity;
    public TBLottieAnimationView mUserLivingLottie;
    public TextView mUserName;
    public UserIconBox mUserYinJi;
    public RelativeLayout mVideoInfoAreaLayout;
    public TbRichTextView mVideoTitle;
    public UserIconBox mVipIcon;
    public TextView mYoungsterTip;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoTabPbFloatUserInfoViewHolder f55699e;

        /* renamed from: com.baidu.tieba.pb.videopb.viewholder.VideoTabPbFloatUserInfoViewHolder$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1797a extends d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f55700a;

            public C1797a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f55700a = aVar;
            }

            @Override // c.a.e.e.m.d, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                    super.onAnimationEnd(animation);
                    this.f55700a.f55699e.mConcernBtn.setVisibility(8);
                    this.f55700a.f55699e.mConcernBtn.setText("");
                }
            }
        }

        public a(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoTabPbFloatUserInfoViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55699e = videoTabPbFloatUserInfoViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setStartOffset(500L);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new C1797a(this));
                this.f55699e.mConcernBtn.startAnimation(alphaAnimation);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoTabPbFloatUserInfoViewHolder f55701e;

        public b(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoTabPbFloatUserInfoViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55701e = videoTabPbFloatUserInfoViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55701e.mUserLivingLottie.playAnimation();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoTabPbFloatUserInfoViewHolder(Context context, View view, AbsVideoPbFragment absVideoPbFragment) {
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
        this.f55694a = 3;
        this.mRoot = view;
        this.f55698e = absVideoPbFragment;
        this.mThreadStamp = (ImageView) view.findViewById(R.id.video_tab_thread_stamp_video_info_item);
        HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view.findViewById(R.id.video_tab_head_view_video_info_item);
        this.mHeadView = headPendantClickableView;
        headPendantClickableView.setHasPendantStyle();
        this.mHeadView.getHeadView().setIsRound(true);
        this.mHeadView.getHeadView().setDrawBorder(true);
        this.mHeadView.getHeadView().setBorderWidth(l.g(context, R.dimen.L_X01));
        this.mHeadView.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.mHeadView.getHeadView().setPlaceHolder(1);
        this.mHeadView.setBigVDimenSize(R.dimen.tbds36);
        this.mUserLivingLottie = (TBLottieAnimationView) view.findViewById(R.id.video_tab_user_living_lottie);
        this.mVipIcon = (UserIconBox) view.findViewById(R.id.video_tab_vip_icon_video_info_item);
        this.mUserName = (TextView) view.findViewById(R.id.video_tab_user_name_video_info_item);
        this.mUserIdentity = (TextView) view.findViewById(R.id.video_tab_user_identity_video_info_item);
        this.mUserForumLevel = (ImageView) view.findViewById(R.id.video_tab_user_forum_level_video_info_item);
        this.mUserYinJi = (UserIconBox) view.findViewById(R.id.video_tab_user_yinji_video_info_item);
        this.mBjhAuthorAuth = (TextView) view.findViewById(R.id.video_tab_bjh_author_auth_video_info_item);
        this.mFansCount = (TextView) view.findViewById(R.id.video_tab_fans_count_video_info_item);
        PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = (PbFirstFloorUserLikeButton) view.findViewById(R.id.video_tab_concern_video_info_item);
        this.mConcernBtn = pbFirstFloorUserLikeButton;
        pbFirstFloorUserLikeButton.setIsShowIcon(true);
        this.mConcernBtn.setAfterStatusUpdateListener(new a(this));
        this.mVideoInfoAreaLayout = (RelativeLayout) view.findViewById(R.id.video_tab_video_info_area_video_info_item);
        TbRichTextView tbRichTextView = (TbRichTextView) view.findViewById(R.id.video_tab_title_video_info_item);
        this.mVideoTitle = tbRichTextView;
        tbRichTextView.setLayoutStrategy(new e(this.mVideoTitle.getLayoutStrategy()));
        this.mVideoTitle.getLayoutStrategy().n(1.0f);
        this.mVideoTitle.getLayoutStrategy().j(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds0));
        this.mVideoTitle.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X06));
        this.mVideoTitle.setTextBold();
        if (this.f55697d) {
            this.abstractView.setVisibility(0);
        }
        TbRichTextView tbRichTextView2 = (TbRichTextView) view.findViewById(R.id.video_tab_video_abstract_item);
        this.abstractView = tbRichTextView2;
        tbRichTextView2.setIsNeedResizeEmotion(true);
        e eVar = new e(this.abstractView.getLayoutStrategy());
        eVar.v(TbConfig.getContentSize());
        eVar.n(0.9f);
        eVar.j(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
        this.abstractView.setLayoutStrategy(eVar);
        this.abstractView.setMaxLines(3);
        this.abstractView.setAddExpandableListener(true);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.video_tab_ueg_root);
        this.f55695b = frameLayout;
        g gVar = new g(absVideoPbFragment, frameLayout);
        this.f55696c = gVar;
        gVar.f20013f = 2;
        this.mYoungsterTip = (TextView) view.findViewById(R.id.video_tab_tv_youngster_tip);
    }

    public final void a(List<TbRichTextData> list, HeadItem headItem) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, list, headItem) == null) {
            TbRichTextData tbRichTextData = new TbRichTextData(1);
            StringBuilder sb = new StringBuilder();
            sb.append(headItem.name);
            sb.append(": ");
            sb.append(headItem.type.intValue() == 1 ? headItem.content : " ");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(sb.toString()));
            if (headItem.type.intValue() == 2) {
                try {
                    i2 = Integer.parseInt(headItem.content);
                } catch (NumberFormatException e2) {
                    BdLog.e(e2);
                    i2 = 0;
                }
                spannableStringBuilder.append((CharSequence) c.a.q0.f1.m.e.q(i2, true));
            }
            tbRichTextData.x(spannableStringBuilder);
            ListUtils.add(list, 0, tbRichTextData);
        }
    }

    public final void handleUserAlaLiveSkinType(int i2) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (tBLottieAnimationView = this.mUserLivingLottie) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public void handleUserAlaLiveState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.mUserLivingLottie.setVisibility(0);
                if (this.mUserLivingLottie.isAnimating()) {
                    return;
                }
                this.mUserLivingLottie.setSpeed(0.8f);
                this.mUserLivingLottie.setRepeatCount(-1);
                this.mUserLivingLottie.post(new b(this));
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
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbRichText) == null) || tbRichText == null) {
            return;
        }
        ArrayList<TbRichTextData> y = tbRichText.y();
        TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(y, 0);
        if (tbRichTextData == null || tbRichTextData.getType() != 1) {
            tbRichTextData = new TbRichTextData(1);
            ListUtils.add(y, 0, tbRichTextData);
        }
        tbRichTextData.b0(c.a.q0.f1.m.e.s());
    }

    public void insertItemToTitleOrAbstractText(TbRichText tbRichText, List<HeadItem> list) {
        int count;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, tbRichText, list) == null) || (count = ListUtils.getCount(list)) == 0 || list == null) {
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
                } catch (NumberFormatException e2) {
                    BdLog.e(e2);
                    i2 = 0;
                }
                tbRichTextData.b0(c.a.q0.f1.m.e.q(i2, false));
                return;
            }
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            HeadItem headItem2 = list.get(size);
            if (headItem2 != null) {
                a(y, headItem2);
            }
        }
    }

    public void onChangeForumLevelSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || i2 <= 0) {
            return;
        }
        SkinManager.setImageResource(this.mUserForumLevel, BitmapHelper.getGradeResourceIdInEnterForum(i2));
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setBackgroundColor(this.mRoot, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.mYoungsterTip, R.color.CAM_X0202);
            this.mBjhAuthorAuth.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.mFansCount.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.mConcernBtn.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.mVideoTitle.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.abstractView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f55696c.d();
            if (this.f55694a != skinType) {
                handleUserAlaLiveSkinType(skinType);
            }
            this.f55694a = skinType;
        }
    }

    public void onChangeThreadStamp(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
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
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if ("manager".equals(str) || PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(str)) {
                StateListDrawable stateListDrawable2 = null;
                if ("manager".equals(str)) {
                    stateListDrawable2 = DrawableSelector.make().setShape(0).radius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds6)).gradientLinear(DrawableSelector.TL_BR, R.color.ba_zhu_start, R.color.ba_zhu_end).build();
                    stateListDrawable = DrawableSelector.make().setShape(0).radius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds6)).defaultColor("#4D000000").build();
                } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(str)) {
                    stateListDrawable2 = DrawableSelector.make().setShape(0).radius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds6)).gradientLinear(DrawableSelector.TL_BR, R.color.xiao_ba_zhu_start, R.color.xiao_ba_zhu_end).build();
                    stateListDrawable = DrawableSelector.make().setShape(0).radius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds6)).defaultColor("#4D000000").build();
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
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                SkinManager.setViewTextColor(this.mUserName, R.color.CAM_X0301, 1);
            } else {
                SkinManager.setViewTextColor(this.mUserName, R.color.CAM_X0105, 1);
            }
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.mHeadView.setOnClickListener(onClickListener);
            this.mVipIcon.setOnClickListener(onClickListener);
            this.mUserName.setOnClickListener(onClickListener);
            this.mUserYinJi.setOnClickListener(onClickListener);
        }
    }

    public void setUegInfo(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, str) == null) {
            this.f55696c.g(i2);
            this.f55696c.f(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVideoInfoAreaLayout.getLayoutParams();
            if (i2 == 8) {
                layoutParams.addRule(3, R.id.video_tab_user_info_area_video_info_item);
                layoutParams.setMargins(0, l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002), 0, 0);
            } else {
                layoutParams.addRule(3, R.id.video_tab_ueg_root);
                layoutParams.setMargins(0, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4), 0, 0);
            }
            this.mVideoInfoAreaLayout.setLayoutParams(layoutParams);
        }
    }

    public void setVideoAbstract(Context context, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, context, postData) == null) {
            if (postData != null && ListUtils.getCount(postData.n0) >= 2) {
                List<PbContent> list = postData.n0;
                TbRichText parser = TbRichTextView.parser(context, ListUtils.subList(list, 1, list.size()), true);
                insertItemToTitleOrAbstractText(parser, postData.G());
                this.abstractView.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X07));
                this.abstractView.setText(parser);
                this.f55697d = true;
                return;
            }
            this.f55697d = false;
        }
    }

    public void setVideoTitle(Context context, List<PbContent> list, String str, d2 d2Var, boolean z, boolean z2) {
        TbRichText tbRichText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, list, str, d2Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (ListUtils.isEmpty(list) && StringUtils.isNull(str)) {
                return;
            }
            if (z) {
                this.abstractView.setVisibility(0);
            }
            if (!ListUtils.isEmpty(list)) {
                tbRichText = TbRichTextView.parser(context, list, true, d2Var);
            } else {
                tbRichText = new TbRichText(context, c.a.r0.l1.f.a.d(context, str, 1));
            }
            insertItemToTitleOrAbstractText(tbRichText, d2Var.t0());
            if (z2) {
                insertHighQualityPrefix(tbRichText);
            }
            this.mVideoTitle.setText(tbRichText, false, this.f55698e, false, true);
        }
    }
}
