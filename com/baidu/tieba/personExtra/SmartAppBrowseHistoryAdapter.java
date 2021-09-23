package com.baidu.tieba.personExtra;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.k;
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
import java.util.Iterator;
import java.util.List;
import tbclient.SmartApp;
/* loaded from: classes7.dex */
public class SmartAppBrowseHistoryAdapter extends RecyclerView.Adapter<HistoryRecordViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f56078a;

    /* renamed from: b  reason: collision with root package name */
    public List<SmartApp> f56079b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f56080c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnLongClickListener f56081d;

    /* loaded from: classes7.dex */
    public static class HistoryRecordViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f56082a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f56083b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f56084c;

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
            this.f56082a = view;
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.iv_smart_app_history_record_item_head);
            this.f56083b = headImageView;
            headImageView.setIsRound(true);
            this.f56083b.setPlaceHolder(1);
            this.f56084c = (TextView) view.findViewById(R.id.tv_smart_app_history_record_item_name);
        }

        public void bindData(SmartApp smartApp) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, smartApp) == null) {
                this.f56082a.setTag(smartApp);
                if (!k.isEmpty(smartApp.avatar)) {
                    this.f56083b.setPlaceHolder(1);
                    this.f56083b.startLoad(smartApp.avatar, 10, false, false);
                }
                if (!k.isEmpty(smartApp.name)) {
                    this.f56084c.setText(smartApp.name);
                } else {
                    this.f56084c.setText(R.string.intelligent_smart_app);
                }
            }
        }

        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundResource(this.f56082a, R.drawable.person_center_action_item_selector);
                SkinManager.setViewTextColor(this.f56084c, R.color.CAM_X0105);
            }
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || (view = this.f56082a) == null) {
                return;
            }
            view.setOnClickListener(onClickListener);
        }

        public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, onLongClickListener) == null) || (view = this.f56082a) == null) {
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
        this.f56078a = context;
    }

    public final SmartApp a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (SmartApp) ListUtils.getItem(this.f56079b, i2) : (SmartApp) invokeI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ListUtils.getCount(this.f56079b) : invokeV.intValue;
    }

    public void moveItemToHead(SmartApp smartApp) {
        SmartApp removeData;
        List<SmartApp> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, smartApp) == null) || (removeData = removeData(smartApp.id)) == null || (list = this.f56079b) == null) {
            return;
        }
        ListUtils.add(list, 0, removeData);
    }

    public SmartApp removeData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (ListUtils.isEmpty(this.f56079b)) {
                return null;
            }
            Iterator<SmartApp> it = this.f56079b.iterator();
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

    public void setDataList(List<SmartApp> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f56079b = list;
        }
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.f56080c = onClickListener;
        }
    }

    public void setOnItemLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onLongClickListener) == null) {
            this.f56081d = onLongClickListener;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(HistoryRecordViewHolder historyRecordViewHolder, int i2) {
        SmartApp a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, historyRecordViewHolder, i2) == null) || historyRecordViewHolder == null || (a2 = a(i2)) == null) {
            return;
        }
        historyRecordViewHolder.bindData(a2);
        historyRecordViewHolder.setOnClickListener(this.f56080c);
        historyRecordViewHolder.setOnLongClickListener(this.f56081d);
        historyRecordViewHolder.onChangeSkinType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public HistoryRecordViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i2)) == null) ? new HistoryRecordViewHolder(LayoutInflater.from(this.f56078a).inflate(R.layout.smart_app_history_record_item, viewGroup, false)) : (HistoryRecordViewHolder) invokeLI.objValue;
    }
}
