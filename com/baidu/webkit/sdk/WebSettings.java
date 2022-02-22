package com.baidu.webkit.sdk;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes3.dex */
public abstract class WebSettings implements Observer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    @Deprecated
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;
    public static final String LOGTAG = "WebSettings";
    public static final int MENU_ITEM_NONE = 0;
    public static final int MENU_ITEM_PROCESS_TEXT = 4;
    public static final int MENU_ITEM_SHARE = 1;
    public static final int MENU_ITEM_WEB_SEARCH = 2;
    public static final int MIXED_CONTENT_ALWAYS_ALLOW = 0;
    public static final int MIXED_CONTENT_COMPATIBILITY_MODE = 2;
    public static final int MIXED_CONTENT_NEVER_ALLOW = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object lockObject;
    public boolean mEnableJsPrompt;
    public String mWebviewFrameName;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface CacheMode {
    }

    /* loaded from: classes3.dex */
    public static class CodeCacheSetting {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long diskCodeCacheSizeThreshold;
        public String id;
        public int maxCount;
        public ArrayList<String> pathList;
        public int sizeLimit;

        public CodeCacheSetting() {
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
            this.diskCodeCacheSizeThreshold = 31457280L;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class FlingAlgorithm {
        public static final /* synthetic */ FlingAlgorithm[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final FlingAlgorithm CUBIC;
        public static final FlingAlgorithm FAST;
        public static final FlingAlgorithm QUADRATIC;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1084642823, "Lcom/baidu/webkit/sdk/WebSettings$FlingAlgorithm;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1084642823, "Lcom/baidu/webkit/sdk/WebSettings$FlingAlgorithm;");
                    return;
                }
            }
            FAST = new FlingAlgorithm("FAST", 0);
            QUADRATIC = new FlingAlgorithm("QUADRATIC", 1);
            FlingAlgorithm flingAlgorithm = new FlingAlgorithm("CUBIC", 2);
            CUBIC = flingAlgorithm;
            $VALUES = new FlingAlgorithm[]{FAST, QUADRATIC, flingAlgorithm};
        }

        public FlingAlgorithm(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static FlingAlgorithm valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (FlingAlgorithm) Enum.valueOf(FlingAlgorithm.class, str) : (FlingAlgorithm) invokeL.objValue;
        }

        public static FlingAlgorithm[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (FlingAlgorithm[]) $VALUES.clone() : (FlingAlgorithm[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class ImgQuality {
        public static final /* synthetic */ ImgQuality[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ImgQuality HIGHT_COMPRESS;
        public static final ImgQuality LOW_COMPRESS;
        public static final ImgQuality MEDIUM_COMPRESS;
        public static final ImgQuality NO_COMPRESS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-216840866, "Lcom/baidu/webkit/sdk/WebSettings$ImgQuality;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-216840866, "Lcom/baidu/webkit/sdk/WebSettings$ImgQuality;");
                    return;
                }
            }
            NO_COMPRESS = new ImgQuality("NO_COMPRESS", 0);
            LOW_COMPRESS = new ImgQuality("LOW_COMPRESS", 1);
            MEDIUM_COMPRESS = new ImgQuality("MEDIUM_COMPRESS", 2);
            ImgQuality imgQuality = new ImgQuality("HIGHT_COMPRESS", 3);
            HIGHT_COMPRESS = imgQuality;
            $VALUES = new ImgQuality[]{NO_COMPRESS, LOW_COMPRESS, MEDIUM_COMPRESS, imgQuality};
        }

        public ImgQuality(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ImgQuality valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ImgQuality) Enum.valueOf(ImgQuality.class, str) : (ImgQuality) invokeL.objValue;
        }

        public static ImgQuality[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ImgQuality[]) $VALUES.clone() : (ImgQuality[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class LayoutAlgorithm {
        public static final /* synthetic */ LayoutAlgorithm[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        @Deprecated
        public static final LayoutAlgorithm NARROW_COLUMNS;
        public static final LayoutAlgorithm NORMAL;
        @Deprecated
        public static final LayoutAlgorithm SINGLE_COLUMN;
        public static final LayoutAlgorithm TEXT_AUTOSIZING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1892838007, "Lcom/baidu/webkit/sdk/WebSettings$LayoutAlgorithm;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1892838007, "Lcom/baidu/webkit/sdk/WebSettings$LayoutAlgorithm;");
                    return;
                }
            }
            NORMAL = new LayoutAlgorithm("NORMAL", 0);
            SINGLE_COLUMN = new LayoutAlgorithm("SINGLE_COLUMN", 1);
            NARROW_COLUMNS = new LayoutAlgorithm("NARROW_COLUMNS", 2);
            LayoutAlgorithm layoutAlgorithm = new LayoutAlgorithm("TEXT_AUTOSIZING", 3);
            TEXT_AUTOSIZING = layoutAlgorithm;
            $VALUES = new LayoutAlgorithm[]{NORMAL, SINGLE_COLUMN, NARROW_COLUMNS, layoutAlgorithm};
        }

        public LayoutAlgorithm(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static LayoutAlgorithm valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LayoutAlgorithm) Enum.valueOf(LayoutAlgorithm.class, str) : (LayoutAlgorithm) invokeL.objValue;
        }

        public static LayoutAlgorithm[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LayoutAlgorithm[]) $VALUES.clone() : (LayoutAlgorithm[]) invokeV.objValue;
        }
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface MenuItemFlags {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class PluginState {
        public static final /* synthetic */ PluginState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PluginState OFF;
        public static final PluginState ON;
        public static final PluginState ON_DEMAND;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-784464546, "Lcom/baidu/webkit/sdk/WebSettings$PluginState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-784464546, "Lcom/baidu/webkit/sdk/WebSettings$PluginState;");
                    return;
                }
            }
            ON = new PluginState("ON", 0);
            ON_DEMAND = new PluginState("ON_DEMAND", 1);
            PluginState pluginState = new PluginState("OFF", 2);
            OFF = pluginState;
            $VALUES = new PluginState[]{ON, ON_DEMAND, pluginState};
        }

        public PluginState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static PluginState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PluginState) Enum.valueOf(PluginState.class, str) : (PluginState) invokeL.objValue;
        }

        public static PluginState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PluginState[]) $VALUES.clone() : (PluginState[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class ProxyType {
        public static final /* synthetic */ ProxyType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ProxyType NO_PROXY;
        public static final ProxyType OVERSEAS_PROXY;
        public static final ProxyType SPDYANDOVERSEAS_PROXY;
        public static final ProxyType SPDY_PROXY;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1246031156, "Lcom/baidu/webkit/sdk/WebSettings$ProxyType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1246031156, "Lcom/baidu/webkit/sdk/WebSettings$ProxyType;");
                    return;
                }
            }
            NO_PROXY = new ProxyType("NO_PROXY", 0);
            SPDY_PROXY = new ProxyType("SPDY_PROXY", 1);
            OVERSEAS_PROXY = new ProxyType("OVERSEAS_PROXY", 2);
            ProxyType proxyType = new ProxyType("SPDYANDOVERSEAS_PROXY", 3);
            SPDYANDOVERSEAS_PROXY = proxyType;
            $VALUES = new ProxyType[]{NO_PROXY, SPDY_PROXY, OVERSEAS_PROXY, proxyType};
        }

        public ProxyType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ProxyType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ProxyType) Enum.valueOf(ProxyType.class, str) : (ProxyType) invokeL.objValue;
        }

        public static ProxyType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ProxyType[]) $VALUES.clone() : (ProxyType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class RemoveAdLevel {
        public static final /* synthetic */ RemoveAdLevel[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RemoveAdLevel DISABLE;
        public static final RemoveAdLevel HIGH_LEVEL;
        public static final RemoveAdLevel LOW_LEVEL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1844825569, "Lcom/baidu/webkit/sdk/WebSettings$RemoveAdLevel;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1844825569, "Lcom/baidu/webkit/sdk/WebSettings$RemoveAdLevel;");
                    return;
                }
            }
            DISABLE = new RemoveAdLevel("DISABLE", 0);
            LOW_LEVEL = new RemoveAdLevel("LOW_LEVEL", 1);
            RemoveAdLevel removeAdLevel = new RemoveAdLevel("HIGH_LEVEL", 2);
            HIGH_LEVEL = removeAdLevel;
            $VALUES = new RemoveAdLevel[]{DISABLE, LOW_LEVEL, removeAdLevel};
        }

        public RemoveAdLevel(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static RemoveAdLevel valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RemoveAdLevel) Enum.valueOf(RemoveAdLevel.class, str) : (RemoveAdLevel) invokeL.objValue;
        }

        public static RemoveAdLevel[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RemoveAdLevel[]) $VALUES.clone() : (RemoveAdLevel[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class RenderPriority {
        public static final /* synthetic */ RenderPriority[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RenderPriority HIGH;
        public static final RenderPriority LOW;
        public static final RenderPriority NORMAL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(988387328, "Lcom/baidu/webkit/sdk/WebSettings$RenderPriority;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(988387328, "Lcom/baidu/webkit/sdk/WebSettings$RenderPriority;");
                    return;
                }
            }
            NORMAL = new RenderPriority("NORMAL", 0);
            HIGH = new RenderPriority("HIGH", 1);
            RenderPriority renderPriority = new RenderPriority("LOW", 2);
            LOW = renderPriority;
            $VALUES = new RenderPriority[]{NORMAL, HIGH, renderPriority};
        }

        public RenderPriority(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static RenderPriority valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RenderPriority) Enum.valueOf(RenderPriority.class, str) : (RenderPriority) invokeL.objValue;
        }

        public static RenderPriority[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RenderPriority[]) $VALUES.clone() : (RenderPriority[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Deprecated
    /* loaded from: classes3.dex */
    public static final class TextSize {
        public static final /* synthetic */ TextSize[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TextSize LARGER;
        public static final TextSize LARGERLITTLE;
        public static final TextSize LARGERMORE;
        public static final TextSize LARGEST;
        public static final TextSize NORMAL;
        public static final TextSize SMALLER;
        public static final TextSize SMALLEST;
        public transient /* synthetic */ FieldHolder $fh;
        public int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1086961588, "Lcom/baidu/webkit/sdk/WebSettings$TextSize;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1086961588, "Lcom/baidu/webkit/sdk/WebSettings$TextSize;");
                    return;
                }
            }
            SMALLEST = new TextSize("SMALLEST", 0, 50);
            SMALLER = new TextSize("SMALLER", 1, 75);
            NORMAL = new TextSize("NORMAL", 2, 100);
            LARGERLITTLE = new TextSize("LARGERLITTLE", 3, 125);
            LARGER = new TextSize("LARGER", 4, 150);
            LARGERMORE = new TextSize("LARGERMORE", 5, 175);
            TextSize textSize = new TextSize("LARGEST", 6, 200);
            LARGEST = textSize;
            $VALUES = new TextSize[]{SMALLEST, SMALLER, NORMAL, LARGERLITTLE, LARGER, LARGERMORE, textSize};
        }

        public TextSize(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i3;
        }

        public static TextSize valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TextSize) Enum.valueOf(TextSize.class, str) : (TextSize) invokeL.objValue;
        }

        public static TextSize[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TextSize[]) $VALUES.clone() : (TextSize[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class ZoomDensity {
        public static final /* synthetic */ ZoomDensity[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ZoomDensity CLOSE;
        public static final ZoomDensity FAR;
        public static final ZoomDensity MEDIUM;
        public transient /* synthetic */ FieldHolder $fh;
        public int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-350004281, "Lcom/baidu/webkit/sdk/WebSettings$ZoomDensity;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-350004281, "Lcom/baidu/webkit/sdk/WebSettings$ZoomDensity;");
                    return;
                }
            }
            FAR = new ZoomDensity("FAR", 0, 150);
            MEDIUM = new ZoomDensity("MEDIUM", 1, 100);
            ZoomDensity zoomDensity = new ZoomDensity("CLOSE", 2, 75);
            CLOSE = zoomDensity;
            $VALUES = new ZoomDensity[]{FAR, MEDIUM, zoomDensity};
        }

        public ZoomDensity(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i3;
        }

        public static ZoomDensity valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ZoomDensity) Enum.valueOf(ZoomDensity.class, str) : (ZoomDensity) invokeL.objValue;
        }

        public static ZoomDensity[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ZoomDensity[]) $VALUES.clone() : (ZoomDensity[]) invokeV.objValue;
        }

        public final int getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
        }
    }

    public WebSettings() {
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
        this.lockObject = new Object();
        this.mEnableJsPrompt = true;
    }

    public static int backgroundNightColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public static int bigPluginTextNightColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return 16777215;
        }
        return invokeV.intValue;
    }

    public static int borderNightColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return 16777215;
        }
        return invokeV.intValue;
    }

    public static void changeInspectorStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
        }
    }

    public static int defaultLinkTextNightColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return 255;
        }
        return invokeV.intValue;
    }

    public static long generateBKDRHash(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? WebSettingsGlobalBlink.generateBKDRHash(str) : invokeL.longValue;
    }

    public static String getBrowserVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? "6.0" : (String) invokeV.objValue;
    }

    public static long getChromiumHandle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? WebSettingsGlobalBlink.getChromiumHandle() : invokeV.longValue;
    }

    public static String getCuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? WebKitFactory.getCUIDString() : (String) invokeV.objValue;
    }

    public static String getDefaultUserAgent(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) ? WebViewFactory.getProvider().getStatics().getDefaultUserAgent(context) : (String) invokeL.objValue;
    }

    public static int getInspectorKernelSupport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public static boolean getPageCacheEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? WebSettingsGlobalBlink.getPageCacheEnabled() : invokeV.booleanValue;
    }

    public static boolean getT5SDKSpdyEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void setCuid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            WebSettingsGlobalBlink.setCuid(str);
        }
    }

    public static void setFreeFlow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, null, z) == null) {
            WebSettingsGlobalBlink.setFreeFlow(z);
        }
    }

    public static void setVideoPlayerMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65552, null, i2) == null) {
            WebSettingsGlobalBlink.setVideoPlayerMode(i2);
        }
    }

    @Deprecated
    public abstract boolean enableSmoothTransition();

    public boolean enableVendorSpecifiedFont() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean getADblockEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public abstract boolean getAllowContentAccess();

    public abstract boolean getAllowFileAccess();

    public abstract boolean getAllowFileAccessFromFileURLs();

    public abstract boolean getAllowUniversalAccessFromFileURLs();

    public boolean getBackForwardAnimationEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean getBackForwardAnimationEnableInternal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract boolean getBlockNetworkImage();

    public abstract boolean getBlockNetworkLoads();

    public abstract boolean getBuiltInZoomControls();

    public abstract int getCacheMode();

    public boolean getCollectMainAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract String getCursiveFontFamily();

    public boolean getCustomFocusEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract boolean getDatabaseEnabled();

    @Deprecated
    public abstract String getDatabasePath();

    public abstract int getDefaultFixedFontSize();

    public abstract int getDefaultFontSize();

    public abstract String getDefaultTextEncodingName();

    @Deprecated
    public abstract ZoomDensity getDefaultZoom();

    public abstract int getDisabledActionModeMenuItems();

    public abstract boolean getDisplayZoomControls();

    public boolean getDitingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean getDitingForceCheck() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract boolean getDomStorageEnabled();

    public abstract boolean getEnableFileSchemaOnPrivate();

    public abstract boolean getEnableJsPrompt();

    public boolean getEnableVSyncOpt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getEyeShieldMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public abstract String getFantasyFontFamily();

    public float getFastFlingDampFactor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    public abstract String getFixedFontFamily();

    public FlingAlgorithm getFlingAlgorithm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? FlingAlgorithm.FAST : (FlingAlgorithm) invokeV.objValue;
    }

    public boolean getForcePageCanBeScaled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean getHookH5NavigationEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean getHtml5NotificationEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean getHtml5VideoEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract boolean getJavaScriptCanOpenWindowsAutomatically();

    public abstract boolean getJavaScriptEnabled();

    public boolean getKeywordExtensionEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract LayoutAlgorithm getLayoutAlgorithm();

    @Deprecated
    public abstract boolean getLightTouchEnabled();

    public abstract boolean getLoadWithOverviewMode();

    public abstract boolean getLoadsImagesAutomatically();

    public boolean getMagicFilterEnabledExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean getMagicFilterJsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean getMarkSubjectEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract boolean getMediaPlaybackRequiresUserGesture();

    public abstract int getMinimumFontSize();

    public abstract int getMinimumLogicalFontSize();

    public abstract int getMixedContentMode();

    public boolean getMultiScaleEnableTextWrap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean getNightModeEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract boolean getOffscreenPreRaster();

    public boolean getPauseAudioEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean getPlayVideoInFullScreenMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public abstract PluginState getPluginState();

    @Deprecated
    public String getPluginsPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? "" : (String) invokeV.objValue;
    }

    public boolean getPrerenderEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract String getSansSerifFontFamily();

    public abstract boolean getSaveFormData();

    @Deprecated
    public abstract boolean getSavePassword();

    public int getScrollSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public abstract String getSerifFontFamily();

    public boolean getShowUnderLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean getSkeletonViewEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract String getStandardFontFamily();

    @Deprecated
    public TextSize getTextSize() {
        InterceptResult invokeV;
        int textZoom;
        TextSize[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            synchronized (this.lockObject) {
                textZoom = getTextZoom();
            }
            TextSize textSize = null;
            int i2 = Integer.MAX_VALUE;
            for (TextSize textSize2 : TextSize.values()) {
                int abs = Math.abs(textZoom - textSize2.value);
                if (abs == 0) {
                    return textSize2;
                }
                if (abs < i2) {
                    textSize = textSize2;
                    i2 = abs;
                }
            }
            return textSize != null ? textSize : TextSize.NORMAL;
        }
        return (TextSize) invokeV.objValue;
    }

    public abstract int getTextZoom();

    public boolean getUrlSecurityCheckEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public boolean getUseDoubleTree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean getUseGLRendering() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean getUseScaleStore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public abstract boolean getUseWebViewBackgroundForOverscrollBackground();

    public abstract boolean getUseWideViewPort();

    public abstract String getUserAgentString();

    public boolean getUserSelectEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract String getWebViewFrameName();

    public abstract void initDefaultSettings(Context context, WebViewFactoryProvider webViewFactoryProvider);

    public abstract boolean isFullScreenMode();

    public boolean isLPLoadingAnimationEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract boolean isLoadingAnimationEnable();

    public void setADblockEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048660, this, z) == null) {
        }
    }

    public void setAdBlockCssEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048661, this, z) == null) {
        }
    }

    public abstract void setAllowContentAccess(boolean z);

    public abstract void setAllowFileAccess(boolean z);

    public abstract void setAllowFileAccessFromFileURLs(boolean z);

    public abstract void setAllowUniversalAccessFromFileURLs(boolean z);

    public void setAntiHackInfoEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048666, this, z) == null) {
        }
    }

    public abstract void setAppCacheEnabled(boolean z);

    @Deprecated
    public abstract void setAppCacheMaxSize(long j2);

    public abstract void setAppCachePath(String str);

    public void setBackForwardAnimationEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048670, this, z) == null) {
        }
    }

    public void setBackForwardAnimationEnableInternal(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048671, this, z) == null) {
        }
    }

    public abstract void setBlockNetworkImage(boolean z);

    public abstract void setBlockNetworkLoads(boolean z);

    public abstract void setBuiltInZoomControls(boolean z);

    public abstract void setCacheMode(int i2);

    @Deprecated
    public void setCodeCacheSetting(CodeCacheSetting codeCacheSetting) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, codeCacheSetting) == null) {
        }
    }

    public void setCollectMainAction(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048677, this, z) == null) {
        }
    }

    public abstract void setCursiveFontFamily(String str);

    public void setCustomFocusEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048679, this, z) == null) {
        }
    }

    public abstract void setDatabaseEnabled(boolean z);

    @Deprecated
    public abstract void setDatabasePath(String str);

    public abstract void setDefaultFixedFontSize(int i2);

    public abstract void setDefaultFontSize(int i2);

    public abstract void setDefaultTextEncodingName(String str);

    @Deprecated
    public abstract void setDefaultZoom(ZoomDensity zoomDensity);

    public abstract void setDisabledActionModeMenuItems(int i2);

    public abstract void setDisplayZoomControls(boolean z);

    public void setDitingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048688, this, z) == null) {
        }
    }

    public void setDitingForceCheck(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048689, this, z) == null) {
        }
    }

    public void setDomParserOptType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048690, this, i2) == null) {
        }
    }

    public abstract void setDomStorageEnabled(boolean z);

    public abstract void setEnableFileSchemaOnPrivate(boolean z);

    public abstract void setEnableJsPrompt(boolean z);

    public void setEnableLPLoadingAnimation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048694, this, z) == null) {
        }
    }

    public abstract void setEnableLoadingAnimation(boolean z);

    @Deprecated
    public abstract void setEnableSmoothTransition(boolean z);

    public void setEnableVSyncOpt(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048697, this, z) == null) {
        }
    }

    public void setEnableVendorSpecifiedFont(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048698, this, z) == null) {
        }
    }

    public void setEyeShieldMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048699, this, i2) == null) {
        }
    }

    public abstract void setFantasyFontFamily(String str);

    public void setFastFlingDampFactor(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048701, this, f2) == null) {
        }
    }

    public void setFeatureDatabasePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048702, this, str) == null) {
        }
    }

    public void setFeedNewsFirstScreenOptEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048703, this, z) == null) {
        }
    }

    public abstract void setFixedFontFamily(String str);

    public void setFlingAlgorithm(FlingAlgorithm flingAlgorithm) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, flingAlgorithm) == null) {
        }
    }

    public void setForcePageCanBeScaled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048706, this, z) == null) {
        }
    }

    public abstract void setFullScreenMode(boolean z);

    @Deprecated
    public abstract void setGeolocationDatabasePath(String str);

    public abstract void setGeolocationEnabled(boolean z);

    public void setHardwareAccelSkiaEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048710, this, z) == null) {
        }
    }

    public void setHookH5NavigationEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048711, this, z) == null) {
        }
    }

    public void setHtml5NotificationEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048712, this, z) == null) {
        }
    }

    public void setHtml5VideoEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048713, this, z) == null) {
        }
    }

    public void setImageMaxWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048714, this, i2) == null) {
        }
    }

    public void setImagesEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048715, this, z) == null) {
        }
    }

    public abstract void setJavaScriptCanOpenWindowsAutomatically(boolean z);

    public abstract void setJavaScriptEnabled(boolean z);

    public void setJsCallFullscreenEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048718, this, z) == null) {
        }
    }

    public void setKeywordExtensionEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048719, this, z) == null) {
        }
    }

    public abstract void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm);

    @Deprecated
    public abstract void setLightTouchEnabled(boolean z);

    public void setLinkPrefetchEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048722, this, z) == null) {
        }
    }

    public abstract void setLoadWithOverviewMode(boolean z);

    public abstract void setLoadsImagesAutomatically(boolean z);

    public void setMagicFilter21Enabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048725, this, z) == null) {
        }
    }

    public void setMagicFilter30Enabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048726, this, z) == null) {
        }
    }

    public void setMagicFilterEnabledExt(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048727, this, z) == null) {
        }
    }

    public void setMagicFilterInWhiteList(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048728, this, z) == null) {
        }
    }

    public void setMagicFilterJsEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048729, this, z) == null) {
        }
    }

    public void setMarkSubjectEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048730, this, z) == null) {
        }
    }

    public abstract void setMediaPlaybackRequiresUserGesture(boolean z);

    public abstract void setMinimumFontSize(int i2);

    public abstract void setMinimumLogicalFontSize(int i2);

    public abstract void setMixedContentMode(int i2);

    public void setMultiScaleEnableTextWrap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048735, this, z) == null) {
        }
    }

    public abstract void setNeedInitialFocus(boolean z);

    public void setNightModeEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048737, this, z) == null) {
        }
    }

    public abstract void setOffscreenPreRaster(boolean z);

    public void setPageCacheCapacity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048739, this, i2) == null) {
        }
    }

    public void setPageFreezeDisable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048740, this, z) == null) {
        }
    }

    public void setPauseAudioEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048741, this, z) == null) {
        }
    }

    public void setPhoenixNetAdFirstScreenOptEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048742, this, z) == null) {
        }
    }

    public void setPlayVideoInFullScreenMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048743, this, z) == null) {
        }
    }

    @Deprecated
    public abstract void setPluginState(PluginState pluginState);

    @Deprecated
    public void setPluginsPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048745, this, str) == null) {
        }
    }

    public void setPrerenderEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048746, this, z) == null) {
        }
    }

    public void setPrivateBrowsingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048747, this, z) == null) {
        }
    }

    @Deprecated
    public abstract void setRenderPriority(RenderPriority renderPriority);

    public void setSafePageEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048749, this, z) == null) {
        }
    }

    public abstract void setSansSerifFontFamily(String str);

    public abstract void setSaveFormData(boolean z);

    @Deprecated
    public abstract void setSavePassword(boolean z);

    public void setScrollSpeed(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048753, this, i2) == null) {
        }
    }

    public abstract void setSerifFontFamily(String str);

    public void setShouldDispatchBeforeunload(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048755, this, z) == null) {
        }
    }

    public void setShowUnderLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048756, this, z) == null) {
        }
    }

    public void setShrinksStandaloneImagesToFit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048757, this, z) == null) {
        }
    }

    public void setSkeletonViewEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048758, this, z) == null) {
        }
    }

    public abstract void setStandardFontFamily(String str);

    public void setStatisticsInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048760, this, str, str2) == null) {
        }
    }

    public abstract void setSupportMultipleWindows(boolean z);

    public abstract void setSupportZoom(boolean z);

    @Deprecated
    public void setTextSize(TextSize textSize) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048763, this, textSize) == null) {
            synchronized (this.lockObject) {
                setTextZoom(textSize.value);
            }
        }
    }

    public abstract void setTextZoom(int i2);

    public void setUrlSecurityCheckEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048765, this, z) == null) {
        }
    }

    @Deprecated
    public void setUseDoubleTree(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048766, this, z) == null) {
        }
    }

    public void setUseGLRendering(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048767, this, z) == null) {
        }
    }

    public void setUseScaleStore(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048768, this, z) == null) {
        }
    }

    @Deprecated
    public abstract void setUseWebViewBackgroundForOverscrollBackground(boolean z);

    public abstract void setUseWideViewPort(boolean z);

    public abstract void setUserAgentString(String str);

    public void setUserSelectEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048772, this, z) == null) {
        }
    }

    public void setUsesPageCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048773, this, z) == null) {
        }
    }

    public void setUsingAdBlockModel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048774, this, z) == null) {
        }
    }

    public abstract void setWebViewFrameName(String str);

    public void setWiseSearchFirstScreenOptType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048776, this, i2) == null) {
        }
    }

    public void setWorkersEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048777, this, z) == null) {
        }
    }

    public void setXSSAuditorEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048778, this, z) == null) {
        }
    }

    public void setZeusMutedEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048779, this, z) == null) {
        }
    }

    public void setZeusNoImageMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048780, this, z) == null) {
        }
    }

    public abstract boolean supportMultipleWindows();

    public abstract boolean supportZoom();

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048783, this, observable, obj) == null) {
        }
    }

    public boolean useCodeCacheSetting(CodeCacheSetting codeCacheSetting) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048784, this, codeCacheSetting)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean usesPageCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048785, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
