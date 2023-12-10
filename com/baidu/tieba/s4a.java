package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tieba.pb.pb.main.pendantrecord.PbPendantRecordCacheModel;
import com.baidu.tieba.push.PushGuideManager;
import com.baidu.tieba.push.PushSceneItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class s4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public PbPendantRecordCacheModel b;
    public boolean c;
    public boolean d;
    public String e;
    public String f;
    public ArrayList<n3a> g;
    public long h;
    public final CacheModel.CacheModelCallback<n3a> i;

    /* loaded from: classes8.dex */
    public class a implements CacheModel.CacheModelCallback<n3a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s4a a;

        public a(s4a s4aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s4aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s4aVar;
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.CacheModelCallback
        public void onCacheDataGet(ReadCacheRespMsg<List<n3a>> readCacheRespMsg, ReadCacheMessage<n3a> readCacheMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, readCacheRespMsg, readCacheMessage) == null) {
                this.a.c = true;
                if (readCacheRespMsg != null && readCacheRespMsg.getData() != null) {
                    this.a.g.clear();
                    this.a.g.addAll(readCacheRespMsg.getData());
                }
                if (this.a.d) {
                    this.a.d = false;
                    if (!TextUtils.isEmpty(this.a.e) && !TextUtils.isEmpty(this.a.f)) {
                        s4a s4aVar = this.a;
                        s4aVar.n(s4aVar.e, this.a.f);
                        this.a.e = null;
                        this.a.f = null;
                    }
                }
            }
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.CacheModelCallback
        public void onCacheDataWrite(WriteCacheRespMsg<List<n3a>> writeCacheRespMsg, WriteCacheMessage<n3a> writeCacheMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeCacheRespMsg, writeCacheMessage) == null) {
                if (writeCacheMessage != null && writeCacheMessage.getData() != null) {
                    this.a.j(writeCacheMessage.getData().getCacheKey(), writeCacheMessage.getData().b(), ListUtils.getCount(writeCacheMessage.getData().c()));
                }
                this.a.o();
            }
        }
    }

    public s4a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.d = false;
        this.g = new ArrayList<>();
        this.h = 0L;
        this.i = new a(this);
        this.a = tbPageContext;
    }

    public final ArrayList<String> k(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    @MainThread
    public void p(@NonNull String str) {
        PbPendantRecordCacheModel pbPendantRecordCacheModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || (pbPendantRecordCacheModel = this.b) == null) {
            return;
        }
        pbPendantRecordCacheModel.addCache(new n3a(str, "", new ArrayList()));
    }

    public final void j(@NonNull String str, @NonNull String str2, int i) {
        PushSceneItem l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048576, this, str, str2, i) == null) && (l = PushGuideManager.l("pb_to_personalize")) != null && l.getThreshold() > 0 && PushGuideManager.e("pb_to_personalize") && i >= l.getThreshold()) {
            br6.b().c(new zw9(true, JavaTypesHelper.toLong(str2, 0L)));
            if (this.a != null && !TextUtils.isEmpty(str)) {
                String string = this.a.getResources().getString(R.string.push_tip_default_title);
                String string2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1049, str);
                l.setTitle(string);
                l.setText(string2);
            }
            p(str);
        }
    }

    @NonNull
    public final ArrayList l(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (ListUtils.isEmpty(this.g)) {
                this.g = new ArrayList<>();
            }
            Iterator<n3a> it = this.g.iterator();
            while (it.hasNext()) {
                n3a next = it.next();
                if (next != null && str.equals(next.a())) {
                    ArrayList<String> c = next.c();
                    if (next.d() < this.h) {
                        c.clear();
                        c.add(str2);
                        return c;
                    } else if (c.contains(str2)) {
                        return c;
                    } else {
                        c.add(str2);
                        return c;
                    }
                }
            }
            return k(str2);
        }
        return (ArrayList) invokeLL.objValue;
    }

    public s4a m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.b == null) {
                PbPendantRecordCacheModel pbPendantRecordCacheModel = new PbPendantRecordCacheModel(this.a);
                this.b = pbPendantRecordCacheModel;
                pbPendantRecordCacheModel.setCallback(this.i);
                this.h = UtilHelper.getTodayZeroTime();
                o();
            }
            return this;
        }
        return (s4a) invokeV.objValue;
    }

    public final void o() {
        PbPendantRecordCacheModel pbPendantRecordCacheModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || (pbPendantRecordCacheModel = this.b) == null) {
            return;
        }
        pbPendantRecordCacheModel.loadCache();
    }

    @MainThread
    public void n(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) && this.b != null && !TextUtils.isEmpty(str)) {
            if (!this.c) {
                this.d = true;
                this.e = str;
                this.f = str2;
                o();
                return;
            }
            this.b.addCache(new n3a(str, str2, l(str, str2)));
        }
    }
}
