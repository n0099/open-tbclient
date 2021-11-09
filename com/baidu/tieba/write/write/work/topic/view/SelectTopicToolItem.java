package com.baidu.tieba.write.write.work.topic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import b.a.q0.s.u.c;
import b.a.r0.k1.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
/* loaded from: classes10.dex */
public class SelectTopicToolItem extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f56331e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f56332f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f56333g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f56334h;

    /* renamed from: i  reason: collision with root package name */
    public f f56335i;
    public b j;
    public boolean k;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTopicToolItem f56336e;

        public a(SelectTopicToolItem selectTopicToolItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTopicToolItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56336e = selectTopicToolItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f56336e.j == null || this.f56336e.f56335i == null) {
                return;
            }
            this.f56336e.j.a(this.f56336e.f56335i);
            if (this.f56336e.f56335i.i()) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_WORK_VIDEO_TOPIC_SUGGESTION_CLICK);
                statisticItem.param("topic_id", this.f56336e.f56335i.b().longValue());
                statisticItem.param(IntentConfig.IS_VIDEO_TOPIC, "1");
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes10.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c();
    }

    public void bindData(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f56335i = fVar;
        if (fVar.i()) {
            this.f56332f.setText("#");
            this.f56331e.setText(this.f56335i.d() + "#");
        } else {
            this.f56331e.setText(HotSelectActivityConfig.HOT_TOPIC_SING + this.f56335i.d() + HotSelectActivityConfig.HOT_TOPIC_SING);
        }
        changeSkin();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            RelativeLayout.inflate(getContext(), R.layout.select_topic_tool_item, this);
            this.f56331e = (EMTextView) findViewById(R.id.topic_tool_title);
            this.f56332f = (EMTextView) findViewById(R.id.topic_tool_title_tag);
            this.f56333g = (ImageView) findViewById(R.id.topic_tool_title_icon);
            this.f56334h = (LinearLayout) findViewById(R.id.ll_hotpic_item);
            setOnClickListener(new a(this));
            changeSkin();
        }
    }

    public void changeSkin() {
        f fVar;
        f fVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!this.k && (fVar2 = this.f56335i) != null) {
                if (fVar2.i()) {
                    this.f56332f.setVisibility(0);
                    this.f56333g.setVisibility(0);
                } else {
                    this.f56333g.setVisibility(8);
                    this.f56332f.setVisibility(8);
                }
                if (this.f56335i.g()) {
                    this.f56333g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_videotopic31, SkinManager.getColor(R.color.CAM_X0304), null));
                } else {
                    this.f56333g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_videotopic31, SkinManager.getColor(R.color.CAM_X0105), null));
                }
            } else {
                this.f56332f.setVisibility(8);
                this.f56333g.setVisibility(0);
                this.f56331e.setText(getContext().getString(R.string.add_topic));
                this.f56333g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.ic_icon_pure_post_topic12, SkinManager.getColor(R.color.CAM_X0109), null));
            }
            if (!this.k && (fVar = this.f56335i) != null && fVar.g()) {
                c.d(this.f56331e).v(R.color.CAM_X0304);
                c.d(this.f56332f).v(R.color.CAM_X0304);
                c d2 = c.d(this.f56334h);
                d2.n(R.string.J_X01);
                d2.l(R.dimen.L_X02);
                d2.k(R.color.CAM_X0304);
                d2.f(R.color.CAM_X0905);
                return;
            }
            c.d(this.f56331e).v(R.color.CAM_X0105);
            c.d(this.f56332f).v(R.color.CAM_X0105);
            c d3 = c.d(this.f56334h);
            d3.n(R.string.J_X01);
            d3.l(R.dimen.L_X02);
            d3.k(R.color.CAM_X0209);
            d3.f(R.color.CAM_X0209);
        }
    }

    public void setIsAddTopicItem() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k = true;
            changeSkin();
        }
    }

    public void setItemClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.j = bVar;
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
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTopicToolItem(Context context, AttributeSet attributeSet, int i2) {
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
        c();
    }
}
