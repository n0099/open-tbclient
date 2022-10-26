package com.bumptech.glide.load.engine.bitmap_recycle;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class GroupedLinkedMap {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedEntry head;
    public final Map keyToEntry;

    /* loaded from: classes7.dex */
    public class LinkedEntry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object key;
        public LinkedEntry next;
        public LinkedEntry prev;
        public List values;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public LinkedEntry() {
            this(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    this(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public Object removeLast() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int size = size();
                if (size > 0) {
                    return this.values.remove(size - 1);
                }
                return null;
            }
            return invokeV.objValue;
        }

        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                List list = this.values;
                if (list != null) {
                    return list.size();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        public LinkedEntry(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.prev = this;
            this.next = this;
            this.key = obj;
        }

        public void add(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.values == null) {
                    this.values = new ArrayList();
                }
                this.values.add(obj);
            }
        }
    }

    public GroupedLinkedMap() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.head = new LinkedEntry();
        this.keyToEntry = new HashMap();
    }

    private void makeHead(LinkedEntry linkedEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, linkedEntry) == null) {
            removeEntry(linkedEntry);
            LinkedEntry linkedEntry2 = this.head;
            linkedEntry.prev = linkedEntry2;
            linkedEntry.next = linkedEntry2.next;
            updateEntry(linkedEntry);
        }
    }

    private void makeTail(LinkedEntry linkedEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, linkedEntry) == null) {
            removeEntry(linkedEntry);
            LinkedEntry linkedEntry2 = this.head;
            linkedEntry.prev = linkedEntry2.prev;
            linkedEntry.next = linkedEntry2;
            updateEntry(linkedEntry);
        }
    }

    public static void removeEntry(LinkedEntry linkedEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, linkedEntry) == null) {
            LinkedEntry linkedEntry2 = linkedEntry.prev;
            linkedEntry2.next = linkedEntry.next;
            linkedEntry.next.prev = linkedEntry2;
        }
    }

    public static void updateEntry(LinkedEntry linkedEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, linkedEntry) == null) {
            linkedEntry.next.prev = linkedEntry;
            linkedEntry.prev.next = linkedEntry;
        }
    }

    public Object get(Poolable poolable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, poolable)) == null) {
            LinkedEntry linkedEntry = (LinkedEntry) this.keyToEntry.get(poolable);
            if (linkedEntry == null) {
                linkedEntry = new LinkedEntry(poolable);
                this.keyToEntry.put(poolable, linkedEntry);
            } else {
                poolable.offer();
            }
            makeHead(linkedEntry);
            return linkedEntry.removeLast();
        }
        return invokeL.objValue;
    }

    public void put(Poolable poolable, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, poolable, obj) == null) {
            LinkedEntry linkedEntry = (LinkedEntry) this.keyToEntry.get(poolable);
            if (linkedEntry == null) {
                linkedEntry = new LinkedEntry(poolable);
                makeTail(linkedEntry);
                this.keyToEntry.put(poolable, linkedEntry);
            } else {
                poolable.offer();
            }
            linkedEntry.add(obj);
        }
    }

    public Object removeLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            for (LinkedEntry linkedEntry = this.head.prev; !linkedEntry.equals(this.head); linkedEntry = linkedEntry.prev) {
                Object removeLast = linkedEntry.removeLast();
                if (removeLast != null) {
                    return removeLast;
                }
                removeEntry(linkedEntry);
                this.keyToEntry.remove(linkedEntry.key);
                ((Poolable) linkedEntry.key).offer();
            }
            return null;
        }
        return invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
            boolean z = false;
            for (LinkedEntry linkedEntry = this.head.next; !linkedEntry.equals(this.head); linkedEntry = linkedEntry.next) {
                z = true;
                sb.append('{');
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
