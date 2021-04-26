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
    public ViewGroup f24467a;

    /* renamed from: b  reason: collision with root package name */
    public Adapter f24468b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f24469c;

    /* renamed from: d  reason: collision with root package name */
    public ViewHolder f24470d;
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
        public final View f24471a;

        public ViewHolder(View view) {
            if (view != null) {
                this.f24471a = view;
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
        this.f24469c = from;
        ViewGroup viewGroup = (ViewGroup) from.inflate(ResUtils.layout(this.mContext, "wallet_base_layout_dialog"), (ViewGroup) null);
        this.f24467a = viewGroup;
        setContentView(viewGroup);
        ViewHolder createViewHolder = this.f24468b.createViewHolder(this.f24467a);
        this.f24470d = createViewHolder;
        this.f24467a.addView(createViewHolder.f24471a);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    @Override // android.app.Dialog
    public void onStart() {
        ViewHolder viewHolder;
        super.onStart();
        Adapter adapter = this.f24468b;
        if (adapter == null || this.f24467a == null || (viewHolder = this.f24470d) == null) {
            return;
        }
        adapter.bindViewHolder(viewHolder);
    }

    public void setAdapter(Adapter adapter) {
        this.f24468b = adapter;
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
