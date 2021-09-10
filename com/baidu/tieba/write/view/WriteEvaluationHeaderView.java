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
import c.a.e.e.p.l;
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
/* loaded from: classes7.dex */
public class WriteEvaluationHeaderView extends FrameLayout implements View.OnClickListener, RankStarView.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f58899e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f58900f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f58901g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f58902h;

    /* renamed from: i  reason: collision with root package name */
    public View f58903i;

    /* renamed from: j  reason: collision with root package name */
    public View f58904j;
    public ItemCardView k;
    public RankStarView l;
    public c m;
    public b n;
    public TbRichTextEvaluateItemInfo o;
    public boolean p;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteEvaluationHeaderView f58905e;

        public a(WriteEvaluationHeaderView writeEvaluationHeaderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeEvaluationHeaderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58905e = writeEvaluationHeaderView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f58905e.gotoItemSearch();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void onStarChange(float f2);
    }

    /* loaded from: classes7.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.write_evaluation_header_view, (ViewGroup) this, true);
            this.f58901g = (EMTextView) findViewById(R.id.item_relevance_desc);
            this.f58900f = (EMTextView) findViewById(R.id.item_relevance_tip);
            this.f58903i = findViewById(R.id.write_select_item_relevance);
            this.f58902h = (ImageView) findViewById(R.id.item_relevance_arrow);
            this.f58904j = findViewById(R.id.item_relevance_line);
            this.k = (ItemCardView) findViewById(R.id.item_star_info);
            RankStarView rankStarView = (RankStarView) findViewById(R.id.item_set_new_star);
            this.l = rankStarView;
            rankStarView.setStarSpacing(l.g(getContext(), R.dimen.tbds30));
            this.l.setClickable(true);
            this.l.setStarChangListener(this);
            this.k.showCloseButton();
            this.k.setOnCloseListener(this);
            this.k.setSizeStyle(1);
            b();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f58903i.setOnClickListener(new a(this));
        }
    }

    public TbRichTextEvaluateItemInfo getEvaluateItemInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.o : (TbRichTextEvaluateItemInfo) invokeV.objValue;
    }

    public ItemCardView getItemStarInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (ItemCardView) invokeV.objValue;
    }

    public int getStarCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l.getStarCount() : invokeV.intValue;
    }

    public void gotoItemSearch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RelevanceItemSearchActivityConfig(getContext(), 25048)));
        }
    }

    public boolean isAllFillIn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l.hasStarSelected() : invokeV.booleanValue;
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f58899e) {
            return;
        }
        this.f58899e = skinType;
        EMTextView eMTextView = this.f58900f;
        if (eMTextView != null) {
            SkinManager.setViewTextColor(eMTextView, R.color.CAM_X0109);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f58900f);
            d2.o(R.string.J_X06);
            d2.f(R.color.CAM_X0206);
        }
        if (this.f58902h != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f58902h, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        }
        View view = this.f58904j;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0210);
        }
        ItemCardView itemCardView = this.k;
        if (itemCardView != null) {
            SkinManager.setBackgroundColor(itemCardView, R.color.CAM_X0206);
        }
        EMTextView eMTextView2 = this.f58901g;
        if (eMTextView2 != null) {
            SkinManager.setViewTextColor(eMTextView2, R.color.CAM_X0105);
        }
        RankStarView rankStarView = this.l;
        if (rankStarView != null) {
            rankStarView.onChangeSkinType(skinType);
        }
        RankStarView rankStarView2 = this.l;
        if (rankStarView2 != null) {
            rankStarView2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            this.k.setVisibility(8);
            this.f58904j.setVisibility(0);
            this.l.setVisibility(8);
            this.f58900f.setVisibility(0);
            c cVar = this.m;
            if (cVar != null) {
                cVar.onClose();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.RankStarView.a
    public void onStarChange(float f2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048585, this, f2) == null) || (bVar = this.n) == null) {
            return;
        }
        bVar.onStarChange(f2);
    }

    public void setItemCloseListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.m = cVar;
        }
    }

    public void setItemInfo(TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tbRichTextEvaluateItemInfo) == null) {
            this.o = tbRichTextEvaluateItemInfo;
            if (this.p) {
                this.k.setVisibility(0);
                this.f58904j.setVisibility(8);
            }
            this.l.setVisibility(0);
            this.l.setStarCount(0.0f);
            this.f58900f.setVisibility(8);
            this.k.setData(tbRichTextEvaluateItemInfo, 10, "");
        }
    }

    public void setShowItemInfo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.p = z;
            this.k.setVisibility(8);
            this.f58904j.setVisibility(0);
            this.f58903i.setVisibility(8);
        }
    }

    public void setStarChangeListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.n = bVar;
        }
    }

    public void setStarCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.l.setStarCount(i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WriteEvaluationHeaderView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f58899e = 3;
        this.p = true;
        a();
    }
}
