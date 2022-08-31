package com.baidu.tieba;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.List;
import tbclient.GameForumGuideTab.GameForumGuideTabResIdl;
/* loaded from: classes4.dex */
public class jl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ve<byte[]> a;
    public c b;

    /* loaded from: classes4.dex */
    public class a extends hf5<GameForumGuideTabResIdl> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ jl6 b;

        public a(jl6 jl6Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jl6Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jl6Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf5
        /* renamed from: a */
        public GameForumGuideTabResIdl doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Wire wire = new Wire(new Class[0]);
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                ve veVar = this.b.a;
                byte[] bArr = (byte[]) veVar.get(currentAccount + this.a);
                if (bArr == null || bArr.length == 0) {
                    return null;
                }
                try {
                    return (GameForumGuideTabResIdl) wire.parseFrom(bArr, GameForumGuideTabResIdl.class);
                } catch (IOException e) {
                    BdLog.e(e);
                    return null;
                }
            }
            return (GameForumGuideTabResIdl) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements oe5<GameForumGuideTabResIdl> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jl6 a;

        public b(jl6 jl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jl6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oe5
        /* renamed from: a */
        public void onReturnDataInUI(GameForumGuideTabResIdl gameForumGuideTabResIdl) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, gameForumGuideTabResIdl) == null) || gameForumGuideTabResIdl == null) {
                return;
            }
            List<pl6> a = il6.a(gameForumGuideTabResIdl.data.sub_tab_list);
            List<pn> b = il6.b(gameForumGuideTabResIdl.data.thread_list);
            boolean z = gameForumGuideTabResIdl.data.has_more.intValue() == 1;
            if (this.a.b != null) {
                this.a.b.a(a, b, z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(List<pl6> list, List<pn> list2, boolean z);
    }

    public jl6() {
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
        this.a = null;
        this.a = BdCacheService.k().a("tb.frs.game.strategy.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.a == null || str == null) {
            return;
        }
        lf5.b(new a(this, str), new b(this));
    }

    public void d(String str, byte[] bArr, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr, z) == null) || str == null || str.length() <= 0) {
            return;
        }
        if (z) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            ve<byte[]> veVar = this.a;
            veVar.e(currentAccount + str, bArr, 604800000L);
            return;
        }
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        ve<byte[]> veVar2 = this.a;
        veVar2.i(currentAccount2 + str, bArr, 604800000L);
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.b = cVar;
        }
    }
}
