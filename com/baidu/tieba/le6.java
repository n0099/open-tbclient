package com.baidu.tieba;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.gift.AlaDynamicGift;
import com.baidu.ala.gift.AlaDynamicGiftAndNativeData;
import com.baidu.ala.gift.AlaDynamicGiftConfigInfo;
import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.ala.gift.IFrameCallback;
import com.baidu.ala.gift.IImageFramePlayerViewController;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEffectPreviewView;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class le6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public RelativeLayout b;
    public IImageFramePlayerViewController c;
    public AlaEffectPreviewView d;
    public AlaEnterEffectData e;
    public int f;
    public IFrameCallback g;
    public c h;

    /* loaded from: classes7.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes7.dex */
    public class a implements IFrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ le6 a;

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameUpdate(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            }
        }

        public a(le6 le6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {le6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = le6Var;
        }

        @Override // com.baidu.ala.gift.IFrameCallback
        public void onFrameEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                le6.b(this.a);
                if (this.a.f <= 0 && this.a.e != null) {
                    le6 le6Var = this.a;
                    le6Var.g(le6Var.e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ le6 a;

        public b(le6 le6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {le6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = le6Var;
        }

        @Override // com.baidu.tieba.le6.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                le6.b(this.a);
                if (this.a.e != null) {
                    if (this.a.e.type == 1 && this.a.f <= 0) {
                        le6 le6Var = this.a;
                        le6Var.g(le6Var.e);
                    } else if (this.a.e.type == 0) {
                        le6 le6Var2 = this.a;
                        le6Var2.g(le6Var2.e);
                    }
                }
            }
        }
    }

    public le6(Context context, RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = 2;
        this.g = new a(this);
        this.h = new b(this);
        this.a = context;
        this.b = relativeLayout;
    }

    public static /* synthetic */ int b(le6 le6Var) {
        int i = le6Var.f;
        le6Var.f = i - 1;
        return i;
    }

    public void g(AlaEnterEffectData alaEnterEffectData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, alaEnterEffectData) != null) || alaEnterEffectData == null) {
            return;
        }
        this.e = alaEnterEffectData;
        int i = alaEnterEffectData.type;
        if (i == 1) {
            this.f = 2;
            e(alaEnterEffectData);
            f(alaEnterEffectData);
        } else if (i == 0) {
            f(alaEnterEffectData);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            IImageFramePlayerViewController iImageFramePlayerViewController = this.c;
            if (iImageFramePlayerViewController != null) {
                iImageFramePlayerViewController.onDestroy();
            }
            AlaEffectPreviewView alaEffectPreviewView = this.d;
            if (alaEffectPreviewView != null) {
                alaEffectPreviewView.f();
            }
        }
    }

    public final void e(AlaEnterEffectData alaEnterEffectData) {
        AlaDynamicGiftConfigInfo alaDynamicGiftConfigInfo;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, alaEnterEffectData) == null) {
            if (this.c == null && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER, IImageFramePlayerViewController.class, this.a)) != null && runTask.getData() != null) {
                IImageFramePlayerViewController iImageFramePlayerViewController = (IImageFramePlayerViewController) runTask.getData();
                this.c = iImageFramePlayerViewController;
                iImageFramePlayerViewController.setFrameCallback(this.g);
            }
            IImageFramePlayerViewController iImageFramePlayerViewController2 = this.c;
            if (iImageFramePlayerViewController2 != null) {
                if (iImageFramePlayerViewController2.getAnimView().getParent() == null) {
                    this.b.addView(this.c.getAnimView(), new RelativeLayout.LayoutParams(-1, BdUtilHelper.getEquipmentHeight(this.a)));
                }
                AlaDynamicGiftAndNativeData alaDynamicGiftAndNativeData = new AlaDynamicGiftAndNativeData();
                AlaDynamicGift alaDynamicGift = alaEnterEffectData.gift;
                alaDynamicGiftAndNativeData.mAlaDynamicGift = alaDynamicGift;
                if (alaDynamicGift != null && (alaDynamicGiftConfigInfo = alaDynamicGift.configInfo) != null) {
                    alaDynamicGiftConfigInfo.isBottomMargin = 1;
                    alaDynamicGiftConfigInfo.oppositeY = 0.6499999761581421d;
                }
                alaDynamicGiftAndNativeData.upZipDirPath = AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName;
                this.c.setData(alaDynamicGiftAndNativeData);
                this.c.startAnim();
            }
        }
    }

    public final void f(AlaEnterEffectData alaEnterEffectData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, alaEnterEffectData) == null) {
            if (this.d == null) {
                AlaEffectPreviewView alaEffectPreviewView = new AlaEffectPreviewView(this.a);
                this.d = alaEffectPreviewView;
                alaEffectPreviewView.setAnimCompleteCallback(this.h);
            }
            if (this.d.getParent() == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(2, R.id.obfuscated_res_0x7f0909e7);
                layoutParams.bottomMargin = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703f0);
                this.b.addView(this.d, layoutParams);
            }
            this.d.setData(alaEnterEffectData);
            this.d.g();
        }
    }
}
