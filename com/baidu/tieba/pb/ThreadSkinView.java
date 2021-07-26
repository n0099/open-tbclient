package com.baidu.tieba.pb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.m.b;
import d.a.d.e.p.l;
import d.a.q0.h3.j0.a;
import tbclient.SkinInfo;
/* loaded from: classes4.dex */
public class ThreadSkinView extends TbImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext x0;
    public SkinInfo y0;
    public a.b z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadSkinView(Context context) {
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
        v();
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view) {
        SkinInfo skinInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (skinInfo = this.y0) == null || StringUtils.isNull(skinInfo.url)) {
            return;
        }
        a.b bVar = this.z0;
        if (bVar != null) {
            bVar.c(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE);
            this.z0.e(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "CLICK");
            this.z0.f();
        }
        UrlManager.getInstance().dealOneLink(this.x0, new String[]{this.y0.url});
    }

    public void setData(TbPageContext tbPageContext, SkinInfo skinInfo, a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, skinInfo, bVar) == null) {
            if (tbPageContext != null && skinInfo != null && !StringUtils.isNull(skinInfo.skin)) {
                this.x0 = tbPageContext;
                if (this.y0 != skinInfo && bVar != null) {
                    this.z0 = bVar;
                    bVar.c(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE);
                    this.z0.e("obj_id", skinInfo.obj_id);
                    this.z0.e(TiebaStatic.Params.OBJ_URL, skinInfo.url);
                    this.z0.e("obj_name", skinInfo.monitor_id);
                    this.z0.e(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "VIEW_TRUE");
                    this.z0.f();
                }
                this.y0 = skinInfo;
                int k = l.k(tbPageContext.getPageActivity());
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.width = k;
                if (!StringUtils.isNull(skinInfo.skin_size)) {
                    String[] split = skinInfo.skin_size.split(",");
                    if (split.length > 1) {
                        int d2 = b.d(split[0].trim(), -1);
                        int d3 = b.d(split[1].trim(), -1);
                        if (d2 > 0 && d3 > 0) {
                            layoutParams.height = (int) (layoutParams.width * (d3 / d2));
                        } else {
                            layoutParams.height = (int) tbPageContext.getResources().getDimension(R.dimen.ds80);
                        }
                    }
                } else {
                    layoutParams.height = (int) tbPageContext.getResources().getDimension(R.dimen.ds80);
                }
                setLayoutParams(layoutParams);
                M(skinInfo.skin, 10, false);
                setOnClickListener(this);
                setScaleType(ImageView.ScaleType.CENTER_CROP);
                setVisibility(0);
                return;
            }
            setVisibility(8);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadSkinView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        v();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        v();
    }
}
