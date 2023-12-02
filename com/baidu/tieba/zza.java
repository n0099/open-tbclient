package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class zza {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final eza b;
    public final sza c;

    public zza(MainTabActivity mainTabActivity, eza ezaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, ezaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.b = ezaVar;
        this.c = mainTabActivity.e;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            eza ezaVar = this.b;
            if (ezaVar != null && ezaVar.y() != null && this.b.y().getAnimationView() != null && this.b.y().getAnimationView().getVisibility() != 0) {
                this.b.y().setLottieView(false);
            }
            if (TbadkCoreApplication.getInst().getActivityPrizeData().isSwitchTurn()) {
                if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getInst().getActivityPrizeData().isUserSatisfy()) {
                    String h5Url = TbadkCoreApplication.getInst().getActivityPrizeData().getH5Url();
                    if (!StringUtils.isNull(h5Url)) {
                        SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                        if (sharedPrefHelper.getBoolean("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), true)) {
                            UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.a.getPageContext(), new String[]{h5Url}, true);
                            SharedPrefHelper sharedPrefHelper2 = SharedPrefHelper.getInstance();
                            sharedPrefHelper2.putBoolean("activity_prize_get_tip" + TbadkCoreApplication.getCurrentAccount(), false);
                        }
                    }
                }
                if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    String myTabText = TbadkCoreApplication.getInst().getActivityPrizeData().getMyTabText();
                    if (!StringUtils.isNull(myTabText)) {
                        eza ezaVar2 = this.b;
                        if (ezaVar2 != null) {
                            ezaVar2.Q(myTabText);
                        }
                    } else {
                        eza ezaVar3 = this.b;
                        if (ezaVar3 != null) {
                            ezaVar3.Q(null);
                        }
                    }
                } else {
                    eza ezaVar4 = this.b;
                    if (ezaVar4 != null) {
                        ezaVar4.Q(null);
                    }
                }
            } else {
                eza ezaVar5 = this.b;
                if (ezaVar5 != null) {
                    ezaVar5.Q(null);
                }
            }
            if (TbSingleton.getInstance().canShowPermDialog()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921360, this.b));
            }
            aw4.b().l("1", "");
            sza szaVar = this.c;
            if (szaVar != null && szaVar.i() != null) {
                this.c.i().a();
            }
        }
    }
}
