package com.baidu.tieba.pb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import c.a.d.f.m.b;
import c.a.d.f.p.m;
import c.a.s0.v3.l0.a;
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
import tbclient.SkinInfo;
/* loaded from: classes12.dex */
public class ThreadSkinView extends TbImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext P;
    public SkinInfo Q;
    public a.b R;

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
        init();
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.TbImageView, android.view.View.OnClickListener
    public void onClick(View view) {
        SkinInfo skinInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || (skinInfo = this.Q) == null || StringUtils.isNull(skinInfo.url)) {
            return;
        }
        a.b bVar = this.R;
        if (bVar != null) {
            bVar.delete(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE);
            this.R.d(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "CLICK");
            this.R.e();
        }
        UrlManager.getInstance().dealOneLink(this.P, new String[]{this.Q.url});
    }

    public void setData(TbPageContext tbPageContext, SkinInfo skinInfo, a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, skinInfo, bVar) == null) {
            if (tbPageContext != null && skinInfo != null && !StringUtils.isNull(skinInfo.skin)) {
                this.P = tbPageContext;
                if (this.Q != skinInfo && bVar != null) {
                    this.R = bVar;
                    bVar.delete(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE);
                    this.R.d("obj_id", skinInfo.obj_id);
                    this.R.d(TiebaStatic.Params.OBJ_URL, skinInfo.url);
                    this.R.d("obj_name", skinInfo.monitor_id);
                    this.R.d(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "VIEW_TRUE");
                    this.R.e();
                }
                this.Q = skinInfo;
                int k2 = m.k(tbPageContext.getPageActivity());
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.width = k2;
                if (!StringUtils.isNull(skinInfo.skin_size)) {
                    String[] split = skinInfo.skin_size.split(",");
                    if (split.length > 1) {
                        int e2 = b.e(split[0].trim(), -1);
                        int e3 = b.e(split[1].trim(), -1);
                        if (e2 > 0 && e3 > 0) {
                            layoutParams.height = (int) (layoutParams.width * (e3 / e2));
                        } else {
                            layoutParams.height = (int) tbPageContext.getResources().getDimension(R.dimen.ds80);
                        }
                    }
                } else {
                    layoutParams.height = (int) tbPageContext.getResources().getDimension(R.dimen.ds80);
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
        init();
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
        init();
    }
}
