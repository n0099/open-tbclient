package com.baidu.wallet.base.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes5.dex */
public class WalletDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f23744a;

    /* renamed from: b  reason: collision with root package name */
    public Adapter f23745b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f23746c;

    /* renamed from: d  reason: collision with root package name */
    public ViewHolder f23747d;
    public Context mContext;

    /* loaded from: classes5.dex */
    public static abstract class Adapter<VH extends ViewHolder> {
        public final void bindViewHolder(VH vh) {
            onBindViewHolder(vh);
        }

        public final VH createViewHolder(ViewGroup viewGroup) {
            return onCreateViewHolder(viewGroup);
        }

        public abstract void onBindViewHolder(VH vh);

        public abstract VH onCreateViewHolder(ViewGroup viewGroup);
    }

    /* loaded from: classes5.dex */
    public static abstract class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final View f23748a;

        public ViewHolder(View view) {
            if (view != null) {
                this.f23748a = view;
                return;
            }
            throw new IllegalArgumentException("contentView may not be null");
        }
    }

    public WalletDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        LayoutInflater from = LayoutInflater.from(this.mContext);
        this.f23746c = from;
        ViewGroup viewGroup = (ViewGroup) from.inflate(ResUtils.layout(this.mContext, "wallet_base_layout_dialog"), (ViewGroup) null);
        this.f23744a = viewGroup;
        setContentView(viewGroup);
        ViewHolder createViewHolder = this.f23745b.createViewHolder(this.f23744a);
        this.f23747d = createViewHolder;
        this.f23744a.addView(createViewHolder.f23748a);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    @Override // android.app.Dialog
    public void onStart() {
        ViewHolder viewHolder;
        super.onStart();
        Adapter adapter = this.f23745b;
        if (adapter == null || this.f23744a == null || (viewHolder = this.f23747d) == null) {
            return;
        }
        adapter.bindViewHolder(viewHolder);
    }

    public void setAdapter(Adapter adapter) {
        this.f23745b = adapter;
    }

    public WalletDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.mContext = context;
    }

    public WalletDialog(Context context, int i2) {
        super(context, i2);
        this.mContext = context;
    }
}
