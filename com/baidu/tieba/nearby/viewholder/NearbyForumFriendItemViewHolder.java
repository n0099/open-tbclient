package com.baidu.tieba.nearby.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.s0.s.u.c;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class NearbyForumFriendItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACTIVE_STATUS_JUST_BEEN_TO = 2;
    public static final int ACTIVE_STATUS_OFFLINE = 3;
    public static final int ACTIVE_STATUS_ONLINE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public HeadImageView mForumFriendItemHeadImg;
    public ImageView mIvForumFriendItemHi;
    public ImageView mIvForumFriendItemSex;
    public View mLayoutForumFriendItemHi;
    public View mLayoutForumFriendItemSexAge;
    public View mRootView;
    public TextView mTvForumFriendItemActiveStatus;
    public TextView mTvForumFriendItemAge;
    public TextView mTvForumFriendItemDistance;
    public TextView mTvForumFriendItemDot;
    public TextView mTvForumFriendItemHi;
    public TextView mTvForumFriendItemLabel;
    public TextView mTvForumFriendItemNickname;
    public TextView mTvForumFriendItemSign;
    public TextView mTvForumFriendItemSlogan;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyForumFriendItemViewHolder(View view, Context context) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, context};
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
        this.a = context;
        this.mRootView = view.findViewById(R.id.rootview);
        this.mForumFriendItemHeadImg = (HeadImageView) view.findViewById(R.id.img_forum_friend_item_head);
        this.mTvForumFriendItemNickname = (TextView) view.findViewById(R.id.tv_forum_friend_item_nickname);
        this.mTvForumFriendItemSlogan = (TextView) view.findViewById(R.id.tv_forum_friend_item_slogan);
        this.mLayoutForumFriendItemSexAge = view.findViewById(R.id.layout_forum_friend_item_sex_age);
        this.mIvForumFriendItemSex = (ImageView) view.findViewById(R.id.iv_forum_friend_item_sex);
        this.mTvForumFriendItemAge = (TextView) view.findViewById(R.id.tv_forum_friend_item_age);
        this.mTvForumFriendItemSign = (TextView) view.findViewById(R.id.tv_forum_friend_item_sign);
        this.mTvForumFriendItemDistance = (TextView) view.findViewById(R.id.tv_forum_friend_item_distance);
        this.mTvForumFriendItemLabel = (TextView) view.findViewById(R.id.tv_forum_friend_item_label);
        this.mLayoutForumFriendItemHi = view.findViewById(R.id.layout_forum_friend_item_hi);
        this.mIvForumFriendItemHi = (ImageView) view.findViewById(R.id.iv_forum_friend_item_hi);
        this.mTvForumFriendItemHi = (TextView) view.findViewById(R.id.tv_forum_friend_item_hi);
        this.mTvForumFriendItemDot = (TextView) view.findViewById(R.id.tv_forum_friend_item_dot);
        this.mTvForumFriendItemActiveStatus = (TextView) view.findViewById(R.id.tv_forum_friend_item_active_status);
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mForumFriendItemHeadImg.setConrers(15);
            this.mForumFriendItemHeadImg.setIsRound(true);
            this.mForumFriendItemHeadImg.setPlaceHolder(3);
            c d2 = c.d(this.mTvForumFriendItemNickname);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X06);
            c d3 = c.d(this.mTvForumFriendItemAge);
            d3.A(R.string.F_X01);
            d3.z(R.dimen.T_X10);
            c d4 = c.d(this.mTvForumFriendItemSign);
            d4.A(R.string.F_X01);
            d4.z(R.dimen.T_X10);
            c d5 = c.d(this.mTvForumFriendItemDistance);
            d5.A(R.string.F_X01);
            d5.z(R.dimen.T_X10);
            c d6 = c.d(this.mTvForumFriendItemDot);
            d6.A(R.string.F_X01);
            d6.z(R.dimen.T_X10);
            c d7 = c.d(this.mTvForumFriendItemActiveStatus);
            d7.z(R.string.F_X01);
            d7.z(R.dimen.T_X10);
            c d8 = c.d(this.mTvForumFriendItemHi);
            d8.A(R.string.F_X01);
            d8.z(R.dimen.T_X08);
            c d9 = c.d(this.mTvForumFriendItemLabel);
            d9.A(R.string.F_X01);
            d9.z(R.dimen.T_X10);
            c d10 = c.d(this.mTvForumFriendItemSlogan);
            d10.A(R.string.F_X01);
            d10.z(R.dimen.T_X08);
        }
    }
}
