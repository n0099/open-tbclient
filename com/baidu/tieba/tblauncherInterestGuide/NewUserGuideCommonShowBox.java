package com.baidu.tieba.tblauncherInterestGuide;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class NewUserGuideCommonShowBox extends Dialog implements c.a.r0.x3.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f49448e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f49449f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f49450g;

    /* renamed from: h  reason: collision with root package name */
    public View f49451h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f49452i;

    /* renamed from: j  reason: collision with root package name */
    public View.OnClickListener f49453j;

    /* renamed from: k  reason: collision with root package name */
    public View f49454k;
    public LinearLayout l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewUserGuideCommonShowBox(Context context) {
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
        this.f49448e = context;
        b();
    }

    @Override // c.a.r0.x3.a
    public void ForumLike(int i2) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && (findViewWithTag = this.f49452i.findViewWithTag(Integer.valueOf(i2))) != null && (findViewWithTag instanceof LinearLayout)) {
            new a(this, findViewWithTag).d(true);
        }
    }

    @Override // c.a.r0.x3.a
    public void ForumUnLike(int i2) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && (findViewWithTag = this.f49452i.findViewWithTag(Integer.valueOf(i2))) != null && (findViewWithTag instanceof LinearLayout)) {
            new a(this, findViewWithTag).d(false);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = View.inflate(this.f49448e, R.layout.new_user_box, null);
            this.f49454k = inflate;
            setContentView(inflate);
            setCanceledOnTouchOutside(true);
            this.l = (LinearLayout) this.f49454k.findViewById(R.id.box_close_layout);
            this.f49449f = (TextView) this.f49454k.findViewById(R.id.prompt_title);
            this.f49450g = (TextView) this.f49454k.findViewById(R.id.prompt_sub_title);
            this.f49451h = this.f49454k.findViewById(R.id.view_layout);
            this.f49452i = (LinearLayout) findViewById(R.id.layout_content);
            this.f49451h.setBackgroundDrawable(this.f49448e.getResources().getDrawable(R.drawable.bg_startpage2_card_purple_up));
        }
    }

    @Override // c.a.r0.x3.a
    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f49454k : (View) invokeV.objValue;
    }

    @Override // android.app.Dialog, c.a.r0.x3.a
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Context context = this.f49448e;
            if (context instanceof Activity) {
                g.a(this, (Activity) context);
            } else {
                super.dismiss();
            }
        }
    }

    @Override // c.a.r0.x3.a
    public void setData(InterestFrsData.Tag tag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tag) == null) {
            this.f49449f.setText(tag.getBname());
            this.f49450g.setText(tag.getBdesc());
            ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
            int i2 = 0;
            while (i2 < card_list.size()) {
                InterestFrsData.Card card = card_list.get(i2);
                View a2 = new a(this, card, this.f49453j).a();
                this.f49452i.addView(a2);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a2.getLayoutParams();
                int dimensionPixelSize = this.f49448e.getResources().getDimensionPixelSize(R.dimen.ds20);
                layoutParams.setMargins(0, i2 == 0 ? this.f49448e.getResources().getDimensionPixelSize(R.dimen.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
                a2.setLayoutParams(layoutParams);
                if (i2 != card_list.size() - 1) {
                    this.f49452i.addView(LayoutInflater.from(this.f49448e).inflate(R.layout.new_user_line_item, (ViewGroup) null));
                }
                ((TbImageView) this.f49452i.findViewWithTag(card.getAvatar())).startLoad(card.getAvatar(), 10, false);
                i2++;
            }
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            int size = (card_list.size() * getContext().getResources().getDimensionPixelSize(R.dimen.ds140)) + getContext().getResources().getDimensionPixelSize(R.dimen.ds188) + getContext().getResources().getDimensionPixelSize(R.dimen.ds100);
            float dimensionPixelSize2 = getContext().getResources().getDisplayMetrics().heightPixels - getContext().getResources().getDimensionPixelSize(R.dimen.ds120);
            if (size > dimensionPixelSize2) {
                attributes.height = (int) dimensionPixelSize2;
            }
        }
    }

    @Override // c.a.r0.x3.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.f49453j = onClickListener;
            this.l.setOnClickListener(onClickListener);
        }
    }

    public void setSubTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f49450g.setText(str);
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f49449f.setText(str);
        }
    }

    /* loaded from: classes11.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f49455b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f49456c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f49457d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f49458e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f49459f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f49460g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ NewUserGuideCommonShowBox f49461h;

        public a(NewUserGuideCommonShowBox newUserGuideCommonShowBox, InterestFrsData.Card card, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newUserGuideCommonShowBox, card, onClickListener};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f49461h = newUserGuideCommonShowBox;
            View inflate = LayoutInflater.from(newUserGuideCommonShowBox.f49448e).inflate(R.layout.new_user_rich_item, (ViewGroup) null);
            this.a = inflate;
            inflate.setTag(Integer.valueOf(card.getFid()));
            b(card, onClickListener);
        }

        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (View) invokeV.objValue;
        }

        public final void b(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, card, onClickListener) == null) {
                c();
                this.f49460g.setOnClickListener(onClickListener);
                this.f49460g.setTag(card);
                this.f49455b.setText(card.getFname());
                this.f49456c.setText(card.getCdesc());
                this.f49457d.setText(card.getSlogan());
                this.f49459f.setTag(card.getAvatar());
                d(card.getIs_like() != 0);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f49455b = (TextView) this.a.findViewById(R.id.tv_fname);
                this.f49456c = (TextView) this.a.findViewById(R.id.tv_cdesc);
                this.f49458e = (ImageView) this.a.findViewById(R.id.iv_like);
                this.f49457d = (TextView) this.a.findViewById(R.id.tv_slogan);
                this.f49459f = (TbImageView) this.a.findViewById(R.id.img);
                this.f49460g = (LinearLayout) this.a.findViewById(R.id.ll_like);
            }
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                if (!z) {
                    this.f49458e.setBackgroundDrawable(this.f49461h.f49448e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_n));
                } else {
                    this.f49458e.setBackgroundDrawable(this.f49461h.f49448e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_s));
                }
            }
        }

        public a(NewUserGuideCommonShowBox newUserGuideCommonShowBox, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newUserGuideCommonShowBox, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49461h = newUserGuideCommonShowBox;
            this.a = view;
            c();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewUserGuideCommonShowBox(Context context, int i2) {
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
        this.f49448e = context;
        b();
    }
}
