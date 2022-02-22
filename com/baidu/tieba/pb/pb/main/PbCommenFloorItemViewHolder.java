package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.t0.s.v.c;
import c.a.u0.u2.f;
import c.a.u0.u2.h;
import c.a.u0.u2.i;
import c.a.u0.u2.j;
import c.a.u0.u2.k;
import c.a.u0.u2.l;
import c.a.u0.u2.u.f.c1.g;
import c.a.u0.u2.u.f.e;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class PbCommenFloorItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBLottieAnimationView a;
    public LinearLayout mAllContent;
    public View mBottomAgreeContainer;
    public AgreeView mBottomAgreeView;
    public View mBottomCommentContainer;
    public ImageView mBottomCommentImg;
    public TextView mBottomCommentText;
    public View mBottomLine;
    public View mBottomShareContainer;
    public ImageView mBottomShareImg;
    public TextView mBottomShareText;
    public ImageView mBtnOpMore;
    public TextView mBtnPostAbove;
    public ImageView mCommentView;
    public ImageView mFeedBackImg;
    public TextView mFloorAuthorView;
    public TextView mFloorNum;
    public LinearLayout mFoldOpArea;
    public TextView mFoldTitleView;
    public ImageView mForumLevelIcon;
    public HeadImageView mHeadPhotoView;
    public ConstrainImageGroup mImagesView;
    public ImageView mImgGodComment;
    public Boolean mIsShowFlooorComplaint;
    public boolean mIsShowImage;
    public TextView mLocationView;
    public MaskView mMaskView;
    public PbFloorComplaint mPbFloorComplaint;
    public AgreeView mPbFloorPraiseView;
    public ViewGroup mPbPostReplyLayoutAbove;
    public AgreeView mPbRightTopAgreeView;
    public ViewGroup mPbRightTopLayout;
    public ImageView mPbRightTopMoreView;
    public HeadPendantView mPendantHeadView;
    public TextView mPointRightFloor;
    public TextView mPointRightPostTime;
    public int mPosition;
    public View mPostReplyContainer;
    public ImageView mRecommendLiveArrowView;
    public View mRecommendLiveDividerView;
    public LinearLayout mRecommendLiveLayout;
    public TextView mRecommendLivePrefixTv;
    public TextView mRecommendLiveTitleView;
    public SubPbLayout mReplyContentView;
    public TextView mReplyCountView;
    public TextView mReplyTimeView;
    public TextView mReplyView;
    public TbRichTextView mRichTextView;
    public ImageView mShareView;
    public int mSkinType;
    public TextView mTailContent;
    public View mTopLine;
    public View mTrisectionContainer;
    public UserIconBox mTshowIconBox;
    public TextView mUserNameView;
    public TextView mViewPostTimeAbove;
    public UserIconBox mVipIconBox;
    public LinearLayout ownerInfoRootView;
    public int pageFrom;
    public g pbHeadUegController;
    public View pbItemViewRoot;
    public FrameLayout uegFrameLayout;

    /* loaded from: classes13.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f46621e;

        public a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46621e = pbCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46621e.a.playAnimation();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbCommenFloorItemViewHolder(TbPageContext tbPageContext, View view, int i2) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSkinType = 3;
        this.mIsShowImage = true;
        this.mIsShowFlooorComplaint = Boolean.FALSE;
        this.mPosition = -1;
        if (tbPageContext == null || view == null) {
            return;
        }
        this.pbItemViewRoot = view;
        this.mTopLine = view.findViewById(i.top_divider_line);
        this.ownerInfoRootView = (LinearLayout) view.findViewById(i.pb_head_owner_info_root);
        this.mUserNameView = (TextView) view.findViewById(i.view_user_name);
        this.mFloorAuthorView = (TextView) view.findViewById(i.view_author_tip);
        this.mReplyTimeView = (TextView) view.findViewById(i.view_post_time);
        this.mForumLevelIcon = (ImageView) view.findViewById(i.icon_forum_level);
        this.mLocationView = (TextView) view.findViewById(i.view_location);
        this.mPostReplyContainer = view.findViewById(i.pb_post_reply_container);
        this.mCommentView = (ImageView) view.findViewById(i.post_info_commont_img);
        this.mShareView = (ImageView) view.findViewById(i.post_info_share_img);
        AgreeView agreeView = (AgreeView) view.findViewById(i.new_pb_floor_praise_view);
        this.mPbFloorPraiseView = agreeView;
        agreeView.setResourceId(k.pb_lottie_agree, k.pb_lottie_disagree);
        this.mPbFloorPraiseView.setNormalColorResourceId(f.CAM_X0109);
        this.mPbFloorPraiseView.adjustLayoutForPbFloor(false);
        this.mTrisectionContainer = view.findViewById(i.pb_floor_trisection_area);
        this.mBottomShareContainer = view.findViewById(i.pb_floor_share_container);
        this.mBottomCommentContainer = view.findViewById(i.pb_floor_comment_container);
        this.mBottomAgreeContainer = view.findViewById(i.pb_floor_agree_container);
        this.mBottomShareImg = (ImageView) view.findViewById(i.pb_floor_share_img);
        this.mBottomShareText = (TextView) view.findViewById(i.pb_floor_share_text);
        this.mBottomCommentImg = (ImageView) view.findViewById(i.pb_floor_comment_img);
        this.mBottomCommentText = (TextView) view.findViewById(i.pb_floor_comment_text);
        AgreeView agreeView2 = (AgreeView) view.findViewById(i.pb_floor_agree_view);
        this.mBottomAgreeView = agreeView2;
        agreeView2.setResourceId(k.pb_lottie_agree, k.pb_lottie_disagree);
        this.mBottomAgreeView.setNormalColorResourceId(f.CAM_X0109);
        this.mBottomAgreeView.adjustLayoutForPbFloor(true);
        this.mTrisectionContainer.setVisibility(8);
        this.mPostReplyContainer.setVisibility(0);
        this.mCommentView.setVisibility(0);
        this.mShareView.setVisibility(0);
        this.mPbFloorPraiseView.setVisibility(0);
        this.mFeedBackImg = (ImageView) view.findViewById(i.pb_floor_feedback);
        this.pageFrom = i2;
        c.a.t0.s.r.f fVar = new c.a.t0.s.r.f();
        fVar.f13841b = 5;
        fVar.f13847h = 8;
        fVar.f13846g = 2;
        fVar.f13845f = i2;
        this.mPbFloorPraiseView.setStatisticData(fVar);
        this.mHeadPhotoView = (HeadImageView) view.findViewById(i.normal_user_photo);
        HeadPendantView headPendantView = (HeadPendantView) view.findViewById(i.pendant_user_photo);
        this.mPendantHeadView = headPendantView;
        headPendantView.setHasPendantStyle();
        if (this.mPendantHeadView.getHeadView() != null) {
            this.mPendantHeadView.getHeadView().setIsRound(true);
            this.mPendantHeadView.getHeadView().setDrawBorder(true);
            this.mPendantHeadView.getHeadView().setPlaceHolder(1);
        }
        this.mVipIconBox = (UserIconBox) view.findViewById(i.show_icon_vip);
        this.mTshowIconBox = (UserIconBox) view.findViewById(i.show_icon_yinji);
        this.mRichTextView = (TbRichTextView) view.findViewById(i.richText);
        this.mReplyContentView = (SubPbLayout) view.findViewById(i.pb_post_footer_layout);
        this.mReplyCountView = (TextView) view.findViewById(i.pb_post_reply_count);
        this.mReplyCountView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(h.icon_pure_arrow12_right, SkinManager.getColor(f.CAM_X0107), null), (Drawable) null);
        this.mReplyCountView.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(c.a.u0.u2.g.tbds4));
        this.mReplyCountView.setTextSize(0, n.f(TbadkCoreApplication.getInst(), c.a.u0.u2.g.T_X07));
        this.mReplyView = (TextView) view.findViewById(i.pb_post_reply);
        this.mImagesView = (ConstrainImageGroup) view.findViewById(i.floor_images_content);
        this.mBottomLine = view.findViewById(i.pb_bottom_line);
        this.mFloorNum = (TextView) view.findViewById(i.floor_num);
        this.mPointRightFloor = (TextView) view.findViewById(i.point_between_floor_and_time);
        this.mPointRightPostTime = (TextView) view.findViewById(i.point_between_time_and_locate);
        this.mImagesView.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c.a.u0.u2.g.ds16));
        this.mImagesView.setSingleImageRatio(0.75d);
        this.mImagesView.setImageProcessor(new c.a.t0.f1.j.f(3));
        e eVar = new e(this.mRichTextView.getLayoutStrategy());
        eVar.j(n.f(TbadkCoreApplication.getInst().getContext(), c.a.u0.u2.g.tbds18));
        eVar.o(TbConfig.getPostLineSpace(), 1.0f);
        this.mRichTextView.setLayoutStrategy(eVar);
        this.mRichTextView.setIsNeedResizeEmotion(true);
        this.mRichTextView.setTextSize(TbConfig.getContentSize());
        this.mHeadPhotoView.setIsRound(true);
        this.mHeadPhotoView.setGodIconWidth(c.a.u0.u2.g.tbds36);
        this.mHeadPhotoView.setPlaceHolder(1);
        this.mRichTextView.setDisplayImage(this.mIsShowImage, false);
        this.mRichTextView.setVoiceViewRes(j.voice_play_btn_new);
        this.mTailContent = (TextView) view.findViewById(i.pb_item_tail_content);
        this.mRecommendLiveLayout = (LinearLayout) view.findViewById(i.pb_post_recommend_live_layout);
        this.mRecommendLivePrefixTv = (TextView) view.findViewById(i.pb_post_recommend_live_prefix_tv);
        this.mRecommendLiveDividerView = view.findViewById(i.pb_post_recommend_live_divider);
        this.mRecommendLiveTitleView = (TextView) view.findViewById(i.pb_post_recommend_live_title);
        this.mRecommendLiveArrowView = (ImageView) view.findViewById(i.pb_post_recommend_live_arrow);
        this.mAllContent = (LinearLayout) view.findViewById(i.all_content);
        this.mFoldOpArea = (LinearLayout) view.findViewById(i.fold_op_area);
        this.mFoldTitleView = (TextView) view.findViewById(i.fold_title);
        this.mImgGodComment = (ImageView) view.findViewById(i.pic_comment_god);
        this.mPbFloorComplaint = (PbFloorComplaint) view.findViewById(i.pb_floor_complaint);
        if (this.mIsShowFlooorComplaint.booleanValue()) {
            this.mPbFloorComplaint.setVisibility(0);
        } else {
            this.mPbFloorComplaint.setVisibility(8);
        }
        this.a = (TBLottieAnimationView) view.findViewById(i.user_living_lottie);
        this.mPbRightTopLayout = (ViewGroup) view.findViewById(i.pb_floor_right_top_layout);
        this.mPbRightTopAgreeView = (AgreeView) view.findViewById(i.pb_floor_right_top_agree_view);
        this.mPbRightTopMoreView = (ImageView) view.findViewById(i.pb_floor_right_top_feedback);
        this.mPbRightTopAgreeView.setResourceId(k.pb_lottie_agree, k.pb_lottie_disagree);
        this.mPbRightTopAgreeView.setNormalColorResourceId(f.CAM_X0109);
        this.mPbRightTopAgreeView.adjustLayoutForPbFloor(false);
        this.mPbRightTopAgreeView.setAgreeAlone(true);
        this.mPbRightTopAgreeView.setStatisticData(fVar);
        this.mPbPostReplyLayoutAbove = (ViewGroup) view.findViewById(i.pb_post_reply_layout_above);
        this.mViewPostTimeAbove = (TextView) view.findViewById(i.view_post_time_above);
        this.mBtnPostAbove = (TextView) view.findViewById(i.btn_post_above);
        this.mBtnOpMore = (ImageView) view.findViewById(i.pb_post_op_more);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(i.ueg_root);
        this.uegFrameLayout = frameLayout;
        g gVar = new g(tbPageContext, frameLayout);
        this.pbHeadUegController = gVar;
        gVar.f23475f = 3;
        this.mMaskView = (MaskView) view.findViewById(i.mask_view_op);
    }

    public void handleUegSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.pbHeadUegController.d();
            MaskView maskView = this.mMaskView;
            if (maskView != null) {
                maskView.onChangeSkin();
            }
            PbFloorComplaint pbFloorComplaint = this.mPbFloorComplaint;
            if (pbFloorComplaint != null) {
                pbFloorComplaint.setBackgroundColor(f.CAM_X0206);
                c d2 = c.d(this.mPbFloorComplaint);
                d2.m(0);
                d2.n(l.J_X05);
                d2.f(f.CAM_X0206);
                this.mPbFloorComplaint.onChangeSkinType();
            }
        }
    }

    public void handleUserAlaLiveSkinType(int i2) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (tBLottieAnimationView = this.a) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, k.card_live_header_bg);
    }

    public void handleUserAlaLiveState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.a.setVisibility(0);
                if (this.a.isAnimating()) {
                    return;
                }
                this.a.setSpeed(0.8f);
                this.a.setRepeatCount(-1);
                this.a.post(new a(this));
                return;
            }
            this.a.setVisibility(8);
            if (this.a.isAnimating()) {
                this.a.cancelAnimation();
            }
        }
    }

    public void setIsSubPb(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && z) {
            c.a.t0.s.r.f fVar = new c.a.t0.s.r.f();
            fVar.f13841b = 12;
            fVar.f13847h = 9;
            fVar.f13846g = 3;
            fVar.f13845f = this.pageFrom;
            this.mPbFloorPraiseView.setStatisticData(fVar);
        }
    }

    public void updateUegInfo(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.pbHeadUegController.f(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mAllContent.getLayoutParams();
            if (z) {
                this.uegFrameLayout.setVisibility(0);
                layoutParams.addRule(3, i.ueg_root);
            } else {
                this.uegFrameLayout.setVisibility(8);
                layoutParams.addRule(3, i.item_head_owner_root);
            }
            this.mAllContent.setLayoutParams(layoutParams);
            MaskView maskView = this.mMaskView;
            if (maskView != null) {
                maskView.setVisibility(8);
            }
            handleUegSkin();
        }
    }
}
