package com.baidu.tieba.write.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RelevanceItemSearchActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class WriteEvaluationHeaderView extends FrameLayout implements View.OnClickListener, RankStarView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public EMTextView f37391b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f37392c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f37393d;

    /* renamed from: e  reason: collision with root package name */
    public View f37394e;

    /* renamed from: f  reason: collision with root package name */
    public View f37395f;

    /* renamed from: g  reason: collision with root package name */
    public ItemCardView f37396g;

    /* renamed from: h  reason: collision with root package name */
    public RankStarView f37397h;
    public c i;
    public b j;
    public TbRichTextEvaluateItemInfo k;
    public boolean l;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteEvaluationHeaderView a;

        public a(WriteEvaluationHeaderView writeEvaluationHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeEvaluationHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeEvaluationHeaderView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(float f2);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void onClose();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WriteEvaluationHeaderView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.widget.RankStarView.a
    public void a(float f2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048576, this, f2) == null) || (bVar = this.j) == null) {
            return;
        }
        bVar.a(f2);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RelevanceItemSearchActivityConfig(getContext(), 25048)));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d08e4, (ViewGroup) this, true);
            this.f37392c = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090f96);
            this.f37391b = (EMTextView) findViewById(R.id.obfuscated_res_0x7f090f98);
            this.f37394e = findViewById(R.id.obfuscated_res_0x7f0924a8);
            this.f37393d = (ImageView) findViewById(R.id.obfuscated_res_0x7f090f95);
            this.f37395f = findViewById(R.id.obfuscated_res_0x7f090f97);
            this.f37396g = (ItemCardView) findViewById(R.id.obfuscated_res_0x7f090fa3);
            RankStarView rankStarView = (RankStarView) findViewById(R.id.obfuscated_res_0x7f090fa0);
            this.f37397h = rankStarView;
            rankStarView.setStarSpacing(n.f(getContext(), R.dimen.tbds30));
            this.f37397h.setClickable(true);
            this.f37397h.setStarChangListener(this);
            this.f37396g.N();
            this.f37396g.setOnCloseListener(this);
            this.f37396g.setSizeStyle(1);
            d();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f37394e.setOnClickListener(new a(this));
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37397h.c() : invokeV.booleanValue;
    }

    public void f() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        EMTextView eMTextView = this.f37391b;
        if (eMTextView != null) {
            SkinManager.setViewTextColor(eMTextView, (int) R.color.CAM_X0109);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f37391b);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0206);
        }
        if (this.f37393d != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f37393d, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        }
        View view = this.f37395f;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0210);
        }
        ItemCardView itemCardView = this.f37396g;
        if (itemCardView != null) {
            SkinManager.setBackgroundColor(itemCardView, R.color.CAM_X0206);
        }
        EMTextView eMTextView2 = this.f37392c;
        if (eMTextView2 != null) {
            SkinManager.setViewTextColor(eMTextView2, (int) R.color.CAM_X0105);
        }
        RankStarView rankStarView = this.f37397h;
        if (rankStarView != null) {
            rankStarView.e(skinType);
        }
        RankStarView rankStarView2 = this.f37397h;
        if (rankStarView2 != null) {
            rankStarView2.e(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public TbRichTextEvaluateItemInfo getEvaluateItemInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : (TbRichTextEvaluateItemInfo) invokeV.objValue;
    }

    public ItemCardView getItemStarInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f37396g : (ItemCardView) invokeV.objValue;
    }

    public int getStarCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f37397h.getStarCount() : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            this.f37396g.setVisibility(8);
            this.f37395f.setVisibility(0);
            this.f37397h.setVisibility(8);
            this.f37391b.setVisibility(0);
            c cVar = this.i;
            if (cVar != null) {
                cVar.onClose();
            }
        }
    }

    public void setItemCloseListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.i = cVar;
        }
    }

    public void setItemInfo(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tbRichTextEvaluateItemInfo) == null) {
            this.k = tbRichTextEvaluateItemInfo;
            if (this.l) {
                this.f37396g.setVisibility(0);
                this.f37395f.setVisibility(8);
            }
            this.f37397h.setVisibility(0);
            this.f37397h.setStarCount(0.0f);
            this.f37391b.setVisibility(8);
            this.f37396g.setData(tbRichTextEvaluateItemInfo, 10, "");
        }
    }

    public void setShowItemInfo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.l = z;
            this.f37396g.setVisibility(8);
            this.f37395f.setVisibility(0);
            this.f37394e.setVisibility(8);
        }
    }

    public void setStarChangeListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.j = bVar;
        }
    }

    public void setStarCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.f37397h.setStarCount(i);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WriteEvaluationHeaderView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WriteEvaluationHeaderView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = 3;
        this.l = true;
        c();
    }
}
