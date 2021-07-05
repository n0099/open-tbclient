package com.baidu.tieba.square.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class LeftAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f20904a;

    /* renamed from: b  reason: collision with root package name */
    public b f20905b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f20906c;

    /* renamed from: d  reason: collision with root package name */
    public int f20907d;

    /* loaded from: classes5.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f20908a;

        /* renamed from: b  reason: collision with root package name */
        public View f20909b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NonNull LeftAdapter leftAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {leftAdapter, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20908a = (TextView) view.findViewById(R.id.tv_class_name);
            this.f20909b = view.findViewById(R.id.tv_line);
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20910e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewHolder f20911f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f20912g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ LeftAdapter f20913h;

        public a(LeftAdapter leftAdapter, int i2, ViewHolder viewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {leftAdapter, Integer.valueOf(i2), viewHolder, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20913h = leftAdapter;
            this.f20910e = i2;
            this.f20911f = viewHolder;
            this.f20912g = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20913h.r(this.f20910e);
                if (this.f20913h.f20905b != null) {
                    this.f20913h.f20905b.a(this.f20911f.itemView, this.f20910e, this.f20912g);
                }
                StatisticItem statisticItem = new StatisticItem("c13649");
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f20912g);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(View view, int i2, String str);
    }

    public LeftAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20905b = null;
        this.f20907d = 0;
        this.f20904a = context;
    }

    public String g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (String) ListUtils.getItem(this.f20906c, i2) : (String) invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<String> list = this.f20906c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public int h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? ListUtils.getPosition(this.f20906c, str) : invokeL.intValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? g(this.f20907d) : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, viewHolder, i2) == null) {
            String str = this.f20906c.get(i2);
            viewHolder.itemView.setTag(Integer.valueOf(i2));
            viewHolder.f20908a.setText(str);
            if (this.f20907d == i2) {
                viewHolder.f20909b.setVisibility(0);
                SkinManager.setBackgroundColor(viewHolder.f20909b, R.color.CAM_X0302);
                SkinManager.setBackgroundColor(viewHolder.itemView, R.color.CAM_X0205);
                SkinManager.setViewTextColor(viewHolder.f20908a, R.color.CAM_X0105);
            } else {
                viewHolder.f20909b.setVisibility(8);
                SkinManager.setBackgroundColor(viewHolder.itemView, R.color.CAM_X0204);
                SkinManager.setViewTextColor(viewHolder.f20908a, R.color.CAM_X0107);
            }
            if ("推荐".equals(m())) {
                StatisticItem statisticItem = new StatisticItem("c13641");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_locate", 3);
                TiebaStatic.log(statisticItem);
            }
            viewHolder.itemView.setOnClickListener(new a(this, i2, viewHolder, str));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: o */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i2)) == null) ? new ViewHolder(this, LayoutInflater.from(this.f20904a).inflate(R.layout.left_item_layout, viewGroup, false)) : (ViewHolder) invokeLI.objValue;
    }

    public void p(int i2, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, list) == null) {
            this.f20907d = i2;
            this.f20906c = list;
            notifyDataSetChanged();
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.f20905b = bVar;
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f20907d = i2;
            notifyDataSetChanged();
        }
    }
}
