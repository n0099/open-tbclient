package com.baidu.tieba.newfaceshop.nativemotionmanager;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b.a.e.e.p.l;
import b.a.r0.f2.g.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.NativeEmotionManagerActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class CreateNewEmotionFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.f2.h.f.a f51884e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f51885f;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CreateNewEmotionFragment f51886a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CreateNewEmotionFragment createNewEmotionFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {createNewEmotionFragment, Integer.valueOf(i2)};
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
            this.f51886a = createNewEmotionFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                if (this.f51886a.f51884e == null) {
                    return;
                }
                if (hashMap == null || hashMap.isEmpty()) {
                    if (this.f51886a.f51884e != null) {
                        this.f51886a.f51884e.i();
                    }
                } else if (!hashMap.containsKey("upload_result")) {
                    if (this.f51886a.f51884e != null) {
                        this.f51886a.f51884e.i();
                    }
                } else if (hashMap.get("upload_result") == null || !(hashMap.get("upload_result") instanceof Boolean)) {
                    if (this.f51886a.f51884e != null) {
                        this.f51886a.f51884e.i();
                    }
                } else if (!((Boolean) hashMap.get("upload_result")).booleanValue()) {
                    if (this.f51886a.f51884e != null) {
                        String str = (String) hashMap.get("upload_msg");
                        if (!TextUtils.isEmpty(str)) {
                            l.J(this.f51886a.getActivity(), str);
                        } else {
                            l.J(this.f51886a.getActivity(), this.f51886a.getString(R.string.emotion_error_default_net_tip));
                        }
                        this.f51886a.f51884e.l();
                    }
                } else {
                    BdToast.c(this.f51886a.getPageContext().getPageActivity(), this.f51886a.getPageContext().getPageActivity().getText(R.string.face_group_upload_success)).q();
                    if (this.f51886a.f51884e != null) {
                        this.f51886a.f51884e.i();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921054));
                }
            }
        }
    }

    public CreateNewEmotionFragment() {
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
        this.f51885f = new a(this, 2921040);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f51884e == null) {
            return;
        }
        if (e.l().r()) {
            this.f51884e.j();
        } else if (e.l().k() == null) {
            this.f51884e.i();
        } else {
            this.f51884e.m(getString(R.string.emotion_draft_tip));
        }
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                return arguments.getInt(NativeEmotionManagerActivityConfig.KEY, 0);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            b.a.r0.f2.h.f.a aVar = this.f51884e;
            if (aVar != null) {
                aVar.g(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, layoutInflater, viewGroup, bundle)) == null) {
            registerListener(this.f51885f);
            b.a.r0.f2.h.f.a aVar = new b.a.r0.f2.h.f.a(getPageContext(), h());
            this.f51884e = aVar;
            return aVar.f();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            b.a.r0.f2.h.f.a aVar = this.f51884e;
            if (aVar != null) {
                aVar.h();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
            g();
        }
    }
}
