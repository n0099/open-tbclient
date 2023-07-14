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
/* loaded from: classes7.dex */
public class rp implements qea {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oj a;
    public Handler b;
    public String c;
    public int d;
    public pj e;
    public Runnable f;
    public TbPageContext<?> g;

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ rp c;

        /* loaded from: classes7.dex */
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
                    rp rpVar = this.a.c;
                    rpVar.a.onShowErr(4, rpVar.g.getString(R.string.obfuscated_res_0x7f0f1845));
                    qj.a = 1;
                }
            }
        }

        /* renamed from: com.baidu.tieba.rp$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0469b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ b b;

            public RunnableC0469b(b bVar, String str) {
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
                    qj.a = 1;
                    b bVar = this.b;
                    bVar.c.a.onSendVoice(this.a, bVar.b);
                }
            }
        }

        public b(rp rpVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rpVar, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rpVar;
            this.a = str;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String d = sc5.c(qc5.d(this.a)).d();
                if (this.c.b != null) {
                    this.c.b.removeCallbacks(this.c.f);
                    if (StringUtils.isNull(d)) {
                        this.c.b.post(new a(this));
                    } else {
                        this.c.b.post(new RunnableC0469b(this, d));
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public a(rp rpVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rpVar};
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

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp a;

        public c(rp rpVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rpVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rpVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            oj ojVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ojVar = this.a.a) != null && qj.a == 2) {
                ojVar.onStopingRecorder();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements pj {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp a;

        public d(rp rpVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rpVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rpVar;
        }

        @Override // com.baidu.tieba.pj
        public void a(int i) {
            oj ojVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || (ojVar = this.a.a) == null) {
                return;
            }
            ojVar.onShowRecordTime(i);
        }

        @Override // com.baidu.tieba.nj
        public void b(int i) {
            oj ojVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || (ojVar = this.a.a) == null) {
                return;
            }
            ojVar.onShowRecording(i);
        }

        public /* synthetic */ d(rp rpVar, a aVar) {
            this(rpVar);
        }

        @Override // com.baidu.tieba.nj
        public void c(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
                qj.a = 1;
                if (this.a.c != null && str != null) {
                    rp rpVar = this.a;
                    oj ojVar = rpVar.a;
                    if (ojVar == null) {
                        return;
                    }
                    if (i <= 1000) {
                        ojVar.onShowErr(2, qj.a(R.string.obfuscated_res_0x7f0f184a));
                        FieldBuilder fieldBuilder = new FieldBuilder();
                        fieldBuilder.append("file", str);
                        fieldBuilder.append("dur", Integer.valueOf(i));
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", fieldBuilder.toString());
                        return;
                    } else if (!str.endsWith(rpVar.c)) {
                        FieldBuilder fieldBuilder2 = new FieldBuilder();
                        fieldBuilder2.append("file", str);
                        fieldBuilder2.append("dur", Integer.valueOf(i));
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", fieldBuilder2.toString());
                        return;
                    } else {
                        rp rpVar2 = this.a;
                        rpVar2.m(rpVar2.c, (int) Math.round((i * 1.0d) / 1000.0d));
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

        @Override // com.baidu.tieba.pj
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                qj.a = 1;
            }
        }

        @Override // com.baidu.tieba.nj
        public void error(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
                TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
                rp rpVar = this.a;
                if (rpVar.a == null) {
                    qj.a = 1;
                } else if (i == 7) {
                    if (rpVar.c == null) {
                        TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
                    } else if (this.a.a.isOnCancle()) {
                        ti.k(qc5.c(this.a.c));
                        this.a.c = null;
                        this.a.a.onStopingRecorder();
                        qj.a = 1;
                    } else {
                        rp rpVar2 = this.a;
                        rpVar2.m(rpVar2.c, this.a.d / 1000);
                        this.a.c = null;
                        if (this.a.d == mj.b) {
                            rp rpVar3 = this.a;
                            rpVar3.a.onShowErr(3, rpVar3.g.getString(R.string.obfuscated_res_0x7f0f184c));
                        } else if (this.a.d == mj.c) {
                            rp rpVar4 = this.a;
                            rpVar4.a.onShowErr(3, rpVar4.g.getString(R.string.obfuscated_res_0x7f0f184b));
                        } else {
                            rp rpVar5 = this.a;
                            rpVar5.a.onShowErr(3, rpVar5.g.getString(R.string.obfuscated_res_0x7f0f184d));
                        }
                    }
                } else {
                    qj.a = 1;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448316207, "Lcom/baidu/tieba/rp;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448316207, "Lcom/baidu/tieba/rp;");
                return;
            }
        }
        qj.a = 1;
    }

    public static rp n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return new rp();
        }
        return (rp) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qea
    public void cancelRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            np.e();
        }
    }

    @Override // com.baidu.tieba.qea
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (qj.a == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qea
    public void stopRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            np.h();
            Handler handler = this.b;
            if (handler != null) {
                handler.postDelayed(this.f, 100L);
            }
        }
    }

    public rp() {
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
        this.d = mj.a;
        this.e = null;
        this.f = new c(this);
        this.b = new Handler();
    }

    @Override // com.baidu.tieba.qea
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

    @Override // com.baidu.tieba.qea
    public void a(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbPageContext) == null) {
            this.g = tbPageContext;
        }
    }

    @Override // com.baidu.tieba.qea
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            stopRecord();
            o(false);
            oj ojVar = this.a;
            if (ojVar != null) {
                ojVar.onDeletedVoice(str);
            }
            Handler handler = this.b;
            if (handler == null) {
                return;
            }
            handler.postDelayed(new a(this), 200L);
        }
    }

    @Override // com.baidu.tieba.qea
    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.d = i;
            try {
                np.f(i);
            } catch (NoClassDefFoundError e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.qea
    public void e(oj ojVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ojVar) == null) {
            this.a = ojVar;
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
            qj.a = 3;
            zu6.a(new b(this, str, i), "RecorderManager", 1);
        }
    }

    @Override // com.baidu.tieba.qea
    public boolean c(oj ojVar, int i) {
        InterceptResult invokeLI;
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, ojVar, i)) == null) {
            if (ojVar == null || (tbPageContext = this.g) == null || !PermissionUtil.checkWriteExternalStorage(tbPageContext.getPageActivity())) {
                return false;
            }
            this.a = ojVar;
            if (!FileHelper.checkSD()) {
                String sdErrorString = FileHelper.getSdErrorString();
                if (sdErrorString == null) {
                    sdErrorString = qj.a(R.string.voice_error_sdcard);
                }
                this.a.onShowErr(0, sdErrorString);
                return false;
            }
            o(true);
            String e = qc5.e();
            this.c = e;
            String c2 = qc5.c(e);
            if (this.e == null) {
                this.e = new d(this, null);
            }
            np.h();
            boolean g = np.g(c2, i, this.e);
            if (g) {
                this.a.onStartedRecorder(true, this.d);
                qj.a = 2;
            } else {
                qj.a = 1;
                np.h();
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
