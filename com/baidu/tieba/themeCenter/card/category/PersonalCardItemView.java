package com.baidu.tieba.themeCenter.card.category;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.mha;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class PersonalCardItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public TbImageView c;
    public TextView d;
    public TbImageView e;
    public TbImageView f;
    public ImageView g;
    public TextView h;
    public View i;
    public mha j;
    public b k;
    public int l;
    public int m;

    /* loaded from: classes8.dex */
    public interface b {
        void a(mha mhaVar);
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalCardItemView a;

        public a(PersonalCardItemView personalCardItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalCardItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalCardItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.k != null) {
                this.a.k.a(this.a.j);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalCardItemView(Context context) {
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
        this.a = context;
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalCardItemView(Context context, AttributeSet attributeSet) {
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
        this.a = context;
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalCardItemView(Context context, AttributeSet attributeSet, int i) {
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
        this.a = context;
        d();
    }

    public void setCardViewController(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.k = bVar;
        }
    }

    public void c(mha mhaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, mhaVar) != null) || mhaVar == null) {
            return;
        }
        this.j = mhaVar;
        if (mhaVar.a() == mha.k) {
            this.c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0204);
            SkinManager.setImageResource(this.c, R.drawable.icon_bubble_choose_no);
            this.d.setVisibility(0);
            this.f.setVisibility(8);
            this.e.setVisibility(8);
        } else {
            this.d.setVisibility(8);
            this.f.setVisibility(0);
            this.e.setVisibility(0);
            this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.c.setImageBitmap(null);
            this.c.setDefaultResource(R.drawable.img_default_100);
            this.c.startLoad(mhaVar.e(), 10, false);
        }
        if (mhaVar.g() == 1) {
            this.g.setVisibility(0);
            SkinManager.setImageResource(this.g, R.drawable.icon_choose_photo);
        } else {
            this.g.setVisibility(8);
        }
        this.e.startLoad(mhaVar.i(), 10, false);
        this.f.startLoad(mhaVar.b(), 10, false);
        this.h.setText(mhaVar.j());
        setVisibility(0);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setOrientation(1);
            int equipmentWidth = (BdUtilHelper.getEquipmentWidth(this.a) - BdUtilHelper.getDimens(this.a, R.dimen.obfuscated_res_0x7f070420)) / 3;
            this.l = equipmentWidth;
            this.m = (int) (equipmentWidth * 0.57d);
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d07f8, this);
            this.b = inflate;
            this.c = (TbImageView) inflate.findViewById(R.id.image_bg);
            TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091b6d);
            this.e = tbImageView;
            tbImageView.setDefaultResource(R.drawable.transparent_bg);
            this.e.setDefaultBgResource(R.drawable.transparent_bg);
            TbImageView tbImageView2 = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0922b0);
            this.f = tbImageView2;
            tbImageView2.setDefaultResource(R.drawable.transparent_bg);
            this.f.setDefaultBgResource(R.drawable.transparent_bg);
            this.g = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0906f9);
            this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0927ab);
            this.h = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092936);
            this.i = this.b.findViewById(R.id.obfuscated_res_0x7f090404);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.height = this.m;
            layoutParams.width = this.l;
            this.c.setLayoutParams(layoutParams);
            this.i.setLayoutParams(layoutParams);
            this.c.setOnClickListener(new a(this));
        }
    }

    public b getCardViewController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.k;
        }
        return (b) invokeV.objValue;
    }
}
