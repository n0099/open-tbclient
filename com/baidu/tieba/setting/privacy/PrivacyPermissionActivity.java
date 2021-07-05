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
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.service.AsInstallService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
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

        /* renamed from: a  reason: collision with root package name */
        public TextView f20800a;

        /* renamed from: b  reason: collision with root package name */
        public int f20801b;

        /* renamed from: c  reason: collision with root package name */
        public View.OnClickListener f20802c;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PermissionDetailHolder f20803e;

            public a(PermissionDetailHolder permissionDetailHolder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {permissionDetailHolder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f20803e = permissionDetailHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    d.a.r0.l.a.l(this.f20803e.itemView.getContext(), TbConfig.PRIVACY_DETAIL_URL);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20801b = 3;
            a aVar = new a(this);
            this.f20802c = aVar;
            TextView textView = (TextView) view;
            this.f20800a = textView;
            textView.setOnClickListener(aVar);
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || i2 == this.f20801b) {
                return;
            }
            SkinManager.setViewTextColor(this.f20800a, R.color.CAM_X0302);
            SkinManager.setBackgroundResource(this.itemView, R.drawable.more_all);
            this.f20801b = i2;
        }
    }

    /* loaded from: classes5.dex */
    public static class PermissionViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbSettingTextTipView f20804a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f20805b;

        /* renamed from: c  reason: collision with root package name */
        public int f20806c;

        /* renamed from: d  reason: collision with root package name */
        public View.OnClickListener f20807d;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PermissionViewHolder f20808e;

            public a(PermissionViewHolder permissionViewHolder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {permissionViewHolder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f20808e = permissionViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20808e.itemView == null) {
                    return;
                }
                Intent intent = new Intent();
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts(AsInstallService.SCHEME_PACKAGE_ADDED, this.f20808e.itemView.getContext().getPackageName(), null));
                this.f20808e.itemView.getContext().startActivity(intent);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20806c = 3;
            this.f20807d = new a(this);
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) view.findViewById(R.id.privacy_name);
            this.f20804a = tbSettingTextTipView;
            tbSettingTextTipView.setOnClickListener(this.f20807d);
            this.f20805b = (TextView) view.findViewById(R.id.privacy_info);
        }

        public void a(b bVar) {
            String string;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null || this.itemView == null) {
                return;
            }
            this.f20804a.setText(bVar.f20811b);
            TbSettingTextTipView tbSettingTextTipView = this.f20804a;
            if (bVar.f20813d) {
                string = this.itemView.getContext().getString(R.string.privacy_permisson_open);
            } else {
                string = this.itemView.getContext().getString(R.string.privacy_permisson_closed);
            }
            tbSettingTextTipView.setTip(string);
            this.f20805b.setText(bVar.f20812c);
        }

        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 == this.f20806c) {
                return;
            }
            this.f20804a.f(i2);
            SkinManager.setBackgroundResource(this.f20804a, R.drawable.more_all);
            SkinManager.setBackgroundColor(this.f20805b, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f20805b, R.color.CAM_X0108);
            this.f20806c = i2;
        }
    }

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.Adapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PrivacyPermissionActivity f20809a;

        public a(PrivacyPermissionActivity privacyPermissionActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {privacyPermissionActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20809a = privacyPermissionActivity;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20809a.mDataList.size() : invokeV.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                b bVar = (b) this.f20809a.mDataList.get(i2);
                if (bVar == null) {
                    return 0;
                }
                return bVar.f20810a;
            }
            return invokeI.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewHolder, i2) == null) {
                int itemViewType = getItemViewType(i2);
                if (itemViewType == 0) {
                    PermissionViewHolder permissionViewHolder = (PermissionViewHolder) viewHolder;
                    permissionViewHolder.a((b) this.f20809a.mDataList.get(i2));
                    permissionViewHolder.b(TbadkCoreApplication.getInst().getSkinType());
                } else if (itemViewType == 1) {
                    ((PermissionDetailHolder) viewHolder).a(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i2)) == null) {
                if (i2 == 0) {
                    return new PermissionViewHolder(LayoutInflater.from(this.f20809a.getActivity()).inflate(R.layout.layout_privacy_permisson_item, viewGroup, false));
                }
                if (i2 == 1) {
                    return new PermissionDetailHolder(LayoutInflater.from(this.f20809a.getActivity()).inflate(R.layout.textview_permission_detail, viewGroup, false));
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

        /* renamed from: a  reason: collision with root package name */
        public int f20810a;

        /* renamed from: b  reason: collision with root package name */
        public String f20811b;

        /* renamed from: c  reason: collision with root package name */
        public String f20812c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f20813d;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20810a = 0;
        }
    }

    public PrivacyPermissionActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDataList = new ArrayList();
        this.PERMISSION_ARRAY = new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, StorageUtils.EXTERNAL_STORAGE_PERMISSION, PermissionRequest.RESOURCE_AUDIO_CAPTURE, "android.permission.ACCESS_FINE_LOCATION"};
        this.PERMISSION_NAME_ARRAY = new String[]{getString(R.string.allow_to_use_camera), getString(R.string.allow_to_use_sdcard), getString(R.string.allow_to_use_record), getString(R.string.allow_to_use_location)};
        this.PERMISSION_INFO_ARRAY = new String[]{getString(R.string.privacy_camera_info), getString(R.string.privacy_sdcard_info), getString(R.string.privacy_record_info), getString(R.string.privacy_location_info)};
        this.mAdapter = new a(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0204);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.privacy_permission_activity);
            this.mRootView = findViewById(R.id.root_view);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.showBottomLine();
            this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(getPageContext().getString(R.string.privacy_permission));
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            this.mRecyclerView = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            this.mRecyclerView.setAdapter(this.mAdapter);
            for (int i2 = 0; i2 < this.PERMISSION_ARRAY.length; i2++) {
                b bVar = new b();
                bVar.f20810a = 0;
                bVar.f20811b = this.PERMISSION_NAME_ARRAY[i2];
                bVar.f20812c = this.PERMISSION_INFO_ARRAY[i2];
                this.mDataList.add(bVar);
            }
            b bVar2 = new b();
            bVar2.f20810a = 1;
            this.mDataList.add(bVar2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onResume();
            if (this.mDataList.size() >= this.PERMISSION_ARRAY.length) {
                for (int i2 = 0; i2 < this.PERMISSION_ARRAY.length; i2++) {
                    this.mDataList.get(i2).f20813d = PermissionUtil.checkPermission(getActivity(), this.PERMISSION_ARRAY[i2]);
                }
                this.mAdapter.notifyDataSetChanged();
            }
        }
    }
}
