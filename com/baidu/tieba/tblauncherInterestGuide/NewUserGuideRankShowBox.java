package com.baidu.tieba.tblauncherInterestGuide;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class NewUserGuideRankShowBox extends Dialog implements c.a.r0.o3.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f57405e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57406f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57407g;

    /* renamed from: h  reason: collision with root package name */
    public View f57408h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f57409i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f57410j;
    public LinearLayout k;
    public View l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewUserGuideRankShowBox(Context context) {
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
        this.f57405e = context;
        b();
    }

    @Override // c.a.r0.o3.a
    public void ForumLike(int i2) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && (findViewWithTag = this.f57409i.findViewWithTag(Integer.valueOf(i2))) != null && (findViewWithTag instanceof LinearLayout)) {
            new a(this, findViewWithTag).d(true);
        }
    }

    @Override // c.a.r0.o3.a
    public void ForumUnLike(int i2) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && (findViewWithTag = this.f57409i.findViewWithTag(Integer.valueOf(i2))) != null && (findViewWithTag instanceof LinearLayout)) {
            new a(this, findViewWithTag).d(false);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = View.inflate(this.f57405e, R.layout.new_user_box, null);
            this.l = inflate;
            setContentView(inflate);
            setCanceledOnTouchOutside(true);
            this.k = (LinearLayout) this.l.findViewById(R.id.box_close_layout);
            this.f57406f = (TextView) this.l.findViewById(R.id.prompt_title);
            this.f57407g = (TextView) this.l.findViewById(R.id.prompt_sub_title);
            this.f57408h = this.l.findViewById(R.id.view_layout);
            this.f57409i = (LinearLayout) this.l.findViewById(R.id.layout_content);
            this.f57408h.setBackgroundDrawable(this.f57405e.getResources().getDrawable(R.drawable.bg_startpage2_card_blue_up));
        }
    }

    @Override // c.a.r0.o3.a
    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    @Override // android.app.Dialog, c.a.r0.o3.a
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Context context = this.f57405e;
            if (context instanceof Activity) {
                g.a(this, (Activity) context);
            } else {
                super.dismiss();
            }
        }
    }

    @Override // c.a.r0.o3.a
    public void setData(InterestFrsData.Tag tag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tag) == null) {
            this.f57406f.setText(tag.getBname());
            this.f57407g.setText(tag.getBdesc());
            ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
            int i2 = 0;
            while (i2 < card_list.size()) {
                View a2 = new a(this, card_list.get(i2), this.f57410j).a();
                this.f57409i.addView(a2);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a2.getLayoutParams();
                int dimensionPixelSize = this.f57405e.getResources().getDimensionPixelSize(R.dimen.ds40);
                layoutParams.setMargins(0, i2 == 0 ? this.f57405e.getResources().getDimensionPixelSize(R.dimen.ds52) : dimensionPixelSize, 0, dimensionPixelSize);
                a2.setLayoutParams(layoutParams);
                if (i2 != card_list.size() - 1) {
                    this.f57409i.addView(LayoutInflater.from(this.f57405e).inflate(R.layout.new_user_line_item, (ViewGroup) null));
                }
                i2++;
            }
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            int size = (card_list.size() * getContext().getResources().getDimensionPixelSize(R.dimen.ds112)) + getContext().getResources().getDimensionPixelSize(R.dimen.ds188) + getContext().getResources().getDimensionPixelSize(R.dimen.ds100);
            float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(R.dimen.ds120);
            if (size > dimensionPixelSize2) {
                attributes.height = (int) dimensionPixelSize2;
            }
        }
    }

    @Override // c.a.r0.o3.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.f57410j = onClickListener;
            this.k.setOnClickListener(onClickListener);
        }
    }

    public void setSubTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f57407g.setText(str);
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f57406f.setText(str);
        }
    }

    @Override // android.app.Dialog, c.a.r0.o3.a
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Context context = this.f57405e;
            if (!(context instanceof Activity) || g.e((Activity) context)) {
                super.show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f57411a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f57412b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f57413c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f57414d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f57415e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewUserGuideRankShowBox f57416f;

        public a(NewUserGuideRankShowBox newUserGuideRankShowBox, InterestFrsData.Card card, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newUserGuideRankShowBox, card, onClickListener};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f57416f = newUserGuideRankShowBox;
            View inflate = LayoutInflater.from(newUserGuideRankShowBox.f57405e).inflate(R.layout.new_user_text_item, (ViewGroup) null);
            this.f57411a = inflate;
            inflate.setTag(Integer.valueOf(card.getFid()));
            b(card, onClickListener);
        }

        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f57411a : (View) invokeV.objValue;
        }

        public final void b(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            Drawable drawable;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, card, onClickListener) == null) {
                c();
                this.f57415e.setOnClickListener(onClickListener);
                this.f57415e.setTag(card);
                this.f57412b.setText(card.getFname());
                if (card.getOrder() == 1) {
                    drawable = this.f57416f.f57405e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_rise);
                } else {
                    drawable = card.getOrder() == 2 ? this.f57416f.f57405e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_decline) : null;
                }
                this.f57412b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
                this.f57413c.setText(card.getCdesc());
                d(card.getIs_like() != 0);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f57412b = (TextView) this.f57411a.findViewById(R.id.tv_fname);
                this.f57413c = (TextView) this.f57411a.findViewById(R.id.tv_cdesc);
                this.f57414d = (ImageView) this.f57411a.findViewById(R.id.iv_like);
                this.f57415e = (LinearLayout) this.f57411a.findViewById(R.id.ll_like);
            }
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                if (!z) {
                    this.f57414d.setBackgroundDrawable(this.f57416f.f57405e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_n));
                } else {
                    this.f57414d.setBackgroundDrawable(this.f57416f.f57405e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_s));
                }
            }
        }

        public a(NewUserGuideRankShowBox newUserGuideRankShowBox, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newUserGuideRankShowBox, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57416f = newUserGuideRankShowBox;
            this.f57411a = view;
            c();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewUserGuideRankShowBox(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57405e = context;
        b();
    }
}
