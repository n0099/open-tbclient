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
import c.a.d.f.p.n;
import c.a.u0.g0.u;
import c.a.u0.z1.i;
import c.a.u0.z3.x;
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
/* loaded from: classes13.dex */
public class HorizontalScrollListView extends MyHorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45846e;

    /* renamed from: f  reason: collision with root package name */
    public int f45847f;

    /* renamed from: g  reason: collision with root package name */
    public int f45848g;

    /* renamed from: h  reason: collision with root package name */
    public int f45849h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f45850i;

    /* renamed from: j  reason: collision with root package name */
    public final ArrayList<ItemViewHolder> f45851j;
    public int k;
    public TbPageContext l;

    /* loaded from: classes13.dex */
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

    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorRankCard.a f45852e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HorizontalScrollListView f45853f;

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
            this.f45853f = horizontalScrollListView;
            this.f45852e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f45852e.f45680j)) {
                return;
            }
            u.b().d(true);
            i.e(this.f45852e.m).d(TiebaStatic.Params.OBJ_URL, this.f45852e.f45680j).a(this.f45852e.m);
            x.c(this.f45853f.l, this.f45852e.f45680j);
        }
    }

    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorRankCard.a f45854e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HorizontalScrollListView f45855f;

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
            this.f45855f = horizontalScrollListView;
            this.f45854e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f45855f.getContext())) {
                c.a.u0.z1.m.b a = c.a.u0.z1.m.b.a();
                HorRankCard.a aVar = this.f45854e;
                a.e(aVar, aVar.f45676f, null, null);
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
        this.f45846e = false;
        this.f45851j = new ArrayList<>();
        this.k = 3;
        f(context);
    }

    public final void b(RelativeLayout.LayoutParams layoutParams, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, layoutParams, i2) == null) {
            if (i2 == 0) {
                layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.ds24);
            } else {
                layoutParams.leftMargin = this.f45849h;
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
            view.setPadding(0, 0, n.f(getContext(), R.dimen.ds24), n.f(getContext(), R.dimen.ds24));
        } else {
            view.setPadding(0, 0, 0, n.f(getContext(), R.dimen.ds24));
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        if (this.f45846e) {
            itemViewHolder.mForumAvatarImageView.setIsRound(true);
            itemViewHolder.mLeftTop.setVisibility(8);
            int i3 = aVar.a;
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
            if (aVar.a <= 0) {
                itemViewHolder.mLeftTop.setVisibility(8);
            } else {
                itemViewHolder.mLeftTop.setVisibility(0);
                itemViewHolder.mLeftTop.setText(String.valueOf(aVar.a));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    if (!c.a.u0.z1.o.k.b.a(aVar.l)) {
                        itemViewHolder.mLeftTop.setBackgroundColor(aVar.l);
                    } else {
                        SkinManager.setBackgroundColor(itemViewHolder.mLeftTop, c.a.u0.z1.a.a[i2 <= 3 ? i2 : 3]);
                    }
                } else if (!c.a.u0.z1.o.k.b.a(aVar.k)) {
                    itemViewHolder.mLeftTop.setBackgroundColor(aVar.k);
                } else {
                    SkinManager.setBackgroundColor(itemViewHolder.mLeftTop, c.a.u0.z1.a.a[i2 <= 3 ? i2 : 3]);
                }
            }
            itemViewHolder.mForumAvatarImageView.setRadius(0);
        }
        if (!TextUtils.isEmpty(aVar.f45680j)) {
            itemViewHolder.mForumAvatarImageView.setOnClickListener(new a(this, aVar));
        } else {
            itemViewHolder.mForumAvatarImageView.setOnClickListener(null);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) itemViewHolder.mForumAvatarImageView.getLayoutParams();
        layoutParams.width = this.f45847f;
        layoutParams.height = this.f45848g;
        b(layoutParams, i2);
        if (this.f45846e) {
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.ds10);
        } else {
            layoutParams.topMargin = 0;
        }
        itemViewHolder.mForumAvatarImageView.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) itemViewHolder.mLeftTop.getLayoutParams();
        b(layoutParams2, i2);
        itemViewHolder.mLeftTop.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) itemViewHolder.mNameLayout.getLayoutParams();
        layoutParams3.width = this.f45847f;
        b(layoutParams3, i2);
        itemViewHolder.mNameLayout.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) itemViewHolder.mSubtitleLayout.getLayoutParams();
        layoutParams4.width = this.f45847f;
        b(layoutParams4, i2);
        itemViewHolder.mSubtitleLayout.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) itemViewHolder.mPostLayout.getLayoutParams();
        layoutParams5.width = this.f45847f;
        b(layoutParams5, i2);
        itemViewHolder.mPostLayout.setLayoutParams(layoutParams5);
        itemViewHolder.mForumAvatarImageView.setTag(aVar.f45672b);
        itemViewHolder.mForumAvatarImageView.startLoad(aVar.f45672b, 10, false);
        if (!TextUtils.isEmpty(aVar.f45673c)) {
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) itemViewHolder.mForumAvatarIcon.getLayoutParams();
            int f2 = n.f(getContext(), R.dimen.ds30);
            int f3 = n.f(getContext(), R.dimen.ds6);
            int f4 = n.f(getContext(), R.dimen.ds18);
            int i4 = ((this.f45847f - f2) + this.f45849h) - f3;
            if (i2 == 0) {
                i4 = (i4 - f4) + f3;
            }
            layoutParams6.setMargins(i4, (this.f45848g - f2) + f3, 0, 0);
            itemViewHolder.mForumAvatarIcon.setLayoutParams(layoutParams6);
            itemViewHolder.mForumAvatarIcon.startLoad(aVar.f45673c, 10, false);
        } else {
            itemViewHolder.mForumAvatarIcon.setVisibility(8);
        }
        if (aVar.f45674d != null) {
            itemViewHolder.mForumNameTextView.setVisibility(0);
            if (this.f45846e) {
                if (aVar.a <= 0) {
                    itemViewHolder.mForumNameTextView.setMaxWidth(this.f45847f);
                } else {
                    itemViewHolder.mForumNameTextView.setMaxWidth((this.f45847f - getResources().getDimensionPixelSize(R.dimen.ds22)) - getResources().getDimensionPixelSize(R.dimen.ds4));
                }
            } else {
                itemViewHolder.mForumNameTextView.setMaxWidth(this.f45847f);
            }
            itemViewHolder.mForumNameTextView.setText(aVar.f45674d);
        } else {
            itemViewHolder.mForumNameTextView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.f45675e)) {
            try {
                itemViewHolder.mSubtitleTextView.setText(StringHelper.numberUniformFormat(Long.parseLong(aVar.f45675e)).toLowerCase());
            } catch (Exception unused) {
                itemViewHolder.mSubtitleTextView.setText(aVar.f45675e);
            }
            SkinManager.setViewTextColor(itemViewHolder.mSubtitleTextView, R.color.CAM_X0312);
            itemViewHolder.mSubtitleTextView.setVisibility(0);
        } else {
            itemViewHolder.mSubtitleTextView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.f45676f) && !TextUtils.isEmpty(aVar.f45678h) && !TextUtils.isEmpty(aVar.f45679i)) {
            itemViewHolder.mPostLayout.setVisibility(0);
            g(itemViewHolder.mBtnPost, aVar.f45677g, aVar.f45678h, aVar.f45679i);
            itemViewHolder.mBtnPost.setTag(aVar.f45676f);
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
            this.f45849h = (int) context.getResources().getDimension(R.dimen.ds36);
            this.f45847f = (int) context.getResources().getDimension(R.dimen.ds102);
            this.f45848g = (int) context.getResources().getDimension(R.dimen.ds102);
            setHorizontalFadingEdgeEnabled(false);
            setVerticalFadingEdgeEnabled(false);
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            LinearLayout linearLayout = new LinearLayout(context);
            this.f45850i = linearLayout;
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.f45850i.setOrientation(0);
            addView(this.f45850i);
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
        Iterator<ItemViewHolder> it = this.f45851j.iterator();
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
        int count = ListUtils.getCount(this.f45851j);
        int count2 = ListUtils.getCount(list);
        if (count > count2) {
            for (int i2 = 0; i2 < count - count2; i2++) {
                TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) ListUtils.getItem(this.f45851j, 0);
                if (viewHolder != null) {
                    this.f45850i.removeView(viewHolder.getView());
                }
                this.f45851j.remove(viewHolder);
            }
        }
        int i3 = 0;
        while (i3 < count2) {
            HorRankCard.a aVar = (HorRankCard.a) ListUtils.getItem(list, i3);
            ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.f45851j, i3);
            if (itemViewHolder != null) {
                d(itemViewHolder.getView(), aVar, i3, i3 == count2 + (-1));
            } else {
                View c2 = c();
                if (c2 != null) {
                    ItemViewHolder itemViewHolder2 = new ItemViewHolder(c2);
                    this.f45851j.add(itemViewHolder2);
                    d(itemViewHolder2.getView(), aVar, i3, i3 == count2 + (-1));
                    this.f45850i.addView(c2);
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
            this.f45847f = (int) (((getResources().getDisplayMetrics().widthPixels - dimensionPixelSize) - (this.f45849h * (((int) (0.5d + d3)) - 1))) / d3);
        }
    }

    public void setRatio(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.f45848g = (int) ((this.f45847f * d2) + 0.5d);
        }
    }

    public void setRound(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f45846e = z;
            if (z) {
                this.f45849h = (int) getResources().getDimension(R.dimen.ds36);
            } else {
                this.f45849h = (int) getResources().getDimension(R.dimen.ds18);
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
        this.f45846e = false;
        this.f45851j = new ArrayList<>();
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
        this.f45846e = false;
        this.f45851j = new ArrayList<>();
        this.k = 3;
        f(context);
    }
}
