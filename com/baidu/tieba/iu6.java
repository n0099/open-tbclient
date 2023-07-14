package com.baidu.tieba;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tieba.core.edit.TbMediaTrackConfig;
import com.baidu.tieba.hu6;
import com.baidu.tieba.view.widget.TbGLMediaPreviewView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter;
import com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaPreparedListener;
import com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol;
import com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager;
import com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener;
import com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import com.google.gson.Gson;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class iu6 implements hu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public VlogEditManager b;
    public MultiMediaDataSourceViewAdapter c;
    public TbGLMediaPreviewView d;
    public i37 e;
    public boolean f;
    public List<MultiMediaData> g;
    public float h;
    public int i;
    public int j;

    @Override // com.baidu.tieba.hu6
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.hu6
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.tieba.hu6
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hu6
    public long getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.hu6
    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements IMultiMediaPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iu6 a;

        public a(iu6 iu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iu6Var;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                this.a.b.start();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements FilenameFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(iu6 iu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iu6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) {
                return str.endsWith(".png");
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c extends IVLogPlayControlProtocol.OnPlayStateListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hu6.a a;

        public c(iu6 iu6Var, hu6.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iu6Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListenerAdapter, com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onPause();
                hu6.a aVar = this.a;
                if (aVar != null) {
                    aVar.a();
                }
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListenerAdapter, com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onStart();
                hu6.a aVar = this.a;
                if (aVar != null) {
                    aVar.c();
                }
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListenerAdapter, com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onSeek(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                super.onSeek(j);
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListenerAdapter, com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onSetIsLoop(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                super.onSetIsLoop(z);
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListenerAdapter, com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onSpeedChanged(float f, MultiMediaData multiMediaData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f), multiMediaData}) == null) {
                super.onSpeedChanged(f, multiMediaData);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements MultiMediaStateEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hu6.a a;

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onIndexChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onPlayEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onRepeatIndexEnd(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onRepeatIndexLoop(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            }
        }

        public d(iu6 iu6Var, hu6.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iu6Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onLoop() {
            hu6.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (aVar = this.a) != null) {
                aVar.b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements j6b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        @Override // com.baidu.tieba.j6b
        public q7b c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (q7b) invokeV.objValue;
        }

        @Override // com.baidu.tieba.j6b
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "tieba_unknown" : (String) invokeV.objValue;
        }

        public e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
        }

        @Override // com.baidu.tieba.j6b
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new csa(TbadkApplication.getInst().getContext());
            }
            return (IMediaPlayer) invokeV.objValue;
        }

        @Override // com.baidu.tieba.j6b
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a) {
                    return yla.c;
                }
                return yla.d;
            }
            return (String) invokeV.objValue;
        }
    }

    public iu6(TbPageContext tbPageContext, TbGLMediaPreviewView tbGLMediaPreviewView, TbMultiMediaData tbMultiMediaData, i37 i37Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, tbGLMediaPreviewView, tbMultiMediaData, i37Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = false;
        this.a = tbPageContext;
        this.d = tbGLMediaPreviewView;
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        arrayList.add(tbMultiMediaData);
        this.e = i37Var;
        this.f = z;
        k();
    }

    @Override // com.baidu.tieba.hu6
    public void b(hu6.a aVar) {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && (vlogEditManager = this.b) != null) {
            vlogEditManager.setOnPlayStateListener(null);
            this.b.setOnPlayStateListener(new c(this, aVar));
            this.b.setMultiMediaStateEventListener(null);
            this.b.setMultiMediaStateEventListener(new d(this, aVar));
        }
    }

    @Override // com.baidu.tieba.hu6
    public void c(TbMultiMediaData tbMultiMediaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbMultiMediaData) != null) || tbMultiMediaData == null) {
            return;
        }
        this.g.clear();
        this.g.add(tbMultiMediaData);
        o();
    }

    @Override // com.baidu.tieba.hu6
    public void f(float f) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeF(1048581, this, f) != null) || this.h == f) {
            return;
        }
        this.h = f;
        j();
        VlogEditManager vlogEditManager = this.b;
        if (vlogEditManager != null && !vlogEditManager.isPlaying()) {
            VlogEditManager vlogEditManager2 = this.b;
            vlogEditManager2.seek(vlogEditManager2.getCurrentPlayTime());
        }
    }

    @Override // com.baidu.tieba.hu6
    public boolean a(QmFilterItem qmFilterItem) {
        InterceptResult invokeL;
        float f;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qmFilterItem)) == null) {
            String str = IVlogEditManager.FILTER_ORIGINAL;
            if (qmFilterItem != null && !StringUtils.isNull(qmFilterItem.localPath) && !"origin".equals(qmFilterItem.localPath)) {
                f = wg.d(qmFilterItem.effect, 100.0f) / 100.0f;
                File file = new File(qmFilterItem.localPath);
                if (file.isDirectory() && (listFiles = file.listFiles(new b(this))) != null && listFiles.length > 0) {
                    str = listFiles[0].getAbsolutePath();
                }
            } else {
                f = 0.0f;
            }
            VlogEditManager vlogEditManager = this.b;
            if (vlogEditManager != null) {
                try {
                    vlogEditManager.setFilter(f, str);
                    return true;
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.hu6
    public long getCurrentPlayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            VlogEditManager vlogEditManager = this.b;
            if (vlogEditManager != null) {
                return vlogEditManager.getCurrentPlayTime();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.hu6
    public TbMediaTrackConfig getMediaTrackConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.b != null) {
                return (TbMediaTrackConfig) new Gson().fromJson(this.b.exportConfigJson(MediaTrackConfig.AE_IMPORT_DRAFT), (Class<Object>) TbMediaTrackConfig.class);
            }
            return null;
        }
        return (TbMediaTrackConfig) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hu6
    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.h;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.hu6
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            VlogEditManager vlogEditManager = this.b;
            if (vlogEditManager != null) {
                return vlogEditManager.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!gla.a()) {
                this.a.getPageActivity().finish();
                return false;
            }
            m();
            n();
            l();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void o() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (vlogEditManager = this.b) != null) {
            boolean isPlaying = vlogEditManager.isPlaying();
            this.b.reset();
            this.b.setMultiMediaData(this.g);
            if (isPlaying) {
                this.b.start();
            } else {
                this.b.pause();
            }
        }
    }

    @Override // com.baidu.tieba.hu6
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            VlogEditManager vlogEditManager = this.b;
            if (vlogEditManager != null) {
                vlogEditManager.onDestroy();
            }
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = this.c;
            if (multiMediaDataSourceViewAdapter != null) {
                multiMediaDataSourceViewAdapter.onDestroy();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onDestroy();
            }
            i37 i37Var = this.e;
            if (i37Var != null) {
                i37Var.onDestroy();
            }
        }
    }

    @Override // com.baidu.tieba.hu6
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            VlogEditManager vlogEditManager = this.b;
            if (vlogEditManager != null) {
                vlogEditManager.onPause();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onPause();
            }
        }
    }

    @Override // com.baidu.tieba.hu6
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            TbGLMediaPreviewView tbGLMediaPreviewView = this.d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onResume();
            }
            VlogEditManager vlogEditManager = this.b;
            if (vlogEditManager != null) {
                vlogEditManager.onResume();
            }
        }
    }

    @Override // com.baidu.tieba.hu6
    public void pause() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (vlogEditManager = this.b) != null) {
            vlogEditManager.pause();
        }
    }

    @Override // com.baidu.tieba.hu6
    public void start() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (vlogEditManager = this.b) != null) {
            vlogEditManager.start();
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (this.d.getLayoutParams() instanceof FrameLayout.LayoutParams) && !ListUtils.isEmpty(this.g) && this.g.get(0) != null && this.g.get(0).height > 0 && this.g.get(0).width > 0) {
            TbGLMediaPreviewView tbGLMediaPreviewView = this.d;
            if (tbGLMediaPreviewView != null) {
                ViewGroup.LayoutParams layoutParams = tbGLMediaPreviewView.getLayoutParams();
                float f = this.h;
                if (f > 1.0f) {
                    layoutParams.width = Math.min((int) (this.i / f), this.j);
                } else if (f > 0.0f) {
                    layoutParams.width = this.j;
                }
                layoutParams.height = (int) (layoutParams.width * this.h);
                int statusBarHeight = UtilHelper.getStatusBarHeight();
                this.d.setTranslationY(((this.i + statusBarHeight) - layoutParams.height) * 0.5f);
                this.d.setTranslationX((this.j - layoutParams.width) * 0.5f);
                this.d.requestLayout();
            }
            this.b.setVideoRatio(this.h);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.d.setZOrderMediaOverlay(true);
            this.d.setMultiMediaDataSourceViewAdapter(this.c, false);
            this.d.setCanMeasure(false);
            this.i = yi.j(this.a.getPageActivity());
            this.j = yi.l(this.a.getPageActivity());
            j();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            i6b.c().h(TbadkCoreApplication.getInst());
            i6b.c().j(FileHelper.getCacheDir());
            i6b.c().k(new e(this.f));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = new MultiMediaDataSourceViewAdapter();
            this.c = multiMediaDataSourceViewAdapter;
            VlogEditManager vlogEditManager = new VlogEditManager(multiMediaDataSourceViewAdapter);
            this.b = vlogEditManager;
            vlogEditManager.setMultiMediaData(this.g);
            this.b.setLooping(true);
            this.b.setPreparedListener(new a(this));
            i37 i37Var = this.e;
            if (i37Var != null) {
                i37Var.e(this.b, this.c);
            }
        }
    }
}
