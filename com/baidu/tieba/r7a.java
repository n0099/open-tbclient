package com.baidu.tieba;

import android.app.Activity;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.BaseWriteConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.d25;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class r7a {
    public static /* synthetic */ Interceptable $ic = null;
    public static String l = "1";
    public static String m = "0";
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public String b;
    public int c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;

    /* loaded from: classes7.dex */
    public interface c {
        void onSuccess();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948075917, "Lcom/baidu/tieba/r7a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948075917, "Lcom/baidu/tieba/r7a;");
        }
    }

    /* loaded from: classes7.dex */
    public class a implements d25.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(r7a r7aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r7aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.d25.e
        public void onClick(d25 d25Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d25Var) == null) {
                d25Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IntentConfig a;

        public b(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {intentConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = intentConfig;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this.a));
            }
        }
    }

    public r7a(TbPageContext tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = "write";
        int i3 = 1;
        this.e = 1;
        this.f = 2;
        this.g = 3;
        this.h = 4;
        this.i = 8;
        this.j = 2;
        this.k = 8;
        this.a = tbPageContext;
        this.b = str;
        if (!"main_tab".equals(str)) {
            if ("frs".equals(this.b)) {
                i3 = 2;
            } else {
                i3 = 0;
            }
        }
        this.c = i3;
    }

    public static boolean o(Activity activity, IntentConfig intentConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, activity, intentConfig)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
            permissionJudgePolicy.setOnPermissionsGrantedListener(new b(intentConfig));
            return permissionJudgePolicy.startRequestPermission(activity);
        }
        return invokeLL.booleanValue;
    }

    public final void a(ForumWriteData forumWriteData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, forumWriteData, str) == null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.getPageActivity(), "", true, true);
            if (forumWriteData != null) {
                albumFloatActivityConfig.getIntent().putExtra("forum_id", forumWriteData.forumId);
                albumFloatActivityConfig.getIntent().putExtra("forum_name", forumWriteData.forumName);
                albumFloatActivityConfig.setFrsTabInfo(forumWriteData.frsTabInfo);
                albumFloatActivityConfig.setCanChangeBarName(false);
                albumFloatActivityConfig.setBarName(forumWriteData.forumName);
                albumFloatActivityConfig.setBarID(forumWriteData.forumId);
                albumFloatActivityConfig.setExtraData(forumWriteData.antiData, forumWriteData.prefixData, forumWriteData.firstDir, forumWriteData.secondDir);
            }
            albumFloatActivityConfig.getIntent().putExtra("from", this.b);
            albumFloatActivityConfig.getIntent().putExtra(BaseWriteConfig.TITLE, str);
            albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            albumFloatActivityConfig.setAlbumThread(0);
            albumFloatActivityConfig.setCanSelectVideo(true);
            albumFloatActivityConfig.setCanSelectOnlyVideo(true);
            albumFloatActivityConfig.setCanEditImage(false);
            albumFloatActivityConfig.setFromWrite(4);
            albumFloatActivityConfig.setCallFrom("2");
            albumFloatActivityConfig.setStatisticFrom(this.c);
            if (o(this.a.getPageActivity(), albumFloatActivityConfig)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    public void e(ForumWriteData forumWriteData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, forumWriteData, str) != null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.getPageActivity(), "", true, true);
        if (forumWriteData != null) {
            albumFloatActivityConfig.getIntent().putExtra("forum_id", forumWriteData.forumId);
            albumFloatActivityConfig.getIntent().putExtra("forum_name", forumWriteData.forumName);
            albumFloatActivityConfig.setFrsTabInfo(forumWriteData.frsTabInfo);
            albumFloatActivityConfig.setExtraData(forumWriteData.antiData, forumWriteData.prefixData, forumWriteData.firstDir, forumWriteData.secondDir);
        }
        albumFloatActivityConfig.getIntent().putExtra("from", this.b);
        albumFloatActivityConfig.getIntent().putExtra(BaseWriteConfig.TITLE, str);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setAlbumThread(0);
        albumFloatActivityConfig.setCanSelectVideo(false);
        albumFloatActivityConfig.setCanEditImage(false);
        albumFloatActivityConfig.setFromWrite(4);
        albumFloatActivityConfig.setCallFrom("2");
        albumFloatActivityConfig.getIntent().putExtra(WriteActivityConfig.RICH_MODE_ENABLE, !this.d);
        albumFloatActivityConfig.setStatisticFrom(this.c);
        if (o(this.a.getPageActivity(), albumFloatActivityConfig)) {
            return;
        }
        f();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    public void b(g9 g9Var, ForumWriteData forumWriteData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g9Var, forumWriteData, str) == null) {
            if (s7a.b()) {
                if (forumWriteData != null) {
                    s7a.f(g9Var, null, null, forumWriteData.forumId, forumWriteData.forumName, 4, Boolean.FALSE, "", "", "");
                } else {
                    s7a.f(g9Var, null, null, null, null, 4, Boolean.TRUE, "", "", "");
                }
                return;
            }
            a(forumWriteData, str);
        }
    }

    public void i(ForumWriteData forumWriteData, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, forumWriteData, i, str) != null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        int a2 = s7a.a();
        if (s7a.c(a2)) {
            s7a.e(this.a.getPageActivity(), a2, i);
        } else if (s7a.b()) {
            if (forumWriteData != null) {
                s7a.g(null, null, forumWriteData.forumId, forumWriteData.forumName, i, Boolean.FALSE);
            } else {
                s7a.g(null, null, null, null, i, Boolean.TRUE);
            }
        } else {
            a(forumWriteData, str);
        }
        l();
    }

    public void c(ForumWriteData forumWriteData, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, forumWriteData, cVar) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                d25 d25Var = new d25(this.a.getPageActivity());
                d25Var.setAutoNight(false);
                d25Var.setTitle(R.string.obfuscated_res_0x7f0f10df);
                d25Var.setMessage(this.a.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
                d25Var.setTitleShowCenter(true);
                d25Var.setMessageShowCenter(true);
                d25Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0af1, new a(this));
                d25Var.create(this.a).show();
                return;
            }
            n(cVar, forumWriteData);
        }
    }

    public void g(ForumWriteData forumWriteData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, forumWriteData, str) != null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.a.getPageActivity()).setType(9).setForumWriteData(forumWriteData).setFrom(this.b).setTitle(str).setCallFrom("2").setStatisticFrom(this.c).setRichModeEnable(!this.d).setRichTextMode(this.d).setFromArticle(l).send();
        h();
    }

    public void j(ForumWriteData forumWriteData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, forumWriteData, str) != null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.a.getPageActivity()).setType(9).setForumWriteData(forumWriteData).setFrom(this.b).setTitle(str).setCallFrom("2").setStatisticFrom(this.c).setFromArticle(m).send();
        k();
    }

    public final void n(c cVar, ForumWriteData forumWriteData) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, cVar, forumWriteData) == null) {
            MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
            lf.n().j(false);
            if (forumWriteData != null) {
                String str4 = forumWriteData.forumId;
                String str5 = forumWriteData.forumName;
                str3 = forumWriteData.specialForumType;
                str = str4;
                str2 = str5;
            } else {
                str = "0";
                str2 = null;
                str3 = null;
            }
            if (cVar != null) {
                cVar.onSuccess();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(this.a.getPageActivity(), str2, str, TbadkCoreApplication.getCurrentAccount(), str3)));
            d();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
            if ("main_tab".equals(this.b)) {
                statisticItem.param("obj_locate", this.k);
            } else {
                statisticItem.param("obj_locate", this.j);
            }
            statisticItem.param("obj_type", this.h);
            TiebaStatic.log(statisticItem);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
            if ("main_tab".equals(this.b)) {
                statisticItem.param("obj_locate", this.k);
            } else {
                statisticItem.param("obj_locate", this.j);
            }
            statisticItem.param("obj_type", this.g);
            TiebaStatic.log(statisticItem);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
            if ("main_tab".equals(this.b)) {
                statisticItem.param("obj_locate", this.k);
            } else {
                statisticItem.param("obj_locate", this.j);
            }
            statisticItem.param("obj_type", this.i);
            TiebaStatic.log(statisticItem);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
            if ("main_tab".equals(this.b)) {
                statisticItem.param("obj_locate", this.k);
            } else {
                statisticItem.param("obj_locate", this.j);
            }
            statisticItem.param("obj_type", this.e);
            TiebaStatic.log(statisticItem);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
            if ("main_tab".equals(this.b)) {
                statisticItem.param("obj_locate", this.k);
            } else {
                statisticItem.param("obj_locate", this.j);
            }
            statisticItem.param("obj_type", this.f);
            TiebaStatic.log(statisticItem);
        }
    }

    public void m(ForumWriteData forumWriteData) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, forumWriteData) != null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.a.getPageActivity()).setType(9).setForumWriteData(forumWriteData).setIsQuestionThread(true).setFrom(this.b).setCallFrom("2").setStatisticFrom(this.c).send();
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
        if (this.c == 1) {
            i = 8;
        } else {
            i = 2;
        }
        TiebaStatic.log(statisticItem.param("obj_locate", i).param("obj_type", 8));
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.d = z;
        }
    }
}
