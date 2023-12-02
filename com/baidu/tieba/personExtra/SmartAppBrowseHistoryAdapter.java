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
import com.baidu.tieba.rd;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes7.dex */
public class SmartAppBrowseHistoryAdapter extends RecyclerView.Adapter<HistoryRecordViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public List<SmartApp> b;
    public View.OnClickListener c;
    public View.OnLongClickListener d;

    /* loaded from: classes7.dex */
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
            HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0912bc);
            this.b = headImageView;
            headImageView.setIsRound(true);
            this.b.setPlaceHolder(1);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092880);
        }

        public void a(SmartApp smartApp) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, smartApp) == null) {
                this.a.setTag(smartApp);
                if (!rd.isEmpty(smartApp.avatar)) {
                    this.b.setPlaceHolder(1);
                    this.b.startLoad(smartApp.avatar, 10, false, false);
                }
                if (!rd.isEmpty(smartApp.name)) {
                    this.c.setText(smartApp.name);
                } else {
                    this.c.setText(R.string.intelligent_smart_app);
                }
            }
        }

        public void b(View.OnClickListener onClickListener) {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) && (view2 = this.a) != null) {
                view2.setOnClickListener(onClickListener);
            }
        }

        public void c(View.OnLongClickListener onLongClickListener) {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onLongClickListener) == null) && (view2 = this.a) != null) {
                view2.setOnLongClickListener(onLongClickListener);
            }
        }

        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SkinManager.setBackgroundResource(this.a, R.drawable.person_center_action_item_selector);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
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

    public final SmartApp l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return (SmartApp) ListUtils.getItem(this.b, i);
        }
        return (SmartApp) invokeI.objValue;
    }

    public void n(SmartApp smartApp) {
        SmartApp q;
        List<SmartApp> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, smartApp) == null) && (q = q(smartApp.id)) != null && (list = this.b) != null) {
            ListUtils.add(list, 0, q);
        }
    }

    public void r(List<SmartApp> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.b = list;
        }
    }

    public void s(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.c = onClickListener;
        }
    }

    public void t(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onLongClickListener) == null) {
            this.d = onLongClickListener;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ListUtils.getCount(this.b);
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(HistoryRecordViewHolder historyRecordViewHolder, int i) {
        SmartApp l;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048579, this, historyRecordViewHolder, i) != null) || historyRecordViewHolder == null || (l = l(i)) == null) {
            return;
        }
        historyRecordViewHolder.a(l);
        historyRecordViewHolder.b(this.c);
        historyRecordViewHolder.c(this.d);
        historyRecordViewHolder.onChangeSkinType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public HistoryRecordViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i)) == null) {
            return new HistoryRecordViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0909, viewGroup, false));
        }
        return (HistoryRecordViewHolder) invokeLI.objValue;
    }

    public SmartApp q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
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
