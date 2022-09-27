package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
import com.baidu.tieba.view.cloudmusic.model.CloudMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class wz8 implements xz8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CloudMusicModel a;
    public final yz8 b;

    /* loaded from: classes6.dex */
    public class a implements e09<CloudMusicData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wz8 a;

        public a(wz8 wz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wz8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.e09
        /* renamed from: b */
        public void a(CloudMusicData cloudMusicData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cloudMusicData) == null) {
                this.a.b.l0(false);
                if (cloudMusicData != null) {
                    this.a.b.l(false);
                    if (cloudMusicData.tag_list.isEmpty()) {
                        this.a.b.l(true);
                        return;
                    } else {
                        this.a.b.B(cloudMusicData);
                        return;
                    }
                }
                this.a.b.l(true);
            }
        }
    }

    public wz8(CloudMusicModel cloudMusicModel, yz8 yz8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cloudMusicModel, yz8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cloudMusicModel;
        this.b = yz8Var;
        yz8Var.A0(this);
    }

    @Override // com.baidu.tieba.xz8
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.xz8
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.l0(true);
            this.a.A(new a(this));
        }
    }
}
