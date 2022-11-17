package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.Scopes;
/* loaded from: classes5.dex */
public class qg5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public String d;
    public int e;
    public int f;
    public int g;
    public int h;
    public String i;

    public qg5(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cdo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 2;
        this.b = "index";
        this.c = "index";
        this.d = "2001";
        this.e = 1;
        this.f = 1;
        this.g = 1;
        this.h = 3;
        this.i = "personalize_page";
        if (cdo != null && cdo.getListView() != null) {
            String a = TbPageExtraHelper.findPageExtraByView(cdo.getListView()).a();
            this.a = c(a);
            this.b = e(a);
            this.c = d(a);
            this.d = i(a);
            this.e = a(a);
            this.f = b(a);
            this.g = f(a);
            this.h = g(a);
            this.i = h(a);
            ph5.b("currentPageKey=" + a);
            ph5.b(toString());
        }
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if ("a072".equals(str)) {
                return 10;
            }
            if (!"a006".equals(str) && !"a070".equals(str) && !"a071".equals(str)) {
                if ("a005".equals(str)) {
                    return 4;
                }
                if ("a007".equals(str)) {
                    return 12;
                }
                if ("a038".equals(str)) {
                    return 9;
                }
                if ("a066".equals(str)) {
                    return 15;
                }
                if ("a067".equals(str)) {
                    return 21;
                }
                if ("a001".equals(str) || "a002".equals(str)) {
                    return 1;
                }
                if ("a011".equals(str)) {
                    return 3;
                }
                if ("a068".equals(str)) {
                    return 22;
                }
                if (!"a008".equals(str)) {
                    return 1;
                }
                return 13;
            }
            return 2;
        }
        return invokeL.intValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if ("a072".equals(str)) {
                return 10;
            }
            if (!"a006".equals(str) && !"a070".equals(str) && !"a071".equals(str)) {
                if ("a005".equals(str)) {
                    return 7;
                }
                if ("a007".equals(str)) {
                    return 9;
                }
                if ("a038".equals(str)) {
                    return 4;
                }
                if ("a066".equals(str)) {
                    return 11;
                }
                if ("a067".equals(str)) {
                    return 18;
                }
                if (!"a001".equals(str) && !"a002".equals(str)) {
                    if (!"a010".equals(str) && !"a014".equals(str)) {
                        if ("a011".equals(str)) {
                            return 3;
                        }
                        if ("a068".equals(str)) {
                            return 19;
                        }
                        if ("a008".equals(str)) {
                            return 10;
                        }
                    } else {
                        return 5;
                    }
                }
                return 1;
            }
            return 2;
        }
        return invokeL.intValue;
    }

    public static int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (!"a006".equals(str) && !"a070".equals(str) && !"a071".equals(str) && !"a072".equals(str)) {
                if ("a005".equals(str)) {
                    return 20;
                }
                if ("a001".equals(str) || "a002".equals(str)) {
                    return 2;
                }
                if ("a038".equals(str)) {
                    return 1;
                }
                if ("a066".equals(str)) {
                    return 18;
                }
                if ("a067".equals(str)) {
                    return 19;
                }
                if ("a011".equals(str)) {
                    return 4;
                }
                if ("a068".equals(str) || "a023".equals(str) || !"a024".equals(str)) {
                    return 2;
                }
                return 17;
            }
            return 3;
        }
        return invokeL.intValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (!"a006".equals(str) && !"a070".equals(str) && !"a071".equals(str) && !"a072".equals(str)) {
                if ("a005".equals(str)) {
                    return "pb";
                }
                if ("a007".equals(str) || "a001".equals(str) || "a002".equals(str)) {
                    return "index";
                }
                if ("a038".equals(str)) {
                    return "concern_tab";
                }
                if ("a066".equals(str)) {
                    return ImageViewerConfig.FROM_GAME_VIDEO;
                }
                if ("a067".equals(str)) {
                    return "video_tab";
                }
                if ("a011".equals(str)) {
                    return Scopes.PROFILE;
                }
                if ("a068".equals(str)) {
                    return "14";
                }
                if (!"a023".equals(str)) {
                    return "index";
                }
                return "auto_midpage";
            }
            return "frs";
        }
        return (String) invokeL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!"a006".equals(str) && !"a070".equals(str) && !"a071".equals(str) && !"a072".equals(str)) {
                if ("a005".equals(str)) {
                    return "pb";
                }
                if ("a038".equals(str)) {
                    return ImageViewerConfig.FROM_CONCERN;
                }
                if ("a066".equals(str)) {
                    return ImageViewerConfig.FROM_GAME_VIDEO;
                }
                if ("a067".equals(str)) {
                    return "video_tab";
                }
                if ("a001".equals(str)) {
                    return "index";
                }
                "a002".equals(str);
                return "index";
            }
            return "frs";
        }
        return (String) invokeL.objValue;
    }

    public static int f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (!"a006".equals(str) && !"a070".equals(str) && !"a071".equals(str) && !"a072".equals(str)) {
                if ("a005".equals(str)) {
                    return 4;
                }
                if ("a001".equals(str) || "a002".equals(str)) {
                    return 1;
                }
                if ("a038".equals(str)) {
                    return 9;
                }
                if ("a066".equals(str)) {
                    return 12;
                }
                if ("a067".equals(str)) {
                    return 16;
                }
                if (!"a011".equals(str)) {
                    return 1;
                }
                return 8;
            }
            return 2;
        }
        return invokeL.intValue;
    }

    public static int g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (!"a006".equals(str) && !"a070".equals(str) && !"a071".equals(str) && !"a072".equals(str)) {
                if ("a005".equals(str)) {
                    return 2;
                }
                if ("a001".equals(str) || "a002".equals(str)) {
                    return 3;
                }
                if ("a038".equals(str)) {
                    return 4;
                }
                if ("a066".equals(str)) {
                    return 9;
                }
                if ("a067".equals(str)) {
                    return 10;
                }
                if ("a011".equals(str)) {
                    return 6;
                }
                if ("a075".equals(str)) {
                    return 12;
                }
                if (!"a076".equals(str)) {
                    return 3;
                }
                return 13;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (!"a006".equals(str) && !"a070".equals(str) && !"a071".equals(str) && !"a072".equals(str)) {
                if (!"a001".equals(str) && !"a002".equals(str)) {
                    if ("a011".equals(str)) {
                        return "person_page";
                    }
                    if ("a038".equals(str)) {
                        return "concern_page";
                    }
                    return null;
                }
                return "personalize_page";
            }
            return "frs_page";
        }
        return (String) invokeL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (!"a006".equals(str) && !"a070".equals(str) && !"a071".equals(str) && !"a072".equals(str)) {
                if ("a005".equals(str)) {
                    return "2002";
                }
                if ("a023".equals(str)) {
                    return "2005";
                }
                if ("a001".equals(str)) {
                    return "2001";
                }
                "a002".equals(str);
                return "2001";
            }
            return "2003";
        }
        return (String) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "AdapterSourceItem:【pbPageFromType=" + this.a + ",imageViewerFromType=" + this.b + ",videoLocationType=" + this.c + ",videoStageType=" + this.d + ",agreeLocate=" + this.e + ",disagreeLocate=" + this.f + ",pageFrom=" + this.g + ",shareReportFrom=" + this.h + ",stType=" + this.i + "】";
        }
        return (String) invokeV.objValue;
    }
}
