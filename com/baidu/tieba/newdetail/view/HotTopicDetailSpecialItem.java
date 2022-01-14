package com.baidu.tieba.newdetail.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c.a.d.f.p.n;
import c.a.s0.n.f;
import c.a.t0.m2.e.b;
import c.a.t0.q1.c;
import c.a.t0.q1.d;
import c.a.t0.q1.e;
import c.a.t0.q1.h;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
/* loaded from: classes12.dex */
public class HotTopicDetailSpecialItem extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f46128e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f46129f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f46130g;

    /* renamed from: h  reason: collision with root package name */
    public View f46131h;

    /* renamed from: i  reason: collision with root package name */
    public View f46132i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f46133j;
    public TextView k;
    public TextView l;
    public TextView m;
    public b n;
    public f<b> o;
    public String p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailSpecialItem(Context context) {
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
        this.f46128e = 3;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(c.a.t0.q1.f.hot_topic_detail_special_item, (ViewGroup) this, true);
            ViewGroup viewGroup = (ViewGroup) findViewById(e.rootLayout);
            this.f46129f = viewGroup;
            viewGroup.setOnClickListener(this);
            this.f46130g = (TbImageView) findViewById(e.coverView);
            this.f46131h = findViewById(e.coverGradientMask);
            this.f46132i = findViewById(e.videoTimeContainer);
            this.f46133j = (ImageView) findViewById(e.videoPlayIcon);
            this.k = (TextView) findViewById(e.videoPlayTime);
            this.l = (TextView) findViewById(e.descView);
            this.m = (TextView) findViewById(e.tagView);
            this.f46130g.setPlaceHolder(2);
            this.f46130g.setRadius(n.f(getContext(), c.tbds10));
            this.f46130g.setConrers(15);
        }
    }

    public void bindData(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null) {
            return;
        }
        this.n = bVar;
        if (TextUtils.isEmpty(bVar.f19348h)) {
            this.f46130g.setVisibility(8);
            this.f46131h.setVisibility(8);
            this.f46132i.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.addRule(8, 0);
            layoutParams.addRule(3, e.descView);
            this.m.setLayoutParams(layoutParams);
        } else {
            this.f46130g.startLoad(bVar.f19348h, 10, false);
            this.f46130g.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams2.addRule(8, e.coverView);
            layoutParams2.addRule(3, 0);
            this.m.setLayoutParams(layoutParams2);
            if (bVar.f19349i > 0) {
                this.f46132i.setVisibility(0);
                this.f46131h.setVisibility(0);
                this.k.setText(StringUtils.translateSecondsToString(bVar.f19349i));
            } else {
                this.f46132i.setVisibility(8);
                this.f46131h.setVisibility(8);
            }
        }
        this.l.setText(bVar.f19345e);
        String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(bVar.f19346f);
        String str = "" + this.m.getContext().getResources().getString(h.hot_topic_special_item_reply, numberUniformFormatExtra);
        String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(bVar.f19347g);
        if (str.length() > 0) {
            str = str + GlideException.IndentedAppendable.INDENT;
        }
        this.m.setText(str + this.m.getContext().getResources().getString(h.hot_topic_special_item_like, numberUniformFormatExtra2));
        setPadding(0, 0, 0, bVar.k ? n.f(TbadkCoreApplication.getInst(), c.tbds40) : 0);
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f46128e == i2) {
            return;
        }
        TBSelector.setViewBackgroundColorWithPressedState(this.f46129f, c.a.t0.q1.b.CAM_X0205, c.a.t0.q1.b.CAM_X0204);
        SkinManager.setViewTextColor(this.l, c.a.t0.q1.b.CAM_X0105);
        SkinManager.setViewTextColor(this.m, c.a.t0.q1.b.CAM_X0109);
        SkinManager.setViewTextColor(this.k, c.a.t0.q1.b.CAM_X0101);
        this.f46133j.setImageDrawable(SvgManager.getInstance().getPureDrawable(d.ic_icon_pure_video_play12_svg, c.a.t0.q1.b.CAM_X0101, null));
        this.f46128e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || (bVar = this.n) == null || bVar.l == null) {
            return;
        }
        f<b> fVar = this.o;
        if (fVar != null) {
            fVar.a(view, bVar, 0, 0L);
        }
        ThreadCardUtils.jumpToPB(this.n.l, view.getContext(), 17, false, this.p, "1");
    }

    public void setCurrentTopicId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.p = str;
        }
    }

    public void setOnItemCoverListener(f<b> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.o = fVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet) {
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
        this.f46128e = 3;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailSpecialItem(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f46128e = 3;
        a();
    }
}
