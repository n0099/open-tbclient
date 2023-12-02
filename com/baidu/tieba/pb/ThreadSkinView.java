package com.baidu.tieba.pb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.swa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SkinInfo;
/* loaded from: classes7.dex */
public class ThreadSkinView extends TbImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public SkinInfo b;
    public swa.b c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadSkinView(Context context) {
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
        init();
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view2) {
        SkinInfo skinInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && (skinInfo = this.b) != null && !StringUtils.isNull(skinInfo.url)) {
            swa.b bVar = this.c;
            if (bVar != null) {
                bVar.c("action_type");
                this.c.e("action_type", "CLICK");
                this.c.f();
            }
            UrlManager.getInstance().dealOneLink(this.a, new String[]{this.b.url});
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadSkinView(Context context, AttributeSet attributeSet) {
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
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadSkinView(Context context, AttributeSet attributeSet, int i) {
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
        init();
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setVisibility(8);
        }
    }

    public void setData(TbPageContext tbPageContext, SkinInfo skinInfo, swa.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, skinInfo, bVar) == null) {
            if (tbPageContext != null && skinInfo != null && !StringUtils.isNull(skinInfo.skin)) {
                this.a = tbPageContext;
                if (this.b != skinInfo && bVar != null) {
                    this.c = bVar;
                    bVar.c("action_type");
                    this.c.e("obj_id", skinInfo.obj_id);
                    this.c.e(TiebaStatic.Params.OBJ_URL, skinInfo.url);
                    this.c.e("obj_name", skinInfo.monitor_id);
                    this.c.e("action_type", "VIEW_TRUE");
                    this.c.f();
                }
                this.b = skinInfo;
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(tbPageContext.getPageActivity());
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.width = equipmentWidth;
                if (!StringUtils.isNull(skinInfo.skin_size)) {
                    String[] split = skinInfo.skin_size.split(",");
                    if (split.length > 1) {
                        int i = JavaTypesHelper.toInt(split[0].trim(), -1);
                        int i2 = JavaTypesHelper.toInt(split[1].trim(), -1);
                        if (i > 0 && i2 > 0) {
                            layoutParams.height = (int) (layoutParams.width * (i2 / i));
                        } else {
                            layoutParams.height = (int) tbPageContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070275);
                        }
                    }
                } else {
                    layoutParams.height = (int) tbPageContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070275);
                }
                setLayoutParams(layoutParams);
                startLoad(skinInfo.skin, 10, false);
                setOnClickListener(this);
                setScaleType(ImageView.ScaleType.CENTER_CROP);
                setVisibility(0);
                return;
            }
            setVisibility(8);
        }
    }
}
