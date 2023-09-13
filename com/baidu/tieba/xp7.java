package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.y45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, y45Var) != null) || y45Var == null) {
                return;
            }
            y45Var.dismiss();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ BlockPopInfoData b;

        public b(TbPageContext tbPageContext, BlockPopInfoData blockPopInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, blockPopInfoData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.b = blockPopInfoData;
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                UrlManager.getInstance().dealOneLink(this.a, new String[]{this.b.ahead_url});
                if (y45Var == null) {
                    return;
                }
                y45Var.dismiss();
            }
        }
    }

    public static boolean a(TbPageContext<?> tbPageContext, FrsViewData frsViewData) {
        InterceptResult invokeLL;
        String fixedText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, frsViewData)) == null) {
            if (tbPageContext != null && frsViewData != null) {
                if (!ViewHelper.checkUpIsLogin(tbPageContext.getPageActivity())) {
                    return true;
                }
                AntiData anti = frsViewData.getAnti();
                if (anti != null) {
                    if (b(tbPageContext, anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (StringHelper.getRealSize(forbid_info) > 14) {
                            forbid_info = StringHelper.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast icon = BdToast.makeText(tbPageContext.getPageActivity(), forbid_info).setIcon(BdToast.ToastIcon.FAILURE);
                        icon.setExtraTextLineSpacing(1.25f);
                        icon.show();
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(TbPageContext<?> tbPageContext, int i, BlockPopInfoData blockPopInfoData) {
        InterceptResult invokeLIL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, tbPageContext, i, blockPopInfoData)) == null) {
            if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
                return false;
            }
            if (StringUtils.isNull(blockPopInfoData.block_info)) {
                str = tbPageContext.getResources().getString(R.string.obfuscated_res_0x7f0f0807);
            } else {
                str = blockPopInfoData.block_info;
            }
            if (i != 1 && i != 2) {
                BdToast icon = BdToast.makeText(tbPageContext.getPageActivity(), str).setIcon(BdToast.ToastIcon.FAILURE);
                icon.setExtraTextLineSpacing(1.25f);
                icon.show();
                return false;
            }
            y45 y45Var = new y45(tbPageContext.getPageActivity());
            y45Var.setMessage(StringHelper.getFixedText(str, 50, true));
            if (StringUtils.isNull(blockPopInfoData.ok_info)) {
                str2 = tbPageContext.getResources().getString(R.string.group_create_private_isee);
            } else {
                str2 = blockPopInfoData.ok_info;
            }
            y45Var.setNegativeButton(StringHelper.getFixedText(str2, 4, true), new a());
            if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
                y45Var.setPositiveButton(StringHelper.getFixedText(blockPopInfoData.ahead_info, 4, true), new b(tbPageContext, blockPopInfoData));
            }
            y45Var.create(tbPageContext).show();
            return true;
        }
        return invokeLIL.booleanValue;
    }
}
