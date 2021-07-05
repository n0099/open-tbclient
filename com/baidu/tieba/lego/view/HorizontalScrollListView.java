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
import d.a.c.e.p.l;
import d.a.s0.a0.t;
import d.a.s0.h3.v;
import d.a.s0.n1.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class HorizontalScrollListView extends MyHorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18289e;

    /* renamed from: f  reason: collision with root package name */
    public int f18290f;

    /* renamed from: g  reason: collision with root package name */
    public int f18291g;

    /* renamed from: h  reason: collision with root package name */
    public int f18292h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f18293i;
    public final ArrayList<ItemViewHolder> j;
    public int k;
    public TbPageContext l;

    /* loaded from: classes5.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f18294a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f18295b;

        /* renamed from: c  reason: collision with root package name */
        public FrameLayout f18296c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f18297d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f18298e;

        /* renamed from: f  reason: collision with root package name */
        public HeadImageView f18299f;

        /* renamed from: g  reason: collision with root package name */
        public TbImageView f18300g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f18301h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f18302i;
        public TextView j;
        public TextView k;
        public LinearLayout l;
        public TextView m;

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
            this.f18295b = null;
            this.f18296c = null;
            this.f18297d = null;
            this.f18298e = null;
            this.f18299f = null;
            this.f18300g = null;
            this.f18301h = null;
            this.f18302i = null;
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.f18294a = (LinearLayout) view.findViewById(R.id.ll_name);
            this.f18296c = (FrameLayout) view.findViewById(R.id.fl_left);
            this.f18297d = (ImageView) view.findViewById(R.id.leftBack);
            this.f18295b = (ImageView) view.findViewById(R.id.leftIcon);
            this.f18298e = (TextView) view.findViewById(R.id.leftText);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.head);
            this.f18299f = headImageView;
            headImageView.setGifIconSupport(false);
            this.f18300g = (TbImageView) view.findViewById(R.id.head_icon);
            this.f18301h = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.f18302i = (LinearLayout) view.findViewById(R.id.ll_subtitle);
            this.j = (TextView) view.findViewById(R.id.subtitle);
            this.k = (TextView) view.findViewById(R.id.leftTopText);
            this.l = (LinearLayout) view.findViewById(R.id.ll_post);
            this.m = (TextView) view.findViewById(R.id.btn_post);
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorRankCard.a f18303e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HorizontalScrollListView f18304f;

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
            this.f18304f = horizontalScrollListView;
            this.f18303e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f18303e.j)) {
                return;
            }
            t.b().d(true);
            i.e(this.f18303e.m).d(TiebaStatic.Params.OBJ_URL, this.f18303e.j).a(this.f18303e.m);
            v.c(this.f18304f.l, this.f18303e.j);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorRankCard.a f18305e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HorizontalScrollListView f18306f;

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
            this.f18306f = horizontalScrollListView;
            this.f18305e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f18306f.getContext())) {
                d.a.s0.n1.m.b a2 = d.a.s0.n1.m.b.a();
                HorRankCard.a aVar = this.f18305e;
                a2.e(aVar, aVar.f18160f, null, null);
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
        this.f18289e = false;
        this.j = new ArrayList<>();
        this.k = 3;
        h(context);
    }

    public final void d(RelativeLayout.LayoutParams layoutParams, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, layoutParams, i2) == null) {
            if (i2 == 0) {
                layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.ds24);
            } else {
                layoutParams.leftMargin = this.f18292h;
            }
        }
    }

    public final View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? View.inflate(this.l.getPageActivity(), R.layout.card_horizontal_rank_list_item, null) : (View) invokeV.objValue;
    }

    public final void f(View view, HorRankCard.a aVar, int i2, boolean z) {
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
        if (this.f18289e) {
            itemViewHolder.f18299f.setIsRound(true);
            itemViewHolder.k.setVisibility(8);
            int i3 = aVar.f18155a;
            if (i3 <= 0) {
                itemViewHolder.f18295b.setVisibility(8);
                itemViewHolder.f18296c.setVisibility(8);
            } else if (i3 == 1) {
                itemViewHolder.f18295b.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.f18295b, R.drawable.icon_grade_star_no1);
                itemViewHolder.f18296c.setVisibility(8);
            } else if (i3 == 2) {
                itemViewHolder.f18295b.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.f18295b, R.drawable.icon_grade_star_no2);
                itemViewHolder.f18296c.setVisibility(8);
            } else if (i3 != 3) {
                itemViewHolder.f18296c.setVisibility(0);
                itemViewHolder.f18297d.getDrawable().setColorFilter(SkinManager.getColor(R.color.CAM_X0204), PorterDuff.Mode.SRC);
                itemViewHolder.f18295b.setVisibility(8);
                SkinManager.setViewTextColor(itemViewHolder.f18298e, R.color.CAM_X0111);
                TextView textView = itemViewHolder.f18298e;
                textView.setText("" + (i2 + 1));
            } else {
                itemViewHolder.f18295b.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.f18295b, R.drawable.icon_grade_star_no3);
                itemViewHolder.f18296c.setVisibility(8);
            }
        } else {
            itemViewHolder.f18299f.setIsRound(false);
            SkinManager.setViewTextColor(itemViewHolder.k, R.color.CAM_X0111);
            itemViewHolder.f18295b.setVisibility(8);
            itemViewHolder.f18296c.setVisibility(8);
            if (aVar.f18155a <= 0) {
                itemViewHolder.k.setVisibility(8);
            } else {
                itemViewHolder.k.setVisibility(0);
                itemViewHolder.k.setText(String.valueOf(aVar.f18155a));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    if (!d.a.s0.n1.o.k.b.a(aVar.l)) {
                        itemViewHolder.k.setBackgroundColor(aVar.l);
                    } else {
                        SkinManager.setBackgroundColor(itemViewHolder.k, d.a.s0.n1.a.f63733a[i2 <= 3 ? i2 : 3]);
                    }
                } else if (!d.a.s0.n1.o.k.b.a(aVar.k)) {
                    itemViewHolder.k.setBackgroundColor(aVar.k);
                } else {
                    SkinManager.setBackgroundColor(itemViewHolder.k, d.a.s0.n1.a.f63733a[i2 <= 3 ? i2 : 3]);
                }
            }
            itemViewHolder.f18299f.setRadius(0);
        }
        if (!TextUtils.isEmpty(aVar.j)) {
            itemViewHolder.f18299f.setOnClickListener(new a(this, aVar));
        } else {
            itemViewHolder.f18299f.setOnClickListener(null);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) itemViewHolder.f18299f.getLayoutParams();
        layoutParams.width = this.f18290f;
        layoutParams.height = this.f18291g;
        d(layoutParams, i2);
        if (this.f18289e) {
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.ds10);
        } else {
            layoutParams.topMargin = 0;
        }
        itemViewHolder.f18299f.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) itemViewHolder.k.getLayoutParams();
        d(layoutParams2, i2);
        itemViewHolder.k.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) itemViewHolder.f18294a.getLayoutParams();
        layoutParams3.width = this.f18290f;
        d(layoutParams3, i2);
        itemViewHolder.f18294a.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) itemViewHolder.f18302i.getLayoutParams();
        layoutParams4.width = this.f18290f;
        d(layoutParams4, i2);
        itemViewHolder.f18302i.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) itemViewHolder.l.getLayoutParams();
        layoutParams5.width = this.f18290f;
        d(layoutParams5, i2);
        itemViewHolder.l.setLayoutParams(layoutParams5);
        itemViewHolder.f18299f.setTag(aVar.f18156b);
        itemViewHolder.f18299f.M(aVar.f18156b, 10, false);
        if (!TextUtils.isEmpty(aVar.f18157c)) {
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) itemViewHolder.f18300g.getLayoutParams();
            int g2 = l.g(getContext(), R.dimen.ds30);
            int g3 = l.g(getContext(), R.dimen.ds6);
            int g4 = l.g(getContext(), R.dimen.ds18);
            int i4 = ((this.f18290f - g2) + this.f18292h) - g3;
            if (i2 == 0) {
                i4 = (i4 - g4) + g3;
            }
            layoutParams6.setMargins(i4, (this.f18291g - g2) + g3, 0, 0);
            itemViewHolder.f18300g.setLayoutParams(layoutParams6);
            itemViewHolder.f18300g.M(aVar.f18157c, 10, false);
        } else {
            itemViewHolder.f18300g.setVisibility(8);
        }
        if (aVar.f18158d != null) {
            itemViewHolder.f18301h.setVisibility(0);
            if (this.f18289e) {
                if (aVar.f18155a <= 0) {
                    itemViewHolder.f18301h.setMaxWidth(this.f18290f);
                } else {
                    itemViewHolder.f18301h.setMaxWidth((this.f18290f - getResources().getDimensionPixelSize(R.dimen.ds22)) - getResources().getDimensionPixelSize(R.dimen.ds4));
                }
            } else {
                itemViewHolder.f18301h.setMaxWidth(this.f18290f);
            }
            itemViewHolder.f18301h.setText(aVar.f18158d);
        } else {
            itemViewHolder.f18301h.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.f18159e)) {
            try {
                itemViewHolder.j.setText(StringHelper.numberUniformFormat(Long.parseLong(aVar.f18159e)).toLowerCase());
            } catch (Exception unused) {
                itemViewHolder.j.setText(aVar.f18159e);
            }
            SkinManager.setViewTextColor(itemViewHolder.j, R.color.CAM_X0312);
            itemViewHolder.j.setVisibility(0);
        } else {
            itemViewHolder.j.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.f18160f) && !TextUtils.isEmpty(aVar.f18162h) && !TextUtils.isEmpty(aVar.f18163i)) {
            itemViewHolder.l.setVisibility(0);
            j(itemViewHolder.m, aVar.f18161g, aVar.f18162h, aVar.f18163i);
            itemViewHolder.m.setTag(aVar.f18160f);
            itemViewHolder.m.setOnClickListener(new b(this, aVar));
            return;
        }
        itemViewHolder.l.setVisibility(8);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void g(ItemViewHolder itemViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, itemViewHolder, i2) == null) || itemViewHolder == null || itemViewHolder.a() == null) {
            return;
        }
        SkinManager.setViewTextColor(itemViewHolder.f18301h, R.color.CAM_X0108, 1);
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.f18292h = (int) context.getResources().getDimension(R.dimen.ds36);
            this.f18290f = (int) context.getResources().getDimension(R.dimen.ds102);
            this.f18291g = (int) context.getResources().getDimension(R.dimen.ds102);
            setHorizontalFadingEdgeEnabled(false);
            setVerticalFadingEdgeEnabled(false);
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            LinearLayout linearLayout = new LinearLayout(context);
            this.f18293i = linearLayout;
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.f18293i.setOrientation(0);
            addView(this.f18293i);
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || this.k == i2) {
            return;
        }
        Iterator<ItemViewHolder> it = this.j.iterator();
        while (it.hasNext()) {
            ItemViewHolder next = it.next();
            if (next != null) {
                g(next, i2);
            }
        }
        this.k = i2;
    }

    public final void j(TextView textView, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{textView, Boolean.valueOf(z), str, str2}) == null) {
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
                    this.f18293i.removeView(viewHolder.a());
                }
                this.j.remove(viewHolder);
            }
        }
        int i3 = 0;
        while (i3 < count2) {
            HorRankCard.a aVar = (HorRankCard.a) ListUtils.getItem(list, i3);
            ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.j, i3);
            if (itemViewHolder != null) {
                f(itemViewHolder.a(), aVar, i3, i3 == count2 + (-1));
            } else {
                View e2 = e();
                if (e2 != null) {
                    ItemViewHolder itemViewHolder2 = new ItemViewHolder(e2);
                    this.j.add(itemViewHolder2);
                    f(itemViewHolder2.a(), aVar, i3, i3 == count2 + (-1));
                    this.f18293i.addView(e2);
                }
            }
            i3++;
        }
        i(this.k);
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
            this.f18290f = (int) (((getResources().getDisplayMetrics().widthPixels - dimensionPixelSize) - (this.f18292h * (((int) (0.5d + d3)) - 1))) / d3);
        }
    }

    public void setRatio(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.f18291g = (int) ((this.f18290f * d2) + 0.5d);
        }
    }

    public void setRound(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f18289e = z;
            if (z) {
                this.f18292h = (int) getResources().getDimension(R.dimen.ds36);
            } else {
                this.f18292h = (int) getResources().getDimension(R.dimen.ds18);
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
        this.f18289e = false;
        this.j = new ArrayList<>();
        this.k = 3;
        h(context);
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
        this.f18289e = false;
        this.j = new ArrayList<>();
        this.k = 3;
        h(context);
    }
}
