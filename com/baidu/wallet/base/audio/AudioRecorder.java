package com.baidu.wallet.base.audio;

import android.media.AudioRecord;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tun2tornadolite.booster.data.TornadoLiteRuntime;
import java.nio.ByteBuffer;
import java.util.Observable;
/* loaded from: classes13.dex */
public class AudioRecorder extends Observable implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioRecord a;

    /* renamed from: b  reason: collision with root package name */
    public State f50459b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f50460c;

    /* renamed from: com.baidu.wallet.base.audio.AudioRecorder$1  reason: invalid class name */
    /* loaded from: classes13.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes13.dex */
    public static final class State {
        public static final /* synthetic */ State[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final State DESTROY;
        public static final State INIT;
        public static final State OPEN;
        public static final State RUNNING;
        public static final State STOP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1560541961, "Lcom/baidu/wallet/base/audio/AudioRecorder$State;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1560541961, "Lcom/baidu/wallet/base/audio/AudioRecorder$State;");
                    return;
                }
            }
            INIT = new State(TornadoLiteRuntime.STATE_INIT, 0);
            OPEN = new State("OPEN", 1);
            RUNNING = new State(TornadoLiteRuntime.STATE_RUNNING, 2);
            STOP = new State("STOP", 3);
            State state = new State("DESTROY", 4);
            DESTROY = state;
            $VALUES = new State[]{INIT, OPEN, RUNNING, STOP, state};
        }

        public State(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static State valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (State) Enum.valueOf(State.class, str) : (State) invokeL.objValue;
        }

        public static State[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (State[]) $VALUES.clone() : (State[]) invokeV.objValue;
        }
    }

    /* loaded from: classes13.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final AudioRecorder a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1923396761, "Lcom/baidu/wallet/base/audio/AudioRecorder$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1923396761, "Lcom/baidu/wallet/base/audio/AudioRecorder$a;");
                    return;
                }
            }
            a = new AudioRecorder(null);
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public /* synthetic */ AudioRecorder(AnonymousClass1 anonymousClass1) {
        this();
    }

    private void a(State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, state) == null) {
            this.f50459b = state;
            setChanged();
            notifyObservers(state);
        }
    }

    public static AudioRecorder getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.a : (AudioRecorder) invokeV.objValue;
    }

    public void end() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && State.RUNNING == this.f50459b) {
            this.f50459b = State.STOP;
        }
    }

    public State getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50459b : (State) invokeV.objValue;
    }

    public synchronized boolean init(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5)) == null) {
            synchronized (this) {
                if (this.f50459b == null || State.DESTROY == this.f50459b) {
                    try {
                        AudioRecord audioRecord = new AudioRecord(1, i2, i3, i4, i5);
                        this.a = audioRecord;
                        if (1 == audioRecord.getState()) {
                            this.f50460c = new byte[i5];
                            a(State.INIT);
                            return true;
                        }
                        throw new IllegalArgumentException("guaranteed format is (8000, mono, 16bit)");
                    } catch (Exception unused) {
                        return false;
                    }
                }
                return false;
            }
        }
        return invokeIIII.booleanValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        AudioRecord audioRecord;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (audioRecord = this.a) == null) {
            return;
        }
        audioRecord.startRecording();
        a(State.OPEN);
        ByteBuffer wrap = ByteBuffer.wrap(this.f50460c);
        this.f50459b = State.RUNNING;
        while (State.RUNNING == this.f50459b) {
            wrap.clear();
            AudioRecord audioRecord2 = this.a;
            byte[] bArr = this.f50460c;
            int read = audioRecord2.read(bArr, 0, bArr.length);
            if (read <= 0) {
                break;
            }
            wrap.limit(read);
            setChanged();
            notifyObservers(wrap);
        }
        this.a.stop();
        a(State.STOP);
        this.a.release();
        this.a = null;
        a(State.DESTROY);
        deleteObservers();
        this.f50460c = null;
    }

    public AudioRecorder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f50459b = null;
    }
}
