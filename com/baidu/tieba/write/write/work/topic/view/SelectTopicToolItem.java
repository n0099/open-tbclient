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
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.hc8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class SelectTopicToolItem extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EMTextView a;
    public EMTextView b;
    public ImageView c;
    public LinearLayout d;
    public hc8 e;
    public b f;
    public boolean g;
    public boolean h;

    /* loaded from: classes8.dex */
    public interface b {
        void a(@NonNull hc8 hc8Var);
    }

    /* loaded from: classes8.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.f != null && this.a.e != null) {
                this.a.f.a(this.a.e);
                if (this.a.e.j()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_WORK_VIDEO_TOPIC_SUGGESTION_CLICK);
                    statisticItem.param("topic_id", this.a.e.d().longValue());
                    statisticItem.param("is_video_topic", "1");
                    TiebaStatic.log(statisticItem);
                }
            }
        }
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

    public void setFromBar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.h = z;
            d();
        }
    }

    public void setItemClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f = bVar;
        }
    }

    public void c(hc8 hc8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, hc8Var) == null) && hc8Var != null) {
            this.e = hc8Var;
            if (hc8Var.j()) {
                this.b.setText("#");
                this.a.setText(this.e.e() + "#");
            } else {
                this.a.setText(HotSelectActivityConfig.HOT_TOPIC_SING + this.e.e() + HotSelectActivityConfig.HOT_TOPIC_SING);
            }
            d();
        }
    }

    public void d() {
        hc8 hc8Var;
        hc8 hc8Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.g && (hc8Var2 = this.e) != null) {
                if (hc8Var2.j()) {
                    this.b.setVisibility(0);
                    this.c.setVisibility(0);
                } else {
                    this.c.setVisibility(8);
                    this.b.setVisibility(8);
                }
                if (this.e.h()) {
                    this.c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_videotopic31, SkinManager.getColor(R.color.CAM_X0304), null));
                } else {
                    this.c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_videotopic31, SkinManager.getColor(R.color.CAM_X0105), null));
                }
            } else {
                this.b.setVisibility(8);
                this.c.setVisibility(0);
                this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0103));
                this.c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.ic_icon_pure_post_topic12, SkinManager.getColor(R.color.CAM_X0109), null));
            }
            if (!this.g && (hc8Var = this.e) != null && hc8Var.h()) {
                EMManager.from(this.a).setTextColor(R.color.CAM_X0304);
                EMManager.from(this.b).setTextColor(R.color.CAM_X0304);
                EMManager.from(this.d).setCorner(R.string.J_X01).setBorderWidth(R.dimen.L_X02).setBorderColor(R.color.CAM_X0304).setBackGroundColor(R.color.CAM_X0905);
            } else if (this.h && !this.g) {
                EMManager.from(this.a).setTextColor(R.color.CAM_X0105);
                EMManager.from(this.b).setTextColor(R.color.CAM_X0105);
                EMManager.from(this.d).setCorner(R.string.J_X01).setBorderWidth(R.dimen.L_X02).setBorderColor(R.color.CAM_X0209).setBackGroundColor(R.color.CAM_X0201);
            } else {
                EMManager.from(this.a).setTextColor(R.color.CAM_X0105);
                EMManager.from(this.b).setTextColor(R.color.CAM_X0105);
                EMManager.from(this.d).setCorner(R.string.J_X01).setBorderWidth(R.dimen.L_X02).setBorderColor(R.color.CAM_X0209).setBackGroundColor(R.color.CAM_X0209);
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RelativeLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d08b5, this);
            this.a = (EMTextView) findViewById(R.id.obfuscated_res_0x7f0926a2);
            this.b = (EMTextView) findViewById(R.id.obfuscated_res_0x7f0926a4);
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f0926a3);
            this.d = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09161d);
            setOnClickListener(new a(this));
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
}
