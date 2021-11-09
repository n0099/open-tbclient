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
import b.a.e.e.m.g;
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
/* loaded from: classes9.dex */
public class NewUserGuideCommonShowBox extends Dialog implements b.a.r0.p3.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f54432e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f54433f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54434g;

    /* renamed from: h  reason: collision with root package name */
    public View f54435h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f54436i;
    public View.OnClickListener j;
    public View k;
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
        this.f54432e = context;
        b();
    }

    @Override // b.a.r0.p3.a
    public void ForumLike(int i2) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && (findViewWithTag = this.f54436i.findViewWithTag(Integer.valueOf(i2))) != null && (findViewWithTag instanceof LinearLayout)) {
            new a(this, findViewWithTag).d(true);
        }
    }

    @Override // b.a.r0.p3.a
    public void ForumUnLike(int i2) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && (findViewWithTag = this.f54436i.findViewWithTag(Integer.valueOf(i2))) != null && (findViewWithTag instanceof LinearLayout)) {
            new a(this, findViewWithTag).d(false);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = View.inflate(this.f54432e, R.layout.new_user_box, null);
            this.k = inflate;
            setContentView(inflate);
            setCanceledOnTouchOutside(true);
            this.l = (LinearLayout) this.k.findViewById(R.id.box_close_layout);
            this.f54433f = (TextView) this.k.findViewById(R.id.prompt_title);
            this.f54434g = (TextView) this.k.findViewById(R.id.prompt_sub_title);
            this.f54435h = this.k.findViewById(R.id.view_layout);
            this.f54436i = (LinearLayout) findViewById(R.id.layout_content);
            this.f54435h.setBackgroundDrawable(this.f54432e.getResources().getDrawable(R.drawable.bg_startpage2_card_purple_up));
        }
    }

    @Override // b.a.r0.p3.a
    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (View) invokeV.objValue;
    }

    @Override // android.app.Dialog, b.a.r0.p3.a
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Context context = this.f54432e;
            if (context instanceof Activity) {
                g.a(this, (Activity) context);
            } else {
                super.dismiss();
            }
        }
    }

    @Override // b.a.r0.p3.a
    public void setData(InterestFrsData.Tag tag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tag) == null) {
            this.f54433f.setText(tag.getBname());
            this.f54434g.setText(tag.getBdesc());
            ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
            int i2 = 0;
            while (i2 < card_list.size()) {
                InterestFrsData.Card card = card_list.get(i2);
                View a2 = new a(this, card, this.j).a();
                this.f54436i.addView(a2);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a2.getLayoutParams();
                int dimensionPixelSize = this.f54432e.getResources().getDimensionPixelSize(R.dimen.ds20);
                layoutParams.setMargins(0, i2 == 0 ? this.f54432e.getResources().getDimensionPixelSize(R.dimen.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
                a2.setLayoutParams(layoutParams);
                if (i2 != card_list.size() - 1) {
                    this.f54436i.addView(LayoutInflater.from(this.f54432e).inflate(R.layout.new_user_line_item, (ViewGroup) null));
                }
                ((TbImageView) this.f54436i.findViewWithTag(card.getAvatar())).startLoad(card.getAvatar(), 10, false);
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

    @Override // b.a.r0.p3.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.j = onClickListener;
            this.l.setOnClickListener(onClickListener);
        }
    }

    public void setSubTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f54434g.setText(str);
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f54433f.setText(str);
        }
    }

    /* loaded from: classes9.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f54437a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f54438b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f54439c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f54440d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f54441e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f54442f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f54443g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ NewUserGuideCommonShowBox f54444h;

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
            this.f54444h = newUserGuideCommonShowBox;
            View inflate = LayoutInflater.from(newUserGuideCommonShowBox.f54432e).inflate(R.layout.new_user_rich_item, (ViewGroup) null);
            this.f54437a = inflate;
            inflate.setTag(Integer.valueOf(card.getFid()));
            b(card, onClickListener);
        }

        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f54437a : (View) invokeV.objValue;
        }

        public final void b(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, card, onClickListener) == null) {
                c();
                this.f54443g.setOnClickListener(onClickListener);
                this.f54443g.setTag(card);
                this.f54438b.setText(card.getFname());
                this.f54439c.setText(card.getCdesc());
                this.f54440d.setText(card.getSlogan());
                this.f54442f.setTag(card.getAvatar());
                d(card.getIs_like() != 0);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f54438b = (TextView) this.f54437a.findViewById(R.id.tv_fname);
                this.f54439c = (TextView) this.f54437a.findViewById(R.id.tv_cdesc);
                this.f54441e = (ImageView) this.f54437a.findViewById(R.id.iv_like);
                this.f54440d = (TextView) this.f54437a.findViewById(R.id.tv_slogan);
                this.f54442f = (TbImageView) this.f54437a.findViewById(R.id.img);
                this.f54443g = (LinearLayout) this.f54437a.findViewById(R.id.ll_like);
            }
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                if (!z) {
                    this.f54441e.setBackgroundDrawable(this.f54444h.f54432e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_n));
                } else {
                    this.f54441e.setBackgroundDrawable(this.f54444h.f54432e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_s));
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
            this.f54444h = newUserGuideCommonShowBox;
            this.f54437a = view;
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
        this.f54432e = context;
        b();
    }
}
