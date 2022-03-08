package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes7.dex */
public class SafeKeyGenerator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Pools.Pool<PoolableDigestContainer> digestPool;
    public final LruCache<Key, String> loadIdToSafeHash;

    /* loaded from: classes7.dex */
    public static final class PoolableDigestContainer implements FactoryPools.Poolable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MessageDigest messageDigest;
        public final StateVerifier stateVerifier;

        public PoolableDigestContainer(MessageDigest messageDigest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {messageDigest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.stateVerifier = StateVerifier.newInstance();
            this.messageDigest = messageDigest;
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
        @NonNull
        public StateVerifier getVerifier() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.stateVerifier : (StateVerifier) invokeV.objValue;
        }
    }

    public SafeKeyGenerator() {
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
        this.loadIdToSafeHash = new LruCache<>(1000L);
        this.digestPool = FactoryPools.threadSafe(10, new FactoryPools.Factory<PoolableDigestContainer>(this) { // from class: com.bumptech.glide.load.engine.cache.SafeKeyGenerator.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SafeKeyGenerator this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            public PoolableDigestContainer create() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    try {
                        return new PoolableDigestContainer(MessageDigest.getInstance("SHA-256"));
                    } catch (NoSuchAlgorithmException e2) {
                        throw new RuntimeException(e2);
                    }
                }
                return (PoolableDigestContainer) invokeV.objValue;
            }
        });
    }

    private String calculateHexStringDigest(Key key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, key)) == null) {
            PoolableDigestContainer poolableDigestContainer = (PoolableDigestContainer) Preconditions.checkNotNull(this.digestPool.acquire());
            try {
                key.updateDiskCacheKey(poolableDigestContainer.messageDigest);
                return Util.sha256BytesToHex(poolableDigestContainer.messageDigest.digest());
            } finally {
                this.digestPool.release(poolableDigestContainer);
            }
        }
        return (String) invokeL.objValue;
    }

    public String getSafeKey(Key key) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, key)) == null) {
            synchronized (this.loadIdToSafeHash) {
                str = this.loadIdToSafeHash.get(key);
            }
            if (str == null) {
                str = calculateHexStringDigest(key);
            }
            synchronized (this.loadIdToSafeHash) {
                this.loadIdToSafeHash.put(key, str);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
