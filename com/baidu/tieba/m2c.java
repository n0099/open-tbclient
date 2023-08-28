package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.player.mediacodec.MediaSample;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class m2c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<MediaSample> a;
    public Object b;
    public int c;
    public int d;
    public AtomicBoolean e;

    public m2c() {
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
        this.a = new LinkedList<>();
        this.b = new Object();
        this.c = 0;
        this.d = 0;
        this.e = new AtomicBoolean(false);
    }

    public boolean a(MediaSample mediaSample) {
        InterceptResult invokeL;
        boolean add;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mediaSample)) == null) {
            synchronized (this.b) {
                add = this.a.add(mediaSample);
                if (add && this.c < Integer.MAX_VALUE) {
                    this.c++;
                }
            }
            if (this.c > 30) {
                int i = this.d;
                this.d = i + 1;
                if (i % 150 == 0) {
                    TLog.g(this, "DecodeOutputQueue elementCount=" + this.c + " audio = " + this.e.get());
                }
            }
            return add;
        }
        return invokeL.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        boolean isEmpty;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this.b) {
                isEmpty = this.a.isEmpty();
            }
            return isEmpty;
        }
        return invokeV.booleanValue;
    }

    public MediaSample c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.b) {
                if (this.e.get()) {
                    MediaSample poll = this.a.poll();
                    if (poll != null && this.c > 0) {
                        this.c--;
                    }
                    return poll;
                }
                int i = 0;
                MediaSample mediaSample = null;
                Iterator<MediaSample> it = this.a.iterator();
                while (it.hasNext()) {
                    int i2 = i + 1;
                    if (i >= 3) {
                        break;
                    }
                    MediaSample next = it.next();
                    if (mediaSample != null) {
                        if (mediaSample.l < next.l) {
                            break;
                        }
                        if (mediaSample.k < next.k && mediaSample.l > next.l && Math.abs(mediaSample.l - next.l) < 500) {
                        }
                        i = i2;
                    }
                    mediaSample = next;
                    i = i2;
                }
                if (mediaSample != null) {
                    this.a.remove(mediaSample);
                    if (this.c > 0) {
                        this.c--;
                    }
                }
                return mediaSample;
            }
        }
        return (MediaSample) invokeV.objValue;
    }

    public void d(MediaSample mediaSample) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, mediaSample) != null) || mediaSample == null) {
            return;
        }
        synchronized (this.b) {
            this.a.remove(mediaSample);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.e.set(z);
        }
    }
}
