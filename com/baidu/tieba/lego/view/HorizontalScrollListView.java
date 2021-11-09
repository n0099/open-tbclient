package com.baidu.tieba.lego.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.r0.b0.u;
import b.a.r0.l3.w;
import b.a.r0.q1.i;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.HorRankCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class HorizontalScrollListView extends MyHorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f51256e;

    /* renamed from: f  reason: collision with root package name */
    public int f51257f;

    /* renamed from: g  reason: collision with root package name */
    public int f51258g;

    /* renamed from: h  reason: collision with root package name */
    public int f51259h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f51260i;
    public final ArrayList<ItemViewHolder> j;
    public int k;
    public TbPageContext l;

    /* loaded from: classes9.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView mBtnPost;
        public TbImageView mForumAvatarIcon;
        public HeadImageView mForumAvatarImageView;
        public TextView mForumNameTextView;
        public ImageView mLeftBack;
        public FrameLayout mLeftFrame;
        public ImageView mLeftIcon;
        public TextView mLeftText;
        public TextView mLeftTop;
        public LinearLayout mNameLayout;
        public LinearLayout mPostLayout;
        public LinearLayout mSubtitleLayout;
        public TextView mSubtitleTextView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
            this.mLeftIcon = null;
            this.mLeftFrame = null;
            this.mLeftBack = null;
            this.mLeftText = null;
            this.mForumAvatarImageView = null;
            this.mForumAvatarIcon = null;
            this.mForumNameTextView = null;
            this.mSubtitleLayout = null;
            this.mSubtitleTextView = null;
            this.mLeftTop = null;
            this.mPostLayout = null;
            this.mBtnPost = null;
            this.mNameLayout = (LinearLayout) view.findViewById(R.id.ll_name);
            this.mLeftFrame = (FrameLayout) view.findViewById(R.id.fl_left);
            this.mLeftBack = (ImageView) view.findViewById(R.id.leftBack);
            this.mLeftIcon = (ImageView) view.findViewById(R.id.leftIcon);
            this.mLeftText = (TextView) view.findViewById(R.id.leftText);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.head);
            this.mForumAvatarImageView = headImageView;
            headImageView.setGifIconSupport(false);
            this.mForumAvatarIcon = (TbImageView) view.findViewById(R.id.head_icon);
            this.mForumNameTextView = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.mSubtitleLayout = (LinearLayout) view.findViewById(R.id.ll_subtitle);
            this.mSubtitleTextView = (TextView) view.findViewById(R.id.subtitle);
            this.mLeftTop = (TextView) view.findViewById(R.id.leftTopText);
            this.mPostLayout = (LinearLayout) view.findViewById(R.id.ll_post);
            this.mBtnPost = (TextView) view.findViewById(R.id.btn_post);
        }
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorRankCard.a f51261e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HorizontalScrollListView f51262f;

        public a(HorizontalScrollListView horizontalScrollListView, HorRankCard.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalScrollListView, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51262f = horizontalScrollListView;
            this.f51261e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f51261e.j)) {
                return;
            }
            u.b().d(true);
            i.e(this.f51261e.m).d(TiebaStatic.Params.OBJ_URL, this.f51261e.j).a(this.f51261e.m);
            w.c(this.f51262f.l, this.f51261e.j);
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorRankCard.a f51263e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HorizontalScrollListView f51264f;

        public b(HorizontalScrollListView horizontalScrollListView, HorRankCard.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalScrollListView, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51264f = horizontalScrollListView;
            this.f51263e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f51264f.getContext())) {
                b.a.r0.q1.m.b a2 = b.a.r0.q1.m.b.a();
                HorRankCard.a aVar = this.f51263e;
                a2.e(aVar, aVar.f51083f, null, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalScrollListView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51256e = false;
        this.j = new ArrayList<>();
        this.k = 3;
        f(context);
    }

    public final void b(RelativeLayout.LayoutParams layoutParams, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, layoutParams, i2) == null) {
            if (i2 == 0) {
                layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.ds24);
            } else {
                layoutParams.leftMargin = this.f51259h;
            }
        }
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? View.inflate(this.l.getPageActivity(), R.layout.card_horizontal_rank_list_item, null) : (View) invokeV.objValue;
    }

    public final void d(View view, HorRankCard.a aVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view, aVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || aVar == null || view == null || view.getTag() == null) {
            return;
        }
        if (z) {
            view.setPadding(0, 0, l.g(getContext(), R.dimen.ds24), l.g(getContext(), R.dimen.ds24));
        } else {
            view.setPadding(0, 0, 0, l.g(getContext(), R.dimen.ds24));
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        if (this.f51256e) {
            itemViewHolder.mForumAvatarImageView.setIsRound(true);
            itemViewHolder.mLeftTop.setVisibility(8);
            int i3 = aVar.f51078a;
            if (i3 <= 0) {
                itemViewHolder.mLeftIcon.setVisibility(8);
                itemViewHolder.mLeftFrame.setVisibility(8);
            } else if (i3 == 1) {
                itemViewHolder.mLeftIcon.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.mLeftIcon, R.drawable.icon_grade_star_no1);
                itemViewHolder.mLeftFrame.setVisibility(8);
            } else if (i3 == 2) {
                itemViewHolder.mLeftIcon.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.mLeftIcon, R.drawable.icon_grade_star_no2);
                itemViewHolder.mLeftFrame.setVisibility(8);
            } else if (i3 != 3) {
                itemViewHolder.mLeftFrame.setVisibility(0);
                itemViewHolder.mLeftBack.getDrawable().setColorFilter(SkinManager.getColor(R.color.CAM_X0204), PorterDuff.Mode.SRC);
                itemViewHolder.mLeftIcon.setVisibility(8);
                SkinManager.setViewTextColor(itemViewHolder.mLeftText, R.color.CAM_X0111);
                TextView textView = itemViewHolder.mLeftText;
                textView.setText("" + (i2 + 1));
            } else {
                itemViewHolder.mLeftIcon.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.mLeftIcon, R.drawable.icon_grade_star_no3);
                itemViewHolder.mLeftFrame.setVisibility(8);
            }
        } else {
            itemViewHolder.mForumAvatarImageView.setIsRound(false);
            SkinManager.setViewTextColor(itemViewHolder.mLeftTop, R.color.CAM_X0111);
            itemViewHolder.mLeftIcon.setVisibility(8);
            itemViewHolder.mLeftFrame.setVisibility(8);
            if (aVar.f51078a <= 0) {
                itemViewHolder.mLeftTop.setVisibility(8);
            } else {
                itemViewHolder.mLeftTop.setVisibility(0);
                itemViewHolder.mLeftTop.setText(String.valueOf(aVar.f51078a));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    if (!b.a.r0.q1.o.k.b.a(aVar.l)) {
                        itemViewHolder.mLeftTop.setBackgroundColor(aVar.l);
                    } else {
                        SkinManager.setBackgroundColor(itemViewHolder.mLeftTop, b.a.r0.q1.a.f22568a[i2 <= 3 ? i2 : 3]);
                    }
                } else if (!b.a.r0.q1.o.k.b.a(aVar.k)) {
                    itemViewHolder.mLeftTop.setBackgroundColor(aVar.k);
                } else {
                    SkinManager.setBackgroundColor(itemViewHolder.mLeftTop, b.a.r0.q1.a.f22568a[i2 <= 3 ? i2 : 3]);
                }
            }
            itemViewHolder.mForumAvatarImageView.setRadius(0);
        }
        if (!TextUtils.isEmpty(aVar.j)) {
            itemViewHolder.mForumAvatarImageView.setOnClickListener(new a(this, aVar));
        } else {
            itemViewHolder.mForumAvatarImageView.setOnClickListener(null);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) itemViewHolder.mForumAvatarImageView.getLayoutParams();
        layoutParams.width = this.f51257f;
        layoutParams.height = this.f51258g;
        b(layoutParams, i2);
        if (this.f51256e) {
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.ds10);
        } else {
            layoutParams.topMargin = 0;
        }
        itemViewHolder.mForumAvatarImageView.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) itemViewHolder.mLeftTop.getLayoutParams();
        b(layoutParams2, i2);
        itemViewHolder.mLeftTop.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) itemViewHolder.mNameLayout.getLayoutParams();
        layoutParams3.width = this.f51257f;
        b(layoutParams3, i2);
        itemViewHolder.mNameLayout.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) itemViewHolder.mSubtitleLayout.getLayoutParams();
        layoutParams4.width = this.f51257f;
        b(layoutParams4, i2);
        itemViewHolder.mSubtitleLayout.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) itemViewHolder.mPostLayout.getLayoutParams();
        layoutParams5.width = this.f51257f;
        b(layoutParams5, i2);
        itemViewHolder.mPostLayout.setLayoutParams(layoutParams5);
        itemViewHolder.mForumAvatarImageView.setTag(aVar.f51079b);
        itemViewHolder.mForumAvatarImageView.startLoad(aVar.f51079b, 10, false);
        if (!TextUtils.isEmpty(aVar.f51080c)) {
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) itemViewHolder.mForumAvatarIcon.getLayoutParams();
            int g2 = l.g(getContext(), R.dimen.ds30);
            int g3 = l.g(getContext(), R.dimen.ds6);
            int g4 = l.g(getContext(), R.dimen.ds18);
            int i4 = ((this.f51257f - g2) + this.f51259h) - g3;
            if (i2 == 0) {
                i4 = (i4 - g4) + g3;
            }
            layoutParams6.setMargins(i4, (this.f51258g - g2) + g3, 0, 0);
            itemViewHolder.mForumAvatarIcon.setLayoutParams(layoutParams6);
            itemViewHolder.mForumAvatarIcon.startLoad(aVar.f51080c, 10, false);
        } else {
            itemViewHolder.mForumAvatarIcon.setVisibility(8);
        }
        if (aVar.f51081d != null) {
            itemViewHolder.mForumNameTextView.setVisibility(0);
            if (this.f51256e) {
                if (aVar.f51078a <= 0) {
                    itemViewHolder.mForumNameTextView.setMaxWidth(this.f51257f);
                } else {
                    itemViewHolder.mForumNameTextView.setMaxWidth((this.f51257f - getResources().getDimensionPixelSize(R.dimen.ds22)) - getResources().getDimensionPixelSize(R.dimen.ds4));
                }
            } else {
                itemViewHolder.mForumNameTextView.setMaxWidth(this.f51257f);
            }
            itemViewHolder.mForumNameTextView.setText(aVar.f51081d);
        } else {
            itemViewHolder.mForumNameTextView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.f51082e)) {
            try {
                itemViewHolder.mSubtitleTextView.setText(StringHelper.numberUniformFormat(Long.parseLong(aVar.f51082e)).toLowerCase());
            } catch (Exception unused) {
                itemViewHolder.mSubtitleTextView.setText(aVar.f51082e);
            }
            SkinManager.setViewTextColor(itemViewHolder.mSubtitleTextView, R.color.CAM_X0312);
            itemViewHolder.mSubtitleTextView.setVisibility(0);
        } else {
            itemViewHolder.mSubtitleTextView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.f51083f) && !TextUtils.isEmpty(aVar.f51085h) && !TextUtils.isEmpty(aVar.f51086i)) {
            itemViewHolder.mPostLayout.setVisibility(0);
            g(itemViewHolder.mBtnPost, aVar.f51084g, aVar.f51085h, aVar.f51086i);
            itemViewHolder.mBtnPost.setTag(aVar.f51083f);
            itemViewHolder.mBtnPost.setOnClickListener(new b(this, aVar));
            return;
        }
        itemViewHolder.mPostLayout.setVisibility(8);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void e(ItemViewHolder itemViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, itemViewHolder, i2) == null) || itemViewHolder == null || itemViewHolder.getView() == null) {
            return;
        }
        SkinManager.setViewTextColor(itemViewHolder.mForumNameTextView, R.color.CAM_X0108, 1);
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.f51259h = (int) context.getResources().getDimension(R.dimen.ds36);
            this.f51257f = (int) context.getResources().getDimension(R.dimen.ds102);
            this.f51258g = (int) context.getResources().getDimension(R.dimen.ds102);
            setHorizontalFadingEdgeEnabled(false);
            setVerticalFadingEdgeEnabled(false);
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            LinearLayout linearLayout = new LinearLayout(context);
            this.f51260i = linearLayout;
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.f51260i.setOrientation(0);
            addView(this.f51260i);
        }
    }

    public final void g(TextView textView, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{textView, Boolean.valueOf(z), str, str2}) == null) {
            if (z) {
                textView.setEnabled(false);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109, 1);
                textView.setText(str2);
                textView.setBackgroundDrawable(null);
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                textView.setPadding(0, 0, 0, 0);
                return;
            }
            SkinManager.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
            textView.setText(str);
            SkinManager.setBackgroundResource(textView, R.drawable.btn_focus_border_bg);
            textView.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setEnabled(true);
            textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
    }

    public void onSkinTypeChanged(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.k == i2) {
            return;
        }
        Iterator<ItemViewHolder> it = this.j.iterator();
        while (it.hasNext()) {
            ItemViewHolder next = it.next();
            if (next != null) {
                e(next, i2);
            }
        }
        this.k = i2;
    }

    public void setData(List<HorRankCard.a> list, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, list, tbPageContext) == null) || ListUtils.getCount(list) <= 0 || tbPageContext == null) {
            return;
        }
        this.l = tbPageContext;
        int count = ListUtils.getCount(this.j);
        int count2 = ListUtils.getCount(list);
        if (count > count2) {
            for (int i2 = 0; i2 < count - count2; i2++) {
                TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) ListUtils.getItem(this.j, 0);
                if (viewHolder != null) {
                    this.f51260i.removeView(viewHolder.getView());
                }
                this.j.remove(viewHolder);
            }
        }
        int i3 = 0;
        while (i3 < count2) {
            HorRankCard.a aVar = (HorRankCard.a) ListUtils.getItem(list, i3);
            ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.j, i3);
            if (itemViewHolder != null) {
                d(itemViewHolder.getView(), aVar, i3, i3 == count2 + (-1));
            } else {
                View c2 = c();
                if (c2 != null) {
                    ItemViewHolder itemViewHolder2 = new ItemViewHolder(c2);
                    this.j.add(itemViewHolder2);
                    d(itemViewHolder2.getView(), aVar, i3, i3 == count2 + (-1));
                    this.f51260i.addView(c2);
                }
            }
            i3++;
        }
        onSkinTypeChanged(this.k);
    }

    public void setDisplayNum(double d2) {
        int dimensionPixelSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d2)}) == null) {
            double d3 = (int) d2;
            if (Math.abs(d2 - d3) < 0.01d) {
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24) * 2;
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24);
                d3 = d2;
            }
            this.f51257f = (int) (((getResources().getDisplayMetrics().widthPixels - dimensionPixelSize) - (this.f51259h * (((int) (0.5d + d3)) - 1))) / d3);
        }
    }

    public void setRatio(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.f51258g = (int) ((this.f51257f * d2) + 0.5d);
        }
    }

    public void setRound(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f51256e = z;
            if (z) {
                this.f51259h = (int) getResources().getDimension(R.dimen.ds36);
            } else {
                this.f51259h = (int) getResources().getDimension(R.dimen.ds18);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51256e = false;
        this.j = new ArrayList<>();
        this.k = 3;
        f(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalScrollListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f51256e = false;
        this.j = new ArrayList<>();
        this.k = 3;
        f(context);
    }
}
