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
    public Context f54433e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f54434f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54435g;

    /* renamed from: h  reason: collision with root package name */
    public View f54436h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f54437i;
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
        this.f54433e = context;
        b();
    }

    @Override // b.a.r0.p3.a
    public void ForumLike(int i2) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && (findViewWithTag = this.f54437i.findViewWithTag(Integer.valueOf(i2))) != null && (findViewWithTag instanceof LinearLayout)) {
            new a(this, findViewWithTag).d(true);
        }
    }

    @Override // b.a.r0.p3.a
    public void ForumUnLike(int i2) {
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && (findViewWithTag = this.f54437i.findViewWithTag(Integer.valueOf(i2))) != null && (findViewWithTag instanceof LinearLayout)) {
            new a(this, findViewWithTag).d(false);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = View.inflate(this.f54433e, R.layout.new_user_box, null);
            this.k = inflate;
            setContentView(inflate);
            setCanceledOnTouchOutside(true);
            this.l = (LinearLayout) this.k.findViewById(R.id.box_close_layout);
            this.f54434f = (TextView) this.k.findViewById(R.id.prompt_title);
            this.f54435g = (TextView) this.k.findViewById(R.id.prompt_sub_title);
            this.f54436h = this.k.findViewById(R.id.view_layout);
            this.f54437i = (LinearLayout) findViewById(R.id.layout_content);
            this.f54436h.setBackgroundDrawable(this.f54433e.getResources().getDrawable(R.drawable.bg_startpage2_card_purple_up));
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
            Context context = this.f54433e;
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
            this.f54434f.setText(tag.getBname());
            this.f54435g.setText(tag.getBdesc());
            ArrayList<InterestFrsData.Card> card_list = tag.getCard_list();
            int i2 = 0;
            while (i2 < card_list.size()) {
                InterestFrsData.Card card = card_list.get(i2);
                View a2 = new a(this, card, this.j).a();
                this.f54437i.addView(a2);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a2.getLayoutParams();
                int dimensionPixelSize = this.f54433e.getResources().getDimensionPixelSize(R.dimen.ds20);
                layoutParams.setMargins(0, i2 == 0 ? this.f54433e.getResources().getDimensionPixelSize(R.dimen.ds44) : dimensionPixelSize, 0, dimensionPixelSize);
                a2.setLayoutParams(layoutParams);
                if (i2 != card_list.size() - 1) {
                    this.f54437i.addView(LayoutInflater.from(this.f54433e).inflate(R.layout.new_user_line_item, (ViewGroup) null));
                }
                ((TbImageView) this.f54437i.findViewWithTag(card.getAvatar())).startLoad(card.getAvatar(), 10, false);
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
            this.f54435g.setText(str);
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.f54434f.setText(str);
        }
    }

    /* loaded from: classes9.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f54438a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f54439b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f54440c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f54441d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f54442e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f54443f;

        /* renamed from: g  reason: collision with root package name */
        public LinearLayout f54444g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ NewUserGuideCommonShowBox f54445h;

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
            this.f54445h = newUserGuideCommonShowBox;
            View inflate = LayoutInflater.from(newUserGuideCommonShowBox.f54433e).inflate(R.layout.new_user_rich_item, (ViewGroup) null);
            this.f54438a = inflate;
            inflate.setTag(Integer.valueOf(card.getFid()));
            b(card, onClickListener);
        }

        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f54438a : (View) invokeV.objValue;
        }

        public final void b(InterestFrsData.Card card, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, card, onClickListener) == null) {
                c();
                this.f54444g.setOnClickListener(onClickListener);
                this.f54444g.setTag(card);
                this.f54439b.setText(card.getFname());
                this.f54440c.setText(card.getCdesc());
                this.f54441d.setText(card.getSlogan());
                this.f54443f.setTag(card.getAvatar());
                d(card.getIs_like() != 0);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f54439b = (TextView) this.f54438a.findViewById(R.id.tv_fname);
                this.f54440c = (TextView) this.f54438a.findViewById(R.id.tv_cdesc);
                this.f54442e = (ImageView) this.f54438a.findViewById(R.id.iv_like);
                this.f54441d = (TextView) this.f54438a.findViewById(R.id.tv_slogan);
                this.f54443f = (TbImageView) this.f54438a.findViewById(R.id.img);
                this.f54444g = (LinearLayout) this.f54438a.findViewById(R.id.ll_like);
            }
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                if (!z) {
                    this.f54442e.setBackgroundDrawable(this.f54445h.f54433e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_n));
                } else {
                    this.f54442e.setBackgroundDrawable(this.f54445h.f54433e.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_s));
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
            this.f54445h = newUserGuideCommonShowBox;
            this.f54438a = view;
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
        this.f54433e = context;
        b();
    }
}
