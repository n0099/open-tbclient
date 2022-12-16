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
import com.baidu.tieba.sp4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kuaishou.weapon.p0.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class PrivacyPermissionActivity extends BaseActivity<PrivacyPermissionActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public View b;
    public RecyclerView c;
    public List<b> d;
    public View e;
    public String[] f;
    public String[] g;
    public String[] h;
    public RecyclerView.Adapter i;

    /* loaded from: classes6.dex */
    public static class PermissionDetailHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public int b;
        public View.OnClickListener c;

        /* loaded from: classes6.dex */
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
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    sp4.o(this.a.itemView.getContext(), TbConfig.PRIVACY_DETAIL_URL);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PermissionDetailHolder(View view2) {
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
            this.b = 3;
            a aVar = new a(this);
            this.c = aVar;
            TextView textView = (TextView) view2;
            this.a = textView;
            textView.setOnClickListener(aVar);
        }

        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i != this.b) {
                SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0302);
                SkinManager.setBackgroundResource(this.itemView, R.drawable.more_all);
                this.b = i;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class PermissionViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbSettingTextTipView a;
        public TextView b;
        public int c;
        public View.OnClickListener d;

        /* loaded from: classes6.dex */
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
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.itemView == null) {
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
        public PermissionViewHolder(View view2) {
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
            this.c = 3;
            this.d = new a(this);
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) view2.findViewById(R.id.obfuscated_res_0x7f091b36);
            this.a = tbSettingTextTipView;
            tbSettingTextTipView.setOnClickListener(this.d);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b34);
        }

        public void a(b bVar) {
            String string;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) && bVar != null && this.itemView != null) {
                this.a.setText(bVar.b);
                TbSettingTextTipView tbSettingTextTipView = this.a;
                if (bVar.d) {
                    string = this.itemView.getContext().getString(R.string.obfuscated_res_0x7f0f0f84);
                } else {
                    string = this.itemView.getContext().getString(R.string.obfuscated_res_0x7f0f0f82);
                }
                tbSettingTextTipView.setTip(string);
                this.b.setText(bVar.c);
            }
        }

        public void b(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && i != this.c) {
                this.a.f(i);
                SkinManager.setBackgroundResource(this.a, R.drawable.more_all);
                SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0108);
                this.c = i;
            }
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
        public int getItemViewType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                b bVar = (b) this.a.d.get(i);
                if (bVar == null) {
                    return 0;
                }
                return bVar.a;
            }
            return invokeI.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.d.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewHolder, i) == null) {
                int itemViewType = getItemViewType(i);
                if (itemViewType == 0) {
                    PermissionViewHolder permissionViewHolder = (PermissionViewHolder) viewHolder;
                    permissionViewHolder.a((b) this.a.d.get(i));
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
                    return new PermissionViewHolder(LayoutInflater.from(this.a.getActivity()).inflate(R.layout.obfuscated_res_0x7f0d04e6, viewGroup, false));
                }
                if (i == 1) {
                    return new PermissionDetailHolder(LayoutInflater.from(this.a.getActivity()).inflate(R.layout.obfuscated_res_0x7f0d08ab, viewGroup, false));
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
        public String b;
        public String c;
        public boolean d;

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
        this.d = new ArrayList();
        this.f = new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, "android.permission.WRITE_EXTERNAL_STORAGE", PermissionRequest.RESOURCE_AUDIO_CAPTURE, h.g};
        this.g = new String[]{getString(R.string.obfuscated_res_0x7f0f027f), getString(R.string.obfuscated_res_0x7f0f0282), getString(R.string.obfuscated_res_0x7f0f0281), getString(R.string.obfuscated_res_0x7f0f0280)};
        this.h = new String[]{getString(R.string.obfuscated_res_0x7f0f0f78), getString(R.string.obfuscated_res_0x7f0f0f8b), getString(R.string.obfuscated_res_0x7f0f0f8a), getString(R.string.obfuscated_res_0x7f0f0f7f)};
        this.i = new a(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            this.a.onChangeSkinType(getPageContext(), i);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
            this.i.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d077c);
            this.e = findViewById(R.id.obfuscated_res_0x7f091d41);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.a = navigationBar;
            navigationBar.showBottomLine();
            this.b = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.a.setTitleText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0f81));
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            this.c = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            this.c.setAdapter(this.i);
            for (int i = 0; i < this.f.length; i++) {
                b bVar = new b();
                bVar.a = 0;
                bVar.b = this.g[i];
                bVar.c = this.h[i];
                this.d.add(bVar);
            }
            b bVar2 = new b();
            bVar2.a = 1;
            this.d.add(bVar2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onResume();
            if (this.d.size() >= this.f.length) {
                for (int i = 0; i < this.f.length; i++) {
                    this.d.get(i).d = PermissionUtil.checkPermission(getActivity(), this.f[i]);
                }
                this.i.notifyDataSetChanged();
            }
        }
    }
}
