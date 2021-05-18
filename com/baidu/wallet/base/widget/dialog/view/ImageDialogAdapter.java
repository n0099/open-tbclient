package com.baidu.wallet.base.widget.dialog.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.WalletDialog;
import com.baidu.wallet.base.widget.dialog.binding.ImageDialogBinding;
import com.baidu.wallet.base.widget.dialog.model.ImageDialogModel;
/* loaded from: classes5.dex */
public class ImageDialogAdapter extends WalletDialog.Adapter<BaseHolder> {

    /* renamed from: a  reason: collision with root package name */
    public ImageDialogModel f23741a;

    /* loaded from: classes5.dex */
    public class BaseHolder extends WalletDialog.ViewHolder {
        public final ImageDialogBinding binding;

        public BaseHolder(ImageDialogBinding imageDialogBinding) {
            super(imageDialogBinding.rootView);
            this.binding = imageDialogBinding;
        }
    }

    public ImageDialogAdapter(ImageDialogModel imageDialogModel) {
        this.f23741a = imageDialogModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.dialog.WalletDialog.Adapter
    public void onBindViewHolder(BaseHolder baseHolder) {
        baseHolder.binding.setViewModel(this.f23741a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.wallet.base.widget.dialog.WalletDialog.Adapter
    public BaseHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new BaseHolder(new ImageDialogBinding(LayoutInflater.from(viewGroup.getContext()).inflate(ResUtils.layout(viewGroup.getContext(), "wallet_base_layout_image_dialog"), (ViewGroup) null)));
    }
}
