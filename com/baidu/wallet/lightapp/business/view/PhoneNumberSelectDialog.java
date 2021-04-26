package com.baidu.wallet.lightapp.business.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.BaseDialog;
import com.baidu.wallet.lightapp.business.datamodel.ContactInfo;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.List;
/* loaded from: classes5.dex */
public class PhoneNumberSelectDialog extends BaseDialog {

    /* renamed from: a  reason: collision with root package name */
    public ListView f25603a;

    /* renamed from: b  reason: collision with root package name */
    public Context f25604b;

    /* renamed from: c  reason: collision with root package name */
    public a f25605c;

    /* renamed from: d  reason: collision with root package name */
    public List<ContactInfo.Phone> f25606d;

    /* loaded from: classes5.dex */
    public class a extends BaseAdapter {
        public a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (PhoneNumberSelectDialog.this.f25606d == null) {
                return 0;
            }
            return PhoneNumberSelectDialog.this.f25606d.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return PhoneNumberSelectDialog.this.f25606d.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(final int i2, View view, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(PhoneNumberSelectDialog.this.f25604b).inflate(ResUtils.layout(PhoneNumberSelectDialog.this.f25604b, "wallet_langbridge_contact_phone_item"), (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(ResUtils.id(PhoneNumberSelectDialog.this.f25604b, "wallet_base_type"));
            textView.setText(((ContactInfo.Phone) PhoneNumberSelectDialog.this.f25606d.get(i2)).getTypeName() + ZeusCrashHandler.NAME_SEPERATOR + ((ContactInfo.Phone) PhoneNumberSelectDialog.this.f25606d.get(i2)).number);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.lightapp.business.view.PhoneNumberSelectDialog.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    EventBus eventBus = EventBus.getInstance();
                    EventBus eventBus2 = EventBus.getInstance();
                    eventBus2.getClass();
                    eventBus.post(new EventBus.Event("read_contact", ((ContactInfo.Phone) PhoneNumberSelectDialog.this.f25606d.get(i2)).number));
                    PhoneNumberSelectDialog.this.dismiss();
                }
            });
            return inflate;
        }
    }

    public PhoneNumberSelectDialog(Context context) {
        super(context);
        this.f25604b = context;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        dismiss();
    }

    @Override // com.baidu.wallet.base.widget.BaseDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(this.f25604b).inflate(ResUtils.layout(this.f25604b, "wallet_langbridge_contact_phone"), (ViewGroup) null);
        this.f25603a = (ListView) inflate.findViewById(ResUtils.id(this.f25604b, "wallet_base_lv"));
        a aVar = new a();
        this.f25605c = aVar;
        this.f25603a.setAdapter((ListAdapter) aVar);
        addContentView(inflate);
        getNegativeBtn().setTextColor(this.f25604b.getResources().getColor(ResUtils.color(this.f25604b, "wallet_base_mainColor")));
        showCloseBtn(false);
        setTitleText(ResUtils.string(this.f25604b, "wallet_lightapp_contact_please_select_phone"));
        hidePositiveButton();
    }

    public void setPhones(List<ContactInfo.Phone> list) {
        this.f25606d = list;
    }
}
