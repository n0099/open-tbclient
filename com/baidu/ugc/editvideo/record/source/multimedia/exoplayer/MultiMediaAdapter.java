package com.baidu.ugc.editvideo.record.source.multimedia.exoplayer;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.repackage.c89;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class MultiMediaAdapter {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TAG = "com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.MultiMediaAdapter";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isLoopingPreload;
    public List<ItemInfo> mChangedList;
    public int mCurItem;
    public List<ItemInfo> mItems;

    /* renamed from: com.baidu.ugc.editvideo.record.source.multimedia.exoplayer.MultiMediaAdapter$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static final class ItemInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public MultiMediaData data;
        public int position;

        public ItemInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ ItemInfo(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1505217453, "Lcom/baidu/ugc/editvideo/record/source/multimedia/exoplayer/MultiMediaAdapter;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1505217453, "Lcom/baidu/ugc/editvideo/record/source/multimedia/exoplayer/MultiMediaAdapter;");
        }
    }

    public MultiMediaAdapter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCurItem = -1;
        this.mItems = new ArrayList();
        this.mChangedList = new ArrayList();
        this.isLoopingPreload = true;
    }

    private ItemInfo getNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            int count = getCount();
            int i = this.mCurItem + 1;
            if (this.isLoopingPreload && i == count && count > 2) {
                i = 0;
            }
            while (i < count) {
                if (isPlayerType(i)) {
                    ItemInfo infoForPosition = infoForPosition(i);
                    if (infoForPosition == null) {
                        MultiMediaData instantiatePlayer = instantiatePlayer(i);
                        if (instantiatePlayer == null) {
                            return null;
                        }
                        ItemInfo itemInfo = new ItemInfo(null);
                        itemInfo.data = instantiatePlayer;
                        itemInfo.position = i;
                        return itemInfo;
                    }
                    return infoForPosition;
                }
                i++;
            }
            return null;
        }
        return (ItemInfo) invokeV.objValue;
    }

    private ItemInfo getPrevious() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65539, this)) != null) {
            return (ItemInfo) invokeV.objValue;
        }
        int i = this.mCurItem;
        while (true) {
            i--;
            if (i < 0) {
                return null;
            }
            if (isPlayerType(i)) {
                ItemInfo infoForPosition = infoForPosition(i);
                if (infoForPosition == null) {
                    MultiMediaData instantiatePlayer = instantiatePlayer(i);
                    if (instantiatePlayer == null) {
                        return null;
                    }
                    ItemInfo itemInfo = new ItemInfo(null);
                    itemInfo.data = instantiatePlayer;
                    itemInfo.position = i;
                    return itemInfo;
                }
                return infoForPosition;
            }
        }
    }

    public synchronized void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                int b = c89.b(this.mItems);
                for (int i = 0; i < b; i++) {
                    ItemInfo itemInfo = (ItemInfo) c89.c(this.mItems, i);
                    if (itemInfo != null) {
                        destroyPlayer(itemInfo.position, itemInfo.data);
                    }
                }
                this.mItems.clear();
            }
        }
    }

    public synchronized void clearByIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            synchronized (this) {
                int b = c89.b(this.mItems);
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 < b) {
                        ItemInfo itemInfo = (ItemInfo) c89.c(this.mItems, i3);
                        if (itemInfo != null && itemInfo.position == i) {
                            destroyPlayer(itemInfo.position, itemInfo.data);
                            i2 = i3;
                            break;
                        }
                        i3++;
                    } else {
                        break;
                    }
                }
                c89.g(this.mItems, i2);
            }
        }
    }

    public abstract void destroyPlayer(int i, MultiMediaData multiMediaData);

    public abstract int getCount();

    public ItemInfo infoForPosition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            int b = c89.b(this.mItems);
            for (int i2 = 0; i2 < b; i2++) {
                ItemInfo itemInfo = (ItemInfo) c89.c(this.mItems, i2);
                if (itemInfo != null && itemInfo.position == i) {
                    return itemInfo;
                }
            }
            return null;
        }
        return (ItemInfo) invokeI.objValue;
    }

    public abstract MultiMediaData instantiatePlayer(int i);

    public abstract boolean isPlayerType(int i);

    public synchronized void positionChanged(int i) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            synchronized (this) {
                this.mChangedList.clear();
                this.mCurItem = i;
                boolean isPlayerType = isPlayerType(i);
                if (isPlayerType) {
                    ItemInfo infoForPosition = infoForPosition(this.mCurItem);
                    if (infoForPosition == null) {
                        MultiMediaData instantiatePlayer = instantiatePlayer(this.mCurItem);
                        if (instantiatePlayer != null) {
                            ItemInfo itemInfo = new ItemInfo(null);
                            itemInfo.data = instantiatePlayer;
                            itemInfo.position = this.mCurItem;
                            this.mChangedList.add(itemInfo);
                        }
                    } else {
                        this.mChangedList.add(infoForPosition);
                    }
                }
                ItemInfo previous = getPrevious();
                if (previous != null) {
                    i2 = previous.position;
                    this.mChangedList.add(previous);
                } else {
                    i2 = -1;
                }
                ItemInfo next = getNext();
                if (next != null) {
                    i3 = next.position;
                    this.mChangedList.add(next);
                } else {
                    i3 = -1;
                }
                int b = c89.b(this.mItems);
                for (int i4 = 0; i4 < b; i4++) {
                    ItemInfo itemInfo2 = (ItemInfo) c89.c(this.mItems, i4);
                    if (itemInfo2 != null && itemInfo2.position != i2 && itemInfo2.position != i3 && itemInfo2.position != this.mCurItem) {
                        destroyPlayer(itemInfo2.position, itemInfo2.data);
                    }
                }
                this.mItems.clear();
                c89.a(this.mItems, this.mChangedList);
                this.mChangedList.clear();
                if (!isPlayerType) {
                    this.mCurItem = -1;
                }
            }
        }
    }

    public synchronized void seek0AndClearOther(MultiMediaData multiMediaData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, multiMediaData, i) == null) {
            synchronized (this) {
                int b = c89.b(this.mItems);
                for (int i2 = 0; i2 < b; i2++) {
                    ItemInfo itemInfo = (ItemInfo) c89.c(this.mItems, i2);
                    if (itemInfo != null) {
                        if (multiMediaData == null || itemInfo.data == null || !TextUtils.equals(multiMediaData.uuid, itemInfo.data.uuid)) {
                            destroyPlayer(itemInfo.position, itemInfo.data);
                            c89.g(this.mItems, i2);
                        } else {
                            itemInfo.position = i;
                        }
                    }
                }
            }
        }
    }
}
