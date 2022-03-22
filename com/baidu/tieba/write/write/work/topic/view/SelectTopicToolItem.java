package com.baidu.tieba.write.write.work.topic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import c.a.o0.r.v.c;
import c.a.p0.t1.f;
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
/* loaded from: classes6.dex */
public class SelectTopicToolItem extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EMTextView a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f37605b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f37606c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f37607d;

    /* renamed from: e  reason: collision with root package name */
    public f f37608e;

    /* renamed from: f  reason: collision with root package name */
    public b f37609f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37610g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f37611h;

    /* loaded from: classes6.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f37609f == null || this.a.f37608e == null) {
                return;
            }
            this.a.f37609f.a(this.a.f37608e);
            if (this.a.f37608e.j()) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_WORK_VIDEO_TOPIC_SUGGESTION_CLICK);
                statisticItem.param("topic_id", this.a.f37608e.d().longValue());
                statisticItem.param("is_video_topic", "1");
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(@NonNull f fVar);
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

    public void c(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f37608e = fVar;
        if (fVar.j()) {
            this.f37605b.setText("#");
            this.a.setText(this.f37608e.e() + "#");
        } else {
            this.a.setText(HotSelectActivityConfig.HOT_TOPIC_SING + this.f37608e.e() + HotSelectActivityConfig.HOT_TOPIC_SING);
        }
        d();
    }

    public void d() {
        f fVar;
        f fVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.f37610g && (fVar2 = this.f37608e) != null) {
                if (fVar2.j()) {
                    this.f37605b.setVisibility(0);
                    this.f37606c.setVisibility(0);
                } else {
                    this.f37606c.setVisibility(8);
                    this.f37605b.setVisibility(8);
                }
                if (this.f37608e.h()) {
                    this.f37606c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809e2, SkinManager.getColor(R.color.CAM_X0304), null));
                } else {
                    this.f37606c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809e2, SkinManager.getColor(R.color.CAM_X0105), null));
                }
            } else {
                this.f37605b.setVisibility(8);
                this.f37606c.setVisibility(0);
                this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f00d1));
                this.f37606c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080612, SkinManager.getColor(R.color.CAM_X0109), null));
            }
            if (!this.f37610g && (fVar = this.f37608e) != null && fVar.h()) {
                c.d(this.a).v(R.color.CAM_X0304);
                c.d(this.f37605b).v(R.color.CAM_X0304);
                c d2 = c.d(this.f37607d);
                d2.n(R.string.J_X01);
                d2.l(R.dimen.L_X02);
                d2.k(R.color.CAM_X0304);
                d2.f(R.color.CAM_X0905);
            } else if (this.f37611h && !this.f37610g) {
                c.d(this.a).v(R.color.CAM_X0105);
                c.d(this.f37605b).v(R.color.CAM_X0105);
                c d3 = c.d(this.f37607d);
                d3.n(R.string.J_X01);
                d3.l(R.dimen.L_X02);
                d3.k(R.color.CAM_X0209);
                d3.f(R.color.CAM_X0201);
            } else {
                c.d(this.a).v(R.color.CAM_X0105);
                c.d(this.f37605b).v(R.color.CAM_X0105);
                c d4 = c.d(this.f37607d);
                d4.n(R.string.J_X01);
                d4.l(R.dimen.L_X02);
                d4.k(R.color.CAM_X0209);
                d4.f(R.color.CAM_X0209);
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RelativeLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d076b, this);
            this.a = (EMTextView) findViewById(R.id.obfuscated_res_0x7f092130);
            this.f37605b = (EMTextView) findViewById(R.id.obfuscated_res_0x7f092132);
            this.f37606c = (ImageView) findViewById(R.id.obfuscated_res_0x7f092131);
            this.f37607d = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0912f4);
            setOnClickListener(new a(this));
            d();
        }
    }

    public void setFromBar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f37611h = z;
            d();
        }
    }

    public void setIsAddTopicItem() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f37610g = true;
            d();
        }
    }

    public void setItemClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f37609f = bVar;
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
