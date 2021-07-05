package com.bumptech.glide.load.model.stream;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class BaseGlideUrlLoader<Model> implements ModelLoader<Model, InputStream> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ModelLoader<GlideUrl, InputStream> concreteLoader;
    @Nullable
    public final ModelCache<Model, GlideUrl> modelCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this(modelLoader, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {modelLoader};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ModelLoader) objArr2[0], (ModelCache) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static List<Key> getAlternateKeys(Collection<String> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, collection)) == null) {
            ArrayList arrayList = new ArrayList(collection.size());
            for (String str : collection) {
                arrayList.add(new GlideUrl(str));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    @Nullable
    public ModelLoader.LoadData<InputStream> buildLoadData(@NonNull Model model, int i2, int i3, @NonNull Options options) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{model, Integer.valueOf(i2), Integer.valueOf(i3), options})) == null) {
            ModelCache<Model, GlideUrl> modelCache = this.modelCache;
            GlideUrl glideUrl = modelCache != null ? modelCache.get(model, i2, i3) : null;
            if (glideUrl == null) {
                String url = getUrl(model, i2, i3, options);
                if (TextUtils.isEmpty(url)) {
                    return null;
                }
                GlideUrl glideUrl2 = new GlideUrl(url, getHeaders(model, i2, i3, options));
                ModelCache<Model, GlideUrl> modelCache2 = this.modelCache;
                if (modelCache2 != null) {
                    modelCache2.put(model, i2, i3, glideUrl2);
                }
                glideUrl = glideUrl2;
            }
            List<String> alternateUrls = getAlternateUrls(model, i2, i3, options);
            ModelLoader.LoadData<InputStream> buildLoadData = this.concreteLoader.buildLoadData(glideUrl, i2, i3, options);
            return (buildLoadData == null || alternateUrls.isEmpty()) ? buildLoadData : new ModelLoader.LoadData<>(buildLoadData.sourceKey, getAlternateKeys(alternateUrls), buildLoadData.fetcher);
        }
        return (ModelLoader.LoadData) invokeCommon.objValue;
    }

    public List<String> getAlternateUrls(Model model, int i2, int i3, Options options) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{model, Integer.valueOf(i2), Integer.valueOf(i3), options})) == null) ? Collections.emptyList() : (List) invokeCommon.objValue;
    }

    @Nullable
    public Headers getHeaders(Model model, int i2, int i3, Options options) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{model, Integer.valueOf(i2), Integer.valueOf(i3), options})) == null) ? Headers.DEFAULT : (Headers) invokeCommon.objValue;
    }

    public abstract String getUrl(Model model, int i2, int i3, Options options);

    public BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader, @Nullable ModelCache<Model, GlideUrl> modelCache) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {modelLoader, modelCache};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.concreteLoader = modelLoader;
        this.modelCache = modelCache;
    }
}
