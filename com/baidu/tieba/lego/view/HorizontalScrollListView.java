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
import c.a.p0.a4.x;
import c.a.p0.b2.i;
import c.a.p0.h0.u;
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
/* loaded from: classes5.dex */
public class HorizontalScrollListView extends MyHorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f34303b;

    /* renamed from: c  reason: collision with root package name */
    public int f34304c;

    /* renamed from: d  reason: collision with root package name */
    public int f34305d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f34306e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<ItemViewHolder> f34307f;

    /* renamed from: g  reason: collision with root package name */
    public int f34308g;

    /* renamed from: h  reason: collision with root package name */
    public TbPageContext f34309h;

    /* loaded from: classes5.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f34310b;

        /* renamed from: c  reason: collision with root package name */
        public FrameLayout f34311c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f34312d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f34313e;

        /* renamed from: f  reason: collision with root package name */
        public HeadImageView f34314f;

        /* renamed from: g  reason: collision with root package name */
        public TbImageView f34315g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f34316h;
        public LinearLayout i;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34310b = null;
            this.f34311c = null;
            this.f34312d = null;
            this.f34313e = null;
            this.f34314f = null;
            this.f34315g = null;
            this.f34316h = null;
            this.i = null;
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.a = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f0912ff);
            this.f34311c = (FrameLayout) view.findViewById(R.id.obfuscated_res_0x7f0909bc);
            this.f34312d = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f09120d);
            this.f34310b = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091213);
            this.f34313e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091215);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f090d1a);
            this.f34314f = headImageView;
            headImageView.setGifIconSupport(false);
            this.f34315g = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090d20);
            this.f34316h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091366);
            this.i = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f091302);
            this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091dd9);
            this.k = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091218);
            this.l = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f091300);
            this.m = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090433);
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorRankCard.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HorizontalScrollListView f34317b;

        public a(HorizontalScrollListView horizontalScrollListView, HorRankCard.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalScrollListView, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34317b = horizontalScrollListView;
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.a.j)) {
                return;
            }
            u.b().d(true);
            i.e(this.a.m).d(TiebaStatic.Params.OBJ_URL, this.a.j).a(this.a.m);
            x.c(this.f34317b.f34309h, this.a.j);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorRankCard.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HorizontalScrollListView f34318b;

        public b(HorizontalScrollListView horizontalScrollListView, HorRankCard.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalScrollListView, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34318b = horizontalScrollListView;
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f34318b.getContext())) {
                c.a.p0.b2.m.b a = c.a.p0.b2.m.b.a();
                HorRankCard.a aVar = this.a;
                a.e(aVar, aVar.f34217f, null, null);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f34307f = new ArrayList<>();
        this.f34308g = 3;
        h(context);
    }

    public final void d(RelativeLayout.LayoutParams layoutParams, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, layoutParams, i) == null) {
            if (i == 0) {
                layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
            } else {
                layoutParams.leftMargin = this.f34305d;
            }
        }
    }

    public final View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? View.inflate(this.f34309h.getPageActivity(), R.layout.obfuscated_res_0x7f0d01a2, null) : (View) invokeV.objValue;
    }

    public final void f(View view, HorRankCard.a aVar, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view, aVar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || aVar == null || view == null || view.getTag() == null) {
            return;
        }
        if (z) {
            view.setPadding(0, 0, n.f(getContext(), R.dimen.obfuscated_res_0x7f0701e8), n.f(getContext(), R.dimen.obfuscated_res_0x7f0701e8));
        } else {
            view.setPadding(0, 0, 0, n.f(getContext(), R.dimen.obfuscated_res_0x7f0701e8));
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        if (this.a) {
            itemViewHolder.f34314f.setIsRound(true);
            itemViewHolder.k.setVisibility(8);
            int i2 = aVar.a;
            if (i2 <= 0) {
                itemViewHolder.f34310b.setVisibility(8);
                itemViewHolder.f34311c.setVisibility(8);
            } else if (i2 == 1) {
                itemViewHolder.f34310b.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.f34310b, R.drawable.icon_grade_star_no1);
                itemViewHolder.f34311c.setVisibility(8);
            } else if (i2 == 2) {
                itemViewHolder.f34310b.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.f34310b, R.drawable.icon_grade_star_no2);
                itemViewHolder.f34311c.setVisibility(8);
            } else if (i2 != 3) {
                itemViewHolder.f34311c.setVisibility(0);
                itemViewHolder.f34312d.getDrawable().setColorFilter(SkinManager.getColor(R.color.CAM_X0204), PorterDuff.Mode.SRC);
                itemViewHolder.f34310b.setVisibility(8);
                SkinManager.setViewTextColor(itemViewHolder.f34313e, (int) R.color.CAM_X0111);
                TextView textView = itemViewHolder.f34313e;
                textView.setText("" + (i + 1));
            } else {
                itemViewHolder.f34310b.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.f34310b, R.drawable.icon_grade_star_no3);
                itemViewHolder.f34311c.setVisibility(8);
            }
        } else {
            itemViewHolder.f34314f.setIsRound(false);
            SkinManager.setViewTextColor(itemViewHolder.k, (int) R.color.CAM_X0111);
            itemViewHolder.f34310b.setVisibility(8);
            itemViewHolder.f34311c.setVisibility(8);
            if (aVar.a <= 0) {
                itemViewHolder.k.setVisibility(8);
            } else {
                itemViewHolder.k.setVisibility(0);
                itemViewHolder.k.setText(String.valueOf(aVar.a));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    if (!c.a.p0.b2.o.k.b.a(aVar.l)) {
                        itemViewHolder.k.setBackgroundColor(aVar.l);
                    } else {
                        SkinManager.setBackgroundColor(itemViewHolder.k, c.a.p0.b2.a.a[i <= 3 ? i : 3]);
                    }
                } else if (!c.a.p0.b2.o.k.b.a(aVar.k)) {
                    itemViewHolder.k.setBackgroundColor(aVar.k);
                } else {
                    SkinManager.setBackgroundColor(itemViewHolder.k, c.a.p0.b2.a.a[i <= 3 ? i : 3]);
                }
            }
            itemViewHolder.f34314f.setRadius(0);
        }
        if (!TextUtils.isEmpty(aVar.j)) {
            itemViewHolder.f34314f.setOnClickListener(new a(this, aVar));
        } else {
            itemViewHolder.f34314f.setOnClickListener(null);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) itemViewHolder.f34314f.getLayoutParams();
        layoutParams.width = this.f34303b;
        layoutParams.height = this.f34304c;
        d(layoutParams, i);
        if (this.a) {
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070229);
        } else {
            layoutParams.topMargin = 0;
        }
        itemViewHolder.f34314f.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) itemViewHolder.k.getLayoutParams();
        d(layoutParams2, i);
        itemViewHolder.k.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) itemViewHolder.a.getLayoutParams();
        layoutParams3.width = this.f34303b;
        d(layoutParams3, i);
        itemViewHolder.a.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) itemViewHolder.i.getLayoutParams();
        layoutParams4.width = this.f34303b;
        d(layoutParams4, i);
        itemViewHolder.i.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) itemViewHolder.l.getLayoutParams();
        layoutParams5.width = this.f34303b;
        d(layoutParams5, i);
        itemViewHolder.l.setLayoutParams(layoutParams5);
        itemViewHolder.f34314f.setTag(aVar.f34213b);
        itemViewHolder.f34314f.J(aVar.f34213b, 10, false);
        if (!TextUtils.isEmpty(aVar.f34214c)) {
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) itemViewHolder.f34315g.getLayoutParams();
            int f2 = n.f(getContext(), R.dimen.obfuscated_res_0x7f070201);
            int f3 = n.f(getContext(), R.dimen.obfuscated_res_0x7f0702df);
            int f4 = n.f(getContext(), R.dimen.obfuscated_res_0x7f070257);
            int i3 = ((this.f34303b - f2) + this.f34305d) - f3;
            if (i == 0) {
                i3 = (i3 - f4) + f3;
            }
            layoutParams6.setMargins(i3, (this.f34304c - f2) + f3, 0, 0);
            itemViewHolder.f34315g.setLayoutParams(layoutParams6);
            itemViewHolder.f34315g.J(aVar.f34214c, 10, false);
        } else {
            itemViewHolder.f34315g.setVisibility(8);
        }
        if (aVar.f34215d != null) {
            itemViewHolder.f34316h.setVisibility(0);
            if (this.a) {
                if (aVar.a <= 0) {
                    itemViewHolder.f34316h.setMaxWidth(this.f34303b);
                } else {
                    itemViewHolder.f34316h.setMaxWidth((this.f34303b - getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070270)) - getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224));
                }
            } else {
                itemViewHolder.f34316h.setMaxWidth(this.f34303b);
            }
            itemViewHolder.f34316h.setText(aVar.f34215d);
        } else {
            itemViewHolder.f34316h.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.f34216e)) {
            try {
                itemViewHolder.j.setText(StringHelper.numberUniformFormat(Long.parseLong(aVar.f34216e)).toLowerCase());
            } catch (Exception unused) {
                itemViewHolder.j.setText(aVar.f34216e);
            }
            SkinManager.setViewTextColor(itemViewHolder.j, (int) R.color.CAM_X0312);
            itemViewHolder.j.setVisibility(0);
        } else {
            itemViewHolder.j.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.f34217f) && !TextUtils.isEmpty(aVar.f34219h) && !TextUtils.isEmpty(aVar.i)) {
            itemViewHolder.l.setVisibility(0);
            j(itemViewHolder.m, aVar.f34218g, aVar.f34219h, aVar.i);
            itemViewHolder.m.setTag(aVar.f34217f);
            itemViewHolder.m.setOnClickListener(new b(this, aVar));
            return;
        }
        itemViewHolder.l.setVisibility(8);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void g(ItemViewHolder itemViewHolder, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, itemViewHolder, i) == null) || itemViewHolder == null || itemViewHolder.b() == null) {
            return;
        }
        SkinManager.setViewTextColor(itemViewHolder.f34316h, R.color.CAM_X0108, 1);
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.f34305d = (int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070215);
            this.f34303b = (int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f07022a);
            this.f34304c = (int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f07022a);
            setHorizontalFadingEdgeEnabled(false);
            setVerticalFadingEdgeEnabled(false);
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            LinearLayout linearLayout = new LinearLayout(context);
            this.f34306e = linearLayout;
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.f34306e.setOrientation(0);
            addView(this.f34306e);
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || this.f34308g == i) {
            return;
        }
        Iterator<ItemViewHolder> it = this.f34307f.iterator();
        while (it.hasNext()) {
            ItemViewHolder next = it.next();
            if (next != null) {
                g(next, i);
            }
        }
        this.f34308g = i;
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
            textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070257), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070229), 0);
        }
    }

    public void setData(List<HorRankCard.a> list, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, list, tbPageContext) == null) || ListUtils.getCount(list) <= 0 || tbPageContext == null) {
            return;
        }
        this.f34309h = tbPageContext;
        int count = ListUtils.getCount(this.f34307f);
        int count2 = ListUtils.getCount(list);
        if (count > count2) {
            for (int i = 0; i < count - count2; i++) {
                TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) ListUtils.getItem(this.f34307f, 0);
                if (viewHolder != null) {
                    this.f34306e.removeView(viewHolder.b());
                }
                this.f34307f.remove(viewHolder);
            }
        }
        int i2 = 0;
        while (i2 < count2) {
            HorRankCard.a aVar = (HorRankCard.a) ListUtils.getItem(list, i2);
            ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.f34307f, i2);
            if (itemViewHolder != null) {
                f(itemViewHolder.b(), aVar, i2, i2 == count2 + (-1));
            } else {
                View e2 = e();
                if (e2 != null) {
                    ItemViewHolder itemViewHolder2 = new ItemViewHolder(e2);
                    this.f34307f.add(itemViewHolder2);
                    f(itemViewHolder2.b(), aVar, i2, i2 == count2 + (-1));
                    this.f34306e.addView(e2);
                }
            }
            i2++;
        }
        i(this.f34308g);
    }

    public void setDisplayNum(double d2) {
        int dimensionPixelSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d2)}) == null) {
            double d3 = (int) d2;
            if (Math.abs(d2 - d3) < 0.01d) {
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8) * 2;
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
                d3 = d2;
            }
            this.f34303b = (int) (((getResources().getDisplayMetrics().widthPixels - dimensionPixelSize) - (this.f34305d * (((int) (0.5d + d3)) - 1))) / d3);
        }
    }

    public void setRatio(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.f34304c = (int) ((this.f34303b * d2) + 0.5d);
        }
    }

    public void setRound(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.a = z;
            if (z) {
                this.f34305d = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070215);
            } else {
                this.f34305d = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070257);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f34307f = new ArrayList<>();
        this.f34308g = 3;
        h(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f34307f = new ArrayList<>();
        this.f34308g = 3;
        h(context);
    }
}
