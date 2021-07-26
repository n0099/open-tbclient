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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import d.a.d.e.p.l;
import d.a.p0.n.f;
import d.a.p0.s.q.a;
import d.a.q0.b2.e.b;
/* loaded from: classes4.dex */
public class HotTopicDetailSpecialItem extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f18919e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f18920f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f18921g;

    /* renamed from: h  reason: collision with root package name */
    public View f18922h;

    /* renamed from: i  reason: collision with root package name */
    public View f18923i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public b n;
    public f<b> o;

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
        this.f18919e = 3;
        b();
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
            return;
        }
        this.n = bVar;
        if (TextUtils.isEmpty(bVar.f55132h)) {
            this.f18921g.setVisibility(8);
            this.f18922h.setVisibility(8);
            this.f18923i.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.addRule(8, 0);
            layoutParams.addRule(3, R.id.descView);
            this.m.setLayoutParams(layoutParams);
        } else {
            this.f18921g.M(bVar.f55132h, 10, false);
            this.f18921g.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams2.addRule(8, R.id.coverView);
            layoutParams2.addRule(3, 0);
            this.m.setLayoutParams(layoutParams2);
            if (bVar.f55133i > 0) {
                this.f18923i.setVisibility(0);
                this.f18922h.setVisibility(0);
                this.k.setText(StringUtils.translateSecondsToString(bVar.f55133i));
            } else {
                this.f18923i.setVisibility(8);
                this.f18922h.setVisibility(8);
            }
        }
        this.l.setText(bVar.f55129e);
        String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(bVar.f55130f);
        String str = "" + this.m.getContext().getResources().getString(R.string.hot_topic_special_item_reply, numberUniformFormatExtra);
        String numberUniformFormatExtra2 = StringHelper.numberUniformFormatExtra(bVar.f55131g);
        if (str.length() > 0) {
            str = str + GlideException.IndentedAppendable.INDENT;
        }
        this.m.setText(str + this.m.getContext().getResources().getString(R.string.hot_topic_special_item_like, numberUniformFormatExtra2));
        setPadding(0, 0, 0, bVar.j ? l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40) : 0);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_special_item, (ViewGroup) this, true);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.rootLayout);
            this.f18920f = viewGroup;
            viewGroup.setOnClickListener(this);
            this.f18921g = (TbImageView) findViewById(R.id.coverView);
            this.f18922h = findViewById(R.id.coverGradientMask);
            this.f18923i = findViewById(R.id.videoTimeContainer);
            this.j = (ImageView) findViewById(R.id.videoPlayIcon);
            this.k = (TextView) findViewById(R.id.videoPlayTime);
            this.l = (TextView) findViewById(R.id.descView);
            this.m = (TextView) findViewById(R.id.tagView);
            this.f18921g.setPlaceHolder(2);
            this.f18921g.setRadius(l.g(getContext(), R.dimen.tbds10));
            this.f18921g.setConrers(15);
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f18919e == i2) {
            return;
        }
        TBSelector.setViewBackgroundColorWithPressedState(this.f18920f, R.color.CAM_X0205, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0101);
        this.j.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
        this.f18919e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || (bVar = this.n) == null || bVar.k == null) {
            return;
        }
        f<b> fVar = this.o;
        if (fVar != null) {
            fVar.a(view, bVar, 0, 0L);
        }
        ThreadCardUtils.jumpToPB((a) this.n.k, view.getContext(), 17, false);
    }

    public void setOnItemCoverListener(f<b> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
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
        this.f18919e = 3;
        b();
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
        this.f18919e = 3;
        b();
    }
}
