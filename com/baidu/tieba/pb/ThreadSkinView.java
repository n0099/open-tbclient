package com.baidu.tieba.pb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gg;
import com.baidu.tieba.ii;
import com.baidu.tieba.yl9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SkinInfo;
/* loaded from: classes5.dex */
public class ThreadSkinView extends TbImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext w0;
    public SkinInfo x0;
    public yl9.b y0;

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
        x();
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view2) {
        SkinInfo skinInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (skinInfo = this.x0) != null && !StringUtils.isNull(skinInfo.url)) {
            yl9.b bVar = this.y0;
            if (bVar != null) {
                bVar.delete("action_type");
                this.y0.d("action_type", "CLICK");
                this.y0.e();
            }
            UrlManager.getInstance().dealOneLink(this.w0, new String[]{this.x0.url});
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
        x();
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
        x();
    }

    public void setData(TbPageContext tbPageContext, SkinInfo skinInfo, yl9.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, skinInfo, bVar) == null) {
            if (tbPageContext != null && skinInfo != null && !StringUtils.isNull(skinInfo.skin)) {
                this.w0 = tbPageContext;
                if (this.x0 != skinInfo && bVar != null) {
                    this.y0 = bVar;
                    bVar.delete("action_type");
                    this.y0.d("obj_id", skinInfo.obj_id);
                    this.y0.d(TiebaStatic.Params.OBJ_URL, skinInfo.url);
                    this.y0.d("obj_name", skinInfo.monitor_id);
                    this.y0.d("action_type", "VIEW_TRUE");
                    this.y0.e();
                }
                this.x0 = skinInfo;
                int l = ii.l(tbPageContext.getPageActivity());
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.width = l;
                if (!StringUtils.isNull(skinInfo.skin_size)) {
                    String[] split = skinInfo.skin_size.split(",");
                    if (split.length > 1) {
                        int e = gg.e(split[0].trim(), -1);
                        int e2 = gg.e(split[1].trim(), -1);
                        if (e > 0 && e2 > 0) {
                            layoutParams.height = (int) (layoutParams.width * (e2 / e));
                        } else {
                            layoutParams.height = (int) tbPageContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070275);
                        }
                    }
                } else {
                    layoutParams.height = (int) tbPageContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070275);
                }
                setLayoutParams(layoutParams);
                N(skinInfo.skin, 10, false);
                setOnClickListener(this);
                setScaleType(ImageView.ScaleType.CENTER_CROP);
                setVisibility(0);
                return;
            }
            setVisibility(8);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setVisibility(8);
        }
    }
}
