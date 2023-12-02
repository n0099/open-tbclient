package com.baidu.tieba.personExtra;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.e65;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class EditForumImageLayerView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BarImageView a;
    public TextView b;
    public HeadImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public LinearLayout g;
    public TBSpecificationBtn h;
    public RelativeLayout i;
    public TbImage j;
    public RelativeLayout k;
    public LinearLayout l;
    public View.OnClickListener m;
    public View.OnClickListener n;

    /* loaded from: classes7.dex */
    public class a implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditForumImageLayerView a;

        public a(EditForumImageLayerView editForumImageLayerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editForumImageLayerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editForumImageLayerView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.k.setVisibility(8);
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditForumImageLayerView(Context context) {
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
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditForumImageLayerView(Context context, @Nullable AttributeSet attributeSet) {
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
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditForumImageLayerView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        b();
    }

    public void setAiCreateLoadingVisible(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            RelativeLayout relativeLayout = this.k;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            relativeLayout.setVisibility(i);
            if (z) {
                this.j.q();
            } else {
                this.j.r();
            }
        }
    }

    public void setCutHeightScale(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
            this.l.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (getContext().getResources().getDisplayMetrics().widthPixels * f)));
        }
    }

    public void setRefreshButtonOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.m = onClickListener;
            this.g.setOnClickListener(onClickListener);
        }
    }

    public void setSaveButtonOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.n = onClickListener;
            this.h.setOnClickListener(onClickListener);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c();
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.k.getVisibility() == 0 && this.j.m()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setAiCreateButtonIsVisible() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.i.setVisibility(0);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0296, (ViewGroup) this, true);
            TbImage tbImage = (TbImage) inflate.findViewById(R.id.obfuscated_res_0x7f0901b5);
            this.j = tbImage;
            tbImage.k(R.drawable.obfuscated_res_0x7f08122d);
            this.j.q();
            this.j.setOnWebpEndedListener(new a(this));
            this.k = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901b6);
            this.l = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901b7);
            this.a = (BarImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090c0f);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c10);
            this.b = textView;
            EMManager.from(textView).setTextStyle(R.string.F_X02);
            this.c = (HeadImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090c13);
            this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c14);
            this.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c49);
            this.f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c4a);
            ((TbImage) inflate.findViewById(R.id.obfuscated_res_0x7f090c12)).k(R.drawable.pic_forum_bg_signin);
            EMManager.from((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c0e)).setCorner(R.string.J_X04).setAlpha(R.string.A_X10).setBackGroundColor(R.color.CAM_X0611);
            this.a.setShowOval(true);
            this.a.setShowOuterBorder(false);
            this.a.setStrokeWith(UtilHelper.getDimenPixelSize(R.dimen.tbds3));
            this.c.setIsRound(true);
            this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.c.setDefaultResource(17170445);
            this.c.setPlaceHolder(1);
            this.i = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901b4);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091f89);
            this.g = linearLayout;
            EMManager.from(linearLayout).setCorner(R.string.J_X01).setBorderWidth(R.dimen.L_X02).setBorderColor(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0105);
            this.g.setAlpha(0.25f);
            this.h = (TBSpecificationBtn) inflate.findViewById(R.id.obfuscated_res_0x7f0921b1);
            e65 e65Var = new e65();
            e65Var.s(R.color.CAM_X0302, R.color.CAM_X0101);
            this.h.setConfig(e65Var);
            this.h.setTextSize(R.dimen.T_X12);
            this.h.setText(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f13c3));
            this.h.setUseDisableState(true);
            this.h.setClickable(false);
            this.h.setOnClickListener(null);
            drawableStateChanged();
        }
    }

    public void setAiCreateButtonClickable(boolean z) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (linearLayout = this.g) != null && this.h != null) {
            linearLayout.setClickable(z);
            this.h.setClickable(z);
            this.h.setClickState(z);
            if (z) {
                this.g.setAlpha(1.0f);
                this.h.setAlpha(1.0f);
                this.h.setOnClickListener(this.n);
                this.g.setOnClickListener(this.m);
                return;
            }
            this.g.setAlpha(0.25f);
            this.h.setAlpha(0.15f);
            this.h.setOnClickListener(null);
            this.g.setOnClickListener(null);
        }
    }

    public void setData(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("forumIcon");
        String optString2 = jSONObject.optString(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME);
        String optString3 = jSONObject.optString("levelName");
        String optString4 = jSONObject.optString("levelId");
        String optString5 = jSONObject.optString("portrait");
        String optString6 = jSONObject.optString("showName");
        this.a.startLoad(optString);
        this.b.setText(String.format(getContext().getString(R.string.chosen_pb_original_bar), optString2));
        this.f.setText(optString3);
        TextView textView = this.e;
        textView.setText("LV" + optString4);
        this.c.startLoad(optString5, 12, false);
        this.d.setText(optString6);
    }
}
