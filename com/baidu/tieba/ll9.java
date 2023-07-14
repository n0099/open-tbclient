package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class ll9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public PbPendantRecordCacheModel b;
    public boolean c;
    public boolean d;
    public String e;
    public String f;
    public ArrayList<al9> g;
    public long h;
    public final CacheModel.c<al9> i;

    /* loaded from: classes6.dex */
    public class a implements CacheModel.c<al9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ll9 a;

        public a(ll9 ll9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ll9Var;
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void m(WriteCacheRespMsg<List<al9>> writeCacheRespMsg, WriteCacheMessage<al9> writeCacheMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, writeCacheRespMsg, writeCacheMessage) == null) {
                if (writeCacheMessage != null && writeCacheMessage.getData() != null) {
                    this.a.j(writeCacheMessage.getData().getCacheKey(), writeCacheMessage.getData().b(), ListUtils.getCount(writeCacheMessage.getData().c()));
                }
                this.a.p();
            }
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void r(ReadCacheRespMsg<List<al9>> readCacheRespMsg, ReadCacheMessage<al9> readCacheMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, readCacheRespMsg, readCacheMessage) == null) {
                this.a.c = true;
                if (readCacheRespMsg != null && readCacheRespMsg.getData() != null) {
                    this.a.g.clear();
                    this.a.g.addAll(readCacheRespMsg.getData());
                }
                if (this.a.d) {
                    this.a.d = false;
                    if (!TextUtils.isEmpty(this.a.e) && !TextUtils.isEmpty(this.a.f)) {
                        ll9 ll9Var = this.a;
                        ll9Var.n(ll9Var.e, this.a.f);
                        this.a.e = null;
                        this.a.f = null;
                    }
                }
            }
        }
    }

    public ll9(TbPageContext tbPageContext) {
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
    public void q(@NonNull String str) {
        PbPendantRecordCacheModel pbPendantRecordCacheModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, str) != null) || (pbPendantRecordCacheModel = this.b) == null) {
            return;
        }
        pbPendantRecordCacheModel.Y(new al9(str, "", new ArrayList()));
    }

    public final void j(@NonNull String str, @NonNull String str2, int i) {
        ax9 g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048576, this, str, str2, i) == null) && (g = bx9.e().g("pb_to_personalize")) != null && g.e() > 0 && bx9.e().b("pb_to_personalize") && i >= g.e()) {
            lu6.b().b(new zf9(true, wg.g(str2, 0L)));
            if (this.a != null && !TextUtils.isEmpty(str)) {
                String string = this.a.getResources().getString(R.string.push_tip_default_title);
                String string2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ff3, str);
                g.h(string);
                g.g(string2);
            }
            q(str);
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
            Iterator<al9> it = this.g.iterator();
            while (it.hasNext()) {
                al9 next = it.next();
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

    public ll9 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.b == null) {
                PbPendantRecordCacheModel pbPendantRecordCacheModel = new PbPendantRecordCacheModel(this.a);
                this.b = pbPendantRecordCacheModel;
                pbPendantRecordCacheModel.o0(this.i);
                this.h = UtilHelper.getTodayZeroTime();
                p();
            }
            return this;
        }
        return (ll9) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            TbPageContext tbPageContext = this.a;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && NotificationManagerCompat.from(this.a.getPageActivity()).areNotificationsEnabled()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p() {
        PbPendantRecordCacheModel pbPendantRecordCacheModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (pbPendantRecordCacheModel = this.b) == null) {
            return;
        }
        pbPendantRecordCacheModel.l0();
    }

    @MainThread
    public void n(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) && this.b != null && !TextUtils.isEmpty(str)) {
            if (!this.c) {
                this.d = true;
                this.e = str;
                this.f = str2;
                p();
                return;
            }
            this.b.Y(new al9(str, str2, l(str, str2)));
        }
    }
}
