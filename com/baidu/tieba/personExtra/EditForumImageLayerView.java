package com.baidu.tieba.personExtra;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
        a();
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
        a();
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
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d028f, (ViewGroup) this, true);
            this.a = (BarImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090bee);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090bef);
            this.b = textView;
            EMManager.from(textView).setTextStyle(R.string.F_X02);
            this.c = (HeadImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090bf2);
            this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090bf3);
            this.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c28);
            this.f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c29);
            ((TbImage) inflate.findViewById(R.id.obfuscated_res_0x7f090bf1)).k(R.drawable.pic_forum_bg_signin);
            EMManager.from((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090bed)).setCorner(R.string.J_X04).setAlpha(R.string.A_X10).setBackGroundColor(R.color.CAM_X0611);
            this.a.setShowOval(true);
            this.a.setShowOuterBorder(false);
            this.a.setStrokeWith(UtilHelper.getDimenPixelSize(R.dimen.tbds3));
            this.c.setIsRound(true);
            this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.c.setDefaultResource(17170445);
            this.c.setPlaceHolder(1);
        }
    }

    public void setData(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) != null) || jSONObject == null) {
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
        this.c.startLoad(optString5);
        this.d.setText(optString6);
    }
}
