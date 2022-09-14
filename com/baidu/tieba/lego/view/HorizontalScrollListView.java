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
import com.baidu.tieba.ej;
import com.baidu.tieba.hf7;
import com.baidu.tieba.lego.card.model.HorRankCard;
import com.baidu.tieba.ng7;
import com.baidu.tieba.o16;
import com.baidu.tieba.pf7;
import com.baidu.tieba.uf7;
import com.baidu.tieba.ul8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class HorizontalScrollListView extends MyHorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public int c;
    public int d;
    public LinearLayout e;
    public final ArrayList<ItemViewHolder> f;
    public int g;
    public TbPageContext h;

    /* loaded from: classes4.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;
        public ImageView b;
        public FrameLayout c;
        public ImageView d;
        public TextView e;
        public HeadImageView f;
        public TbImageView g;
        public TextView h;
        public LinearLayout i;
        public TextView j;
        public TextView k;
        public LinearLayout l;
        public TextView m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemViewHolder(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
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
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091407);
            this.c = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0909e4);
            this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0912be);
            this.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0912c4);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0912c6);
            HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090d26);
            this.f = headImageView;
            headImageView.setGifIconSupport(false);
            this.g = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090d2d);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091477);
            this.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09140a);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091faa);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0912c9);
            this.l = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091408);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090456);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorRankCard.a a;
        public final /* synthetic */ HorizontalScrollListView b;

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
            this.b = horizontalScrollListView;
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || TextUtils.isEmpty(this.a.j)) {
                return;
            }
            o16.b().d(true);
            pf7.e(this.a.m).d(TiebaStatic.Params.OBJ_URL, this.a.j).a(this.a.m);
            ul8.c(this.b.h, this.a.j);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorRankCard.a a;
        public final /* synthetic */ HorizontalScrollListView b;

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
            this.b = horizontalScrollListView;
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ViewHelper.checkUpIsLogin(this.b.getContext())) {
                uf7 a = uf7.a();
                HorRankCard.a aVar = this.a;
                a.e(aVar, aVar.f, null, null);
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
        this.f = new ArrayList<>();
        this.g = 3;
        h(context);
    }

    public final void d(RelativeLayout.LayoutParams layoutParams, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, layoutParams, i) == null) {
            if (i == 0) {
                layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
            } else {
                layoutParams.leftMargin = this.d;
            }
        }
    }

    public final View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? View.inflate(this.h.getPageActivity(), R.layout.obfuscated_res_0x7f0d019e, null) : (View) invokeV.objValue;
    }

    public final void f(View view2, HorRankCard.a aVar, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, aVar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || aVar == null || view2 == null || view2.getTag() == null) {
            return;
        }
        if (z) {
            view2.setPadding(0, 0, ej.f(getContext(), R.dimen.obfuscated_res_0x7f0701e8), ej.f(getContext(), R.dimen.obfuscated_res_0x7f0701e8));
        } else {
            view2.setPadding(0, 0, 0, ej.f(getContext(), R.dimen.obfuscated_res_0x7f0701e8));
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view2.getTag();
        if (this.a) {
            itemViewHolder.f.setIsRound(true);
            itemViewHolder.k.setVisibility(8);
            int i2 = aVar.a;
            if (i2 <= 0) {
                itemViewHolder.b.setVisibility(8);
                itemViewHolder.c.setVisibility(8);
            } else if (i2 == 1) {
                itemViewHolder.b.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.b, R.drawable.icon_grade_star_no1);
                itemViewHolder.c.setVisibility(8);
            } else if (i2 == 2) {
                itemViewHolder.b.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.b, R.drawable.icon_grade_star_no2);
                itemViewHolder.c.setVisibility(8);
            } else if (i2 != 3) {
                itemViewHolder.c.setVisibility(0);
                itemViewHolder.d.getDrawable().setColorFilter(SkinManager.getColor(R.color.CAM_X0204), PorterDuff.Mode.SRC);
                itemViewHolder.b.setVisibility(8);
                SkinManager.setViewTextColor(itemViewHolder.e, (int) R.color.CAM_X0111);
                TextView textView = itemViewHolder.e;
                textView.setText("" + (i + 1));
            } else {
                itemViewHolder.b.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.b, R.drawable.icon_grade_star_no3);
                itemViewHolder.c.setVisibility(8);
            }
        } else {
            itemViewHolder.f.setIsRound(false);
            SkinManager.setViewTextColor(itemViewHolder.k, (int) R.color.CAM_X0111);
            itemViewHolder.b.setVisibility(8);
            itemViewHolder.c.setVisibility(8);
            if (aVar.a <= 0) {
                itemViewHolder.k.setVisibility(8);
            } else {
                itemViewHolder.k.setVisibility(0);
                itemViewHolder.k.setText(String.valueOf(aVar.a));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    if (!ng7.a(aVar.l)) {
                        itemViewHolder.k.setBackgroundColor(aVar.l);
                    } else {
                        SkinManager.setBackgroundColor(itemViewHolder.k, hf7.a[i <= 3 ? i : 3]);
                    }
                } else if (!ng7.a(aVar.k)) {
                    itemViewHolder.k.setBackgroundColor(aVar.k);
                } else {
                    SkinManager.setBackgroundColor(itemViewHolder.k, hf7.a[i <= 3 ? i : 3]);
                }
            }
            itemViewHolder.f.setRadius(0);
        }
        if (!TextUtils.isEmpty(aVar.j)) {
            itemViewHolder.f.setOnClickListener(new a(this, aVar));
        } else {
            itemViewHolder.f.setOnClickListener(null);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) itemViewHolder.f.getLayoutParams();
        layoutParams.width = this.b;
        layoutParams.height = this.c;
        d(layoutParams, i);
        if (this.a) {
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070230);
        } else {
            layoutParams.topMargin = 0;
        }
        itemViewHolder.f.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) itemViewHolder.k.getLayoutParams();
        d(layoutParams2, i);
        itemViewHolder.k.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) itemViewHolder.a.getLayoutParams();
        layoutParams3.width = this.b;
        d(layoutParams3, i);
        itemViewHolder.a.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) itemViewHolder.i.getLayoutParams();
        layoutParams4.width = this.b;
        d(layoutParams4, i);
        itemViewHolder.i.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) itemViewHolder.l.getLayoutParams();
        layoutParams5.width = this.b;
        d(layoutParams5, i);
        itemViewHolder.l.setLayoutParams(layoutParams5);
        itemViewHolder.f.setTag(aVar.b);
        itemViewHolder.f.K(aVar.b, 10, false);
        if (!TextUtils.isEmpty(aVar.c)) {
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) itemViewHolder.g.getLayoutParams();
            int f = ej.f(getContext(), R.dimen.obfuscated_res_0x7f070201);
            int f2 = ej.f(getContext(), R.dimen.obfuscated_res_0x7f0702e6);
            int f3 = ej.f(getContext(), R.dimen.obfuscated_res_0x7f07025f);
            int i3 = ((this.b - f) + this.d) - f2;
            if (i == 0) {
                i3 = (i3 - f3) + f2;
            }
            layoutParams6.setMargins(i3, (this.c - f) + f2, 0, 0);
            itemViewHolder.g.setLayoutParams(layoutParams6);
            itemViewHolder.g.K(aVar.c, 10, false);
        } else {
            itemViewHolder.g.setVisibility(8);
        }
        if (aVar.d != null) {
            itemViewHolder.h.setVisibility(0);
            if (this.a) {
                if (aVar.a <= 0) {
                    itemViewHolder.h.setMaxWidth(this.b);
                } else {
                    itemViewHolder.h.setMaxWidth((this.b - getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070279)) - getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224));
                }
            } else {
                itemViewHolder.h.setMaxWidth(this.b);
            }
            itemViewHolder.h.setText(aVar.d);
        } else {
            itemViewHolder.h.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.e)) {
            try {
                itemViewHolder.j.setText(StringHelper.numberUniformFormat(Long.parseLong(aVar.e)).toLowerCase());
            } catch (Exception unused) {
                itemViewHolder.j.setText(aVar.e);
            }
            SkinManager.setViewTextColor(itemViewHolder.j, (int) R.color.CAM_X0312);
            itemViewHolder.j.setVisibility(0);
        } else {
            itemViewHolder.j.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.f) && !TextUtils.isEmpty(aVar.h) && !TextUtils.isEmpty(aVar.i)) {
            itemViewHolder.l.setVisibility(0);
            j(itemViewHolder.m, aVar.g, aVar.h, aVar.i);
            itemViewHolder.m.setTag(aVar.f);
            itemViewHolder.m.setOnClickListener(new b(this, aVar));
            return;
        }
        itemViewHolder.l.setVisibility(8);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void g(ItemViewHolder itemViewHolder, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, itemViewHolder, i) == null) || itemViewHolder == null || itemViewHolder.getView() == null) {
            return;
        }
        SkinManager.setViewTextColor(itemViewHolder.h, R.color.CAM_X0108, 1);
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.d = (int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070215);
            this.b = (int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070231);
            this.c = (int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f070231);
            setHorizontalFadingEdgeEnabled(false);
            setVerticalFadingEdgeEnabled(false);
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            LinearLayout linearLayout = new LinearLayout(context);
            this.e = linearLayout;
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.e.setOrientation(0);
            addView(this.e);
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || this.g == i) {
            return;
        }
        Iterator<ItemViewHolder> it = this.f.iterator();
        while (it.hasNext()) {
            ItemViewHolder next = it.next();
            if (next != null) {
                g(next, i);
            }
        }
        this.g = i;
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
            textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07025f), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070230), 0);
        }
    }

    public void setData(List<HorRankCard.a> list, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, list, tbPageContext) == null) || ListUtils.getCount(list) <= 0 || tbPageContext == null) {
            return;
        }
        this.h = tbPageContext;
        int count = ListUtils.getCount(this.f);
        int count2 = ListUtils.getCount(list);
        if (count > count2) {
            for (int i = 0; i < count - count2; i++) {
                TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) ListUtils.getItem(this.f, 0);
                if (viewHolder != null) {
                    this.e.removeView(viewHolder.getView());
                }
                this.f.remove(viewHolder);
            }
        }
        int i2 = 0;
        while (i2 < count2) {
            HorRankCard.a aVar = (HorRankCard.a) ListUtils.getItem(list, i2);
            ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.f, i2);
            if (itemViewHolder != null) {
                f(itemViewHolder.getView(), aVar, i2, i2 == count2 + (-1));
            } else {
                View e = e();
                if (e != null) {
                    ItemViewHolder itemViewHolder2 = new ItemViewHolder(e);
                    this.f.add(itemViewHolder2);
                    f(itemViewHolder2.getView(), aVar, i2, i2 == count2 + (-1));
                    this.e.addView(e);
                }
            }
            i2++;
        }
        i(this.g);
    }

    public void setDisplayNum(double d) {
        int dimensionPixelSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d)}) == null) {
            double d2 = (int) d;
            if (Math.abs(d - d2) < 0.01d) {
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8) * 2;
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
                d2 = d;
            }
            this.b = (int) (((getResources().getDisplayMetrics().widthPixels - dimensionPixelSize) - (this.d * (((int) (0.5d + d2)) - 1))) / d2);
        }
    }

    public void setRatio(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Double.valueOf(d)}) == null) {
            this.c = (int) ((this.b * d) + 0.5d);
        }
    }

    public void setRound(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.a = z;
            if (z) {
                this.d = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070215);
            } else {
                this.d = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07025f);
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
        this.f = new ArrayList<>();
        this.g = 3;
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
        this.f = new ArrayList<>();
        this.g = 3;
        h(context);
    }
}
