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
import b.a.e.f.m.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class NewUserGuideRankShowBox extends Dialog implements b.a.r0.q3.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f55386e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f55387f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55388g;

    /* renamed from: h  reason: collision with root package name */
    public View f55389h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f55390i;
    public View.OnClickListener j;
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
        this.f55386e = context;
        b();
    }

    @Override // b.a.r0.q3.a
    public void ForumLike(int i2) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && (findViewWithTag = this.f55390i.findViewWithTag(Integer.valueOf(i2))) != null && (findViewWithTag instanceof LinearLayout)) {
            new a(this, findViewWithTag).d(true);
        }
    }

    @Override // b.a.r0.q3.a
    public void ForumUnLike(int i2) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && (findViewWithTag = this.f55390i.findViewWithTag(Integer.valueOf(i2))) != null && (findViewWithTag instanceof LinearLayout)) {
            new a(this, findViewWithTag).d(false);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = View.inflate(this.f55386e, R.layout.new_user_box, null);
            this.l = inflate;
            setContentView(inflate);
            setCanceledOnTouchOutside(true);
            this.k = (LinearLayout) this.l.findViewById(R.id.box_close_layout);
            this.f55387f = (TextView) this.l.findViewById(R.id.prompt_title);
            this.f55388g = (TextView) this.l.findViewById(R.id.prompt_sub_title);
            this.f55389h = this.l.findViewById(R.id.view_layout);
            this.f55390i = (LinearLayout) this.l.findViewById(R.id.layout_content);
            this.f55389h.setBackgroundDrawable(this.f55386e.getResources().getDrawable(R.drawable.bg_startpage2_card_blue_up));
        }
    }

    @Override // b.a.r0.q3.a
    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    @Override // android.app.Dialog, b.a.r0.q3.a
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Context context = this.f55386e;
            if (context instanceof Activity) {
                g.a(this, (Activity) context);
            } else {
                super.dismiss();
            }
        }
    }

    @Override // b.a.r0.q3.a
    public void setData(InterestFrsData.Tag tag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tag) == null) {
            this.f55387f.setText(tag.getBname());
            this.f55388g.setText(tag.getBdesc());
            ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
            int i2 = 0;
            while (i2 < card_list.size()) {
                View a2 = new a(this, card_list.get(i2), this.j).a();
                this.f55390i.addView(a2);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a2.getLayoutParams();
                int dimensionPixelSize = this.f55386e.getResources().getDimensionPixelSize(R.dimen.ds40);
                layoutParams.setMargins(0, i2 == 0 ? this.f55386e.getResources().getDimensionPixelSize(R.dimen.ds52) : dimensionPixelSize, 0, dimensionPixelSize);
                a2.setLayoutParams(layoutParams);
                if (i2 != card_list.size() - 1) {
                    this.f55390i.addView(LayoutInflater.from(this.f55386e).inflate(R.layout.new_user_line_item, (ViewGroup) null));
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

    @Override // b.a.r0.q3.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.j = onClickListener;
            this.k.setOnClickListener(onClickListener);
        }
    }

    public void setSubTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f55388g.setText(str);
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f55387f.setText(str);
        }
    }

    @Override // android.app.Dialog, b.a.r0.q3.a
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Context context = this.f55386e;
            if (!(context instanceof Activity) || g.e((Activity) context)) {
                super.show();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f55391a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f55392b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f55393c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f55394d;

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f55395e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewUserGuideRankShowBox f55396f;

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
            this.f55396f = newUserGuideRankShowBox;
            View inflate = LayoutInflater.from(newUserGuideRankShowBox.f55386e).inflate(R.layout.new_user_text_item, (ViewGroup) null);
            this.f55391a = inflate;
            inflate.setTag(Integer.valueOf(card.getFid()));
            b(card, onClickListener);
        }

        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f55391a : (View) invokeV.objValue;
        }

        public final void b(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            Drawable drawable;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, card, onClickListener) == null) {
                c();
                this.f55395e.setOnClickListener(onClickListener);
                this.f55395e.setTag(card);
                this.f55392b.setText(card.getFname());
                if (card.getOrder() == 1) {
                    drawable = this.f55396f.f55386e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_rise);
                } else {
                    drawable = card.getOrder() == 2 ? this.f55396f.f55386e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_decline) : null;
                }
                this.f55392b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
                this.f55393c.setText(card.getCdesc());
                d(card.getIs_like() != 0);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f55392b = (TextView) this.f55391a.findViewById(R.id.tv_fname);
                this.f55393c = (TextView) this.f55391a.findViewById(R.id.tv_cdesc);
                this.f55394d = (ImageView) this.f55391a.findViewById(R.id.iv_like);
                this.f55395e = (LinearLayout) this.f55391a.findViewById(R.id.ll_like);
            }
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                if (!z) {
                    this.f55394d.setBackgroundDrawable(this.f55396f.f55386e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_n));
                } else {
                    this.f55394d.setBackgroundDrawable(this.f55396f.f55386e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_s));
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
            this.f55396f = newUserGuideRankShowBox;
            this.f55391a = view;
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
        this.f55386e = context;
        b();
    }
}
