package com.baidu.tieba.personExtra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class SmartAppBrowseHistoryAdapter extends RecyclerView.Adapter<HistoryRecordViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public List<SmartApp> b;
    public View.OnClickListener c;
    public View.OnLongClickListener d;

    /* loaded from: classes5.dex */
    public static class HistoryRecordViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public HeadImageView b;
        public TextView c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HistoryRecordViewHolder(View view2) {
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
            this.a = view2;
            HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091196);
            this.b = headImageView;
            headImageView.setIsRound(true);
            this.b.setPlaceHolder(1);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092603);
        }

        public void a(SmartApp smartApp) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, smartApp) == null) {
                this.a.setTag(smartApp);
                if (!gi.isEmpty(smartApp.avatar)) {
                    this.b.setPlaceHolder(1);
                    this.b.N(smartApp.avatar, 10, false, false);
                }
                if (!gi.isEmpty(smartApp.name)) {
                    this.c.setText(smartApp.name);
                } else {
                    this.c.setText(R.string.intelligent_smart_app);
                }
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundResource(this.a, R.drawable.person_center_action_item_selector);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
            }
        }

        public void c(View.OnClickListener onClickListener) {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) && (view2 = this.a) != null) {
                view2.setOnClickListener(onClickListener);
            }
        }

        public void d(View.OnLongClickListener onLongClickListener) {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, onLongClickListener) == null) && (view2 = this.a) != null) {
                view2.setOnLongClickListener(onLongClickListener);
            }
        }
    }

    public SmartAppBrowseHistoryAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public final SmartApp d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return (SmartApp) ListUtils.getItem(this.b, i);
        }
        return (SmartApp) invokeI.objValue;
    }

    public void e(SmartApp smartApp) {
        SmartApp h;
        List<SmartApp> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, smartApp) == null) && (h = h(smartApp.id)) != null && (list = this.b) != null) {
            ListUtils.add(list, 0, h);
        }
    }

    public void i(List<SmartApp> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.b = list;
        }
    }

    public void j(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.c = onClickListener;
        }
    }

    public void k(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onLongClickListener) == null) {
            this.d = onLongClickListener;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(HistoryRecordViewHolder historyRecordViewHolder, int i) {
        SmartApp d;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, historyRecordViewHolder, i) != null) || historyRecordViewHolder == null || (d = d(i)) == null) {
            return;
        }
        historyRecordViewHolder.a(d);
        historyRecordViewHolder.c(this.c);
        historyRecordViewHolder.d(this.d);
        historyRecordViewHolder.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public HistoryRecordViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i)) == null) {
            return new HistoryRecordViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0844, viewGroup, false));
        }
        return (HistoryRecordViewHolder) invokeLI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ListUtils.getCount(this.b);
        }
        return invokeV.intValue;
    }

    public SmartApp h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (ListUtils.isEmpty(this.b)) {
                return null;
            }
            Iterator<SmartApp> it = this.b.iterator();
            while (it.hasNext()) {
                SmartApp next = it.next();
                if (next != null && StringHelper.equals(next.id, str)) {
                    it.remove();
                    return next;
                }
            }
            return null;
        }
        return (SmartApp) invokeL.objValue;
    }
}
