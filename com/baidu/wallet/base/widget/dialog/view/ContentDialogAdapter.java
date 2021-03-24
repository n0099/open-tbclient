package com.baidu.wallet.base.widget.dialog.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.WalletDialog;
import com.baidu.wallet.base.widget.dialog.binding.ContentDialogBinding;
import com.baidu.wallet.base.widget.dialog.model.ContentDialogModel;
/* loaded from: classes5.dex */
public class ContentDialogAdapter extends WalletDialog.Adapter<BaseHolder> {

    /* renamed from: a  reason: collision with root package name */
    public ContentDialogModel f24062a;

    /* loaded from: classes5.dex */
    public class BaseHolder extends WalletDialog.ViewHolder {
        public final ContentDialogBinding binding;

        public BaseHolder(ContentDialogBinding contentDialogBinding) {
            super(contentDialogBinding.rootView);
            this.binding = contentDialogBinding;
        }
    }

    public ContentDialogAdapter(ContentDialogModel contentDialogModel) {
        this.f24062a = contentDialogModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.dialog.WalletDialog.Adapter
    public void onBindViewHolder(BaseHolder baseHolder) {
        baseHolder.binding.setViewModel(this.f24062a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.dialog.WalletDialog.Adapter
    public BaseHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new BaseHolder(new ContentDialogBinding(LayoutInflater.from(viewGroup.getContext()).inflate(ResUtils.layout(viewGroup.getContext(), "wallet_base_layout_content_dialog"), (ViewGroup) null)));
    }
}
