package com.baidu.tieba.pb.pb.main;

import android.graphics.Matrix;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import c.a.e.e.m.b;
import c.a.e.e.p.l;
import c.a.q0.s.q.d2;
import c.a.r0.k2.k.e.e;
import c.a.r0.k2.k.e.g1.a;
import c.a.r0.k2.k.e.q0;
import c.a.r0.k2.k.e.s;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PbFirstFloorViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f55015a;

    /* renamed from: b  reason: collision with root package name */
    public View f55016b;
    public AppletsCellView mAppletsCellView;
    public View mBottomDivider;
    public ThreadForumEnterButtonContainer mForumEnterButtonContainer;
    public TbImageView mGameBanner;
    public TbImageView mHeadMask;
    public LinearLayout mLinkContainer;
    public a mManagerSelectView;
    public c.a.r0.k2.k.e.d1.a mOriginalThreadView;
    public FrameLayout mOrignalThreadRootView;
    public PbBusinessPromotionContainer mPbBusinessPromotionContainer;
    public ThreadSkinView mPbItemSkinView;
    public LinearLayout mPbListContent;
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
        ImageView imageView = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.f55015a = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -q0.g());
        this.f55015a.setImageMatrix(matrix);
        this.f55016b = view.findViewById(R.id.blank_view_above_rich_text);
        this.richText = (TbRichTextView) view.findViewById(R.id.richText);
        this.pbItemViewRoot = view;
        int k = (((l.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.richText.getPaddingLeft()) - this.richText.getPaddingRight();
        e eVar = new e(this.richText.getLayoutStrategy());
        eVar.G = k;
        this.richText.setLayoutStrategy(eVar);
        this.mGameBanner = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(k - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i2);
        this.richText.getLayoutStrategy().q(min);
        this.richText.getLayoutStrategy().p((int) (min * 1.618f));
        this.richText.setIsNeedResizeEmotion(true);
        this.richText.setTextSize(TbConfig.getContentSize());
        this.richText.setDisplayImage(z, false);
        this.richText.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.mBottomDivider = view.findViewById(R.id.divider_bottom_first_floor);
        this.mHeadMask = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.mPbItemSkinView = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.mPbListContent = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.mTailContent = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.mAppletsCellView = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.mLinkContainer = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        this.mVoteTailTv = (TextView) view.findViewById(R.id.pb_tail_text);
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.mForumEnterButtonContainer = threadForumEnterButtonContainer;
        threadForumEnterButtonContainer.setFrom(1);
        this.mManagerSelectView = new a(tbPageContext);
        this.mPbBusinessPromotionContainer = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.mOrignalThreadRootView = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
        VoteView voteView = (VoteView) view.findViewById(R.id.vote_view);
        this.mVoteView = voteView;
        voteView.setPageContext(tbPageContext);
        this.mYoungsterTipTv = (TextView) view.findViewById(R.id.tv_youngster_tip);
    }

    public void showBlankViewAboveRichText(boolean z, int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (view = this.f55016b) == null) {
            return;
        }
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.height = i2;
            this.f55016b.setLayoutParams(layoutParams);
            this.f55016b.setVisibility(0);
            return;
        }
        view.setVisibility(8);
    }

    public void showForumEnterButton(@NonNull c.a.r0.k2.h.e eVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{eVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.mForumEnterButtonContainer == null || eVar == null || eVar.m() == null) {
            return;
        }
        if (eVar.f0() && eVar.q0()) {
            this.mForumEnterButtonContainer.setVisibility(8);
            return;
        }
        this.mForumEnterButtonContainer.setBottomPlaceHolderVisibility(z2);
        if (!z) {
            ListUtils.isEmpty(eVar.q());
        }
        d2 d2Var = new d2();
        d2Var.N3(eVar.Q());
        d2Var.D3(b.g(eVar.m().getId(), 0L));
        d2Var.H3(eVar.m().getName());
        d2Var.E3(eVar.m().getFirst_class());
        d2Var.q4(eVar.m().getSecond_class());
        if (eVar.O() != null) {
            d2Var.y4(eVar.O().i0);
        }
        if (eVar.f19811i) {
            this.mForumEnterButtonContainer.setVisibility(8);
            this.mPbBusinessPromotionContainer.bindForumData(d2Var, eVar.h(), eVar.q0());
            return;
        }
        this.mPbBusinessPromotionContainer.setVisibility(8);
    }

    public void showThreadTypeStampBottomPart(c.a.r0.k2.h.e eVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{eVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (eVar != null && eVar.f19812j) {
                this.f55015a.setImageResource(R.drawable.pic_frs_headlines_n);
                this.f55015a.setVisibility(0);
            } else if (z && z2) {
                this.f55015a.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.f55015a.setVisibility(0);
            } else if (z) {
                this.f55015a.setImageResource(R.drawable.pic_pb_refined_n);
                this.f55015a.setVisibility(0);
            } else if (z2) {
                this.f55015a.setImageResource(R.drawable.pic_pb_stick_n);
                this.f55015a.setVisibility(0);
            } else {
                this.f55015a.setVisibility(8);
            }
        }
    }
}
