package com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble.TopBubbleData;
import com.baidu.tieba.j88;
import com.baidu.tieba.p45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ExcellentAdapter extends RecyclerView.Adapter<ExcellentHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<TopBubbleData> a;
    public c b;

    /* loaded from: classes6.dex */
    public interface c {
        void a(int i);

        void b(int i);
    }

    /* loaded from: classes6.dex */
    public static class ExcellentHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;
        public ConstraintLayout b;
        public LinearLayout c;
        public TextView d;
        public TextView e;
        public ImageView f;
        public ImageView g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ExcellentHolder(@NonNull View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            view2.setVisibility(0);
            this.a = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09069e);
            this.b = (ConstraintLayout) view2.findViewById(R.id.obfuscated_res_0x7f09069d);
            this.c = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09050a);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090509);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090507);
            this.f = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090508);
            this.g = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0920a4);
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ ExcellentHolder b;
        public final /* synthetic */ ExcellentAdapter c;

        public a(ExcellentAdapter excellentAdapter, int i, ExcellentHolder excellentHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {excellentAdapter, Integer.valueOf(i), excellentHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = excellentAdapter;
            this.a = i;
            this.b = excellentHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.c.b != null) {
                this.c.b.a(this.a);
                this.b.f.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ ExcellentAdapter b;

        public b(ExcellentAdapter excellentAdapter, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {excellentAdapter, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = excellentAdapter;
            this.a = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (this.b.b != null) {
                    this.b.b.b(this.a);
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public ExcellentAdapter(@NonNull TbPageContext<BaseFragmentActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void n(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.b = cVar;
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void setData(List<TopBubbleData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            List<TopBubbleData> list2 = this.a;
            if (list2 == null) {
                this.a = new ArrayList();
            } else {
                list2.clear();
            }
            this.a.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return Math.min(this.a.size(), 5);
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"SetTextI18n"})
    /* renamed from: l */
    public void onBindViewHolder(@NonNull ExcellentHolder excellentHolder, @SuppressLint({"RecyclerView"}) int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, excellentHolder, i) == null) {
            TopBubbleData topBubbleData = this.a.get(i);
            TextView textView = excellentHolder.e;
            textView.setText(topBubbleData.getUserName() + "：" + topBubbleData.getContent());
            excellentHolder.d.setText(R.string.obfuscated_res_0x7f0f03ff);
            if (!j88.a(topBubbleData.getVersionKey())) {
                excellentHolder.f.setVisibility(0);
            } else {
                excellentHolder.f.setVisibility(8);
            }
            p45 d = p45.d(excellentHolder.b);
            d.m(R.dimen.L_X02);
            d.o(R.string.J_X05);
            d.f(R.color.CAM_X0207);
            p45 d2 = p45.d(excellentHolder.d);
            d2.w(R.color.CAM_X0101);
            d2.C(R.string.F_X01);
            d2.B(R.dimen.T_X10);
            p45 d3 = p45.d(excellentHolder.e);
            d3.C(R.string.F_X01);
            d3.w(R.color.CAM_X0107);
            d3.B(R.dimen.T_X08);
            p45 d4 = p45.d(excellentHolder.c);
            d4.o(R.string.J_X04);
            d4.f(R.color.CAM_X0303);
            SkinManager.setImageResource(excellentHolder.g, R.drawable.top_bubble_excellent_bg);
            SkinManager.setViewTextColor(excellentHolder.d, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(excellentHolder.e, (int) R.color.CAM_X0107);
            SkinManager.setImageResource(excellentHolder.f, R.drawable.obfuscated_res_0x7f0805ed);
            SkinManager.setViewTextColor(excellentHolder.c, (int) R.color.CAM_X0304);
            excellentHolder.itemView.setOnClickListener(new a(this, i, excellentHolder));
            excellentHolder.itemView.setOnLongClickListener(new b(this, i));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: m */
    public ExcellentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
            return new ExcellentHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0946, viewGroup, false));
        }
        return (ExcellentHolder) invokeLI.objValue;
    }
}
