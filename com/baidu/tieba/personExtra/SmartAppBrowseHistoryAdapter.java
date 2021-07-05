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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import java.util.Iterator;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes5.dex */
public class SmartAppBrowseHistoryAdapter extends RecyclerView.Adapter<HistoryRecordViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f20119a;

    /* renamed from: b  reason: collision with root package name */
    public List<SmartApp> f20120b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f20121c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnLongClickListener f20122d;

    /* loaded from: classes5.dex */
    public static class HistoryRecordViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f20123a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f20124b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f20125c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HistoryRecordViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
            this.f20123a = view;
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.iv_smart_app_history_record_item_head);
            this.f20124b = headImageView;
            headImageView.setIsRound(true);
            this.f20124b.setPlaceHolder(1);
            this.f20125c = (TextView) view.findViewById(R.id.tv_smart_app_history_record_item_name);
        }

        public void a(SmartApp smartApp) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, smartApp) == null) {
                this.f20123a.setTag(smartApp);
                if (!k.isEmpty(smartApp.avatar)) {
                    this.f20124b.setPlaceHolder(1);
                    this.f20124b.N(smartApp.avatar, 10, false, false);
                }
                if (!k.isEmpty(smartApp.name)) {
                    this.f20125c.setText(smartApp.name);
                } else {
                    this.f20125c.setText(R.string.intelligent_smart_app);
                }
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundResource(this.f20123a, R.drawable.person_center_action_item_selector);
                SkinManager.setViewTextColor(this.f20125c, R.color.CAM_X0105);
            }
        }

        public void c(View.OnClickListener onClickListener) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || (view = this.f20123a) == null) {
                return;
            }
            view.setOnClickListener(onClickListener);
        }

        public void d(View.OnLongClickListener onLongClickListener) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, onLongClickListener) == null) || (view = this.f20123a) == null) {
                return;
            }
            view.setOnLongClickListener(onLongClickListener);
        }
    }

    public SmartAppBrowseHistoryAdapter(Context context) {
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
        this.f20119a = context;
    }

    public final SmartApp g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (SmartApp) ListUtils.getItem(this.f20120b, i2) : (SmartApp) invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ListUtils.getCount(this.f20120b) : invokeV.intValue;
    }

    public void h(SmartApp smartApp) {
        SmartApp k;
        List<SmartApp> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, smartApp) == null) || (k = k(smartApp.id)) == null || (list = this.f20120b) == null) {
            return;
        }
        ListUtils.add(list, 0, k);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public void onBindViewHolder(HistoryRecordViewHolder historyRecordViewHolder, int i2) {
        SmartApp g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, historyRecordViewHolder, i2) == null) || historyRecordViewHolder == null || (g2 = g(i2)) == null) {
            return;
        }
        historyRecordViewHolder.a(g2);
        historyRecordViewHolder.c(this.f20121c);
        historyRecordViewHolder.d(this.f20122d);
        historyRecordViewHolder.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public HistoryRecordViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i2)) == null) ? new HistoryRecordViewHolder(LayoutInflater.from(this.f20119a).inflate(R.layout.smart_app_history_record_item, viewGroup, false)) : (HistoryRecordViewHolder) invokeLI.objValue;
    }

    public SmartApp k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (ListUtils.isEmpty(this.f20120b)) {
                return null;
            }
            Iterator<SmartApp> it = this.f20120b.iterator();
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

    public void l(List<SmartApp> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.f20120b = list;
        }
    }

    public void m(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.f20121c = onClickListener;
        }
    }

    public void n(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onLongClickListener) == null) {
            this.f20122d = onLongClickListener;
        }
    }
}
