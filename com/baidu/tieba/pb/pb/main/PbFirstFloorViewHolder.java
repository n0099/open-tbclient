package com.baidu.tieba.pb.pb.main;

import android.graphics.Matrix;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import c.a.d.f.m.b;
import c.a.d.f.p.n;
import c.a.s0.s.q.d2;
import c.a.t0.s2.g;
import c.a.t0.s2.h;
import c.a.t0.s2.i;
import c.a.t0.s2.j;
import c.a.t0.s2.r.f;
import c.a.t0.s2.u.f.e;
import c.a.t0.s2.u.f.h1.a;
import c.a.t0.s2.u.f.r0;
import c.a.t0.s2.u.f.s;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.NovelInfoCardView;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class PbFirstFloorViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public View f48254b;
    public AppletsCellView mAppletsCellView;
    public View mBottomDivider;
    public View mContentReadMoreMaskView;
    public ThreadForumEnterButtonContainer mForumEnterButtonContainer;
    public TbImageView mGameBanner;
    public TbImageView mHeadMask;
    public LinearLayout mLinkContainer;
    public a mManagerSelectView;
    public NovelInfoCardView mNovelInfoCardView;
    public c.a.t0.s2.u.f.e1.a mOriginalThreadView;
    public FrameLayout mOrignalThreadRootView;
    public PbBusinessPromotionContainer mPbBusinessPromotionContainer;
    public ThreadSkinView mPbItemSkinView;
    public LinearLayout mPbListContent;
    public View mReadMoreButton;
    public TextView mReadMoreButtonText;
    public ImageView mReadMoreIcon;
    public int mSkinType;
    public TextView mTailContent;
    public s mViewStubController;
    public TextView mVoteTailTv;
    public VoteView mVoteView;
    public TextView mYoungsterTipTv;
    public View pbItemTopEmptyView;
    public View pbItemViewRoot;
    public TbRichTextView richText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorViewHolder(TbPageContext tbPageContext, View view, boolean z, int i2) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, Boolean.valueOf(z), Integer.valueOf(i2)};
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
        this.mViewStubController = new s(view);
        ImageView imageView = (ImageView) view.findViewById(i.pb_thread_type_stamp_first_floor_bottom_part);
        this.a = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -r0.g());
        this.a.setImageMatrix(matrix);
        this.f48254b = view.findViewById(i.blank_view_above_rich_text);
        this.richText = (TbRichTextView) view.findViewById(i.richText);
        this.pbItemViewRoot = view;
        int k2 = (((n.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.richText.getPaddingLeft()) - this.richText.getPaddingRight();
        e eVar = new e(this.richText.getLayoutStrategy());
        eVar.G = k2;
        this.richText.setLayoutStrategy(eVar);
        this.mGameBanner = (TbImageView) view.findViewById(i.game_activity_banner);
        int min = Math.min(k2 - ((int) TbadkCoreApplication.getInst().getResources().getDimension(g.ds60)), i2);
        this.richText.getLayoutStrategy().q(min);
        this.richText.getLayoutStrategy().p((int) (min * 1.618f));
        this.richText.setIsNeedResizeEmotion(true);
        this.richText.setTextSize(TbConfig.getContentSize());
        this.richText.setDisplayImage(z, false);
        this.richText.setVoiceViewRes(j.voice_play_btn_new);
        this.mBottomDivider = view.findViewById(i.divider_bottom_first_floor);
        this.mHeadMask = (TbImageView) view.findViewById(i.user_head_mask);
        this.mPbItemSkinView = (ThreadSkinView) view.findViewById(i.pb_item_thread_skin);
        this.mPbListContent = (LinearLayout) view.findViewById(i.pb_list_content);
        this.mTailContent = (TextView) view.findViewById(i.pb_item_tail_content);
        this.mAppletsCellView = (AppletsCellView) view.findViewById(i.card_pb_page_first_floor_thread_share);
        this.mNovelInfoCardView = (NovelInfoCardView) view.findViewById(i.card_pb_page_first_floor_novel_card);
        this.mContentReadMoreMaskView = view.findViewById(i.content_mask_gradual_view);
        this.mReadMoreButton = view.findViewById(i.read_more_pay_btn);
        this.mReadMoreIcon = (ImageView) view.findViewById(i.read_more_pay_btn_icon);
        this.mReadMoreButtonText = (TextView) view.findViewById(i.read_more_pay_btn_text);
        this.mReadMoreButton.setClickable(true);
        this.mLinkContainer = (LinearLayout) view.findViewById(i.pb_link_container_layout);
        this.mVoteTailTv = (TextView) view.findViewById(i.pb_tail_text);
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer = (ThreadForumEnterButtonContainer) view.findViewById(i.pb_fourm_name_container);
        this.mForumEnterButtonContainer = threadForumEnterButtonContainer;
        threadForumEnterButtonContainer.setFrom(1);
        this.mManagerSelectView = new a(tbPageContext);
        this.mPbBusinessPromotionContainer = (PbBusinessPromotionContainer) view.findViewById(i.pb_business_promotion_container);
        this.mOrignalThreadRootView = (FrameLayout) view.findViewById(i.original_thread_root_view);
        VoteView voteView = (VoteView) view.findViewById(i.vote_view);
        this.mVoteView = voteView;
        voteView.setPageContext(tbPageContext);
        this.mYoungsterTipTv = (TextView) view.findViewById(i.tv_youngster_tip);
    }

    public void showBlankViewAboveRichText(boolean z, int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (view = this.f48254b) == null) {
            return;
        }
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.height = i2;
            this.f48254b.setLayoutParams(layoutParams);
            this.f48254b.setVisibility(0);
            return;
        }
        view.setVisibility(8);
    }

    public void showForumEnterButton(@NonNull f fVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{fVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.mForumEnterButtonContainer == null || fVar == null || fVar.l() == null) {
            return;
        }
        if (fVar.g0() && fVar.r0()) {
            this.mForumEnterButtonContainer.setVisibility(8);
            return;
        }
        this.mForumEnterButtonContainer.setBottomPlaceHolderVisibility(z2);
        if (!z) {
            ListUtils.isEmpty(fVar.p());
        }
        d2 d2Var = new d2();
        d2Var.S3(fVar.Q());
        d2Var.I3(b.g(fVar.l().getId(), 0L));
        d2Var.M3(fVar.l().getName());
        d2Var.J3(fVar.l().getFirst_class());
        d2Var.v4(fVar.l().getSecond_class());
        if (fVar.O() != null) {
            d2Var.D4(fVar.O().d0);
        }
        if (fVar.f23041i) {
            this.mForumEnterButtonContainer.setVisibility(8);
            this.mPbBusinessPromotionContainer.bindForumData(d2Var, fVar.h(), fVar.r0());
            return;
        }
        this.mPbBusinessPromotionContainer.setVisibility(8);
    }

    public void showThreadTypeStampBottomPart(f fVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{fVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (fVar != null && fVar.f23042j) {
                this.a.setImageResource(h.pic_frs_headlines_n);
                this.a.setVisibility(0);
            } else if (z && z2) {
                this.a.setImageResource(h.pic_pb_stick_refined_n);
                this.a.setVisibility(0);
            } else if (z) {
                this.a.setImageResource(h.pic_pb_refined_n);
                this.a.setVisibility(0);
            } else if (z2) {
                this.a.setImageResource(h.pic_pb_stick_n);
                this.a.setVisibility(0);
            } else {
                this.a.setVisibility(8);
            }
        }
    }
}
