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
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.contacts.PhoneContactsMananger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class ContactAssociationAdapter extends BaseAdapter implements Filterable, PhoneContactsMananger.LoadAddressInfoComplitedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String[] f58062a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<ContractInfo> f58063b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<ContractInfo> f58064c;

    /* renamed from: d  reason: collision with root package name */
    public final LayoutInflater f58065d;

    /* renamed from: e  reason: collision with root package name */
    public Filter f58066e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<String> f58067f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<String> f58068g;

    /* renamed from: h  reason: collision with root package name */
    public Context f58069h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f58070i;

    /* loaded from: classes10.dex */
    public class AssociationViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ContactAssociationAdapter f58075a;
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
            this.f58075a = contactAssociationAdapter;
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
        this.f58070i = false;
        this.f58062a = new String[]{"@qq.com", "@163.com", "@126.com", "@sina.com", "@gmail.com", "@hotmail.com"};
        this.f58069h = context;
        this.f58065d = LayoutInflater.from(context);
        this.f58067f = new ArrayList<>();
        this.f58068g = new ArrayList<>();
        this.f58070i = z;
        loadPhoneContact();
    }

    public void clearMailInput() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f58064c = new ArrayList<>();
        }
    }

    public List<ContractInfo> getContractInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            int size = this.f58067f.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 < this.f58068g.size()) {
                    arrayList.add(new ContractInfo(this.f58067f.get(i2), this.f58068g.get(i2)));
                } else {
                    arrayList.add(new ContractInfo(this.f58067f.get(i2), ""));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f58067f.size() : invokeV.intValue;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f58066e == null) {
                this.f58066e = new Filter(this) { // from class: com.baidu.wallet.core.utils.contacts.ContactAssociationAdapter.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ ContactAssociationAdapter f58071a;

                    /* renamed from: b  reason: collision with root package name */
                    public final ConcurrentHashMap<String, ArrayList<String>> f58072b;

                    /* renamed from: c  reason: collision with root package name */
                    public final ArrayList<String> f58073c;

                    /* renamed from: d  reason: collision with root package name */
                    public final ArrayList<String> f58074d;

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
                        this.f58071a = this;
                        this.f58072b = new ConcurrentHashMap<>();
                        this.f58073c = new ArrayList<>();
                        this.f58074d = new ArrayList<>();
                    }

                    @Override // android.widget.Filter
                    public Filter.FilterResults performFiltering(CharSequence charSequence) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, charSequence)) == null) {
                            this.f58073c.clear();
                            this.f58074d.clear();
                            this.f58072b.clear();
                            Filter.FilterResults filterResults = new Filter.FilterResults();
                            if (!TextUtils.isEmpty(charSequence)) {
                                if (charSequence.toString().contains("@")) {
                                    if (this.f58071a.f58064c != null && this.f58071a.f58064c.size() > 0) {
                                        Iterator it = this.f58071a.f58064c.iterator();
                                        while (it.hasNext()) {
                                            ContractInfo contractInfo = (ContractInfo) it.next();
                                            if (contractInfo != null) {
                                                String mobile = contractInfo.getMobile();
                                                if (!TextUtils.isEmpty(mobile) && mobile.startsWith(charSequence.toString())) {
                                                    this.f58073c.add(contractInfo.getMobile());
                                                    this.f58074d.add("");
                                                }
                                            }
                                        }
                                    }
                                } else if (this.f58071a.f58070i && (charSequence.length() <= 4 || charSequence.length() >= 13)) {
                                    return filterResults;
                                } else {
                                    if (!this.f58071a.f58070i && (charSequence.length() <= 3 || charSequence.length() >= 11)) {
                                        return filterResults;
                                    }
                                    if (this.f58071a.f58063b == null) {
                                        this.f58071a.f58063b = new ArrayList();
                                    }
                                    if (!this.f58071a.f58063b.isEmpty()) {
                                        if (this.f58071a.f58070i) {
                                            String a2 = this.f58071a.a(charSequence);
                                            if (TextUtils.isEmpty(a2) || a2.length() < 4) {
                                                return filterResults;
                                            }
                                            Iterator it2 = this.f58071a.f58063b.iterator();
                                            while (it2.hasNext()) {
                                                ContractInfo contractInfo2 = (ContractInfo) it2.next();
                                                if (contractInfo2 != null) {
                                                    String mobile2 = contractInfo2.getMobile();
                                                    String name = contractInfo2.getName();
                                                    if (charSequence.length() < 13 && !TextUtils.isEmpty(mobile2) && mobile2.startsWith(a2)) {
                                                        if (mobile2.length() > 13) {
                                                            this.f58073c.add(mobile2.substring(0, 13));
                                                        } else {
                                                            this.f58073c.add(mobile2);
                                                        }
                                                        ArrayList<String> arrayList = this.f58074d;
                                                        if (TextUtils.isEmpty(name)) {
                                                            name = "";
                                                        }
                                                        arrayList.add(name);
                                                    }
                                                }
                                            }
                                        } else {
                                            Iterator it3 = this.f58071a.f58063b.iterator();
                                            while (it3.hasNext()) {
                                                ContractInfo contractInfo3 = (ContractInfo) it3.next();
                                                if (contractInfo3 != null) {
                                                    String mobile3 = contractInfo3.getMobile();
                                                    String name2 = contractInfo3.getName();
                                                    if (charSequence.length() < 11 && !TextUtils.isEmpty(mobile3)) {
                                                        String replace = mobile3.replace(" ", "");
                                                        if (!TextUtils.isEmpty(replace) && replace.startsWith(charSequence.toString())) {
                                                            if (replace.length() > 11) {
                                                                this.f58073c.add(replace.substring(0, 11));
                                                            } else {
                                                                this.f58073c.add(replace);
                                                            }
                                                            ArrayList<String> arrayList2 = this.f58074d;
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
                            int size = this.f58073c.size();
                            filterResults.count = size;
                            if (size > 0) {
                                this.f58072b.put("mD1", this.f58073c);
                                this.f58072b.put("mD2", this.f58074d);
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
                            this.f58071a.f58067f.clear();
                            this.f58071a.f58068g.clear();
                            if (filterResults.count > 0 && (concurrentHashMap = this.f58072b) != null && concurrentHashMap.get("mD1") != null && this.f58072b.get("mD2") != null) {
                                this.f58071a.f58067f.addAll(this.f58072b.get("mD1"));
                                this.f58071a.f58068g.addAll(this.f58072b.get("mD2"));
                                this.f58071a.notifyDataSetChanged();
                                return;
                            }
                            this.f58071a.notifyDataSetInvalidated();
                        }
                    }
                };
            }
            return this.f58066e;
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
                view2 = this.f58065d.inflate(ResUtils.layout(this.f58069h, "wallet_base_history_item"), (ViewGroup) null);
                associationViewHolder.mPhone = (TextView) view2.findViewById(ResUtils.id(this.f58069h, "wallet_phone"));
                associationViewHolder.mName = (TextView) view2.findViewById(ResUtils.id(this.f58069h, "wallet_name"));
                view2.setTag(associationViewHolder);
            } else {
                view2 = view;
                associationViewHolder = (AssociationViewHolder) view.getTag();
            }
            associationViewHolder.mPhone.setText(getItem(i2));
            if (i2 < this.f58068g.size()) {
                associationViewHolder.mName.setText(this.f58068g.get(i2));
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public void loadPhoneContact() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            PhoneContactsMananger.getInstance(DxmApplicationContextImpl.getApplicationContext(this.f58069h)).loadPhoneContacts(this);
        }
    }

    @Override // com.baidu.wallet.core.utils.contacts.PhoneContactsMananger.LoadAddressInfoComplitedListener
    public void onLoadContractsComplited(ArrayList<ContractInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) {
            this.f58063b = arrayList;
        }
    }

    public void setMailInput(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        clearMailInput();
        if (this.f58064c != null) {
            for (int i2 = 0; i2 < this.f58062a.length; i2++) {
                String str2 = str + this.f58062a[i2];
                if (!TextUtils.isEmpty(str2) && str2.length() <= 32) {
                    this.f58064c.add(new ContractInfo(str2, ""));
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
            if (i2 < this.f58067f.size()) {
                return this.f58067f.get(i2);
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
