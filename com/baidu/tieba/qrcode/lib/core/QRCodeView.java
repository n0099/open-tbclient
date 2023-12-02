package com.baidu.tieba.qrcode.lib.core;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.nga;
import com.baidu.tieba.pga;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class QRCodeView extends RelativeLayout implements Camera.PreviewCallback, pga.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Camera a;
    public CameraPreview b;
    public ScanBoxView c;
    public c d;
    public Handler e;
    public boolean f;
    public pga g;
    public int h;
    public Runnable i;

    /* loaded from: classes7.dex */
    public interface c {
        void a();

        void b(String str);
    }

    /* loaded from: classes7.dex */
    public class a extends pga {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Camera e;
        public final /* synthetic */ QRCodeView f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(QRCodeView qRCodeView, Camera camera, byte[] bArr, pga.a aVar, int i, Camera camera2) {
            super(camera, bArr, aVar, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRCodeView, camera, bArr, aVar, Integer.valueOf(i), camera2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Camera) objArr2[0], (byte[]) objArr2[1], (pga.a) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = qRCodeView;
            this.e = camera2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: d */
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                QRCodeView qRCodeView = this.f;
                if (qRCodeView.f) {
                    try {
                        if (qRCodeView.d != null && !TextUtils.isEmpty(str)) {
                            StatisticItem statisticItem = new StatisticItem("qrcoderesult");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem.param("obj_type", 1);
                            TiebaStatic.log(statisticItem);
                            this.f.d.b(str);
                        } else {
                            this.e.setOneShotPreviewCallback(this.f);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ QRCodeView a;

        public b(QRCodeView qRCodeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qRCodeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qRCodeView;
        }

        @Override // java.lang.Runnable
        public void run() {
            QRCodeView qRCodeView;
            Camera camera;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (camera = (qRCodeView = this.a).a) != null && qRCodeView.f) {
                try {
                    camera.setOneShotPreviewCallback(qRCodeView);
                } catch (Exception e) {
                    StatisticItem statisticItem = new StatisticItem("qrcoderesult");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_type", 0);
                    TiebaStatic.log(statisticItem);
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QRCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void d(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, attributeSet) == null) {
            this.b = new CameraPreview(getContext());
            ScanBoxView scanBoxView = new ScanBoxView(getContext());
            this.c = scanBoxView;
            scanBoxView.k(context, attributeSet);
            this.b.setId(R.id.obfuscated_res_0x7f090413);
            addView(this.b);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context, attributeSet);
            layoutParams.addRule(6, this.b.getId());
            layoutParams.addRule(8, this.b.getId());
            addView(this.c, layoutParams);
            this.h = nga.c(context);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QRCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = false;
        this.i = new b(this);
        this.e = new Handler();
        d(context, attributeSet);
    }

    public void b() {
        pga pgaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (pgaVar = this.g) != null) {
            pgaVar.a();
            this.g = null;
        }
    }

    public void c() {
        ScanBoxView scanBoxView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (scanBoxView = this.c) != null) {
            scanBoxView.setVisibility(8);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            m();
            this.e = null;
            this.d = null;
            this.i = null;
        }
    }

    public void f() {
        CameraPreview cameraPreview;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (cameraPreview = this.b) != null) {
            cameraPreview.f();
        }
    }

    public void g() {
        ScanBoxView scanBoxView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (scanBoxView = this.c) != null) {
            scanBoxView.setVisibility(0);
        }
    }

    public boolean getIsScanBarcodeStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c.getIsBarcode();
        }
        return invokeV.booleanValue;
    }

    public ScanBoxView getScanBoxView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (ScanBoxView) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            i(0);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            StatisticItem statisticItem = new StatisticItem("qrcodeuse");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            l(1000);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            try {
                o();
                if (this.a != null) {
                    this.b.h();
                    this.b.setCamera(null);
                    this.a.release();
                    this.a = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b();
            this.f = false;
            Camera camera = this.a;
            if (camera != null) {
                try {
                    camera.setOneShotPreviewCallback(null);
                } catch (Exception unused) {
                }
            }
            Handler handler = this.e;
            if (handler != null) {
                handler.removeCallbacks(this.i);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            n();
            c();
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048585, this, i) != null) || this.a != null) {
            return;
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == i) {
                j(i2);
                return;
            }
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f = true;
            Handler handler = this.e;
            if (handler != null) {
                handler.removeCallbacks(this.i);
                this.e.postDelayed(this.i, i);
            }
        }
    }

    public void setDelegate(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, cVar) == null) {
            this.d = cVar;
        }
    }

    public final void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            try {
                Camera open = Camera.open(i);
                this.a = open;
                this.b.setCamera(open);
            } catch (Exception unused) {
                if (this.d != null) {
                    StatisticItem statisticItem = new StatisticItem("qrcoderesult");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("obj_type", 2);
                    TiebaStatic.log(statisticItem);
                    this.d.a();
                }
            }
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, bArr, camera) == null) && this.f) {
            b();
            a aVar = new a(this, camera, bArr, this, this.h, camera);
            aVar.c();
            this.g = aVar;
        }
    }
}
