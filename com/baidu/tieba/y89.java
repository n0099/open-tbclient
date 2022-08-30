package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.utils.FileUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class y89 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<AudioPlayData> a;
    public List<AudioPlayData> b;
    public g99 c;
    public int d;
    public b e;

    /* loaded from: classes6.dex */
    public class a extends va9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ AudioPlayData b;
        public final /* synthetic */ y89 c;

        public a(y89 y89Var, String str, AudioPlayData audioPlayData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y89Var, str, audioPlayData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = y89Var;
            this.a = str;
            this.b = audioPlayData;
        }

        @Override // com.baidu.tieba.va9, com.baidu.tieba.ua9
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.c.e == null) {
                return;
            }
            this.c.e.onFailed(str);
        }

        @Override // com.baidu.tieba.va9
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                AudioPlayData audioPlayData = new AudioPlayData(this.a, 0, (int) vc9.b(this.a), this.b.volume);
                if (this.c.b == null) {
                    this.c.b = new ArrayList();
                }
                this.c.b.add(audioPlayData);
                y89.c(this.c);
                this.c.f();
            }
        }

        @Override // com.baidu.tieba.va9, com.baidu.tieba.ua9
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
            }
        }

        @Override // com.baidu.tieba.va9, com.baidu.tieba.ua9
        public void onTrackEnd(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void onFailed(String str);

        void onSuccess(List<AudioPlayData> list);
    }

    public y89() {
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

    public static /* synthetic */ int c(y89 y89Var) {
        int i = y89Var.d;
        y89Var.d = i + 1;
        return i;
    }

    public final void f() {
        AudioPlayData audioPlayData;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (fc9.c(this.a, this.d) == null) {
                b bVar = this.e;
                if (bVar != null) {
                    bVar.onSuccess(this.b);
                    return;
                }
                return;
            }
            AudioPlayData audioPlayData2 = this.a.get(this.d);
            if (!FileUtils.isExists(audioPlayData2.audioPath)) {
                String str = audioPlayData2.audioPath;
                int i = audioPlayData2.start;
                audioPlayData = new AudioPlayData(str, i, audioPlayData2.end - i, audioPlayData2.volume);
                if (this.b == null) {
                    arrayList = new ArrayList();
                    this.b = arrayList;
                }
                this.b.add(audioPlayData);
                this.d++;
                f();
            } else if (audioPlayData2.mSpeed == 1.0f) {
                audioPlayData = new AudioPlayData(audioPlayData2.audioPath, audioPlayData2.start, audioPlayData2.end, audioPlayData2.volume);
                if (this.b == null) {
                    arrayList = new ArrayList();
                    this.b = arrayList;
                }
                this.b.add(audioPlayData);
                this.d++;
                f();
            } else {
                String str2 = FileUtils.removeExtention(audioPlayData2.audioPath) + "_speed.aac";
                try {
                    g99 g99Var = new g99(audioPlayData2.audioPath, str2, null);
                    this.c = g99Var;
                    g99Var.S(new a(this, str2, audioPlayData2));
                    this.c.D(null);
                    this.c.G(audioPlayData2.mSpeed);
                    this.c.B(audioPlayData2.start);
                    this.c.R(audioPlayData2.end);
                    this.c.I();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void g(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public void h(List<AudioPlayData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.a = list;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f();
        }
    }
}
