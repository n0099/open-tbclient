package com.baidu.wallet.base.widget.dialog.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.WalletDialog;
import com.baidu.wallet.base.widget.dialog.binding.BaseDialogBinding;
import com.baidu.wallet.base.widget.dialog.model.BaseDialogModel;
/* loaded from: classes5.dex */
public class BaseAdapter extends WalletDialog.Adapter<BaseHolder> {

    /* renamed from: a  reason: collision with root package name */
    public BaseDialogModel f23754a;

    /* loaded from: classes5.dex */
    public class BaseHolder extends WalletDialog.ViewHolder {
        public final BaseDialogBinding binding;

        public BaseHolder(BaseDialogBinding baseDialogBinding) {
            super(baseDialogBinding.rootView);
            this.binding = baseDialogBinding;
        }
    }

    public BaseAdapter(BaseDialogModel baseDialogModel) {
        this.f23754a = baseDialogModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.dialog.WalletDialog.Adapter
    public void onBindViewHolder(BaseHolder baseHolder) {
        baseHolder.binding.setViewModel(this.f23754a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.dialog.WalletDialog.Adapter
    public BaseHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new BaseHolder(new BaseDialogBinding(LayoutInflater.from(viewGroup.getContext()).inflate(ResUtils.layout(viewGroup.getContext(), "wallet_base_layout_common_dialog"), (ViewGroup) null)));
    }
}
