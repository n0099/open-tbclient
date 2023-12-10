package com.baidu.tieba;

import android.media.MediaPlayer;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.data.TbMusicData;
import com.baidu.tieba.edb;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.external.music.model.SelectMusicModel;
import com.baidu.tieba.v07;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes8.dex */
public class u07 implements s07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SelectMusicModel a;
    public MediaPlayer b;
    public int c;
    public TbMusicData d;
    public String e;
    public boolean f;
    public TbPageContext g;
    public boolean h;
    public gp9 i;

    /* loaded from: classes8.dex */
    public class a implements v07.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ edb.a a;
        public final /* synthetic */ MusicData b;
        public final /* synthetic */ u07 c;

        public a(u07 u07Var, edb.a aVar, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u07Var, aVar, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u07Var;
            this.a = aVar;
            this.b = musicData;
        }

        @Override // com.baidu.tieba.v07.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || this.a.d != this.c.c) {
                return;
            }
            this.c.h = false;
            this.a.b.setVisibility(4);
            this.a.a.setDrawBorder(true);
            this.a.a.invalidate();
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            if (this.c.i != null) {
                this.c.i.b(3, str);
            }
        }

        @Override // com.baidu.tieba.v07.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.d == this.c.c) {
                this.c.h = false;
                this.a.a.setDrawBorder(true);
                this.a.a.invalidate();
                this.a.b.setVisibility(4);
            }
        }

        @Override // com.baidu.tieba.v07.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && this.a.d == this.c.c) {
                this.c.h = false;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.c.o(str, this.b);
                this.a.b.setVisibility(4);
                this.a.a.setDrawBorder(true);
                this.a.a.invalidate();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements v07.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MusicData a;
        public final /* synthetic */ u07 b;

        @Override // com.baidu.tieba.v07.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(u07 u07Var, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u07Var, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u07Var;
            this.a = musicData;
        }

        @Override // com.baidu.tieba.v07.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                if (this.b.i != null) {
                    this.b.i.b(3, str);
                }
            }
        }

        @Override // com.baidu.tieba.v07.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.b.o(str, this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u07 a;

        public c(u07 u07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u07Var;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.a.b.setLooping(true);
                this.a.b.start();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u07 a;

        public d(u07 u07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u07Var;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i, i2)) == null) {
                if (this.a.i != null) {
                    gp9 gp9Var = this.a.i;
                    gp9Var.b(4, "what-->" + i + "  extra-->" + i2);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    public u07(TbPageContext tbPageContext, t07 t07Var) {
        kp9 kp9Var;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, t07Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, kp9.class);
        if (runTask != null) {
            kp9Var = (kp9) runTask.getData();
        } else {
            kp9Var = null;
        }
        if (kp9Var != null) {
            this.i = kp9Var.get();
        }
        this.g = tbPageContext;
        this.a = new SelectMusicModel(tbPageContext, t07Var);
        n();
    }

    @Override // com.baidu.tieba.s07
    public void d(MusicData musicData, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, musicData, obj) != null) || musicData == null) {
            return;
        }
        int i = musicData.editMusicType;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    CloudMusicActivityConfig cloudMusicActivityConfig = new CloudMusicActivityConfig(this.g.getPageActivity(), 25032);
                    cloudMusicActivityConfig.setCurrentMusicData(this.d);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, cloudMusicActivityConfig));
                    return;
                }
                return;
            }
            b();
            return;
        }
        p(obj, musicData);
    }

    public final void o(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, str, musicData) != null) || this.f) {
            return;
        }
        if (this.b == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.b = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.e = str;
            this.b.reset();
            this.b.setDataSource(str);
            this.b.prepare();
            this.b.setOnPreparedListener(new c(this));
            this.b.setOnErrorListener(new d(this));
        } catch (Exception e) {
            e.printStackTrace();
            q(str, musicData);
        }
    }

    @Override // com.baidu.tieba.s07
    public void f(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbMusicData) == null) {
            this.d = tbMusicData;
        }
    }

    @Override // com.baidu.tieba.s07
    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            this.f = false;
            this.e = str;
            o(str, null);
        }
    }

    @Override // com.baidu.tieba.s07
    public void a(float f) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048576, this, f) == null) && (mediaPlayer = this.b) != null && mediaPlayer.getDuration() > 0) {
            if (f < 0.0f) {
                f = 0.0f;
            }
            if (f > this.b.getDuration()) {
                f %= this.b.getDuration();
            }
            this.b.seekTo((int) (f * 1000.0f));
            this.b.start();
        }
    }

    @Override // com.baidu.tieba.s07
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MediaPlayer mediaPlayer = this.b;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.b.stop();
                }
                this.b.release();
                this.b = null;
            }
            this.e = null;
        }
    }

    @Override // com.baidu.tieba.s07
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s07
    public void e() {
        SelectMusicModel selectMusicModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (selectMusicModel = this.a) != null) {
            selectMusicModel.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.s07
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            this.a.P();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.s07
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f = true;
            MediaPlayer mediaPlayer = this.b;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                this.b.pause();
            }
        }
    }

    @Override // com.baidu.tieba.s07
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f = false;
            MediaPlayer mediaPlayer = this.b;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.b.seekTo(0);
            }
        }
    }

    @Override // com.baidu.tieba.s07
    public void pause() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (mediaPlayer = this.b) != null && mediaPlayer.isPlaying()) {
            this.b.pause();
        }
    }

    @Override // com.baidu.tieba.s07
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            b();
        }
    }

    public final void p(Object obj, MusicData musicData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, obj, musicData) == null) && musicData != null && !TextUtils.isEmpty(musicData.resource)) {
            MediaPlayer mediaPlayer = this.b;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                this.b.stop();
            }
            this.h = false;
            String str = musicData.id;
            String g = v07.h().g(musicData.resource);
            if (obj != null && (obj instanceof edb.a)) {
                this.c = ((edb.a) obj).d;
            }
            if (TextUtils.isEmpty(g)) {
                if (obj instanceof edb.a) {
                    edb.a aVar = (edb.a) obj;
                    aVar.b.setVisibility(0);
                    aVar.a.setDrawBorder(false);
                    aVar.a.invalidate();
                    this.h = true;
                    v07.h().f(musicData.id, musicData.resource, new a(this, aVar, musicData));
                    return;
                }
                v07.h().f(musicData.id, musicData.resource, new b(this, musicData));
                return;
            }
            o(g, musicData);
        }
    }

    public final void q(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, musicData) == null) {
            this.e = null;
            b();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                v07.h().e();
            }
            p(null, musicData);
        }
    }
}
