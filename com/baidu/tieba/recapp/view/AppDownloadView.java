package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.l3.g0.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class AppDownloadView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f35781b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f35782c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35783d;

    /* renamed from: e  reason: collision with root package name */
    public DownloadData f35784e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f35785f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f35786g;

    /* loaded from: classes5.dex */
    public static abstract class AppDownloadListener implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AppDownloadView a;

        public AppDownloadListener() {
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

        public void setAppDownloadView(AppDownloadView appDownloadView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, appDownloadView) == null) {
                this.a = appDownloadView;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f35785f = null;
        this.f35786g = null;
        d(context);
    }

    public static int getStatus(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, downloadData)) == null) ? e.p(downloadData) : invokeL.intValue;
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(0);
            setGravity(16);
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0122, (ViewGroup) this, true);
            this.a = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090291);
            this.f35781b = (ProgressBar) inflate.findViewById(R.id.obfuscated_res_0x7f090ac7);
            this.f35782c = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090ac5);
            this.f35783d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090ac6);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void e(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) || downloadData == null) {
            return;
        }
        int status = downloadData.getStatus();
        if (status == 1) {
            setVisibility(0);
            SkinManager.setImageResource(this.f35782c, R.drawable.icon_download_pause);
        } else if (status == 3) {
            setVisibility(8);
        } else if (status == 5) {
            setVisibility(0);
        } else if (status == 6) {
            setVisibility(8);
        } else if (status == 7) {
            setVisibility(0);
            SkinManager.setImageResource(this.f35782c, R.drawable.icon_download_play);
        }
        int j = e.n().j(downloadData.getId(), downloadData.getName());
        if (j >= 0) {
            h(j);
        } else {
            h(0);
        }
    }

    public void enableDownloadListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f35785f == null) {
                this.f35785f = new CustomMessageListener(this, 2001118) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AppDownloadView a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(r8)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof DownloadMessage) && this.a.f35784e != null) {
                            DownloadData downloadData = null;
                            List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                            int i = 0;
                            while (true) {
                                if (i >= data.size()) {
                                    break;
                                }
                                DownloadData downloadData2 = data.get(i);
                                if (TextUtils.isEmpty(this.a.f35784e.getId())) {
                                    i++;
                                } else if (this.a.f35784e.getId().equals(downloadData2.getId())) {
                                    downloadData = downloadData2;
                                }
                            }
                            if (downloadData != null) {
                                this.a.h(e.n().j(downloadData.getId(), downloadData.getName()));
                                this.a.postInvalidate();
                            }
                        }
                    }
                };
            }
            if (this.f35786g == null) {
                this.f35786g = new CustomMessageListener(this, 2016484) { // from class: com.baidu.tieba.recapp.view.AppDownloadView.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AppDownloadView a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(r8)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.adp.framework.listener.MessageListener
                    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.f35784e == null) {
                            return;
                        }
                        DownloadData downloadData = (DownloadData) customResponsedMessage.getData();
                        if (this.a.f35784e.getId() == null || downloadData == null || !this.a.f35784e.getId().equals(downloadData.getId())) {
                            return;
                        }
                        int p = e.p(downloadData);
                        if (p == 7) {
                            SkinManager.setImageResource(this.a.f35782c, R.drawable.icon_download_pause);
                        } else if (p == 1) {
                            SkinManager.setImageResource(this.a.f35782c, R.drawable.icon_download_play);
                        }
                    }
                };
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f35785f != null) {
                MessageManager.getInstance().registerListener(this.f35785f);
            }
            if (this.f35786g != null) {
                MessageManager.getInstance().registerListener(this.f35786g);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f35785f != null) {
                MessageManager.getInstance().unRegisterListener(this.f35785f);
            }
            if (this.f35786g != null) {
                MessageManager.getInstance().unRegisterListener(this.f35786g);
            }
        }
    }

    public final void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            int max = Math.max(0, i);
            this.f35781b.setProgress(max);
            TextView textView = this.f35783d;
            textView.setText(max + "%");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onAttachedToWindow();
            f();
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            SkinManager.setViewTextColor(this.a, R.color.CAM_X0108, 1, i);
            this.f35781b.setProgressDrawable(SkinManager.getDrawable(i, (int) R.drawable.progress_download_app_layerlist));
            SkinManager.setImageResource(this.f35782c, R.drawable.icon_download_play, i);
            SkinManager.setViewTextColor(this.f35783d, R.color.CAM_X0109, 1, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDetachedFromWindow();
            g();
        }
    }

    public void refreshControlIcon(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            if (i == 1) {
                SkinManager.setImageResource(this.f35782c, R.drawable.icon_download_pause);
            } else {
                SkinManager.setImageResource(this.f35782c, R.drawable.icon_download_play);
            }
        }
    }

    public void setData(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, downloadData) == null) || downloadData == null) {
            return;
        }
        DownloadData downloadData2 = (DownloadData) downloadData.clone();
        this.f35784e = downloadData2;
        if (downloadData2 == null) {
            return;
        }
        setTag(downloadData2);
        e(downloadData);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            super.setVisibility(i);
            if (i == 0) {
                f();
            } else {
                g();
            }
        }
    }

    public void showTitleView(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.a.setVisibility(i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35785f = null;
        this.f35786g = null;
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppDownloadView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35785f = null;
        this.f35786g = null;
        d(context);
    }
}
