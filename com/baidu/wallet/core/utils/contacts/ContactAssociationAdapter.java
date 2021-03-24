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
    public ArrayList<ContractInfo> f24316b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<ContractInfo> f24317c;

    /* renamed from: d  reason: collision with root package name */
    public final LayoutInflater f24318d;

    /* renamed from: e  reason: collision with root package name */
    public Filter f24319e;

    /* renamed from: h  reason: collision with root package name */
    public Context f24322h;
    public boolean i;

    /* renamed from: a  reason: collision with root package name */
    public String[] f24315a = {"@qq.com", "@163.com", "@126.com", "@sina.com", "@gmail.com", "@hotmail.com"};

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f24320f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f24321g = new ArrayList<>();

    /* loaded from: classes5.dex */
    public class AssociationViewHolder {
        public TextView mName;
        public TextView mPhone;

        public AssociationViewHolder() {
        }
    }

    public ContactAssociationAdapter(Context context, boolean z) {
        this.i = false;
        this.f24322h = context;
        this.f24318d = LayoutInflater.from(context);
        this.i = z;
        loadPhoneContact();
    }

    public void clearMailInput() {
        this.f24317c = new ArrayList<>();
    }

    public List<ContractInfo> getContractInfo() {
        ArrayList arrayList = new ArrayList();
        int size = this.f24320f.size();
        for (int i = 0; i < size; i++) {
            if (i < this.f24321g.size()) {
                arrayList.add(new ContractInfo(this.f24320f.get(i), this.f24321g.get(i)));
            } else {
                arrayList.add(new ContractInfo(this.f24320f.get(i), ""));
            }
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f24320f.size();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f24319e == null) {
            this.f24319e = new Filter() { // from class: com.baidu.wallet.core.utils.contacts.ContactAssociationAdapter.1

                /* renamed from: b  reason: collision with root package name */
                public final ConcurrentHashMap<String, ArrayList<String>> f24324b = new ConcurrentHashMap<>();

                /* renamed from: c  reason: collision with root package name */
                public final ArrayList<String> f24325c = new ArrayList<>();

                /* renamed from: d  reason: collision with root package name */
                public final ArrayList<String> f24326d = new ArrayList<>();

                @Override // android.widget.Filter
                public Filter.FilterResults performFiltering(CharSequence charSequence) {
                    this.f24325c.clear();
                    this.f24326d.clear();
                    this.f24324b.clear();
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    if (!TextUtils.isEmpty(charSequence)) {
                        if (charSequence.toString().contains("@")) {
                            if (ContactAssociationAdapter.this.f24317c != null && ContactAssociationAdapter.this.f24317c.size() > 0) {
                                Iterator it = ContactAssociationAdapter.this.f24317c.iterator();
                                while (it.hasNext()) {
                                    ContractInfo contractInfo = (ContractInfo) it.next();
                                    if (contractInfo != null) {
                                        String mobile = contractInfo.getMobile();
                                        if (!TextUtils.isEmpty(mobile) && mobile.startsWith(charSequence.toString())) {
                                            this.f24325c.add(contractInfo.getMobile());
                                            this.f24326d.add("");
                                        }
                                    }
                                }
                            }
                        } else if (ContactAssociationAdapter.this.i && (charSequence.length() <= 4 || charSequence.length() >= 13)) {
                            return filterResults;
                        } else {
                            if (!ContactAssociationAdapter.this.i && (charSequence.length() <= 3 || charSequence.length() >= 11)) {
                                return filterResults;
                            }
                            if (ContactAssociationAdapter.this.f24316b == null) {
                                ContactAssociationAdapter.this.f24316b = new ArrayList();
                            }
                            if (!ContactAssociationAdapter.this.f24316b.isEmpty()) {
                                if (ContactAssociationAdapter.this.i) {
                                    String a2 = ContactAssociationAdapter.this.a(charSequence);
                                    if (TextUtils.isEmpty(a2) || a2.length() < 4) {
                                        return filterResults;
                                    }
                                    Iterator it2 = ContactAssociationAdapter.this.f24316b.iterator();
                                    while (it2.hasNext()) {
                                        ContractInfo contractInfo2 = (ContractInfo) it2.next();
                                        if (contractInfo2 != null) {
                                            String mobile2 = contractInfo2.getMobile();
                                            String name = contractInfo2.getName();
                                            if (charSequence.length() < 13 && !TextUtils.isEmpty(mobile2) && mobile2.startsWith(a2)) {
                                                if (mobile2.length() > 13) {
                                                    this.f24325c.add(mobile2.substring(0, 13));
                                                } else {
                                                    this.f24325c.add(mobile2);
                                                }
                                                ArrayList<String> arrayList = this.f24326d;
                                                if (TextUtils.isEmpty(name)) {
                                                    name = "";
                                                }
                                                arrayList.add(name);
                                            }
                                        }
                                    }
                                } else {
                                    Iterator it3 = ContactAssociationAdapter.this.f24316b.iterator();
                                    while (it3.hasNext()) {
                                        ContractInfo contractInfo3 = (ContractInfo) it3.next();
                                        if (contractInfo3 != null) {
                                            String mobile3 = contractInfo3.getMobile();
                                            String name2 = contractInfo3.getName();
                                            if (charSequence.length() < 11 && !TextUtils.isEmpty(mobile3)) {
                                                String replace = mobile3.replace(" ", "");
                                                if (!TextUtils.isEmpty(replace) && replace.startsWith(charSequence.toString())) {
                                                    if (replace.length() > 11) {
                                                        this.f24325c.add(replace.substring(0, 11));
                                                    } else {
                                                        this.f24325c.add(replace);
                                                    }
                                                    ArrayList<String> arrayList2 = this.f24326d;
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
                    int size = this.f24325c.size();
                    filterResults.count = size;
                    if (size > 0) {
                        this.f24324b.put("mD1", this.f24325c);
                        this.f24324b.put("mD2", this.f24326d);
                    }
                    return filterResults;
                }

                @Override // android.widget.Filter
                public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                    ConcurrentHashMap<String, ArrayList<String>> concurrentHashMap;
                    ContactAssociationAdapter.this.f24320f.clear();
                    ContactAssociationAdapter.this.f24321g.clear();
                    if (filterResults.count > 0 && (concurrentHashMap = this.f24324b) != null && concurrentHashMap.get("mD1") != null && this.f24324b.get("mD2") != null) {
                        ContactAssociationAdapter.this.f24320f.addAll(this.f24324b.get("mD1"));
                        ContactAssociationAdapter.this.f24321g.addAll(this.f24324b.get("mD2"));
                        ContactAssociationAdapter.this.notifyDataSetChanged();
                        return;
                    }
                    ContactAssociationAdapter.this.notifyDataSetInvalidated();
                }
            };
        }
        return this.f24319e;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        AssociationViewHolder associationViewHolder;
        if (view == null) {
            associationViewHolder = new AssociationViewHolder();
            view2 = this.f24318d.inflate(ResUtils.layout(this.f24322h, "wallet_base_history_item"), (ViewGroup) null);
            associationViewHolder.mPhone = (TextView) view2.findViewById(ResUtils.id(this.f24322h, "wallet_phone"));
            associationViewHolder.mName = (TextView) view2.findViewById(ResUtils.id(this.f24322h, "wallet_name"));
            view2.setTag(associationViewHolder);
        } else {
            view2 = view;
            associationViewHolder = (AssociationViewHolder) view.getTag();
        }
        associationViewHolder.mPhone.setText(getItem(i));
        if (i < this.f24321g.size()) {
            associationViewHolder.mName.setText(this.f24321g.get(i));
        }
        return view2;
    }

    public void loadPhoneContact() {
        PhoneContactsMananger.getInstance(this.f24322h.getApplicationContext()).loadPhoneContacts(this);
    }

    @Override // com.baidu.wallet.core.utils.contacts.PhoneContactsMananger.LoadAddressInfoComplitedListener
    public void onLoadContractsComplited(ArrayList<ContractInfo> arrayList) {
        this.f24316b = arrayList;
    }

    public void setMailInput(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        clearMailInput();
        if (this.f24317c != null) {
            for (int i = 0; i < this.f24315a.length; i++) {
                String str2 = str + this.f24315a[i];
                if (!TextUtils.isEmpty(str2) && str2.length() <= 32) {
                    this.f24317c.add(new ContractInfo(str2, ""));
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        if (i < this.f24320f.size()) {
            return this.f24320f.get(i);
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
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
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
