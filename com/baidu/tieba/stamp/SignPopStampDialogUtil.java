package com.baidu.tieba.stamp;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdDimDialog;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.data.IconPopData;
import com.baidu.tieba.lta;
import com.baidu.tieba.mta;
import com.baidu.tieba.nta;
import com.baidu.tieba.stamp.SignPopStampDialogUtil;
import com.baidu.tieba.stamp.view.NewStyleStampDialogView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class SignPopStampDialogUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId SIGN_POP_STAMP_DIALOG;
    public transient /* synthetic */ FieldHolder $fh;
    public NewStyleStampDialogView dialogView;
    public clickCallBack mClickCallBack;
    public DialogInterface.OnDismissListener onDismissListener;

    /* loaded from: classes8.dex */
    public interface clickCallBack {
        void closeBtn();

        void jumpToIconCenterBtn();

        void shareBtn();
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdDimDialog a;
        public final /* synthetic */ SignPopStampDialogUtil b;

        public a(SignPopStampDialogUtil signPopStampDialogUtil, BdDimDialog bdDimDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signPopStampDialogUtil, bdDimDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = signPopStampDialogUtil;
            this.a = bdDimDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.mClickCallBack != null) {
                    this.b.mClickCallBack.closeBtn();
                }
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdDimDialog a;
        public final /* synthetic */ lta b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ SignPopStampDialogUtil d;

        public b(SignPopStampDialogUtil signPopStampDialogUtil, BdDimDialog bdDimDialog, lta ltaVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {signPopStampDialogUtil, bdDimDialog, ltaVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = signPopStampDialogUtil;
            this.a = bdDimDialog;
            this.b = ltaVar;
            this.c = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
                nta ntaVar = new nta();
                lta ltaVar = this.b;
                if (ltaVar != null) {
                    ntaVar.g(ltaVar.a());
                    ntaVar.h(this.b.b());
                }
                new mta(this.c, ntaVar).a();
                this.d.statisticStampShareClick();
                if (this.d.mClickCallBack != null) {
                    this.d.mClickCallBack.shareBtn();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(530347592, "Lcom/baidu/tieba/stamp/SignPopStampDialogUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(530347592, "Lcom/baidu/tieba/stamp/SignPopStampDialogUtil;");
                return;
            }
        }
        SIGN_POP_STAMP_DIALOG = BdUniqueId.gen();
    }

    public SignPopStampDialogUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.dialogView = new NewStyleStampDialogView(TbadkCoreApplication.getInst().getContext());
    }

    public static void statisticStampClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STAMP_SHARE_DIALOG).param("obj_type", 2).param("obj_source", 1).param("obj_locate", 1));
        }
    }

    public static void statisticStampDialogShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STAMP_SHARE_DIALOG).param("obj_type", 1).param("obj_source", 1).param("obj_locate", 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void statisticStampShareClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK).param("obj_locate", 31));
        }
    }

    public void setClickCallBack(clickCallBack clickcallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, clickcallback) == null) {
            this.mClickCallBack = clickcallback;
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onDismissListener) == null) {
            this.onDismissListener = onDismissListener;
        }
    }

    private BdDimDialog showStampDialog(lta ltaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, ltaVar)) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            final TbPageContext tbPageContext = null;
            if (currentActivity == null) {
                return null;
            }
            if (currentActivity instanceof TbPageContextSupport) {
                tbPageContext = ((TbPageContextSupport) currentActivity).getPageContext();
            }
            NewStyleStampDialogView newStyleStampDialogView = new NewStyleStampDialogView(currentActivity);
            newStyleStampDialogView.setStampData(ltaVar);
            final BdDimDialog bdDimDialog = new BdDimDialog(currentActivity);
            bdDimDialog.setContentView(newStyleStampDialogView);
            bdDimDialog.setOnDismissListener(this.onDismissListener);
            try {
                bdDimDialog.show();
            } catch (Exception e) {
                bdDimDialog.dismiss();
                BdLog.e(e);
            }
            statisticStampDialogShow();
            newStyleStampDialogView.getImgStampDialogCancelView().setOnClickListener(new a(this, bdDimDialog));
            newStyleStampDialogView.getStampDialogLookView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.kta
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        SignPopStampDialogUtil.this.a(bdDimDialog, tbPageContext, view2);
                    }
                }
            });
            newStyleStampDialogView.getStampDialogShareView().setOnClickListener(new b(this, bdDimDialog, ltaVar, currentActivity));
            return bdDimDialog;
        }
        return (BdDimDialog) invokeL.objValue;
    }

    public /* synthetic */ void a(BdDimDialog bdDimDialog, TbPageContext tbPageContext, View view2) {
        bdDimDialog.dismiss();
        if (tbPageContext != null) {
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{"https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&user_id=" + TbadkCoreApplication.getCurrentAccount()});
            statisticStampClick();
            clickCallBack clickcallback = this.mClickCallBack;
            if (clickcallback != null) {
                clickcallback.jumpToIconCenterBtn();
            }
        }
    }

    public BdDimDialog preShowPollingStampDialog(IconPopData iconPopData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iconPopData)) == null) {
            if (iconPopData != null && iconPopData.getPic160() != null && iconPopData.getTitle() != null) {
                lta ltaVar = new lta();
                String pic160 = iconPopData.getPic160();
                ltaVar.d(iconPopData.getTitle());
                ltaVar.c(pic160);
                PollingModel.setIconPopData(iconPopData, true);
                return showStampDialog(ltaVar);
            }
            return null;
        }
        return (BdDimDialog) invokeL.objValue;
    }
}
