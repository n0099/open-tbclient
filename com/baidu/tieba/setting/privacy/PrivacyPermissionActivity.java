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
import com.baidu.webkit.sdk.PermissionRequest;
import com.kuaishou.weapon.un.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static class PermissionDetailHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public int f46451b;

        /* renamed from: c  reason: collision with root package name */
        public View.OnClickListener f46452c;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PermissionDetailHolder f46453e;

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
                this.f46453e = permissionDetailHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    c.a.q0.l.a.m(this.f46453e.itemView.getContext(), TbConfig.PRIVACY_DETAIL_URL);
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
            this.f46451b = 3;
            a aVar = new a(this);
            this.f46452c = aVar;
            TextView textView = (TextView) view;
            this.a = textView;
            textView.setOnClickListener(aVar);
        }

        public void onChangeSkinType(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || i2 == this.f46451b) {
                return;
            }
            SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0302);
            SkinManager.setBackgroundResource(this.itemView, R.drawable.more_all);
            this.f46451b = i2;
        }
    }

    /* loaded from: classes6.dex */
    public static class PermissionViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbSettingTextTipView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f46454b;

        /* renamed from: c  reason: collision with root package name */
        public int f46455c;

        /* renamed from: d  reason: collision with root package name */
        public View.OnClickListener f46456d;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PermissionViewHolder f46457e;

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
                this.f46457e = permissionViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f46457e.itemView == null) {
                    return;
                }
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", this.f46457e.itemView.getContext().getPackageName(), null));
                this.f46457e.itemView.getContext().startActivity(intent);
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
            this.f46455c = 3;
            this.f46456d = new a(this);
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) view.findViewById(R.id.privacy_name);
            this.a = tbSettingTextTipView;
            tbSettingTextTipView.setOnClickListener(this.f46456d);
            this.f46454b = (TextView) view.findViewById(R.id.privacy_info);
        }

        public void bindView(b bVar) {
            String string;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null || this.itemView == null) {
                return;
            }
            this.a.setText(bVar.f46458b);
            TbSettingTextTipView tbSettingTextTipView = this.a;
            if (bVar.f46460d) {
                string = this.itemView.getContext().getString(R.string.privacy_permisson_open);
            } else {
                string = this.itemView.getContext().getString(R.string.privacy_permisson_closed);
            }
            tbSettingTextTipView.setTip(string);
            this.f46454b.setText(bVar.f46459c);
        }

        public void onChangeSkinType(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 == this.f46455c) {
                return;
            }
            this.a.onChangeSkinType(i2);
            SkinManager.setBackgroundResource(this.a, R.drawable.more_all);
            SkinManager.setBackgroundColor(this.f46454b, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.f46454b, (int) R.color.CAM_X0108);
            this.f46455c = i2;
        }
    }

    /* loaded from: classes6.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public int getItemViewType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                b bVar = (b) this.a.mDataList.get(i2);
                if (bVar == null) {
                    return 0;
                }
                return bVar.a;
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
                    permissionViewHolder.bindView((b) this.a.mDataList.get(i2));
                    permissionViewHolder.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                } else if (itemViewType == 1) {
                    ((PermissionDetailHolder) viewHolder).onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i2)) == null) {
                if (i2 == 0) {
                    return new PermissionViewHolder(LayoutInflater.from(this.a.getActivity()).inflate(R.layout.layout_privacy_permisson_item, viewGroup, false));
                }
                if (i2 == 1) {
                    return new PermissionDetailHolder(LayoutInflater.from(this.a.getActivity()).inflate(R.layout.textview_permission_detail, viewGroup, false));
                }
                return null;
            }
            return (RecyclerView.ViewHolder) invokeLI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f46458b;

        /* renamed from: c  reason: collision with root package name */
        public String f46459c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f46460d;

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
            this.a = 0;
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
        this.PERMISSION_ARRAY = new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, "android.permission.WRITE_EXTERNAL_STORAGE", PermissionRequest.RESOURCE_AUDIO_CAPTURE, s.f53808g};
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
                bVar.a = 0;
                bVar.f46458b = this.PERMISSION_NAME_ARRAY[i2];
                bVar.f46459c = this.PERMISSION_INFO_ARRAY[i2];
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
                for (int i2 = 0; i2 < this.PERMISSION_ARRAY.length; i2++) {
                    this.mDataList.get(i2).f46460d = PermissionUtil.checkPermission(getActivity(), this.PERMISSION_ARRAY[i2]);
                }
                this.mAdapter.notifyDataSetChanged();
            }
        }
    }
}
