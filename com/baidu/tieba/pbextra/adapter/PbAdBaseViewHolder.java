package com.baidu.tieba.pbextra.adapter;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.q0.e.c;
import c.a.r0.j2.k.e.g1.d;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.view.TriangleShapeView;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.tbadkCore.FrsPraiseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PbAdBaseViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public UserIconBox f55852a;
    public TextView floor;
    public TextView floorOwner;
    public PbGiftListView giftListView;
    public HeadImageView headPhoto;
    public FrameLayout lottery_tail;
    public GifView lottery_tail_gifview;
    public TbImageView lottery_tail_normal;
    public TextView mActBtn;
    public TbImageView mActImg;
    public LinearLayout mAddPostLayout;
    public View mAdditionDivider1;
    public View mAdditionDivider2;
    public TextView mAdditionMore;
    public LinearLayout mAdditionMoreContainer;
    public RelativeLayout mFloorInfoLayout;
    public SubPbLayout mFooterLayout;
    public TbImageView mGameBanner;
    public ClickableHeaderImageView mGodHeadImageView;
    public TbImageView mHeadMask;
    public ViewStub mHeadMaskViewStub;
    public RelativeLayout mHeaderLayout;
    public LinearLayout mMiddleLayout;
    public TextView mPbFirstFloorLocation;
    public RelativeLayout mPbFirstFloorLocationContainer;
    public TextView mPbFirstFloorRepTime;
    public TextView mPbFristFloorName;
    public ThreadSkinView mPbItemSkinView;
    public LinearLayout mPbListContent;
    public TriangleShapeView mPbTriangleShapeView;
    public d mPbVideoExtraViewHolder;
    public ImageView mReplyBtn;
    public View mReplyCoverView;
    public int mSkinType;
    public TextView mTailContent;
    public RelativeLayout mUserHeadLayout;
    public UserIconBox mUserIconLayout;
    public View pbItemLineFull;
    public View pbItemTopEmptyView;
    public View pbItemViewRoot;
    public TextView pb_reply_location_address;
    public HeadPendantView pendantHeadPhoto;
    public TextView postTime;
    public ImageView praiseBottomLine;
    public FrsPraiseView praiseView;
    public TbRichTextView richText;
    public View subPbViewRoot;
    public ImageView userBawu;
    public TextView userName;
    public View userOnLiving;
    public ImageView userRank;
    public TbImageView yuleHeadImg;
    public TextView yuleHeadImgAllRank;
    public RelativeLayout yuleHeadImgContainer;
    public View yuleHeadImgDivider;
    public TextView yuleHeadImgPicAuthor;
    public TextView yuleHeadImgPostAuthor;
    public TextView yuleHeadImgRank;
    public TextView yuleHeadImgUpInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbAdBaseViewHolder(TbPageContext tbPageContext, View view, boolean z, int i2) {
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
        this.subPbViewRoot = view.findViewById(R.id.sub_pb_more);
        this.mUserHeadLayout = (RelativeLayout) view.findViewById(R.id.user_head_layout);
        this.headPhoto = (HeadImageView) view.findViewById(R.id.photo);
        this.pendantHeadPhoto = (HeadPendantView) view.findViewById(R.id.pendant_photo);
        this.mHeadMaskViewStub = (ViewStub) view.findViewById(R.id.viewstub_headimage_mask);
        this.headPhoto.setRadius(l.g(view.getContext(), R.dimen.ds30));
        this.pendantHeadPhoto.setHasPendantStyle();
        if (this.pendantHeadPhoto.getHeadView() != null) {
            this.pendantHeadPhoto.getHeadView().setIsRound(true);
            this.pendantHeadPhoto.getHeadView().setDrawBorder(false);
        }
        if (this.pendantHeadPhoto.getPendantView() != null) {
            this.pendantHeadPhoto.getPendantView().setIsRound(true);
            this.pendantHeadPhoto.getPendantView().setDrawBorder(false);
        }
        this.userName = (TextView) view.findViewById(R.id.user_name);
        this.userRank = (ImageView) view.findViewById(R.id.user_rank);
        this.userBawu = (ImageView) view.findViewById(R.id.user_bawu);
        this.richText = (TbRichTextView) view.findViewById(R.id.richText);
        this.pbItemLineFull = view.findViewById(R.id.new_pb_list_item_line_full);
        this.giftListView = (PbGiftListView) view.findViewById(R.id.gift_list_view);
        this.praiseView = (FrsPraiseView) view.findViewById(R.id.pb_item_praise_view);
        this.praiseBottomLine = (ImageView) view.findViewById(R.id.pb_item_praise_bottomline);
        this.mPbFirstFloorLocationContainer = (RelativeLayout) view.findViewById(R.id.pb_first_floor_location_container);
        this.mPbFristFloorName = (TextView) view.findViewById(R.id.pb_item_first_floor_name);
        this.mPbFirstFloorRepTime = (TextView) view.findViewById(R.id.pb_item_first_floor_reply_time);
        this.mPbFirstFloorLocation = (TextView) view.findViewById(R.id.pb_item_first_floor_location_address);
        this.pb_reply_location_address = (TextView) view.findViewById(R.id.pb_reply_location_address);
        this.mFloorInfoLayout = (RelativeLayout) view.findViewById(R.id.pb_item_floor_layout);
        this.floorOwner = (TextView) view.findViewById(R.id.floor_owner);
        this.floor = (TextView) view.findViewById(R.id.floor);
        this.postTime = (TextView) view.findViewById(R.id.time);
        this.mHeaderLayout = (RelativeLayout) view.findViewById(R.id.pb_post_header_layout);
        this.mFooterLayout = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
        this.pbItemViewRoot = view;
        this.pbItemTopEmptyView = view.findViewById(R.id.new_pb_list_item_blank_top);
        this.richText.getLayoutStrategy().t();
        this.richText.getLayoutStrategy().k(true);
        this.mGameBanner = (TbImageView) view.findViewById(R.id.game_activity_banner);
        this.mActBtn = (TextView) view.findViewById(R.id.action_button);
        this.mActImg = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(((((l.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.richText.getPaddingLeft()) - this.richText.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i2);
        this.richText.getLayoutStrategy().q(min);
        this.richText.getLayoutStrategy().p((int) (min * 1.618f));
        this.richText.setTextSize(TbConfig.getContentSize());
        this.richText.setDisplayImage(z, false);
        this.richText.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.mUserIconLayout = (UserIconBox) view.findViewById(R.id.user_icon_box);
        this.f55852a = (UserIconBox) view.findViewById(R.id.user_tshow_icon_box);
        this.mAddPostLayout = (LinearLayout) view.findViewById(R.id.add_post_footer_layout);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.addition_more_container);
        this.mAdditionMoreContainer = linearLayout;
        this.mAdditionMore = (TextView) linearLayout.findViewById(R.id.addition_more);
        this.mAdditionDivider1 = this.mAdditionMoreContainer.findViewById(R.id.addition_divider1);
        this.mAdditionDivider2 = this.mAdditionMoreContainer.findViewById(R.id.addition_divider2);
        this.mTailContent = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.mReplyBtn = (ImageView) view.findViewById(R.id.replybtn);
        this.mReplyCoverView = view.findViewById(R.id.cover_reply_content);
        this.mGodHeadImageView = (ClickableHeaderImageView) view.findViewById(R.id.god_user_photo);
        this.mHeadMask = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.mGodHeadImageView.setGodIconMargin(0);
        this.mGodHeadImageView.setGodIconWidth(R.dimen.tbds36);
        this.lottery_tail = (FrameLayout) view.findViewById(R.id.lottery_tail);
        this.lottery_tail_normal = (TbImageView) view.findViewById(R.id.lottery_tail_normalview);
        this.lottery_tail_gifview = (GifView) view.findViewById(R.id.lottery_tail_gifview);
        this.mPbItemSkinView = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.mMiddleLayout = (LinearLayout) view.findViewById(R.id.middle);
        this.mPbListContent = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.mPbVideoExtraViewHolder = new d(tbPageContext, view);
        this.mPbTriangleShapeView = (TriangleShapeView) view.findViewById(R.id.triangle_view);
        View a2 = c.b().a(tbPageContext.getPageActivity(), 3);
        this.userOnLiving = a2;
        if (a2 != null) {
            this.mMiddleLayout.addView(a2, 2);
            this.userOnLiving.setVisibility(8);
        }
    }

    public void initYuleHeadImg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.yuleHeadImgContainer == null) {
                this.yuleHeadImgContainer = (RelativeLayout) ((ViewStub) this.pbItemViewRoot.findViewById(R.id.pb_yule_head_img_container)).inflate();
            }
            this.yuleHeadImgContainer.setVisibility(0);
            if (this.yuleHeadImg == null) {
                this.yuleHeadImg = (TbImageView) this.pbItemViewRoot.findViewById(R.id.yule_head_img_img);
            }
            if (this.yuleHeadImgPicAuthor == null) {
                this.yuleHeadImgPicAuthor = (TextView) this.pbItemViewRoot.findViewById(R.id.yule_head_img_pic_author);
            }
            if (this.yuleHeadImgPostAuthor == null) {
                this.yuleHeadImgPostAuthor = (TextView) this.pbItemViewRoot.findViewById(R.id.yule_head_img_post_author);
            }
            if (this.yuleHeadImgAllRank == null) {
                this.yuleHeadImgAllRank = (TextView) this.pbItemViewRoot.findViewById(R.id.yule_head_img_all_rank);
            }
            if (this.yuleHeadImgDivider == null) {
                this.yuleHeadImgDivider = this.pbItemViewRoot.findViewById(R.id.yule_head_img_header_divider);
            }
            if (this.yuleHeadImgRank == null) {
                this.yuleHeadImgRank = (TextView) this.pbItemViewRoot.findViewById(R.id.yule_head_img_rank);
            }
            if (this.yuleHeadImgUpInfo == null) {
                this.yuleHeadImgUpInfo = (TextView) this.pbItemViewRoot.findViewById(R.id.yule_head_img_up_info);
            }
        }
    }
}
