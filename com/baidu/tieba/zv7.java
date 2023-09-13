package com.baidu.tieba;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class zv7 {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-218840047, "Lcom/baidu/tieba/zv7$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-218840047, "Lcom/baidu/tieba/zv7$a;");
                    return;
                }
            }
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948373486, "Lcom/baidu/tieba/zv7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948373486, "Lcom/baidu/tieba/zv7;");
                return;
            }
        }
        a = Pattern.compile("(/p/){1}(\\d+)");
    }

    public static void a(@Nullable l25 l25Var, @Nullable BaseFragment baseFragment) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, l25Var, baseFragment) == null) && l25Var != null && baseFragment != null) {
            String d = l25Var.d();
            if (l25Var.a() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(baseFragment.getPageContext().getPageActivity(), d, false, "frs_banner")));
            } else if (l25Var.a() == 2) {
                if (d.contains("tieba.baidu.com")) {
                    Matcher matcher = a.matcher(d);
                    if (matcher.find()) {
                        try {
                            String group = matcher.group(2);
                            PbActivityConfig createNormalCfg = new PbActivityConfig(baseFragment.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                            createNormalCfg.setForumId(group);
                            createNormalCfg.setStartFrom(3);
                            baseFragment.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        } catch (Exception e) {
                            BdLog.e(e.toString());
                        }
                    }
                }
            } else if (l25Var.a() == 3) {
                UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(d);
                UtilHelper.NativePageType nativePageType = isNativeAddress.type;
                if (nativePageType != UtilHelper.NativePageType.NONE) {
                    int i = a.a[nativePageType.ordinal()];
                    if (i != 1) {
                        if (i == 2) {
                            PbActivityConfig createNormalCfg2 = new PbActivityConfig(baseFragment.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                            createNormalCfg2.setForumId(isNativeAddress.id);
                            createNormalCfg2.setStartFrom(3);
                            baseFragment.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            return;
                        }
                        return;
                    }
                    baseFragment.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(baseFragment.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                    return;
                }
                UrlManager.getInstance().dealOneLink(baseFragment.getPageContext(), new String[]{d});
                if (!StringUtils.isNull(d) && d.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(baseFragment.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", GameCenterCoreUtils.REF_TYPE_FROM_FRS);
                }
            } else if (l25Var.a() == 4) {
                baseFragment.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(baseFragment.getPageContext().getPageActivity()).createNormalCfg(d, "frs_banner")));
            }
        }
    }

    public static void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            pi7 pi7Var = new pi7();
            pi7Var.a = i;
            pi7Var.b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, pi7Var));
        }
    }

    public static void c(boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && !z) {
            pi7 pi7Var = new pi7();
            pi7Var.a = i;
            pi7Var.b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, pi7Var));
        }
    }

    public static void d(ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData, i) == null) {
            if (i == 1) {
                PraiseData praise = threadData.getPraise();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (praise == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        threadData.setPraise(praiseData);
                        return;
                    }
                    threadData.getPraise().getUser().add(0, metaData);
                    threadData.getPraise().setNum(threadData.getPraise().getNum() + 1);
                    threadData.getPraise().setIsLike(i);
                }
            } else if (threadData.getPraise() != null) {
                threadData.getPraise().setIsLike(i);
                threadData.getPraise().setNum(threadData.getPraise().getNum() - 1);
                ArrayList<MetaData> user = threadData.getPraise().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (it.hasNext()) {
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                            threadData.getPraise().getUser().remove(next);
                            return;
                        }
                    }
                }
            }
        }
    }
}
