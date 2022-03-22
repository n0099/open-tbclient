package com.baidu.tieba.setting.privacy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class PrivacyPermissionActivity extends BaseActivity<PrivacyPermissionActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String[] PERMISSION_ARRAY;
    public String[] PERMISSION_INFO_ARRAY;
    public String[] PERMISSION_NAME_ARRAY;
    public RecyclerView.Adapter mAdapter;
    public View mBack;
    public List<b> mDataList;
    public NavigationBar mNavigationBar;
    public RecyclerView mRecyclerView;
    public View mRootView;

    /* loaded from: classes5.dex */
    public static class PermissionDetailHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public int f35922b;

        /* renamed from: c  reason: collision with root package name */
        public View.OnClickListener f35923c;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PermissionDetailHolder a;

            public a(PermissionDetailHolder permissionDetailHolder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {permissionDetailHolder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = permissionDetailHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    c.a.o0.l.a.m(this.a.itemView.getContext(), TbConfig.PRIVACY_DETAIL_URL);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PermissionDetailHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
            this.f35922b = 3;
            a aVar = new a(this);
            this.f35923c = aVar;
            TextView textView = (TextView) view;
            this.a = textView;
            textView.setOnClickListener(aVar);
        }

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || i == this.f35922b) {
                return;
            }
            SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0302);
            SkinManager.setBackgroundResource(this.itemView, R.drawable.more_all);
            this.f35922b = i;
        }
    }

    /* loaded from: classes5.dex */
    public static class PermissionViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbSettingTextTipView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f35924b;

        /* renamed from: c  reason: collision with root package name */
        public int f35925c;

        /* renamed from: d  reason: collision with root package name */
        public View.OnClickListener f35926d;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PermissionViewHolder a;

            public a(PermissionViewHolder permissionViewHolder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {permissionViewHolder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = permissionViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.itemView == null) {
                    return;
                }
                Intent intent = new Intent();
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", this.a.itemView.getContext().getPackageName(), null));
                this.a.itemView.getContext().startActivity(intent);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PermissionViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
            this.f35925c = 3;
            this.f35926d = new a(this);
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) view.findViewById(R.id.obfuscated_res_0x7f0918f3);
            this.a = tbSettingTextTipView;
            tbSettingTextTipView.setOnClickListener(this.f35926d);
            this.f35924b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0918f1);
        }

        public void a(b bVar) {
            String string;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null || this.itemView == null) {
                return;
            }
            this.a.setText(bVar.f35927b);
            TbSettingTextTipView tbSettingTextTipView = this.a;
            if (bVar.f35929d) {
                string = this.itemView.getContext().getString(R.string.obfuscated_res_0x7f0f0ebc);
            } else {
                string = this.itemView.getContext().getString(R.string.obfuscated_res_0x7f0f0eba);
            }
            tbSettingTextTipView.setTip(string);
            this.f35924b.setText(bVar.f35928c);
        }

        public void b(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || i == this.f35925c) {
                return;
            }
            this.a.f(i);
            SkinManager.setBackgroundResource(this.a, R.drawable.more_all);
            SkinManager.setBackgroundColor(this.f35924b, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f35924b, (int) R.color.CAM_X0108);
            this.f35925c = i;
        }
    }

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.Adapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PrivacyPermissionActivity a;

        public a(PrivacyPermissionActivity privacyPermissionActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {privacyPermissionActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = privacyPermissionActivity;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.mDataList.size() : invokeV.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                b bVar = (b) this.a.mDataList.get(i);
                if (bVar == null) {
                    return 0;
                }
                return bVar.a;
            }
            return invokeI.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewHolder, i) == null) {
                int itemViewType = getItemViewType(i);
                if (itemViewType == 0) {
                    PermissionViewHolder permissionViewHolder = (PermissionViewHolder) viewHolder;
                    permissionViewHolder.a((b) this.a.mDataList.get(i));
                    permissionViewHolder.b(TbadkCoreApplication.getInst().getSkinType());
                } else if (itemViewType == 1) {
                    ((PermissionDetailHolder) viewHolder).a(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i)) == null) {
                if (i == 0) {
                    return new PermissionViewHolder(LayoutInflater.from(this.a.getActivity()).inflate(R.layout.obfuscated_res_0x7f0d04b6, viewGroup, false));
                }
                if (i == 1) {
                    return new PermissionDetailHolder(LayoutInflater.from(this.a.getActivity()).inflate(R.layout.obfuscated_res_0x7f0d082b, viewGroup, false));
                }
                return null;
            }
            return (RecyclerView.ViewHolder) invokeLI.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f35927b;

        /* renamed from: c  reason: collision with root package name */
        public String f35928c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f35929d;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0;
        }
    }

    public PrivacyPermissionActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDataList = new ArrayList();
        this.PERMISSION_ARRAY = new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.RECORD_AUDIO", "android.permission.ACCESS_FINE_LOCATION"};
        this.PERMISSION_NAME_ARRAY = new String[]{getString(R.string.obfuscated_res_0x7f0f026a), getString(R.string.obfuscated_res_0x7f0f026d), getString(R.string.obfuscated_res_0x7f0f026c), getString(R.string.obfuscated_res_0x7f0f026b)};
        this.PERMISSION_INFO_ARRAY = new String[]{getString(R.string.obfuscated_res_0x7f0f0eb0), getString(R.string.obfuscated_res_0x7f0f0ec1), getString(R.string.obfuscated_res_0x7f0f0ec0), getString(R.string.obfuscated_res_0x7f0f0eb7)};
        this.mAdapter = new a(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0204);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0707);
            this.mRootView = findViewById(R.id.obfuscated_res_0x7f091aee);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923cf);
            this.mNavigationBar = navigationBar;
            navigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0eb9));
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091a27);
            this.mRecyclerView = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            this.mRecyclerView.setAdapter(this.mAdapter);
            for (int i = 0; i < this.PERMISSION_ARRAY.length; i++) {
                b bVar = new b();
                bVar.a = 0;
                bVar.f35927b = this.PERMISSION_NAME_ARRAY[i];
                bVar.f35928c = this.PERMISSION_INFO_ARRAY[i];
                this.mDataList.add(bVar);
            }
            b bVar2 = new b();
            bVar2.a = 1;
            this.mDataList.add(bVar2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onResume();
            if (this.mDataList.size() >= this.PERMISSION_ARRAY.length) {
                for (int i = 0; i < this.PERMISSION_ARRAY.length; i++) {
                    this.mDataList.get(i).f35929d = PermissionUtil.checkPermission(getActivity(), this.PERMISSION_ARRAY[i]);
                }
                this.mAdapter.notifyDataSetChanged();
            }
        }
    }
}
