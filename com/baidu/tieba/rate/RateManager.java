package com.baidu.tieba.rate;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.jg;
import com.baidu.tieba.npa;
import com.baidu.tieba.um9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes7.dex */
public class RateManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_RATE_FIRST_LIKE_TIME = "key_rate_first_like_time";
    public static final String KEY_RATE_LIKE_COUNT = "key_rate_like_count";
    public static final String KEY_RATE_SAME_VERSION_IS_SCORE = "key_rate_same_version_is_score";
    public static final String KEY_RATE_VERSION = "key_rate_version";
    public static final String KEY_RATE_VERSION_TIME = "key_rate_version_time";
    public static final int RATE_LIKE_MAX_COUNT = 3;
    public static RateManager instance;
    public transient /* synthetic */ FieldHolder $fh;
    public um9 dialog;
    public int mScore;

    /* loaded from: classes7.dex */
    public class a implements npa.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ RateManager b;

        public a(RateManager rateManager, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rateManager, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rateManager;
            this.a = tbPageContext;
        }

        @Override // com.baidu.tieba.npa.g
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.b.dialog == null) {
                return;
            }
            this.b.dialog.dismiss();
            this.b.dialog = null;
            this.b.mScore = i;
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_CLICK_STAR).param("obj_type", this.b.mScore));
            this.b.showSecondDialog(this.a);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements npa.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ RateManager b;

        public b(RateManager rateManager, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rateManager, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rateManager;
            this.a = tbPageContext;
        }

        @Override // com.baidu.tieba.npa.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.dialog == null) {
                return;
            }
            this.b.dialog.dismiss();
            this.b.dialog = null;
            if (this.b.mScore == 1 || this.b.mScore == 2) {
                this.b.goToFeedBack(this.a);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_CLICK_FEEDBACK));
                return;
            }
            this.b.goToMarketPlace(this.a);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_CLICK_SCORE));
        }
    }

    /* loaded from: classes7.dex */
    public class c implements npa.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RateManager a;

        public c(RateManager rateManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rateManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rateManager;
        }

        @Override // com.baidu.tieba.npa.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.dialog == null) {
                return;
            }
            this.a.dialog.dismiss();
            this.a.dialog = null;
            if (this.a.mScore != 1 && this.a.mScore != 2) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_CLICK_CANCEL));
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_CLICK_CANCEL));
            }
        }
    }

    public RateManager() {
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
        this.mScore = 0;
    }

    public static RateManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (instance == null) {
                synchronized (RateManager.class) {
                    if (instance == null) {
                        instance = new RateManager();
                    }
                }
            }
            return instance;
        }
        return (RateManager) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToFeedBack(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65544, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink((TbPageContext<?>) tbPageContext, new String[]{TbConfig.getFeedBackUrl()}, true);
    }

    public void notifyShare(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        isShowRateDiaLog(tbPageContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToMarketPlace(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, tbPageContext) == null) {
            try {
                Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(BaseConstants.MARKET_PREFIX + TbadkCoreApplication.getInst().getPackageName()));
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                tbPageContext.getContext().startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void isShowRateDiaLog(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65546, this, tbPageContext) != null) || tbPageContext == null || TbConfig.getVersionType() == 2) {
            return;
        }
        if (Long.valueOf(new Date().getTime()).longValue() - SharedPrefHelper.getInstance().getLong(KEY_RATE_VERSION_TIME, 0L) < 86400000) {
            return;
        }
        String version = TbConfig.getVersion();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
        if (sharedPrefHelper.getBoolean(KEY_RATE_SAME_VERSION_IS_SCORE + version + currentAccount, false)) {
            return;
        }
        SharedPrefHelper sharedPrefHelper2 = SharedPrefHelper.getInstance();
        sharedPrefHelper2.putBoolean(KEY_RATE_SAME_VERSION_IS_SCORE + version + currentAccount, true);
        showFirstDialog(tbPageContext);
    }

    public void showFirstDialog(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        npa npaVar = new npa(tbPageContext.getContext());
        npaVar.x(tbPageContext.getContext().getString(R.string.is_tieba_pleased));
        npaVar.n(8);
        npaVar.r(0);
        int dimens = BdUtilHelper.getDimens(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f07041f);
        int dimens2 = BdUtilHelper.getDimens(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f07036e);
        int dimens3 = BdUtilHelper.getDimens(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0703ab);
        npaVar.w(R.dimen.obfuscated_res_0x7f0701f9);
        npaVar.v(0, dimens, 0, dimens3);
        npaVar.p(0, 0, 0, dimens2);
        npaVar.o(true);
        npaVar.u(new a(this, tbPageContext));
        um9 um9Var = new um9(tbPageContext.getContext(), npaVar.j());
        this.dialog = um9Var;
        um9Var.a(0.7f);
        jg.j(this.dialog, tbPageContext);
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_DIALOG_SHOW));
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String version = TbConfig.getVersion();
            if (!version.equals(SharedPrefHelper.getInstance().getString(KEY_RATE_VERSION, ""))) {
                SharedPrefHelper.getInstance().putString(KEY_RATE_VERSION, version);
                SharedPrefHelper.getInstance().putLong(KEY_RATE_VERSION_TIME, new Date().getTime());
            }
        }
    }

    public void notifyLike(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
        int i = sharedPrefHelper.getInt(KEY_RATE_LIKE_COUNT + currentAccount, 0) + 1;
        if (i < 3) {
            if (i == 1) {
                Long valueOf = Long.valueOf(new Date().getTime());
                SharedPrefHelper sharedPrefHelper2 = SharedPrefHelper.getInstance();
                sharedPrefHelper2.putLong(KEY_RATE_FIRST_LIKE_TIME + currentAccount, valueOf.longValue());
                SharedPrefHelper sharedPrefHelper3 = SharedPrefHelper.getInstance();
                sharedPrefHelper3.putInt(KEY_RATE_LIKE_COUNT + currentAccount, i);
                return;
            }
            SharedPrefHelper sharedPrefHelper4 = SharedPrefHelper.getInstance();
            sharedPrefHelper4.putInt(KEY_RATE_LIKE_COUNT + currentAccount, i);
            return;
        }
        SharedPrefHelper sharedPrefHelper5 = SharedPrefHelper.getInstance();
        if (Long.valueOf(new Date().getTime()).longValue() - sharedPrefHelper5.getLong(KEY_RATE_FIRST_LIKE_TIME + currentAccount, 0L) < 86400000) {
            SharedPrefHelper sharedPrefHelper6 = SharedPrefHelper.getInstance();
            sharedPrefHelper6.putInt(KEY_RATE_LIKE_COUNT + currentAccount, 0);
            isShowRateDiaLog(tbPageContext);
            return;
        }
        SharedPrefHelper sharedPrefHelper7 = SharedPrefHelper.getInstance();
        sharedPrefHelper7.putInt(KEY_RATE_LIKE_COUNT + currentAccount, 0);
    }

    public void showSecondDialog(TbPageContext tbPageContext) {
        npa.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        npa npaVar = new npa(tbPageContext.getContext());
        int i = this.mScore;
        if (i != 1 && i != 2) {
            npaVar.x(tbPageContext.getContext().getString(R.string.go_shop_give_me_comment));
            cVar = new npa.c(tbPageContext.getContext().getString(R.string.go_score), npaVar);
        } else {
            npaVar.x(tbPageContext.getContext().getString(R.string.help_my_improving_experience));
            cVar = new npa.c(tbPageContext.getContext().getString(R.string.go_feedback), npaVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        npaVar.q(this.mScore);
        npaVar.r(0);
        npaVar.n(0);
        npaVar.o(false);
        BdUtilHelper.getDimens(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0703d8);
        int dimens = BdUtilHelper.getDimens(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070207);
        BdUtilHelper.getDimens(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0703ef);
        npaVar.v(0, BdUtilHelper.getDimens(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070394), 0, 0);
        npaVar.p(0, dimens, 0, dimens);
        cVar.h(new b(this, tbPageContext));
        npaVar.t(new c(this));
        npaVar.s(arrayList);
        um9 um9Var = new um9(tbPageContext.getContext(), npaVar.j());
        this.dialog = um9Var;
        um9Var.a(0.7f);
        jg.j(this.dialog, tbPageContext);
        int i2 = this.mScore;
        if (i2 != 1 && i2 != 2) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_DIALOG_SHOW));
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_DIALOG_SHOW));
        }
    }
}
