package com.baidu.wallet.base.widget.dialog.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.WalletDialog;
import com.baidu.wallet.base.widget.dialog.binding.MultiBtnDialogBinding;
import com.baidu.wallet.base.widget.dialog.model.MultiBtnDialogModel;
/* loaded from: classes5.dex */
public class MultiBtnDialogAdapter extends WalletDialog.Adapter<BaseHolder> {

    /* renamed from: a  reason: collision with root package name */
    public MultiBtnDialogModel f23857a;

    /* loaded from: classes5.dex */
    public class BaseHolder extends WalletDialog.ViewHolder {
        public final MultiBtnDialogBinding binding;

        public BaseHolder(MultiBtnDialogBinding multiBtnDialogBinding) {
            super(multiBtnDialogBinding.rootView);
            this.binding = multiBtnDialogBinding;
        }
    }

    public MultiBtnDialogAdapter(MultiBtnDialogModel multiBtnDialogModel) {
        this.f23857a = multiBtnDialogModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.dialog.WalletDialog.Adapter
    public void onBindViewHolder(BaseHolder baseHolder) {
        baseHolder.binding.setViewModel(this.f23857a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.dialog.WalletDialog.Adapter
    public BaseHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new BaseHolder(new MultiBtnDialogBinding(LayoutInflater.from(viewGroup.getContext()).inflate(ResUtils.layout(viewGroup.getContext(), "wallet_base_layout_multibtn_dialog"), (ViewGroup) null)));
    }
}
