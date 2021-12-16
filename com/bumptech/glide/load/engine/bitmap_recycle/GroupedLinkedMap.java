package com.bumptech.glide.load.engine.bitmap_recycle;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes2.dex */
public class GroupedLinkedMap<K extends Poolable, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedEntry<K, V> head;
    public final Map<K, LinkedEntry<K, V>> keyToEntry;

    /* loaded from: classes2.dex */
    public static class LinkedEntry<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final K key;
        public LinkedEntry<K, V> next;
        public LinkedEntry<K, V> prev;
        public List<V> values;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public LinkedEntry() {
            this(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    this(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public void add(V v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
                if (this.values == null) {
                    this.values = new ArrayList();
                }
                this.values.add(v);
            }
        }

        @Nullable
        public V removeLast() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int size = size();
                if (size > 0) {
                    return this.values.remove(size - 1);
                }
                return null;
            }
            return (V) invokeV.objValue;
        }

        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                List<V> list = this.values;
                if (list != null) {
                    return list.size();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        public LinkedEntry(K k2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.prev = this;
            this.next = this;
            this.key = k2;
        }
    }

    public GroupedLinkedMap() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.head = new LinkedEntry<>();
        this.keyToEntry = new HashMap();
    }

    private void makeHead(LinkedEntry<K, V> linkedEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, linkedEntry) == null) {
            removeEntry(linkedEntry);
            LinkedEntry<K, V> linkedEntry2 = this.head;
            linkedEntry.prev = linkedEntry2;
            linkedEntry.next = linkedEntry2.next;
            updateEntry(linkedEntry);
        }
    }

    private void makeTail(LinkedEntry<K, V> linkedEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, linkedEntry) == null) {
            removeEntry(linkedEntry);
            LinkedEntry<K, V> linkedEntry2 = this.head;
            linkedEntry.prev = linkedEntry2.prev;
            linkedEntry.next = linkedEntry2;
            updateEntry(linkedEntry);
        }
    }

    public static <K, V> void removeEntry(LinkedEntry<K, V> linkedEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, linkedEntry) == null) {
            LinkedEntry<K, V> linkedEntry2 = linkedEntry.prev;
            linkedEntry2.next = linkedEntry.next;
            linkedEntry.next.prev = linkedEntry2;
        }
    }

    public static <K, V> void updateEntry(LinkedEntry<K, V> linkedEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, linkedEntry) == null) {
            linkedEntry.next.prev = linkedEntry;
            linkedEntry.prev.next = linkedEntry;
        }
    }

    @Nullable
    public V get(K k2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k2)) == null) {
            LinkedEntry<K, V> linkedEntry = this.keyToEntry.get(k2);
            if (linkedEntry == null) {
                linkedEntry = new LinkedEntry<>(k2);
                this.keyToEntry.put(k2, linkedEntry);
            } else {
                k2.offer();
            }
            makeHead(linkedEntry);
            return linkedEntry.removeLast();
        }
        return (V) invokeL.objValue;
    }

    public void put(K k2, V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k2, v) == null) {
            LinkedEntry<K, V> linkedEntry = this.keyToEntry.get(k2);
            if (linkedEntry == null) {
                linkedEntry = new LinkedEntry<>(k2);
                makeTail(linkedEntry);
                this.keyToEntry.put(k2, linkedEntry);
            } else {
                k2.offer();
            }
            linkedEntry.add(v);
        }
    }

    @Nullable
    public V removeLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            for (LinkedEntry linkedEntry = this.head.prev; !linkedEntry.equals(this.head); linkedEntry = linkedEntry.prev) {
                V v = (V) linkedEntry.removeLast();
                if (v != null) {
                    return v;
                }
                removeEntry(linkedEntry);
                this.keyToEntry.remove(linkedEntry.key);
                ((Poolable) linkedEntry.key).offer();
            }
            return null;
        }
        return (V) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
            boolean z = false;
            for (LinkedEntry linkedEntry = this.head.next; !linkedEntry.equals(this.head); linkedEntry = linkedEntry.next) {
                z = true;
                sb.append(ExtendedMessageFormat.START_FE);
                sb.append(linkedEntry.key);
                sb.append(':');
                sb.append(linkedEntry.size());
                sb.append("}, ");
            }
            if (z) {
                sb.delete(sb.length() - 2, sb.length());
            }
            sb.append(" )");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
