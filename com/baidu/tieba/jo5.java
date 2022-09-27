package com.baidu.tieba;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.attention.AttentionView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class jo5 implements zm5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public LinearLayout b;
    public NavigationBar c;
    public RelativeLayout d;
    public TextView e;
    public EMTextView f;
    public AttentionView g;
    public g95 h;
    @Nullable
    public f i;
    public final ArrayList<SelectForumData> j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo5 a;

        public a(jo5 jo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jo5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jo5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.i == null) {
                return;
            }
            this.a.i.a(this.a.j);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo5 a;

        public b(jo5 jo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jo5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jo5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.g == null || this.a.a == null) {
                return;
            }
            this.a.i();
            new ForumSquareActivityConfig(this.a.a.getPageActivity()).start();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AttentionView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo5 a;

        public c(jo5 jo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jo5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jo5Var;
        }

        @Override // com.baidu.tieba.attention.AttentionView.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo5 a;

        public d(jo5 jo5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jo5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jo5Var;
        }

        @Override // com.baidu.tieba.jo5.e
        public void a(SelectForumData selectForumData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, selectForumData) == null) || selectForumData == null) {
                return;
            }
            if (this.a.j.size() == 2 && !selectForumData.isInterestForumSelected) {
                ej.N(this.a.a.getPageActivity(), this.a.a.getString(R.string.obfuscated_res_0x7f0f0098));
                return;
            }
            boolean z = !selectForumData.isInterestForumSelected;
            selectForumData.isInterestForumSelected = z;
            if (z) {
                this.a.j.add(selectForumData);
            } else {
                this.a.q(selectForumData);
            }
            if (this.a.g != null) {
                this.a.g.t(selectForumData.index);
            }
            this.a.p();
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(SelectForumData selectForumData);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(ArrayList<SelectForumData> arrayList);
    }

    public jo5(@NonNull TbPageContext tbPageContext, @NonNull LinearLayout linearLayout, @NonNull NavigationBar navigationBar, @NonNull f fVar, @Nullable ArrayList<SelectForumData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, linearLayout, navigationBar, fVar, arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList<SelectForumData> arrayList2 = new ArrayList<>();
        this.j = arrayList2;
        this.a = tbPageContext;
        this.b = linearLayout;
        this.c = navigationBar;
        this.i = fVar;
        if (arrayList != null) {
            arrayList2.addAll(arrayList);
        }
        o();
        m();
    }

    @Override // com.baidu.tieba.ie5
    public boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ie5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14494");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final e j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new d(this) : (e) invokeV.objValue;
    }

    public final AttentionView.d k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new c(this) : (AttentionView.d) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            EMTextView eMTextView = this.f;
            if (eMTextView != null) {
                eMTextView.setVisibility(0);
            }
            AttentionView attentionView = this.g;
            if (attentionView != null) {
                attentionView.setVisibility(0);
            }
            g95 g95Var = this.h;
            if (g95Var == null || !g95Var.isViewAttached()) {
                return;
            }
            this.h.dettachView(this.d);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d050e, (ViewGroup) this.b, true);
            this.d = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091e43);
            this.f = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f091e44);
            AttentionView attentionView = (AttentionView) this.b.findViewById(R.id.obfuscated_res_0x7f091e42);
            this.g = attentionView;
            if (attentionView != null) {
                attentionView.setForumSelectStateChangedListener(j());
                this.g.setResultEmptyListener(k());
                this.g.o(this.j);
                this.g.c(null);
            }
        }
    }

    @Override // com.baidu.tieba.ie5
    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            EMTextView eMTextView = this.f;
            if (eMTextView != null) {
                SkinManager.setViewTextColor(eMTextView, (int) R.color.CAM_X0108);
            }
            TextView textView = this.e;
            if (textView != null) {
                textView.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, i));
            }
            AttentionView attentionView = this.g;
            if (attentionView != null) {
                attentionView.a();
            }
            g95 g95Var = this.h;
            if (g95Var != null) {
                g95Var.onChangeSkinType();
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.c.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f009a));
            TextView addTextButton = this.c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(R.string.obfuscated_res_0x7f0f0099));
            this.e = addTextButton;
            if (addTextButton != null) {
                addTextButton.setOnClickListener(new a(this));
            }
            p();
        }
    }

    @Override // com.baidu.tieba.zm5
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            AttentionView attentionView = this.g;
            if (attentionView != null) {
                attentionView.onDestroy();
            }
            this.i = null;
        }
    }

    @Override // com.baidu.tieba.zm5
    public void onResume() {
        g95 g95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (g95Var = this.h) != null && g95Var.isViewAttached()) {
            l();
            AttentionView attentionView = this.g;
            if (attentionView != null) {
                attentionView.c(null);
            }
        }
    }

    public final void p() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (textView = this.e) == null) {
            return;
        }
        textView.setEnabled(!this.j.isEmpty());
    }

    public final void q(SelectForumData selectForumData) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, selectForumData) == null) || selectForumData == null) {
            return;
        }
        Iterator<SelectForumData> it = this.j.iterator();
        while (it.hasNext()) {
            SelectForumData next = it.next();
            if (next != null && (str = next.forumId) != null && str.equals(selectForumData.forumId)) {
                it.remove();
                return;
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14493");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.ie5
    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.a == null || this.d == null) {
            return;
        }
        g95 g95Var = this.h;
        if (g95Var == null || !g95Var.isViewAttached()) {
            g95 g95Var2 = new g95(this.a.getPageActivity(), new b(this));
            this.h = g95Var2;
            g95Var2.j(true);
            this.h.m(this.a.getString(R.string.obfuscated_res_0x7f0f0095));
            this.h.o(this.a.getString(R.string.obfuscated_res_0x7f0f0096));
            this.h.g(this.a.getString(R.string.obfuscated_res_0x7f0f0094));
            this.h.i(R.drawable.new_pic_emotion_07);
            this.h.p();
            this.h.attachView(this.d);
            EMTextView eMTextView = this.f;
            if (eMTextView != null) {
                eMTextView.setVisibility(8);
            }
            AttentionView attentionView = this.g;
            if (attentionView != null) {
                attentionView.setVisibility(8);
            }
            r();
        }
    }
}
