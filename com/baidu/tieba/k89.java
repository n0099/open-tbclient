package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k89 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public boolean b;
    public q35 c;

    public k89(TbPageContext tbPageContext) {
        Uri uri;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.a = tbPageContext;
        if (tbPageContext.getPageActivity() != null && this.a.getPageActivity().getIntent() != null && (uri = (Uri) this.a.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            String queryParameter = uri.getQueryParameter("tid");
            q35 q35Var = new q35();
            this.c = q35Var;
            q35Var.a = uri.getQueryParameter("tid");
            this.c.b = uri.getQueryParameter(TiebaStatic.Params.EQID);
            if (!TextUtils.isEmpty(queryParameter) && g9.f().g() <= 3) {
                this.b = true;
            }
        }
    }

    public void a(PbModel pbModel) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, pbModel) == null) && this.b && this.c != null && pbModel != null && pbModel.y1() != null && pbModel.y1().k() != null) {
            ForumData k = pbModel.y1().k();
            this.c.c = k.getFirst_class();
            this.c.d = k.getSecond_class();
            TbSingleton.getInstance().setPbToHomeUpdateData(this.c);
            if (g9.f().h("MainTabActivity")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            } else {
                TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
            }
        }
    }
}
