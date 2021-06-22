package com.baidu.wallet.core.utils.contacts;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.utils.contacts.PhoneContactsMananger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class ContactAssociationAdapter extends BaseAdapter implements Filterable, PhoneContactsMananger.LoadAddressInfoComplitedListener {

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<ContractInfo> f24117b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<ContractInfo> f24118c;

    /* renamed from: d  reason: collision with root package name */
    public final LayoutInflater f24119d;

    /* renamed from: e  reason: collision with root package name */
    public Filter f24120e;

    /* renamed from: h  reason: collision with root package name */
    public Context f24123h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f24124i;

    /* renamed from: a  reason: collision with root package name */
    public String[] f24116a = {"@qq.com", "@163.com", "@126.com", "@sina.com", "@gmail.com", "@hotmail.com"};

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f24121f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f24122g = new ArrayList<>();

    /* loaded from: classes5.dex */
    public class AssociationViewHolder {
        public TextView mName;
        public TextView mPhone;

        public AssociationViewHolder() {
        }
    }

    public ContactAssociationAdapter(Context context, boolean z) {
        this.f24124i = false;
        this.f24123h = context;
        this.f24119d = LayoutInflater.from(context);
        this.f24124i = z;
        loadPhoneContact();
    }

    public void clearMailInput() {
        this.f24118c = new ArrayList<>();
    }

    public List<ContractInfo> getContractInfo() {
        ArrayList arrayList = new ArrayList();
        int size = this.f24121f.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 < this.f24122g.size()) {
                arrayList.add(new ContractInfo(this.f24121f.get(i2), this.f24122g.get(i2)));
            } else {
                arrayList.add(new ContractInfo(this.f24121f.get(i2), ""));
            }
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f24121f.size();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f24120e == null) {
            this.f24120e = new Filter() { // from class: com.baidu.wallet.core.utils.contacts.ContactAssociationAdapter.1

                /* renamed from: b  reason: collision with root package name */
                public final ConcurrentHashMap<String, ArrayList<String>> f24126b = new ConcurrentHashMap<>();

                /* renamed from: c  reason: collision with root package name */
                public final ArrayList<String> f24127c = new ArrayList<>();

                /* renamed from: d  reason: collision with root package name */
                public final ArrayList<String> f24128d = new ArrayList<>();

                @Override // android.widget.Filter
                public Filter.FilterResults performFiltering(CharSequence charSequence) {
                    this.f24127c.clear();
                    this.f24128d.clear();
                    this.f24126b.clear();
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    if (!TextUtils.isEmpty(charSequence)) {
                        if (charSequence.toString().contains("@")) {
                            if (ContactAssociationAdapter.this.f24118c != null && ContactAssociationAdapter.this.f24118c.size() > 0) {
                                Iterator it = ContactAssociationAdapter.this.f24118c.iterator();
                                while (it.hasNext()) {
                                    ContractInfo contractInfo = (ContractInfo) it.next();
                                    if (contractInfo != null) {
                                        String mobile = contractInfo.getMobile();
                                        if (!TextUtils.isEmpty(mobile) && mobile.startsWith(charSequence.toString())) {
                                            this.f24127c.add(contractInfo.getMobile());
                                            this.f24128d.add("");
                                        }
                                    }
                                }
                            }
                        } else if (ContactAssociationAdapter.this.f24124i && (charSequence.length() <= 4 || charSequence.length() >= 13)) {
                            return filterResults;
                        } else {
                            if (!ContactAssociationAdapter.this.f24124i && (charSequence.length() <= 3 || charSequence.length() >= 11)) {
                                return filterResults;
                            }
                            if (ContactAssociationAdapter.this.f24117b == null) {
                                ContactAssociationAdapter.this.f24117b = new ArrayList();
                            }
                            if (!ContactAssociationAdapter.this.f24117b.isEmpty()) {
                                if (ContactAssociationAdapter.this.f24124i) {
                                    String a2 = ContactAssociationAdapter.this.a(charSequence);
                                    if (TextUtils.isEmpty(a2) || a2.length() < 4) {
                                        return filterResults;
                                    }
                                    Iterator it2 = ContactAssociationAdapter.this.f24117b.iterator();
                                    while (it2.hasNext()) {
                                        ContractInfo contractInfo2 = (ContractInfo) it2.next();
                                        if (contractInfo2 != null) {
                                            String mobile2 = contractInfo2.getMobile();
                                            String name = contractInfo2.getName();
                                            if (charSequence.length() < 13 && !TextUtils.isEmpty(mobile2) && mobile2.startsWith(a2)) {
                                                if (mobile2.length() > 13) {
                                                    this.f24127c.add(mobile2.substring(0, 13));
                                                } else {
                                                    this.f24127c.add(mobile2);
                                                }
                                                ArrayList<String> arrayList = this.f24128d;
                                                if (TextUtils.isEmpty(name)) {
                                                    name = "";
                                                }
                                                arrayList.add(name);
                                            }
                                        }
                                    }
                                } else {
                                    Iterator it3 = ContactAssociationAdapter.this.f24117b.iterator();
                                    while (it3.hasNext()) {
                                        ContractInfo contractInfo3 = (ContractInfo) it3.next();
                                        if (contractInfo3 != null) {
                                            String mobile3 = contractInfo3.getMobile();
                                            String name2 = contractInfo3.getName();
                                            if (charSequence.length() < 11 && !TextUtils.isEmpty(mobile3)) {
                                                String replace = mobile3.replace(" ", "");
                                                if (!TextUtils.isEmpty(replace) && replace.startsWith(charSequence.toString())) {
                                                    if (replace.length() > 11) {
                                                        this.f24127c.add(replace.substring(0, 11));
                                                    } else {
                                                        this.f24127c.add(replace);
                                                    }
                                                    ArrayList<String> arrayList2 = this.f24128d;
                                                    if (TextUtils.isEmpty(name2)) {
                                                        name2 = "";
                                                    }
                                                    arrayList2.add(name2);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    int size = this.f24127c.size();
                    filterResults.count = size;
                    if (size > 0) {
                        this.f24126b.put("mD1", this.f24127c);
                        this.f24126b.put("mD2", this.f24128d);
                    }
                    return filterResults;
                }

                @Override // android.widget.Filter
                public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                    ConcurrentHashMap<String, ArrayList<String>> concurrentHashMap;
                    ContactAssociationAdapter.this.f24121f.clear();
                    ContactAssociationAdapter.this.f24122g.clear();
                    if (filterResults.count > 0 && (concurrentHashMap = this.f24126b) != null && concurrentHashMap.get("mD1") != null && this.f24126b.get("mD2") != null) {
                        ContactAssociationAdapter.this.f24121f.addAll(this.f24126b.get("mD1"));
                        ContactAssociationAdapter.this.f24122g.addAll(this.f24126b.get("mD2"));
                        ContactAssociationAdapter.this.notifyDataSetChanged();
                        return;
                    }
                    ContactAssociationAdapter.this.notifyDataSetInvalidated();
                }
            };
        }
        return this.f24120e;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        AssociationViewHolder associationViewHolder;
        if (view == null) {
            associationViewHolder = new AssociationViewHolder();
            view2 = this.f24119d.inflate(ResUtils.layout(this.f24123h, "wallet_base_history_item"), (ViewGroup) null);
            associationViewHolder.mPhone = (TextView) view2.findViewById(ResUtils.id(this.f24123h, "wallet_phone"));
            associationViewHolder.mName = (TextView) view2.findViewById(ResUtils.id(this.f24123h, "wallet_name"));
            view2.setTag(associationViewHolder);
        } else {
            view2 = view;
            associationViewHolder = (AssociationViewHolder) view.getTag();
        }
        associationViewHolder.mPhone.setText(getItem(i2));
        if (i2 < this.f24122g.size()) {
            associationViewHolder.mName.setText(this.f24122g.get(i2));
        }
        return view2;
    }

    public void loadPhoneContact() {
        PhoneContactsMananger.getInstance(this.f24123h.getApplicationContext()).loadPhoneContacts(this);
    }

    @Override // com.baidu.wallet.core.utils.contacts.PhoneContactsMananger.LoadAddressInfoComplitedListener
    public void onLoadContractsComplited(ArrayList<ContractInfo> arrayList) {
        this.f24117b = arrayList;
    }

    public void setMailInput(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        clearMailInput();
        if (this.f24118c != null) {
            for (int i2 = 0; i2 < this.f24116a.length; i2++) {
                String str2 = str + this.f24116a[i2];
                if (!TextUtils.isEmpty(str2) && str2.length() <= 32) {
                    this.f24118c.add(new ContractInfo(str2, ""));
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i2) {
        if (i2 < this.f24121f.size()) {
            return this.f24121f.get(i2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() <= 0) {
            return "";
        }
        int length = charSequence.length();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = charSequence.charAt(i2);
            if (charAt != ' ') {
                stringBuffer.append(charAt);
            }
        }
        if (stringBuffer.length() >= 4) {
            if (stringBuffer.length() < 8) {
                stringBuffer.insert(3, ' ');
            } else {
                stringBuffer.insert(7, ' ');
                stringBuffer.insert(3, ' ');
            }
        }
        return stringBuffer.toString();
    }
}
