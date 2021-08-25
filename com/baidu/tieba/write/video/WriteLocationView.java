package com.baidu.tieba.write.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import c.a.e.e.p.j;
import c.a.p0.s.s.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class WriteLocationView extends LocationInfoView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public BaseActivity<?> f58674h;

    /* renamed from: i  reason: collision with root package name */
    public LocationModel f58675i;

    /* renamed from: j  reason: collision with root package name */
    public int f58676j;
    public final LocationModel.e k;
    public final CustomMessageListener l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteLocationView f58677e;

        public a(WriteLocationView writeLocationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeLocationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58677e = writeLocationView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int i2 = this.f58677e.f58676j;
                if (i2 == 0) {
                    this.f58677e.onLocViewClickedInInitState();
                } else if (i2 != 2) {
                } else {
                    this.f58677e.h();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements LocationModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteLocationView f58678a;

        public b(WriteLocationView writeLocationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeLocationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58678a = writeLocationView;
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58678a.f58674h.showToast(R.string.no_network_guide);
                this.f58678a.j(0, true, null);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData locationData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locationData) == null) {
                if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                    this.f58678a.j(2, true, locationData.getFormatted_address());
                } else {
                    onFail(null);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                BaseActivity baseActivity = this.f58678a.f58674h;
                if (StringUtils.isNull(str)) {
                    str = this.f58678a.f58674h.getResources().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                this.f58678a.j(0, true, null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteLocationView f58679e;

        public c(WriteLocationView writeLocationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeLocationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58679e = writeLocationView;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f58679e.j(0, true, null);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteLocationView f58680e;

        public d(WriteLocationView writeLocationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeLocationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58680e = writeLocationView;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (j.z()) {
                    this.f58680e.j(1, true, null);
                    this.f58680e.f58675i.K();
                } else {
                    this.f58680e.k.a();
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteLocationView f58681a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(WriteLocationView writeLocationView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeLocationView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58681a = writeLocationView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedSelectLocation)) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    this.f58681a.f58675i.M(false);
                    this.f58681a.f58675i.L(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    this.f58681a.j(2, true, responsedSelectLocation.getName());
                    return;
                }
                this.f58681a.f58675i.M(true);
                this.f58681a.j(0, true, null);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WriteLocationView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean canShowLocation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LocationModel locationModel = this.f58675i;
            if (locationModel == null) {
                return false;
            }
            return locationModel.z();
        }
        return invokeV.booleanValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.f58674h.getPageContext().getPageActivity())));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f58675i.z() && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                if (this.f58675i.D()) {
                    j(2, true, c.a.q0.i3.n0.b.a().b().getFormatted_address());
                    return;
                }
                j(1, true, null);
                this.f58675i.H();
                return;
            }
            j(0, true, null);
        }
    }

    public void init(BaseActivity<?> baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, baseActivity) == null) {
            this.f58674h = baseActivity;
            baseActivity.registerListener(this.l);
            LocationModel locationModel = new LocationModel(this.f58674h.getPageContext());
            this.f58675i = locationModel;
            locationModel.N(this.k);
            setOnClickListener(new a(this));
            i();
        }
    }

    public final void j(int i2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str}) == null) {
            this.f58676j = i2;
            setVisibility(z ? 0 : 8);
            setState(i2, str);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f58674h.getPageContext().getPageActivity());
            aVar.setMessageId(R.string.location_app_permission_prompt).setPositiveButton(R.string.isopen, new d(this)).setNegativeButton(R.string.cancel, new c(this)).create(this.f58674h.getPageContext());
            aVar.show();
        }
    }

    public void onLocViewClickedInInitState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!UtilHelper.isSystemLocationProviderEnabled(this.f58674h.getPageContext().getPageActivity())) {
                this.f58674h.showToast(R.string.location_system_permission_prompt);
                j(0, true, null);
            } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
                k();
            } else if (this.f58675i.D()) {
                h();
            } else {
                this.f58675i.M(false);
                j(1, true, null);
                this.f58675i.H();
            }
        }
    }

    public void stopTask() {
        LocationModel locationModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (locationModel = this.f58675i) == null) {
            return;
        }
        locationModel.cancelLoadData();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WriteLocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f58676j = 0;
        this.k = new b(this);
        this.l = new e(this, 2001226);
    }
}
