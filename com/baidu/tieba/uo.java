package com.baidu.tieba;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class uo implements nja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ti a;
    public Handler b;
    public String c;
    public int d;
    public ui e;
    public Runnable f;
    public TbPageContext<?> g;

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ uo c;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    uo uoVar = this.a.c;
                    uoVar.a.onShowErr(4, uoVar.g.getString(R.string.obfuscated_res_0x7f0f1875));
                    vi.a = 1;
                }
            }
        }

        /* renamed from: com.baidu.tieba.uo$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0496b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ b b;

            public RunnableC0496b(b bVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    vi.a = 1;
                    b bVar = this.b;
                    bVar.c.a.onSendVoice(this.a, bVar.b);
                }
            }
        }

        public b(uo uoVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uoVar, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = uoVar;
            this.a = str;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String d = yb5.c(wb5.d(this.a)).d();
                if (this.c.b != null) {
                    this.c.b.removeCallbacks(this.c.f);
                    if (StringUtils.isNull(d)) {
                        this.c.b.post(new a(this));
                    } else {
                        this.c.b.post(new RunnableC0496b(this, d));
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public a(uo uoVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uoVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uo a;

        public c(uo uoVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uoVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uoVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ti tiVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (tiVar = this.a.a) != null && vi.a == 2) {
                tiVar.onStopingRecorder();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements ui {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uo a;

        public d(uo uoVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uoVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uoVar;
        }

        @Override // com.baidu.tieba.ui
        public void a(int i) {
            ti tiVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || (tiVar = this.a.a) == null) {
                return;
            }
            tiVar.onShowRecordTime(i);
        }

        @Override // com.baidu.tieba.si
        public void b(int i) {
            ti tiVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || (tiVar = this.a.a) == null) {
                return;
            }
            tiVar.onShowRecording(i);
        }

        public /* synthetic */ d(uo uoVar, a aVar) {
            this(uoVar);
        }

        @Override // com.baidu.tieba.si
        public void c(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
                vi.a = 1;
                if (this.a.c != null && str != null) {
                    uo uoVar = this.a;
                    ti tiVar = uoVar.a;
                    if (tiVar == null) {
                        return;
                    }
                    if (i <= 1000) {
                        tiVar.onShowErr(2, vi.a(R.string.obfuscated_res_0x7f0f187a));
                        FieldBuilder fieldBuilder = new FieldBuilder();
                        fieldBuilder.append("file", str);
                        fieldBuilder.append("dur", Integer.valueOf(i));
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", fieldBuilder.toString());
                        return;
                    } else if (!str.endsWith(uoVar.c)) {
                        FieldBuilder fieldBuilder2 = new FieldBuilder();
                        fieldBuilder2.append("file", str);
                        fieldBuilder2.append("dur", Integer.valueOf(i));
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", fieldBuilder2.toString());
                        return;
                    } else {
                        uo uoVar2 = this.a;
                        uoVar2.m(uoVar2.c, (int) Math.round((i * 1.0d) / 1000.0d));
                        this.a.c = null;
                        return;
                    }
                }
                FieldBuilder fieldBuilder3 = new FieldBuilder();
                fieldBuilder3.append("file", str);
                fieldBuilder3.append("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", fieldBuilder3.toString());
            }
        }

        @Override // com.baidu.tieba.ui
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                vi.a = 1;
            }
        }

        @Override // com.baidu.tieba.si
        public void error(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
                TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
                uo uoVar = this.a;
                if (uoVar.a == null) {
                    vi.a = 1;
                } else if (i == 7) {
                    if (uoVar.c == null) {
                        TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
                    } else if (this.a.a.isOnCancle()) {
                        ai.k(wb5.c(this.a.c));
                        this.a.c = null;
                        this.a.a.onStopingRecorder();
                        vi.a = 1;
                    } else {
                        uo uoVar2 = this.a;
                        uoVar2.m(uoVar2.c, this.a.d / 1000);
                        this.a.c = null;
                        if (this.a.d == ri.b) {
                            uo uoVar3 = this.a;
                            uoVar3.a.onShowErr(3, uoVar3.g.getString(R.string.obfuscated_res_0x7f0f187c));
                        } else if (this.a.d == ri.c) {
                            uo uoVar4 = this.a;
                            uoVar4.a.onShowErr(3, uoVar4.g.getString(R.string.obfuscated_res_0x7f0f187b));
                        } else {
                            uo uoVar5 = this.a;
                            uoVar5.a.onShowErr(3, uoVar5.g.getString(R.string.obfuscated_res_0x7f0f187d));
                        }
                    }
                } else {
                    vi.a = 1;
                    if (i == 8) {
                        i = 2;
                    }
                    this.a.a.onShowErr(i, str);
                    TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448319059, "Lcom/baidu/tieba/uo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448319059, "Lcom/baidu/tieba/uo;");
                return;
            }
        }
        vi.a = 1;
    }

    public static uo n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return new uo();
        }
        return (uo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nja
    public void cancelRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            qo.e();
        }
    }

    @Override // com.baidu.tieba.nja
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (vi.a == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.nja
    public void stopRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            qo.h();
            Handler handler = this.b;
            if (handler != null) {
                handler.postDelayed(this.f, 100L);
            }
        }
    }

    public uo() {
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
        this.c = null;
        this.d = ri.a;
        this.e = null;
        this.f = new c(this);
        this.b = new Handler();
    }

    @Override // com.baidu.tieba.nja
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            stopRecord();
            TbPageContext<?> tbPageContext = this.g;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
                MediaService.stopMy(this.g.getPageActivity());
            }
            Handler handler = this.b;
            if (handler != null) {
                handler.removeCallbacks(this.f);
            }
            this.g = null;
            this.a = null;
            this.b = null;
        }
    }

    @Override // com.baidu.tieba.nja
    public void a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            this.g = tbPageContext;
        }
    }

    @Override // com.baidu.tieba.nja
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            stopRecord();
            o(false);
            ti tiVar = this.a;
            if (tiVar != null) {
                tiVar.onDeletedVoice(str);
            }
            Handler handler = this.b;
            if (handler == null) {
                return;
            }
            handler.postDelayed(new a(this), 200L);
        }
    }

    @Override // com.baidu.tieba.nja
    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.d = i;
            try {
                qo.f(i);
            } catch (NoClassDefFoundError e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.nja
    public void e(ti tiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tiVar) == null) {
            this.a = tiVar;
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, Boolean.valueOf(z)));
        }
    }

    public final void m(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048583, this, str, i) == null) && str != null && i >= 1) {
            vi.a = 3;
            vu6.a(new b(this, str, i), "RecorderManager", 1);
        }
    }

    @Override // com.baidu.tieba.nja
    public boolean c(ti tiVar, int i) {
        InterceptResult invokeLI;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tiVar, i)) == null) {
            if (tiVar == null || (tbPageContext = this.g) == null || !PermissionUtil.checkWriteExternalStorage(tbPageContext.getPageActivity())) {
                return false;
            }
            this.a = tiVar;
            if (!FileHelper.checkSD()) {
                String sdErrorString = FileHelper.getSdErrorString();
                if (sdErrorString == null) {
                    sdErrorString = vi.a(R.string.voice_error_sdcard);
                }
                this.a.onShowErr(0, sdErrorString);
                return false;
            }
            o(true);
            String e = wb5.e();
            this.c = e;
            String c2 = wb5.c(e);
            if (this.e == null) {
                this.e = new d(this, null);
            }
            qo.h();
            boolean g = qo.g(c2, i, this.e);
            if (g) {
                this.a.onStartedRecorder(true, this.d);
                vi.a = 2;
            } else {
                vi.a = 1;
                qo.h();
                FieldBuilder fieldBuilder = new FieldBuilder();
                fieldBuilder.append("voiceType", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", fieldBuilder.toString());
                this.a.onStartedRecorder(false, this.d);
            }
            return g;
        }
        return invokeLI.booleanValue;
    }
}
