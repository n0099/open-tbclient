package com.baidu.tieba.view.cloudmusic;

import android.media.MediaPlayer;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.bx;
import com.baidu.tieba.uab;
import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes8.dex */
public class MusicPlayer {
    public static /* synthetic */ Interceptable $ic;
    public static MusicPlayer c;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaPlayer a;
    public MusicPlayerState b;

    /* loaded from: classes8.dex */
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
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
            PAUSE = new MusicPlayerState("PAUSE", 1);
            PREPARED = new MusicPlayerState("PREPARED", 2);
            REPLAY = new MusicPlayerState("REPLAY", 3);
            RESUME = new MusicPlayerState("RESUME", 4);
            MusicPlayerState musicPlayerState = new MusicPlayerState(bx.l, 5);
            ERROR = musicPlayerState;
            $VALUES = new MusicPlayerState[]{WAIT, PAUSE, PREPARED, REPLAY, RESUME, musicPlayerState};
        }

        public MusicPlayerState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (MusicPlayerState) Enum.valueOf(MusicPlayerState.class, str);
            }
            return (MusicPlayerState) invokeL.objValue;
        }

        public static MusicPlayerState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (MusicPlayerState[]) $VALUES.clone();
            }
            return (MusicPlayerState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList a;
        public final /* synthetic */ MusicPlayer b;

        public a(MusicPlayer musicPlayer, CloudMusicData.MusicTagList.MusicList musicList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {musicPlayer, musicList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = musicPlayer;
            this.a = musicList;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                uab.b().d(this.a);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921307));
                this.b.a.setLooping(true);
                this.b.a.start();
                this.b.b = MusicPlayerState.PREPARED;
            }
        }
    }

    public MusicPlayer() {
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
        this.b = MusicPlayerState.WAIT;
    }

    public static synchronized MusicPlayer c() {
        InterceptResult invokeV;
        MusicPlayer musicPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (MusicPlayer.class) {
                if (c == null) {
                    c = new MusicPlayer();
                }
                musicPlayer = c;
            }
            return musicPlayer;
        }
        return (MusicPlayer) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                this.a.pause();
            }
            this.b = MusicPlayerState.PAUSE;
        }
    }

    public void f() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (mediaPlayer = this.a) != null) {
            if (mediaPlayer.isPlaying()) {
                this.a.stop();
            }
            this.a.release();
            this.a = null;
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.a.seekTo(0);
            }
            this.b = MusicPlayerState.RESUME;
        }
    }

    public void e(String str, CloudMusicData.MusicTagList.MusicList musicList, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, musicList, bVar) != null) || this.b == MusicPlayerState.PAUSE) {
            return;
        }
        if (this.a == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.a = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.a.reset();
            this.a.setDataSource(str);
            this.a.prepare();
            this.b = MusicPlayerState.WAIT;
            this.a.setOnPreparedListener(new a(this, musicList));
        } catch (IOException e) {
            e.printStackTrace();
            this.b = MusicPlayerState.ERROR;
            if (bVar != null) {
                bVar.a();
            }
        }
    }
}
