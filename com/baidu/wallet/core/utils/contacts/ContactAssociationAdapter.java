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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.contacts.PhoneContactsMananger;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class ContactAssociationAdapter extends BaseAdapter implements Filterable, PhoneContactsMananger.LoadAddressInfoComplitedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String[] f24659a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<ContractInfo> f24660b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<ContractInfo> f24661c;

    /* renamed from: d  reason: collision with root package name */
    public final LayoutInflater f24662d;

    /* renamed from: e  reason: collision with root package name */
    public Filter f24663e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f24664f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f24665g;

    /* renamed from: h  reason: collision with root package name */
    public Context f24666h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f24667i;

    /* loaded from: classes6.dex */
    public class AssociationViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ContactAssociationAdapter f24672a;
        public TextView mName;
        public TextView mPhone;

        public AssociationViewHolder(ContactAssociationAdapter contactAssociationAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contactAssociationAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24672a = contactAssociationAdapter;
        }
    }

    public ContactAssociationAdapter(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24667i = false;
        this.f24659a = new String[]{"@qq.com", "@163.com", "@126.com", "@sina.com", "@gmail.com", "@hotmail.com"};
        this.f24666h = context;
        this.f24662d = LayoutInflater.from(context);
        this.f24664f = new ArrayList<>();
        this.f24665g = new ArrayList<>();
        this.f24667i = z;
        loadPhoneContact();
    }

    public void clearMailInput() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24661c = new ArrayList<>();
        }
    }

    public List<ContractInfo> getContractInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            int size = this.f24664f.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 < this.f24665g.size()) {
                    arrayList.add(new ContractInfo(this.f24664f.get(i2), this.f24665g.get(i2)));
                } else {
                    arrayList.add(new ContractInfo(this.f24664f.get(i2), ""));
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24664f.size() : invokeV.intValue;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f24663e == null) {
                this.f24663e = new Filter(this) { // from class: com.baidu.wallet.core.utils.contacts.ContactAssociationAdapter.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ContactAssociationAdapter f24668a;

                    /* renamed from: b  reason: collision with root package name */
                    public final ConcurrentHashMap<String, ArrayList<String>> f24669b;

                    /* renamed from: c  reason: collision with root package name */
                    public final ArrayList<String> f24670c;

                    /* renamed from: d  reason: collision with root package name */
                    public final ArrayList<String> f24671d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f24668a = this;
                        this.f24669b = new ConcurrentHashMap<>();
                        this.f24670c = new ArrayList<>();
                        this.f24671d = new ArrayList<>();
                    }

                    @Override // android.widget.Filter
                    public Filter.FilterResults performFiltering(CharSequence charSequence) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, charSequence)) == null) {
                            this.f24670c.clear();
                            this.f24671d.clear();
                            this.f24669b.clear();
                            Filter.FilterResults filterResults = new Filter.FilterResults();
                            if (!TextUtils.isEmpty(charSequence)) {
                                if (charSequence.toString().contains(TNCManager.TNC_PROBE_HEADER_SECEPTOR)) {
                                    if (this.f24668a.f24661c != null && this.f24668a.f24661c.size() > 0) {
                                        Iterator it = this.f24668a.f24661c.iterator();
                                        while (it.hasNext()) {
                                            ContractInfo contractInfo = (ContractInfo) it.next();
                                            if (contractInfo != null) {
                                                String mobile = contractInfo.getMobile();
                                                if (!TextUtils.isEmpty(mobile) && mobile.startsWith(charSequence.toString())) {
                                                    this.f24670c.add(contractInfo.getMobile());
                                                    this.f24671d.add("");
                                                }
                                            }
                                        }
                                    }
                                } else if (this.f24668a.f24667i && (charSequence.length() <= 4 || charSequence.length() >= 13)) {
                                    return filterResults;
                                } else {
                                    if (!this.f24668a.f24667i && (charSequence.length() <= 3 || charSequence.length() >= 11)) {
                                        return filterResults;
                                    }
                                    if (this.f24668a.f24660b == null) {
                                        this.f24668a.f24660b = new ArrayList();
                                    }
                                    if (!this.f24668a.f24660b.isEmpty()) {
                                        if (this.f24668a.f24667i) {
                                            String a2 = this.f24668a.a(charSequence);
                                            if (TextUtils.isEmpty(a2) || a2.length() < 4) {
                                                return filterResults;
                                            }
                                            Iterator it2 = this.f24668a.f24660b.iterator();
                                            while (it2.hasNext()) {
                                                ContractInfo contractInfo2 = (ContractInfo) it2.next();
                                                if (contractInfo2 != null) {
                                                    String mobile2 = contractInfo2.getMobile();
                                                    String name = contractInfo2.getName();
                                                    if (charSequence.length() < 13 && !TextUtils.isEmpty(mobile2) && mobile2.startsWith(a2)) {
                                                        if (mobile2.length() > 13) {
                                                            this.f24670c.add(mobile2.substring(0, 13));
                                                        } else {
                                                            this.f24670c.add(mobile2);
                                                        }
                                                        ArrayList<String> arrayList = this.f24671d;
                                                        if (TextUtils.isEmpty(name)) {
                                                            name = "";
                                                        }
                                                        arrayList.add(name);
                                                    }
                                                }
                                            }
                                        } else {
                                            Iterator it3 = this.f24668a.f24660b.iterator();
                                            while (it3.hasNext()) {
                                                ContractInfo contractInfo3 = (ContractInfo) it3.next();
                                                if (contractInfo3 != null) {
                                                    String mobile3 = contractInfo3.getMobile();
                                                    String name2 = contractInfo3.getName();
                                                    if (charSequence.length() < 11 && !TextUtils.isEmpty(mobile3)) {
                                                        String replace = mobile3.replace(" ", "");
                                                        if (!TextUtils.isEmpty(replace) && replace.startsWith(charSequence.toString())) {
                                                            if (replace.length() > 11) {
                                                                this.f24670c.add(replace.substring(0, 11));
                                                            } else {
                                                                this.f24670c.add(replace);
                                                            }
                                                            ArrayList<String> arrayList2 = this.f24671d;
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
                            int size = this.f24670c.size();
                            filterResults.count = size;
                            if (size > 0) {
                                this.f24669b.put("mD1", this.f24670c);
                                this.f24669b.put("mD2", this.f24671d);
                            }
                            return filterResults;
                        }
                        return (Filter.FilterResults) invokeL.objValue;
                    }

                    @Override // android.widget.Filter
                    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                        ConcurrentHashMap<String, ArrayList<String>> concurrentHashMap;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, filterResults) == null) {
                            this.f24668a.f24664f.clear();
                            this.f24668a.f24665g.clear();
                            if (filterResults.count > 0 && (concurrentHashMap = this.f24669b) != null && concurrentHashMap.get("mD1") != null && this.f24669b.get("mD2") != null) {
                                this.f24668a.f24664f.addAll(this.f24669b.get("mD1"));
                                this.f24668a.f24665g.addAll(this.f24669b.get("mD2"));
                                this.f24668a.notifyDataSetChanged();
                                return;
                            }
                            this.f24668a.notifyDataSetInvalidated();
                        }
                    }
                };
            }
            return this.f24663e;
        }
        return (Filter) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        AssociationViewHolder associationViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                associationViewHolder = new AssociationViewHolder(this);
                view2 = this.f24662d.inflate(ResUtils.layout(this.f24666h, "wallet_base_history_item"), (ViewGroup) null);
                associationViewHolder.mPhone = (TextView) view2.findViewById(ResUtils.id(this.f24666h, "wallet_phone"));
                associationViewHolder.mName = (TextView) view2.findViewById(ResUtils.id(this.f24666h, "wallet_name"));
                view2.setTag(associationViewHolder);
            } else {
                view2 = view;
                associationViewHolder = (AssociationViewHolder) view.getTag();
            }
            associationViewHolder.mPhone.setText(getItem(i2));
            if (i2 < this.f24665g.size()) {
                associationViewHolder.mName.setText(this.f24665g.get(i2));
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public void loadPhoneContact() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            PhoneContactsMananger.getInstance(this.f24666h.getApplicationContext()).loadPhoneContacts(this);
        }
    }

    @Override // com.baidu.wallet.core.utils.contacts.PhoneContactsMananger.LoadAddressInfoComplitedListener
    public void onLoadContractsComplited(ArrayList<ContractInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) {
            this.f24660b = arrayList;
        }
    }

    public void setMailInput(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        clearMailInput();
        if (this.f24661c != null) {
            for (int i2 = 0; i2 < this.f24659a.length; i2++) {
                String str2 = str + this.f24659a[i2];
                if (!TextUtils.isEmpty(str2) && str2.length() <= 32) {
                    this.f24661c.add(new ContractInfo(str2, ""));
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 < this.f24664f.size()) {
                return this.f24664f.get(i2);
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, charSequence)) == null) {
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
        return (String) invokeL.objValue;
    }
}
