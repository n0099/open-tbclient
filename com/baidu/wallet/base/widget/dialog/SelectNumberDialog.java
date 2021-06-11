package com.baidu.wallet.base.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.base.widget.BaseDialog;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import java.util.List;
/* loaded from: classes5.dex */
public class SelectNumberDialog extends BaseDialog implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f23742a;

    /* renamed from: b  reason: collision with root package name */
    public AdapterView.OnItemClickListener f23743b;

    public SelectNumberDialog(Context context) {
        super(context);
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        this.f23742a = linearLayout;
        linearLayout.setOrientation(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        dismiss();
        if (this.f23743b == null || view.getTag() == null) {
            return;
        }
        this.f23743b.onItemClick(null, view, ((Integer) view.getTag()).intValue(), 0L);
    }

    @Override // com.baidu.apollon.base.widget.BaseDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addContentView(this.f23742a);
        hideButtons();
        setTitleText("选择手机号");
        setCancelable(true);
    }

    public void setData(List<String> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        this.f23742a.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(this.mContext, 45.0f));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(this.mContext, 1.0f));
        for (int i2 = 1; i2 < list.size(); i2++) {
            if (i2 > 1) {
                View view = new View(this.mContext);
                view.setBackgroundColor(ResUtils.getColor(this.mContext, "bd_wallet_gray"));
                view.setLayoutParams(layoutParams2);
                this.f23742a.addView(view);
            }
            TextView textView = new TextView(this.mContext);
            textView.setText(list.get(i2));
            textView.setPadding(DisplayUtils.dip2px(this.mContext, 10.0f), 0, 0, 0);
            textView.setGravity(19);
            textView.setLayoutParams(layoutParams);
            textView.setTag(Integer.valueOf(i2));
            textView.setOnClickListener(this);
            this.f23742a.addView(textView);
        }
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f23743b = onItemClickListener;
    }
}
