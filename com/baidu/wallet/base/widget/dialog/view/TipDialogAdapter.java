package com.baidu.wallet.base.widget.dialog.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.WalletDialog;
import com.baidu.wallet.base.widget.dialog.binding.TipDialogBinding;
import com.baidu.wallet.base.widget.dialog.model.TipDialogModel;
/* loaded from: classes5.dex */
public class TipDialogAdapter extends WalletDialog.Adapter<BaseHolder> {

    /* renamed from: a  reason: collision with root package name */
    public TipDialogModel f23676a;

    /* loaded from: classes5.dex */
    public class BaseHolder extends WalletDialog.ViewHolder {
        public final TipDialogBinding binding;

        public BaseHolder(TipDialogBinding tipDialogBinding) {
            super(tipDialogBinding.rootView);
            this.binding = tipDialogBinding;
        }
    }

    public TipDialogAdapter(TipDialogModel tipDialogModel) {
        this.f23676a = tipDialogModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.dialog.WalletDialog.Adapter
    public void onBindViewHolder(BaseHolder baseHolder) {
        baseHolder.binding.setViewModel(this.f23676a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.dialog.WalletDialog.Adapter
    public BaseHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new BaseHolder(new TipDialogBinding(LayoutInflater.from(viewGroup.getContext()).inflate(ResUtils.layout(viewGroup.getContext(), "wallet_base_layout_tip_dialog"), (ViewGroup) null)));
    }
}
