package com.baidu.tieba;

import androidx.lifecycle.SavedStateHandle;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.tencent.open.SocialConstants;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class vkb extends jlb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<a> a;

    /* loaded from: classes8.dex */
    public static class a extends jlb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final Map<String, Set<Object>> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, ObjectInput objectInput) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), objectInput};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = objectInput.readUTF();
            HashMap hashMap = new HashMap();
            int readInt = objectInput.readInt();
            for (int i4 = 0; i4 < readInt; i4++) {
                String readUTF = objectInput.readUTF();
                int readInt2 = objectInput.readInt();
                HashSet hashSet = new HashSet();
                for (int i5 = 0; i5 < readInt2; i5++) {
                    try {
                        hashSet.add(objectInput.readObject());
                    } catch (ClassNotFoundException e) {
                        LogPrinter.e(e);
                    }
                }
                hashMap.put(readUTF, Collections.unmodifiableSet(hashSet));
            }
            this.b = Collections.unmodifiableMap(hashMap);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(JSONObject jSONObject) {
            super(1);
            Map<String, Set<Object>> unmodifiableMap;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = jSONObject.getString("key");
            JSONArray optJSONArray = jSONObject.optJSONArray("content");
            if (optJSONArray == null) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                HashMap hashMap = new HashMap();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    String string = jSONObject2.getString(CriusAttrConstants.COLUMN);
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray(SavedStateHandle.VALUES);
                    int length = optJSONArray2 == null ? 0 : optJSONArray2.length();
                    HashSet hashSet = new HashSet();
                    for (int i4 = 0; i4 < length; i4++) {
                        hashSet.add(optJSONArray2.get(i4));
                    }
                    hashMap.put(string, Collections.unmodifiableSet(hashSet));
                }
                unmodifiableMap = Collections.unmodifiableMap(hashMap);
            }
            this.b = unmodifiableMap;
        }

        @Override // com.baidu.tieba.jlb
        public void srzableInternal(ObjectOutput objectOutput) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, objectOutput) == null) {
                objectOutput.writeUTF(this.a);
                objectOutput.writeInt(this.b.size());
                for (Map.Entry<String, Set<Object>> entry : this.b.entrySet()) {
                    Set<Object> value = entry.getValue();
                    objectOutput.writeUTF(entry.getKey());
                    objectOutput.writeInt(value.size());
                    for (Object obj : value) {
                        objectOutput.writeObject(obj);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vkb(int i, ObjectInput objectInput) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), objectInput};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int readInt = objectInput.readInt();
        HashSet hashSet = new HashSet();
        for (int i4 = 0; i4 < readInt; i4++) {
            hashSet.add(new a(objectInput.readInt(), objectInput));
        }
        this.a = Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vkb(JSONObject jSONObject) {
        super(1);
        Set<a> unmodifiableSet;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(SocialConstants.PARAM_EXCLUDE);
        if (optJSONArray == null) {
            unmodifiableSet = Collections.emptySet();
        } else {
            HashSet hashSet = new HashSet();
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                hashSet.add(new a(optJSONArray.getJSONObject(i3)));
            }
            unmodifiableSet = Collections.unmodifiableSet(hashSet);
        }
        this.a = unmodifiableSet;
    }

    @Override // com.baidu.tieba.jlb
    public void srzableInternal(ObjectOutput objectOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, objectOutput) == null) {
            objectOutput.writeInt(this.a.size());
            for (a aVar : this.a) {
                aVar.srzable(objectOutput);
            }
        }
    }
}
