package com.bumptech.glide.load.model.stream;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class BaseGlideUrlLoader implements ModelLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ModelLoader concreteLoader;
    public final ModelCache modelCache;

    public abstract String getUrl(Object obj, int i, int i2, Options options);

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseGlideUrlLoader(ModelLoader modelLoader) {
        this(modelLoader, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {modelLoader};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ModelLoader) objArr2[0], (ModelCache) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static List getAlternateKeys(Collection collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, collection)) == null) {
            ArrayList arrayList = new ArrayList(collection.size());
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(new GlideUrl((String) it.next()));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public BaseGlideUrlLoader(ModelLoader modelLoader, ModelCache modelCache) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {modelLoader, modelCache};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.concreteLoader = modelLoader;
        this.modelCache = modelCache;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData buildLoadData(Object obj, int i, int i2, Options options) {
        InterceptResult invokeCommon;
        GlideUrl glideUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{obj, Integer.valueOf(i), Integer.valueOf(i2), options})) == null) {
            ModelCache modelCache = this.modelCache;
            if (modelCache != null) {
                glideUrl = (GlideUrl) modelCache.get(obj, i, i2);
            } else {
                glideUrl = null;
            }
            if (glideUrl == null) {
                String url = getUrl(obj, i, i2, options);
                if (TextUtils.isEmpty(url)) {
                    return null;
                }
                GlideUrl glideUrl2 = new GlideUrl(url, getHeaders(obj, i, i2, options));
                ModelCache modelCache2 = this.modelCache;
                if (modelCache2 != null) {
                    modelCache2.put(obj, i, i2, glideUrl2);
                }
                glideUrl = glideUrl2;
            }
            List alternateUrls = getAlternateUrls(obj, i, i2, options);
            ModelLoader.LoadData buildLoadData = this.concreteLoader.buildLoadData(glideUrl, i, i2, options);
            if (buildLoadData != null && !alternateUrls.isEmpty()) {
                return new ModelLoader.LoadData(buildLoadData.sourceKey, getAlternateKeys(alternateUrls), buildLoadData.fetcher);
            }
            return buildLoadData;
        }
        return (ModelLoader.LoadData) invokeCommon.objValue;
    }

    public List getAlternateUrls(Object obj, int i, int i2, Options options) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{obj, Integer.valueOf(i), Integer.valueOf(i2), options})) == null) {
            return Collections.emptyList();
        }
        return (List) invokeCommon.objValue;
    }

    public Headers getHeaders(Object obj, int i, int i2, Options options) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{obj, Integer.valueOf(i), Integer.valueOf(i2), options})) == null) {
            return Headers.DEFAULT;
        }
        return (Headers) invokeCommon.objValue;
    }
}
