package com.baidu.tieba.view.cloudmusic;

import android.media.MediaPlayer;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.info.XDeviceInfo;
import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes4.dex */
public class MusicPlayer {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static MusicPlayer f22438c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MediaPlayer f22439a;

    /* renamed from: b  reason: collision with root package name */
    public MusicPlayerState f22440b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class MusicPlayerState {
        public static final /* synthetic */ MusicPlayerState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MusicPlayerState ERROR;
        public static final MusicPlayerState PAUSE;
        public static final MusicPlayerState PREPARED;
        public static final MusicPlayerState REPLAY;
        public static final MusicPlayerState RESUME;
        public static final MusicPlayerState WAIT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2091103441, "Lcom/baidu/tieba/view/cloudmusic/MusicPlayer$MusicPlayerState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2091103441, "Lcom/baidu/tieba/view/cloudmusic/MusicPlayer$MusicPlayerState;");
                    return;
                }
            }
            WAIT = new MusicPlayerState("WAIT", 0);
            PAUSE = new MusicPlayerState(XDeviceInfo.ABILITY_PAUSE, 1);
            PREPARED = new MusicPlayerState("PREPARED", 2);
            REPLAY = new MusicPlayerState("REPLAY", 3);
            RESUME = new MusicPlayerState("RESUME", 4);
            MusicPlayerState musicPlayerState = new MusicPlayerState("ERROR", 5);
            ERROR = musicPlayerState;
            $VALUES = new MusicPlayerState[]{WAIT, PAUSE, PREPARED, REPLAY, RESUME, musicPlayerState};
        }

        public MusicPlayerState(String str, int i2) {
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

        public static MusicPlayerState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MusicPlayerState) Enum.valueOf(MusicPlayerState.class, str) : (MusicPlayerState) invokeL.objValue;
        }

        public static MusicPlayerState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MusicPlayerState[]) $VALUES.clone() : (MusicPlayerState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f22441e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MusicPlayer f22442f;

        public a(MusicPlayer musicPlayer, CloudMusicData.MusicTagList.MusicList musicList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {musicPlayer, musicList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22442f = musicPlayer;
            this.f22441e = musicList;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                d.a.q0.z3.l.i.a.b().d(this.f22441e);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                this.f22442f.f22439a.setLooping(true);
                this.f22442f.f22439a.start();
                this.f22442f.f22440b = MusicPlayerState.PREPARED;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-157620808, "Lcom/baidu/tieba/view/cloudmusic/MusicPlayer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-157620808, "Lcom/baidu/tieba/view/cloudmusic/MusicPlayer;");
        }
    }

    public MusicPlayer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f22440b = MusicPlayerState.WAIT;
    }

    public static synchronized MusicPlayer c() {
        InterceptResult invokeV;
        MusicPlayer musicPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (MusicPlayer.class) {
                if (f22438c == null) {
                    f22438c = new MusicPlayer();
                }
                musicPlayer = f22438c;
            }
            return musicPlayer;
        }
        return (MusicPlayer) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MediaPlayer mediaPlayer = this.f22439a;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                this.f22439a.pause();
            }
            this.f22440b = MusicPlayerState.PAUSE;
        }
    }

    public void e(String str, CloudMusicData.MusicTagList.MusicList musicList, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, musicList, bVar) == null) || this.f22440b == MusicPlayerState.PAUSE) {
            return;
        }
        if (this.f22439a == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f22439a = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f22439a.reset();
            this.f22439a.setDataSource(str);
            this.f22439a.prepare();
            this.f22440b = MusicPlayerState.WAIT;
            this.f22439a.setOnPreparedListener(new a(this, musicList));
        } catch (IOException e2) {
            e2.printStackTrace();
            this.f22440b = MusicPlayerState.ERROR;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public void f() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (mediaPlayer = this.f22439a) == null) {
            return;
        }
        if (mediaPlayer.isPlaying()) {
            this.f22439a.stop();
        }
        this.f22439a.release();
        this.f22439a = null;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MediaPlayer mediaPlayer = this.f22439a;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.f22439a.seekTo(0);
            }
            this.f22440b = MusicPlayerState.RESUME;
        }
    }
}
