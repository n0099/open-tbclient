package com.baidu.wallet.base.widget.dialog.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.dialog.WalletDialog;
import com.baidu.wallet.base.widget.dialog.binding.TipDialogBinding;
import com.baidu.wallet.base.widget.dialog.model.TipDialogModel;
/* loaded from: classes8.dex */
public class TipDialogAdapter extends WalletDialog.Adapter<BaseHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TipDialogModel f60911a;

    /* loaded from: classes8.dex */
    public class BaseHolder extends WalletDialog.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TipDialogAdapter f60912a;
        public final TipDialogBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseHolder(TipDialogAdapter tipDialogAdapter, TipDialogBinding tipDialogBinding) {
            super(tipDialogBinding.rootView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tipDialogAdapter, tipDialogBinding};
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
            this.f60912a = tipDialogAdapter;
            this.binding = tipDialogBinding;
        }
    }

    public TipDialogAdapter(TipDialogModel tipDialogModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tipDialogModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60911a = tipDialogModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.dialog.WalletDialog.Adapter
    public void onBindViewHolder(BaseHolder baseHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, baseHolder) == null) {
            baseHolder.binding.setViewModel(this.f60911a);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.dialog.WalletDialog.Adapter
    public BaseHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new BaseHolder(this, new TipDialogBinding(LayoutInflater.from(viewGroup.getContext()).inflate(ResUtils.layout(viewGroup.getContext(), "wallet_base_layout_tip_dialog"), (ViewGroup) null))) : (BaseHolder) invokeL.objValue;
    }
}
