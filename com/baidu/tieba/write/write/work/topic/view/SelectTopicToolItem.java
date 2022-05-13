package com.baidu.tieba.write.write.work.topic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gs4;
import com.repackage.t37;
/* loaded from: classes4.dex */
public class SelectTopicToolItem extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EMTextView a;
    public EMTextView b;
    public ImageView c;
    public LinearLayout d;
    public t37 e;
    public b f;
    public boolean g;
    public boolean h;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTopicToolItem a;

        public a(SelectTopicToolItem selectTopicToolItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTopicToolItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTopicToolItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.f == null || this.a.e == null) {
                return;
            }
            this.a.f.a(this.a.e);
            if (this.a.e.j()) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_WORK_VIDEO_TOPIC_SUGGESTION_CLICK);
                statisticItem.param("topic_id", this.a.e.d().longValue());
                statisticItem.param("is_video_topic", "1");
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(@NonNull t37 t37Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicToolItem(Context context) {
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
        e();
    }

    public void c(t37 t37Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, t37Var) == null) || t37Var == null) {
            return;
        }
        this.e = t37Var;
        if (t37Var.j()) {
            this.b.setText("#");
            this.a.setText(this.e.e() + "#");
        } else {
            this.a.setText(HotSelectActivityConfig.HOT_TOPIC_SING + this.e.e() + HotSelectActivityConfig.HOT_TOPIC_SING);
        }
        d();
    }

    public void d() {
        t37 t37Var;
        t37 t37Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.g && (t37Var2 = this.e) != null) {
                if (t37Var2.j()) {
                    this.b.setVisibility(0);
                    this.c.setVisibility(0);
                } else {
                    this.c.setVisibility(8);
                    this.b.setVisibility(8);
                }
                if (this.e.h()) {
                    this.c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a04, SkinManager.getColor(R.color.CAM_X0304), null));
                } else {
                    this.c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a04, SkinManager.getColor(R.color.CAM_X0105), null));
                }
            } else {
                this.b.setVisibility(8);
                this.c.setVisibility(0);
                this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f00d4));
                this.c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080600, SkinManager.getColor(R.color.CAM_X0109), null));
            }
            if (!this.g && (t37Var = this.e) != null && t37Var.h()) {
                gs4.d(this.a).v(R.color.CAM_X0304);
                gs4.d(this.b).v(R.color.CAM_X0304);
                gs4 d = gs4.d(this.d);
                d.n(R.string.J_X01);
                d.l(R.dimen.L_X02);
                d.k(R.color.CAM_X0304);
                d.f(R.color.CAM_X0905);
            } else if (this.h && !this.g) {
                gs4.d(this.a).v(R.color.CAM_X0105);
                gs4.d(this.b).v(R.color.CAM_X0105);
                gs4 d2 = gs4.d(this.d);
                d2.n(R.string.J_X01);
                d2.l(R.dimen.L_X02);
                d2.k(R.color.CAM_X0209);
                d2.f(R.color.CAM_X0201);
            } else {
                gs4.d(this.a).v(R.color.CAM_X0105);
                gs4.d(this.b).v(R.color.CAM_X0105);
                gs4 d3 = gs4.d(this.d);
                d3.n(R.string.J_X01);
                d3.l(R.dimen.L_X02);
                d3.k(R.color.CAM_X0209);
                d3.f(R.color.CAM_X0209);
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RelativeLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0755, this);
            this.a = (EMTextView) findViewById(R.id.obfuscated_res_0x7f092171);
            this.b = (EMTextView) findViewById(R.id.obfuscated_res_0x7f092173);
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f092172);
            this.d = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0912f9);
            setOnClickListener(new a(this));
            d();
        }
    }

    public void setFromBar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.h = z;
            d();
        }
    }

    public void setIsAddTopicItem() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.g = true;
            d();
        }
    }

    public void setItemClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f = bVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicToolItem(Context context, AttributeSet attributeSet) {
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
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicToolItem(Context context, AttributeSet attributeSet, int i) {
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
        e();
    }
}
