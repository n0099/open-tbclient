package com.baidu.tieba.write.write.work.topic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import c.a.s0.s.u.c;
import c.a.t0.p4.d;
import c.a.t0.p4.e;
import c.a.t0.p4.g;
import c.a.t0.p4.h;
import c.a.t0.p4.j;
import c.a.t0.s1.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class SelectTopicToolItem extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f50078e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f50079f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f50080g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f50081h;

    /* renamed from: i  reason: collision with root package name */
    public f f50082i;

    /* renamed from: j  reason: collision with root package name */
    public b f50083j;
    public boolean k;
    public boolean l;

    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTopicToolItem f50084e;

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
            this.f50084e = selectTopicToolItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f50084e.f50083j == null || this.f50084e.f50082i == null) {
                return;
            }
            this.f50084e.f50083j.a(this.f50084e.f50082i);
            if (this.f50084e.f50082i.j()) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_WORK_VIDEO_TOPIC_SUGGESTION_CLICK);
                statisticItem.param("topic_id", this.f50084e.f50082i.d().longValue());
                statisticItem.param("is_video_topic", "1");
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes13.dex */
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
        this.f50082i = fVar;
        if (fVar.j()) {
            this.f50079f.setText("#");
            this.f50078e.setText(this.f50082i.e() + "#");
        } else {
            this.f50078e.setText(HotSelectActivityConfig.HOT_TOPIC_SING + this.f50082i.e() + HotSelectActivityConfig.HOT_TOPIC_SING);
        }
        changeSkin();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            RelativeLayout.inflate(getContext(), h.select_topic_tool_item, this);
            this.f50078e = (EMTextView) findViewById(g.topic_tool_title);
            this.f50079f = (EMTextView) findViewById(g.topic_tool_title_tag);
            this.f50080g = (ImageView) findViewById(g.topic_tool_title_icon);
            this.f50081h = (LinearLayout) findViewById(g.ll_hotpic_item);
            setOnClickListener(new a(this));
            changeSkin();
        }
    }

    public void changeSkin() {
        f fVar;
        f fVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!this.k && (fVar2 = this.f50082i) != null) {
                if (fVar2.j()) {
                    this.f50079f.setVisibility(0);
                    this.f50080g.setVisibility(0);
                } else {
                    this.f50080g.setVisibility(8);
                    this.f50079f.setVisibility(8);
                }
                if (this.f50082i.h()) {
                    this.f50080g.setImageDrawable(WebPManager.getPureDrawable(c.a.t0.p4.f.icon_pure_videotopic31, SkinManager.getColor(d.CAM_X0304), null));
                } else {
                    this.f50080g.setImageDrawable(WebPManager.getPureDrawable(c.a.t0.p4.f.icon_pure_videotopic31, SkinManager.getColor(d.CAM_X0105), null));
                }
            } else {
                this.f50079f.setVisibility(8);
                this.f50080g.setVisibility(0);
                this.f50078e.setText(getContext().getString(j.add_topic));
                this.f50080g.setImageDrawable(WebPManager.getPureDrawable(c.a.t0.p4.f.ic_icon_pure_post_topic12, SkinManager.getColor(d.CAM_X0109), null));
            }
            if (!this.k && (fVar = this.f50082i) != null && fVar.h()) {
                c.d(this.f50078e).v(d.CAM_X0304);
                c.d(this.f50079f).v(d.CAM_X0304);
                c d2 = c.d(this.f50081h);
                d2.n(j.J_X01);
                d2.l(e.L_X02);
                d2.k(d.CAM_X0304);
                d2.f(d.CAM_X0905);
            } else if (this.l && !this.k) {
                c.d(this.f50078e).v(d.CAM_X0105);
                c.d(this.f50079f).v(d.CAM_X0105);
                c d3 = c.d(this.f50081h);
                d3.n(j.J_X01);
                d3.l(e.L_X02);
                d3.k(d.CAM_X0209);
                d3.f(d.CAM_X0201);
            } else {
                c.d(this.f50078e).v(d.CAM_X0105);
                c.d(this.f50079f).v(d.CAM_X0105);
                c d4 = c.d(this.f50081h);
                d4.n(j.J_X01);
                d4.l(e.L_X02);
                d4.k(d.CAM_X0209);
                d4.f(d.CAM_X0209);
            }
        }
    }

    public void setFromBar(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l = z;
            changeSkin();
        }
    }

    public void setIsAddTopicItem() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.k = true;
            changeSkin();
        }
    }

    public void setItemClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f50083j = bVar;
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
