package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.t.c.d;
import b.a.r0.r.e.g.b;
import b.a.r0.z2.f0.e;
import b.a.r0.z2.f0.k;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class ApkDownloadView extends FrameLayout implements b.a.r0.r.e.g.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.z2.o0.a f53721e;

    /* renamed from: f  reason: collision with root package name */
    public DownloadData f53722f;

    /* renamed from: g  reason: collision with root package name */
    public b.a f53723g;

    /* renamed from: h  reason: collision with root package name */
    public DownloadStatus f53724h;

    /* renamed from: i  reason: collision with root package name */
    public String f53725i;
    public CustomMessageListener j;
    public CustomMessageListener k;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ApkDownloadView f53726a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ApkDownloadView apkDownloadView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {apkDownloadView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53726a = apkDownloadView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof DownloadMessage) && this.f53726a.f53722f != null) {
                DownloadData downloadData = null;
                List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                int i2 = 0;
                while (true) {
                    if (i2 >= data.size()) {
                        break;
                    }
                    DownloadData downloadData2 = data.get(i2);
                    if (TextUtils.isEmpty(this.f53726a.f53722f.getId())) {
                        i2++;
                    } else if (this.f53726a.f53722f.getId().equals(downloadData2.getId())) {
                        downloadData = downloadData2;
                    }
                }
                if (downloadData != null) {
                    int e2 = this.f53726a.e(downloadData);
                    if (k.n(downloadData) == 1) {
                        this.f53726a.j(e2);
                    } else if (k.n(downloadData) == 3) {
                        this.f53726a.f53721e.setButtonText(this.f53726a.getResources().getString(R.string.immediately_install));
                    } else {
                        this.f53726a.pause(downloadData);
                    }
                    this.f53726a.postInvalidate();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ApkDownloadView f53727a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ApkDownloadView apkDownloadView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {apkDownloadView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53727a = apkDownloadView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f53727a.f53722f == null) {
                return;
            }
            DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
            if (this.f53727a.f53722f.getId() == null || downloadData == null || !this.f53727a.f53722f.getId().equals(downloadData.getId())) {
                return;
            }
            this.f53727a.updata(downloadData);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApkDownloadView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f53725i = getResources().getString(R.string.install_app);
        this.j = null;
        this.k = null;
        f(context);
    }

    public static int getRealProgress(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, downloadData)) == null) {
            if (downloadData == null) {
                return 0;
            }
            int process = downloadData.getProcess();
            if (process <= 0) {
                process = k.l().j(downloadData.getId(), downloadData.getName());
            }
            return Math.max(process, 0);
        }
        return invokeL.intValue;
    }

    public static int getStatus(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, downloadData)) == null) {
            d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null && !adAdSense.f()) {
                return e.p(downloadData);
            }
            return k.n(downloadData);
        }
        return invokeL.intValue;
    }

    public void changeSkin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f53721e.changeSkin();
        }
    }

    public final int e(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData)) == null) {
            if (downloadData == null) {
                return 0;
            }
            return (int) ((downloadData.getLength() * 100) / downloadData.getSize());
        }
        return invokeL.intValue;
    }

    public void enableDownloadListener(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            if (this.j == null) {
                a aVar = new a(this, 2001118);
                this.j = aVar;
                aVar.setTag(bdUniqueId);
            }
            if (this.k == null) {
                b bVar = new b(this, 2016484);
                this.k = bVar;
                bVar.setTag(bdUniqueId);
            }
        }
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.f53721e = (b.a.r0.z2.o0.a) LayoutInflater.from(context).inflate(R.layout.apk_download_view_layout, (ViewGroup) this, true).findViewById(R.id.feed_ad_operate_progress_button);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.j != null) {
                MessageManager.getInstance().registerListener(this.j);
            }
            if (this.k != null) {
                MessageManager.getInstance().registerListener(this.k);
            }
        }
    }

    @Override // b.a.r0.r.e.g.b
    public View getActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (View) invokeV.objValue;
    }

    public int getDownloadStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            DownloadStatus downloadStatus = this.f53724h;
            if (downloadStatus == null || downloadStatus == DownloadStatus.STATUS_NONE) {
                return 6;
            }
            if (downloadStatus == DownloadStatus.STATUS_DOWNLOADING) {
                return 1;
            }
            if (downloadStatus == DownloadStatus.STATUS_PAUSED) {
                return 7;
            }
            if (downloadStatus == DownloadStatus.STATUS_SUCCESS) {
                return 3;
            }
            return downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS ? 8 : 6;
        }
        return invokeV.intValue;
    }

    @Override // b.a.r0.r.e.g.b
    @NonNull
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : (View) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setOnClickInterceptListener(null);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.j != null) {
                MessageManager.getInstance().unRegisterListener(this.j);
            }
            if (this.k != null) {
                MessageManager.getInstance().unRegisterListener(this.k);
            }
        }
    }

    public final void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f53721e.setProgress(Math.max(0, i2));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onAttachedToWindow();
            g();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f53721e.onChangeSkinType();
        }
    }

    @Override // b.a.r0.r.e.g.b
    public boolean onClickIntercept(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, view)) == null) {
            b.a aVar = this.f53723g;
            if (aVar != null) {
                return aVar.onClickIntercept(view);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDetachedFromWindow();
            i();
            h();
        }
    }

    @Override // b.a.r0.r.e.g.b
    public void onProgressChanged(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i2) == null) && this.f53724h == DownloadStatus.STATUS_DOWNLOADING) {
            j(i2);
        }
    }

    @Override // b.a.r0.r.e.g.b
    public void onStateAndProgressChanged(DownloadStatus downloadStatus, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, downloadStatus, i2) == null) {
            onStatusChanged(downloadStatus);
            onProgressChanged(i2);
        }
    }

    @Override // b.a.r0.r.e.g.b
    public void onStatusChanged(@NonNull DownloadStatus downloadStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, downloadStatus) == null) {
            this.f53724h = downloadStatus;
            DownloadData downloadData = this.f53722f;
            if (downloadData != null) {
                downloadData.setStatus(getDownloadStatus());
                updata(this.f53722f);
            }
        }
    }

    public void pause(DownloadData downloadData) {
        AdDownloadData a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, downloadData) == null) {
            DownloadCacheKey g2 = b.a.r0.r.e.e.c().g(downloadData.getId());
            this.f53721e.setButtonText(getResources().getString(R.string.go_on_download), (g2 == null || (a2 = b.a.r0.r.e.b.c().a(g2)) == null) ? 0 : a2.getPercent());
        }
    }

    public void reset(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, downloadData) == null) {
            this.f53721e.setButtonText(this.f53725i);
        }
    }

    public void setBackgroundSkin(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            b.a.r0.z2.o0.a aVar = this.f53721e;
            if (aVar instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) aVar).setBackgroundSkin(i2);
            }
        }
    }

    public void setData(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, downloadData) == null) || downloadData == null) {
            return;
        }
        DownloadData downloadData2 = (DownloadData) downloadData.clone();
        this.f53722f = downloadData2;
        if (downloadData2 == null) {
            return;
        }
        setTag(downloadData2);
        updata(downloadData);
    }

    public void setForegroundSkin(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            b.a.r0.z2.o0.a aVar = this.f53721e;
            if (aVar instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) aVar).setForeground(i2);
            }
        }
    }

    public void setInitText(String str) {
        b.a.r0.z2.o0.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.f53725i = str;
            if (TextUtils.isEmpty(str) || (aVar = this.f53721e) == null) {
                return;
            }
            aVar.setInitText(str);
        }
    }

    public void setOnClickInterceptListener(b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, aVar) == null) {
            this.f53723g = aVar;
        }
    }

    public void setRatio(int i2) {
        b.a.r0.z2.o0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i2) == null) || (aVar = this.f53721e) == null) {
            return;
        }
        aVar.setRatio(i2);
    }

    public void setStrokeWidth(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            b.a.r0.z2.o0.a aVar = this.f53721e;
            if (aVar instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) aVar).setStrokeWidth(i2);
            }
        }
    }

    public void setTextColor(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.f53721e.setButtonTextColor(i2);
        }
    }

    public void setTextColorInitSkin(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            b.a.r0.z2.o0.a aVar = this.f53721e;
            if (aVar instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) aVar).setTextColorInitSkin(i2);
            }
        }
    }

    public void setTextColorSkin(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            b.a.r0.z2.o0.a aVar = this.f53721e;
            if (aVar instanceof FeedAdProgressButton) {
                ((FeedAdProgressButton) aVar).setTextColorSkin(i2);
            }
        }
    }

    public void setTextNightColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.f53721e.setButtonTextNightColor(i2);
        }
    }

    public void setTextSize(@DimenRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.f53721e.setButtonTextSize(i2);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            super.setVisibility(i2);
            if (i2 == 0) {
                g();
            } else {
                i();
            }
        }
    }

    public void startDownload(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, downloadData) == null) {
            j(getRealProgress(downloadData));
        }
    }

    public void updata(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, downloadData) == null) || downloadData == null) {
            return;
        }
        DownloadCacheKey g2 = b.a.r0.r.e.e.c().g(downloadData.getId());
        AdDownloadData adDownloadData = null;
        int percent = (g2 == null || (adDownloadData = b.a.r0.r.e.b.c().a(g2)) == null) ? 0 : adDownloadData.getPercent();
        switch (downloadData.getStatus()) {
            case 1:
            case 5:
                j(percent);
                return;
            case 2:
            case 7:
                this.f53721e.setButtonText(getResources().getString(R.string.go_on_download), percent);
                return;
            case 3:
                this.f53721e.setButtonText(getResources().getString(R.string.immediately_install), percent);
                if (adDownloadData != null) {
                    adDownloadData.setFakePercent(0);
                    adDownloadData.setPercent(0);
                    return;
                }
                return;
            case 4:
            default:
                return;
            case 6:
                this.f53721e.setButtonText(this.f53725i, 0);
                return;
            case 8:
                this.f53721e.setButtonText(getResources().getString(R.string.immediately_open), 0);
                if (adDownloadData != null) {
                    adDownloadData.setFakePercent(0);
                    adDownloadData.setPercent(0);
                    return;
                }
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApkDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f53725i = getResources().getString(R.string.install_app);
        this.j = null;
        this.k = null;
        f(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApkDownloadView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53725i = getResources().getString(R.string.install_app);
        this.j = null;
        this.k = null;
        f(context);
    }
}
