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
/* loaded from: classes9.dex */
public class LeftAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f54937a;

    /* renamed from: b  reason: collision with root package name */
    public b f54938b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f54939c;

    /* renamed from: d  reason: collision with root package name */
    public int f54940d;

    /* loaded from: classes9.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f54941a;

        /* renamed from: b  reason: collision with root package name */
        public View f54942b;

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
            this.f54941a = (TextView) view.findViewById(R.id.tv_class_name);
            this.f54942b = view.findViewById(R.id.tv_line);
        }
    }

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f54943e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewHolder f54944f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f54945g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ LeftAdapter f54946h;

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
            this.f54946h = leftAdapter;
            this.f54943e = i2;
            this.f54944f = viewHolder;
            this.f54945g = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f54946h.setSelectPosition(this.f54943e);
                if (this.f54946h.f54938b != null) {
                    this.f54946h.f54938b.a(this.f54944f.itemView, this.f54943e, this.f54945g);
                }
                StatisticItem statisticItem = new StatisticItem("c13649");
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.f54945g);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes9.dex */
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
        this.f54938b = null;
        this.f54940d = 0;
        this.f54937a = context;
    }

    public String getItemByPosition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (String) ListUtils.getItem(this.f54939c, i2) : (String) invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<String> list = this.f54939c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public int getPositionByItem(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? ListUtils.getPosition(this.f54939c, str) : invokeL.intValue;
    }

    public int getSelectPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f54940d : invokeV.intValue;
    }

    public String getSelected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getItemByPosition(this.f54940d) : (String) invokeV.objValue;
    }

    public void setData(int i2, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, list) == null) {
            this.f54940d = i2;
            this.f54939c = list;
            notifyDataSetChanged();
        }
    }

    public void setOnItemClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.f54938b = bVar;
        }
    }

    public void setSelectPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f54940d = i2;
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, viewHolder, i2) == null) {
            String str = this.f54939c.get(i2);
            viewHolder.itemView.setTag(Integer.valueOf(i2));
            viewHolder.f54941a.setText(str);
            if (this.f54940d == i2) {
                viewHolder.f54942b.setVisibility(0);
                SkinManager.setBackgroundColor(viewHolder.f54942b, R.color.CAM_X0302);
                SkinManager.setBackgroundColor(viewHolder.itemView, R.color.CAM_X0205);
                SkinManager.setViewTextColor(viewHolder.f54941a, R.color.CAM_X0105);
            } else {
                viewHolder.f54942b.setVisibility(8);
                SkinManager.setBackgroundColor(viewHolder.itemView, R.color.CAM_X0204);
                SkinManager.setViewTextColor(viewHolder.f54941a, R.color.CAM_X0107);
            }
            if ("推荐".equals(getSelected())) {
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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, i2)) == null) ? new ViewHolder(this, LayoutInflater.from(this.f54937a).inflate(R.layout.left_item_layout, viewGroup, false)) : (ViewHolder) invokeLI.objValue;
    }

    public void setData(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.f54939c = list;
            notifyDataSetChanged();
        }
    }
}
