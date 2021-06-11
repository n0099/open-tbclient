package com.baidu.wallet.base.widget.dialog.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.WalletDialog;
import com.baidu.wallet.base.widget.dialog.binding.NoTitleContentDialogBinding;
import com.baidu.wallet.base.widget.dialog.model.ContentDialogModel;
/* loaded from: classes5.dex */
public class NoTitleContentDialogAdapter extends WalletDialog.Adapter<BaseHolder> {

    /* renamed from: a  reason: collision with root package name */
    public ContentDialogModel f23777a;

    /* loaded from: classes5.dex */
    public class BaseHolder extends WalletDialog.ViewHolder {
        public final NoTitleContentDialogBinding binding;

        public BaseHolder(NoTitleContentDialogBinding noTitleContentDialogBinding) {
            super(noTitleContentDialogBinding.rootView);
            this.binding = noTitleContentDialogBinding;
        }
    }

    public NoTitleContentDialogAdapter(ContentDialogModel contentDialogModel) {
        this.f23777a = contentDialogModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.dialog.WalletDialog.Adapter
    public void onBindViewHolder(BaseHolder baseHolder) {
        baseHolder.binding.setViewModel(this.f23777a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.dialog.WalletDialog.Adapter
    public BaseHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new BaseHolder(new NoTitleContentDialogBinding(LayoutInflater.from(viewGroup.getContext()).inflate(ResUtils.layout(viewGroup.getContext(), "wallet_base_layout_no_title_content_dialog"), (ViewGroup) null)));
    }
}
