package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tieba.jm9;
import com.baidu.tieba.kl9;
import com.baidu.tieba.om9;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes5.dex */
public class pm9 implements om9.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaPlayer a;
    public int b;
    public String c;
    public String d;
    public boolean e;
    public Context f;
    public boolean g;
    public oc8 h;

    @Override // com.baidu.tieba.om9.b
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    public void t(SelectMusicModel selectMusicModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, selectMusicModel) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements kl9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jm9.a a;
        public final /* synthetic */ MusicData b;
        public final /* synthetic */ pm9 c;

        public a(pm9 pm9Var, jm9.a aVar, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pm9Var, aVar, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pm9Var;
            this.a = aVar;
            this.b = musicData;
        }

        @Override // com.baidu.tieba.kl9.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || this.a.d != this.c.b) {
                return;
            }
            this.c.g = false;
            this.a.b.setVisibility(4);
            this.a.a.setDrawBorder(true);
            this.a.a.invalidate();
            hi.Q(TbadkCoreApplication.getInst(), str);
            if (this.c.h != null) {
                this.c.h.b(3, str);
            }
        }

        @Override // com.baidu.tieba.kl9.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.d == this.c.b) {
                this.c.g = false;
                this.a.a.setDrawBorder(true);
                this.a.a.invalidate();
                this.a.b.setVisibility(4);
            }
        }

        @Override // com.baidu.tieba.kl9.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && this.a.d == this.c.b) {
                this.c.g = false;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.c.p(str, this.b);
                this.a.b.setVisibility(4);
                this.a.a.setDrawBorder(true);
                this.a.a.invalidate();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements kl9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MusicData a;
        public final /* synthetic */ pm9 b;

        @Override // com.baidu.tieba.kl9.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(pm9 pm9Var, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pm9Var, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pm9Var;
            this.a = musicData;
        }

        @Override // com.baidu.tieba.kl9.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                hi.Q(TbadkCoreApplication.getInst(), str);
                if (this.b.h != null) {
                    this.b.h.b(3, str);
                }
            }
        }

        @Override // com.baidu.tieba.kl9.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.b.p(str, this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pm9 a;

        public c(pm9 pm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pm9Var;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.a.a.setLooping(true);
                this.a.a.start();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pm9 a;

        public d(pm9 pm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pm9Var;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i, i2)) == null) {
                if (this.a.h != null) {
                    oc8 oc8Var = this.a.h;
                    oc8Var.b(4, "what-->" + i + "  extra-->" + i2);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    public pm9(Activity activity) {
        sc8 sc8Var;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, sc8.class);
        if (runTask != null) {
            sc8Var = (sc8) runTask.getData();
        } else {
            sc8Var = null;
        }
        if (sc8Var != null) {
            this.h = sc8Var.get();
        }
        this.f = activity;
    }

    public void g(EditVideoActivityConfig editVideoActivityConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editVideoActivityConfig) == null) && !TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(this.c)) {
            editVideoActivityConfig.addMusicInfo(this.d, this.c, this.b);
        }
    }

    public void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.e = false;
            this.d = str;
            this.c = str2;
            p(str, null);
        }
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.e = true;
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                this.a.pause();
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e = false;
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.a.seekTo(0);
            }
        }
    }

    public void o() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (mediaPlayer = this.a) != null && mediaPlayer.isPlaying()) {
            this.a.pause();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.a.stop();
                }
                this.a.release();
                this.a = null;
            }
            this.d = null;
            this.c = null;
        }
    }

    public void k(MusicData musicData, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048581, this, musicData, obj) != null) || musicData == null) {
            return;
        }
        int i = musicData.editMusicType;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.f, 25032)));
                    return;
                }
                return;
            }
            r();
            return;
        }
        q(obj, musicData);
    }

    public final void s(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, musicData) == null) {
            this.d = null;
            r();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                kl9.g().d();
            }
            q(null, musicData);
        }
    }

    public void n(int i) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (mediaPlayer = this.a) != null && mediaPlayer.getDuration() > 0) {
            if (i < 0) {
                i = 0;
            }
            if (i > this.a.getDuration()) {
                i %= this.a.getDuration();
            }
            this.a.seekTo(i);
            this.a.start();
        }
    }

    public final void p(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048586, this, str, musicData) != null) || this.e) {
            return;
        }
        if (this.a == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.a = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.d = str;
            this.a.reset();
            this.a.setDataSource(str);
            this.a.prepare();
            this.a.setOnPreparedListener(new c(this));
            this.a.setOnErrorListener(new d(this));
        } catch (Exception e) {
            e.printStackTrace();
            s(str, musicData);
        }
    }

    public final void q(Object obj, MusicData musicData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, obj, musicData) == null) && musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                this.a.stop();
            }
            this.g = false;
            this.c = musicData.id;
            String f = kl9.g().f(musicData.resource);
            if (obj != null && (obj instanceof jm9.a)) {
                this.b = ((jm9.a) obj).d;
            }
            if (TextUtils.isEmpty(f)) {
                if (obj instanceof jm9.a) {
                    jm9.a aVar = (jm9.a) obj;
                    aVar.b.setVisibility(0);
                    aVar.a.setDrawBorder(false);
                    aVar.a.invalidate();
                    this.g = true;
                    kl9.g().e(musicData.id, musicData.resource, new a(this, aVar, musicData));
                    return;
                }
                kl9.g().e(musicData.id, musicData.resource, new b(this, musicData));
                return;
            }
            p(f, musicData);
        }
    }
}
