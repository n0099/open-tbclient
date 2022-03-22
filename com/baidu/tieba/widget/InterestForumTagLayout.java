package com.baidu.tieba.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.l.q;
import c.a.o0.r.v.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.R;
import com.baidu.tieba.widget.InterestForumTagView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class InterestForumTagLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final float a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f37254b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f37255c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f37256d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f37257e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f37258f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37259g;

    /* renamed from: h  reason: collision with root package name */
    public List<SelectForumData> f37260h;
    public InterestForumTagView.b i;

    /* loaded from: classes6.dex */
    public class a implements InterestForumTagView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InterestForumTagLayout a;

        public a(InterestForumTagLayout interestForumTagLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interestForumTagLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interestForumTagLayout;
        }

        @Override // com.baidu.tieba.widget.InterestForumTagView.b
        public void a(SelectForumData selectForumData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, selectForumData) == null) || ListUtils.isEmpty(this.a.f37260h) || selectForumData == null || this.a.f37256d == null) {
                return;
            }
            int indexOf = this.a.f37260h.indexOf(selectForumData);
            if (indexOf != -1 && this.a.f37256d.getChildCount() > indexOf) {
                this.a.f37256d.removeViewAt(indexOf);
                this.a.f37260h.remove(selectForumData);
            }
            if (ListUtils.isEmpty(this.a.f37260h)) {
                this.a.f();
            }
            if (this.a.i != null) {
                this.a.i.a(selectForumData);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InterestForumTagLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private InterestForumTagView.b getCloseListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? new a(this) : (InterestForumTagView.b) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f37260h) || getContext() == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, n.f(getContext(), R.dimen.M_W_X004), 0);
        int size = this.f37260h.size();
        if (size > 2) {
            size = 2;
        }
        for (int i = 0; i < size; i++) {
            g(layoutParams, this.f37260h.get(i));
        }
    }

    public final void f() {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f37256d == null || getContext() == null) {
            return;
        }
        if (this.f37259g) {
            string = this.f37254b.getString(R.string.obfuscated_res_0x7f0f08f0);
        } else {
            string = this.f37254b.getString(R.string.obfuscated_res_0x7f0f08ee);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        EMTextView eMTextView = new EMTextView(getContext());
        this.f37257e = eMTextView;
        eMTextView.setText(string);
        this.f37256d.addView(this.f37257e, layoutParams);
        j();
    }

    public final void g(LinearLayout.LayoutParams layoutParams, SelectForumData selectForumData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, layoutParams, selectForumData) == null) || selectForumData == null || layoutParams == null || getContext() == null) {
            return;
        }
        InterestForumTagView interestForumTagView = new InterestForumTagView(getContext());
        interestForumTagView.onChangeSkinType(this.f37254b, TbadkCoreApplication.getInst().getSkinType());
        interestForumTagView.b(selectForumData);
        interestForumTagView.setCloseListener(getCloseListener());
        float f2 = this.a;
        if (interestForumTagView.getInitialMeasuredWidth() > f2) {
            interestForumTagView.d(f2);
        }
        this.f37256d.addView(interestForumTagView, layoutParams);
    }

    public void h(TbPageContext tbPageContext, List<SelectForumData> list, boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048579, this, tbPageContext, list, z) == null) || tbPageContext == null || (linearLayout = this.f37256d) == null) {
            return;
        }
        this.f37260h = list;
        this.f37254b = tbPageContext;
        this.f37259g = z;
        linearLayout.removeAllViews();
        this.f37257e = null;
        if (ListUtils.isEmpty(list)) {
            f();
        } else {
            e();
        }
    }

    public void i(List<SelectForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            h(this.f37254b, list, this.f37259g);
        }
    }

    public final void j() {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (eMTextView = this.f37257e) == null) {
            return;
        }
        c d2 = c.d(eMTextView);
        d2.v(R.color.CAM_X0110);
        d2.z(R.dimen.T_X06);
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setPadding(n.f(getContext(), R.dimen.obfuscated_res_0x7f070225), n.f(getContext(), R.dimen.tbds36), n.f(getContext(), R.dimen.obfuscated_res_0x7f070225), n.f(getContext(), R.dimen.tbds36));
            setOrientation(1);
            TextView textView = new TextView(getContext());
            this.f37255c = textView;
            textView.setText(getContext().getString(R.string.obfuscated_res_0x7f0f08f4));
            addView(this.f37255c, new LinearLayout.LayoutParams(-2, -2));
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, n.f(getContext(), R.dimen.tbds18), 0, 0);
            addView(relativeLayout, layoutParams);
            ImageView imageView = new ImageView(getContext());
            this.f37258f = imageView;
            imageView.setId(R.id.obfuscated_res_0x7f090f17);
            int f2 = n.f(getContext(), R.dimen.tbds42);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(f2, f2);
            layoutParams2.addRule(11, -1);
            layoutParams2.addRule(15, -1);
            relativeLayout.addView(this.f37258f, layoutParams2);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.f37256d = linearLayout;
            linearLayout.setGravity(16);
            this.f37256d.setMinimumHeight(n.f(getContext(), R.dimen.tbds68));
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams3.addRule(15, -1);
            layoutParams3.addRule(0, R.id.obfuscated_res_0x7f090f17);
            relativeLayout.addView(this.f37256d, layoutParams3);
            onChangeSkinType(this.f37254b, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i) == null) {
            TextView textView = this.f37255c;
            if (textView != null) {
                c d2 = c.d(textView);
                d2.v(R.color.CAM_X0109);
                d2.z(R.dimen.T_X06);
            }
            LinearLayout linearLayout = this.f37256d;
            if (linearLayout != null) {
                int childCount = linearLayout.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.f37256d.getChildAt(i2);
                    if (childAt instanceof q) {
                        ((q) childAt).onChangeSkinType(tbPageContext, i);
                    }
                }
            }
            ImageView imageView = this.f37258f;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.icon_common_arrow16_right_n, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL);
            }
            j();
        }
    }

    public void setDeleteForumListener(InterestForumTagView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public void setMustFill(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (textView = this.f37255c) == null) {
            return;
        }
        if (z) {
            Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08091e, SkinManager.getColor(R.color.CAM_X0301), null);
            if (pureDrawable != null) {
                this.f37255c.setCompoundDrawablePadding(n.f(getContext(), R.dimen.M_W_X002));
                this.f37255c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
                return;
            }
            return;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InterestForumTagLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InterestForumTagLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"NewApi"})
    public InterestForumTagLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = ((((((n.k(getContext()) - n.f(getContext(), R.dimen.obfuscated_res_0x7f070225)) - n.f(getContext(), R.dimen.obfuscated_res_0x7f070225)) - n.f(getContext(), R.dimen.tbds42)) - n.f(getContext(), R.dimen.M_W_X008)) - (n.f(getContext(), R.dimen.M_W_X004) * 2)) * 1.0f) / 2.0f;
        k();
    }
}
